/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.vimagegallery.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.vimagegallery.model.TFImage;

import java.util.List;

/**
 * The persistence utility for the t f image service. This utility wraps {@link TFImagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucNN
 * @see TFImagePersistence
 * @see TFImagePersistenceImpl
 * @generated
 */
public class TFImageUtil {
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
	public static void clearCache(TFImage tfImage) {
		getPersistence().clearCache(tfImage);
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
	public static List<TFImage> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TFImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TFImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TFImage update(TFImage tfImage, boolean merge)
		throws SystemException {
		return getPersistence().update(tfImage, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TFImage update(TFImage tfImage, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tfImage, merge, serviceContext);
	}

	/**
	* Caches the t f image in the entity cache if it is enabled.
	*
	* @param tfImage the t f image
	*/
	public static void cacheResult(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage) {
		getPersistence().cacheResult(tfImage);
	}

	/**
	* Caches the t f images in the entity cache if it is enabled.
	*
	* @param tfImages the t f images
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> tfImages) {
		getPersistence().cacheResult(tfImages);
	}

	/**
	* Creates a new t f image with the primary key. Does not add the t f image to the database.
	*
	* @param id the primary key for the new t f image
	* @return the new t f image
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the t f image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the t f image
	* @return the t f image that was removed
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence().remove(id);
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage updateImpl(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tfImage, merge);
	}

	/**
	* Returns the t f image with the primary key or throws a {@link com.vportal.portlet.vimagegallery.NoSuchTFImageException} if it could not be found.
	*
	* @param id the primary key of the t f image
	* @return the t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the t f image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the t f image
	* @return the t f image, or <code>null</code> if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the t f images where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C(groupId, categoryId);
	}

	/**
	* Returns a range of all the t f images where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @return the range of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C(groupId, categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the t f images where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C(groupId, categoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first t f image in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage findByG_C_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByG_C_First(groupId, categoryId, orderByComparator);
	}

	/**
	* Returns the last t f image in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage findByG_C_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByG_C_Last(groupId, categoryId, orderByComparator);
	}

	/**
	* Returns the t f images before and after the current t f image in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t f image
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage[] findByG_C_PrevAndNext(
		long id, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByG_C_PrevAndNext(id, groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns all the t f images that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_C(groupId, categoryId);
	}

	/**
	* Returns a range of all the t f images that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @return the range of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_C(groupId, categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the t f images that the user has permissions to view where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C(groupId, categoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the t f images before and after the current t f image in the ordered set of t f images that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param id the primary key of the current t f image
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage[] filterFindByG_C_PrevAndNext(
		long id, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .filterFindByG_C_PrevAndNext(id, groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns all the t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @return the matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C_I(
		long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C_I(groupId, categoryId, isShow);
	}

	/**
	* Returns a range of all the t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @return the range of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C_I(
		long groupId, long categoryId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_I(groupId, categoryId, isShow, start, end);
	}

	/**
	* Returns an ordered range of all the t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C_I(
		long groupId, long categoryId, boolean isShow, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_I(groupId, categoryId, isShow, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t f image in the ordered set where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage findByG_C_I_First(
		long groupId, long categoryId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByG_C_I_First(groupId, categoryId, isShow,
			orderByComparator);
	}

	/**
	* Returns the last t f image in the ordered set where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage findByG_C_I_Last(
		long groupId, long categoryId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByG_C_I_Last(groupId, categoryId, isShow,
			orderByComparator);
	}

	/**
	* Returns the t f images before and after the current t f image in the ordered set where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t f image
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage[] findByG_C_I_PrevAndNext(
		long id, long groupId, long categoryId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByG_C_I_PrevAndNext(id, groupId, categoryId, isShow,
			orderByComparator);
	}

	/**
	* Returns all the t f images that the user has permission to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @return the matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C_I(
		long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_C_I(groupId, categoryId, isShow);
	}

	/**
	* Returns a range of all the t f images that the user has permission to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @return the range of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C_I(
		long groupId, long categoryId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_I(groupId, categoryId, isShow, start, end);
	}

	/**
	* Returns an ordered range of all the t f images that the user has permissions to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C_I(
		long groupId, long categoryId, boolean isShow, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C_I(groupId, categoryId, isShow, start, end,
			orderByComparator);
	}

	/**
	* Returns the t f images before and after the current t f image in the ordered set of t f images that the user has permission to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* @param id the primary key of the current t f image
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage[] filterFindByG_C_I_PrevAndNext(
		long id, long groupId, long categoryId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .filterFindByG_C_I_PrevAndNext(id, groupId, categoryId,
			isShow, orderByComparator);
	}

	/**
	* Returns all the t f images where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the t f images where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @return the range of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t f images where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first t f image in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last t f image in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the t f images before and after the current t f image in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t f image
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage[] findByGroupId_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(id, groupId, orderByComparator);
	}

	/**
	* Returns all the t f images that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the t f images that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @return the range of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t f images that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the t f images before and after the current t f image in the ordered set of t f images that the user has permission to view where groupId = &#63;.
	*
	* @param id the primary key of the current t f image
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage[] filterFindByGroupId_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(id, groupId,
			orderByComparator);
	}

	/**
	* Returns all the t f images where groupId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @return the matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_I(
		long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_I(groupId, isShow);
	}

	/**
	* Returns a range of all the t f images where groupId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @return the range of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_I(
		long groupId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_I(groupId, isShow, start, end);
	}

	/**
	* Returns an ordered range of all the t f images where groupId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_I(
		long groupId, boolean isShow, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_I(groupId, isShow, start, end, orderByComparator);
	}

	/**
	* Returns the first t f image in the ordered set where groupId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage findByG_I_First(
		long groupId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByG_I_First(groupId, isShow, orderByComparator);
	}

	/**
	* Returns the last t f image in the ordered set where groupId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage findByG_I_Last(
		long groupId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByG_I_Last(groupId, isShow, orderByComparator);
	}

	/**
	* Returns the t f images before and after the current t f image in the ordered set where groupId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t f image
	* @param groupId the group ID
	* @param isShow the is show
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage[] findByG_I_PrevAndNext(
		long id, long groupId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByG_I_PrevAndNext(id, groupId, isShow, orderByComparator);
	}

	/**
	* Returns all the t f images that the user has permission to view where groupId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @return the matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_I(
		long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_I(groupId, isShow);
	}

	/**
	* Returns a range of all the t f images that the user has permission to view where groupId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @return the range of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_I(
		long groupId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_I(groupId, isShow, start, end);
	}

	/**
	* Returns an ordered range of all the t f images that the user has permissions to view where groupId = &#63; and isShow = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_I(
		long groupId, boolean isShow, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_I(groupId, isShow, start, end,
			orderByComparator);
	}

	/**
	* Returns the t f images before and after the current t f image in the ordered set of t f images that the user has permission to view where groupId = &#63; and isShow = &#63;.
	*
	* @param id the primary key of the current t f image
	* @param groupId the group ID
	* @param isShow the is show
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage[] filterFindByG_I_PrevAndNext(
		long id, long groupId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .filterFindByG_I_PrevAndNext(id, groupId, isShow,
			orderByComparator);
	}

	/**
	* Returns all the t f images where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the t f images where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @return the range of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the t f images where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first t f image in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last t f image in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the t f images before and after the current t f image in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t f image
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vimagegallery.model.TFImage[] findByCompanyId_PrevAndNext(
		long id, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(id, companyId, orderByComparator);
	}

	/**
	* Returns all the t f images.
	*
	* @return the t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the t f images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @return the range of t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the t f images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t f images
	* @param end the upper bound of the range of t f images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t f images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the t f images where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C(groupId, categoryId);
	}

	/**
	* Removes all the t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C_I(long groupId, long categoryId,
		boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C_I(groupId, categoryId, isShow);
	}

	/**
	* Removes all the t f images where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the t f images where groupId = &#63; and isShow = &#63; from the database.
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_I(long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_I(groupId, isShow);
	}

	/**
	* Removes all the t f images where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the t f images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of t f images where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C(groupId, categoryId);
	}

	/**
	* Returns the number of t f images that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_C(groupId, categoryId);
	}

	/**
	* Returns the number of t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @return the number of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C_I(long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C_I(groupId, categoryId, isShow);
	}

	/**
	* Returns the number of t f images that the user has permission to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @return the number of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_C_I(long groupId, long categoryId,
		boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_C_I(groupId, categoryId, isShow);
	}

	/**
	* Returns the number of t f images where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of t f images that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of t f images where groupId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @return the number of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_I(long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_I(groupId, isShow);
	}

	/**
	* Returns the number of t f images that the user has permission to view where groupId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @return the number of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_I(long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_I(groupId, isShow);
	}

	/**
	* Returns the number of t f images where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of t f images.
	*
	* @return the number of t f images
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TFImagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TFImagePersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vimagegallery.service.ClpSerializer.getServletContextName(),
					TFImagePersistence.class.getName());

			ReferenceRegistry.registerReference(TFImageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TFImagePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TFImageUtil.class, "_persistence");
	}

	private static TFImagePersistence _persistence;
}