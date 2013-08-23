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

import com.vportal.portlet.vimagegallery.model.TFCategory;

/**
 * The persistence interface for the t f category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucNN
 * @see TFCategoryPersistenceImpl
 * @see TFCategoryUtil
 * @generated
 */
public interface TFCategoryPersistence extends BasePersistence<TFCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TFCategoryUtil} to access the t f category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the t f category in the entity cache if it is enabled.
	*
	* @param tfCategory the t f category
	*/
	public void cacheResult(
		com.vportal.portlet.vimagegallery.model.TFCategory tfCategory);

	/**
	* Caches the t f categories in the entity cache if it is enabled.
	*
	* @param tfCategories the t f categories
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> tfCategories);

	/**
	* Creates a new t f category with the primary key. Does not add the t f category to the database.
	*
	* @param id the primary key for the new t f category
	* @return the new t f category
	*/
	public com.vportal.portlet.vimagegallery.model.TFCategory create(long id);

	/**
	* Removes the t f category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the t f category
	* @return the t f category that was removed
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFCategoryException if a t f category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFCategory remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFCategoryException;

	public com.vportal.portlet.vimagegallery.model.TFCategory updateImpl(
		com.vportal.portlet.vimagegallery.model.TFCategory tfCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t f category with the primary key or throws a {@link com.vportal.portlet.vimagegallery.NoSuchTFCategoryException} if it could not be found.
	*
	* @param id the primary key of the t f category
	* @return the t f category
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFCategoryException if a t f category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFCategory findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFCategoryException;

	/**
	* Returns the t f category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the t f category
	* @return the t f category, or <code>null</code> if a t f category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFCategory fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the t f categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t f categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t f categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t f categories
	* @param end the upper bound of the range of t f categories (not inclusive)
	* @return the range of matching t f categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t f categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t f categories
	* @param end the upper bound of the range of t f categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t f category in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t f category
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFCategoryException if a matching t f category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFCategory findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFCategoryException;

	/**
	* Returns the last t f category in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t f category
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFCategoryException if a matching t f category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFCategory findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFCategoryException;

	/**
	* Returns the t f categories before and after the current t f category in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t f category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f category
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFCategoryException if a t f category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFCategory[] findByGroupId_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFCategoryException;

	/**
	* Returns all the t f categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t f categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t f categories that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t f categories
	* @param end the upper bound of the range of t f categories (not inclusive)
	* @return the range of matching t f categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t f categories that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t f categories
	* @param end the upper bound of the range of t f categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t f categories before and after the current t f category in the ordered set of t f categories that the user has permission to view where groupId = &#63;.
	*
	* @param id the primary key of the current t f category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f category
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFCategoryException if a t f category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFCategory[] filterFindByGroupId_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFCategoryException;

	/**
	* Returns all the t f categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching t f categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t f categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of t f categories
	* @param end the upper bound of the range of t f categories (not inclusive)
	* @return the range of matching t f categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t f categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of t f categories
	* @param end the upper bound of the range of t f categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t f categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t f category in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t f category
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFCategoryException if a matching t f category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFCategory findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFCategoryException;

	/**
	* Returns the last t f category in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t f category
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFCategoryException if a matching t f category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFCategory findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFCategoryException;

	/**
	* Returns the t f categories before and after the current t f category in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t f category
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t f category
	* @throws com.vportal.portlet.vimagegallery.NoSuchTFCategoryException if a t f category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vimagegallery.model.TFCategory[] findByCompanyId_PrevAndNext(
		long id, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vimagegallery.NoSuchTFCategoryException;

	/**
	* Returns all the t f categories.
	*
	* @return the t f categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t f categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t f categories
	* @param end the upper bound of the range of t f categories (not inclusive)
	* @return the range of t f categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t f categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t f categories
	* @param end the upper bound of the range of t f categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t f categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t f categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t f categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t f categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t f categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t f categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching t f categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t f categories.
	*
	* @return the number of t f categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}