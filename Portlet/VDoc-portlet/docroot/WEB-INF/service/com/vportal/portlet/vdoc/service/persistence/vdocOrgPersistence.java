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

import com.vportal.portlet.vdoc.model.vdocOrg;

/**
 * The persistence interface for the vdoc org service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocOrgPersistenceImpl
 * @see vdocOrgUtil
 * @generated
 */
public interface vdocOrgPersistence extends BasePersistence<vdocOrg> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link vdocOrgUtil} to access the vdoc org persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vdoc org in the entity cache if it is enabled.
	*
	* @param vdocOrg the vdoc org
	*/
	public void cacheResult(com.vportal.portlet.vdoc.model.vdocOrg vdocOrg);

	/**
	* Caches the vdoc orgs in the entity cache if it is enabled.
	*
	* @param vdocOrgs the vdoc orgs
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> vdocOrgs);

	/**
	* Creates a new vdoc org with the primary key. Does not add the vdoc org to the database.
	*
	* @param orgId the primary key for the new vdoc org
	* @return the new vdoc org
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg create(java.lang.String orgId);

	/**
	* Removes the vdoc org with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orgId the primary key of the vdoc org
	* @return the vdoc org that was removed
	* @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a vdoc org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg remove(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	public com.vportal.portlet.vdoc.model.vdocOrg updateImpl(
		com.vportal.portlet.vdoc.model.vdocOrg vdocOrg, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vdoc org with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocOrgException} if it could not be found.
	*
	* @param orgId the primary key of the vdoc org
	* @return the vdoc org
	* @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a vdoc org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg findByPrimaryKey(
		java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	/**
	* Returns the vdoc org with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orgId the primary key of the vdoc org
	* @return the vdoc org, or <code>null</code> if a vdoc org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg fetchByPrimaryKey(
		java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vdoc orgs where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findByParentId(
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vdoc orgs where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of vdoc orgs
	* @param end the upper bound of the range of vdoc orgs (not inclusive)
	* @return the range of matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findByParentId(
		java.lang.String parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vdoc orgs where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of vdoc orgs
	* @param end the upper bound of the range of vdoc orgs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findByParentId(
		java.lang.String parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vdoc org in the ordered set where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc org
	* @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg findByParentId_First(
		java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	/**
	* Returns the last vdoc org in the ordered set where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc org
	* @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg findByParentId_Last(
		java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	/**
	* Returns the vdoc orgs before and after the current vdoc org in the ordered set where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orgId the primary key of the current vdoc org
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc org
	* @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a vdoc org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg[] findByParentId_PrevAndNext(
		java.lang.String orgId, java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	/**
	* Returns all the vdoc orgs where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vdoc orgs where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vdoc orgs
	* @param end the upper bound of the range of vdoc orgs (not inclusive)
	* @return the range of matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findByG_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vdoc orgs where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vdoc orgs
	* @param end the upper bound of the range of vdoc orgs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findByG_L(
		long groupId, java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vdoc org in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc org
	* @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg findByG_L_First(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	/**
	* Returns the last vdoc org in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc org
	* @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg findByG_L_Last(long groupId,
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	/**
	* Returns the vdoc orgs before and after the current vdoc org in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orgId the primary key of the current vdoc org
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc org
	* @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a vdoc org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg[] findByG_L_PrevAndNext(
		java.lang.String orgId, long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	/**
	* Returns all the vdoc orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @return the matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vdoc orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param start the lower bound of the range of vdoc orgs
	* @param end the upper bound of the range of vdoc orgs (not inclusive)
	* @return the range of matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vdoc orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param start the lower bound of the range of vdoc orgs
	* @param end the upper bound of the range of vdoc orgs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vdoc org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc org
	* @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg findByG_L_P_First(
		long groupId, java.lang.String language, java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	/**
	* Returns the last vdoc org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc org
	* @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg findByG_L_P_Last(
		long groupId, java.lang.String language, java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	/**
	* Returns the vdoc orgs before and after the current vdoc org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orgId the primary key of the current vdoc org
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc org
	* @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a vdoc org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocOrg[] findByG_L_P_PrevAndNext(
		java.lang.String orgId, long groupId, java.lang.String language,
		java.lang.String parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	/**
	* Returns all the vdoc orgs.
	*
	* @return the vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vdoc orgs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vdoc orgs
	* @param end the upper bound of the range of vdoc orgs (not inclusive)
	* @return the range of vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vdoc orgs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vdoc orgs
	* @param end the upper bound of the range of vdoc orgs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc orgs where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentId(java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc orgs where groupId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc orgs where groupId = &#63; and language = &#63; and parentId = &#63; from the database.
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
	* Removes all the vdoc orgs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc orgs where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentId(java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc orgs where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the number of matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @return the number of matching vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc orgs.
	*
	* @return the number of vdoc orgs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}