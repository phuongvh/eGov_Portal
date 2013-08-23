package com.vportal.portlet.edirectory.action;

import java.io.File;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portal.attachment.AttachmentManager;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.edirectory.DepartmentEmployeeInvalidException;
import com.vportal.portlet.edirectory.NoSuchEDEmployeeException;
import com.vportal.portlet.edirectory.model.EDDepartment;
import com.vportal.portlet.edirectory.model.EDEmployee;
import com.vportal.portlet.edirectory.model.EDFunction;
import com.vportal.portlet.edirectory.model.EDFunctionEmployee;
import com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil;
import com.vportal.portlet.edirectory.service.EDEmployeeLocalServiceUtil;
import com.vportal.portlet.edirectory.service.EDFunctionEmployeeLocalServiceUtil;
import com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil;
import com.vportal.portlet.edirectory.util.WebKeysExt;

/**
 * Portlet implementation class ViewAction
 */
public class ManageEDirectory extends MVCPortlet {
	/**
	 * Thêm đơn vị
	 * 
	 * @param req
	 * @param res
	 * @throws PortalException
	 * @throws SystemException
	 * @throws RemoteException
	 */
	/**
	 * Copyright (c) Vietsoftware, Inc. All rights reserved.
	 * 
	 * This library is free software; you can redistribute it and/or modify it
	 * under the terms of the GNU Lesser General Public License as published by
	 * the Free Software Foundation; either version 2.1 of the License, or (at
	 * your option) any later version.
	 * 
	 * This library is distributed in the hope that it will be useful, but
	 * WITHOUT ANY WARRANTY; without even the implied warranty of
	 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
	 * General Public License for more details.
	 */
	public void addDepartment(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException, RemoteException {
		ThemeDisplay theme = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		EDDepartment dep = ActionUtil.departmentFormRequest(req);
		EDDepartmentLocalServiceUtil.addDepartment(dep, theme.getUserId(),
				theme.getLanguageId(), WebKeysExt.DOMAIN_DIR);

		res.setRenderParameter("jspPage",
				"/html/manage_edirectory/view.jsp?tab1=tab.danhba.donvi");
	}

	/**
	 * Thêm chức vụ
	 * 
	 * @param req
	 * @param res
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void addFunction(ActionRequest req, ActionResponse res)
			throws SystemException, PortalException {
		ThemeDisplay theme = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		// String[] communityPermissions =
		// req.getParameterValues("communityPermissions");
		// String[] guestPermissions =
		// req.getParameterValues("guestPermissions");

		EDFunction func = ActionUtil.functionFormRequest(req);
		EDFunctionLocalServiceUtil.addFunction(func, theme.getUserId(),
				theme.getLanguageId());
		// EDFunctionServiceUtil.addFunction(func, theme.getLanguageId(),
		// theme.getUserId(), theme.getPlid(),
		// null, null, communityPermissions, guestPermissions);
		// EDFunctionLocalServiceUtil.addFunction(func, theme.getUserId(),
		// theme.getLanguageId());
		res.setRenderParameter("jspPage",
				"/html/manage_edirectory/view.jsp?tab1=tab.danhba.chucvu");
	}

	/**
	 * Thêm cán bộ
	 * 
	 * @param req
	 * @param res
	 * @throws Exception
	 */
	public void addEmployee(ActionRequest req, ActionResponse res)
			throws Exception {
		EDEmployee employee = ActionUtil.edEmployeeFormRequest(req);

		// String portletId = WebKeysExt.EDIR;
		// AttachmentManager am = new AttachmentManager(portletId,
		// EDEmployee.class, employee.getId());
		// IGImage image = am.addImage(req);
		// if(image != null){
		// EDEmployeeLocalServiceUtil.addImage(employee.getId(),
		// Long.toString(image.getLargeImageId()));
		// }
		// FileUploadUtil.uploadImage(arg0, arg1, arg2, arg3, arg4, arg5)
		res.setRenderParameter("jspPage",
				"/html/manage_edirectory/view.jsp?tab1=tab.danhba.canbo");

	}

	/**
	 * Cập nhập thông tin đơn vị
	 * 
	 * @param req
	 * @param res
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void updateDepartment(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException {
		long depId = ParamUtil.getLong(req, "depId");
		EDDepartment dep = EDDepartmentLocalServiceUtil.getEDDepartment(depId);

		dep.setName(ParamUtil.getString(req, "name"));
		dep.setParent(ParamUtil.getLong(req, "parentId"));
		dep.setLevelEd(ParamUtil.getInteger(req, "level"));
		dep.setPhone(ParamUtil.getString(req, "phone"));
		dep.setFax(ParamUtil.getString(req, "fax"));
		dep.setEmail(ParamUtil.getString(req, "email"));
		dep.setWebsite(ParamUtil.getString(req, "website"));
		dep.setAddress(ParamUtil.getString(req, "address"));
		dep.setDescription(ParamUtil.getString(req, "description"));

		EDDepartmentLocalServiceUtil.updateEDDepartment(dep);
		res.setRenderParameter("jspPage",
				"/html/manage_edirectory/view.jsp?tab1=tab.danhba.donvi");

	}

	/**
	 * Cập nhập thông tin chức vụ
	 * 
	 * @param req
	 * @param res
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void updateFunction(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException {
		ThemeDisplay theme = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long funcId = ParamUtil.getLong(req, "funcId");
		EDFunction func = EDFunctionLocalServiceUtil.getEDFunction(funcId);

		func.setName(ParamUtil.getString(req, "name"));
		func.setDescription(ParamUtil.getString(req, "description"));
		func.setLevelEd(ParamUtil.getInteger(req, "level"));
		func.setIsShowTree(ParamUtil.getBoolean(req, "show"));
		func.setLanguageId(theme.getLanguageId());
		func.setGroupId(theme.getLayout().getGroupId());
		func.setUserId(theme.getUserId());

		EDFunctionLocalServiceUtil.updateEDFunction(func);
		res.setRenderParameter("jspPage",
				"/html/manage_edirectory/view.jsp?tab1=tab.danhba.chucvu");
	}

	/**
	 * Cập nhập thông tin cán bộ
	 * 
	 * @param req
	 * @param res
	 * @throws Exception
	 */
	public void updateEmployee(ActionRequest req, ActionResponse res)
			throws Exception {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		long employeeId = ParamUtil.getLong(uploadReq, "employeeId");
		ThemeDisplay theme = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = theme.getLayout();

		EDEmployee employee = EDEmployeeLocalServiceUtil
				.getEDEmployee(employeeId);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// Set it for employee
		employee.setGroupId(layout.getGroupId());
		employee.setCompanyId(theme.getCompanyId());
		employee.setUserId(theme.getUserId());
		employee.setLanguageId(theme.getLanguageId());

		employee.setName(uploadReq.getParameter("name"));
		employee.setTitle(uploadReq.getParameter("title"));
		employee.setSex(uploadReq.getParameter("sex"));

		// Ngay sinh
		String sDateDOB = uploadReq.getParameter("dayDOB") + "/"
				+ uploadReq.getParameter("monthDOB") + "/"
				+ uploadReq.getParameter("yearDOB");
		// Date dateDOB = dateFormat.parse(sDateDOB);
		employee.setBirthday(dateFormat.parse(sDateDOB));

		// Ngay vao dang
		String sJoinDate = uploadReq.getParameter("dayJoinDate") + "/"
				+ uploadReq.getParameter("monthJoinDate") + "/"
				+ uploadReq.getParameter("yearJoinDate");
		// Date dateJoinDate = dateFormat.parse(sJoinDate);
		employee.setJoinDate(dateFormat.parse(sJoinDate));

		String show = "";
		employee.setHomeSide(uploadReq.getParameter("homeSide"));
		boolean ckhomeSide = ParamUtil.getBoolean(uploadReq, "ckhomeSide",
				false);
		show = Boolean.toString(ckhomeSide);
		employee.setRace(uploadReq.getParameter("race"));
		boolean ckrace = ParamUtil.getBoolean(uploadReq, "ckrace", false);
		show = show + "," + Boolean.toString(ckrace);
		employee.setHome(uploadReq.getParameter("home"));
		boolean ckhone = ParamUtil.get(uploadReq, "ckhome", false);
		show = show + "," + Boolean.toString(ckhone);
		employee.setHomePhone(uploadReq.getParameter("homePhone"));
		boolean ckhomePhone = ParamUtil.getBoolean(uploadReq, "ckhomePhone",
				false);
		show = show + "," + Boolean.toString(ckhomePhone);
		employee.setWorkPhone(uploadReq.getParameter("workPhone"));
		boolean ckworkPhone = ParamUtil.getBoolean(uploadReq, "ckworkPhone",
				false);
		show = show + "," + Boolean.toString(ckworkPhone);
		employee.setMobilePhone(uploadReq.getParameter("mobilePhone"));
		boolean ckmobilePhone = ParamUtil.getBoolean(uploadReq,
				"ckmobilePhone", false);
		show = show + "," + Boolean.toString(ckmobilePhone);
		employee.setEmail(uploadReq.getParameter("email"));
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
		employee.setDepartmentId(departmentId);

		boolean ckdepartmentId = ParamUtil.getBoolean(uploadReq,
				"ckdepartmentId", false);
		show = show + "," + Boolean.toString(ckdepartmentId);
		boolean ckbigPhoto = ParamUtil.getBoolean(uploadReq, "ckbigPhoto",
				false);
		show = show + "," + Boolean.toString(ckbigPhoto);
		employee.setMajorLevel(uploadReq.getParameter("majorLevel"));
		boolean ckmajorLevel = ParamUtil.getBoolean(uploadReq, "ckmajorLevel",
				false);
		show = show + "," + Boolean.toString(ckmajorLevel);
		employee.setPhilosophism(uploadReq.getParameter("philosophism"));
		boolean ckphilosophism = ParamUtil.getBoolean(uploadReq,
				"ckphilosophism", false);
		show = show + "," + Boolean.toString(ckphilosophism);
		employee.setFamily(uploadReq.getParameter("family"));
		boolean ckfamily = ParamUtil.getBoolean(uploadReq, "ckfamily", false);
		show = show + "," + Boolean.toString(ckfamily);
		employee.setForeignLanguage(uploadReq.getParameter("foreignLanguage"));
		boolean ckforeignLanguage = ParamUtil.getBoolean(uploadReq,
				"ckforeignLanguage", false);
		show = show + "," + Boolean.toString(ckforeignLanguage);
		boolean ckjoinDate = ParamUtil.getBoolean(uploadReq, "ckjoinDate",
				false);
		show = show + "," + Boolean.toString(ckjoinDate);

		employee.setShow(show);
		employee.setIsShowTree(ParamUtil.getBoolean(uploadReq, "isShowTree"));
		employee.setOtherInfo(uploadReq.getParameter("otherInfo"));
		employee.setDisplayOrder(ParamUtil.getLong(uploadReq, "order"));

		// upload image
		// String imageUrl = "";
		// String realPath =
		// req.getPortletSession().getPortletContext().getRealPath("/");
		// String sourceFileName = null;
		// byte[] bytes = null;
		// String image = uploadReq.getFileName("bigPhoto");
		// System.out.println("RealPath"+realPath);
		// if(Validator.isNotNull(image)){
		// String imageKey = "";
		// try{
		// sourceFileName =uploadReq.getFileName("bigPhoto");
		// System.out.println("File name :" + sourceFileName);
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
		// if(employee.getImage() != null){
		// File file = new
		// File(req.getPortletSession().getPortletContext().getRealPath("/") +
		// employee.getImage());
		// file.delete();
		// }
		// employee.setImage(imageUrl);
		// }else if(employee.getImage() != null){
		// employee.setImage(employee.getImage());
		// }
		//

		// UPLOAD IMAGE USE VPORTAL TAG : 18/05/2013 - hailn
		String attached = ParamUtil.getString(uploadReq, "attached");

		if (attached.equals("1")) {
			String portletId = PortletKeysExt.EDIR;
			AttachmentManager am = new AttachmentManager(portletId,
					EDEmployee.class, employee.getId());
			am.deleteFileEntries();

		}
		/*
		 * FileUploadUtil.uploadFile(req, uploadReq, portletId,
		 * EDEmployee.class,Long.valueOf(employee.getId())); List images =
		 * AttachmentLocalServiceUtil
		 * .getAttachments(Long.valueOf(employee.getId()), EDEmployee.class) ;
		 * if(images.size()>0){ Attachment imageAttch = (Attachment)
		 * images.get(0);
		 * employee.setImage(String.valueOf(imageAttch.getFileEntryId())); }
		 */

		ActionUtil._attachFile(employee, req, uploadReq);
		// END CODE BY HAILN
		// EDEmployeeLocalServiceUtil.updateEDEmployee(employee);
		EDEmployeeLocalServiceUtil.addFunctionToEmployee(employee.getId(),
				functionIds);
	}

	/**
	 * Xóa đơn vị
	 * 
	 * @param req
	 * @param res
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteDepartment(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException {
		long depId = ParamUtil.getLong(req, "resourcePrimKey");
		EDDepartment dep = EDDepartmentLocalServiceUtil.getEDDepartment(depId);
		List<EDDepartment> depList = EDDepartmentLocalServiceUtil
				.getByParent(dep.getId());
		List<EDEmployee> employeeList = EDEmployeeLocalServiceUtil
				.getByDepartmentId(dep.getId());
		if ((!depList.isEmpty()) || (!employeeList.isEmpty())) {
			SessionErrors.add(req, "do-not-delete-department");
		} else {
			EDDepartmentLocalServiceUtil.deleteDepartment(dep);
			SessionMessages.add(req, "Xóa thành công");
		}
		res.setRenderParameter("jspPage",
				"/html/manage_edirectory/view.jsp?tab1=tab.danhba.donvi");
	}

	/**
	 * Xóa chức vụ
	 * 
	 * @param req
	 * @param res
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void deleteFunction(ActionRequest req, ActionResponse res)
			throws SystemException, PortalException {
		long funcId = ParamUtil.getLong(req, "resourcePrimKey");
		EDFunction function = EDFunctionLocalServiceUtil.getEDFunction(funcId);
		List<EDFunctionEmployee> edFunctionEmployeeList = EDFunctionEmployeeLocalServiceUtil
				.getByFunctionId(funcId);
		if (!edFunctionEmployeeList.isEmpty()) {
			SessionErrors.add(req, "Không xóa được đơn vị");
			return;
		} else {
			EDFunctionLocalServiceUtil.deleteFunction(function);
			SessionMessages.add(req, "Xóa thành công");
		}
		res.setRenderParameter("jspPage",
				"/html/manage_edirectory/view.jsp?tab1=tab.danhba.chucvu");
	}

	/**
	 * Tìm kiếm
	 * 
	 * @param req
	 * @param res
	 * @throws SystemException
	 * @throws NoSuchEDEmployeeException
	 */
	public void searchEmployee(ActionRequest req, ActionResponse res)
			throws SystemException, NoSuchEDEmployeeException {

		ThemeDisplay theme = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = theme.getScopeGroupId();
		String language = theme.getLanguageId();

		// //Get data to search form search
		long departmentId = ParamUtil.getLong(req, "departmentId");
		long functionId = ParamUtil.getLong(req, "functionId");
		String name = ParamUtil.getString(req, "name");

		// List to contains results search
		List<EDEmployee> employeeList = new ArrayList<EDEmployee>();
		employeeList = EDEmployeeLocalServiceUtil.searchEmployeeByParams(
				groupId, language, name, departmentId, functionId);

		req.setAttribute("employeeList", employeeList);
		req.setAttribute("departmentId", departmentId);
		req.setAttribute("name", name);
		res.setRenderParameter("jspPage",
				"/html/manage_edirectory/view.jsp?tab1=tab.danhba.canbo");
	}

	/**
	 * Xóa cán bộ bằng check box
	 * 
	 * @param req
	 * @param res
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void deleteEmployee(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException {
		long employeeId = ParamUtil.getLong(req, "employeeId");

		if (employeeId > 0) {
			EDEmployee employee = EDEmployeeLocalServiceUtil
					.getById(employeeId);
			File file = new File(req.getPortletSession().getPortletContext()
					.getRealPath("/")
					+ employee.getImage());
			file.delete();

			EDEmployeeLocalServiceUtil.delelteEmployee(employeeId);
		}

		String[] employeeIds = StringUtil.split(ParamUtil.get(req, "allRowIds",
				StringPool.BLANK));

		if ((employeeIds == null) || (employeeIds.length <= 0)) {
			return;
		}

		for (int i = 0; i < employeeIds.length; i++) {
			try {

				EDEmployee employee = EDEmployeeLocalServiceUtil.getById(Long
						.valueOf(employeeIds[i]));
				File file = new File(req.getPortletSession()
						.getPortletContext().getRealPath("/")
						+ employee.getImage());
				file.delete();
				EDEmployeeLocalServiceUtil.deleteEDEmployee(Long
						.valueOf(employeeIds[i]));
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		res.setRenderParameter("jspPage",
				"/html/manage_edirectory/view.jsp?tab1=tab.danhba.canbo");
	}

	public void searchEmployeeByParams(ActionRequest req, ActionResponse res)
			throws SystemException {

		List<EDEmployee> employeeList = EDEmployeeLocalServiceUtil
				.searchEmployeeByParams(10157, "vi_VN", 0, "cua");

		for (EDEmployee employee : employeeList) {
			System.out.println("Name Employee: " + employee.getName());
		}
	}

	public void updateBranchPosition(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException {
		long departmentId = ParamUtil.getLong(req, "departmentId");
		long chucvuId = ParamUtil.getLong(req, "functionId");
		String positionId = ParamUtil.getString(req, "Selectposition");
		int position = 0;
		long employeeId = 0;

		if (Validator.isNotNull(positionId) && (positionId.indexOf("|") > 0)) {
			String[] cpIds = StringUtil.split(positionId, "|");

			position = Integer.parseInt(cpIds[0]);
			employeeId = Long.parseLong(cpIds[1]);
		}
		EDEmployee empolyee = EDEmployeeLocalServiceUtil
				.getEDEmployee(employeeId);
		List<EDEmployee> listEmpolyee = EDEmployeeLocalServiceUtil
				.getByDepartmentId(empolyee.getDepartmentId());
		// set lai vi tri
		for (int i = 0; i < listEmpolyee.size(); i++) {
			EDEmployee Empolyee = (EDEmployee) listEmpolyee.get(i);
			if (Empolyee.getDisplayOrder() == position) {
				Empolyee.setDisplayOrder(empolyee.getDisplayOrder());
				EDEmployeeLocalServiceUtil.updateEDEmployee(Empolyee);
			}
		}
		empolyee.setDisplayOrder(position);
		EDEmployeeLocalServiceUtil.updateEDEmployee(empolyee);

		res.setRenderParameter("departmentId", String.valueOf(departmentId));
		res.setRenderParameter("functionId", String.valueOf(chucvuId));
		res.setRenderParameter("position", String.valueOf(position));
		res.setRenderParameter("jspPage",
				"/html/manage_edirectory/view.jsp?tab1=tab.danhba.canbo");
	}
}
