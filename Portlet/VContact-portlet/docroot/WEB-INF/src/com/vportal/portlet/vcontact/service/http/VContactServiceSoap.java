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

package com.vportal.portlet.vcontact.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vcontact.service.VContactServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcontact.service.VContactServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcontact.model.VContactSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcontact.model.VContact}, that is translated to a
 * {@link com.vportal.portlet.vcontact.model.VContactSoap}. Methods that SOAP cannot
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
 * @author    LongLH
 * @see       VContactServiceHttp
 * @see       com.vportal.portlet.vcontact.model.VContactSoap
 * @see       com.vportal.portlet.vcontact.service.VContactServiceUtil
 * @generated
 */
public class VContactServiceSoap {
	public static com.vportal.portlet.vcontact.model.VContactSoap addContact(
		long groupId, long companyId, long plid, java.lang.String guestName,
		java.lang.String email, java.lang.String title,
		java.lang.String address, java.lang.String phone, java.lang.String fax,
		java.lang.String content, boolean hasAttach, int status, long userId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vcontact.model.VContact returnValue = VContactServiceUtil.addContact(groupId,
					companyId, plid, guestName, email, title, address, phone,
					fax, content, hasAttach, status, userId,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vcontact.model.VContactSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcontact.model.VContactSoap addContact(
		long groupId, long companyId, long plid, java.lang.String guestName,
		java.lang.String email, java.lang.String title,
		java.lang.String address, java.lang.String phone, java.lang.String fax,
		java.lang.String content, boolean hasAttach, int status, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vcontact.model.VContact returnValue = VContactServiceUtil.addContact(groupId,
					companyId, plid, guestName, email, title, address, phone,
					fax, content, hasAttach, status, userId,
					addCommunityPermissions, addGuestPermissions,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vcontact.model.VContactSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcontact.model.VContactSoap updateContact(
		long Id, long groupId, long companyId, java.lang.String guestName,
		java.lang.String email, java.lang.String title,
		java.lang.String address, java.lang.String phone, java.lang.String fax,
		java.lang.String content, boolean hasAttach, int status)
		throws RemoteException {
		try {
			com.vportal.portlet.vcontact.model.VContact returnValue = VContactServiceUtil.updateContact(Id,
					groupId, companyId, guestName, email, title, address,
					phone, fax, content, hasAttach, status);

			return com.vportal.portlet.vcontact.model.VContactSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcontact.model.VContactSoap updateContact(
		com.vportal.portlet.vcontact.model.VContact contact)
		throws RemoteException {
		try {
			com.vportal.portlet.vcontact.model.VContact returnValue = VContactServiceUtil.updateContact(contact);

			return com.vportal.portlet.vcontact.model.VContactSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteContact(long Id) throws RemoteException {
		try {
			VContactServiceUtil.deleteContact(Id);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcontact.model.VContact[] getAll()
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcontact.model.VContact> returnValue =
				VContactServiceUtil.getAll();

			return returnValue.toArray(new com.vportal.portlet.vcontact.model.VContact[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcontact.model.VContact[] getByStatus(
		int status) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcontact.model.VContact> returnValue =
				VContactServiceUtil.getByStatus(status);

			return returnValue.toArray(new com.vportal.portlet.vcontact.model.VContact[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcontact.model.VContact[] getByG_S(
		long groupId, int status) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcontact.model.VContact> returnValue =
				VContactServiceUtil.getByG_S(groupId, status);

			return returnValue.toArray(new com.vportal.portlet.vcontact.model.VContact[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcontact.model.VContact[] getByG_S(
		long groupId, int status, int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcontact.model.VContact> returnValue =
				VContactServiceUtil.getByG_S(groupId, status, start, end);

			return returnValue.toArray(new com.vportal.portlet.vcontact.model.VContact[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcontact.model.VContactSoap getContact(
		long Id) throws RemoteException {
		try {
			com.vportal.portlet.vcontact.model.VContact returnValue = VContactServiceUtil.getContact(Id);

			return com.vportal.portlet.vcontact.model.VContactSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VContactServiceSoap.class);
}