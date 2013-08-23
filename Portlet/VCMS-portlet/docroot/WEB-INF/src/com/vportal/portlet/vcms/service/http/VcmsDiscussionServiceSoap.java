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

package com.vportal.portlet.vcms.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vcms.service.VcmsDiscussionServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcms.service.VcmsDiscussionServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcms.model.VcmsDiscussionSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcms.model.VcmsDiscussion}, that is translated to a
 * {@link com.vportal.portlet.vcms.model.VcmsDiscussionSoap}. Methods that SOAP cannot
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
 * @author    hai
 * @see       VcmsDiscussionServiceHttp
 * @see       com.vportal.portlet.vcms.model.VcmsDiscussionSoap
 * @see       com.vportal.portlet.vcms.service.VcmsDiscussionServiceUtil
 * @generated
 */
public class VcmsDiscussionServiceSoap {
	public static com.vportal.portlet.vcms.model.VcmsDiscussionSoap addDiscussion(
		java.lang.String visitorName, java.lang.String visitorEmail,
		java.lang.String visitorPhone, long groupId, long companyId,
		java.lang.String articleId, java.lang.String title,
		java.lang.String content, boolean hasAttachment,
		java.lang.String language, boolean addCommunityPermissions,
		boolean addGuestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsDiscussion returnValue = VcmsDiscussionServiceUtil.addDiscussion(visitorName,
					visitorEmail, visitorPhone, groupId, companyId, articleId,
					title, content, hasAttachment, language,
					addCommunityPermissions, addGuestPermissions);

			return com.vportal.portlet.vcms.model.VcmsDiscussionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussionSoap updateDiscussion(
		java.lang.String discussionId, java.lang.String visitorName,
		java.lang.String visitorEmail, java.lang.String visitorPhone,
		long groupId, long companyId, java.lang.String articleId,
		java.lang.String title, java.lang.String content,
		boolean hasAttachment, boolean approved, java.lang.String language)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsDiscussion returnValue = VcmsDiscussionServiceUtil.updateDiscussion(discussionId,
					visitorName, visitorEmail, visitorPhone, groupId,
					companyId, articleId, title, content, hasAttachment,
					approved, language);

			return com.vportal.portlet.vcms.model.VcmsDiscussionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussionSoap updateDiscussion(
		com.vportal.portlet.vcms.model.VcmsDiscussion discussion)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsDiscussion returnValue = VcmsDiscussionServiceUtil.updateDiscussion(discussion);

			return com.vportal.portlet.vcms.model.VcmsDiscussionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteDiscussion(java.lang.String discussionId)
		throws RemoteException {
		try {
			VcmsDiscussionServiceUtil.deleteDiscussion(discussionId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteDiscussions(java.lang.String[] discussionIds)
		throws RemoteException {
		try {
			VcmsDiscussionServiceUtil.deleteDiscussions(discussionIds);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteDiscussions(java.lang.String articleId)
		throws RemoteException {
		try {
			VcmsDiscussionServiceUtil.deleteDiscussions(articleId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteDiscussions(java.lang.String articleId,
		boolean approved) throws RemoteException {
		try {
			VcmsDiscussionServiceUtil.deleteDiscussions(articleId, approved);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussionSoap getDiscussion(
		java.lang.String discussionId) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsDiscussion returnValue = VcmsDiscussionServiceUtil.getDiscussion(discussionId);

			return com.vportal.portlet.vcms.model.VcmsDiscussionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussion[] getDiscussions(
		java.lang.String articleId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> returnValue =
				VcmsDiscussionServiceUtil.getDiscussions(articleId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsDiscussion[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussion[] getDiscussions(
		java.lang.String articleId, boolean approved) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> returnValue =
				VcmsDiscussionServiceUtil.getDiscussions(articleId, approved);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsDiscussion[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussion[] getDiscussionsByP_L(
		long groupId, java.lang.String language) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> returnValue =
				VcmsDiscussionServiceUtil.getDiscussionsByP_L(groupId, language);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsDiscussion[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussion[] getDiscussionsByP_L_A(
		long groupId, java.lang.String language, boolean approved)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> returnValue =
				VcmsDiscussionServiceUtil.getDiscussionsByP_L_A(groupId,
					language, approved);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsDiscussion[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussion[] getDiscussionsByA_P_L_A(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> returnValue =
				VcmsDiscussionServiceUtil.getDiscussionsByA_P_L_A(articleId,
					groupId, language, approved);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsDiscussion[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussion[] searchDiscussionByA_P_L_K(
		java.lang.String articleId, long groupId, java.lang.String language,
		java.lang.String keyword, boolean approved, boolean isTitle,
		boolean isContent, java.lang.String select) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> returnValue =
				VcmsDiscussionServiceUtil.searchDiscussionByA_P_L_K(articleId,
					groupId, language, keyword, approved, isTitle, isContent,
					select);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsDiscussion[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByApproval(long groupId, java.lang.String language,
		boolean approved) throws RemoteException {
		try {
			int returnValue = VcmsDiscussionServiceUtil.countByApproval(groupId,
					language, approved);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VcmsDiscussionServiceSoap.class);
}