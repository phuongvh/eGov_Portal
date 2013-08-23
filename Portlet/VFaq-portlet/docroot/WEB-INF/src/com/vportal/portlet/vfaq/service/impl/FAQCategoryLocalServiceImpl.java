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

package com.vportal.portlet.vfaq.service.impl;

import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vfaq.service.base.FAQCategoryLocalServiceBaseImpl;
import com.vportal.portlet.vfaq.util.ActionKeysExt;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.vportal.portlet.vfaq.model.FAQCategory;
/**
 * The implementation of the f a q category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vfaq.service.FAQCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucNN
 * @see com.vportal.portlet.vfaq.service.base.FAQCategoryLocalServiceBaseImpl
 * @see com.vportal.portlet.vfaq.service.FAQCategoryLocalServiceUtil
 */
public class FAQCategoryLocalServiceImpl extends FAQCategoryLocalServiceBaseImpl {

	public FAQCategory addCategory(String name, String description,
			String language, long parent, long catorder, long catlevel,
			String image, String createdByUser, Date createdDate, long groupId,
			long plid, long userId, Boolean addCommunityPermissions,
			Boolean addGuestPermissions) throws Exception {
		return addCategory(name, description, language, parent, catorder,
				catlevel, image, createdByUser, createdDate, groupId, userId,plid,
				addCommunityPermissions, addGuestPermissions, null, null);
	}

	public FAQCategory addCategory(String name, String description,
			String language, long parent, long catorder, long catlevel,
			String image, String createdByUser, Date createdDate, long groupId,long plid,
			long userId, String[] communityPermissions,
			String[] guestPermissions) throws Exception {
		return addCategory(name, description, language, parent, catorder,
				catlevel, image, createdByUser, createdDate, groupId, plid, userId,
				null, null, communityPermissions, guestPermissions);
	}

	public FAQCategory addCategory(String name, String description,
			String language, long parent, long catorder, long catlevel,
			String image, String createdByUser, Date createdDate, long groupId,
			long plid, long userId, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws Exception {

		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(userLocalService.getUser(userId), false);
		PortletPermissionUtil.check(permissionChecker, plid,PortletKeysExt.VFAQ, ActionKeysExt.ADD_CATEGORY);
		// Category
		long catId = counterLocalService.increment();
		FAQCategory category = faqCategoryPersistence.create(catId);
		category.setName(name);
		category.setDescription(description);
		category.setLanguage(language);
		category.setParent(parent);
		category.setCatorder(catorder);
		category.setCatlevel(catlevel);
		category.setCreatedByUser(createdByUser);
		category.setCreatedDate(createdDate);
		category.setGroupId(groupId);
		category.setUserId(userId);

		faqCategoryPersistence.update(category, false);

		// Resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addCategoryResources(category,
					addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addCategoryResources(category, communityPermissions,
					guestPermissions);
		}

		return category;
	}

	public FAQCategory updateImage(long categoryId, String imageName)
			throws SystemException, PortalException {
		FAQCategory category = faqCategoryPersistence
				.findByPrimaryKey(categoryId);
		category.setImage(imageName);
		return faqCategoryPersistence.update(category, false);
	}

	public FAQCategory updateCategory(long categoryId, String name,
			String description, String language, long parent, long catorder,
			long catlevel, String image, String modifiedByUser,
			Date modifiedDate, long groupId, long userId)
			throws PortalException, SystemException {
		FAQCategory category = faqCategoryPersistence
				.findByPrimaryKey(categoryId);
		category.setName(name);
		category.setDescription(description);
		category.setLanguage(language);
		category.setParent(parent);
		category.setCatorder(catorder);
		category.setCatlevel(catlevel);
		category.setModifiedByUser(modifiedByUser);
		category.setModifiedDate(modifiedDate);
		category.setGroupId(groupId);
		category.setUserId(userId);

		faqCategoryPersistence.update(category, false);
		return category;
	}

	public void deleteCategory(long categoryId) throws PortalException,
			SystemException {

		faqCategoryPersistence.remove(categoryId);
	}

