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
package com.vportal.portlet.vcms.service.permission;

import java.rmi.RemoteException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.vportal.portlet.vcms.model.VcmsStatus;
import com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil;
/**
 * 
 * @author TrungPQ
 * @version 1.0.00, May 16, 2009
 */

public class VcmsStatusPermission {
	public static void check(PermissionChecker permissionChecker,
			int statusId,String actionId)
			throws PortalException, SystemException, RemoteException {

		if (!contains(permissionChecker, statusId, actionId)) {
			throw new PrincipalException();
		}
		
		
	}

	public static void check(PermissionChecker permissionChecker,
			VcmsStatus status, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, status, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			int statusId, String actionId) throws PortalException,
			SystemException, RemoteException {

		VcmsStatus status = (VcmsStatus) VcmsStatusLocalServiceUtil.getVcmsStatus(statusId);

		return contains(permissionChecker, status, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			VcmsStatus status, String actionId) throws PortalException,
			SystemException {

		return permissionChecker
				.hasPermission(status.getGroupId(), VcmsStatus.class
						.getName(), status.getPrimaryKey(), actionId);
	}
}
