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

package com.vportal.portlet.vlinksman.service.permission;

import java.rmi.RemoteException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.vportal.portlet.vlinksman.model.Links;
import com.vportal.portlet.vlinksman.service.LinksServiceUtil;

public class LinksPermission {

	public static void check(PermissionChecker permissionChecker, Links link,
			String actionId) throws PortalException, SystemException,
			RemoteException {
		if (!contains(permissionChecker, link, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long linkId,
			String actionId) throws PortalException, SystemException,
			RemoteException {

		if (!contains(permissionChecker, linkId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long linkId, String actionId) throws PortalException,
			SystemException, RemoteException {

		Links link = LinksServiceUtil.getLinks(linkId);
		return contains(permissionChecker, link, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			Links link, String actionId) throws PortalException,
			SystemException, RemoteException {

		return permissionChecker.hasPermission(link.getGroupId(), Links.class
				.getName(), link.getLinkId(), actionId);
	}
}
