/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.vportal.portlet.edirectory.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EDEmployeeService}.
 * </p>
 *
 * @author    HOAN
 * @see       EDEmployeeService
 * @generated
 */
public class EDEmployeeServiceWrapper implements EDEmployeeService,
	ServiceWrapper<EDEmployeeService> {
	public EDEmployeeServiceWrapper(EDEmployeeService edEmployeeService) {
		_edEmployeeService = edEmployeeService;
	}

	public com.vportal.portlet.edirectory.model.EDEmployee addEmployee(
		long groupId, long companyId, long plid, java.lang.String title,
		java.lang.String name, java.util.Date birthday, java.lang.String sex,
		java.lang.String homeSide, java.lang.String race,
		java.lang.String home, java.lang.String homePhone,
		java.lang.String workPhone, java.lang.String mobilePhone,
		java.lang.String email, long departmentId, java.lang.String imageUrl,
		java.lang.String majorLevel, java.lang.String philosophism,
		java.lang.String family, java.lang.String foreignLanguage,
		java.util.Date joinDate, java.lang.String otherInfo,
		boolean isShowTree, long displayOrder, java.lang.String show,
		long userId, java.lang.String languageId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			java.rmi.RemoteException {
		return _edEmployeeService.addEmployee(groupId, companyId, plid, title,
			name, birthday, sex, homeSide, race, home, homePhone, workPhone,
			mobilePhone, email, departmentId, imageUrl, majorLevel,
			philosophism, family, foreignLanguage, joinDate, otherInfo,
			isShowTree, displayOrder, show, userId, languageId,
			communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee addEmployee(
		long groupId, long companyId, long plid, java.lang.String title,
		java.lang.String name, java.util.Date birthday, java.lang.String sex,
		java.lang.String homeSide, java.lang.String race,
		java.lang.String home, java.lang.String homePhone,
		java.lang.String workPhone, java.lang.String mobilePhone,
		java.lang.String email, long departmentId, java.lang.String imageUrl,
		java.lang.String majorLevel, java.lang.String philosophism,
		java.lang.String family, java.lang.String foreignLanguage,
		java.util.Date joinDate, java.lang.String otherInfo,
		boolean isShowTree, long displayOrder, java.lang.String show,
		long userId, java.lang.String languageId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			java.rmi.RemoteException {
		return _edEmployeeService.addEmployee(groupId, companyId, plid, title,
			name, birthday, sex, homeSide, race, home, homePhone, workPhone,
			mobilePhone, email, departmentId, imageUrl, majorLevel,
			philosophism, family, foreignLanguage, joinDate, otherInfo,
			isShowTree, displayOrder, show, userId, languageId,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public void addEmployeeResources(
		com.vportal.portlet.edirectory.model.EDEmployee employee,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		_edEmployeeService.addEmployeeResources(employee,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addEmployeeResources(
		com.vportal.portlet.edirectory.model.EDEmployee employee,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_edEmployeeService.addEmployeeResources(employee, communityPermissions,
			guestPermissions);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
		long employeeId, long groupId, long companyId, java.lang.String name,
		java.lang.String title, java.util.Date birthday, java.lang.String sex,
		java.lang.String homeSide, java.lang.String race,
		java.lang.String home, java.lang.String homePhone,
		java.lang.String workPhone, java.lang.String email, long departmentId,
		java.lang.String imageUrl, java.lang.String majorLevel,
		java.lang.String philosophism, java.lang.String family,
		java.lang.String foreignLanguage, java.util.Date joinDate,
		java.lang.String otherInfo, boolean isShowTree, long displayOrder,
		java.lang.String show, long userId, java.lang.String languageId,
		java.lang.String mobilePhone)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _edEmployeeService.updateEmployee(employeeId, groupId,
			companyId, name, title, birthday, sex, homeSide, race, home,
			homePhone, workPhone, email, departmentId, imageUrl, majorLevel,
			philosophism, family, foreignLanguage, joinDate, otherInfo,
			isShowTree, displayOrder, show, userId, languageId, mobilePhone);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _edEmployeeService.updateEmployee(employee);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
		long groupId, long companyId, java.lang.String employeeId,
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws java.lang.Exception {
		return _edEmployeeService.updateEmployee(groupId, companyId,
			employeeId, employee);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EDEmployeeService getWrappedEDEmployeeService() {
		return _edEmployeeService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEDEmployeeService(EDEmployeeService edEmployeeService) {
		_edEmployeeService = edEmployeeService;
	}

	public EDEmployeeService getWrappedService() {
		return _edEmployeeService;
	}

	public void setWrappedService(EDEmployeeService edEmployeeService) {
		_edEmployeeService = edEmployeeService;
	}

	private EDEmployeeService _edEmployeeService;
}