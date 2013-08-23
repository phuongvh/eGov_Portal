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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the e d employee remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author HOAN
 * @see EDEmployeeServiceUtil
 * @see com.vportal.portlet.edirectory.service.base.EDEmployeeServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.impl.EDEmployeeServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface EDEmployeeService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EDEmployeeServiceUtil} to access the e d employee remote service. Add custom service methods to {@link com.vportal.portlet.edirectory.service.impl.EDEmployeeServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
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
			java.rmi.RemoteException;

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
			java.rmi.RemoteException;

	public void addEmployeeResources(
		com.vportal.portlet.edirectory.model.EDEmployee employee,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException;

	public void addEmployeeResources(
		com.vportal.portlet.edirectory.model.EDEmployee employee,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
			java.rmi.RemoteException;

	public com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	public com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
		long groupId, long companyId, java.lang.String employeeId,
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws java.lang.Exception;
}