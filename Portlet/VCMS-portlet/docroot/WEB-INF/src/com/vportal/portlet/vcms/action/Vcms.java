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
package com.vportal.portlet.vcms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;
import javax.portlet.filter.ActionRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.vportal.portal.service.AttachmentLocalServiceUtil;
import com.vportal.portal.service.AttachmentServiceUtil;
import com.vportal.portal.taglib.FileUploadUtil;
import com.vportal.portal.util.PropsUtilExt;
import com.vportal.portlet.vcms.InvalidArticleRelationException;
import com.vportal.portlet.vcms.NoSuchVcmsLoggerException;
import com.vportal.portlet.vcms.model.VcmsArticle;
import com.vportal.portlet.vcms.model.VcmsArticleType;
import com.vportal.portlet.vcms.model.VcmsCARelation;
import com.vportal.portlet.vcms.model.VcmsCategory;
import com.vportal.portlet.vcms.model.VcmsPortion;
import com.vportal.portlet.vcms.model.VcmsStatus;
import com.vportal.portlet.vcms.model.VcmsTARelation;
import com.vportal.portlet.vcms.model.VcmsThread;
import com.vportal.portlet.vcms.model.VcmsType;
import com.vportal.portlet.vcms.service.VcmsArticleServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleStatusLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleTypeLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsArticleVersionServiceUtil;
import com.vportal.portlet.vcms.service.VcmsAttachedMessageServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCARelationServiceUtil;
import com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil;
import com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil;
import com.vportal.portlet.vcms.service.VcmsPARelationServiceUtil;
import com.vportal.portlet.vcms.service.VcmsPortionServiceUtil;
import com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsTARelationServiceUtil;
import com.vportal.portlet.vcms.service.VcmsThreadServiceUtil;
import com.vportal.portlet.vcms.service.VcmsTypeServiceUtil;
import com.vportal.portlet.vcms.service.impl.VcmsArticleServiceImpl;
import com.vportal.portlet.vcms.util.ReportUtil;
import com.vportal.portlet.vcms.util.WebKeysExt;
import com.vportal.portlet.vcmsview.util.ConstantsExt;
import com.vportal.util.HtmlExt;
import com.vportal.util.ImageUtilExt;

/**
 * Portlet implementation class Vcms
 */

public class Vcms extends MVCPortlet  {
	public void updatePortion(ActionRequest req,ActionResponse res) throws Exception {
		
		// ID
		String portionId = ParamUtil.getString(req, "portionId");

		// Other fields
		
		long groupId = ParamUtil.getLong(req, "groupId");
		long companyId = PortalUtil.getCompanyId(req);

		String code = ParamUtil.getString(req, "code");
		String name = ParamUtil.getString(req, "name");
		String description = ParamUtil.getString(req, "description");
		boolean categorizable = ParamUtil.getBoolean(req, "categorizable");
		String language = ParamUtil.getString(req, "language");

		String[] communityPermissions = req
				.getParameterValues("communityPermissions");

		String[] guestPermissions = req.getParameterValues("guestPermissions");

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		if (Validator.isNull(portionId)) {

			VcmsPortionServiceUtil.addPortion(groupId, companyId, layout.getPlid()
					, code, name, description, categorizable
					, language, communityPermissions, guestPermissions);

		} else {

			VcmsPortionServiceUtil.updatePortion(portionId, groupId, companyId,
					code, name, description, categorizable, language);

		}
		res.setRenderParameter("jspPage", "/html/portlet/vcms/view.jsp?tabs1=portlet.vcms.tabs.manage&tabs2=portlet.vcms.tabs.portion");
	}
	
	public void deletePortion(ActionRequest req,ActionResponse res) throws Exception {

		String portionId = ParamUtil.getString(req, "portionId");
		VcmsPortionServiceUtil.deletePortion(portionId);
		res.setRenderParameter("jspPage", "/html/portlet/vcms/view.jsp?tabs1=portlet.vcms.tabs.manage&tabs2=portlet.vcms.tabs.portion");
	}
	
	
	/*Category chuyen muc*
	 * 
	 */
	
	public void updateCategory(ActionRequest req,ActionResponse res) throws Exception {
		
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		// ID fields
		String categoryId = ParamUtil.get(uploadReq, "categoryId", StringPool.BLANK);

		// Other fields
		long groupId = ParamUtil.getLong(uploadReq, "groupId");
		long companyId = PortalUtil.getCompanyId(uploadReq);

		String portionId = null;
		String parentId = ParamUtil.getString(uploadReq, "parentId");

		if (Validator.isNotNull(parentId) && (parentId.indexOf("|") > 0)) {
			String[] ppIds = StringUtil.split(parentId, "|");
			portionId = ppIds[0];
			parentId = ppIds[1];
		}

		String name = ParamUtil.getString(uploadReq, "name");
		String description = ParamUtil.getString(uploadReq, "description");

		boolean anchored = ParamUtil.getBoolean(uploadReq, "anchored");
		String href = ParamUtil.getString(uploadReq, "href");

		String language = ParamUtil.getString(uploadReq, "language");
		String image = uploadReq.getFileName("image");
		
		boolean rssable = ParamUtil.getBoolean(uploadReq, "rssable");

		String[] communityPermissions = uploadReq
				.getParameterValues("communityPermissions");

		String[] guestPermissions = uploadReq.getParameterValues("guestPermissions");

		VcmsCategory category = null;

		ThemeDisplay themeDisplay = (ThemeDisplay) uploadReq
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		if (categoryId.equals(StringPool.BLANK)) {
			category = VcmsCategoryServiceUtil.addCategory(groupId, companyId,
					layout.getPlid(), portionId, parentId, name, description,
					anchored, href, language, false, null, rssable,
					communityPermissions, guestPermissions);

		} else {

			category = VcmsCategoryServiceUtil.getCategory(categoryId);

			VcmsCategoryServiceUtil.updateCategory(groupId, companyId,
					categoryId, portionId, parentId, name, description,
					anchored, href, language, category.getHasImage(), category
							.getImage(), category.getPosition(), category
							.getUserHit(), rssable);
			if (parentId.equals("0")
					&& !category.getPortionId().equals(portionId)) {
				VcmsCategoryServiceUtil.changePortion(categoryId, groupId,
						portionId, language);
			}
		}

		// Image...

		if ((category != null) && Validator.isNotNull(image)) {
			

			// Validate the image input

			String contentType = uploadReq.getContentType("image");
			if (ImageUtilExt.isImage(contentType)) {
				String imageKey = category.getCategoryId();
				File fileImage = uploadReq.getFile("image");
				if (fileImage != null) {
					byte[] photoBytes = FileUtil.getBytes(fileImage);
					ImageUtilExt.saveOriginalImage(Long.parseLong(imageKey),
							photoBytes);
				}

				// Update the category when the image is saved
				category.setHasImage(true);
				category.setImage(imageKey);

				VcmsCategoryServiceUtil.updateCategory(category);
			}
		}
		res.setRenderParameter("jspPage", "/html/portlet/vcms/view.jsp?tabs1=portlet.vcms.tabs.manage&tabs2=portlet.vcms.tabs.category");
	}
	
	public void deleteCategory(ActionRequest req, ActionResponse res) throws PortalException, SystemException, RemoteException{
		String categoryId = ParamUtil.get(req, "categoryId", StringPool.BLANK);

		if (Validator.isNull(categoryId)) {
			return;
		}

		// 1. Delete the image if available

		VcmsCategory category = VcmsCategoryServiceUtil.getCategory(categoryId);

		if (category.getHasImage()) {
			String imageKey = category.getImage();

			if (Validator.isNotNull(imageKey)) {
				ImageUtilExt.deleteImage(Long.parseLong(imageKey));
			}

		}

		// 2. Delete the category
//		SessionMessages.add(req, "Internal Error! Captcha text not found in session");
//		SessionErrors.add(req, "error-captcha");
		res.setRenderParameter("jspPage", "/html/portlet/vcms/view.jsp?tabs1=portlet.vcms.tabs.manage&tabs2=portlet.vcms.tabs.category");
		VcmsCategoryServiceUtil.deleteCategory(categoryId);
		
		res.setRenderParameter("jspPage", "/html/portlet/vcms/view.jsp?tabs1=portlet.vcms.tabs.manage&tabs2=portlet.vcms.tabs.category");
	}
	
	public void removeImage(ActionRequest req,ActionResponse res) throws Exception {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		String categoryId = ParamUtil.getString(uploadReq, "categoryId");
		VcmsCategory category = VcmsCategoryServiceUtil.getCategory(categoryId);
		ImageUtilExt.deleteImage(Long.parseLong(category.getImage()));
		if (category != null) {
			category.setHasImage(false);
			category.setImage(null);
			VcmsCategoryServiceUtil.updateCategory(category);
		}
		res.setRenderParameter("categoryId", categoryId);
		res.setRenderParameter("jspPage", "/html/portlet/vcms/manage/categories/edit_category.jsp");
	}
	
