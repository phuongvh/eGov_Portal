
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

/*
 * @(#)ActionUtil.java
 *
 * Copyright (c) 2007 VietSoftware, Inc.
 * 51 Le Dai Hanh street, Hai Ba Trung district, Hanoi, Vietnam.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * VietSoftware, Inc. ("Confidential Information").  You shall not 
 * disclose such Confidential Information and shall use it only in 
 * accordance with the terms of the license agreement you entered 
 * into with VietSoftware, Inc.
 *
 */
package com.vportal.portlet.vcms.action;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portal.kernel.security.permission.ActionKeysExt;
import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portlet.vcms.model.VcmsArticle;
import com.vportal.portlet.vcms.model.VcmsCategory;
import com.vportal.portlet.vcms.model.VcmsDiscussion;
import com.vportal.portlet.vcms.model.VcmsPortion;
import com.vportal.portlet.vcms.model.VcmsThread;
import com.vportal.portlet.vcms.model.VcmsType;
import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil;
import com.vportal.portlet.vcms.service.VcmsDiscussionServiceUtil;
import com.vportal.portlet.vcms.service.VcmsPortionServiceUtil;
import com.vportal.portlet.vcms.service.VcmsThreadServiceUtil;
import com.vportal.portlet.vcms.service.VcmsTypeServiceUtil;
import com.vportal.portlet.vcms.service.permission.VcmsCategoryPermission;
import com.vportal.portlet.vcms.service.permission.VcmsPortionPermission;
import com.vportal.portlet.vcms.service.permission.VcmsThreadPermission;
import com.vportal.portlet.vcms.service.permission.VcmsTypePermission;
import com.vportal.portlet.vcms.util.WebKeysExt;

/**
 * @author anhnts
 * @version 1.0.00, Dec 19, 2007
 */

public class ActionUtil {

	public static final String DEFAULT_CATEGORY_ID = "0";

	public static final String AUTO_USER = "system";

	/**
	 * Ham phan tich ngay thang<br /> Copied from
	 * com.vportal.portlet.edirectory.util.EDirectoryUtil
	 * 
	 * @param date
	 *            Ngay thang can phan tich
	 * @return Dang dd/MM/yyyy cua ngay thang nhap vao
	 */
	public static String dateParser(Date date) {
		if (date == null) {
			return "";
		}
		Calendar cal = Calendar.getInstance();
		String dateStr = "";
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		if (month < 10) {
			dateStr = day + "/" + "0" + month + "/" + year;
		} else {
			dateStr = day + "/" + month + "/" + year;
		}

		return dateStr;
	}

