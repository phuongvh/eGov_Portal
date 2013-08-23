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

import com.vportal.portlet.vdoc.service.vdocFieldServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vdoc.service.vdocFieldServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vdoc.model.vdocFieldSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vdoc.model.vdocField}, that is translated to a
 * {@link com.vportal.portlet.vdoc.model.vdocFieldSoap}. Methods that SOAP cannot
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
 * @see       vdocFieldServiceHttp
 * @see       com.vportal.portlet.vdoc.model.vdocFieldSoap
 * @see       com.vportal.portlet.vdoc.service.vdocFieldServiceUtil
 * @generated
 */
public class vdocFieldServiceSoap {
	public static com.vportal.portlet.vdoc.model.vdocFieldSoap updateField(
		com.vportal.portlet.vdoc.model.vdocField field, long userId)
		throws RemoteException {
		try {
			com.vportal.portlet.vdoc.model.vdocField returnValue = vdocFieldServiceUtil.updateField(field,
					userId);

			return com.vportal.portlet.vdoc.model.vdocFieldSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocFieldSoap updateField(
		java.lang.String fieldId, long groupId, java.lang.String language,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean statusField, int position,
		java.lang.String listparent, long userId) throws RemoteException {
		try {
			com.vportal.portlet.vdoc.model.vdocField returnValue = vdocFieldServiceUtil.updateField(fieldId,
					groupId, language, parentId, name, description,
					statusField, position, listparent, userId);

			return com.vportal.portlet.vdoc.model.vdocFieldSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteField(java.lang.String fieldId)
		throws RemoteException {
		try {
			vdocFieldServiceUtil.deleteField(fieldId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocFieldSoap getField(
		java.lang.String fieldId) throws RemoteException {
		try {
			com.vportal.portlet.vdoc.model.vdocField returnValue = vdocFieldServiceUtil.getField(fieldId);

			return com.vportal.portlet.vdoc.model.vdocFieldSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocField[] getFieldByParentId(
		java.lang.String parentId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocField> returnValue =
				vdocFieldServiceUtil.getFieldByParentId(parentId);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocField[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocField[] getFieldByG_L(
		long groupId, java.lang.String language) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocField> returnValue =
				vdocFieldServiceUtil.getFieldByG_L(groupId, language);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocField[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocField[] getFieldByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocField> returnValue =
				vdocFieldServiceUtil.getFieldByG_L_P(groupId, language, parentId);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocField[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocField[] getFieldByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int begin, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocField> returnValue =
				vdocFieldServiceUtil.getFieldByG_L_P(groupId, language,
					parentId, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocField[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocField[] getFieldByG_L(
		long groupId, java.lang.String language, int begin, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocField> returnValue =
				vdocFieldServiceUtil.getFieldByG_L(groupId, language, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocField[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countFieldByG_L(long groupId, java.lang.String language)
		throws RemoteException {
		try {
			int returnValue = vdocFieldServiceUtil.countFieldByG_L(groupId,
					language);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countFieldByG_L_P(long groupId,
		java.lang.String language, java.lang.String parentId)
		throws RemoteException {
		try {
			int returnValue = vdocFieldServiceUtil.countFieldByG_L_P(groupId,
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
			vdocFieldServiceUtil.addEntryResources(entryId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocField entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			vdocFieldServiceUtil.addEntryResources(entry,
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
			vdocFieldServiceUtil.addEntryResources(entryId,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocField entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			vdocFieldServiceUtil.addEntryResources(entry, communityPermissions,
				guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(vdocFieldServiceSoap.class);
}