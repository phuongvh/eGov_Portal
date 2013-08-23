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
 * This class is a wrapper for {@link VcmsCARelationService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsCARelationService
 * @generated
 */
public class VcmsCARelationServiceWrapper implements VcmsCARelationService,
	ServiceWrapper<VcmsCARelationService> {
	public VcmsCARelationServiceWrapper(
		VcmsCARelationService vcmsCARelationService) {
		_vcmsCARelationService = vcmsCARelationService;
	}

	public com.vportal.portlet.vcms.model.VcmsCARelation addRelation(
		java.lang.String categoryId, java.lang.String articleId, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCARelationService.addRelation(categoryId, articleId,
			statusId);
	}

	public void deleteRelation(java.lang.String categoryId,
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsCARelationService.deleteRelation(categoryId, articleId);
	}

	public void deleteRelationsByCategory(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsCARelationService.deleteRelationsByCategory(categoryId);
	}

	public void deleteRelationsByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsCARelationService.deleteRelationsByArticle(articleId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> getRelationsByCategory(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCARelationService.getRelationsByCategory(categoryId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> getRelationsByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCARelationService.getRelationsByArticle(articleId);
	}

	public int countArticlesOfCategory(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCARelationService.countArticlesOfCategory(categoryId);
	}

	public com.vportal.portlet.vcms.model.VcmsCARelation findRelationsByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCARelationService.findRelationsByArticle(articleId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsCARelationService getWrappedVcmsCARelationService() {
		return _vcmsCARelationService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsCARelationService(
		VcmsCARelationService vcmsCARelationService) {
		_vcmsCARelationService = vcmsCARelationService;
	}

	public VcmsCARelationService getWrappedService() {
		return _vcmsCARelationService;
	}

	public void setWrappedService(VcmsCARelationService vcmsCARelationService) {
		_vcmsCARelationService = vcmsCARelationService;
	}

	private VcmsCARelationService _vcmsCARelationService;
}