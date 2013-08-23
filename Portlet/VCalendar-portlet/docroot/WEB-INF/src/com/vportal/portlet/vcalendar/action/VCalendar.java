
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

package com.vportal.portlet.vcalendar.action;

import com.liferay.util.bridges.mvc.MVCPortlet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portal.taglib.FileUploadUtil;
import com.vportal.portal.util.PortalUtilExt;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vcalendar.model.VCal;
import com.vportal.portlet.vcalendar.model.impl.VCalImpl;
import com.vportal.portlet.vcalendar.service.VCalServiceUtil;

/**
 * Portlet implementation class VCalendar
 */
public class VCalendar extends MVCPortlet {
	public void _addvCal(ActionRequest req, ActionResponse rep)
			throws Exception {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);

		String time = ParamUtil.getString(uploadReq, "time");
		long calId = ParamUtil.getLong(uploadReq, "calId", 0);
		Layout layout = (Layout) uploadReq.getAttribute(WebKeys.LAYOUT);
		String eventId = ParamUtil.getString(uploadReq, "eventId");
		Locale locale = req.getLocale();
		long fileId = ParamUtil.getLong(uploadReq, "fileId");
		String title = ParamUtil.getString(uploadReq, "title");
		String description = ParamUtil.getString(uploadReq, "description");
		String guest = ParamUtil.getString(uploadReq, "listguest", "");
		String location = ParamUtil.getString(uploadReq, "location", "");
		if (Validator.isNull(fileId)) {
			fileId = 0;
		}
		long userId = PortalUtilExt.getUserId(uploadReq);
		User user = UserServiceUtil.getUserById(userId);
		long groupId = PortalUtil.getScopeGroupId(layout.getPlid());
		Date now = new Date();
		String languageId = user.getLanguageId();
		long companyId = user.getCompanyId();
		String userName = user.getLogin();

		try {
			String startDatetime = ParamUtil.getString(uploadReq,
					"startDatetime", "0");
			Date startDate = new Date(startDatetime);
			VCal vcal = new VCalImpl();
			vcal = VCalServiceUtil.addvCal(groupId, companyId, userId,
					userName, now, now, languageId, title, description,
					startDate, startDate, 0, fileId, guest, location, time);

			String portletId = PortletKeysExt.VCALENDAR;
			if (Validator.isNotNull(vcal)) {
				FileUploadUtil.uploadFile(req, uploadReq, portletId,
						VCal.class, vcal.getCalId(),GetterUtil.getLong(0),StringPool.BLANK);
			}
		} catch (IllegalArgumentException e) {
			System.out.print(e);
		}
	}

	public void deletevCal(ActionRequest req, ActionResponse rep)
			throws Exception {
		long calId = ParamUtil.getLong(req, "calId", 0);
		VCalServiceUtil.deletevCal(calId);
	}

	public void updatevCal(ActionRequest req, ActionResponse rep)
			throws Exception {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		String time = ParamUtil.getString(uploadReq, "time");
		long calId = ParamUtil.getLong(uploadReq, "calId", 0);
		Layout layout = (Layout) uploadReq.getAttribute(WebKeys.LAYOUT);
		String eventId = ParamUtil.getString(uploadReq, "eventId");

		long fileId = ParamUtil.getLong(uploadReq, "fileId");
		String title = ParamUtil.getString(uploadReq, "title");
		String description = ParamUtil.getString(uploadReq, "description");
		String guest = ParamUtil.getString(uploadReq, "listguest", "");
		String location = ParamUtil.getString(uploadReq, "location", "");
		if (Validator.isNull(fileId)) {
			fileId = 0;
		}
		long userId = PortalUtilExt.getUserId(uploadReq);
		User user = UserServiceUtil.getUserById(userId);

		long groupId = PortalUtil.getScopeGroupId(layout.getPlid());
		Date now = new Date();
		String languageId = user.getLanguageId();
		long companyId = user.getCompanyId();
		String userName = user.getLogin();

		// VCal vCal = VCalServiceUtil.get

		VCalServiceUtil.updatevCal(calId, groupId, companyId, userId, userName,
				now, now, languageId, title, description, 0, fileId, guest,
				location, time);

		String portletId = PortletKeysExt.VCALENDAR;
		FileUploadUtil.uploadFile(req, uploadReq, portletId, VCal.class, calId,0,"");

	}

	public void deleteFileDL(ActionRequest req, ActionResponse res)
			throws Exception {
		long groupId = PortalUtil.getScopeGroupId(req);
		long folderId = ParamUtil.getLong(req, "folderId");
		String name = ParamUtil.getString(req, "name");
		Long attachmentId = ParamUtil.getLong(req, "attachmentId");
		DLFileEntryServiceUtil.deleteFileEntry(groupId, folderId, name);
		AttachmentLocalServiceUtil.deleteAttachment(attachmentId);
	}

}