	public void deleteCategory(long groupId, long categoryId)
			throws PortalException, SystemException {
		// Get Category
		FAQCategory category = faqCategoryPersistence.findByG_C(groupId,
				categoryId);

		// Delete Resources
		resourceLocalService.deleteResource(PortalUtil.getDefaultCompanyId(),
				FAQCategory.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, category.getId());

		// Delete Category
		faqCategoryPersistence.remove(categoryId);
	}

	public FAQCategory getCategory(long groupId, long categoryId)
			throws PortalException, SystemException {
		return faqCategoryPersistence.findByG_C(groupId, categoryId);
	}

	public FAQCategory getCategory(long categoryId) throws PortalException,
			SystemException {
		return faqCategoryPersistence.findByPrimaryKey(categoryId);
	}

	public List getSubCategory(long groupId, long parentId)
			throws PortalException, SystemException {
		return faqCategoryPersistence.findByG_P(groupId, parentId);
	}

	public List getSubCategory(long parentId) throws PortalException,
			SystemException {
		return faqCategoryPersistence.findByParentId(parentId);
	}

	public List getAll(long groupId) throws PortalException, SystemException {
		return faqCategoryPersistence.findByGroupId(groupId);
	}

	public List getAll(long groupId, int start, int end)
			throws PortalException, SystemException {
		return faqCategoryPersistence.findByGroupId(groupId, start, end);
	}

	public int countAll(long groupId) throws PortalException, SystemException {
		return faqCategoryPersistence.countByGroupId(groupId);
	}

	public List getAll() throws PortalException, SystemException {
		return faqCategoryPersistence.findAll();
	}

	public List getAll(int begin, int end) throws PortalException,
			SystemException {
		return faqCategoryPersistence.findAll(begin, end);
	}

	public List getByGroupId(long groupId) throws PortalException,
			SystemException {
		return faqCategoryPersistence.findByGroupId(groupId);
	}

	public void addCategoryResources(long categoryId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		FAQCategory category = faqCategoryPersistence
				.findByPrimaryKey(categoryId);

		addCategoryResources(category, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addCategoryResources(FAQCategory category,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addResources(PortalUtil.getDefaultCompanyId(),
				category.getGroupId(), category.getUserId(),
				FAQCategory.class.getName(), category.getId(), false,
				addCommunityPermissions, addGuestPermissions);
	}

	public void addCategoryResources(long categoryId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		FAQCategory category = faqCategoryPersistence
				.findByPrimaryKey(categoryId);

		addCategoryResources(category, communityPermissions, guestPermissions);

	}

	public void addCategoryResources(FAQCategory category,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(PortalUtil.getDefaultCompanyId(),
				category.getGroupId(), category.getUserId(),
				DLFileShortcut.class.getName(), category.getId(),
				communityPermissions, guestPermissions);
	}

	public List getByG_L(long groupId, String language) throws SystemException {
		return faqCategoryPersistence.findByG_L(groupId, language);
	}

	public List getByG_L(long groupId, String language, int start, int end)
			throws SystemException {
		return faqCategoryPersistence.findByG_L(groupId, language, start, end);
	}

	public List getByG_L_P(long groupId, String language, long parentId)
			throws SystemException {
		return faqCategoryPersistence.findByG_L_P(groupId, language, parentId);
	}

	public List getByG_L_P(long groupId, String language, long parentId,
			int start, int end) throws SystemException {
		return faqCategoryPersistence.findByG_L_P(groupId, language, parentId,
				start, end);
	}

	public int countByG_L(long groupId, String language) throws SystemException {
		return faqCategoryPersistence.countByG_L(groupId, language);
	}

	public int countByG_L_P(long groupId, String language, long parentId)
			throws SystemException {
		return faqCategoryPersistence.countByG_L_P(groupId, language, parentId);
	}

	public int countByG_L_C(long groupId, String language, long categoryId)
			throws SystemException {
		return faqCategoryFinder.countByG_L_C(groupId, language, categoryId);
	}
	
	public List getCategoriesByG_L(long groupId, String language)
			throws PortalException, SystemException {

		return faqCategoryLocalService.getByG_L(groupId, language);
	}
}