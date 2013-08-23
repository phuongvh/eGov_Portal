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

package com.vportal.portlet.vcms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VcmsStatusService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsStatusService
 * @generated
 */
public class VcmsStatusServiceWrapper implements VcmsStatusService,
	ServiceWrapper<VcmsStatusService> {
	public VcmsStatusServiceWrapper(VcmsStatusService vcmsStatusService) {
		_vcmsStatusService = vcmsStatusService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsStatusService getWrappedVcmsStatusService() {
		return _vcmsStatusService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsStatusService(VcmsStatusService vcmsStatusService) {
		_vcmsStatusService = vcmsStatusService;
	}

	public VcmsStatusService getWrappedService() {
		return _vcmsStatusService;
	}

	public void setWrappedService(VcmsStatusService vcmsStatusService) {
		_vcmsStatusService = vcmsStatusService;
	}

	private VcmsStatusService _vcmsStatusService;
}