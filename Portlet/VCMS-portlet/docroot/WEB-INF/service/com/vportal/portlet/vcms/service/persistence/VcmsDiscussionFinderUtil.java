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
public class VcmsDiscussionFinderUtil {
	public static java.util.List searchDiscussionByA_P_L_K(
		java.lang.String articleId, long groupId, java.lang.String language,
		java.lang.String keyword, boolean approved, boolean isTitle,
		boolean isContent, java.lang.String select)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchDiscussionByA_P_L_K(articleId, groupId, language,
			keyword, approved, isTitle, isContent, select);
	}

	public static VcmsDiscussionFinder getFinder() {
		if (_finder == null) {
			_finder = (VcmsDiscussionFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsDiscussionFinder.class.getName());

			ReferenceRegistry.registerReference(VcmsDiscussionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VcmsDiscussionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VcmsDiscussionFinderUtil.class,
			"_finder");
	}

	private static VcmsDiscussionFinder _finder;
}