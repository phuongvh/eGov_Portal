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
 * This class is a wrapper for {@link LinksService}.
 * </p>
 *
 * @author    LongLH
 * @see       LinksService
 * @generated
 */
public class LinksServiceWrapper implements LinksService,
	ServiceWrapper<LinksService> {
	public LinksServiceWrapper(LinksService linksService) {
		_linksService = linksService;
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, long position,
		long userId, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.addLinks(groupId, companyId, plid, linkgroupId,
			name, description, url, position, userId, communityPermissions,
			guestPermissions);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, long position,
		long userId, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.addLinks(groupId, companyId, plid, linkgroupId,
			name, description, url, position, userId, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, int position,
		long userId, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.addLinks(groupId, companyId, plid, linkgroupId,
			name, description, url, position, userId, hasImage, isTargetBlank,
			imageName, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, int position,
		long userId, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.addLinks(groupId, companyId, plid, linkgroupId,
			name, description, url, position, userId, hasImage, isTargetBlank,
			imageName, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, int position,
		long userId, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName,
		long folderId, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.addLinks(groupId, companyId, plid, linkgroupId,
			name, description, url, position, userId, hasImage, isTargetBlank,
			imageName, folderId, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, int position,
		long userId, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName,
		long folderId, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.addLinks(groupId, companyId, plid, linkgroupId,
			name, description, url, position, userId, hasImage, isTargetBlank,
			imageName, folderId, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(
		com.vportal.portlet.vlinksman.model.Links link, long plid,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _linksService.addLinks(link, plid, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLinks(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			java.rmi.RemoteException {
		return _linksService.updateLinks(link);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLinks(long linkId,
		long groupId, long companyId, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, long position)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.updateLinks(linkId, groupId, companyId,
			linkgroupId, name, description, url, position);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLink(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.updateLink(link);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLinks(long linkId,
		long groupId, long companyId, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, long position,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.updateLinks(linkId, groupId, companyId,
			linkgroupId, name, description, url, position, hasImage,
			isTargetBlank, imageName);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLinks(long linkId,
		long groupId, long companyId, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, long position,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName, long folderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.updateLinks(linkId, groupId, companyId,
			linkgroupId, name, description, url, position, hasImage,
			isTargetBlank, imageName, folderId);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLink2(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.updateLink2(link);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLink3(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.updateLink3(link);
	}

	public void deleteLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_linksService.deleteLink(linkId);
	}

	public java.util.List getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.getAll();
	}

	public java.util.List getByLinkGroupId(long linkGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.getByLinkGroupId(linkGroupId);
	}

	public java.util.List getByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.getByGroupId(groupId);
	}

	public java.util.List getByGroupId(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.getByGroupId(groupId, start, end);
	}

	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.countByGroupId(groupId);
	}

	public java.util.List getByLinkG_GL(long groupId, long linkGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.getByLinkG_GL(groupId, linkGroupId);
	}

	public java.util.List getByLinkG_GL(long groupId, long linkGroupId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.getByLinkG_GL(groupId, linkGroupId, start, end);
	}

	public com.vportal.portlet.vlinksman.model.Links getLinks(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _linksService.getLinks(linkId);
	}

	public void addLinksResources(long linkId, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_linksService.addLinksResources(linkId, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addLinksResources(
		com.vportal.portlet.vlinksman.model.Links link,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_linksService.addLinksResources(link, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addLinksResources(long linkId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_linksService.addLinksResources(linkId, communityPermissions,
			guestPermissions);
	}

	public void addLinksResources(
		com.vportal.portlet.vlinksman.model.Links link,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_linksService.addLinksResources(link, communityPermissions,
			guestPermissions);
	}

	public void _validate(java.lang.String name, java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_linksService._validate(name, url);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LinksService getWrappedLinksService() {
		return _linksService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLinksService(LinksService linksService) {
		_linksService = linksService;
	}

	public LinksService getWrappedService() {
		return _linksService;
	}

	public void setWrappedService(LinksService linksService) {
		_linksService = linksService;
	}

	private LinksService _linksService;
}