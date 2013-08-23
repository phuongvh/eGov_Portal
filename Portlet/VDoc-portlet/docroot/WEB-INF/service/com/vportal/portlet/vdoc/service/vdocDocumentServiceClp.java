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
public class vdocDocumentServiceClp implements vdocDocumentService {
	public vdocDocumentServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_getmaxPositionMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"getmaxPosition", long.class, java.lang.String.class);

		_addDocumentMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDocument", java.lang.String.class, long.class,
				java.lang.String.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.util.Date.class, java.util.Date.class,
				java.util.Date.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				int.class, java.lang.String[].class, java.lang.String[].class,
				com.liferay.portal.theme.ThemeDisplay.class);

		_addDocumentMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDocument", java.lang.String.class, long.class,
				java.lang.String.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.util.Date.class, java.util.Date.class,
				java.util.Date.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				int.class, java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String[].class, java.lang.String[].class,
				com.liferay.portal.theme.ThemeDisplay.class);

		_updateDocumentMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDocument", java.lang.String.class, long.class,
				java.lang.String.class, java.lang.String.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.util.Date.class, java.util.Date.class,
				java.util.Date.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				int.class, java.lang.String[].class, java.lang.String[].class,
				com.liferay.portal.theme.ThemeDisplay.class);

		_updateDocumentMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDocument", java.lang.String.class, long.class,
				java.lang.String.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.util.Date.class, java.util.Date.class,
				java.util.Date.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				int.class, java.lang.Boolean.class, java.lang.Boolean.class,
				java.lang.String[].class, java.lang.String[].class,
				com.liferay.portal.theme.ThemeDisplay.class);

		_updateDocumentMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDocument",
				com.vportal.portlet.vdoc.model.vdocDocument.class);

		_updateDocumentMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDocument", java.lang.String.class, long.class,
				java.lang.String.class, long.class, int.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.util.Date.class,
				java.util.Date.class, java.util.Date.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, int.class);

		_deleteDocumentMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDocument", java.lang.String.class);

		_deleteDocumentMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDocument",
				com.vportal.portlet.vdoc.model.vdocDocument.class);

		_updateDocumentMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDocument", java.lang.String.class, int.class);

		_getDocumentMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDocument", java.lang.String.class);

		_getAllDocMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllDoc");

		_getAllDocMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllDoc", int.class, int.class);

		_getDocByG_L_SMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDocByG_L_S", long.class, java.lang.String.class, int.class);

		_getDocByG_L_SMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDocByG_L_S", long.class, java.lang.String.class, int.class,
				int.class, int.class);

		_countDocByG_L_SMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"countDocByG_L_S", long.class, java.lang.String.class, int.class);

		_getDocByG_L_FMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDocByG_L_F", long.class, java.lang.String.class,
				java.lang.String.class);

		_countDocByG_L_FMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"countDocByG_L_F", long.class, java.lang.String.class,
				java.lang.String.class);

		_countDocByG_L_F_SMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"countDocByG_L_F_S", long.class, java.lang.String.class,
				java.lang.String.class, int.class);

		_getDocByG_L_S_TMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDocByG_L_S_T", long.class, java.lang.String.class,
				int.class, int.class);

		_getDocbyModifyDateMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDocbyModifyDate", long.class, java.lang.String.class,
				java.util.Date.class, java.util.Date.class, int.class);

		_getDocByG_L_S_TMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDocByG_L_S_T", long.class, java.lang.String.class,
				int.class, int.class, int.class, int.class);

		_countDocByG_L_S_TMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"countDocByG_L_S_T", long.class, java.lang.String.class,
				int.class, int.class);

		_getDocByG_L_S_F_TMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDocByG_L_S_F_T", long.class, java.lang.String.class,
				int.class, java.lang.String.class, int.class);

		_getDocByG_L_S_F_TMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDocByG_L_S_F_T", long.class, java.lang.String.class,
				int.class, java.lang.String.class, int.class, int.class,
				int.class);

		_countDocByG_L_S_F_TMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"countDocByG_L_S_F_T", long.class, java.lang.String.class,
				int.class, java.lang.String.class, int.class);

		_getOtherDocMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"getOtherDoc", long.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class, int.class);

		_countOtherDocMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"countOtherDoc", long.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class, int.class);

		_addEntryResourcesMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources", long.class, boolean.class, boolean.class);

		_addEntryResourcesMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources",
				com.vportal.portlet.vdoc.model.vdocDocument.class,
				boolean.class, boolean.class);

		_addEntryResourcesMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources", long.class, java.lang.String[].class,
				java.lang.String[].class);

		_addEntryResourcesMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources",
				com.vportal.portlet.vdoc.model.vdocDocument.class,
				java.lang.String[].class, java.lang.String[].class);

		_searchDocumentMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchDocument", long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class);

		_searchDocumentMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchDocument", long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class, int.class);

		_getDocByPublishDateMethodKey34 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDocByPublishDate", long.class, java.lang.String.class,
				java.util.Date.class, java.util.Date.class, int.class, int.class);
	}

	public java.lang.String getmaxPosition(long groupId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getmaxPositionMethodKey0,
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocDocument addDocument(
		java.lang.String docId, long groupId, java.lang.String language,
		long userId, java.lang.String title, java.lang.String content,
		java.lang.String process, java.lang.String base, java.lang.String time,
		java.lang.String cost, java.lang.String result,
		java.lang.String require, java.lang.String objects,
		java.lang.String style, java.lang.String note,
		java.util.Date promulDate, java.util.Date effectivedDate,
		java.util.Date expiredDate, java.lang.String fieldId,
		java.lang.String orgRels, java.lang.String fieldRels,
		boolean hasAttachment, int typeDoc,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDocumentMethodKey1,
				ClpSerializer.translateInput(docId), groupId,
				ClpSerializer.translateInput(language), userId,
				ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(content),
				ClpSerializer.translateInput(process),
				ClpSerializer.translateInput(base),
				ClpSerializer.translateInput(time),
				ClpSerializer.translateInput(cost),
				ClpSerializer.translateInput(result),
				ClpSerializer.translateInput(require),
				ClpSerializer.translateInput(objects),
				ClpSerializer.translateInput(style),
				ClpSerializer.translateInput(note),
				ClpSerializer.translateInput(promulDate),
				ClpSerializer.translateInput(effectivedDate),
				ClpSerializer.translateInput(expiredDate),
				ClpSerializer.translateInput(fieldId),
				ClpSerializer.translateInput(orgRels),
				ClpSerializer.translateInput(fieldRels), hasAttachment,
				typeDoc, ClpSerializer.translateInput(communityPermissions),
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

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vdoc.model.vdocDocument)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocDocument addDocument(
		java.lang.String docId, long groupId, java.lang.String language,
		long userId, java.lang.String title, java.lang.String content,
		java.lang.String process, java.lang.String base, java.lang.String time,
		java.lang.String cost, java.lang.String result,
		java.lang.String require, java.lang.String objects,
		java.lang.String style, java.lang.String note,
		java.util.Date promulDate, java.util.Date effectivedDate,
		java.util.Date expiredDate, java.lang.String fieldId,
		java.lang.String orgRels, java.lang.String fieldRels,
		boolean hasAttachment, int typeDoc,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDocumentMethodKey2,
				ClpSerializer.translateInput(docId), groupId,
				ClpSerializer.translateInput(language), userId,
				ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(content),
				ClpSerializer.translateInput(process),
				ClpSerializer.translateInput(base),
				ClpSerializer.translateInput(time),
				ClpSerializer.translateInput(cost),
				ClpSerializer.translateInput(result),
				ClpSerializer.translateInput(require),
				ClpSerializer.translateInput(objects),
				ClpSerializer.translateInput(style),
				ClpSerializer.translateInput(note),
				ClpSerializer.translateInput(promulDate),
				ClpSerializer.translateInput(effectivedDate),
				ClpSerializer.translateInput(expiredDate),
				ClpSerializer.translateInput(fieldId),
				ClpSerializer.translateInput(orgRels),
				ClpSerializer.translateInput(fieldRels), hasAttachment,
				typeDoc, ClpSerializer.translateInput(addCommunityPermissions),
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

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vdoc.model.vdocDocument)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
		java.lang.String docId, long groupId, java.lang.String language,
		java.lang.String title, long userId, java.lang.String content,
		java.lang.String process, java.lang.String base, java.lang.String time,
		java.lang.String cost, java.lang.String result,
		java.lang.String require, java.lang.String objects,
		java.lang.String style, java.lang.String note,
		java.util.Date promulDate, java.util.Date effectivedDate,
		java.util.Date expiredDate, java.lang.String fieldId,
		java.lang.String orgRels, java.lang.String fieldRels,
		boolean hasAttachment, int typeDoc,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDocumentMethodKey3,
				ClpSerializer.translateInput(docId), groupId,
				ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(title), userId,
				ClpSerializer.translateInput(content),
				ClpSerializer.translateInput(process),
				ClpSerializer.translateInput(base),
				ClpSerializer.translateInput(time),
				ClpSerializer.translateInput(cost),
				ClpSerializer.translateInput(result),
				ClpSerializer.translateInput(require),
				ClpSerializer.translateInput(objects),
				ClpSerializer.translateInput(style),
				ClpSerializer.translateInput(note),
				ClpSerializer.translateInput(promulDate),
				ClpSerializer.translateInput(effectivedDate),
				ClpSerializer.translateInput(expiredDate),
				ClpSerializer.translateInput(fieldId),
				ClpSerializer.translateInput(orgRels),
				ClpSerializer.translateInput(fieldRels), hasAttachment,
				typeDoc, ClpSerializer.translateInput(communityPermissions),
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

		return (com.vportal.portlet.vdoc.model.vdocDocument)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
		java.lang.String docId, long groupId, java.lang.String language,
		long userId, java.lang.String title, java.lang.String content,
		java.lang.String process, java.lang.String base, java.lang.String time,
		java.lang.String cost, java.lang.String result,
		java.lang.String require, java.lang.String objects,
		java.lang.String style, java.lang.String note,
		java.util.Date promulDate, java.util.Date effectivedDate,
		java.util.Date expiredDate, java.lang.String fieldId,
		java.lang.String orgRels, java.lang.String fieldRels,
		boolean hasAttachment, int typeDoc,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDocumentMethodKey4,
				ClpSerializer.translateInput(docId), groupId,
				ClpSerializer.translateInput(language), userId,
				ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(content),
				ClpSerializer.translateInput(process),
				ClpSerializer.translateInput(base),
				ClpSerializer.translateInput(time),
				ClpSerializer.translateInput(cost),
				ClpSerializer.translateInput(result),
				ClpSerializer.translateInput(require),
				ClpSerializer.translateInput(objects),
				ClpSerializer.translateInput(style),
				ClpSerializer.translateInput(note),
				ClpSerializer.translateInput(promulDate),
				ClpSerializer.translateInput(effectivedDate),
				ClpSerializer.translateInput(expiredDate),
				ClpSerializer.translateInput(fieldId),
				ClpSerializer.translateInput(orgRels),
				ClpSerializer.translateInput(fieldRels), hasAttachment,
				typeDoc, ClpSerializer.translateInput(addCommunityPermissions),
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

		return (com.vportal.portlet.vdoc.model.vdocDocument)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
		com.vportal.portlet.vdoc.model.vdocDocument doc)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDocumentMethodKey5,
				ClpSerializer.translateInput(doc));

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

			if (t instanceof com.vportal.portlet.vdoc.NoSuchvdocDocumentException) {
				throw (com.vportal.portlet.vdoc.NoSuchvdocDocumentException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vdoc.model.vdocDocument)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
		java.lang.String docId, long groupId, java.lang.String language,
		long userId, int status, java.lang.String title,
		java.lang.String content, java.lang.String process,
		java.lang.String base, java.lang.String time, java.lang.String cost,
		java.lang.String result, java.lang.String require,
		java.lang.String objects, java.lang.String style,
		java.lang.String note, java.util.Date promulDate,
		java.util.Date effectivedDate, java.util.Date expiredDate,
		java.lang.String fieldId, java.lang.String orgRels,
		java.lang.String fieldRels, boolean hasAttachment, int typeDoc)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDocumentMethodKey6,
				ClpSerializer.translateInput(docId), groupId,
				ClpSerializer.translateInput(language), userId, status,
				ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(content),
				ClpSerializer.translateInput(process),
				ClpSerializer.translateInput(base),
				ClpSerializer.translateInput(time),
				ClpSerializer.translateInput(cost),
				ClpSerializer.translateInput(result),
				ClpSerializer.translateInput(require),
				ClpSerializer.translateInput(objects),
				ClpSerializer.translateInput(style),
				ClpSerializer.translateInput(note),
				ClpSerializer.translateInput(promulDate),
				ClpSerializer.translateInput(effectivedDate),
				ClpSerializer.translateInput(expiredDate),
				ClpSerializer.translateInput(fieldId),
				ClpSerializer.translateInput(orgRels),
				ClpSerializer.translateInput(fieldRels), hasAttachment, typeDoc);

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

			if (t instanceof com.vportal.portlet.vdoc.NoSuchvdocDocumentException) {
				throw (com.vportal.portlet.vdoc.NoSuchvdocDocumentException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vdoc.model.vdocDocument)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteDocument(java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteDocumentMethodKey7,
				ClpSerializer.translateInput(docId));

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

	public void deleteDocument(com.vportal.portlet.vdoc.model.vdocDocument doc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteDocumentMethodKey8,
				ClpSerializer.translateInput(doc));

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

	public com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
		java.lang.String docId, int position)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDocumentMethodKey9,
				ClpSerializer.translateInput(docId), position);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.vportal.portlet.vdoc.NoSuchvdocDocumentException) {
				throw (com.vportal.portlet.vdoc.NoSuchvdocDocumentException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vdoc.model.vdocDocument)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vdoc.model.vdocDocument getDocument(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDocumentMethodKey10,
				ClpSerializer.translateInput(docId));

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

		return (com.vportal.portlet.vdoc.model.vdocDocument)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getAllDoc()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllDocMethodKey11);

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getAllDoc(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllDocMethodKey12,
				begin, end);

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S(
		long groupId, java.lang.String language, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDocByG_L_SMethodKey13,
				groupId, ClpSerializer.translateInput(language), status);

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S(
		long groupId, java.lang.String language, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDocByG_L_SMethodKey14,
				groupId, ClpSerializer.translateInput(language), status, begin,
				end);

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public int countDocByG_L_S(long groupId, java.lang.String language,
		int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countDocByG_L_SMethodKey15,
				groupId, ClpSerializer.translateInput(language), status);

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

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_F(
		long groupId, java.lang.String language, java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDocByG_L_FMethodKey16,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(fieldId));

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public int countDocByG_L_F(long groupId, java.lang.String language,
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countDocByG_L_FMethodKey17,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(fieldId));

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

	public int countDocByG_L_F_S(long groupId, java.lang.String language,
		java.lang.String fieldId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countDocByG_L_F_SMethodKey18,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(fieldId), status);

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

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_T(
		long groupId, java.lang.String language, int status, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDocByG_L_S_TMethodKey19,
				groupId, ClpSerializer.translateInput(language), status, type);

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocbyModifyDate(
		long groupId, java.lang.String language, java.util.Date modiDateFrom,
		java.util.Date modiDateTo, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDocbyModifyDateMethodKey20,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(modiDateFrom),
				ClpSerializer.translateInput(modiDateTo), status);

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_T(
		long groupId, java.lang.String language, int status, int type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDocByG_L_S_TMethodKey21,
				groupId, ClpSerializer.translateInput(language), status, type,
				start, end);

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public int countDocByG_L_S_T(long groupId, java.lang.String language,
		int status, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countDocByG_L_S_TMethodKey22,
				groupId, ClpSerializer.translateInput(language), status, type);

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

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_F_T(
		long groupId, java.lang.String language, int status,
		java.lang.String fieldId, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDocByG_L_S_F_TMethodKey23,
				groupId, ClpSerializer.translateInput(language), status,
				ClpSerializer.translateInput(fieldId), type);

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_F_T(
		long groupId, java.lang.String language, int status,
		java.lang.String fieldId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDocByG_L_S_F_TMethodKey24,
				groupId, ClpSerializer.translateInput(language), status,
				ClpSerializer.translateInput(fieldId), type, start, end);

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public int countDocByG_L_S_F_T(long groupId, java.lang.String language,
		int status, java.lang.String fieldId, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countDocByG_L_S_F_TMethodKey25,
				groupId, ClpSerializer.translateInput(language), status,
				ClpSerializer.translateInput(fieldId), type);

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

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getOtherDoc(
		long groupId, java.lang.String language, java.lang.String id,
		int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getOtherDocMethodKey26,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(id), status, begin, end);

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public int countOtherDoc(long groupId, java.lang.String language,
		java.lang.String id, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countOtherDocMethodKey27,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(id), status, begin, end);

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

	public void addEntryResources(long entryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addEntryResourcesMethodKey28,
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
		com.vportal.portlet.vdoc.model.vdocDocument entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addEntryResourcesMethodKey29,
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
		MethodHandler methodHandler = new MethodHandler(_addEntryResourcesMethodKey30,
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
		com.vportal.portlet.vdoc.model.vdocDocument entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addEntryResourcesMethodKey31,
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

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> searchDocument(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchDocumentMethodKey32,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(fieldId),
				ClpSerializer.translateInput(orgId),
				ClpSerializer.translateInput(title), status);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> searchDocument(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status, int begin,
		int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchDocumentMethodKey33,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(fieldId),
				ClpSerializer.translateInput(orgId),
				ClpSerializer.translateInput(title), status, begin, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByPublishDate(
		long groupId, java.lang.String language, java.util.Date pubDateFrom,
		java.util.Date pubDateTo, int status, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDocByPublishDateMethodKey34,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(pubDateFrom),
				ClpSerializer.translateInput(pubDateTo), status, quantity);

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

		return (java.util.List<com.vportal.portlet.vdoc.model.vdocDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _getmaxPositionMethodKey0;
	private MethodKey _addDocumentMethodKey1;
	private MethodKey _addDocumentMethodKey2;
	private MethodKey _updateDocumentMethodKey3;
	private MethodKey _updateDocumentMethodKey4;
	private MethodKey _updateDocumentMethodKey5;
	private MethodKey _updateDocumentMethodKey6;
	private MethodKey _deleteDocumentMethodKey7;
	private MethodKey _deleteDocumentMethodKey8;
	private MethodKey _updateDocumentMethodKey9;
	private MethodKey _getDocumentMethodKey10;
	private MethodKey _getAllDocMethodKey11;
	private MethodKey _getAllDocMethodKey12;
	private MethodKey _getDocByG_L_SMethodKey13;
	private MethodKey _getDocByG_L_SMethodKey14;
	private MethodKey _countDocByG_L_SMethodKey15;
	private MethodKey _getDocByG_L_FMethodKey16;
	private MethodKey _countDocByG_L_FMethodKey17;
	private MethodKey _countDocByG_L_F_SMethodKey18;
	private MethodKey _getDocByG_L_S_TMethodKey19;
	private MethodKey _getDocbyModifyDateMethodKey20;
	private MethodKey _getDocByG_L_S_TMethodKey21;
	private MethodKey _countDocByG_L_S_TMethodKey22;
	private MethodKey _getDocByG_L_S_F_TMethodKey23;
	private MethodKey _getDocByG_L_S_F_TMethodKey24;
	private MethodKey _countDocByG_L_S_F_TMethodKey25;
	private MethodKey _getOtherDocMethodKey26;
	private MethodKey _countOtherDocMethodKey27;
	private MethodKey _addEntryResourcesMethodKey28;
	private MethodKey _addEntryResourcesMethodKey29;
	private MethodKey _addEntryResourcesMethodKey30;
	private MethodKey _addEntryResourcesMethodKey31;
	private MethodKey _searchDocumentMethodKey32;
	private MethodKey _searchDocumentMethodKey33;
	private MethodKey _getDocByPublishDateMethodKey34;
}