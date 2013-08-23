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

import com.vportal.portlet.vdoc.model.vdocLogger;

import java.util.List;

/**
 * The persistence utility for the vdoc logger service. This utility wraps {@link vdocLoggerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocLoggerPersistence
 * @see vdocLoggerPersistenceImpl
 * @generated
 */
public class vdocLoggerUtil {
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
	public static void clearCache(vdocLogger vdocLogger) {
		getPersistence().clearCache(vdocLogger);
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
	public static List<vdocLogger> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<vdocLogger> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<vdocLogger> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static vdocLogger update(vdocLogger vdocLogger, boolean merge)
		throws SystemException {
		return getPersistence().update(vdocLogger, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static vdocLogger update(vdocLogger vdocLogger, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vdocLogger, merge, serviceContext);
	}

	/**
	* Caches the vdoc logger in the entity cache if it is enabled.
	*
	* @param vdocLogger the vdoc logger
	*/
	public static void cacheResult(
		com.vportal.portlet.vdoc.model.vdocLogger vdocLogger) {
		getPersistence().cacheResult(vdocLogger);
	}

	/**
	* Caches the vdoc loggers in the entity cache if it is enabled.
	*
	* @param vdocLoggers the vdoc loggers
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> vdocLoggers) {
		getPersistence().cacheResult(vdocLoggers);
	}

	/**
	* Creates a new vdoc logger with the primary key. Does not add the vdoc logger to the database.
	*
	* @param loggerId the primary key for the new vdoc logger
	* @return the new vdoc logger
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger create(
		java.lang.String loggerId) {
		return getPersistence().create(loggerId);
	}

	/**
	* Removes the vdoc logger with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loggerId the primary key of the vdoc logger
	* @return the vdoc logger that was removed
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a vdoc logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger remove(
		java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException {
		return getPersistence().remove(loggerId);
	}

	public static com.vportal.portlet.vdoc.model.vdocLogger updateImpl(
		com.vportal.portlet.vdoc.model.vdocLogger vdocLogger, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vdocLogger, merge);
	}

	/**
	* Returns the vdoc logger with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocLoggerException} if it could not be found.
	*
	* @param loggerId the primary key of the vdoc logger
	* @return the vdoc logger
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a vdoc logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger findByPrimaryKey(
		java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException {
		return getPersistence().findByPrimaryKey(loggerId);
	}

	/**
	* Returns the vdoc logger with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loggerId the primary key of the vdoc logger
	* @return the vdoc logger, or <code>null</code> if a vdoc logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger fetchByPrimaryKey(
		java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(loggerId);
	}

	/**
	* Returns the vdoc logger where groupId = &#63; and loggerId = &#63; or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocLoggerException} if it could not be found.
	*
	* @param groupId the group ID
	* @param loggerId the logger ID
	* @return the matching vdoc logger
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a matching vdoc logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger findByG_L(
		long groupId, java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException {
		return getPersistence().findByG_L(groupId, loggerId);
	}

	/**
	* Returns the vdoc logger where groupId = &#63; and loggerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param loggerId the logger ID
	* @return the matching vdoc logger, or <code>null</code> if a matching vdoc logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger fetchByG_L(
		long groupId, java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_L(groupId, loggerId);
	}

	/**
	* Returns the vdoc logger where groupId = &#63; and loggerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param loggerId the logger ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vdoc logger, or <code>null</code> if a matching vdoc logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger fetchByG_L(
		long groupId, java.lang.String loggerId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_L(groupId, loggerId, retrieveFromCache);
	}

	/**
	* Returns all the vdoc loggers where groupId = &#63; and createdByUser = &#63; and createdDate = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @return the matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByU_D(
		long groupId, long createdByUser, java.util.Date createdDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_D(groupId, createdByUser, createdDate);
	}

	/**
	* Returns a range of all the vdoc loggers where groupId = &#63; and createdByUser = &#63; and createdDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @param start the lower bound of the range of vdoc loggers
	* @param end the upper bound of the range of vdoc loggers (not inclusive)
	* @return the range of matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByU_D(
		long groupId, long createdByUser, java.util.Date createdDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_D(groupId, createdByUser, createdDate, start, end);
	}

	/**
	* Returns an ordered range of all the vdoc loggers where groupId = &#63; and createdByUser = &#63; and createdDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @param start the lower bound of the range of vdoc loggers
	* @param end the upper bound of the range of vdoc loggers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByU_D(
		long groupId, long createdByUser, java.util.Date createdDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_D(groupId, createdByUser, createdDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first vdoc logger in the ordered set where groupId = &#63; and createdByUser = &#63; and createdDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc logger
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a matching vdoc logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger findByU_D_First(
		long groupId, long createdByUser, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException {
		return getPersistence()
				   .findByU_D_First(groupId, createdByUser, createdDate,
			orderByComparator);
	}

	/**
	* Returns the last vdoc logger in the ordered set where groupId = &#63; and createdByUser = &#63; and createdDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc logger
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a matching vdoc logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger findByU_D_Last(
		long groupId, long createdByUser, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException {
		return getPersistence()
				   .findByU_D_Last(groupId, createdByUser, createdDate,
			orderByComparator);
	}

	/**
	* Returns the vdoc loggers before and after the current vdoc logger in the ordered set where groupId = &#63; and createdByUser = &#63; and createdDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loggerId the primary key of the current vdoc logger
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc logger
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a vdoc logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger[] findByU_D_PrevAndNext(
		java.lang.String loggerId, long groupId, long createdByUser,
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException {
		return getPersistence()
				   .findByU_D_PrevAndNext(loggerId, groupId, createdByUser,
			createdDate, orderByComparator);
	}

	/**
	* Returns all the vdoc loggers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the vdoc loggers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of vdoc loggers
	* @param end the upper bound of the range of vdoc loggers (not inclusive)
	* @return the range of matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the vdoc loggers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of vdoc loggers
	* @param end the upper bound of the range of vdoc loggers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first vdoc logger in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc logger
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a matching vdoc logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last vdoc logger in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc logger
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a matching vdoc logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the vdoc loggers before and after the current vdoc logger in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loggerId the primary key of the current vdoc logger
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc logger
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a vdoc logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocLogger[] findByGroupId_PrevAndNext(
		java.lang.String loggerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(loggerId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the vdoc loggers.
	*
	* @return the vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vdoc loggers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vdoc loggers
	* @param end the upper bound of the range of vdoc loggers (not inclusive)
	* @return the range of vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vdoc loggers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vdoc loggers
	* @param end the upper bound of the range of vdoc loggers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the vdoc logger where groupId = &#63; and loggerId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param loggerId the logger ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L(long groupId, java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException {
		getPersistence().removeByG_L(groupId, loggerId);
	}

	/**
	* Removes all the vdoc loggers where groupId = &#63; and createdByUser = &#63; and createdDate = &#63; from the database.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_D(long groupId, long createdByUser,
		java.util.Date createdDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_D(groupId, createdByUser, createdDate);
	}

	/**
	* Removes all the vdoc loggers where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the vdoc loggers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vdoc loggers where groupId = &#63; and loggerId = &#63;.
	*
	* @param groupId the group ID
	* @param loggerId the logger ID
	* @return the number of matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L(long groupId, java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L(groupId, loggerId);
	}

	/**
	* Returns the number of vdoc loggers where groupId = &#63; and createdByUser = &#63; and createdDate = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @return the number of matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_D(long groupId, long createdByUser,
		java.util.Date createdDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_D(groupId, createdByUser, createdDate);
	}

	/**
	* Returns the number of vdoc loggers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of vdoc loggers.
	*
	* @return the number of vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static vdocLoggerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (vdocLoggerPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vdoc.service.ClpSerializer.getServletContextName(),
					vdocLoggerPersistence.class.getName());

			ReferenceRegistry.registerReference(vdocLoggerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(vdocLoggerPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(vdocLoggerUtil.class, "_persistence");
	}

	private static vdocLoggerPersistence _persistence;
}