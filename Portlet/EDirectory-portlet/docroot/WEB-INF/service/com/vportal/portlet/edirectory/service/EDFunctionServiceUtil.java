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

package com.vportal.portlet.edirectory.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the e d function remote service. This utility wraps {@link com.vportal.portlet.edirectory.service.impl.EDFunctionServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author HOAN
 * @see EDFunctionService
 * @see com.vportal.portlet.edirectory.service.base.EDFunctionServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.impl.EDFunctionServiceImpl
 * @generated
 */
public class EDFunctionServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.edirectory.service.impl.EDFunctionServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.edirectory.model.EDFunction addFunction(
		com.vportal.portlet.edirectory.model.EDFunction function,
		java.lang.String languageId, long userId, long plid,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addFunction(function, languageId, userId, plid,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public static com.vportal.portlet.edirectory.model.EDFunction updateFunction(
		com.vportal.portlet.edirectory.model.EDFunction function,
		long functionId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			java.rmi.RemoteException {
		return getService().updateFunction(function, functionId, groupId);
	}

	public static void removeFunction(long functionId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			java.rmi.RemoteException {
		getService().removeFunction(functionId, groupId);
	}

	public static void addFunctionResources(long functionId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addFunctionResources(functionId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addFunctionResources(
		com.vportal.portlet.edirectory.model.EDFunction function,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addFunctionResources(function, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addFunctionResources(long functionId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addFunctionResources(functionId, communityPermissions,
			guestPermissions);
	}

	public static void addFunctionResources(
		com.vportal.portlet.edirectory.model.EDFunction function,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addFunctionResources(function, communityPermissions,
			guestPermissions);
	}

	public static void clearService() {
		_service = null;
	}

	public static EDFunctionService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EDFunctionService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					EDFunctionService.class.getName(), portletClassLoader);

			_service = new EDFunctionServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(EDFunctionServiceUtil.class,
				"_service");
			MethodCache.remove(EDFunctionService.class);
		}

		return _service;
	}

	public void setService(EDFunctionService service) {
		MethodCache.remove(EDFunctionService.class);

		_service = service;

		ReferenceRegistry.registerReference(EDFunctionServiceUtil.class,
			"_service");
		MethodCache.remove(EDFunctionService.class);
	}

	private static EDFunctionService _service;
}