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
 * The utility for the vcms logger remote service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsLoggerServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author hai
 * @see VcmsLoggerService
 * @see com.vportal.portlet.vcms.service.base.VcmsLoggerServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsLoggerServiceImpl
 * @generated
 */
public class VcmsLoggerServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsLoggerServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vcms.model.VcmsLogger log(
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().log(content);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogsByUser(
		java.lang.String userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().findLogsByUser(userId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogs(
		java.util.Date from, java.util.Date to)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().findLogs(from, to);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogersByD_A_K(
		java.lang.String keyword, int select, java.util.Date datePresent)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().findLogersByD_A_K(keyword, select, datePresent);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogersByD_A_K(
		java.lang.String keyword, int select, java.util.Date datePresent,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .findLogersByD_A_K(keyword, select, datePresent, start, end);
	}

	public static int countLogersByD_A_K(java.lang.String keyword, int select,
		java.util.Date datePresent)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countLogersByD_A_K(keyword, select, datePresent);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogs()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().findLogs();
	}

	public static int countLogs()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countLogs();
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> findLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().findLogs(start, end);
	}

	public static void removeLogs(java.util.Date from, java.util.Date to)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().removeLogs(from, to);
	}

	public static void removeLog(java.lang.String loggerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().removeLog(loggerId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VcmsLoggerService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsLoggerService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsLoggerService.class.getName(), portletClassLoader);

			_service = new VcmsLoggerServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsLoggerServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsLoggerService.class);
		}

		return _service;
	}

	public void setService(VcmsLoggerService service) {
		MethodCache.remove(VcmsLoggerService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsLoggerServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsLoggerService.class);
	}

	private static VcmsLoggerService _service;
}