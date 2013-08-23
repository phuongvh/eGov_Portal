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
 * The utility for the vcms discussion remote service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsDiscussionServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author hai
 * @see VcmsDiscussionService
 * @see com.vportal.portlet.vcms.service.base.VcmsDiscussionServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsDiscussionServiceImpl
 * @generated
 */
public class VcmsDiscussionServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsDiscussionServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vcms.model.VcmsDiscussion addDiscussion(
		java.lang.String visitorName, java.lang.String visitorEmail,
		java.lang.String visitorPhone, long groupId, long companyId,
		java.lang.String articleId, java.lang.String title,
		java.lang.String content, boolean hasAttachment,
		java.lang.String language, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .addDiscussion(visitorName, visitorEmail, visitorPhone,
			groupId, companyId, articleId, title, content, hasAttachment,
			language, addCommunityPermissions, addGuestPermissions);
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussion updateDiscussion(
		java.lang.String discussionId, java.lang.String visitorName,
		java.lang.String visitorEmail, java.lang.String visitorPhone,
		long groupId, long companyId, java.lang.String articleId,
		java.lang.String title, java.lang.String content,
		boolean hasAttachment, boolean approved, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .updateDiscussion(discussionId, visitorName, visitorEmail,
			visitorPhone, groupId, companyId, articleId, title, content,
			hasAttachment, approved, language);
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussion updateDiscussion(
		com.vportal.portlet.vcms.model.VcmsDiscussion discussion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateDiscussion(discussion);
	}

	public static void deleteDiscussion(java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteDiscussion(discussionId);
	}

	public static void deleteDiscussions(java.lang.String[] discussionIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteDiscussions(discussionIds);
	}

	public static void deleteDiscussions(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteDiscussions(articleId);
	}

	public static void deleteDiscussions(java.lang.String articleId,
		boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteDiscussions(articleId, approved);
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussion getDiscussion(
		java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getDiscussion(discussionId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussions(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getDiscussions(articleId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussions(
		java.lang.String articleId, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getDiscussions(articleId, approved);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussionsByP_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getDiscussionsByP_L(groupId, language);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussionsByP_L_A(
		long groupId, java.lang.String language, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getDiscussionsByP_L_A(groupId, language, approved);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussionsByA_P_L_A(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getDiscussionsByA_P_L_A(articleId, groupId, language,
			approved);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> searchDiscussionByA_P_L_K(
		java.lang.String articleId, long groupId, java.lang.String language,
		java.lang.String keyword, boolean approved, boolean isTitle,
		boolean isContent, java.lang.String select)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .searchDiscussionByA_P_L_K(articleId, groupId, language,
			keyword, approved, isTitle, isContent, select);
	}

	public static int countByApproval(long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countByApproval(groupId, language, approved);
	}

	public static void clearService() {
		_service = null;
	}

	public static VcmsDiscussionService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsDiscussionService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsDiscussionService.class.getName(), portletClassLoader);

			_service = new VcmsDiscussionServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsDiscussionServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsDiscussionService.class);
		}

		return _service;
	}

	public void setService(VcmsDiscussionService service) {
		MethodCache.remove(VcmsDiscussionService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsDiscussionServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsDiscussionService.class);
	}

	private static VcmsDiscussionService _service;
}