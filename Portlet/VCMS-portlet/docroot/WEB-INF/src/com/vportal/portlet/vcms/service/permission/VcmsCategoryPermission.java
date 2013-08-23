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
import com.vportal.portlet.vcms.model.VcmsCategory;
import com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil;

/**
 * 
 * @author donghh
 * @version 1.0.00, May 23, 2008
 */

public class VcmsCategoryPermission {
	public static void check(PermissionChecker permissionChecker,
			long categoryId, String name, String actionId)
			throws PortalException, SystemException, RemoteException {

		if (!contains(permissionChecker, categoryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker,
			VcmsCategory category, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, category, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long categoryId, String actionId) throws PortalException,
			SystemException, RemoteException {

		VcmsCategory category = (VcmsCategory) VcmsCategoryServiceUtil
				.getCategory(String.valueOf(categoryId));

		return contains(permissionChecker, category, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			VcmsCategory category, String actionId) throws PortalException,
			SystemException {

		return permissionChecker
				.hasPermission(category.getGroupId(), VcmsCategory.class
						.getName(), category.getCategoryId(), actionId);
	}
}
