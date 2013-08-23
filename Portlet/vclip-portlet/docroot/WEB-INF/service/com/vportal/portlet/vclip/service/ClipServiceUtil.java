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
 * The utility for the clip remote service. This utility wraps {@link com.vportal.portlet.vclip.service.impl.ClipServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author HOAN
 * @see ClipService
 * @see com.vportal.portlet.vclip.service.base.ClipServiceBaseImpl
 * @see com.vportal.portlet.vclip.service.impl.ClipServiceImpl
 * @generated
 */
public class ClipServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vclip.service.impl.ClipServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vclip.model.Clip addClip(long groupId,
		long companyId, long plid, com.vportal.portlet.vclip.model.Clip clip,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return getService()
				   .addClip(groupId, companyId, plid, clip,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public static com.vportal.portlet.vclip.model.Clip updateClip(
		long groupId, long companyId, java.lang.String clipId,
		com.vportal.portlet.vclip.model.Clip clip) throws java.lang.Exception {
		return getService().updateClip(groupId, companyId, clipId, clip);
	}

	public static void deleteClip(com.vportal.portlet.vclip.model.Clip clip)
		throws java.lang.Exception {
		getService().deleteClip(clip);
	}

	public static void deleteClip(java.lang.String clipId)
		throws java.lang.Exception {
		getService().deleteClip(clipId);
	}

	public static com.vportal.portlet.vclip.model.Clip increaseHitCount(
		java.lang.String clipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().increaseHitCount(clipId);
	}

	public static com.vportal.portlet.vclip.model.Clip increaseHitCountView(
		java.lang.String clipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().increaseHitCountView(clipId);
	}

	public static com.vportal.portlet.vclip.model.Clip findById(
		java.lang.String clipId) throws java.lang.Exception {
		return getService().findById(clipId);
	}

	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId) throws java.lang.Exception {
		return getService().findByClipTypeId(clipTypeId);
	}

	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId, int start, int end)
		throws java.lang.Exception {
		return getService().findByClipTypeId(clipTypeId, start, end);
	}

	public static int countByClipTypeId(java.lang.String clipTypeId)
		throws java.lang.Exception {
		return getService().countByClipTypeId(clipTypeId);
	}

	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findClip(
		com.vportal.portlet.vclip.model.Clip clip) throws java.lang.Exception {
		return getService().findClip(clip);
	}

	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findClip(
		com.vportal.portlet.vclip.model.Clip clip, int start, int end)
		throws java.lang.Exception {
		return getService().findClip(clip, start, end);
	}

	public static int countClip(com.vportal.portlet.vclip.model.Clip clip)
		throws java.lang.Exception {
		return getService().countClip(clip);
	}

	public static java.util.List<com.vportal.portlet.vclip.model.Clip> searchClip(
		java.lang.String textSearch, java.lang.String clipTypeId)
		throws java.lang.Exception {
		return getService().searchClip(textSearch, clipTypeId);
	}

	public static java.util.List<com.vportal.portlet.vclip.model.Clip> getAll()
		throws java.lang.Exception {
		return getService().getAll();
	}

	public static java.util.List<com.vportal.portlet.vclip.model.Clip> getAll(
		int begin, int end) throws java.lang.Exception {
		return getService().getAll(begin, end);
	}

	public static int countAll() throws java.lang.Exception {
		return getService().countAll();
	}

	public static boolean hasParent(java.lang.String clipTypeId)
		throws java.lang.Exception {
		return getService().hasParent(clipTypeId);
	}

	public static com.vportal.portlet.vclip.model.Clip getFirst()
		throws java.lang.Exception {
		return getService().getFirst();
	}

	public static com.vportal.portlet.vclip.model.Clip getByClipTypeId(
		java.lang.String clipTypeId) throws java.lang.Exception {
		return getService().getByClipTypeId(clipTypeId);
	}

	public static void addClipResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addClipResources(articleId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addClipResources(
		com.vportal.portlet.vclip.model.Clip article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addClipResources(article, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addClipResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addClipResources(articleId, communityPermissions, guestPermissions);
	}

	public static void addClipResources(
		com.vportal.portlet.vclip.model.Clip article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addClipResources(article, communityPermissions, guestPermissions);
	}

	public static void clearService() {
		_service = null;
	}

	public static ClipService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ClipService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ClipService.class.getName(), portletClassLoader);

			_service = new ClipServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ClipServiceUtil.class,
				"_service");
			MethodCache.remove(ClipService.class);
		}

		return _service;
	}

	public void setService(ClipService service) {
		MethodCache.remove(ClipService.class);

		_service = service;

		ReferenceRegistry.registerReference(ClipServiceUtil.class, "_service");
		MethodCache.remove(ClipService.class);
	}

	private static ClipService _service;
}