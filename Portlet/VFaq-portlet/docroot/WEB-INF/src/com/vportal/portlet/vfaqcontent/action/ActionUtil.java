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

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portal.service.AttachmentServiceUtil;
import com.vportal.portal.util.PortalUtilExt;
import com.vportal.portlet.vfaq.model.FAQQuestion;
import com.vportal.portlet.vfaq.service.FAQCategoryLocalServiceUtil;
import com.vportal.portlet.vfaq.util.FAQUtil;
import com.vportal.portlet.vfaq.util.WebKeysExt;
public class ActionUtil {

	public static void getCategoryList(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getCategoryList(httpReq);
	}

	public static void getCategoryList(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getCategoryList(httpReq);
	}

	public static void getCategoryList(HttpServletRequest req) throws Exception {
		// get list of category
		long groupId = PortalUtilExt.getPortletGroupId(req);
		List listCategory = FAQCategoryLocalServiceUtil.getAll(groupId);
		listCategory = FAQUtil.sort(listCategory);
		listCategory = FAQUtil.formatByLevel(listCategory);
		req.setAttribute(WebKeysExt.VFAQ_LIST_CATEGORY, listCategory);
	}
	
	public static void getAttachmentList(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAttachmentList(httpReq);
	}

	public static void getAttachmentList(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAttachmentList(httpReq);
	}

	public static void getAttachmentList(HttpServletRequest req)
			throws Exception {
		long questionId = ParamUtil.getLong(req, "questionId");
		// get attachment
		List listAttachment = AttachmentServiceUtil.getAttachments(questionId,
				FAQQuestion.class);
		if (listAttachment == null) {
			listAttachment = new ArrayList();
		}
		req.setAttribute(WebKeysExt.VFAQCONTENT_LIST_ATTACHMENT, listAttachment);
	}
}
