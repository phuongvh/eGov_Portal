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
 * This class is a wrapper for {@link TFImageService}.
 * </p>
 *
 * @author    DucNN
 * @see       TFImageService
 * @generated
 */
public class TFImageServiceWrapper implements TFImageService,
	ServiceWrapper<TFImageService> {
	public TFImageServiceWrapper(TFImageService tfImageService) {
		_tfImageService = tfImageService;
	}

	public com.vportal.portlet.vimagegallery.model.TFImage addImage(
		long groupId, long companyId, long plid, long categoryId,
		java.lang.String name, java.lang.String description,
		java.lang.String image, boolean isShow,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.addImage(groupId, companyId, plid, categoryId,
			name, description, image, isShow, communityPermissions,
			guestPermissions);
	}

	public com.vportal.portlet.vimagegallery.model.TFImage addImage(
		long groupId, long companyId, long plid, long categoryId,
		java.lang.String name, java.lang.String description,
		java.lang.String image, boolean isShow,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.addImage(groupId, companyId, plid, categoryId,
			name, description, image, isShow, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vimagegallery.model.TFImage addImage(
		com.vportal.portlet.vimagegallery.model.TFImage image)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.addImage(image);
	}

	public com.vportal.portlet.vimagegallery.model.TFImage updateImage(
		long groupId, long companyId, long plid, long id, long categoryId,
		java.lang.String name, java.lang.String description,
		java.lang.String image, boolean isShow)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.updateImage(groupId, companyId, plid, id,
			categoryId, name, description, image, isShow);
	}

	public com.vportal.portlet.vimagegallery.model.TFImage updateImage(
		com.vportal.portlet.vimagegallery.model.TFImage image)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.updateImage(image);
	}

	public void deleteImage(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_tfImageService.deleteImage(id);
	}

	public com.vportal.portlet.vimagegallery.model.TFImage findImagebyID(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tfImageService.findImagebyID(id);
	}

	public com.vportal.portlet.vimagegallery.model.TFImage getImage(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.getImage(id);
	}

	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.findAll();
	}

	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.getByGroupId(groupId);
	}

	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.getByGroupId(groupId, start, end);
	}

	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.countByGroupId(groupId);
	}

	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.getByG_C(groupId, categoryId, start, end);
	}

	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.getByG_C(groupId, categoryId);
	}

	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByG_I(
		long groupId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.getByG_I(groupId, isShow, start, end);
	}

	public int countByG_I(long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.countByG_I(groupId, isShow);
	}

	public int countByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.countByG_C(groupId, categoryId);
	}

	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByG_C_I(
		long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.getByG_C_I(groupId, categoryId, isShow);
	}

	public java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByG_C_I(
		long groupId, long categoryId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.getByG_C_I(groupId, categoryId, isShow, start,
			end);
	}

	public int countByG_C_I(long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _tfImageService.countByG_C_I(groupId, categoryId, isShow);
	}

	public void addTFImageResources(long id, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tfImageService.addTFImageResources(id, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addTFImageResources(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tfImageService.addTFImageResources(tfImage, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addTFImageResources(long id,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tfImageService.addTFImageResources(id, communityPermissions,
			guestPermissions);
	}

	public void addTFImageResources(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tfImageService.addTFImageResources(tfImage, communityPermissions,
			guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TFImageService getWrappedTFImageService() {
		return _tfImageService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTFImageService(TFImageService tfImageService) {
		_tfImageService = tfImageService;
	}

	public TFImageService getWrappedService() {
		return _tfImageService;
	}

	public void setWrappedService(TFImageService tfImageService) {
		_tfImageService = tfImageService;
	}

	private TFImageService _tfImageService;
}