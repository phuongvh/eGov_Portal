/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.vimagegallery.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TFCategoryService}.
 * </p>
 *
 * @author    DucNN
 * @see       TFCategoryService
 * @generated
 */
public class TFCategoryServiceWrapper implements TFCategoryService,
	ServiceWrapper<TFCategoryService> {
	public TFCategoryServiceWrapper(TFCategoryService tfCategoryService) {
		_tfCategoryService = tfCategoryService;
	}

	public com.vportal.portlet.vimagegallery.model.TFCategory addCategory(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String image,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfCategoryService.addCategory(groupId, companyId, plid, name,
			description, image, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vimagegallery.model.TFCategory addCategory(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String image,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfCategoryService.addCategory(groupId, companyId, plid, name,
			description, image, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vimagegallery.model.TFCategory addCategory(
		com.vportal.portlet.vimagegallery.model.TFCategory category)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfCategoryService.addCategory(category);
	}

	public com.vportal.portlet.vimagegallery.model.TFCategory updateCategory(
		long groupId, long companyId, long id, java.lang.String name,
		java.lang.String description, java.lang.String image)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfCategoryService.updateCategory(groupId, companyId, id, name,
			description, image);
	}

	public com.vportal.portlet.vimagegallery.model.TFCategory updateCategory(
		com.vportal.portlet.vimagegallery.model.TFCategory category)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfCategoryService.updateCategory(category);
	}

	public void deleteCategory(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_tfCategoryService.deleteCategory(id);
	}

	public com.vportal.portlet.vimagegallery.model.TFCategory getCategory(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfCategoryService.getCategory(id);
	}

	public java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> getByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tfCategoryService.getByGroupId(groupId);
	}

	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tfCategoryService.countByGroupId(groupId);
	}

	public com.vportal.portlet.vimagegallery.model.TFCategory findCategory(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfCategoryService.findCategory(id);
	}

	public void addTFCategoryResources(long id,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tfCategoryService.addTFCategoryResources(id, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addTFCategoryResources(
		com.vportal.portlet.vimagegallery.model.TFCategory tfCategory,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tfCategoryService.addTFCategoryResources(tfCategory,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addTFCategoryResources(long id,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tfCategoryService.addTFCategoryResources(id, communityPermissions,
			guestPermissions);
	}

	public void addTFCategoryResources(
		com.vportal.portlet.vimagegallery.model.TFCategory tfCategory,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tfCategoryService.addTFCategoryResources(tfCategory,
			communityPermissions, guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TFCategoryService getWrappedTFCategoryService() {
		return _tfCategoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTFCategoryService(TFCategoryService tfCategoryService) {
		_tfCategoryService = tfCategoryService;
	}

	public TFCategoryService getWrappedService() {
		return _tfCategoryService;
	}

	public void setWrappedService(TFCategoryService tfCategoryService) {
		_tfCategoryService = tfCategoryService;
	}

	private TFCategoryService _tfCategoryService;
}