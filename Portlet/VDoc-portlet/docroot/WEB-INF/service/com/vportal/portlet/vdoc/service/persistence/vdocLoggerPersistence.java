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

import com.vportal.portlet.vdoc.model.vdocLogger;

/**
 * The persistence interface for the vdoc logger service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocLoggerPersistenceImpl
 * @see vdocLoggerUtil
 * @generated
 */
public interface vdocLoggerPersistence extends BasePersistence<vdocLogger> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link vdocLoggerUtil} to access the vdoc logger persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vdoc logger in the entity cache if it is enabled.
	*
	* @param vdocLogger the vdoc logger
	*/
	public void cacheResult(
		com.vportal.portlet.vdoc.model.vdocLogger vdocLogger);

	/**
	* Caches the vdoc loggers in the entity cache if it is enabled.
	*
	* @param vdocLoggers the vdoc loggers
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> vdocLoggers);

	/**
	* Creates a new vdoc logger with the primary key. Does not add the vdoc logger to the database.
	*
	* @param loggerId the primary key for the new vdoc logger
	* @return the new vdoc logger
	*/
	public com.vportal.portlet.vdoc.model.vdocLogger create(
		java.lang.String loggerId);

	/**
	* Removes the vdoc logger with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loggerId the primary key of the vdoc logger
	* @return the vdoc logger that was removed
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a vdoc logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocLogger remove(
		java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException;

	public com.vportal.portlet.vdoc.model.vdocLogger updateImpl(
		com.vportal.portlet.vdoc.model.vdocLogger vdocLogger, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vdoc logger with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocLoggerException} if it could not be found.
	*
	* @param loggerId the primary key of the vdoc logger
	* @return the vdoc logger
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a vdoc logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocLogger findByPrimaryKey(
		java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException;

	/**
	* Returns the vdoc logger with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loggerId the primary key of the vdoc logger
	* @return the vdoc logger, or <code>null</code> if a vdoc logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocLogger fetchByPrimaryKey(
		java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vdoc logger where groupId = &#63; and loggerId = &#63; or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocLoggerException} if it could not be found.
	*
	* @param groupId the group ID
	* @param loggerId the logger ID
	* @return the matching vdoc logger
	* @throws com.vportal.portlet.vdoc.NoSuchvdocLoggerException if a matching vdoc logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocLogger findByG_L(long groupId,
		java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException;

	/**
	* Returns the vdoc logger where groupId = &#63; and loggerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param loggerId the logger ID
	* @return the matching vdoc logger, or <code>null</code> if a matching vdoc logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocLogger fetchByG_L(long groupId,
		java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vdoc logger where groupId = &#63; and loggerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param loggerId the logger ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vdoc logger, or <code>null</code> if a matching vdoc logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocLogger fetchByG_L(long groupId,
		java.lang.String loggerId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vdoc loggers where groupId = &#63; and createdByUser = &#63; and createdDate = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @return the matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByU_D(
		long groupId, long createdByUser, java.util.Date createdDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByU_D(
		long groupId, long createdByUser, java.util.Date createdDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByU_D(
		long groupId, long createdByUser, java.util.Date createdDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vdoc.model.vdocLogger findByU_D_First(
		long groupId, long createdByUser, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException;

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
	public com.vportal.portlet.vdoc.model.vdocLogger findByU_D_Last(
		long groupId, long createdByUser, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException;

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
	public com.vportal.portlet.vdoc.model.vdocLogger[] findByU_D_PrevAndNext(
		java.lang.String loggerId, long groupId, long createdByUser,
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException;

	/**
	* Returns all the vdoc loggers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vdoc.model.vdocLogger findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException;

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
	public com.vportal.portlet.vdoc.model.vdocLogger findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException;

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
	public com.vportal.portlet.vdoc.model.vdocLogger[] findByGroupId_PrevAndNext(
		java.lang.String loggerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException;

	/**
	* Returns all the vdoc loggers.
	*
	* @return the vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocLogger> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the vdoc logger where groupId = &#63; and loggerId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param loggerId the logger ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_L(long groupId, java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocLoggerException;

	/**
	* Removes all the vdoc loggers where groupId = &#63; and createdByUser = &#63; and createdDate = &#63; from the database.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_D(long groupId, long createdByUser,
		java.util.Date createdDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc loggers where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc loggers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc loggers where groupId = &#63; and loggerId = &#63;.
	*
	* @param groupId the group ID
	* @param loggerId the logger ID
	* @return the number of matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_L(long groupId, java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc loggers where groupId = &#63; and createdByUser = &#63; and createdDate = &#63;.
	*
	* @param groupId the group ID
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @return the number of matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_D(long groupId, long createdByUser,
		java.util.Date createdDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc loggers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc loggers.
	*
	* @return the number of vdoc loggers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}