	/**
	 * Ham chuyen 1 xau sang ngay thang<br /> Copied from
	 * com.vportal.portlet.edirectory.util.EDirectoryUtil
	 * 
	 * @param date
	 *            Xau chua ngay thang, co dang: dd/MM/yyyy
	 * @return Doi tuong ngay thang
	 */
	public static Date dateParser(String date) {
		try {
			SimpleDateFormat result = new SimpleDateFormat("dd/MM/yyyy");
			Date newDate = result.parse(date);
			return newDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void getPortion(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getPortion(httpReq);
	}

	public static void getPortion(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getPortion(httpReq);
	}

	public static void getPortion(HttpServletRequest req) throws Exception {
		String portionId = ParamUtil.getString(req, "portionId");

		VcmsPortion portion = null;

		if (Validator.isNotNull(portionId)) {
			portion = VcmsPortionServiceUtil.getPortion(portionId);
		}

		req.setAttribute(WebKeysExt.VCMS_PORTION, portion);
	}

	public static void getType(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getType(httpReq);
	}

	public static void getType(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getType(httpReq);
	}

	public static void getType(HttpServletRequest req) throws Exception {
		String typeId = ParamUtil.getString(req, "typeId");

		VcmsType type = null;

		if (Validator.isNotNull(typeId)) {
			type = VcmsTypeServiceUtil.getType(typeId);
		}

		req.setAttribute(WebKeysExt.VCMS_TYPE, type);
	}

	public static void getCategory(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getCategory(httpReq);
	}

	public static void getCategory(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getCategory(httpReq);
	}

	public static String getListCategory(long groupId, String language,
			String categoryId) throws PortalException, SystemException,
			RemoteException {
		StringBuffer sb = new StringBuffer();
		sb.append("'" + categoryId + "'");
		getListCategory(groupId, language, sb, categoryId);
		return sb.toString();
	}
	
	public static void getListCategory(long groupId, String language,
			StringBuffer sb, String parentId) throws PortalException,
			SystemException, RemoteException {
		List list = VcmsCategoryServiceUtil.getCategoriesByParent(groupId,
				parentId, language);
		for (int i = 0; i < list.size(); i++) {
			VcmsCategory cat = (VcmsCategory) list.get(i);
			sb.append(",");
			sb.append("'" + cat.getCategoryId() + "'");
			getListCategory(groupId, language, sb, cat.getCategoryId());
		}
	}
	

	public static void getCategory(HttpServletRequest req) throws Exception {
		String categoryId = ParamUtil.getString(req, "categoryId");

		VcmsCategory category = null;

		if (Validator.isNotNull(categoryId)) {
			category = VcmsCategoryServiceUtil.getCategory(categoryId);
		}

		req.setAttribute(WebKeysExt.VCMS_CATEGORY, category);
	}

	public static void getArticle(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getArticle(httpReq);
	}

	public static void getArticle(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getArticle(httpReq);
	}

	public static void getArticle(HttpServletRequest req) throws Exception {
		String articleId = ParamUtil.getString(req, "articleId");

		VcmsArticle article = null;

		if (Validator.isNotNull(articleId)) {
			article = VcmsArticleServiceUtil.getArticle(articleId);
		}

		req.setAttribute(WebKeysExt.VCMS_ARTICLE, article);
	}

	public static void getThread(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getThread(httpReq);
	}

	public static void getThread(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getThread(httpReq);
	}

	public static void getThread(HttpServletRequest req) throws Exception {
		String threadId = ParamUtil.getString(req, "threadId");

		VcmsThread thread = null;

		if (Validator.isNotNull(threadId)) {
			thread = VcmsThreadServiceUtil.getThread(threadId);
		}

		req.setAttribute(WebKeysExt.VCMS_THREAD, thread);
	}

	public static void getDiscussion(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getDiscussion(httpReq);
	}

	public static void getDiscussion(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getDiscussion(httpReq);
	}

	public static void getDiscussion(HttpServletRequest req) throws Exception {
		String discussionId = ParamUtil.getString(req, "discussionId");

		VcmsDiscussion discussion = null;

		if (Validator.isNotNull(discussionId)) {
			discussion = VcmsDiscussionServiceUtil.getDiscussion(discussionId);
		}

		req.setAttribute(WebKeysExt.VCMS_DISCUSSION, discussion);
	}

	public static String getThreads(long groupId, String language,
			String portletNamespace, PermissionChecker permissionChecker,
			String threadId) throws SystemException, PortalException {

		StringBuffer sb = new StringBuffer();

		List threads = null;

		try {
			threads = VcmsThreadServiceUtil.getThreadsByP_L(groupId, language);
		} catch (Exception ex) {
			// Ignore...
		}

		if ((threads == null) || (threads.size() <= 0)) {
			return null;
		}

		for (int j = 0; j < threads.size(); j++) {

			VcmsThread thread = (VcmsThread) threads.get(j);

			if (VcmsThreadPermission.contains(permissionChecker, thread,
					ActionKeysExt.ADD_ARTICLES_THREAD)) {

				sb.append("<tr>");
				sb.append("<td width=\"1%\" valign=\"middle\" >");
				sb.append("<input type=\"radio\" name=\"");
				sb.append(portletNamespace + "thread\" id=\"");
				sb.append(portletNamespace + "thread_" + thread.getThreadId()
						+ "\" value=\"" + thread.getThreadId() + "\" ");

				sb.append(thread.getThreadId().equals(threadId) ? "checked />"
						: " />");

				sb.append("</td>");
				sb.append("<td width=\"99%\" valign=\"middle\" >");
				sb.append("<label for=\"");
				sb.append(portletNamespace + "thread_" + thread.getThreadId()
						+ "\" >");
				sb.append(thread.getTitle());
				sb.append("</label>");
				sb.append("</td>");
				sb.append("</tr>");
			}
			// }
		}
		return sb.toString();
	}

	public static String getPortions(long groupId, String language,
			String portletNamespace) {
		StringBuffer sb = new StringBuffer();
		/*
		 * if ((portalSites == null) || (portalSites.size() <= 0)) { return
		 * sb.toString(); }
		 * 
		 * for (int i = 0; i < portalSites.size(); i++) { PortalSite portalSite
		 * = (PortalSite) portalSites.get(i);
		 * 
		 * if (!portalSite.getLanguage().equals(language)) { continue; }
		 * 
		 * sb.append("<tr>");
		 * sb.append("<td width=\"100%\" colspan=\"2\" valign=\"middle\">");
		 * sb.append("<b>").append(portalSite.getName()).append("</b>");
		 * sb.append("</td>"); sb.append("</tr>");
		 */
		try {
			List portions = VcmsPortionServiceUtil.getPortionsByS_L(groupId,
					language);

			if ((portions == null) || (portions.size() <= 0)) {
				return null;
			}

			for (int j = 0; j < portions.size(); j++) {
				VcmsPortion portion = (VcmsPortion) portions.get(j);

				sb.append("<tr>");
				sb
						.append("<td width=\"3%\" align=\"right\" valign=\"middle\">");
				sb.append("<input type=\"checkbox\" name=\"");
				sb.append(portletNamespace + "portion\" id=\"");
				sb.append(portletNamespace + "portion_"
						+ portion.getPortionId() + "\" ");
				sb.append("value =\"" + portion.getPortionId() + "\" ");
				sb.append(portion.getCategorizable() ? "disabled />" : " />");
				sb.append("</td>");
				sb
						.append("<td width=\"97%\" align=\"left\" valign=\"middle\">");
				sb.append("<label for=\"");
				sb.append(portletNamespace + "portion_"
						+ portion.getPortionId() + "\" ");
				sb
						.append(portion.getCategorizable() ? "style=\"font-color: #F1F1f1\" >"
								: ">");
				sb.append(portion.getName());
				sb.append("</label>");
				sb.append("</td>");
				sb.append("</tr>");
			}

		} catch (Exception ex) {
			// Ignore ...
		}
		// }

		return sb.toString();
	}

	public static String getCategoryTree(long groupId, String language,
			String parentId, String categoryId,
			PermissionChecker permissionChecker) throws SystemException,
			PortalException {

		StringBuffer sb = new StringBuffer();
		List portions = null;

		try {
			portions = VcmsPortionServiceUtil.getPortionsByS_L(groupId,
					language);
		} catch (Exception ex) {
			return StringPool.BLANK;
		}

		for (int i = 0; i < portions.size(); i++) {
			VcmsPortion portion = (VcmsPortion) portions.get(i);

			if (VcmsPortionPermission.contains(permissionChecker, portion,
					ActionKeysExt.ADD_CATEGORIES_PORTION)) {
				// Only list categorizable portions

				if (!portion.getCategorizable()) {
					continue;
				}
				sb.append("<option value=\"" + portion.getPortionId() + "|"
						+ DEFAULT_CATEGORY_ID + "\" ");
				sb.append(((portion.getPortionId() + "|" + DEFAULT_CATEGORY_ID)
						.equals(parentId) ? "selected=\"selected\"" : ""));
				sb.append(">");
				sb.append(portion.getName());
				sb.append("</option>");

				List categories = new ArrayList();

				try {
					categories = VcmsCategoryServiceUtil.getCategoriesByP_P(
							portion.getGroupId(), portion.getPortionId(),
							DEFAULT_CATEGORY_ID, portion.getLanguage());
				} catch (Exception ex) {
					continue;
				}

				int indent = 2;
				traverseCategoryTree(sb, categories, indent, parentId,
						categoryId);
			}
		}

		return sb.toString();
	}

	public static String getCategoryTree(String portionId, String parentId) {

		StringBuffer sb = new StringBuffer();

		if (Validator.isNull(portionId)) {
			return sb.toString();
		}

		List categories = new ArrayList();

		try {

			VcmsPortion portion = VcmsPortionServiceUtil.getPortion(portionId);
			categories = VcmsCategoryServiceUtil.getCategoriesByP_P(portion
					.getGroupId(), portionId, DEFAULT_CATEGORY_ID, portion
					.getLanguage());

		} catch (Exception ex) {
			// Ignore..
		}

		int indent = 0;
		traverseCategoryTree(sb, categories, indent, parentId);

		return sb.toString();
	}

	public static String getCategoryTree(long groupId, String language,
			String portletNamespace, PermissionChecker permissionChecker,
			String[] strPortion, String[] strCategory) {

		StringBuffer sb = new StringBuffer();

		try {
			List portions = VcmsPortionServiceUtil.getPortionsByS_L(groupId,
					language);

			if ((portions == null) || (portions.size() <= 0)) {
				return null;
			}

			for (int j = 0; j < portions.size(); j++) {
				VcmsPortion portion = (VcmsPortion) portions.get(j);

				if (VcmsPortionPermission.contains(permissionChecker, portion,
						ActionKeysExt.MANAGE_CATEGORIES_PORTION)) {

					sb.append("<tr>");
					sb.append("<td width=\"100%\" valign=\"middle\" ");
					sb
							.append(portion.getCategorizable() ? "style=\"font-color: #F1F1f1\">"
									: ">");
					sb.append(StringPool.NBSP);
					sb.append(StringPool.NBSP);
					sb.append("<input type=\"checkbox\" name=\"");
					sb.append(portletNamespace + "portion\" id=\"");
					sb.append(portletNamespace + "portion_"
							+ portion.getPortionId() + "\" ");
					sb.append("value=\"" + portion.getPortionId() + "\" ");

					if (Validator.isNotNull(strPortion)) {
						for (int k = 0; k < strPortion.length; k++) {
							if (portion.getPortionId().equals(strPortion[k])) {
								sb.append("checked=\"true\"");
							}
						}
					}

					sb.append(portion.getCategorizable() ? "disabled />"

					: " />");
					sb.append("<label for=\"");
					sb.append(portletNamespace + "portion_"
							+ portion.getPortionId() + "\" >");
					sb.append("<b>");
					sb.append(StringPool.NBSP);
					sb.append(portion.getName());
					sb.append("</b>");
					sb.append("</label>");
					sb.append("</td>");
					sb.append("</tr>");

					if (!portion.getCategorizable()) {
						continue;
					}

					List categories = VcmsCategoryServiceUtil
							.getCategoriesByP_P(portion.getGroupId(), portion
									.getPortionId(), DEFAULT_CATEGORY_ID,
									language);

					if ((categories == null) || (categories.size() <= 0)) {
						continue;
					}

					int indent = 2;
					traverseCategoryTree2(sb, categories, indent,
							portletNamespace, permissionChecker, strCategory);
				}
			}
		} catch (Exception ex) {
			// Ignore ...
		}
		// }

		return sb.toString();
	}
	
	public static String getPortionTree(long groupId, String language,
			String portletNamespace, PermissionChecker permissionChecker,
			String[] strPortion, String[] strCategory) {

		StringBuffer sb = new StringBuffer();

		try {
			List portions = VcmsPortionServiceUtil.getPortionsByS_L(groupId,
					language);

			if ((portions == null) || (portions.size() <= 0)) {
				return null;
			}

			for (int j = 0; j < portions.size(); j++) {
				VcmsPortion portion = (VcmsPortion) portions.get(j);

				if (VcmsPortionPermission.contains(permissionChecker, portion,
						ActionKeysExt.MANAGE_CATEGORIES_PORTION)) {

					sb.append("<tr>");
					sb.append("<td width=\"100%\" valign=\"middle\" ");
					sb
							.append(portion.getCategorizable() ? "style=\"font-color: #F1F1f1\">"
									: ">");
					sb.append(StringPool.NBSP);
					sb.append(StringPool.NBSP);
					sb.append("<input type=\"checkbox\" name=\"");
					sb.append(portletNamespace + "portion\" id=\"");
					sb.append(portletNamespace + "portion_"
							+ portion.getPortionId() + "\" ");
					sb.append("value=\"" + portion.getPortionId() + "\" ");

					if (Validator.isNotNull(strPortion)) {
						for (int k = 0; k < strPortion.length; k++) {
							if (portion.getPortionId().equals(strPortion[k])) {
								sb.append("checked=\"true\"");
							}
						}
					}

					sb.append(" />");
					sb.append("<label for=\"");
					sb.append(portletNamespace + "portion_"
							+ portion.getPortionId() + "\" >");
					sb.append("<b>");
					sb.append(StringPool.NBSP);
					sb.append(portion.getName());
					sb.append("</b>");
					sb.append("</label>");
					sb.append("</td>");
					sb.append("</tr>");

					if (!portion.getCategorizable()) {
						continue;
					}

					List categories = VcmsCategoryServiceUtil
							.getCategoriesByP_P(portion.getGroupId(), portion
									.getPortionId(), DEFAULT_CATEGORY_ID,
									language);

					if ((categories == null) || (categories.size() <= 0)) {
						continue;
					}

					int indent = 2;
					traverseCategoryTree2(sb, categories, indent,
							portletNamespace, permissionChecker, strCategory);
				}
			}
		} catch (Exception ex) {
			// Ignore ...
		}
		// }

		return sb.toString();
	}

	public static String getCategoryTreeRadio(long groupId, String language,
			String portletNamespace, PermissionChecker permissionChecker,
			String categoryId) {

		StringBuffer sb = new StringBuffer();

		try {
			List portions = VcmsPortionServiceUtil.getPortionsByS_L(groupId,
					language);

			if ((portions == null) || (portions.size() <= 0)) {
				return null;
			}

			for (int j = 0; j < portions.size(); j++) {
				VcmsPortion portion = (VcmsPortion) portions.get(j);

				if (VcmsPortionPermission.contains(permissionChecker, portion,
						ActionKeysExt.MANAGE_CATEGORIES_PORTION)) {

					sb.append("<tr>");
					sb.append("<td width=\"100%\" valign=\"middle\" ");
					sb
							.append(portion.getCategorizable() ? "style=\"font-color: #F1F1f1\">"
									: ">");
					sb.append(StringPool.NBSP);
					sb.append(StringPool.NBSP);
					sb.append("<b>").append(portion.getName()).append("</b>");
					sb.append("</td>");
					sb.append("</tr>");

					if (!portion.getCategorizable()) {
						continue;
					}

					List categories = VcmsCategoryServiceUtil
							.getCategoriesByP_P(portion.getGroupId(), portion
									.getPortionId(), DEFAULT_CATEGORY_ID,
									language);

					if ((categories == null) || (categories.size() <= 0)) {
						continue;
					}

					int indent = 3;
					traverseCategoryTree3(sb, categories, indent,
							portletNamespace, permissionChecker, categoryId);
				}
			}
		} catch (Exception ex) {
			// Ignore ...
		}
		// }

		return sb.toString();
	}
	
	public static String getCategoryTreeRadio(List categories,
			String portletNamespace, PermissionChecker permissionChecker,
			String categoryId) throws SystemException, PortalException {
		StringBuffer sb = new StringBuffer();
		int indent = 3;
		traverseCategoryTree3(sb, categories, indent, portletNamespace,
				permissionChecker, categoryId);
		return sb.toString();
	}

	private static void traverseCategoryTree2(StringBuffer sb, List categories,
			int indent, String portletNamespace,
			PermissionChecker permissionChecker, String[] strCategory)
			throws SystemException, PortalException {

		if ((categories == null) || (categories.size() <= 0)) {
			return;
		}

		for (int i = 0; i < categories.size(); i++) {
			VcmsCategory category = (VcmsCategory) categories.get(i);

			// if (VcmsCategoryPermission.contains(permissionChecker, category,
			// ActionKeysExt.ADD_ARTICLES_CATEGORY)) {

			sb.append("<tr>");
			sb.append("<td width=\"100%\" valign=\"middle\" ");
			sb
					.append(category.getAnchored() ? "style=\"font-color: #F1F1f1\" >"
							: ">");
			for (int j = 0; j < indent; j++) {
				sb.append(StringPool.NBSP);
			}
			sb.append(StringPool.NBSP);
			sb.append(StringPool.NBSP);
			sb.append("<input type=\"checkbox\" name=\"");
			sb.append(portletNamespace + "category\" id=\"");
			sb.append(portletNamespace + "category_" + category.getCategoryId()
					+ "\" ");
			sb.append("value=\"" + category.getCategoryId() + "\" ");

			if (Validator.isNotNull(strCategory)) {
				for (int k = 0; k < strCategory.length; k++) {
					if (category.getCategoryId().equals(strCategory[k])) {
						sb.append("checked=\"true\"");
					}
				}
			}

			if (!VcmsCategoryPermission.contains(permissionChecker, category,
					ActionKeysExt.ADD_ARTICLES_CATEGORY)) {
				sb.append("disabled=\"true\"");
			}
			
			

			sb.append(" />");
			sb.append("<label for=\"");
			sb.append(portletNamespace + "category_" + category.getCategoryId()
					+ "\" >");
			sb.append(StringPool.NBSP);
			sb.append(category.getName());
			sb.append("</label>");
			sb.append("</td>");
			sb.append("</tr>");

			if (category.getAnchored()) {
				// continue;
			}

			try {
				traverseCategoryTree2(sb, VcmsCategoryServiceUtil
						.getCategoriesByParent(category.getGroupId(), category
								.getCategoryId(), category.getLanguage()),
						(indent + 5), portletNamespace, permissionChecker,
						strCategory);
			} catch (Exception ex) {
				// Ignore ...
			}
			// }
		}
	}

	private static void traverseCategoryTree3(StringBuffer sb, List categories,
			int indent, String portletNamespace,
			PermissionChecker permissionChecker, String categoryId)
			throws SystemException, PortalException {

		if ((categories == null) || (categories.size() <= 0)) {
			return;
		}

		for (int i = 0; i < categories.size(); i++) {
			VcmsCategory category = (VcmsCategory) categories.get(i);

			if (VcmsCategoryPermission.contains(permissionChecker, category,
					ActionKeysExt.ADD_ARTICLES_CATEGORY)) {

				sb.append("<tr>");
				sb.append("<td width=\"100%\" valign=\"middle\" ");
				sb
						.append(category.getAnchored() ? "style=\"font-color: #F1F1f1\" >"
								: ">");
				for (int j = 0; j < indent; j++) {
					sb.append(StringPool.NBSP);
				}
				sb.append(StringPool.NBSP);
				sb.append(StringPool.NBSP);
				sb.append("<input type=\"radio\" name=\"");
				sb.append(portletNamespace + "categoryId\" id=\"");
				sb.append(portletNamespace + "categoryId_"
						+ category.getCategoryId() + "\" ");

				if (Validator.isNotNull(categoryId)
						&& category.getCategoryId().equals(categoryId)) {
					sb.append("checked=\"true\"");
				}

				sb.append("value=\"" + category.getCategoryId() + "\" ");
				sb.append(category.getAnchored() ? " />" : " />");
				sb.append("<label for=\"");
				sb.append(portletNamespace + "categoryId_"
						+ category.getCategoryId() + "\" >");
				sb.append(category.getName());
				sb.append("</label>");
				sb.append("</td>");
				sb.append("</tr>");

				/*
				if (category.getAnchored()) {
					continue;
				}
				*/

				try {
					traverseCategoryTree3(sb, VcmsCategoryServiceUtil
							.getCategoriesByParent(category.getGroupId(),
									category.getCategoryId(), category
											.getLanguage()), (indent + 2),
							portletNamespace, permissionChecker, categoryId);
				} catch (Exception ex) {
					// Ignore ...
				}
			}
		}
	}

	private static void traverseCategoryTree(StringBuffer sb, List categories,
			int indent, String parentId, String categoryId) {

		if ((categories == null) || (categories.size() <= 0)) {
			return;
		}

		for (int i = 0; i < categories.size(); i++) {
			VcmsCategory category = (VcmsCategory) categories.get(i);

			/* CuongNV
			 * if (category.getCategoryId().equals(categoryId)
					|| category.isAnchored()) {
				continue;
			}
			*/
			if (category.getCategoryId().equals(categoryId)) {
				continue;
			}
			sb.append("<option value=\"" + category.getPortionId() + "|"
					+ category.getCategoryId() + "\" ");
			sb.append(((category.getPortionId() + "|" + category
					.getCategoryId()).equals(parentId) ? "selected" : ""));
			sb.append(">");

			// Indent

			for (int j = 0; j < indent; j++) {
				sb.append(StringPool.NBSP);
			}

			sb.append(category.getName());
			sb.append("</option>");

			try {
				traverseCategoryTree(sb, VcmsCategoryServiceUtil
						.getCategoriesByParent(category.getGroupId(), category
								.getCategoryId(), category.getLanguage()),
						indent + 2, parentId, categoryId);
			} catch (Exception ex) {
				// Ignore..
			}
		}

	}

	private static void traverseCategoryTree(StringBuffer sb, List categories,
			int indent, String parentId) {

		if ((categories == null) || (categories.size() <= 0)) {
			return;
		}

		for (int i = 0; i < categories.size(); i++) {
			VcmsCategory category = (VcmsCategory) categories.get(i);
			
			/* 
			if (category.isAnchored()) {
				continue;
			}
			*/

			sb.append("<option value=\"" + category.getCategoryId() + "\" ");
			sb
					.append(category.getCategoryId().equals(parentId) ? "\"selected\""
							: "");
			sb.append(">");

			// Indent

			for (int j = 0; j < indent; j++) {
				sb.append(StringPool.NBSP);
			}

			sb.append(category.getName());
			sb.append("</option>");

			try {
				traverseCategoryTree(sb, VcmsCategoryServiceUtil
						.getCategoriesByParent(category.getGroupId(), category
								.getCategoryId(), category.getLanguage()),
						indent + 2, parentId);
			} catch (Exception ex) {
				// Ignore..
			}

		}

	}

	public static void getAttachmentList(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAttachmentList(httpReq);
	}

	public static void getAttachmentList(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAttachmentList(httpReq);
	}

	public static void getAttachmentList(HttpServletRequest req)
			throws Exception {

		String articleId = ParamUtil.getString(req, "articleId");

		if (Validator.isNull(articleId)) {
			return;
		}
		// get attachment
		List listAttachment = AttachmentLocalServiceUtil.getAttachments(Long
				.parseLong(articleId), VcmsArticle.class);

		if (listAttachment == null) {
			listAttachment = new ArrayList();
		}

		req.setAttribute(WebKeysExt.VCMS_LIST_ATTACHMENT, listAttachment);
	}

	public static void getAttachmentListDiscussion(ActionRequest req)
			throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAttachmentListDiscussion(httpReq);
	}

	public static void getAttachmentListDiscussion(RenderRequest req)
			throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAttachmentListDiscussion(httpReq);
	}

