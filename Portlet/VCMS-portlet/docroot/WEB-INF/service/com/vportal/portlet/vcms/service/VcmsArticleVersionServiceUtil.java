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
 * The utility for the vcms article version remote service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsArticleVersionServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author hai
 * @see VcmsArticleVersionService
 * @see com.vportal.portlet.vcms.service.base.VcmsArticleVersionServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsArticleVersionServiceImpl
 * @generated
 */
public class VcmsArticleVersionServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsArticleVersionServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vcms.model.VcmsArticleVersion addVersion(
		long groupId, java.lang.String language, long companyId,
		java.lang.String articleId, java.lang.String typeIds, long status,
		java.lang.String versionName, java.lang.String title,
		java.lang.String lead, java.lang.String content, long userHit,
		boolean hasImage, java.lang.String imageTitle, java.lang.String image,
		java.lang.String author, java.lang.String source, boolean discussible,
		boolean hasPoll, java.lang.String pollId, java.util.Date effectiveDate,
		java.util.Date expireDate, boolean sticky, boolean stickyNeverExpired,
		java.util.Date stickyExpireDate, boolean hasAttach)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addVersion(groupId, language, companyId, articleId,
			typeIds, status, versionName, title, lead, content, userHit,
			hasImage, imageTitle, image, author, source, discussible, hasPoll,
			pollId, effectiveDate, expireDate, sticky, stickyNeverExpired,
			stickyExpireDate, hasAttach);
	}

	public static int countVersionByArticleId(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countVersionByArticleId(articleId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleVersion> listVersionByArticleId(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().listVersionByArticleId(articleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VcmsArticleVersionService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsArticleVersionService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsArticleVersionService.class.getName(),
					portletClassLoader);

			_service = new VcmsArticleVersionServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsArticleVersionServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsArticleVersionService.class);
		}

		return _service;
	}

	public void setService(VcmsArticleVersionService service) {
		MethodCache.remove(VcmsArticleVersionService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsArticleVersionServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsArticleVersionService.class);
	}

	private static VcmsArticleVersionService _service;
}