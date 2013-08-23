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

import com.vportal.portlet.vimagegallery.service.base.TFCategoryServiceBaseImpl;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vimagegallery.DeleteCategoryException;
import com.vportal.portlet.vimagegallery.model.TFCategory;
import com.vportal.portlet.vimagegallery.model.TFImage;
import com.vportal.portlet.vimagegallery.service.TFImageServiceUtil;
import com.vportal.portlet.vimagegallery.service.permission.TFCategoryPermission;
import com.vportal.portlet.vimagegallery.service.persistence.TFCategoryUtil;
import com.vportal.portlet.vimagegallery.util.ActionKeysExt;
import com.vportal.portlet.vimagegallery.util.PortletKeyExt;

/**
 * The implementation of the t f category remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vimagegallery.service.TFCategoryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author DucNN
 * @see com.vportal.portlet.vimagegallery.service.base.TFCategoryServiceBaseImpl
 * @see com.vportal.portlet.vimagegallery.service.TFCategoryServiceUtil
 */
public class TFCategoryServiceImpl extends TFCategoryServiceBaseImpl {
	public TFCategory addCategory(long groupId, long companyId, long plid,
			String name, String description, String image,String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException, RemoteException {

		return addCategory(groupId, companyId, plid, name, description, image,
				null, null, communityPermissions, guestPermissions);
	}

	public TFCategory addCategory(long groupId, long companyId, long plid,
			String name, String description, String image,
			Boolean addCommunityPermissions, Boolean addGuestPermissions,String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException, RemoteException {

		// Check permissions
		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeyExt.VIMAGEGALLERY, ActionKeysExt.ADD_CATEGORY_);
		

		long id = CounterLocalServiceUtil.increment(TFCategory.class.getName());
		TFCategory tfCategory = TFCategoryUtil.create(id);

		tfCategory.setGroupId(groupId);
		tfCategory.setCompanyId(companyId);
		
		tfCategory.setCreateDate(new Date());
		tfCategory.setModifiedDate(new Date());
		tfCategory.setName(name);
		tfCategory.setDescription(description);
		tfCategory.setImage(image);

		TFCategoryUtil.update(tfCategory, false);

		// Add to common resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addTFCategoryResources(tfCategory, addCommunityPermissions
					.booleanValue(), addGuestPermissions.booleanValue());

		} else {

			addTFCategoryResources(tfCategory, null,
					null);
		}
		return tfCategory;

	}

	public TFCategory addCategory(TFCategory category) throws PortalException,
			SystemException, RemoteException {

		long id = CounterLocalServiceUtil.increment(TFImage.class.getName());
		TFCategory tfCategory = TFCategoryUtil.create(id);
		Date now = new Date();
		tfCategory.setName(category.getName());
		tfCategory.setDescription(category.getDescription());
		tfCategory.setImage(category.getImage());
		tfCategory.setModifiedDate(now);
		TFCategoryUtil.update(tfCategory, false);
		return tfCategory;
	}

	// Update Category
	public TFCategory updateCategory(long groupId, long companyId, long id,
			String name, String description, String image)
			throws PortalException, SystemException, RemoteException {

		TFCategoryPermission.check(getPermissionChecker(), id,
				ActionKeysExt.UPDATE);
		TFCategory tfCategory = TFCategoryUtil.findByPrimaryKey(id);

		tfCategory.setGroupId(groupId);
		tfCategory.setCompanyId(companyId);

		tfCategory.setModifiedDate(new Date());
		tfCategory.setName(name);
		tfCategory.setDescription(description);
		tfCategory.setImage(image);
		TFCategoryUtil.update(tfCategory, false);
		return tfCategory;
	}

	public TFCategory updateCategory(TFCategory category)
			throws PortalException, SystemException, RemoteException {

		TFCategory tfCategory = TFCategoryUtil.findByPrimaryKey(category
				.getId());

		tfCategory.setGroupId(category.getGroupId());
		tfCategory.setCompanyId(category.getCompanyId());
		tfCategory.setName(category.getName());
		tfCategory.setDescription(category.getDescription());
		tfCategory.setImage(category.getImage());
		tfCategory.setModifiedDate(new Date());
		TFCategoryUtil.update(tfCategory, false);
		return tfCategory;
	}

	public void deleteCategory(long id) throws PortalException,
			SystemException, RemoteException {

		try {
			TFCategoryPermission.check(getPermissionChecker(), id,
					ActionKeysExt.DELETE);

			TFCategory tfCategory = TFCategoryUtil.findByPrimaryKey(id);

			List listImage = (List) TFImageServiceUtil.getByG_C(tfCategory
					.getGroupId(), tfCategory.getId());

			if (Validator.isNotNull(listImage) && listImage.size() > 0) {
				throw new DeleteCategoryException();
			}

			ResourceLocalServiceUtil.deleteResource(tfCategory.getCompanyId(),
					TFCategory.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, tfCategory.getId());

			tfCategoryPersistence.remove(tfCategory);
			//TFCategoryUtil.remove(id);
			
		} catch (Exception e) {
			throw new DeleteCategoryException();
		}
	}

	public TFCategory getCategory(long id) throws PortalException,
			SystemException, RemoteException {

		return TFCategoryUtil.findByPrimaryKey(id);
	}

	public List<TFCategory> getByGroupId(long groupId) throws PortalException,
			SystemException {
		return TFCategoryUtil.findByGroupId(groupId);
	}

	public int countByGroupId(long groupId) throws PortalException,
			SystemException {
		return TFCategoryUtil.countByGroupId(groupId);
	}

	public TFCategory findCategory(long id) throws PortalException,
			SystemException, RemoteException {
		return TFCategoryUtil.findByPrimaryKey(id);
	}

	// add Resource
	public void addTFCategoryResources(long id,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		TFCategory tfCategory = TFCategoryUtil.findByPrimaryKey(id);
		addTFCategoryResources(tfCategory, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addTFCategoryResources(TFCategory tfCategory,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(tfCategory.getCompanyId(),
				0, getUserId(), TFCategory.class.getName(), tfCategory
						.getPrimaryKey(), false, addCommunityPermissions,
				addGuestPermissions);

	}

	public void addTFCategoryResources(long id, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		TFCategory tfCategory = TFCategoryUtil.findByPrimaryKey(id);
		addTFCategoryResources(tfCategory, communityPermissions,
				guestPermissions);
	}

	public void addTFCategoryResources(TFCategory tfCategory,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(
				tfCategory.getCompanyId(), 0, getUserId(), TFCategory.class
						.getName(), tfCategory.getPrimaryKey(),
				communityPermissions, guestPermissions);
	}
}