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

package com.vportal.portlet.vcalendar.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the v file remote service. This utility wraps {@link com.vportal.portlet.vcalendar.service.impl.VFileServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LongLH
 * @see VFileService
 * @see com.vportal.portlet.vcalendar.service.base.VFileServiceBaseImpl
 * @see com.vportal.portlet.vcalendar.service.impl.VFileServiceImpl
 * @generated
 */
public class VFileServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcalendar.service.impl.VFileServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vcalendar.model.VFile addVFile(
		java.lang.String fullname, java.lang.String phone,
		java.lang.String address, java.lang.String position,
		java.util.Date birthday, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addVFile(fullname, phone, address, position, birthday,
			status);
	}

	public static com.vportal.portlet.vcalendar.model.VFile updateVFile(
		long fileId, java.lang.String fullname, java.lang.String phone,
		java.lang.String address, java.lang.String position,
		java.util.Date birthday, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException {
		return getService()
				   .updateVFile(fileId, fullname, phone, address, position,
			birthday, status);
	}

	public static com.vportal.portlet.vcalendar.model.VFile deleteVFile(
		long fileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException {
		return getService().deleteVFile(fileId);
	}

	public static com.vportal.portlet.vcalendar.model.VFile findById(
		long fileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException {
		return getService().findById(fileId);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByAll();
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByAll(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByAll(begin, end);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByGroupId(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupId(status);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByGroupId(
		int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupId(status, begin, end);
	}

	public static int countByGroupId(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroupId(status);
	}

	public static void clearService() {
		_service = null;
	}

	public static VFileService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VFileService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VFileService.class.getName(), portletClassLoader);

			_service = new VFileServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VFileServiceUtil.class,
				"_service");
			MethodCache.remove(VFileService.class);
		}

		return _service;
	}

	public void setService(VFileService service) {
		MethodCache.remove(VFileService.class);

		_service = service;

		ReferenceRegistry.registerReference(VFileServiceUtil.class, "_service");
		MethodCache.remove(VFileService.class);
	}

	private static VFileService _service;
}