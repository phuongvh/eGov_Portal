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

package com.vportal.portlet.vadvman.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author DucNN
 */
public class AdvItemServiceClp implements AdvItemService {
	public AdvItemServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addItemMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addItem", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, java.lang.String.class,
				boolean.class, long.class, long.class, java.util.Date.class,
				java.lang.String[].class, java.lang.String[].class);

		_addItemMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"addItem", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, java.lang.String.class,
				boolean.class, long.class, long.class, java.util.Date.class,
				java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String[].class, java.lang.String[].class);

		_updateItemMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateItem", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, java.lang.String.class,
				boolean.class, long.class, long.class, java.util.Date.class);

		_updateItemMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateItem", com.vportal.portlet.vadvman.model.AdvItem.class);

		_deleteItemMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteItem", long.class);

		_deleteItembyTypeMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteItembyType", long.class);

		_getItemMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItem", long.class);

		_getAllbyTypeMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllbyType", long.class);

		_getItemByGMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemByG", long.class);

		_getItemByGMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemByG", long.class, int.class, int.class);

		_countItemByGMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"countItemByG", long.class);

		_getItemByG_SMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemByG_S", long.class, boolean.class);

		_getItemByG_SMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemByG_S", long.class, boolean.class, int.class, int.class);

		_countItemByG_SMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"countItemByG_S", long.class, boolean.class);

		_countItemByG_TMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"countItemByG_T", long.class, long.class);

		_getItemByParamMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemByParam", long.class, java.lang.String.class,
				long.class, int.class, int.class, int.class);

		_countItemByParamMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"countItemByParam", long.class, java.lang.String.class,
				long.class, int.class);

		_addAdvItemResourcesMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"addAdvItemResources", long.class, boolean.class, boolean.class);

		_addAdvItemResourcesMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"addAdvItemResources",
				com.vportal.portlet.vadvman.model.AdvItem.class, boolean.class,
				boolean.class);

		_addAdvItemResourcesMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"addAdvItemResources", long.class, java.lang.String[].class,
				java.lang.String[].class);

		_addAdvItemResourcesMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"addAdvItemResources",
				com.vportal.portlet.vadvman.model.AdvItem.class,
				java.lang.String[].class, java.lang.String[].class);
	}

	public com.vportal.portlet.vadvman.model.AdvItem addItem(long groupId,
		long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String url,
		boolean isTargetBlank, java.lang.String txtMouseOver, boolean status,
		long typeId, long folderId, java.util.Date expriedDate,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addItemMethodKey0,
				groupId, companyId, plid, ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), isTargetBlank,
				ClpSerializer.translateInput(txtMouseOver), status, typeId,
				folderId, ClpSerializer.translateInput(expriedDate),
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

		return (com.vportal.portlet.vadvman.model.AdvItem)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vadvman.model.AdvItem addItem(long groupId,
		long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String url,
		boolean isTargetBlank, java.lang.String txtMouseOver, boolean status,
		long typeId, long folderId, java.util.Date expriedDate,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addItemMethodKey1,
				groupId, companyId, plid, ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), isTargetBlank,
				ClpSerializer.translateInput(txtMouseOver), status, typeId,
				folderId, ClpSerializer.translateInput(expriedDate),
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

		return (com.vportal.portlet.vadvman.model.AdvItem)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vadvman.model.AdvItem updateItem(long itemId,
		long groupId, long companyId, java.lang.String name,
		java.lang.String description, java.lang.String url,
		boolean isTargetBlank, java.lang.String txtMouseOver, boolean status,
		long typeId, long folderId, java.util.Date expriedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateItemMethodKey2,
				itemId, groupId, companyId, ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(url), isTargetBlank,
				ClpSerializer.translateInput(txtMouseOver), status, typeId,
				folderId, ClpSerializer.translateInput(expriedDate));

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

		return (com.vportal.portlet.vadvman.model.AdvItem)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vadvman.model.AdvItem updateItem(
		com.vportal.portlet.vadvman.model.AdvItem advItem)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateItemMethodKey3,
				ClpSerializer.translateInput(advItem));

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

		return (com.vportal.portlet.vadvman.model.AdvItem)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteItemMethodKey4,
				itemId);

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

	public void deleteItembyType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteItembyTypeMethodKey5,
				typeId);

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

	public com.vportal.portlet.vadvman.model.AdvItem getItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemMethodKey6,
				itemId);

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

		return (com.vportal.portlet.vadvman.model.AdvItem)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getAllbyType(
		long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllbyTypeMethodKey7,
				typeId);

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

		return (java.util.List<com.vportal.portlet.vadvman.model.AdvItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemByGMethodKey8,
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

		return (java.util.List<com.vportal.portlet.vadvman.model.AdvItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemByGMethodKey9,
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

		return (java.util.List<com.vportal.portlet.vadvman.model.AdvItem>)ClpSerializer.translateOutput(returnObj);
	}

	public int countItemByG(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countItemByGMethodKey10,
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

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG_S(
		long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemByG_SMethodKey11,
				groupId, status);

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

		return (java.util.List<com.vportal.portlet.vadvman.model.AdvItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByG_S(
		long groupId, boolean status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemByG_SMethodKey12,
				groupId, status, start, end);

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

		return (java.util.List<com.vportal.portlet.vadvman.model.AdvItem>)ClpSerializer.translateOutput(returnObj);
	}

	public int countItemByG_S(long groupId, boolean status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countItemByG_SMethodKey13,
				groupId, status);

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

	public int countItemByG_T(long groupId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countItemByG_TMethodKey14,
				groupId, typeId);

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

	public java.util.List<com.vportal.portlet.vadvman.model.AdvItem> getItemByParam(
		long groupId, java.lang.String description, long typeId, int status,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemByParamMethodKey15,
				groupId, ClpSerializer.translateInput(description), typeId,
				status, begin, end);

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

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vadvman.model.AdvItem>)ClpSerializer.translateOutput(returnObj);
	}

	public int countItemByParam(long groupId, java.lang.String description,
		long typeId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countItemByParamMethodKey16,
				groupId, ClpSerializer.translateInput(description), typeId,
				status);

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

	public void addAdvItemResources(long itemId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addAdvItemResourcesMethodKey17,
				itemId, addCommunityPermissions, addGuestPermissions);

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

	public void addAdvItemResources(
		com.vportal.portlet.vadvman.model.AdvItem item,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addAdvItemResourcesMethodKey18,
				ClpSerializer.translateInput(item), addCommunityPermissions,
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

	public void addAdvItemResources(long itemId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addAdvItemResourcesMethodKey19,
				itemId, ClpSerializer.translateInput(communityPermissions),
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

	public void addAdvItemResources(
		com.vportal.portlet.vadvman.model.AdvItem item,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addAdvItemResourcesMethodKey20,
				ClpSerializer.translateInput(item),
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
	private MethodKey _addItemMethodKey0;
	private MethodKey _addItemMethodKey1;
	private MethodKey _updateItemMethodKey2;
	private MethodKey _updateItemMethodKey3;
	private MethodKey _deleteItemMethodKey4;
	private MethodKey _deleteItembyTypeMethodKey5;
	private MethodKey _getItemMethodKey6;
	private MethodKey _getAllbyTypeMethodKey7;
	private MethodKey _getItemByGMethodKey8;
	private MethodKey _getItemByGMethodKey9;
	private MethodKey _countItemByGMethodKey10;
	private MethodKey _getItemByG_SMethodKey11;
	private MethodKey _getItemByG_SMethodKey12;
	private MethodKey _countItemByG_SMethodKey13;
	private MethodKey _countItemByG_TMethodKey14;
	private MethodKey _getItemByParamMethodKey15;
	private MethodKey _countItemByParamMethodKey16;
	private MethodKey _addAdvItemResourcesMethodKey17;
	private MethodKey _addAdvItemResourcesMethodKey18;
	private MethodKey _addAdvItemResourcesMethodKey19;
	private MethodKey _addAdvItemResourcesMethodKey20;
}