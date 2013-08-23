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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the vdoc org remote service. This utility wraps {@link com.vportal.portlet.vdoc.service.impl.vdocOrgServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author MrEn
 * @see vdocOrgService
 * @see com.vportal.portlet.vdoc.service.base.vdocOrgServiceBaseImpl
 * @see com.vportal.portlet.vdoc.service.impl.vdocOrgServiceImpl
 * @generated
 */
public class vdocOrgServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vdoc.service.impl.vdocOrgServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vdoc.model.vdocOrg addOrg(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		java.lang.String address, java.lang.String phone, boolean statusOrg,
		int position, java.lang.String fax, java.lang.String listparent,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addOrg(groupId, userId, language, parentId, name,
			description, address, phone, statusOrg, position, fax, listparent,
			communityPermissions, guestPermissions, themeDisplay);
	}

	public static com.vportal.portlet.vdoc.model.vdocOrg addOrg(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		java.lang.String address, java.lang.String phone, boolean statusOrg,
		int position, java.lang.String fax, java.lang.String listparent,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addOrg(groupId, userId, language, parentId, name,
			description, address, phone, statusOrg, position, fax, listparent,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions, themeDisplay);
	}

	public static com.vportal.portlet.vdoc.model.vdocOrg updateOrg(
		com.vportal.portlet.vdoc.model.vdocOrg org, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		return getService().updateOrg(org, userId);
	}

	public static com.vportal.portlet.vdoc.model.vdocOrg updateOrg(
		java.lang.String orgId, long groupId, java.lang.String language,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, java.lang.String address,
		java.lang.String phone, boolean statusOrg, int position,
		java.lang.String fax, java.lang.String listparent, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		return getService()
				   .updateOrg(orgId, groupId, language, parentId, name,
			description, address, phone, statusOrg, position, fax, listparent,
			userId);
	}

	public static void deleteOrg(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.DeleteOrgException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		getService().deleteOrg(orgId);
	}

	public static com.vportal.portlet.vdoc.model.vdocOrg getOrg(
		java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		return getService().getOrg(orgId);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByParentId(
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrgByParentId(parentId);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrgByG_L(groupId, language);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L(
		long groupId, java.lang.String language, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrgByG_L(groupId, language, begin, end);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrgByG_L_P(groupId, language, parentId);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getOrgByG_L_P(groupId, language, parentId, begin, end);
	}

	public static int countOrgByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countOrgByG_L(groupId, language);
	}

	public static int countOrgByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countOrgByG_L_P(groupId, language, parentId);
	}

	public static void addEntryResources(long entryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(entryId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocOrg entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(entry, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addEntryResources(long entryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(entryId, communityPermissions, guestPermissions);
	}

	public static void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocOrg entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(entry, communityPermissions, guestPermissions);
	}

	public static void clearService() {
		_service = null;
	}

	public static vdocOrgService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					vdocOrgService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					vdocOrgService.class.getName(), portletClassLoader);

			_service = new vdocOrgServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(vdocOrgServiceUtil.class,
				"_service");
			MethodCache.remove(vdocOrgService.class);
		}

		return _service;
	}

	public void setService(vdocOrgService service) {
		MethodCache.remove(vdocOrgService.class);

		_service = service;

		ReferenceRegistry.registerReference(vdocOrgServiceUtil.class, "_service");
		MethodCache.remove(vdocOrgService.class);
	}

	private static vdocOrgService _service;
}