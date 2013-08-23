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
 * This class is a wrapper for {@link VcmsLoggerService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsLoggerService
 * @generated
 */
public class VcmsLoggerServiceWrapper implements VcmsLoggerService,
	ServiceWrapper<VcmsLoggerService> {
	public VcmsLoggerServiceWrapper(VcmsLoggerService vcmsLoggerService) {
		_vcmsLoggerService = vcmsLoggerService;
	}

	public com.vportal.portlet.vcms.model.VcmsLogger log(
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsLoggerService.log(content);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogsByUser(
		java.lang.String userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsLoggerService.findLogsByUser(userId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogs(
		java.util.Date from, java.util.Date to)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsLoggerService.findLogs(from, to);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogersByD_A_K(
		java.lang.String keyword, int select, java.util.Date datePresent)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsLoggerService.findLogersByD_A_K(keyword, select, datePresent);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogersByD_A_K(
		java.lang.String keyword, int select, java.util.Date datePresent,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsLoggerService.findLogersByD_A_K(keyword, select,
			datePresent, start, end);
	}

	public int countLogersByD_A_K(java.lang.String keyword, int select,
		java.util.Date datePresent)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsLoggerService.countLogersByD_A_K(keyword, select,
			datePresent);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogs()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsLoggerService.findLogs();
	}

	public int countLogs()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsLoggerService.countLogs();
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsLoggerService.findLogs(start, end);
	}

	public void removeLogs(java.util.Date from, java.util.Date to)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsLoggerService.removeLogs(from, to);
	}

	public void removeLog(java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsLoggerService.removeLog(loggerId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsLoggerService getWrappedVcmsLoggerService() {
		return _vcmsLoggerService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsLoggerService(VcmsLoggerService vcmsLoggerService) {
		_vcmsLoggerService = vcmsLoggerService;
	}

	public VcmsLoggerService getWrappedService() {
		return _vcmsLoggerService;
	}

	public void setWrappedService(VcmsLoggerService vcmsLoggerService) {
		_vcmsLoggerService = vcmsLoggerService;
	}

	private VcmsLoggerService _vcmsLoggerService;
}