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

package com.vportal.portlet.edirectory.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.edirectory.model.EDEmployee;

import java.util.List;

/**
 * The persistence utility for the e d employee service. This utility wraps {@link EDEmployeePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see EDEmployeePersistence
 * @see EDEmployeePersistenceImpl
 * @generated
 */
public class EDEmployeeUtil {
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
	public static void clearCache(EDEmployee edEmployee) {
		getPersistence().clearCache(edEmployee);
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
	public static List<EDEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EDEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EDEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static EDEmployee update(EDEmployee edEmployee, boolean merge)
		throws SystemException {
		return getPersistence().update(edEmployee, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static EDEmployee update(EDEmployee edEmployee, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(edEmployee, merge, serviceContext);
	}

	/**
	* Caches the e d employee in the entity cache if it is enabled.
	*
	* @param edEmployee the e d employee
	*/
	public static void cacheResult(
		com.vportal.portlet.edirectory.model.EDEmployee edEmployee) {
		getPersistence().cacheResult(edEmployee);
	}

	/**
	* Caches the e d employees in the entity cache if it is enabled.
	*
	* @param edEmployees the e d employees
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> edEmployees) {
		getPersistence().cacheResult(edEmployees);
	}

	/**
	* Creates a new e d employee with the primary key. Does not add the e d employee to the database.
	*
	* @param id the primary key for the new e d employee
	* @return the new e d employee
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the e d employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d employee
	* @return the e d employee that was removed
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence().remove(id);
	}

	public static com.vportal.portlet.edirectory.model.EDEmployee updateImpl(
		com.vportal.portlet.edirectory.model.EDEmployee edEmployee,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(edEmployee, merge);
	}

	/**
	* Returns the e d employee with the primary key or throws a {@link com.vportal.portlet.edirectory.NoSuchEDEmployeeException} if it could not be found.
	*
	* @param id the primary key of the e d employee
	* @return the e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the e d employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the e d employee
	* @return the e d employee, or <code>null</code> if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the e d employees where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e d employees where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @return the range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e d employees where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e d employee in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e d employee in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e d employees before and after the current e d employee in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d employee
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee[] findByUuid_PrevAndNext(
		long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
	}

	/**
	* Returns the e d employee where uuid = &#63; and groupId = &#63; or throws a {@link com.vportal.portlet.edirectory.NoSuchEDEmployeeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e d employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e d employee, or <code>null</code> if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e d employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e d employee, or <code>null</code> if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Returns the e d employee where departmentId = &#63; and id = &#63; or throws a {@link com.vportal.portlet.edirectory.NoSuchEDEmployeeException} if it could not be found.
	*
	* @param departmentId the department ID
	* @param id the ID
	* @return the matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByDepartment_Id(
		long departmentId, long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence().findByDepartment_Id(departmentId, id);
	}

	/**
	* Returns the e d employee where departmentId = &#63; and id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param departmentId the department ID
	* @param id the ID
	* @return the matching e d employee, or <code>null</code> if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee fetchByDepartment_Id(
		long departmentId, long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDepartment_Id(departmentId, id);
	}

	/**
	* Returns the e d employee where departmentId = &#63; and id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param departmentId the department ID
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e d employee, or <code>null</code> if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee fetchByDepartment_Id(
		long departmentId, long id, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartment_Id(departmentId, id, retrieveFromCache);
	}

	/**
	* Returns all the e d employees where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the e d employees where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @return the range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e d employees where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first e d employee in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last e d employee in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the e d employees before and after the current e d employee in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d employee
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee[] findByGroupId_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(id, groupId, orderByComparator);
	}

	/**
	* Returns all the e d employees where departmentId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByDepartmentId_Status(
		long departmentId, long groupId, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentId_Status(departmentId, groupId, status);
	}

	/**
	* Returns a range of all the e d employees where departmentId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @return the range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByDepartmentId_Status(
		long departmentId, long groupId, long status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentId_Status(departmentId, groupId, status,
			start, end);
	}

	/**
	* Returns an ordered range of all the e d employees where departmentId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByDepartmentId_Status(
		long departmentId, long groupId, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentId_Status(departmentId, groupId, status,
			start, end, orderByComparator);
	}

	/**
	* Returns the first e d employee in the ordered set where departmentId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByDepartmentId_Status_First(
		long departmentId, long groupId, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByDepartmentId_Status_First(departmentId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns the last e d employee in the ordered set where departmentId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByDepartmentId_Status_Last(
		long departmentId, long groupId, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByDepartmentId_Status_Last(departmentId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns the e d employees before and after the current e d employee in the ordered set where departmentId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d employee
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee[] findByDepartmentId_Status_PrevAndNext(
		long id, long departmentId, long groupId, long status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByDepartmentId_Status_PrevAndNext(id, departmentId,
			groupId, status, orderByComparator);
	}

	/**
	* Returns all the e d employees where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByDepartmentId(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartmentId(departmentId);
	}

	/**
	* Returns a range of all the e d employees where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @return the range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByDepartmentId(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartmentId(departmentId, start, end);
	}

	/**
	* Returns an ordered range of all the e d employees where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByDepartmentId(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentId(departmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e d employee in the ordered set where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByDepartmentId_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByDepartmentId_First(departmentId, orderByComparator);
	}

	/**
	* Returns the last e d employee in the ordered set where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByDepartmentId_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByDepartmentId_Last(departmentId, orderByComparator);
	}

	/**
	* Returns the e d employees before and after the current e d employee in the ordered set where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d employee
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee[] findByDepartmentId_PrevAndNext(
		long id, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByDepartmentId_PrevAndNext(id, departmentId,
			orderByComparator);
	}

	/**
	* Returns all the e d employees where isShowTree = &#63;.
	*
	* @param isShowTree the is show tree
	* @return the matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByIsShowed(
		boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsShowed(isShowTree);
	}

	/**
	* Returns a range of all the e d employees where isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isShowTree the is show tree
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @return the range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByIsShowed(
		boolean isShowTree, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsShowed(isShowTree, start, end);
	}

	/**
	* Returns an ordered range of all the e d employees where isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isShowTree the is show tree
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByIsShowed(
		boolean isShowTree, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsShowed(isShowTree, start, end, orderByComparator);
	}

	/**
	* Returns the first e d employee in the ordered set where isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isShowTree the is show tree
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByIsShowed_First(
		boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByIsShowed_First(isShowTree, orderByComparator);
	}

	/**
	* Returns the last e d employee in the ordered set where isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isShowTree the is show tree
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByIsShowed_Last(
		boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByIsShowed_Last(isShowTree, orderByComparator);
	}

	/**
	* Returns the e d employees before and after the current e d employee in the ordered set where isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d employee
	* @param isShowTree the is show tree
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee[] findByIsShowed_PrevAndNext(
		long id, boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByIsShowed_PrevAndNext(id, isShowTree, orderByComparator);
	}

	/**
	* Returns all the e d employees where groupId = &#63; and languageId = &#63;.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @return the matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByG_L(
		long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(groupId, languageId);
	}

	/**
	* Returns a range of all the e d employees where groupId = &#63; and languageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @return the range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByG_L(
		long groupId, java.lang.String languageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(groupId, languageId, start, end);
	}

	/**
	* Returns an ordered range of all the e d employees where groupId = &#63; and languageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByG_L(
		long groupId, java.lang.String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L(groupId, languageId, start, end, orderByComparator);
	}

	/**
	* Returns the first e d employee in the ordered set where groupId = &#63; and languageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByG_L_First(
		long groupId, java.lang.String languageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByG_L_First(groupId, languageId, orderByComparator);
	}

	/**
	* Returns the last e d employee in the ordered set where groupId = &#63; and languageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByG_L_Last(
		long groupId, java.lang.String languageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByG_L_Last(groupId, languageId, orderByComparator);
	}

	/**
	* Returns the e d employees before and after the current e d employee in the ordered set where groupId = &#63; and languageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d employee
	* @param groupId the group ID
	* @param languageId the language ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee[] findByG_L_PrevAndNext(
		long id, long groupId, java.lang.String languageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByG_L_PrevAndNext(id, groupId, languageId,
			orderByComparator);
	}

	/**
	* Returns all the e d employees where groupId = &#63; and languageId = &#63; and isShowTree = &#63;.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param isShowTree the is show tree
	* @return the matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByG_L_I(
		long groupId, java.lang.String languageId, boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L_I(groupId, languageId, isShowTree);
	}

	/**
	* Returns a range of all the e d employees where groupId = &#63; and languageId = &#63; and isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param isShowTree the is show tree
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @return the range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByG_L_I(
		long groupId, java.lang.String languageId, boolean isShowTree,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_I(groupId, languageId, isShowTree, start, end);
	}

	/**
	* Returns an ordered range of all the e d employees where groupId = &#63; and languageId = &#63; and isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param isShowTree the is show tree
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByG_L_I(
		long groupId, java.lang.String languageId, boolean isShowTree,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_I(groupId, languageId, isShowTree, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e d employee in the ordered set where groupId = &#63; and languageId = &#63; and isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param isShowTree the is show tree
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByG_L_I_First(
		long groupId, java.lang.String languageId, boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByG_L_I_First(groupId, languageId, isShowTree,
			orderByComparator);
	}

	/**
	* Returns the last e d employee in the ordered set where groupId = &#63; and languageId = &#63; and isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param isShowTree the is show tree
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByG_L_I_Last(
		long groupId, java.lang.String languageId, boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByG_L_I_Last(groupId, languageId, isShowTree,
			orderByComparator);
	}

	/**
	* Returns the e d employees before and after the current e d employee in the ordered set where groupId = &#63; and languageId = &#63; and isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d employee
	* @param groupId the group ID
	* @param languageId the language ID
	* @param isShowTree the is show tree
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee[] findByG_L_I_PrevAndNext(
		long id, long groupId, java.lang.String languageId, boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByG_L_I_PrevAndNext(id, groupId, languageId,
			isShowTree, orderByComparator);
	}

	/**
	* Returns the e d employee where id = &#63; and groupId = &#63; or throws a {@link com.vportal.portlet.edirectory.NoSuchEDEmployeeException} if it could not be found.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByE_G(
		long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence().findByE_G(id, groupId);
	}

	/**
	* Returns the e d employee where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the matching e d employee, or <code>null</code> if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee fetchByE_G(
		long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByE_G(id, groupId);
	}

	/**
	* Returns the e d employee where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e d employee, or <code>null</code> if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee fetchByE_G(
		long id, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByE_G(id, groupId, retrieveFromCache);
	}

	/**
	* Returns all the e d employees where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByDepartmentId_GroupId(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartmentId_GroupId(departmentId, groupId);
	}

	/**
	* Returns a range of all the e d employees where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @return the range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByDepartmentId_GroupId(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentId_GroupId(departmentId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e d employees where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findByDepartmentId_GroupId(
		long departmentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentId_GroupId(departmentId, groupId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first e d employee in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByDepartmentId_GroupId_First(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByDepartmentId_GroupId_First(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last e d employee in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a matching e d employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee findByDepartmentId_GroupId_Last(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByDepartmentId_GroupId_Last(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the e d employees before and after the current e d employee in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d employee
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDEmployee[] findByDepartmentId_GroupId_PrevAndNext(
		long id, long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return getPersistence()
				   .findByDepartmentId_GroupId_PrevAndNext(id, departmentId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the e d employees.
	*
	* @return the e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e d employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @return the range of e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e d employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e d employees where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes the e d employee where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Removes the e d employee where departmentId = &#63; and id = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param id the ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartment_Id(long departmentId, long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		getPersistence().removeByDepartment_Id(departmentId, id);
	}

	/**
	* Removes all the e d employees where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the e d employees where departmentId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentId_Status(long departmentId,
		long groupId, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByDepartmentId_Status(departmentId, groupId, status);
	}

	/**
	* Removes all the e d employees where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentId(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartmentId(departmentId);
	}

	/**
	* Removes all the e d employees where isShowTree = &#63; from the database.
	*
	* @param isShowTree the is show tree
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsShowed(boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsShowed(isShowTree);
	}

	/**
	* Removes all the e d employees where groupId = &#63; and languageId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L(long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L(groupId, languageId);
	}

	/**
	* Removes all the e d employees where groupId = &#63; and languageId = &#63; and isShowTree = &#63; from the database.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param isShowTree the is show tree
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L_I(long groupId, java.lang.String languageId,
		boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L_I(groupId, languageId, isShowTree);
	}

	/**
	* Removes the e d employee where id = &#63; and groupId = &#63; from the database.
	*
	* @param id the ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByE_G(long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		getPersistence().removeByE_G(id, groupId);
	}

	/**
	* Removes all the e d employees where departmentId = &#63; and groupId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentId_GroupId(long departmentId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartmentId_GroupId(departmentId, groupId);
	}

	/**
	* Removes all the e d employees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e d employees where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of e d employees where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of e d employees where departmentId = &#63; and id = &#63;.
	*
	* @param departmentId the department ID
	* @param id the ID
	* @return the number of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartment_Id(long departmentId, long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDepartment_Id(departmentId, id);
	}

	/**
	* Returns the number of e d employees where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of e d employees where departmentId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentId_Status(long departmentId,
		long groupId, long status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDepartmentId_Status(departmentId, groupId, status);
	}

	/**
	* Returns the number of e d employees where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentId(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDepartmentId(departmentId);
	}

	/**
	* Returns the number of e d employees where isShowTree = &#63;.
	*
	* @param isShowTree the is show tree
	* @return the number of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsShowed(boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsShowed(isShowTree);
	}

	/**
	* Returns the number of e d employees where groupId = &#63; and languageId = &#63;.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @return the number of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L(long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L(groupId, languageId);
	}

	/**
	* Returns the number of e d employees where groupId = &#63; and languageId = &#63; and isShowTree = &#63;.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param isShowTree the is show tree
	* @return the number of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L_I(long groupId, java.lang.String languageId,
		boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L_I(groupId, languageId, isShowTree);
	}

	/**
	* Returns the number of e d employees where id = &#63; and groupId = &#63;.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the number of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByE_G(long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByE_G(id, groupId);
	}

	/**
	* Returns the number of e d employees where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the number of matching e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentId_GroupId(long departmentId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDepartmentId_GroupId(departmentId, groupId);
	}

	/**
	* Returns the number of e d employees.
	*
	* @return the number of e d employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EDEmployeePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EDEmployeePersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.edirectory.service.ClpSerializer.getServletContextName(),
					EDEmployeePersistence.class.getName());

			ReferenceRegistry.registerReference(EDEmployeeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(EDEmployeePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(EDEmployeeUtil.class, "_persistence");
	}

	private static EDEmployeePersistence _persistence;
}