/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.vdoc.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vdoc.model.vdocDocumentSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vdoc.model.vdocDocument}, that is translated to a
 * {@link com.vportal.portlet.vdoc.model.vdocDocumentSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    MrEn
 * @see       vdocDocumentServiceHttp
 * @see       com.vportal.portlet.vdoc.model.vdocDocumentSoap
 * @see       com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil
 * @generated
 */
public class vdocDocumentServiceSoap {
	/**
	* Add Document
	*
	* @throws SystemException
	* @throws PortalException
	*/
	public static java.lang.String getmaxPosition(long groupId,
		java.lang.String language) throws RemoteException {
		try {
			java.lang.String returnValue = vdocDocumentServiceUtil.getmaxPosition(groupId,
					language);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Update Doc
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocumentSoap updateDocument(
		com.vportal.portlet.vdoc.model.vdocDocument doc)
		throws RemoteException {
		try {
			com.vportal.portlet.vdoc.model.vdocDocument returnValue = vdocDocumentServiceUtil.updateDocument(doc);

			return com.vportal.portlet.vdoc.model.vdocDocumentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Update Doc by param
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocumentSoap updateDocument(
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
		throws RemoteException {
		try {
			com.vportal.portlet.vdoc.model.vdocDocument returnValue = vdocDocumentServiceUtil.updateDocument(docId,
					groupId, language, userId, status, title, content, process,
					base, time, cost, result, require, objects, style, note,
					promulDate, effectivedDate, expiredDate, fieldId, orgRels,
					fieldRels, hasAttachment, typeDoc);

			return com.vportal.portlet.vdoc.model.vdocDocumentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Delete Document By Id
	*/
	public static void deleteDocument(java.lang.String docId)
		throws RemoteException {
		try {
			vdocDocumentServiceUtil.deleteDocument(docId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Delete Document By Object Doc
	*/
	public static void deleteDocument(
		com.vportal.portlet.vdoc.model.vdocDocument doc)
		throws RemoteException {
		try {
			vdocDocumentServiceUtil.deleteDocument(doc);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Update Position Doc
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocumentSoap updateDocument(
		java.lang.String docId, int position) throws RemoteException {
		try {
			com.vportal.portlet.vdoc.model.vdocDocument returnValue = vdocDocumentServiceUtil.updateDocument(docId,
					position);

			return com.vportal.portlet.vdoc.model.vdocDocumentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocumentSoap getDocument(
		java.lang.String docId) throws RemoteException {
		try {
			com.vportal.portlet.vdoc.model.vdocDocument returnValue = vdocDocumentServiceUtil.getDocument(docId);

			return com.vportal.portlet.vdoc.model.vdocDocumentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getAllDoc()
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getAllDoc();

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getAllDoc(
		int begin, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getAllDoc(begin, end);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getDocByG_L_S(
		long groupId, java.lang.String language, int status)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getDocByG_L_S(groupId, language, status);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getDocByG_L_S(
		long groupId, java.lang.String language, int status, int begin, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getDocByG_L_S(groupId, language,
					status, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countDocByG_L_S(long groupId, java.lang.String language,
		int status) throws RemoteException {
		try {
			int returnValue = vdocDocumentServiceUtil.countDocByG_L_S(groupId,
					language, status);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getDocByG_L_F(
		long groupId, java.lang.String language, java.lang.String fieldId)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getDocByG_L_F(groupId, language, fieldId);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countDocByG_L_F(long groupId, java.lang.String language,
		java.lang.String fieldId) throws RemoteException {
		try {
			int returnValue = vdocDocumentServiceUtil.countDocByG_L_F(groupId,
					language, fieldId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countDocByG_L_F_S(long groupId,
		java.lang.String language, java.lang.String fieldId, int status)
		throws RemoteException {
		try {
			int returnValue = vdocDocumentServiceUtil.countDocByG_L_F_S(groupId,
					language, fieldId, status);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getDocByG_L_S_T(
		long groupId, java.lang.String language, int status, int type)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getDocByG_L_S_T(groupId, language,
					status, type);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getDocbyModifyDate(
		long groupId, java.lang.String language, java.util.Date modiDateFrom,
		java.util.Date modiDateTo, int status) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getDocbyModifyDate(groupId, language,
					modiDateFrom, modiDateTo, status);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getDocByG_L_S_T(
		long groupId, java.lang.String language, int status, int type,
		int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getDocByG_L_S_T(groupId, language,
					status, type, start, end);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countDocByG_L_S_T(long groupId,
		java.lang.String language, int status, int type)
		throws RemoteException {
		try {
			int returnValue = vdocDocumentServiceUtil.countDocByG_L_S_T(groupId,
					language, status, type);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getDocByG_L_S_F_T(
		long groupId, java.lang.String language, int status,
		java.lang.String fieldId, int type) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getDocByG_L_S_F_T(groupId, language,
					status, fieldId, type);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getDocByG_L_S_F_T(
		long groupId, java.lang.String language, int status,
		java.lang.String fieldId, int type, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getDocByG_L_S_F_T(groupId, language,
					status, fieldId, type, start, end);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countDocByG_L_S_F_T(long groupId,
		java.lang.String language, int status, java.lang.String fieldId,
		int type) throws RemoteException {
		try {
			int returnValue = vdocDocumentServiceUtil.countDocByG_L_S_F_T(groupId,
					language, status, fieldId, type);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getOtherDoc(
		long groupId, java.lang.String language, java.lang.String id,
		int status, int begin, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getOtherDoc(groupId, language, id,
					status, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countOtherDoc(long groupId, java.lang.String language,
		java.lang.String id, int status, int begin, int end)
		throws RemoteException {
		try {
			int returnValue = vdocDocumentServiceUtil.countOtherDoc(groupId,
					language, id, status, begin, end);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Add Resource
	*/
	public static void addEntryResources(long entryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			vdocDocumentServiceUtil.addEntryResources(entryId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocDocument entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			vdocDocumentServiceUtil.addEntryResources(entry,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addEntryResources(long entryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			vdocDocumentServiceUtil.addEntryResources(entryId,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocDocument entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			vdocDocumentServiceUtil.addEntryResources(entry,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] searchDocument(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.searchDocument(groupId, language,
					fieldId, orgId, title, status);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] searchDocument(
		long groupId, java.lang.String language, java.lang.String fieldId,
		java.lang.String orgId, java.lang.String title, int status, int begin,
		int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.searchDocument(groupId, language,
					fieldId, orgId, title, status, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument[] getDocByPublishDate(
		long groupId, java.lang.String language, java.util.Date pubDateFrom,
		java.util.Date pubDateTo, int status, int quantity)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> returnValue =
				vdocDocumentServiceUtil.getDocByPublishDate(groupId, language,
					pubDateFrom, pubDateTo, status, quantity);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDocument[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(vdocDocumentServiceSoap.class);
}