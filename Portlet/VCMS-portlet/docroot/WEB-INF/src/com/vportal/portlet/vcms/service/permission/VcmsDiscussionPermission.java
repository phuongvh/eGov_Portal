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
import com.vportal.portlet.vcms.model.VcmsDiscussion;
import com.vportal.portlet.vcms.service.VcmsDiscussionServiceUtil;

public class VcmsDiscussionPermission {
	public static void check(PermissionChecker permissionChecker,
			long discussionId, String actionId) throws PortalException,
			SystemException, RemoteException {

		if (!contains(permissionChecker, discussionId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker,
			VcmsDiscussion discussion, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, discussion, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long discussionId, String actionId) throws PortalException,
			SystemException, RemoteException {

		VcmsDiscussion discussion = (VcmsDiscussion) VcmsDiscussionServiceUtil
				.getDiscussion(String.valueOf(discussionId));

		return contains(permissionChecker, discussion, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			VcmsDiscussion discussion, String actionId) throws PortalException,
			SystemException {

		return permissionChecker.hasPermission(discussion.getGroupId(),
				VcmsDiscussion.class.getName(), discussion.getDiscussionId(),
				actionId);
	}
}
