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

import com.vportal.portlet.vcms.model.VcmsArticleType;

import java.util.List;

/**
 * The persistence utility for the vcms article type service. This utility wraps {@link VcmsArticleTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsArticleTypePersistence
 * @see VcmsArticleTypePersistenceImpl
 * @generated
 */
public class VcmsArticleTypeUtil {
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
	public static void clearCache(VcmsArticleType vcmsArticleType) {
		getPersistence().clearCache(vcmsArticleType);
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
	public static List<VcmsArticleType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VcmsArticleType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VcmsArticleType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VcmsArticleType update(VcmsArticleType vcmsArticleType,
		boolean merge) throws SystemException {
		return getPersistence().update(vcmsArticleType, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VcmsArticleType update(VcmsArticleType vcmsArticleType,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vcmsArticleType, merge, serviceContext);
	}

	/**
	* Caches the vcms article type in the entity cache if it is enabled.
	*
	* @param vcmsArticleType the vcms article type
	*/
	public static void cacheResult(
		com.vportal.portlet.vcms.model.VcmsArticleType vcmsArticleType) {
		getPersistence().cacheResult(vcmsArticleType);
	}

	/**
	* Caches the vcms article types in the entity cache if it is enabled.
	*
	* @param vcmsArticleTypes the vcms article types
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> vcmsArticleTypes) {
		getPersistence().cacheResult(vcmsArticleTypes);
	}

	/**
	* Creates a new vcms article type with the primary key. Does not add the vcms article type to the database.
	*
	* @param vcmsArticleTypePK the primary key for the new vcms article type
	* @return the new vcms article type
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType create(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK) {
		return getPersistence().create(vcmsArticleTypePK);
	}

	/**
	* Removes the vcms article type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleTypePK the primary key of the vcms article type
	* @return the vcms article type that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType remove(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException {
		return getPersistence().remove(vcmsArticleTypePK);
	}

	public static com.vportal.portlet.vcms.model.VcmsArticleType updateImpl(
		com.vportal.portlet.vcms.model.VcmsArticleType vcmsArticleType,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vcmsArticleType, merge);
	}

	/**
	* Returns the vcms article type with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException} if it could not be found.
	*
	* @param vcmsArticleTypePK the primary key of the vcms article type
	* @return the vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType findByPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException {
		return getPersistence().findByPrimaryKey(vcmsArticleTypePK);
	}

	/**
	* Returns the vcms article type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vcmsArticleTypePK the primary key of the vcms article type
	* @return the vcms article type, or <code>null</code> if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType fetchByPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vcmsArticleTypePK);
	}

	/**
	* Returns all the vcms article types where typeId = &#63;.
	*
	* @param typeId the type ID
	* @return the matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByType(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(typeId);
	}

	/**
	* Returns a range of all the vcms article types where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @return the range of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByType(
		long typeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(typeId, start, end);
	}

	/**
	* Returns an ordered range of all the vcms article types where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByType(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(typeId, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms article type in the ordered set where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType findByType_First(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException {
		return getPersistence().findByType_First(typeId, orderByComparator);
	}

	/**
	* Returns the last vcms article type in the ordered set where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType findByType_Last(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException {
		return getPersistence().findByType_Last(typeId, orderByComparator);
	}

	/**
	* Returns the vcms article types before and after the current vcms article type in the ordered set where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vcmsArticleTypePK the primary key of the current vcms article type
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType[] findByType_PrevAndNext(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK,
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException {
		return getPersistence()
				   .findByType_PrevAndNext(vcmsArticleTypePK, typeId,
			orderByComparator);
	}

	/**
	* Returns all the vcms article types where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticle(articleId);
	}

	/**
	* Returns a range of all the vcms article types where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @return the range of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByArticle(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticle(articleId, start, end);
	}

	/**
	* Returns an ordered range of all the vcms article types where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByArticle(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArticle(articleId, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms article type in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType findByArticle_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException {
		return getPersistence().findByArticle_First(articleId, orderByComparator);
	}

	/**
	* Returns the last vcms article type in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType findByArticle_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException {
		return getPersistence().findByArticle_Last(articleId, orderByComparator);
	}

	/**
	* Returns the vcms article types before and after the current vcms article type in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vcmsArticleTypePK the primary key of the current vcms article type
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType[] findByArticle_PrevAndNext(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK,
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException {
		return getPersistence()
				   .findByArticle_PrevAndNext(vcmsArticleTypePK, articleId,
			orderByComparator);
	}

	/**
	* Returns the vcms article type where typeId = &#63; and articleId = &#63; or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException} if it could not be found.
	*
	* @param typeId the type ID
	* @param articleId the article ID
	* @return the matching vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType findByArticleByType(
		long typeId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException {
		return getPersistence().findByArticleByType(typeId, articleId);
	}

	/**
	* Returns the vcms article type where typeId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param typeId the type ID
	* @param articleId the article ID
	* @return the matching vcms article type, or <code>null</code> if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType fetchByArticleByType(
		long typeId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByArticleByType(typeId, articleId);
	}

	/**
	* Returns the vcms article type where typeId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param typeId the type ID
	* @param articleId the article ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vcms article type, or <code>null</code> if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleType fetchByArticleByType(
		long typeId, java.lang.String articleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByArticleByType(typeId, articleId, retrieveFromCache);
	}

	/**
	* Returns all the vcms article types.
	*
	* @return the vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vcms article types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @return the range of vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vcms article types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vcms article types where typeId = &#63; from the database.
	*
	* @param typeId the type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(typeId);
	}

	/**
	* Removes all the vcms article types where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArticle(articleId);
	}

	/**
	* Removes the vcms article type where typeId = &#63; and articleId = &#63; from the database.
	*
	* @param typeId the type ID
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArticleByType(long typeId,
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException {
		getPersistence().removeByArticleByType(typeId, articleId);
	}

	/**
	* Removes all the vcms article types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vcms article types where typeId = &#63;.
	*
	* @param typeId the type ID
	* @return the number of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(typeId);
	}

	/**
	* Returns the number of vcms article types where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArticle(articleId);
	}

	/**
	* Returns the number of vcms article types where typeId = &#63; and articleId = &#63;.
	*
	* @param typeId the type ID
	* @param articleId the article ID
	* @return the number of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArticleByType(long typeId,
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArticleByType(typeId, articleId);
	}

	/**
	* Returns the number of vcms article types.
	*
	* @return the number of vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VcmsArticleTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VcmsArticleTypePersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsArticleTypePersistence.class.getName());

			ReferenceRegistry.registerReference(VcmsArticleTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VcmsArticleTypePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VcmsArticleTypeUtil.class,
			"_persistence");
	}

	private static VcmsArticleTypePersistence _persistence;
}