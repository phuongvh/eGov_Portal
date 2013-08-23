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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the vdoc document remote service. This utility wraps {@link com.vportal.portlet.vdoc.service.impl.vdocDocumentServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author MrEn
 * @see vdocDocumentService
 * @see com.vportal.portlet.vdoc.service.base.vdocDocumentServiceBaseImpl
 * @see com.vportal.portlet.vdoc.service.impl.vdocDocumentServiceImpl
 * @generated
 */
public class vdocDocumentServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vdoc.service.impl.vdocDocumentServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Add Document
	*
	* @throws SystemException
	* @throws PortalException
	*/
	public static java.lang.String getmaxPosition(long groupId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getmaxPosition(groupId, language);
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument addDocument(
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
		return getService()
				   .addDocument(docId, groupId, language, userId, title,
			content, process, base, time, cost, result, require, objects,
			style, note, promulDate, effectivedDate, expiredDate, fieldId,
			orgRels, fieldRels, hasAttachment, typeDoc, communityPermissions,
			guestPermissions, themeDisplay);
	}

	/**
	* Add Document
	*
	* @throws SystemException
	* @throws PortalException
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument addDocument(
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
		return getService()
				   .addDocument(docId, groupId, language, userId, title,
			content, process, base, time, cost, result, require, objects,
			style, note, promulDate, effectivedDate, expiredDate, fieldId,
			orgRels, fieldRels, hasAttachment, typeDoc,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions, themeDisplay);
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
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
		return getService()
				   .updateDocument(docId, groupId, language, title, userId,
			content, process, base, time, cost, result, require, objects,
			style, note, promulDate, effectivedDate, expiredDate, fieldId,
			orgRels, fieldRels, hasAttachment, typeDoc, communityPermissions,
			guestPermissions, themeDisplay);
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
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
		return getService()
				   .updateDocument(docId, groupId, language, userId, title,
			content, process, base, time, cost, result, require, objects,
			style, note, promulDate, effectivedDate, expiredDate, fieldId,
			orgRels, fieldRels, hasAttachment, typeDoc,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions, themeDisplay);
	}

	/**
	* Update Doc
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
		com.vportal.portlet.vdoc.model.vdocDocument doc)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getService().updateDocument(doc);
	}

	/**
	* Update Doc by param
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
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
		return getService()
				   .updateDocument(docId, groupId, language, userId, status,
			title, content, process, base, time, cost, result, require,
			objects, style, note, promulDate, effectivedDate, expiredDate,
			fieldId, orgRels, fieldRels, hasAttachment, typeDoc);
	}

	/**
	* Delete Document By Id
	*/
	public static void deleteDocument(java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteDocument(docId);
	}

	/**
	* Delete Document By Object Doc
	*/
	public static void deleteDocument(
		com.vportal.portlet.vdoc.model.vdocDocument doc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteDocument(doc);
	}

	/**
	* Update Position Doc
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
		java.lang.String docId, int position)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getService().updateDocument(docId, position);
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument getDocument(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDocument(docId);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getAllDoc()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllDoc();
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getAllDoc(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllDoc(begin, end);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S(
		long groupId, java.lang.String language, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDocByG_L_S(groupId, language, status);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S(
		long groupId, java.lang.String language, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDocByG_L_S(groupId, language, status, begin, end);
	}

	public static int countDocByG_L_S(long groupId, java.lang.String language,
		int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countDocByG_L_S(groupId, language, status);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_F(
		long groupId, java.lang.String language, java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDocByG_L_F(groupId, language, fieldId);
	}

	public static int countDocByG_L_F(long groupId, java.lang.String language,
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countDocByG_L_F(groupId, language, fieldId);
	}

	public static int countDocByG_L_F_S(long groupId,
		java.lang.String language, java.lang.String fieldId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countDocByG_L_F_S(groupId, language, fieldId, status);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_T(
		long groupId, java.lang.String language, int status, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDocByG_L_S_T(groupId, language, status, type);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocbyModifyDate(
		long groupId, java.lang.String language, java.util.Date modiDateFrom,
		java.util.Date modiDateTo, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDocbyModifyDate(groupId, language, modiDateFrom,
			modiDateTo, status);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_T(
		long groupId, java.lang.String language, int status, int type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDocByG_L_S_T(groupId, language, status, type, start, end);
	}

	public static int countDocByG_L_S_T(long groupId,
		java.lang.String language, int status, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countDocByG_L_S_T(groupId, language, status, type);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_F_T(
		long groupId, java.lang.String language, int status,
		java.lang.String fieldId, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getDocByG_L_S_F_T(groupId, language, status, fieldId, type);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_F_T(
		long groupId, java.lang.String language, int status,
		java.lang.String fieldId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getDocByG_L_S_F_T(groupId, language, status, fieldId, type,
			start, end);
	}

	public static int countDocByG_L_S_F_T(long groupId,
		java.lang.String language, int status, java.lang.String fieldId,
		int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countDocByG_L_S_F_T(groupId, language, status, fieldId, type);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getOtherDoc(
		long groupId, java.lang.String language, java.lang.String id,
		int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getOtherDoc(groupId, language, id, status, begin, end);
	}

	public static int countOtherDoc(long groupId, java.lang.String language,
		java.lang.String id, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countOtherDoc(groupId, language, id, status, begin, end);
	}

	/**
	* Add Resource
	*/
	public static void addEntryResources(long entryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(entryId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocDocument entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(entry, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addEntryResources(long entryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(entryId, communityPermissions, guestPermissions);
	}

	public static void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocDocument entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(entry, communityPermissions, guestPermissions);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> searchDocument(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status) {
		return getService()
				   .searchDocument(groupId, language, fieldId, orgId, title,
			status);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> searchDocument(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status, int begin,
		int end) {
		return getService()
				   .searchDocument(groupId, language, fieldId, orgId, title,
			status, begin, end);
	}

	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByPublishDate(
		long groupId, java.lang.String language, java.util.Date pubDateFrom,
		java.util.Date pubDateTo, int status, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDocByPublishDate(groupId, language, pubDateFrom,
			pubDateTo, status, quantity);
	}

	public static void clearService() {
		_service = null;
	}

	public static vdocDocumentService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					vdocDocumentService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					vdocDocumentService.class.getName(), portletClassLoader);

			_service = new vdocDocumentServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(vdocDocumentServiceUtil.class,
				"_service");
			MethodCache.remove(vdocDocumentService.class);
		}

		return _service;
	}

	public void setService(vdocDocumentService service) {
		MethodCache.remove(vdocDocumentService.class);

		_service = service;

		ReferenceRegistry.registerReference(vdocDocumentServiceUtil.class,
			"_service");
		MethodCache.remove(vdocDocumentService.class);
	}

	private static vdocDocumentService _service;
}