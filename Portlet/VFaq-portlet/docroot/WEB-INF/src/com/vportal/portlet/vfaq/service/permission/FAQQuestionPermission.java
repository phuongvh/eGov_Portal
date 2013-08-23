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
import com.vportal.portlet.vfaq.model.FAQQuestion;
import com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil;

/**
 * @author Nguyen Ngoc Duc
 * @since June 13, 2013
 */
public class FAQQuestionPermission {
	public static void check(PermissionChecker permissionChecker, long groupId,
			long questionId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, groupId, questionId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker,
			FAQQuestion question, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, question, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, long questionId, String actionId)
			throws PortalException, SystemException {

		FAQQuestion question = FAQQuestionLocalServiceUtil.getQuestion(groupId,
				questionId);

		return contains(permissionChecker, question, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			FAQQuestion question, String actionId) throws PortalException,
			SystemException {

		return permissionChecker.hasPermission(question.getGroupId(),
				FAQQuestion.class.getName(), question.getId(), actionId);
	}
}
