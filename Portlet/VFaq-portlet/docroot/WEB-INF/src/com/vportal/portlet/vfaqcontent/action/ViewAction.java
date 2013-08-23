/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.vportal.portlet.vfaqcontent.action;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portal.attachment.AttachmentManager;
import com.vportal.portal.util.PortalUtilExt;
import com.vportal.portlet.vfaq.model.FAQQuestion;
import com.vportal.portlet.vfaq.service.FAQCategoryQuestionLocalServiceUtil;
import com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil;
import com.vportal.portlet.vfaq.util.WebKeysExt;

/**
 * Portlet implementation class ViewAction
 */
public class ViewAction extends MVCPortlet {
	public void updateQuestion(ActionRequest req,ActionResponse res) throws Exception {
		FAQQuestion question = null;
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(req);
		long questionId = ParamUtil.getLong(req, "questionId");
		String title = ParamUtil.getString(req, "title");
		String content = ParamUtil.getString(req, "content");
		String language = ParamUtil.getString(req, "language");
		long questionOrder = ParamUtil.getInteger(req, "questionOrder");
		String questionType = ParamUtil.getString(req, "type");
		String sentByUser = ParamUtil.getString(req, "username");
		String senderEmail = ParamUtil.getString(req, "email");
		String[] categoryId = req.getParameterValues("category");
		boolean isApproved = ParamUtil.getBoolean(req, "approved");
		String isRemoveAttach = ParamUtil.getString(req, "removeAttach");
		String[] communityPermissions = req
				.getParameterValues("communityPermissions");
		String[] guestPermissions = req.getParameterValues("guestPermissions");

		Date now = new Date();
		long userId = PortalUtilExt.getUserId(req);
		long groupId = PortalUtilExt.getPortletGroupId(req);
		long companyId = PortalUtilExt.getCompanyId(req);
		long plId = PortalUtilExt.getPlid(req);
		User user = PortalUtilExt.getUser(req);
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		String currentUser = user.getFullName();

		if (Validator.isNull(sentByUser)) {
			sentByUser = currentUser;

		}
		// this is insert
		if (questionId <= 0) {
			question = FAQQuestionLocalServiceUtil.addQuestion(title, content,
					language, questionOrder, now, sentByUser, senderEmail,
					questionType, 0, isApproved, groupId, userId,plId, communityPermissions,guestPermissions);

			// add relationship between question and categories
			if (Validator.isNotNull(categoryId)) {
				for (int i = 0; i < categoryId.length; i++) {
					// add relation
					FAQCategoryQuestionLocalServiceUtil.addCategoryQuestion(
							Long.parseLong(categoryId[i]), question.getId());
				}
			}
		}
		// attach file
		String portletId = WebKeysExt.VFAQ;

		AttachmentManager am = new AttachmentManager(portletId,
				FAQQuestion.class, question.getId());
		am.addFile(req,null);

		// AttachmentUtil attachment = new AttachmentUtil();
		// attachment.addFile(req, portletId, FAQQuestion.class,
		// question.getId());
	}
	
	public void processAction(ActionRequest req, ActionResponse res)
			throws IOException, PortletException {

		String cmd = ParamUtil.getString(req, Constants.CMD);
		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		PortletPreferences prefs = req.getPreferences();

		String themeType = ParamUtil.getString(req, "themeType");
		String titlePortlet = ParamUtil.getString(req, "titlePortlet");
		String url = ParamUtil.getString(req, "url");

		String defaultCategory = ParamUtil.getString(req, "defaultCategory");
		String questionNumber = ParamUtil.getString(req, "questionNumber");
		String otherQuestionNumber = ParamUtil.getString(req,
				"otherQuestionNumber");

		prefs.setValue("defaultCategory", defaultCategory);
		prefs.setValue("questionNumber", questionNumber);
		prefs.setValue("otherQuestionNumber", otherQuestionNumber);

		prefs.setValue("themeType", themeType);
		prefs.setValue("titlePortlet", titlePortlet);
		prefs.setValue("url", url);

		prefs.store();
		//SessionMessages.add(req, config.getPortletName() + ".doEdit");
	}	

}