	public void updateStatus(ActionRequest req,ActionResponse res) throws Exception {
		// Primary key
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		long statusId = ParamUtil.getLong(uploadReq, "statusId", 0);

		// Other fields
		String title = ParamUtil.get(uploadReq, "title", StringPool.BLANK);
		String description = ParamUtil
				.get(uploadReq, "description", StringPool.BLANK);
		String cssClass = ParamUtil.get(uploadReq, "cssClass", StringPool.BLANK);
		String textColor = ParamUtil.get(uploadReq, "textColor", StringPool.BLANK);
		long position = ParamUtil.getInteger(uploadReq, "position", 0);
		boolean isPrimary = ParamUtil.getBoolean(uploadReq, "isPrimary", false);
		boolean _active = ParamUtil.getBoolean(uploadReq, "active", false);

		long userId = PortalUtil.getUserId(uploadReq);
		long groupId = ParamUtil.getLong(uploadReq, "groupId", 0);
		long companyId = PortalUtil.getCompanyId(uploadReq);

		String[] communityPermissions = uploadReq
				.getParameterValues("communityPermissions");
		String[] guestPermissions = uploadReq.getParameterValues("guestPermissions");

		if (statusId == 0) {
			VcmsStatusLocalServiceUtil.addStatus(companyId, groupId, userId,
					title, description, cssClass, textColor, position,
					isPrimary, _active, true, true, communityPermissions,
					guestPermissions);
		} else {
			VcmsStatusLocalServiceUtil.updateStatus(statusId, companyId,
					groupId, userId, title, description, cssClass, textColor,
					position, isPrimary, _active, true, true,
					communityPermissions, guestPermissions);
		}

		VcmsStatus status = null;
		res.setRenderParameter("jspPage", "/html/portlet/vcms/view.jsp?tabs1=portlet.vcms.tabs.manage&tabs2=portlet.vcms.tabs.manage-status");
	}
	
	public void deleteStatus(ActionRequest req,ActionResponse res) throws Exception {
		String[] statusIds = StringUtil.split(ParamUtil.get(req, "statusIds",
				StringPool.BLANK));

		if ((statusIds == null) || (statusIds.length <= 0)) {
			return;
		}

		long userId = PortalUtil.getUserId(req);
		long groupId = ParamUtil.getLong(req, "groupId", 0);
		long companyId = PortalUtil.getCompanyId(req);

		String undeleted = "";

		for (int i = 0; i < statusIds.length; i++) {
			long statusId = Long.parseLong(statusIds[i]);
			int countArticle = VcmsArticleServiceUtil.countByStatus(statusId);
			if (countArticle == 0)
				VcmsStatusLocalServiceUtil.deleteStatus(statusId, companyId,
						groupId, userId);
			else
				undeleted += statusId + ", ";
		}

		if (Validator.isNotNull(undeleted))
			SessionMessages.add(req, "portlet.vcms.status.delete.errorhavearticle");
		res.setRenderParameter("jspPage", "/html/portlet/vcms/view.jsp?tabs1=portlet.vcms.tabs.manage&tabs2=portlet.vcms.tabs.manage-status");
	}
	
	//Type
	public void updateType(ActionRequest req,ActionResponse res) throws Exception {

		// ID
		String typeId = ParamUtil.getString(req, "typeId");

		long groupId = ParamUtil.getLong(req, "groupId");
		long companyId = PortalUtil.getCompanyId(req);

		String code = ParamUtil.getString(req, "code");
		String name = ParamUtil.getString(req, "name");
		String description = ParamUtil.getString(req, "description");
		String language = ParamUtil.getString(req, "language");

		String[] communityPermissions = req
				.getParameterValues("communityPermissions");

		String[] guestPermissions = req.getParameterValues("guestPermissions");

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		if (Validator.isNull(typeId)) {

			VcmsTypeServiceUtil.addType(groupId, companyId, layout.getPlid(),
					code, name, description, language, communityPermissions,
					guestPermissions);

		} else {

			VcmsTypeServiceUtil.updateType(typeId, groupId, companyId, code,
					name, description, language);

		}
		
		//res.setRenderParameter("jspPage", "/html/portlet/vcms/view.jsp?tabs1=portlet.vcms.tabs.manage&tabs2=portlet.vcms.tabs.type");
	}

	public void deleteType(ActionRequest req,ActionResponse res) throws Exception {

		String typeId = ParamUtil.getString(req, "typeId");

		VcmsTypeServiceUtil.deleteType(typeId);
		res.setRenderParameter("jspPage", "/html/portlet/vcms/view.jsp?tabs1=portlet.vcms.tabs.manage&tabs2=portlet.vcms.tabs.type");
	}

	public void addArticle(ActionRequest req,ActionResponse res) throws Exception {

		long typeId = ParamUtil.getLong(req, "typeId");
		String parameter = ParamUtil.getString(req, "parameter");
		String[] articleId_position = StringUtil.split(parameter, ",");
		String[] param = null;
		String strArticle = "";

		String articleId = "";
		String position = "";

		if ((articleId_position == null) || (articleId_position.length <= 0)) {
			return;
		}

		VcmsArticleTypeLocalServiceUtil.deleteRelationByTypeId(typeId);		
		for (int i = 0; i < articleId_position.length; i++) {
			strArticle = articleId_position[i];
			param = StringUtil.split(strArticle, "_");

			articleId = param[0];
			position = param[1];

			VcmsArticleTypeLocalServiceUtil.addArticleType(articleId, typeId,
					Integer.parseInt(position));

		}

	}

