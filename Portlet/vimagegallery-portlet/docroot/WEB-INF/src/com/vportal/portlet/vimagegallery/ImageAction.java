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

package com.vportal.portlet.vimagegallery;

import java.io.File;
import java.rmi.RemoteException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portlet.vimagegallery.model.TFCategory;
import com.vportal.portlet.vimagegallery.model.TFImage;
import com.vportal.portlet.vimagegallery.model.impl.TFCategoryImpl;
import com.vportal.portlet.vimagegallery.model.impl.TFImageImpl;
import com.vportal.portlet.vimagegallery.service.TFCategoryServiceUtil;
import com.vportal.portlet.vimagegallery.service.TFImageServiceUtil;
import com.vportal.portlet.vimagegallery.util.PropsKeys;
import com.vportal.portlet.vimagegallery.util.VImagegalleryUtil;
import com.vportal.util.ImageUtilExt;

/**
 * Portlet implementation class ImageAction
 */
public class ImageAction extends MVCPortlet {

	// _updateImage
	public void updateImage(ActionRequest req, ActionResponse res)
			throws Exception {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		long id = ParamUtil.getLong(uploadReq, "id");
		long categoryId = ParamUtil.getLong(uploadReq, "categoryId");
		String name = ParamUtil.getString(uploadReq, "name");
		String description = ParamUtil.getString(uploadReq, "description");
		boolean isShow = ParamUtil.getBoolean(uploadReq, "isShow");
		String image = ParamUtil.getString(req, "image");
		String cmd = ParamUtil.getString(uploadReq, "cmd");
		
		long groupId = ParamUtil.getLong(uploadReq, "groupId");
		long companyId = PortalUtil.getCompanyId(uploadReq);

	String[] communityPermissions = uploadReq
				.getParameterValues("communityPermissions");
		String[] guestPermissions = uploadReq.getParameterValues("guestPermissions");

		ThemeDisplay themeDisplay = (ThemeDisplay) uploadReq
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();

		TFImage tfImage = new TFImageImpl();
		
		if (id <= 0) {
			
			tfImage = TFImageServiceUtil.addImage(groupId, companyId,layout.getPlid(), categoryId, name, description, "",isShow,communityPermissions, guestPermissions);
			checkImage(tfImage, req, res,uploadReq);
		} else {

			tfImage = TFImageServiceUtil.getImage(id);
			
			if (cmd.equals("remove_image")){
				removeImage(req, res,uploadReq);
				res.setRenderParameter("jspPage", "/html/portlet/vimagegallery/image/edit_image.jsp");
				res.setRenderParameter("id", String.valueOf(id));
			}
			else{
				checkImage(tfImage, req, res,uploadReq);
				TFImageServiceUtil.updateImage(groupId, companyId,
						layout.getPlid(), id, categoryId, name, description,
						tfImage.getImage(), isShow);
				res.setRenderParameter("jspPage", "/html/portlet/vimagegallery/view.jsp");
				res.setRenderParameter("tabs1", "VImageGallery.title.image");
				res.setRenderParameter("categoryId", String.valueOf(categoryId));
			}
		}
		
	}

	// _deleteImage
	public void deleteImage(ActionRequest req, ActionResponse res)
			throws Exception {
		String imageId[] = StringUtil.split(ParamUtil.getString(req, "id"));
		for (int i = 0; i < imageId.length; i++) {
			try {
				TFImageServiceUtil.deleteImage(Long.parseLong(imageId[i]));
			} catch (Exception ce) {
				ce.printStackTrace();
			}
		}
	}

	// _removeImage
	public void removeImage(ActionRequest req, ActionResponse res,UploadPortletRequest uploadreq)
			throws PortalException, SystemException, RemoteException {
		try {
			String id = ParamUtil.getString(uploadreq, "id");
			if (Validator.isNull(id)) {
				return;
			}
			TFImage image = TFImageServiceUtil.getImage(Long.parseLong(id));
			ImageUtilExt.deleteImage(Long.parseLong(image.getImage()));

			if (image != null) {
				image.setImage(null);
				TFImageServiceUtil.updateImage(image);
			}
		} catch (Exception ce) {
			ce.printStackTrace();
		}
	}

	// Get Image by Id
	public void getImage(RenderRequest req, ActionResponse res)
			throws Exception {
		long id = ParamUtil.getLong(req, "id");
		TFImage image = TFImageServiceUtil.getImage(id);
		req.setAttribute("image", image);
	}

	// check Image
	public void checkImage(TFImage tfImage, ActionRequest req,
			ActionResponse res,UploadPortletRequest uploadReq) throws Exception {

		if (tfImage != null) {
			String contentType = "";
			
			if(Validator.isNull(tfImage.getImage())){
				contentType = uploadReq.getContentType("image");
			}

			if (ImageUtilExt.isImage(contentType)) {

				File fileImage = uploadReq.getFile("image");
				if ((fileImage != null)) {

					byte[] photoBytes = FileUtil.getBytes(fileImage); // Image
					if ((GetterUtil.getInteger(PropsUtil
							.get(PropsKeys.IG_IMAGE_MAX_SIZE)) > 0)
							&& ((photoBytes == null) || photoBytes.length > (GetterUtil
									.getInteger(PropsUtil
											.get(PropsKeys.IG_IMAGE_MAX_SIZE))))) {

						throw new ImageSizeException();

					} else {
						// VImagegalleryUtil.getRandPrefix()
						String imageKey = tfImage.getId()
								+ VImagegalleryUtil.getRandPrefix();
						ImageUtilExt.saveOriginalImage(
								Long.parseLong(imageKey), photoBytes);

						tfImage.setImage(imageKey);
						TFImageServiceUtil.updateImage(tfImage);
					}
				}
			}
		}
	}

