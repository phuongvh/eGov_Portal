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

import com.liferay.portal.service.persistence.BasePersistence;

import com.vportal.portlet.edirectory.model.EDFunctionDepartment;

/**
 * The persistence interface for the e d function department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see EDFunctionDepartmentPersistenceImpl
 * @see EDFunctionDepartmentUtil
 * @generated
 */
public interface EDFunctionDepartmentPersistence extends BasePersistence<EDFunctionDepartment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EDFunctionDepartmentUtil} to access the e d function department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the e d function department in the entity cache if it is enabled.
	*
	* @param edFunctionDepartment the e d function department
	*/
	public void cacheResult(
		com.vportal.portlet.edirectory.model.EDFunctionDepartment edFunctionDepartment);

	/**
	* Caches the e d function departments in the entity cache if it is enabled.
	*
	* @param edFunctionDepartments the e d function departments
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> edFunctionDepartments);

	/**
	* Creates a new e d function department with the primary key. Does not add the e d function department to the database.
	*
	* @param id the primary key for the new e d function department
	* @return the new e d function department
	*/
	public com.vportal.portlet.edirectory.model.EDFunctionDepartment create(
		long id);

	/**
	* Removes the e d function department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d function department
	* @return the e d function department that was removed
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a e d function department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunctionDepartment remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException;

	public com.vportal.portlet.edirectory.model.EDFunctionDepartment updateImpl(
		com.vportal.portlet.edirectory.model.EDFunctionDepartment edFunctionDepartment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e d function department with the primary key or throws a {@link com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException} if it could not be found.
	*
	* @param id the primary key of the e d function department
	* @return the e d function department
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a e d function department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunctionDepartment findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException;

	/**
	* Returns the e d function department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the e d function department
	* @return the e d function department, or <code>null</code> if a e d function department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunctionDepartment fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e d function departments where functionId = &#63;.
	*
	* @param functionId the function ID
	* @return the matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByFunctionId(
		long functionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByFunctionId(
		long functionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByFunctionId(
		long functionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.edirectory.model.EDFunctionDepartment findByFunctionId_First(
		long functionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException;

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
	public com.vportal.portlet.edirectory.model.EDFunctionDepartment findByFunctionId_Last(
		long functionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException;

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
	public com.vportal.portlet.edirectory.model.EDFunctionDepartment[] findByFunctionId_PrevAndNext(
		long id, long functionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException;

	/**
	* Returns all the e d function departments where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByDepartmentId(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByDepartmentId(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findByDepartmentId(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.edirectory.model.EDFunctionDepartment findByDepartmentId_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException;

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
	public com.vportal.portlet.edirectory.model.EDFunctionDepartment findByDepartmentId_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException;

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
	public com.vportal.portlet.edirectory.model.EDFunctionDepartment[] findByDepartmentId_PrevAndNext(
		long id, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException;

	/**
	* Returns all the e d function departments.
	*
	* @return the e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionDepartment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d function departments where functionId = &#63; from the database.
	*
	* @param functionId the function ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFunctionId(long functionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d function departments where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartmentId(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d function departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d function departments where functionId = &#63;.
	*
	* @param functionId the function ID
	* @return the number of matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByFunctionId(long functionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d function departments where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartmentId(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d function departments.
	*
	* @return the number of e d function departments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}