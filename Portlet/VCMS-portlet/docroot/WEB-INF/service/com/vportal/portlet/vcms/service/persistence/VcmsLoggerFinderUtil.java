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

package com.vportal.portlet.vcms.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author hai
 */
public class VcmsLoggerFinderUtil {
	public static java.util.List findByUser(java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByUser(createdByUser);
	}

	public static java.util.List findByPeriod(java.util.Date from,
		java.util.Date to)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByPeriod(from, to);
	}

	public static java.util.List findByD_A_K(java.lang.String keyword,
		int select, java.util.Date datePresent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByD_A_K(keyword, select, datePresent);
	}

	public static java.util.List findByD_A_K(java.lang.String keyword,
		int select, java.util.Date datePresent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByD_A_K(keyword, select, datePresent, start, end);
	}

	public static int countByD_A_K(java.lang.String keyword, int select,
		java.util.Date datePresent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByD_A_K(keyword, select, datePresent);
	}

	public static void removeByPeriod(java.util.Date from, java.util.Date to)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().removeByPeriod(from, to);
	}

	public static VcmsLoggerFinder getFinder() {
		if (_finder == null) {
			_finder = (VcmsLoggerFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsLoggerFinder.class.getName());

			ReferenceRegistry.registerReference(VcmsLoggerFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VcmsLoggerFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VcmsLoggerFinderUtil.class,
			"_finder");
	}

	private static VcmsLoggerFinder _finder;
}