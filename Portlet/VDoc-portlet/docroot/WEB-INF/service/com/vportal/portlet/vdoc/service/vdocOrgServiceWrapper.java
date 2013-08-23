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
 * This class is a wrapper for {@link vdocOrgService}.
 * </p>
 *
 * @author    MrEn
 * @see       vdocOrgService
 * @generated
 */
public class vdocOrgServiceWrapper implements vdocOrgService,
	ServiceWrapper<vdocOrgService> {
	public vdocOrgServiceWrapper(vdocOrgService vdocOrgService) {
		_vdocOrgService = vdocOrgService;
	}

	public com.vportal.portlet.vdoc.model.vdocOrg addOrg(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		java.lang.String address, java.lang.String phone, boolean statusOrg,
		int position, java.lang.String fax, java.lang.String listparent,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocOrgService.addOrg(groupId, userId, language, parentId,
			name, description, address, phone, statusOrg, position, fax,
			listparent, communityPermissions, guestPermissions, themeDisplay);
	}

	public com.vportal.portlet.vdoc.model.vdocOrg addOrg(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		java.lang.String address, java.lang.String phone, boolean statusOrg,
		int position, java.lang.String fax, java.lang.String listparent,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocOrgService.addOrg(groupId, userId, language, parentId,
			name, description, address, phone, statusOrg, position, fax,
			listparent, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions, themeDisplay);
	}

	public com.vportal.portlet.vdoc.model.vdocOrg updateOrg(
		com.vportal.portlet.vdoc.model.vdocOrg org, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		return _vdocOrgService.updateOrg(org, userId);
	}

	public com.vportal.portlet.vdoc.model.vdocOrg updateOrg(
		java.lang.String orgId, long groupId, java.lang.String language,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, java.lang.String address,
		java.lang.String phone, boolean statusOrg, int position,
		java.lang.String fax, java.lang.String listparent, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		return _vdocOrgService.updateOrg(orgId, groupId, language, parentId,
			name, description, address, phone, statusOrg, position, fax,
			listparent, userId);
	}

	public void deleteOrg(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.DeleteOrgException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		_vdocOrgService.deleteOrg(orgId);
	}

	public com.vportal.portlet.vdoc.model.vdocOrg getOrg(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		return _vdocOrgService.getOrg(orgId);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByParentId(
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocOrgService.getOrgByParentId(parentId);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocOrgService.getOrgByG_L(groupId, language);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L(
		long groupId, java.lang.String language, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocOrgService.getOrgByG_L(groupId, language, begin, end);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocOrgService.getOrgByG_L_P(groupId, language, parentId);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocOrgService.getOrgByG_L_P(groupId, language, parentId,
			begin, end);
	}

	public int countOrgByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocOrgService.countOrgByG_L(groupId, language);
	}

	public int countOrgByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocOrgService.countOrgByG_L_P(groupId, language, parentId);
	}

	public void addEntryResources(long entryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocOrgService.addEntryResources(entryId, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocOrg entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocOrgService.addEntryResources(entry, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addEntryResources(long entryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocOrgService.addEntryResources(entryId, communityPermissions,
			guestPermissions);
	}

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocOrg entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocOrgService.addEntryResources(entry, communityPermissions,
			guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public vdocOrgService getWrappedvdocOrgService() {
		return _vdocOrgService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedvdocOrgService(vdocOrgService vdocOrgService) {
		_vdocOrgService = vdocOrgService;
	}

	public vdocOrgService getWrappedService() {
		return _vdocOrgService;
	}

	public void setWrappedService(vdocOrgService vdocOrgService) {
		_vdocOrgService = vdocOrgService;
	}

	private vdocOrgService _vdocOrgService;
}