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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.edirectory.service.http.EDFunctionDepartmentServiceSoap}.
 *
 * @author    HOAN
 * @see       com.vportal.portlet.edirectory.service.http.EDFunctionDepartmentServiceSoap
 * @generated
 */
public class EDFunctionDepartmentSoap implements Serializable {
	public static EDFunctionDepartmentSoap toSoapModel(
		EDFunctionDepartment model) {
		EDFunctionDepartmentSoap soapModel = new EDFunctionDepartmentSoap();

		soapModel.setId(model.getId());
		soapModel.setFunctionId(model.getFunctionId());
		soapModel.setDepartmentId(model.getDepartmentId());

		return soapModel;
	}

	public static EDFunctionDepartmentSoap[] toSoapModels(
		EDFunctionDepartment[] models) {
		EDFunctionDepartmentSoap[] soapModels = new EDFunctionDepartmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EDFunctionDepartmentSoap[][] toSoapModels(
		EDFunctionDepartment[][] models) {
		EDFunctionDepartmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EDFunctionDepartmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EDFunctionDepartmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EDFunctionDepartmentSoap[] toSoapModels(
		List<EDFunctionDepartment> models) {
		List<EDFunctionDepartmentSoap> soapModels = new ArrayList<EDFunctionDepartmentSoap>(models.size());

		for (EDFunctionDepartment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EDFunctionDepartmentSoap[soapModels.size()]);
	}

	public EDFunctionDepartmentSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getFunctionId() {
		return _functionId;
	}

	public void setFunctionId(long functionId) {
		_functionId = functionId;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	private long _id;
	private long _functionId;
	private long _departmentId;
}