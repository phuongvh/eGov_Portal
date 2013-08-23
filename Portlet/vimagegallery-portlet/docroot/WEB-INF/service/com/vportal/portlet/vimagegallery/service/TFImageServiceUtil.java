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
 * The utility for the t f image remote service. This utility wraps {@link com.vportal.portlet.vimagegallery.service.impl.TFImageServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author DucNN
 * @see TFImageService
 * @see com.vportal.portlet.vimagegallery.service.base.TFImageServiceBaseImpl
 * @see com.vportal.portlet.vimagegallery.service.impl.TFImageServiceImpl
 * @generated
 */
public class TFImageServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vimagegallery.service.impl.TFImageServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vimagegallery.model.TFImage addImage(
		long groupId, long companyId, long plid, long categoryId,
		java.lang.String name, java.lang.String description,
		java.lang.String image, boolean isShow,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addImage(groupId, companyId, plid, categoryId, name,
			description, image, isShow, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage addImage(
		long groupId, long companyId, long plid, long categoryId,
		java.lang.String name, java.lang.String description,
		java.lang.String image, boolean isShow,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addImage(groupId, companyId, plid, categoryId, name,
			description, image, isShow, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage addImage(
		com.vportal.portlet.vimagegallery.model.TFImage image)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().addImage(image);
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage updateImage(
		long groupId, long companyId, long plid, long id, long categoryId,
		java.lang.String name, java.lang.String description,
		java.lang.String image, boolean isShow)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateImage(groupId, companyId, plid, id, categoryId, name,
			description, image, isShow);
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage updateImage(
		com.vportal.portlet.vimagegallery.model.TFImage image)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateImage(image);
	}

	public static void deleteImage(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteImage(id);
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage findImagebyID(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findImagebyID(id);
	}

	public static com.vportal.portlet.vimagegallery.model.TFImage getImage(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getImage(id);
	}

	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> findAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().findAll();
	}

	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByGroupId(groupId);
	}

	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByGroupId(
		long groupId, int start, int end)
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

	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByG_C(groupId, categoryId, start, end);
	}

	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByG_C(groupId, categoryId);
	}

	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByG_I(
		long groupId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByG_I(groupId, isShow, start, end);
	}

	public static int countByG_I(long groupId, boolean isShow)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countByG_I(groupId, isShow);
	}

	public static int countByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countByG_C(groupId, categoryId);
	}

	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByG_C_I(
		long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByG_C_I(groupId, categoryId, isShow);
	}

	public static java.util.List<com.vportal.portlet.vimagegallery.model.TFImage> getByG_C_I(
		long groupId, long categoryId, boolean isShow, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByG_C_I(groupId, categoryId, isShow, start, end);
	}

	public static int countByG_C_I(long groupId, long categoryId, boolean isShow)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countByG_C_I(groupId, categoryId, isShow);
	}

	public static void addTFImageResources(long id,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTFImageResources(id, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addTFImageResources(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTFImageResources(tfImage, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addTFImageResources(long id,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTFImageResources(id, communityPermissions, guestPermissions);
	}

	public static void addTFImageResources(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addTFImageResources(tfImage, communityPermissions, guestPermissions);
	}

	public static void clearService() {
		_service = null;
	}

	public static TFImageService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TFImageService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TFImageService.class.getName(), portletClassLoader);

			_service = new TFImageServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TFImageServiceUtil.class,
				"_service");
			MethodCache.remove(TFImageService.class);
		}

		return _service;
	}

	public void setService(TFImageService service) {
		MethodCache.remove(TFImageService.class);

		_service = service;

		ReferenceRegistry.registerReference(TFImageServiceUtil.class, "_service");
		MethodCache.remove(TFImageService.class);
	}

	private static TFImageService _service;
}