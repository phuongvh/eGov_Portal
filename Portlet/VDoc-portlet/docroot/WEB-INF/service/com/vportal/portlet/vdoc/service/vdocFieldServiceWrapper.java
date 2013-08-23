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
 * This class is a wrapper for {@link vdocFieldService}.
 * </p>
 *
 * @author    MrEn
 * @see       vdocFieldService
 * @generated
 */
public class vdocFieldServiceWrapper implements vdocFieldService,
	ServiceWrapper<vdocFieldService> {
	public vdocFieldServiceWrapper(vdocFieldService vdocFieldService) {
		_vdocFieldService = vdocFieldService;
	}

	public com.vportal.portlet.vdoc.model.vdocField addField(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		boolean statusField, int position, java.lang.String listparent,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocFieldService.addField(groupId, userId, language, parentId,
			name, description, statusField, position, listparent,
			communityPermissions, guestPermissions, themeDisplay);
	}

	public com.vportal.portlet.vdoc.model.vdocField addField(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		boolean statusField, int position, java.lang.String listparent,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocFieldService.addField(groupId, userId, language, parentId,
			name, description, statusField, position, listparent,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions, themeDisplay);
	}

	public com.vportal.portlet.vdoc.model.vdocField updateField(
		com.vportal.portlet.vdoc.model.vdocField field, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return _vdocFieldService.updateField(field, userId);
	}

	public com.vportal.portlet.vdoc.model.vdocField updateField(
		java.lang.String fieldId, long groupId, java.lang.String language,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean statusField, int position,
		java.lang.String listparent, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return _vdocFieldService.updateField(fieldId, groupId, language,
			parentId, name, description, statusField, position, listparent,
			userId);
	}

	public void deleteField(java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocFieldService.deleteField(fieldId);
	}

	public com.vportal.portlet.vdoc.model.vdocField getField(
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return _vdocFieldService.getField(fieldId);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByParentId(
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocFieldService.getFieldByParentId(parentId);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocFieldService.getFieldByG_L(groupId, language);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocFieldService.getFieldByG_L_P(groupId, language, parentId);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocFieldService.getFieldByG_L_P(groupId, language, parentId,
			begin, end);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L(
		long groupId, java.lang.String language, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocFieldService.getFieldByG_L(groupId, language, begin, end);
	}

	public int countFieldByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocFieldService.countFieldByG_L(groupId, language);
	}

	public int countFieldByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocFieldService.countFieldByG_L_P(groupId, language, parentId);
	}

	public void addEntryResources(long entryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocFieldService.addEntryResources(entryId, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocField entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocFieldService.addEntryResources(entry, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addEntryResources(long entryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocFieldService.addEntryResources(entryId, communityPermissions,
			guestPermissions);
	}

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocField entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocFieldService.addEntryResources(entry, communityPermissions,
			guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public vdocFieldService getWrappedvdocFieldService() {
		return _vdocFieldService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedvdocFieldService(vdocFieldService vdocFieldService) {
		_vdocFieldService = vdocFieldService;
	}

	public vdocFieldService getWrappedService() {
		return _vdocFieldService;
	}

	public void setWrappedService(vdocFieldService vdocFieldService) {
		_vdocFieldService = vdocFieldService;
	}

	private vdocFieldService _vdocFieldService;
}