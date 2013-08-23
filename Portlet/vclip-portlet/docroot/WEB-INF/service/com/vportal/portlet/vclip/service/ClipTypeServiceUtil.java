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

package com.vportal.portlet.vclip.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the clip type remote service. This utility wraps {@link com.vportal.portlet.vclip.service.impl.ClipTypeServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author HOAN
 * @see ClipTypeService
 * @see com.vportal.portlet.vclip.service.base.ClipTypeServiceBaseImpl
 * @see com.vportal.portlet.vclip.service.impl.ClipTypeServiceImpl
 * @generated
 */
public class ClipTypeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vclip.service.impl.ClipTypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vclip.model.ClipType addClipType(
		long groupId, long companyId, long plid,
		com.vportal.portlet.vclip.model.ClipType clipType,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return getService()
				   .addClipType(groupId, companyId, plid, clipType,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public static com.vportal.portlet.vclip.model.ClipType updateClipType(
		long groupId, long companyId, java.lang.String clipTypeId,
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		return getService()
				   .updateClipType(groupId, companyId, clipTypeId, clipType);
	}

	public static void deleteClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		getService().deleteClipType(clipType);
	}

	public static void deleteClipType(java.lang.String clipTypeId)
		throws java.lang.Exception {
		getService().deleteClipType(clipTypeId);
	}

	public static com.vportal.portlet.vclip.model.ClipType findById(
		java.lang.String clipTypeId) throws java.lang.Exception {
		return getService().findById(clipTypeId);
	}

	public static java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll()
		throws java.lang.Exception {
		return getService().findAll();
	}

	public static java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll(
		int begin, int end) throws java.lang.Exception {
		return getService().findAll(begin, end);
	}

	public static int countAll() throws java.lang.Exception {
		return getService().countAll();
	}

	public static java.util.List<com.vportal.portlet.vclip.model.ClipType> getLanguage(
		java.lang.String language, boolean active) throws java.lang.Exception {
		return getService().getLanguage(language, active);
	}

	public static java.util.List<com.vportal.portlet.vclip.model.ClipType> findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		return getService().findClipType(clipType);
	}

	public static java.util.List<com.vportal.portlet.vclip.model.ClipType> findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType, int start, int end)
		throws java.lang.Exception {
		return getService().findClipType(clipType, start, end);
	}

	public static int countClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		return getService().countClipType(clipType);
	}

	public static com.vportal.portlet.vclip.model.ClipType getFirst()
		throws java.lang.Exception {
		return getService().getFirst();
	}

	public static void addClipTypeResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addClipTypeResources(articleId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addClipTypeResources(
		com.vportal.portlet.vclip.model.ClipType article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addClipTypeResources(article, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addClipTypeResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addClipTypeResources(articleId, communityPermissions,
			guestPermissions);
	}

	public static void addClipTypeResources(
		com.vportal.portlet.vclip.model.ClipType article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addClipTypeResources(article, communityPermissions,
			guestPermissions);
	}

	public static void clearService() {
		_service = null;
	}

	public static ClipTypeService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ClipTypeService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ClipTypeService.class.getName(), portletClassLoader);

			_service = new ClipTypeServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ClipTypeServiceUtil.class,
				"_service");
			MethodCache.remove(ClipTypeService.class);
		}

		return _service;
	}

	public void setService(ClipTypeService service) {
		MethodCache.remove(ClipTypeService.class);

		_service = service;

		ReferenceRegistry.registerReference(ClipTypeServiceUtil.class,
			"_service");
		MethodCache.remove(ClipTypeService.class);
	}

	private static ClipTypeService _service;
}