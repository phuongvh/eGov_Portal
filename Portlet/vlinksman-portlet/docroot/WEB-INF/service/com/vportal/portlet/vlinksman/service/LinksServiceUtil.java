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
 * The utility for the links remote service. This utility wraps {@link com.vportal.portlet.vlinksman.service.impl.LinksServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LongLH
 * @see LinksService
 * @see com.vportal.portlet.vlinksman.service.base.LinksServiceBaseImpl
 * @see com.vportal.portlet.vlinksman.service.impl.LinksServiceImpl
 * @generated
 */
public class LinksServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vlinksman.service.impl.LinksServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vlinksman.model.Links addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, long position, long userId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addLinks(groupId, companyId, plid, linkgroupId, name,
			description, url, position, userId, communityPermissions,
			guestPermissions);
	}

	public static com.vportal.portlet.vlinksman.model.Links addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, long position, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addLinks(groupId, companyId, plid, linkgroupId, name,
			description, url, position, userId, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vlinksman.model.Links addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, int position, long userId,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addLinks(groupId, companyId, plid, linkgroupId, name,
			description, url, position, userId, hasImage, isTargetBlank,
			imageName, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vlinksman.model.Links addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, int position, long userId,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addLinks(groupId, companyId, plid, linkgroupId, name,
			description, url, position, userId, hasImage, isTargetBlank,
			imageName, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vlinksman.model.Links addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, int position, long userId,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName, long folderId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addLinks(groupId, companyId, plid, linkgroupId, name,
			description, url, position, userId, hasImage, isTargetBlank,
			imageName, folderId, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vlinksman.model.Links addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, int position, long userId,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName, long folderId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addLinks(groupId, companyId, plid, linkgroupId, name,
			description, url, position, userId, hasImage, isTargetBlank,
			imageName, folderId, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vlinksman.model.Links addLinks(
		com.vportal.portlet.vlinksman.model.Links link, long plid,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return getService()
				   .addLinks(link, plid, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vlinksman.model.Links updateLinks(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			java.rmi.RemoteException {
		return getService().updateLinks(link);
	}

	public static com.vportal.portlet.vlinksman.model.Links updateLinks(
		long linkId, long groupId, long companyId, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, long position)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateLinks(linkId, groupId, companyId, linkgroupId, name,
			description, url, position);
	}

	public static com.vportal.portlet.vlinksman.model.Links updateLink(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateLink(link);
	}

	public static com.vportal.portlet.vlinksman.model.Links updateLinks(
		long linkId, long groupId, long companyId, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, long position, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateLinks(linkId, groupId, companyId, linkgroupId, name,
			description, url, position, hasImage, isTargetBlank, imageName);
	}

	public static com.vportal.portlet.vlinksman.model.Links updateLinks(
		long linkId, long groupId, long companyId, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, long position, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName,
		long folderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateLinks(linkId, groupId, companyId, linkgroupId, name,
			description, url, position, hasImage, isTargetBlank, imageName,
			folderId);
	}

	public static com.vportal.portlet.vlinksman.model.Links updateLink2(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateLink2(link);
	}

	public static com.vportal.portlet.vlinksman.model.Links updateLink3(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateLink3(link);
	}

	public static void deleteLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteLink(linkId);
	}

	public static java.util.List getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getAll();
	}

	public static java.util.List getByLinkGroupId(long linkGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByLinkGroupId(linkGroupId);
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

	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countByGroupId(groupId);
	}

	public static java.util.List getByLinkG_GL(long groupId, long linkGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByLinkG_GL(groupId, linkGroupId);
	}

	public static java.util.List getByLinkG_GL(long groupId, long linkGroupId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByLinkG_GL(groupId, linkGroupId, start, end);
	}

	public static com.vportal.portlet.vlinksman.model.Links getLinks(
		long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getLinks(linkId);
	}

	public static void addLinksResources(long linkId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLinksResources(linkId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addLinksResources(
		com.vportal.portlet.vlinksman.model.Links link,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLinksResources(link, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addLinksResources(long linkId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLinksResources(linkId, communityPermissions, guestPermissions);
	}

	public static void addLinksResources(
		com.vportal.portlet.vlinksman.model.Links link,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLinksResources(link, communityPermissions, guestPermissions);
	}

	public static void _validate(java.lang.String name, java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService()._validate(name, url);
	}

	public static void clearService() {
		_service = null;
	}

	public static LinksService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LinksService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LinksService.class.getName(), portletClassLoader);

			_service = new LinksServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LinksServiceUtil.class,
				"_service");
			MethodCache.remove(LinksService.class);
		}

		return _service;
	}

	public void setService(LinksService service) {
		MethodCache.remove(LinksService.class);

		_service = service;

		ReferenceRegistry.registerReference(LinksServiceUtil.class, "_service");
		MethodCache.remove(LinksService.class);
	}

	private static LinksService _service;
}