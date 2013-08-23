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

package com.vportal.portlet.vadvman.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author DucNN
 */
public class AdvItemFinderUtil {
	public static java.util.List getItemByParam(long groupId,
		java.lang.String description, long typeId, int status, int begin,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getItemByParam(groupId, description, typeId, status, begin,
			end);
	}

	public static int countItemByParam(long groupId,
		java.lang.String description, long typeId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countItemByParam(groupId, description, typeId, status);
	}

	public static AdvItemFinder getFinder() {
		if (_finder == null) {
			_finder = (AdvItemFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vadvman.service.ClpSerializer.getServletContextName(),
					AdvItemFinder.class.getName());

			ReferenceRegistry.registerReference(AdvItemFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AdvItemFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AdvItemFinderUtil.class, "_finder");
	}

	private static AdvItemFinder _finder;
}