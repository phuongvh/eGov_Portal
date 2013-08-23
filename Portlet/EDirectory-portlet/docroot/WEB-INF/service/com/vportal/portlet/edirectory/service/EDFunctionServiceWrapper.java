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
 * This class is a wrapper for {@link EDFunctionService}.
 * </p>
 *
 * @author    HOAN
 * @see       EDFunctionService
 * @generated
 */
public class EDFunctionServiceWrapper implements EDFunctionService,
	ServiceWrapper<EDFunctionService> {
	public EDFunctionServiceWrapper(EDFunctionService edFunctionService) {
		_edFunctionService = edFunctionService;
	}

	public com.vportal.portlet.edirectory.model.EDFunction addFunction(
		com.vportal.portlet.edirectory.model.EDFunction function,
		java.lang.String languageId, long userId, long plid,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _edFunctionService.addFunction(function, languageId, userId,
			plid, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.edirectory.model.EDFunction updateFunction(
		com.vportal.portlet.edirectory.model.EDFunction function,
		long functionId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			java.rmi.RemoteException {
		return _edFunctionService.updateFunction(function, functionId, groupId);
	}

	public void removeFunction(long functionId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			java.rmi.RemoteException {
		_edFunctionService.removeFunction(functionId, groupId);
	}

	public void addFunctionResources(long functionId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_edFunctionService.addFunctionResources(functionId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addFunctionResources(
		com.vportal.portlet.edirectory.model.EDFunction function,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_edFunctionService.addFunctionResources(function,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addFunctionResources(long functionId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_edFunctionService.addFunctionResources(functionId,
			communityPermissions, guestPermissions);
	}

	public void addFunctionResources(
		com.vportal.portlet.edirectory.model.EDFunction function,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_edFunctionService.addFunctionResources(function, communityPermissions,
			guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EDFunctionService getWrappedEDFunctionService() {
		return _edFunctionService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEDFunctionService(EDFunctionService edFunctionService) {
		_edFunctionService = edFunctionService;
	}

	public EDFunctionService getWrappedService() {
		return _edFunctionService;
	}

	public void setWrappedService(EDFunctionService edFunctionService) {
		_edFunctionService = edFunctionService;
	}

	private EDFunctionService _edFunctionService;
}