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

package com.vportal.portlet.vcms.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.vportal.portlet.vcms.model.VcmsLogger;

/**
 * The persistence interface for the vcms logger service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsLoggerPersistenceImpl
 * @see VcmsLoggerUtil
 * @generated
 */
public interface VcmsLoggerPersistence extends BasePersistence<VcmsLogger> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VcmsLoggerUtil} to access the vcms logger persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vcms logger in the entity cache if it is enabled.
	*
	* @param vcmsLogger the vcms logger
	*/
	public void cacheResult(
		com.vportal.portlet.vcms.model.VcmsLogger vcmsLogger);

	/**
	* Caches the vcms loggers in the entity cache if it is enabled.
	*
	* @param vcmsLoggers the vcms loggers
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> vcmsLoggers);

	/**
	* Creates a new vcms logger with the primary key. Does not add the vcms logger to the database.
	*
	* @param loggerId the primary key for the new vcms logger
	* @return the new vcms logger
	*/
	public com.vportal.portlet.vcms.model.VcmsLogger create(
		java.lang.String loggerId);

	/**
	* Removes the vcms logger with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loggerId the primary key of the vcms logger
	* @return the vcms logger that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsLoggerException if a vcms logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsLogger remove(
		java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsLoggerException;

	public com.vportal.portlet.vcms.model.VcmsLogger updateImpl(
		com.vportal.portlet.vcms.model.VcmsLogger vcmsLogger, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms logger with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsLoggerException} if it could not be found.
	*
	* @param loggerId the primary key of the vcms logger
	* @return the vcms logger
	* @throws com.vportal.portlet.vcms.NoSuchVcmsLoggerException if a vcms logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsLogger findByPrimaryKey(
		java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsLoggerException;

	/**
	* Returns the vcms logger with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loggerId the primary key of the vcms logger
	* @return the vcms logger, or <code>null</code> if a vcms logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsLogger fetchByPrimaryKey(
		java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vcms loggers where createdByUser = &#63; and createdDate = &#63;.
	*
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @return the matching vcms loggers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findByU_D(
		java.lang.String createdByUser, java.util.Date createdDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms loggers where createdByUser = &#63; and createdDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @param start the lower bound of the range of vcms loggers
	* @param end the upper bound of the range of vcms loggers (not inclusive)
	* @return the range of matching vcms loggers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findByU_D(
		java.lang.String createdByUser, java.util.Date createdDate, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms loggers where createdByUser = &#63; and createdDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @param start the lower bound of the range of vcms loggers
	* @param end the upper bound of the range of vcms loggers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms loggers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findByU_D(
		java.lang.String createdByUser, java.util.Date createdDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms logger
	* @throws com.vportal.portlet.vcms.NoSuchVcmsLoggerException if a matching vcms logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsLogger findByU_D_First(
		java.lang.String createdByUser, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsLoggerException;

	/**
	* Returns the last vcms logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms logger
	* @throws com.vportal.portlet.vcms.NoSuchVcmsLoggerException if a matching vcms logger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsLogger findByU_D_Last(
		java.lang.String createdByUser, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsLoggerException;

	/**
	* Returns the vcms loggers before and after the current vcms logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loggerId the primary key of the current vcms logger
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms logger
	* @throws com.vportal.portlet.vcms.NoSuchVcmsLoggerException if a vcms logger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsLogger[] findByU_D_PrevAndNext(
		java.lang.String loggerId, java.lang.String createdByUser,
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsLoggerException;

	/**
	* Returns all the vcms loggers.
	*
	* @return the vcms loggers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms loggers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms loggers
	* @param end the upper bound of the range of vcms loggers (not inclusive)
	* @return the range of vcms loggers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms loggers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms loggers
	* @param end the upper bound of the range of vcms loggers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms loggers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms loggers where createdByUser = &#63; and createdDate = &#63; from the database.
	*
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_D(java.lang.String createdByUser,
		java.util.Date createdDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms loggers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms loggers where createdByUser = &#63; and createdDate = &#63;.
	*
	* @param createdByUser the created by user
	* @param createdDate the created date
	* @return the number of matching vcms loggers
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_D(java.lang.String createdByUser,
		java.util.Date createdDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms loggers.
	*
	* @return the number of vcms loggers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}