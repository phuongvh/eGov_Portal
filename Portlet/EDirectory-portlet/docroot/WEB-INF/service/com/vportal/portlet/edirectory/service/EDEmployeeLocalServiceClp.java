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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author HOAN
 */
public class EDEmployeeLocalServiceClp implements EDEmployeeLocalService {
	public EDEmployeeLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addEDEmployeeMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEDEmployee",
				com.vportal.portlet.edirectory.model.EDEmployee.class);

		_createEDEmployeeMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createEDEmployee", long.class);

		_deleteEDEmployeeMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteEDEmployee", long.class);

		_deleteEDEmployeeMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteEDEmployee",
				com.vportal.portlet.edirectory.model.EDEmployee.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_fetchEDEmployeeMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchEDEmployee", long.class);

		_getEDEmployeeMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getEDEmployee", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getEDEmployeeByUuidAndGroupIdMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getEDEmployeeByUuidAndGroupId", java.lang.String.class,
				long.class);

		_getEDEmployeesMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getEDEmployees", int.class, int.class);

		_getEDEmployeesCountMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"getEDEmployeesCount");

		_updateEDEmployeeMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateEDEmployee",
				com.vportal.portlet.edirectory.model.EDEmployee.class);

		_updateEDEmployeeMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateEDEmployee",
				com.vportal.portlet.edirectory.model.EDEmployee.class,
				boolean.class);

		_getBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getByIdMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getById", long.class);

		_getEmployeeByE_GMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"getEmployeeByE_G", long.class, long.class);

		_getAllEmployeeMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllEmployee");

		_getAllEmployeeMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllEmployee", int.class, int.class);

		_getEmployeeByAllMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"getEmployeeByAll", long.class, long.class,
				java.lang.String.class);

		_getByDepartmentIdMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByDepartmentId", long.class);

		_getByDepartmentIdMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByDepartmentId", long.class, int.class, int.class);

		_getByDepartmentAndIdMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByDepartmentAndId", long.class, long.class);

		_getByFunctionIdMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByFunctionId", long.class);

		_getByDepartmentAndFunctionMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByDepartmentAndFunction", long.class, long.class);

		_getByNameMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByName", java.lang.String.class);

		_getByDepartmentAndNameMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByDepartmentAndName", long.class, java.lang.String.class);

		_getByFunctionAndNameMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByFunctionAndName", long.class, java.lang.String.class);

		_getByDepartmentFunctionNameMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByDepartmentFunctionName", long.class, long.class,
				java.lang.String.class);

		_countEmployeeByParamMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"countEmployeeByParam", long.class, java.lang.String.class,
				boolean.class, long.class, java.lang.String.class);

		_getEmployeeByParamMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"getEmployeeByParam", long.class, java.lang.String.class,
				boolean.class, long.class, int.class, int.class);

		_addEmployeeMethodKey34 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEmployee", java.lang.String.class, java.lang.String.class,
				java.util.Date.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long[].class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.util.Date.class,
				java.lang.String.class, boolean.class, long.class,
				java.lang.String.class, long.class, long.class, long.class,
				java.lang.String.class);

		_updateEmployeeMethodKey35 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateEmployee", long.class, java.lang.String.class,
				java.lang.String.class, java.util.Date.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, long[].class,
				long.class, java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.util.Date.class,
				java.lang.String.class, boolean.class, long.class,
				java.lang.String.class, long.class, long.class, long.class,
				java.lang.String.class);

		_delelteEmployeeMethodKey36 = new MethodKey(_classLoaderProxy.getClassName(),
				"delelteEmployee", long.class);

		_deleteEmployeeMethodKey37 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteEmployee",
				com.vportal.portlet.edirectory.model.EDEmployee.class);

		_addFunctionToEmployeeMethodKey38 = new MethodKey(_classLoaderProxy.getClassName(),
				"addFunctionToEmployee", long.class, long[].class);

		_addImageMethodKey39 = new MethodKey(_classLoaderProxy.getClassName(),
				"addImage", long.class, java.lang.String.class);

		_searchEmployeeByParamsMethodKey40 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchEmployeeByParams", long.class, java.lang.String.class,
				long.class, java.lang.String.class);

		_searchEmployeeByParamsMethodKey41 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchEmployeeByParams", long.class, java.lang.String.class,
				java.lang.String.class, long.class, long.class, int.class,
				int.class);

		_searchEmployeeByParamsMethodKey42 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchEmployeeByParams", long.class, java.lang.String.class,
				java.lang.String.class, long.class, long.class);

		_countEmployeeByParamMethodKey43 = new MethodKey(_classLoaderProxy.getClassName(),
				"countEmployeeByParam", long.class, java.lang.String.class,
				java.lang.String.class, long.class, long.class);

		_searchEmployeeByDepartmentNamePhoneEmailMethodKey44 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchEmployeeByDepartmentNamePhoneEmail", long.class,
				java.lang.String.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee addEDEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee edEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addEDEmployeeMethodKey0,
				ClpSerializer.translateInput(edEmployee));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee createEDEmployee(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createEDEmployeeMethodKey1,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteEDEmployee(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteEDEmployeeMethodKey2,
				id);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteEDEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee edEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteEDEmployeeMethodKey3,
				ClpSerializer.translateInput(edEmployee));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public com.vportal.portlet.edirectory.model.EDEmployee fetchEDEmployee(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchEDEmployeeMethodKey8,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee getEDEmployee(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getEDEmployeeMethodKey9,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee getEDEmployeeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getEDEmployeeByUuidAndGroupIdMethodKey11,
				ClpSerializer.translateInput(uuid), groupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getEDEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getEDEmployeesMethodKey12,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public int getEDEmployeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getEDEmployeesCountMethodKey13);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.vportal.portlet.edirectory.model.EDEmployee updateEDEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee edEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateEDEmployeeMethodKey14,
				ClpSerializer.translateInput(edEmployee));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee updateEDEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee edEmployee,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateEDEmployeeMethodKey15,
				ClpSerializer.translateInput(edEmployee), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey16);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey17,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.vportal.portlet.edirectory.model.EDEmployee getById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByIdMethodKey18, id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.vportal.portlet.edirectory.NoSuchEDEmployeeException) {
				throw (com.vportal.portlet.edirectory.NoSuchEDEmployeeException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee getEmployeeByE_G(
		long employeeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getEmployeeByE_GMethodKey19,
				employeeId, groupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.vportal.portlet.edirectory.NoSuchEDEmployeeException) {
				throw (com.vportal.portlet.edirectory.NoSuchEDEmployeeException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getAllEmployee()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllEmployeeMethodKey20);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getAllEmployee(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllEmployeeMethodKey21,
				begin, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getEmployeeByAll(
		long departmentId, long functionId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getEmployeeByAllMethodKey22,
				departmentId, functionId, ClpSerializer.translateInput(name));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByDepartmentId(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByDepartmentIdMethodKey23,
				departmentId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByDepartmentId(
		long departmentId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByDepartmentIdMethodKey24,
				departmentId, begin, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee getByDepartmentAndId(
		long departmentId, long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByDepartmentAndIdMethodKey25,
				departmentId, id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByFunctionId(
		long functionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByFunctionIdMethodKey26,
				functionId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.vportal.portlet.edirectory.NoSuchEDEmployeeException) {
				throw (com.vportal.portlet.edirectory.NoSuchEDEmployeeException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByDepartmentAndFunction(
		long departmentId, long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByDepartmentAndFunctionMethodKey27,
				departmentId, functionId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByNameMethodKey28,
				ClpSerializer.translateInput(name));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByDepartmentAndName(
		long departmentId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByDepartmentAndNameMethodKey29,
				departmentId, ClpSerializer.translateInput(name));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByFunctionAndName(
		long functionId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByFunctionAndNameMethodKey30,
				functionId, ClpSerializer.translateInput(name));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByDepartmentFunctionName(
		long departmentId, long functionId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByDepartmentFunctionNameMethodKey31,
				departmentId, functionId, ClpSerializer.translateInput(name));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public int countEmployeeByParam(long groupId, java.lang.String language,
		boolean isShow, long departmentId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countEmployeeByParamMethodKey32,
				groupId, ClpSerializer.translateInput(language), isShow,
				departmentId, ClpSerializer.translateInput(name));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getEmployeeByParam(
		long groupId, java.lang.String language, boolean isShow,
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getEmployeeByParamMethodKey33,
				groupId, ClpSerializer.translateInput(language), isShow,
				departmentId, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee addEmployee(
		java.lang.String title, java.lang.String name, java.util.Date birthday,
		java.lang.String sex, java.lang.String homeSide, java.lang.String race,
		java.lang.String home, java.lang.String homePhone,
		java.lang.String workPhone, java.lang.String mobilePhone,
		java.lang.String email, long[] functionIds, long departmentId,
		java.lang.String imageUrl, java.lang.String majorLevel,
		java.lang.String philosophism, java.lang.String family,
		java.lang.String foreignLanguage, java.util.Date joinDate,
		java.lang.String otherInfo, boolean isShowTree, long displayOrder,
		java.lang.String show, long groupId, long companyId, long userId,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addEmployeeMethodKey34,
				ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(birthday),
				ClpSerializer.translateInput(sex),
				ClpSerializer.translateInput(homeSide),
				ClpSerializer.translateInput(race),
				ClpSerializer.translateInput(home),
				ClpSerializer.translateInput(homePhone),
				ClpSerializer.translateInput(workPhone),
				ClpSerializer.translateInput(mobilePhone),
				ClpSerializer.translateInput(email),
				ClpSerializer.translateInput(functionIds), departmentId,
				ClpSerializer.translateInput(imageUrl),
				ClpSerializer.translateInput(majorLevel),
				ClpSerializer.translateInput(philosophism),
				ClpSerializer.translateInput(family),
				ClpSerializer.translateInput(foreignLanguage),
				ClpSerializer.translateInput(joinDate),
				ClpSerializer.translateInput(otherInfo), isShowTree,
				displayOrder, ClpSerializer.translateInput(show), groupId,
				companyId, userId, ClpSerializer.translateInput(languageId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
		long employeeId, java.lang.String title, java.lang.String name,
		java.util.Date birthday, java.lang.String sex,
		java.lang.String homeSide, java.lang.String race,
		java.lang.String home, java.lang.String homePhone,
		java.lang.String workPhone, java.lang.String mobilePhone,
		java.lang.String email, long[] functionIds, long departmentId,
		java.lang.String image, java.lang.String majorLevel,
		java.lang.String philosophism, java.lang.String family,
		java.lang.String foreignLanguage, java.util.Date joinDate,
		java.lang.String otherInfo, boolean isShowTree, long displayOrder,
		java.lang.String show, long groupId, long companyId, long userId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateEmployeeMethodKey35,
				employeeId, ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(birthday),
				ClpSerializer.translateInput(sex),
				ClpSerializer.translateInput(homeSide),
				ClpSerializer.translateInput(race),
				ClpSerializer.translateInput(home),
				ClpSerializer.translateInput(homePhone),
				ClpSerializer.translateInput(workPhone),
				ClpSerializer.translateInput(mobilePhone),
				ClpSerializer.translateInput(email),
				ClpSerializer.translateInput(functionIds), departmentId,
				ClpSerializer.translateInput(image),
				ClpSerializer.translateInput(majorLevel),
				ClpSerializer.translateInput(philosophism),
				ClpSerializer.translateInput(family),
				ClpSerializer.translateInput(foreignLanguage),
				ClpSerializer.translateInput(joinDate),
				ClpSerializer.translateInput(otherInfo), isShowTree,
				displayOrder, ClpSerializer.translateInput(show), groupId,
				companyId, userId, ClpSerializer.translateInput(language));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.vportal.portlet.edirectory.NoSuchEDEmployeeException) {
				throw (com.vportal.portlet.edirectory.NoSuchEDEmployeeException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.edirectory.model.EDEmployee)ClpSerializer.translateOutput(returnObj);
	}

	public void delelteEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_delelteEmployeeMethodKey36,
				employeeId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteEmployeeMethodKey37,
				ClpSerializer.translateInput(employee));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addFunctionToEmployee(long employeeId, long[] functionIds)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_addFunctionToEmployeeMethodKey38,
				employeeId, ClpSerializer.translateInput(functionIds));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addImage(long employeeId, java.lang.String imageKey)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		MethodHandler methodHandler = new MethodHandler(_addImageMethodKey39,
				employeeId, ClpSerializer.translateInput(imageKey));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.vportal.portlet.edirectory.NoSuchEDEmployeeException) {
				throw (com.vportal.portlet.edirectory.NoSuchEDEmployeeException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> searchEmployeeByParams(
		long groupId, java.lang.String language, long departmentId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchEmployeeByParamsMethodKey40,
				groupId, ClpSerializer.translateInput(language), departmentId,
				ClpSerializer.translateInput(name));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> searchEmployeeByParams(
		long groupId, java.lang.String language, java.lang.String name,
		long departmentId, long functionId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchEmployeeByParamsMethodKey41,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(name), departmentId, functionId,
				begin, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List searchEmployeeByParams(long groupId,
		java.lang.String language, java.lang.String name, long departmentId,
		long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchEmployeeByParamsMethodKey42,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(name), departmentId, functionId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public int countEmployeeByParam(long groupId, java.lang.String language,
		java.lang.String name, long departmentId, long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countEmployeeByParamMethodKey43,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(name), departmentId, functionId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> searchEmployeeByDepartmentNamePhoneEmail(
		long groupId, java.lang.String language, long departmentId,
		java.lang.String name, java.lang.String phone, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchEmployeeByDepartmentNamePhoneEmailMethodKey44,
				groupId, ClpSerializer.translateInput(language), departmentId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(phone),
				ClpSerializer.translateInput(email));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.edirectory.model.EDEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addEDEmployeeMethodKey0;
	private MethodKey _createEDEmployeeMethodKey1;
	private MethodKey _deleteEDEmployeeMethodKey2;
	private MethodKey _deleteEDEmployeeMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchEDEmployeeMethodKey8;
	private MethodKey _getEDEmployeeMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getEDEmployeeByUuidAndGroupIdMethodKey11;
	private MethodKey _getEDEmployeesMethodKey12;
	private MethodKey _getEDEmployeesCountMethodKey13;
	private MethodKey _updateEDEmployeeMethodKey14;
	private MethodKey _updateEDEmployeeMethodKey15;
	private MethodKey _getBeanIdentifierMethodKey16;
	private MethodKey _setBeanIdentifierMethodKey17;
	private MethodKey _getByIdMethodKey18;
	private MethodKey _getEmployeeByE_GMethodKey19;
	private MethodKey _getAllEmployeeMethodKey20;
	private MethodKey _getAllEmployeeMethodKey21;
	private MethodKey _getEmployeeByAllMethodKey22;
	private MethodKey _getByDepartmentIdMethodKey23;
	private MethodKey _getByDepartmentIdMethodKey24;
	private MethodKey _getByDepartmentAndIdMethodKey25;
	private MethodKey _getByFunctionIdMethodKey26;
	private MethodKey _getByDepartmentAndFunctionMethodKey27;
	private MethodKey _getByNameMethodKey28;
	private MethodKey _getByDepartmentAndNameMethodKey29;
	private MethodKey _getByFunctionAndNameMethodKey30;
	private MethodKey _getByDepartmentFunctionNameMethodKey31;
	private MethodKey _countEmployeeByParamMethodKey32;
	private MethodKey _getEmployeeByParamMethodKey33;
	private MethodKey _addEmployeeMethodKey34;
	private MethodKey _updateEmployeeMethodKey35;
	private MethodKey _delelteEmployeeMethodKey36;
	private MethodKey _deleteEmployeeMethodKey37;
	private MethodKey _addFunctionToEmployeeMethodKey38;
	private MethodKey _addImageMethodKey39;
	private MethodKey _searchEmployeeByParamsMethodKey40;
	private MethodKey _searchEmployeeByParamsMethodKey41;
	private MethodKey _searchEmployeeByParamsMethodKey42;
	private MethodKey _countEmployeeByParamMethodKey43;
	private MethodKey _searchEmployeeByDepartmentNamePhoneEmailMethodKey44;
}