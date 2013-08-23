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
 * The utility for the vdoc d o rel remote service. This utility wraps {@link com.vportal.portlet.vdoc.service.impl.vdocDORelServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author MrEn
 * @see vdocDORelService
 * @see com.vportal.portlet.vdoc.service.base.vdocDORelServiceBaseImpl
 * @see com.vportal.portlet.vdoc.service.impl.vdocDORelServiceImpl
 * @generated
 */
public class vdocDORelServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vdoc.service.impl.vdocDORelServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static int countCategory_approving(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countCategory_approving(categoryId);
	}

	public static int countCategory_public(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countCategory_public(categoryId);
	}

	public static int countCategory_modify(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countCategory_modify(categoryId);
	}

	public static com.vportal.portlet.vdoc.model.vdocDORel addRelation(
		java.lang.String docId, java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().addRelation(docId, orgId);
	}

	public static void deleteRelation(java.lang.String docId,
		java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteRelation(docId, orgId);
	}

	public static void deleteRelByDoc(java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteRelByDoc(docId);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> getDORelByDoc(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDORelByDoc(docId);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> getDORelByOrg(
		java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDORelByOrg(orgId);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> getRelByDoc(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getRelByDoc(docId);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> getRelByField(
		java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getRelByField(orgId);
	}

	public static void clearService() {
		_service = null;
	}

	public static vdocDORelService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					vdocDORelService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					vdocDORelService.class.getName(), portletClassLoader);

			_service = new vdocDORelServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(vdocDORelServiceUtil.class,
				"_service");
			MethodCache.remove(vdocDORelService.class);
		}

		return _service;
	}

	public void setService(vdocDORelService service) {
		MethodCache.remove(vdocDORelService.class);

		_service = service;

		ReferenceRegistry.registerReference(vdocDORelServiceUtil.class,
			"_service");
		MethodCache.remove(vdocDORelService.class);
	}

	private static vdocDORelService _service;
}