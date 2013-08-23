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

package com.vportal.portlet.vcms.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vcms.service.VcmsAttachedMessageServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcms.service.VcmsAttachedMessageServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcms.model.VcmsAttachedMessageSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcms.model.VcmsAttachedMessage}, that is translated to a
 * {@link com.vportal.portlet.vcms.model.VcmsAttachedMessageSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    hai
 * @see       VcmsAttachedMessageServiceHttp
 * @see       com.vportal.portlet.vcms.model.VcmsAttachedMessageSoap
 * @see       com.vportal.portlet.vcms.service.VcmsAttachedMessageServiceUtil
 * @generated
 */
public class VcmsAttachedMessageServiceSoap {
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessageSoap addMessage(
		long groupId, java.lang.String articleId, java.lang.String content,
		boolean read) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsAttachedMessage returnValue = VcmsAttachedMessageServiceUtil.addMessage(groupId,
					articleId, content, read);

			return com.vportal.portlet.vcms.model.VcmsAttachedMessageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessageSoap updateMessage(
		java.lang.String messageId, boolean read) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsAttachedMessage returnValue = VcmsAttachedMessageServiceUtil.updateMessage(messageId,
					read);

			return com.vportal.portlet.vcms.model.VcmsAttachedMessageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessageSoap updateMessage(
		com.vportal.portlet.vcms.model.VcmsAttachedMessage message)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsAttachedMessage returnValue = VcmsAttachedMessageServiceUtil.updateMessage(message);

			return com.vportal.portlet.vcms.model.VcmsAttachedMessageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteMessage(java.lang.String messageId)
		throws RemoteException {
		try {
			VcmsAttachedMessageServiceUtil.deleteMessage(messageId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteMessages(java.lang.String articleId)
		throws RemoteException {
		try {
			VcmsAttachedMessageServiceUtil.deleteMessages(articleId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessageSoap getMessage(
		java.lang.String messageId) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsAttachedMessage returnValue = VcmsAttachedMessageServiceUtil.getMessage(messageId);

			return com.vportal.portlet.vcms.model.VcmsAttachedMessageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage[] getMessages(
		java.lang.String[] messageIds) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> returnValue =
				VcmsAttachedMessageServiceUtil.getMessages(messageIds);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsAttachedMessage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage[] getMessages(
		java.lang.String articleId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> returnValue =
				VcmsAttachedMessageServiceUtil.getMessages(articleId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsAttachedMessage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage[] getMessages(
		java.lang.String articleId, boolean read) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> returnValue =
				VcmsAttachedMessageServiceUtil.getMessages(articleId, read);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsAttachedMessage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage[] getByG_R(
		long groupId, boolean read) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> returnValue =
				VcmsAttachedMessageServiceUtil.getByG_R(groupId, read);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsAttachedMessage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage[] getByG_R(
		long groupId, boolean read, int begin, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> returnValue =
				VcmsAttachedMessageServiceUtil.getByG_R(groupId, read, begin,
					end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsAttachedMessage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByG_R(long groupId, boolean read)
		throws RemoteException {
		try {
			int returnValue = VcmsAttachedMessageServiceUtil.countByG_R(groupId,
					read);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* add by Donghh get messages by unread
	*/
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage[] getMessagesUnread(
		boolean read) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> returnValue =
				VcmsAttachedMessageServiceUtil.getMessagesUnread(read);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsAttachedMessage[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int count(java.lang.String articleId, boolean read)
		throws RemoteException {
		try {
			int returnValue = VcmsAttachedMessageServiceUtil.count(articleId,
					read);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VcmsAttachedMessageServiceSoap.class);
}