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
 * This class is a wrapper for {@link EDFunctionDepartment}.
 * </p>
 *
 * @author    HOAN
 * @see       EDFunctionDepartment
 * @generated
 */
public class EDFunctionDepartmentWrapper implements EDFunctionDepartment,
	ModelWrapper<EDFunctionDepartment> {
	public EDFunctionDepartmentWrapper(
		EDFunctionDepartment edFunctionDepartment) {
		_edFunctionDepartment = edFunctionDepartment;
	}

	public Class<?> getModelClass() {
		return EDFunctionDepartment.class;
	}

	public String getModelClassName() {
		return EDFunctionDepartment.class.getName();
	}

	/**
	* Returns the primary key of this e d function department.
	*
	* @return the primary key of this e d function department
	*/
	public long getPrimaryKey() {
		return _edFunctionDepartment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e d function department.
	*
	* @param primaryKey the primary key of this e d function department
	*/
	public void setPrimaryKey(long primaryKey) {
		_edFunctionDepartment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this e d function department.
	*
	* @return the ID of this e d function department
	*/
	public long getId() {
		return _edFunctionDepartment.getId();
	}

	/**
	* Sets the ID of this e d function department.
	*
	* @param id the ID of this e d function department
	*/
	public void setId(long id) {
		_edFunctionDepartment.setId(id);
	}

	/**
	* Returns the function ID of this e d function department.
	*
	* @return the function ID of this e d function department
	*/
	public long getFunctionId() {
		return _edFunctionDepartment.getFunctionId();
	}

	/**
	* Sets the function ID of this e d function department.
	*
	* @param functionId the function ID of this e d function department
	*/
	public void setFunctionId(long functionId) {
		_edFunctionDepartment.setFunctionId(functionId);
	}

	/**
	* Returns the department ID of this e d function department.
	*
	* @return the department ID of this e d function department
	*/
	public long getDepartmentId() {
		return _edFunctionDepartment.getDepartmentId();
	}

	/**
	* Sets the department ID of this e d function department.
	*
	* @param departmentId the department ID of this e d function department
	*/
	public void setDepartmentId(long departmentId) {
		_edFunctionDepartment.setDepartmentId(departmentId);
	}

	public boolean isNew() {
		return _edFunctionDepartment.isNew();
	}

	public void setNew(boolean n) {
		_edFunctionDepartment.setNew(n);
	}

	public boolean isCachedModel() {
		return _edFunctionDepartment.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_edFunctionDepartment.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _edFunctionDepartment.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _edFunctionDepartment.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_edFunctionDepartment.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _edFunctionDepartment.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_edFunctionDepartment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EDFunctionDepartmentWrapper((EDFunctionDepartment)_edFunctionDepartment.clone());
	}

	public int compareTo(
		com.vportal.portlet.edirectory.model.EDFunctionDepartment edFunctionDepartment) {
		return _edFunctionDepartment.compareTo(edFunctionDepartment);
	}

	@Override
	public int hashCode() {
		return _edFunctionDepartment.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.edirectory.model.EDFunctionDepartment> toCacheModel() {
		return _edFunctionDepartment.toCacheModel();
	}

	public com.vportal.portlet.edirectory.model.EDFunctionDepartment toEscapedModel() {
		return new EDFunctionDepartmentWrapper(_edFunctionDepartment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _edFunctionDepartment.toString();
	}

	public java.lang.String toXmlString() {
		return _edFunctionDepartment.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_edFunctionDepartment.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public EDFunctionDepartment getWrappedEDFunctionDepartment() {
		return _edFunctionDepartment;
	}

	public EDFunctionDepartment getWrappedModel() {
		return _edFunctionDepartment;
	}

	public void resetOriginalValues() {
		_edFunctionDepartment.resetOriginalValues();
	}

	private EDFunctionDepartment _edFunctionDepartment;
}