	public void updatePosition(ActionRequest req,ActionResponse res) throws Exception {

		long typeId = ParamUtil.getLong(req, "typeId");
		String articleId = null;
		int newPosition = 0;
		String compoundParam = ParamUtil.getString(req, "position");

		if (Validator.isNotNull(compoundParam)
				&& (compoundParam.indexOf("_") > 0)) {
			String[] cpIds = StringUtil.split(compoundParam, "_");

			newPosition = Integer.parseInt(cpIds[1]);
			articleId = cpIds[0];
		}

		try {
			VcmsArticleType vArticleType = VcmsArticleTypeLocalServiceUtil
					.getArticleType(typeId, articleId);

			if (vArticleType != null) {
				vArticleType.setPosition(newPosition);
			}

			VcmsArticleTypeLocalServiceUtil.updateVcmsArticleType(vArticleType);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void updateConfiguration(ActionRequest req,ActionResponse res) throws Exception{
		// 1. Article settings
				int imageWidth = ParamUtil.getInteger(req, "imageWidth", 100);
				int imageHeight = ParamUtil.getInteger(req, "imageHeight", 100);

				int maxArticleAttachment = ParamUtil.getInteger(req,
						"maxArticleAttachment", 5);

				boolean autoApprove = ParamUtil.getBoolean(req, "autoApprove");
				// boolean autoPublish = ParamUtil.getBoolean(req, "autoPublish");

				String autoMessage = ParamUtil.getString(req, "autoMessage");

				// 2. Discussion settings
				boolean autoDiscussionApprove = ParamUtil.getBoolean(req,
						"autoDiscussionApprove");
				int maxDiscussionAttachment = ParamUtil.getInteger(req,
						"maxDiscussionAttachment");
				boolean sendThanksDiscussionEmail = ParamUtil.getBoolean(req,
						"sendThanksDiscussionEmail");
				String senderName = ParamUtil.getString(req, "senderName");
				String senderEmail = ParamUtil.getString(req, "senderEmail");
				String autoDiscussionEmailSubject = ParamUtil.getString(req,
						"autoDiscussionEmailSubject");
				String autoDiscussionEmailContent = ParamUtil.getString(req,
						"autoDiscussionEmailContent");

				// 3. Logging settings
				int autoClearLog = ParamUtil.getInteger(req, "autoClearLog");

				// Save these settings to preferences
				long companyId = PortalUtil.getCompanyId(req);
				//PortletPreferences prefs = PrefsPropsUtil.getPreferences(companyId);
				
				String portletResource = ParamUtil.getString(req, "portletResource");
				//Creating the Reference for Portletpreferences Table
				//hoan
				//PortletPreferences  prefs = PortletPreferencesFactoryUtil.getPortletSetup(req, portletResource);
				
				MethodKey method = new MethodKey("com.liferay.portal.util.PrefsPropsUtil", "getPreferences",long.class);
				Object[] args = new Object[]{companyId};
				Object objectRe= PortalClassInvoker.invoke(false, method, args);
				PortletPreferences prefs = null;
				if(objectRe!=null){
					prefs = (PortletPreferences)objectRe;
					prefs.setValue(PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_WIDTH, String
							.valueOf(imageWidth));
					prefs.setValue(PropsUtilExt.VCMS_ARTICLE_THUMB_IMAGE_HEIGHT, String
							.valueOf(imageHeight));
					prefs.setValue(PropsUtilExt.VCMS_ARTICLE_MAX_ATTACHMENT, String
							.valueOf(maxArticleAttachment));
					prefs.setValue(PropsUtilExt.VCMS_ARTICLE_AUTO_APPROVE, String
							.valueOf(autoApprove));
					// prefs.setValue(PropsUtilExt.VCMS_ARTICLE_AUTO_PUBLISH,
					// String.valueOf(autoPublish));
					prefs.setValue(PropsUtilExt.VCMS_ARTICLE_AUTO_REQUEST_MESSAGE,
							autoMessage);
					prefs.setValue(PropsUtilExt.VCMS_DISCUSSION_AUTO_APPROVE, String
							.valueOf(autoDiscussionApprove));
					prefs.setValue(PropsUtilExt.VCMS_DISCUSSION_MAX_ATTACHMENT, String
							.valueOf(maxDiscussionAttachment));
					prefs.setValue(PropsUtilExt.VCMS_DISCUSSION_SEND_THANKS_EMAIL, String
							.valueOf(sendThanksDiscussionEmail));
					prefs.setValue(PropsUtilExt.VCMS_DISCUSSION_THANKS_SENDER_NAME,
							senderName);
					prefs.setValue(PropsUtilExt.VCMS_DISCUSSION_THANKS_SENDER_EMAIL,
							senderEmail);
					prefs.setValue(PropsUtilExt.VCMS_DISCUSSION_THANKS_EMAIL_SUBJECT,
							autoDiscussionEmailSubject);
					prefs.setValue(PropsUtilExt.VCMS_DISCUSSION_THANKS_EMAIL_CONTENT,
							autoDiscussionEmailContent);

					prefs.setValue(PropsUtilExt.VCMS_LOGGING_AUTO_CLEAR, String
							.valueOf(autoClearLog));

					prefs.store();
				}else{
					
				}
								
	}
	
	public VcmsArticle updateArticle(ActionRequest req,ActionResponse res) throws Exception {
		
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		
		/*ServiceContext serviceContext = ServiceContextFactory
				.getInstance(VcmsArticle.getName(), req);*/
		String articleId = ParamUtil.get(uploadReq, "articleId", StringPool.BLANK);

		String title = ParamUtil.getString(uploadReq, "title");
		String lead = ParamUtil.getString(uploadReq, "lead");
		String content = ParamUtil.getString(uploadReq, "content");
		String imageTitle = ParamUtil.getString(uploadReq, "imageTitle");
		//String image = ParamUtil.getString(req, "image");
		String image = uploadReq.getFileName("image");
		
		long groupId = ParamUtil.getLong(uploadReq, "groupId");
		String language = ParamUtil.getString(uploadReq, "language");
		String pollId = ParamUtil.getString(uploadReq, "pollId");
		String threadId = ParamUtil.getString(uploadReq, "threadId");
		long status = ParamUtil.getLong(uploadReq, "status");
		String author = ParamUtil.getString(uploadReq, "author", StringPool.BLANK);
		String source = ParamUtil.getString(uploadReq, "source", StringPool.BLANK);

		String[] portions = StringUtil.split(ParamUtil.getString(uploadReq,
				"portions", StringPool.BLANK), StringPool.COMMA);
		String[] categories = StringUtil.split(ParamUtil.getString(uploadReq,
				"categories", StringPool.BLANK), StringPool.COMMA);

		String[] typeIds = uploadReq.getParameterValues("typeIds");
		String strTypeIds = "";

		String message = ParamUtil
				.get(uploadReq, "attachedMessage", StringPool.BLANK);

		long companyId = PortalUtil.getCompanyId(uploadReq);

		String[] communityPermissions = uploadReq
				.getParameterValues("communityPermissions");

		String[] guestPermissions = uploadReq.getParameterValues("guestPermissions");

		// Welform article's lead and content

//		lead = GetterUtil.get(lead, StringPool.BLANK);
//		lead = HtmlExt.welform(lead, false);

//		content = GetterUtil.get(content, StringPool.BLANK);
//		content = HtmlExt.welform(content, false);

		VcmsArticle article = null;

		ThemeDisplay themeDisplay = (ThemeDisplay) uploadReq
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		if (Validator.isNull(articleId)) {
			article = VcmsArticleServiceUtil.addArticle(req,uploadReq, groupId,
					companyId, layout.getPlid(), title, lead, content, false,
					imageTitle, image, language, false, Validator
							.isNotNull(pollId), pollId, status, author, source,
					communityPermissions, guestPermissions);

		} else {

			article = VcmsArticleServiceUtil.getArticle(articleId);
			article.setTitle(title);
			article.setLead(lead);
			article.setContent(content);
			article.setHasPoll(Validator.isNotNull(pollId));
			article.setPollId(pollId);
			article.setAuthor(author);
			article.setSource(source);
			article.setImage(image);
			
			article = VcmsArticleServiceUtil.updateArticle(req, uploadReq,article);

		}

		if (Validator.isNotNull(message)) {
			VcmsAttachedMessageServiceUtil.addMessage(article.getGroupId(),
					article.getArticleId(), message, false);
		}

		// Thread of Articles
		VcmsTARelationServiceUtil.deleteRelationsByArticle(articleId);
		VcmsPARelationServiceUtil.deleteRelationsByArticle(articleId);
		VcmsCARelationServiceUtil.deleteRelationsByArticle(articleId);
		VcmsArticleTypeLocalServiceUtil.deleteRelationByArticleId(articleId);

		VcmsArticleType vArticleType = null;

		for (int i = 0; (portions != null) && (i < portions.length); i++) {
			VcmsPARelationServiceUtil.addRelation(portions[i], article
					.getArticleId());
		}

		for (int i = 0; (categories != null) && (i < categories.length); i++) {
			VcmsCARelationServiceUtil.addRelation(categories[i], article
					.getArticleId(), status);

		}

		if (Validator.isNotNull(threadId)) {
			VcmsTARelationServiceUtil.addRelation(threadId, article
					.getArticleId());
		}

		for (int i = 0; (typeIds != null) && (i < typeIds.length); i++) {

			strTypeIds += typeIds[i] + (i < typeIds.length - 1 ? "," : "");

			VcmsArticleTypeLocalServiceUtil.addArticleType(article
					.getArticleId(), Long.parseLong(typeIds[i]), 0);
		}

		try {
			boolean hasAttachment = false;

			// Upload file && Attach file from server
			String portletId = WebKeysExt.VCMS;
			int maxAttachment = ParamUtil.getInteger(uploadReq, "attached");
			
			//ham cu
			//FileUploadUtil.uploadFile(req, uploadReq, portletId, VcmsArticle.class, Long.parseLong(article.getArticleId()));
			
			//ham moi
			FileUploadUtil.uploadFile(req, uploadReq, portletId, VcmsArticle.class, Long.parseLong(article.getArticleId()),0,StringPool.BLANK);
			
			List addedAttachments = AttachmentLocalServiceUtil.getAttachments(Long.parseLong(article.getArticleId()), VcmsArticle.class);

			hasAttachment = ((addedAttachments != null) && (addedAttachments.size() > 0));

			article.setHasAttachment(hasAttachment);
			VcmsArticleServiceUtil.updateArticle(article,uploadReq);
		} catch (Exception e) {
		}

		return article;
	}
	
	public void deleteFileDL(ActionRequest req,ActionResponse res) throws Exception{
		long groupId = PortalUtil.getScopeGroupId(req);
		long folderId = ParamUtil.getLong(req, "folderId");
		String name = ParamUtil.getString(req, "name");
		Long attachmentId = ParamUtil.getLong(req, "attachmentId");
		DLFileEntryServiceUtil.deleteFileEntry(groupId,folderId, name);
		AttachmentLocalServiceUtil.deleteAttachment(attachmentId);
	}
	public void deleteArticle(ActionRequest req,ActionResponse res) throws Exception {
		
		
		String[] articleIds = StringUtil.split(ParamUtil.get(req, "articleIds",
				StringPool.BLANK));

		long companyId = PortalUtil.getCompanyId(req);

		if ((articleIds == null) || (articleIds.length <= 0)) {
			return;
		}

		for (int i = 0; i < articleIds.length; i++) {

			String articleId = articleIds[i];

			VcmsArticle article = VcmsArticleServiceUtil.getArticle(articleId);

			// 1. Remove article's image first
			if (article.getHasImage()) {
				ImageUtilExt.deleteImage(Long.parseLong(article.getImage()));
			}

			// 2. Remove article's attachments
			if (article.getHasAttachment()) {
				AttachmentServiceUtil.deleteAttachments(VcmsArticle.class, Long
						.parseLong(articleId));
			}

			// 3. Delete the article itself and relations to other entities
			VcmsArticleServiceUtil.deleteArticle(articleId);

			// 4. Delete thread of article
			VcmsTARelationServiceUtil.deleteRelationsByArticle(articleId);

			// 5. Delete VcmsArticlesStatus
			VcmsArticleStatusLocalServiceUtil
					.deleteRelationByArticleId(articleId);

			// 6. Delete VcmsArticleType
			VcmsArticleTypeLocalServiceUtil
					.deleteRelationByArticleId(articleId);
		}
	}
	
	
	public void removeArticleImage(ActionRequest req,ActionResponse res) throws Exception {

		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		String articleId = ParamUtil.get(uploadReq, "articleId", StringPool.BLANK);

		if (Validator.isNull(articleId)) {
			return;
		}

		VcmsArticle article = VcmsArticleServiceUtil.getArticle(articleId);

		if (article == null) {
			return;
		}

		ImageUtilExt.deleteImage(Long.parseLong(article.getImage()));

		article.setImage("delete_image");
		article.setImageTitle(null);
		article.setHasImage(false);

		VcmsArticleServiceUtil.updateArticle(article,uploadReq);
		res.setRenderParameter("articleId", articleId);
		res.setRenderParameter("jspPage","/html/portlet/vcms/articles/edit_article.jsp");

	}
	
	
	public void sendArticle(ActionRequest req,ActionResponse res)
			throws Exception {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		boolean status =ParamUtil.getBoolean(req, "status",true);
		String userId = req.getRemoteUser();
		String[] articleIds = StringUtil.split(ParamUtil.get(req, "articleIds",
				StringPool.BLANK));

		if ((articleIds == null) || (articleIds.length <= 0)) {
			return;
		}

		String message = ParamUtil
				.get(req, "attachedMessage", StringPool.BLANK);

		String strCatId = "";

		List listCategoryId = new ArrayList();
		List statusIds = new ArrayList();

		long articleVersionId = 0;

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		long groupId = layout.getGroupId();

		long statusId = ParamUtil.getLong(req, "tabs2", 0);

		VcmsArticle article = null;

		if (Validator.isNotNull(articleIds) && articleIds.length > 0) {
			for (int i = 0; i < articleIds.length; i++) {

				String articleId = articleIds[i];

				listCategoryId = VcmsCARelationServiceUtil
						.getRelationsByArticle(articleId);

				if (Validator.isNotNull(listCategoryId)
						&& listCategoryId.size() > 0) {
					for (int j = 0; j < listCategoryId.size(); j++) {
						VcmsCARelation CA = (VcmsCARelation) listCategoryId
								.get(j);
						strCatId += CA.getCategoryId()
								+ (j < listCategoryId.size() - 1 ? "," : "");
					}
				}

				article = VcmsArticleServiceUtil.getArticle(articleId);

				if (status) {

					if (statusId == 0) {

						statusIds = (List) VcmsStatusLocalServiceUtil.getByG_P(
								groupId, 1);

						if (Validator.isNotNull(statusIds)
								&& statusIds.size() > 0) {
							for (int j = 0; j < statusIds.size(); j++) {
								VcmsStatus vStatus = (VcmsStatus) statusIds
										.get(0);
								article.setStatus(vStatus.getStatusId());

								VcmsArticleStatusLocalServiceUtil
										.addArticleStatus(
												vStatus.getStatusId(),
												articleId, strCatId,
												new Date(), userId, true,
												articleVersionId);
							}
						}
					} else {

						statusIds = (List) VcmsStatusLocalServiceUtil.getByG_P(
								groupId,
								VcmsStatusLocalServiceUtil.getVcmsStatus(
										statusId).getPosition() + 1);

						if (Validator.isNotNull(statusIds)
								&& statusIds.size() > 0) {
							for (int j = 0; j < statusIds.size(); j++) {
								VcmsStatus vStatus = (VcmsStatus) statusIds
										.get(0);
								article.setStatus(vStatus.getStatusId());

								VcmsArticleStatusLocalServiceUtil
										.addArticleStatus(
												vStatus.getStatusId(),
												articleId, strCatId,
												new Date(), userId, true,
												articleVersionId);

								if (vStatus.getActive()) { // Article Published
									article.setPublishedByUser(userId);
									article.setPublishedDate(new Date());
								} else {
									article.setModifiedByUser(userId);
									article.setModifiedDate(new Date());
								}
							}
						}
					}

				} else {

					if (statusId != 0) {

						if (VcmsStatusLocalServiceUtil.getVcmsStatus(statusId)
								.getActive()) {

							article.setSticky(false);
							article.setStickyExpireDate(null);
							article.setStickyNeverExpired(false);
							article.setEffectiveDate(null);
							article.setExpireDate(null);

							// Remove all relations
							VcmsPARelationServiceUtil
									.deleteRelationsByArticle(articleId);
							VcmsCARelationServiceUtil
									.deleteRelationsByArticle(articleId);
							VcmsTARelationServiceUtil
									.deleteRelationsByArticle(articleId);

							VcmsArticleTypeLocalServiceUtil
									.deleteRelationByArticleId(articleId);

							article.setPublishedByUser(null);
							article.setPublishedDate(null);
						}

						statusIds = (List) VcmsStatusLocalServiceUtil.getByG_P(
								groupId,
								VcmsStatusLocalServiceUtil.getVcmsStatus(
										statusId).getPosition() - 1);

						if (Validator.isNotNull(statusIds)
								&& statusIds.size() > 0) {
							for (int j = 0; j < statusIds.size(); j++) {
								VcmsStatus vStatus = (VcmsStatus) statusIds
										.get(0);
								article.setStatus(vStatus.getStatusId());

								VcmsArticleStatusLocalServiceUtil
										.addArticleStatus(
												vStatus.getStatusId(),
												articleId, strCatId,
												new Date(), userId, false,
												articleVersionId);

								if (vStatus.getActive()) {

									// Reset sticky attribute

								} else {
									article.setModifiedByUser(userId);
									article.setModifiedDate(new Date());
								}
							}
						} else { // change status Article -> draft

							VcmsArticleStatusLocalServiceUtil.addArticleStatus(
									0, articleId, strCatId, new Date(), userId,
									false, articleVersionId);

							article.setStatus(0);
							article.setModifiedByUser(userId);
							article.setModifiedDate(new Date());
						}
					}
				}
				// Attached message if available
				if (Validator.isNotNull(message)) {
					VcmsAttachedMessageServiceUtil.addMessage(groupId,
							articleId, message, false);
				}

				VcmsArticleServiceUtil.updateArticle(article,uploadReq);
			}
		}
	}
	
	//xuat ban
	public void publishArticle(ActionRequest req, ActionResponse res)
			throws Exception {
		UploadPortletRequest uploadReq = null;//PortalUtil.getUploadPortletRequest(req);
		
		boolean publish =ParamUtil.getBoolean(req, "publish", true);
		String userId = req.getRemoteUser();

		//String articleId = ParamUtil.get(req, "articleId", StringPool.BLANK);

		long groupId = ParamUtil.getLong(req, "groupId");
		long companyId = PortalUtil.getCompanyId(req);
		String categoryId = ParamUtil.getString(req, "categoryId");

		long articleVersionId = ParamUtil.getLong(req, "articleVersionId");
		
		
		
		/*if (Validator.isNull(articleId)) {
			return;
		}*/
		String[] articleIds = StringUtil.split(ParamUtil.get(req, "articleIds",
				StringPool.BLANK));
		if ((articleIds == null) || (articleIds.length <= 0)) {
			return;
		}
		
		VcmsArticle article = null;
		
		if (Validator.isNotNull(articleIds) && articleIds.length > 0) {
			for (int k = 0; k < articleIds.length; k++) {
				String articleId = articleIds[k];
				
				article = VcmsArticleServiceUtil.getArticle(articleId);
				
				if (publish) {
					// Update relations
					boolean sticky = Validator.isNotNull(ParamUtil.getString(req,
							"sticky", StringPool.BLANK));
					boolean stickyNeverExpired = Validator.isNotNull(ParamUtil
							.getString(req, "stickyNeverExpired", StringPool.BLANK));
					boolean selectPublishedDate = ParamUtil.getBoolean(req,
							"selectPublishedDate", false);

					boolean selectEffective = ParamUtil.getBoolean(req,
							"selectEffective", false);

					boolean selectExpire = ParamUtil.getBoolean(req, "selectExpire",
							false);

					int sedDay = ParamUtil.getInteger(req, "sedDay");
					int sedMonth = ParamUtil.getInteger(req, "sedMonth");
					int sedYear = ParamUtil.getInteger(req, "sedYear");

					int publishedDay = ParamUtil.getInteger(req, "publishedDay");
					int publishedMonth = ParamUtil.getInteger(req, "publishedMonth");
					int publishedYear = ParamUtil.getInteger(req, "publishedYear");

					int effectiveDay = ParamUtil.getInteger(req, "effectiveDay");
					int effectiveMonth = ParamUtil.getInteger(req, "effectiveMonth");
					int effectiveYear = ParamUtil.getInteger(req, "effectiveYear");

					int expireDay = ParamUtil.getInteger(req, "expireDay");
					int expireMonth = ParamUtil.getInteger(req, "expireMonth");
					int expireYear = ParamUtil.getInteger(req, "expireYear");

					boolean discussible = Validator.isNotNull(ParamUtil.getString(req,
							"discussible"));

					String[] portions = StringUtil.split(ParamUtil.getString(req,
							"portions", StringPool.BLANK), StringPool.COMMA);
					String[] categories = StringUtil.split(ParamUtil.getString(req,
							"categories", StringPool.BLANK), StringPool.COMMA);
					String[] threads = StringUtil.split(ParamUtil.getString(req,
							"threads", StringPool.BLANK), StringPool.COMMA);
					String[] websites = StringUtil.split(ParamUtil.getString(req,
							"websites", StringPool.BLANK), StringPool.COMMA);

					String[] typeIds = req.getParameterValues("typeIds");

					String attachedMessage = ParamUtil
							.getString(req, "attachedMessage");

					String[] communityPermissions = req
							.getParameterValues("communityPermissions");

					String[] guestPermissions = req
							.getParameterValues("guestPermissions");

					if (((portions == null) || (portions.length <= 0))
							&& ((categories == null) || (categories.length <= 0))) {

						throw new InvalidArticleRelationException();
					}

					VcmsStatus vStatus = VcmsStatusLocalServiceUtil.getByC_G_A(
							companyId, groupId, true);

					VcmsPARelationServiceUtil.deleteRelationsByArticle(articleId);
					VcmsCARelationServiceUtil.deleteRelationsByArticle(articleId);
					VcmsTARelationServiceUtil.deleteRelationsByArticle(articleId);
					VcmsArticleTypeLocalServiceUtil
							.deleteRelationByArticleId(articleId);

					// Update relations
					for (int i = 0; (portions != null) && (i < portions.length); i++) {
						VcmsPARelationServiceUtil.addRelation(portions[i], articleId);
					}

					for (int i = 0; (categories != null) && (i < categories.length); i++) {
						VcmsCARelationServiceUtil.addRelation(categories[i], articleId,
								vStatus.getStatusId());
					}

					for (int i = 0; (threads != null) && (i < threads.length); i++) {
						VcmsTARelationServiceUtil.addRelation(threads[i], articleId);
					}

					for (int i = 0; (typeIds != null) && (i < typeIds.length); i++) {

						VcmsArticleTypeLocalServiceUtil.addArticleType(articleId, Long
								.parseLong(typeIds[i]), 0);
					}

					// Send request to other websites' general editors
					ThemeDisplay themeDisplay = (ThemeDisplay) req
							.getAttribute(WebKeys.THEME_DISPLAY);

					Layout layout = themeDisplay.getLayout();

					if ((websites != null) && (websites.length > 0)) {
						for (int i = 0; i < websites.length; i++) {

							VcmsArticle anotherArticle = VcmsArticleServiceUtil
									.addArticle(req,uploadReq, groupId, companyId, layout
											.getPlid(), article.getTitle(), article
											.getLead(), article.getContent(), article
											.getHasImage(), article.getImageTitle(),
											article.getImage(), article.getLanguage(),
											false, article.getHasPoll(), article
													.getPollId(), article.getStatus(),
											article.getAuthor(), article.getSource(),
											communityPermissions, guestPermissions);

							// Update status, images when the article is cloned
							anotherArticle
									.setStatus(VcmsArticleServiceImpl.PUBLISH_PENDING);

							if (anotherArticle.getHasImage()) {
								ImageUtilExt.saveOriginalImage(Long
										.parseLong(WebKeysExt.VCMS_ARTICLE_IMAGE_KEY
												+ anotherArticle.getArticleId()),
										ImageLocalServiceUtil.getImage(
												Long.parseLong(article.getImage()))
												.getTextObj());

								ImageUtilExt
										.saveOriginalImage(
												Long
														.parseLong(WebKeysExt.VCMS_ARTICLE_SMALL_IMAGE_KEY
																+ anotherArticle
																		.getArticleId()),
												ImageLocalServiceUtil
														.getImage(
																Long
																		.parseLong(WebKeysExt.VCMS_ARTICLE_SMALL_IMAGE_KEY
																				+ article
																						.getArticleId()))
														.getTextObj());
							}

							// Attached messages
							if (Validator.isNotNull(attachedMessage)) {
								VcmsAttachedMessageServiceUtil.addMessage(groupId,
										anotherArticle.getArticleId(), attachedMessage,
										false);
							}
						}
					}

					// Update article status
					article.setStatus(vStatus.getStatusId());
					article.setPublishedByUser(userId);

					VcmsArticleStatusLocalServiceUtil.addArticleStatus(vStatus
							.getStatusId(), article.getArticleId(), categoryId,
							new Date(), userId, true, articleVersionId);

					if (selectPublishedDate) {
						article.setPublishedDate(new GregorianCalendar(publishedYear,
								publishedMonth, publishedDay).getTime());
					} else {
						article.setPublishedDate(new Date());
					}

					article.setSticky(sticky);

					if (sticky) {
						if (stickyNeverExpired) {
							article.setStickyNeverExpired(true);
							article.setStickyExpireDate(null);
						} else {
							article.setStickyNeverExpired(false);
							article.setStickyExpireDate(new GregorianCalendar(sedYear,
									sedMonth, sedDay).getTime());
						}
					}

					if (selectEffective) {
						article.setEffectiveDate(new GregorianCalendar(effectiveYear,
								effectiveMonth, effectiveDay).getTime());
					} else {
						article.setEffectiveDate(null);
					}

					if (selectExpire) {
						article.setExpireDate(new GregorianCalendar(expireYear,
								expireMonth, expireDay).getTime());
					} else {
						article.setExpireDate(null);
					}

					article.setDiscussible(discussible);

					// All attached messages will be removed upon publish
					VcmsAttachedMessageServiceUtil.deleteMessages(articleId);

				} else {
					String attachedMessage = ParamUtil
							.getString(req, "attachedMessage");

					List statusIds = new ArrayList();
					
					long currentPosition = 1;
					VcmsStatus currentStatus = VcmsStatusLocalServiceUtil.getVcmsStatus(article.getStatus());
					if(currentStatus != null) 
						currentPosition = currentStatus.getPosition() -1;

					statusIds = (List) VcmsStatusLocalServiceUtil.getByG_P(groupId, currentPosition);

					if (Validator.isNotNull(statusIds) && statusIds.size() > 0) {
						VcmsStatus vStatus = (VcmsStatus) statusIds.get(0);
						article.setStatus(vStatus.getStatusId());

						VcmsArticleStatusLocalServiceUtil.addArticleStatus(vStatus
								.getStatusId(), article.getArticleId(), categoryId,
								new Date(), userId, false, articleVersionId);

						if (vStatus.getActive()) {
							article.setPublishedByUser(null);
							article.setPublishedDate(null);
						} else {
							article.setModifiedByUser(userId);
							article.setModifiedDate(new Date());
						}
					} else {
						article.setStatus(VcmsArticleServiceImpl.DRAFT_STATE);
						article.setModifiedByUser(userId);
						article.setModifiedDate(new Date());
					}

					// Reset sticky attribute
					article.setSticky(false);
					article.setStickyExpireDate(null);
					article.setStickyNeverExpired(false);
					article.setEffectiveDate(null);
					article.setExpireDate(null);

					/*// Remove all relations
					VcmsPARelationServiceUtil.deleteRelationsByArticle(articleId);
					VcmsCARelationServiceUtil.deleteRelationsByArticle(articleId);
					VcmsTARelationServiceUtil.deleteRelationsByArticle(articleId);
					VcmsArticleTypeLocalServiceUtil.deleteRelationByArticleId(articleId);*/

					if (Validator.isNotNull(attachedMessage)) {
						VcmsAttachedMessageServiceUtil.addMessage(groupId, articleId,
								attachedMessage, false);
					}
				}

				VcmsArticleServiceUtil.updateArticle(article, uploadReq);
			}
		}

		

	}
	//xuat ban
	public void updateCategoryPosition(ActionRequest req,ActionResponse res) throws Exception {

		String categoryId = null;
		int newPosition = 0;
		String compoundParam = ParamUtil.getString(req, "position");

		if (Validator.isNotNull(compoundParam)
				&& (compoundParam.indexOf("|") > 0)) {
			String[] cpIds = StringUtil.split(compoundParam, "|");

			newPosition = Integer.parseInt(cpIds[0]);
			categoryId = cpIds[1];
		}

		if (Validator.isNull(categoryId)) {
			return;
		}

		VcmsCategory category = VcmsCategoryServiceUtil.getCategory(categoryId);

		if (category != null) {
			// Reoder position the categories
			ThemeDisplay themeDisplay = (ThemeDisplay) req
					.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = PortalUtil.getScopeGroupId(req);
			String language = themeDisplay.getLanguageId();

			String parentId = category.getParentId();
			List categoriesList = VcmsCategoryServiceUtil
					.getCategoriesByParent(groupId, parentId, language);
			int count = VcmsCategoryServiceUtil.countCategoriesByParent(
					groupId, parentId, language);
			long oldPosition = category.getPosition();

			// System.out.println("--------> Count = " + count);
			// System.out.println("--------> oldPosition = " + oldPosition);
			// System.out.println("--------> newPosition = " + newPosition);
			// System.out.println("--------> categoryId = " + categoryId);
			// for (int i = 0; i < categoriesList.size(); i++) {
			// VcmsCategory cate = (VcmsCategory) categoriesList.get(i);
			// System.out.println("Category [" + i + "] --- " +
			// cate.getCategoryId() + cate.getName() + "----position = " +
			// String.valueOf(cate.getPosition()));
			// }

			long updatePosition = 0;

			if (newPosition < oldPosition && oldPosition > 1) {
				for (int i = (newPosition - 1); i < (oldPosition - 1); i++) {
					VcmsCategory cate = (VcmsCategory) categoriesList.get(i);
					if (!(cate.getCategoryId().equals(categoryId))) {
						updatePosition = cate.getPosition() + 1;
						if (updatePosition > count) {
							updatePosition = count;
						}
					}
					cate.setPosition(updatePosition);
					VcmsCategoryServiceUtil.updateCategory(cate);
				}
			} else if (newPosition > oldPosition && oldPosition < count) {
				for (int i = (int)oldPosition; i < newPosition; i++) {
					VcmsCategory cate = (VcmsCategory) categoriesList.get(i);
					if (!(cate.getCategoryId().equals(categoryId))) {
						updatePosition = cate.getPosition() - 1;
						if (updatePosition < 1) {
							updatePosition = 1;
						}
					}
					cate.setPosition(updatePosition);
					VcmsCategoryServiceUtil.updateCategory(cate);
				}
			}
			// Set new position
			category.setPosition(newPosition);
			VcmsCategoryServiceUtil.updateCategory(category);
		}
	}
	
	//Thread
	public void updateThread(ActionRequest req,ActionResponse res) throws Exception {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		// Primary key
		String threadId = ParamUtil.get(uploadReq, "threadId", StringPool.BLANK);

		// Other fields
		String title = ParamUtil.get(uploadReq, "title", StringPool.BLANK);
		String description = ParamUtil
				.get(uploadReq, "description", StringPool.BLANK);
		String language = ParamUtil.get(uploadReq, "language", StringPool.BLANK);

		long groupId = ParamUtil.getLong(uploadReq, "groupId");
		long companyId = PortalUtil.getCompanyId(req);

		String image = ParamUtil.get(uploadReq, "image", StringPool.BLANK);

		String[] communityPermissions = uploadReq
				.getParameterValues("communityPermissions");

		String[] guestPermissions = uploadReq.getParameterValues("guestPermissions");

		VcmsThread thread = null;

		ThemeDisplay themeDisplay = (ThemeDisplay) uploadReq
				.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		if (Validator.isNull(threadId)) {
			thread = VcmsThreadServiceUtil.addThread(groupId, companyId, layout
					.getPlid(), title, description, false, null, language,
					communityPermissions, guestPermissions);
		} else {
			thread = VcmsThreadServiceUtil.getThread(threadId);
			thread = VcmsThreadServiceUtil.updateThread(threadId, groupId,
					companyId, title, description, thread.getHasImage(), thread
							.getImage(), language);
		}

		// Image...

		if ((thread != null) && Validator.isNotNull(image)) {
			/*UploadPortletRequest uploadReq = PortalUtil
					.getUploadPortletRequest(req);
*/
			// Validate the image input

			String contentType = uploadReq.getContentType("image");
			if (ImageUtilExt.isImage(contentType)) {

				String imageKey = thread.getThreadId();
				File fileImage = uploadReq.getFile("image");
				if (fileImage != null) {
					byte[] photoBytes = FileUtil.getBytes(fileImage);
					ImageUtilExt.saveOriginalImage(Long.parseLong(imageKey),
							photoBytes);
				}

				// Update the category when the image is saved
				thread.setHasImage(true);
				thread.setImage(imageKey);

				VcmsThreadServiceUtil.updateThread(thread);
			}

		}
	}

	public void deleteThread(ActionRequest req,ActionResponse res) throws Exception {
		String[] threadIds = StringUtil.split(ParamUtil.get(req, "threadIds",
				StringPool.BLANK));
		String articleId = ParamUtil.get(req, "articleId", StringPool.BLANK);
		if ((threadIds == null) || (threadIds.length <= 0)) {
			return;
		}

		for (int i = 0; i < threadIds.length; i++) {

			// 1. Remove image if available

			VcmsThread thread = VcmsThreadServiceUtil.getThread(threadIds[i]);

			if (thread.getHasImage()) {
				String imageKey = thread.getImage();

				if (Validator.isNotNull(imageKey)) {
					ImageUtilExt.deleteImage(Long.parseLong(imageKey));
				}
			}
			
			// 2. Remove the thread

			VcmsThreadServiceUtil.deleteThread(threadIds[i]);
		}
	}

	public void listThreadArticles(ActionRequest req,ActionResponse res) throws Exception {
		String threadId = ParamUtil.get(req, "threadId", StringPool.BLANK);
		
		if (Validator.isNull(threadId)) {
			return;
		}

		List relations = VcmsTARelationServiceUtil
				.getRelationsByThread(threadId);

		if ((relations == null) || (relations.size() <= 0)) {
			return;
		}

		List articles = new ArrayList(relations.size());

		for (int i = 0; i < relations.size(); i++) {

			VcmsTARelation relation = (VcmsTARelation) relations.get(i);

			VcmsArticle article = VcmsArticleServiceUtil.getArticle(relation
					.getArticleId());

			articles.add(article);
		}

		req.setAttribute(WebKeysExt.VCMS_ARTICLES, articles);
	}

	public void removeThreadImage(ActionRequest req,ActionResponse res) throws Exception {
		String threadId = ParamUtil.get(req, "threadId", StringPool.BLANK);

		if (Validator.isNull(threadId)) {
			return;
		}

		VcmsThread thread = VcmsThreadServiceUtil.getThread(threadId);

		if (thread == null) {
			return;
		}

		if (thread.getHasImage()) {
			ImageUtilExt.deleteImage(Long.parseLong(thread.getImage()));

			thread.setHasImage(false);
			thread.setImage(null);
			VcmsThreadServiceUtil.updateThread(thread);
		}
	}
	
	//
	public void removeArticlePoll(ActionRequest req,ActionResponse res) throws Exception {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		String articleId = ParamUtil.get(req, "articleId", StringPool.BLANK);

		if (Validator.isNull(articleId)) {
			return;
		}

		VcmsArticle article = VcmsArticleServiceUtil.getArticle(articleId);

		article.setHasPoll(false);
		article.setPollId(null);

		VcmsArticleServiceUtil.updateArticle(article,uploadReq);
		
		res.setRenderParameter("articleId", articleId);
		res.setRenderParameter("jspPage","/html/portlet/vcms/articles/edit_article.jsp");
	}

	public void removeThread(ActionRequest req,ActionResponse res) throws Exception {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		String articleId = ParamUtil.get(uploadReq, "articleId", StringPool.BLANK);
		
		if (Validator.isNull(articleId)) {
			return;
		}

		VcmsTARelationServiceUtil.deleteRelationsByArticle(articleId);
		res.setRenderParameter("articleId", articleId);
		res.setRenderParameter("jspPage","/html/portlet/vcms/articles/edit_article.jsp");
	}
	
	public void viewArticleVersion(ActionRequest req,ActionResponse res) throws Exception {

		String articleId = ParamUtil.get(req, "articleId", StringPool.BLANK);

		if (Validator.isNull(articleId)) {
			return;
		}

		List articleVersionList = VcmsArticleVersionServiceUtil
				.listVersionByArticleId(articleId);
		req.setAttribute("articleVersionList", articleVersionList);
	}

	public void restoreArticleVersion(ActionRequest req,ActionResponse res) throws Exception {

		long articleVersionId = ParamUtil.getLong(req, "articleVersionId");
		VcmsArticleServiceUtil.restoreArticleVersion(articleVersionId);
	}
	
	
	public void deleteLogs(ActionRequest req,ActionResponse res) throws Exception{
		String[] loggerIds = StringUtil.split(ParamUtil.getString(req,
				"loggerIds", StringPool.BLANK));
		try {
			for (int i = 0; i < loggerIds.length; i++) {
				VcmsLoggerServiceUtil.removeLog(loggerIds[i]);
			}
			
			sendRedirect(req, res);
			
		} catch (Exception ex) {
			if (ex instanceof NoSuchVcmsLoggerException){
				ex.printStackTrace();
			} else {
				throw ex;
			}
		}

	}
	
	public void exportToExcel(ActionRequest request, ActionResponse response) throws IOException{		
		int exportType = ParamUtil.getInteger(request, "exportType");
		int fromDay = ParamUtil.getInteger(request, "fromDay");
		int fromMonth = ParamUtil.getInteger(request, "fromMonth");
		int fromYear = ParamUtil.getInteger(request, "fromYear");

		int toDay = ParamUtil.getInteger(request, "toDay");
		int toMonth = ParamUtil.getInteger(request, "toMonth");
		int toYear = ParamUtil.getInteger(request, "toYear");
		
		long groupId = ParamUtil.getLong(request, "groupId");
		String byUser = ParamUtil.getString(request, "byUser");

		Date dateFrom = new GregorianCalendar(fromYear, fromMonth, fromDay)
				.getTime();
		Date dateTo = new GregorianCalendar(toYear, toMonth, toDay).getTime();

		String language = ParamUtil.getString(request, "language");
		String parentId = ParamUtil.getString(request, "parentId");
		
		long statusId = ParamUtil.getLong(request, "statusId");
		long typeId = ParamUtil.getLong(request, "byType");
		
		int begin = ParamUtil.getInteger(request, "begin");
		int end = ParamUtil.getInteger(request, "end");			

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long companyId = layout.getCompanyId();
		String porttalDir = PortalUtil.getPortalWebDir();
	
		if (exportType ==1 ) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(porttalDir.substring(0, porttalDir.indexOf("ROOT")) 
						+ "//VCMS-portlet//html//portlet//vcms//report//file//reportUserTemplate.xls");
				/*fis = new FileInputStream("/VCMS-portlet/html/portlet/vcms/report/file/reportUserTemplate.xls");*/

				POIFSFileSystem fs = new POIFSFileSystem(fis);
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				HSSFSheet sheet = wb.getSheetAt(0);
				//ham cu
//				int totalUser = UserLocalServiceUtil.searchCount(companyId,
//						null, true, null);
				//ham moi
				int totalUser = UserLocalServiceUtil.searchCount(companyId,
						null, 0, null);
				
				
				OrderByComparator compare = null;
				
				//ham cu
//				List userList = UserLocalServiceUtil.search(companyId, null,
//						true, null, 0, totalUser, compare);
				
				//ham moi
				List userList =UserLocalServiceUtil.search(companyId, null, 0, null, 0, totalUser, compare);
				
			

				setUserReport(userList, 7, 0, sheet, wb, groupId, language,
						parentId,statusId, dateFrom, dateTo);
				String strDir = "//VCMS-portlet//html//portlet//vcms//report//file//reportUser.xls";
				getFile(PortalUtil.getHttpServletRequest(request),PortalUtil.getHttpServletResponse(response), strDir,1);

			} catch (Exception ex) {
				ex.toString();
			} finally {
				fis.close();
			}
			
		} else if (exportType ==2) {

			FileInputStream fis = null;
			try {
				fis = new FileInputStream(porttalDir.substring(0, porttalDir.indexOf("ROOT")) 
								+ "//VCMS-portlet//html//portlet//vcms//report//file//reportCategoryTemplate.xls");

				POIFSFileSystem fs = new POIFSFileSystem(fis);
				HSSFWorkbook wb = new HSSFWorkbook(fs);				
				HSSFSheet sheet = wb.getSheetAt(0);
				List portionResults = VcmsPortionServiceUtil.getPortionsByS_L(
						groupId, language);

				setCategoryReport(portionResults, 7 ,0, sheet, wb, groupId,
						language, parentId, dateFrom, dateTo, byUser);

				String strDir = "//VCMS-portlet//html//portlet//vcms//report//file//reportCategory.xls";
				getFile(PortalUtil.getHttpServletRequest(request),PortalUtil.getHttpServletResponse(response), strDir,2);
			} catch (Exception ex) {
				ex.toString();
			} finally {
				fis.close();
			}
		} else if (exportType == 3) {
			String[] strType = null;
			String strTypeIds = ParamUtil.getString(request, "typeIds");
			if(strTypeIds.length()>0){
				strType = strTypeIds.split(",");
			}
			
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(porttalDir.substring(0, porttalDir.indexOf("ROOT")) 
						+ "//VCMS-portlet//html//portlet//vcms//report//file//reportByDateTemplate.xls");

				POIFSFileSystem fs = new POIFSFileSystem(fis);
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				// wb.createSheet();
				HSSFSheet sheet = wb.getSheetAt(0);

				setReportByDate(7, 0, sheet, wb, groupId, language, statusId,
						dateFrom, dateTo, byUser, strType, begin, end);
				String strDir = "//VCMS-portlet//html//portlet//vcms//report//file//reportByDate.xls";
				getFile(PortalUtil.getHttpServletRequest(request),PortalUtil.getHttpServletResponse(response), strDir,3);
			} catch (Exception ex) {
				ex.toString();
			} finally {
				fis.close();
			}

		}
		else if(exportType == 4){
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(porttalDir.substring(0, porttalDir.indexOf("ROOT")) 
						+ "//VCMS-portlet//html//portlet//vcms//report//file//reportByTypeTemplate.xls");

				POIFSFileSystem fs = new POIFSFileSystem(fis);
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				// wb.createSheet();
				HSSFSheet sheet = wb.getSheetAt(0);

				setReportByType(7, 0, sheet, wb, groupId, language, statusId, dateFrom, dateTo, byUser);
				String strDir = "//VCMS-portlet//html//portlet//vcms//report//file//reportByType.xls";
				getFile(PortalUtil.getHttpServletRequest(request),PortalUtil.getHttpServletResponse(response), strDir,4);
			} catch (Exception ex) {
				ex.toString();
			} finally {
				fis.close();
			}
		}
	}
	
	public void setReportByType(int y, int x, HSSFSheet sheet,
			HSSFWorkbook wb, long groupId, String language, long statusId,
			Date fromDate, Date toDate, String byUser)
			throws Exception {
		
		HSSFRow row;	
		y=y-3;
		
		List listType = VcmsTypeServiceUtil.getTypesByS_L(groupId, language);
		sheet.shiftRows(y, sheet.getLastRowNum(), 1);

		//date
		row = sheet.createRow(y - 2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),
				" T\u1eeb ng\u00e0y " + ActionUtil.dateParser(fromDate)
						+ " \u0111\u1ebfn ng\u00e0y "
						+ ActionUtil.dateParser(toDate), wb);
		
		row = sheet.createRow(y);

		ReportUtil.createCellBold(row, (short) (x), "S\u1ed1 TT", wb);
		ReportUtil.createCellBold(row, (short) (x + 1), "Lo\u1ea1i tin", wb);
		ReportUtil.createCellBold(row, (short) (x + 2), "T\u00e1c ph\u1ea9m", wb);		
		
		int totalArticle = 0;
		int stt = 0;		
		for (int j = 0; j < listType.size(); j++) {			
			VcmsType vcmsType = (VcmsType) listType.get(j);
			sheet.shiftRows(y + 1, sheet.getLastRowNum(), 1);
			row = sheet.createRow(1 + y++);
			
			int total = VcmsArticleServiceUtil.countByType(groupId, language,
					statusId, Long.valueOf(vcmsType.getTypeId()), fromDate, toDate, byUser);
			totalArticle += total;
			
			if (vcmsType.getTypeId() != null) {
				ReportUtil.createCell(row, (short) (x), ++stt, wb);
				ReportUtil.createCellAlignLeft(row, (short) (x + 1), ""
						+ vcmsType.getName() + "", wb);
				ReportUtil.createCell(row, (short) (x + 2), total, wb);
			}

		}
		//total count
		row = sheet.createRow(y+2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),"T\u1ed5ng s\u1ed1 b\u00e0i vi\u1ebft", wb);		
		ReportUtil.createCellNoBorder(row, (short) (x + 2), String.valueOf(totalArticle), wb);
		
		FileOutputStream fileOut = null;		
		try {			
			fileOut = new FileOutputStream(PortalUtil.getPortalWebDir().substring(0, PortalUtil.getPortalWebDir().lastIndexOf("/ROOT"))
					+ "//VCMS-portlet//html//portlet//vcms//report//file//reportByType.xls");
			wb.write(fileOut);			
		
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			fileOut.flush();
			fileOut.close();
		}		
	}
	public void setCategoryReport(List portionResults, int y, int x,
			HSSFSheet sheet, HSSFWorkbook wb, long groupId, String language,
			String parentId, Date dateFrom, Date dateTo, String byUser)
			throws Exception {
		int totalStatus = VcmsStatusLocalServiceUtil.countByGroupId(groupId);
		List statusResults = VcmsStatusLocalServiceUtil.getByGroupId(groupId,
				0, totalStatus);

		HSSFRow row;
		HSSFCell cell;
		User userBean;
		y=y-3;

		sheet.shiftRows(y, sheet.getLastRowNum(), 1);
		
		row = sheet.createRow(y - 2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),
				" T\u1eeb ng\u00e0y " + ActionUtil.dateParser(dateFrom)
						+ " \u0111\u1ebfn ng\u00e0y "
						+ ActionUtil.dateParser(dateTo), wb);
		
		row = sheet.createRow(y);
		ReportUtil.createCellBold(row, (short) (x), "S\u1ed1 TT", wb);
		ReportUtil.createCellBold(row, (short) (x + 1), "Chuy\u00ean m\u1ee5c", wb);
		
		for (int j = 0; j < totalStatus; j++) {
			VcmsStatus vcmsStatus = (VcmsStatus) statusResults.get(j);
			ReportUtil.createCellBold(row, (short) (x + 2 + j), "" + vcmsStatus.getName() + "", wb);
		}

		int stt = 0;
		int totalArticle=0;
		for (int i = portionResults.size() - 1; i >= 0; --i) {
			VcmsPortion vcmsPortion = (VcmsPortion) portionResults.get(i);
			List categoryByPortion = ActionUtil.getListCategoryReport(groupId,
					vcmsPortion.getPortionId(), parentId, language);

			for (int j = 0; j < categoryByPortion.size(); j++) {
				VcmsCategory vcmsCategory = (VcmsCategory) categoryByPortion
						.get(j);
				sheet.shiftRows(y + 1, sheet.getLastRowNum(), 1);
				row = sheet.createRow(1 + y++);

				if (vcmsCategory.getName() != null) {
					ReportUtil.createCell(row, (short) (x), ++stt, wb);
				}
				if (vcmsCategory.getName() != null) {
					ReportUtil.createCellAlignLeft(row, (short) (x + 1), ""
							+ vcmsCategory.getName() + "", wb);
				}
				for (int k = 0; k < totalStatus; k++) {
					int countArticles = 0;
					VcmsStatus status = (VcmsStatus) statusResults.get(k);
					
					countArticles = VcmsArticleServiceUtil.countByC_P_L_S_D(
							vcmsCategory.getCategoryId(), groupId, language,
							status.getStatusId(), dateFrom, dateTo, byUser);					
					totalArticle += countArticles;
					
					ReportUtil.createCell(row, (short) (x + 2 + k), countArticles, wb);
				}
			}

		}
		
		row = sheet.createRow(y+2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),"T\u1ed5ng s\u1ed1 b\u00e0i vi\u1ebft", wb);		
		ReportUtil.createCellNoBorder(row, (short) (x + 2), String.valueOf(totalArticle), wb);
		
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(PortalUtil.getPortalWebDir().substring(0, PortalUtil.getPortalWebDir().lastIndexOf("/ROOT")) 
					+ "//VCMS-portlet//html//portlet//vcms//report//file//reportCategory.xls");
			wb.write(fileOut);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			fileOut.flush();
			fileOut.close();
		}
	}

	public void setReportByDate(int y, int x, HSSFSheet sheet,
			HSSFWorkbook wb, long groupId, String language, long statusId,
			Date dateFrom, Date dateTo, String byUser, String[] strType, int begin, int end)
			throws Exception {
		
		List listNews = new ArrayList();		
					
		listNews = VcmsArticleServiceUtil.listArticleByDateTypes(groupId,
				language, statusId, dateFrom, dateTo, byUser, strType, begin, end);		
		
		HSSFRow row;
		HSSFCell cell;
		User userBean;
		y=y-3;
		
		VcmsStatus vcmsStatus = VcmsStatusLocalServiceUtil
				.getVcmsStatus(statusId);
		
		sheet.shiftRows(y, sheet.getLastRowNum(), 1);		
		row = sheet.createRow(y - 2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),
				" T\u1eeb ng\u00e0y " + ActionUtil.dateParser(dateFrom)
						+ " \u0111\u1ebfn ng\u00e0y "
						+ ActionUtil.dateParser(dateTo), wb);	
		
		row = sheet.createRow(y);

		ReportUtil.createCellBold(row, (short) (x), "S\u1ed1 TT", wb);
		ReportUtil.createCellBold(row, (short) (x + 1), "Ti\u00eau \u0111\u1ec1", wb);
		ReportUtil.createCellBold(row, (short) (x + 2), "Ng\u00e0y \u0111\u0103ng", wb);
		ReportUtil.createCellBold(row, (short) (x + 3), "Ng\u01b0\u1eddi t\u1ea1o", wb);
		ReportUtil.createCellBold(row, (short) (x + 4), "Ng\u01b0\u1eddi duy\u1ec7t", wb);
		ReportUtil.createCellBold(row, (short) (x + 5), "Ng\u01b0\u1eddi xu\u1ea5t b\u1ea3n", wb);
		ReportUtil.createCellBold(row, (short) (x + 6), "Lo\u1ea1i tin", wb);
				
		int stt = 0;
		for (int j = 0; j < listNews.size(); j++) {
			VcmsArticle vcmsAr = (VcmsArticle) listNews.get(j);
			
			String typeNames ="";
			try{
				typeNames += ReportUtil.getTypeNames(vcmsAr.getArticleId());	
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			sheet.shiftRows(y + 1, sheet.getLastRowNum(), 1);
			row = sheet.createRow(1 + y++);

			if (vcmsAr != null) {
				ReportUtil.createCell(row, (short) (x), ++stt, wb);
				ReportUtil.createCellAlignLeft(row, (short) (x + 1), ""
						+ vcmsAr.getTitle() + "", wb);
				ReportUtil.createCell(row, (short) (x + 2), ActionUtil.dateParser(vcmsAr.getPublishedDate()), wb);
				
				try{
					User userCreate = UserServiceUtil.getUserById(Long.parseLong(vcmsAr
							.getCreatedByUser()));
					ReportUtil.createCellAlignLeft(row, (short) (x + 3), userCreate.getFullName(), wb);
				}catch(Exception ex){
					ReportUtil.createCellAlignLeft(row, (short) (x + 3), "User \u0111\u00e3 b\u1ecb x\u00f3a", wb);
				}
				
				try{
					User modifieddUser = UserServiceUtil.getUserById(Long.parseLong(vcmsAr
							.getModifiedByUser()));
					ReportUtil.createCellAlignLeft(row, (short) (x + 4), modifieddUser.getFullName(), wb);
				}catch(Exception ex){
					ReportUtil.createCellAlignLeft(row, (short) (x + 4), "User \u0111\u00e3 b\u1ecb x\u00f3a", wb);
				}
				
				try{
					User publishedUser = UserServiceUtil.getUserById(Long.parseLong(vcmsAr.getPublishedByUser()));
					ReportUtil.createCellAlignLeft(row, (short) (x + 5), publishedUser.getFullName(), wb);
				}catch(Exception ex){
					ReportUtil.createCellAlignLeft(row, (short) (x + 5), "User \u0111\u00e3 b\u1ecb x\u00f3a", wb);
				}
				
				ReportUtil.createCellAlignLeft(row, (short) (x + 6), typeNames, wb);
			}

		}
		
		row = sheet.createRow(y+2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),"T\u1ed5ng s\u1ed1 b\u00e0i vi\u1ebft", wb);		
		ReportUtil.createCellNoBorder(row, (short) (x + 2), String.valueOf(listNews.size()), wb);
		
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(PortalUtil.getPortalWebDir().substring(0, PortalUtil.getPortalWebDir().lastIndexOf("/ROOT"))
					+ "//VCMS-portlet//html//portlet//vcms//report//file//reportByDate.xls");
			wb.write(fileOut);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			fileOut.flush();
			fileOut.close();
		}
	}

	public void setUserReport(List userList, int y, int x, HSSFSheet sheet,
			HSSFWorkbook wb, long groupId, String language, String parentId,
			long statusId, Date dateFrom, Date dateTo) throws Exception {

		List listType = VcmsTypeServiceUtil.getTypesByS_L(groupId, language);

		HSSFRow row;
		User userBean;
		y=y-3;
		sheet.shiftRows(y, sheet.getLastRowNum(), 1);

		row = sheet.createRow(y - 2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),
				" T\u1eeb ng\u00e0y " + ActionUtil.dateParser(dateFrom)
						+ " \u0111\u1ebfn ng\u00e0y "
						+ ActionUtil.dateParser(dateTo), wb);

		row = sheet.createRow(y);
		ReportUtil.createCellBold(row, (short) (x), "S\u1ed1 TT", wb);
		ReportUtil.createCellBold(row, (short) (x + 1), "H\u1ecd T\u00ean", wb);

		for (int j = 0; j < listType.size(); j++) {
			VcmsType vcmsType = (VcmsType) listType.get(j);
			ReportUtil.createCellBold(row, (short) (x + 2 + j), ""
					+ vcmsType.getName() + "", wb);
		}
		ReportUtil.createCellBold(row, (short) (x + 2 + listType.size()),
				"C\u00e1c lo\u1ea1i tin kh\u00e1c", wb);
		
		int stt = 0;
		int totalArticle = 0;

		for (int i = userList.size() - 1; i >= 0; --i) {
			userBean = (User) userList.get(i);
			sheet.shiftRows(y + 1, sheet.getLastRowNum(), 1);
			row = sheet.createRow(1 + y++);

			if (userBean != null) {
				ReportUtil.createCell(row, (short) (x), ++stt, wb);
			}
			if (userBean != null) {
				ReportUtil.createCellAlignLeft(row, (short) (x + 1), ""
						+ userBean.getFullName() + "", wb);
			}
			
			for (int j = 0; j < listType.size(); j++) {
				VcmsType vcmsType = (VcmsType) listType.get(j);
				int countArticle = 0;
				if (!parentId.equals("0")) {
					countArticle = VcmsArticleServiceUtil.countByUser(groupId,
							language, parentId, statusId, Long.valueOf(vcmsType
									.getTypeId()), dateFrom, dateTo, String
									.valueOf(userBean.getUserId()));
				} else {

					countArticle = VcmsArticleServiceUtil.countByType(groupId,
							language, statusId, Long.valueOf(vcmsType
									.getTypeId()), dateFrom, dateTo, String
									.valueOf(userBean.getUserId()));
				}
				
				ReportUtil.createCell(row, (short) (x + 2 + j), countArticle,
						wb);
				totalArticle += countArticle;
			}

			//other type
			int countArticleAllCatNotInType =0;
			if (!parentId.equals("0")) {
				countArticleAllCatNotInType = VcmsArticleServiceUtil
						.countArticleNotInType(groupId, language, parentId,
								statusId, dateFrom, dateTo, String.valueOf(userBean.getUserId()));
			} else {
				countArticleAllCatNotInType = VcmsArticleServiceUtil
						.countArticleAllCatNotInType(groupId, language,
								statusId, dateFrom, dateTo, String
										.valueOf(userBean.getUserId()));
			}
			
			ReportUtil.createCell(row, (short) (x + 2 + listType.size()), countArticleAllCatNotInType,wb);
			totalArticle += countArticleAllCatNotInType;
		}
		
		row = sheet.createRow(y+2);
		ReportUtil.createCellNoBorder(row, (short) (x + 1),"T\u1ed5ng s\u1ed1 b\u00e0i vi\u1ebft", wb);		
		ReportUtil.createCellNoBorder(row, (short) (x + 2), String.valueOf(totalArticle), wb);
		
		FileOutputStream fileOut = null;
		try {
			/*fileOut = new FileOutputStream(PortalUtil.getPortalWebDir()
					+ "/VCMS-portlet/html/portlet/vcms/report/file/reportUser.xls");*/
			fileOut = new FileOutputStream(PortalUtil.getPortalWebDir().substring(0, PortalUtil.getPortalWebDir().lastIndexOf("/ROOT")) 
						+ "//VCMS-portlet//html//portlet//vcms//report//file//reportUser.xls");
			wb.write(fileOut);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			fileOut.flush();
			fileOut.close();
		}

	}	

	public void getFile(HttpServletRequest request,HttpServletResponse response, String strDir,int export)
			throws Exception {
		InputStream is = null;
		try {
			is = new FileInputStream(PortalUtil.getPortalWebDir().substring(0,
					PortalUtil.getPortalWebDir().lastIndexOf("ROOT"))
					+ strDir);
			byte[] bytes = IOUtils.toByteArray(is);
			String contentType = MimeTypesUtil.getContentType(PortalUtil
					.getPortalWebDir().substring(0,
							PortalUtil.getPortalWebDir().lastIndexOf("ROOT"))
					+ strDir);
			if (export == 1) {
				ServletResponseUtil.sendFile(request, response,
						"reportUser.xls", bytes, contentType);
			} 
			else if(export == 2){
				ServletResponseUtil.sendFile(request, response,
						"reportCategory.xls", bytes, contentType);				
			}			
			else if(export == 3){
				ServletResponseUtil.sendFile(request, response,
						"reportByDate.xls", bytes, contentType);				
			}			
			else {
				com.liferay.portal.kernel.servlet.ServletResponseUtil.sendFile(request, response,
						"reportByType.xls", bytes, contentType);
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			is.close();
		
		}
	}
}
