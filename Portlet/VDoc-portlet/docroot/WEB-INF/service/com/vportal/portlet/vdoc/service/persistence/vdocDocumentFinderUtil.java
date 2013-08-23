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

package com.vportal.portlet.vdoc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author MrEn
 */
public class vdocDocumentFinderUtil {
	public static java.util.List findDocumentByParams(long groupId,
		java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findDocumentByParams(groupId, language, fieldId, orgId,
			title, status);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findDocumentByParams(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status, int begin,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findDocumentByParams(groupId, language, fieldId, orgId,
			title, status, begin, end);
	}

	public static java.util.List findDocsByPublishedDate(long groupId,
		java.lang.String language, java.util.Date pubDateFrom,
		java.util.Date pubDateTo, int status, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findDocsByPublishedDate(groupId, language, pubDateFrom,
			pubDateTo, status, quantity);
	}

	public static java.util.List findDocbyModifyDate(long groupId,
		java.lang.String language, java.util.Date modiDateFrom,
		java.util.Date modiDateTo, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findDocbyModifyDate(groupId, language, modiDateFrom,
			modiDateTo, status);
	}

	public static java.lang.String maxPositionDocument(long groupId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().maxPositionDocument(groupId, language);
	}

	public static java.util.List findOtherDoc(long groupId,
		java.lang.String language, java.lang.String Id, int status, int begin,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findOtherDoc(groupId, language, Id, status, begin, end);
	}

	public static int countDoc(long groupId, java.lang.String language,
		java.lang.String Id, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countDoc(groupId, language, Id, status, begin, end);
	}

	public static vdocDocumentFinder getFinder() {
		if (_finder == null) {
			_finder = (vdocDocumentFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vdoc.service.ClpSerializer.getServletContextName(),
					vdocDocumentFinder.class.getName());

			ReferenceRegistry.registerReference(vdocDocumentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(vdocDocumentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(vdocDocumentFinderUtil.class,
			"_finder");
	}

	private static vdocDocumentFinder _finder;
}