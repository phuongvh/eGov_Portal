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

package com.vportal.portlet.vcontact.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VContactService}.
 * </p>
 *
 * @author    LongLH
 * @see       VContactService
 * @generated
 */
public class VContactServiceWrapper implements VContactService,
	ServiceWrapper<VContactService> {
	public VContactServiceWrapper(VContactService vContactService) {
		_vContactService = vContactService;
	}

	public com.vportal.portlet.vcontact.model.VContact addContact(
		long groupId, long companyId, long plid, java.lang.String guestName,
		java.lang.String email, java.lang.String title,
		java.lang.String address, java.lang.String phone, java.lang.String fax,
		java.lang.String content, boolean hasAttach, int status, long userId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vContactService.addContact(groupId, companyId, plid, guestName,
			email, title, address, phone, fax, content, hasAttach, status,
			userId, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vcontact.model.VContact addContact(
		long groupId, long companyId, long plid, java.lang.String guestName,
		java.lang.String email, java.lang.String title,
		java.lang.String address, java.lang.String phone, java.lang.String fax,
		java.lang.String content, boolean hasAttach, int status, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vContactService.addContact(groupId, companyId, plid, guestName,
			email, title, address, phone, fax, content, hasAttach, status,
			userId, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vcontact.model.VContact updateContact(long Id,
		long groupId, long companyId, java.lang.String guestName,
		java.lang.String email, java.lang.String title,
		java.lang.String address, java.lang.String phone, java.lang.String fax,
		java.lang.String content, boolean hasAttach, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vContactService.updateContact(Id, groupId, companyId,
			guestName, email, title, address, phone, fax, content, hasAttach,
			status);
	}

	public com.vportal.portlet.vcontact.model.VContact updateContact(
		com.vportal.portlet.vcontact.model.VContact contact)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vContactService.updateContact(contact);
	}

	public void deleteContact(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vContactService.deleteContact(Id);
	}

	public java.util.List<com.vportal.portlet.vcontact.model.VContact> getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vContactService.getAll();
	}

	public java.util.List<com.vportal.portlet.vcontact.model.VContact> getByStatus(
		int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vContactService.getByStatus(status);
	}

	public java.util.List<com.vportal.portlet.vcontact.model.VContact> getByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vContactService.getByG_S(groupId, status);
	}

	public java.util.List<com.vportal.portlet.vcontact.model.VContact> getByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vContactService.getByG_S(groupId, status, start, end);
	}

	public com.vportal.portlet.vcontact.model.VContact getContact(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vContactService.getContact(Id);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VContactService getWrappedVContactService() {
		return _vContactService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVContactService(VContactService vContactService) {
		_vContactService = vContactService;
	}

	public VContactService getWrappedService() {
		return _vContactService;
	}

	public void setWrappedService(VContactService vContactService) {
		_vContactService = vContactService;
	}

	private VContactService _vContactService;
}