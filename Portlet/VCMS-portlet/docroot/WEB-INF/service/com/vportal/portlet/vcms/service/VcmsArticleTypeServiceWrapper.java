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
 * This class is a wrapper for {@link VcmsArticleTypeService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticleTypeService
 * @generated
 */
public class VcmsArticleTypeServiceWrapper implements VcmsArticleTypeService,
	ServiceWrapper<VcmsArticleTypeService> {
	public VcmsArticleTypeServiceWrapper(
		VcmsArticleTypeService vcmsArticleTypeService) {
		_vcmsArticleTypeService = vcmsArticleTypeService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsArticleTypeService getWrappedVcmsArticleTypeService() {
		return _vcmsArticleTypeService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsArticleTypeService(
		VcmsArticleTypeService vcmsArticleTypeService) {
		_vcmsArticleTypeService = vcmsArticleTypeService;
	}

	public VcmsArticleTypeService getWrappedService() {
		return _vcmsArticleTypeService;
	}

	public void setWrappedService(VcmsArticleTypeService vcmsArticleTypeService) {
		_vcmsArticleTypeService = vcmsArticleTypeService;
	}

	private VcmsArticleTypeService _vcmsArticleTypeService;
}