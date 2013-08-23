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

import com.vportal.portlet.edirectory.model.EDFunctionDepartment;

import java.util.List;

/**
 * The persistence utility for the e d function department service. This utility wraps {@link EDFunctionDepartmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see EDFunctionDepartmentPersistence
 * @see EDFunctionDepartmentPersistenceImpl
 * @generated
 */
public class EDFunctionDepartmentUtil {
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
	public static void clearCache(EDFunctionDepartment edFunctionDepartment) {
		getPersistence().clearCache(edFunctionDepartment);
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
	public static List<EDFunctionDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EDFunctionDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EDFunctionDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static EDFunctionDepartment update(
		EDFunctionDepartment edFunctionDepartment, boolean merge)
		throws SystemException {
		return getPersistence().update(edFunctionDepartment, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static EDFunctionDepartment update(
		EDFunctionDepartment edFunctionDepartment, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(edFunctionDepartment, merge, serviceContext);
	}

	/**
	* Caches the e d function department in the entity cache if it is enabled.
	*
	* @param edFunctionDepartment the e d function department
	*/
	public static void cacheResult(
		com.vportal.portlet.edirectory.model.EDFunctionDepartment edFunctionDepartment) {
		getPersistence().cacheResult(edFunctionDepartment);
	}

	/**
	* Caches the e d function departments in the entity cache if it is enabled.
	*
	* @param edFunctionDepartments the e d function departments
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> edFunctionDepartments) {
		getPersistence().cacheResult(edFunctionDepartments);
	}

	/**
	* Creates a new e d function department with the primary key. Does not add the e d function department to the database.
	*
	* @param id the primary key for the new e d function department
	* @return the new e d function department
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionDepartment create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the e d function department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d function department
	* @return the e d function department that was removed
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a e d function department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionDepartment remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException {
		return getPersistence().remove(id);
	}

	public static com.vportal.portlet.edirectory.model.EDFunctionDepartment updateImpl(
		com.vportal.portlet.edirectory.model.EDFunctionDepartment edFunctionDepartment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(edFunctionDepartment, merge);
	}

	/**
	* Returns the e d function department with the primary key or throws a {@link com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException} if it could not be found.
	*
	* @param id the primary key of the e d function department
	* @return the e d function department
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a e d function department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionDepartment findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the e d function department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the e d function department
	* @return the e d function department, or <code>null</code> if a e d function department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionDepartment fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the e d function departments where functionId = &#63;.
	*
	* @param functionId the function ID
	* @return the matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByFunctionId(
		long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFunctionId(functionId);
	}

	/**
	* Returns a range of all the e d function departments where functionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param functionId the function ID
	* @param start the lower bound of the range of e d function departments
	* @param end the upper bound of the range of e d function departments (not inclusive)
	* @return the range of matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByFunctionId(
		long functionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFunctionId(functionId, start, end);
	}

	/**
	* Returns an ordered range of all the e d function departments where functionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param functionId the function ID
	* @param start the lower bound of the range of e d function departments
	* @param end the upper bound of the range of e d function departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByFunctionId(
		long functionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFunctionId(functionId, start, end, orderByComparator);
	}

	/**
	* Returns the first e d function department in the ordered set where functionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param functionId the function ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d function department
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a matching e d function department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionDepartment findByFunctionId_First(
		long functionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException {
		return getPersistence()
				   .findByFunctionId_First(functionId, orderByComparator);
	}

	/**
	* Returns the last e d function department in the ordered set where functionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param functionId the function ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d function department
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a matching e d function department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionDepartment findByFunctionId_Last(
		long functionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException {
		return getPersistence()
				   .findByFunctionId_Last(functionId, orderByComparator);
	}

	/**
	* Returns the e d function departments before and after the current e d function department in the ordered set where functionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d function department
	* @param functionId the function ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d function department
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a e d function department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionDepartment[] findByFunctionId_PrevAndNext(
		long id, long functionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException {
		return getPersistence()
				   .findByFunctionId_PrevAndNext(id, functionId,
			orderByComparator);
	}

	/**
	* Returns all the e d function departments where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByDepartmentId(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartmentId(departmentId);
	}

	/**
	* Returns a range of all the e d function departments where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of e d function departments
	* @param end the upper bound of the range of e d function departments (not inclusive)
	* @return the range of matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByDepartmentId(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartmentId(departmentId, start, end);
	}

	/**
	* Returns an ordered range of all the e d function departments where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of e d function departments
	* @param end the upper bound of the range of e d function departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByDepartmentId(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentId(departmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e d function department in the ordered set where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d function department
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a matching e d function department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionDepartment findByDepartmentId_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException {
		return getPersistence()
				   .findByDepartmentId_First(departmentId, orderByComparator);
	}

	/**
	* Returns the last e d function department in the ordered set where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d function department
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a matching e d function department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionDepartment findByDepartmentId_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException {
		return getPersistence()
				   .findByDepartmentId_Last(departmentId, orderByComparator);
	}

	/**
	* Returns the e d function departments before and after the current e d function department in the ordered set where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d function department
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d function department
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a e d function department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionDepartment[] findByDepartmentId_PrevAndNext(
		long id, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException {
		return getPersistence()
				   .findByDepartmentId_PrevAndNext(id, departmentId,
			orderByComparator);
	}

	/**
	* Returns all the e d function departments.
	*
	* @return the e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e d function departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d function departments
	* @param end the upper bound of the range of e d function departments (not inclusive)
	* @return the range of e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e d function departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d function departments
	* @param end the upper bound of the range of e d function departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e d function departments where functionId = &#63; from the database.
	*
	* @param functionId the function ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFunctionId(long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFunctionId(functionId);
	}

	/**
	* Removes all the e d function departments where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentId(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartmentId(departmentId);
	}

	/**
	* Removes all the e d function departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e d function departments where functionId = &#63;.
	*
	* @param functionId the function ID
	* @return the number of matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFunctionId(long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFunctionId(functionId);
	}

	/**
	* Returns the number of e d function departments where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentId(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDepartmentId(departmentId);
	}

	/**
	* Returns the number of e d function departments.
	*
	* @return the number of e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EDFunctionDepartmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EDFunctionDepartmentPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.edirectory.service.ClpSerializer.getServletContextName(),
					EDFunctionDepartmentPersistence.class.getName());

			ReferenceRegistry.registerReference(EDFunctionDepartmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(EDFunctionDepartmentPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(EDFunctionDepartmentUtil.class,
			"_persistence");
	}

	private static EDFunctionDepartmentPersistence _persistence;
}