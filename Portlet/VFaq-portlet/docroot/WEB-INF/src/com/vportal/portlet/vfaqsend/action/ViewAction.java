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

package com.vportal.portlet.vfaqsend.action;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portal.attachment.AttachmentManager;
import com.vportal.portal.taglib.FileUploadUtil;
import com.vportal.portal.util.PortalUtilExt;
import com.vportal.portlet.vfaq.model.FAQQuestion;
import com.vportal.portlet.vfaq.service.FAQCategoryQuestionLocalServiceUtil;
import com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil;
import com.vportal.portlet.vfaq.util.WebKeysExt;

/**
 * Portlet implementation class ViewAction
 */
public class ViewAction extends MVCPortlet {

	// public void updateQuestion(ActionRequest req,ActionResponse res) throws
	// Exception {
	// FAQQuestion question = null;
	// long questionId = ParamUtil.getLong(req, "questionId");
	// String title = ParamUtil.getString(req, "title");
	// String content = ParamUtil.getString(req, "content");
	// String language = ParamUtil.getString(req, "language");
	// int questionOrder = ParamUtil.getInteger(req, "questionOrder");
	// String questionType = ParamUtil.getString(req, "type");
	// String sentByUser = ParamUtil.getString(req, "username");
	// String senderEmail = ParamUtil.getString(req, "email");
	// String[] categoryId = req.getParameterValues("category");
	// boolean isApproved = ParamUtil.getBoolean(req, "approved");
	//
	// Date now = new Date();
	// long userId = PortalUtilExt.getUserId(req);
	// long groupId = PortalUtilExt.getPortletGroupId(req);
	//
	// User user = PortalUtilExt.getUser(req);
	//
	// String currentUser = user.getFullName();
	//
	// if (Validator.isNull(sentByUser)) {
	// sentByUser = currentUser;
	//
	// }
	//
	// //check captcha
	// CaptchaUtil.check(req);
	//
	// // this is insert
	// if (questionId <= 0) {
	// question = FAQQuestionLocalServiceUtil.addQuestion(title, content,
	// language, questionOrder, now, sentByUser, senderEmail,
	// questionType, 0, isApproved, groupId, userId);
	//
	// // add relationship between question and categories
	// if (Validator.isNotNull(categoryId)) {
	// for (int i = 0; i < categoryId.length; i++) {
	// // add relation
	// FAQCategoryQuestionLocalServiceUtil.addCategoryQuestion(
	// Long.parseLong(categoryId[i]), question.getId());
	// }
	// }
	// }
	// // attach file
	// String portletId = WebKeysExt.VFAQ;
	//
	// AttachmentManager am = new AttachmentManager(portletId,
	// FAQQuestion.class, question.getId());
	// am.addFile(req,null);
	//
	// // AttachmentUtil attachment = new AttachmentUtil();
	// // attachment.addFile(req, portletId, FAQQuestion.class,
	// // question.getId());
	// }

	public void updateQuestion(ActionRequest req, ActionResponse res)
			throws Exception {
		FAQQuestion question = null;

		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(req);
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long questionId = ParamUtil.getLong(uploadRequest, "questionId");
		String title = ParamUtil.getString(uploadRequest, "title");
		String content = ParamUtil.getString(uploadRequest, "content");
		String language = ParamUtil.getString(uploadRequest, "language");
		long questionOrder = ParamUtil
				.getInteger(uploadRequest, "questionOrder");
		String questionType = ParamUtil.getString(uploadRequest, "type");
		String sentByUser = ParamUtil.getString(uploadRequest, "username");
		String senderEmail = ParamUtil.getString(uploadRequest, "email");
		String[] categoryId = uploadRequest.getParameterValues("category");
		boolean isApproved = ParamUtil.getBoolean(uploadRequest, "approved");
		
		String[] communityPermissions = req
				.getParameterValues("communityPermissions");
		String[] guestPermissions = req.getParameterValues("guestPermissions");


		Date now = new Date();
		long userId = PortalUtilExt.getUserId(uploadRequest);
		long groupId = PortalUtilExt.getPortletGroupId(uploadRequest);

		User user = PortalUtilExt.getUser(uploadRequest);

		String currentUser = user.getFullName();

		if (Validator.isNull(sentByUser)) {
			sentByUser = currentUser;

		}

		// check captcha
		// CaptchaUtil.check(uploadRequest);
		boolean bChechCaptcha = checkCaptcha(req, uploadRequest);
		if (bChechCaptcha) {
			// this is insert
			if (questionId <= 0) {
				question = FAQQuestionLocalServiceUtil.addQuestion(title,
						content, language, questionOrder, now, sentByUser,
						senderEmail, questionType, 0, isApproved, groupId,
						userId,layout.getPlid(),communityPermissions,guestPermissions);
				String portletId = WebKeysExt.VFAQ;
				
				// add relationship between question and categories
				if (Validator.isNotNull(categoryId)) {
					for (int i = 0; i < categoryId.length; i++) {
						// add relation
						FAQCategoryQuestionLocalServiceUtil
								.addCategoryQuestion(
										Long.parseLong(categoryId[i]),
										question.getId());
					}
				}
				FileUploadUtil.uploadFile(req, uploadRequest, portletId, FAQQuestion.class, question.getId(),GetterUtil.getLong(0),StringPool.BLANK);				
			}
			// attach file
			
//			AttachmentManager am = new AttachmentManager(portletId,
//					FAQQuestion.class, question.getId());
//			am.addFile(req, uploadRequest);

			// AttachmentUtil attachment = new AttachmentUtil();
			// attachment.addFile(req, portletId, FAQQuestion.class,
			// question.getId());
		}
		res.sendRedirect(layout.getRegularURL(uploadRequest));
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		try {
			com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(
					resourceRequest, resourceResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean checkCaptcha(PortletRequest request,
			UploadPortletRequest uploadReq) throws Exception {
		String enteredCaptchaText = ParamUtil.getString(uploadReq,
				"captchaText");
		PortletSession session = request.getPortletSession();
		String captchaText = getCaptchaValueFromSession(session);
		if (Validator.isNull(captchaText)) {
//			SessionMessages.add(request,
//					"error-captcha");
			SessionErrors.add(request, "error-captcha");
			return false;
		}
		if (!captchaText.equals(enteredCaptchaText)) {
//			SessionMessages.add(request,
//					"error-captcha");
			SessionErrors.add(request, "error-captcha");
			return false;
		}
		SessionMessages.add(request, "success-send");
		return true;
	}

	public String getCaptchaValueFromSession(PortletSession session) {
		Enumeration<String> atNames = session.getAttributeNames();
		while (atNames.hasMoreElements()) {
			String name = atNames.nextElement();
			if (name.contains("CAPTCHA_TEXT")) {
				return (String) session.getAttribute(name);
			}
		}
		return null;
	}

	public void processAction(ActionRequest req, ActionResponse res)
			throws IOException, PortletException {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		if (!cmd.equals(Constants.UPDATE)) {
			try {
				updateQuestion(req, res);
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}		
		

		String themeType = ParamUtil.getString(req, "themeType");
		String titlePortlet = ParamUtil.getString(req, "titlePortlet");

		PortletPreferences prefs = req.getPreferences();
		String titleQuestion = ParamUtil.getString(req, "titleQuestion");

		prefs.setValue("titleQuestion", titleQuestion);
		prefs.setValue("titlePortlet", titlePortlet);
		prefs.setValue("themeType", themeType);

		prefs.store();
		// SessionMessages.add(req, config.getPortletName() + ".doEdit");

	}

}
