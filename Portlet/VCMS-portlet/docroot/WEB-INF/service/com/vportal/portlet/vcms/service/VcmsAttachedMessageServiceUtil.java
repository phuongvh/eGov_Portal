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
 * The utility for the vcms attached message remote service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsAttachedMessageServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author hai
 * @see VcmsAttachedMessageService
 * @see com.vportal.portlet.vcms.service.base.VcmsAttachedMessageServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsAttachedMessageServiceImpl
 * @generated
 */
public class VcmsAttachedMessageServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsAttachedMessageServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage addMessage(
		long groupId, java.lang.String articleId, java.lang.String content,
		boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().addMessage(groupId, articleId, content, read);
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage updateMessage(
		java.lang.String messageId, boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateMessage(messageId, read);
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage updateMessage(
		com.vportal.portlet.vcms.model.VcmsAttachedMessage message)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateMessage(message);
	}

	public static void deleteMessage(java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteMessage(messageId);
	}

	public static void deleteMessages(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteMessages(articleId);
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage getMessage(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getMessage(messageId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getMessages(
		java.lang.String[] messageIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getMessages(messageIds);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getMessages(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getMessages(articleId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getMessages(
		java.lang.String articleId, boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getMessages(articleId, read);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getByG_R(
		long groupId, boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByG_R(groupId, read);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getByG_R(
		long groupId, boolean read, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getByG_R(groupId, read, begin, end);
	}

	public static int countByG_R(long groupId, boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countByG_R(groupId, read);
	}

	/**
	* add by Donghh get messages by unread
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getMessagesUnread(
		boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getMessagesUnread(read);
	}

	public static int count(java.lang.String articleId, boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().count(articleId, read);
	}

	public static void clearService() {
		_service = null;
	}

	public static VcmsAttachedMessageService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsAttachedMessageService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsAttachedMessageService.class.getName(),
					portletClassLoader);

			_service = new VcmsAttachedMessageServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsAttachedMessageServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsAttachedMessageService.class);
		}

		return _service;
	}

	public void setService(VcmsAttachedMessageService service) {
		MethodCache.remove(VcmsAttachedMessageService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsAttachedMessageServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsAttachedMessageService.class);
	}

	private static VcmsAttachedMessageService _service;
}