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
 * The utility for the vdoc field remote service. This utility wraps {@link com.vportal.portlet.vdoc.service.impl.vdocFieldServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author MrEn
 * @see vdocFieldService
 * @see com.vportal.portlet.vdoc.service.base.vdocFieldServiceBaseImpl
 * @see com.vportal.portlet.vdoc.service.impl.vdocFieldServiceImpl
 * @generated
 */
public class vdocFieldServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vdoc.service.impl.vdocFieldServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vdoc.model.vdocField addField(
		long groupId, long userId, java.lang.String language,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean statusField, int position,
		java.lang.String listparent, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addField(groupId, userId, language, parentId, name,
			description, statusField, position, listparent,
			communityPermissions, guestPermissions, themeDisplay);
	}

	public static com.vportal.portlet.vdoc.model.vdocField addField(
		long groupId, long userId, java.lang.String language,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean statusField, int position,
		java.lang.String listparent, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addField(groupId, userId, language, parentId, name,
			description, statusField, position, listparent,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions, themeDisplay);
	}

	public static com.vportal.portlet.vdoc.model.vdocField updateField(
		com.vportal.portlet.vdoc.model.vdocField field, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getService().updateField(field, userId);
	}

	public static com.vportal.portlet.vdoc.model.vdocField updateField(
		java.lang.String fieldId, long groupId, java.lang.String language,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean statusField, int position,
		java.lang.String listparent, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getService()
				   .updateField(fieldId, groupId, language, parentId, name,
			description, statusField, position, listparent, userId);
	}

	public static void deleteField(java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteField(fieldId);
	}

	public static com.vportal.portlet.vdoc.model.vdocField getField(
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		return getService().getField(fieldId);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByParentId(
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFieldByParentId(parentId);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFieldByG_L(groupId, language);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFieldByG_L_P(groupId, language, parentId);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getFieldByG_L_P(groupId, language, parentId, begin, end);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L(
		long groupId, java.lang.String language, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFieldByG_L(groupId, language, begin, end);
	}

	public static int countFieldByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countFieldByG_L(groupId, language);
	}

	public static int countFieldByG_L_P(long groupId,
		java.lang.String language, java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countFieldByG_L_P(groupId, language, parentId);
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
		com.vportal.portlet.vdoc.model.vdocField entry,
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
		com.vportal.portlet.vdoc.model.vdocField entry,
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

	public static vdocFieldService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					vdocFieldService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					vdocFieldService.class.getName(), portletClassLoader);

			_service = new vdocFieldServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(vdocFieldServiceUtil.class,
				"_service");
			MethodCache.remove(vdocFieldService.class);
		}

		return _service;
	}

	public void setService(vdocFieldService service) {
		MethodCache.remove(vdocFieldService.class);

		_service = service;

		ReferenceRegistry.registerReference(vdocFieldServiceUtil.class,
			"_service");
		MethodCache.remove(vdocFieldService.class);
	}

	private static vdocFieldService _service;
}