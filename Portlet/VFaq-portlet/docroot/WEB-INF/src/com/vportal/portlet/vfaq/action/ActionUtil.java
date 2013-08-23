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

package com.vportal.portlet.vfaq.action;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portal.util.PortalUtilExt;
import com.vportal.portlet.vfaq.model.FAQAnswer;
import com.vportal.portlet.vfaq.model.FAQCategory;
import com.vportal.portlet.vfaq.model.FAQComment;
import com.vportal.portlet.vfaq.model.FAQQuestion;
import com.vportal.portlet.vfaq.model.impl.FAQAnswerImpl;
import com.vportal.portlet.vfaq.model.impl.FAQCategoryImpl;
import com.vportal.portlet.vfaq.model.impl.FAQCommentImpl;
import com.vportal.portlet.vfaq.model.impl.FAQQuestionImpl;
import com.vportal.portlet.vfaq.service.FAQAnswerLocalServiceUtil;
import com.vportal.portlet.vfaq.service.FAQCategoryLocalServiceUtil;
import com.vportal.portlet.vfaq.service.FAQCategoryQuestionLocalServiceUtil;
import com.vportal.portlet.vfaq.service.FAQCommentLocalServiceUtil;
import com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil;
import com.vportal.portlet.vfaq.util.FAQUtil;
import com.vportal.portlet.vfaq.util.WebKeysExt;

/**
 * @author Nguyen Duy Nhat (nhatnd)
 * @since Mar 22, 2008
 */
public class ActionUtil {

	public static final long DEFAULT_CAT_ID = 0;

	public static void getCategory(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getCategory(httpReq);

	}

	public static void getCategory(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getCategory(httpReq);
	}

	public static void getCategory(HttpServletRequest req) throws Exception {
		// get category
		long catId = ParamUtil.getLong(req, "categoryId");
		long groupId = PortalUtilExt.getPortletGroupId(req);
		FAQCategory category;
		if (catId > 0) {
			category = FAQCategoryLocalServiceUtil.getCategory(groupId, catId);
		} else {
			category = new FAQCategoryImpl();
		}
		req.setAttribute(WebKeysExt.VFAQ_CATEGORY, category);
	}

	public static void getQuestion(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getQuestion(httpReq);
	}

	public static void getQuestion(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getQuestion(httpReq);
	}

	public static void getQuestion(HttpServletRequest req) throws Exception {
		// get question
		long questionId = ParamUtil.getLong(req, "questionId");
		long groupId = PortalUtilExt.getPortletGroupId(req);
		FAQQuestion question;
		if (questionId > 0) {
			question = FAQQuestionLocalServiceUtil.getQuestion(groupId,
					questionId);
		} else {
			question = new FAQQuestionImpl();
		}
		req.setAttribute(WebKeysExt.VFAQ_QUESTION, question);
	}

	public static void getAnswer(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAnswer(httpReq);
	}

	public static void getAnswer(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAnswer(httpReq);
	}

	public static void getAnswer(HttpServletRequest req) throws Exception {

		// get answer
		long answerId = ParamUtil.getLong(req, "answerId");
		FAQAnswer answer;
		if (answerId > 0) {
			answer = FAQAnswerLocalServiceUtil.getAnswer(answerId);
		} else {
			answer = new FAQAnswerImpl();
		}
		req.setAttribute(WebKeysExt.VFAQ_ANSWER, answer);

		// get attachmentlist
	}

	public static void getAnswerList(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAnswerList(httpReq);
	}

	public static void getAnswerList(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getAnswerList(httpReq);
	}

	public static void getAnswerList(HttpServletRequest req) throws Exception {

		long questionId = ParamUtil.getLong(req, "questionId");
		List listAnswer = FAQAnswerLocalServiceUtil.getByQuestion(questionId);
		req.setAttribute(WebKeysExt.VFAQ_LIST_ANSWER, listAnswer);

	}

	public static void getComment(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getComment(httpReq);
	}

	public static void getComment(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getComment(httpReq);
	}

	public static void getComment(HttpServletRequest req) throws Exception {
		// get comment
		long commentId = ParamUtil.getLong(req, "commentId");
		FAQComment comment;
		if (commentId > 0) {
			comment = FAQCommentLocalServiceUtil.getComment(commentId);
		} else {
			comment = new FAQCommentImpl();
		}
		req.setAttribute(WebKeysExt.VFAQ_COMMENT, comment);
	}

