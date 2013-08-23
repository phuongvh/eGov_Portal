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

package com.vportal.portlet.vcms.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VcmsCategory}.
 * </p>
 *
 * @author    hai
 * @see       VcmsCategory
 * @generated
 */
public class VcmsCategoryWrapper implements VcmsCategory,
	ModelWrapper<VcmsCategory> {
	public VcmsCategoryWrapper(VcmsCategory vcmsCategory) {
		_vcmsCategory = vcmsCategory;
	}

	public Class<?> getModelClass() {
		return VcmsCategory.class;
	}

	public String getModelClassName() {
		return VcmsCategory.class.getName();
	}

	/**
	* Returns the primary key of this vcms category.
	*
	* @return the primary key of this vcms category
	*/
	public java.lang.String getPrimaryKey() {
		return _vcmsCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms category.
	*
	* @param primaryKey the primary key of this vcms category
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vcmsCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this vcms category.
	*
	* @return the category ID of this vcms category
	*/
	public java.lang.String getCategoryId() {
		return _vcmsCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this vcms category.
	*
	* @param categoryId the category ID of this vcms category
	*/
	public void setCategoryId(java.lang.String categoryId) {
		_vcmsCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the group ID of this vcms category.
	*
	* @return the group ID of this vcms category
	*/
	public long getGroupId() {
		return _vcmsCategory.getGroupId();
	}

	/**
	* Sets the group ID of this vcms category.
	*
	* @param groupId the group ID of this vcms category
	*/
	public void setGroupId(long groupId) {
		_vcmsCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vcms category.
	*
	* @return the company ID of this vcms category
	*/
	public long getCompanyId() {
		return _vcmsCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this vcms category.
	*
	* @param companyId the company ID of this vcms category
	*/
	public void setCompanyId(long companyId) {
		_vcmsCategory.setCompanyId(companyId);
	}

	/**
	* Returns the created date of this vcms category.
	*
	* @return the created date of this vcms category
	*/
	public java.util.Date getCreatedDate() {
		return _vcmsCategory.getCreatedDate();
	}

	/**
	* Sets the created date of this vcms category.
	*
	* @param createdDate the created date of this vcms category
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vcmsCategory.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by user of this vcms category.
	*
	* @return the created by user of this vcms category
	*/
	public java.lang.String getCreatedByUser() {
		return _vcmsCategory.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vcms category.
	*
	* @param createdByUser the created by user of this vcms category
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_vcmsCategory.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the modified date of this vcms category.
	*
	* @return the modified date of this vcms category
	*/
	public java.util.Date getModifiedDate() {
		return _vcmsCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this vcms category.
	*
	* @param modifiedDate the modified date of this vcms category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vcmsCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the modified by user of this vcms category.
	*
	* @return the modified by user of this vcms category
	*/
	public java.lang.String getModifiedByUser() {
		return _vcmsCategory.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this vcms category.
	*
	* @param modifiedByUser the modified by user of this vcms category
	*/
	public void setModifiedByUser(java.lang.String modifiedByUser) {
		_vcmsCategory.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the portion ID of this vcms category.
	*
	* @return the portion ID of this vcms category
	*/
	public java.lang.String getPortionId() {
		return _vcmsCategory.getPortionId();
	}

	/**
	* Sets the portion ID of this vcms category.
	*
	* @param portionId the portion ID of this vcms category
	*/
	public void setPortionId(java.lang.String portionId) {
		_vcmsCategory.setPortionId(portionId);
	}

	/**
	* Returns the parent ID of this vcms category.
	*
	* @return the parent ID of this vcms category
	*/
	public java.lang.String getParentId() {
		return _vcmsCategory.getParentId();
	}

	/**
	* Sets the parent ID of this vcms category.
	*
	* @param parentId the parent ID of this vcms category
	*/
	public void setParentId(java.lang.String parentId) {
		_vcmsCategory.setParentId(parentId);
	}

	/**
	* Returns the name of this vcms category.
	*
	* @return the name of this vcms category
	*/
	public java.lang.String getName() {
		return _vcmsCategory.getName();
	}

	/**
	* Sets the name of this vcms category.
	*
	* @param name the name of this vcms category
	*/
	public void setName(java.lang.String name) {
		_vcmsCategory.setName(name);
	}

	/**
	* Returns the description of this vcms category.
	*
	* @return the description of this vcms category
	*/
	public java.lang.String getDescription() {
		return _vcmsCategory.getDescription();
	}

	/**
	* Sets the description of this vcms category.
	*
	* @param description the description of this vcms category
	*/
	public void setDescription(java.lang.String description) {
		_vcmsCategory.setDescription(description);
	}

	/**
	* Returns the anchored of this vcms category.
	*
	* @return the anchored of this vcms category
	*/
	public boolean getAnchored() {
		return _vcmsCategory.getAnchored();
	}

	/**
	* Returns <code>true</code> if this vcms category is anchored.
	*
	* @return <code>true</code> if this vcms category is anchored; <code>false</code> otherwise
	*/
	public boolean isAnchored() {
		return _vcmsCategory.isAnchored();
	}

	/**
	* Sets whether this vcms category is anchored.
	*
	* @param anchored the anchored of this vcms category
	*/
	public void setAnchored(boolean anchored) {
		_vcmsCategory.setAnchored(anchored);
	}

	/**
	* Returns the href of this vcms category.
	*
	* @return the href of this vcms category
	*/
	public java.lang.String getHref() {
		return _vcmsCategory.getHref();
	}

	/**
	* Sets the href of this vcms category.
	*
	* @param href the href of this vcms category
	*/
	public void setHref(java.lang.String href) {
		_vcmsCategory.setHref(href);
	}

	/**
	* Returns the language of this vcms category.
	*
	* @return the language of this vcms category
	*/
	public java.lang.String getLanguage() {
		return _vcmsCategory.getLanguage();
	}

	/**
	* Sets the language of this vcms category.
	*
	* @param language the language of this vcms category
	*/
	public void setLanguage(java.lang.String language) {
		_vcmsCategory.setLanguage(language);
	}

	/**
	* Returns the has image of this vcms category.
	*
	* @return the has image of this vcms category
	*/
	public boolean getHasImage() {
		return _vcmsCategory.getHasImage();
	}

	/**
	* Returns <code>true</code> if this vcms category is has image.
	*
	* @return <code>true</code> if this vcms category is has image; <code>false</code> otherwise
	*/
	public boolean isHasImage() {
		return _vcmsCategory.isHasImage();
	}

	/**
	* Sets whether this vcms category is has image.
	*
	* @param hasImage the has image of this vcms category
	*/
	public void setHasImage(boolean hasImage) {
		_vcmsCategory.setHasImage(hasImage);
	}

	/**
	* Returns the image of this vcms category.
	*
	* @return the image of this vcms category
	*/
	public java.lang.String getImage() {
		return _vcmsCategory.getImage();
	}

	/**
	* Sets the image of this vcms category.
	*
	* @param image the image of this vcms category
	*/
	public void setImage(java.lang.String image) {
		_vcmsCategory.setImage(image);
	}

	/**
	* Returns the position of this vcms category.
	*
	* @return the position of this vcms category
	*/
	public long getPosition() {
		return _vcmsCategory.getPosition();
	}

	/**
	* Sets the position of this vcms category.
	*
	* @param position the position of this vcms category
	*/
	public void setPosition(long position) {
		_vcmsCategory.setPosition(position);
	}

	/**
	* Returns the user hit of this vcms category.
	*
	* @return the user hit of this vcms category
	*/
	public long getUserHit() {
		return _vcmsCategory.getUserHit();
	}

	/**
	* Sets the user hit of this vcms category.
	*
	* @param userHit the user hit of this vcms category
	*/
	public void setUserHit(long userHit) {
		_vcmsCategory.setUserHit(userHit);
	}

	/**
	* Returns the rssable of this vcms category.
	*
	* @return the rssable of this vcms category
	*/
	public boolean getRssable() {
		return _vcmsCategory.getRssable();
	}

	/**
	* Returns <code>true</code> if this vcms category is rssable.
	*
	* @return <code>true</code> if this vcms category is rssable; <code>false</code> otherwise
	*/
	public boolean isRssable() {
		return _vcmsCategory.isRssable();
	}

	/**
	* Sets whether this vcms category is rssable.
	*
	* @param rssable the rssable of this vcms category
	*/
	public void setRssable(boolean rssable) {
		_vcmsCategory.setRssable(rssable);
	}

	public boolean isNew() {
		return _vcmsCategory.isNew();
	}

	public void setNew(boolean n) {
		_vcmsCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsCategoryWrapper((VcmsCategory)_vcmsCategory.clone());
	}

	public int compareTo(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory) {
		return _vcmsCategory.compareTo(vcmsCategory);
	}

	@Override
	public int hashCode() {
		return _vcmsCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsCategory> toCacheModel() {
		return _vcmsCategory.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsCategory toEscapedModel() {
		return new VcmsCategoryWrapper(_vcmsCategory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsCategory.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsCategory getWrappedVcmsCategory() {
		return _vcmsCategory;
	}

	public VcmsCategory getWrappedModel() {
		return _vcmsCategory;
	}

	public void resetOriginalValues() {
		_vcmsCategory.resetOriginalValues();
	}

	private VcmsCategory _vcmsCategory;
}