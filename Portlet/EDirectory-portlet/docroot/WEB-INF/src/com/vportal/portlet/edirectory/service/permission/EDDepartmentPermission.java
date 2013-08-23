package com.vportal.portlet.edirectory.service.permission;

import java.rmi.RemoteException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.vportal.portlet.edirectory.model.EDDepartment;
import com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil;

public class EDDepartmentPermission {

	public static void check(PermissionChecker permissionChecker, long groupId,
			long id, String actionId) throws PortalException, SystemException,
			RemoteException {
		if (!contains(permissionChecker, groupId, id, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker,
			EDDepartment deparment, String actionId) throws PortalException,
			SystemException {
		if (!contains(permissionChecker, deparment, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, long id, String actionId) throws PortalException,
			SystemException, RemoteException {
		EDDepartment deparment = EDDepartmentLocalServiceUtil
				.getDepartmentByD_G(id, groupId);
		return contains(permissionChecker, deparment, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			EDDepartment deparment, String actionId) throws PortalException,
			SystemException {
		return permissionChecker.hasPermission(deparment.getGroupId(),
				EDDepartment.class.getName(), deparment.getId(), actionId);
	}

}