	public static void getCategoryList(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getCategoryList(httpReq);
	}

	public static void getCategoryList(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getCategoryList(httpReq);
	}

	public static void getCategoryList(HttpServletRequest req) throws Exception {
		// get list of category
		long groupId = PortalUtilExt.getPortletGroupId(req);
		List listCategory = FAQCategoryLocalServiceUtil.getAll(groupId);
		listCategory = FAQUtil.sort(listCategory);
		listCategory = FAQUtil.formatByLevel(listCategory);
		req.setAttribute(WebKeysExt.VFAQ_LIST_CATEGORY, listCategory);
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
		long questionId = ParamUtil.getLong(req, "questionId");
		// get attachment
		List listAttachment = AttachmentLocalServiceUtil.getAttachments(
				questionId, FAQQuestion.class);
		if (listAttachment == null) {
			listAttachment = new ArrayList();
		}
		req.setAttribute(WebKeysExt.VFAQ_LIST_ATTACHMENT, listAttachment);
	}

	public static void getCategoriesOfQuestion(ActionRequest req)
			throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getCategoriesOfQuestion(httpReq);
	}

	public static void getCategoriesOfQuestion(RenderRequest req)
			throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		getCategoriesOfQuestion(httpReq);
	}

	public static void getCategoriesOfQuestion(HttpServletRequest req)
			throws Exception {
		// get question
		long questionId = ParamUtil.getLong(req, "questionId");
		List categoryList;
		if (questionId > 0) {
			categoryList = FAQCategoryQuestionLocalServiceUtil
					.getCategoriesOfQuestion(questionId);
		} else {
			categoryList = new ArrayList();
		}
		req.setAttribute(WebKeysExt.VFAQ_CATEGORIES_OF_QUESTION, categoryList);
	}

	public static String getCategoryTree(long groupId, String language,
			long parentId, long categoryId, long[] catIds) throws Exception {

		StringBuffer sb = new StringBuffer();

		List listCat = new ArrayList();

		try {

			listCat = FAQCategoryLocalServiceUtil.getByG_L_P(groupId, language,
					DEFAULT_CAT_ID);

		} catch (Exception e) {
		}

		int indent = 0;

		traverseCatTree(sb, listCat, indent, parentId, categoryId, catIds);

		return sb.toString();
	}

	private static void traverseCatTree(StringBuffer sb, List listCat,
			int indent, long parentId, long categoryId, long[] catIds)
			throws Exception {

		if ((listCat == null) || (listCat.size() <= 0)) {
			return;
		}

		for (int i = 0; i < listCat.size(); i++) {

			FAQCategory category = (FAQCategory) listCat.get(i);

			sb.append("<option value=\"" + category.getId() + "\" ");

			if (Validator.isNull(catIds)) {

				sb.append((category.getId() == parentId)?" selected ":"");

			} else if (Validator.isNotNull(catIds) && catIds.length > 0) {
				for (int j = 0; j < catIds.length; j++) {
					sb.append((category.getId() == catIds[j])?" selected ":"");
				}
			}

			sb.append(">");

			// Indent
			for (int j = 0; j < indent; j++) {
				sb.append(StringPool.NBSP);

			}

			sb.append(category.getName());
			sb.append("</option>");

			try {

				traverseCatTree(sb, FAQCategoryLocalServiceUtil.getByG_L_P(
						category.getGroupId(), category.getLanguage(), category
								.getId()), indent + 3, parentId, category
						.getId(), catIds);

			} catch (Exception ex) {
				// Ignore..
			}
		}
	}

	public static String getListParentCategory(long categoryId)
			throws PortalException, SystemException, RemoteException {
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(categoryId));
		getParentCategory(sb, categoryId);
		return sb.toString();
	}

	public static void getParentCategory(StringBuffer sb, long categoryId)
			throws PortalException, SystemException, RemoteException {

		FAQCategory cat = FAQCategoryLocalServiceUtil.getCategory(categoryId);
		if (cat.getParent() != 0) {
			sb.append("," + cat.getParent());
			getParentCategory(sb, cat.getParent());
		}
	}
}
