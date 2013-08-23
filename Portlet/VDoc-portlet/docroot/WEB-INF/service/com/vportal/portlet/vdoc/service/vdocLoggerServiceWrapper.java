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

package com.vportal.portlet.vdoc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link vdocLoggerService}.
 * </p>
 *
 * @author    MrEn
 * @see       vdocLoggerService
 * @generated
 */
public class vdocLoggerServiceWrapper implements vdocLoggerService,
	ServiceWrapper<vdocLoggerService> {
	public vdocLoggerServiceWrapper(vdocLoggerService vdocLoggerService) {
		_vdocLoggerService = vdocLoggerService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public vdocLoggerService getWrappedvdocLoggerService() {
		return _vdocLoggerService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedvdocLoggerService(vdocLoggerService vdocLoggerService) {
		_vdocLoggerService = vdocLoggerService;
	}

	public vdocLoggerService getWrappedService() {
		return _vdocLoggerService;
	}

	public void setWrappedService(vdocLoggerService vdocLoggerService) {
		_vdocLoggerService = vdocLoggerService;
	}

	private vdocLoggerService _vdocLoggerService;
}