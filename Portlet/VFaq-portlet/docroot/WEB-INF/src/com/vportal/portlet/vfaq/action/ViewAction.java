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

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portal.attachment.AttachmentManager;
import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portal.taglib.FileUploadUtil;
import com.vportal.portal.util.PortalUtilExt;
import com.vportal.portlet.vfaq.model.FAQAnswer;
import com.vportal.portlet.vfaq.model.FAQCategory;
import com.vportal.portlet.vfaq.model.FAQQuestion;
import com.vportal.portlet.vfaq.service.FAQAnswerLocalServiceUtil;
import com.vportal.portlet.vfaq.service.FAQCategoryLocalServiceUtil;
import com.vportal.portlet.vfaq.service.FAQCategoryQuestionLocalServiceUtil;
import com.vportal.portlet.vfaq.service.FAQCommentLocalServiceUtil;
import com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil;
import com.vportal.portlet.vfaq.util.WebKeysExt;


/**
 * Portlet implementation class ViewAction
 */
public class ViewAction extends MVCPortlet {
	
	public void deleteQuestion(ActionRequest req,ActionResponse res) throws Exception {		
		long questionId = ParamUtil.getLong(req, "questionId");

		long groupId = PortalUtilExt.getPortletGroupId(req);
		long userId = PortalUtilExt.getUserId(req);
		String portletId = WebKeysExt.VFAQ;
		AttachmentManager am = new AttachmentManager(portletId,
				FAQQuestion.class, questionId);
		am.deleteFileEntries();

		if (questionId > 0) {
			FAQQuestionLocalServiceUtil.deleteQuestion(groupId,userId, questionId);

			FAQCategoryQuestionLocalServiceUtil.deleteByQuestionId(questionId);

		}

		String[] deleteQuestionIds = StringUtil.split(ParamUtil.getString(req,
				"deleteQuestionIds"));
		for (int i = 0; i < deleteQuestionIds.length; i++) {
			FAQQuestionLocalServiceUtil.deleteQuestion(groupId, userId,
					Long.parseLong(deleteQuestionIds[i]));

			FAQCategoryQuestionLocalServiceUtil.deleteByQuestionId(Long
					.parseLong(deleteQuestionIds[i]));

			am.setFileEntryId(Long.parseLong(deleteQuestionIds[i]));
			am.deleteFileEntries();

		}
	}

