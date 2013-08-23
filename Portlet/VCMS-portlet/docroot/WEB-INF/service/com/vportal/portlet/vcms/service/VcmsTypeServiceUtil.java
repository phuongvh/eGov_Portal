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
 * The utility for the vcms type remote service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsTypeServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author hai
 * @see VcmsTypeService
 * @see com.vportal.portlet.vcms.service.base.VcmsTypeServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsTypeServiceImpl
 * @generated
 */
public class VcmsTypeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsTypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vcms.model.VcmsType addType(
		long groupId, long companyId, long plid, java.lang.String code,
		java.lang.String name, java.lang.String description,
		java.lang.String language, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addType(groupId, companyId, plid, code, name, description,
			language, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vcms.model.VcmsType addType(
		long groupId, long companyId, long plid, java.lang.String code,
		java.lang.String name, java.lang.String description,
		java.lang.String language, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addType(groupId, companyId, plid, code, name, description,
			language, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public static void addTypeResources(java.lang.String TypeId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService()
			.addTypeResources(TypeId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addTypeResources(
		com.vportal.portlet.vcms.model.VcmsType Type,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTypeResources(Type, addCommunityPermissions, addGuestPermissions);
	}

	public static void addTypeResources(java.lang.String TypeId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService()
			.addTypeResources(TypeId, communityPermissions, guestPermissions);
	}

	public static void addTypeResources(
		com.vportal.portlet.vcms.model.VcmsType Type,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTypeResources(Type, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vcms.model.VcmsType updateType(
		java.lang.String typeId, long groupId, long companyId,
		java.lang.String code, java.lang.String name,
		java.lang.String description, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateType(typeId, groupId, companyId, code, name,
			description, language);
	}

	public static void deleteType(java.lang.String typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteType(typeId);
	}

	public static void deleteTypes(java.lang.String[] typeIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteTypes(typeIds);
	}

	public static com.vportal.portlet.vcms.model.VcmsType getType(
		java.lang.String typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getType(typeId);
	}

	public static com.vportal.portlet.vcms.model.VcmsType getTypeByS_C(
		long groupId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getTypeByS_C(groupId, code);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsType> getTypesByS_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getTypesByS_L(groupId, language);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsType> getTypesByS_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getTypesByS_L(groupId, language, start, end);
	}

	public static int countTypesByS_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countTypesByS_L(groupId, language);
	}

	public static void clearService() {
		_service = null;
	}

	public static VcmsTypeService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsTypeService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsTypeService.class.getName(), portletClassLoader);

			_service = new VcmsTypeServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsTypeServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsTypeService.class);
		}

		return _service;
	}

	public void setService(VcmsTypeService service) {
		MethodCache.remove(VcmsTypeService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsTypeServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsTypeService.class);
	}

	private static VcmsTypeService _service;
}