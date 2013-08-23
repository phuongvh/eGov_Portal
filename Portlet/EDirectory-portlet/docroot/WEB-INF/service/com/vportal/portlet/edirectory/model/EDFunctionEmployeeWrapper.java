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

package com.vportal.portlet.edirectory.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EDFunctionEmployee}.
 * </p>
 *
 * @author    HOAN
 * @see       EDFunctionEmployee
 * @generated
 */
public class EDFunctionEmployeeWrapper implements EDFunctionEmployee,
	ModelWrapper<EDFunctionEmployee> {
	public EDFunctionEmployeeWrapper(EDFunctionEmployee edFunctionEmployee) {
		_edFunctionEmployee = edFunctionEmployee;
	}

	public Class<?> getModelClass() {
		return EDFunctionEmployee.class;
	}

	public String getModelClassName() {
		return EDFunctionEmployee.class.getName();
	}

	/**
	* Returns the primary key of this e d function employee.
	*
	* @return the primary key of this e d function employee
	*/
	public long getPrimaryKey() {
		return _edFunctionEmployee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e d function employee.
	*
	* @param primaryKey the primary key of this e d function employee
	*/
	public void setPrimaryKey(long primaryKey) {
		_edFunctionEmployee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e d function employee.
	*
	* @return the uuid of this e d function employee
	*/
	public java.lang.String getUuid() {
		return _edFunctionEmployee.getUuid();
	}

	/**
	* Sets the uuid of this e d function employee.
	*
	* @param uuid the uuid of this e d function employee
	*/
	public void setUuid(java.lang.String uuid) {
		_edFunctionEmployee.setUuid(uuid);
	}

	/**
	* Returns the ID of this e d function employee.
	*
	* @return the ID of this e d function employee
	*/
	public long getId() {
		return _edFunctionEmployee.getId();
	}

	/**
	* Sets the ID of this e d function employee.
	*
	* @param id the ID of this e d function employee
	*/
	public void setId(long id) {
		_edFunctionEmployee.setId(id);
	}

	/**
	* Returns the function ID of this e d function employee.
	*
	* @return the function ID of this e d function employee
	*/
	public long getFunctionId() {
		return _edFunctionEmployee.getFunctionId();
	}

	/**
	* Sets the function ID of this e d function employee.
	*
	* @param functionId the function ID of this e d function employee
	*/
	public void setFunctionId(long functionId) {
		_edFunctionEmployee.setFunctionId(functionId);
	}

	/**
	* Returns the employee ID of this e d function employee.
	*
	* @return the employee ID of this e d function employee
	*/
	public long getEmployeeId() {
		return _edFunctionEmployee.getEmployeeId();
	}

	/**
	* Sets the employee ID of this e d function employee.
	*
	* @param employeeId the employee ID of this e d function employee
	*/
	public void setEmployeeId(long employeeId) {
		_edFunctionEmployee.setEmployeeId(employeeId);
	}

	public boolean isNew() {
		return _edFunctionEmployee.isNew();
	}

	public void setNew(boolean n) {
		_edFunctionEmployee.setNew(n);
	}

	public boolean isCachedModel() {
		return _edFunctionEmployee.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_edFunctionEmployee.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _edFunctionEmployee.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _edFunctionEmployee.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_edFunctionEmployee.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _edFunctionEmployee.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_edFunctionEmployee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EDFunctionEmployeeWrapper((EDFunctionEmployee)_edFunctionEmployee.clone());
	}

	public int compareTo(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee) {
		return _edFunctionEmployee.compareTo(edFunctionEmployee);
	}

	@Override
	public int hashCode() {
		return _edFunctionEmployee.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.edirectory.model.EDFunctionEmployee> toCacheModel() {
		return _edFunctionEmployee.toCacheModel();
	}

	public com.vportal.portlet.edirectory.model.EDFunctionEmployee toEscapedModel() {
		return new EDFunctionEmployeeWrapper(_edFunctionEmployee.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _edFunctionEmployee.toString();
	}

	public java.lang.String toXmlString() {
		return _edFunctionEmployee.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_edFunctionEmployee.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public EDFunctionEmployee getWrappedEDFunctionEmployee() {
		return _edFunctionEmployee;
	}

	public EDFunctionEmployee getWrappedModel() {
		return _edFunctionEmployee;
	}

	public void resetOriginalValues() {
		_edFunctionEmployee.resetOriginalValues();
	}

	private EDFunctionEmployee _edFunctionEmployee;
}