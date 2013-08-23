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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link vdocDocumentService}.
 * </p>
 *
 * @author    MrEn
 * @see       vdocDocumentService
 * @generated
 */
public class vdocDocumentServiceWrapper implements vdocDocumentService,
	ServiceWrapper<vdocDocumentService> {
	public vdocDocumentServiceWrapper(vdocDocumentService vdocDocumentService) {
		_vdocDocumentService = vdocDocumentService;
	}

	/**
	* Add Document
	*
	* @throws SystemException
	* @throws PortalException
	*/
	public java.lang.String getmaxPosition(long groupId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.getmaxPosition(groupId, language);
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
		return _vdocDocumentService.addDocument(docId, groupId, language,
			userId, title, content, process, base, time, cost, result, require,
			objects, style, note, promulDate, effectivedDate, expiredDate,
			fieldId, orgRels, fieldRels, hasAttachment, typeDoc,
			communityPermissions, guestPermissions, themeDisplay);
	}

	/**
	* Add Document
	*
	* @throws SystemException
	* @throws PortalException
	*/
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
		return _vdocDocumentService.addDocument(docId, groupId, language,
			userId, title, content, process, base, time, cost, result, require,
			objects, style, note, promulDate, effectivedDate, expiredDate,
			fieldId, orgRels, fieldRels, hasAttachment, typeDoc,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions, themeDisplay);
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
		return _vdocDocumentService.updateDocument(docId, groupId, language,
			title, userId, content, process, base, time, cost, result, require,
			objects, style, note, promulDate, effectivedDate, expiredDate,
			fieldId, orgRels, fieldRels, hasAttachment, typeDoc,
			communityPermissions, guestPermissions, themeDisplay);
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
		return _vdocDocumentService.updateDocument(docId, groupId, language,
			userId, title, content, process, base, time, cost, result, require,
			objects, style, note, promulDate, effectivedDate, expiredDate,
			fieldId, orgRels, fieldRels, hasAttachment, typeDoc,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions, themeDisplay);
	}

	/**
	* Update Doc
	*/
	public com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
		com.vportal.portlet.vdoc.model.vdocDocument doc)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return _vdocDocumentService.updateDocument(doc);
	}

	/**
	* Update Doc by param
	*/
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
		return _vdocDocumentService.updateDocument(docId, groupId, language,
			userId, status, title, content, process, base, time, cost, result,
			require, objects, style, note, promulDate, effectivedDate,
			expiredDate, fieldId, orgRels, fieldRels, hasAttachment, typeDoc);
	}

	/**
	* Delete Document By Id
	*/
	public void deleteDocument(java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vdocDocumentService.deleteDocument(docId);
	}

	/**
	* Delete Document By Object Doc
	*/
	public void deleteDocument(com.vportal.portlet.vdoc.model.vdocDocument doc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vdocDocumentService.deleteDocument(doc);
	}

	/**
	* Update Position Doc
	*/
	public com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
		java.lang.String docId, int position)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return _vdocDocumentService.updateDocument(docId, position);
	}

	public com.vportal.portlet.vdoc.model.vdocDocument getDocument(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.getDocument(docId);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getAllDoc()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.getAllDoc();
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getAllDoc(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.getAllDoc(begin, end);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S(
		long groupId, java.lang.String language, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.getDocByG_L_S(groupId, language, status);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S(
		long groupId, java.lang.String language, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.getDocByG_L_S(groupId, language, status,
			begin, end);
	}

	public int countDocByG_L_S(long groupId, java.lang.String language,
		int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.countDocByG_L_S(groupId, language, status);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_F(
		long groupId, java.lang.String language, java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.getDocByG_L_F(groupId, language, fieldId);
	}

	public int countDocByG_L_F(long groupId, java.lang.String language,
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.countDocByG_L_F(groupId, language, fieldId);
	}

	public int countDocByG_L_F_S(long groupId, java.lang.String language,
		java.lang.String fieldId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.countDocByG_L_F_S(groupId, language,
			fieldId, status);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_T(
		long groupId, java.lang.String language, int status, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.getDocByG_L_S_T(groupId, language, status,
			type);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocbyModifyDate(
		long groupId, java.lang.String language, java.util.Date modiDateFrom,
		java.util.Date modiDateTo, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.getDocbyModifyDate(groupId, language,
			modiDateFrom, modiDateTo, status);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_T(
		long groupId, java.lang.String language, int status, int type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.getDocByG_L_S_T(groupId, language, status,
			type, start, end);
	}

	public int countDocByG_L_S_T(long groupId, java.lang.String language,
		int status, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.countDocByG_L_S_T(groupId, language,
			status, type);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_F_T(
		long groupId, java.lang.String language, int status,
		java.lang.String fieldId, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocDocumentService.getDocByG_L_S_F_T(groupId, language,
			status, fieldId, type);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_F_T(
		long groupId, java.lang.String language, int status,
		java.lang.String fieldId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocDocumentService.getDocByG_L_S_F_T(groupId, language,
			status, fieldId, type, start, end);
	}

	public int countDocByG_L_S_F_T(long groupId, java.lang.String language,
		int status, java.lang.String fieldId, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocDocumentService.countDocByG_L_S_F_T(groupId, language,
			status, fieldId, type);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getOtherDoc(
		long groupId, java.lang.String language, java.lang.String id,
		int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocDocumentService.getOtherDoc(groupId, language, id, status,
			begin, end);
	}

	public int countOtherDoc(long groupId, java.lang.String language,
		java.lang.String id, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vdocDocumentService.countOtherDoc(groupId, language, id,
			status, begin, end);
	}

	/**
	* Add Resource
	*/
	public void addEntryResources(long entryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocDocumentService.addEntryResources(entryId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocDocument entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocDocumentService.addEntryResources(entry, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addEntryResources(long entryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocDocumentService.addEntryResources(entryId, communityPermissions,
			guestPermissions);
	}

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocDocument entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vdocDocumentService.addEntryResources(entry, communityPermissions,
			guestPermissions);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> searchDocument(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status) {
		return _vdocDocumentService.searchDocument(groupId, language, fieldId,
			orgId, title, status);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> searchDocument(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status, int begin,
		int end) {
		return _vdocDocumentService.searchDocument(groupId, language, fieldId,
			orgId, title, status, begin, end);
	}

	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByPublishDate(
		long groupId, java.lang.String language, java.util.Date pubDateFrom,
		java.util.Date pubDateTo, int status, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocumentService.getDocByPublishDate(groupId, language,
			pubDateFrom, pubDateTo, status, quantity);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public vdocDocumentService getWrappedvdocDocumentService() {
		return _vdocDocumentService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedvdocDocumentService(
		vdocDocumentService vdocDocumentService) {
		_vdocDocumentService = vdocDocumentService;
	}

	public vdocDocumentService getWrappedService() {
		return _vdocDocumentService;
	}

	public void setWrappedService(vdocDocumentService vdocDocumentService) {
		_vdocDocumentService = vdocDocumentService;
	}

	private vdocDocumentService _vdocDocumentService;
}