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
public class VcmsArticleStatusFinderUtil {
	public static VcmsArticleStatusFinder getFinder() {
		if (_finder == null) {
			_finder = (VcmsArticleStatusFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsArticleStatusFinder.class.getName());

			ReferenceRegistry.registerReference(VcmsArticleStatusFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VcmsArticleStatusFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VcmsArticleStatusFinderUtil.class,
			"_finder");
	}

	private static VcmsArticleStatusFinder _finder;
}