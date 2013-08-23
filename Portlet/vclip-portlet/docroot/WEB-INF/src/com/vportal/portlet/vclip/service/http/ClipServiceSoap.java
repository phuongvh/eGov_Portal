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

import com.vportal.portlet.vclip.service.ClipServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vclip.service.ClipServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vclip.model.ClipSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vclip.model.Clip}, that is translated to a
 * {@link com.vportal.portlet.vclip.model.ClipSoap}. Methods that SOAP cannot
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
 * @see       ClipServiceHttp
 * @see       com.vportal.portlet.vclip.model.ClipSoap
 * @see       com.vportal.portlet.vclip.service.ClipServiceUtil
 * @generated
 */
public class ClipServiceSoap {
	public static com.vportal.portlet.vclip.model.ClipSoap addClip(
		long groupId, long companyId, long plid,
		com.vportal.portlet.vclip.model.Clip clip,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vclip.model.Clip returnValue = ClipServiceUtil.addClip(groupId,
					companyId, plid, clip, addCommunityPermissions,
					addGuestPermissions, communityPermissions, guestPermissions);

			return com.vportal.portlet.vclip.model.ClipSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipSoap updateClip(
		long groupId, long companyId, java.lang.String clipId,
		com.vportal.portlet.vclip.model.Clip clip) throws RemoteException {
		try {
			com.vportal.portlet.vclip.model.Clip returnValue = ClipServiceUtil.updateClip(groupId,
					companyId, clipId, clip);

			return com.vportal.portlet.vclip.model.ClipSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteClip(com.vportal.portlet.vclip.model.Clip clip)
		throws RemoteException {
		try {
			ClipServiceUtil.deleteClip(clip);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteClip(java.lang.String clipId)
		throws RemoteException {
		try {
			ClipServiceUtil.deleteClip(clipId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipSoap increaseHitCount(
		java.lang.String clipId) throws RemoteException {
		try {
			com.vportal.portlet.vclip.model.Clip returnValue = ClipServiceUtil.increaseHitCount(clipId);

			return com.vportal.portlet.vclip.model.ClipSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipSoap increaseHitCountView(
		java.lang.String clipId) throws RemoteException {
		try {
			com.vportal.portlet.vclip.model.Clip returnValue = ClipServiceUtil.increaseHitCountView(clipId);

			return com.vportal.portlet.vclip.model.ClipSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipSoap findById(
		java.lang.String clipId) throws RemoteException {
		try {
			com.vportal.portlet.vclip.model.Clip returnValue = ClipServiceUtil.findById(clipId);

			return com.vportal.portlet.vclip.model.ClipSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.Clip[] findByClipTypeId(
		java.lang.String clipTypeId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.Clip> returnValue = ClipServiceUtil.findByClipTypeId(clipTypeId);

			return returnValue.toArray(new com.vportal.portlet.vclip.model.Clip[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.Clip[] findByClipTypeId(
		java.lang.String clipTypeId, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.Clip> returnValue = ClipServiceUtil.findByClipTypeId(clipTypeId,
					start, end);

			return returnValue.toArray(new com.vportal.portlet.vclip.model.Clip[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByClipTypeId(java.lang.String clipTypeId)
		throws RemoteException {
		try {
			int returnValue = ClipServiceUtil.countByClipTypeId(clipTypeId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.Clip[] findClip(
		com.vportal.portlet.vclip.model.Clip clip) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.Clip> returnValue = ClipServiceUtil.findClip(clip);

			return returnValue.toArray(new com.vportal.portlet.vclip.model.Clip[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.Clip[] findClip(
		com.vportal.portlet.vclip.model.Clip clip, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.Clip> returnValue = ClipServiceUtil.findClip(clip,
					start, end);

			return returnValue.toArray(new com.vportal.portlet.vclip.model.Clip[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countClip(com.vportal.portlet.vclip.model.Clip clip)
		throws RemoteException {
		try {
			int returnValue = ClipServiceUtil.countClip(clip);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.Clip[] searchClip(
		java.lang.String textSearch, java.lang.String clipTypeId)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.Clip> returnValue = ClipServiceUtil.searchClip(textSearch,
					clipTypeId);

			return returnValue.toArray(new com.vportal.portlet.vclip.model.Clip[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.Clip[] getAll()
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.Clip> returnValue = ClipServiceUtil.getAll();

			return returnValue.toArray(new com.vportal.portlet.vclip.model.Clip[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.Clip[] getAll(int begin,
		int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vclip.model.Clip> returnValue = ClipServiceUtil.getAll(begin,
					end);

			return returnValue.toArray(new com.vportal.portlet.vclip.model.Clip[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countAll() throws RemoteException {
		try {
			int returnValue = ClipServiceUtil.countAll();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean hasParent(java.lang.String clipTypeId)
		throws RemoteException {
		try {
			boolean returnValue = ClipServiceUtil.hasParent(clipTypeId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipSoap getFirst()
		throws RemoteException {
		try {
			com.vportal.portlet.vclip.model.Clip returnValue = ClipServiceUtil.getFirst();

			return com.vportal.portlet.vclip.model.ClipSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vclip.model.ClipSoap getByClipTypeId(
		java.lang.String clipTypeId) throws RemoteException {
		try {
			com.vportal.portlet.vclip.model.Clip returnValue = ClipServiceUtil.getByClipTypeId(clipTypeId);

			return com.vportal.portlet.vclip.model.ClipSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addClipResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			ClipServiceUtil.addClipResources(articleId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addClipResources(
		com.vportal.portlet.vclip.model.Clip article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			ClipServiceUtil.addClipResources(article, addCommunityPermissions,
				addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addClipResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			ClipServiceUtil.addClipResources(articleId, communityPermissions,
				guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addClipResources(
		com.vportal.portlet.vclip.model.Clip article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			ClipServiceUtil.addClipResources(article, communityPermissions,
				guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClipServiceSoap.class);
}