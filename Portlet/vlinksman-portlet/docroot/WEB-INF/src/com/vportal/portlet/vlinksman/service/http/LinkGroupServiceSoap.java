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

package com.vportal.portlet.vlinksman.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vlinksman.service.LinkGroupServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vlinksman.service.LinkGroupServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vlinksman.model.LinkGroupSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vlinksman.model.LinkGroup}, that is translated to a
 * {@link com.vportal.portlet.vlinksman.model.LinkGroupSoap}. Methods that SOAP cannot
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
 * @see       LinkGroupServiceHttp
 * @see       com.vportal.portlet.vlinksman.model.LinkGroupSoap
 * @see       com.vportal.portlet.vlinksman.service.LinkGroupServiceUtil
 * @generated
 */
public class LinkGroupServiceSoap {
	public static com.vportal.portlet.vlinksman.model.LinkGroupSoap addLinkGroup(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, long userId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.LinkGroup returnValue = LinkGroupServiceUtil.addLinkGroup(groupId,
					companyId, plid, name, description, userId,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vlinksman.model.LinkGroupSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinkGroupSoap addLinkGroup(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.LinkGroup returnValue = LinkGroupServiceUtil.addLinkGroup(groupId,
					companyId, plid, name, description, userId,
					addCommunityPermissions, addGuestPermissions,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vlinksman.model.LinkGroupSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinkGroupSoap updateLinkGroup(
		long linkgroupId, long groupId, long companyId, java.lang.String name,
		java.lang.String description) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.LinkGroup returnValue = LinkGroupServiceUtil.updateLinkGroup(linkgroupId,
					groupId, companyId, name, description);

			return com.vportal.portlet.vlinksman.model.LinkGroupSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteLinkGroup(long linkgroupId)
		throws RemoteException {
		try {
			LinkGroupServiceUtil.deleteLinkGroup(linkgroupId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getAll() throws RemoteException {
		try {
			java.util.List returnValue = LinkGroupServiceUtil.getAll();

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getByGroupId(long groupId)
		throws RemoteException {
		try {
			java.util.List returnValue = LinkGroupServiceUtil.getByGroupId(groupId);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getByGroupId(long groupId, int start, int end)
		throws RemoteException {
		try {
			java.util.List returnValue = LinkGroupServiceUtil.getByGroupId(groupId,
					start, end);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinkGroupSoap getLinkGroup(
		long linkgroupId) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.LinkGroup returnValue = LinkGroupServiceUtil.getLinkGroup(linkgroupId);

			return com.vportal.portlet.vlinksman.model.LinkGroupSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addLinkGroupResources(long linkgroupId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			LinkGroupServiceUtil.addLinkGroupResources(linkgroupId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addLinkGroupResources(
		com.vportal.portlet.vlinksman.model.LinkGroup linkGroup,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			LinkGroupServiceUtil.addLinkGroupResources(linkGroup,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addLinkGroupResources(long linkgroupId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			LinkGroupServiceUtil.addLinkGroupResources(linkgroupId,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addLinkGroupResources(
		com.vportal.portlet.vlinksman.model.LinkGroup linkGroup,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			LinkGroupServiceUtil.addLinkGroupResources(linkGroup,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LinkGroupServiceSoap.class);
}