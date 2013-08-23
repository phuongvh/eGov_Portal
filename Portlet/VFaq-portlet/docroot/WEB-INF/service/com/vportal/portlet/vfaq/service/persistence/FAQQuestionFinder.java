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
public interface FAQQuestionFinder {
	public java.util.List findByCategoryId(long groupId,
		java.lang.String language, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByG_Q_A(long groupId, java.lang.String language,
		int quantity, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByC_S(long groupId, java.lang.String language,
		long categoryId, java.lang.String title, int begin, int end,
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByC_S(long groupId, java.lang.String language,
		long categoryId, java.lang.String title, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByC_S(long groupId, java.lang.String language,
		long categoryId, java.lang.String title, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findQuestionByParam(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		java.lang.String sentByUser, boolean approved, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countQuestionByParam(long groupId, java.lang.String language,
		long categoryId, java.lang.String title, java.lang.String sentByUser,
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findOtherQuestionByParam(long groupId,
		java.lang.String language, long Id, long categoryId, boolean approved,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findQuestion(long groupId, java.lang.String language,
		long categoryId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countQuestion(long groupId, java.lang.String language,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findQuestionByParamArrange(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		java.lang.String sentByUser, boolean approved,
		java.lang.String clickValue, java.lang.String arrange, int begin,
		int end) throws com.liferay.portal.kernel.exception.SystemException;
}