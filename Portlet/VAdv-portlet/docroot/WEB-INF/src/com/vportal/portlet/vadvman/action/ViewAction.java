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

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
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
import com.vportal.portlet.vadvman.InvalidItemNameException;
import com.vportal.portlet.vadvman.InvalidSizeFileException;
import com.vportal.portlet.vadvman.InvalidTypeNameException;
import com.vportal.portlet.vadvman.InvalidUrlException;
import com.vportal.portlet.vadvman.model.AdvItem;
import com.vportal.portlet.vadvman.model.AdvType;
import com.vportal.portlet.vadvman.model.impl.AdvItemImpl;
import com.vportal.portlet.vadvman.model.impl.AdvTypeImpl;
import com.vportal.portlet.vadvman.service.AdvItemServiceUtil;
import com.vportal.portlet.vadvman.service.AdvTypeServiceUtil;
import com.vportal.portlet.vadvman.util.PortletKeysExt;

/**
 * Portlet implementation class ViewAction
 */
public class ViewAction extends MVCPortlet {
		
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.render(request, response);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub

		super.processAction(actionRequest, actionResponse);
	}

	/* Type kieu quang cao */
	public void _updateType(ActionRequest req, ActionResponse res)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();		
		long typeId = ParamUtil.getLong(req, "typeId");

		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		String name = ParamUtil.getString(req, "name");
		String description = ParamUtil.getString(req, "description");

		String[] communityPermissions = req
				.getParameterValues("communityPermissions");
		String[] guestPermissions = req.getParameterValues("guestPermissions");

		AdvType type = new AdvTypeImpl();

		try {
			if (typeId <= 0) {

				type = AdvTypeServiceUtil.addType(groupId, companyId,
						layout.getPlid(), name, description,
						communityPermissions, guestPermissions);

			} else {
				type = AdvTypeServiceUtil.getType(typeId);

				AdvTypeServiceUtil.updateType(typeId, groupId, companyId,
						layout.getPlid(), name, description);

			}
		} catch (Exception ex) {
			if (ex instanceof InvalidTypeNameException
					|| ex instanceof InvalidUrlException
					|| ex instanceof InvalidSizeFileException
					|| ex instanceof InvalidItemNameException) {
				SessionErrors.add(req, ex.getClass().getName(), ex);
			} else {
				ex.printStackTrace();
			}
		}

	}

	public void _deleteType(ActionRequest req, ActionResponse res)
			throws Exception {
		String[] ids = StringUtil.split(ParamUtil.getString(req, "ids"));
		for (int i = 0; i < ids.length; i++) {
			try {
				AdvTypeServiceUtil.deleteType(Long.parseLong(ids[i]));
			} catch (RuntimeException e) {				
				e.printStackTrace();				
			}
		}
	}

	/* Item quang cao */

	public void _updateItem(ActionRequest req,ActionResponse res) throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();

		long itemId = ParamUtil.getLong(uploadRequest, "itemId");
		long typeId = ParamUtil.getLong(uploadRequest, "typeId");
		long folderId = 0;

		long groupId = layout.getGroupId();
		long companyId = PortalUtil.getCompanyId(req);

		boolean status = false;
		String description = ParamUtil.getString(uploadRequest, "description");
		String url = ParamUtil.getString(uploadRequest, "url");

		boolean isTargetBlank = ParamUtil.getBoolean(uploadRequest, "isTargetBlank");
		boolean neverExpired = ParamUtil.getBoolean(uploadRequest, "neverExpired");

		String txtMouseOver = ParamUtil.getString(uploadRequest, "txtMouseOver");

		int expiredMonth = ParamUtil.getInteger(uploadRequest, "expiredMonth");
		int expiredDate = ParamUtil.getInteger(uploadRequest, "expiredDay");
		int expiredYear = ParamUtil.getInteger(uploadRequest, "expiredYear");

		Locale locale = null;
		TimeZone timeZone = null;

		locale = LocaleUtil.getDefault();
		timeZone = TimeZoneUtil.getDefault();

		Calendar expiredDay = CalendarFactoryUtil.getCalendar(timeZone, locale);

		if (neverExpired) {

			expiredDay = null;
			status = true;

		} else {
			expiredDay.set(Calendar.MONTH, expiredMonth);
			expiredDay.set(Calendar.DATE, expiredDate);
			expiredDay.set(Calendar.YEAR, expiredYear);

		}

		if (Validator.isNotNull(expiredDay)) {
			if (expiredDay.getTime().after(new Date())) {
				status = true;
			}
		}

		String[] communityPermissions = uploadRequest
				.getParameterValues("communityPermissions");

		String[] guestPermissions = uploadRequest.getParameterValues("guestPermissions");

		AdvItem item = new AdvItemImpl();

		if (itemId <= 0) {

			if (Validator.isNull(expiredDay)) {
				item = AdvItemServiceUtil.addItem(groupId, companyId,
						layout.getPlid(), "", description, url, isTargetBlank,
						txtMouseOver, status, typeId, folderId, null,
						communityPermissions, guestPermissions);

			} else {
				item = AdvItemServiceUtil.addItem(groupId, companyId,
						layout.getPlid(), "", description, url, isTargetBlank,
						txtMouseOver, status, typeId, folderId,
						ActionUtil.getEndDate(expiredDay.getTime()), communityPermissions,
						guestPermissions);
			}

			AdvTypeServiceUtil.getTypeByG(groupId);

			_attachFile(item, req,uploadRequest);

		} else {

			item = AdvItemServiceUtil.getItem(itemId);

			_attachFile(item, req,uploadRequest);

			if (Validator.isNull(expiredDay)) {
				AdvItemServiceUtil.updateItem(itemId, groupId, companyId,
						item.getName(), description, url, isTargetBlank,
						txtMouseOver, status, typeId, item.getFolderId(), null);
			} else {
				AdvItemServiceUtil.updateItem(itemId, groupId, companyId,
						item.getName(), description, url, isTargetBlank,
						txtMouseOver, status, typeId, item.getFolderId(),
						/*expiredDay.getTime());*/
						ActionUtil.getEndDate(expiredDay.getTime()));
			}

		}
		res.setRenderParameter("jspPage", "/html/portlet/vadvman/view.jsp");
		res.setRenderParameter("tabs1", "VAdvman.title.item");
	}

	// Delete item
	public void _deleteItem(ActionRequest req,ActionResponse res) throws Exception {

		String[] ids = StringUtil.split(ParamUtil.getString(req, "ids"));
		for (int i = 0; i < ids.length; i++) {
			try {
				AdvItem item = AdvItemServiceUtil.getItem(Long
						.parseLong(ids[i]));

				AttachmentLocalServiceUtil.deleteAttachments(AdvItem.class,
						item.getItemId());

				AdvItemServiceUtil.deleteItem(Long.parseLong(ids[i]));

			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	}

	// Attach File
	public void _attachFile(AdvItem item, ActionRequest req,UploadPortletRequest uploadRequest) throws Exception {

		try {
			if (item != null) {
				
				String portletId = PortletKeysExt.VADVMAN;

				FileUploadUtil.uploadFile(req,uploadRequest, portletId, AdvItem.class,
						item.getItemId(), GetterUtil.getLong(0),StringPool.BLANK);

				List listAttachment = AttachmentLocalServiceUtil
						.getDLFileEntries(AdvItem.class, item.getItemId());

				for (int i = 0; i < listAttachment.size(); i++) {
					DLFileEntry fileEntry = (DLFileEntry) listAttachment.get(i);

					item.setName(fileEntry.getTitle());
					item.setFolderId(fileEntry.getFolderId());
				}

				AdvItemServiceUtil.updateItem(item);
			}
		} catch (Exception e) {
		}
	}
	

	// update Status
	private void _updateStatus(ActionRequest req, ActionResponse res)
			throws Exception {
		boolean status = ParamUtil.getBoolean(req, "status");
		long itemId = ParamUtil.getLong(req, "itemId");
		if (Validator.isNotNull(String.valueOf(itemId))) {

			AdvItem item = AdvItemServiceUtil.getItem(itemId);
			item.setStatus(status);
			AdvItemServiceUtil.updateItem(item);
		}
	}
	
	//delete file
	public void deleteFileDL(ActionRequest req,ActionResponse res) throws Exception{
		long groupId = PortalUtil.getScopeGroupId(req);
		long folderId = ParamUtil.getLong(req, "folderId");
		String name = ParamUtil.getString(req, "name");
		Long attachmentId = ParamUtil.getLong(req, "attachmentId");
		DLFileEntryServiceUtil.deleteFileEntry(groupId,folderId, name);
		AttachmentLocalServiceUtil.deleteAttachment(attachmentId);
	}
}
