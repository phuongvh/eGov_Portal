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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VcmsAttachedMessageService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsAttachedMessageService
 * @generated
 */
public class VcmsAttachedMessageServiceWrapper
	implements VcmsAttachedMessageService,
		ServiceWrapper<VcmsAttachedMessageService> {
	public VcmsAttachedMessageServiceWrapper(
		VcmsAttachedMessageService vcmsAttachedMessageService) {
		_vcmsAttachedMessageService = vcmsAttachedMessageService;
	}

	public com.vportal.portlet.vcms.model.VcmsAttachedMessage addMessage(
		long groupId, java.lang.String articleId, java.lang.String content,
		boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.addMessage(groupId, articleId,
			content, read);
	}

	public com.vportal.portlet.vcms.model.VcmsAttachedMessage updateMessage(
		java.lang.String messageId, boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.updateMessage(messageId, read);
	}

	public com.vportal.portlet.vcms.model.VcmsAttachedMessage updateMessage(
		com.vportal.portlet.vcms.model.VcmsAttachedMessage message)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.updateMessage(message);
	}

	public void deleteMessage(java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsAttachedMessageService.deleteMessage(messageId);
	}

	public void deleteMessages(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsAttachedMessageService.deleteMessages(articleId);
	}

	public com.vportal.portlet.vcms.model.VcmsAttachedMessage getMessage(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.getMessage(messageId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getMessages(
		java.lang.String[] messageIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.getMessages(messageIds);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getMessages(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.getMessages(articleId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getMessages(
		java.lang.String articleId, boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.getMessages(articleId, read);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getByG_R(
		long groupId, boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.getByG_R(groupId, read);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getByG_R(
		long groupId, boolean read, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.getByG_R(groupId, read, begin, end);
	}

	public int countByG_R(long groupId, boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.countByG_R(groupId, read);
	}

	/**
	* add by Donghh get messages by unread
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> getMessagesUnread(
		boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.getMessagesUnread(read);
	}

	public int count(java.lang.String articleId, boolean read)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsAttachedMessageService.count(articleId, read);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsAttachedMessageService getWrappedVcmsAttachedMessageService() {
		return _vcmsAttachedMessageService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsAttachedMessageService(
		VcmsAttachedMessageService vcmsAttachedMessageService) {
		_vcmsAttachedMessageService = vcmsAttachedMessageService;
	}

	public VcmsAttachedMessageService getWrappedService() {
		return _vcmsAttachedMessageService;
	}

	public void setWrappedService(
		VcmsAttachedMessageService vcmsAttachedMessageService) {
		_vcmsAttachedMessageService = vcmsAttachedMessageService;
	}

	private VcmsAttachedMessageService _vcmsAttachedMessageService;
}