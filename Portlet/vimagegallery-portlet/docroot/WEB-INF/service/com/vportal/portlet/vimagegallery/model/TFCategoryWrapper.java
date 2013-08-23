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

package com.vportal.portlet.vimagegallery.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TFCategory}.
 * </p>
 *
 * @author    DucNN
 * @see       TFCategory
 * @generated
 */
public class TFCategoryWrapper implements TFCategory, ModelWrapper<TFCategory> {
	public TFCategoryWrapper(TFCategory tfCategory) {
		_tfCategory = tfCategory;
	}

	public Class<?> getModelClass() {
		return TFCategory.class;
	}

	public String getModelClassName() {
		return TFCategory.class.getName();
	}

	/**
	* Returns the primary key of this t f category.
	*
	* @return the primary key of this t f category
	*/
	public long getPrimaryKey() {
		return _tfCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this t f category.
	*
	* @param primaryKey the primary key of this t f category
	*/
	public void setPrimaryKey(long primaryKey) {
		_tfCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this t f category.
	*
	* @return the ID of this t f category
	*/
	public long getId() {
		return _tfCategory.getId();
	}

	/**
	* Sets the ID of this t f category.
	*
	* @param id the ID of this t f category
	*/
	public void setId(long id) {
		_tfCategory.setId(id);
	}

	/**
	* Returns the group ID of this t f category.
	*
	* @return the group ID of this t f category
	*/
	public long getGroupId() {
		return _tfCategory.getGroupId();
	}

	/**
	* Sets the group ID of this t f category.
	*
	* @param groupId the group ID of this t f category
	*/
	public void setGroupId(long groupId) {
		_tfCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this t f category.
	*
	* @return the company ID of this t f category
	*/
	public long getCompanyId() {
		return _tfCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this t f category.
	*
	* @param companyId the company ID of this t f category
	*/
	public void setCompanyId(long companyId) {
		_tfCategory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this t f category.
	*
	* @return the user ID of this t f category
	*/
	public long getUserId() {
		return _tfCategory.getUserId();
	}

	/**
	* Sets the user ID of this t f category.
	*
	* @param userId the user ID of this t f category
	*/
	public void setUserId(long userId) {
		_tfCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this t f category.
	*
	* @return the user uuid of this t f category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tfCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this t f category.
	*
	* @param userUuid the user uuid of this t f category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_tfCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this t f category.
	*
	* @return the create date of this t f category
	*/
	public java.util.Date getCreateDate() {
		return _tfCategory.getCreateDate();
	}

	/**
	* Sets the create date of this t f category.
	*
	* @param createDate the create date of this t f category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_tfCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this t f category.
	*
	* @return the modified date of this t f category
	*/
	public java.util.Date getModifiedDate() {
		return _tfCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this t f category.
	*
	* @param modifiedDate the modified date of this t f category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tfCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this t f category.
	*
	* @return the name of this t f category
	*/
	public java.lang.String getName() {
		return _tfCategory.getName();
	}

	/**
	* Sets the name of this t f category.
	*
	* @param name the name of this t f category
	*/
	public void setName(java.lang.String name) {
		_tfCategory.setName(name);
	}

	/**
	* Returns the description of this t f category.
	*
	* @return the description of this t f category
	*/
	public java.lang.String getDescription() {
		return _tfCategory.getDescription();
	}

	/**
	* Sets the description of this t f category.
	*
	* @param description the description of this t f category
	*/
	public void setDescription(java.lang.String description) {
		_tfCategory.setDescription(description);
	}

	/**
	* Returns the image of this t f category.
	*
	* @return the image of this t f category
	*/
	public java.lang.String getImage() {
		return _tfCategory.getImage();
	}

	/**
	* Sets the image of this t f category.
	*
	* @param image the image of this t f category
	*/
	public void setImage(java.lang.String image) {
		_tfCategory.setImage(image);
	}

	public boolean isNew() {
		return _tfCategory.isNew();
	}

	public void setNew(boolean n) {
		_tfCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _tfCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tfCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tfCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tfCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tfCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tfCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tfCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TFCategoryWrapper((TFCategory)_tfCategory.clone());
	}

	public int compareTo(
		com.vportal.portlet.vimagegallery.model.TFCategory tfCategory) {
		return _tfCategory.compareTo(tfCategory);
	}

	@Override
	public int hashCode() {
		return _tfCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vimagegallery.model.TFCategory> toCacheModel() {
		return _tfCategory.toCacheModel();
	}

	public com.vportal.portlet.vimagegallery.model.TFCategory toEscapedModel() {
		return new TFCategoryWrapper(_tfCategory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tfCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _tfCategory.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TFCategory getWrappedTFCategory() {
		return _tfCategory;
	}

	public TFCategory getWrappedModel() {
		return _tfCategory;
	}

	public void resetOriginalValues() {
		_tfCategory.resetOriginalValues();
	}

	private TFCategory _tfCategory;
}