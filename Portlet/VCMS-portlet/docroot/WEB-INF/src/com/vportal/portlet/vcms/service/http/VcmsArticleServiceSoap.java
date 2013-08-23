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

import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcms.service.VcmsArticleServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcms.model.VcmsArticleSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcms.model.VcmsArticle}, that is translated to a
 * {@link com.vportal.portlet.vcms.model.VcmsArticleSoap}. Methods that SOAP cannot
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
 * @see       VcmsArticleServiceHttp
 * @see       com.vportal.portlet.vcms.model.VcmsArticleSoap
 * @see       com.vportal.portlet.vcms.service.VcmsArticleServiceUtil
 * @generated
 */
public class VcmsArticleServiceSoap {
	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByCompanyId(
		long companyId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByCompanyId(companyId, start,
					end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByCompanyId(
		long companyId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByCompanyId(companyId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticleByCompanyId(long companyId)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticleByCompanyId(companyId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addArticleResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			VcmsArticleServiceUtil.addArticleResources(articleId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addArticleResources(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			VcmsArticleServiceUtil.addArticleResources(article,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addArticleResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			VcmsArticleServiceUtil.addArticleResources(articleId,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addArticleResources(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			VcmsArticleServiceUtil.addArticleResources(article,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticleSoap updateArticle(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsArticle returnValue = VcmsArticleServiceUtil.updateArticle(article,
					upRequest);

			return com.vportal.portlet.vcms.model.VcmsArticleSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteArticle(java.lang.String articleId)
		throws RemoteException {
		try {
			VcmsArticleServiceUtil.deleteArticle(articleId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteArticles(java.lang.String[] articleIds)
		throws RemoteException {
		try {
			VcmsArticleServiceUtil.deleteArticles(articleIds);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticleSoap getArticle(
		java.lang.String articleId) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsArticle returnValue = VcmsArticleServiceUtil.getArticle(articleId);

			return com.vportal.portlet.vcms.model.VcmsArticleSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticles(
		java.lang.String[] articleIds) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticles(articleIds);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesByU_L_S(
		long groupId, java.lang.String userId, int status,
		java.lang.String language) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesByU_L_S(groupId, userId,
					status, language);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesByU_L_S(
		long groupId, java.lang.String userId, int status,
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesByU_L_S(groupId, userId,
					status, language, obc);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesByL_S(
		long groupId, java.lang.String language, long statusId)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesByL_S(groupId, language,
					statusId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesByL_S(
		long groupId, java.lang.String language, long statusId, int start,
		int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesByL_S(groupId, language,
					statusId, start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticlesByL_S(long groupId,
		java.lang.String language, long statusId) throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticlesByL_S(groupId,
					language, statusId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesByG_L_S_U(
		long groupId, java.lang.String language, long statusId,
		java.lang.String createdByUser, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesByG_L_S_U(groupId, language,
					statusId, createdByUser, start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticlesByG_L_S_U(long groupId,
		java.lang.String language, long statusId, java.lang.String createdByUser)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticlesByG_L_S_U(groupId,
					language, statusId, createdByUser);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesByL_S(
		long groupId, java.lang.String language, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesByL_S(groupId, language,
					status, obc);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesByL_S_S(
		long groupId, java.lang.String language, long statusId, boolean sticky)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesByL_S_S(groupId, language,
					statusId, sticky);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesNewByL_S_S(
		long groupId, java.lang.String language, long statusId, boolean sticky,
		int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesNewByL_S_S(groupId, language,
					statusId, sticky, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticlesByL_S_S(long groupId,
		java.lang.String language, long statusId, boolean sticky)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticlesByL_S_S(groupId,
					language, statusId, sticky);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesByL_S_S(
		long groupId, java.lang.String language, int statusId, boolean sticky,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesByL_S_S(groupId, language,
					statusId, sticky, obc);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByP_L_S_D(
		long groupId, java.lang.String language, long statusId,
		boolean discussible) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByP_L_S_D(groupId, language,
					statusId, discussible);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByC_P_L_S(
		java.lang.String categoryId, long groupId, java.lang.String language,
		long statusId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByC_P_L_S(categoryId, groupId,
					language, statusId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByC_P_L_S(
		java.lang.String categoryId, long groupId, java.lang.String language,
		long statusId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByC_P_L_S(categoryId, groupId,
					language, statusId, start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticleByC_P_L_S(java.lang.String categoryId,
		long groupId, java.lang.String language, long statusId)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticleByC_P_L_S(categoryId,
					groupId, language, statusId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByP_P_L_S(
		java.lang.String portionId, long groupId, java.lang.String language,
		long statusId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByP_P_L_S(portionId, groupId,
					language, statusId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticleByP_P_L_S(java.lang.String portionId,
		long groupId, java.lang.String language, long statusId)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticleByP_P_L_S(portionId,
					groupId, language, statusId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByP_P_L_S(
		java.lang.String portionId, long groupId, java.lang.String language,
		long statusId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByP_P_L_S(portionId, groupId,
					language, statusId, start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByT_P_L_S(
		java.lang.String threadId, long groupId, java.lang.String language,
		long statusId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByT_P_L_S(threadId, groupId,
					language, statusId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByT_P_L_S(
		java.lang.String threadId, long groupId, java.lang.String language,
		long statusId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByT_P_L_S(threadId, groupId,
					language, statusId, start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticleByT_P_L_S(java.lang.String threadId,
		long groupId, java.lang.String language, long statusId)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticleByT_P_L_S(threadId,
					groupId, language, statusId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByStatus(long groupId, java.lang.String language,
		long statusId) throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countByStatus(groupId,
					language, statusId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByStatus(long statusId) throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countByStatus(statusId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, int quantity)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getTopNewArticles(groupId, language,
					portionId, categoryId, statusId, quantity);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getHotNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, int quantity)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getHotNewArticles(groupId, language,
					portionId, categoryId, statusId, quantity);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, boolean sticky, int quantity)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getTopNewArticles(groupId, language,
					portionId, categoryId, statusId, sticky, quantity);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getTopNewArticles(
		long groupId, java.lang.String language, long statusId, boolean sticky,
		int quantity) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getTopNewArticles(groupId, language,
					statusId, sticky, quantity);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, boolean sticky, int quantity) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getTopNewArticles(groupId, language,
					categoryId, statusId, sticky, quantity);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, int quantity,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getTopNewArticles(groupId, language,
					categoryId, statusId, quantity, obc);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getAllCategoryArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, int begin, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getAllCategoryArticles(groupId,
					language, categoryId, statusId, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countAllCategoryArticles(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countAllCategoryArticles(groupId,
					language, categoryId, statusId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String threadId,
		long statusId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesInThread(groupId, language,
					threadId, statusId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String threadId,
		long statusId, int quantity) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesInThread(groupId, language,
					threadId, statusId, quantity);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String[] threadIds,
		long statusId, int quantity) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesInThread(groupId, language,
					threadIds, statusId, quantity);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getOlderArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, java.lang.String articleId, long statusId,
		int quantity) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getOlderArticles(groupId, language,
					portionId, categoryId, articleId, statusId, quantity);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, java.lang.String articleId, long statusId,
		int quantity) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getNewArticles(groupId, language,
					portionId, categoryId, articleId, statusId, quantity);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByC_P_L_S_D(java.lang.String categoryId,
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countByC_P_L_S_D(categoryId,
					groupId, language, statusId, fromDate, toDate, byUser);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByP_L_S_D(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser) throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countByP_L_S_D(groupId,
					language, statusId, fromDate, toDate, byUser);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] listReportByDate(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, long typeId, int begin, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.listReportByDate(groupId, language,
					statusId, fromDate, toDate, byUser, typeId, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] listReportByDateNotType(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, int begin, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.listReportByDateNotType(groupId,
					language, statusId, fromDate, toDate, byUser, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByDate(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, long typeId) throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countByDate(groupId,
					language, statusId, fromDate, toDate, byUser, typeId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByDateNotType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countByDateNotType(groupId,
					language, statusId, fromDate, toDate, byUser);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] listArticleByDateTypes(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, java.lang.String[] strType, int begin, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.listArticleByDateTypes(groupId,
					language, statusId, fromDate, toDate, byUser, strType,
					begin, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticleByDateTypes(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser,
		java.lang.String[] strType) throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticleByDateTypes(groupId,
					language, statusId, fromDate, toDate, byUser, strType);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByType(long groupId, java.lang.String language,
		long statusId, long typeId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countByType(groupId,
					language, statusId, typeId, fromDate, toDate, byUser);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByUser(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, long typeId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countByUser(groupId,
					language, categoryId, statusId, typeId, fromDate, toDate,
					byUser);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticleNotInType(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticleNotInType(groupId,
					language, categoryId, statusId, fromDate, toDate, byUser);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticleAllCatNotInType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticleAllCatNotInType(groupId,
					language, statusId, fromDate, toDate, byUser);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesBySearchContainer(
		java.lang.String keyword, long groupId, java.lang.String language,
		java.lang.String portionId, java.lang.String parentId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesBySearchContainer(keyword,
					groupId, language, portionId, parentId, isTitle, isLead,
					isContent, isDate, fromDate, toDate, statusId, select);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesBySearchContainer(
		java.lang.String keyword, long groupId, java.lang.String language,
		java.lang.String portionId, java.lang.String parentId, long typeId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select, int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesBySearchContainer(keyword,
					groupId, language, portionId, parentId, typeId, isTitle,
					isLead, isContent, isDate, fromDate, toDate, statusId,
					select, start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticlesBySearchContainer(java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String parentId, long typeId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select) throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticlesBySearchContainer(keyword,
					groupId, language, portionId, parentId, typeId, isTitle,
					isLead, isContent, isDate, fromDate, toDate, statusId,
					select);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticlesBySearchContainer_T(
		java.lang.String categoryId, long typeId, java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String threadId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select, int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticlesBySearchContainer_T(categoryId,
					typeId, keyword, groupId, language, threadId, isTitle,
					isLead, isContent, isDate, fromDate, toDate, statusId,
					select, start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticlesBySearchContainer_T(
		java.lang.String categoryId, long typeId, java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String threadId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select) throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticlesBySearchContainer_T(categoryId,
					typeId, keyword, groupId, language, threadId, isTitle,
					isLead, isContent, isDate, fromDate, toDate, statusId,
					select);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByG_L_C_S_T(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, long typeId, int begin, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByG_L_C_S_T(groupId, language,
					categoryId, statusId, typeId, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticleByG_L_C_S_T(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId,
		long typeId) throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticleByG_L_C_S_T(groupId,
					language, categoryId, statusId, typeId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByG_L_S_T(
		long groupId, java.lang.String language, long statusId, long typeId,
		int begin, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByG_L_S_T(groupId, language,
					statusId, typeId, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticleByG_L_S_T(long groupId,
		java.lang.String language, long statusId, long typeId)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticleByG_L_S_T(groupId,
					language, statusId, typeId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticleByG_L_S_C_D(long groupId,
		java.lang.String language, long statusId, java.lang.String categoryId,
		java.util.Date fromDate, java.util.Date toDate)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countArticleByG_L_S_C_D(groupId,
					language, statusId, categoryId, fromDate, toDate);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getArticleByG_L_S_C_D(
		long groupId, java.lang.String language, long statusId,
		java.lang.String categoryId, java.util.Date fromDate,
		java.util.Date toDate, int begin, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getArticleByG_L_S_C_D(groupId, language,
					statusId, categoryId, fromDate, toDate, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countOtherArticle(long groupId,
		java.lang.String language, long statusId, java.lang.String categoryId,
		java.lang.String articleId) throws RemoteException {
		try {
			int returnValue = VcmsArticleServiceUtil.countOtherArticle(groupId,
					language, statusId, categoryId, articleId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticle[] getOtherArticle(
		long groupId, java.lang.String language, long statusId,
		java.lang.String categoryId, java.lang.String articleId, int begin,
		int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> returnValue =
				VcmsArticleServiceUtil.getOtherArticle(groupId, language,
					statusId, categoryId, articleId, begin, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticle[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void removeExpiredStickyArticles(
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest)
		throws RemoteException {
		try {
			VcmsArticleServiceUtil.removeExpiredStickyArticles(upRequest);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void reIndex(java.lang.String[] ids)
		throws RemoteException {
		try {
			VcmsArticleServiceUtil.reIndex(ids);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void restoreArticleVersion(long articleVersionId)
		throws RemoteException {
		try {
			VcmsArticleServiceUtil.restoreArticleVersion(articleVersionId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long getStatusIdOfPublishedArticles(long companyId,
		long groupId, boolean active) throws RemoteException {
		try {
			long returnValue = VcmsArticleServiceUtil.getStatusIdOfPublishedArticles(companyId,
					groupId, active);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long getStatusIdOfPublishedArticles(boolean active)
		throws RemoteException {
		try {
			long returnValue = VcmsArticleServiceUtil.getStatusIdOfPublishedArticles(active);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VcmsArticleServiceSoap.class);
}