	public void updateIsShow(ActionRequest req, ActionResponse res)
			throws Exception {

		boolean isShow = ParamUtil.getBoolean(req, "isShow");
		long id = ParamUtil.getLong(req, "id");
		if (Validator.isNotNull(String.valueOf(id))) {

			TFImage image = TFImageServiceUtil.findImagebyID(id);
			image.setIsShow(isShow);
			TFImageServiceUtil.updateImage(image);
		}
	}

	// _updateCategory
	public void updateCategory(ActionRequest req, ActionResponse res)
			throws Exception {
		UploadPortletRequest uploadReq = PortalUtil
				.getUploadPortletRequest(req);
		long id = ParamUtil.getLong(uploadReq, "id");
		long groupId = ParamUtil.getLong(uploadReq, "groupId");
		long companyId = PortalUtil.getCompanyId(uploadReq);
		String name = ParamUtil.getString(uploadReq, "name");
		String description = ParamUtil.getString(uploadReq, "description");
		String image = uploadReq.getFileName("image");
		String[] communityPermissions = uploadReq
				.getParameterValues("communityPermissions");
		String[] guestPermissions = uploadReq.getParameterValues("guestPermissions");
		String cmd = ParamUtil.getString(uploadReq, "cmd");
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadReq
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();

		TFCategory tfCategory = new TFCategoryImpl();

		if (id <= 0) {

			tfCategory = TFCategoryServiceUtil.addCategory(groupId, companyId,
					layout.getPlid(), name, description, "",communityPermissions, guestPermissions);
			checkImage(tfCategory, req, res,uploadReq);

			TFCategoryServiceUtil.getByGroupId(groupId);

			TFImageServiceUtil.getByGroupId(groupId);

		} else {
			tfCategory = TFCategoryServiceUtil.getCategory(id);
			if (cmd.equals("remove_image")){
				removeImage(req, res,uploadReq);
				TFCategoryServiceUtil.updateCategory(groupId, companyId, id, name,
						description, "");
				res.setRenderParameter("jspPage", "/html/portlet/vimagegallery/category/edit_category.jsp");
				res.setRenderParameter("categoryId", String.valueOf(tfCategory.getId()));
				}
			else{	
				checkImage(tfCategory, req, res,uploadReq);
				TFCategoryServiceUtil.updateCategory(groupId, companyId, id, name,
						description, tfCategory.getImage());
				res.setRenderParameter("jspPage", "/html/portlet/vimagegallery/view.jsp");
				res.setRenderParameter("tabs1", "VImageGallery.title.category");
			}
			
		}
		
		
	}

	// _deleteCategory
	public void deleteCategory(ActionRequest req, ActionResponse res)
			throws Exception {
		String[] ids = StringUtil.split(ParamUtil.getString(req, "ids"));
		for (int i = 0; i < ids.length; i++) {
			try {
				TFCategoryServiceUtil.deleteCategory(Long.parseLong(ids[i]));
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	}

	// _remove Image Intro
	public void removeImageCategory(ActionRequest req, ActionResponse res)
			throws PortalException, SystemException, RemoteException {
		try {
			String id = ParamUtil.getString(req, "id");
			if (Validator.isNull(id)) {
				return;
			}
			TFCategory category = TFCategoryServiceUtil.getCategory(Long
					.parseLong(id));
			ImageUtilExt.deleteImage(Long.parseLong(category.getImage()));

			if (category != null) {
				category.setImage(null);
				TFCategoryServiceUtil.updateCategory(category);
			}
		} catch (Exception ce) {
			ce.printStackTrace();
		}
	}

	// Check Image
	public void checkImage(TFCategory tfCategory, ActionRequest req,
			ActionResponse res,UploadPortletRequest uploadReq) throws Exception {

		if (tfCategory != null) {
			String contentType = "";
			if(Validator.isNull(tfCategory.getImage())){
				contentType = uploadReq.getContentType("image");
			}
			if (ImageUtilExt.isImage(contentType)) {

				File fileImage = uploadReq.getFile("image");
				if ((fileImage != null)) {

					byte[] photoBytes = FileUtil.getBytes(fileImage); // Image
					if ((GetterUtil.getInteger(PropsUtil
							.get(PropsKeys.IG_IMAGE_MAX_SIZE)) > 0)
							&& ((photoBytes == null) || photoBytes.length > GetterUtil
									.getInteger(PropsUtil
											.get(PropsKeys.IG_IMAGE_MAX_SIZE)))) {

						throw new ImageSizeException();
					} else {

						String imageKey = tfCategory.getId()
								+ VImagegalleryUtil.getRandPrefix();
						ImageUtilExt.saveOriginalImage(
								Long.parseLong(imageKey), photoBytes);
						
						tfCategory.setImage(imageKey);
						TFCategoryServiceUtil.updateCategory(tfCategory);
					}
				}
			}
		}
	}
}
