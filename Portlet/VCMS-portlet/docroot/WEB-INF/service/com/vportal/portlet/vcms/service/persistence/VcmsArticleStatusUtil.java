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

import com.vportal.portlet.vcms.model.VcmsArticleStatus;

import java.util.List;

/**
 * The persistence utility for the vcms article status service. This utility wraps {@link VcmsArticleStatusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsArticleStatusPersistence
 * @see VcmsArticleStatusPersistenceImpl
 * @generated
 */
public class VcmsArticleStatusUtil {
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
	public static void clearCache(VcmsArticleStatus vcmsArticleStatus) {
		getPersistence().clearCache(vcmsArticleStatus);
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
	public static List<VcmsArticleStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VcmsArticleStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VcmsArticleStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VcmsArticleStatus update(
		VcmsArticleStatus vcmsArticleStatus, boolean merge)
		throws SystemException {
		return getPersistence().update(vcmsArticleStatus, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VcmsArticleStatus update(
		VcmsArticleStatus vcmsArticleStatus, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vcmsArticleStatus, merge, serviceContext);
	}

	/**
	* Caches the vcms article status in the entity cache if it is enabled.
	*
	* @param vcmsArticleStatus the vcms article status
	*/
	public static void cacheResult(
		com.vportal.portlet.vcms.model.VcmsArticleStatus vcmsArticleStatus) {
		getPersistence().cacheResult(vcmsArticleStatus);
	}

	/**
	* Caches the vcms article statuses in the entity cache if it is enabled.
	*
	* @param vcmsArticleStatuses the vcms article statuses
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> vcmsArticleStatuses) {
		getPersistence().cacheResult(vcmsArticleStatuses);
	}

	/**
	* Creates a new vcms article status with the primary key. Does not add the vcms article status to the database.
	*
	* @param id the primary key for the new vcms article status
	* @return the new vcms article status
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the vcms article status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the vcms article status
	* @return the vcms article status that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence().remove(id);
	}

	public static com.vportal.portlet.vcms.model.VcmsArticleStatus updateImpl(
		com.vportal.portlet.vcms.model.VcmsArticleStatus vcmsArticleStatus,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vcmsArticleStatus, merge);
	}

	/**
	* Returns the vcms article status with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException} if it could not be found.
	*
	* @param id the primary key of the vcms article status
	* @return the vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the vcms article status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the vcms article status
	* @return the vcms article status, or <code>null</code> if a vcms article status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the vcms article statuses where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticle(articleId);
	}

	/**
	* Returns a range of all the vcms article statuses where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms article statuses
	* @param end the upper bound of the range of vcms article statuses (not inclusive)
	* @return the range of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByArticle(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticle(articleId, start, end);
	}

	/**
	* Returns an ordered range of all the vcms article statuses where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms article statuses
	* @param end the upper bound of the range of vcms article statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByArticle(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArticle(articleId, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms article status in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus findByArticle_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence().findByArticle_First(articleId, orderByComparator);
	}

	/**
	* Returns the last vcms article status in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus findByArticle_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence().findByArticle_Last(articleId, orderByComparator);
	}

	/**
	* Returns the vcms article statuses before and after the current vcms article status in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vcms article status
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus[] findByArticle_PrevAndNext(
		long id, java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence()
				   .findByArticle_PrevAndNext(id, articleId, orderByComparator);
	}

	/**
	* Returns all the vcms article statuses where active = &#63;.
	*
	* @param active the active
	* @return the matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByActive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive(active);
	}

	/**
	* Returns a range of all the vcms article statuses where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of vcms article statuses
	* @param end the upper bound of the range of vcms article statuses (not inclusive)
	* @return the range of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByActive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive(active, start, end);
	}

	/**
	* Returns an ordered range of all the vcms article statuses where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of vcms article statuses
	* @param end the upper bound of the range of vcms article statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActive(active, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms article status in the ordered set where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus findByActive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	* Returns the last vcms article status in the ordered set where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus findByActive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	* Returns the vcms article statuses before and after the current vcms article status in the ordered set where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vcms article status
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus[] findByActive_PrevAndNext(
		long id, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence()
				   .findByActive_PrevAndNext(id, active, orderByComparator);
	}

	/**
	* Returns all the vcms article statuses where createdByUser = &#63;.
	*
	* @param createdByUser the created by user
	* @return the matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByUser(
		java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(createdByUser);
	}

	/**
	* Returns a range of all the vcms article statuses where createdByUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param start the lower bound of the range of vcms article statuses
	* @param end the upper bound of the range of vcms article statuses (not inclusive)
	* @return the range of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByUser(
		java.lang.String createdByUser, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(createdByUser, start, end);
	}

	/**
	* Returns an ordered range of all the vcms article statuses where createdByUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param start the lower bound of the range of vcms article statuses
	* @param end the upper bound of the range of vcms article statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByUser(
		java.lang.String createdByUser, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser(createdByUser, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms article status in the ordered set where createdByUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus findByUser_First(
		java.lang.String createdByUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence()
				   .findByUser_First(createdByUser, orderByComparator);
	}

	/**
	* Returns the last vcms article status in the ordered set where createdByUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus findByUser_Last(
		java.lang.String createdByUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence().findByUser_Last(createdByUser, orderByComparator);
	}

	/**
	* Returns the vcms article statuses before and after the current vcms article status in the ordered set where createdByUser = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vcms article status
	* @param createdByUser the created by user
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus[] findByUser_PrevAndNext(
		long id, java.lang.String createdByUser,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence()
				   .findByUser_PrevAndNext(id, createdByUser, orderByComparator);
	}

	/**
	* Returns all the vcms article statuses where createdByUser = &#63; and active = &#63;.
	*
	* @param createdByUser the created by user
	* @param active the active
	* @return the matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByU_A(
		java.lang.String createdByUser, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_A(createdByUser, active);
	}

	/**
	* Returns a range of all the vcms article statuses where createdByUser = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param active the active
	* @param start the lower bound of the range of vcms article statuses
	* @param end the upper bound of the range of vcms article statuses (not inclusive)
	* @return the range of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByU_A(
		java.lang.String createdByUser, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_A(createdByUser, active, start, end);
	}

	/**
	* Returns an ordered range of all the vcms article statuses where createdByUser = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param active the active
	* @param start the lower bound of the range of vcms article statuses
	* @param end the upper bound of the range of vcms article statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findByU_A(
		java.lang.String createdByUser, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_A(createdByUser, active, start, end,
			orderByComparator);
	}

	/**
	* Returns the first vcms article status in the ordered set where createdByUser = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus findByU_A_First(
		java.lang.String createdByUser, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence()
				   .findByU_A_First(createdByUser, active, orderByComparator);
	}

	/**
	* Returns the last vcms article status in the ordered set where createdByUser = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus findByU_A_Last(
		java.lang.String createdByUser, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence()
				   .findByU_A_Last(createdByUser, active, orderByComparator);
	}

	/**
	* Returns the vcms article statuses before and after the current vcms article status in the ordered set where createdByUser = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vcms article status
	* @param createdByUser the created by user
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article status
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleStatus[] findByU_A_PrevAndNext(
		long id, java.lang.String createdByUser, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException {
		return getPersistence()
				   .findByU_A_PrevAndNext(id, createdByUser, active,
			orderByComparator);
	}

	/**
	* Returns all the vcms article statuses.
	*
	* @return the vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vcms article statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms article statuses
	* @param end the upper bound of the range of vcms article statuses (not inclusive)
	* @return the range of vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vcms article statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms article statuses
	* @param end the upper bound of the range of vcms article statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vcms article statuses where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArticle(articleId);
	}

	/**
	* Removes all the vcms article statuses where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByActive(active);
	}

	/**
	* Removes all the vcms article statuses where createdByUser = &#63; from the database.
	*
	* @param createdByUser the created by user
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(createdByUser);
	}

	/**
	* Removes all the vcms article statuses where createdByUser = &#63; and active = &#63; from the database.
	*
	* @param createdByUser the created by user
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_A(java.lang.String createdByUser,
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_A(createdByUser, active);
	}

	/**
	* Removes all the vcms article statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vcms article statuses where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArticle(articleId);
	}

	/**
	* Returns the number of vcms article statuses where active = &#63;.
	*
	* @param active the active
	* @return the number of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByActive(active);
	}

	/**
	* Returns the number of vcms article statuses where createdByUser = &#63;.
	*
	* @param createdByUser the created by user
	* @return the number of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(createdByUser);
	}

	/**
	* Returns the number of vcms article statuses where createdByUser = &#63; and active = &#63;.
	*
	* @param createdByUser the created by user
	* @param active the active
	* @return the number of matching vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_A(java.lang.String createdByUser, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_A(createdByUser, active);
	}

	/**
	* Returns the number of vcms article statuses.
	*
	* @return the number of vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VcmsArticleStatusPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VcmsArticleStatusPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsArticleStatusPersistence.class.getName());

			ReferenceRegistry.registerReference(VcmsArticleStatusUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VcmsArticleStatusPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VcmsArticleStatusUtil.class,
			"_persistence");
	}

	private static VcmsArticleStatusPersistence _persistence;
}