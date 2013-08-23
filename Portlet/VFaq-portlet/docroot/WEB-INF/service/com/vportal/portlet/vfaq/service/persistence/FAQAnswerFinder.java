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

/**
 * @author DucNN
 */
public interface FAQAnswerFinder {
	public java.util.List findByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByGroupId(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List getByG_L_S(long groupId, java.lang.String language,
		boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByG_L_S(long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByG_L_S_Q(long groupId, java.lang.String language,
		boolean approved, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List getByParam(long groupId, java.lang.String language,
		boolean approved, java.lang.String title, java.lang.String sentByUser,
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByParam(long groupId, java.lang.String language,
		boolean approved, java.lang.String title, java.lang.String sentByUser,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List getAnswer(long groupId, java.lang.String language,
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countAnswer(long groupId, java.lang.String language,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;
}