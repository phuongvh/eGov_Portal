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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the vcms thread remote service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsThreadServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author hai
 * @see VcmsThreadService
 * @see com.vportal.portlet.vcms.service.base.VcmsThreadServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsThreadServiceImpl
 * @generated
 */
public class VcmsThreadServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsThreadServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vcms.model.VcmsThread addThread(
		long groupId, long companyId, long plid, java.lang.String title,
		java.lang.String description, boolean hasImage, java.lang.String image,
		java.lang.String language, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addThread(groupId, companyId, plid, title, description,
			hasImage, image, language, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vcms.model.VcmsThread addThread(
		long groupId, long companyId, long plid, java.lang.String title,
		java.lang.String description, boolean hasImage, java.lang.String image,
		java.lang.String language, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addThread(groupId, companyId, plid, title, description,
			hasImage, image, language, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public static void addThreadResources(java.lang.String threadId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addThreadResources(threadId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addThreadResources(
		com.vportal.portlet.vcms.model.VcmsThread thread,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addThreadResources(thread, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addThreadResources(java.lang.String threadId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addThreadResources(threadId, communityPermissions, guestPermissions);
	}

	public static void addThreadResources(
		com.vportal.portlet.vcms.model.VcmsThread thread,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addThreadResources(thread, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vcms.model.VcmsThread updateThread(
		java.lang.String threadId, long groupId, long companyId,
		java.lang.String title, java.lang.String description, boolean hasImage,
		java.lang.String image, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateThread(threadId, groupId, companyId, title,
			description, hasImage, image, language);
	}

	public static com.vportal.portlet.vcms.model.VcmsThread updateThread(
		com.vportal.portlet.vcms.model.VcmsThread thread)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateThread(thread);
	}

	public static void deleteThread(java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteThread(threadId);
	}

	public static com.vportal.portlet.vcms.model.VcmsThread getThread(
		java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getThread(threadId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsThread> getThreads(
		java.lang.String[] threadIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getThreads(threadIds);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsThread> getThreadsByP_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getThreadsByP_L(groupId, language);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsThread> getThreadsByP_L(
		long groupId, java.lang.String language, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getThreadsByP_L(groupId, language, begin, end);
	}

	public static int countThreadsByP_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countThreadsByP_L(groupId, language);
	}

	public static void clearService() {
		_service = null;
	}

	public static VcmsThreadService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsThreadService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsThreadService.class.getName(), portletClassLoader);

			_service = new VcmsThreadServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsThreadServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsThreadService.class);
		}

		return _service;
	}

	public void setService(VcmsThreadService service) {
		MethodCache.remove(VcmsThreadService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsThreadServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsThreadService.class);
	}

	private static VcmsThreadService _service;
}