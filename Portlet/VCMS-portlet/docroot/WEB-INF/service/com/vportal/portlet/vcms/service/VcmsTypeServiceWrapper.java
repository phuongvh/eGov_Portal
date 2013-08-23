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

package com.vportal.portlet.vcms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VcmsTypeService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsTypeService
 * @generated
 */
public class VcmsTypeServiceWrapper implements VcmsTypeService,
	ServiceWrapper<VcmsTypeService> {
	public VcmsTypeServiceWrapper(VcmsTypeService vcmsTypeService) {
		_vcmsTypeService = vcmsTypeService;
	}

	public com.vportal.portlet.vcms.model.VcmsType addType(long groupId,
		long companyId, long plid, java.lang.String code,
		java.lang.String name, java.lang.String description,
		java.lang.String language, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsTypeService.addType(groupId, companyId, plid, code, name,
			description, language, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vcms.model.VcmsType addType(long groupId,
		long companyId, long plid, java.lang.String code,
		java.lang.String name, java.lang.String description,
		java.lang.String language, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsTypeService.addType(groupId, companyId, plid, code, name,
			description, language, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public void addTypeResources(java.lang.String TypeId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsTypeService.addTypeResources(TypeId, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addTypeResources(com.vportal.portlet.vcms.model.VcmsType Type,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsTypeService.addTypeResources(Type, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addTypeResources(java.lang.String TypeId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsTypeService.addTypeResources(TypeId, communityPermissions,
			guestPermissions);
	}

	public void addTypeResources(com.vportal.portlet.vcms.model.VcmsType Type,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsTypeService.addTypeResources(Type, communityPermissions,
			guestPermissions);
	}

	public com.vportal.portlet.vcms.model.VcmsType updateType(
		java.lang.String typeId, long groupId, long companyId,
		java.lang.String code, java.lang.String name,
		java.lang.String description, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsTypeService.updateType(typeId, groupId, companyId, code,
			name, description, language);
	}

	public void deleteType(java.lang.String typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsTypeService.deleteType(typeId);
	}

	public void deleteTypes(java.lang.String[] typeIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsTypeService.deleteTypes(typeIds);
	}

	public com.vportal.portlet.vcms.model.VcmsType getType(
		java.lang.String typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsTypeService.getType(typeId);
	}

	public com.vportal.portlet.vcms.model.VcmsType getTypeByS_C(long groupId,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsTypeService.getTypeByS_C(groupId, code);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsType> getTypesByS_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsTypeService.getTypesByS_L(groupId, language);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsType> getTypesByS_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsTypeService.getTypesByS_L(groupId, language, start, end);
	}

	public int countTypesByS_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsTypeService.countTypesByS_L(groupId, language);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsTypeService getWrappedVcmsTypeService() {
		return _vcmsTypeService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsTypeService(VcmsTypeService vcmsTypeService) {
		_vcmsTypeService = vcmsTypeService;
	}

	public VcmsTypeService getWrappedService() {
		return _vcmsTypeService;
	}

	public void setWrappedService(VcmsTypeService vcmsTypeService) {
		_vcmsTypeService = vcmsTypeService;
	}

	private VcmsTypeService _vcmsTypeService;
}