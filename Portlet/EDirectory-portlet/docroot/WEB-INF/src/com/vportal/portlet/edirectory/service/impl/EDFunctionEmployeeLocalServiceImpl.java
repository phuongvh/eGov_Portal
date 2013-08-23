/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.edirectory.service.impl;

import java.rmi.RemoteException;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException;
import com.vportal.portlet.edirectory.model.EDFunctionEmployee;
import com.vportal.portlet.edirectory.service.base.EDFunctionEmployeeLocalServiceBaseImpl;

/**
 * The implementation of the e d function employee local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.edirectory.service.EDFunctionEmployeeLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.edirectory.service.base.EDFunctionEmployeeLocalServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.EDFunctionEmployeeLocalServiceUtil
 */
public class EDFunctionEmployeeLocalServiceImpl extends
		EDFunctionEmployeeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.vportal.portlet
	 * .edirectory.service.EDFunctionEmployeeLocalServiceUtil} to access the e d
	 * function employee local service.
	 */
	public List<EDFunctionEmployee> getAllEDFunctionEmployee()
			throws SystemException {
		return edFunctionEmployeePersistence.findAll();
	}

	public List<EDFunctionEmployee> getByFunctionId(long functionId)
			throws SystemException {
		return edFunctionEmployeePersistence.findByFunctionId(functionId);
	}

	public List<EDFunctionEmployee> getByEmployeeId(long employeeId)
			throws SystemException {
		return edFunctionEmployeePersistence.findByEmployeeId(employeeId);
	}

	public EDFunctionEmployee addFunctionEmployee(long functionId,
			long employeeId) throws SystemException, RemoteException {
		long feId = counterLocalService.increment();
		EDFunctionEmployee fe = edFunctionEmployeePersistence.create(feId);
		fe.setEmployeeId(employeeId);
		fe.setFunctionId(functionId);
		edFunctionEmployeePersistence.update(fe, false);

		return fe;
	}

	public EDFunctionEmployee updateFunctionEmployee(long feId,
			long functionId, long employeeId) throws SystemException,
			RemoteException, NoSuchEDFunctionEmployeeException {
		EDFunctionEmployee funcEmp = edFunctionEmployeePersistence
				.findByPrimaryKey(feId);
		funcEmp.setEmployeeId(employeeId);
		funcEmp.setFunctionId(functionId);
		edFunctionEmployeePersistence.update(funcEmp, false);
		return funcEmp;
	}

	public void removeEmployeesInFunction(long functionId)
			throws SystemException, RemoteException {
		List<EDFunctionEmployee> employees = edFunctionEmployeePersistence
				.findByFunctionId(functionId);
		for (int i = 0; i < employees.size(); i++) {
			EDFunctionEmployee item = (EDFunctionEmployee) employees.get(i);
			edFunctionEmployeePersistence.remove(item);
		}
	}

	public void removeFunctionsOfEmployee(long employeeId)
			throws SystemException, RemoteException {
		List<EDFunctionEmployee> functions = edFunctionEmployeePersistence
				.findByEmployeeId(employeeId);
		for (int i = 0; i < functions.size(); i++) {
			EDFunctionEmployee item = (EDFunctionEmployee) functions.get(i);
			edFunctionEmployeePersistence.remove(item);
		}
	}
}