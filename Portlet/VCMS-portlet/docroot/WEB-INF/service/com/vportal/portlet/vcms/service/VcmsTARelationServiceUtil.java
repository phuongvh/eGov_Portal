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
 * The utility for the vcms t a relation remote service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsTARelationServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author hai
 * @see VcmsTARelationService
 * @see com.vportal.portlet.vcms.service.base.VcmsTARelationServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsTARelationServiceImpl
 * @generated
 */
public class VcmsTARelationServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsTARelationServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vcms.model.VcmsTARelation addRelation(
		java.lang.String threadId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().addRelation(threadId, articleId);
	}

	public static void deleteRelation(java.lang.String threadId,
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteRelation(threadId, articleId);
	}

	public static void deleteRelationsByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteRelationsByArticle(articleId);
	}

	public static void deleteRelationsByThread(java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteRelationsByThread(threadId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> getRelationsByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getRelationsByArticle(articleId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> getRelationsByThread(
		java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getRelationsByThread(threadId);
	}

	public static int countArticlesOfThread(java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countArticlesOfThread(threadId);
	}

	public static int countRelationByThread(java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countRelationByThread(threadId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VcmsTARelationService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsTARelationService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsTARelationService.class.getName(), portletClassLoader);

			_service = new VcmsTARelationServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsTARelationServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsTARelationService.class);
		}

		return _service;
	}

	public void setService(VcmsTARelationService service) {
		MethodCache.remove(VcmsTARelationService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsTARelationServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsTARelationService.class);
	}

	private static VcmsTARelationService _service;
}