	public static void getAttachmentListDiscussion(HttpServletRequest req)
			throws Exception {

		String discussionId = ParamUtil.getString(req, "discussionId");

		if (Validator.isNull(discussionId)) {
			return;
		}
		// get attachment
		List listAttachment = AttachmentLocalServiceUtil.getAttachments(Long
				.parseLong(discussionId), VcmsDiscussion.class);

		if (listAttachment == null) {
			listAttachment = new ArrayList();
		}

		req.setAttribute(WebKeysExt.VCMS_LIST_ATTACHMENT_DISCUSSION,
				listAttachment);
	}

	public static List getListCategoryReport(long groupId, String portionId,
			String parentId, String language) throws PortalException,
			SystemException, RemoteException {
		List categoryList = new ArrayList();
		List categories = VcmsCategoryServiceUtil.getCategoriesByP_P(groupId,
				portionId, parentId, language);
		getListCategoryReportSub(groupId, portionId, parentId, language,
				categoryList, categories);
		return categoryList;
	}

	public static void getListCategoryReportSub(long groupId, String portionId,
			String parentId, String language, List categoryList, List categories)
			throws PortalException, SystemException, RemoteException {

		for (int i = 0; i < categories.size(); i++) {

			VcmsCategory vcmsCategory = (VcmsCategory) categories.get(i);
			categoryList.add(vcmsCategory);

			getListCategoryReportSub(groupId, portionId, vcmsCategory
					.getCategoryId(), language, categoryList,
					VcmsCategoryServiceUtil.getCategoriesByParent(groupId,
							vcmsCategory.getCategoryId(), language));

		}

	}

