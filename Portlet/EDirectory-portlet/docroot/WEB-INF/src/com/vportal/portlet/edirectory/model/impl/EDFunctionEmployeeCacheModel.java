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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.edirectory.model.EDFunctionEmployee;

import java.io.Serializable;

/**
 * The cache model class for representing EDFunctionEmployee in entity cache.
 *
 * @author HOAN
 * @see EDFunctionEmployee
 * @generated
 */
public class EDFunctionEmployeeCacheModel implements CacheModel<EDFunctionEmployee>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", functionId=");
		sb.append(functionId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	public EDFunctionEmployee toEntityModel() {
		EDFunctionEmployeeImpl edFunctionEmployeeImpl = new EDFunctionEmployeeImpl();

		if (uuid == null) {
			edFunctionEmployeeImpl.setUuid(StringPool.BLANK);
		}
		else {
			edFunctionEmployeeImpl.setUuid(uuid);
		}

		edFunctionEmployeeImpl.setId(id);
		edFunctionEmployeeImpl.setFunctionId(functionId);
		edFunctionEmployeeImpl.setEmployeeId(employeeId);

		edFunctionEmployeeImpl.resetOriginalValues();

		return edFunctionEmployeeImpl;
	}

	public String uuid;
	public long id;
	public long functionId;
	public long employeeId;
}