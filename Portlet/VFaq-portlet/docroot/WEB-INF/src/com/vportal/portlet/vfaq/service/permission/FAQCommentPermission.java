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

package com.vportal.portlet.vfaq.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.vportal.portlet.vfaq.model.FAQComment;
import com.vportal.portlet.vfaq.service.FAQCommentLocalServiceUtil;

/**
 * @author Nguyen Ngoc Duc
 * @since June 13, 2013
 */
public class FAQCommentPermission {
	public static void check(PermissionChecker permissionChecker, long groupId,
			long commentId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, groupId, commentId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long groupId,
			FAQComment comment, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, groupId, comment, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, long commentId, String actionId)
			throws PortalException, SystemException {

		FAQComment comment = FAQCommentLocalServiceUtil.getComment(commentId);

		return contains(permissionChecker, groupId, comment, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, FAQComment comment, String actionId)
			throws PortalException, SystemException {
		return permissionChecker.hasPermission(groupId, FAQComment.class
				.getName(), comment.getId(), actionId);
	}
}
