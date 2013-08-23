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
 * This class is a wrapper for {@link EDDepartmentService}.
 * </p>
 *
 * @author    HOAN
 * @see       EDDepartmentService
 * @generated
 */
public class EDDepartmentServiceWrapper implements EDDepartmentService,
	ServiceWrapper<EDDepartmentService> {
	public EDDepartmentServiceWrapper(EDDepartmentService edDepartmentService) {
		_edDepartmentService = edDepartmentService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EDDepartmentService getWrappedEDDepartmentService() {
		return _edDepartmentService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEDDepartmentService(
		EDDepartmentService edDepartmentService) {
		_edDepartmentService = edDepartmentService;
	}

	public EDDepartmentService getWrappedService() {
		return _edDepartmentService;
	}

	public void setWrappedService(EDDepartmentService edDepartmentService) {
		_edDepartmentService = edDepartmentService;
	}

	private EDDepartmentService _edDepartmentService;
}