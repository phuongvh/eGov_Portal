
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

package com.vportal.portlet.vclip;

/**
 * @author Doan Khanh Duy
 * @version 1.0.0
 */
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portal.service.AttachmentLocalService;
import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portal.service.AttachmentServiceUtil;
import com.vportal.portlet.vclip.model.Clip;
import com.vportal.portlet.vclip.model.ClipType;


import com.vportal.portlet.vclip.service.ClipServiceUtil;
import com.vportal.portlet.vclip.service.ClipTypeServiceUtil;
import com.vportal.portlet.vclip.util.WebKeysVClip;

public class ActionUtil {

	// Attach file by cuongnv
	public static void getAttachmentList(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAttachmentList(httpReq);
	}

	public static void getAttachmentList(HttpServletRequest req)
			throws Exception {
		long clipId = ParamUtil.getLong(req, "clipId");
		// get attachment
		List listAttachment = AttachmentLocalServiceUtil.getAttachments(clipId, Clip.class);    //getAttachments(clipId,Clip.class);
				
		if (listAttachment == null) {
			listAttachment = new ArrayList();
		}
		req.setAttribute(WebKeysVClip.VCLIP_LIST_ATTACHMENT, listAttachment);
	}

	// Attach image 
	public static void getImageList(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getImageList(httpReq);
	}

	public static void getImageList(HttpServletRequest req)
			throws Exception {
		long clipId = ParamUtil.getLong(req, "clipId");
		// get attachment
		List listImage = AttachmentLocalServiceUtil.getAttachments(clipId, Clip.class);    //getAttachments(clipId,Clip.class);
				
		if (listImage == null) {
			listImage = new ArrayList();
		}
		req.setAttribute("imageList", listImage);
	}

	// Clip Type
	public static void getClipType(RenderRequest req) {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		getClipType(request);
	}

	public static void getClipType(ActionRequest req) {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		getClipType(request);
	}

	public static void getClipType(HttpServletRequest req) {
		try {
			String id = ParamUtil.getString(req, WebKeysVClip.CLIP_TYPE_ID);
			if (Validator.isNotNull(id)) {
				ClipType c = ClipTypeServiceUtil.findById(id);
				req.setAttribute(WebKeysVClip.CLIP_TYPE, c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Clip
	public static void getClip(RenderRequest req) {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		getClip(request);
	}

	public static void getClip(ActionRequest req) {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);

		getClip(request);
	}

	public static void getClip(HttpServletRequest req) {
		try {
			String id = ParamUtil.getString(req, WebKeysVClip.CLIP_ID);
			if (Validator.isNotNull(id)) {
				Clip c = ClipServiceUtil.findById(id);
				req.setAttribute(WebKeysVClip.CLIP, c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
