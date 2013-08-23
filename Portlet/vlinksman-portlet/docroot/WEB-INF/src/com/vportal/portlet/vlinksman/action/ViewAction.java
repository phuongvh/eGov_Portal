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

package com.vportal.portlet.vlinksman.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portal.taglib.FileUploadUtil;
import com.vportal.portlet.vlinksman.util.PortletKeysExt;
import com.vportal.portlet.vlinksman.model.LinkGroup;
import com.vportal.portlet.vlinksman.model.Links;
import com.vportal.portlet.vlinksman.model.impl.LinkGroupImpl;
import com.vportal.portlet.vlinksman.model.impl.LinksImpl;
import com.vportal.portlet.vlinksman.service.LinkGroupServiceUtil;
import com.vportal.portlet.vlinksman.service.LinksServiceUtil;

/**
 * Portlet implementation class ViewAction
 */
public class ViewAction extends MVCPortlet {
	// updateLink
	public void _updateLink(ActionRequest req, ActionResponse res)
			throws Exception {		
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(req);
		long linkId = ParamUtil.getLong(uploadRequest, "linkId");
		long linkgroupId = ParamUtil.getLong(uploadRequest, "linkgroupId");
		long groupId = ParamUtil.getLong(uploadRequest, "groupId");  
		long companyId = PortalUtil.getCompanyId(req);
		String name = ParamUtil.getString(uploadRequest, "name");
		String description = ParamUtil.getString(uploadRequest, "description");
		String url = ParamUtil.getString(uploadRequest, "url");
		String imageName = ParamUtil.getString(uploadRequest, "imageName");
		int position = ParamUtil.getInteger(uploadRequest, "position");
		boolean isTargetBlank = ParamUtil.getBoolean(uploadRequest, "isTargetBlank");
		String[] communityPermissions = req
				.getParameterValues("communityPermissions");
		String[] guestPermissions = req.getParameterValues("guestPermissions");

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long userId = themeDisplay.getUserId();

		Links link = new LinksImpl();
		link.setGroupId(groupId);
		link.setCompanyId(companyId);
		link.setLinkgroupId(linkgroupId);
		link.setName(name);
		link.setDescription(description);
		link.setUrl(url);
		link.setPosition(position);
		link.setIsTargetBlank(isTargetBlank);
		link.setImageName("");
		if (linkId <= 0) {		
//			link = LinksServiceUtil.addLinks(link, layout.getPlid(), null, null, communityPermissions, guestPermissions);
//			link = LinksServiceUtil.addLinks(groupId, companyId,
//					layout.getPlid(), linkgroupId, name, description, url,
//					position, userId, communityPermissions, guestPermissions);
			link = LinksServiceUtil.addLinks(groupId, companyId, layout.getPlid(), linkgroupId, name, description, url, position, userId, false, isTargetBlank, imageName,0, communityPermissions, guestPermissions);
			_attachFile(link, req, uploadRequest);
		}

		else {

			link = LinksServiceUtil.updateLinks(linkId, groupId, companyId, linkgroupId, name, description, url, position, false, isTargetBlank, imageName,0);
			_attachFile(link, req, uploadRequest);
		}
		String redirectURL = ParamUtil.getString(uploadRequest, "redirect");
		res.sendRedirect(redirectURL);
	}

	public void _attachFile(Links item, ActionRequest req,
			UploadPortletRequest uploadRequest) throws Exception {

		try {
			if (item != null) {
			
				String portletId = PortletKeysExt.VLINKSMAN;				
				FileUploadUtil.uploadFile(req, uploadRequest, portletId,
						Links.class, item.getLinkId(),0,"");

				List listAttachment = AttachmentLocalServiceUtil
						.getDLFileEntries(Links.class, item.getLinkId());

				for (int i = 0; i < listAttachment.size(); i++) {
					DLFileEntry fileEntry = (DLFileEntry) listAttachment.get(i);					
					item.setImageName(fileEntry.getTitle());
					item.setFolderId(fileEntry.getFolderId());
					if((item.getImageName()).equals("")){		
						item.setHasImage(false);
					}
					else{
						item.setHasImage(true);						
					}
				}				
				LinksServiceUtil.updateLink3(item);
			}
		} catch (Exception e) {
		}
	}
	
