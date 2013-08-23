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
public class VcmsArticleFinderUtil {
	public static int countOtherArticle(long groupId,
		java.lang.String language, long statusId, java.lang.String categoryId,
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countOtherArticle(groupId, language, statusId, categoryId,
			articleId);
	}

	public static java.util.List findOtherArticle(long groupId,
		java.lang.String language, long statusId, java.lang.String categoryId,
		java.lang.String articleId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findOtherArticle(groupId, language, statusId, categoryId,
			articleId, begin, end);
	}

	public static int countByG_L_S_C_D(long groupId, java.lang.String language,
		long statusId, java.lang.String categoryId, java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByG_L_S_C_D(groupId, language, statusId, categoryId,
			fromDate, toDate);
	}

	public static java.util.List findByG_L_S_C_D(long groupId,
		java.lang.String language, long statusId, java.lang.String categoryId,
		java.util.Date fromDate, java.util.Date toDate, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByG_L_S_C_D(groupId, language, statusId, categoryId,
			fromDate, toDate, begin, end);
	}

	public static java.util.List findArticleByDate(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser, long typeId, int begin,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findArticleByDate(groupId, language, statusId, fromDate,
			toDate, byUser, typeId, begin, end);
	}

	public static java.util.List findArticleByDateNotType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findArticleByDateNotType(groupId, language, statusId,
			fromDate, toDate, byUser, begin, end);
	}

	public static int countArticleByDate(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser, long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countArticleByDate(groupId, language, statusId, fromDate,
			toDate, byUser, typeId);
	}

	public static int countArticleByDateNotType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countArticleByDateNotType(groupId, language, statusId,
			fromDate, toDate, byUser);
	}

	public static java.util.List findArticleByDateTypes(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser,
		java.lang.String[] strType, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findArticleByDateTypes(groupId, language, statusId,
			fromDate, toDate, byUser, strType, begin, end);
	}

	public static int countArticleByDateTypes(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser,
		java.lang.String[] strType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countArticleByDateTypes(groupId, language, statusId,
			fromDate, toDate, byUser, strType);
	}

	public static int countByType(long groupId, java.lang.String language,
		long statusId, long typeId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByType(groupId, language, statusId, typeId, fromDate,
			toDate, byUser);
	}

	public static int countArticleNotInType(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countArticleNotInType(groupId, language, categoryId,
			statusId, fromDate, toDate, byUser);
	}

	public static int countArticleAllCatNotInType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countArticleAllCatNotInType(groupId, language, statusId,
			fromDate, toDate, byUser);
	}

	public static int countByUser(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, long typeId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByUser(groupId, language, categoryId, statusId,
			typeId, fromDate, toDate, byUser);
	}

	public static int countByG_L_C_S_T(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByG_L_C_S_T(groupId, language, categoryId, statusId,
			typeId);
	}

	public static java.util.List findByG_L_C_S_T(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		long typeId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByG_L_C_S_T(groupId, language, categoryId, statusId,
			typeId, begin, end);
	}

	public static int countByG_L_S_T(long groupId, java.lang.String language,
		long statusId, long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByG_L_S_T(groupId, language, statusId, typeId);
	}

	public static java.util.List findByG_L_S_T(long groupId,
		java.lang.String language, long statusId, long typeId, int begin,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByG_L_S_T(groupId, language, statusId, typeId, begin,
			end);
	}

	public static int countByC_P_L_S_D(java.lang.String categoryId,
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_P_L_S_D(categoryId, groupId, language, statusId,
			fromDate, toDate, byUser);
	}

	public static int countByP_L_S_D(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByP_L_S_D(groupId, language, statusId, fromDate,
			toDate, byUser);
	}

	public static java.util.List findByC_S(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_S(groupId, language, categoryId, statusId, quantity);
	}

	public static java.util.List findByG_L_C_S(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByG_L_C_S(groupId, language, categoryId, statusId,
			quantity);
	}

	public static java.util.List findByC_S_S(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		boolean sticky, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_S_S(groupId, language, categoryId, statusId,
			sticky, quantity);
	}

	public static java.util.List findByP_S(long groupId,
		java.lang.String language, java.lang.String portionId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByP_S(groupId, language, portionId, statusId, quantity);
	}

	public static java.util.List findByP_S_S(long groupId,
		java.lang.String language, java.lang.String portionId, long statusId,
		boolean sticky, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByP_S_S(groupId, language, portionId, statusId, sticky,
			quantity);
	}

	public static java.util.List findByL_P_S_S(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int begin, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByL_P_S_S(groupId, language, categoryId, statusId,
			begin, end, obc);
	}

	public static java.util.List findByAllL_P_S_S(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByAllL_P_S_S(groupId, language, categoryId, statusId,
			begin, end);
	}

	public static int countByAllL_P_S_S(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByAllL_P_S_S(groupId, language, categoryId, statusId);
	}

	public static java.util.List findByC_S_After(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_S_After(groupId, language, categoryId, statusId,
			quantity, date);
	}

	public static java.util.List findByG_L_C_S_After(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByG_L_C_S_After(groupId, language, categoryId,
			statusId, quantity, date);
	}

	public static java.util.List findByP_S_After(long groupId,
		java.lang.String language, java.lang.String portionId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByP_S_After(groupId, language, portionId, statusId,
			quantity, date);
	}

	public static java.util.List findByC_S_Before(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_S_Before(groupId, language, categoryId, statusId,
			quantity, date);
	}

	public static java.util.List findByG_L_C_S_Before(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByG_L_C_S_Before(groupId, language, categoryId,
			statusId, quantity, date);
	}

	public static java.util.List findByG_L_P_S_Before(long groupId,
		java.lang.String language, java.lang.String portionId, long statusId,
		int quantity, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByG_L_P_S_Before(groupId, language, portionId,
			statusId, quantity, date);
	}

	public static java.util.List findByC_P_L_S(java.lang.String categoryId,
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByC_P_L_S(categoryId, groupId, language, statusId);
	}

	public static java.util.List findByC_P_L_S(java.lang.String categoryId,
		long groupId, java.lang.String language, long statusId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_P_L_S(categoryId, groupId, language, statusId,
			start, end);
	}

	public static int countByC_P_L_S(java.lang.String categoryId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByC_P_L_S(categoryId, groupId, language, statusId);
	}

	public static java.util.List findByP_P_L_S(java.lang.String portionId,
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByP_P_L_S(portionId, groupId, language, statusId);
	}

	public static java.util.List findByP_P_L_S(java.lang.String portionId,
		long groupId, java.lang.String language, long statusId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByP_P_L_S(portionId, groupId, language, statusId,
			start, end);
	}

	public static int countByP_P_L_S(java.lang.String portionId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByP_P_L_S(portionId, groupId, language, statusId);
	}

	public static java.util.List findByT_P_L_S(java.lang.String threadId,
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByT_P_L_S(threadId, groupId, language, statusId);
	}

	public static java.util.List findByT_P_L_S(java.lang.String threadId,
		long groupId, java.lang.String language, long statusId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByT_P_L_S(threadId, groupId, language, statusId, start,
			end);
	}

	public static int countByT_P_L_S(java.lang.String threadId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByT_P_L_S(threadId, groupId, language, statusId);
	}

	public static java.util.List findByT_P_L_S(long groupId,
		java.lang.String language, java.lang.String threadId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByT_P_L_S(groupId, language, threadId, statusId,
			quantity);
	}

	public static java.util.List findByT_P_L_S(long groupId,
		java.lang.String language, java.lang.String[] threadIds, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByT_P_L_S(groupId, language, threadIds, statusId,
			quantity);
	}

	public static java.util.List getUpComingExpiredArticles(java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getUpComingExpiredArticles(date);
	}

	public static java.util.List findBySearchContainer_C(
		java.lang.String keyword, long groupId, java.lang.String language,
		java.lang.String parentId, boolean isTitle, boolean isLead,
		boolean isContent, boolean isDate, java.util.Date fromDate,
		java.util.Date toDate, long statusId, java.lang.String select)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findBySearchContainer_C(keyword, groupId, language,
			parentId, isTitle, isLead, isContent, isDate, fromDate, toDate,
			statusId, select);
	}

	public static java.util.List findBySearchContainer_C(
		java.lang.String keyword, long groupId, java.lang.String language,
		java.lang.String parentId, long typeId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findBySearchContainer_C(keyword, groupId, language,
			parentId, typeId, isTitle, isLead, isContent, isDate, fromDate,
			toDate, statusId, select, start, end);
	}

	public static int countBySearchContainer_C(java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String parentId,
		long typeId, boolean isTitle, boolean isLead, boolean isContent,
		boolean isDate, java.util.Date fromDate, java.util.Date toDate,
		long statusId, java.lang.String select)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countBySearchContainer_C(keyword, groupId, language,
			parentId, typeId, isTitle, isLead, isContent, isDate, fromDate,
			toDate, statusId, select);
	}

	public static java.util.List findBySearchContainer_P(
		java.lang.String keyword, long groupId, java.lang.String language,
		java.lang.String portionId, boolean isTitle, boolean isLead,
		boolean isContent, boolean isDate, java.util.Date fromDate,
		java.util.Date toDate, long statusId, java.lang.String select)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findBySearchContainer_P(keyword, groupId, language,
			portionId, isTitle, isLead, isContent, isDate, fromDate, toDate,
			statusId, select);
	}

	public static java.util.List findBySearchContainer_P(
		java.lang.String keyword, long groupId, java.lang.String language,
		java.lang.String portionId, boolean isTitle, boolean isLead,
		boolean isContent, boolean isDate, java.util.Date fromDate,
		java.util.Date toDate, long statusId, java.lang.String select,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findBySearchContainer_P(keyword, groupId, language,
			portionId, isTitle, isLead, isContent, isDate, fromDate, toDate,
			statusId, select, start, end);
	}

	public static int countBySearchContainer_P(java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String portionId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countBySearchContainer_P(keyword, groupId, language,
			portionId, isTitle, isLead, isContent, isDate, fromDate, toDate,
			statusId, select);
	}

	public static java.util.List findBySearchContainer_T(
		java.lang.String categoryId, long typeId, java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String threadId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findBySearchContainer_T(categoryId, typeId, keyword,
			groupId, language, threadId, isTitle, isLead, isContent, isDate,
			fromDate, toDate, statusId, select, start, end);
	}

	public static int countBySearchContainer_T(java.lang.String categoryId,
		long typeId, java.lang.String keyword, long groupId,
		java.lang.String language, java.lang.String threadId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countBySearchContainer_T(categoryId, typeId, keyword,
			groupId, language, threadId, isTitle, isLead, isContent, isDate,
			fromDate, toDate, statusId, select);
	}

	public static VcmsArticleFinder getFinder() {
		if (_finder == null) {
			_finder = (VcmsArticleFinder)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsArticleFinder.class.getName());

			ReferenceRegistry.registerReference(VcmsArticleFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VcmsArticleFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VcmsArticleFinderUtil.class,
			"_finder");
	}

	private static VcmsArticleFinder _finder;
}