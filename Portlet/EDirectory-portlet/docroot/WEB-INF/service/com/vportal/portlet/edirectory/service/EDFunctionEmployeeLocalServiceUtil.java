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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the e d function employee local service. This utility wraps {@link com.vportal.portlet.edirectory.service.impl.EDFunctionEmployeeLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HOAN
 * @see EDFunctionEmployeeLocalService
 * @see com.vportal.portlet.edirectory.service.base.EDFunctionEmployeeLocalServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.impl.EDFunctionEmployeeLocalServiceImpl
 * @generated
 */
public class EDFunctionEmployeeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.edirectory.service.impl.EDFunctionEmployeeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e d function employee to the database. Also notifies the appropriate model listeners.
	*
	* @param edFunctionEmployee the e d function employee
	* @return the e d function employee that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee addEDFunctionEmployee(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEDFunctionEmployee(edFunctionEmployee);
	}

	/**
	* Creates a new e d function employee with the primary key. Does not add the e d function employee to the database.
	*
	* @param id the primary key for the new e d function employee
	* @return the new e d function employee
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee createEDFunctionEmployee(
		long id) {
		return getService().createEDFunctionEmployee(id);
	}

	/**
	* Deletes the e d function employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d function employee
	* @throws PortalException if a e d function employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEDFunctionEmployee(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEDFunctionEmployee(id);
	}

	/**
	* Deletes the e d function employee from the database. Also notifies the appropriate model listeners.
	*
	* @param edFunctionEmployee the e d function employee
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEDFunctionEmployee(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEDFunctionEmployee(edFunctionEmployee);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee fetchEDFunctionEmployee(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEDFunctionEmployee(id);
	}

	/**
	* Returns the e d function employee with the primary key.
	*
	* @param id the primary key of the e d function employee
	* @return the e d function employee
	* @throws PortalException if a e d function employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee getEDFunctionEmployee(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEDFunctionEmployee(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> getEDFunctionEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEDFunctionEmployees(start, end);
	}

	/**
	* Returns the number of e d function employees.
	*
	* @return the number of e d function employees
	* @throws SystemException if a system exception occurred
	*/
	public static int getEDFunctionEmployeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEDFunctionEmployeesCount();
	}

	/**
	* Updates the e d function employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param edFunctionEmployee the e d function employee
	* @return the e d function employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee updateEDFunctionEmployee(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEDFunctionEmployee(edFunctionEmployee);
	}

	/**
	* Updates the e d function employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param edFunctionEmployee the e d function employee
	* @param merge whether to merge the e d function employee with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the e d function employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee updateEDFunctionEmployee(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEDFunctionEmployee(edFunctionEmployee, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> getAllEDFunctionEmployee()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEDFunctionEmployee();
	}

	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> getByFunctionId(
		long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByFunctionId(functionId);
	}

	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunctionEmployee> getByEmployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByEmployeeId(employeeId);
	}

	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee addFunctionEmployee(
		long functionId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().addFunctionEmployee(functionId, employeeId);
	}

	public static com.vportal.portlet.edirectory.model.EDFunctionEmployee updateFunctionEmployee(
		long feId, long functionId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException,
			java.rmi.RemoteException {
		return getService().updateFunctionEmployee(feId, functionId, employeeId);
	}

	public static void removeEmployeesInFunction(long functionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().removeEmployeesInFunction(functionId);
	}

	public static void removeFunctionsOfEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().removeFunctionsOfEmployee(employeeId);
	}

	public static void clearService() {
		_service = null;
	}

	public static EDFunctionEmployeeLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EDFunctionEmployeeLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					EDFunctionEmployeeLocalService.class.getName(),
					portletClassLoader);

			_service = new EDFunctionEmployeeLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(EDFunctionEmployeeLocalServiceUtil.class,
				"_service");
			MethodCache.remove(EDFunctionEmployeeLocalService.class);
		}

		return _service;
	}

	public void setService(EDFunctionEmployeeLocalService service) {
		MethodCache.remove(EDFunctionEmployeeLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(EDFunctionEmployeeLocalServiceUtil.class,
			"_service");
		MethodCache.remove(EDFunctionEmployeeLocalService.class);
	}

	private static EDFunctionEmployeeLocalService _service;
}