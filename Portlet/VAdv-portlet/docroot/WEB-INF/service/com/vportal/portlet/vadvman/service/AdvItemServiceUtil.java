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
 * The utility for the adv item remote service. This utility wraps {@link com.vportal.portlet.vadvman.service.impl.AdvItemServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author DucNN
 * @see AdvItemService
 * @see com.vportal.portlet.vadvman.service.base.AdvItemServiceBaseImpl
 * @see com.vportal.portlet.vadvman.service.impl.AdvItemServiceImpl
 * @generated
 */
public class AdvItemServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vadvman.service.impl.AdvItemServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vadvman.model.AdvItem addItem(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String url,
		boolean isTargetBlank, java.lang.String txtMouseOver, boolean status,
		long typeId, long folderId, java.util.Date expriedDate,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addItem(groupId, companyId, plid, name, description, url,
			isTargetBlank, txtMouseOver, status, typeId, folderId, expriedDate,
			communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vadvman.model.AdvItem addItem(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String url,
		boolean isTargetBlank, java.lang.String txtMouseOver, boolean status,
		long typeId, long folderId, java.util.Date expriedDate,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addItem(groupId, companyId, plid, name, description, url,
			isTargetBlank, txtMouseOver, status, typeId, folderId, expriedDate,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public static com.vportal.portlet.vadvman.model.AdvItem updateItem(
		long itemId, long groupId, long companyId, java.lang.String name,
		java.lang.String description, java.lang.String url,
		boolean isTargetBlank, java.lang.String txtMouseOver, boolean status,
		long typeId, long folderId, java.util.Date expriedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateItem(itemId, groupId, companyId, name, description,
			url, isTargetBlank, txtMouseOver, status, typeId, folderId,
			expriedDate);
	}

	public static com.vportal.portlet.vadvman.model.AdvItem updateItem(
		com.vportal.portlet.vadvman.model.AdvItem advItem)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateItem(advItem);
	}

	public static void deleteItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteItem(itemId);
	}

	public static void deleteItembyType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteItembyType(typeId);
	}

	public static com.vportal.portlet.vadvman.model.AdvItem getItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getItem(itemId);
	}

	public static java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getAllbyType(
		long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getAllbyType(typeId);
	}

	public static java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getItemByG(groupId);
	}

	public static java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getItemByG(groupId, start, end);
	}

	public static int countItemByG(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countItemByG(groupId);
	}

	public static java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG_S(
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getItemByG_S(groupId, status);
	}

	public static java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG_S(
		long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getItemByG_S(groupId, status, start, end);
	}

	public static int countItemByG_S(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countItemByG_S(groupId, status);
	}

	public static int countItemByG_T(long groupId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countItemByG_T(groupId, typeId);
	}

	public static java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByParam(
		long groupId, java.lang.String description, long typeId, int status,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getItemByParam(groupId, description, typeId, status, begin,
			end);
	}

	public static int countItemByParam(long groupId,
		java.lang.String description, long typeId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countItemByParam(groupId, description, typeId, status);
	}

	public static void addAdvItemResources(long itemId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAdvItemResources(itemId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addAdvItemResources(
		com.vportal.portlet.vadvman.model.AdvItem item,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAdvItemResources(item, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addAdvItemResources(long itemId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAdvItemResources(itemId, communityPermissions, guestPermissions);
	}

	public static void addAdvItemResources(
		com.vportal.portlet.vadvman.model.AdvItem item,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAdvItemResources(item, communityPermissions, guestPermissions);
	}

	public static void clearService() {
		_service = null;
	}

	public static AdvItemService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AdvItemService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					AdvItemService.class.getName(), portletClassLoader);

			_service = new AdvItemServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(AdvItemServiceUtil.class,
				"_service");
			MethodCache.remove(AdvItemService.class);
		}

		return _service;
	}

	public void setService(AdvItemService service) {
		MethodCache.remove(AdvItemService.class);

		_service = service;

		ReferenceRegistry.registerReference(AdvItemServiceUtil.class, "_service");
		MethodCache.remove(AdvItemService.class);
	}

	private static AdvItemService _service;
}