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
package com.vportal.portlet.vadvman.service.permission;

import java.rmi.RemoteException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.auth.PrincipalException;
import com.vportal.portlet.vadvman.model.AdvItem;
import com.vportal.portlet.vadvman.service.AdvItemServiceUtil;

public class AdvItemPermission {
	
	public static void check(PermissionChecker permissionChecker, AdvItem 
		item, String actionId) throws PortalException, SystemException, 
			RemoteException {
		if( ! contains(permissionChecker, item, actionId)){
			throw new PrincipalException();
		}
	}
	public static void check(PermissionChecker permissionChecker, long itemId,
		String actionId) throws PortalException, SystemException, RemoteException {

		if (!contains(permissionChecker, itemId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long itemId,
		String actionId) throws PortalException, SystemException,RemoteException {
				
		AdvItem item = AdvItemServiceUtil.getItem(itemId);
		return contains(permissionChecker, item, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, 
			AdvItem item, String actionId) throws PortalException,
		SystemException,RemoteException {
		
		return permissionChecker.hasPermission(item.getGroupId(), 
				AdvItem.class.getName(),	item.getItemId(), actionId);
	}
}
