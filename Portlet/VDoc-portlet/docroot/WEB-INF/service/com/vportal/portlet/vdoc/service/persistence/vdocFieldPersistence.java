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

package com.vportal.portlet.vdoc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.vportal.portlet.vdoc.model.vdocField;

/**
 * The persistence interface for the vdoc field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocFieldPersistenceImpl
 * @see vdocFieldUtil
 * @generated
 */
public interface vdocFieldPersistence extends BasePersistence<vdocField> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link vdocFieldUtil} to access the vdoc field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vdoc field in the entity cache if it is enabled.
	*
	* @param vdocField the vdoc field
	*/
	public void cacheResult(com.vportal.portlet.vdoc.model.vdocField vdocField);

	/**
	* Caches the vdoc fields in the entity cache if it is enabled.
	*
	* @param vdocFields the vdoc fields
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vdoc.model.vdocField> vdocFields);

	/**
	* Creates a new vdoc field with the primary key. Does not add the vdoc field to the database.
	*
	* @param fieldId the primary key for the new vdoc field
	* @return the new vdoc field
	*/
	public com.vportal.portlet.vdoc.model.vdocField create(
		java.lang.String fieldId);

	/**
	* Removes the vdoc field with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fieldId the primary key of the vdoc field
	* @return the vdoc field that was removed
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField remove(
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException;

	public com.vportal.portlet.vdoc.model.vdocField updateImpl(
		com.vportal.portlet.vdoc.model.vdocField vdocField, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vdoc field with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocFieldException} if it could not be found.
	*
	* @param fieldId the primary key of the vdoc field
	* @return the vdoc field
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField findByPrimaryKey(
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException;

	/**
	* Returns the vdoc field with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fieldId the primary key of the vdoc field
	* @return the vdoc field, or <code>null</code> if a vdoc field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField fetchByPrimaryKey(
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vdoc fields where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByParentId(
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vdoc fields where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of vdoc fields
	* @param end the upper bound of the range of vdoc fields (not inclusive)
	* @return the range of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByParentId(
		java.lang.String parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vdoc fields where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of vdoc fields
	* @param end the upper bound of the range of vdoc fields (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByParentId(
		java.lang.String parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vdoc field in the ordered set where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc field
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField findByParentId_First(
		java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException;

	/**
	* Returns the last vdoc field in the ordered set where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc field
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField findByParentId_Last(
		java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException;

	/**
	* Returns the vdoc fields before and after the current vdoc field in the ordered set where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fieldId the primary key of the current vdoc field
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc field
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField[] findByParentId_PrevAndNext(
		java.lang.String fieldId, java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException;

	/**
	* Returns all the vdoc fields where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vdoc fields where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vdoc fields
	* @param end the upper bound of the range of vdoc fields (not inclusive)
	* @return the range of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vdoc fields where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vdoc fields
	* @param end the upper bound of the range of vdoc fields (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L(
		long groupId, java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vdoc field in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc field
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField findByG_L_First(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException;

	/**
	* Returns the last vdoc field in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc field
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField findByG_L_Last(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException;

	/**
	* Returns the vdoc fields before and after the current vdoc field in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fieldId the primary key of the current vdoc field
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc field
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField[] findByG_L_PrevAndNext(
		java.lang.String fieldId, long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException;

	/**
	* Returns all the vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @return the matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param start the lower bound of the range of vdoc fields
	* @param end the upper bound of the range of vdoc fields (not inclusive)
	* @return the range of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param start the lower bound of the range of vdoc fields
	* @param end the upper bound of the range of vdoc fields (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vdoc field in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc field
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField findByG_L_P_First(
		long groupId, java.lang.String language, java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException;

	/**
	* Returns the last vdoc field in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc field
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField findByG_L_P_Last(
		long groupId, java.lang.String language, java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException;

	/**
	* Returns the vdoc fields before and after the current vdoc field in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fieldId the primary key of the current vdoc field
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc field
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocField[] findByG_L_P_PrevAndNext(
		java.lang.String fieldId, long groupId, java.lang.String language,
		java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException;

	/**
	* Returns all the vdoc fields.
	*
	* @return the vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vdoc fields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vdoc fields
	* @param end the upper bound of the range of vdoc fields (not inclusive)
	* @return the range of vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vdoc fields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vdoc fields
	* @param end the upper bound of the range of vdoc fields (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc fields where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentId(java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc fields where groupId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc fields from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc fields where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentId(java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc fields where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the number of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @return the number of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc fields.
	*
	* @return the number of vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}