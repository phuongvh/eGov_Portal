package com.vportal.portlet.edirectory.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.vportal.portal.model.Attachment;
import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portal.taglib.FileUploadUtil;
import com.vportal.portlet.edirectory.DepartmentEmployeeInvalidException;
import com.vportal.portlet.edirectory.model.EDDepartment;
import com.vportal.portlet.edirectory.model.EDEmployee;
import com.vportal.portlet.edirectory.model.EDFunction;
import com.vportal.portlet.edirectory.model.impl.EDDepartmentImpl;
import com.vportal.portlet.edirectory.model.impl.EDEmployeeImpl;
import com.vportal.portlet.edirectory.model.impl.EDFunctionImpl;
import com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil;
import com.vportal.portlet.edirectory.service.EDEmployeeLocalServiceUtil;

public class ActionUtil {
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
	public static EDDepartment departmentFormRequest(ActionRequest actionRequest)
			throws PortalException, SystemException {
		ThemeDisplay theme = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		EDDepartment department = new EDDepartmentImpl();

		// long departmentId = 0l;
		// try {
		// departmentId =
		// CounterLocalServiceUtil.increment(EDDepartment.class.getName());
		// } catch (SystemException e) {
		// e.printStackTrace();
		// }
		//
		// department.setId(departmentId);
		department.setGroupId(theme.getScopeGroupId());
		department.setCompanyId(theme.getCompanyId());
		department.setName(ParamUtil.getString(actionRequest, "name"));
		long parentId = 0l;
		long parentIdForm = ParamUtil.getLong(actionRequest, "parentId");
		if (parentIdForm == 0l) {
			parentId = 0l;
		} else {
			EDDepartment dep = EDDepartmentLocalServiceUtil
					.getEDDepartment(parentIdForm);
			if (dep.getParent() == 0) {
				parentId = dep.getId();
			} else {
				parentId = dep.getParent();
			}
		}
		department.setParent(parentId);

		int level = 0;
		int levelForm = ParamUtil.getInteger(actionRequest, "level");
		if (levelForm == 0) {
			level += 1;
		} else {
			level = levelForm;
		}
		department.setLevelEd(level);
		department.setPhone(ParamUtil.getString(actionRequest, "phone"));
		department.setFax(ParamUtil.getString(actionRequest, "fax"));
		department.setEmail(ParamUtil.getString(actionRequest, "email"));
		department.setWebsite(ParamUtil.getString(actionRequest, "website"));
		department.setAddress(ParamUtil.getString(actionRequest, "address"));
		department.setDescription(ParamUtil.getString(actionRequest,
				"description"));
		department.setCreatedDate(new Date());

		return department;
	}

	public static EDFunction functionFormRequest(ActionRequest req)
			throws SystemException {
		ThemeDisplay theme = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		EDFunction function = new EDFunctionImpl();
		// long functionId = 0l;
		// functionId =
		// CounterLocalServiceUtil.increment(EDFunction.class.getName());

		// function.setId(functionId);
		function.setCompanyId(theme.getCompanyId());
		function.setGroupId(theme.getScopeGroupId());
		function.setName(ParamUtil.getString(req, "name"));
		function.setDescription(ParamUtil.getString(req, "description"));
		int level = 0;
		int levelForm = ParamUtil.getInteger(req, "level");
		if (levelForm == 0) {
			level += 1;
		} else {
			level = levelForm;
		}
		function.setLevelEd(level);
		function.setIsShowTree(ParamUtil.getBoolean(req, "show"));
		function.setCreatedDate(new Date());
		function.setLanguageId(ParamUtil.getString(req, "languageId"));
		return function;
	}

