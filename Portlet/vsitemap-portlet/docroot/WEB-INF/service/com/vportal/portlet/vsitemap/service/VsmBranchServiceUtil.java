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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the vsm branch remote service. This utility wraps {@link com.vportal.portlet.vsitemap.service.impl.VsmBranchServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LongLH
 * @see VsmBranchService
 * @see com.vportal.portlet.vsitemap.service.base.VsmBranchServiceBaseImpl
 * @see com.vportal.portlet.vsitemap.service.impl.VsmBranchServiceImpl
 * @generated
 */
public class VsmBranchServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vsitemap.service.impl.VsmBranchServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vsitemap.model.VsmBranch addBranch(
		long groupId, long companyId, long plid, long parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasIcon,
		java.lang.String icon, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addBranch(groupId, companyId, plid, parentId, name,
			description, anchored, href, language, hasIcon, icon, userId);
	}

	public static com.vportal.portlet.vsitemap.model.VsmBranch addBranch(
		long groupId, long companyId, long plid, long parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasIcon,
		java.lang.String icon, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addBranch(groupId, companyId, plid, parentId, name,
			description, anchored, href, language, hasIcon, icon, userId,
			addCommunityPermissions, addGuestPermissions);
	}

	public static com.vportal.portlet.vsitemap.model.VsmBranch updateBranch(
		long groupId, long companyId, long branchId, long parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasIcon,
		java.lang.String icon, long position, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateBranch(groupId, companyId, branchId, parentId, name,
			description, anchored, href, language, hasIcon, icon, position,
			userId);
	}

	public static com.vportal.portlet.vsitemap.model.VsmBranch updateBranch(
		com.vportal.portlet.vsitemap.model.VsmBranch branch)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateBranch(branch);
	}

	public static void deleteBranch(long branchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteBranch(branchId);
	}

	public static java.util.List getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getAll();
	}

	public static java.util.List getByG_L(long groupId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByG_L(groupId, language);
	}

	public static java.util.List getByG_L(long groupId,
		java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByG_L(groupId, language, start, end);
	}

	public static int countByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countByG_L(groupId, language);
	}

	public static java.util.List getByG_L_P(long groupId,
		java.lang.String language, long parentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByG_L_P(groupId, language, parentId);
	}

	public static java.util.List getByG_L_P(long groupId,
		java.lang.String language, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByG_L_P(groupId, language, parentId, start, end);
	}

	public static int countByG_L_P(long groupId, java.lang.String language,
		long parentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countByG_L_P(groupId, language, parentId);
	}

	public static com.vportal.portlet.vsitemap.model.VsmBranch getBranch(
		long branchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getBranch(branchId);
	}

	public static java.util.List getAllByLanguage(java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getAllByLanguage(language);
	}

	public static java.util.List getAllByHasicon(boolean hasIcon)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getAllByHasicon(hasIcon);
	}

	public static java.util.List getAllByParent(long parentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getAllByParent(parentId);
	}

	public static void addVsmBranchResources(long branchId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVsmBranchResources(branchId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addVsmBranchResources(
		com.vportal.portlet.vsitemap.model.VsmBranch branch,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVsmBranchResources(branch, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addVsmBranchResources(long branchId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVsmBranchResources(branchId, communityPermissions,
			guestPermissions);
	}

	public static void addVsmBranchResources(
		com.vportal.portlet.vsitemap.model.VsmBranch branch,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVsmBranchResources(branch, communityPermissions,
			guestPermissions);
	}

	public static void clearService() {
		_service = null;
	}

	public static VsmBranchService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VsmBranchService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VsmBranchService.class.getName(), portletClassLoader);

			_service = new VsmBranchServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VsmBranchServiceUtil.class,
				"_service");
			MethodCache.remove(VsmBranchService.class);
		}

		return _service;
	}

	public void setService(VsmBranchService service) {
		MethodCache.remove(VsmBranchService.class);

		_service = service;

		ReferenceRegistry.registerReference(VsmBranchServiceUtil.class,
			"_service");
		MethodCache.remove(VsmBranchService.class);
	}

	private static VsmBranchService _service;
}