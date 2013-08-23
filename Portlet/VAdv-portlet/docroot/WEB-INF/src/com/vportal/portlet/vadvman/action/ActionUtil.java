
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

package com.vportal.portlet.vadvman.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portlet.vadvman.model.AdvItem;
import com.vportal.portlet.vadvman.model.AdvType;
import com.vportal.portlet.vadvman.service.AdvItemServiceUtil;
import com.vportal.portlet.vadvman.service.AdvTypeServiceUtil;
import com.vportal.portlet.vadvman.util.WebKeysExt;

public class ActionUtil {

	public static void getType(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getType(httpReq);		
	}

	public static void getType(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getType(httpReq);
	}

	public static void getItem(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getItem(httpReq);
	}

	public static void getItem(RenderRequest req) throws Exception {

		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
	}

	public static void getType(HttpServletRequest req) throws Exception {

		long typeId = ParamUtil.getLong(req, "typeId");

		AdvType type = null;

		if (typeId > 0) {
			type = AdvTypeServiceUtil.getType(typeId);
		}
		req.setAttribute("type", type);
	}

	public static void getItem(HttpServletRequest req) throws Exception {

		long itemId = ParamUtil.getLong(req, "itemId");

		AdvItem item = null;

		if (itemId > 0) {

			item = AdvItemServiceUtil.getItem(itemId);
		}

		req.setAttribute("item", item);
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

		String itemId = ParamUtil.getString(req, "itemId");

		if (Validator.isNull(itemId)) {
			return;
		}
		// get attachment
		List listAttachment = AttachmentLocalServiceUtil.getAttachments(Long
				.parseLong(itemId), AdvItem.class);

		if (listAttachment == null) {
			listAttachment = new ArrayList();
		}

		req.setAttribute(WebKeysExt.VADVMAN_LIST_ATTACHMENT, listAttachment);
	}
	
	 public static Date getEndDate(Date date) {
	        if (date == null) {
	            return null;
	        }
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.set(Calendar.HOUR_OF_DAY, 23);
	        c.set(Calendar.MINUTE, 59);
	        c.set(Calendar.SECOND, 55);
	        return c.getTime();
	  }
}
