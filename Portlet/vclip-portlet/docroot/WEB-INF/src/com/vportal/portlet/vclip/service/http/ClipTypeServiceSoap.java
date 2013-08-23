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

package com.vportal.portlet.vclip.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vclip.service.ClipTypeServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vclip.service.ClipTypeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vclip.model.ClipTypeSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vclip.model.ClipType}, that is translated to a
 * {@link com.vportal.portlet.vclip.model.ClipTypeSoap}. Methods that SOAP cannot
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
 * @author    HOAN
 * @see       ClipTypeServiceHttp
 * @see       com.vportal.portlet.vclip.model.ClipTypeSoap
 * @see       com.vportal.portlet.vclip.service.ClipTypeServiceUtil
 * @generated
 */
public class ClipTypeServiceSoap {
	public static com.vportal.portlet.vclip.model.ClipTypeSoap addClipType(
		long groupId, long companyId, long plid,
		com.vportal.portlet.vclip.model.ClipType clipType,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vclip.model.ClipType returnValue = ClipTypeServiceUtil.addClipType(groupId,
					companyId, plid, clipType, addCommunityPermissions,
					addGuestPermissions, communityPermissions, guestPermissions);

			return com.vportal.portlet.vclip.model.ClipTypeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipTypeSoap updateClipType(
		long groupId, long companyId, java.lang.String clipTypeId,
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws RemoteException {
		try {
			com.vportal.portlet.vclip.model.ClipType returnValue = ClipTypeServiceUtil.updateClipType(groupId,
					companyId, clipTypeId, clipType);

			return com.vportal.portlet.vclip.model.ClipTypeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws RemoteException {
		try {
			ClipTypeServiceUtil.deleteClipType(clipType);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteClipType(java.lang.String clipTypeId)
		throws RemoteException {
		try {
			ClipTypeServiceUtil.deleteClipType(clipTypeId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipTypeSoap findById(
		java.lang.String clipTypeId) throws RemoteException {
		try {
			com.vportal.portlet.vclip.model.ClipType returnValue = ClipTypeServiceUtil.findById(clipTypeId);

			return com.vportal.portlet.vclip.model.ClipTypeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipType[] findAll()
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.ClipType> returnValue =
				ClipTypeServiceUtil.findAll();

			return returnValue.toArray(new com.vportal.portlet.vclip.model.ClipType[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipType[] findAll(
		int begin, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.ClipType> returnValue =
				ClipTypeServiceUtil.findAll(begin, end);

			return returnValue.toArray(new com.vportal.portlet.vclip.model.ClipType[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countAll() throws RemoteException {
		try {
			int returnValue = ClipTypeServiceUtil.countAll();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipType[] getLanguage(
		java.lang.String language, boolean active) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.ClipType> returnValue =
				ClipTypeServiceUtil.getLanguage(language, active);

			return returnValue.toArray(new com.vportal.portlet.vclip.model.ClipType[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipType[] findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.ClipType> returnValue =
				ClipTypeServiceUtil.findClipType(clipType);

			return returnValue.toArray(new com.vportal.portlet.vclip.model.ClipType[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipType[] findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.ClipType> returnValue =
				ClipTypeServiceUtil.findClipType(clipType, start, end);

			return returnValue.toArray(new com.vportal.portlet.vclip.model.ClipType[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws RemoteException {
		try {
			int returnValue = ClipTypeServiceUtil.countClipType(clipType);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipTypeSoap getFirst()
		throws RemoteException {
		try {
			com.vportal.portlet.vclip.model.ClipType returnValue = ClipTypeServiceUtil.getFirst();

			return com.vportal.portlet.vclip.model.ClipTypeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addClipTypeResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			ClipTypeServiceUtil.addClipTypeResources(articleId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addClipTypeResources(
		com.vportal.portlet.vclip.model.ClipType article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			ClipTypeServiceUtil.addClipTypeResources(article,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addClipTypeResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			ClipTypeServiceUtil.addClipTypeResources(articleId,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addClipTypeResources(
		com.vportal.portlet.vclip.model.ClipType article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			ClipTypeServiceUtil.addClipTypeResources(article,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClipTypeServiceSoap.class);
}