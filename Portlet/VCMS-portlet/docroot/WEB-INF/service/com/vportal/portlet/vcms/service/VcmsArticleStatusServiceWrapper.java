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
 * This class is a wrapper for {@link VcmsArticleStatusService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticleStatusService
 * @generated
 */
public class VcmsArticleStatusServiceWrapper implements VcmsArticleStatusService,
	ServiceWrapper<VcmsArticleStatusService> {
	public VcmsArticleStatusServiceWrapper(
		VcmsArticleStatusService vcmsArticleStatusService) {
		_vcmsArticleStatusService = vcmsArticleStatusService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsArticleStatusService getWrappedVcmsArticleStatusService() {
		return _vcmsArticleStatusService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsArticleStatusService(
		VcmsArticleStatusService vcmsArticleStatusService) {
		_vcmsArticleStatusService = vcmsArticleStatusService;
	}

	public VcmsArticleStatusService getWrappedService() {
		return _vcmsArticleStatusService;
	}

	public void setWrappedService(
		VcmsArticleStatusService vcmsArticleStatusService) {
		_vcmsArticleStatusService = vcmsArticleStatusService;
	}

	private VcmsArticleStatusService _vcmsArticleStatusService;
}