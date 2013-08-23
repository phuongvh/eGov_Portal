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

package com.vportal.portlet.vfaq.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author DucNN
 */
public class FAQCategoryFinderUtil {
	public static int countByG_L_C(long groupId, java.lang.String language,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByG_L_C(groupId, language, categoryId);
	}

	public static FAQCategoryFinder getFinder() {
		if (_finder == null) {
			_finder = (FAQCategoryFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vfaq.service.ClpSerializer.getServletContextName(),
					FAQCategoryFinder.class.getName());

			ReferenceRegistry.registerReference(FAQCategoryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(FAQCategoryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FAQCategoryFinderUtil.class,
			"_finder");
	}

	private static FAQCategoryFinder _finder;
}