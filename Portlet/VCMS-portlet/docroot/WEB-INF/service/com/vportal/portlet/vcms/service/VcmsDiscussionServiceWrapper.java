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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VcmsDiscussionService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsDiscussionService
 * @generated
 */
public class VcmsDiscussionServiceWrapper implements VcmsDiscussionService,
	ServiceWrapper<VcmsDiscussionService> {
	public VcmsDiscussionServiceWrapper(
		VcmsDiscussionService vcmsDiscussionService) {
		_vcmsDiscussionService = vcmsDiscussionService;
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
		return _vcmsDiscussionService.addDiscussion(visitorName, visitorEmail,
			visitorPhone, groupId, companyId, articleId, title, content,
			hasAttachment, language, addCommunityPermissions,
			addGuestPermissions);
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
		return _vcmsDiscussionService.updateDiscussion(discussionId,
			visitorName, visitorEmail, visitorPhone, groupId, companyId,
			articleId, title, content, hasAttachment, approved, language);
	}

	public com.vportal.portlet.vcms.model.VcmsDiscussion updateDiscussion(
		com.vportal.portlet.vcms.model.VcmsDiscussion discussion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsDiscussionService.updateDiscussion(discussion);
	}

	public void deleteDiscussion(java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsDiscussionService.deleteDiscussion(discussionId);
	}

	public void deleteDiscussions(java.lang.String[] discussionIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsDiscussionService.deleteDiscussions(discussionIds);
	}

	public void deleteDiscussions(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsDiscussionService.deleteDiscussions(articleId);
	}

	public void deleteDiscussions(java.lang.String articleId, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsDiscussionService.deleteDiscussions(articleId, approved);
	}

	public com.vportal.portlet.vcms.model.VcmsDiscussion getDiscussion(
		java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsDiscussionService.getDiscussion(discussionId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussions(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsDiscussionService.getDiscussions(articleId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussions(
		java.lang.String articleId, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsDiscussionService.getDiscussions(articleId, approved);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussionsByP_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsDiscussionService.getDiscussionsByP_L(groupId, language);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussionsByP_L_A(
		long groupId, java.lang.String language, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsDiscussionService.getDiscussionsByP_L_A(groupId, language,
			approved);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> getDiscussionsByA_P_L_A(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsDiscussionService.getDiscussionsByA_P_L_A(articleId,
			groupId, language, approved);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> searchDiscussionByA_P_L_K(
		java.lang.String articleId, long groupId, java.lang.String language,
		java.lang.String keyword, boolean approved, boolean isTitle,
		boolean isContent, java.lang.String select)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsDiscussionService.searchDiscussionByA_P_L_K(articleId,
			groupId, language, keyword, approved, isTitle, isContent, select);
	}

	public int countByApproval(long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsDiscussionService.countByApproval(groupId, language,
			approved);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsDiscussionService getWrappedVcmsDiscussionService() {
		return _vcmsDiscussionService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsDiscussionService(
		VcmsDiscussionService vcmsDiscussionService) {
		_vcmsDiscussionService = vcmsDiscussionService;
	}

	public VcmsDiscussionService getWrappedService() {
		return _vcmsDiscussionService;
	}

	public void setWrappedService(VcmsDiscussionService vcmsDiscussionService) {
		_vcmsDiscussionService = vcmsDiscussionService;
	}

	private VcmsDiscussionService _vcmsDiscussionService;
}