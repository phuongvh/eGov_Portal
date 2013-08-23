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

package com.vportal.portlet.edirectory.service.impl;

import java.rmi.RemoteException;
import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.edirectory.model.EDEmployee;
import com.vportal.portlet.edirectory.model.EDFunction;
import com.vportal.portlet.edirectory.service.base.EDEmployeeServiceBaseImpl;
import com.vportal.portlet.edirectory.util.ActionKeysExt;

/**
 * The implementation of the e d employee remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.edirectory.service.EDEmployeeService} interface.
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.edirectory.service.base.EDEmployeeServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.EDEmployeeServiceUtil
 */
public class EDEmployeeServiceImpl extends EDEmployeeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.vportal.portlet.edirectory.service.EDEmployeeServiceUtil} to access
	 * the e d employee remote service.
	 */
	// ================================================== Add EDEmployee
	public EDEmployee addEmployee(long groupId, long companyId, long plid,
			String title, String name, Date birthday, String sex,
			String homeSide, String race, String home, String homePhone,
			String workPhone, String mobilePhone, String email,
			long departmentId, String imageUrl, String majorLevel,
			String philosophism, String family, String foreignLanguage,
			Date joinDate, String otherInfo, boolean isShowTree,
			long displayOrder, String show, long userId, String languageId,
			String[] communityPermissions, String[] guestPermissions)
			throws SystemException, RemoteException, PrincipalException,
			com.liferay.portal.kernel.exception.PortalException {

		return addEmployee(groupId, companyId, plid, title, name, birthday,
				sex, homeSide, race, home, homePhone, workPhone, mobilePhone,
				email, departmentId, imageUrl, majorLevel, philosophism,
				family, foreignLanguage, joinDate, otherInfo, isShowTree,
				displayOrder, show, userId, languageId, null, null,
				communityPermissions, guestPermissions);

	}

	public EDEmployee addEmployee(long groupId, long companyId, long plid,
			String title, String name, Date birthday, String sex,
			String homeSide, String race, String home, String homePhone,
			String workPhone, String mobilePhone, String email,
			long departmentId, String imageUrl, String majorLevel,
			String philosophism, String family, String foreignLanguage,
			Date joinDate, String otherInfo, boolean isShowTree,
			long displayOrder, String show, long userId, String languageId,
			Boolean addCommunityPermissions, Boolean addGuestPermissions,
			String[] communityPermissions, String[] guestPermissions)
			throws SystemException, RemoteException, PrincipalException,
			com.liferay.portal.kernel.exception.PortalException {

		// Check quyen han
		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeysExt.EDIR, ActionKeysExt.ADD_EMPLOYEE);

		// Validate du lieu truoc khi store vao db
		// validate(description, expriedDate);

		// Tang id cua can bo len 1
		long employeeId = CounterLocalServiceUtil.increment(EDEmployee.class
				.getName());

		EDEmployee employee = edEmployeePersistence.create(employeeId);

		employee.setGroupId(groupId);
		employee.setCompanyId(companyId);
		employee.setCreatedDate(new Date());
		employee.setTitle(title);
		employee.setName(name);
		employee.setBirthday(birthday);
		employee.setSex(sex);
		employee.setHomeSide(homeSide);
		employee.setRace(race);
		employee.setHome(home);
		employee.setHomePhone(homePhone);
		employee.setWorkPhone(workPhone);
		employee.setMobilePhone(mobilePhone);
		employee.setEmail(email);
		employee.setDepartmentId(departmentId);
		employee.setImage(imageUrl);
		employee.setMajorLevel(majorLevel);
		employee.setPhilosophism(philosophism);
		employee.setFamily(family);
		employee.setForeignLanguage(foreignLanguage);
		employee.setJoinDate(joinDate);
		employee.setOtherInfo(otherInfo);
		employee.setIsShowTree(isShowTree);
		employee.setDisplayOrder(displayOrder);
		employee.setShow(show);
		employee.setUserId(userId);
		employee.setLanguageId(languageId);
		employee.setStatus(0);

		edEmployeePersistence.update(employee, false);

		// Add to common resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addEmployeeResources(employee,
					addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());

		} else {

			addEmployeeResources(employee, communityPermissions,
					guestPermissions);
		}

		return employee;
	}

	// Phan quyen theo user
	public void addEmployeeResources(EDEmployee employee,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws SystemException, PrincipalException,
			com.liferay.portal.kernel.exception.PortalException {

		ResourceLocalServiceUtil.addResources(PortalUtil.getDefaultCompanyId(),
				0, getUserId(), EDEmployee.class.getName(),
				employee.getPrimaryKey(), false, addCommunityPermissions,
				addGuestPermissions);

	}

	// Add id EDEmployee in table EDFunction ????
	public void addEmployeeResources(EDEmployee employee,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		try {
			ResourceLocalServiceUtil.addModelResources(
					PortalUtil.getDefaultCompanyId(), 0, getUserId(),
					EDFunction.class.getName(), employee.getPrimaryKey(),
					communityPermissions, guestPermissions);
		} catch (PrincipalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.liferay.portal.kernel.exception.PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Not validate because all fields in table EDEmployee can not null
	// private void validate(String description, Date expriedDate)
	// throws PortalException, SystemException {
	//
	// Date now = new Date();
	//
	// if (Validator.isNull(description)) {
	// //throw new InvalidItemDescriptionException();
	// }
	//
	// if (Validator.isNotNull(expriedDate)) {
	// if (expriedDate.before(now)) {
	// //throw new ItemExpirationDateException();
	// }
	// }
	//
	// }

	// ================================================== End Add EDEmployee

	// ---------------------------------------------------Update Employee

	public EDEmployee updateEmployee(long employeeId, long groupId,
			long companyId, String name, String title, Date birthday,
			String sex, String homeSide, String race, String home,
			String homePhone, String workPhone, String email,
			long departmentId, String imageUrl, String majorLevel,
			String philosophism, String family, String foreignLanguage,
			Date joinDate, String otherInfo, boolean isShowTree,
			long displayOrder, String show, long userId, String languageId,
			String mobilePhone) throws PortalException, SystemException,
			RemoteException {

		// EDEmployeePermission.check(getPermissionChecker(), itemId,
		// ActionKeysExt.UPDATE);

		// ((PortletPermissionUtil)
		// edEmployeePersistence).check(getPermissionChecker(), itemId,
		// ActionKeysExt.UPDATE);

		// validate(description, expriedDate);

		EDEmployee employee = edEmployeePersistence
				.findByPrimaryKey(employeeId);

		employee.setGroupId(groupId);
		employee.setCompanyId(companyId);
		employee.setCreatedDate(new Date());
		employee.setTitle(title);
		employee.setName(name);
		employee.setBirthday(birthday);
		employee.setSex(sex);
		employee.setHomeSide(homeSide);
		employee.setRace(race);
		employee.setHome(home);
		employee.setHomePhone(homePhone);
		employee.setWorkPhone(workPhone);
		employee.setMobilePhone(mobilePhone);
		employee.setEmail(email);
		employee.setDepartmentId(departmentId);
		employee.setImage(imageUrl); // Path file image
		employee.setMajorLevel(majorLevel);
		employee.setPhilosophism(philosophism);
		employee.setFamily(family);
		employee.setForeignLanguage(foreignLanguage);
		employee.setJoinDate(joinDate);
		employee.setOtherInfo(otherInfo);
		employee.setIsShowTree(isShowTree);
		employee.setDisplayOrder(displayOrder);
		employee.setShow(show);
		employee.setUserId(userId);
		employee.setLanguageId(languageId);
		employee.setStatus(0);

		edEmployeePersistence.update(employee, false);
		return employee;
	}

	public EDEmployee updateEmployee(EDEmployee employee)
			throws PortalException, SystemException, RemoteException {

		return updateEmployee(employee.getId(), employee.getGroupId(),
				employee.getCompanyId(), employee.getName(),
				employee.getTitle(), employee.getBirthday(), employee.getSex(),
				employee.getHomeSide(), employee.getRace(), employee.getHome(),
				employee.getHomePhone(), employee.getWorkPhone(),
				employee.getEmail(), employee.getDepartmentId(),
				employee.getImage(), employee.getMajorLevel(),
				employee.getPhilosophism(), employee.getFamily(),
				employee.getForeignLanguage(), employee.getJoinDate(),
				employee.getOtherInfo(), employee.getIsShowTree(),
				employee.getDisplayOrder(), employee.getShow(),
				employee.getUserId(), employee.getLanguageId(),
				employee.getMobilePhone());
	}

	// update image into database
	public EDEmployee updateEmployee(long groupId, long companyId,
			String employeeId, EDEmployee employee) throws Exception {
		PortletPermissionUtil.check(getPermissionChecker(),
				PortletKeysExt.EDIR, ActionKeysExt.UPDATE);

		EDEmployee emp = edEmployeePersistence.findByPrimaryKey(employee
				.getId());
		if (emp.getImage() != null && !emp.getImage().trim().equals(""))
			emp.setImage(employee.getImage());

		// emp.setModifiedDate(clip.getModifiedDate());
		// emp.setLanguage(clip.getLanguage());
		// emp.setClipTypeId(clip.getClipTypeId());
		// emp.setUrl(clip.getUrl());
		// emp.setName(clip.getName());
		// emp.setTitle(clip.getTitle());
		// if ((clip.getImage() != null) &&
		// (!clip.getImage().trim().equals(""))) {
		// c.setImage(clip.getImage());
		// }
		// c.setTitle(clip.getTitle());
		// if ((clip.getImage() != null) &&
		// (!clip.getImage().trim().equals(""))) {
		// c.setImage(clip.getImage());
		// }
		// c.setDescription(clip.getDescription());

		emp = edEmployeePersistence.update(emp, false);

		return emp;
	}
}