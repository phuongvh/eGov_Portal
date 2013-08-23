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

package com.vportal.portlet.vlinksman.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.vlinksman.model.LinkGroup;

import java.util.List;

/**
 * The persistence utility for the link group service. This utility wraps {@link LinkGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LongLH
 * @see LinkGroupPersistence
 * @see LinkGroupPersistenceImpl
 * @generated
 */
public class LinkGroupUtil {
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
	public static void clearCache(LinkGroup linkGroup) {
		getPersistence().clearCache(linkGroup);
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
	public static List<LinkGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LinkGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LinkGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LinkGroup update(LinkGroup linkGroup, boolean merge)
		throws SystemException {
		return getPersistence().update(linkGroup, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LinkGroup update(LinkGroup linkGroup, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(linkGroup, merge, serviceContext);
	}

	/**
	* Caches the link group in the entity cache if it is enabled.
	*
	* @param linkGroup the link group
	*/
	public static void cacheResult(
		com.vportal.portlet.vlinksman.model.LinkGroup linkGroup) {
		getPersistence().cacheResult(linkGroup);
	}

	/**
	* Caches the link groups in the entity cache if it is enabled.
	*
	* @param linkGroups the link groups
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vlinksman.model.LinkGroup> linkGroups) {
		getPersistence().cacheResult(linkGroups);
	}

	/**
	* Creates a new link group with the primary key. Does not add the link group to the database.
	*
	* @param linkgroupId the primary key for the new link group
	* @return the new link group
	*/
	public static com.vportal.portlet.vlinksman.model.LinkGroup create(
		long linkgroupId) {
		return getPersistence().create(linkgroupId);
	}

	/**
	* Removes the link group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkgroupId the primary key of the link group
	* @return the link group that was removed
	* @throws com.vportal.portlet.vlinksman.NoSuchLinkGroupException if a link group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vlinksman.model.LinkGroup remove(
		long linkgroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinkGroupException {
		return getPersistence().remove(linkgroupId);
	}

	public static com.vportal.portlet.vlinksman.model.LinkGroup updateImpl(
		com.vportal.portlet.vlinksman.model.LinkGroup linkGroup, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(linkGroup, merge);
	}

	/**
	* Returns the link group with the primary key or throws a {@link com.vportal.portlet.vlinksman.NoSuchLinkGroupException} if it could not be found.
	*
	* @param linkgroupId the primary key of the link group
	* @return the link group
	* @throws com.vportal.portlet.vlinksman.NoSuchLinkGroupException if a link group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vlinksman.model.LinkGroup findByPrimaryKey(
		long linkgroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinkGroupException {
		return getPersistence().findByPrimaryKey(linkgroupId);
	}

	/**
	* Returns the link group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param linkgroupId the primary key of the link group
	* @return the link group, or <code>null</code> if a link group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vlinksman.model.LinkGroup fetchByPrimaryKey(
		long linkgroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(linkgroupId);
	}

	/**
	* Returns all the link groups where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching link groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vlinksman.model.LinkGroup> findBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygroupId(groupId);
	}

	/**
	* Returns a range of all the link groups where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of link groups
	* @param end the upper bound of the range of link groups (not inclusive)
	* @return the range of matching link groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vlinksman.model.LinkGroup> findBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the link groups where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of link groups
	* @param end the upper bound of the range of link groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching link groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vlinksman.model.LinkGroup> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBygroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first link group in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link group
	* @throws com.vportal.portlet.vlinksman.NoSuchLinkGroupException if a matching link group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vlinksman.model.LinkGroup findBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinkGroupException {
		return getPersistence().findBygroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last link group in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link group
	* @throws com.vportal.portlet.vlinksman.NoSuchLinkGroupException if a matching link group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vlinksman.model.LinkGroup findBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinkGroupException {
		return getPersistence().findBygroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the link groups before and after the current link group in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param linkgroupId the primary key of the current link group
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next link group
	* @throws com.vportal.portlet.vlinksman.NoSuchLinkGroupException if a link group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vlinksman.model.LinkGroup[] findBygroupId_PrevAndNext(
		long linkgroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinkGroupException {
		return getPersistence()
				   .findBygroupId_PrevAndNext(linkgroupId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the link groups.
	*
	* @return the link groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vlinksman.model.LinkGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the link groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of link groups
	* @param end the upper bound of the range of link groups (not inclusive)
	* @return the range of link groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vlinksman.model.LinkGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the link groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of link groups
	* @param end the upper bound of the range of link groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of link groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vlinksman.model.LinkGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the link groups where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBygroupId(groupId);
	}

	/**
	* Removes all the link groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of link groups where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching link groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBygroupId(groupId);
	}

	/**
	* Returns the number of link groups.
	*
	* @return the number of link groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LinkGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LinkGroupPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vlinksman.service.ClpSerializer.getServletContextName(),
					LinkGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(LinkGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(LinkGroupPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(LinkGroupUtil.class, "_persistence");
	}

	private static LinkGroupPersistence _persistence;
}