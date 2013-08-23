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
 * This class is a wrapper for {@link VcmsArticleService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticleService
 * @generated
 */
public class VcmsArticleServiceWrapper implements VcmsArticleService,
	ServiceWrapper<VcmsArticleService> {
	public VcmsArticleServiceWrapper(VcmsArticleService vcmsArticleService) {
		_vcmsArticleService = vcmsArticleService;
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.getArticleByCompanyId(companyId, start, end);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.getArticleByCompanyId(companyId);
	}

	public int countArticleByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.countArticleByCompanyId(companyId);
	}

	public com.vportal.portlet.vcms.model.VcmsArticle addArticle(
		javax.portlet.ActionRequest req,
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest,
		long groupId, long companyId, long plid, java.lang.String title,
		java.lang.String lead, java.lang.String content, boolean hasImage,
		java.lang.String imageTitle, java.lang.String image,
		java.lang.String language, boolean hasAttachment, boolean hasPoll,
		java.lang.String pollId, long status, java.lang.String author,
		java.lang.String source, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.addArticle(req, upRequest, groupId,
			companyId, plid, title, lead, content, hasImage, imageTitle, image,
			language, hasAttachment, hasPoll, pollId, status, author, source,
			communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vcms.model.VcmsArticle addArticle(
		javax.portlet.ActionRequest req,
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest,
		long groupId, long companyId, long plid, java.lang.String title,
		java.lang.String lead, java.lang.String content, boolean hasImage,
		java.lang.String imageTitle, java.lang.String image,
		java.lang.String language, boolean hasAttachment, boolean hasPoll,
		java.lang.String pollId, long status, java.lang.String author,
		java.lang.String source, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.addArticle(req, upRequest, groupId,
			companyId, plid, title, lead, content, hasImage, imageTitle, image,
			language, hasAttachment, hasPoll, pollId, status, author, source,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public void addArticleResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleService.addArticleResources(articleId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addArticleResources(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleService.addArticleResources(article,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addArticleResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleService.addArticleResources(articleId,
			communityPermissions, guestPermissions);
	}

	public void addArticleResources(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleService.addArticleResources(article, communityPermissions,
			guestPermissions);
	}

	public com.vportal.portlet.vcms.model.VcmsArticle updateArticle(
		javax.portlet.ActionRequest req,
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest,
		long groupId, long companyId, java.lang.String articleId, long status,
		java.lang.String title, java.lang.String lead,
		java.lang.String content, boolean hasImage,
		java.lang.String imageTitle, java.lang.String image,
		java.lang.String language, boolean discussible, boolean hasAttachment,
		boolean hasPoll, java.lang.String pollId, boolean sticky,
		boolean stickyNeverExpired, java.util.Date stickyExpireDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.updateArticle(req, upRequest, groupId,
			companyId, articleId, status, title, lead, content, hasImage,
			imageTitle, image, language, discussible, hasAttachment, hasPoll,
			pollId, sticky, stickyNeverExpired, stickyExpireDate);
	}

	public com.vportal.portlet.vcms.model.VcmsArticle updateArticle(
		javax.portlet.ActionRequest req,
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest,
		com.vportal.portlet.vcms.model.VcmsArticle article)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.updateArticle(req, upRequest, article);
	}

	public com.vportal.portlet.vcms.model.VcmsArticle updateArticle(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.updateArticle(article, upRequest);
	}

	public void deleteArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsArticleService.deleteArticle(articleId);
	}

	public void deleteArticles(java.lang.String[] articleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsArticleService.deleteArticles(articleIds);
	}

	public com.vportal.portlet.vcms.model.VcmsArticle getArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticle(articleId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticles(
		java.lang.String[] articleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticles(articleIds);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByU_L_S(
		long groupId, java.lang.String userId, int status,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesByU_L_S(groupId, userId, status,
			language);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByU_L_S(
		long groupId, java.lang.String userId, int status,
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesByU_L_S(groupId, userId, status,
			language, obc);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S(
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesByL_S(groupId, language, statusId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S(
		long groupId, java.lang.String language, long statusId, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesByL_S(groupId, language,
			statusId, start, end);
	}

	public int countArticlesByL_S(long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticlesByL_S(groupId, language,
			statusId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByG_L_S_U(
		long groupId, java.lang.String language, long statusId,
		java.lang.String createdByUser, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesByG_L_S_U(groupId, language,
			statusId, createdByUser, start, end);
	}

	public int countArticlesByG_L_S_U(long groupId, java.lang.String language,
		long statusId, java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticlesByG_L_S_U(groupId, language,
			statusId, createdByUser);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S(
		long groupId, java.lang.String language, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesByL_S(groupId, language, status,
			obc);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S_S(
		long groupId, java.lang.String language, long statusId, boolean sticky)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesByL_S_S(groupId, language,
			statusId, sticky);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesNewByL_S_S(
		long groupId, java.lang.String language, long statusId, boolean sticky,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesNewByL_S_S(groupId, language,
			statusId, sticky, end);
	}

	public int countArticlesByL_S_S(long groupId, java.lang.String language,
		long statusId, boolean sticky)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticlesByL_S_S(groupId, language,
			statusId, sticky);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S_S(
		long groupId, java.lang.String language, int statusId, boolean sticky,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesByL_S_S(groupId, language,
			statusId, sticky, obc);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByP_L_S_D(
		long groupId, java.lang.String language, long statusId,
		boolean discussible)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticleByP_L_S_D(groupId, language,
			statusId, discussible);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByC_P_L_S(
		java.lang.String categoryId, long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticleByC_P_L_S(categoryId, groupId,
			language, statusId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByC_P_L_S(
		java.lang.String categoryId, long groupId, java.lang.String language,
		long statusId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticleByC_P_L_S(categoryId, groupId,
			language, statusId, start, end);
	}

	public int countArticleByC_P_L_S(java.lang.String categoryId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticleByC_P_L_S(categoryId, groupId,
			language, statusId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByP_P_L_S(
		java.lang.String portionId, long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticleByP_P_L_S(portionId, groupId,
			language, statusId);
	}

	public int countArticleByP_P_L_S(java.lang.String portionId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticleByP_P_L_S(portionId, groupId,
			language, statusId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByP_P_L_S(
		java.lang.String portionId, long groupId, java.lang.String language,
		long statusId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticleByP_P_L_S(portionId, groupId,
			language, statusId, start, end);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByT_P_L_S(
		java.lang.String threadId, long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticleByT_P_L_S(threadId, groupId,
			language, statusId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByT_P_L_S(
		java.lang.String threadId, long groupId, java.lang.String language,
		long statusId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticleByT_P_L_S(threadId, groupId,
			language, statusId, start, end);
	}

	public int countArticleByT_P_L_S(java.lang.String threadId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticleByT_P_L_S(threadId, groupId,
			language, statusId);
	}

	public int countByStatus(long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countByStatus(groupId, language, statusId);
	}

	public int countByStatus(long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countByStatus(statusId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getTopNewArticles(groupId, language,
			portionId, categoryId, statusId, quantity);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getHotNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.getHotNewArticles(groupId, language,
			portionId, categoryId, statusId, quantity);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, boolean sticky, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getTopNewArticles(groupId, language,
			portionId, categoryId, statusId, sticky, quantity);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, long statusId, boolean sticky,
		int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getTopNewArticles(groupId, language,
			statusId, sticky, quantity);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, boolean sticky, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getTopNewArticles(groupId, language,
			categoryId, statusId, sticky, quantity);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, int quantity,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getTopNewArticles(groupId, language,
			categoryId, statusId, quantity, obc);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getAllCategoryArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getAllCategoryArticles(groupId, language,
			categoryId, statusId, begin, end);
	}

	public int countAllCategoryArticles(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countAllCategoryArticles(groupId, language,
			categoryId, statusId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String threadId,
		long statusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesInThread(groupId, language,
			threadId, statusId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String threadId,
		long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesInThread(groupId, language,
			threadId, statusId, quantity);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String[] threadIds,
		long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesInThread(groupId, language,
			threadIds, statusId, quantity);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getOlderArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, java.lang.String articleId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getOlderArticles(groupId, language,
			portionId, categoryId, articleId, statusId, quantity);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, java.lang.String articleId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getNewArticles(groupId, language, portionId,
			categoryId, articleId, statusId, quantity);
	}

	public int countByC_P_L_S_D(java.lang.String categoryId, long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.countByC_P_L_S_D(categoryId, groupId,
			language, statusId, fromDate, toDate, byUser);
	}

	public int countByP_L_S_D(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.countByP_L_S_D(groupId, language, statusId,
			fromDate, toDate, byUser);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> listReportByDate(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, long typeId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.listReportByDate(groupId, language,
			statusId, fromDate, toDate, byUser, typeId, begin, end);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> listReportByDateNotType(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.listReportByDateNotType(groupId, language,
			statusId, fromDate, toDate, byUser, begin, end);
	}

	public int countByDate(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.countByDate(groupId, language, statusId,
			fromDate, toDate, byUser, typeId);
	}

	public int countByDateNotType(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.countByDateNotType(groupId, language,
			statusId, fromDate, toDate, byUser);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> listArticleByDateTypes(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, java.lang.String[] strType, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.listArticleByDateTypes(groupId, language,
			statusId, fromDate, toDate, byUser, strType, begin, end);
	}

	public int countArticleByDateTypes(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, java.lang.String[] strType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.countArticleByDateTypes(groupId, language,
			statusId, fromDate, toDate, byUser, strType);
	}

	public int countByType(long groupId, java.lang.String language,
		long statusId, long typeId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countByType(groupId, language, statusId,
			typeId, fromDate, toDate, byUser);
	}

	public int countByUser(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, long typeId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countByUser(groupId, language, categoryId,
			statusId, typeId, fromDate, toDate, byUser);
	}

	public int countArticleNotInType(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticleNotInType(groupId, language,
			categoryId, statusId, fromDate, toDate, byUser);
	}

	public int countArticleAllCatNotInType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticleAllCatNotInType(groupId,
			language, statusId, fromDate, toDate, byUser);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesBySearchContainer(
		java.lang.String keyword, long groupId, java.lang.String language,
		java.lang.String portionId, java.lang.String parentId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesBySearchContainer(keyword,
			groupId, language, portionId, parentId, isTitle, isLead, isContent,
			isDate, fromDate, toDate, statusId, select);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesBySearchContainer(
		java.lang.String keyword, long groupId, java.lang.String language,
		java.lang.String portionId, java.lang.String parentId, long typeId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesBySearchContainer(keyword,
			groupId, language, portionId, parentId, typeId, isTitle, isLead,
			isContent, isDate, fromDate, toDate, statusId, select, start, end);
	}

	public int countArticlesBySearchContainer(java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String parentId, long typeId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticlesBySearchContainer(keyword,
			groupId, language, portionId, parentId, typeId, isTitle, isLead,
			isContent, isDate, fromDate, toDate, statusId, select);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesBySearchContainer_T(
		java.lang.String categoryId, long typeId, java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String threadId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticlesBySearchContainer_T(categoryId,
			typeId, keyword, groupId, language, threadId, isTitle, isLead,
			isContent, isDate, fromDate, toDate, statusId, select, start, end);
	}

	public int countArticlesBySearchContainer_T(java.lang.String categoryId,
		long typeId, java.lang.String keyword, long groupId,
		java.lang.String language, java.lang.String threadId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticlesBySearchContainer_T(categoryId,
			typeId, keyword, groupId, language, threadId, isTitle, isLead,
			isContent, isDate, fromDate, toDate, statusId, select);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByG_L_C_S_T(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, long typeId, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticleByG_L_C_S_T(groupId, language,
			categoryId, statusId, typeId, begin, end);
	}

	public int countArticleByG_L_C_S_T(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticleByG_L_C_S_T(groupId, language,
			categoryId, statusId, typeId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByG_L_S_T(
		long groupId, java.lang.String language, long statusId, long typeId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticleByG_L_S_T(groupId, language,
			statusId, typeId, begin, end);
	}

	public int countArticleByG_L_S_T(long groupId, java.lang.String language,
		long statusId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticleByG_L_S_T(groupId, language,
			statusId, typeId);
	}

	public int countArticleByG_L_S_C_D(long groupId, java.lang.String language,
		long statusId, java.lang.String categoryId, java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countArticleByG_L_S_C_D(groupId, language,
			statusId, categoryId, fromDate, toDate);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByG_L_S_C_D(
		long groupId, java.lang.String language, long statusId,
		java.lang.String categoryId, java.util.Date fromDate,
		java.util.Date toDate, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getArticleByG_L_S_C_D(groupId, language,
			statusId, categoryId, fromDate, toDate, begin, end);
	}

	public int countOtherArticle(long groupId, java.lang.String language,
		long statusId, java.lang.String categoryId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.countOtherArticle(groupId, language,
			statusId, categoryId, articleId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getOtherArticle(
		long groupId, java.lang.String language, long statusId,
		java.lang.String categoryId, java.lang.String articleId, int begin,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getOtherArticle(groupId, language, statusId,
			categoryId, articleId, begin, end);
	}

	public void removeExpiredStickyArticles(
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsArticleService.removeExpiredStickyArticles(upRequest);
	}

	public void reIndex(java.lang.String[] ids)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsArticleService.reIndex(ids);
	}

	public com.liferay.portal.kernel.search.Hits search(
		javax.servlet.http.HttpServletRequest request, long companyId,
		long groupId, long userId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleService.search(request, companyId, groupId, userId,
			keywords, start, end);
	}

	public void restoreArticleVersion(long articleVersionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsArticleService.restoreArticleVersion(articleVersionId);
	}

	public long getStatusIdOfPublishedArticles(long companyId, long groupId,
		boolean active) throws java.lang.Exception {
		return _vcmsArticleService.getStatusIdOfPublishedArticles(companyId,
			groupId, active);
	}

	public long getStatusIdOfPublishedArticles(boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleService.getStatusIdOfPublishedArticles(active);
	}

	public void saveImage(javax.portlet.ActionRequest req,
		com.liferay.portal.kernel.upload.UploadPortletRequest uploadReq,
		com.vportal.portlet.vcms.model.VcmsArticle article,
		java.lang.String image, java.lang.String imageTitle, long companyId)
		throws java.lang.Exception {
		_vcmsArticleService.saveImage(req, uploadReq, article, image,
			imageTitle, companyId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsArticleService getWrappedVcmsArticleService() {
		return _vcmsArticleService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsArticleService(
		VcmsArticleService vcmsArticleService) {
		_vcmsArticleService = vcmsArticleService;
	}

	public VcmsArticleService getWrappedService() {
		return _vcmsArticleService;
	}

	public void setWrappedService(VcmsArticleService vcmsArticleService) {
		_vcmsArticleService = vcmsArticleService;
	}

	private VcmsArticleService _vcmsArticleService;
}