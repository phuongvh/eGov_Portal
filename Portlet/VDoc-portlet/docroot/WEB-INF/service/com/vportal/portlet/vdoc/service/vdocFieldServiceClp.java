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
public class vdocFieldServiceClp implements vdocFieldService {
	public vdocFieldServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addFieldMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addField", long.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, int.class,
				java.lang.String.class, java.lang.String[].class,
				java.lang.String[].class,
				com.liferay.portal.theme.ThemeDisplay.class);

		_addFieldMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"addField", long.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, int.class,
				java.lang.String.class, java.lang.Boolean.class,
				java.lang.Boolean.class, java.lang.String[].class,
				java.lang.String[].class,
				com.liferay.portal.theme.ThemeDisplay.class);

		_updateFieldMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateField", com.vportal.portlet.vdoc.model.vdocField.class,
				long.class);

		_updateFieldMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateField", java.lang.String.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				int.class, java.lang.String.class, long.class);

		_deleteFieldMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteField", java.lang.String.class);

		_getFieldMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"getField", java.lang.String.class);

		_getFieldByParentIdMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFieldByParentId", java.lang.String.class);

		_getFieldByG_LMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFieldByG_L", long.class, java.lang.String.class);

		_getFieldByG_L_PMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFieldByG_L_P", long.class, java.lang.String.class,
				java.lang.String.class);

		_getFieldByG_L_PMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFieldByG_L_P", long.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_getFieldByG_LMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFieldByG_L", long.class, java.lang.String.class, int.class,
				int.class);

		_countFieldByG_LMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"countFieldByG_L", long.class, java.lang.String.class);

		_countFieldByG_L_PMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"countFieldByG_L_P", long.class, java.lang.String.class,
				java.lang.String.class);

		_addEntryResourcesMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources", long.class, boolean.class, boolean.class);

		_addEntryResourcesMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources",
				com.vportal.portlet.vdoc.model.vdocField.class, boolean.class,
				boolean.class);

		_addEntryResourcesMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources", long.class, java.lang.String[].class,
				java.lang.String[].class);

		_addEntryResourcesMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources",
				com.vportal.portlet.vdoc.model.vdocField.class,
				java.lang.String[].class, java.lang.String[].class);
	}

	public com.vportal.portlet.vdoc.model.vdocField addField(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		boolean statusField, int position, java.lang.String listparent,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addFieldMethodKey0,
				groupId, userId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description), statusField,
				position, ClpSerializer.translateInput(listparent),
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

		return (com.vportal.portlet.vdoc.model.vdocField)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocField addField(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		boolean statusField, int position, java.lang.String listparent,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addFieldMethodKey1,
				groupId, userId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description), statusField,
				position, ClpSerializer.translateInput(listparent),
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

		return (com.vportal.portlet.vdoc.model.vdocField)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocField updateField(
		com.vportal.portlet.vdoc.model.vdocField field, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateFieldMethodKey2,
				ClpSerializer.translateInput(field), userId);

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

			if (t instanceof com.vportal.portlet.vdoc.NoSuchvdocFieldException) {
				throw (com.vportal.portlet.vdoc.NoSuchvdocFieldException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vdoc.model.vdocField)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocField updateField(
		java.lang.String fieldId, long groupId, java.lang.String language,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean statusField, int position,
		java.lang.String listparent, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateFieldMethodKey3,
				ClpSerializer.translateInput(fieldId), groupId,
				ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description), statusField,
				position, ClpSerializer.translateInput(listparent), userId);

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

			if (t instanceof com.vportal.portlet.vdoc.NoSuchvdocFieldException) {
				throw (com.vportal.portlet.vdoc.NoSuchvdocFieldException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vdoc.model.vdocField)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteField(java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteFieldMethodKey4,
				ClpSerializer.translateInput(fieldId));

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

	public com.vportal.portlet.vdoc.model.vdocField getField(
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocFieldException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFieldMethodKey5,
				ClpSerializer.translateInput(fieldId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.vportal.portlet.vdoc.NoSuchvdocFieldException) {
				throw (com.vportal.portlet.vdoc.NoSuchvdocFieldException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vdoc.model.vdocField)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByParentId(
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFieldByParentIdMethodKey6,
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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocField>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFieldByG_LMethodKey7,
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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocField>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFieldByG_L_PMethodKey8,
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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocField>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFieldByG_L_PMethodKey9,
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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocField>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocField> getFieldByG_L(
		long groupId, java.lang.String language, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFieldByG_LMethodKey10,
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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocField>)ClpSerializer.translateOutput(returnObj);
	}

	public int countFieldByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countFieldByG_LMethodKey11,
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

	public int countFieldByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countFieldByG_L_PMethodKey12,
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
		com.vportal.portlet.vdoc.model.vdocField entry,
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
		com.vportal.portlet.vdoc.model.vdocField entry,
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
	private MethodKey _addFieldMethodKey0;
	private MethodKey _addFieldMethodKey1;
	private MethodKey _updateFieldMethodKey2;
	private MethodKey _updateFieldMethodKey3;
	private MethodKey _deleteFieldMethodKey4;
	private MethodKey _getFieldMethodKey5;
	private MethodKey _getFieldByParentIdMethodKey6;
	private MethodKey _getFieldByG_LMethodKey7;
	private MethodKey _getFieldByG_L_PMethodKey8;
	private MethodKey _getFieldByG_L_PMethodKey9;
	private MethodKey _getFieldByG_LMethodKey10;
	private MethodKey _countFieldByG_LMethodKey11;
	private MethodKey _countFieldByG_L_PMethodKey12;
	private MethodKey _addEntryResourcesMethodKey13;
	private MethodKey _addEntryResourcesMethodKey14;
	private MethodKey _addEntryResourcesMethodKey15;
	private MethodKey _addEntryResourcesMethodKey16;
}