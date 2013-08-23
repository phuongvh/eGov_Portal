/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.vportal.portlet.edirectory.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HOAN
 */
public class EDEmployeeFinderUtil {
	public static java.util.List findEmployeeByParam(long groupId,
		java.lang.String language, java.lang.String name, long departmentId,
		long functionId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findEmployeeByParam(groupId, language, name, departmentId,
			functionId, begin, end);
	}

	public static java.util.List findEmployeeByParam(long groupId,
		java.lang.String language, java.lang.String name, long departmentId,
		long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findEmployeeByParam(groupId, language, name, departmentId,
			functionId);
	}

	public static int countEDEmployeByParam(long groupId,
		java.lang.String language, java.lang.String name, long departmentId,
		long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countEDEmployeByParam(groupId, language, name,
			departmentId, functionId);
	}

	public static java.util.List findEmployeeByParam(long groupId,
		java.lang.String language, long departmentId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findEmployeeByParam(groupId, language, departmentId, name);
	}

	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findEmployeeByParam(
		long groupId, java.lang.String language, long departmentId,
		java.lang.String name, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findEmployeeByParam(groupId, language, departmentId, name,
			begin, end);
	}

	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findEmployeeByParam(
		long groupId, java.lang.String languageId, long departmentId,
		java.lang.String name, java.lang.String phone, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findEmployeeByParam(groupId, languageId, departmentId,
			name, phone, email);
	}

	public static EDEmployeeFinder getFinder() {
		if (_finder == null) {
			_finder = (EDEmployeeFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.edirectory.service.ClpSerializer.getServletContextName(),
					EDEmployeeFinder.class.getName());

			ReferenceRegistry.registerReference(EDEmployeeFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(EDEmployeeFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(EDEmployeeFinderUtil.class,
			"_finder");
	}

	private static EDEmployeeFinder _finder;
}