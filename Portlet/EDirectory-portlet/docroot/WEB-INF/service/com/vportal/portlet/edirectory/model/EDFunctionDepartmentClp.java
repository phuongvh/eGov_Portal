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

import com.vportal.portlet.edirectory.service.EDFunctionDepartmentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author HOAN
 */
public class EDFunctionDepartmentClp extends BaseModelImpl<EDFunctionDepartment>
	implements EDFunctionDepartment {
	public EDFunctionDepartmentClp() {
	}

	public Class<?> getModelClass() {
		return EDFunctionDepartment.class;
	}

	public String getModelClassName() {
		return EDFunctionDepartment.class.getName();
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			EDFunctionDepartmentLocalServiceUtil.addEDFunctionDepartment(this);
		}
		else {
			EDFunctionDepartmentLocalServiceUtil.updateEDFunctionDepartment(this);
		}
	}

	@Override
	public EDFunctionDepartment toEscapedModel() {
		return (EDFunctionDepartment)Proxy.newProxyInstance(EDFunctionDepartment.class.getClassLoader(),
			new Class[] { EDFunctionDepartment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EDFunctionDepartmentClp clone = new EDFunctionDepartmentClp();

		clone.setId(getId());
		clone.setFunctionId(getFunctionId());
		clone.setDepartmentId(getDepartmentId());

		return clone;
	}

	public int compareTo(EDFunctionDepartment edFunctionDepartment) {
		int value = 0;

		if (getFunctionId() < edFunctionDepartment.getFunctionId()) {
			value = -1;
		}
		else if (getFunctionId() > edFunctionDepartment.getFunctionId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getDepartmentId() < edFunctionDepartment.getDepartmentId()) {
			value = -1;
		}
		else if (getDepartmentId() > edFunctionDepartment.getDepartmentId()) {
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

		EDFunctionDepartmentClp edFunctionDepartment = null;

		try {
			edFunctionDepartment = (EDFunctionDepartmentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = edFunctionDepartment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", functionId=");
		sb.append(getFunctionId());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.edirectory.model.EDFunctionDepartment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>functionId</column-name><column-value><![CDATA[");
		sb.append(getFunctionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _functionId;
	private long _departmentId;
}