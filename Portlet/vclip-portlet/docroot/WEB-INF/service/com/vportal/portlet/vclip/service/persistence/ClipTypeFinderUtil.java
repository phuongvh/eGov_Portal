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

package com.vportal.portlet.vclip.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HOAN
 */
public class ClipTypeFinderUtil {
	public static java.util.List findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		return getFinder().findClipType(clipType);
	}

	public static java.util.List findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType, int start, int end)
		throws java.lang.Exception {
		return getFinder().findClipType(clipType, start, end);
	}

	public static int countClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		return getFinder().countClipType(clipType);
	}

	public static ClipTypeFinder getFinder() {
		if (_finder == null) {
			_finder = (ClipTypeFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vclip.service.ClpSerializer.getServletContextName(),
					ClipTypeFinder.class.getName());

			ReferenceRegistry.registerReference(ClipTypeFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ClipTypeFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ClipTypeFinderUtil.class, "_finder");
	}

	private static ClipTypeFinder _finder;
}