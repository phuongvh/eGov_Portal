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

package com.vportal.portlet.vsitemap.action;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
//import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portlet.vsitemap.IconNameException;
import com.vportal.portlet.vsitemap.IconSizeException;
import com.vportal.portlet.vsitemap.model.VsmBranch;
import com.vportal.portlet.vsitemap.model.impl.VsmBranchImpl;
import com.vportal.portlet.vsitemap.service.VsmBranchServiceUtil;
import com.vportal.portlet.vsitemap.util.SiteMapUtil;
import com.vportal.portal.util.ImageUtilExt;
/**
 * Portlet implementation class ViewAction
 */
public class ViewAction extends MVCPortlet {
//	public ActionForward render(ActionMapping mapping, ActionForm form,
//			PortletConfig config, RenderRequest req, RenderResponse res)
//			throws Exception {
//
//		String forward = "portlet.vsitemap.view";
//		String cmd = ParamUtil.getString(req, "cmd");
//		long branchId = ParamUtil.getLong(req, "id");
//
//		try {
//
//			if (Validator.isNotNull(cmd) && cmd.equals("showadd")) {
//				VsmBranch root = new VsmBranchImpl();
//				root.setBranchId(0);
//
//				List listBranch = VsmBranchServiceUtil.getAll();
//
//				listBranch = SiteMapUtil.sort(listBranch);
//				listBranch = SiteMapUtil.formatByLevel(listBranch);
//
//				listBranch.add(0, root);
//				req.setAttribute("listBranch", listBranch);
//
//				forward = "portlet.vsitemap.branch.edit";
//
//			} else if (Validator.isNotNull(cmd) && cmd.equals("showupdate")) {
//
//				VsmBranch root = new VsmBranchImpl();
//				root.setBranchId(0);
//
//				List listBranch = VsmBranchServiceUtil.getAll();
//
//				listBranch = SiteMapUtil.sort(listBranch);
//				listBranch = SiteMapUtil.formatByLevel(listBranch);
//				listBranch.add(0, root);
//				req.setAttribute("listBranch", listBranch);
//
//				VsmBranch branch = VsmBranchServiceUtil.getBranch(branchId);
//				req.setAttribute("vsmBranch", branch);
//
//				forward = "portlet.vsitemap.branch.edit";
//			}
//
//		} catch (Exception e) {
//			if (e instanceof NoSuchVsmBranchException
//					|| e instanceof PrincipalException) {
//				SessionErrors.add(req, e.getClass().getName());
//
//				return mapping.findForward("portlet.vsitemap.error");
//			} else {
//				throw e;
//			}
//
//		}
//		return mapping.findForward(forward);
//
//	}
//
//	public void processAction(PortletConfig config, ActionRequest req, ActionResponse res)
//			throws Exception {
//
//		String cmd = ParamUtil.getString(req, "cmd");
//		try {
//
//			if (cmd.equals("doadd") || cmd.equals("doupdate")) {
//				updateBranch(req);
//			} else if (Validator.isNotNull(cmd) && cmd.equals("dodelete")) {
//				doRemoveBranch(req);
//			} else if (Validator.isNotNull(cmd) && cmd.equals("remove_icon")) {
//				removeIcon(req);
//			} else if (Validator.isNotNull(cmd)
//					&& cmd.equals("update_position")) {
//				updatePosition(req);
//			}
//			sendRedirect(req, res);
//
//		} catch (Exception e) {
//			if (e instanceof NoSuchVsmBranchException
//					|| e instanceof PrincipalException) {
//
//				setForward(req, "portlet.vsitemap.error");
//
//			} else if (e instanceof IconSizeException
//					|| e instanceof IconNameException) {
//
//				SessionErrors.add(req, e.getClass().getName());
//			} else {
//				throw e;
//			}
//		}
//	}

