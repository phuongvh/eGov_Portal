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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author hai
 */
public class VcmsArticleServiceClp implements VcmsArticleService {
	public VcmsArticleServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_getArticleByCompanyIdMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByCompanyId", long.class, int.class, int.class);

		_getArticleByCompanyIdMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByCompanyId", long.class);

		_countArticleByCompanyIdMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticleByCompanyId", long.class);

		_addArticleMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"addArticle", javax.portlet.ActionRequest.class,
				com.liferay.portal.kernel.upload.UploadPortletRequest.class,
				long.class, long.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, boolean.class,
				java.lang.String.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String[].class,
				java.lang.String[].class);

		_addArticleMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"addArticle", javax.portlet.ActionRequest.class,
				com.liferay.portal.kernel.upload.UploadPortletRequest.class,
				long.class, long.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, boolean.class,
				java.lang.String.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.Boolean.class,
				java.lang.Boolean.class, java.lang.String[].class,
				java.lang.String[].class);

		_addArticleResourcesMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"addArticleResources", java.lang.String.class, boolean.class,
				boolean.class);

		_addArticleResourcesMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"addArticleResources",
				com.vportal.portlet.vcms.model.VcmsArticle.class,
				boolean.class, boolean.class);

		_addArticleResourcesMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"addArticleResources", java.lang.String.class,
				java.lang.String[].class, java.lang.String[].class);

		_addArticleResourcesMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"addArticleResources",
				com.vportal.portlet.vcms.model.VcmsArticle.class,
				java.lang.String[].class, java.lang.String[].class);

		_updateArticleMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateArticle", javax.portlet.ActionRequest.class,
				com.liferay.portal.kernel.upload.UploadPortletRequest.class,
				long.class, long.class, java.lang.String.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				boolean.class, boolean.class, java.lang.String.class,
				boolean.class, boolean.class, java.util.Date.class);

		_updateArticleMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateArticle", javax.portlet.ActionRequest.class,
				com.liferay.portal.kernel.upload.UploadPortletRequest.class,
				com.vportal.portlet.vcms.model.VcmsArticle.class);

		_updateArticleMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateArticle",
				com.vportal.portlet.vcms.model.VcmsArticle.class,
				com.liferay.portal.kernel.upload.UploadPortletRequest.class);

		_deleteArticleMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteArticle", java.lang.String.class);

		_deleteArticlesMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteArticles", java.lang.String[].class);

		_getArticleMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticle", java.lang.String.class);

		_getArticlesMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticles", java.lang.String[].class);

		_getArticlesByU_L_SMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesByU_L_S", long.class, java.lang.String.class,
				int.class, java.lang.String.class);

		_getArticlesByU_L_SMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesByU_L_S", long.class, java.lang.String.class,
				int.class, java.lang.String.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_getArticlesByL_SMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesByL_S", long.class, java.lang.String.class,
				long.class);

		_getArticlesByL_SMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesByL_S", long.class, java.lang.String.class,
				long.class, int.class, int.class);

		_countArticlesByL_SMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticlesByL_S", long.class, java.lang.String.class,
				long.class);

		_getArticlesByG_L_S_UMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesByG_L_S_U", long.class, java.lang.String.class,
				long.class, java.lang.String.class, int.class, int.class);

		_countArticlesByG_L_S_UMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticlesByG_L_S_U", long.class, java.lang.String.class,
				long.class, java.lang.String.class);

		_getArticlesByL_SMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesByL_S", long.class, java.lang.String.class,
				int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_getArticlesByL_S_SMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesByL_S_S", long.class, java.lang.String.class,
				long.class, boolean.class);

		_getArticlesNewByL_S_SMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesNewByL_S_S", long.class, java.lang.String.class,
				long.class, boolean.class, int.class);

		_countArticlesByL_S_SMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticlesByL_S_S", long.class, java.lang.String.class,
				long.class, boolean.class);

		_getArticlesByL_S_SMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesByL_S_S", long.class, java.lang.String.class,
				int.class, boolean.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_getArticleByP_L_S_DMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByP_L_S_D", long.class, java.lang.String.class,
				long.class, boolean.class);

		_getArticleByC_P_L_SMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByC_P_L_S", java.lang.String.class, long.class,
				java.lang.String.class, long.class);

		_getArticleByC_P_L_SMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByC_P_L_S", java.lang.String.class, long.class,
				java.lang.String.class, long.class, int.class, int.class);

		_countArticleByC_P_L_SMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticleByC_P_L_S", java.lang.String.class, long.class,
				java.lang.String.class, long.class);

		_getArticleByP_P_L_SMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByP_P_L_S", java.lang.String.class, long.class,
				java.lang.String.class, long.class);

		_countArticleByP_P_L_SMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticleByP_P_L_S", java.lang.String.class, long.class,
				java.lang.String.class, long.class);

		_getArticleByP_P_L_SMethodKey34 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByP_P_L_S", java.lang.String.class, long.class,
				java.lang.String.class, long.class, int.class, int.class);

		_getArticleByT_P_L_SMethodKey35 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByT_P_L_S", java.lang.String.class, long.class,
				java.lang.String.class, long.class);

		_getArticleByT_P_L_SMethodKey36 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByT_P_L_S", java.lang.String.class, long.class,
				java.lang.String.class, long.class, int.class, int.class);

		_countArticleByT_P_L_SMethodKey37 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticleByT_P_L_S", java.lang.String.class, long.class,
				java.lang.String.class, long.class);

		_countByStatusMethodKey38 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByStatus", long.class, java.lang.String.class, long.class);

		_countByStatusMethodKey39 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByStatus", long.class);

		_getTopNewArticlesMethodKey40 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTopNewArticles", long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, long.class,
				int.class);

		_getHotNewArticlesMethodKey41 = new MethodKey(_classLoaderProxy.getClassName(),
				"getHotNewArticles", long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, long.class,
				int.class);

		_getTopNewArticlesMethodKey42 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTopNewArticles", long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, long.class,
				boolean.class, int.class);

		_getTopNewArticlesMethodKey43 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTopNewArticles", long.class, java.lang.String.class,
				long.class, boolean.class, int.class);

		_getTopNewArticlesMethodKey44 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTopNewArticles", long.class, java.lang.String.class,
				java.lang.String.class, long.class, boolean.class, int.class);

		_getTopNewArticlesMethodKey45 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTopNewArticles", long.class, java.lang.String.class,
				java.lang.String.class, long.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_getAllCategoryArticlesMethodKey46 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllCategoryArticles", long.class, java.lang.String.class,
				java.lang.String.class, long.class, int.class, int.class);

		_countAllCategoryArticlesMethodKey47 = new MethodKey(_classLoaderProxy.getClassName(),
				"countAllCategoryArticles", long.class, java.lang.String.class,
				java.lang.String.class, long.class);

		_getArticlesInThreadMethodKey48 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesInThread", long.class, java.lang.String.class,
				java.lang.String.class, long.class);

		_getArticlesInThreadMethodKey49 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesInThread", long.class, java.lang.String.class,
				java.lang.String.class, long.class, int.class);

		_getArticlesInThreadMethodKey50 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesInThread", long.class, java.lang.String.class,
				java.lang.String[].class, long.class, int.class);

		_getOlderArticlesMethodKey51 = new MethodKey(_classLoaderProxy.getClassName(),
				"getOlderArticles", long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class, int.class);

		_getNewArticlesMethodKey52 = new MethodKey(_classLoaderProxy.getClassName(),
				"getNewArticles", long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class, int.class);

		_countByC_P_L_S_DMethodKey53 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByC_P_L_S_D", java.lang.String.class, long.class,
				java.lang.String.class, long.class, java.util.Date.class,
				java.util.Date.class, java.lang.String.class);

		_countByP_L_S_DMethodKey54 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByP_L_S_D", long.class, java.lang.String.class,
				long.class, java.util.Date.class, java.util.Date.class,
				java.lang.String.class);

		_listReportByDateMethodKey55 = new MethodKey(_classLoaderProxy.getClassName(),
				"listReportByDate", long.class, java.lang.String.class,
				long.class, java.util.Date.class, java.util.Date.class,
				java.lang.String.class, long.class, int.class, int.class);

		_listReportByDateNotTypeMethodKey56 = new MethodKey(_classLoaderProxy.getClassName(),
				"listReportByDateNotType", long.class, java.lang.String.class,
				long.class, java.util.Date.class, java.util.Date.class,
				java.lang.String.class, int.class, int.class);

		_countByDateMethodKey57 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByDate", long.class, java.lang.String.class, long.class,
				java.util.Date.class, java.util.Date.class,
				java.lang.String.class, long.class);

		_countByDateNotTypeMethodKey58 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByDateNotType", long.class, java.lang.String.class,
				long.class, java.util.Date.class, java.util.Date.class,
				java.lang.String.class);

		_listArticleByDateTypesMethodKey59 = new MethodKey(_classLoaderProxy.getClassName(),
				"listArticleByDateTypes", long.class, java.lang.String.class,
				long.class, java.util.Date.class, java.util.Date.class,
				java.lang.String.class, java.lang.String[].class, int.class,
				int.class);

		_countArticleByDateTypesMethodKey60 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticleByDateTypes", long.class, java.lang.String.class,
				long.class, java.util.Date.class, java.util.Date.class,
				java.lang.String.class, java.lang.String[].class);

		_countByTypeMethodKey61 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByType", long.class, java.lang.String.class, long.class,
				long.class, java.util.Date.class, java.util.Date.class,
				java.lang.String.class);

		_countByUserMethodKey62 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByUser", long.class, java.lang.String.class,
				java.lang.String.class, long.class, long.class,
				java.util.Date.class, java.util.Date.class,
				java.lang.String.class);

		_countArticleNotInTypeMethodKey63 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticleNotInType", long.class, java.lang.String.class,
				java.lang.String.class, long.class, java.util.Date.class,
				java.util.Date.class, java.lang.String.class);

		_countArticleAllCatNotInTypeMethodKey64 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticleAllCatNotInType", long.class,
				java.lang.String.class, long.class, java.util.Date.class,
				java.util.Date.class, java.lang.String.class);

		_getArticlesBySearchContainerMethodKey65 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesBySearchContainer", java.lang.String.class,
				long.class, java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, boolean.class,
				boolean.class, boolean.class, java.util.Date.class,
				java.util.Date.class, long.class, java.lang.String.class);

		_getArticlesBySearchContainerMethodKey66 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesBySearchContainer", java.lang.String.class,
				long.class, java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class, boolean.class,
				boolean.class, boolean.class, boolean.class,
				java.util.Date.class, java.util.Date.class, long.class,
				java.lang.String.class, int.class, int.class);

		_countArticlesBySearchContainerMethodKey67 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticlesBySearchContainer", java.lang.String.class,
				long.class, java.lang.String.class, java.lang.String.class,
				java.lang.String.class, long.class, boolean.class,
				boolean.class, boolean.class, boolean.class,
				java.util.Date.class, java.util.Date.class, long.class,
				java.lang.String.class);

		_getArticlesBySearchContainer_TMethodKey68 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticlesBySearchContainer_T", java.lang.String.class,
				long.class, java.lang.String.class, long.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				boolean.class, boolean.class, boolean.class,
				java.util.Date.class, java.util.Date.class, long.class,
				java.lang.String.class, int.class, int.class);

		_countArticlesBySearchContainer_TMethodKey69 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticlesBySearchContainer_T", java.lang.String.class,
				long.class, java.lang.String.class, long.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				boolean.class, boolean.class, boolean.class,
				java.util.Date.class, java.util.Date.class, long.class,
				java.lang.String.class);

		_getArticleByG_L_C_S_TMethodKey70 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByG_L_C_S_T", long.class, java.lang.String.class,
				java.lang.String.class, long.class, long.class, int.class,
				int.class);

		_countArticleByG_L_C_S_TMethodKey71 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticleByG_L_C_S_T", long.class, java.lang.String.class,
				java.lang.String.class, long.class, long.class);

		_getArticleByG_L_S_TMethodKey72 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByG_L_S_T", long.class, java.lang.String.class,
				long.class, long.class, int.class, int.class);

		_countArticleByG_L_S_TMethodKey73 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticleByG_L_S_T", long.class, java.lang.String.class,
				long.class, long.class);

		_countArticleByG_L_S_C_DMethodKey74 = new MethodKey(_classLoaderProxy.getClassName(),
				"countArticleByG_L_S_C_D", long.class, java.lang.String.class,
				long.class, java.lang.String.class, java.util.Date.class,
				java.util.Date.class);

		_getArticleByG_L_S_C_DMethodKey75 = new MethodKey(_classLoaderProxy.getClassName(),
				"getArticleByG_L_S_C_D", long.class, java.lang.String.class,
				long.class, java.lang.String.class, java.util.Date.class,
				java.util.Date.class, int.class, int.class);

		_countOtherArticleMethodKey76 = new MethodKey(_classLoaderProxy.getClassName(),
				"countOtherArticle", long.class, java.lang.String.class,
				long.class, java.lang.String.class, java.lang.String.class);

		_getOtherArticleMethodKey77 = new MethodKey(_classLoaderProxy.getClassName(),
				"getOtherArticle", long.class, java.lang.String.class,
				long.class, java.lang.String.class, java.lang.String.class,
				int.class, int.class);

		_removeExpiredStickyArticlesMethodKey78 = new MethodKey(_classLoaderProxy.getClassName(),
				"removeExpiredStickyArticles",
				com.liferay.portal.kernel.upload.UploadPortletRequest.class);

		_reIndexMethodKey79 = new MethodKey(_classLoaderProxy.getClassName(),
				"reIndex", java.lang.String[].class);

		_searchMethodKey80 = new MethodKey(_classLoaderProxy.getClassName(),
				"search", javax.servlet.http.HttpServletRequest.class,
				long.class, long.class, long.class, java.lang.String.class,
				int.class, int.class);

		_restoreArticleVersionMethodKey81 = new MethodKey(_classLoaderProxy.getClassName(),
				"restoreArticleVersion", long.class);

		_getStatusIdOfPublishedArticlesMethodKey82 = new MethodKey(_classLoaderProxy.getClassName(),
				"getStatusIdOfPublishedArticles", long.class, long.class,
				boolean.class);

		_getStatusIdOfPublishedArticlesMethodKey83 = new MethodKey(_classLoaderProxy.getClassName(),
				"getStatusIdOfPublishedArticles", boolean.class);

		_saveImageMethodKey84 = new MethodKey(_classLoaderProxy.getClassName(),
				"saveImage", javax.portlet.ActionRequest.class,
				com.liferay.portal.kernel.upload.UploadPortletRequest.class,
				com.vportal.portlet.vcms.model.VcmsArticle.class,
				java.lang.String.class, java.lang.String.class, long.class);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByCompanyIdMethodKey0,
				companyId, start, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByCompanyIdMethodKey1,
				companyId);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countArticleByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticleByCompanyIdMethodKey2,
				companyId);

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

		return ((Integer)returnObj).intValue();
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addArticleMethodKey3,
				ClpSerializer.translateInput(req),
				ClpSerializer.translateInput(upRequest), groupId, companyId,
				plid, ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(lead),
				ClpSerializer.translateInput(content), hasImage,
				ClpSerializer.translateInput(imageTitle),
				ClpSerializer.translateInput(image),
				ClpSerializer.translateInput(language), hasAttachment, hasPoll,
				ClpSerializer.translateInput(pollId), status,
				ClpSerializer.translateInput(author),
				ClpSerializer.translateInput(source),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

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

		return (com.vportal.portlet.vcms.model.VcmsArticle)ClpSerializer.translateOutput(returnObj);
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addArticleMethodKey4,
				ClpSerializer.translateInput(req),
				ClpSerializer.translateInput(upRequest), groupId, companyId,
				plid, ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(lead),
				ClpSerializer.translateInput(content), hasImage,
				ClpSerializer.translateInput(imageTitle),
				ClpSerializer.translateInput(image),
				ClpSerializer.translateInput(language), hasAttachment, hasPoll,
				ClpSerializer.translateInput(pollId), status,
				ClpSerializer.translateInput(author),
				ClpSerializer.translateInput(source),
				ClpSerializer.translateInput(addCommunityPermissions),
				ClpSerializer.translateInput(addGuestPermissions),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

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

		return (com.vportal.portlet.vcms.model.VcmsArticle)ClpSerializer.translateOutput(returnObj);
	}

	public void addArticleResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addArticleResourcesMethodKey5,
				ClpSerializer.translateInput(articleId),
				addCommunityPermissions, addGuestPermissions);

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

	public void addArticleResources(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addArticleResourcesMethodKey6,
				ClpSerializer.translateInput(article), addCommunityPermissions,
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

	public void addArticleResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addArticleResourcesMethodKey7,
				ClpSerializer.translateInput(articleId),
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

	public void addArticleResources(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addArticleResourcesMethodKey8,
				ClpSerializer.translateInput(article),
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateArticleMethodKey9,
				ClpSerializer.translateInput(req),
				ClpSerializer.translateInput(upRequest), groupId, companyId,
				ClpSerializer.translateInput(articleId), status,
				ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(lead),
				ClpSerializer.translateInput(content), hasImage,
				ClpSerializer.translateInput(imageTitle),
				ClpSerializer.translateInput(image),
				ClpSerializer.translateInput(language), discussible,
				hasAttachment, hasPoll, ClpSerializer.translateInput(pollId),
				sticky, stickyNeverExpired,
				ClpSerializer.translateInput(stickyExpireDate));

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

		return (com.vportal.portlet.vcms.model.VcmsArticle)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vcms.model.VcmsArticle updateArticle(
		javax.portlet.ActionRequest req,
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest,
		com.vportal.portlet.vcms.model.VcmsArticle article)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateArticleMethodKey10,
				ClpSerializer.translateInput(req),
				ClpSerializer.translateInput(upRequest),
				ClpSerializer.translateInput(article));

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

		return (com.vportal.portlet.vcms.model.VcmsArticle)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vcms.model.VcmsArticle updateArticle(
		com.vportal.portlet.vcms.model.VcmsArticle article,
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateArticleMethodKey11,
				ClpSerializer.translateInput(article),
				ClpSerializer.translateInput(upRequest));

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

		return (com.vportal.portlet.vcms.model.VcmsArticle)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteArticleMethodKey12,
				ClpSerializer.translateInput(articleId));

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

	public void deleteArticles(java.lang.String[] articleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteArticlesMethodKey13,
				ClpSerializer.translateInput(articleIds));

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

	public com.vportal.portlet.vcms.model.VcmsArticle getArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleMethodKey14,
				ClpSerializer.translateInput(articleId));

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

		return (com.vportal.portlet.vcms.model.VcmsArticle)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticles(
		java.lang.String[] articleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesMethodKey15,
				ClpSerializer.translateInput(articleIds));

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByU_L_S(
		long groupId, java.lang.String userId, int status,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesByU_L_SMethodKey16,
				groupId, ClpSerializer.translateInput(userId), status,
				ClpSerializer.translateInput(language));

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByU_L_S(
		long groupId, java.lang.String userId, int status,
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesByU_L_SMethodKey17,
				groupId, ClpSerializer.translateInput(userId), status,
				ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(obc));

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S(
		long groupId, java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesByL_SMethodKey18,
				groupId, ClpSerializer.translateInput(language), statusId);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S(
		long groupId, java.lang.String language, long statusId, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesByL_SMethodKey19,
				groupId, ClpSerializer.translateInput(language), statusId,
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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countArticlesByL_S(long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticlesByL_SMethodKey20,
				groupId, ClpSerializer.translateInput(language), statusId);

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByG_L_S_U(
		long groupId, java.lang.String language, long statusId,
		java.lang.String createdByUser, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesByG_L_S_UMethodKey21,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(createdByUser), start, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countArticlesByG_L_S_U(long groupId, java.lang.String language,
		long statusId, java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticlesByG_L_S_UMethodKey22,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(createdByUser));

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S(
		long groupId, java.lang.String language, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesByL_SMethodKey23,
				groupId, ClpSerializer.translateInput(language), status,
				ClpSerializer.translateInput(obc));

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S_S(
		long groupId, java.lang.String language, long statusId, boolean sticky)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesByL_S_SMethodKey24,
				groupId, ClpSerializer.translateInput(language), statusId,
				sticky);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesNewByL_S_S(
		long groupId, java.lang.String language, long statusId, boolean sticky,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesNewByL_S_SMethodKey25,
				groupId, ClpSerializer.translateInput(language), statusId,
				sticky, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countArticlesByL_S_S(long groupId, java.lang.String language,
		long statusId, boolean sticky)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticlesByL_S_SMethodKey26,
				groupId, ClpSerializer.translateInput(language), statusId,
				sticky);

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesByL_S_S(
		long groupId, java.lang.String language, int statusId, boolean sticky,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesByL_S_SMethodKey27,
				groupId, ClpSerializer.translateInput(language), statusId,
				sticky, ClpSerializer.translateInput(obc));

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByP_L_S_D(
		long groupId, java.lang.String language, long statusId,
		boolean discussible)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByP_L_S_DMethodKey28,
				groupId, ClpSerializer.translateInput(language), statusId,
				discussible);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByC_P_L_S(
		java.lang.String categoryId, long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByC_P_L_SMethodKey29,
				ClpSerializer.translateInput(categoryId), groupId,
				ClpSerializer.translateInput(language), statusId);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByC_P_L_S(
		java.lang.String categoryId, long groupId, java.lang.String language,
		long statusId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByC_P_L_SMethodKey30,
				ClpSerializer.translateInput(categoryId), groupId,
				ClpSerializer.translateInput(language), statusId, start, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countArticleByC_P_L_S(java.lang.String categoryId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticleByC_P_L_SMethodKey31,
				ClpSerializer.translateInput(categoryId), groupId,
				ClpSerializer.translateInput(language), statusId);

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByP_P_L_S(
		java.lang.String portionId, long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByP_P_L_SMethodKey32,
				ClpSerializer.translateInput(portionId), groupId,
				ClpSerializer.translateInput(language), statusId);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countArticleByP_P_L_S(java.lang.String portionId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticleByP_P_L_SMethodKey33,
				ClpSerializer.translateInput(portionId), groupId,
				ClpSerializer.translateInput(language), statusId);

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByP_P_L_S(
		java.lang.String portionId, long groupId, java.lang.String language,
		long statusId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByP_P_L_SMethodKey34,
				ClpSerializer.translateInput(portionId), groupId,
				ClpSerializer.translateInput(language), statusId, start, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByT_P_L_S(
		java.lang.String threadId, long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByT_P_L_SMethodKey35,
				ClpSerializer.translateInput(threadId), groupId,
				ClpSerializer.translateInput(language), statusId);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByT_P_L_S(
		java.lang.String threadId, long groupId, java.lang.String language,
		long statusId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByT_P_L_SMethodKey36,
				ClpSerializer.translateInput(threadId), groupId,
				ClpSerializer.translateInput(language), statusId, start, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countArticleByT_P_L_S(java.lang.String threadId, long groupId,
		java.lang.String language, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticleByT_P_L_SMethodKey37,
				ClpSerializer.translateInput(threadId), groupId,
				ClpSerializer.translateInput(language), statusId);

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

	public int countByStatus(long groupId, java.lang.String language,
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByStatusMethodKey38,
				groupId, ClpSerializer.translateInput(language), statusId);

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

	public int countByStatus(long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByStatusMethodKey39,
				statusId);

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTopNewArticlesMethodKey40,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(categoryId), statusId, quantity);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getHotNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getHotNewArticlesMethodKey41,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(categoryId), statusId, quantity);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, long statusId, boolean sticky, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTopNewArticlesMethodKey42,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(categoryId), statusId, sticky,
				quantity);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, long statusId, boolean sticky,
		int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTopNewArticlesMethodKey43,
				groupId, ClpSerializer.translateInput(language), statusId,
				sticky, quantity);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, boolean sticky, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTopNewArticlesMethodKey44,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(categoryId), statusId, sticky,
				quantity);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getTopNewArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, int quantity,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTopNewArticlesMethodKey45,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(categoryId), statusId, quantity,
				ClpSerializer.translateInput(obc));

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getAllCategoryArticles(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllCategoryArticlesMethodKey46,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(categoryId), statusId, begin, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countAllCategoryArticles(long groupId,
		java.lang.String language, java.lang.String categoryId, long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countAllCategoryArticlesMethodKey47,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(categoryId), statusId);

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String threadId,
		long statusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesInThreadMethodKey48,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(threadId), statusId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String threadId,
		long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesInThreadMethodKey49,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(threadId), statusId, quantity);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesInThread(
		long groupId, java.lang.String language, java.lang.String[] threadIds,
		long statusId, int quantity)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesInThreadMethodKey50,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(threadIds), statusId, quantity);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getOlderArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, java.lang.String articleId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getOlderArticlesMethodKey51,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(categoryId),
				ClpSerializer.translateInput(articleId), statusId, quantity);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getNewArticles(
		long groupId, java.lang.String language, java.lang.String portionId,
		java.lang.String categoryId, java.lang.String articleId, long statusId,
		int quantity)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getNewArticlesMethodKey52,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(categoryId),
				ClpSerializer.translateInput(articleId), statusId, quantity);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countByC_P_L_S_D(java.lang.String categoryId, long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByC_P_L_S_DMethodKey53,
				ClpSerializer.translateInput(categoryId), groupId,
				ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser));

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

		return ((Integer)returnObj).intValue();
	}

	public int countByP_L_S_D(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByP_L_S_DMethodKey54,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser));

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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> listReportByDate(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, long typeId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_listReportByDateMethodKey55,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser), typeId, begin, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> listReportByDateNotType(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_listReportByDateNotTypeMethodKey56,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser), begin, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countByDate(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByDateMethodKey57,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser), typeId);

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

		return ((Integer)returnObj).intValue();
	}

	public int countByDateNotType(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByDateNotTypeMethodKey58,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser));

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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> listArticleByDateTypes(
		long groupId, java.lang.String language, long statusId,
		java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, java.lang.String[] strType, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_listArticleByDateTypesMethodKey59,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser),
				ClpSerializer.translateInput(strType), begin, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countArticleByDateTypes(long groupId, java.lang.String language,
		long statusId, java.util.Date fromDate, java.util.Date toDate,
		java.lang.String byUser, java.lang.String[] strType)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticleByDateTypesMethodKey60,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser),
				ClpSerializer.translateInput(strType));

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

		return ((Integer)returnObj).intValue();
	}

	public int countByType(long groupId, java.lang.String language,
		long statusId, long typeId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByTypeMethodKey61,
				groupId, ClpSerializer.translateInput(language), statusId,
				typeId, ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
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

	public int countByUser(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, long typeId,
		java.util.Date fromDate, java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByUserMethodKey62,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(categoryId), statusId, typeId,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser));

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

	public int countArticleNotInType(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticleNotInTypeMethodKey63,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(categoryId), statusId,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser));

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

	public int countArticleAllCatNotInType(long groupId,
		java.lang.String language, long statusId, java.util.Date fromDate,
		java.util.Date toDate, java.lang.String byUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticleAllCatNotInTypeMethodKey64,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate),
				ClpSerializer.translateInput(byUser));

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesBySearchContainer(
		java.lang.String keyword, long groupId, java.lang.String language,
		java.lang.String portionId, java.lang.String parentId, boolean isTitle,
		boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesBySearchContainerMethodKey65,
				ClpSerializer.translateInput(keyword), groupId,
				ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(parentId), isTitle, isLead,
				isContent, isDate, ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate), statusId,
				ClpSerializer.translateInput(select));

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesBySearchContainerMethodKey66,
				ClpSerializer.translateInput(keyword), groupId,
				ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(parentId), typeId, isTitle,
				isLead, isContent, isDate,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate), statusId,
				ClpSerializer.translateInput(select), start, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticlesBySearchContainerMethodKey67,
				ClpSerializer.translateInput(keyword), groupId,
				ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(parentId), typeId, isTitle,
				isLead, isContent, isDate,
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate), statusId,
				ClpSerializer.translateInput(select));

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticlesBySearchContainer_T(
		java.lang.String categoryId, long typeId, java.lang.String keyword,
		long groupId, java.lang.String language, java.lang.String threadId,
		boolean isTitle, boolean isLead, boolean isContent, boolean isDate,
		java.util.Date fromDate, java.util.Date toDate, long statusId,
		java.lang.String select, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticlesBySearchContainer_TMethodKey68,
				ClpSerializer.translateInput(categoryId), typeId,
				ClpSerializer.translateInput(keyword), groupId,
				ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(threadId), isTitle, isLead,
				isContent, isDate, ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate), statusId,
				ClpSerializer.translateInput(select), start, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticlesBySearchContainer_TMethodKey69,
				ClpSerializer.translateInput(categoryId), typeId,
				ClpSerializer.translateInput(keyword), groupId,
				ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(threadId), isTitle, isLead,
				isContent, isDate, ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate), statusId,
				ClpSerializer.translateInput(select));

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByG_L_C_S_T(
		long groupId, java.lang.String language, java.lang.String categoryId,
		long statusId, long typeId, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByG_L_C_S_TMethodKey70,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(categoryId), statusId, typeId,
				begin, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countArticleByG_L_C_S_T(long groupId, java.lang.String language,
		java.lang.String categoryId, long statusId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticleByG_L_C_S_TMethodKey71,
				groupId, ClpSerializer.translateInput(language),
				ClpSerializer.translateInput(categoryId), statusId, typeId);

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByG_L_S_T(
		long groupId, java.lang.String language, long statusId, long typeId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByG_L_S_TMethodKey72,
				groupId, ClpSerializer.translateInput(language), statusId,
				typeId, begin, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countArticleByG_L_S_T(long groupId, java.lang.String language,
		long statusId, long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticleByG_L_S_TMethodKey73,
				groupId, ClpSerializer.translateInput(language), statusId,
				typeId);

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

	public int countArticleByG_L_S_C_D(long groupId, java.lang.String language,
		long statusId, java.lang.String categoryId, java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countArticleByG_L_S_C_DMethodKey74,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(categoryId),
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate));

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getArticleByG_L_S_C_D(
		long groupId, java.lang.String language, long statusId,
		java.lang.String categoryId, java.util.Date fromDate,
		java.util.Date toDate, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getArticleByG_L_S_C_DMethodKey75,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(categoryId),
				ClpSerializer.translateInput(fromDate),
				ClpSerializer.translateInput(toDate), begin, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public int countOtherArticle(long groupId, java.lang.String language,
		long statusId, java.lang.String categoryId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countOtherArticleMethodKey76,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(categoryId),
				ClpSerializer.translateInput(articleId));

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

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getOtherArticle(
		long groupId, java.lang.String language, long statusId,
		java.lang.String categoryId, java.lang.String articleId, int begin,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getOtherArticleMethodKey77,
				groupId, ClpSerializer.translateInput(language), statusId,
				ClpSerializer.translateInput(categoryId),
				ClpSerializer.translateInput(articleId), begin, end);

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

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsArticle>)ClpSerializer.translateOutput(returnObj);
	}

	public void removeExpiredStickyArticles(
		com.liferay.portal.kernel.upload.UploadPortletRequest upRequest)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_removeExpiredStickyArticlesMethodKey78,
				ClpSerializer.translateInput(upRequest));

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

	public void reIndex(java.lang.String[] ids)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_reIndexMethodKey79,
				ClpSerializer.translateInput(ids));

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

	public com.liferay.portal.kernel.search.Hits search(
		javax.servlet.http.HttpServletRequest request, long companyId,
		long groupId, long userId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchMethodKey80,
				ClpSerializer.translateInput(request), companyId, groupId,
				userId, ClpSerializer.translateInput(keywords), start, end);

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

		return (com.liferay.portal.kernel.search.Hits)ClpSerializer.translateOutput(returnObj);
	}

	public void restoreArticleVersion(long articleVersionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_restoreArticleVersionMethodKey81,
				articleVersionId);

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

	public long getStatusIdOfPublishedArticles(long companyId, long groupId,
		boolean active) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getStatusIdOfPublishedArticlesMethodKey82,
				companyId, groupId, active);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public long getStatusIdOfPublishedArticles(boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getStatusIdOfPublishedArticlesMethodKey83,
				active);

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

		return ((Long)returnObj).longValue();
	}

	public void saveImage(javax.portlet.ActionRequest req,
		com.liferay.portal.kernel.upload.UploadPortletRequest uploadReq,
		com.vportal.portlet.vcms.model.VcmsArticle article,
		java.lang.String image, java.lang.String imageTitle, long companyId)
		throws java.lang.Exception {
		MethodHandler methodHandler = new MethodHandler(_saveImageMethodKey84,
				ClpSerializer.translateInput(req),
				ClpSerializer.translateInput(uploadReq),
				ClpSerializer.translateInput(article),
				ClpSerializer.translateInput(image),
				ClpSerializer.translateInput(imageTitle), companyId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
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

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _getArticleByCompanyIdMethodKey0;
	private MethodKey _getArticleByCompanyIdMethodKey1;
	private MethodKey _countArticleByCompanyIdMethodKey2;
	private MethodKey _addArticleMethodKey3;
	private MethodKey _addArticleMethodKey4;
	private MethodKey _addArticleResourcesMethodKey5;
	private MethodKey _addArticleResourcesMethodKey6;
	private MethodKey _addArticleResourcesMethodKey7;
	private MethodKey _addArticleResourcesMethodKey8;
	private MethodKey _updateArticleMethodKey9;
	private MethodKey _updateArticleMethodKey10;
	private MethodKey _updateArticleMethodKey11;
	private MethodKey _deleteArticleMethodKey12;
	private MethodKey _deleteArticlesMethodKey13;
	private MethodKey _getArticleMethodKey14;
	private MethodKey _getArticlesMethodKey15;
	private MethodKey _getArticlesByU_L_SMethodKey16;
	private MethodKey _getArticlesByU_L_SMethodKey17;
	private MethodKey _getArticlesByL_SMethodKey18;
	private MethodKey _getArticlesByL_SMethodKey19;
	private MethodKey _countArticlesByL_SMethodKey20;
	private MethodKey _getArticlesByG_L_S_UMethodKey21;
	private MethodKey _countArticlesByG_L_S_UMethodKey22;
	private MethodKey _getArticlesByL_SMethodKey23;
	private MethodKey _getArticlesByL_S_SMethodKey24;
	private MethodKey _getArticlesNewByL_S_SMethodKey25;
	private MethodKey _countArticlesByL_S_SMethodKey26;
	private MethodKey _getArticlesByL_S_SMethodKey27;
	private MethodKey _getArticleByP_L_S_DMethodKey28;
	private MethodKey _getArticleByC_P_L_SMethodKey29;
	private MethodKey _getArticleByC_P_L_SMethodKey30;
	private MethodKey _countArticleByC_P_L_SMethodKey31;
	private MethodKey _getArticleByP_P_L_SMethodKey32;
	private MethodKey _countArticleByP_P_L_SMethodKey33;
	private MethodKey _getArticleByP_P_L_SMethodKey34;
	private MethodKey _getArticleByT_P_L_SMethodKey35;
	private MethodKey _getArticleByT_P_L_SMethodKey36;
	private MethodKey _countArticleByT_P_L_SMethodKey37;
	private MethodKey _countByStatusMethodKey38;
	private MethodKey _countByStatusMethodKey39;
	private MethodKey _getTopNewArticlesMethodKey40;
	private MethodKey _getHotNewArticlesMethodKey41;
	private MethodKey _getTopNewArticlesMethodKey42;
	private MethodKey _getTopNewArticlesMethodKey43;
	private MethodKey _getTopNewArticlesMethodKey44;
	private MethodKey _getTopNewArticlesMethodKey45;
	private MethodKey _getAllCategoryArticlesMethodKey46;
	private MethodKey _countAllCategoryArticlesMethodKey47;
	private MethodKey _getArticlesInThreadMethodKey48;
	private MethodKey _getArticlesInThreadMethodKey49;
	private MethodKey _getArticlesInThreadMethodKey50;
	private MethodKey _getOlderArticlesMethodKey51;
	private MethodKey _getNewArticlesMethodKey52;
	private MethodKey _countByC_P_L_S_DMethodKey53;
	private MethodKey _countByP_L_S_DMethodKey54;
	private MethodKey _listReportByDateMethodKey55;
	private MethodKey _listReportByDateNotTypeMethodKey56;
	private MethodKey _countByDateMethodKey57;
	private MethodKey _countByDateNotTypeMethodKey58;
	private MethodKey _listArticleByDateTypesMethodKey59;
	private MethodKey _countArticleByDateTypesMethodKey60;
	private MethodKey _countByTypeMethodKey61;
	private MethodKey _countByUserMethodKey62;
	private MethodKey _countArticleNotInTypeMethodKey63;
	private MethodKey _countArticleAllCatNotInTypeMethodKey64;
	private MethodKey _getArticlesBySearchContainerMethodKey65;
	private MethodKey _getArticlesBySearchContainerMethodKey66;
	private MethodKey _countArticlesBySearchContainerMethodKey67;
	private MethodKey _getArticlesBySearchContainer_TMethodKey68;
	private MethodKey _countArticlesBySearchContainer_TMethodKey69;
	private MethodKey _getArticleByG_L_C_S_TMethodKey70;
	private MethodKey _countArticleByG_L_C_S_TMethodKey71;
	private MethodKey _getArticleByG_L_S_TMethodKey72;
	private MethodKey _countArticleByG_L_S_TMethodKey73;
	private MethodKey _countArticleByG_L_S_C_DMethodKey74;
	private MethodKey _getArticleByG_L_S_C_DMethodKey75;
	private MethodKey _countOtherArticleMethodKey76;
	private MethodKey _getOtherArticleMethodKey77;
	private MethodKey _removeExpiredStickyArticlesMethodKey78;
	private MethodKey _reIndexMethodKey79;
	private MethodKey _searchMethodKey80;
	private MethodKey _restoreArticleVersionMethodKey81;
	private MethodKey _getStatusIdOfPublishedArticlesMethodKey82;
	private MethodKey _getStatusIdOfPublishedArticlesMethodKey83;
	private MethodKey _saveImageMethodKey84;
}