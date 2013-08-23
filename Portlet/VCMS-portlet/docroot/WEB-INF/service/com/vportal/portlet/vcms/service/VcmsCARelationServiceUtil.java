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
 * The utility for the vcms c a relation remote service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsCARelationServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author hai
 * @see VcmsCARelationService
 * @see com.vportal.portlet.vcms.service.base.VcmsCARelationServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsCARelationServiceImpl
 * @generated
 */
public class VcmsCARelationServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsCARelationServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vcms.model.VcmsCARelation addRelation(
		java.lang.String categoryId, java.lang.String articleId, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().addRelation(categoryId, articleId, statusId);
	}

	public static void deleteRelation(java.lang.String categoryId,
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteRelation(categoryId, articleId);
	}

	public static void deleteRelationsByCategory(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteRelationsByCategory(categoryId);
	}

	public static void deleteRelationsByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteRelationsByArticle(articleId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> getRelationsByCategory(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getRelationsByCategory(categoryId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> getRelationsByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getRelationsByArticle(articleId);
	}

	public static int countArticlesOfCategory(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countArticlesOfCategory(categoryId);
	}

	public static com.vportal.portlet.vcms.model.VcmsCARelation findRelationsByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().findRelationsByArticle(articleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VcmsCARelationService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsCARelationService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsCARelationService.class.getName(), portletClassLoader);

			_service = new VcmsCARelationServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsCARelationServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsCARelationService.class);
		}

		return _service;
	}

	public void setService(VcmsCARelationService service) {
		MethodCache.remove(VcmsCARelationService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsCARelationServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsCARelationService.class);
	}

	private static VcmsCARelationService _service;
}