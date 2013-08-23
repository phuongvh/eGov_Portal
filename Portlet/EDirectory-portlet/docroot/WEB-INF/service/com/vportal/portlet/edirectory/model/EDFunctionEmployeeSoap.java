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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.edirectory.service.http.EDFunctionEmployeeServiceSoap}.
 *
 * @author    HOAN
 * @see       com.vportal.portlet.edirectory.service.http.EDFunctionEmployeeServiceSoap
 * @generated
 */
public class EDFunctionEmployeeSoap implements Serializable {
	public static EDFunctionEmployeeSoap toSoapModel(EDFunctionEmployee model) {
		EDFunctionEmployeeSoap soapModel = new EDFunctionEmployeeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setFunctionId(model.getFunctionId());
		soapModel.setEmployeeId(model.getEmployeeId());

		return soapModel;
	}

	public static EDFunctionEmployeeSoap[] toSoapModels(
		EDFunctionEmployee[] models) {
		EDFunctionEmployeeSoap[] soapModels = new EDFunctionEmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EDFunctionEmployeeSoap[][] toSoapModels(
		EDFunctionEmployee[][] models) {
		EDFunctionEmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EDFunctionEmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EDFunctionEmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EDFunctionEmployeeSoap[] toSoapModels(
		List<EDFunctionEmployee> models) {
		List<EDFunctionEmployeeSoap> soapModels = new ArrayList<EDFunctionEmployeeSoap>(models.size());

		for (EDFunctionEmployee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EDFunctionEmployeeSoap[soapModels.size()]);
	}

	public EDFunctionEmployeeSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
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

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	private String _uuid;
	private long _id;
	private long _functionId;
	private long _employeeId;
}