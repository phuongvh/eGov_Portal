
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
package com.vportal.portlet.vdoc.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


import com.vportal.portlet.vdoc.DeleteOrgException;
import com.vportal.portlet.vdoc.InvalidFieldDocException;
import com.vportal.portlet.vdoc.InvalidNameOrgException;
import com.vportal.portlet.vdoc.NoSuchvdocOrgException;

import com.vportal.portlet.vdoc.model.vdocDORel;
import com.vportal.portlet.vdoc.model.vdocField;
import com.vportal.portlet.vdoc.model.vdocDocument;
import com.vportal.portlet.vdoc.model.vdocOrg;
import com.vportal.portlet.vdoc.model.impl.vdocDocumentImpl;


import com.vportal.portlet.vdoc.service.vdocDORelServiceUtil;
import com.vportal.portlet.vdoc.service.vdocFieldServiceUtil;
import com.vportal.portlet.vdoc.service.vdocOrgServiceUtil;
import com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil;
import com.vportal.portlet.vdoc.service.impl.vdocDocumentServiceImpl;

import com.vportal.portlet.vdoc.service.util.ActionUtil;
import com.vportal.portlet.vdoc.service.util.PortletKeysExt;
import com.vportal.portlet.vdoc.service.util.ReportUtil;
import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portal.taglib.FileUploadUtil;
import com.vportal.portal.util.PropsUtilExt;

public class VDocManage extends MVCPortlet {

	public static final int APPROVAL_PENDING = 0;

	public static final int PUBLISH_PENDING = 1;

	public static final int PUBLISHED = 2;

	/**
	 * 
	 * @param req
	 * @param res
	 * @throws SystemException
	 * @throws PortalException
	 * @throws RemoteException
	 */
	public void updateField(ActionRequest req, ActionResponse res)
			throws SystemException, PortalException, RemoteException {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		String fieldId = ParamUtil.getString(req, "fieldId");
		String parentId = ParamUtil.getString(req, "parentId", "0");
		long groupId = layout.getGroupId();
		long userId = themeDisplay.getUserId();
		String name = ParamUtil.getString(req, "name");
		String description = ParamUtil.getString(req, "description");
		String language = ParamUtil.getString(req, "language");
		int position = 0;
		int positionForm = ParamUtil.getInteger(req, "position");
		if (positionForm == 0) {
			position += 1;
		} else {
			position = positionForm;
		}
		boolean statusField = Validator.isNotNull(ParamUtil.getString(req,
				"status")) ? true : false;

		vdocField field = null;

		String[] communityPermissions = req
				.getParameterValues("communityPermissions");
		String[] guestPermissions = req.getParameterValues("guestPermissions");

		String listParent = "0";
		if (!parentId.equals("0")) {
			listParent = vdocFieldServiceUtil.getField(parentId)
					.getListparent();
			System.out.println("List parent: " + listParent);
		}

		if (fieldId.equals("0") || Validator.isNull(fieldId)) {
			field = vdocFieldServiceUtil.addField(groupId, userId,
					language, parentId, name, description, statusField,
					position, listParent, communityPermissions,
					guestPermissions, themeDisplay);
		} else {
			field = vdocFieldServiceUtil.getField(fieldId);
			field.setName(name);
			field.setDescription(description);
			field.setLanguage(language);
			field.setPosition(position);
			field.setListparent(listParent);
			vdocFieldServiceUtil.updateField(field, userId);
		}

		res.setRenderParameter(
				"jspPage",
				"/html/portlet/vdoc_manage/view.jsp?tabs1=generalmanage-tab&tabs2=portlet.vdoc.general-manage.fields-tab");
	}

