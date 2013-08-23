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

/**
 * @author MrEn
 */
public interface vdocDocumentFinder {
	public java.util.List findDocumentByParams(long groupId,
		java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findDocumentByParams(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status, int begin,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findDocsByPublishedDate(long groupId,
		java.lang.String language, java.util.Date pubDateFrom,
		java.util.Date pubDateTo, int status, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findDocbyModifyDate(long groupId,
		java.lang.String language, java.util.Date modiDateFrom,
		java.util.Date modiDateTo, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String maxPositionDocument(long groupId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findOtherDoc(long groupId, java.lang.String language,
		java.lang.String Id, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countDoc(long groupId, java.lang.String language,
		java.lang.String Id, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;
}