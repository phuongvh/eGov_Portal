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
public class VcmsStatusFinderUtil {
	public static void updatePostion(long statusId, long companyId,
		long groupId, long position, boolean flag)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().updatePostion(statusId, companyId, groupId, position, flag);
	}

	public static void updatePrimary(long statusId, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().updatePrimary(statusId, companyId, groupId);
	}

	public static void updateActive(long statusId, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().updateActive(statusId, companyId, groupId);
	}

	public static java.util.List selectStatusId(long position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().selectStatusId(position);
	}

	public static VcmsStatusFinder getFinder() {
		if (_finder == null) {
			_finder = (VcmsStatusFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsStatusFinder.class.getName());

			ReferenceRegistry.registerReference(VcmsStatusFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VcmsStatusFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VcmsStatusFinderUtil.class,
			"_finder");
	}

	private static VcmsStatusFinder _finder;
}