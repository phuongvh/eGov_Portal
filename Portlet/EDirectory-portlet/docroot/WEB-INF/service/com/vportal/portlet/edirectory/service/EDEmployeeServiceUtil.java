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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the e d employee remote service. This utility wraps {@link com.vportal.portlet.edirectory.service.impl.EDEmployeeServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author HOAN
 * @see EDEmployeeService
 * @see com.vportal.portlet.edirectory.service.base.EDEmployeeServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.impl.EDEmployeeServiceImpl
 * @generated
 */
public class EDEmployeeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.edirectory.service.impl.EDEmployeeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.edirectory.model.EDEmployee addEmployee(
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
		return getService()
				   .addEmployee(groupId, companyId, plid, title, name,
			birthday, sex, homeSide, race, home, homePhone, workPhone,
			mobilePhone, email, departmentId, imageUrl, majorLevel,
			philosophism, family, foreignLanguage, joinDate, otherInfo,
			isShowTree, displayOrder, show, userId, languageId,
			communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.edirectory.model.EDEmployee addEmployee(
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
		return getService()
				   .addEmployee(groupId, companyId, plid, title, name,
			birthday, sex, homeSide, race, home, homePhone, workPhone,
			mobilePhone, email, departmentId, imageUrl, majorLevel,
			philosophism, family, foreignLanguage, joinDate, otherInfo,
			isShowTree, displayOrder, show, userId, languageId,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public static void addEmployeeResources(
		com.vportal.portlet.edirectory.model.EDEmployee employee,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		getService()
			.addEmployeeResources(employee, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addEmployeeResources(
		com.vportal.portlet.edirectory.model.EDEmployee employee,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEmployeeResources(employee, communityPermissions,
			guestPermissions);
	}

	public static com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
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
		return getService()
				   .updateEmployee(employeeId, groupId, companyId, name, title,
			birthday, sex, homeSide, race, home, homePhone, workPhone, email,
			departmentId, imageUrl, majorLevel, philosophism, family,
			foreignLanguage, joinDate, otherInfo, isShowTree, displayOrder,
			show, userId, languageId, mobilePhone);
	}

	public static com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateEmployee(employee);
	}

	public static com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
		long groupId, long companyId, java.lang.String employeeId,
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws java.lang.Exception {
		return getService()
				   .updateEmployee(groupId, companyId, employeeId, employee);
	}

	public static void clearService() {
		_service = null;
	}

	public static EDEmployeeService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EDEmployeeService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					EDEmployeeService.class.getName(), portletClassLoader);

			_service = new EDEmployeeServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(EDEmployeeServiceUtil.class,
				"_service");
			MethodCache.remove(EDEmployeeService.class);
		}

		return _service;
	}

	public void setService(EDEmployeeService service) {
		MethodCache.remove(EDEmployeeService.class);

		_service = service;

		ReferenceRegistry.registerReference(EDEmployeeServiceUtil.class,
			"_service");
		MethodCache.remove(EDEmployeeService.class);
	}

	private static EDEmployeeService _service;
}