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

package com.vportal.portlet.vcalendar.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VFileService}.
 * </p>
 *
 * @author    LongLH
 * @see       VFileService
 * @generated
 */
public class VFileServiceWrapper implements VFileService,
	ServiceWrapper<VFileService> {
	public VFileServiceWrapper(VFileService vFileService) {
		_vFileService = vFileService;
	}

	public com.vportal.portlet.vcalendar.model.VFile addVFile(
		java.lang.String fullname, java.lang.String phone,
		java.lang.String address, java.lang.String position,
		java.util.Date birthday, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vFileService.addVFile(fullname, phone, address, position,
			birthday, status);
	}

	public com.vportal.portlet.vcalendar.model.VFile updateVFile(long fileId,
		java.lang.String fullname, java.lang.String phone,
		java.lang.String address, java.lang.String position,
		java.util.Date birthday, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException {
		return _vFileService.updateVFile(fileId, fullname, phone, address,
			position, birthday, status);
	}

	public com.vportal.portlet.vcalendar.model.VFile deleteVFile(long fileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException {
		return _vFileService.deleteVFile(fileId);
	}

	public com.vportal.portlet.vcalendar.model.VFile findById(long fileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException {
		return _vFileService.findById(fileId);
	}

	public java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vFileService.findByAll();
	}

	public java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByAll(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vFileService.findByAll(begin, end);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vFileService.countAll();
	}

	public java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByGroupId(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _vFileService.findByGroupId(status);
	}

	public java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByGroupId(
		int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vFileService.findByGroupId(status, begin, end);
	}

	public int countByGroupId(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vFileService.countByGroupId(status);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VFileService getWrappedVFileService() {
		return _vFileService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVFileService(VFileService vFileService) {
		_vFileService = vFileService;
	}

	public VFileService getWrappedService() {
		return _vFileService;
	}

	public void setWrappedService(VFileService vFileService) {
		_vFileService = vFileService;
	}

	private VFileService _vFileService;
}