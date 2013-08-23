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

package com.vportal.portlet.vlinksman.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LinkGroupService}.
 * </p>
 *
 * @author    LongLH
 * @see       LinkGroupService
 * @generated
 */
public class LinkGroupServiceWrapper implements LinkGroupService,
	ServiceWrapper<LinkGroupService> {
	public LinkGroupServiceWrapper(LinkGroupService linkGroupService) {
		_linkGroupService = linkGroupService;
	}

	public com.vportal.portlet.vlinksman.model.LinkGroup addLinkGroup(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, long userId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linkGroupService.addLinkGroup(groupId, companyId, plid, name,
			description, userId, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vlinksman.model.LinkGroup addLinkGroup(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linkGroupService.addLinkGroup(groupId, companyId, plid, name,
			description, userId, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vlinksman.model.LinkGroup updateLinkGroup(
		long linkgroupId, long groupId, long companyId, java.lang.String name,
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linkGroupService.updateLinkGroup(linkgroupId, groupId,
			companyId, name, description);
	}

	public void deleteLinkGroup(long linkgroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_linkGroupService.deleteLinkGroup(linkgroupId);
	}

	public java.util.List getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linkGroupService.getAll();
	}

	public java.util.List getByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linkGroupService.getByGroupId(groupId);
	}

	public java.util.List getByGroupId(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linkGroupService.getByGroupId(groupId, start, end);
	}

	public com.vportal.portlet.vlinksman.model.LinkGroup getLinkGroup(
		long linkgroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linkGroupService.getLinkGroup(linkgroupId);
	}

	public void addLinkGroupResources(long linkgroupId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_linkGroupService.addLinkGroupResources(linkgroupId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addLinkGroupResources(
		com.vportal.portlet.vlinksman.model.LinkGroup linkGroup,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_linkGroupService.addLinkGroupResources(linkGroup,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addLinkGroupResources(long linkgroupId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_linkGroupService.addLinkGroupResources(linkgroupId,
			communityPermissions, guestPermissions);
	}

	public void addLinkGroupResources(
		com.vportal.portlet.vlinksman.model.LinkGroup linkGroup,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_linkGroupService.addLinkGroupResources(linkGroup,
			communityPermissions, guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LinkGroupService getWrappedLinkGroupService() {
		return _linkGroupService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLinkGroupService(LinkGroupService linkGroupService) {
		_linkGroupService = linkGroupService;
	}

	public LinkGroupService getWrappedService() {
		return _linkGroupService;
	}

	public void setWrappedService(LinkGroupService linkGroupService) {
		_linkGroupService = linkGroupService;
	}

	private LinkGroupService _linkGroupService;
}