	// Update Branch
	public void updateBranch(ActionRequest req, ActionResponse res) throws Exception {
		UploadPortletRequest uploadReq = PortalUtil.getUploadPortletRequest(req);
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();

		long userId = themeDisplay.getUserId();
		long branchId = Long.valueOf(uploadReq.getParameter("id"));
		long parentId = Long.valueOf(uploadReq.getParameter("parentId"));
		long groupId = Long.valueOf(uploadReq.getParameter("groupId"));
		long companyId = themeDisplay.getCompanyId();
		String name = uploadReq.getParameter("name");
		String icon = uploadReq.getFileName("icon");
		String description = uploadReq.getParameter("description");
		String language = uploadReq.getParameter("language");
		boolean anchored = Boolean.valueOf(uploadReq.getParameter("anchored"));
		String href = uploadReq.getParameter("href");
		boolean hasIcon = false;
		
		String cmd = uploadReq.getParameter("cmd");
//		String[] communityPermissions = req
//				.getParameterValues("communityPermissions");
//		String[] guestPermissions = req.getParameterValues("guestPermissions");
		
		VsmBranch branch = new VsmBranchImpl();
		if (branchId <= 0) {
			if (Validator.isNull(icon)) {
				hasIcon = false;
			} else {
				hasIcon = true;
			}
//			branch = VsmBranchServiceUtil.addBranch(groupId, companyId, layout
//					.getPlid(), parentId, name, description, anchored, href,
//					language, hasIcon, "", userId, communityPermissions,
//					guestPermissions);
			branch = VsmBranchServiceUtil.addBranch(groupId, companyId, layout
					.getPlid(), parentId, name, description, anchored, href,
					language, hasIcon, "", userId,null,null);
			
		} else {
			
			branch = VsmBranchServiceUtil.getBranch(branchId);
			if (cmd.equals("remove_icon")){
				removeIcon(req,String.valueOf( branch.getBranchId()));
			
				return;
			}
			
			if (Validator.isNull(icon)) {
				hasIcon = false;
				hasIcon = branch.getHasIcon();
			} else {
				hasIcon = true;
			}
			 

			branch = VsmBranchServiceUtil.updateBranch(groupId, companyId,
					branchId, parentId, name, description, anchored, href,
					language, hasIcon, branch.getIcon(), branch.getPosition(),
					userId);
		}
		
		// upload image
		
	
		if (hasIcon) {
			

			long itemId = branch.getBranchId();
			String imageContentType = uploadReq.getContentType("icon");

			if (checkIsImage(imageContentType)
					&& Validator.isNotNull(String.valueOf(itemId))) {

				String imageKey = SiteMapUtil.getRandPrefix();

				File fileImage = uploadReq.getFile("icon");
				// save org image
				if (fileImage != null) {

					byte[] photoBytes = FileUtil.getBytes(fileImage);
							
										
					if ((GetterUtil.getLong(PrefsPropsUtil.getString(PropsKeys.DL_FILE_MAX_SIZE)) > 0)
							&& ((photoBytes == null) || photoBytes.length > GetterUtil.getLong(PrefsPropsUtil.getString(PropsKeys.DL_FILE_MAX_SIZE)))) {
						branch.setHasIcon(false);
						VsmBranchServiceUtil.updateBranch(branch);
						throw new IconSizeException();

					} else {

						ImageUtilExt.saveOriginalImage(
								Long.parseLong(imageKey), photoBytes);

						branch.setHasIcon(true);
						branch.setIcon(imageKey);
						VsmBranchServiceUtil.updateBranch(branch);
					}
					
				}
			}
		}
	}

	// Remove Branch
	public void doRemoveBranch(ActionRequest req, ActionResponse res) throws Exception {
		String branchId[] = StringUtil.split(ParamUtil.getString(req, "ids"));
		for (int i = 0; i < branchId.length; i++) {
			try {

				VsmBranch branch = VsmBranchServiceUtil.getBranch(Long
						.parseLong(branchId[i]));

				if (!branch.getIcon().equalsIgnoreCase("")) {

					ImageUtilExt.deleteImage(Long.parseLong(branch.getIcon()));
				}

				VsmBranchServiceUtil.deleteBranch(Long.parseLong(branchId[i]));

			} catch (Exception ce) {
				ce.printStackTrace();
			}
		}
	}

	// Remove Icon
	public void removeIcon(ActionRequest req,String branchId) throws Exception {
		try {
			
			
			
			if (Validator.isNull(branchId)) {
				return;
			}

			VsmBranch branch = VsmBranchServiceUtil.getBranch(Long
					.parseLong(branchId));

			ImageUtilExt.deleteImage(Long.parseLong(branch.getIcon()));

			if (branch != null) {
				branch.setHasIcon(false);
				branch.setIcon(null);
				VsmBranchServiceUtil.updateBranch(branch);
				
			}
		} catch (Exception ce) {
			ce.printStackTrace();
		}
	}

	// Update position
	public void updatePosition(ActionRequest req,ActionResponse res) throws Exception {
		long branchId = 0;
		long position = 0;
		UploadPortletRequest uploadReq = com.liferay.portal.util.PortalUtil
				.getUploadPortletRequest(req);
		String compoundParam = uploadReq.getParameter("position");

		if (Validator.isNotNull(compoundParam)
				&& (compoundParam.indexOf("|") > 0)) {
			String[] cpIds = StringUtil.split(compoundParam, "|");

			position = Long.parseLong(cpIds[0]);
			branchId = Long.parseLong(cpIds[1]);
		}

		if (branchId <= 0) {
			return;
		}
		try {
			VsmBranch branch = VsmBranchServiceUtil.getBranch(branchId);

			if (branch != null) {
				branch.setPosition(position);
				VsmBranchServiceUtil.updateBranch(branch);
			}
		} catch (Exception ce) {
			ce.printStackTrace();
		}
		res.setRenderParameter("jspPage", "/html/portlet/vsitemap/view_branch.jsp");

	}

	private boolean checkIsImage(String contentType) throws Exception {
		if (Validator.isNull(contentType)) {
			return false;
		}

		if (contentType.indexOf("gif") == -1
				&& contentType.indexOf("jpg") == -1
				&& contentType.indexOf("jpeg") == -1
				&& contentType.indexOf("png") == -1) {
			{
				throw new IconNameException();
			}
		}
		return true;
	}
	
}
