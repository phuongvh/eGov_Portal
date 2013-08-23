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
 * The utility for the vcms portion remote service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsPortionServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author hai
 * @see VcmsPortionService
 * @see com.vportal.portlet.vcms.service.base.VcmsPortionServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsPortionServiceImpl
 * @generated
 */
public class VcmsPortionServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsPortionServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vcms.model.VcmsPortion addPortion(
		long groupId, long companyId, long plid, java.lang.String code,
		java.lang.String name, java.lang.String description,
		boolean categorizable, java.lang.String language,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addPortion(groupId, companyId, plid, code, name,
			description, categorizable, language, communityPermissions,
			guestPermissions);
	}

	public static com.vportal.portlet.vcms.model.VcmsPortion addPortion(
		long groupId, long companyId, long plid, java.lang.String code,
		java.lang.String name, java.lang.String description,
		boolean categorizable, java.lang.String language,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addPortion(groupId, companyId, plid, code, name,
			description, categorizable, language, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public static void addPortionResources(java.lang.String portionId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService()
			.addPortionResources(portionId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addPortionResources(
		com.vportal.portlet.vcms.model.VcmsPortion portion,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addPortionResources(portion, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addPortionResources(java.lang.String portionId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService()
			.addPortionResources(portionId, communityPermissions,
			guestPermissions);
	}

	public static void addPortionResources(
		com.vportal.portlet.vcms.model.VcmsPortion portion,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addPortionResources(portion, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vcms.model.VcmsPortion updatePortion(
		java.lang.String portionId, long groupId, long companyId,
		java.lang.String code, java.lang.String name,
		java.lang.String description, boolean categorizable,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updatePortion(portionId, groupId, companyId, code, name,
			description, categorizable, language);
	}

	public static void deletePortion(java.lang.String portionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deletePortion(portionId);
	}

	public static void deletePortions(java.lang.String[] portionIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deletePortions(portionIds);
	}

	public static com.vportal.portlet.vcms.model.VcmsPortion getPortion(
		java.lang.String portionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getPortion(portionId);
	}

	public static com.vportal.portlet.vcms.model.VcmsPortion getPortionByS_C(
		long groupId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getPortionByS_C(groupId, code);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsPortion> getPortionsByS_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getPortionsByS_L(groupId, language);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsPortion> getPortionsByS_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getPortionsByS_L(groupId, language, start, end);
	}

	public static int countPortionsByS_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countPortionsByS_L(groupId, language);
	}

	public static int countByCategorizable(long groupId, boolean categorizable)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countByCategorizable(groupId, categorizable);
	}

	public static void clearService() {
		_service = null;
	}

	public static VcmsPortionService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsPortionService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsPortionService.class.getName(), portletClassLoader);

			_service = new VcmsPortionServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsPortionServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsPortionService.class);
		}

		return _service;
	}

	public void setService(VcmsPortionService service) {
		MethodCache.remove(VcmsPortionService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsPortionServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsPortionService.class);
	}

	private static VcmsPortionService _service;
}