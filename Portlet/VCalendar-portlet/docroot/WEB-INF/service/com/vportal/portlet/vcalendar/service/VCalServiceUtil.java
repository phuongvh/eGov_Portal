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
 * The utility for the v cal remote service. This utility wraps {@link com.vportal.portlet.vcalendar.service.impl.VCalServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LongLH
 * @see VCalService
 * @see com.vportal.portlet.vcalendar.service.base.VCalServiceBaseImpl
 * @see com.vportal.portlet.vcalendar.service.impl.VCalServiceImpl
 * @generated
 */
public class VCalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcalendar.service.impl.VCalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vcalendar.model.VCal addvCal(
		long groupId, long companyId, long userId, java.lang.String userName,
		java.util.Date createDate, java.util.Date modifiedDate,
		java.lang.String languageId, java.lang.String title,
		java.lang.String description, java.util.Date startDate,
		java.util.Date endDate, int status, long fileId,
		java.lang.String guest, java.lang.String location, java.lang.String time)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addvCal(groupId, companyId, userId, userName, createDate,
			modifiedDate, languageId, title, description, startDate, endDate,
			status, fileId, guest, location, time);
	}

	public static com.vportal.portlet.vcalendar.model.VCal updatevCal(
		long calId, long groupId, long companyId, long userId,
		java.lang.String userName, java.util.Date createDate,
		java.util.Date modifiedDate, java.lang.String languageId,
		java.lang.String title, java.lang.String description, int status,
		long fileId, java.lang.String guest, java.lang.String location,
		java.lang.String time)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatevCal(calId, groupId, companyId, userId, userName,
			createDate, modifiedDate, languageId, title, description, status,
			fileId, guest, location, time);
	}

	public static com.vportal.portlet.vcalendar.model.VCal deletevCal(
		long calId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletevCal(calId);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S_G(
		java.util.Date startDate, int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByD_S_G(startDate, status, groupId);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S_G(
		java.util.Date startDate, int status, long groupId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByD_S_G(startDate, status, groupId, begin, end);
	}

	public static int countByD_S_G(java.util.Date startDate, int status,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByD_S_G(startDate, status, groupId);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByU_D_S(
		long userId, int status, java.util.Date startDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByU_D_S(userId, status, startDate);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByU_D_S(
		long userId, java.util.Date startDate, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByU_D_S(userId, startDate, status, begin, end);
	}

	public static int countByU_D_S(long userId, java.util.Date startDate,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByU_D_S(userId, startDate, status);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S(
		java.util.Date startDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByD_S(startDate, status);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByD_S(
		java.util.Date startDate, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByD_S(startDate, status, begin, end);
	}

	public static int countByD_S(java.util.Date startDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByD_S(startDate, status);
	}

	public static com.vportal.portlet.vcalendar.model.VCal findById(long calId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getService().findById(calId);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByUser(
		long calId, java.util.Date startDate, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getService().findByUser(calId, startDate, groupId);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByUserGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getService().findByUserGroup(groupId);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByGroupOrg()
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVCalException {
		return getService().findByGroupOrg();
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF_D_G_T(
		long fileId, java.util.Date startDate, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByF_D_G_T(fileId, startDate, groupId, status);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF_D_G_U(
		long userId, java.util.Date startDate, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByF_D_G_U(userId, startDate, groupId, status);
	}

	public static java.util.List<com.vportal.portlet.vcalendar.model.VCal> findByF(
		long fileId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByF(fileId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VCalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VCalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VCalService.class.getName(), portletClassLoader);

			_service = new VCalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VCalServiceUtil.class,
				"_service");
			MethodCache.remove(VCalService.class);
		}

		return _service;
	}

	public void setService(VCalService service) {
		MethodCache.remove(VCalService.class);

		_service = service;

		ReferenceRegistry.registerReference(VCalServiceUtil.class, "_service");
		MethodCache.remove(VCalService.class);
	}

	private static VCalService _service;
}