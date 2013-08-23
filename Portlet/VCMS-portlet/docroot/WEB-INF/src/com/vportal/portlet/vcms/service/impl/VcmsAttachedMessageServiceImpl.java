/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.vcms.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.vportal.portlet.vcms.model.VcmsAttachedMessage;
import com.vportal.portlet.vcms.service.base.VcmsAttachedMessageServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsAttachedMessageUtil;

/**
 * The implementation of the vcms attached message remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsAttachedMessageService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsAttachedMessageServiceUtil} to
 * access the vcms attached message remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsAttachedMessageServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsAttachedMessageServiceUtil
 */
public class VcmsAttachedMessageServiceImpl extends
		VcmsAttachedMessageServiceBaseImpl {
	public VcmsAttachedMessage addMessage(long groupId, String articleId,
			String content, boolean read) throws PortalException,
			SystemException, RemoteException {

		// Only save the message when its content is not null

		if (Validator.isNull(content)) {
			return null;
		}

		String messageId = Long.toString(CounterLocalServiceUtil
				.increment(VcmsAttachedMessage.class.getName()));

		Date now = new Date();
		String userId = String.valueOf(getUserId());

		VcmsAttachedMessage message = VcmsAttachedMessageUtil.create(messageId);

		message.setArticleId(articleId);
		message.setGroupId(groupId);
		message.setContent(content);
		message.setReadMessage(read);
		message.setCreatedByUser(userId);
		message.setCreatedDate(now);

		vcmsAttachedMessagePersistence.update(message, false);

		return message;
	}

	public VcmsAttachedMessage updateMessage(String messageId, boolean read)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(messageId)) {
			return null;
		}

		VcmsAttachedMessage message = vcmsAttachedMessagePersistence
				.findByPrimaryKey(messageId);
		message.setReadMessage(true);
		return vcmsAttachedMessagePersistence.update(message, false);
	}

	public VcmsAttachedMessage updateMessage(VcmsAttachedMessage message)
			throws PortalException, SystemException, RemoteException {

		return updateMessage(message.getMessageId(), message.getReadMessage());
	}

	public void deleteMessage(String messageId) throws PortalException,
			SystemException, RemoteException {
		vcmsAttachedMessagePersistence.remove(messageId);

	}

	public void deleteMessages(String articleId) throws PortalException,
			SystemException, RemoteException {
		vcmsAttachedMessagePersistence.removeByArticle(articleId);
	}

	public VcmsAttachedMessage getMessage(String messageId)
			throws PortalException, SystemException, RemoteException {
		return vcmsAttachedMessagePersistence.findByPrimaryKey(messageId);
	}

	public List<VcmsAttachedMessage> getMessages(String[] messageIds)
			throws PortalException, SystemException, RemoteException {

		List messages = new ArrayList();

		if ((messageIds == null) || (messageIds.length <= 0)) {
			return messages;
		}

		for (int i = 0; i < messageIds.length; i++) {
			messages.add(getMessage(messageIds[i]));
		}

		return messages;
	}

	public List<VcmsAttachedMessage> getMessages(String articleId)
			throws PortalException, SystemException, RemoteException {
		return vcmsAttachedMessagePersistence.findByArticle(articleId);

	}

	public List<VcmsAttachedMessage> getMessages(String articleId, boolean read)
			throws PortalException, SystemException, RemoteException {

		return vcmsAttachedMessagePersistence.findByA_R(articleId, read);

	}

	public List<VcmsAttachedMessage> getByG_R(long groupId, boolean read)
			throws PortalException, SystemException, RemoteException {
		return vcmsAttachedMessagePersistence.findByG_R(groupId, read);
	}

	public List<VcmsAttachedMessage> getByG_R(long groupId, boolean read,
			int begin, int end) throws PortalException, SystemException,
			RemoteException {
		return vcmsAttachedMessagePersistence.findByG_R(groupId, read, begin,
				end);
	}

	public int countByG_R(long groupId, boolean read) throws PortalException,
			SystemException, RemoteException {
		return vcmsAttachedMessagePersistence.countByG_R(groupId, read);
	}

	/**
	 * add by Donghh get messages by unread
	 */
	public List<VcmsAttachedMessage> getMessagesUnread(boolean read)
			throws PortalException, SystemException, RemoteException {

		return (List) VcmsAttachedMessageUtil.findByUnRead(read);
	}

	public int count(String articleId, boolean read) throws PortalException,
			SystemException, RemoteException {
		return VcmsAttachedMessageUtil.countByA_R(articleId, read);
	}
}