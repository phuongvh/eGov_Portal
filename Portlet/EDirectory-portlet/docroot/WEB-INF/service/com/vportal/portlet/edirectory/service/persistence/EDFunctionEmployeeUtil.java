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

import com.vportal.portlet.edirectory.model.EDFunctionEmployee;

import java.util.List;

/**
 * The persistence utility for the e d function employee service. This utility wraps {@link EDFunctionEmployeePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see EDFunctionEmployeePersistence
 * @see EDFunctionEmployeePersistenceImpl
 * @generated
 */
public class EDFunctionEmployeeUtil {
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
	public static void clearCache(EDFunctionEmployee edFunctionEmployee) {
		getPersistence().clearCache(edFunctionEmployee);
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
	public static List<EDFunctionEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EDFunctionEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EDFunctionEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static EDFunctionEmployee update(
		EDFunctionEmployee edFunctionEmployee, boolean merge)
		throws SystemException {
		return getPersistence().update(edFunctionEmployee, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static EDFunctionEmployee update(
		EDFunctionEmployee edFunctionEmployee, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(edFunctionEmployee, merge, serviceContext);
	}

	/**
	* Caches the e d function employee in the entity cache if it is enabled.
	*
	* @param edFunctionEmployee the e d function employee
	*/
	public static void cacheResult(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee) {
		getPersistence().cacheResult(edFunctionEmployee);
	}

	/**
	* Caches the e d function employees in the entity cache if it is enabled.
	*
	* @param edFunctionEmployees the e d function employees
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> edFunctionEmployees) {
		getPersistence().cacheResult(edFunctionEmployees);
	}

	/**
	* Creates a new e d function employee with the primary key. Does not add the e d function employee to the database.
	*
	* @param id the primary key for the new e d function employee
	* @return the new e d function employee
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the e d function employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d function employee
	* @return the e d function employee that was removed
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a e d function employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException {
		return getPersistence().remove(id);
	}

	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee updateImpl(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(edFunctionEmployee, merge);
	}

	/**
	* Returns the e d function employee with the primary key or throws a {@link com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException} if it could not be found.
	*
	* @param id the primary key of the e d function employee
	* @return the e d function employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a e d function employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the e d function employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the e d function employee
	* @return the e d function employee, or <code>null</code> if a e d function employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the e d function employees where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e d function employees where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e d function employees
	* @param end the upper bound of the range of e d function employees (not inclusive)
	* @return the range of matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e d function employees where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e d function employees
	* @param end the upper bound of the range of e d function employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e d function employee in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d function employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e d function employee in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d function employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e d function employees before and after the current e d function employee in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d function employee
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d function employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a e d function employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee[] findByUuid_PrevAndNext(
		long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException {
		return getPersistence()
				   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
	}

	/**
	* Returns all the e d function employees where functionId = &#63;.
	*
	* @param functionId the function ID
	* @return the matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findByFunctionId(
		long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFunctionId(functionId);
	}

	/**
	* Returns a range of all the e d function employees where functionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param functionId the function ID
	* @param start the lower bound of the range of e d function employees
	* @param end the upper bound of the range of e d function employees (not inclusive)
	* @return the range of matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findByFunctionId(
		long functionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFunctionId(functionId, start, end);
	}

	/**
	* Returns an ordered range of all the e d function employees where functionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param functionId the function ID
	* @param start the lower bound of the range of e d function employees
	* @param end the upper bound of the range of e d function employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findByFunctionId(
		long functionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFunctionId(functionId, start, end, orderByComparator);
	}

	/**
	* Returns the first e d function employee in the ordered set where functionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param functionId the function ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d function employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee findByFunctionId_First(
		long functionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException {
		return getPersistence()
				   .findByFunctionId_First(functionId, orderByComparator);
	}

	/**
	* Returns the last e d function employee in the ordered set where functionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param functionId the function ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d function employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee findByFunctionId_Last(
		long functionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException {
		return getPersistence()
				   .findByFunctionId_Last(functionId, orderByComparator);
	}

	/**
	* Returns the e d function employees before and after the current e d function employee in the ordered set where functionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d function employee
	* @param functionId the function ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d function employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a e d function employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee[] findByFunctionId_PrevAndNext(
		long id, long functionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException {
		return getPersistence()
				   .findByFunctionId_PrevAndNext(id, functionId,
			orderByComparator);
	}

	/**
	* Returns all the e d function employees where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findByEmployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	* Returns a range of all the e d function employees where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of e d function employees
	* @param end the upper bound of the range of e d function employees (not inclusive)
	* @return the range of matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findByEmployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the e d function employees where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of e d function employees
	* @param end the upper bound of the range of e d function employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmployeeId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns the first e d function employee in the ordered set where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d function employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee findByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException {
		return getPersistence()
				   .findByEmployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last e d function employee in the ordered set where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d function employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee findByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException {
		return getPersistence()
				   .findByEmployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the e d function employees before and after the current e d function employee in the ordered set where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d function employee
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d function employee
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a e d function employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee[] findByEmployeeId_PrevAndNext(
		long id, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException {
		return getPersistence()
				   .findByEmployeeId_PrevAndNext(id, employeeId,
			orderByComparator);
	}

	/**
	* Returns all the e d function employees.
	*
	* @return the e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e d function employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d function employees
	* @param end the upper bound of the range of e d function employees (not inclusive)
	* @return the range of e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e d function employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d function employees
	* @param end the upper bound of the range of e d function employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e d function employees where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes all the e d function employees where functionId = &#63; from the database.
	*
	* @param functionId the function ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFunctionId(long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFunctionId(functionId);
	}

	/**
	* Removes all the e d function employees where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	* Removes all the e d function employees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e d function employees where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of e d function employees where functionId = &#63;.
	*
	* @param functionId the function ID
	* @return the number of matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFunctionId(long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFunctionId(functionId);
	}

	/**
	* Returns the number of e d function employees where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	* Returns the number of e d function employees.
	*
	* @return the number of e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EDFunctionEmployeePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EDFunctionEmployeePersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.edirectory.service.ClpSerializer.getServletContextName(),
					EDFunctionEmployeePersistence.class.getName());

			ReferenceRegistry.registerReference(EDFunctionEmployeeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(EDFunctionEmployeePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(EDFunctionEmployeeUtil.class,
			"_persistence");
	}

	private static EDFunctionEmployeePersistence _persistence;
}