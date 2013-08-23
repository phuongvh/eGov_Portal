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
public class VcmsDiscussionServiceClp implements VcmsDiscussionService {
	public VcmsDiscussionServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addDiscussionMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDiscussion", java.lang.String.class,
				java.lang.String.class, java.lang.String.class, long.class,
				long.class, java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, java.lang.String.class,
				boolean.class, boolean.class);

		_updateDiscussionMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDiscussion", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, boolean.class,
				java.lang.String.class);

		_updateDiscussionMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDiscussion",
				com.vportal.portlet.vcms.model.VcmsDiscussion.class);

		_deleteDiscussionMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDiscussion", java.lang.String.class);

		_deleteDiscussionsMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDiscussions", java.lang.String[].class);

		_deleteDiscussionsMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDiscussions", java.lang.String.class);

		_deleteDiscussionsMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDiscussions", java.lang.String.class, boolean.class);

		_getDiscussionMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDiscussion", java.lang.String.class);

		_getDiscussionsMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDiscussions", java.lang.String.class);

		_getDiscussionsMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDiscussions", java.lang.String.class, boolean.class);

		_getDiscussionsByP_LMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDiscussionsByP_L", long.class, java.lang.String.class);

		_getDiscussionsByP_L_AMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDiscussionsByP_L_A", long.class, java.lang.String.class,
				boolean.class);

		_getDiscussionsByA_P_L_AMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDiscussionsByA_P_L_A", java.lang.String.class, long.class,
				java.lang.String.class, boolean.class);

		_searchDiscussionByA_P_L_KMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchDiscussionByA_P_L_K", java.lang.String.class,
				long.class, java.lang.String.class, java.lang.String.class,
				boolean.class, boolean.class, boolean.class,
				java.lang.String.class);

		_countByApprovalMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByApproval", long.class, java.lang.String.class,
				boolean.class);
	}

	public com.vportal.portlet.vcms.model.VcmsDiscussion addDiscussion(
		java.lang.String visitorName, java.lang.String visitorEmail,
		java.lang.String visitorPhone, long groupId, long companyId,
		java.lang.String articleId, java.lang.String title,
		java.lang.String content, boolean hasAttachment,
		java.lang.String language, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDiscussionMethodKey0,
				ClpSerializer.translateInput(visitorName),
				ClpSerializer.translateInput(visitorEmail),
				ClpSerializer.translateInput(visitorPhone), groupId, companyId,
				ClpSerializer.translateInput(articleId),
				ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(content), hasAttachment,
				ClpSerializer.translateInput(language),
				addCommunityPermissions, addGuestPermissions);

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

		return (com.vportal.portlet.vcms.model.VcmsDiscussion)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vcms.model.VcmsDiscussion updateDiscussion(
		java.lang.String discussionId, java.lang.String visitorName,
		java.lang.String visitorEmail, java.lang.String visitorPhone,
		long groupId, long companyId, java.lang.String articleId,
		java.lang.String title, java.lang.String content,
		boolean hasAttachment, boolean approved, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDiscussionMethodKey1,
				ClpSerializer.translateInput(discussionId),
				ClpSerializer.translateInput(visitorName),
				ClpSerializer.translateInput(visitorEmail),
				ClpSerializer.translateInput(visitorPhone), groupId, companyId,
				ClpSerializer.translateInput(articleId),
				ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(content), hasAttachment, approved,
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

		return (com.vportal.portlet.vcms.model.VcmsDiscussion)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vcms.model.VcmsDiscussion updateDiscussion(
		com.vportal.portlet.vcms.model.VcmsDiscussion discussion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDiscussionMethodKey2,
				ClpSerializer.translateInput(discussion));

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

		return (com.vportal.portlet.vcms.model.VcmsDiscussion)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteDiscussion(java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteDiscussionMethodKey3,
				ClpSerializer.translateInput(discussionId));

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

	public void deleteDiscussions(java.lang.String[] discussionIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteDiscussionsMethodKey4,
				ClpSerializer.translateInput(discussionIds));

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

	public void deleteDiscussions(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteDiscussionsMethodKey5,
				ClpSerializer.translateInput(articleId));

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

	public void deleteDiscussions(java.lang.String articleId, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteDiscussionsMethodKey6,
				ClpSerializer.translateInput(articleId), approved);

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

	public com.vportal.portlet.vcms.model.VcmsDiscussion getDiscussion(
		java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDiscussionMethodKey7,
				ClpSerializer.translateInput(discussionId));

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

		return (com.vportal.portlet.vcms.model.VcmsDiscussion)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussions(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDiscussionsMethodKey8,
				ClpSerializer.translateInput(articleId));

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussions(
		java.lang.String articleId, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDiscussionsMethodKey9,
				ClpSerializer.translateInput(articleId), approved);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussionsByP_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDiscussionsByP_LMethodKey10,
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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussionsByP_L_A(
		long groupId, java.lang.String language, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDiscussionsByP_L_AMethodKey11,
				groupId, ClpSerializer.translateInput(language), approved);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussionsByA_P_L_A(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDiscussionsByA_P_L_AMethodKey12,
				ClpSerializer.translateInput(articleId), groupId,
				ClpSerializer.translateInput(language), approved);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> searchDiscussionByA_P_L_K(
		java.lang.String articleId, long groupId, java.lang.String language,
		java.lang.String keyword, boolean approved, boolean isTitle,
		boolean isContent, java.lang.String select)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchDiscussionByA_P_L_KMethodKey13,
				ClpSerializer.translateInput(articleId), groupId,
				ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(keyword), approved, isTitle,
				isContent, ClpSerializer.translateInput(select));

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion>)ClpSerializer.translateOutput(returnObj);
	}

	public int countByApproval(long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByApprovalMethodKey14,
				groupId, ClpSerializer.translateInput(language), approved);

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
	private MethodKey _addDiscussionMethodKey0;
	private MethodKey _updateDiscussionMethodKey1;
	private MethodKey _updateDiscussionMethodKey2;
	private MethodKey _deleteDiscussionMethodKey3;
	private MethodKey _deleteDiscussionsMethodKey4;
	private MethodKey _deleteDiscussionsMethodKey5;
	private MethodKey _deleteDiscussionsMethodKey6;
	private MethodKey _getDiscussionMethodKey7;
	private MethodKey _getDiscussionsMethodKey8;
	private MethodKey _getDiscussionsMethodKey9;
	private MethodKey _getDiscussionsByP_LMethodKey10;
	private MethodKey _getDiscussionsByP_L_AMethodKey11;
	private MethodKey _getDiscussionsByA_P_L_AMethodKey12;
	private MethodKey _searchDiscussionByA_P_L_KMethodKey13;
	private MethodKey _countByApprovalMethodKey14;
}