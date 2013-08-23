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

package com.vportal.portlet.vcms.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author hai
 */
public class VcmsThreadServiceClp implements VcmsThreadService {
	public VcmsThreadServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addThreadMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addThread", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String[].class, java.lang.String[].class);

		_addThreadMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"addThread", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String[].class, java.lang.String[].class);

		_addThreadResourcesMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"addThreadResources", java.lang.String.class, boolean.class,
				boolean.class);

		_addThreadResourcesMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"addThreadResources",
				com.vportal.portlet.vcms.model.VcmsThread.class, boolean.class,
				boolean.class);

		_addThreadResourcesMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"addThreadResources", java.lang.String.class,
				java.lang.String[].class, java.lang.String[].class);

		_addThreadResourcesMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"addThreadResources",
				com.vportal.portlet.vcms.model.VcmsThread.class,
				java.lang.String[].class, java.lang.String[].class);

		_updateThreadMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateThread", java.lang.String.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				java.lang.String.class, java.lang.String.class);

		_updateThreadMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateThread", com.vportal.portlet.vcms.model.VcmsThread.class);

		_deleteThreadMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteThread", java.lang.String.class);

		_getThreadMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThread", java.lang.String.class);

		_getThreadsMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThreads", java.lang.String[].class);

		_getThreadsByP_LMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThreadsByP_L", long.class, java.lang.String.class);

		_getThreadsByP_LMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThreadsByP_L", long.class, java.lang.String.class,
				int.class, int.class);

		_countThreadsByP_LMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"countThreadsByP_L", long.class, java.lang.String.class);
	}

	public com.vportal.portlet.vcms.model.VcmsThread addThread(long groupId,
		long companyId, long plid, java.lang.String title,
		java.lang.String description, boolean hasImage, java.lang.String image,
		java.lang.String language, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addThreadMethodKey0,
				groupId, companyId, plid, ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(description), hasImage,
				ClpSerializer.translateInput(image),
				ClpSerializer.translateInput(language),
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

		return (com.vportal.portlet.vcms.model.VcmsThread)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vcms.model.VcmsThread addThread(long groupId,
		long companyId, long plid, java.lang.String title,
		java.lang.String description, boolean hasImage, java.lang.String image,
		java.lang.String language, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addThreadMethodKey1,
				groupId, companyId, plid, ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(description), hasImage,
				ClpSerializer.translateInput(image),
				ClpSerializer.translateInput(language),
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

		return (com.vportal.portlet.vcms.model.VcmsThread)ClpSerializer.translateOutput(returnObj);
	}

	public void addThreadResources(java.lang.String threadId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addThreadResourcesMethodKey2,
				ClpSerializer.translateInput(threadId),
				addCommunityPermissions, addGuestPermissions);

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

	public void addThreadResources(
		com.vportal.portlet.vcms.model.VcmsThread thread,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addThreadResourcesMethodKey3,
				ClpSerializer.translateInput(thread), addCommunityPermissions,
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

	public void addThreadResources(java.lang.String threadId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addThreadResourcesMethodKey4,
				ClpSerializer.translateInput(threadId),
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

	public void addThreadResources(
		com.vportal.portlet.vcms.model.VcmsThread thread,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addThreadResourcesMethodKey5,
				ClpSerializer.translateInput(thread),
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

	public com.vportal.portlet.vcms.model.VcmsThread updateThread(
		java.lang.String threadId, long groupId, long companyId,
		java.lang.String title, java.lang.String description, boolean hasImage,
		java.lang.String image, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateThreadMethodKey6,
				ClpSerializer.translateInput(threadId), groupId, companyId,
				ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(description), hasImage,
				ClpSerializer.translateInput(image),
				ClpSerializer.translateInput(language));

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

		return (com.vportal.portlet.vcms.model.VcmsThread)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vcms.model.VcmsThread updateThread(
		com.vportal.portlet.vcms.model.VcmsThread thread)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateThreadMethodKey7,
				ClpSerializer.translateInput(thread));

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

		return (com.vportal.portlet.vcms.model.VcmsThread)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteThread(java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteThreadMethodKey8,
				ClpSerializer.translateInput(threadId));

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

	public com.vportal.portlet.vcms.model.VcmsThread getThread(
		java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThreadMethodKey9,
				ClpSerializer.translateInput(threadId));

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

		return (com.vportal.portlet.vcms.model.VcmsThread)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsThread> getThreads(
		java.lang.String[] threadIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThreadsMethodKey10,
				ClpSerializer.translateInput(threadIds));

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsThread>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsThread> getThreadsByP_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThreadsByP_LMethodKey11,
				groupId, ClpSerializer.translateInput(language));

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsThread>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsThread> getThreadsByP_L(
		long groupId, java.lang.String language, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThreadsByP_LMethodKey12,
				groupId, ClpSerializer.translateInput(language), begin, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsThread>)ClpSerializer.translateOutput(returnObj);
	}

	public int countThreadsByP_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countThreadsByP_LMethodKey13,
				groupId, ClpSerializer.translateInput(language));

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

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addThreadMethodKey0;
	private MethodKey _addThreadMethodKey1;
	private MethodKey _addThreadResourcesMethodKey2;
	private MethodKey _addThreadResourcesMethodKey3;
	private MethodKey _addThreadResourcesMethodKey4;
	private MethodKey _addThreadResourcesMethodKey5;
	private MethodKey _updateThreadMethodKey6;
	private MethodKey _updateThreadMethodKey7;
	private MethodKey _deleteThreadMethodKey8;
	private MethodKey _getThreadMethodKey9;
	private MethodKey _getThreadsMethodKey10;
	private MethodKey _getThreadsByP_LMethodKey11;
	private MethodKey _getThreadsByP_LMethodKey12;
	private MethodKey _countThreadsByP_LMethodKey13;
}