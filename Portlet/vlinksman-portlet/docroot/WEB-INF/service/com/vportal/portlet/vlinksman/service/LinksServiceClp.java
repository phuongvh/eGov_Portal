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

package com.vportal.portlet.vlinksman.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author LongLH
 */
public class LinksServiceClp implements LinksService {
	public LinksServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addLinksMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLinks", long.class, long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class, long.class,
				java.lang.String[].class, java.lang.String[].class);

		_addLinksMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLinks", long.class, long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class, long.class,
				java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String[].class, java.lang.String[].class);

		_addLinksMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLinks", long.class, long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, long.class,
				java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String.class, java.lang.String[].class,
				java.lang.String[].class);

		_addLinksMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLinks", long.class, long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, long.class,
				java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String.class, java.lang.Boolean.class,
				java.lang.Boolean.class, java.lang.String[].class,
				java.lang.String[].class);

		_addLinksMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLinks", long.class, long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, long.class,
				java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String.class, long.class, java.lang.String[].class,
				java.lang.String[].class);

		_addLinksMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLinks", long.class, long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, long.class,
				java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String.class, long.class, java.lang.Boolean.class,
				java.lang.Boolean.class, java.lang.String[].class,
				java.lang.String[].class);

		_addLinksMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLinks", com.vportal.portlet.vlinksman.model.Links.class,
				long.class, java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String[].class, java.lang.String[].class);

		_updateLinksMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLinks", com.vportal.portlet.vlinksman.model.Links.class);

		_updateLinksMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLinks", long.class, long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class);

		_updateLinkMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLink", com.vportal.portlet.vlinksman.model.Links.class);

		_updateLinksMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLinks", long.class, long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class, java.lang.Boolean.class,
				java.lang.Boolean.class, java.lang.String.class);

		_updateLinksMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLinks", long.class, long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class, java.lang.Boolean.class,
				java.lang.Boolean.class, java.lang.String.class, long.class);

		_updateLink2MethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLink2", com.vportal.portlet.vlinksman.model.Links.class);

		_updateLink3MethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLink3", com.vportal.portlet.vlinksman.model.Links.class);

		_deleteLinkMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteLink", long.class);

		_getAllMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAll");

		_getByLinkGroupIdMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByLinkGroupId", long.class);

		_getByGroupIdMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByGroupId", long.class);

		_getByGroupIdMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByGroupId", long.class, int.class, int.class);

		_countByGroupIdMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByGroupId", long.class);

		_getByLinkG_GLMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByLinkG_GL", long.class, long.class);

		_getByLinkG_GLMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByLinkG_GL", long.class, long.class, int.class, int.class);

		_getLinksMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLinks", long.class);

		_addLinksResourcesMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLinksResources", long.class, boolean.class, boolean.class);

		_addLinksResourcesMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLinksResources",
				com.vportal.portlet.vlinksman.model.Links.class, boolean.class,
				boolean.class);

		_addLinksResourcesMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLinksResources", long.class, java.lang.String[].class,
				java.lang.String[].class);

		_addLinksResourcesMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLinksResources",
				com.vportal.portlet.vlinksman.model.Links.class,
				java.lang.String[].class, java.lang.String[].class);

		__validateMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"_validate", java.lang.String.class, java.lang.String.class);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, long position,
		long userId, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addLinksMethodKey0,
				groupId, companyId, plid, linkgroupId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), position, userId,
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, long position,
		long userId, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addLinksMethodKey1,
				groupId, companyId, plid, linkgroupId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), position, userId,
				ClpSerializer.translateInput(addCommunityPermissions),
				ClpSerializer.translateInput(addGuestPermissions),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, int position,
		long userId, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addLinksMethodKey2,
				groupId, companyId, plid, linkgroupId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), position, userId,
				ClpSerializer.translateInput(hasImage),
				ClpSerializer.translateInput(isTargetBlank),
				ClpSerializer.translateInput(imageName),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, int position,
		long userId, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addLinksMethodKey3,
				groupId, companyId, plid, linkgroupId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), position, userId,
				ClpSerializer.translateInput(hasImage),
				ClpSerializer.translateInput(isTargetBlank),
				ClpSerializer.translateInput(imageName),
				ClpSerializer.translateInput(addCommunityPermissions),
				ClpSerializer.translateInput(addGuestPermissions),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, int position,
		long userId, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName,
		long folderId, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addLinksMethodKey4,
				groupId, companyId, plid, linkgroupId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), position, userId,
				ClpSerializer.translateInput(hasImage),
				ClpSerializer.translateInput(isTargetBlank),
				ClpSerializer.translateInput(imageName), folderId,
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(long groupId,
		long companyId, long plid, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, int position,
		long userId, java.lang.Boolean hasImage,
		java.lang.Boolean isTargetBlank, java.lang.String imageName,
		long folderId, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addLinksMethodKey5,
				groupId, companyId, plid, linkgroupId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), position, userId,
				ClpSerializer.translateInput(hasImage),
				ClpSerializer.translateInput(isTargetBlank),
				ClpSerializer.translateInput(imageName), folderId,
				ClpSerializer.translateInput(addCommunityPermissions),
				ClpSerializer.translateInput(addGuestPermissions),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links addLinks(
		com.vportal.portlet.vlinksman.model.Links link, long plid,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addLinksMethodKey6,
				ClpSerializer.translateInput(link), plid,
				ClpSerializer.translateInput(addCommunityPermissions),
				ClpSerializer.translateInput(addGuestPermissions),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
				throw (com.liferay.portal.security.auth.PrincipalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLinks(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLinksMethodKey7,
				ClpSerializer.translateInput(link));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
				throw (com.liferay.portal.security.auth.PrincipalException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLinks(long linkId,
		long groupId, long companyId, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, long position)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLinksMethodKey8,
				linkId, groupId, companyId, linkgroupId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), position);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLink(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLinkMethodKey9,
				ClpSerializer.translateInput(link));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLinks(long linkId,
		long groupId, long companyId, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, long position,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLinksMethodKey10,
				linkId, groupId, companyId, linkgroupId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), position,
				ClpSerializer.translateInput(hasImage),
				ClpSerializer.translateInput(isTargetBlank),
				ClpSerializer.translateInput(imageName));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLinks(long linkId,
		long groupId, long companyId, long linkgroupId, java.lang.String name,
		java.lang.String description, java.lang.String url, long position,
		java.lang.Boolean hasImage, java.lang.Boolean isTargetBlank,
		java.lang.String imageName, long folderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLinksMethodKey11,
				linkId, groupId, companyId, linkgroupId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), position,
				ClpSerializer.translateInput(hasImage),
				ClpSerializer.translateInput(isTargetBlank),
				ClpSerializer.translateInput(imageName), folderId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLink2(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLink2MethodKey12,
				ClpSerializer.translateInput(link));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links updateLink3(
		com.vportal.portlet.vlinksman.model.Links link)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLink3MethodKey13,
				ClpSerializer.translateInput(link));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteLinkMethodKey14,
				linkId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllMethodKey15);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List getByLinkGroupId(long linkGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByLinkGroupIdMethodKey16,
				linkGroupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List getByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByGroupIdMethodKey17,
				groupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List getByGroupId(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByGroupIdMethodKey18,
				groupId, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByGroupIdMethodKey19,
				groupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List getByLinkG_GL(long groupId, long linkGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByLinkG_GLMethodKey20,
				groupId, linkGroupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List getByLinkG_GL(long groupId, long linkGroupId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByLinkG_GLMethodKey21,
				groupId, linkGroupId, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vlinksman.model.Links getLinks(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLinksMethodKey22,
				linkId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vlinksman.model.Links)ClpSerializer.translateOutput(returnObj);
	}

	public void addLinksResources(long linkId, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addLinksResourcesMethodKey23,
				linkId, addCommunityPermissions, addGuestPermissions);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addLinksResources(
		com.vportal.portlet.vlinksman.model.Links link,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addLinksResourcesMethodKey24,
				ClpSerializer.translateInput(link), addCommunityPermissions,
				addGuestPermissions);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addLinksResources(long linkId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addLinksResourcesMethodKey25,
				linkId, ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addLinksResources(
		com.vportal.portlet.vlinksman.model.Links link,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addLinksResourcesMethodKey26,
				ClpSerializer.translateInput(link),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void _validate(java.lang.String name, java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(__validateMethodKey27,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(url));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addLinksMethodKey0;
	private MethodKey _addLinksMethodKey1;
	private MethodKey _addLinksMethodKey2;
	private MethodKey _addLinksMethodKey3;
	private MethodKey _addLinksMethodKey4;
	private MethodKey _addLinksMethodKey5;
	private MethodKey _addLinksMethodKey6;
	private MethodKey _updateLinksMethodKey7;
	private MethodKey _updateLinksMethodKey8;
	private MethodKey _updateLinkMethodKey9;
	private MethodKey _updateLinksMethodKey10;
	private MethodKey _updateLinksMethodKey11;
	private MethodKey _updateLink2MethodKey12;
	private MethodKey _updateLink3MethodKey13;
	private MethodKey _deleteLinkMethodKey14;
	private MethodKey _getAllMethodKey15;
	private MethodKey _getByLinkGroupIdMethodKey16;
	private MethodKey _getByGroupIdMethodKey17;
	private MethodKey _getByGroupIdMethodKey18;
	private MethodKey _countByGroupIdMethodKey19;
	private MethodKey _getByLinkG_GLMethodKey20;
	private MethodKey _getByLinkG_GLMethodKey21;
	private MethodKey _getLinksMethodKey22;
	private MethodKey _addLinksResourcesMethodKey23;
	private MethodKey _addLinksResourcesMethodKey24;
	private MethodKey _addLinksResourcesMethodKey25;
	private MethodKey _addLinksResourcesMethodKey26;
	private MethodKey __validateMethodKey27;
}