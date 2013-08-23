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

package com.vportal.portlet.vadvman.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.vadvman.model.AdvType;

import java.util.List;

/**
 * The persistence utility for the adv type service. This utility wraps {@link AdvTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucNN
 * @see AdvTypePersistence
 * @see AdvTypePersistenceImpl
 * @generated
 */
public class AdvTypeUtil {
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
	public static void clearCache(AdvType advType) {
		getPersistence().clearCache(advType);
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
	public static List<AdvType> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdvType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdvType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AdvType update(AdvType advType, boolean merge)
		throws SystemException {
		return getPersistence().update(advType, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AdvType update(AdvType advType, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(advType, merge, serviceContext);
	}

	/**
	* Caches the adv type in the entity cache if it is enabled.
	*
	* @param advType the adv type
	*/
	public static void cacheResult(
		com.vportal.portlet.vadvman.model.AdvType advType) {
		getPersistence().cacheResult(advType);
	}

	/**
	* Caches the adv types in the entity cache if it is enabled.
	*
	* @param advTypes the adv types
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vadvman.model.AdvType> advTypes) {
		getPersistence().cacheResult(advTypes);
	}

	/**
	* Creates a new adv type with the primary key. Does not add the adv type to the database.
	*
	* @param typeId the primary key for the new adv type
	* @return the new adv type
	*/
	public static com.vportal.portlet.vadvman.model.AdvType create(long typeId) {
		return getPersistence().create(typeId);
	}

	/**
	* Removes the adv type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the adv type
	* @return the adv type that was removed
	* @throws com.vportal.portlet.vadvman.NoSuchAdvTypeException if a adv type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vadvman.model.AdvType remove(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vadvman.NoSuchAdvTypeException {
		return getPersistence().remove(typeId);
	}

	public static com.vportal.portlet.vadvman.model.AdvType updateImpl(
		com.vportal.portlet.vadvman.model.AdvType advType, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(advType, merge);
	}

	/**
	* Returns the adv type with the primary key or throws a {@link com.vportal.portlet.vadvman.NoSuchAdvTypeException} if it could not be found.
	*
	* @param typeId the primary key of the adv type
	* @return the adv type
	* @throws com.vportal.portlet.vadvman.NoSuchAdvTypeException if a adv type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vadvman.model.AdvType findByPrimaryKey(
		long typeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vadvman.NoSuchAdvTypeException {
		return getPersistence().findByPrimaryKey(typeId);
	}

	/**
	* Returns the adv type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeId the primary key of the adv type
	* @return the adv type, or <code>null</code> if a adv type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vadvman.model.AdvType fetchByPrimaryKey(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(typeId);
	}

	/**
	* Returns all the adv types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching adv types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vadvman.model.AdvType> findByG(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG(groupId);
	}

	/**
	* Returns a range of all the adv types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of adv types
	* @param end the upper bound of the range of adv types (not inclusive)
	* @return the range of matching adv types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vadvman.model.AdvType> findByG(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the adv types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of adv types
	* @param end the upper bound of the range of adv types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adv types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vadvman.model.AdvType> findByG(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first adv type in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching adv type
	* @throws com.vportal.portlet.vadvman.NoSuchAdvTypeException if a matching adv type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vadvman.model.AdvType findByG_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vadvman.NoSuchAdvTypeException {
		return getPersistence().findByG_First(groupId, orderByComparator);
	}

	/**
	* Returns the last adv type in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching adv type
	* @throws com.vportal.portlet.vadvman.NoSuchAdvTypeException if a matching adv type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vadvman.model.AdvType findByG_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vadvman.NoSuchAdvTypeException {
		return getPersistence().findByG_Last(groupId, orderByComparator);
	}

	/**
	* Returns the adv types before and after the current adv type in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the primary key of the current adv type
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next adv type
	* @throws com.vportal.portlet.vadvman.NoSuchAdvTypeException if a adv type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vadvman.model.AdvType[] findByG_PrevAndNext(
		long typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vadvman.NoSuchAdvTypeException {
		return getPersistence()
				   .findByG_PrevAndNext(typeId, groupId, orderByComparator);
	}

	/**
	* Returns all the adv types.
	*
	* @return the adv types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vadvman.model.AdvType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the adv types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of adv types
	* @param end the upper bound of the range of adv types (not inclusive)
	* @return the range of adv types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vadvman.model.AdvType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the adv types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of adv types
	* @param end the upper bound of the range of adv types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of adv types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vadvman.model.AdvType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the adv types where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG(groupId);
	}

	/**
	* Removes all the adv types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of adv types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching adv types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG(groupId);
	}

	/**
	* Returns the number of adv types.
	*
	* @return the number of adv types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdvTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdvTypePersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vadvman.service.ClpSerializer.getServletContextName(),
					AdvTypePersistence.class.getName());

			ReferenceRegistry.registerReference(AdvTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(AdvTypePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(AdvTypeUtil.class, "_persistence");
	}

	private static AdvTypePersistence _persistence;
}