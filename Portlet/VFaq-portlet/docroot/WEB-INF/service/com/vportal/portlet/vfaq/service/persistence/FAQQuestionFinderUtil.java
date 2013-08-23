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
public class FAQQuestionFinderUtil {
	public static java.util.List findByCategoryId(long groupId,
		java.lang.String language, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByCategoryId(groupId, language, categoryId);
	}

	public static java.util.List findByG_Q_A(long groupId,
		java.lang.String language, int quantity, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_Q_A(groupId, language, quantity, approved);
	}

	public static java.util.List findByC_S(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		int begin, int end, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_S(groupId, language, categoryId, title, begin, end,
			approved);
	}

	public static java.util.List findByC_S(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_S(groupId, language, categoryId, title, approved);
	}

	public static int countByC_S(long groupId, java.lang.String language,
		long categoryId, java.lang.String title, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_S(groupId, language, categoryId, title, approved);
	}

	public static java.util.List findQuestionByParam(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		java.lang.String sentByUser, boolean approved, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findQuestionByParam(groupId, language, categoryId, title,
			sentByUser, approved, begin, end);
	}

	public static int countQuestionByParam(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		java.lang.String sentByUser, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countQuestionByParam(groupId, language, categoryId, title,
			sentByUser, approved);
	}

	public static java.util.List findOtherQuestionByParam(long groupId,
		java.lang.String language, long Id, long categoryId, boolean approved,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findOtherQuestionByParam(groupId, language, Id, categoryId,
			approved, begin, end);
	}

	public static java.util.List findQuestion(long groupId,
		java.lang.String language, long categoryId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findQuestion(groupId, language, categoryId, begin, end);
	}

	public static int countQuestion(long groupId, java.lang.String language,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countQuestion(groupId, language, categoryId);
	}

	public static java.util.List findQuestionByParamArrange(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		java.lang.String sentByUser, boolean approved,
		java.lang.String clickValue, java.lang.String arrange, int begin,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findQuestionByParamArrange(groupId, language, categoryId,
			title, sentByUser, approved, clickValue, arrange, begin, end);
	}

	public static FAQQuestionFinder getFinder() {
		if (_finder == null) {
			_finder = (FAQQuestionFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vfaq.service.ClpSerializer.getServletContextName(),
					FAQQuestionFinder.class.getName());

			ReferenceRegistry.registerReference(FAQQuestionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(FAQQuestionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FAQQuestionFinderUtil.class,
			"_finder");
	}

	private static FAQQuestionFinder _finder;
}