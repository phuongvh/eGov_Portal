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
 * This class is a wrapper for {@link TFImage}.
 * </p>
 *
 * @author    DucNN
 * @see       TFImage
 * @generated
 */
public class TFImageWrapper implements TFImage, ModelWrapper<TFImage> {
	public TFImageWrapper(TFImage tfImage) {
		_tfImage = tfImage;
	}

	public Class<?> getModelClass() {
		return TFImage.class;
	}

	public String getModelClassName() {
		return TFImage.class.getName();
	}

	/**
	* Returns the primary key of this t f image.
	*
	* @return the primary key of this t f image
	*/
	public long getPrimaryKey() {
		return _tfImage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this t f image.
	*
	* @param primaryKey the primary key of this t f image
	*/
	public void setPrimaryKey(long primaryKey) {
		_tfImage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this t f image.
	*
	* @return the ID of this t f image
	*/
	public long getId() {
		return _tfImage.getId();
	}

	/**
	* Sets the ID of this t f image.
	*
	* @param id the ID of this t f image
	*/
	public void setId(long id) {
		_tfImage.setId(id);
	}

	/**
	* Returns the group ID of this t f image.
	*
	* @return the group ID of this t f image
	*/
	public long getGroupId() {
		return _tfImage.getGroupId();
	}

	/**
	* Sets the group ID of this t f image.
	*
	* @param groupId the group ID of this t f image
	*/
	public void setGroupId(long groupId) {
		_tfImage.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this t f image.
	*
	* @return the company ID of this t f image
	*/
	public long getCompanyId() {
		return _tfImage.getCompanyId();
	}

	/**
	* Sets the company ID of this t f image.
	*
	* @param companyId the company ID of this t f image
	*/
	public void setCompanyId(long companyId) {
		_tfImage.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this t f image.
	*
	* @return the user ID of this t f image
	*/
	public long getUserId() {
		return _tfImage.getUserId();
	}

	/**
	* Sets the user ID of this t f image.
	*
	* @param userId the user ID of this t f image
	*/
	public void setUserId(long userId) {
		_tfImage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this t f image.
	*
	* @return the user uuid of this t f image
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tfImage.getUserUuid();
	}

	/**
	* Sets the user uuid of this t f image.
	*
	* @param userUuid the user uuid of this t f image
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_tfImage.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this t f image.
	*
	* @return the create date of this t f image
	*/
	public java.util.Date getCreateDate() {
		return _tfImage.getCreateDate();
	}

	/**
	* Sets the create date of this t f image.
	*
	* @param createDate the create date of this t f image
	*/
	public void setCreateDate(java.util.Date createDate) {
		_tfImage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this t f image.
	*
	* @return the modified date of this t f image
	*/
	public java.util.Date getModifiedDate() {
		return _tfImage.getModifiedDate();
	}

	/**
	* Sets the modified date of this t f image.
	*
	* @param modifiedDate the modified date of this t f image
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tfImage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category ID of this t f image.
	*
	* @return the category ID of this t f image
	*/
	public long getCategoryId() {
		return _tfImage.getCategoryId();
	}

	/**
	* Sets the category ID of this t f image.
	*
	* @param categoryId the category ID of this t f image
	*/
	public void setCategoryId(long categoryId) {
		_tfImage.setCategoryId(categoryId);
	}

	/**
	* Returns the name of this t f image.
	*
	* @return the name of this t f image
	*/
	public java.lang.String getName() {
		return _tfImage.getName();
	}

	/**
	* Sets the name of this t f image.
	*
	* @param name the name of this t f image
	*/
	public void setName(java.lang.String name) {
		_tfImage.setName(name);
	}

	/**
	* Returns the description of this t f image.
	*
	* @return the description of this t f image
	*/
	public java.lang.String getDescription() {
		return _tfImage.getDescription();
	}

	/**
	* Sets the description of this t f image.
	*
	* @param description the description of this t f image
	*/
	public void setDescription(java.lang.String description) {
		_tfImage.setDescription(description);
	}

	/**
	* Returns the image of this t f image.
	*
	* @return the image of this t f image
	*/
	public java.lang.String getImage() {
		return _tfImage.getImage();
	}

	/**
	* Sets the image of this t f image.
	*
	* @param image the image of this t f image
	*/
	public void setImage(java.lang.String image) {
		_tfImage.setImage(image);
	}

	/**
	* Returns the is show of this t f image.
	*
	* @return the is show of this t f image
	*/
	public boolean getIsShow() {
		return _tfImage.getIsShow();
	}

	/**
	* Returns <code>true</code> if this t f image is is show.
	*
	* @return <code>true</code> if this t f image is is show; <code>false</code> otherwise
	*/
	public boolean isIsShow() {
		return _tfImage.isIsShow();
	}

	/**
	* Sets whether this t f image is is show.
	*
	* @param isShow the is show of this t f image
	*/
	public void setIsShow(boolean isShow) {
		_tfImage.setIsShow(isShow);
	}

	public boolean isNew() {
		return _tfImage.isNew();
	}

	public void setNew(boolean n) {
		_tfImage.setNew(n);
	}

	public boolean isCachedModel() {
		return _tfImage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tfImage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tfImage.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tfImage.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tfImage.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tfImage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tfImage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TFImageWrapper((TFImage)_tfImage.clone());
	}

	public int compareTo(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage) {
		return _tfImage.compareTo(tfImage);
	}

	@Override
	public int hashCode() {
		return _tfImage.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vimagegallery.model.TFImage> toCacheModel() {
		return _tfImage.toCacheModel();
	}

	public com.vportal.portlet.vimagegallery.model.TFImage toEscapedModel() {
		return new TFImageWrapper(_tfImage.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tfImage.toString();
	}

	public java.lang.String toXmlString() {
		return _tfImage.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TFImage getWrappedTFImage() {
		return _tfImage;
	}

	public TFImage getWrappedModel() {
		return _tfImage;
	}

	public void resetOriginalValues() {
		_tfImage.resetOriginalValues();
	}

	private TFImage _tfImage;
}