	public void deleteFileDL(ActionRequest req,ActionResponse res) throws Exception{
		long groupId = PortalUtil.getScopeGroupId(req);
		long folderId = ParamUtil.getLong(req, "folderId");
		String name = ParamUtil.getString(req, "name");		
		Long attachmentId = ParamUtil.getLong(req, "attachmentId");
		DLFileEntryServiceUtil.deleteFileEntry(groupId,folderId, name);
		AttachmentLocalServiceUtil.deleteAttachment(attachmentId);
	}

	// deleteLink
	public void _deleteLink(ActionRequest req, ActionResponse res)
			throws Exception {
		String Id = ParamUtil.getString(req, "linkIds");
		String[] linkIds = StringUtil
				.split(ParamUtil.getString(req, "linkIds"));
		if(linkIds.length>=1){
			for (int i = 0; i < linkIds.length; i++) {
				try {
					LinksServiceUtil.deleteLink(Long.parseLong(linkIds[i]));
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}		
		}
		else{
			LinksServiceUtil.deleteLink(Long.parseLong(Id));
		}
	}

	// updatePosition
	public void _updatePositionLink(ActionRequest req, ActionResponse res)
			throws Exception {

		String linkId = null;

		int position = 0;
		String compoundParam = ParamUtil.getString(req, "position");

		if (Validator.isNotNull(compoundParam)
				&& (compoundParam.indexOf("|") > 0)) {
			String[] cpIds = StringUtil.split(compoundParam, "|");

			position = Integer.parseInt(cpIds[0]);
			linkId = cpIds[1];
		}

		if (Validator.isNull(linkId)) {
			return;
		}

		Links link = LinksServiceUtil.getLinks(Long.parseLong(linkId));

		if (link != null) {
			link.setPosition(position);
			LinksServiceUtil.updateLink(link);
		}
	}

	// viewByGroup
	public void _viewByGroupLink(ActionRequest req, ActionResponse res)
			throws Exception {

		long linkgroupId = ParamUtil.getLong(req, "linkgroupId", 0);
		List listLink = new ArrayList();

		if (linkgroupId == 0) {
			listLink = LinksServiceUtil.getAll();
		} else {
			listLink = LinksServiceUtil.getByLinkGroupId(linkgroupId);
		}

		req.setAttribute("listLink", listLink);
	}

	public void _updateLinkGroup(ActionRequest req, ActionResponse res)
			throws Exception {
		long linkgroupId = ParamUtil.getLong(req, "Id");
		long groupId = ParamUtil.getLong(req, "groupId");
		long companyId = PortalUtil.getCompanyId(req);
		String name = ParamUtil.getString(req, "name");
		String description = ParamUtil.getString(req, "description");

		String[] communityPermissions = req
				.getParameterValues("communityPermissions");
		String[] guestPermissions = req.getParameterValues("guestPermissions");

		ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long userId = themeDisplay.getUserId();

		LinkGroup linkGroup = new LinkGroupImpl();
		
		if (linkgroupId <= 0) {
			linkGroup = LinkGroupServiceUtil.addLinkGroup(groupId, companyId,
					layout.getPlid(), name, description, userId,
					communityPermissions, guestPermissions);
		}else {

			linkGroup = LinkGroupServiceUtil.getLinkGroup(linkgroupId);

			LinkGroupServiceUtil.updateLinkGroup(linkgroupId, groupId,
					companyId, name, description);

		}
	}

	public void _deleteLinkGroup(ActionRequest req, ActionResponse res)
			throws Exception {

		String Id = ParamUtil.getString(req, "Id");

		LinkGroupServiceUtil.deleteLinkGroup(Long.parseLong(Id));
	}

}
