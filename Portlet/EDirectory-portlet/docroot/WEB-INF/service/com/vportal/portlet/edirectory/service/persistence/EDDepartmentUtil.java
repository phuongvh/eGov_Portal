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

import com.vportal.portlet.edirectory.model.EDDepartment;

import java.util.List;

/**
 * The persistence utility for the e d department service. This utility wraps {@link EDDepartmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see EDDepartmentPersistence
 * @see EDDepartmentPersistenceImpl
 * @generated
 */
public class EDDepartmentUtil {
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
	public static void clearCache(EDDepartment edDepartment) {
		getPersistence().clearCache(edDepartment);
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
	public static List<EDDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EDDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EDDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static EDDepartment update(EDDepartment edDepartment, boolean merge)
		throws SystemException {
		return getPersistence().update(edDepartment, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static EDDepartment update(EDDepartment edDepartment, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(edDepartment, merge, serviceContext);
	}

	/**
	* Caches the e d department in the entity cache if it is enabled.
	*
	* @param edDepartment the e d department
	*/
	public static void cacheResult(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment) {
		getPersistence().cacheResult(edDepartment);
	}

	/**
	* Caches the e d departments in the entity cache if it is enabled.
	*
	* @param edDepartments the e d departments
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> edDepartments) {
		getPersistence().cacheResult(edDepartments);
	}

	/**
	* Creates a new e d department with the primary key. Does not add the e d department to the database.
	*
	* @param id the primary key for the new e d department
	* @return the new e d department
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the e d department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d department
	* @return the e d department that was removed
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence().remove(id);
	}

	public static com.vportal.portlet.edirectory.model.EDDepartment updateImpl(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(edDepartment, merge);
	}

	/**
	* Returns the e d department with the primary key or throws a {@link com.vportal.portlet.edirectory.NoSuchEDDepartmentException} if it could not be found.
	*
	* @param id the primary key of the e d department
	* @return the e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the e d department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the e d department
	* @return the e d department, or <code>null</code> if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the e d departments where levelEd = &#63;.
	*
	* @param levelEd the level ed
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevel(
		long levelEd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevel(levelEd);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevel(
		long levelEd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevel(levelEd, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevel(
		long levelEd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLevel(levelEd, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByLevel_First(
		long levelEd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence().findByLevel_First(levelEd, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByLevel_Last(
		long levelEd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence().findByLevel_Last(levelEd, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment[] findByLevel_PrevAndNext(
		long id, long levelEd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByLevel_PrevAndNext(id, levelEd, orderByComparator);
	}

	/**
	* Returns all the e d departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment[] findByGroupId_PrevAndNext(
		long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(id, groupId, orderByComparator);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParentId(
		long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentId(parent, languageId, groupId, domainId);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParentId(
		long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentId(parent, languageId, groupId, domainId,
			start, end);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParentId(
		long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentId(parent, languageId, groupId, domainId,
			start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByParentId_First(
		long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByParentId_First(parent, languageId, groupId, domainId,
			orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByParentId_Last(
		long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByParentId_Last(parent, languageId, groupId, domainId,
			orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment[] findByParentId_PrevAndNext(
		long id, long parent, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByParentId_PrevAndNext(id, parent, languageId, groupId,
			domainId, orderByComparator);
	}

	/**
	* Returns all the e d departments where parent = &#63;.
	*
	* @param parent the parent
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParent(
		long parent) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParent(parent);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParent(
		long parent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParent(parent, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByParent(
		long parent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParent(parent, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByParent_First(
		long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence().findByParent_First(parent, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByParent_Last(
		long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence().findByParent_Last(parent, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment[] findByParent_PrevAndNext(
		long id, long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByParent_PrevAndNext(id, parent, orderByComparator);
	}

	/**
	* Returns all the e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLanguageAndGroup(
		java.lang.String languageId, long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLanguageAndGroup(languageId, groupId, domainId);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLanguageAndGroup(
		java.lang.String languageId, long groupId, java.lang.String domainId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLanguageAndGroup(languageId, groupId, domainId,
			start, end);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLanguageAndGroup(
		java.lang.String languageId, long groupId, java.lang.String domainId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLanguageAndGroup(languageId, groupId, domainId,
			start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByLanguageAndGroup_First(
		java.lang.String languageId, long groupId, java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByLanguageAndGroup_First(languageId, groupId, domainId,
			orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByLanguageAndGroup_Last(
		java.lang.String languageId, long groupId, java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByLanguageAndGroup_Last(languageId, groupId, domainId,
			orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment[] findByLanguageAndGroup_PrevAndNext(
		long id, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByLanguageAndGroup_PrevAndNext(id, languageId, groupId,
			domainId, orderByComparator);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevelAndDomain(
		long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLevelAndDomain(levelEd, languageId, groupId, domainId);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevelAndDomain(
		long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLevelAndDomain(levelEd, languageId, groupId,
			domainId, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByLevelAndDomain(
		long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLevelAndDomain(levelEd, languageId, groupId,
			domainId, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByLevelAndDomain_First(
		long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByLevelAndDomain_First(levelEd, languageId, groupId,
			domainId, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByLevelAndDomain_Last(
		long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByLevelAndDomain_Last(levelEd, languageId, groupId,
			domainId, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment[] findByLevelAndDomain_PrevAndNext(
		long id, long levelEd, java.lang.String languageId, long groupId,
		java.lang.String domainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByLevelAndDomain_PrevAndNext(id, levelEd, languageId,
			groupId, domainId, orderByComparator);
	}

	/**
	* Returns the e d department where id = &#63; and groupId = &#63; or throws a {@link com.vportal.portlet.edirectory.NoSuchEDDepartmentException} if it could not be found.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the matching e d department
	* @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment findByD_G(
		long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence().findByD_G(id, groupId);
	}

	/**
	* Returns the e d department where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the matching e d department, or <code>null</code> if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment fetchByD_G(
		long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByD_G(id, groupId);
	}

	/**
	* Returns the e d department where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e d department, or <code>null</code> if a matching e d department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment fetchByD_G(
		long id, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByD_G(id, groupId, retrieveFromCache);
	}

	/**
	* Returns all the e d departments where languageId = &#63; and groupId = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G(
		java.lang.String languageId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByL_G(languageId, groupId);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G(
		java.lang.String languageId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByL_G(languageId, groupId, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G(
		java.lang.String languageId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByL_G(languageId, groupId, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByL_G_First(
		java.lang.String languageId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByL_G_First(languageId, groupId, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByL_G_Last(
		java.lang.String languageId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByL_G_Last(languageId, groupId, orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment[] findByL_G_PrevAndNext(
		long id, java.lang.String languageId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByL_G_PrevAndNext(id, languageId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the e d departments where languageId = &#63; and groupId = &#63; and parent = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param parent the parent
	* @return the matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G_P(
		java.lang.String languageId, long groupId, long parent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByL_G_P(languageId, groupId, parent);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G_P(
		java.lang.String languageId, long groupId, long parent, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByL_G_P(languageId, groupId, parent, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findByL_G_P(
		java.lang.String languageId, long groupId, long parent, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByL_G_P(languageId, groupId, parent, start, end,
			orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByL_G_P_First(
		java.lang.String languageId, long groupId, long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByL_G_P_First(languageId, groupId, parent,
			orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment findByL_G_P_Last(
		java.lang.String languageId, long groupId, long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByL_G_P_Last(languageId, groupId, parent,
			orderByComparator);
	}

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
	public static com.vportal.portlet.edirectory.model.EDDepartment[] findByL_G_P_PrevAndNext(
		long id, java.lang.String languageId, long groupId, long parent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getPersistence()
				   .findByL_G_P_PrevAndNext(id, languageId, groupId, parent,
			orderByComparator);
	}

	/**
	* Returns all the e d departments.
	*
	* @return the e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e d departments where levelEd = &#63; from the database.
	*
	* @param levelEd the level ed
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLevel(long levelEd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLevel(levelEd);
	}

	/**
	* Removes all the e d departments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the e d departments where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63; from the database.
	*
	* @param parent the parent
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentId(long parent,
		java.lang.String languageId, long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentId(parent, languageId, groupId, domainId);
	}

	/**
	* Removes all the e d departments where parent = &#63; from the database.
	*
	* @param parent the parent
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParent(long parent)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParent(parent);
	}

	/**
	* Removes all the e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63; from the database.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLanguageAndGroup(java.lang.String languageId,
		long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLanguageAndGroup(languageId, groupId, domainId);
	}

	/**
	* Removes all the e d departments where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63; from the database.
	*
	* @param levelEd the level ed
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLevelAndDomain(long levelEd,
		java.lang.String languageId, long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByLevelAndDomain(levelEd, languageId, groupId, domainId);
	}

	/**
	* Removes the e d department where id = &#63; and groupId = &#63; from the database.
	*
	* @param id the ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByD_G(long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		getPersistence().removeByD_G(id, groupId);
	}

	/**
	* Removes all the e d departments where languageId = &#63; and groupId = &#63; from the database.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByL_G(java.lang.String languageId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByL_G(languageId, groupId);
	}

	/**
	* Removes all the e d departments where languageId = &#63; and groupId = &#63; and parent = &#63; from the database.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param parent the parent
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByL_G_P(java.lang.String languageId, long groupId,
		long parent) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByL_G_P(languageId, groupId, parent);
	}

	/**
	* Removes all the e d departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e d departments where levelEd = &#63;.
	*
	* @param levelEd the level ed
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLevel(long levelEd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLevel(levelEd);
	}

	/**
	* Returns the number of e d departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

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
	public static int countByParentId(long parent, java.lang.String languageId,
		long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByParentId(parent, languageId, groupId, domainId);
	}

	/**
	* Returns the number of e d departments where parent = &#63;.
	*
	* @param parent the parent
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParent(long parent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParent(parent);
	}

	/**
	* Returns the number of e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param domainId the domain ID
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLanguageAndGroup(java.lang.String languageId,
		long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLanguageAndGroup(languageId, groupId, domainId);
	}

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
	public static int countByLevelAndDomain(long levelEd,
		java.lang.String languageId, long groupId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByLevelAndDomain(levelEd, languageId, groupId, domainId);
	}

	/**
	* Returns the number of e d departments where id = &#63; and groupId = &#63;.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByD_G(long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByD_G(id, groupId);
	}

	/**
	* Returns the number of e d departments where languageId = &#63; and groupId = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByL_G(java.lang.String languageId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByL_G(languageId, groupId);
	}

	/**
	* Returns the number of e d departments where languageId = &#63; and groupId = &#63; and parent = &#63;.
	*
	* @param languageId the language ID
	* @param groupId the group ID
	* @param parent the parent
	* @return the number of matching e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByL_G_P(java.lang.String languageId, long groupId,
		long parent) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByL_G_P(languageId, groupId, parent);
	}

	/**
	* Returns the number of e d departments.
	*
	* @return the number of e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EDDepartmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EDDepartmentPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.edirectory.service.ClpSerializer.getServletContextName(),
					EDDepartmentPersistence.class.getName());

			ReferenceRegistry.registerReference(EDDepartmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(EDDepartmentPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(EDDepartmentUtil.class,
			"_persistence");
	}

	private static EDDepartmentPersistence _persistence;
}