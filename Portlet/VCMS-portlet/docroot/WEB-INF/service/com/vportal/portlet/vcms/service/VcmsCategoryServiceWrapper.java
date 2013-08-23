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
 * This class is a wrapper for {@link VcmsCategoryService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsCategoryService
 * @generated
 */
public class VcmsCategoryServiceWrapper implements VcmsCategoryService,
	ServiceWrapper<VcmsCategoryService> {
	public VcmsCategoryServiceWrapper(VcmsCategoryService vcmsCategoryService) {
		_vcmsCategoryService = vcmsCategoryService;
	}

	public com.vportal.portlet.vcms.model.VcmsCategory addCategory(
		long groupId, long companyId, long plid, java.lang.String portionId,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean anchored, java.lang.String href,
		java.lang.String language, boolean hasImage, java.lang.String image,
		boolean rssable, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.addCategory(groupId, companyId, plid,
			portionId, parentId, name, description, anchored, href, language,
			hasImage, image, rssable, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vcms.model.VcmsCategory addCategory(
		long groupId, long companyId, long plid, java.lang.String portionId,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean anchored, java.lang.String href,
		java.lang.String language, boolean hasImage, java.lang.String image,
		boolean rssable, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.addCategory(groupId, companyId, plid,
			portionId, parentId, name, description, anchored, href, language,
			hasImage, image, rssable, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public void changePortion(java.lang.String parentId, long groupId,
		java.lang.String portionId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsCategoryService.changePortion(parentId, groupId, portionId,
			language);
	}

	public void addCategoryResources(java.lang.String categoryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsCategoryService.addCategoryResources(categoryId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addCategoryResources(
		com.vportal.portlet.vcms.model.VcmsCategory category,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsCategoryService.addCategoryResources(category,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addCategoryResources(java.lang.String categoryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsCategoryService.addCategoryResources(categoryId,
			communityPermissions, guestPermissions);
	}

	public void addCategoryResources(
		com.vportal.portlet.vcms.model.VcmsCategory category,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsCategoryService.addCategoryResources(category,
			communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vcms.model.VcmsCategory updateCategory(
		long groupId, long companyId, java.lang.String categoryId,
		java.lang.String portionId, java.lang.String parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasImage,
		java.lang.String image, long position, long userHit, boolean rssable)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.updateCategory(groupId, companyId,
			categoryId, portionId, parentId, name, description, anchored, href,
			language, hasImage, image, position, userHit, rssable);
	}

	public com.vportal.portlet.vcms.model.VcmsCategory updateCategory(
		com.vportal.portlet.vcms.model.VcmsCategory category)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.updateCategory(category);
	}

	public void deleteCategory(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsCategoryService.deleteCategory(categoryId);
	}

	public com.vportal.portlet.vcms.model.VcmsCategory getCategory(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.getCategory(categoryId);
	}

	public java.lang.String getCategoriesByRSS(java.lang.String categoryId,
		int max, java.lang.String type, double version,
		java.lang.String displayStyle, java.lang.String feedURL,
		java.lang.String entryURL, int quantity,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.getCategoriesByRSS(categoryId, max, type,
			version, displayStyle, feedURL, entryURL, quantity, themeDisplay);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getCategoriesByPortion(
		long groupId, java.lang.String portionId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.getCategoriesByPortion(groupId, portionId,
			language);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getCategoriesByParent(
		long groupId, java.lang.String parentId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.getCategoriesByParent(groupId, parentId,
			language);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getCategoriesByParent(
		long groupId, java.lang.String parentId, java.lang.String language,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.getCategoriesByParent(groupId, parentId,
			language, start, end);
	}

	public int countCategoriesByParent(long groupId, java.lang.String parentId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.countCategoriesByParent(groupId, parentId,
			language);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getCategoriesByP_P(
		long groupId, java.lang.String portionId, java.lang.String parentId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.getCategoriesByP_P(groupId, portionId,
			parentId, language);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getCategoriesByP_P(
		long groupId, java.lang.String portionId, java.lang.String parentId,
		java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.getCategoriesByP_P(groupId, portionId,
			parentId, language, start, end);
	}

	public int countCategoriesByP_P(long groupId, java.lang.String portionId,
		java.lang.String parentId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.countCategoriesByP_P(groupId, portionId,
			parentId, language);
	}

	public int countByP_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsCategoryService.countByP_L(groupId, language);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsCategoryService getWrappedVcmsCategoryService() {
		return _vcmsCategoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsCategoryService(
		VcmsCategoryService vcmsCategoryService) {
		_vcmsCategoryService = vcmsCategoryService;
	}

	public VcmsCategoryService getWrappedService() {
		return _vcmsCategoryService;
	}

	public void setWrappedService(VcmsCategoryService vcmsCategoryService) {
		_vcmsCategoryService = vcmsCategoryService;
	}

	private VcmsCategoryService _vcmsCategoryService;
}