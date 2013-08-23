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

package com.vportal.portlet.vlinksman.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Links}.
 * </p>
 *
 * @author    LongLH
 * @see       Links
 * @generated
 */
public class LinksWrapper implements Links, ModelWrapper<Links> {
	public LinksWrapper(Links links) {
		_links = links;
	}

	public Class<?> getModelClass() {
		return Links.class;
	}

	public String getModelClassName() {
		return Links.class.getName();
	}

	/**
	* Returns the primary key of this links.
	*
	* @return the primary key of this links
	*/
	public long getPrimaryKey() {
		return _links.getPrimaryKey();
	}

	/**
	* Sets the primary key of this links.
	*
	* @param primaryKey the primary key of this links
	*/
	public void setPrimaryKey(long primaryKey) {
		_links.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the link ID of this links.
	*
	* @return the link ID of this links
	*/
	public long getLinkId() {
		return _links.getLinkId();
	}

	/**
	* Sets the link ID of this links.
	*
	* @param linkId the link ID of this links
	*/
	public void setLinkId(long linkId) {
		_links.setLinkId(linkId);
	}

	/**
	* Returns the group ID of this links.
	*
	* @return the group ID of this links
	*/
	public long getGroupId() {
		return _links.getGroupId();
	}

	/**
	* Sets the group ID of this links.
	*
	* @param groupId the group ID of this links
	*/
	public void setGroupId(long groupId) {
		_links.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this links.
	*
	* @return the company ID of this links
	*/
	public long getCompanyId() {
		return _links.getCompanyId();
	}

	/**
	* Sets the company ID of this links.
	*
	* @param companyId the company ID of this links
	*/
	public void setCompanyId(long companyId) {
		_links.setCompanyId(companyId);
	}

	/**
	* Returns the created date of this links.
	*
	* @return the created date of this links
	*/
	public java.util.Date getCreatedDate() {
		return _links.getCreatedDate();
	}

	/**
	* Sets the created date of this links.
	*
	* @param createdDate the created date of this links
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_links.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this links.
	*
	* @return the modified date of this links
	*/
	public java.util.Date getModifiedDate() {
		return _links.getModifiedDate();
	}

	/**
	* Sets the modified date of this links.
	*
	* @param modifiedDate the modified date of this links
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_links.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the linkgroup ID of this links.
	*
	* @return the linkgroup ID of this links
	*/
	public long getLinkgroupId() {
		return _links.getLinkgroupId();
	}

	/**
	* Sets the linkgroup ID of this links.
	*
	* @param linkgroupId the linkgroup ID of this links
	*/
	public void setLinkgroupId(long linkgroupId) {
		_links.setLinkgroupId(linkgroupId);
	}

	/**
	* Returns the name of this links.
	*
	* @return the name of this links
	*/
	public java.lang.String getName() {
		return _links.getName();
	}

	/**
	* Sets the name of this links.
	*
	* @param name the name of this links
	*/
	public void setName(java.lang.String name) {
		_links.setName(name);
	}

	/**
	* Returns the description of this links.
	*
	* @return the description of this links
	*/
	public java.lang.String getDescription() {
		return _links.getDescription();
	}

	/**
	* Sets the description of this links.
	*
	* @param description the description of this links
	*/
	public void setDescription(java.lang.String description) {
		_links.setDescription(description);
	}

	/**
	* Returns the url of this links.
	*
	* @return the url of this links
	*/
	public java.lang.String getUrl() {
		return _links.getUrl();
	}

	/**
	* Sets the url of this links.
	*
	* @param url the url of this links
	*/
	public void setUrl(java.lang.String url) {
		_links.setUrl(url);
	}

	/**
	* Returns the position of this links.
	*
	* @return the position of this links
	*/
	public long getPosition() {
		return _links.getPosition();
	}

	/**
	* Sets the position of this links.
	*
	* @param position the position of this links
	*/
	public void setPosition(long position) {
		_links.setPosition(position);
	}

	/**
	* Returns the has image of this links.
	*
	* @return the has image of this links
	*/
	public boolean getHasImage() {
		return _links.getHasImage();
	}

	/**
	* Returns <code>true</code> if this links is has image.
	*
	* @return <code>true</code> if this links is has image; <code>false</code> otherwise
	*/
	public boolean isHasImage() {
		return _links.isHasImage();
	}

	/**
	* Sets whether this links is has image.
	*
	* @param hasImage the has image of this links
	*/
	public void setHasImage(boolean hasImage) {
		_links.setHasImage(hasImage);
	}

	/**
	* Returns the is target blank of this links.
	*
	* @return the is target blank of this links
	*/
	public boolean getIsTargetBlank() {
		return _links.getIsTargetBlank();
	}

	/**
	* Returns <code>true</code> if this links is is target blank.
	*
	* @return <code>true</code> if this links is is target blank; <code>false</code> otherwise
	*/
	public boolean isIsTargetBlank() {
		return _links.isIsTargetBlank();
	}

	/**
	* Sets whether this links is is target blank.
	*
	* @param isTargetBlank the is target blank of this links
	*/
	public void setIsTargetBlank(boolean isTargetBlank) {
		_links.setIsTargetBlank(isTargetBlank);
	}

	/**
	* Returns the image name of this links.
	*
	* @return the image name of this links
	*/
	public java.lang.String getImageName() {
		return _links.getImageName();
	}

	/**
	* Sets the image name of this links.
	*
	* @param imageName the image name of this links
	*/
	public void setImageName(java.lang.String imageName) {
		_links.setImageName(imageName);
	}

	/**
	* Returns the folder ID of this links.
	*
	* @return the folder ID of this links
	*/
	public long getFolderId() {
		return _links.getFolderId();
	}

	/**
	* Sets the folder ID of this links.
	*
	* @param folderId the folder ID of this links
	*/
	public void setFolderId(long folderId) {
		_links.setFolderId(folderId);
	}

	public boolean isNew() {
		return _links.isNew();
	}

	public void setNew(boolean n) {
		_links.setNew(n);
	}

	public boolean isCachedModel() {
		return _links.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_links.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _links.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _links.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_links.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _links.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_links.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LinksWrapper((Links)_links.clone());
	}

	public int compareTo(com.vportal.portlet.vlinksman.model.Links links) {
		return _links.compareTo(links);
	}

	@Override
	public int hashCode() {
		return _links.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vlinksman.model.Links> toCacheModel() {
		return _links.toCacheModel();
	}

	public com.vportal.portlet.vlinksman.model.Links toEscapedModel() {
		return new LinksWrapper(_links.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _links.toString();
	}

	public java.lang.String toXmlString() {
		return _links.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Links getWrappedLinks() {
		return _links;
	}

	public Links getWrappedModel() {
		return _links;
	}

	public void resetOriginalValues() {
		_links.resetOriginalValues();
	}

	private Links _links;
}