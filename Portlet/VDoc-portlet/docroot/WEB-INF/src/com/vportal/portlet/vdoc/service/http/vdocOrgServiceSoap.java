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

package com.vportal.portlet.vdoc.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vdoc.service.vdocOrgServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vdoc.service.vdocOrgServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vdoc.model.vdocOrgSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vdoc.model.vdocOrg}, that is translated to a
 * {@link com.vportal.portlet.vdoc.model.vdocOrgSoap}. Methods that SOAP cannot
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
 * @author    MrEn
 * @see       vdocOrgServiceHttp
 * @see       com.vportal.portlet.vdoc.model.vdocOrgSoap
 * @see       com.vportal.portlet.vdoc.service.vdocOrgServiceUtil
 * @generated
 */
public class vdocOrgServiceSoap {
	public static com.vportal.portlet.vdoc.model.vdocOrgSoap updateOrg(
		com.vportal.portlet.vdoc.model.vdocOrg org, long userId)
		throws RemoteException {
		try {
			com.vportal.portlet.vdoc.model.vdocOrg returnValue = vdocOrgServiceUtil.updateOrg(org,
					userId);

			return com.vportal.portlet.vdoc.model.vdocOrgSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocOrgSoap updateOrg(
		java.lang.String orgId, long groupId, java.lang.String language,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, java.lang.String address,
		java.lang.String phone, boolean statusOrg, int position,
		java.lang.String fax, java.lang.String listparent, long userId)
		throws RemoteException {
		try {
			com.vportal.portlet.vdoc.model.vdocOrg returnValue = vdocOrgServiceUtil.updateOrg(orgId,
					groupId, language, parentId, name, description, address,
					phone, statusOrg, position, fax, listparent, userId);

			return com.vportal.portlet.vdoc.model.vdocOrgSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteOrg(java.lang.String orgId)
		throws RemoteException {
		try {
			vdocOrgServiceUtil.deleteOrg(orgId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocOrgSoap getOrg(
		java.lang.String orgId) throws RemoteException {
		try {
			com.vportal.portlet.vdoc.model.vdocOrg returnValue = vdocOrgServiceUtil.getOrg(orgId);

			return com.vportal.portlet.vdoc.model.vdocOrgSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocOrg[] getOrgByParentId(
		java.lang.String parentId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> returnValue = vdocOrgServiceUtil.getOrgByParentId(parentId);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocOrg[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocOrg[] getOrgByG_L(
		long groupId, java.lang.String language) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> returnValue = vdocOrgServiceUtil.getOrgByG_L(groupId,
					language);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocOrg[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocOrg[] getOrgByG_L(
		long groupId, java.lang.String language, int begin, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> returnValue = vdocOrgServiceUtil.getOrgByG_L(groupId,
					language, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocOrg[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocOrg[] getOrgByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> returnValue = vdocOrgServiceUtil.getOrgByG_L_P(groupId,
					language, parentId);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocOrg[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocOrg[] getOrgByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int begin, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> returnValue = vdocOrgServiceUtil.getOrgByG_L_P(groupId,
					language, parentId, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocOrg[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countOrgByG_L(long groupId, java.lang.String language)
		throws RemoteException {
		try {
			int returnValue = vdocOrgServiceUtil.countOrgByG_L(groupId, language);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countOrgByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId) throws RemoteException {
		try {
			int returnValue = vdocOrgServiceUtil.countOrgByG_L_P(groupId,
					language, parentId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addEntryResources(long entryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			vdocOrgServiceUtil.addEntryResources(entryId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocOrg entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			vdocOrgServiceUtil.addEntryResources(entry,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addEntryResources(long entryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			vdocOrgServiceUtil.addEntryResources(entryId, communityPermissions,
				guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocOrg entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			vdocOrgServiceUtil.addEntryResources(entry, communityPermissions,
				guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(vdocOrgServiceSoap.class);
}