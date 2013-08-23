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

import com.vportal.portlet.vcms.model.VcmsCategory;

import java.util.List;

/**
 * The persistence utility for the vcms category service. This utility wraps {@link VcmsCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsCategoryPersistence
 * @see VcmsCategoryPersistenceImpl
 * @generated
 */
public class VcmsCategoryUtil {
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
	public static void clearCache(VcmsCategory vcmsCategory) {
		getPersistence().clearCache(vcmsCategory);
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
	public static List<VcmsCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VcmsCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VcmsCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VcmsCategory update(VcmsCategory vcmsCategory, boolean merge)
		throws SystemException {
		return getPersistence().update(vcmsCategory, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VcmsCategory update(VcmsCategory vcmsCategory, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vcmsCategory, merge, serviceContext);
	}

	/**
	* Caches the vcms category in the entity cache if it is enabled.
	*
	* @param vcmsCategory the vcms category
	*/
	public static void cacheResult(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory) {
		getPersistence().cacheResult(vcmsCategory);
	}

	/**
	* Caches the vcms categories in the entity cache if it is enabled.
	*
	* @param vcmsCategories the vcms categories
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> vcmsCategories) {
		getPersistence().cacheResult(vcmsCategories);
	}

	/**
	* Creates a new vcms category with the primary key. Does not add the vcms category to the database.
	*
	* @param categoryId the primary key for the new vcms category
	* @return the new vcms category
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory create(
		java.lang.String categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the vcms category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the vcms category
	* @return the vcms category that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory remove(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.vportal.portlet.vcms.model.VcmsCategory updateImpl(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vcmsCategory, merge);
	}

	/**
	* Returns the vcms category with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the vcms category
	* @return the vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory findByPrimaryKey(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the vcms category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the vcms category
	* @return the vcms category, or <code>null</code> if a vcms category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory fetchByPrimaryKey(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the vcms categories where groupId = &#63; and portionId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param language the language
	* @return the matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByPortion_Language(
		long groupId, java.lang.String portionId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPortion_Language(groupId, portionId, language);
	}

	/**
	* Returns a range of all the vcms categories where groupId = &#63; and portionId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param language the language
	* @param start the lower bound of the range of vcms categories
	* @param end the upper bound of the range of vcms categories (not inclusive)
	* @return the range of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByPortion_Language(
		long groupId, java.lang.String portionId, java.lang.String language,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPortion_Language(groupId, portionId, language, start,
			end);
	}

	/**
	* Returns an ordered range of all the vcms categories where groupId = &#63; and portionId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param language the language
	* @param start the lower bound of the range of vcms categories
	* @param end the upper bound of the range of vcms categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByPortion_Language(
		long groupId, java.lang.String portionId, java.lang.String language,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPortion_Language(groupId, portionId, language, start,
			end, orderByComparator);
	}

	/**
	* Returns the first vcms category in the ordered set where groupId = &#63; and portionId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory findByPortion_Language_First(
		long groupId, java.lang.String portionId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByPortion_Language_First(groupId, portionId, language,
			orderByComparator);
	}

	/**
	* Returns the last vcms category in the ordered set where groupId = &#63; and portionId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory findByPortion_Language_Last(
		long groupId, java.lang.String portionId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByPortion_Language_Last(groupId, portionId, language,
			orderByComparator);
	}

	/**
	* Returns the vcms categories before and after the current vcms category in the ordered set where groupId = &#63; and portionId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the primary key of the current vcms category
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory[] findByPortion_Language_PrevAndNext(
		java.lang.String categoryId, long groupId, java.lang.String portionId,
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByPortion_Language_PrevAndNext(categoryId, groupId,
			portionId, language, orderByComparator);
	}

	/**
	* Returns all the vcms categories where groupId = &#63; and parentId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param language the language
	* @return the matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByParent_Language(
		long groupId, java.lang.String parentId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParent_Language(groupId, parentId, language);
	}

	/**
	* Returns a range of all the vcms categories where groupId = &#63; and parentId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param language the language
	* @param start the lower bound of the range of vcms categories
	* @param end the upper bound of the range of vcms categories (not inclusive)
	* @return the range of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByParent_Language(
		long groupId, java.lang.String parentId, java.lang.String language,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParent_Language(groupId, parentId, language, start,
			end);
	}

	/**
	* Returns an ordered range of all the vcms categories where groupId = &#63; and parentId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param language the language
	* @param start the lower bound of the range of vcms categories
	* @param end the upper bound of the range of vcms categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByParent_Language(
		long groupId, java.lang.String parentId, java.lang.String language,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParent_Language(groupId, parentId, language, start,
			end, orderByComparator);
	}

	/**
	* Returns the first vcms category in the ordered set where groupId = &#63; and parentId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory findByParent_Language_First(
		long groupId, java.lang.String parentId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByParent_Language_First(groupId, parentId, language,
			orderByComparator);
	}

	/**
	* Returns the last vcms category in the ordered set where groupId = &#63; and parentId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory findByParent_Language_Last(
		long groupId, java.lang.String parentId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByParent_Language_Last(groupId, parentId, language,
			orderByComparator);
	}

	/**
	* Returns the vcms categories before and after the current vcms category in the ordered set where groupId = &#63; and parentId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the primary key of the current vcms category
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory[] findByParent_Language_PrevAndNext(
		java.lang.String categoryId, long groupId, java.lang.String parentId,
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByParent_Language_PrevAndNext(categoryId, groupId,
			parentId, language, orderByComparator);
	}

	/**
	* Returns all the vcms categories where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByLanguage(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLanguage(groupId, language);
	}

	/**
	* Returns a range of all the vcms categories where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vcms categories
	* @param end the upper bound of the range of vcms categories (not inclusive)
	* @return the range of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByLanguage(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLanguage(groupId, language, start, end);
	}

	/**
	* Returns an ordered range of all the vcms categories where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vcms categories
	* @param end the upper bound of the range of vcms categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByLanguage(
		long groupId, java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLanguage(groupId, language, start, end,
			orderByComparator);
	}

	/**
	* Returns the first vcms category in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory findByLanguage_First(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByLanguage_First(groupId, language, orderByComparator);
	}

	/**
	* Returns the last vcms category in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory findByLanguage_Last(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByLanguage_Last(groupId, language, orderByComparator);
	}

	/**
	* Returns the vcms categories before and after the current vcms category in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the primary key of the current vcms category
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory[] findByLanguage_PrevAndNext(
		java.lang.String categoryId, long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByLanguage_PrevAndNext(categoryId, groupId, language,
			orderByComparator);
	}

	/**
	* Returns all the vcms categories where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param parentId the parent ID
	* @param language the language
	* @return the matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByP_P_L(
		long groupId, java.lang.String portionId, java.lang.String parentId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_P_L(groupId, portionId, parentId, language);
	}

	/**
	* Returns a range of all the vcms categories where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param parentId the parent ID
	* @param language the language
	* @param start the lower bound of the range of vcms categories
	* @param end the upper bound of the range of vcms categories (not inclusive)
	* @return the range of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByP_P_L(
		long groupId, java.lang.String portionId, java.lang.String parentId,
		java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_P_L(groupId, portionId, parentId, language, start,
			end);
	}

	/**
	* Returns an ordered range of all the vcms categories where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param parentId the parent ID
	* @param language the language
	* @param start the lower bound of the range of vcms categories
	* @param end the upper bound of the range of vcms categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findByP_P_L(
		long groupId, java.lang.String portionId, java.lang.String parentId,
		java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_P_L(groupId, portionId, parentId, language, start,
			end, orderByComparator);
	}

	/**
	* Returns the first vcms category in the ordered set where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param parentId the parent ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory findByP_P_L_First(
		long groupId, java.lang.String portionId, java.lang.String parentId,
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByP_P_L_First(groupId, portionId, parentId, language,
			orderByComparator);
	}

	/**
	* Returns the last vcms category in the ordered set where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param parentId the parent ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory findByP_P_L_Last(
		long groupId, java.lang.String portionId, java.lang.String parentId,
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByP_P_L_Last(groupId, portionId, parentId, language,
			orderByComparator);
	}

	/**
	* Returns the vcms categories before and after the current vcms category in the ordered set where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the primary key of the current vcms category
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param parentId the parent ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms category
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory[] findByP_P_L_PrevAndNext(
		java.lang.String categoryId, long groupId, java.lang.String portionId,
		java.lang.String parentId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCategoryException {
		return getPersistence()
				   .findByP_P_L_PrevAndNext(categoryId, groupId, portionId,
			parentId, language, orderByComparator);
	}

	/**
	* Returns all the vcms categories.
	*
	* @return the vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vcms categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms categories
	* @param end the upper bound of the range of vcms categories (not inclusive)
	* @return the range of vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vcms categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms categories
	* @param end the upper bound of the range of vcms categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vcms categories where groupId = &#63; and portionId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPortion_Language(long groupId,
		java.lang.String portionId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPortion_Language(groupId, portionId, language);
	}

	/**
	* Removes all the vcms categories where groupId = &#63; and parentId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParent_Language(long groupId,
		java.lang.String parentId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParent_Language(groupId, parentId, language);
	}

	/**
	* Removes all the vcms categories where groupId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLanguage(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLanguage(groupId, language);
	}

	/**
	* Removes all the vcms categories where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param parentId the parent ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByP_P_L(long groupId, java.lang.String portionId,
		java.lang.String parentId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByP_P_L(groupId, portionId, parentId, language);
	}

	/**
	* Removes all the vcms categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vcms categories where groupId = &#63; and portionId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param language the language
	* @return the number of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPortion_Language(long groupId,
		java.lang.String portionId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPortion_Language(groupId, portionId, language);
	}

	/**
	* Returns the number of vcms categories where groupId = &#63; and parentId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param language the language
	* @return the number of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParent_Language(long groupId,
		java.lang.String parentId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByParent_Language(groupId, parentId, language);
	}

	/**
	* Returns the number of vcms categories where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the number of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLanguage(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLanguage(groupId, language);
	}

	/**
	* Returns the number of vcms categories where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param portionId the portion ID
	* @param parentId the parent ID
	* @param language the language
	* @return the number of matching vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_P_L(long groupId, java.lang.String portionId,
		java.lang.String parentId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByP_P_L(groupId, portionId, parentId, language);
	}

	/**
	* Returns the number of vcms categories.
	*
	* @return the number of vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VcmsCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VcmsCategoryPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(VcmsCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VcmsCategoryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VcmsCategoryUtil.class,
			"_persistence");
	}

	private static VcmsCategoryPersistence _persistence;
}