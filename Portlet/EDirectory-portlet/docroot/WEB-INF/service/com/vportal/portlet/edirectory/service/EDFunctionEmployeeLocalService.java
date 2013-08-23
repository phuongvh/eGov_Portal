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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the e d function employee local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HOAN
 * @see EDFunctionEmployeeLocalServiceUtil
 * @see com.vportal.portlet.edirectory.service.base.EDFunctionEmployeeLocalServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.impl.EDFunctionEmployeeLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface EDFunctionEmployeeLocalService
	extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EDFunctionEmployeeLocalServiceUtil} to access the e d function employee local service. Add custom service methods to {@link com.vportal.portlet.edirectory.service.impl.EDFunctionEmployeeLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the e d function employee to the database. Also notifies the appropriate model listeners.
	*
	* @param edFunctionEmployee the e d function employee
	* @return the e d function employee that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunctionEmployee addEDFunctionEmployee(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new e d function employee with the primary key. Does not add the e d function employee to the database.
	*
	* @param id the primary key for the new e d function employee
	* @return the new e d function employee
	*/
	public com.vportal.portlet.edirectory.model.EDFunctionEmployee createEDFunctionEmployee(
		long id);

	/**
	* Deletes the e d function employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d function employee
	* @throws PortalException if a e d function employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEDFunctionEmployee(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the e d function employee from the database. Also notifies the appropriate model listeners.
	*
	* @param edFunctionEmployee the e d function employee
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEDFunctionEmployee(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.edirectory.model.EDFunctionEmployee fetchEDFunctionEmployee(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e d function employee with the primary key.
	*
	* @param id the primary key of the e d function employee
	* @return the e d function employee
	* @throws PortalException if a e d function employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.edirectory.model.EDFunctionEmployee getEDFunctionEmployee(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> getEDFunctionEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d function employees.
	*
	* @return the number of e d function employees
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEDFunctionEmployeesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e d function employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param edFunctionEmployee the e d function employee
	* @return the e d function employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunctionEmployee updateEDFunctionEmployee(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e d function employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param edFunctionEmployee the e d function employee
	* @param merge whether to merge the e d function employee with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the e d function employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunctionEmployee updateEDFunctionEmployee(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> getAllEDFunctionEmployee()
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> getByFunctionId(
		long functionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> getByEmployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.vportal.portlet.edirectory.model.EDFunctionEmployee addFunctionEmployee(
		long functionId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	public com.vportal.portlet.edirectory.model.EDFunctionEmployee updateFunctionEmployee(
		long feId, long functionId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException,
			java.rmi.RemoteException;

	public void removeEmployeesInFunction(long functionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	public void removeFunctionsOfEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;
}