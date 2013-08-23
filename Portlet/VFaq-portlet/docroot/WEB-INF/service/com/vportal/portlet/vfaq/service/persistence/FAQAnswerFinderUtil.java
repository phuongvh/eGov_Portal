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
public class FAQAnswerFinderUtil {
	public static java.util.List findByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByGroupId(groupId);
	}

	public static java.util.List findByGroupId(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByGroupId(groupId, start, end);
	}

	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByGroupId(groupId);
	}

	public static java.util.List getByG_L_S(long groupId,
		java.lang.String language, boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getByG_L_S(groupId, language, approved, start, end);
	}

	public static int countByG_L_S(long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByG_L_S(groupId, language, approved);
	}

	public static int countByG_L_S_Q(long groupId, java.lang.String language,
		boolean approved, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByG_L_S_Q(groupId, language, approved, questionId);
	}

	public static java.util.List getByParam(long groupId,
		java.lang.String language, boolean approved, java.lang.String title,
		java.lang.String sentByUser, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getByParam(groupId, language, approved, title, sentByUser,
			categoryId, start, end);
	}

	public static int countByParam(long groupId, java.lang.String language,
		boolean approved, java.lang.String title, java.lang.String sentByUser,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByParam(groupId, language, approved, title,
			sentByUser, categoryId);
	}

	public static java.util.List findByG_L(long groupId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_L(groupId, language);
	}

	public static java.util.List getAnswer(long groupId,
		java.lang.String language, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getAnswer(groupId, language, categoryId, start, end);
	}

	public static int countAnswer(long groupId, java.lang.String language,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countAnswer(groupId, language, categoryId);
	}

	public static FAQAnswerFinder getFinder() {
		if (_finder == null) {
			_finder = (FAQAnswerFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vfaq.service.ClpSerializer.getServletContextName(),
					FAQAnswerFinder.class.getName());

			ReferenceRegistry.registerReference(FAQAnswerFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(FAQAnswerFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FAQAnswerFinderUtil.class, "_finder");
	}

	private static FAQAnswerFinder _finder;
}