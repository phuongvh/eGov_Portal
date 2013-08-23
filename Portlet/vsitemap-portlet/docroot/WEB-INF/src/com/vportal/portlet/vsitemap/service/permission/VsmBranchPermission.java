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

package com.vportal.portlet.vsitemap.service.permission;

import java.rmi.RemoteException;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.auth.PrincipalException;
import com.vportal.portlet.vsitemap.model.VsmBranch;
import com.vportal.portlet.vsitemap.service.VsmBranchServiceUtil;

public class VsmBranchPermission {
	
	public static void check(PermissionChecker permissionChecker, VsmBranch 
			branch, String actionId) throws PortalException, SystemException, 
			RemoteException {
		if( ! contains(permissionChecker, branch, actionId)){
			throw new PrincipalException();
		}
	}
//	public static void check(PermissionChecker permissionChecker, long branchId,
//		String actionId) throws PortalException, SystemException, RemoteException {
//
//		if (!contains(permissionChecker, branchId, actionId)) {
//			throw new PrincipalException();
//		}
//	}
	
	public static boolean contains(PermissionChecker permissionChecker, long branchId,
		String actionId) throws PortalException, SystemException,RemoteException {	
		
		VsmBranch branch = VsmBranchServiceUtil.getBranch(branchId);
		return contains(permissionChecker, branch, actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, 
		VsmBranch branch, String actionId) throws PortalException,
		SystemException,RemoteException {
		
		return permissionChecker.hasPermission(branch.getGroupId(), 
				VsmBranch.class.getName(),	branch.getBranchId(), actionId);
	}
}
