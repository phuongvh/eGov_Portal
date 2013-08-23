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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.vportal.portlet.edirectory.service.EDFunctionEmployeeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author HOAN
 */
public class EDFunctionEmployeeClp extends BaseModelImpl<EDFunctionEmployee>
	implements EDFunctionEmployee {
	public EDFunctionEmployeeClp() {
	}

	public Class<?> getModelClass() {
		return EDFunctionEmployee.class;
	}

	public String getModelClassName() {
		return EDFunctionEmployee.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			EDFunctionEmployeeLocalServiceUtil.addEDFunctionEmployee(this);
		}
		else {
			EDFunctionEmployeeLocalServiceUtil.updateEDFunctionEmployee(this);
		}
	}

	@Override
	public EDFunctionEmployee toEscapedModel() {
		return (EDFunctionEmployee)Proxy.newProxyInstance(EDFunctionEmployee.class.getClassLoader(),
			new Class[] { EDFunctionEmployee.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EDFunctionEmployeeClp clone = new EDFunctionEmployeeClp();

		clone.setUuid(getUuid());
		clone.setId(getId());
		clone.setFunctionId(getFunctionId());
		clone.setEmployeeId(getEmployeeId());

		return clone;
	}

	public int compareTo(EDFunctionEmployee edFunctionEmployee) {
		int value = 0;

		if (getFunctionId() < edFunctionEmployee.getFunctionId()) {
			value = -1;
		}
		else if (getFunctionId() > edFunctionEmployee.getFunctionId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getEmployeeId() < edFunctionEmployee.getEmployeeId()) {
			value = -1;
		}
		else if (getEmployeeId() > edFunctionEmployee.getEmployeeId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EDFunctionEmployeeClp edFunctionEmployee = null;

		try {
			edFunctionEmployee = (EDFunctionEmployeeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = edFunctionEmployee.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", functionId=");
		sb.append(getFunctionId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.edirectory.model.EDFunctionEmployee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>functionId</column-name><column-value><![CDATA[");
		sb.append(getFunctionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _id;
	private long _functionId;
	private long _employeeId;
}