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

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portlet.vclip.model.ClipType;
import com.vportal.portlet.vclip.model.impl.ClipTypeImpl;
import com.vportal.portlet.vclip.service.ClipTypeServiceUtil;
import com.vportal.portlet.vclip.util.WebKeysVClip;

public class ClipTypeAction {

	// public void render(RenderRequest req, RenderResponse res)
	// throws Exception {
	//
	// String language = ParamUtil.getString(req, "language");
	// req.setAttribute(language, "language");
	//
	// String cmd = ParamUtil.getString(req, Constants.CMD);
	//
	// if (Validator.isNotNull(cmd)) {
	// if (cmd.equals(Constants.EDIT)) {
	// try {
	// ActionUtil.getClipType(req);
	// // return mapping.findForward("vportal.vclip.edit_cliptype");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// else if (cmd.equals(Constants.VIEW)) {
	// ActionUtil.getClipType(req);
	// // return mapping.findForward("vportal.vclip.view_cliptype");
	// }
	//
	// else if (cmd.equals(Constants.SEARCH)) {
	// String title = ParamUtil.getString(req, "title");
	// String name = ParamUtil.getString(req, "name");
	// String description = ParamUtil.getString(req, "description");
	//
	// ClipType clipType = new ClipTypeImpl();
	//
	// clipType.setLanguage(language);
	//
	// req.setAttribute(WebKeysVClip.CLIP_TYPE, clipType);
	//
	// List result=ClipTypeServiceUtil.findClipType(clipType);
	// req.setAttribute(WebKeysVClip.CLIP_TYPE_RESULT_SEARCH, result);
	// // return mapping.findForward("vportal.vclip.start");
	// }
	// }
	// // return mapping.findForward("vportal.vclip.start");
	// }

	public static void processAction(ActionRequest req, ActionResponse res,
			String cmd, UploadPortletRequest uploadRequest) throws Exception {

		String[] communityPermissions = req
				.getParameterValues("communityPermissions");
		String[] guestPermissions = req.getParameterValues("guestPermissions");
		String language = ParamUtil.getString(req, "language");
		if (Validator.isNull(cmd)) {
			return;
		}
		if (cmd.equals(Constants.EDIT)) {
			try {
				ActionUtil.getClipType(req);
				// return mapping.findForward("vportal.vclip.edit_cliptype");
				res.setRenderParameter("jspPage",
						"/html/portlet/manage_vclip/view.jsp");
				res.setRenderParameter("tabs1", "vportal.vclip.clipType");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (cmd.equals(Constants.VIEW)) {
			ActionUtil.getClipType(req);
			// return mapping.findForward("vportal.vclip.view_cliptype");
			res.setRenderParameter("jspPage",
					"/html/portlet/manage_vclip/view.jsp");
			res.setRenderParameter("tabs1", "vportal.vclip.clipType");
		}

		else if (cmd.equals(Constants.SEARCH)) {
			String title = ParamUtil.getString(req, "title");
			String name = ParamUtil.getString(req, "name");
			String description = ParamUtil.getString(req, "description");

			ClipType clipType = new ClipTypeImpl();

			clipType.setLanguage(language);

			req.setAttribute(WebKeysVClip.CLIP_TYPE, clipType);

			List result = ClipTypeServiceUtil.findClipType(clipType);
			req.setAttribute(WebKeysVClip.CLIP_TYPE_RESULT_SEARCH, result);
			res.setRenderParameter("jspPage",
					"/html/portlet/manage_vclip/view.jsp");
			res.setRenderParameter("tabs1", "vportal.vclip.clipType");
			// return mapping.findForward("vportal.vclip.start");
		}
		// Delete
		else if (cmd.equals(Constants.DELETE)) {
			try {
				String id = ParamUtil.getString(req, WebKeysVClip.CLIP_TYPE_ID);
				if (Validator.isNotNull(id)) {
					ClipTypeServiceUtil.deleteClipType(id);
				}
				res.setRenderParameter("jspPage",
						"/html/portlet/manage_vclip/view.jsp");
				res.setRenderParameter("tabs1", "vportal.vclip.clipType");
				// sendRedirect(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Save
		else if (cmd.equals(Constants.SAVE)) {

			ClipType clipType = getProperties(req, uploadRequest);
			java.util.Date date = new java.util.Date();
			ThemeDisplay themeDisplay = (ThemeDisplay) req
					.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = clipType.getGroupId();
			long companyId = clipType.getCompanyId();
			String clipTypeId = clipType.getId();

			Layout layout = themeDisplay.getLayout();

			if (Validator.isNull(clipType.getId())
					|| clipType.getId().trim().equals("")) {// is Add new
				companyId = themeDisplay.getCompanyId();
				groupId = PortalUtil.getScopeGroupId(layout);
				clipType.setCreatedDate(date);
				clipType.setModifiedDate(date);
				clipType.setUserId(themeDisplay.getUserId());
				clipType = ClipTypeServiceUtil.addClipType(groupId, companyId,
						layout.getPlid(), clipType, null, null,
						communityPermissions, guestPermissions);
			} else {// Is modify
				clipType.setModifiedDate(date);
				clipType = ClipTypeServiceUtil.updateClipType(groupId,
						companyId, clipTypeId, clipType);
			}
			res.setRenderParameter("jspPage",
					"/html/portlet/manage_vclip/view.jsp");
			res.setRenderParameter("tabs1", "vportal.vclip.clipType");
			req.setAttribute(Constants.CMD, "");
			// sendRedirect(req, res);
		}

	}

	private static ClipType getProperties(ActionRequest req,
			UploadPortletRequest uploadRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		String id = ParamUtil.getString(uploadRequest,
				WebKeysVClip.CLIP_TYPE_ID);
		String portalSiteId = ParamUtil.getString(req, "portalSiteId");
		String language = ParamUtil.getString(req, "language");
		String title = ParamUtil.getString(uploadRequest, "title");
		String name = ParamUtil.getString(uploadRequest, "name");
		String description = ParamUtil.getString(uploadRequest, "description");
		Long companyId = themeDisplay.getCompanyId();
		Long groupId = PortalUtil.getScopeGroupId(layout);
		ClipType clipType = new ClipTypeImpl();
		clipType.setGroupId(Long.valueOf(groupId));
		clipType.setCompanyId(Long.valueOf(companyId));
		clipType.setId(id);
		clipType.setLanguage(language);
		clipType.setTitle(title);
		clipType.setName(name);
		clipType.setDescription(description);
		clipType.setActive(true);
		return clipType;
	}

}