	public static int countCategoryIndex(String categoryId)
			throws PortalException, RemoteException, SystemException {
		int count = 0;
		count = countCategoryIndexSub(categoryId, count);
		return count;
	}

	public static int countCategoryIndexSub(String categoryId, int count)
			throws PortalException, RemoteException, SystemException {
		VcmsCategory vcmsCategory = VcmsCategoryServiceUtil
				.getCategory(categoryId);
		String parentId = vcmsCategory.getParentId();
		if (Validator.isNotNull(parentId) && !parentId.equals("0")) {
			count += 1;
			countCategoryIndexSub(parentId, count);
		}
		return count;
	}
	
	//no check permission
	public static String getCategoryTree(long groupId, String language,
			String portletNamespace, String[] strPortion, String[] strCategory) {

		StringBuffer sb = new StringBuffer();

		try {
			List portions = VcmsPortionServiceUtil.getPortionsByS_L(groupId,
					language);

			if ((portions == null) || (portions.size() <= 0)) {
				return null;
			}

			for (int j = 0; j < portions.size(); j++) {
				VcmsPortion portion = (VcmsPortion) portions.get(j);

				sb.append("<tr>");
				sb.append("<td width=\"100%\" valign=\"middle\" ");
				sb
						.append(portion.getCategorizable() ? "style=\"font-color: #F1F1f1\">"
								: ">");
				sb.append(StringPool.NBSP);
				sb.append(StringPool.NBSP);
				sb.append("<input type=\"checkbox\" name=\"");
				sb.append(portletNamespace + "portion\" id=\"");
				sb.append(portletNamespace + "portion_"
						+ portion.getPortionId() + "\" ");
				sb.append("value=\"" + portion.getPortionId() + "\" ");

				if (Validator.isNotNull(strPortion)) {
					for (int k = 0; k < strPortion.length; k++) {
						if (portion.getPortionId().equals(strPortion[k])) {
							sb.append("checked=\"true\"");
						}
					}
				}

				sb.append(portion.getCategorizable() ? "disabled />"

				: " />");
				sb.append("<label for=\"");
				sb.append(portletNamespace + "portion_"
						+ portion.getPortionId() + "\" >");
				sb.append("<b>");
				sb.append(StringPool.NBSP);
				sb.append(portion.getName());
				sb.append("</b>");
				sb.append("</label>");
				sb.append("</td>");
				sb.append("</tr>");

				if (!portion.getCategorizable()) {
					continue;
				}

				List categories = VcmsCategoryServiceUtil.getCategoriesByP_P(
						portion.getGroupId(), portion.getPortionId(),
						DEFAULT_CATEGORY_ID, language);

				if ((categories == null) || (categories.size() <= 0)) {
					continue;
				}

				int indent = 2;
				traverseCategoryTree2(sb, categories, indent, portletNamespace,
						strCategory);

			}
		} catch (Exception ex) {
			// Ignore ...
		}
		// }

		return sb.toString();
	}

