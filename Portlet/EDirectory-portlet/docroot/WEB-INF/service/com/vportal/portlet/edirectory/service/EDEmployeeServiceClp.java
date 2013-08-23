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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author HOAN
 */
public class EDEmployeeServiceClp implements EDEmployeeService {
	public EDEmployeeServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addEmployeeMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEmployee", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.util.Date.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.util.Date.class, java.lang.String.class, boolean.class,
				long.class, java.lang.String.class, long.class,
				java.lang.String.class, java.lang.String[].class,
				java.lang.String[].class);

		_addEmployeeMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEmployee", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.util.Date.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.util.Date.class, java.lang.String.class, boolean.class,
				long.class, java.lang.String.class, long.class,
				java.lang.String.class, java.lang.Boolean.class,
				java.lang.Boolean.class, java.lang.String[].class,
				java.lang.String[].class);

		_addEmployeeResourcesMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEmployeeResources",
				com.vportal.portlet.edirectory.model.EDEmployee.class,
				boolean.class, boolean.class);

		_addEmployeeResourcesMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEmployeeResources",
				com.vportal.portlet.edirectory.model.EDEmployee.class,
				java.lang.String[].class, java.lang.String[].class);

		_updateEmployeeMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateEmployee", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.util.Date.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.util.Date.class,
				java.lang.String.class, boolean.class, long.class,
				java.lang.String.class, long.class, java.lang.String.class,
				java.lang.String.class);

		_updateEmployeeMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateEmployee",
				com.vportal.portlet.edirectory.model.EDEmployee.class);

		_updateEmployeeMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateEmployee", long.class, long.class,
				java.lang.String.class,
				com.vportal.portlet.edirectory.model.EDEmployee.class);
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addEmployeeMethodKey0,
				groupId, companyId, plid, ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(birthday),
				ClpSerializer.translateInput(sex),
				ClpSerializer.translateInput(homeSide),
				ClpSerializer.translateInput(race),
				ClpSerializer.translateInput(home),
				ClpSerializer.translateInput(homePhone),
				ClpSerializer.translateInput(workPhone),
				ClpSerializer.translateInput(mobilePhone),
				ClpSerializer.translateInput(email), departmentId,
				ClpSerializer.translateInput(imageUrl),
				ClpSerializer.translateInput(majorLevel),
				ClpSerializer.translateInput(philosophism),
				ClpSerializer.translateInput(family),
				ClpSerializer.translateInput(foreignLanguage),
				ClpSerializer.translateInput(joinDate),
				ClpSerializer.translateInput(otherInfo), isShowTree,
				displayOrder, ClpSerializer.translateInput(show), userId,
				ClpSerializer.translateInput(languageId),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
				throw (com.liferay.portal.security.auth.PrincipalException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addEmployeeMethodKey1,
				groupId, companyId, plid, ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(birthday),
				ClpSerializer.translateInput(sex),
				ClpSerializer.translateInput(homeSide),
				ClpSerializer.translateInput(race),
				ClpSerializer.translateInput(home),
				ClpSerializer.translateInput(homePhone),
				ClpSerializer.translateInput(workPhone),
				ClpSerializer.translateInput(mobilePhone),
				ClpSerializer.translateInput(email), departmentId,
				ClpSerializer.translateInput(imageUrl),
				ClpSerializer.translateInput(majorLevel),
				ClpSerializer.translateInput(philosophism),
				ClpSerializer.translateInput(family),
				ClpSerializer.translateInput(foreignLanguage),
				ClpSerializer.translateInput(joinDate),
				ClpSerializer.translateInput(otherInfo), isShowTree,
				displayOrder, ClpSerializer.translateInput(show), userId,
				ClpSerializer.translateInput(languageId),
				ClpSerializer.translateInput(addCommunityPermissions),
				ClpSerializer.translateInput(addGuestPermissions),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
				throw (com.liferay.portal.security.auth.PrincipalException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public void addEmployeeResources(
		com.vportal.portlet.edirectory.model.EDEmployee employee,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		MethodHandler methodHandler = new MethodHandler(_addEmployeeResourcesMethodKey2,
				ClpSerializer.translateInput(employee),
				addCommunityPermissions, addGuestPermissions);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
				throw (com.liferay.portal.security.auth.PrincipalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addEmployeeResources(
		com.vportal.portlet.edirectory.model.EDEmployee employee,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addEmployeeResourcesMethodKey3,
				ClpSerializer.translateInput(employee),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateEmployeeMethodKey4,
				employeeId, groupId, companyId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(birthday),
				ClpSerializer.translateInput(sex),
				ClpSerializer.translateInput(homeSide),
				ClpSerializer.translateInput(race),
				ClpSerializer.translateInput(home),
				ClpSerializer.translateInput(homePhone),
				ClpSerializer.translateInput(workPhone),
				ClpSerializer.translateInput(email), departmentId,
				ClpSerializer.translateInput(imageUrl),
				ClpSerializer.translateInput(majorLevel),
				ClpSerializer.translateInput(philosophism),
				ClpSerializer.translateInput(family),
				ClpSerializer.translateInput(foreignLanguage),
				ClpSerializer.translateInput(joinDate),
				ClpSerializer.translateInput(otherInfo), isShowTree,
				displayOrder, ClpSerializer.translateInput(show), userId,
				ClpSerializer.translateInput(languageId),
				ClpSerializer.translateInput(mobilePhone));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateEmployeeMethodKey5,
				ClpSerializer.translateInput(employee));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
		long groupId, long companyId, java.lang.String employeeId,
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateEmployeeMethodKey6,
				groupId, companyId, ClpSerializer.translateInput(employeeId),
				ClpSerializer.translateInput(employee));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addEmployeeMethodKey0;
	private MethodKey _addEmployeeMethodKey1;
	private MethodKey _addEmployeeResourcesMethodKey2;
	private MethodKey _addEmployeeResourcesMethodKey3;
	private MethodKey _updateEmployeeMethodKey4;
	private MethodKey _updateEmployeeMethodKey5;
	private MethodKey _updateEmployeeMethodKey6;
}