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
 * The utility for the e d function department remote service. This utility wraps {@link com.vportal.portlet.edirectory.service.impl.EDFunctionDepartmentServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author HOAN
 * @see EDFunctionDepartmentService
 * @see com.vportal.portlet.edirectory.service.base.EDFunctionDepartmentServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.impl.EDFunctionDepartmentServiceImpl
 * @generated
 */
public class EDFunctionDepartmentServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.edirectory.service.impl.EDFunctionDepartmentServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void clearService() {
		_service = null;
	}

	public static EDFunctionDepartmentService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EDFunctionDepartmentService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					EDFunctionDepartmentService.class.getName(),
					portletClassLoader);

			_service = new EDFunctionDepartmentServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(EDFunctionDepartmentServiceUtil.class,
				"_service");
			MethodCache.remove(EDFunctionDepartmentService.class);
		}

		return _service;
	}

	public void setService(EDFunctionDepartmentService service) {
		MethodCache.remove(EDFunctionDepartmentService.class);

		_service = service;

		ReferenceRegistry.registerReference(EDFunctionDepartmentServiceUtil.class,
			"_service");
		MethodCache.remove(EDFunctionDepartmentService.class);
	}

	private static EDFunctionDepartmentService _service;
}