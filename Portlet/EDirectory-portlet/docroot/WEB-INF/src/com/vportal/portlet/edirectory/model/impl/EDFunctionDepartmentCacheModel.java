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

package com.vportal.portlet.edirectory.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.edirectory.model.EDFunctionDepartment;

import java.io.Serializable;

/**
 * The cache model class for representing EDFunctionDepartment in entity cache.
 *
 * @author HOAN
 * @see EDFunctionDepartment
 * @generated
 */
public class EDFunctionDepartmentCacheModel implements CacheModel<EDFunctionDepartment>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", functionId=");
		sb.append(functionId);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append("}");

		return sb.toString();
	}

	public EDFunctionDepartment toEntityModel() {
		EDFunctionDepartmentImpl edFunctionDepartmentImpl = new EDFunctionDepartmentImpl();

		edFunctionDepartmentImpl.setId(id);
		edFunctionDepartmentImpl.setFunctionId(functionId);
		edFunctionDepartmentImpl.setDepartmentId(departmentId);

		edFunctionDepartmentImpl.resetOriginalValues();

		return edFunctionDepartmentImpl;
	}

	public long id;
	public long functionId;
	public long departmentId;
}