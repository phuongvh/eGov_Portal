/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.vimagegallery.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the t f category remote service. This utility wraps {@link com.vportal.portlet.vimagegallery.service.impl.TFCategoryServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author DucNN
 * @see TFCategoryService
 * @see com.vportal.portlet.vimagegallery.service.base.TFCategoryServiceBaseImpl
 * @see com.vportal.portlet.vimagegallery.service.impl.TFCategoryServiceImpl
 * @generated
 */
public class TFCategoryServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vimagegallery.service.impl.TFCategoryServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vimagegallery.model.TFCategory addCategory(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String image,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addCategory(groupId, companyId, plid, name, description,
			image, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategory addCategory(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String image,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addCategory(groupId, companyId, plid, name, description,
			image, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategory addCategory(
		com.vportal.portlet.vimagegallery.model.TFCategory category)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().addCategory(category);
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategory updateCategory(
		long groupId, long companyId, long id, java.lang.String name,
		java.lang.String description, java.lang.String image)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateCategory(groupId, companyId, id, name, description,
			image);
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategory updateCategory(
		com.vportal.portlet.vimagegallery.model.TFCategory category)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateCategory(category);
	}

	public static void deleteCategory(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteCategory(id);
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategory getCategory(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getCategory(id);
	}

	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> getByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByGroupId(groupId);
	}

	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroupId(groupId);
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategory findCategory(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().findCategory(id);
	}

	public static void addTFCategoryResources(long id,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTFCategoryResources(id, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addTFCategoryResources(
		com.vportal.portlet.vimagegallery.model.TFCategory tfCategory,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTFCategoryResources(tfCategory, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addTFCategoryResources(long id,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTFCategoryResources(id, communityPermissions, guestPermissions);
	}

	public static void addTFCategoryResources(
		com.vportal.portlet.vimagegallery.model.TFCategory tfCategory,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTFCategoryResources(tfCategory, communityPermissions,
			guestPermissions);
	}

	public static void clearService() {
		_service = null;
	}

	public static TFCategoryService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TFCategoryService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TFCategoryService.class.getName(), portletClassLoader);

			_service = new TFCategoryServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TFCategoryServiceUtil.class,
				"_service");
			MethodCache.remove(TFCategoryService.class);
		}

		return _service;
	}

	public void setService(TFCategoryService service) {
		MethodCache.remove(TFCategoryService.class);

		_service = service;

		ReferenceRegistry.registerReference(TFCategoryServiceUtil.class,
			"_service");
		MethodCache.remove(TFCategoryService.class);
	}

	private static TFCategoryService _service;
}