	/**
	 * 
	 * @param req
	 * @param res
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteField(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException {
		String fieldId = ParamUtil.getString(req, "fieldId");
		if (Validator.isNotNull(fieldId)) {
			vdocFieldServiceUtil.deleteField(fieldId);
		}
		res.setRenderParameter("jspPage",
				"/html/portlet/vdoc_manage/view.jsp?tabs1=generalmanage-tab&tabs2=field-tab");
	}

	/**
	 * 
	 * @param req
	 * @param res
	 * @throws SystemException
	 * @throws PortalException
	 * @throws RemoteException
	 */
	public void updateOrg(ActionRequest req, ActionResponse res)
			throws SystemException, PortalException, RemoteException {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		long groupId = layout.getGroupId();
		long userId = themeDisplay.getUserId();

		String orgId = ParamUtil.getString(req, "orgId");
		String parentId = ParamUtil.get(req, "parentId", "0");
		String name = ParamUtil.getString(req, "name");
		String description = ParamUtil.getString(req, "description");
		String address = ParamUtil.getString(req, "address");
		String phone = ParamUtil.getString(req, "phone");
		int position = 0;
		int positionForm = ParamUtil.getInteger(req, "position");
		if (positionForm == 0) {
			position += 1;
		} else {
			position = positionForm;
		}
		boolean statusOrg = Validator.isNotNull(ParamUtil.getString(req,
				"status")) ? true : false;
		String fax = ParamUtil.getString(req, "fax");
		String language = ParamUtil.getString(req, "language");

		vdocOrg org = null;

		String[] communityPermissions = req
				.getParameterValues("communityPermissions");
		String[] guestPermissions = req.getParameterValues("guestPermissions");

		String listParent = "0";
		if (!parentId.equals("0")) {
			listParent = vdocOrgServiceUtil.getOrg(parentId)
					.getListparent();
			System.out.println("List parent: " + listParent);
		}

		if (orgId.equals("0") || Validator.isNull(orgId)) {
			org = vdocOrgServiceUtil.addOrg(groupId, userId, language,
					parentId, name, description, address, phone, statusOrg,
					position, fax, listParent, communityPermissions,
					guestPermissions, themeDisplay);
		} else {
			org = vdocOrgServiceUtil.getOrg(orgId);
			org.setName(name);
			org.setDescription(description);
			org.setAddress(address);
			org.setPhone(phone);
			org.setPosition(position);
			org.setFax(fax);
			org.setLanguage(language);
			org.setListparent(listParent);

			vdocOrgServiceUtil.updateOrg(org, userId);
		}

		res.setRenderParameter("jspPage",
				"/html/portlet/vdoc_manage/view.jsp?tabs1=generalmanage-tab&tabs2=organization-tab");
		
	}

