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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.vcms.model.VcmsArticle;

import java.util.List;

/**
 * The persistence utility for the vcms article service. This utility wraps {@link VcmsArticlePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsArticlePersistence
 * @see VcmsArticlePersistenceImpl
 * @generated
 */
public class VcmsArticleUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(VcmsArticle vcmsArticle) {
		getPersistence().clearCache(vcmsArticle);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VcmsArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VcmsArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VcmsArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VcmsArticle update(VcmsArticle vcmsArticle, boolean merge)
		throws SystemException {
		return getPersistence().update(vcmsArticle, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VcmsArticle update(VcmsArticle vcmsArticle, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vcmsArticle, merge, serviceContext);
	}

	/**
	* Caches the vcms article in the entity cache if it is enabled.
	*
	* @param vcmsArticle the vcms article
	*/
	public static void cacheResult(
		com.vportal.portlet.vcms.model.VcmsArticle vcmsArticle) {
		getPersistence().cacheResult(vcmsArticle);
	}

	/**
	* Caches the vcms articles in the entity cache if it is enabled.
	*
	* @param vcmsArticles the vcms articles
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> vcmsArticles) {
		getPersistence().cacheResult(vcmsArticles);
	}

	/**
	* Creates a new vcms article with the primary key. Does not add the vcms article to the database.
	*
	* @param articleId the primary key for the new vcms article
	* @return the new vcms article
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle create(
		java.lang.String articleId) {
		return getPersistence().create(articleId);
	}

	/**
	* Removes the vcms article with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articleId the primary key of the vcms article
	* @return the vcms article that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle remove(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence().remove(articleId);
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle updateImpl(
		com.vportal.portlet.vcms.model.VcmsArticle vcmsArticle, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vcmsArticle, merge);
	}

	/**
	* Returns the vcms article with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsArticleException} if it could not be found.
	*
	* @param articleId the primary key of the vcms article
	* @return the vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByPrimaryKey(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence().findByPrimaryKey(articleId);
	}

	/**
	* Returns the vcms article with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param articleId the primary key of the vcms article
	* @return the vcms article, or <code>null</code> if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle fetchByPrimaryKey(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(articleId);
	}

	/**
	* Returns all the vcms articles where groupId = &#63; and language = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @return the matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByL_S(
		long groupId, java.lang.String language, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByL_S(groupId, language, status);
	}

	/**
	* Returns a range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @return the range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByL_S(
		long groupId, java.lang.String language, long status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByL_S(groupId, language, status, start, end);
	}

	/**
	* Returns an ordered range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByL_S(
		long groupId, java.lang.String language, long status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByL_S(groupId, language, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByL_S_First(
		long groupId, java.lang.String language, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByL_S_First(groupId, language, status, orderByComparator);
	}

	/**
	* Returns the last vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByL_S_Last(
		long groupId, java.lang.String language, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByL_S_Last(groupId, language, status, orderByComparator);
	}

	/**
	* Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the primary key of the current vcms article
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle[] findByL_S_PrevAndNext(
		java.lang.String articleId, long groupId, java.lang.String language,
		long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByL_S_PrevAndNext(articleId, groupId, language, status,
			orderByComparator);
	}

	/**
	* Returns all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param createdByUser the created by user
	* @return the matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByG_L_S_U(
		long groupId, java.lang.String language, long status,
		java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_S_U(groupId, language, status, createdByUser);
	}

	/**
	* Returns a range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param createdByUser the created by user
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @return the range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByG_L_S_U(
		long groupId, java.lang.String language, long status,
		java.lang.String createdByUser, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_S_U(groupId, language, status, createdByUser,
			start, end);
	}

	/**
	* Returns an ordered range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param createdByUser the created by user
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByG_L_S_U(
		long groupId, java.lang.String language, long status,
		java.lang.String createdByUser, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_S_U(groupId, language, status, createdByUser,
			start, end, orderByComparator);
	}

	/**
	* Returns the first vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param createdByUser the created by user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByG_L_S_U_First(
		long groupId, java.lang.String language, long status,
		java.lang.String createdByUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByG_L_S_U_First(groupId, language, status,
			createdByUser, orderByComparator);
	}

	/**
	* Returns the last vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param createdByUser the created by user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByG_L_S_U_Last(
		long groupId, java.lang.String language, long status,
		java.lang.String createdByUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByG_L_S_U_Last(groupId, language, status,
			createdByUser, orderByComparator);
	}

	/**
	* Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the primary key of the current vcms article
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param createdByUser the created by user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle[] findByG_L_S_U_PrevAndNext(
		java.lang.String articleId, long groupId, java.lang.String language,
		long status, java.lang.String createdByUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByG_L_S_U_PrevAndNext(articleId, groupId, language,
			status, createdByUser, orderByComparator);
	}

	/**
	* Returns all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param sticky the sticky
	* @return the matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByL_S_S(
		long groupId, java.lang.String language, long status, boolean sticky)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByL_S_S(groupId, language, status, sticky);
	}

	/**
	* Returns a range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param sticky the sticky
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @return the range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByL_S_S(
		long groupId, java.lang.String language, long status, boolean sticky,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByL_S_S(groupId, language, status, sticky, start, end);
	}

	/**
	* Returns an ordered range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param sticky the sticky
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByL_S_S(
		long groupId, java.lang.String language, long status, boolean sticky,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByL_S_S(groupId, language, status, sticky, start, end,
			orderByComparator);
	}

	/**
	* Returns the first vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param sticky the sticky
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByL_S_S_First(
		long groupId, java.lang.String language, long status, boolean sticky,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByL_S_S_First(groupId, language, status, sticky,
			orderByComparator);
	}

	/**
	* Returns the last vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param sticky the sticky
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByL_S_S_Last(
		long groupId, java.lang.String language, long status, boolean sticky,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByL_S_S_Last(groupId, language, status, sticky,
			orderByComparator);
	}

	/**
	* Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the primary key of the current vcms article
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param sticky the sticky
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle[] findByL_S_S_PrevAndNext(
		java.lang.String articleId, long groupId, java.lang.String language,
		long status, boolean sticky,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByL_S_S_PrevAndNext(articleId, groupId, language,
			status, sticky, orderByComparator);
	}

	/**
	* Returns all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @return the matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByU_L(
		long groupId, java.lang.String createdByUser, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_L(groupId, createdByUser, language);
	}

	/**
	* Returns a range of all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @return the range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByU_L(
		long groupId, java.lang.String createdByUser,
		java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_L(groupId, createdByUser, language, start, end);
	}

	/**
	* Returns an ordered range of all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByU_L(
		long groupId, java.lang.String createdByUser,
		java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_L(groupId, createdByUser, language, start, end,
			orderByComparator);
	}

	/**
	* Returns the first vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByU_L_First(
		long groupId, java.lang.String createdByUser,
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByU_L_First(groupId, createdByUser, language,
			orderByComparator);
	}

	/**
	* Returns the last vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByU_L_Last(
		long groupId, java.lang.String createdByUser,
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByU_L_Last(groupId, createdByUser, language,
			orderByComparator);
	}

	/**
	* Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the primary key of the current vcms article
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle[] findByU_L_PrevAndNext(
		java.lang.String articleId, long groupId,
		java.lang.String createdByUser, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByU_L_PrevAndNext(articleId, groupId, createdByUser,
			language, orderByComparator);
	}

	/**
	* Returns all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param status the status
	* @return the matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByU_L_S(
		long groupId, java.lang.String createdByUser,
		java.lang.String language, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_L_S(groupId, createdByUser, language, status);
	}

	/**
	* Returns a range of all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param status the status
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @return the range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByU_L_S(
		long groupId, java.lang.String createdByUser,
		java.lang.String language, long status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_L_S(groupId, createdByUser, language, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param status the status
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByU_L_S(
		long groupId, java.lang.String createdByUser,
		java.lang.String language, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_L_S(groupId, createdByUser, language, status,
			start, end, orderByComparator);
	}

	/**
	* Returns the first vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByU_L_S_First(
		long groupId, java.lang.String createdByUser,
		java.lang.String language, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByU_L_S_First(groupId, createdByUser, language, status,
			orderByComparator);
	}

	/**
	* Returns the last vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByU_L_S_Last(
		long groupId, java.lang.String createdByUser,
		java.lang.String language, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByU_L_S_Last(groupId, createdByUser, language, status,
			orderByComparator);
	}

	/**
	* Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the primary key of the current vcms article
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle[] findByU_L_S_PrevAndNext(
		java.lang.String articleId, long groupId,
		java.lang.String createdByUser, java.lang.String language, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByU_L_S_PrevAndNext(articleId, groupId, createdByUser,
			language, status, orderByComparator);
	}

	/**
	* Returns all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param discussible the discussible
	* @return the matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByP_L_S_D(
		long groupId, java.lang.String language, long status,
		boolean discussible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_L_S_D(groupId, language, status, discussible);
	}

	/**
	* Returns a range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param discussible the discussible
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @return the range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByP_L_S_D(
		long groupId, java.lang.String language, long status,
		boolean discussible, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_L_S_D(groupId, language, status, discussible,
			start, end);
	}

	/**
	* Returns an ordered range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param discussible the discussible
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByP_L_S_D(
		long groupId, java.lang.String language, long status,
		boolean discussible, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_L_S_D(groupId, language, status, discussible,
			start, end, orderByComparator);
	}

	/**
	* Returns the first vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param discussible the discussible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByP_L_S_D_First(
		long groupId, java.lang.String language, long status,
		boolean discussible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByP_L_S_D_First(groupId, language, status, discussible,
			orderByComparator);
	}

	/**
	* Returns the last vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param discussible the discussible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByP_L_S_D_Last(
		long groupId, java.lang.String language, long status,
		boolean discussible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByP_L_S_D_Last(groupId, language, status, discussible,
			orderByComparator);
	}

	/**
	* Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the primary key of the current vcms article
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param discussible the discussible
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle[] findByP_L_S_D_PrevAndNext(
		java.lang.String articleId, long groupId, java.lang.String language,
		long status, boolean discussible,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByP_L_S_D_PrevAndNext(articleId, groupId, language,
			status, discussible, orderByComparator);
	}

	/**
	* Returns all the vcms articles where status = &#63;.
	*
	* @param status the status
	* @return the matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByStatus(
		long status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the vcms articles where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @return the range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByStatus(
		long status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the vcms articles where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByStatus(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms article in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByStatus_First(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last vcms article in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByStatus_Last(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the vcms articles before and after the current vcms article in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the primary key of the current vcms article
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle[] findByStatus_PrevAndNext(
		java.lang.String articleId, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByStatus_PrevAndNext(articleId, status,
			orderByComparator);
	}

	/**
	* Returns all the vcms articles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the vcms articles where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @return the range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the vcms articles where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms article in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last vcms article in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the vcms articles before and after the current vcms article in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the primary key of the current vcms article
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticle[] findByCompany_PrevAndNext(
		java.lang.String articleId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleException {
		return getPersistence()
				   .findByCompany_PrevAndNext(articleId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the vcms articles.
	*
	* @return the vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vcms articles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @return the range of vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vcms articles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByL_S(long groupId, java.lang.String language,
		long status) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByL_S(groupId, language, status);
	}

	/**
	* Removes all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param createdByUser the created by user
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L_S_U(long groupId, java.lang.String language,
		long status, java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByG_L_S_U(groupId, language, status, createdByUser);
	}

	/**
	* Removes all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param sticky the sticky
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByL_S_S(long groupId, java.lang.String language,
		long status, boolean sticky)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByL_S_S(groupId, language, status, sticky);
	}

	/**
	* Removes all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_L(long groupId,
		java.lang.String createdByUser, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_L(groupId, createdByUser, language);
	}

	/**
	* Removes all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_L_S(long groupId,
		java.lang.String createdByUser, java.lang.String language, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_L_S(groupId, createdByUser, language, status);
	}

	/**
	* Removes all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param discussible the discussible
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByP_L_S_D(long groupId, java.lang.String language,
		long status, boolean discussible)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByP_L_S_D(groupId, language, status, discussible);
	}

	/**
	* Removes all the vcms articles where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Removes all the vcms articles where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the vcms articles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vcms articles where groupId = &#63; and language = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @return the number of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByL_S(long groupId, java.lang.String language,
		long status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByL_S(groupId, language, status);
	}

	/**
	* Returns the number of vcms articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param createdByUser the created by user
	* @return the number of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L_S_U(long groupId, java.lang.String language,
		long status, java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_L_S_U(groupId, language, status, createdByUser);
	}

	/**
	* Returns the number of vcms articles where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param sticky the sticky
	* @return the number of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByL_S_S(long groupId, java.lang.String language,
		long status, boolean sticky)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByL_S_S(groupId, language, status, sticky);
	}

	/**
	* Returns the number of vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @return the number of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_L(long groupId, java.lang.String createdByUser,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_L(groupId, createdByUser, language);
	}

	/**
	* Returns the number of vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param language the language
	* @param status the status
	* @return the number of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_L_S(long groupId,
		java.lang.String createdByUser, java.lang.String language, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByU_L_S(groupId, createdByUser, language, status);
	}

	/**
	* Returns the number of vcms articles where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param status the status
	* @param discussible the discussible
	* @return the number of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_L_S_D(long groupId, java.lang.String language,
		long status, boolean discussible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByP_L_S_D(groupId, language, status, discussible);
	}

	/**
	* Returns the number of vcms articles where status = &#63;.
	*
	* @param status the status
	* @return the number of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns the number of vcms articles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of vcms articles.
	*
	* @return the number of vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VcmsArticlePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VcmsArticlePersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsArticlePersistence.class.getName());

			ReferenceRegistry.registerReference(VcmsArticleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VcmsArticlePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VcmsArticleUtil.class,
			"_persistence");
	}

	private static VcmsArticlePersistence _persistence;
}