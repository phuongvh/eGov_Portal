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

import com.vportal.portlet.vcms.service.VcmsThreadServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcms.service.VcmsThreadServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcms.model.VcmsThreadSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcms.model.VcmsThread}, that is translated to a
 * {@link com.vportal.portlet.vcms.model.VcmsThreadSoap}. Methods that SOAP cannot
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
 * @see       VcmsThreadServiceHttp
 * @see       com.vportal.portlet.vcms.model.VcmsThreadSoap
 * @see       com.vportal.portlet.vcms.service.VcmsThreadServiceUtil
 * @generated
 */
public class VcmsThreadServiceSoap {
	public static com.vportal.portlet.vcms.model.VcmsThreadSoap addThread(
		long groupId, long companyId, long plid, java.lang.String title,
		java.lang.String description, boolean hasImage, java.lang.String image,
		java.lang.String language, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsThread returnValue = VcmsThreadServiceUtil.addThread(groupId,
					companyId, plid, title, description, hasImage, image,
					language, communityPermissions, guestPermissions);

			return com.vportal.portlet.vcms.model.VcmsThreadSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsThreadSoap addThread(
		long groupId, long companyId, long plid, java.lang.String title,
		java.lang.String description, boolean hasImage, java.lang.String image,
		java.lang.String language, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsThread returnValue = VcmsThreadServiceUtil.addThread(groupId,
					companyId, plid, title, description, hasImage, image,
					language, addCommunityPermissions, addGuestPermissions,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vcms.model.VcmsThreadSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addThreadResources(java.lang.String threadId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			VcmsThreadServiceUtil.addThreadResources(threadId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addThreadResources(
		com.vportal.portlet.vcms.model.VcmsThread thread,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			VcmsThreadServiceUtil.addThreadResources(thread,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addThreadResources(java.lang.String threadId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			VcmsThreadServiceUtil.addThreadResources(threadId,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addThreadResources(
		com.vportal.portlet.vcms.model.VcmsThread thread,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			VcmsThreadServiceUtil.addThreadResources(thread,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsThreadSoap updateThread(
		java.lang.String threadId, long groupId, long companyId,
		java.lang.String title, java.lang.String description, boolean hasImage,
		java.lang.String image, java.lang.String language)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsThread returnValue = VcmsThreadServiceUtil.updateThread(threadId,
					groupId, companyId, title, description, hasImage, image,
					language);

			return com.vportal.portlet.vcms.model.VcmsThreadSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsThreadSoap updateThread(
		com.vportal.portlet.vcms.model.VcmsThread thread)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsThread returnValue = VcmsThreadServiceUtil.updateThread(thread);

			return com.vportal.portlet.vcms.model.VcmsThreadSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteThread(java.lang.String threadId)
		throws RemoteException {
		try {
			VcmsThreadServiceUtil.deleteThread(threadId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsThreadSoap getThread(
		java.lang.String threadId) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsThread returnValue = VcmsThreadServiceUtil.getThread(threadId);

			return com.vportal.portlet.vcms.model.VcmsThreadSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsThread[] getThreads(
		java.lang.String[] threadIds) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsThread> returnValue =
				VcmsThreadServiceUtil.getThreads(threadIds);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsThread[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsThread[] getThreadsByP_L(
		long groupId, java.lang.String language) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsThread> returnValue =
				VcmsThreadServiceUtil.getThreadsByP_L(groupId, language);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsThread[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsThread[] getThreadsByP_L(
		long groupId, java.lang.String language, int begin, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsThread> returnValue =
				VcmsThreadServiceUtil.getThreadsByP_L(groupId, language, begin,
					end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsThread[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countThreadsByP_L(long groupId, java.lang.String language)
		throws RemoteException {
		try {
			int returnValue = VcmsThreadServiceUtil.countThreadsByP_L(groupId,
					language);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VcmsThreadServiceSoap.class);
}