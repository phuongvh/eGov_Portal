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

package com.vportal.portlet.vlinksman.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the link group remote service. This utility wraps {@link com.vportal.portlet.vlinksman.service.impl.LinkGroupServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LongLH
 * @see LinkGroupService
 * @see com.vportal.portlet.vlinksman.service.base.LinkGroupServiceBaseImpl
 * @see com.vportal.portlet.vlinksman.service.impl.LinkGroupServiceImpl
 * @generated
 */
public class LinkGroupServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vlinksman.service.impl.LinkGroupServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vlinksman.model.LinkGroup addLinkGroup(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, long userId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addLinkGroup(groupId, companyId, plid, name, description,
			userId, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vlinksman.model.LinkGroup addLinkGroup(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addLinkGroup(groupId, companyId, plid, name, description,
			userId, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vlinksman.model.LinkGroup updateLinkGroup(
		long linkgroupId, long groupId, long companyId, java.lang.String name,
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateLinkGroup(linkgroupId, groupId, companyId, name,
			description);
	}

	public static void deleteLinkGroup(long linkgroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteLinkGroup(linkgroupId);
	}

	public static java.util.List getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getAll();
	}

	public static java.util.List getByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByGroupId(groupId);
	}

	public static java.util.List getByGroupId(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByGroupId(groupId, start, end);
	}

	public static com.vportal.portlet.vlinksman.model.LinkGroup getLinkGroup(
		long linkgroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getLinkGroup(linkgroupId);
	}

	public static void addLinkGroupResources(long linkgroupId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLinkGroupResources(linkgroupId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addLinkGroupResources(
		com.vportal.portlet.vlinksman.model.LinkGroup linkGroup,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLinkGroupResources(linkGroup, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addLinkGroupResources(long linkgroupId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLinkGroupResources(linkgroupId, communityPermissions,
			guestPermissions);
	}

	public static void addLinkGroupResources(
		com.vportal.portlet.vlinksman.model.LinkGroup linkGroup,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLinkGroupResources(linkGroup, communityPermissions,
			guestPermissions);
	}

	public static void clearService() {
		_service = null;
	}

	public static LinkGroupService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LinkGroupService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LinkGroupService.class.getName(), portletClassLoader);

			_service = new LinkGroupServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LinkGroupServiceUtil.class,
				"_service");
			MethodCache.remove(LinkGroupService.class);
		}

		return _service;
	}

	public void setService(LinkGroupService service) {
		MethodCache.remove(LinkGroupService.class);

		_service = service;

		ReferenceRegistry.registerReference(LinkGroupServiceUtil.class,
			"_service");
		MethodCache.remove(LinkGroupService.class);
	}

	private static LinkGroupService _service;
}