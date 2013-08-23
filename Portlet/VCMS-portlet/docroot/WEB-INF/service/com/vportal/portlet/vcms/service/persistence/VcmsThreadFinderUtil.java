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
public class VcmsThreadFinderUtil {
	public static java.util.List findInPeriod(java.util.Date from,
		java.util.Date to)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findInPeriod(from, to);
	}

	public static VcmsThreadFinder getFinder() {
		if (_finder == null) {
			_finder = (VcmsThreadFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsThreadFinder.class.getName());

			ReferenceRegistry.registerReference(VcmsThreadFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VcmsThreadFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VcmsThreadFinderUtil.class,
			"_finder");
	}

	private static VcmsThreadFinder _finder;
}