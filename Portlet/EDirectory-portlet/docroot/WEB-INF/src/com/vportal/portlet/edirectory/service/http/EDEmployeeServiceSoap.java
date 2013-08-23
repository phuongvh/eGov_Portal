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

package com.vportal.portlet.edirectory.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.edirectory.service.EDEmployeeServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.edirectory.service.EDEmployeeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.edirectory.model.EDEmployeeSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.edirectory.model.EDEmployee}, that is translated to a
 * {@link com.vportal.portlet.edirectory.model.EDEmployeeSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    HOAN
 * @see       EDEmployeeServiceHttp
 * @see       com.vportal.portlet.edirectory.model.EDEmployeeSoap
 * @see       com.vportal.portlet.edirectory.service.EDEmployeeServiceUtil
 * @generated
 */
public class EDEmployeeServiceSoap {
	public static com.vportal.portlet.edirectory.model.EDEmployeeSoap addEmployee(
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
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.edirectory.model.EDEmployee returnValue = EDEmployeeServiceUtil.addEmployee(groupId,
					companyId, plid, title, name, birthday, sex, homeSide,
					race, home, homePhone, workPhone, mobilePhone, email,
					departmentId, imageUrl, majorLevel, philosophism, family,
					foreignLanguage, joinDate, otherInfo, isShowTree,
					displayOrder, show, userId, languageId,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.edirectory.model.EDEmployeeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.edirectory.model.EDEmployeeSoap addEmployee(
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
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.edirectory.model.EDEmployee returnValue = EDEmployeeServiceUtil.addEmployee(groupId,
					companyId, plid, title, name, birthday, sex, homeSide,
					race, home, homePhone, workPhone, mobilePhone, email,
					departmentId, imageUrl, majorLevel, philosophism, family,
					foreignLanguage, joinDate, otherInfo, isShowTree,
					displayOrder, show, userId, languageId,
					addCommunityPermissions, addGuestPermissions,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.edirectory.model.EDEmployeeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addEmployeeResources(
		com.vportal.portlet.edirectory.model.EDEmployee employee,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			EDEmployeeServiceUtil.addEmployeeResources(employee,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addEmployeeResources(
		com.vportal.portlet.edirectory.model.EDEmployee employee,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			EDEmployeeServiceUtil.addEmployeeResources(employee,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.edirectory.model.EDEmployeeSoap updateEmployee(
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
		java.lang.String mobilePhone) throws RemoteException {
		try {
			com.vportal.portlet.edirectory.model.EDEmployee returnValue = EDEmployeeServiceUtil.updateEmployee(employeeId,
					groupId, companyId, name, title, birthday, sex, homeSide,
					race, home, homePhone, workPhone, email, departmentId,
					imageUrl, majorLevel, philosophism, family,
					foreignLanguage, joinDate, otherInfo, isShowTree,
					displayOrder, show, userId, languageId, mobilePhone);

			return com.vportal.portlet.edirectory.model.EDEmployeeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.edirectory.model.EDEmployeeSoap updateEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws RemoteException {
		try {
			com.vportal.portlet.edirectory.model.EDEmployee returnValue = EDEmployeeServiceUtil.updateEmployee(employee);

			return com.vportal.portlet.edirectory.model.EDEmployeeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.edirectory.model.EDEmployeeSoap updateEmployee(
		long groupId, long companyId, java.lang.String employeeId,
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws RemoteException {
		try {
			com.vportal.portlet.edirectory.model.EDEmployee returnValue = EDEmployeeServiceUtil.updateEmployee(groupId,
					companyId, employeeId, employee);

			return com.vportal.portlet.edirectory.model.EDEmployeeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EDEmployeeServiceSoap.class);
}