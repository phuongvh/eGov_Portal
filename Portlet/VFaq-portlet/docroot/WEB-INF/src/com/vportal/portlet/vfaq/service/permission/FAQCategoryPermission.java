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
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.vportal.portlet.vfaq.model.FAQCategory;
import com.vportal.portlet.vfaq.service.FAQCategoryLocalServiceUtil;
import com.vportal.portlet.vfaq.util.ActionKeysExt;
import com.vportal.portlet.vfaq.util.WebKeysExt;

/**
 * @author Nguyen Ngoc Duc
 * @since June 13, 2013
 */
public class FAQCategoryPermission {
	public static void check(PermissionChecker permissionChecker,
			long categoryId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, categoryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long plId,
			long categoryId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, plId, categoryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker,
			FAQCategory category, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, category, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long plId, long categoryId, String actionId)
			throws PortalException, SystemException {

		if (categoryId == 0) {
			return PortletPermissionUtil.contains(permissionChecker, plId,
					WebKeysExt.VFAQ, actionId);
		} else {
			return contains(permissionChecker, categoryId, actionId);
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long categoryId, String actionId) throws PortalException,
			SystemException {

		FAQCategory category = FAQCategoryLocalServiceUtil
				.getCategory(categoryId);

		return contains(permissionChecker, category, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			FAQCategory category, String actionId) throws PortalException,
			SystemException {
		if (actionId.equals(ActionKeysExt.ADD_CATEGORY)) {
			actionId = ActionKeysExt.ADD_CATEGORY;
		}

		long categoryId = category.getId();

		while (categoryId != 0) {
			category = FAQCategoryLocalServiceUtil.getCategory(categoryId);

			categoryId = category.getParent();

			if (permissionChecker.hasPermission(category.getGroupId(),
					FAQCategory.class.getName(), category.getId(), actionId)) {

				return true;
			}

			if (actionId.equals(ActionKeys.VIEW)) {
				break;
			}
		}

		return false;
	}

}
