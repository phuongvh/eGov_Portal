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
 * This class is a wrapper for {@link vdocDORelService}.
 * </p>
 *
 * @author    MrEn
 * @see       vdocDORelService
 * @generated
 */
public class vdocDORelServiceWrapper implements vdocDORelService,
	ServiceWrapper<vdocDORelService> {
	public vdocDORelServiceWrapper(vdocDORelService vdocDORelService) {
		_vdocDORelService = vdocDORelService;
	}

	public int countCategory_approving(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocDORelService.countCategory_approving(categoryId);
	}

	public int countCategory_public(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocDORelService.countCategory_public(categoryId);
	}

	public int countCategory_modify(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocDORelService.countCategory_modify(categoryId);
	}

	public com.vportal.portlet.vdoc.model.vdocDORel addRelation(
		java.lang.String docId, java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocDORelService.addRelation(docId, orgId);
	}

	public void deleteRelation(java.lang.String docId, java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vdocDORelService.deleteRelation(docId, orgId);
	}

	public void deleteRelByDoc(java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vdocDORelService.deleteRelByDoc(docId);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> getDORelByDoc(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocDORelService.getDORelByDoc(docId);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> getDORelByOrg(
		java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocDORelService.getDORelByOrg(orgId);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> getRelByDoc(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocDORelService.getRelByDoc(docId);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> getRelByField(
		java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocDORelService.getRelByField(orgId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public vdocDORelService getWrappedvdocDORelService() {
		return _vdocDORelService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedvdocDORelService(vdocDORelService vdocDORelService) {
		_vdocDORelService = vdocDORelService;
	}

	public vdocDORelService getWrappedService() {
		return _vdocDORelService;
	}

	public void setWrappedService(vdocDORelService vdocDORelService) {
		_vdocDORelService = vdocDORelService;
	}

	private vdocDORelService _vdocDORelService;
}