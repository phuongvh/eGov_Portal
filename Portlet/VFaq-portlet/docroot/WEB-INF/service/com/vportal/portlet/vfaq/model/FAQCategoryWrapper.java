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

package com.vportal.portlet.vfaq.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link FAQCategory}.
 * </p>
 *
 * @author    DucNN
 * @see       FAQCategory
 * @generated
 */
public class FAQCategoryWrapper implements FAQCategory,
	ModelWrapper<FAQCategory> {
	public FAQCategoryWrapper(FAQCategory faqCategory) {
		_faqCategory = faqCategory;
	}

	public Class<?> getModelClass() {
		return FAQCategory.class;
	}

	public String getModelClassName() {
		return FAQCategory.class.getName();
	}

	/**
	* Returns the primary key of this f a q category.
	*
	* @return the primary key of this f a q category
	*/
	public long getPrimaryKey() {
		return _faqCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this f a q category.
	*
	* @param primaryKey the primary key of this f a q category
	*/
	public void setPrimaryKey(long primaryKey) {
		_faqCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this f a q category.
	*
	* @return the ID of this f a q category
	*/
	public long getId() {
		return _faqCategory.getId();
	}

	/**
	* Sets the ID of this f a q category.
	*
	* @param id the ID of this f a q category
	*/
	public void setId(long id) {
		_faqCategory.setId(id);
	}

	/**
	* Returns the name of this f a q category.
	*
	* @return the name of this f a q category
	*/
	public java.lang.String getName() {
		return _faqCategory.getName();
	}

	/**
	* Sets the name of this f a q category.
	*
	* @param name the name of this f a q category
	*/
	public void setName(java.lang.String name) {
		_faqCategory.setName(name);
	}

	/**
	* Returns the description of this f a q category.
	*
	* @return the description of this f a q category
	*/
	public java.lang.String getDescription() {
		return _faqCategory.getDescription();
	}

	/**
	* Sets the description of this f a q category.
	*
	* @param description the description of this f a q category
	*/
	public void setDescription(java.lang.String description) {
		_faqCategory.setDescription(description);
	}

	/**
	* Returns the language of this f a q category.
	*
	* @return the language of this f a q category
	*/
	public java.lang.String getLanguage() {
		return _faqCategory.getLanguage();
	}

	/**
	* Sets the language of this f a q category.
	*
	* @param language the language of this f a q category
	*/
	public void setLanguage(java.lang.String language) {
		_faqCategory.setLanguage(language);
	}

	/**
	* Returns the parent of this f a q category.
	*
	* @return the parent of this f a q category
	*/
	public long getParent() {
		return _faqCategory.getParent();
	}

	/**
	* Sets the parent of this f a q category.
	*
	* @param parent the parent of this f a q category
	*/
	public void setParent(long parent) {
		_faqCategory.setParent(parent);
	}

	/**
	* Returns the catorder of this f a q category.
	*
	* @return the catorder of this f a q category
	*/
	public long getCatorder() {
		return _faqCategory.getCatorder();
	}

	/**
	* Sets the catorder of this f a q category.
	*
	* @param catorder the catorder of this f a q category
	*/
	public void setCatorder(long catorder) {
		_faqCategory.setCatorder(catorder);
	}

	/**
	* Returns the catlevel of this f a q category.
	*
	* @return the catlevel of this f a q category
	*/
	public long getCatlevel() {
		return _faqCategory.getCatlevel();
	}

	/**
	* Sets the catlevel of this f a q category.
	*
	* @param catlevel the catlevel of this f a q category
	*/
	public void setCatlevel(long catlevel) {
		_faqCategory.setCatlevel(catlevel);
	}

	/**
	* Returns the image of this f a q category.
	*
	* @return the image of this f a q category
	*/
	public java.lang.String getImage() {
		return _faqCategory.getImage();
	}

	/**
	* Sets the image of this f a q category.
	*
	* @param image the image of this f a q category
	*/
	public void setImage(java.lang.String image) {
		_faqCategory.setImage(image);
	}

	/**
	* Returns the created by user of this f a q category.
	*
	* @return the created by user of this f a q category
	*/
	public java.lang.String getCreatedByUser() {
		return _faqCategory.getCreatedByUser();
	}

	/**
	* Sets the created by user of this f a q category.
	*
	* @param createdByUser the created by user of this f a q category
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_faqCategory.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the created date of this f a q category.
	*
	* @return the created date of this f a q category
	*/
	public java.util.Date getCreatedDate() {
		return _faqCategory.getCreatedDate();
	}

	/**
	* Sets the created date of this f a q category.
	*
	* @param createdDate the created date of this f a q category
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_faqCategory.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified by user of this f a q category.
	*
	* @return the modified by user of this f a q category
	*/
	public java.lang.String getModifiedByUser() {
		return _faqCategory.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this f a q category.
	*
	* @param modifiedByUser the modified by user of this f a q category
	*/
	public void setModifiedByUser(java.lang.String modifiedByUser) {
		_faqCategory.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the modified date of this f a q category.
	*
	* @return the modified date of this f a q category
	*/
	public java.util.Date getModifiedDate() {
		return _faqCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this f a q category.
	*
	* @param modifiedDate the modified date of this f a q category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_faqCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the group ID of this f a q category.
	*
	* @return the group ID of this f a q category
	*/
	public long getGroupId() {
		return _faqCategory.getGroupId();
	}

	/**
	* Sets the group ID of this f a q category.
	*
	* @param groupId the group ID of this f a q category
	*/
	public void setGroupId(long groupId) {
		_faqCategory.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this f a q category.
	*
	* @return the user ID of this f a q category
	*/
	public long getUserId() {
		return _faqCategory.getUserId();
	}

	/**
	* Sets the user ID of this f a q category.
	*
	* @param userId the user ID of this f a q category
	*/
	public void setUserId(long userId) {
		_faqCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this f a q category.
	*
	* @return the user uuid of this f a q category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this f a q category.
	*
	* @param userUuid the user uuid of this f a q category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_faqCategory.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _faqCategory.isNew();
	}

	public void setNew(boolean n) {
		_faqCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _faqCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_faqCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _faqCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _faqCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_faqCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _faqCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_faqCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FAQCategoryWrapper((FAQCategory)_faqCategory.clone());
	}

	public int compareTo(com.vportal.portlet.vfaq.model.FAQCategory faqCategory) {
		return _faqCategory.compareTo(faqCategory);
	}

	@Override
	public int hashCode() {
		return _faqCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vfaq.model.FAQCategory> toCacheModel() {
		return _faqCategory.toCacheModel();
	}

	public com.vportal.portlet.vfaq.model.FAQCategory toEscapedModel() {
		return new FAQCategoryWrapper(_faqCategory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _faqCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _faqCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_faqCategory.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FAQCategory getWrappedFAQCategory() {
		return _faqCategory;
	}

	public FAQCategory getWrappedModel() {
		return _faqCategory;
	}

	public void resetOriginalValues() {
		_faqCategory.resetOriginalValues();
	}

	private FAQCategory _faqCategory;
}