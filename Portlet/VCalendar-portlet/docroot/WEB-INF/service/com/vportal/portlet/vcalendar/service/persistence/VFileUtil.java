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

import com.vportal.portlet.vcalendar.model.VFile;

import java.util.List;

/**
 * The persistence utility for the v file service. This utility wraps {@link VFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LongLH
 * @see VFilePersistence
 * @see VFilePersistenceImpl
 * @generated
 */
public class VFileUtil {
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
	public static void clearCache(VFile vFile) {
		getPersistence().clearCache(vFile);
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
	public static List<VFile> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VFile> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VFile> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VFile update(VFile vFile, boolean merge)
		throws SystemException {
		return getPersistence().update(vFile, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VFile update(VFile vFile, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vFile, merge, serviceContext);
	}

	/**
	* Caches the v file in the entity cache if it is enabled.
	*
	* @param vFile the v file
	*/
	public static void cacheResult(
		com.vportal.portlet.vcalendar.model.VFile vFile) {
		getPersistence().cacheResult(vFile);
	}

	/**
	* Caches the v files in the entity cache if it is enabled.
	*
	* @param vFiles the v files
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vcalendar.model.VFile> vFiles) {
		getPersistence().cacheResult(vFiles);
	}

	/**
	* Creates a new v file with the primary key. Does not add the v file to the database.
	*
	* @param fileId the primary key for the new v file
	* @return the new v file
	*/
	public static com.vportal.portlet.vcalendar.model.VFile create(long fileId) {
		return getPersistence().create(fileId);
	}

	/**
	* Removes the v file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileId the primary key of the v file
	* @return the v file that was removed
	* @throws com.vportal.portlet.vcalendar.NoSuchVFileException if a v file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VFile remove(long fileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException {
		return getPersistence().remove(fileId);
	}

	public static com.vportal.portlet.vcalendar.model.VFile updateImpl(
		com.vportal.portlet.vcalendar.model.VFile vFile, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vFile, merge);
	}

	/**
	* Returns the v file with the primary key or throws a {@link com.vportal.portlet.vcalendar.NoSuchVFileException} if it could not be found.
	*
	* @param fileId the primary key of the v file
	* @return the v file
	* @throws com.vportal.portlet.vcalendar.NoSuchVFileException if a v file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VFile findByPrimaryKey(
		long fileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException {
		return getPersistence().findByPrimaryKey(fileId);
	}

	/**
	* Returns the v file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fileId the primary key of the v file
	* @return the v file, or <code>null</code> if a v file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VFile fetchByPrimaryKey(
		long fileId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(fileId);
	}

	/**
	* Returns all the v files where status = &#63;.
	*
	* @param status the status
	* @return the matching v files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByGroupID(
		long status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupID(status);
	}

	/**
	* Returns a range of all the v files where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of v files
	* @param end the upper bound of the range of v files (not inclusive)
	* @return the range of matching v files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByGroupID(
		long status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupID(status, start, end);
	}

	/**
	* Returns an ordered range of all the v files where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of v files
	* @param end the upper bound of the range of v files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByGroupID(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupID(status, start, end, orderByComparator);
	}

	/**
	* Returns the first v file in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v file
	* @throws com.vportal.portlet.vcalendar.NoSuchVFileException if a matching v file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VFile findByGroupID_First(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException {
		return getPersistence().findByGroupID_First(status, orderByComparator);
	}

	/**
	* Returns the last v file in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v file
	* @throws com.vportal.portlet.vcalendar.NoSuchVFileException if a matching v file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VFile findByGroupID_Last(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException {
		return getPersistence().findByGroupID_Last(status, orderByComparator);
	}

	/**
	* Returns the v files before and after the current v file in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileId the primary key of the current v file
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v file
	* @throws com.vportal.portlet.vcalendar.NoSuchVFileException if a v file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcalendar.model.VFile[] findByGroupID_PrevAndNext(
		long fileId, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException {
		return getPersistence()
				   .findByGroupID_PrevAndNext(fileId, status, orderByComparator);
	}

	/**
	* Returns all the v files.
	*
	* @return the v files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the v files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v files
	* @param end the upper bound of the range of v files (not inclusive)
	* @return the range of v files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the v files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v files
	* @param end the upper bound of the range of v files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcalendar.model.VFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v files where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupID(long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupID(status);
	}

	/**
	* Removes all the v files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v files where status = &#63;.
	*
	* @param status the status
	* @return the number of matching v files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupID(long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupID(status);
	}

	/**
	* Returns the number of v files.
	*
	* @return the number of v files
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VFilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VFilePersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcalendar.service.ClpSerializer.getServletContextName(),
					VFilePersistence.class.getName());

			ReferenceRegistry.registerReference(VFileUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VFilePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VFileUtil.class, "_persistence");
	}

	private static VFilePersistence _persistence;
}