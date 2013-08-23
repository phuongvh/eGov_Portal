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

package com.vportal.portlet.vimagegallery.service.impl;

import com.vportal.portlet.vimagegallery.service.base.TFImageServiceBaseImpl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.vportal.portal.kernel.security.permission.ActionKeysExt;
import com.vportal.portal.util.PortalUtilExt;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vimagegallery.model.TFImage;
import com.vportal.portlet.vimagegallery.service.permission.TFImagePermission;
import com.vportal.portlet.vimagegallery.service.persistence.TFImageUtil;
import com.vportal.portlet.vimagegallery.util.PortletKeyExt;

/**
 * The implementation of the t f image remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vimagegallery.service.TFImageService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author DucNN
 * @see com.vportal.portlet.vimagegallery.service.base.TFImageServiceBaseImpl
 * @see com.vportal.portlet.vimagegallery.service.TFImageServiceUtil
 */
public class TFImageServiceImpl extends TFImageServiceBaseImpl {
	public TFImage addImage(long groupId, long companyId, long plid,
			long categoryId, String name, String description, String image,
			boolean isShow, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		return addImage(groupId, companyId, plid, categoryId, name,
				description, image, isShow, null,null,communityPermissions,
				guestPermissions);
	}

	public TFImage addImage(long groupId, long companyId, long plid,
			long categoryId, String name, String description, String image,
			boolean isShow, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {
		
//		 Check Permissions
		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeyExt.VIMAGEGALLERY,"ADD_IMAGE_");
	
		long id = CounterLocalServiceUtil.increment(TFImage.class.getName());
		TFImage tfImage = TFImageUtil.create(id);

		tfImage.setCreateDate(new Date());
		tfImage.setModifiedDate(new Date());
		tfImage.setName(name);
		tfImage.setDescription(description);
		tfImage.setCategoryId(categoryId);
		tfImage.setGroupId(groupId);
		tfImage.setImage(image);
		tfImage.setIsShow(isShow);
		tfImage.setCompanyId(companyId);

		tfImagePersistence.update(tfImage, false);

		// Add to common resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addTFImageResources(tfImage,
					addCommunityPermissions.booleanValue(), addGuestPermissions
							.booleanValue());

		} else {

			addTFImageResources(tfImage,communityPermissions, guestPermissions);
		}

		return tfImage;
	}

	public TFImage addImage(TFImage image) throws PortalException,
			SystemException, RemoteException {

		long id = CounterLocalServiceUtil.increment(TFImage.class.getName());
		TFImage tfImage = TFImageUtil.create(id);
		Date now = new Date();

		tfImage.setCategoryId(image.getCategoryId());
		tfImage.setGroupId(image.getGroupId());
		tfImage.setName(image.getName());
		tfImage.setDescription(image.getDescription());
		tfImage.setImage(image.getImage());
		tfImage.setIsShow(image.getIsShow());
		tfImage.setModifiedDate(now);
		tfImagePersistence.update(tfImage, false);
		return tfImage;
	}

	public TFImage updateImage(long groupId, long companyId, long plid,
			long id, long categoryId, String name, String description,
			String image, boolean isShow) throws PortalException,
			SystemException, RemoteException {

		TFImagePermission.check(getPermissionChecker(), id,
				ActionKeysExt.UPDATE);

		TFImage tfImage = tfImagePersistence.findByPrimaryKey(id);
		tfImage.setGroupId(groupId);
		tfImage.setCompanyId(companyId);

		tfImage.setModifiedDate(new Date());
		tfImage.setName(name);
		tfImage.setDescription(description);
		tfImage.setCategoryId(categoryId);

		tfImage.setImage(image);
		tfImage.setIsShow(isShow);
		tfImagePersistence.update(tfImage, false);

		return tfImage;

	}

	public TFImage updateImage(TFImage image) throws PortalException,
			SystemException, RemoteException {
		TFImage tfImage = tfImagePersistence.findByPrimaryKey(image.getId());
		Date now = new Date();

		tfImage.setGroupId(image.getGroupId());
		tfImage.setCompanyId(image.getCompanyId());
		tfImage.setName(image.getName());
		tfImage.setDescription(image.getDescription());
		tfImage.setCategoryId(image.getCategoryId());
		tfImage.setImage(image.getImage());
		tfImage.setIsShow(image.getIsShow());
		tfImage.setModifiedDate(now);

		tfImagePersistence.update(tfImage, false);
		return tfImage;
	}

	// Delete Image by Id
	public void deleteImage(long id) throws PortalException, SystemException,
			RemoteException {

		// TFImagePermission.check(getPermissionChecker(), id,
		// ActionKeysExt.DELETE);
		TFImage tfImage = tfImagePersistence.findByPrimaryKey(id);

		// Remove resource tfImage from system
		ResourceLocalServiceUtil.deleteResource(tfImage.getCompanyId(),
				TFImage.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				tfImage.getId());

		tfImagePersistence.remove(id);
	}

	public TFImage findImagebyID(long id) throws PortalException,
			SystemException {
		return tfImagePersistence.findByPrimaryKey(id);
	}

	public TFImage getImage(long id) throws PortalException, SystemException,
			RemoteException {

		return tfImagePersistence.findByPrimaryKey(id);
	}

	public List<TFImage> findAll() throws PortalException, SystemException,
			RemoteException {
		return tfImagePersistence.findAll();
	}

	public List<TFImage> getByGroupId(long groupId) throws PortalException,
			SystemException, RemoteException {
		return tfImagePersistence.findByGroupId(groupId);
	}

	public List<TFImage> getByGroupId(long groupId, int start, int end)
			throws PortalException, SystemException, RemoteException {
		return tfImagePersistence.findByGroupId(groupId, start, end);
	}

	public int countByGroupId(long groupId) throws PortalException,
			SystemException, RemoteException {
		return tfImagePersistence.countByGroupId(groupId);
	}

	public List<TFImage> getByG_C(long groupId, long categoryId, int start, int end)
			throws PortalException, SystemException, RemoteException {
		return tfImagePersistence.findByG_C(groupId, categoryId, start, end);
	}

	public List<TFImage> getByG_C(long groupId, long categoryId) throws PortalException,
			SystemException, RemoteException {
		return tfImagePersistence.findByG_C(groupId, categoryId);
	}

	public List<TFImage> getByG_I(long groupId, boolean isShow, int start, int end)
			throws PortalException, SystemException, RemoteException {
		return tfImagePersistence.findByG_I(groupId, isShow, start, end);
	}

	public int countByG_I(long groupId, boolean isShow) throws PortalException,
			SystemException, RemoteException {
		return tfImagePersistence.countByG_I(groupId, isShow);
	}

	public int countByG_C(long groupId, long categoryId)
			throws PortalException, SystemException, RemoteException {
		return tfImagePersistence.countByG_C(groupId, categoryId);
	}

	public List<TFImage> getByG_C_I(long groupId, long categoryId, boolean isShow)
			throws PortalException, SystemException, RemoteException {
		return tfImagePersistence.findByG_C_I(groupId, categoryId, isShow);
	}

	public List<TFImage> getByG_C_I(long groupId, long categoryId, boolean isShow,
			int start, int end) throws PortalException, SystemException,
			RemoteException {
		return tfImagePersistence.findByG_C_I(groupId, categoryId, isShow,
				start, end);
	}

	public int countByG_C_I(long groupId, long categoryId, boolean isShow)
			throws PortalException, SystemException, RemoteException {
		return tfImagePersistence.countByG_C_I(groupId, categoryId, isShow);
	}

	// add Resource
	public void addTFImageResources(long id, boolean addCommunityPermissions,
			boolean addGuestPermissions) throws PortalException,
			SystemException {

		TFImage tfImage = tfImagePersistence.findByPrimaryKey(id);
		addTFImageResources(tfImage, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addTFImageResources(TFImage tfImage,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(tfImage.getCompanyId(),
				0, getUserId(), TFImage.class.getName(), tfImage
						.getPrimaryKey(), false, addCommunityPermissions,
				addGuestPermissions);

	}

	public void addTFImageResources(long id, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		TFImage tfImage = tfImagePersistence.findByPrimaryKey(id);
		addTFImageResources(tfImage, communityPermissions, guestPermissions);

	}

	public void addTFImageResources(TFImage tfImage,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(
				tfImage.getCompanyId(), tfImage.getGroupId(), getUserId(), TFImage.class
						.getName(), tfImage.getPrimaryKey(),
				communityPermissions, guestPermissions);
	}
}