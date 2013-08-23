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

import com.vportal.portlet.vdoc.model.vdocDORel;

/**
 * The persistence interface for the vdoc d o rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocDORelPersistenceImpl
 * @see vdocDORelUtil
 * @generated
 */
public interface vdocDORelPersistence extends BasePersistence<vdocDORel> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link vdocDORelUtil} to access the vdoc d o rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vdoc d o rel in the entity cache if it is enabled.
	*
	* @param vdocDORel the vdoc d o rel
	*/
	public void cacheResult(com.vportal.portlet.vdoc.model.vdocDORel vdocDORel);

	/**
	* Caches the vdoc d o rels in the entity cache if it is enabled.
	*
	* @param vdocDORels the vdoc d o rels
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> vdocDORels);

	/**
	* Creates a new vdoc d o rel with the primary key. Does not add the vdoc d o rel to the database.
	*
	* @param vdocDORelPK the primary key for the new vdoc d o rel
	* @return the new vdoc d o rel
	*/
	public com.vportal.portlet.vdoc.model.vdocDORel create(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK);

	/**
	* Removes the vdoc d o rel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vdocDORelPK the primary key of the vdoc d o rel
	* @return the vdoc d o rel that was removed
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a vdoc d o rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDORel remove(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException;

	public com.vportal.portlet.vdoc.model.vdocDORel updateImpl(
		com.vportal.portlet.vdoc.model.vdocDORel vdocDORel, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vdoc d o rel with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocDORelException} if it could not be found.
	*
	* @param vdocDORelPK the primary key of the vdoc d o rel
	* @return the vdoc d o rel
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a vdoc d o rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDORel findByPrimaryKey(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException;

	/**
	* Returns the vdoc d o rel with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vdocDORelPK the primary key of the vdoc d o rel
	* @return the vdoc d o rel, or <code>null</code> if a vdoc d o rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDORel fetchByPrimaryKey(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vdoc d o rels where docId = &#63;.
	*
	* @param docId the doc ID
	* @return the matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByDocument(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vdoc d o rels where docId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the doc ID
	* @param start the lower bound of the range of vdoc d o rels
	* @param end the upper bound of the range of vdoc d o rels (not inclusive)
	* @return the range of matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByDocument(
		java.lang.String docId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vdoc d o rels where docId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the doc ID
	* @param start the lower bound of the range of vdoc d o rels
	* @param end the upper bound of the range of vdoc d o rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByDocument(
		java.lang.String docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vdoc d o rel in the ordered set where docId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the doc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc d o rel
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a matching vdoc d o rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDORel findByDocument_First(
		java.lang.String docId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException;

	/**
	* Returns the last vdoc d o rel in the ordered set where docId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the doc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc d o rel
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a matching vdoc d o rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDORel findByDocument_Last(
		java.lang.String docId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException;

	/**
	* Returns the vdoc d o rels before and after the current vdoc d o rel in the ordered set where docId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vdocDORelPK the primary key of the current vdoc d o rel
	* @param docId the doc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc d o rel
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a vdoc d o rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDORel[] findByDocument_PrevAndNext(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK,
		java.lang.String docId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException;

	/**
	* Returns all the vdoc d o rels where orgId = &#63;.
	*
	* @param orgId the org ID
	* @return the matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByOrg(
		java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vdoc d o rels where orgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orgId the org ID
	* @param start the lower bound of the range of vdoc d o rels
	* @param end the upper bound of the range of vdoc d o rels (not inclusive)
	* @return the range of matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByOrg(
		java.lang.String orgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vdoc d o rels where orgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orgId the org ID
	* @param start the lower bound of the range of vdoc d o rels
	* @param end the upper bound of the range of vdoc d o rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByOrg(
		java.lang.String orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vdoc d o rel in the ordered set where orgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc d o rel
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a matching vdoc d o rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDORel findByOrg_First(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException;

	/**
	* Returns the last vdoc d o rel in the ordered set where orgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc d o rel
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a matching vdoc d o rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDORel findByOrg_Last(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException;

	/**
	* Returns the vdoc d o rels before and after the current vdoc d o rel in the ordered set where orgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vdocDORelPK the primary key of the current vdoc d o rel
	* @param orgId the org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc d o rel
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a vdoc d o rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDORel[] findByOrg_PrevAndNext(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK,
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException;

	/**
	* Returns all the vdoc d o rels.
	*
	* @return the vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vdoc d o rels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vdoc d o rels
	* @param end the upper bound of the range of vdoc d o rels (not inclusive)
	* @return the range of vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vdoc d o rels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vdoc d o rels
	* @param end the upper bound of the range of vdoc d o rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc d o rels where docId = &#63; from the database.
	*
	* @param docId the doc ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDocument(java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc d o rels where orgId = &#63; from the database.
	*
	* @param orgId the org ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrg(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc d o rels from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc d o rels where docId = &#63;.
	*
	* @param docId the doc ID
	* @return the number of matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public int countByDocument(java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc d o rels where orgId = &#63;.
	*
	* @param orgId the org ID
	* @return the number of matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrg(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc d o rels.
	*
	* @return the number of vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}