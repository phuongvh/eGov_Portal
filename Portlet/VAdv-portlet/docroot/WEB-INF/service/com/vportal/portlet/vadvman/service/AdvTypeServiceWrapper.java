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

package com.vportal.portlet.vadvman.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AdvTypeService}.
 * </p>
 *
 * @author    DucNN
 * @see       AdvTypeService
 * @generated
 */
public class AdvTypeServiceWrapper implements AdvTypeService,
	ServiceWrapper<AdvTypeService> {
	public AdvTypeServiceWrapper(AdvTypeService advTypeService) {
		_advTypeService = advTypeService;
	}

	public com.vportal.portlet.vadvman.model.AdvType addType(long groupId,
		long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advTypeService.addType(groupId, companyId, plid, name,
			description, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vadvman.model.AdvType addType(long groupId,
		long companyId, long plid, java.lang.String name,
		java.lang.String description,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advTypeService.addType(groupId, companyId, plid, name,
			description, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vadvman.model.AdvType updateType(long typeId,
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advTypeService.updateType(typeId, groupId, companyId, plid,
			name, description);
	}

	public void deleteType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_advTypeService.deleteType(typeId);
	}

	public void deleteType(com.vportal.portlet.vadvman.model.AdvType type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_advTypeService.deleteType(type);
	}

	public com.vportal.portlet.vadvman.model.AdvType getType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advTypeService.getType(typeId);
	}

	public int getItemCount(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advTypeService.getItemCount(typeId);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvType> getTypeByG(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advTypeService.getTypeByG(groupId);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvType> getTypeByG(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advTypeService.getTypeByG(groupId, start, end);
	}

	public int countTypeByG(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advTypeService.countTypeByG(groupId);
	}

	public void addAdvTypeResources(long typeId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_advTypeService.addAdvTypeResources(typeId, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addAdvTypeResources(
		com.vportal.portlet.vadvman.model.AdvType type,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_advTypeService.addAdvTypeResources(type, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addAdvTypeResources(long typeId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_advTypeService.addAdvTypeResources(typeId, communityPermissions,
			guestPermissions);
	}

	public void addAdvTypeResources(
		com.vportal.portlet.vadvman.model.AdvType type,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_advTypeService.addAdvTypeResources(type, communityPermissions,
			guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AdvTypeService getWrappedAdvTypeService() {
		return _advTypeService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAdvTypeService(AdvTypeService advTypeService) {
		_advTypeService = advTypeService;
	}

	public AdvTypeService getWrappedService() {
		return _advTypeService;
	}

	public void setWrappedService(AdvTypeService advTypeService) {
		_advTypeService = advTypeService;
	}

	private AdvTypeService _advTypeService;
}