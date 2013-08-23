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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EDFunctionDepartmentService}.
 * </p>
 *
 * @author    HOAN
 * @see       EDFunctionDepartmentService
 * @generated
 */
public class EDFunctionDepartmentServiceWrapper
	implements EDFunctionDepartmentService,
		ServiceWrapper<EDFunctionDepartmentService> {
	public EDFunctionDepartmentServiceWrapper(
		EDFunctionDepartmentService edFunctionDepartmentService) {
		_edFunctionDepartmentService = edFunctionDepartmentService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EDFunctionDepartmentService getWrappedEDFunctionDepartmentService() {
		return _edFunctionDepartmentService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEDFunctionDepartmentService(
		EDFunctionDepartmentService edFunctionDepartmentService) {
		_edFunctionDepartmentService = edFunctionDepartmentService;
	}

	public EDFunctionDepartmentService getWrappedService() {
		return _edFunctionDepartmentService;
	}

	public void setWrappedService(
		EDFunctionDepartmentService edFunctionDepartmentService) {
		_edFunctionDepartmentService = edFunctionDepartmentService;
	}

	private EDFunctionDepartmentService _edFunctionDepartmentService;
}