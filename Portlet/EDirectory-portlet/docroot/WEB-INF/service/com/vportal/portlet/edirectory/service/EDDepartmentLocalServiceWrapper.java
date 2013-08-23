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

package com.vportal.portlet.edirectory.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EDDepartmentLocalService}.
 * </p>
 *
 * @author    HOAN
 * @see       EDDepartmentLocalService
 * @generated
 */
public class EDDepartmentLocalServiceWrapper implements EDDepartmentLocalService,
	ServiceWrapper<EDDepartmentLocalService> {
	public EDDepartmentLocalServiceWrapper(
		EDDepartmentLocalService edDepartmentLocalService) {
		_edDepartmentLocalService = edDepartmentLocalService;
	}

	/**
	* Adds the e d department to the database. Also notifies the appropriate model listeners.
	*
	* @param edDepartment the e d department
	* @return the e d department that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment addEDDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.addEDDepartment(edDepartment);
	}

	/**
	* Creates a new e d department with the primary key. Does not add the e d department to the database.
	*
	* @param id the primary key for the new e d department
	* @return the new e d department
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment createEDDepartment(
		long id) {
		return _edDepartmentLocalService.createEDDepartment(id);
	}

	/**
	* Deletes the e d department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d department
	* @throws PortalException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEDDepartment(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_edDepartmentLocalService.deleteEDDepartment(id);
	}

	/**
	* Deletes the e d department from the database. Also notifies the appropriate model listeners.
	*
	* @param edDepartment the e d department
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEDDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		_edDepartmentLocalService.deleteEDDepartment(edDepartment);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.edirectory.model.EDDepartment fetchEDDepartment(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.fetchEDDepartment(id);
	}

	/**
	* Returns the e d department with the primary key.
	*
	* @param id the primary key of the e d department
	* @return the e d department
	* @throws PortalException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment getEDDepartment(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.getEDDepartment(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> getEDDepartments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.getEDDepartments(start, end);
	}

	/**
	* Returns the number of e d departments.
	*
	* @return the number of e d departments
	* @throws SystemException if a system exception occurred
	*/
	public int getEDDepartmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.getEDDepartmentsCount();
	}

	/**
	* Updates the e d department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param edDepartment the e d department
	* @return the e d department that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment updateEDDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.updateEDDepartment(edDepartment);
	}

	/**
	* Updates the e d department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param edDepartment the e d department
	* @param merge whether to merge the e d department with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the e d department that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDDepartment updateEDDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.updateEDDepartment(edDepartment, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _edDepartmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_edDepartmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.vportal.portlet.edirectory.model.EDDepartment getDepartmentByD_G(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return _edDepartmentLocalService.getDepartmentByD_G(departmentId,
			groupId);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> getAllDepartment()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.getAllDepartment();
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> getByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.getByGroupId(groupId);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> getByParent(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.getByParent(parentId);
	}

	public com.vportal.portlet.edirectory.model.EDDepartment getByParent1(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartmentLocalService.getByParent1(parentId);
	}

	public com.vportal.portlet.edirectory.model.EDDepartment addDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment dep, long userId,
		java.lang.String languageId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _edDepartmentLocalService.addDepartment(dep, userId, languageId,
			domainId);
	}

	public com.vportal.portlet.edirectory.model.EDDepartment updateDepartment(
		long departmentId, java.lang.String name, java.lang.String description,
		long parent, int level, java.lang.String address,
		java.lang.String email, java.lang.String phone, java.lang.String fax,
		java.lang.String languageId, long userId, long groupId,
		java.lang.String website)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return _edDepartmentLocalService.updateDepartment(departmentId, name,
			description, parent, level, address, email, phone, fax, languageId,
			userId, groupId, website);
	}

	/**
	* @param departmentId
	* @throws SystemException
	* @throws PortalException
	*/
	public void deleteDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_edDepartmentLocalService.deleteDepartment(departmentId);
	}

	/**
	* @param department
	* @throws PortalException
	* @throws SystemException
	*/
	public void deleteDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment department)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_edDepartmentLocalService.deleteDepartment(department);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EDDepartmentLocalService getWrappedEDDepartmentLocalService() {
		return _edDepartmentLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEDDepartmentLocalService(
		EDDepartmentLocalService edDepartmentLocalService) {
		_edDepartmentLocalService = edDepartmentLocalService;
	}

	public EDDepartmentLocalService getWrappedService() {
		return _edDepartmentLocalService;
	}

	public void setWrappedService(
		EDDepartmentLocalService edDepartmentLocalService) {
		_edDepartmentLocalService = edDepartmentLocalService;
	}

	private EDDepartmentLocalService _edDepartmentLocalService;
}