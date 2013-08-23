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
package com.vportal.portlet.vclip.service.permission;

import java.rmi.RemoteException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.vportal.portlet.vclip.model.ClipType;
import com.vportal.portlet.vclip.service.ClipTypeServiceUtil;

public class ClipTypePermission {
	public static void check(PermissionChecker permissionChecker, long groupId,
			String clipTypeId, String actionId) throws PortalException,
			SystemException, RemoteException, Exception {
		if (!contains(permissionChecker, groupId, clipTypeId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker,
			ClipType clipType, String actionId) throws PortalException,
			SystemException, Exception {

		if (!contains(permissionChecker, clipType, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String clipTypeId, String actionId)
			throws PortalException, SystemException, RemoteException, Exception {
		ClipType clipType = ClipTypeServiceUtil.findById(clipTypeId);
		return contains(permissionChecker, clipType, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			ClipType clipType, String actionId) throws PortalException,
			SystemException, Exception {
		return permissionChecker.hasPermission(clipType.getGroupId(),
				ClipType.class.getName(), clipType.getId(), actionId);
	}
}
