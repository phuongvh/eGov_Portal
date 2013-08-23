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

package com.vportal.portlet.vsitemap.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VsmBranchService}.
 * </p>
 *
 * @author    LongLH
 * @see       VsmBranchService
 * @generated
 */
public class VsmBranchServiceWrapper implements VsmBranchService,
	ServiceWrapper<VsmBranchService> {
	public VsmBranchServiceWrapper(VsmBranchService vsmBranchService) {
		_vsmBranchService = vsmBranchService;
	}

	public com.vportal.portlet.vsitemap.model.VsmBranch addBranch(
		long groupId, long companyId, long plid, long parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasIcon,
		java.lang.String icon, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.addBranch(groupId, companyId, plid, parentId,
			name, description, anchored, href, language, hasIcon, icon, userId);
	}

	public com.vportal.portlet.vsitemap.model.VsmBranch addBranch(
		long groupId, long companyId, long plid, long parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasIcon,
		java.lang.String icon, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.addBranch(groupId, companyId, plid, parentId,
			name, description, anchored, href, language, hasIcon, icon, userId,
			addCommunityPermissions, addGuestPermissions);
	}

	public com.vportal.portlet.vsitemap.model.VsmBranch updateBranch(
		long groupId, long companyId, long branchId, long parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasIcon,
		java.lang.String icon, long position, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.updateBranch(groupId, companyId, branchId,
			parentId, name, description, anchored, href, language, hasIcon,
			icon, position, userId);
	}

	public com.vportal.portlet.vsitemap.model.VsmBranch updateBranch(
		com.vportal.portlet.vsitemap.model.VsmBranch branch)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.updateBranch(branch);
	}

	public void deleteBranch(long branchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vsmBranchService.deleteBranch(branchId);
	}

	public java.util.List getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.getAll();
	}

	public java.util.List getByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.getByG_L(groupId, language);
	}

	public java.util.List getByG_L(long groupId, java.lang.String language,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.getByG_L(groupId, language, start, end);
	}

	public int countByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.countByG_L(groupId, language);
	}

	public java.util.List getByG_L_P(long groupId, java.lang.String language,
		long parentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.getByG_L_P(groupId, language, parentId);
	}

	public java.util.List getByG_L_P(long groupId, java.lang.String language,
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.getByG_L_P(groupId, language, parentId, start,
			end);
	}

	public int countByG_L_P(long groupId, java.lang.String language,
		long parentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.countByG_L_P(groupId, language, parentId);
	}

	public com.vportal.portlet.vsitemap.model.VsmBranch getBranch(long branchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.getBranch(branchId);
	}

	public java.util.List getAllByLanguage(java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.getAllByLanguage(language);
	}

	public java.util.List getAllByHasicon(boolean hasIcon)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.getAllByHasicon(hasIcon);
	}

	public java.util.List getAllByParent(long parentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vsmBranchService.getAllByParent(parentId);
	}

	public void addVsmBranchResources(long branchId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vsmBranchService.addVsmBranchResources(branchId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addVsmBranchResources(
		com.vportal.portlet.vsitemap.model.VsmBranch branch,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vsmBranchService.addVsmBranchResources(branch,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addVsmBranchResources(long branchId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vsmBranchService.addVsmBranchResources(branchId, communityPermissions,
			guestPermissions);
	}

	public void addVsmBranchResources(
		com.vportal.portlet.vsitemap.model.VsmBranch branch,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vsmBranchService.addVsmBranchResources(branch, communityPermissions,
			guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VsmBranchService getWrappedVsmBranchService() {
		return _vsmBranchService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVsmBranchService(VsmBranchService vsmBranchService) {
		_vsmBranchService = vsmBranchService;
	}

	public VsmBranchService getWrappedService() {
		return _vsmBranchService;
	}

	public void setWrappedService(VsmBranchService vsmBranchService) {
		_vsmBranchService = vsmBranchService;
	}

	private VsmBranchService _vsmBranchService;
}