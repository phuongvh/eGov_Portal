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

import com.vportal.portlet.edirectory.model.EDDepartment;

/**
 * The persistence interface for the e d department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see EDDepartmentPersistenceImpl
 * @see EDDepartmentUtil
 * @generated
 */
public interface EDDepartmentPersistence extends BasePersistence<EDDepartment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EDDepartmentUtil} to access the e d department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the e d department in the entity cache if it is enabled.
	*
	* @param edDepartment the e d department
	*/
	public void cacheResult(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment);

	/**
	* Caches the e d departments in the entity cache if it is enabled.
	*
	* @param edDepartments the e d departments
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> edDepartments);

	/**
	* Creates a new e d department with the primary key. Does not add the e d department to the database.
	*
	* @param id the primary key for the new e d department
	* @return the new e d department
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment create(long id);

	/**
	* Removes the e d department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d department
	* @return the e d department that was removed
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	public com.vportal.portlet.edirectory.model.EDDepartment updateImpl(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e d department with the primary key or throws a {@link com.vportal.portlet.edirectory.NoSuchEDDepartmentException} if it could not be found.
	*
	* @param id the primary key of the e d department
	* @return the e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the e d department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the e d department
	* @return the e d department, or <code>null</code> if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e d departments where levelEd = &#63;.
	*
	* @param levelEd the level ed
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevel(
		long levelEd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e d departments where levelEd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelEd the level ed
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @return the range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevel(
		long levelEd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e d departments where levelEd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelEd the level ed
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevel(
		long levelEd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e d department in the ordered set where levelEd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelEd the level ed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByLevel_First(
		long levelEd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the last e d department in the ordered set where levelEd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelEd the level ed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByLevel_Last(
		long levelEd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the e d departments before and after the current e d department in the ordered set where levelEd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d department
	* @param levelEd the level ed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment[] findByLevel_PrevAndNext(
		long id, long levelEd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns all the e d departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e d departments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @return the range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e d departments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e d department in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the last e d department in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the e d departments before and after the current e d department in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d department
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment[] findByGroupId_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns all the e d departments where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* @param parent the parent
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParentId(
		long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e d departments where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parent the parent
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @return the range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParentId(
		long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e d departments where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parent the parent
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParentId(
		long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e d department in the ordered set where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parent the parent
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByParentId_First(
		long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the last e d department in the ordered set where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parent the parent
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByParentId_Last(
		long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the e d departments before and after the current e d department in the ordered set where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d department
	* @param parent the parent
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment[] findByParentId_PrevAndNext(
		long id, long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns all the e d departments where parent = &#63;.
	*
	* @param parent the parent
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParent(
		long parent) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e d departments where parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parent the parent
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @return the range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParent(
		long parent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e d departments where parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parent the parent
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParent(
		long parent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e d department in the ordered set where parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parent the parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByParent_First(
		long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the last e d department in the ordered set where parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parent the parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByParent_Last(
		long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the e d departments before and after the current e d department in the ordered set where parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d department
	* @param parent the parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment[] findByParent_PrevAndNext(
		long id, long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns all the e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLanguageAndGroup(
		java.lang.String languageId, long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @return the range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLanguageAndGroup(
		java.lang.String languageId, long groupId, java.lang.String domainId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLanguageAndGroup(
		java.lang.String languageId, long groupId, java.lang.String domainId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e d department in the ordered set where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByLanguageAndGroup_First(
		java.lang.String languageId, long groupId, java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the last e d department in the ordered set where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByLanguageAndGroup_Last(
		java.lang.String languageId, long groupId, java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the e d departments before and after the current e d department in the ordered set where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d department
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment[] findByLanguageAndGroup_PrevAndNext(
		long id, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns all the e d departments where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* @param levelEd the level ed
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevelAndDomain(
		long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e d departments where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelEd the level ed
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @return the range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevelAndDomain(
		long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e d departments where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelEd the level ed
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevelAndDomain(
		long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e d department in the ordered set where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelEd the level ed
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByLevelAndDomain_First(
		long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the last e d department in the ordered set where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelEd the level ed
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByLevelAndDomain_Last(
		long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the e d departments before and after the current e d department in the ordered set where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d department
	* @param levelEd the level ed
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment[] findByLevelAndDomain_PrevAndNext(
		long id, long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the e d department where id = &#63; and groupId = &#63; or throws a {@link com.vportal.portlet.edirectory.NoSuchEDDepartmentException} if it could not be found.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByD_G(
		long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the e d department where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the matching e d department, or <code>null</code> if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment fetchByD_G(
		long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e d department where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e d department, or <code>null</code> if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment fetchByD_G(
		long id, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e d departments where languageId = &#63; and groupId = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G(
		java.lang.String languageId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e d departments where languageId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @return the range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G(
		java.lang.String languageId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e d departments where languageId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G(
		java.lang.String languageId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e d department in the ordered set where languageId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByL_G_First(
		java.lang.String languageId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the last e d department in the ordered set where languageId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByL_G_Last(
		java.lang.String languageId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the e d departments before and after the current e d department in the ordered set where languageId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d department
	* @param languageId the language ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment[] findByL_G_PrevAndNext(
		long id, java.lang.String languageId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns all the e d departments where languageId = &#63; and groupId = &#63; and parent = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param parent the parent
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G_P(
		java.lang.String languageId, long groupId, long parent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e d departments where languageId = &#63; and groupId = &#63; and parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param parent the parent
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @return the range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G_P(
		java.lang.String languageId, long groupId, long parent, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e d departments where languageId = &#63; and groupId = &#63; and parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param parent the parent
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G_P(
		java.lang.String languageId, long groupId, long parent, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e d department in the ordered set where languageId = &#63; and groupId = &#63; and parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param parent the parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByL_G_P_First(
		java.lang.String languageId, long groupId, long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the last e d department in the ordered set where languageId = &#63; and groupId = &#63; and parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param parent the parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment findByL_G_P_Last(
		java.lang.String languageId, long groupId, long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns the e d departments before and after the current e d department in the ordered set where languageId = &#63; and groupId = &#63; and parent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d department
	* @param languageId the language ID
	* @param groupId the group ID
	* @param parent the parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment[] findByL_G_P_PrevAndNext(
		long id, java.lang.String languageId, long groupId, long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Returns all the e d departments.
	*
	* @return the e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e d departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @return the range of e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e d departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e d departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d departments where levelEd = &#63; from the database.
	*
	* @param levelEd the level ed
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLevel(long levelEd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d departments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d departments where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63; from the database.
	*
	* @param parent the parent
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentId(long parent, java.lang.String languageId,
		long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d departments where parent = &#63; from the database.
	*
	* @param parent the parent
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParent(long parent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63; from the database.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLanguageAndGroup(java.lang.String languageId,
		long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d departments where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63; from the database.
	*
	* @param levelEd the level ed
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLevelAndDomain(long levelEd,
		java.lang.String languageId, long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e d department where id = &#63; and groupId = &#63; from the database.
	*
	* @param id the ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByD_G(long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException;

	/**
	* Removes all the e d departments where languageId = &#63; and groupId = &#63; from the database.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByL_G(java.lang.String languageId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d departments where languageId = &#63; and groupId = &#63; and parent = &#63; from the database.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param parent the parent
	* @throws SystemException if a system exception occurred
	*/
	public void removeByL_G_P(java.lang.String languageId, long groupId,
		long parent) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d departments where levelEd = &#63;.
	*
	* @param levelEd the level ed
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByLevel(long levelEd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d departments where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* @param parent the parent
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentId(long parent, java.lang.String languageId,
		long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d departments where parent = &#63;.
	*
	* @param parent the parent
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByParent(long parent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByLanguageAndGroup(java.lang.String languageId,
		long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d departments where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* @param levelEd the level ed
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByLevelAndDomain(long levelEd, java.lang.String languageId,
		long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d departments where id = &#63; and groupId = &#63;.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByD_G(long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d departments where languageId = &#63; and groupId = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByL_G(java.lang.String languageId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d departments where languageId = &#63; and groupId = &#63; and parent = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param parent the parent
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByL_G_P(java.lang.String languageId, long groupId,
		long parent) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d departments.
	*
	* @return the number of e d departments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}