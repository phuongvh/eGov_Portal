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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the vcms article remote service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsArticleServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author hai
 * @see VcmsArticleService
 * @see com.vportal.portlet.vcms.service.base.VcmsArticleServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsArticleServiceImpl
 * @generated
 */
public class VcmsArticleServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsArticleServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticleByCompanyId(companyId, start, end);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticleByCompanyId(companyId);
	}

	public static int countArticleByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countArticleByCompanyId(companyId);
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle addArticle(
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
		return getService()
				   .addArticle(req, upRequest, groupId, companyId, plid, title,
			lead, content, hasImage, imageTitle, image, language,
			hasAttachment, hasPoll, pollId, status, author, source,
			communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle addArticle(
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
		return getService()
				   .addArticle(req, upRequest, groupId, companyId, plid, title,
			lead, content, hasImage, imageTitle, image, language,
			hasAttachment, hasPoll, pollId, status, author, source,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public static void addArticleResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addArticleResources(articleId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addArticleResources(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addArticleResources(article, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addArticleResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addArticleResources(articleId, communityPermissions,
			guestPermissions);
	}

	public static void addArticleResources(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addArticleResources(article, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle updateArticle(
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
		return getService()
				   .updateArticle(req, upRequest, groupId, companyId,
			articleId, status, title, lead, content, hasImage, imageTitle,
			image, language, discussible, hasAttachment, hasPoll, pollId,
			sticky, stickyNeverExpired, stickyExpireDate);
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle updateArticle(
		javax.portlet.ActionRequest req,
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest,
		com.vportal.portlet.vcms.model.VcmsArticle article)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateArticle(req, upRequest, article);
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle updateArticle(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().updateArticle(article, upRequest);
	}

	public static void deleteArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteArticle(articleId);
	}

	public static void deleteArticles(java.lang.String[] articleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().deleteArticles(articleIds);
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle getArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getArticle(articleId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticles(
		java.lang.String[] articleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getArticles(articleIds);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByU_L_S(
		long groupId, java.lang.String userId, int status,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getArticlesByU_L_S(groupId, userId, status, language);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByU_L_S(
		long groupId, java.lang.String userId, int status,
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesByU_L_S(groupId, userId, status, language, obc);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S(
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getArticlesByL_S(groupId, language, statusId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S(
		long groupId, java.lang.String language, long statusId, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesByL_S(groupId, language, statusId, start, end);
	}

	public static int countArticlesByL_S(long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countArticlesByL_S(groupId, language, statusId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByG_L_S_U(
		long groupId, java.lang.String language, long statusId,
		java.lang.String createdByUser, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesByG_L_S_U(groupId, language, statusId,
			createdByUser, start, end);
	}

	public static int countArticlesByG_L_S_U(long groupId,
		java.lang.String language, long statusId, java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticlesByG_L_S_U(groupId, language, statusId,
			createdByUser);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S(
		long groupId, java.lang.String language, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getArticlesByL_S(groupId, language, status, obc);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S_S(
		long groupId, java.lang.String language, long statusId, boolean sticky)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesByL_S_S(groupId, language, statusId, sticky);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesNewByL_S_S(
		long groupId, java.lang.String language, long statusId, boolean sticky,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesNewByL_S_S(groupId, language, statusId, sticky,
			end);
	}

	public static int countArticlesByL_S_S(long groupId,
		java.lang.String language, long statusId, boolean sticky)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticlesByL_S_S(groupId, language, statusId, sticky);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S_S(
		long groupId, java.lang.String language, int statusId, boolean sticky,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesByL_S_S(groupId, language, statusId, sticky, obc);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByP_L_S_D(
		long groupId, java.lang.String language, long statusId,
		boolean discussible)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticleByP_L_S_D(groupId, language, statusId, discussible);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByC_P_L_S(
		java.lang.String categoryId, long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticleByC_P_L_S(categoryId, groupId, language, statusId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByC_P_L_S(
		java.lang.String categoryId, long groupId, java.lang.String language,
		long statusId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticleByC_P_L_S(categoryId, groupId, language,
			statusId, start, end);
	}

	public static int countArticleByC_P_L_S(java.lang.String categoryId,
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticleByC_P_L_S(categoryId, groupId, language,
			statusId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByP_P_L_S(
		java.lang.String portionId, long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticleByP_P_L_S(portionId, groupId, language, statusId);
	}

	public static int countArticleByP_P_L_S(java.lang.String portionId,
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticleByP_P_L_S(portionId, groupId, language, statusId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByP_P_L_S(
		java.lang.String portionId, long groupId, java.lang.String language,
		long statusId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticleByP_P_L_S(portionId, groupId, language, statusId,
			start, end);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByT_P_L_S(
		java.lang.String threadId, long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticleByT_P_L_S(threadId, groupId, language, statusId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByT_P_L_S(
		java.lang.String threadId, long groupId, java.lang.String language,
		long statusId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticleByT_P_L_S(threadId, groupId, language, statusId,
			start, end);
	}

	public static int countArticleByT_P_L_S(java.lang.String threadId,
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticleByT_P_L_S(threadId, groupId, language, statusId);
	}

	public static int countByStatus(long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countByStatus(groupId, language, statusId);
	}

	public static int countByStatus(long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countByStatus(statusId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getTopNewArticles(groupId, language, portionId, categoryId,
			statusId, quantity);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getHotNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getHotNewArticles(groupId, language, portionId, categoryId,
			statusId, quantity);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, boolean sticky, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getTopNewArticles(groupId, language, portionId, categoryId,
			statusId, sticky, quantity);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, long statusId, boolean sticky,
		int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getTopNewArticles(groupId, language, statusId, sticky,
			quantity);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, boolean sticky, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getTopNewArticles(groupId, language, categoryId, statusId,
			sticky, quantity);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, int quantity,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getTopNewArticles(groupId, language, categoryId, statusId,
			quantity, obc);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getAllCategoryArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getAllCategoryArticles(groupId, language, categoryId,
			statusId, begin, end);
	}

	public static int countAllCategoryArticles(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countAllCategoryArticles(groupId, language, categoryId,
			statusId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String threadId,
		long statusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesInThread(groupId, language, threadId, statusId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String threadId,
		long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesInThread(groupId, language, threadId, statusId,
			quantity);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String[] threadIds,
		long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesInThread(groupId, language, threadIds, statusId,
			quantity);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getOlderArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, java.lang.String articleId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getOlderArticles(groupId, language, portionId, categoryId,
			articleId, statusId, quantity);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, java.lang.String articleId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getNewArticles(groupId, language, portionId, categoryId,
			articleId, statusId, quantity);
	}

	public static int countByC_P_L_S_D(java.lang.String categoryId,
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByC_P_L_S_D(categoryId, groupId, language, statusId,
			fromDate, toDate, byUser);
	}

	public static int countByP_L_S_D(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByP_L_S_D(groupId, language, statusId, fromDate,
			toDate, byUser);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> listReportByDate(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, long typeId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .listReportByDate(groupId, language, statusId, fromDate,
			toDate, byUser, typeId, begin, end);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> listReportByDateNotType(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .listReportByDateNotType(groupId, language, statusId,
			fromDate, toDate, byUser, begin, end);
	}

	public static int countByDate(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByDate(groupId, language, statusId, fromDate, toDate,
			byUser, typeId);
	}

	public static int countByDateNotType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByDateNotType(groupId, language, statusId, fromDate,
			toDate, byUser);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> listArticleByDateTypes(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, java.lang.String[] strType, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .listArticleByDateTypes(groupId, language, statusId,
			fromDate, toDate, byUser, strType, begin, end);
	}

	public static int countArticleByDateTypes(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser,
		java.lang.String[] strType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countArticleByDateTypes(groupId, language, statusId,
			fromDate, toDate, byUser, strType);
	}

	public static int countByType(long groupId, java.lang.String language,
		long statusId, long typeId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countByType(groupId, language, statusId, typeId, fromDate,
			toDate, byUser);
	}

	public static int countByUser(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, long typeId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countByUser(groupId, language, categoryId, statusId,
			typeId, fromDate, toDate, byUser);
	}

	public static int countArticleNotInType(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticleNotInType(groupId, language, categoryId,
			statusId, fromDate, toDate, byUser);
	}

	public static int countArticleAllCatNotInType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticleAllCatNotInType(groupId, language, statusId,
			fromDate, toDate, byUser);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesBySearchContainer(
		java.lang.String keyword, long groupId, java.lang.String language,
		java.lang.String portionId, java.lang.String parentId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesBySearchContainer(keyword, groupId, language,
			portionId, parentId, isTitle, isLead, isContent, isDate, fromDate,
			toDate, statusId, select);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesBySearchContainer(
		java.lang.String keyword, long groupId, java.lang.String language,
		java.lang.String portionId, java.lang.String parentId, long typeId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesBySearchContainer(keyword, groupId, language,
			portionId, parentId, typeId, isTitle, isLead, isContent, isDate,
			fromDate, toDate, statusId, select, start, end);
	}

	public static int countArticlesBySearchContainer(java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String parentId, long typeId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticlesBySearchContainer(keyword, groupId, language,
			portionId, parentId, typeId, isTitle, isLead, isContent, isDate,
			fromDate, toDate, statusId, select);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesBySearchContainer_T(
		java.lang.String categoryId, long typeId, java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String threadId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticlesBySearchContainer_T(categoryId, typeId, keyword,
			groupId, language, threadId, isTitle, isLead, isContent, isDate,
			fromDate, toDate, statusId, select, start, end);
	}

	public static int countArticlesBySearchContainer_T(
		java.lang.String categoryId, long typeId, java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String threadId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticlesBySearchContainer_T(categoryId, typeId,
			keyword, groupId, language, threadId, isTitle, isLead, isContent,
			isDate, fromDate, toDate, statusId, select);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByG_L_C_S_T(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, long typeId, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticleByG_L_C_S_T(groupId, language, categoryId,
			statusId, typeId, begin, end);
	}

	public static int countArticleByG_L_C_S_T(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticleByG_L_C_S_T(groupId, language, categoryId,
			statusId, typeId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByG_L_S_T(
		long groupId, java.lang.String language, long statusId, long typeId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticleByG_L_S_T(groupId, language, statusId, typeId,
			begin, end);
	}

	public static int countArticleByG_L_S_T(long groupId,
		java.lang.String language, long statusId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticleByG_L_S_T(groupId, language, statusId, typeId);
	}

	public static int countArticleByG_L_S_C_D(long groupId,
		java.lang.String language, long statusId, java.lang.String categoryId,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countArticleByG_L_S_C_D(groupId, language, statusId,
			categoryId, fromDate, toDate);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByG_L_S_C_D(
		long groupId, java.lang.String language, long statusId,
		java.lang.String categoryId, java.util.Date fromDate,
		java.util.Date toDate, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getArticleByG_L_S_C_D(groupId, language, statusId,
			categoryId, fromDate, toDate, begin, end);
	}

	public static int countOtherArticle(long groupId,
		java.lang.String language, long statusId, java.lang.String categoryId,
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countOtherArticle(groupId, language, statusId, categoryId,
			articleId);
	}

	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getOtherArticle(
		long groupId, java.lang.String language, long statusId,
		java.lang.String categoryId, java.lang.String articleId, int begin,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getOtherArticle(groupId, language, statusId, categoryId,
			articleId, begin, end);
	}

	public static void removeExpiredStickyArticles(
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().removeExpiredStickyArticles(upRequest);
	}

	public static void reIndex(java.lang.String[] ids)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().reIndex(ids);
	}

	public static com.liferay.portal.kernel.search.Hits search(
		javax.servlet.http.HttpServletRequest request, long companyId,
		long groupId, long userId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(request, companyId, groupId, userId, keywords,
			start, end);
	}

	public static void restoreArticleVersion(long articleVersionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		getService().restoreArticleVersion(articleVersionId);
	}

	public static long getStatusIdOfPublishedArticles(long companyId,
		long groupId, boolean active) throws java.lang.Exception {
		return getService()
				   .getStatusIdOfPublishedArticles(companyId, groupId, active);
	}

	public static long getStatusIdOfPublishedArticles(boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().getStatusIdOfPublishedArticles(active);
	}

	public static void saveImage(javax.portlet.ActionRequest req,
		com.liferay.portal.kernel.upload.UploadPortletRequest uploadReq,
		com.vportal.portlet.vcms.model.VcmsArticle article,
		java.lang.String image, java.lang.String imageTitle, long companyId)
		throws java.lang.Exception {
		getService()
			.saveImage(req, uploadReq, article, image, imageTitle, companyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VcmsArticleService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsArticleService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsArticleService.class.getName(), portletClassLoader);

			_service = new VcmsArticleServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsArticleServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsArticleService.class);
		}

		return _service;
	}

	public void setService(VcmsArticleService service) {
		MethodCache.remove(VcmsArticleService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsArticleServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsArticleService.class);
	}

	private static VcmsArticleService _service;
}