	// no check permission
	private static void traverseCategoryTree2(StringBuffer sb, List categories,
			int indent, String portletNamespace, String[] strCategory)
			throws SystemException, PortalException {

		if ((categories == null) || (categories.size() <= 0)) {
			return;
		}

		for (int i = 0; i < categories.size(); i++) {
			VcmsCategory category = (VcmsCategory) categories.get(i);

			// if (VcmsCategoryPermission.contains(permissionChecker, category,
			// ActionKeysExt.ADD_ARTICLES_CATEGORY)) {

			sb.append("<tr>");
			sb.append("<td width=\"100%\" valign=\"middle\" ");
			sb
					.append(category.getAnchored() ? "style=\"font-color: #F1F1f1\" >"
							: ">");
			for (int j = 0; j < indent; j++) {
				sb.append(StringPool.NBSP);
			}
			sb.append(StringPool.NBSP);
			sb.append(StringPool.NBSP);
			sb.append("<input type=\"checkbox\" name=\"");
			sb.append(portletNamespace + "category\" id=\"");
			sb.append(portletNamespace + "category_" + category.getCategoryId()
					+ "\" ");
			sb.append("value=\"" + category.getCategoryId() + "\" ");

			if (Validator.isNotNull(strCategory)) {
				for (int k = 0; k < strCategory.length; k++) {
					if (category.getCategoryId().equals(strCategory[k])) {
						sb.append("checked=\"true\"");
					}
				}
			}

			sb.append(" />");
			sb.append("<label for=\"");
			sb.append(portletNamespace + "category_" + category.getCategoryId()
					+ "\" >");
			sb.append(StringPool.NBSP);
			sb.append(category.getName());
			sb.append("</label>");
			sb.append("</td>");
			sb.append("</tr>");

			if (category.getAnchored()) {
				// continue;
			}

			try {
				traverseCategoryTree2(sb, VcmsCategoryServiceUtil
						.getCategoriesByParent(category.getGroupId(), category
								.getCategoryId(), category.getLanguage()),
						(indent + 5), portletNamespace, strCategory);
			} catch (Exception ex) {
				// Ignore ...
			}
			// }
		}
	}
	
}