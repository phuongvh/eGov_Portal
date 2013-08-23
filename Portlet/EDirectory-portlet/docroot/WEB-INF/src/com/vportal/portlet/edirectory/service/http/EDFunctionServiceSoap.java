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

package com.vportal.portlet.edirectory.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.edirectory.service.EDFunctionServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.edirectory.service.EDFunctionServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.edirectory.model.EDFunctionSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.edirectory.model.EDFunction}, that is translated to a
 * {@link com.vportal.portlet.edirectory.model.EDFunctionSoap}. Methods that SOAP cannot
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
 * @see       EDFunctionServiceHttp
 * @see       com.vportal.portlet.edirectory.model.EDFunctionSoap
 * @see       com.vportal.portlet.edirectory.service.EDFunctionServiceUtil
 * @generated
 */
public class EDFunctionServiceSoap {
	public static com.vportal.portlet.edirectory.model.EDFunctionSoap addFunction(
		com.vportal.portlet.edirectory.model.EDFunction function,
		java.lang.String languageId, long userId, long plid,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.edirectory.model.EDFunction returnValue = EDFunctionServiceUtil.addFunction(function,
					languageId, userId, plid, addCommunityPermissions,
					addGuestPermissions, communityPermissions, guestPermissions);

			return com.vportal.portlet.edirectory.model.EDFunctionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.edirectory.model.EDFunctionSoap updateFunction(
		com.vportal.portlet.edirectory.model.EDFunction function,
		long functionId, long groupId) throws RemoteException {
		try {
			com.vportal.portlet.edirectory.model.EDFunction returnValue = EDFunctionServiceUtil.updateFunction(function,
					functionId, groupId);

			return com.vportal.portlet.edirectory.model.EDFunctionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void removeFunction(long functionId, long groupId)
		throws RemoteException {
		try {
			EDFunctionServiceUtil.removeFunction(functionId, groupId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addFunctionResources(long functionId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			EDFunctionServiceUtil.addFunctionResources(functionId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addFunctionResources(
		com.vportal.portlet.edirectory.model.EDFunction function,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			EDFunctionServiceUtil.addFunctionResources(function,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addFunctionResources(long functionId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			EDFunctionServiceUtil.addFunctionResources(functionId,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addFunctionResources(
		com.vportal.portlet.edirectory.model.EDFunction function,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			EDFunctionServiceUtil.addFunctionResources(function,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EDFunctionServiceSoap.class);
}