	public void updateQuestion(ActionRequest req,ActionResponse res) throws Exception {
		FAQQuestion question = null;
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(req);
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long questionId = ParamUtil.getLong(uploadRequest, "questionId");
		String title = ParamUtil.getString(uploadRequest, "title");
		String content = ParamUtil.getString(uploadRequest, "content");
		String language = ParamUtil.getString(uploadRequest, "language");
		long questionOrder = ParamUtil.getLong(uploadRequest, "questionOrder");
		String questionType = ParamUtil.getString(uploadRequest, "type");
		String sentByUser = ParamUtil.getString(uploadRequest, "sentByUser");
		String senderEmail = ParamUtil.getString(uploadRequest, "senderEmail");
		String[] categoryId = uploadRequest.getParameterValues("category");
		boolean isApproved = ParamUtil.getBoolean(uploadRequest, "approved");
		String isRemoveAttach = ParamUtil.getString(uploadRequest, "removeAttach");
		String[] communityPermissions = uploadRequest
				.getParameterValues("communityPermissions");
		String[] guestPermissions = uploadRequest.getParameterValues("guestPermissions");

		Date now = new Date();
		long userId = PortalUtilExt.getUserId(uploadRequest);
		long groupId = PortalUtilExt.getPortletGroupId(uploadRequest);
		try {

		if (questionId <= 0) {
			// this is insert
			question = FAQQuestionLocalServiceUtil.addQuestion(title, content,
					language, questionOrder, now, sentByUser, senderEmail,
					questionType, 0, isApproved, groupId,userId,layout.getPlid(),
					communityPermissions, guestPermissions);			

			if (Validator.isNotNull(categoryId)) {
				for (int i = 0; i < categoryId.length; i++) {

					/*FAQCategoryPermission.check(themeDisplay
							.getPermissionChecker(), Long
							.parseLong(categoryId[i]),
							ActionKeysExt.ADD_QUESTION);*/

					FAQCategoryQuestionLocalServiceUtil.addCategoryQuestion(
							Long.parseLong(categoryId[i]), question.getId());					
				}
			}

		} else {

			FAQQuestion old = FAQQuestionLocalServiceUtil.getQuestion(groupId,
					questionId);
			question = FAQQuestionLocalServiceUtil.updateQuestion(questionId, title,
					content, language, questionOrder, now, sentByUser,
					questionType, old.getHitCount(), isApproved, groupId,
					userId, senderEmail, sentByUser);

			FAQCategoryQuestionLocalServiceUtil.deleteByQuestionId(question
					.getId());

			if (Validator.isNotNull(categoryId)) {
				for (int i = 0; i < categoryId.length; i++) {
					FAQCategoryQuestionLocalServiceUtil.addCategoryQuestion(
							Long.parseLong(categoryId[i]), question.getId());
				}
			}

			if (Validator.isNotNull(isRemoveAttach)) {
				String portletId = WebKeysExt.VFAQ;
				AttachmentManager am = new AttachmentManager(portletId,
						FAQQuestion.class, question.getId());
				am.deleteFileEntries();

			}
		}

		String portletId = WebKeysExt.VFAQ;
		FileUploadUtil.uploadFile(req, uploadRequest, portletId, FAQQuestion.class, question.getId(),GetterUtil.getLong(0),StringPool.BLANK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		res.setRenderParameter("jspPage", "/html/portlet/vfaq/view.jsp");
		res.setRenderParameter("tabs1", ParamUtil.getString(uploadRequest, "tabs1"));
		res.setRenderParameter("tabs2", ParamUtil.getString(uploadRequest, "tabs2"));
	}
	
	public void deleteComment(ActionRequest req,ActionResponse res) throws Exception {
		// single delete
		long commentId = ParamUtil.getLong(req, "commentId");
		long groupId = PortalUtilExt.getPortletGroupId(req);
		if (commentId > 0) {
			FAQCommentLocalServiceUtil.removeComment(groupId, commentId);
		}
		// multiple delete
		String[] deleteCommentIds = StringUtil.split(ParamUtil.getString(req,
				"deleteCommentIds"));
		for (int i = 0; i < deleteCommentIds.length; i++) {
			FAQCommentLocalServiceUtil.removeComment(groupId,
					Long.parseLong(deleteCommentIds[i]));
		}
	}

	/**
	 * 
	 */
	public void updateComment(ActionRequest req,ActionResponse res) throws Exception {
		long answerid = ParamUtil.getLong(req, "answerId");
		long commentId = ParamUtil.getLong(req, "commentId");
		String content = ParamUtil.getString(req, "content");
		String commName = ParamUtil.getString(req, "commName");
		String commEmail = ParamUtil.getString(req, "commEmail");
		boolean approved = ParamUtil.getBoolean(req, "approved");
		String approvedByUser = ParamUtil.getString(req, "approvedByUser");
		String[] communityPermissions = req
				.getParameterValues("communityPermissions");
		String[] guestPermissions = req.getParameterValues("guestPermissions");
		Date now = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		String currentUser = themeDisplay.getUser().getFullName();
		long groupId = themeDisplay.getPortletGroupId();
		long userId = themeDisplay.getUserId();
		long plid = PortalUtilExt.getPlid(req);
		if (Validator.isNull(approvedByUser)) {
			approvedByUser = currentUser;
		}
		if (commentId <= 0) {
			// this is insert
			FAQCommentLocalServiceUtil.addComment(answerid, content,
					commName, commEmail, approved, currentUser, now, now,
					userId,plid, communityPermissions, guestPermissions);
		} else {
			// this is update
			FAQCommentLocalServiceUtil.updateComment(groupId, commentId, content,
					approved, currentUser, now, userId);			
		}
	}
	
	public void deleteCategory(ActionRequest req,ActionResponse res) throws Exception {
		// single delete
		long catId = ParamUtil.getLong(req, "categoryId");
		long groupId = PortalUtil.getScopeGroupId(req);
		if (catId > 0) {
			FAQCategoryLocalServiceUtil.deleteCategory(groupId, catId);

			FAQCategoryQuestionLocalServiceUtil.deleteByCategoryId(catId);
		}

		String[] deleteCategoryIds = StringUtil.split(ParamUtil.getString(req,
				"deleteCategoryIds"));
		for (int i = 0; i < deleteCategoryIds.length; i++) {
			FAQCategoryLocalServiceUtil.deleteCategory(groupId, Long
					.parseLong(deleteCategoryIds[i]));

			FAQCategoryQuestionLocalServiceUtil.deleteByCategoryId(Long
					.parseLong(deleteCategoryIds[i]));
		}
		
		 
		 
		 
	}

	/**
	 * 
	 */
	public void updateCategory(ActionRequest req,ActionResponse res) throws Exception {
		FAQCategory category = null;
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(req);
		long catId = ParamUtil.getLong(uploadRequest, "categoryId");
		String name = ParamUtil.getString(uploadRequest, "name");
		String description = ParamUtil.getString(uploadRequest, "description");
		String language = ParamUtil.getString(uploadRequest, "language");
		long parent = ParamUtil.getLong(uploadRequest, "parent");
		long catOrder = ParamUtil.getInteger(uploadRequest, "catOrder");
		long catLevel = ParamUtil.getInteger(uploadRequest, "catLevel");
		Date now = new Date();
		User user = PortalUtilExt.getUser(uploadRequest);
		String currentUser = user.getFullName();
		long groupId = PortalUtilExt.getPortletGroupId(uploadRequest);
		long plId = PortalUtilExt.getPlid(uploadRequest);
		long userId = PortalUtilExt.getUserId(uploadRequest);
		String isRemoveAttach = ParamUtil.getString(uploadRequest, "removeAttach");
		String[] communityPermissions = uploadRequest
				.getParameterValues("communityPermissions");
		String[] guestPermissions = uploadRequest.getParameterValues("guestPermissions");

		try {
			if (catId <= 0) {
				category = FAQCategoryLocalServiceUtil.addCategory(name, description,
						language, parent, catOrder, catLevel, null, currentUser,
						now, groupId, plId, userId, communityPermissions, guestPermissions);

			} else {

				category = FAQCategoryLocalServiceUtil.updateCategory(catId, name,
						description, language, parent, catOrder, catLevel, null,
						currentUser, now, groupId, userId);
				
				if (Validator.isNotNull(isRemoveAttach)) {
					String portletId = WebKeysExt.VFAQ;
					AttachmentManager am = new AttachmentManager(portletId,
							FAQCategory.class, category.getId());
					am.deleteFileEntries();

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		String portletId = WebKeysExt.VFAQ;
		FileUploadUtil.uploadFile(req, uploadRequest, portletId, FAQCategory.class, category.getId(),GetterUtil.getLong(0),StringPool.BLANK);

		res.setRenderParameter("jspPage", "/html/portlet/vfaq/view.jsp");
		res.setRenderParameter("tabs1", ParamUtil.getString(uploadRequest, "tabs1"));
		res.setRenderParameter("tabs2", ParamUtil.getString(uploadRequest, "tabs2"));
	}

	public void deleteAnswer(ActionRequest req,ActionResponse res) throws Exception {
		// single delete
		long id = ParamUtil.getLong(req, "answerId");
		long groupId = PortalUtilExt.getPortletGroupId(req);
		long userId = PortalUtilExt.getUserId(req);
		String portletId = WebKeysExt.VFAQ;
		if (id > 0) {
			AttachmentManager am = new AttachmentManager(portletId,
					FAQAnswer.class, id);
			am.deleteFileEntries();
			FAQAnswerLocalServiceUtil.deleteAnswer(groupId, userId, id);

		}

		String[] deleteAnswerIds = StringUtil.split(ParamUtil.getString(req,
				"deleteAnswerIds"));
		for (int i = 0; i < deleteAnswerIds.length; i++) {
			// delete attach
			AttachmentManager am = new AttachmentManager(portletId,
					FAQAnswer.class, Long.parseLong(deleteAnswerIds[i]));
			am.deleteFileEntries();
			// delete multi answer
			FAQAnswerLocalServiceUtil.deleteAnswer(groupId, userId,  Long
					.parseLong(deleteAnswerIds[i]));
		}
	}

	/**
	 * 
	 */
	public void updateAnswer(ActionRequest req,ActionResponse res) throws Exception {
		FAQAnswer answer = null;
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(req);
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long answerId = ParamUtil.getLong(uploadRequest, "answerId");
		long questionId = ParamUtil.getLong(uploadRequest, "questionId");
		String content = ParamUtil.getString(uploadRequest, "content");
		long answerOrder = ParamUtil.getLong(uploadRequest, "answerOrder");
		boolean isApproved = ParamUtil.getBoolean(uploadRequest, "approved");
		String answeredByUser = ParamUtil.getString(uploadRequest, "answeredByUser");

		String attachName = ParamUtil.getString(uploadRequest, "attachName");
		long folderId = ParamUtil.getLong(uploadRequest, "folderId");
		String[] communityPermissions = uploadRequest
				.getParameterValues("communityPermissions");
		String[] guestPermissions = uploadRequest.getParameterValues("guestPermissions");

		Date now = new Date();
		long groupId = PortalUtilExt.getPortletGroupId(uploadRequest);
		long plId = layout.getPlid();
		long userId = themeDisplay.getUserId();
		String language = themeDisplay.getLanguageId();

		if (answerId <= 0) {
			answer = FAQAnswerLocalServiceUtil.addAnswer(groupId, questionId, content, answerOrder, answeredByUser, now, language,
					isApproved, answeredByUser, now, userId,plId, attachName, folderId,
					communityPermissions, guestPermissions);

		} else {
			FAQAnswerLocalServiceUtil.updateAnswer(groupId, answerId,
					content, answerOrder, answeredByUser, now, language,
					isApproved, answeredByUser, now, userId, attachName, folderId);

		}

		_attachFile(answer, req, uploadRequest);
		
		res.setRenderParameter("jspPage", "/html/portlet/vfaq/view.jsp");
		res.setRenderParameter("tabs1", ParamUtil.getString(uploadRequest, "tabs1"));
		res.setRenderParameter("tabs2", ParamUtil.getString(uploadRequest, "tabs2"));

	}

	public void _attachFile(FAQAnswer answer, ActionRequest req,UploadPortletRequest uploadRequest)
			throws Exception {
		try{
			if (answer != null) {
			
				String portletId = WebKeysExt.VFAQ;		
				FileUploadUtil.uploadFile(req, uploadRequest, portletId,
						FAQAnswer.class, answer.getId(),GetterUtil.getLong(0),StringPool.BLANK);
//				AttachmentManager am = new AttachmentManager(portletId,
//						FAQAnswer.class, answer.getId());
//				am.addFile(req, uploadRequest);
				List listAttachment = AttachmentLocalServiceUtil
						.getDLFileEntries(FAQAnswer.class, answer.getId());
				for (int i = 0; i < listAttachment.size(); i++) {
					DLFileEntry fileEntry = (DLFileEntry) listAttachment.get(i);
					if (fileEntry != null) {
						answer.setFolderId(fileEntry.getFolderId());
						answer.setAttachName(fileEntry.getName());
					}
				}
				FAQAnswerLocalServiceUtil.updateFAQAnswer(answer);
			}
		}catch(Exception e){
			
		}
	}
	
	public void deleteFileDL(ActionRequest req,ActionResponse res) throws Exception{
		long groupId = PortalUtil.getScopeGroupId(req);
		long folderId = ParamUtil.getLong(req, "folderId");
		String name = ParamUtil.getString(req, "name");
		Long attachmentId = ParamUtil.getLong(req, "attachmentId");
		DLFileEntryServiceUtil.deleteFileEntry(groupId,folderId, name);
		AttachmentLocalServiceUtil.deleteAttachment(attachmentId);
	}
		
}
