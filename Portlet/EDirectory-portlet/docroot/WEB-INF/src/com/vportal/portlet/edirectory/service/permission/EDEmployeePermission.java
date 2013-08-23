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
package com.vportal.portlet.edirectory.service.permission;

import java.rmi.RemoteException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.vportal.portlet.edirectory.model.EDEmployee;
import com.vportal.portlet.edirectory.service.EDEmployeeLocalServiceUtil;

public class EDEmployeePermission {

	public static void check(PermissionChecker permissionChecker, long groupId,
			long id, String actionId) throws PortalException, SystemException,
			RemoteException {
		if (!contains(permissionChecker, groupId, id, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker,
			EDEmployee employee, String actionId) throws PortalException,
			SystemException {
		if (!contains(permissionChecker, employee, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, long id, String actionId) throws PortalException,
			SystemException, RemoteException {
		EDEmployee employee = EDEmployeeLocalServiceUtil.getEmployeeByE_G(id,
				groupId);
		return contains(permissionChecker, employee, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			EDEmployee employee, String actionId) throws PortalException,
			SystemException {
		return permissionChecker.hasPermission(employee.getGroupId(),
				EDEmployee.class.getName(), employee.getId(), actionId);
	}

}
