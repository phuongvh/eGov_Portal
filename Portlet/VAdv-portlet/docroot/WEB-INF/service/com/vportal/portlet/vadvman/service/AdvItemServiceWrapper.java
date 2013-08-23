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
 * This class is a wrapper for {@link AdvItemService}.
 * </p>
 *
 * @author    DucNN
 * @see       AdvItemService
 * @generated
 */
public class AdvItemServiceWrapper implements AdvItemService,
	ServiceWrapper<AdvItemService> {
	public AdvItemServiceWrapper(AdvItemService advItemService) {
		_advItemService = advItemService;
	}

	public com.vportal.portlet.vadvman.model.AdvItem addItem(long groupId,
		long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String url,
		boolean isTargetBlank, java.lang.String txtMouseOver, boolean status,
		long typeId, long folderId, java.util.Date expriedDate,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.addItem(groupId, companyId, plid, name,
			description, url, isTargetBlank, txtMouseOver, status, typeId,
			folderId, expriedDate, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vadvman.model.AdvItem addItem(long groupId,
		long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String url,
		boolean isTargetBlank, java.lang.String txtMouseOver, boolean status,
		long typeId, long folderId, java.util.Date expriedDate,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.addItem(groupId, companyId, plid, name,
			description, url, isTargetBlank, txtMouseOver, status, typeId,
			folderId, expriedDate, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vadvman.model.AdvItem updateItem(long itemId,
		long groupId, long companyId, java.lang.String name,
		java.lang.String description, java.lang.String url,
		boolean isTargetBlank, java.lang.String txtMouseOver, boolean status,
		long typeId, long folderId, java.util.Date expriedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.updateItem(itemId, groupId, companyId, name,
			description, url, isTargetBlank, txtMouseOver, status, typeId,
			folderId, expriedDate);
	}

	public com.vportal.portlet.vadvman.model.AdvItem updateItem(
		com.vportal.portlet.vadvman.model.AdvItem advItem)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.updateItem(advItem);
	}

	public void deleteItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_advItemService.deleteItem(itemId);
	}

	public void deleteItembyType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_advItemService.deleteItembyType(typeId);
	}

	public com.vportal.portlet.vadvman.model.AdvItem getItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.getItem(itemId);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getAllbyType(
		long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.getAllbyType(typeId);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.getItemByG(groupId);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.getItemByG(groupId, start, end);
	}

	public int countItemByG(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.countItemByG(groupId);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG_S(
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.getItemByG_S(groupId, status);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG_S(
		long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.getItemByG_S(groupId, status, start, end);
	}

	public int countItemByG_S(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.countItemByG_S(groupId, status);
	}

	public int countItemByG_T(long groupId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _advItemService.countItemByG_T(groupId, typeId);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByParam(
		long groupId, java.lang.String description, long typeId, int status,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advItemService.getItemByParam(groupId, description, typeId,
			status, begin, end);
	}

	public int countItemByParam(long groupId, java.lang.String description,
		long typeId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advItemService.countItemByParam(groupId, description, typeId,
			status);
	}

	public void addAdvItemResources(long itemId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_advItemService.addAdvItemResources(itemId, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addAdvItemResources(
		com.vportal.portlet.vadvman.model.AdvItem item,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_advItemService.addAdvItemResources(item, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addAdvItemResources(long itemId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_advItemService.addAdvItemResources(itemId, communityPermissions,
			guestPermissions);
	}

	public void addAdvItemResources(
		com.vportal.portlet.vadvman.model.AdvItem item,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_advItemService.addAdvItemResources(item, communityPermissions,
			guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AdvItemService getWrappedAdvItemService() {
		return _advItemService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAdvItemService(AdvItemService advItemService) {
		_advItemService = advItemService;
	}

	public AdvItemService getWrappedService() {
		return _advItemService;
	}

	public void setWrappedService(AdvItemService advItemService) {
		_advItemService = advItemService;
	}

	private AdvItemService _advItemService;
}