	/**
	 * 
	 * @param req
	 * @param res
	 * @throws NoSuchvdocOrgException
	 * @throws DeleteOrgException
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteOrg(ActionRequest req, ActionResponse res)
			throws NoSuchvdocOrgException, DeleteOrgException, PortalException,
			SystemException {
		String orgId = ParamUtil.getString(req, "orgId");
		if (Validator.isNotNull(orgId)) {
			vdocOrgServiceUtil.deleteOrg(orgId);
		}
		res.setRenderParameter("jspPage",
				"/html/portlet/vdoc_manage/view.jsp?tabs1=generalmanage-tab&tabs2=organization-tab");
	}

	@SuppressWarnings("rawtypes")
	public void updateDocument(ActionRequest req, ActionResponse res)
			throws SystemException, PortalException, RemoteException {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();

		String docId = ParamUtil.getString(uploadReq, "docId");
		long groupId = layout.getGroupId();
		String language = ParamUtil.getString(uploadReq, "language");
		long userId = themeDisplay.getUserId();

		String fieldId = ParamUtil.getString(uploadReq, "fieldId");

		String fieldRels = "";
		String orgRels = "";

		if ((Validator.isNull(fieldId)) || (fieldId.equals("0"))) {
			throw new InvalidFieldDocException();
		} else {
			vdocField field = vdocFieldServiceUtil.getField(fieldId);
			fieldRels = field.getName();
		}

		String orgIds[] = uploadReq.getParameterValues("orgId");

		int typeDoc = vdocDocumentServiceImpl.SINGLE;

		if (Validator.isNotNull(orgIds) && orgIds.length > 1) {
			typeDoc = vdocDocumentServiceImpl.MULTI;
		}
		if (Validator.isNull(orgIds) || (orgIds.length < 1)) {
			throw new InvalidNameOrgException();
		}
		String title = ParamUtil.getString(uploadReq, "title");
		// if (Validator.isNull(title)) {
		// throw new InvalidTitleDocException();
		// }

		String process = ParamUtil.getString(uploadReq, "process");
		String base = ParamUtil.getString(uploadReq, "base");
		String cost = ParamUtil.getString(uploadReq, "cost");
		String require = ParamUtil.getString(uploadReq, "require");
		String result = ParamUtil.getString(uploadReq, "result");
		String objects = ParamUtil.getString(uploadReq, "objects");
		String style = ParamUtil.getString(uploadReq, "style");
		String time = ParamUtil.getString(uploadReq, "time");
		String content = ParamUtil.getString(uploadReq, "content");
		// if (Validator.isNull(content)) {
		// throw new InvalidContentDocException();
		// }

		String note = ParamUtil.getString(uploadReq, "note");

		String save_approve = ParamUtil.getString(uploadReq, "saveAndApprove");
		String save_publish = ParamUtil.getString(uploadReq, "saveAndPublish");

		Date promulDate = null;
		Date effectivedDate = null;
		Date expiredDate = null;

		boolean hasAttachment = false;

		String[] communityPermissions = uploadReq
				.getParameterValues("communityPermissions");

		String[] guestPermissions = uploadReq
				.getParameterValues("guestPermissions");

		vdocDocument vdoc = new vdocDocumentImpl();

		try {
			if ((docId.equals("0")) || (Validator.isNull(docId))) {
				docId = String.valueOf(CounterLocalServiceUtil.increment());

				for (int i = 0; i < orgIds.length; i++) {
					vdocOrg org = vdocOrgServiceUtil.getOrg(orgIds[i]);
					vdocDORelServiceUtil.addRelation(docId, orgIds[i]);
					orgRels += org.getName() + (i < orgIds.length - 1 ? "," : "");
				}
				
				vdoc = vdocDocumentServiceUtil.addDocument(docId, groupId,
						language, userId, title, content, process, base, time,
						cost, result, require, objects, style, note, promulDate,
						effectivedDate, expiredDate, fieldId, orgRels, fieldRels,
						hasAttachment, typeDoc, communityPermissions,
						guestPermissions, themeDisplay);

			} else {
				vdocDORelServiceUtil.deleteRelByDoc(docId);
				for (int i = 0; i < orgIds.length; i++) {
					vdocOrg org = vdocOrgServiceUtil.getOrg(orgIds[i]);
					vdocDORelServiceUtil.addRelation(docId, orgIds[i]);
					orgRels += org.getName() + (i < orgIds.length - 1 ? "," : "");
				}

				vdoc = vdocDocumentServiceUtil.updateDocument(docId, groupId,
						language, userId, typeDoc, title, content, process, base,
						time, cost, result, require, objects, style, note,
						promulDate, effectivedDate, expiredDate, fieldId, orgRels,
						fieldRels, hasAttachment, typeDoc);
				//System.out.println("UPDATE DOCUMENT+++++++++++++++++++++++++++");
			}

			if (save_approve.equalsIgnoreCase("save-approve")) {

				vdoc.setStatusDoc(vdocDocumentServiceImpl.PUBLISH_PENDING);
				vdoc.setApprovedDate(new Date());
				vdoc.setApprovedByUser(themeDisplay.getUserId());
				//System.out.println("save-approve+++++++++++++++++++++++++++");

				vdocDocumentServiceUtil.updateDocument(vdoc);

			} else if (save_publish.equalsIgnoreCase("save-publish")) {

				vdoc.setStatusDoc(vdocDocumentServiceImpl.PUBLISHED);
				vdoc.setPublishedDate(new Date());
				vdoc.setPublishedByUser(themeDisplay.getUserId());
				//System.out.println("save-publish+++++++++++++++++++++++++++");
				vdocDocumentServiceUtil.updateDocument(vdoc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		String portletId = PortletKeysExt.VDOC;
		FileUploadUtil.uploadFile(req, uploadReq, portletId, vdocDocument.class, Long.parseLong(vdoc.getDocId()), GetterUtil.getLong(0), StringPool.BLANK);
		

		List addedAttachments = AttachmentLocalServiceUtil.getAttachments(
				Long.parseLong(vdoc.getDocId()), vdocDocument.class);

		hasAttachment = ((addedAttachments != null) && (addedAttachments.size() > 0));

		if (hasAttachment) {
			vdoc.setHasAttachment(true);
			vdocDocumentServiceUtil.updateDocument(vdoc);
		}

		res.setRenderParameter("jspPage",
				"/html/portlet/vdoc_manage/view.jsp?tabs1=document-tab");
	}

	/**
	 * 
	 * Approve Document
	 * 
	 */
	public void approveDocument(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException {
		String docId = ParamUtil.getString(req, "docId");
		String[] docIds = StringUtil.split(ParamUtil.get(req, "allRowIds",
				StringPool.BLANK));
		long userId = PortalUtil.getUserId(req);

		if (Validator.isNotNull(docId)) {
			vdocDocument doc = vdocDocumentServiceUtil.getDocument(docId);
			doc.setApprovedByUser(userId);
			doc.setApprovedDate(new Date());
			doc.setStatusDoc(PUBLISH_PENDING);
			vdocDocumentServiceUtil.updateDocument(doc);
			res.setRenderParameter("jspPage",
					"/html/portlet/vdoc_manage/view.jsp?tabs1=document-tab");
		} else {
			for (int i = 0; i < docIds.length; i++) {
				vdocDocument doc = vdocDocumentServiceUtil
						.getDocument(docIds[i]);
				doc.setApprovedByUser(userId);
				doc.setApprovedDate(new Date());
				doc.setStatusDoc(PUBLISH_PENDING);
				vdocDocumentServiceUtil.updateDocument(doc);
			}
		}
	}

	/**
	 * 
	 * Publish Document
	 * 
	 */
	public void publishDocument(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException {
		String docId = ParamUtil.getString(req, "docId");
		String[] docIds = StringUtil.split(ParamUtil.get(req, "allRowIds",
				StringPool.BLANK));
		long userId = PortalUtil.getUserId(req);

		if (Validator.isNotNull(docId)) {
			vdocDocument doc = vdocDocumentServiceUtil.getDocument(docId);
			doc.setPublishedByUser(userId);
			doc.setPublishedDate(new Date());
			doc.setStatusDoc(PUBLISHED);
			vdocDocumentServiceUtil.updateDocument(doc);
			res.setRenderParameter("jspPage",
					"/html/portlet/vdoc_manage/view.jsp?tabs1=document-tab&tabs2=approved");
		} else {
			for (int i = 0; i < docIds.length; i++) {
				vdocDocument doc = vdocDocumentServiceUtil
						.getDocument(docIds[i]);
				doc.setPublishedByUser(userId);
				doc.setPublishedDate(new Date());
				doc.setStatusDoc(PUBLISHED);
				vdocDocumentServiceUtil.updateDocument(doc);
			}
		}
	}

	/**
	 * Cancel Approve Publish Document
	 * 
	 */
	public void cancelApprovePublish(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException {
		String docId = ParamUtil.getString(req, "docId");
		String url = "";

		if (Validator.isNotNull(docId)) {
			vdocDocument doc = vdocDocumentServiceUtil.getDocument(docId);
			if (doc.getStatusDoc() == PUBLISH_PENDING) {
				doc.setApprovedByUser(0);
				doc.setApprovedDate(null);
				doc.setStatusDoc(APPROVAL_PENDING);
				url = "/html/portlet/vdoc_manage/view.jsp?tabs1=document-tab&tabs2=approved";
			} else if (doc.getStatusDoc() == PUBLISHED) {
				doc.setPublishedByUser(0);
				doc.setPublishedDate(null);
				doc.setStatusDoc(PUBLISH_PENDING);
				url = "/html/portlet/vdoc_manage/view.jsp?tabs1=document-tab&tabs2=published";
			}
			vdocDocumentServiceUtil.updateDocument(doc);
			res.setRenderParameter("jspPage", url);
		}
	}

	public void deleteDocument(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException, RemoteException {
		String docId = ParamUtil.getString(req, "docId");
		String[] docIds = StringUtil.split(ParamUtil.get(req, "allRowIds",
				StringPool.BLANK));

		if (Validator.isNotNull(docId)) {
			String url1 = "";
			vdocDocument doc = vdocDocumentServiceUtil.getDocument(docId);
			if (doc.getStatusDoc() == APPROVAL_PENDING) {
				url1 = "/html/portlet/vdoc_manage/view.jsp?tabs1=document-tab";
			} else if (doc.getStatusDoc() == PUBLISH_PENDING) {
				url1 = "/html/portlet/vdoc_manage/view.jsp?tabs1=document-tab&tabs2=approved";
			}
			vdocDocumentServiceUtil.deleteDocument(doc);
			res.setRenderParameter("jspPage", url1);
		} else {
			// Delete Documentss
			for (int i = 0; i < docIds.length; i++) {
				vdocDocument doc = vdocDocumentServiceUtil
						.getDocument(docIds[i]);
				vdocDocumentServiceUtil.deleteDocument(doc);
			}
		}
	}

	public void searchDoc(ActionRequest req, ActionResponse res) {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		String language = themeDisplay.getLanguageId();
		//System.out.println("GroupId: " + groupId + "Language : " + language);
		//System.out.println("Search Doc Method++++++++++++++++++++++++++++");

		List<vdocDocument> listVdoc = vdocDocumentServiceUtil
				.searchDocument(groupId, language, "105", "101", "Test TV", 2);
		for (vdocDocument doc : listVdoc) {
			System.out.println("Title : " + doc.getTitle());
		}
	}

	public void updateOrgPosition(ActionRequest req, ActionResponse res)
			throws Exception {

		String orgId = null;
		int position = 0;
		String compoundParam = ParamUtil.getString(req, "position");
		long userId = ParamUtil.getLong(req, "userId");

		if (Validator.isNotNull(compoundParam)
				&& (compoundParam.indexOf("|") > 0)) {
			String[] cpIds = StringUtil.split(compoundParam, "|");

			position = Integer.parseInt(cpIds[0]);
			orgId = cpIds[1];
		}

		if (Validator.isNull(orgId)) {
			return;
		}

		vdocOrg org = vdocOrgServiceUtil.getOrg(orgId);

		if (org != null) {
			org.setPosition(position);

			vdocOrgServiceUtil.updateOrg(org, userId);

		}

	}

	public void EditConfigurationAction(ActionRequest req, ActionResponse res)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		String groupId = String.valueOf(layout.getGroupId());

		long companyId = PortalUtil.getCompanyId(req);

		boolean displayGeneralTab = ParamUtil.getBoolean(req,
				"displayGeneralTab");

		boolean displayLogTab = ParamUtil.getBoolean(req, "displayLogTab");

		int numberFile = ParamUtil.getInteger(req, "numberFile");

		PortletPreferences prefs = req.getPreferences();

		prefs.setValue(PropsUtilExt.VDOC_DOCUMENT_MAX_ATTACHMENT,
				String.valueOf(numberFile));

		prefs.setValue("displayLogTab", String.valueOf(displayLogTab));

		prefs.setValue("displayGeneralTab", String.valueOf(displayGeneralTab));
		prefs.setValue("numberFile", String.valueOf(numberFile));
		prefs.store();
	}

	public void setReportByDate(int y, int x, HSSFSheet sheet, HSSFWorkbook wb,
			long groupId, String language, int statusId, Date dateFrom,
			Date dateTo) throws Exception {
		List listnew = new ArrayList();
		listnew = vdocDocumentServiceUtil.getDocbyModifyDate(groupId,
				language, dateFrom, dateTo, statusId);
		HSSFRow row;
		HSSFCell cell;
		sheet.shiftRows(sheet.getLastRowNum(), y, 1);
		row = sheet.createRow(y - 2);
		ReportUtil.createCellNoBorder(
				row,
				(short) (x + 1),
				" T\u1eeb ng\u00e0y " + ActionUtil.dateParser(dateFrom)
						+ " \u0111\u1ebfn ng\u00e0y "
						+ ActionUtil.dateParser(dateTo), wb);

		row = sheet.createRow(y);

		ReportUtil.createCellBold(row, (short) (x), "S\u1ed1 TT", wb);
		ReportUtil.createCellBold(row, (short) (x + 1),
				"Ti\u00eau \u0111\u1ec1", wb);
		ReportUtil.createCellBold(row, (short) (x + 2),
				"Nga\u0300y xu\u00E2\u0301t ba\u0309n", wb);
		ReportUtil.createCellBold(row, (short) (x + 3),
				"Nga\u0300y chi\u0309nh s\u01B0\u0309a", wb);
		ReportUtil.createCellBold(row, (short) (x + 4),
				"Ng\u01B0\u01A1\u0300i duy\u00EA\u0323t", wb);
		ReportUtil.createCellBold(row, (short) (x + 5),
				"Ng\u01B0\u01A1\u0300i chi\u0309nh s\u01B0\u0309a", wb);
		ReportUtil.createCellBold(row, (short) (x + 6),
				"\u0110\u01A1n vi\u0323", wb);
		int stt = 0;
		for (int j = 0; j < listnew.size(); j++) {
			// VcmsArticle vcmsAr = (VcmsArticle) listNews.get(j);
			vdocDocument vdoc = (vdocDocument) listnew.get(j);

			sheet.shiftRows(y + 1, sheet.getLastRowNum(), 1);
			row = sheet.createRow(1 + y++);

			if (vdoc != null) {
				ReportUtil.createCell(row, (short) (x), ++stt, wb);
				ReportUtil.createCellAlignLeft(row, (short) (x + 1),
						"" + vdoc.getTitle() + "", wb);
				ReportUtil.createCell(row, (short) (x + 2),
						ActionUtil.dateParser(vdoc.getPublishedDate()), wb);

				try {
					// User userCreate =
					// UserServiceUtil.getUserById(vdoc.getCreatedByUser());
					ReportUtil.createCellAlignLeft(row, (short) (x + 3),
							ActionUtil.dateParser(vdoc.getModifiedDate()), wb);
				} catch (Exception ex) {
					ReportUtil.createCellAlignLeft(row, (short) (x + 3),
							"Ng&#224;y ch&#7881;nh s&#7917;a", wb);
				}

				try {
					User modifieddUser = UserServiceUtil.getUserById(vdoc
							.getPublishedByUser());
					ReportUtil.createCellAlignLeft(row, (short) (x + 4),
							modifieddUser.getFullName(), wb);
				} catch (Exception ex) {
					ReportUtil.createCellAlignLeft(row, (short) (x + 4),
							"Ng\u01B0\u01A1\u0300i duy\u00EA\u0323t", wb);
				}

				try {
					User publishedUser = UserServiceUtil.getUserById(vdoc
							.getModifiedByUser());
					ReportUtil.createCellAlignLeft(row, (short) (x + 5),
							publishedUser.getFullName(), wb);
				} catch (Exception ex) {
					ReportUtil.createCellAlignLeft(row, (short) (x + 5),
							"Ng\u01B0\u01A1\u0300i chi\u0309nh s\u01B0\u0309a",
							wb);
				}
				try {

					ReportUtil.createCellAlignLeft(row, (short) (x + 6),
							vdoc.getOrgRels(), wb);
				} catch (Exception ex) {
					ReportUtil.createCellAlignLeft(row, (short) (x + 6),
							"\u0110\u01A1n vi\u0323", wb);
				}

			}

		}

		row = sheet.createRow(y + 2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),
				"T\u1ed5ng s\u1ed1 b\u00e0i vi\u1ebft", wb);
		ReportUtil.createCellNoBorder(row, (short) (x + 2),
				String.valueOf(listnew.size()), wb);

		FileOutputStream fileOut = null;
		String porttalDir = PortalUtil.getPortalWebDir();
		try {
			fileOut = new FileOutputStream(
					porttalDir.substring(0, porttalDir.indexOf("ROOT"))
							+ "//VDoc-portlet//html//vdoc_manage//statistics//file//reportByDate.xls");
			wb.write(fileOut);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			fileOut.flush();
			fileOut.close();
		}
	}

	public void setReportByOrg(int y, int x, HSSFSheet sheet, HSSFWorkbook wb,
			long groupId, String language, int statusId) throws Exception {
		List listnew = new ArrayList();
		listnew = vdocOrgServiceUtil.getOrgByG_L(groupId, language);
		HSSFRow row;
		HSSFCell cell;
		sheet.shiftRows(sheet.getLastRowNum(), y, 1);
		row = sheet.createRow(y - 2);
		row = sheet.createRow(y);

		ReportUtil.createCellBold(row, (short) (x), "S\u1ed1 TT", wb);
		ReportUtil.createCellBold(row, (short) (x + 1),
				"C\u01A1 quan - \u0110\u01A1n vi\u0323", wb);
		ReportUtil.createCellBold(row, (short) (x + 2),
				"Ch\u01A1\u0300 xu\u00E2\u0301t ba\u0309n", wb);
		ReportUtil.createCellBold(row, (short) (x + 3),
				"\u0110a\u0303 xu\u00E2\u0301t ba\u0309n", wb);
		ReportUtil.createCellBold(row, (short) (x + 4),
				"Chi\u0309nh s\u01B0\u0309a", wb);
		int stt = 0;
		for (int j = 0; j < listnew.size(); j++) {
			// VcmsArticle vcmsAr = (VcmsArticle) listNews.get(j);
			vdocOrg org = (vdocOrg) listnew.get(j);

			sheet.shiftRows(y + 1, sheet.getLastRowNum(), 1);
			row = sheet.createRow(1 + y++);

			if (org != null) {
				ReportUtil.createCell(row, (short) (x), ++stt, wb);
				ReportUtil.createCellAlignLeft(row, (short) (x + 1),
						"" + org.getName() + "", wb);
				ReportUtil.createCell(row, (short) (x + 2),
						vdocDORelServiceUtil.countCategory_approving(org
								.getOrgId()), wb);

				try {
					// User userCreate =
					// UserServiceUtil.getUserById(vdoc.getCreatedByUser());
					ReportUtil.createCellAlignLeft(row, (short) (x + 3), String
							.valueOf(vdocDORelServiceUtil
									.countCategory_approving(org.getOrgId())),
							wb);
				} catch (Exception ex) {
					ReportUtil.createCellAlignLeft(row, (short) (x + 3), "...",
							wb);
				}

				try {

					ReportUtil.createCellAlignLeft(row, (short) (x + 4), String
							.valueOf(vdocDORelServiceUtil
									.countCategory_approving(org.getOrgId())),
							wb);
				} catch (Exception ex) {
					ReportUtil.createCellAlignLeft(row, (short) (x + 4), "...",
							wb);
				}

			}

		}

		FileOutputStream fileOut = null;
		String porttalDir = PortalUtil.getPortalWebDir();
		try {
			fileOut = new FileOutputStream(
					porttalDir.substring(0, porttalDir.indexOf("ROOT"))
							+ "//VDoc-portlet//html//vdoc_manage//statistics//file//reportByOrg.xls");
			wb.write(fileOut);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			fileOut.flush();
			fileOut.close();
		}
	}

	public void getFile(HttpServletRequest request,
			HttpServletResponse response, String strDir, String cmd)
			throws Exception {
		InputStream is = null;
		try {
			is = new FileInputStream(PortalUtil.getPortalWebDir().substring(0,
					PortalUtil.getPortalWebDir().lastIndexOf("ROOT"))
					+ strDir);
			byte[] bytes = IOUtils.toByteArray(is);
			String contentType = MimeTypesUtil.getContentType(PortalUtil
					.getPortalWebDir().substring(0,
							PortalUtil.getPortalWebDir().lastIndexOf("ROOT"))
					+ strDir);
			if (cmd.equals("reportBydate")) {
				ServletResponseUtil.sendFile(request, response,
						"reportByDate.xls", bytes, contentType);
			} else {
				ServletResponseUtil.sendFile(request, response,
						"reportByOrg.xls", bytes, contentType);
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			is.close();
		}
	}

	public void exportToExcel(ActionRequest request, ActionResponse response)
			throws IOException {
		int fromDay = ParamUtil.getInteger(request, "fromDay");
		int fromMonth = ParamUtil.getInteger(request, "fromMonth");
		int fromYear = ParamUtil.getInteger(request, "fromYear");
		String cmd = ParamUtil.getString(request, "cmd");
		int toDay = ParamUtil.getInteger(request, "toDay");
		int toMonth = ParamUtil.getInteger(request, "toMonth");
		int toYear = ParamUtil.getInteger(request, "toYear");

		long groupId = ParamUtil.getLong(request, "groupId");
		String byUser = ParamUtil.getString(request, "byUser");

		Date dateFrom = new GregorianCalendar(fromYear, fromMonth, fromDay)
				.getTime();
		Date dateTo = new GregorianCalendar(toYear, toMonth, toDay).getTime();

		String language = ParamUtil.getString(request, "language");
		String parentId = ParamUtil.getString(request, "parentId");

		long statusId = ParamUtil.getLong(request, "statusId", 2);
		long typeId = ParamUtil.getLong(request, "byType");

		int begin = ParamUtil.getInteger(request, "begin");
		int end = ParamUtil.getInteger(request, "end");

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long companyId = layout.getCompanyId();
		FileInputStream fis = null;
		String porttalDir = PortalUtil.getPortalWebDir();
		if (cmd.equals("reportBydate")) {
			try {

				fis = new FileInputStream(
						porttalDir.substring(0, porttalDir.indexOf("ROOT"))
								+ "//VDoc-portlet//html//vdoc_manage//statistics//file//reportByDateTemplate.xls");

				POIFSFileSystem fs = new POIFSFileSystem(fis);
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				// wb.createSheet();
				HSSFSheet sheet = wb.getSheetAt(0);

				setReportByDate(7, 0, sheet, wb, groupId, language,
						(int) statusId, dateFrom, dateTo);
				String strDir = "//VDoc-portlet//html//vdoc_manage//statistics//file//reportByDate.xls";
				getFile(PortalUtil.getHttpServletRequest(request),
						PortalUtil.getHttpServletResponse(response), strDir,
						cmd);
			} catch (Exception ex) {
				ex.toString();
			} finally {
				fis.close();
			}
		} else {
			fis = new FileInputStream(
					porttalDir.substring(0, porttalDir.indexOf("ROOT"))
							+ "//VDoc-portlet//html//vdoc_manage//statistics//file//reportByOrgTemplate.xls");

			POIFSFileSystem fs = new POIFSFileSystem(fis);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			// wb.createSheet();
			HSSFSheet sheet = wb.getSheetAt(0);

			try {
				setReportByOrg(7, 0, sheet, wb, groupId, language,
						(int) statusId);
				String strDir = "//VDoc-portlet//html//vdoc_manage//statistics//file//reportByOrg.xls";
				getFile(PortalUtil.getHttpServletRequest(request),
						PortalUtil.getHttpServletResponse(response), strDir,
						cmd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	public void updateDocumentPosition(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
	
		String positionId = ParamUtil.getString(req, "Selectposition");
		int position = 0;
		String docId = null;
		

		if (Validator.isNotNull(positionId)
				&& (positionId.indexOf("|") > 0)) {
			String[] cpIds = StringUtil.split(positionId, "|");

			 position = Integer.parseInt(cpIds[0]);
			 docId = cpIds[1];
		}
		vdocDocument vdoc = vdocDocumentServiceUtil.getDocument(docId);
		List<vdocDocument> listVdoc = vdocDocumentServiceUtil.getAllDoc();
		//set lai vi tri
		for(int i=0;i<listVdoc.size();i++)
		{
			vdocDocument vdoc1 = (vdocDocument)listVdoc.get(i);
			if(vdoc1.getPosition()==position){
				
				
				try {
					vdocDocumentServiceUtil.updateDocument(vdoc1.getDocId(), vdoc.getPosition());
					
					vdocDocumentServiceUtil.updateDocument(docId,position);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.print(e);
				}
				
				
				
			}
		}
		
		
		
	
		
	
//		res.setRenderParameter("jspPage", "/html/portlet/vdoc_manage/view.jsp?tabs1=document-tab&tabs2=portlet.vdoc.information-tab.published");
	}


}
