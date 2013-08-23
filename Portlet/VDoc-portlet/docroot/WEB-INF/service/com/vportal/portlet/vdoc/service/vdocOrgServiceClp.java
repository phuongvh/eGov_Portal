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

package com.vportal.portlet.vdoc.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author MrEn
 */
public class vdocOrgServiceClp implements vdocOrgService {
	public vdocOrgServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addOrgMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addOrg", long.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, int.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String[].class, java.lang.String[].class,
				com.liferay.portal.theme.ThemeDisplay.class);

		_addOrgMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"addOrg", long.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, int.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String[].class, java.lang.String[].class,
				com.liferay.portal.theme.ThemeDisplay.class);

		_updateOrgMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateOrg", com.vportal.portlet.vdoc.model.vdocOrg.class,
				long.class);

		_updateOrgMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateOrg", java.lang.String.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				int.class, java.lang.String.class, java.lang.String.class,
				long.class);

		_deleteOrgMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteOrg", java.lang.String.class);

		_getOrgMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"getOrg", java.lang.String.class);

		_getOrgByParentIdMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"getOrgByParentId", java.lang.String.class);

		_getOrgByG_LMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"getOrgByG_L", long.class, java.lang.String.class);

		_getOrgByG_LMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"getOrgByG_L", long.class, java.lang.String.class, int.class,
				int.class);

		_getOrgByG_L_PMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getOrgByG_L_P", long.class, java.lang.String.class,
				java.lang.String.class);

		_getOrgByG_L_PMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getOrgByG_L_P", long.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_countOrgByG_LMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"countOrgByG_L", long.class, java.lang.String.class);

		_countOrgByG_L_PMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"countOrgByG_L_P", long.class, java.lang.String.class,
				java.lang.String.class);

		_addEntryResourcesMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources", long.class, boolean.class, boolean.class);

		_addEntryResourcesMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources",
				com.vportal.portlet.vdoc.model.vdocOrg.class, boolean.class,
				boolean.class);

		_addEntryResourcesMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources", long.class, java.lang.String[].class,
				java.lang.String[].class);

		_addEntryResourcesMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources",
				com.vportal.portlet.vdoc.model.vdocOrg.class,
				java.lang.String[].class, java.lang.String[].class);
	}

	public com.vportal.portlet.vdoc.model.vdocOrg addOrg(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		java.lang.String address, java.lang.String phone, boolean statusOrg,
		int position, java.lang.String fax, java.lang.String listparent,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addOrgMethodKey0,
				groupId, userId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(address),
				ClpSerializer.translateInput(phone), statusOrg, position,
				ClpSerializer.translateInput(fax),
				ClpSerializer.translateInput(listparent),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions),
				ClpSerializer.translateInput(themeDisplay));

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

		return (com.vportal.portlet.vdoc.model.vdocOrg)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocOrg addOrg(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		java.lang.String address, java.lang.String phone, boolean statusOrg,
		int position, java.lang.String fax, java.lang.String listparent,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addOrgMethodKey1,
				groupId, userId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(address),
				ClpSerializer.translateInput(phone), statusOrg, position,
				ClpSerializer.translateInput(fax),
				ClpSerializer.translateInput(listparent),
				ClpSerializer.translateInput(addCommunityPermissions),
				ClpSerializer.translateInput(addGuestPermissions),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions),
				ClpSerializer.translateInput(themeDisplay));

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

		return (com.vportal.portlet.vdoc.model.vdocOrg)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocOrg updateOrg(
		com.vportal.portlet.vdoc.model.vdocOrg org, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateOrgMethodKey2,
				ClpSerializer.translateInput(org), userId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.NoSuchUserException) {
				throw (com.liferay.portal.NoSuchUserException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.vportal.portlet.vdoc.NoSuchvdocOrgException) {
				throw (com.vportal.portlet.vdoc.NoSuchvdocOrgException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vdoc.model.vdocOrg)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocOrg updateOrg(
		java.lang.String orgId, long groupId, java.lang.String language,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, java.lang.String address,
		java.lang.String phone, boolean statusOrg, int position,
		java.lang.String fax, java.lang.String listparent, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateOrgMethodKey3,
				ClpSerializer.translateInput(orgId), groupId,
				ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(address),
				ClpSerializer.translateInput(phone), statusOrg, position,
				ClpSerializer.translateInput(fax),
				ClpSerializer.translateInput(listparent), userId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.NoSuchUserException) {
				throw (com.liferay.portal.NoSuchUserException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.vportal.portlet.vdoc.NoSuchvdocOrgException) {
				throw (com.vportal.portlet.vdoc.NoSuchvdocOrgException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vdoc.model.vdocOrg)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteOrg(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.DeleteOrgException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		MethodHandler methodHandler = new MethodHandler(_deleteOrgMethodKey4,
				ClpSerializer.translateInput(orgId));

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

			if (t instanceof com.vportal.portlet.vdoc.DeleteOrgException) {
				throw (com.vportal.portlet.vdoc.DeleteOrgException)t;
			}

			if (t instanceof com.vportal.portlet.vdoc.NoSuchvdocOrgException) {
				throw (com.vportal.portlet.vdoc.NoSuchvdocOrgException)t;
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

	public com.vportal.portlet.vdoc.model.vdocOrg getOrg(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getOrgMethodKey5,
				ClpSerializer.translateInput(orgId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.vportal.portlet.vdoc.NoSuchvdocOrgException) {
				throw (com.vportal.portlet.vdoc.NoSuchvdocOrgException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vdoc.model.vdocOrg)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByParentId(
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getOrgByParentIdMethodKey6,
				ClpSerializer.translateInput(parentId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocOrg>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getOrgByG_LMethodKey7,
				groupId, ClpSerializer.translateInput(language));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocOrg>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L(
		long groupId, java.lang.String language, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getOrgByG_LMethodKey8,
				groupId, ClpSerializer.translateInput(language), begin, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocOrg>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getOrgByG_L_PMethodKey9,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(parentId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocOrg>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getOrgByG_L_PMethodKey10,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(parentId), begin, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocOrg>)ClpSerializer.translateOutput(returnObj);
	}

	public int countOrgByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countOrgByG_LMethodKey11,
				groupId, ClpSerializer.translateInput(language));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

		return ((Integer)returnObj).intValue();
	}

	public int countOrgByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countOrgByG_L_PMethodKey12,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(parentId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

		return ((Integer)returnObj).intValue();
	}

	public void addEntryResources(long entryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addEntryResourcesMethodKey13,
				entryId, addCommunityPermissions, addGuestPermissions);

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

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocOrg entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addEntryResourcesMethodKey14,
				ClpSerializer.translateInput(entry), addCommunityPermissions,
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

	public void addEntryResources(long entryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addEntryResourcesMethodKey15,
				entryId, ClpSerializer.translateInput(communityPermissions),
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

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocOrg entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addEntryResourcesMethodKey16,
				ClpSerializer.translateInput(entry),
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

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addOrgMethodKey0;
	private MethodKey _addOrgMethodKey1;
	private MethodKey _updateOrgMethodKey2;
	private MethodKey _updateOrgMethodKey3;
	private MethodKey _deleteOrgMethodKey4;
	private MethodKey _getOrgMethodKey5;
	private MethodKey _getOrgByParentIdMethodKey6;
	private MethodKey _getOrgByG_LMethodKey7;
	private MethodKey _getOrgByG_LMethodKey8;
	private MethodKey _getOrgByG_L_PMethodKey9;
	private MethodKey _getOrgByG_L_PMethodKey10;
	private MethodKey _countOrgByG_LMethodKey11;
	private MethodKey _countOrgByG_L_PMethodKey12;
	private MethodKey _addEntryResourcesMethodKey13;
	private MethodKey _addEntryResourcesMethodKey14;
	private MethodKey _addEntryResourcesMethodKey15;
	private MethodKey _addEntryResourcesMethodKey16;
}