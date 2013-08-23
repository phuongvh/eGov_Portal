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

import com.liferay.portal.service.persistence.BasePersistence;

import com.vportal.portlet.vimagegallery.model.TFImage;

/**
 * The persistence interface for the t f image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucNN
 * @see TFImagePersistenceImpl
 * @see TFImageUtil
 * @generated
 */
public interface TFImagePersistence extends BasePersistence<TFImage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TFImageUtil} to access the t f image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the t f image in the entity cache if it is enabled.
	*
	* @param tfImage the t f image
	*/
	public void cacheResult(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage);

	/**
	* Caches the t f images in the entity cache if it is enabled.
	*
	* @param tfImages the t f images
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> tfImages);

	/**
	* Creates a new t f image with the primary key. Does not add the t f image to the database.
	*
	* @param id the primary key for the new t f image
	* @return the new t f image
	*/
	public com.vportal.portlet.vimagegallery.model.TFImage create(long id);

	/**
	* Removes the t f image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the t f image
	* @return the t f image that was removed
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFImage remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

	public com.vportal.portlet.vimagegallery.model.TFImage updateImpl(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t f image with the primary key or throws a {@link com.vportal.portlet.vimagegallery.NoSuchTFImageException} if it could not be found.
	*
	* @param id the primary key of the t f image
	* @return the t f image
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFImage findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

	/**
	* Returns the t f image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the t f image
	* @return the t f image, or <code>null</code> if a t f image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFImage fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the t f images where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage findByG_C_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage findByG_C_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage[] findByG_C_PrevAndNext(
		long id, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

	/**
	* Returns all the t f images that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage[] filterFindByG_C_PrevAndNext(
		long id, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

	/**
	* Returns all the t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @return the matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C_I(
		long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C_I(
		long groupId, long categoryId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_C_I(
		long groupId, long categoryId, boolean isShow, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage findByG_C_I_First(
		long groupId, long categoryId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage findByG_C_I_Last(
		long groupId, long categoryId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage[] findByG_C_I_PrevAndNext(
		long id, long groupId, long categoryId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

	/**
	* Returns all the t f images that the user has permission to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @return the matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C_I(
		long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C_I(
		long groupId, long categoryId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_C_I(
		long groupId, long categoryId, boolean isShow, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage[] filterFindByG_C_I_PrevAndNext(
		long id, long groupId, long categoryId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

	/**
	* Returns all the t f images where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage[] findByGroupId_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

	/**
	* Returns all the t f images that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage[] filterFindByGroupId_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

	/**
	* Returns all the t f images where groupId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @return the matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_I(
		long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_I(
		long groupId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByG_I(
		long groupId, boolean isShow, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage findByG_I_First(
		long groupId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage findByG_I_Last(
		long groupId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage[] findByG_I_PrevAndNext(
		long id, long groupId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

	/**
	* Returns all the t f images that the user has permission to view where groupId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @return the matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_I(
		long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_I(
		long groupId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> filterFindByG_I(
		long groupId, boolean isShow, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage[] filterFindByG_I_PrevAndNext(
		long id, long groupId, boolean isShow,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

	/**
	* Returns all the t f images where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

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
	public com.vportal.portlet.vimagegallery.model.TFImage[] findByCompanyId_PrevAndNext(
		long id, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFImageException;

	/**
	* Returns all the t f images.
	*
	* @return the t f images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t f images where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_C_I(long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t f images where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t f images where groupId = &#63; and isShow = &#63; from the database.
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_I(long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t f images where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t f images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f images where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f images that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @return the number of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C_I(long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f images that the user has permission to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param isShow the is show
	* @return the number of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_C_I(long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f images where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f images that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f images where groupId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @return the number of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_I(long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f images that the user has permission to view where groupId = &#63; and isShow = &#63;.
	*
	* @param groupId the group ID
	* @param isShow the is show
	* @return the number of matching t f images that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_I(long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f images where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching t f images
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f images.
	*
	* @return the number of t f images
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}