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

import com.vportal.portlet.vdoc.model.vdocDORel;

import java.util.List;

/**
 * The persistence utility for the vdoc d o rel service. This utility wraps {@link vdocDORelPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocDORelPersistence
 * @see vdocDORelPersistenceImpl
 * @generated
 */
public class vdocDORelUtil {
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
	public static void clearCache(vdocDORel vdocDORel) {
		getPersistence().clearCache(vdocDORel);
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
	public static List<vdocDORel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<vdocDORel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<vdocDORel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static vdocDORel update(vdocDORel vdocDORel, boolean merge)
		throws SystemException {
		return getPersistence().update(vdocDORel, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static vdocDORel update(vdocDORel vdocDORel, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vdocDORel, merge, serviceContext);
	}

	/**
	* Caches the vdoc d o rel in the entity cache if it is enabled.
	*
	* @param vdocDORel the vdoc d o rel
	*/
	public static void cacheResult(
		com.vportal.portlet.vdoc.model.vdocDORel vdocDORel) {
		getPersistence().cacheResult(vdocDORel);
	}

	/**
	* Caches the vdoc d o rels in the entity cache if it is enabled.
	*
	* @param vdocDORels the vdoc d o rels
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> vdocDORels) {
		getPersistence().cacheResult(vdocDORels);
	}

	/**
	* Creates a new vdoc d o rel with the primary key. Does not add the vdoc d o rel to the database.
	*
	* @param vdocDORelPK the primary key for the new vdoc d o rel
	* @return the new vdoc d o rel
	*/
	public static com.vportal.portlet.vdoc.model.vdocDORel create(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK) {
		return getPersistence().create(vdocDORelPK);
	}

	/**
	* Removes the vdoc d o rel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vdocDORelPK the primary key of the vdoc d o rel
	* @return the vdoc d o rel that was removed
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a vdoc d o rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDORel remove(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException {
		return getPersistence().remove(vdocDORelPK);
	}

	public static com.vportal.portlet.vdoc.model.vdocDORel updateImpl(
		com.vportal.portlet.vdoc.model.vdocDORel vdocDORel, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vdocDORel, merge);
	}

	/**
	* Returns the vdoc d o rel with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocDORelException} if it could not be found.
	*
	* @param vdocDORelPK the primary key of the vdoc d o rel
	* @return the vdoc d o rel
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a vdoc d o rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDORel findByPrimaryKey(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException {
		return getPersistence().findByPrimaryKey(vdocDORelPK);
	}

	/**
	* Returns the vdoc d o rel with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vdocDORelPK the primary key of the vdoc d o rel
	* @return the vdoc d o rel, or <code>null</code> if a vdoc d o rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDORel fetchByPrimaryKey(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vdocDORelPK);
	}

	/**
	* Returns all the vdoc d o rels where docId = &#63;.
	*
	* @param docId the doc ID
	* @return the matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByDocument(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDocument(docId);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByDocument(
		java.lang.String docId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDocument(docId, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByDocument(
		java.lang.String docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDocument(docId, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocDORel findByDocument_First(
		java.lang.String docId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException {
		return getPersistence().findByDocument_First(docId, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocDORel findByDocument_Last(
		java.lang.String docId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException {
		return getPersistence().findByDocument_Last(docId, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocDORel[] findByDocument_PrevAndNext(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK,
		java.lang.String docId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException {
		return getPersistence()
				   .findByDocument_PrevAndNext(vdocDORelPK, docId,
			orderByComparator);
	}

	/**
	* Returns all the vdoc d o rels where orgId = &#63;.
	*
	* @param orgId the org ID
	* @return the matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByOrg(
		java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrg(orgId);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByOrg(
		java.lang.String orgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrg(orgId, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findByOrg(
		java.lang.String orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrg(orgId, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocDORel findByOrg_First(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException {
		return getPersistence().findByOrg_First(orgId, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocDORel findByOrg_Last(
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException {
		return getPersistence().findByOrg_Last(orgId, orderByComparator);
	}

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
	public static com.vportal.portlet.vdoc.model.vdocDORel[] findByOrg_PrevAndNext(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK vdocDORelPK,
		java.lang.String orgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDORelException {
		return getPersistence()
				   .findByOrg_PrevAndNext(vdocDORelPK, orgId, orderByComparator);
	}

	/**
	* Returns all the vdoc d o rels.
	*
	* @return the vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vdoc d o rels where docId = &#63; from the database.
	*
	* @param docId the doc ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDocument(java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDocument(docId);
	}

	/**
	* Removes all the vdoc d o rels where orgId = &#63; from the database.
	*
	* @param orgId the org ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrg(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrg(orgId);
	}

	/**
	* Removes all the vdoc d o rels from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vdoc d o rels where docId = &#63;.
	*
	* @param docId the doc ID
	* @return the number of matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDocument(java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDocument(docId);
	}

	/**
	* Returns the number of vdoc d o rels where orgId = &#63;.
	*
	* @param orgId the org ID
	* @return the number of matching vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrg(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrg(orgId);
	}

	/**
	* Returns the number of vdoc d o rels.
	*
	* @return the number of vdoc d o rels
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static vdocDORelPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (vdocDORelPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vdoc.service.ClpSerializer.getServletContextName(),
					vdocDORelPersistence.class.getName());

			ReferenceRegistry.registerReference(vdocDORelUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(vdocDORelPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(vdocDORelUtil.class, "_persistence");
	}

	private static vdocDORelPersistence _persistence;
}