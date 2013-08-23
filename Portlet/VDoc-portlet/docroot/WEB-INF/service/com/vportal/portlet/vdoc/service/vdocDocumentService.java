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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the vdoc document remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author MrEn
 * @see vdocDocumentServiceUtil
 * @see com.vportal.portlet.vdoc.service.base.vdocDocumentServiceBaseImpl
 * @see com.vportal.portlet.vdoc.service.impl.vdocDocumentServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface vdocDocumentService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link vdocDocumentServiceUtil} to access the vdoc document remote service. Add custom service methods to {@link com.vportal.portlet.vdoc.service.impl.vdocDocumentServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Add Document
	*
	* @throws SystemException
	* @throws PortalException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getmaxPosition(long groupId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

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
			com.liferay.portal.kernel.exception.SystemException;

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
			com.liferay.portal.kernel.exception.SystemException;

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
			java.rmi.RemoteException;

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
			java.rmi.RemoteException;

	/**
	* Update Doc
	*/
	public com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
		com.vportal.portlet.vdoc.model.vdocDocument doc)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

	/**
	* Delete Document By Id
	*/
	public void deleteDocument(java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	/**
	* Delete Document By Object Doc
	*/
	public void deleteDocument(com.vportal.portlet.vdoc.model.vdocDocument doc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	/**
	* Update Position Doc
	*/
	public com.vportal.portlet.vdoc.model.vdocDocument updateDocument(
		java.lang.String docId, int position)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.vdoc.model.vdocDocument getDocument(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getAllDoc()
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getAllDoc(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S(
		long groupId, java.lang.String language, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S(
		long groupId, java.lang.String language, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countDocByG_L_S(long groupId, java.lang.String language,
		int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_F(
		long groupId, java.lang.String language, java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countDocByG_L_F(long groupId, java.lang.String language,
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countDocByG_L_F_S(long groupId, java.lang.String language,
		java.lang.String fieldId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_T(
		long groupId, java.lang.String language, int status, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocbyModifyDate(
		long groupId, java.lang.String language, java.util.Date modiDateFrom,
		java.util.Date modiDateTo, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_T(
		long groupId, java.lang.String language, int status, int type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countDocByG_L_S_T(long groupId, java.lang.String language,
		int status, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_F_T(
		long groupId, java.lang.String language, int status,
		java.lang.String fieldId, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByG_L_S_F_T(
		long groupId, java.lang.String language, int status,
		java.lang.String fieldId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	public int countDocByG_L_S_F_T(long groupId, java.lang.String language,
		int status, java.lang.String fieldId, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getOtherDoc(
		long groupId, java.lang.String language, java.lang.String id,
		int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	public int countOtherDoc(long groupId, java.lang.String language,
		java.lang.String id, int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	/**
	* Add Resource
	*/
	public void addEntryResources(long entryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocDocument entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(long entryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocDocument entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> searchDocument(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> searchDocument(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status, int begin,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> getDocByPublishDate(
		long groupId, java.lang.String language, java.util.Date pubDateFrom,
		java.util.Date pubDateTo, int status, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}