	public static EDEmployee edEmployeeFormRequest(ActionRequest req)
			throws Exception {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		ThemeDisplay theme = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = theme.getLayout();
		EDEmployee employee = new EDEmployeeImpl();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// long employeeId =
		// CounterLocalServiceUtil.increment(EDEmployee.class.getName());
		// Set it for employee
		
		//long groupId = layout.getGroupId();
		long groupId = theme.getPortletGroupId();
		System.out.println("Add----> GroupID: " + groupId);
		long companyId = theme.getCompanyId();
		long userId = theme.getUserId();
		String languageId = theme.getLanguageId();

		String name = uploadReq.getParameter("name");
		String title = uploadReq.getParameter("title");

		// Ngay sinh
		String sDateDOB = uploadReq.getParameter("dayDOB") + "/"
				+ uploadReq.getParameter("monthDOB") + "/"
				+ uploadReq.getParameter("yearDOB");
		Date dateDOB = dateFormat.parse("21/07/1998");

		// Ngay vao dang
		String sJoinDate = uploadReq.getParameter("dayJoinDate") + "/"
				+ uploadReq.getParameter("monthJoinDate") + "/"
				+ uploadReq.getParameter("yearJoinDate");
		Date dateJoinDate = dateFormat.parse("21/07/1998");

		String show = "";
		String homeSide = uploadReq.getParameter("homeSide");
		boolean ckhomeSide = ParamUtil.getBoolean(uploadReq, "ckhomeSide",
				false);
		show = Boolean.toString(ckhomeSide);
		String race = uploadReq.getParameter("race");
		boolean ckrace = ParamUtil.getBoolean(uploadReq, "ckrace", false);
		show = show + "," + Boolean.toString(ckrace);
		String home = uploadReq.getParameter("home");
		boolean ckhone = ParamUtil.get(uploadReq, "ckhome", false);
		show = show + "," + Boolean.toString(ckhone);
		String homePhone = (uploadReq.getParameter("homePhone"));
		boolean ckhomePhone = ParamUtil.getBoolean(uploadReq, "ckhomePhone",
				false);
		show = show + "," + Boolean.toString(ckhomePhone);
		String workPhone = (uploadReq.getParameter("workPhone"));
		boolean ckworkPhone = ParamUtil.getBoolean(uploadReq, "ckworkPhone",
				false);
		show = show + "," + Boolean.toString(ckworkPhone);
		String mobilePhone = (uploadReq.getParameter("mobilePhone"));
		boolean ckmobilePhone = ParamUtil.getBoolean(uploadReq,
				"ckmobilePhone", false);
		show = show + "," + Boolean.toString(ckmobilePhone);
		String email = (uploadReq.getParameter("email"));
		boolean ckemail = ParamUtil.getBoolean(uploadReq, "ckemail", false);
		show = show + "," + Boolean.toString(ckemail);
		// Chuc vu
		String[] strFuncIds = uploadReq.getParameterValues("functionId");
		long[] functionIds = new long[strFuncIds.length];
		for (int i = 0; i < strFuncIds.length; i++) {
			functionIds[i] = Long.parseLong(strFuncIds[i]);
		}
		boolean ckfunctionId = ParamUtil.getBoolean(uploadReq, "ckfunctionId",
				false);
		show = show + "," + Boolean.toString(ckfunctionId);

		long departmentId = ParamUtil.getLong(uploadReq, "departmentId");
		if (Validator.isNull(String.valueOf(departmentId)) || departmentId == 0) {
			throw new DepartmentEmployeeInvalidException();
		}

		boolean ckdepartmentId = ParamUtil.getBoolean(uploadReq,
				"ckdepartmentId", false);
		show = show + "," + Boolean.toString(ckdepartmentId);
		boolean ckbigPhoto = ParamUtil.getBoolean(uploadReq, "ckbigPhoto",
				false);
		show = show + "," + Boolean.toString(ckbigPhoto);
		String majorLevel = (uploadReq.getParameter("majorLevel"));
		boolean ckmajorLevel = ParamUtil.getBoolean(uploadReq, "ckmajorLevel",
				false);
		show = show + "," + Boolean.toString(ckmajorLevel);
		String philosophism = uploadReq.getParameter("philosophism");
		boolean ckphilosophism = ParamUtil.getBoolean(uploadReq,
				"ckphilosophism", false);
		show = show + "," + Boolean.toString(ckphilosophism);
		String family = uploadReq.getParameter("family");
		boolean ckfamily = ParamUtil.getBoolean(uploadReq, "ckfamily", false);
		show = show + "," + Boolean.toString(ckfamily);
		String foreignLanguage = uploadReq.getParameter("foreignLanguage");
		boolean ckforeignLanguage = ParamUtil.getBoolean(uploadReq,
				"ckforeignLanguage", false);
		show = show + "," + Boolean.toString(ckforeignLanguage);
		boolean ckjoinDate = ParamUtil.getBoolean(uploadReq, "ckjoinDate",
				false);
		show = show + "," + Boolean.toString(ckjoinDate);

		boolean isShowTree = ParamUtil.getBoolean(uploadReq, "isShowTree");
		String otherInfo = uploadReq.getParameter("otherInfo");
		long displayOrder = ParamUtil.getLong(uploadReq, "order");
		String sex = uploadReq.getParameter("sex");

		// ======================= OLDER BY SOMEONE======================

		// upload image
		// String imageUrl = "";
		// String imageKey = "";
		// String realPath =
		// req.getPortletSession().getPortletContext().getRealPath("/");
		// String sourceFileName = null;
		// System.out.println("path: " + realPath);
		// byte[] bytes = null;
		// String image = uploadReq.getFileName("bigPhoto");
		// System.out.println("RealPath"+realPath);
		// if(Validator.isNotNull(image)){
		// try{
		// sourceFileName =uploadReq.getFileName("bigPhoto");
		//
		// File file = uploadReq.getFile("bigPhoto");
		// try {
		// bytes = FileUtil.getBytes(file);
		// } catch (IOException e2) {
		// e2.printStackTrace();
		// }
		// File newFile=null;
		//
		// if ((bytes != null) && (bytes.length > 0)) {
		// try {
		// imageKey = employee.getId()
		// + EdirectoryUtil.getRandPrefix();
		// ImageUtilExt.saveOriginalImage(
		// Long.parseLong(imageKey), bytes);
		// System.out.println("File name 1:" + sourceFileName);
		// employee.setImage(imageKey);
		// //
		// //tfImage.setImage(imageKey);
		// newFile = new File(realPath+sourceFileName);
		// FileInputStream fileInputStream = new FileInputStream(file);
		// FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		// fileInputStream.read(bytes);
		// fileOutputStream.write(bytes, 0, bytes.length);
		// fileOutputStream.close();
		// fileInputStream.close();
		// SessionMessages.add(req, "success");
		// }
		// catch (FileNotFoundException e) {
		// System.out.println("File Not Found.");
		// e.printStackTrace();
		// SessionMessages.add(req, "error");
		// }
		// catch (IOException e1){
		// System.out.println("Error Reading The File.");
		// e1.printStackTrace();
		// SessionMessages.add(req, "error");
		// }
		// }
		//
		// } catch (Exception e) {
		// System.out.println("Exception::::"+e.getMessage());
		// SessionMessages.add(req, "error");
		// }
		// imageUrl = imageKey;
		// }
		// END======================= OLDER BY SOMEONE======================

		try {
			// EDEmployeeServiceUtil.updateEmployee(groupId, companyId,
			// String.valueOf(employee.getId()),employee);
			employee = EDEmployeeLocalServiceUtil.addEmployee(title, name,
					dateDOB, sex, homeSide, race, home, homePhone, workPhone,
					mobilePhone, email, functionIds, departmentId, null,
					majorLevel, philosophism, family, foreignLanguage,
					dateJoinDate, otherInfo, isShowTree, displayOrder, show,
					groupId, companyId, userId, languageId);

			// System.out.println("IDEMP: " + employee.getId());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// System.out.println("==================>No File Found");
			e.printStackTrace();
		}

		// UPLOAD IMAGE USE VPORTAL TAG : 18/05/2013 - hailn
		
		String portletId = "EDirectory_WAR_EDirectoryportlet";
		// END CODE BY HAILN
		// FileUploadUtil.uploadFile(req, uploadReq, portletId,
		// EDEmployee.class,
		// Long.valueOf(employee.getId()));
		//List images = AttachmentLocalServiceUtil.getAttachments(Long.valueOf(employee.getId()), EDEmployee.class);
		// //System.out.println("==================>ok men: " + images.size());
		// if(images.size()>0){
		// Attachment imageAttch = (Attachment) images.get(0);
		// if(imageAttch != null)
		// employee.setImage(String.valueOf(imageAttch.getFileEntryId()));
		
		//if(images.size() != 0)
			_attachFile(employee, req, uploadReq);// add 28/05/2013
		// }
		// EDEmployeeLocalServiceUtil.updateEDEmployee(employee,false);

		return employee;
	}

	// Attach File
	public static void _attachFile(EDEmployee empployee, ActionRequest req,
			UploadPortletRequest uploadRequest) throws Exception {

		try {
			if (empployee != null) {

				String portletId = com.vportal.portal.util.PortletKeysExt.EDIR;

				FileUploadUtil.uploadFile(req, uploadRequest, portletId,
						EDEmployee.class, empployee.getId(), 0, portletId);

				List listAttachment = AttachmentLocalServiceUtil
						.getDLFileEntries(EDEmployee.class, empployee.getId());

				for (int i = 0; i < listAttachment.size(); i++) {
					DLFileEntry fileEntry = (DLFileEntry) listAttachment.get(i);

					empployee.setImage(fileEntry.getFolderId() + "/"
							+ fileEntry.getTitle());
					// empployee.setFolderId(fileEntry.getFolderId());
				}

				EDEmployeeLocalServiceUtil.updateEDEmployee(empployee);
			}
		} catch (Exception e) {
		}
	}

	public static String parseDateToString(Date myDate) {
		if (myDate == null) {
			return "";
		}
		Calendar cal = Calendar.getInstance();
		String date = "";
		cal.setTime(myDate);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		date = day + "/" + month + "/" + year;
		return date;
	}
}
