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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.vdoc.model.vdocField;

import java.util.List;

/**
 * The persistence utility for the vdoc field service. This utility wraps {@link vdocFieldPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocFieldPersistence
 * @see vdocFieldPersistenceImpl
 * @generated
 */
public class vdocFieldUtil {
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
	public static void clearCache(vdocField vdocField) {
		getPersistence().clearCache(vdocField);
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
	public static List<vdocField> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<vdocField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<vdocField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static vdocField update(vdocField vdocField, boolean merge)
		throws SystemException {
		return getPersistence().update(vdocField, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static vdocField update(vdocField vdocField, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vdocField, merge, serviceContext);
	}

	/**
	* Caches the vdoc field in the entity cache if it is enabled.
	*
	* @param vdocField the vdoc field
	*/
	public static void cacheResult(
		com.vportal.portlet.vdoc.model.vdocField vdocField) {
		getPersistence().cacheResult(vdocField);
	}

	/**
	* Caches the vdoc fields in the entity cache if it is enabled.
	*
	* @param vdocFields the vdoc fields
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vdoc.model.vdocField> vdocFields) {
		getPersistence().cacheResult(vdocFields);
	}

	/**
	* Creates a new vdoc field with the primary key. Does not add the vdoc field to the database.
	*
	* @param fieldId the primary key for the new vdoc field
	* @return the new vdoc field
	*/
	public static com.vportal.portlet.vdoc.model.vdocField create(
		java.lang.String fieldId) {
		return getPersistence().create(fieldId);
	}

	/**
	* Removes the vdoc field with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fieldId the primary key of the vdoc field
	* @return the vdoc field that was removed
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocField remove(
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getPersistence().remove(fieldId);
	}

	public static com.vportal.portlet.vdoc.model.vdocField updateImpl(
		com.vportal.portlet.vdoc.model.vdocField vdocField, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vdocField, merge);
	}

	/**
	* Returns the vdoc field with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocFieldException} if it could not be found.
	*
	* @param fieldId the primary key of the vdoc field
	* @return the vdoc field
	* @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocField findByPrimaryKey(
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getPersistence().findByPrimaryKey(fieldId);
	}

	/**
	* Returns the vdoc field with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fieldId the primary key of the vdoc field
	* @return the vdoc field, or <code>null</code> if a vdoc field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocField fetchByPrimaryKey(
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(fieldId);
	}

	/**
	* Returns all the vdoc fields where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByParentId(
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentId(parentId);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByParentId(
		java.lang.String parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentId(parentId, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByParentId(
		java.lang.String parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentId(parentId, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocField findByParentId_First(
		java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getPersistence().findByParentId_First(parentId, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocField findByParentId_Last(
		java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getPersistence().findByParentId_Last(parentId, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocField[] findByParentId_PrevAndNext(
		java.lang.String fieldId, java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getPersistence()
				   .findByParentId_PrevAndNext(fieldId, parentId,
			orderByComparator);
	}

	/**
	* Returns all the vdoc fields where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(groupId, language);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(groupId, language, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L(
		long groupId, java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L(groupId, language, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocField findByG_L_First(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getPersistence()
				   .findByG_L_First(groupId, language, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocField findByG_L_Last(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getPersistence()
				   .findByG_L_Last(groupId, language, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocField[] findByG_L_PrevAndNext(
		java.lang.String fieldId, long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getPersistence()
				   .findByG_L_PrevAndNext(fieldId, groupId, language,
			orderByComparator);
	}

	/**
	* Returns all the vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @return the matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L_P(groupId, language, parentId);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_P(groupId, language, parentId, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_P(groupId, language, parentId, start, end,
			orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocField findByG_L_P_First(
		long groupId, java.lang.String language, java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getPersistence()
				   .findByG_L_P_First(groupId, language, parentId,
			orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocField findByG_L_P_Last(
		long groupId, java.lang.String language, java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getPersistence()
				   .findByG_L_P_Last(groupId, language, parentId,
			orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocField[] findByG_L_P_PrevAndNext(
		java.lang.String fieldId, long groupId, java.lang.String language,
		java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getPersistence()
				   .findByG_L_P_PrevAndNext(fieldId, groupId, language,
			parentId, orderByComparator);
	}

	/**
	* Returns all the vdoc fields.
	*
	* @return the vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vdoc fields where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentId(java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentId(parentId);
	}

	/**
	* Removes all the vdoc fields where groupId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L(groupId, language);
	}

	/**
	* Removes all the vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L_P(groupId, language, parentId);
	}

	/**
	* Removes all the vdoc fields from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vdoc fields where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentId(java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentId(parentId);
	}

	/**
	* Returns the number of vdoc fields where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the number of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L(groupId, language);
	}

	/**
	* Returns the number of vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @return the number of matching vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L_P(groupId, language, parentId);
	}

	/**
	* Returns the number of vdoc fields.
	*
	* @return the number of vdoc fields
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static vdocFieldPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (vdocFieldPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vdoc.service.ClpSerializer.getServletContextName(),
					vdocFieldPersistence.class.getName());

			ReferenceRegistry.registerReference(vdocFieldUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(vdocFieldPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(vdocFieldUtil.class, "_persistence");
	}

	private static vdocFieldPersistence _persistence;
}