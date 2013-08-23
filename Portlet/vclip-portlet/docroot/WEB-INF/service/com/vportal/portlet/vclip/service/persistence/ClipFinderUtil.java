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
public class ClipFinderUtil {
	public static java.util.List findClip(
		com.vportal.portlet.vclip.model.Clip clip) throws java.lang.Exception {
		return getFinder().findClip(clip);
	}

	public static int countClip(com.vportal.portlet.vclip.model.Clip clip)
		throws java.lang.Exception {
		return getFinder().countClip(clip);
	}

	public static java.util.List findClip(
		com.vportal.portlet.vclip.model.Clip clip, int start, int end)
		throws java.lang.Exception {
		return getFinder().findClip(clip, start, end);
	}

	public static java.util.List searchClip(java.lang.String textSearch,
		java.lang.String clipTypeId) throws java.lang.Exception {
		return getFinder().searchClip(textSearch, clipTypeId);
	}

	public static ClipFinder getFinder() {
		if (_finder == null) {
			_finder = (ClipFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vclip.service.ClpSerializer.getServletContextName(),
					ClipFinder.class.getName());

			ReferenceRegistry.registerReference(ClipFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(ClipFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ClipFinderUtil.class, "_finder");
	}

	private static ClipFinder _finder;
}