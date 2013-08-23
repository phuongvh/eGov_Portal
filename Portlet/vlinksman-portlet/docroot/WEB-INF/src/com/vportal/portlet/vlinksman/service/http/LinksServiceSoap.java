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

import com.vportal.portlet.vlinksman.service.LinksServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vlinksman.service.LinksServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vlinksman.model.LinksSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vlinksman.model.Links}, that is translated to a
 * {@link com.vportal.portlet.vlinksman.model.LinksSoap}. Methods that SOAP cannot
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
 * @see       LinksServiceHttp
 * @see       com.vportal.portlet.vlinksman.model.LinksSoap
 * @see       com.vportal.portlet.vlinksman.service.LinksServiceUtil
 * @generated
 */
public class LinksServiceSoap {
	public static com.vportal.portlet.vlinksman.model.LinksSoap addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, long position, long userId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.addLinks(groupId,
					companyId, plid, linkgroupId, name, description, url,
					position, userId, communityPermissions, guestPermissions);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, long position, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.addLinks(groupId,
					companyId, plid, linkgroupId, name, description, url,
					position, userId, addCommunityPermissions,
					addGuestPermissions, communityPermissions, guestPermissions);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, int position, long userId,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.addLinks(groupId,
					companyId, plid, linkgroupId, name, description, url,
					position, userId, hasImage, isTargetBlank, imageName,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, int position, long userId,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.addLinks(groupId,
					companyId, plid, linkgroupId, name, description, url,
					position, userId, hasImage, isTargetBlank, imageName,
					addCommunityPermissions, addGuestPermissions,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, int position, long userId,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName, long folderId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.addLinks(groupId,
					companyId, plid, linkgroupId, name, description, url,
					position, userId, hasImage, isTargetBlank, imageName,
					folderId, communityPermissions, guestPermissions);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap addLinks(
		long groupId, long companyId, long plid, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, int position, long userId,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName, long folderId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.addLinks(groupId,
					companyId, plid, linkgroupId, name, description, url,
					position, userId, hasImage, isTargetBlank, imageName,
					folderId, addCommunityPermissions, addGuestPermissions,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap addLinks(
		com.vportal.portlet.vlinksman.model.Links link, long plid,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.addLinks(link,
					plid, addCommunityPermissions, addGuestPermissions,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap updateLinks(
		com.vportal.portlet.vlinksman.model.Links link)
		throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.updateLinks(link);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap updateLinks(
		long linkId, long groupId, long companyId, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, long position) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.updateLinks(linkId,
					groupId, companyId, linkgroupId, name, description, url,
					position);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap updateLink(
		com.vportal.portlet.vlinksman.model.Links link)
		throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.updateLink(link);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap updateLinks(
		long linkId, long groupId, long companyId, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, long position, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName)
		throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.updateLinks(linkId,
					groupId, companyId, linkgroupId, name, description, url,
					position, hasImage, isTargetBlank, imageName);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap updateLinks(
		long linkId, long groupId, long companyId, long linkgroupId,
		java.lang.String name, java.lang.String description,
		java.lang.String url, long position, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName,
		long folderId) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.updateLinks(linkId,
					groupId, companyId, linkgroupId, name, description, url,
					position, hasImage, isTargetBlank, imageName, folderId);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap updateLink2(
		com.vportal.portlet.vlinksman.model.Links link)
		throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.updateLink2(link);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap updateLink3(
		com.vportal.portlet.vlinksman.model.Links link)
		throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.updateLink3(link);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteLink(long linkId) throws RemoteException {
		try {
			LinksServiceUtil.deleteLink(linkId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getAll() throws RemoteException {
		try {
			java.util.List returnValue = LinksServiceUtil.getAll();

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getByLinkGroupId(long linkGroupId)
		throws RemoteException {
		try {
			java.util.List returnValue = LinksServiceUtil.getByLinkGroupId(linkGroupId);

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
			java.util.List returnValue = LinksServiceUtil.getByGroupId(groupId);

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
			java.util.List returnValue = LinksServiceUtil.getByGroupId(groupId,
					start, end);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByGroupId(long groupId) throws RemoteException {
		try {
			int returnValue = LinksServiceUtil.countByGroupId(groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getByLinkG_GL(long groupId, long linkGroupId)
		throws RemoteException {
		try {
			java.util.List returnValue = LinksServiceUtil.getByLinkG_GL(groupId,
					linkGroupId);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getByLinkG_GL(long groupId,
		long linkGroupId, int start, int end) throws RemoteException {
		try {
			java.util.List returnValue = LinksServiceUtil.getByLinkG_GL(groupId,
					linkGroupId, start, end);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vlinksman.model.LinksSoap getLinks(
		long linkId) throws RemoteException {
		try {
			com.vportal.portlet.vlinksman.model.Links returnValue = LinksServiceUtil.getLinks(linkId);

			return com.vportal.portlet.vlinksman.model.LinksSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addLinksResources(long linkId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			LinksServiceUtil.addLinksResources(linkId, addCommunityPermissions,
				addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addLinksResources(
		com.vportal.portlet.vlinksman.model.Links link,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			LinksServiceUtil.addLinksResources(link, addCommunityPermissions,
				addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addLinksResources(long linkId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			LinksServiceUtil.addLinksResources(linkId, communityPermissions,
				guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addLinksResources(
		com.vportal.portlet.vlinksman.model.Links link,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			LinksServiceUtil.addLinksResources(link, communityPermissions,
				guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void _validate(java.lang.String name, java.lang.String url)
		throws RemoteException {
		try {
			LinksServiceUtil._validate(name, url);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LinksServiceSoap.class);
}