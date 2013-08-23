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

package com.vportal.portlet.vadvman.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the adv type remote service. This utility wraps {@link com.vportal.portlet.vadvman.service.impl.AdvTypeServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author DucNN
 * @see AdvTypeService
 * @see com.vportal.portlet.vadvman.service.base.AdvTypeServiceBaseImpl
 * @see com.vportal.portlet.vadvman.service.impl.AdvTypeServiceImpl
 * @generated
 */
public class AdvTypeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vadvman.service.impl.AdvTypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vadvman.model.AdvType addType(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addType(groupId, companyId, plid, name, description,
			communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vadvman.model.AdvType addType(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addType(groupId, companyId, plid, name, description,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public static com.vportal.portlet.vadvman.model.AdvType updateType(
		long typeId, long groupId, long companyId, long plid,
		java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateType(typeId, groupId, companyId, plid, name,
			description);
	}

	public static void deleteType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteType(typeId);
	}

	public static void deleteType(
		com.vportal.portlet.vadvman.model.AdvType type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteType(type);
	}

	public static com.vportal.portlet.vadvman.model.AdvType getType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getType(typeId);
	}

	public static int getItemCount(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getItemCount(typeId);
	}

	public static java.util.List<com.vportal.portlet.vadvman.model.AdvType> getTypeByG(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getTypeByG(groupId);
	}

	public static java.util.List<com.vportal.portlet.vadvman.model.AdvType> getTypeByG(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getTypeByG(groupId, start, end);
	}

	public static int countTypeByG(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countTypeByG(groupId);
	}

	public static void addAdvTypeResources(long typeId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAdvTypeResources(typeId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addAdvTypeResources(
		com.vportal.portlet.vadvman.model.AdvType type,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAdvTypeResources(type, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addAdvTypeResources(long typeId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAdvTypeResources(typeId, communityPermissions, guestPermissions);
	}

	public static void addAdvTypeResources(
		com.vportal.portlet.vadvman.model.AdvType type,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAdvTypeResources(type, communityPermissions, guestPermissions);
	}

	public static void clearService() {
		_service = null;
	}

	public static AdvTypeService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AdvTypeService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					AdvTypeService.class.getName(), portletClassLoader);

			_service = new AdvTypeServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(AdvTypeServiceUtil.class,
				"_service");
			MethodCache.remove(AdvTypeService.class);
		}

		return _service;
	}

	public void setService(AdvTypeService service) {
		MethodCache.remove(AdvTypeService.class);

		_service = service;

		ReferenceRegistry.registerReference(AdvTypeServiceUtil.class, "_service");
		MethodCache.remove(AdvTypeService.class);
	}

	private static AdvTypeService _service;
}