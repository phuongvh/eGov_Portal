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

package com.vportal.portlet.vcalendar.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.vcalendar.model.VCal;

import java.util.List;

/**
 * The persistence utility for the v cal service. This utility wraps {@link VCalPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LongLH
 * @see VCalPersistence
 * @see VCalPersistenceImpl
 * @generated
 */
public class VCalUtil {
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
	public static void clearCache(VCal vCal) {
		getPersistence().clearCache(vCal);
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
	public static List<VCal> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VCal> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VCal> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VCal update(VCal vCal, boolean merge)
		throws SystemException {
		return getPersistence().update(vCal, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VCal update(VCal vCal, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vCal, merge, serviceContext);
	}

	/**
	* Caches the v cal in the entity cache if it is enabled.
	*
	* @param vCal the v cal
	*/
	public static void cacheResult(
		com.vportal.portlet.vcalendar.model.VCal vCal) {
		getPersistence().cacheResult(vCal);
	}

	/**
	* Caches the v cals in the entity cache if it is enabled.
	*
	* @param vCals the v cals
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vcalendar.model.VCal> vCals) {
		getPersistence().cacheResult(vCals);
	}

	/**
	* Creates a new v cal with the primary key. Does not add the v cal to the database.
	*
	* @param calId the primary key for the new v cal
	* @return the new v cal
	*/
	public static com.vportal.portlet.vcalendar.model.VCal create(long calId) {
		return getPersistence().create(calId);
	}

	/**
	* Removes the v cal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param calId the primary key of the v cal
	* @return the v cal that was removed
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal remove(long calId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence().remove(calId);
	}

	public static com.vportal.portlet.vcalendar.model.VCal updateImpl(
		com.vportal.portlet.vcalendar.model.VCal vCal, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vCal, merge);
	}

	/**
	* Returns the v cal with the primary key or throws a {@link com.vportal.portlet.vcalendar.NoSuchVCalException} if it could not be found.
	*
	* @param calId the primary key of the v cal
	* @return the v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByPrimaryKey(
		long calId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence().findByPrimaryKey(calId);
	}

	/**
	* Returns the v cal with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param calId the primary key of the v cal
	* @return the v cal, or <code>null</code> if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal fetchByPrimaryKey(
		long calId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(calId);
	}

	/**
	* Returns all the v cals where startDate = &#63; and status = &#63; and groupId = &#63;.
	*
	* @param startDate the start date
	* @param status the status
	* @param groupId the group ID
	* @return the matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S_G(
		java.util.Date startDate, long status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByD_S_G(startDate, status, groupId);
	}

	/**
	* Returns a range of all the v cals where startDate = &#63; and status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param startDate the start date
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @return the range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S_G(
		java.util.Date startDate, long status, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByD_S_G(startDate, status, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v cals where startDate = &#63; and status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param startDate the start date
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S_G(
		java.util.Date startDate, long status, long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByD_S_G(startDate, status, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v cal in the ordered set where startDate = &#63; and status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param startDate the start date
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByD_S_G_First(
		java.util.Date startDate, long status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByD_S_G_First(startDate, status, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v cal in the ordered set where startDate = &#63; and status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param startDate the start date
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByD_S_G_Last(
		java.util.Date startDate, long status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByD_S_G_Last(startDate, status, groupId,
			orderByComparator);
	}

	/**
	* Returns the v cals before and after the current v cal in the ordered set where startDate = &#63; and status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param calId the primary key of the current v cal
	* @param startDate the start date
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal[] findByD_S_G_PrevAndNext(
		long calId, java.util.Date startDate, long status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByD_S_G_PrevAndNext(calId, startDate, status, groupId,
			orderByComparator);
	}

	/**
	* Returns all the v cals where userId = &#63; and startDate = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param status the status
	* @return the matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByU_D_S(
		long userId, java.util.Date startDate, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_D_S(userId, startDate, status);
	}

	/**
	* Returns a range of all the v cals where userId = &#63; and startDate = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param status the status
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @return the range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByU_D_S(
		long userId, java.util.Date startDate, long status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_D_S(userId, startDate, status, start, end);
	}

	/**
	* Returns an ordered range of all the v cals where userId = &#63; and startDate = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param status the status
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByU_D_S(
		long userId, java.util.Date startDate, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_D_S(userId, startDate, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v cal in the ordered set where userId = &#63; and startDate = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByU_D_S_First(
		long userId, java.util.Date startDate, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByU_D_S_First(userId, startDate, status,
			orderByComparator);
	}

	/**
	* Returns the last v cal in the ordered set where userId = &#63; and startDate = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByU_D_S_Last(
		long userId, java.util.Date startDate, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByU_D_S_Last(userId, startDate, status,
			orderByComparator);
	}

	/**
	* Returns the v cals before and after the current v cal in the ordered set where userId = &#63; and startDate = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param calId the primary key of the current v cal
	* @param userId the user ID
	* @param startDate the start date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal[] findByU_D_S_PrevAndNext(
		long calId, long userId, java.util.Date startDate, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByU_D_S_PrevAndNext(calId, userId, startDate, status,
			orderByComparator);
	}

	/**
	* Returns all the v cals where startDate = &#63; and status = &#63;.
	*
	* @param startDate the start date
	* @param status the status
	* @return the matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S(
		java.util.Date startDate, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByD_S(startDate, status);
	}

	/**
	* Returns a range of all the v cals where startDate = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param startDate the start date
	* @param status the status
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @return the range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S(
		java.util.Date startDate, long status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByD_S(startDate, status, start, end);
	}

	/**
	* Returns an ordered range of all the v cals where startDate = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param startDate the start date
	* @param status the status
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S(
		java.util.Date startDate, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByD_S(startDate, status, start, end, orderByComparator);
	}

	/**
	* Returns the first v cal in the ordered set where startDate = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param startDate the start date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByD_S_First(
		java.util.Date startDate, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByD_S_First(startDate, status, orderByComparator);
	}

	/**
	* Returns the last v cal in the ordered set where startDate = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param startDate the start date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByD_S_Last(
		java.util.Date startDate, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByD_S_Last(startDate, status, orderByComparator);
	}

	/**
	* Returns the v cals before and after the current v cal in the ordered set where startDate = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param calId the primary key of the current v cal
	* @param startDate the start date
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal[] findByD_S_PrevAndNext(
		long calId, java.util.Date startDate, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByD_S_PrevAndNext(calId, startDate, status,
			orderByComparator);
	}

	/**
	* Returns all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @return the matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF_D_G_U(
		long userId, java.util.Date startDate, long groupId, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByF_D_G_U(userId, startDate, groupId, status);
	}

	/**
	* Returns a range of all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @return the range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF_D_G_U(
		long userId, java.util.Date startDate, long groupId, long status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByF_D_G_U(userId, startDate, groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF_D_G_U(
		long userId, java.util.Date startDate, long groupId, long status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByF_D_G_U(userId, startDate, groupId, status, start,
			end, orderByComparator);
	}

	/**
	* Returns the first v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByF_D_G_U_First(
		long userId, java.util.Date startDate, long groupId, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByF_D_G_U_First(userId, startDate, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByF_D_G_U_Last(
		long userId, java.util.Date startDate, long groupId, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByF_D_G_U_Last(userId, startDate, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the v cals before and after the current v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param calId the primary key of the current v cal
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal[] findByF_D_G_U_PrevAndNext(
		long calId, long userId, java.util.Date startDate, long groupId,
		long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByF_D_G_U_PrevAndNext(calId, userId, startDate,
			groupId, status, orderByComparator);
	}

	/**
	* Returns all the v cals where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param fileId the file ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @return the matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF_D_G_T(
		long fileId, java.util.Date startDate, long groupId, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByF_D_G_T(fileId, startDate, groupId, status);
	}

	/**
	* Returns a range of all the v cals where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileId the file ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @return the range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF_D_G_T(
		long fileId, java.util.Date startDate, long groupId, long status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByF_D_G_T(fileId, startDate, groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the v cals where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileId the file ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF_D_G_T(
		long fileId, java.util.Date startDate, long groupId, long status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByF_D_G_T(fileId, startDate, groupId, status, start,
			end, orderByComparator);
	}

	/**
	* Returns the first v cal in the ordered set where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileId the file ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByF_D_G_T_First(
		long fileId, java.util.Date startDate, long groupId, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByF_D_G_T_First(fileId, startDate, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last v cal in the ordered set where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileId the file ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByF_D_G_T_Last(
		long fileId, java.util.Date startDate, long groupId, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByF_D_G_T_Last(fileId, startDate, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the v cals before and after the current v cal in the ordered set where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param calId the primary key of the current v cal
	* @param fileId the file ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal[] findByF_D_G_T_PrevAndNext(
		long calId, long fileId, java.util.Date startDate, long groupId,
		long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByF_D_G_T_PrevAndNext(calId, fileId, startDate,
			groupId, status, orderByComparator);
	}

	/**
	* Returns all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @return the matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByUser(
		long userId, java.util.Date startDate, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, startDate, groupId);
	}

	/**
	* Returns a range of all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @return the range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByUser(
		long userId, java.util.Date startDate, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser(userId, startDate, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByUser(
		long userId, java.util.Date startDate, long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser(userId, startDate, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByUser_First(
		long userId, java.util.Date startDate, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByUser_First(userId, startDate, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByUser_Last(
		long userId, java.util.Date startDate, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByUser_Last(userId, startDate, groupId,
			orderByComparator);
	}

	/**
	* Returns the v cals before and after the current v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param calId the primary key of the current v cal
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal[] findByUser_PrevAndNext(
		long calId, long userId, java.util.Date startDate, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByUser_PrevAndNext(calId, userId, startDate, groupId,
			orderByComparator);
	}

	/**
	* Returns all the v cals where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByUserGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserGroup(groupId);
	}

	/**
	* Returns a range of all the v cals where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @return the range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByUserGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v cals where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByUserGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first v cal in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByUserGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence().findByUserGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last v cal in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByUserGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence().findByUserGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the v cals before and after the current v cal in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param calId the primary key of the current v cal
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal[] findByUserGroup_PrevAndNext(
		long calId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByUserGroup_PrevAndNext(calId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the v cals where fileId = &#63;.
	*
	* @param fileId the file ID
	* @return the matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByFileId(
		long fileId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFileId(fileId);
	}

	/**
	* Returns a range of all the v cals where fileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileId the file ID
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @return the range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByFileId(
		long fileId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFileId(fileId, start, end);
	}

	/**
	* Returns an ordered range of all the v cals where fileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileId the file ID
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByFileId(
		long fileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFileId(fileId, start, end, orderByComparator);
	}

	/**
	* Returns the first v cal in the ordered set where fileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileId the file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByFileId_First(
		long fileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence().findByFileId_First(fileId, orderByComparator);
	}

	/**
	* Returns the last v cal in the ordered set where fileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileId the file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal findByFileId_Last(
		long fileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence().findByFileId_Last(fileId, orderByComparator);
	}

	/**
	* Returns the v cals before and after the current v cal in the ordered set where fileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param calId the primary key of the current v cal
	* @param fileId the file ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v cal
	* @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VCal[] findByFileId_PrevAndNext(
		long calId, long fileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getPersistence()
				   .findByFileId_PrevAndNext(calId, fileId, orderByComparator);
	}

	/**
	* Returns all the v cals.
	*
	* @return the v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the v cals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @return the range of v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the v cals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v cals
	* @param end the upper bound of the range of v cals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v cals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v cals where startDate = &#63; and status = &#63; and groupId = &#63; from the database.
	*
	* @param startDate the start date
	* @param status the status
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByD_S_G(java.util.Date startDate, long status,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByD_S_G(startDate, status, groupId);
	}

	/**
	* Removes all the v cals where userId = &#63; and startDate = &#63; and status = &#63; from the database.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_D_S(long userId, java.util.Date startDate,
		long status) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_D_S(userId, startDate, status);
	}

	/**
	* Removes all the v cals where startDate = &#63; and status = &#63; from the database.
	*
	* @param startDate the start date
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByD_S(java.util.Date startDate, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByD_S(startDate, status);
	}

	/**
	* Removes all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByF_D_G_U(long userId, java.util.Date startDate,
		long groupId, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByF_D_G_U(userId, startDate, groupId, status);
	}

	/**
	* Removes all the v cals where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param fileId the file ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByF_D_G_T(long fileId, java.util.Date startDate,
		long groupId, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByF_D_G_T(fileId, startDate, groupId, status);
	}

	/**
	* Removes all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId, java.util.Date startDate,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId, startDate, groupId);
	}

	/**
	* Removes all the v cals where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserGroup(groupId);
	}

	/**
	* Removes all the v cals where fileId = &#63; from the database.
	*
	* @param fileId the file ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFileId(long fileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFileId(fileId);
	}

	/**
	* Removes all the v cals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v cals where startDate = &#63; and status = &#63; and groupId = &#63;.
	*
	* @param startDate the start date
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByD_S_G(java.util.Date startDate, long status,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByD_S_G(startDate, status, groupId);
	}

	/**
	* Returns the number of v cals where userId = &#63; and startDate = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param status the status
	* @return the number of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_D_S(long userId, java.util.Date startDate,
		long status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_D_S(userId, startDate, status);
	}

	/**
	* Returns the number of v cals where startDate = &#63; and status = &#63;.
	*
	* @param startDate the start date
	* @param status the status
	* @return the number of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByD_S(java.util.Date startDate, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByD_S(startDate, status);
	}

	/**
	* Returns the number of v cals where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByF_D_G_U(long userId, java.util.Date startDate,
		long groupId, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByF_D_G_U(userId, startDate, groupId, status);
	}

	/**
	* Returns the number of v cals where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param fileId the file ID
	* @param startDate the start date
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByF_D_G_T(long fileId, java.util.Date startDate,
		long groupId, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByF_D_G_T(fileId, startDate, groupId, status);
	}

	/**
	* Returns the number of v cals where userId = &#63; and startDate = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param groupId the group ID
	* @return the number of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId, java.util.Date startDate,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId, startDate, groupId);
	}

	/**
	* Returns the number of v cals where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserGroup(groupId);
	}

	/**
	* Returns the number of v cals where fileId = &#63;.
	*
	* @param fileId the file ID
	* @return the number of matching v cals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFileId(long fileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFileId(fileId);
	}

	/**
	* Returns the number of v cals.
	*
	* @return the number of v cals
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VCalPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VCalPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcalendar.service.ClpSerializer.getServletContextName(),
					VCalPersistence.class.getName());

			ReferenceRegistry.registerReference(VCalUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VCalPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VCalUtil.class, "_persistence");
	}

	private static VCalPersistence _persistence;
}