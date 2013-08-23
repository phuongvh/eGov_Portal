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

/**
 * @author hai
 */
public interface VcmsArticleFinder {
	public int countOtherArticle(long groupId, java.lang.String language,
		long statusId, java.lang.String categoryId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findOtherArticle(long groupId,
		java.lang.String language, long statusId, java.lang.String categoryId,
		java.lang.String articleId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByG_L_S_C_D(long groupId, java.lang.String language,
		long statusId, java.lang.String categoryId, java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByG_L_S_C_D(long groupId,
		java.lang.String language, long statusId, java.lang.String categoryId,
		java.util.Date fromDate, java.util.Date toDate, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findArticleByDate(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser, long typeId, int begin,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findArticleByDateNotType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countArticleByDate(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, long typeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countArticleByDateNotType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findArticleByDateTypes(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser,
		java.lang.String[] strType, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countArticleByDateTypes(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, java.lang.String[] strType)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByType(long groupId, java.lang.String language,
		long statusId, long typeId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countArticleNotInType(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countArticleAllCatNotInType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByUser(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, long typeId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByG_L_C_S_T(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, long typeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByG_L_C_S_T(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		long typeId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByG_L_S_T(long groupId, java.lang.String language,
		long statusId, long typeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByG_L_S_T(long groupId,
		java.lang.String language, long statusId, long typeId, int begin,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public int countByC_P_L_S_D(java.lang.String categoryId, long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByP_L_S_D(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByC_S(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByG_L_C_S(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByC_S_S(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, boolean sticky, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByP_S(long groupId, java.lang.String language,
		java.lang.String portionId, long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByP_S_S(long groupId, java.lang.String language,
		java.lang.String portionId, long statusId, boolean sticky, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByL_P_S_S(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int begin, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByAllL_P_S_S(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByAllL_P_S_S(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByC_S_After(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByG_L_C_S_After(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByP_S_After(long groupId,
		java.lang.String language, java.lang.String portionId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByC_S_Before(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByG_L_C_S_Before(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByG_L_P_S_Before(long groupId,
		java.lang.String language, java.lang.String portionId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByC_P_L_S(java.lang.String categoryId,
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByC_P_L_S(java.lang.String categoryId,
		long groupId, java.lang.String language, long statusId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public int countByC_P_L_S(java.lang.String categoryId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByP_P_L_S(java.lang.String portionId,
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByP_P_L_S(java.lang.String portionId,
		long groupId, java.lang.String language, long statusId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public int countByP_P_L_S(java.lang.String portionId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByT_P_L_S(java.lang.String threadId,
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByT_P_L_S(java.lang.String threadId,
		long groupId, java.lang.String language, long statusId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public int countByT_P_L_S(java.lang.String threadId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByT_P_L_S(long groupId,
		java.lang.String language, java.lang.String threadId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByT_P_L_S(long groupId,
		java.lang.String language, java.lang.String[] threadIds, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List getUpComingExpiredArticles(java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findBySearchContainer_C(java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String parentId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findBySearchContainer_C(java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String parentId,
		long typeId, boolean isTitle, boolean isLead, boolean isContent,
		boolean isDate, java.util.Date fromDate, java.util.Date toDate,
		long statusId, java.lang.String select, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countBySearchContainer_C(java.lang.String keyword, long groupId,
		java.lang.String language, java.lang.String parentId, long typeId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findBySearchContainer_P(java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String portionId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findBySearchContainer_P(java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String portionId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countBySearchContainer_P(java.lang.String keyword, long groupId,
		java.lang.String language, java.lang.String portionId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findBySearchContainer_T(java.lang.String categoryId,
		long typeId, java.lang.String keyword, long groupId,
		java.lang.String language, java.lang.String threadId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countBySearchContainer_T(java.lang.String categoryId,
		long typeId, java.lang.String keyword, long groupId,
		java.lang.String language, java.lang.String threadId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.SystemException;
}