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
 * This class is a wrapper for {@link VcmsArticleVersion}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticleVersion
 * @generated
 */
public class VcmsArticleVersionWrapper implements VcmsArticleVersion,
	ModelWrapper<VcmsArticleVersion> {
	public VcmsArticleVersionWrapper(VcmsArticleVersion vcmsArticleVersion) {
		_vcmsArticleVersion = vcmsArticleVersion;
	}

	public Class<?> getModelClass() {
		return VcmsArticleVersion.class;
	}

	public String getModelClassName() {
		return VcmsArticleVersion.class.getName();
	}

	/**
	* Returns the primary key of this vcms article version.
	*
	* @return the primary key of this vcms article version
	*/
	public long getPrimaryKey() {
		return _vcmsArticleVersion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms article version.
	*
	* @param primaryKey the primary key of this vcms article version
	*/
	public void setPrimaryKey(long primaryKey) {
		_vcmsArticleVersion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the article version ID of this vcms article version.
	*
	* @return the article version ID of this vcms article version
	*/
	public long getArticleVersionId() {
		return _vcmsArticleVersion.getArticleVersionId();
	}

	/**
	* Sets the article version ID of this vcms article version.
	*
	* @param articleVersionId the article version ID of this vcms article version
	*/
	public void setArticleVersionId(long articleVersionId) {
		_vcmsArticleVersion.setArticleVersionId(articleVersionId);
	}

	/**
	* Returns the group ID of this vcms article version.
	*
	* @return the group ID of this vcms article version
	*/
	public long getGroupId() {
		return _vcmsArticleVersion.getGroupId();
	}

	/**
	* Sets the group ID of this vcms article version.
	*
	* @param groupId the group ID of this vcms article version
	*/
	public void setGroupId(long groupId) {
		_vcmsArticleVersion.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vcms article version.
	*
	* @return the company ID of this vcms article version
	*/
	public long getCompanyId() {
		return _vcmsArticleVersion.getCompanyId();
	}

	/**
	* Sets the company ID of this vcms article version.
	*
	* @param companyId the company ID of this vcms article version
	*/
	public void setCompanyId(long companyId) {
		_vcmsArticleVersion.setCompanyId(companyId);
	}

	/**
	* Returns the article ID of this vcms article version.
	*
	* @return the article ID of this vcms article version
	*/
	public java.lang.String getArticleId() {
		return _vcmsArticleVersion.getArticleId();
	}

	/**
	* Sets the article ID of this vcms article version.
	*
	* @param articleId the article ID of this vcms article version
	*/
	public void setArticleId(java.lang.String articleId) {
		_vcmsArticleVersion.setArticleId(articleId);
	}

	/**
	* Returns the created by user of this vcms article version.
	*
	* @return the created by user of this vcms article version
	*/
	public java.lang.String getCreatedByUser() {
		return _vcmsArticleVersion.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vcms article version.
	*
	* @param createdByUser the created by user of this vcms article version
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_vcmsArticleVersion.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the created date of this vcms article version.
	*
	* @return the created date of this vcms article version
	*/
	public java.util.Date getCreatedDate() {
		return _vcmsArticleVersion.getCreatedDate();
	}

	/**
	* Sets the created date of this vcms article version.
	*
	* @param createdDate the created date of this vcms article version
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vcmsArticleVersion.setCreatedDate(createdDate);
	}

	/**
	* Returns the type IDs of this vcms article version.
	*
	* @return the type IDs of this vcms article version
	*/
	public java.lang.String getTypeIds() {
		return _vcmsArticleVersion.getTypeIds();
	}

	/**
	* Sets the type IDs of this vcms article version.
	*
	* @param typeIds the type IDs of this vcms article version
	*/
	public void setTypeIds(java.lang.String typeIds) {
		_vcmsArticleVersion.setTypeIds(typeIds);
	}

	/**
	* Returns the status of this vcms article version.
	*
	* @return the status of this vcms article version
	*/
	public long getStatus() {
		return _vcmsArticleVersion.getStatus();
	}

	/**
	* Sets the status of this vcms article version.
	*
	* @param status the status of this vcms article version
	*/
	public void setStatus(long status) {
		_vcmsArticleVersion.setStatus(status);
	}

	/**
	* Returns the version name of this vcms article version.
	*
	* @return the version name of this vcms article version
	*/
	public java.lang.String getVersionName() {
		return _vcmsArticleVersion.getVersionName();
	}

	/**
	* Sets the version name of this vcms article version.
	*
	* @param versionName the version name of this vcms article version
	*/
	public void setVersionName(java.lang.String versionName) {
		_vcmsArticleVersion.setVersionName(versionName);
	}

	/**
	* Returns the title of this vcms article version.
	*
	* @return the title of this vcms article version
	*/
	public java.lang.String getTitle() {
		return _vcmsArticleVersion.getTitle();
	}

	/**
	* Sets the title of this vcms article version.
	*
	* @param title the title of this vcms article version
	*/
	public void setTitle(java.lang.String title) {
		_vcmsArticleVersion.setTitle(title);
	}

	/**
	* Returns the lead of this vcms article version.
	*
	* @return the lead of this vcms article version
	*/
	public java.lang.String getLead() {
		return _vcmsArticleVersion.getLead();
	}

	/**
	* Sets the lead of this vcms article version.
	*
	* @param lead the lead of this vcms article version
	*/
	public void setLead(java.lang.String lead) {
		_vcmsArticleVersion.setLead(lead);
	}

	/**
	* Returns the content of this vcms article version.
	*
	* @return the content of this vcms article version
	*/
	public java.lang.String getContent() {
		return _vcmsArticleVersion.getContent();
	}

	/**
	* Sets the content of this vcms article version.
	*
	* @param content the content of this vcms article version
	*/
	public void setContent(java.lang.String content) {
		_vcmsArticleVersion.setContent(content);
	}

	/**
	* Returns the has image of this vcms article version.
	*
	* @return the has image of this vcms article version
	*/
	public boolean getHasImage() {
		return _vcmsArticleVersion.getHasImage();
	}

	/**
	* Returns <code>true</code> if this vcms article version is has image.
	*
	* @return <code>true</code> if this vcms article version is has image; <code>false</code> otherwise
	*/
	public boolean isHasImage() {
		return _vcmsArticleVersion.isHasImage();
	}

	/**
	* Sets whether this vcms article version is has image.
	*
	* @param hasImage the has image of this vcms article version
	*/
	public void setHasImage(boolean hasImage) {
		_vcmsArticleVersion.setHasImage(hasImage);
	}

	/**
	* Returns the image title of this vcms article version.
	*
	* @return the image title of this vcms article version
	*/
	public java.lang.String getImageTitle() {
		return _vcmsArticleVersion.getImageTitle();
	}

	/**
	* Sets the image title of this vcms article version.
	*
	* @param imageTitle the image title of this vcms article version
	*/
	public void setImageTitle(java.lang.String imageTitle) {
		_vcmsArticleVersion.setImageTitle(imageTitle);
	}

	/**
	* Returns the image of this vcms article version.
	*
	* @return the image of this vcms article version
	*/
	public java.lang.String getImage() {
		return _vcmsArticleVersion.getImage();
	}

	/**
	* Sets the image of this vcms article version.
	*
	* @param image the image of this vcms article version
	*/
	public void setImage(java.lang.String image) {
		_vcmsArticleVersion.setImage(image);
	}

	/**
	* Returns the language of this vcms article version.
	*
	* @return the language of this vcms article version
	*/
	public java.lang.String getLanguage() {
		return _vcmsArticleVersion.getLanguage();
	}

	/**
	* Sets the language of this vcms article version.
	*
	* @param language the language of this vcms article version
	*/
	public void setLanguage(java.lang.String language) {
		_vcmsArticleVersion.setLanguage(language);
	}

	/**
	* Returns the user hit of this vcms article version.
	*
	* @return the user hit of this vcms article version
	*/
	public long getUserHit() {
		return _vcmsArticleVersion.getUserHit();
	}

	/**
	* Sets the user hit of this vcms article version.
	*
	* @param userHit the user hit of this vcms article version
	*/
	public void setUserHit(long userHit) {
		_vcmsArticleVersion.setUserHit(userHit);
	}

	/**
	* Returns the author of this vcms article version.
	*
	* @return the author of this vcms article version
	*/
	public java.lang.String getAuthor() {
		return _vcmsArticleVersion.getAuthor();
	}

	/**
	* Sets the author of this vcms article version.
	*
	* @param author the author of this vcms article version
	*/
	public void setAuthor(java.lang.String author) {
		_vcmsArticleVersion.setAuthor(author);
	}

	/**
	* Returns the source of this vcms article version.
	*
	* @return the source of this vcms article version
	*/
	public java.lang.String getSource() {
		return _vcmsArticleVersion.getSource();
	}

	/**
	* Sets the source of this vcms article version.
	*
	* @param source the source of this vcms article version
	*/
	public void setSource(java.lang.String source) {
		_vcmsArticleVersion.setSource(source);
	}

	/**
	* Returns the discussible of this vcms article version.
	*
	* @return the discussible of this vcms article version
	*/
	public boolean getDiscussible() {
		return _vcmsArticleVersion.getDiscussible();
	}

	/**
	* Returns <code>true</code> if this vcms article version is discussible.
	*
	* @return <code>true</code> if this vcms article version is discussible; <code>false</code> otherwise
	*/
	public boolean isDiscussible() {
		return _vcmsArticleVersion.isDiscussible();
	}

	/**
	* Sets whether this vcms article version is discussible.
	*
	* @param discussible the discussible of this vcms article version
	*/
	public void setDiscussible(boolean discussible) {
		_vcmsArticleVersion.setDiscussible(discussible);
	}

	/**
	* Returns the has attachment of this vcms article version.
	*
	* @return the has attachment of this vcms article version
	*/
	public boolean getHasAttachment() {
		return _vcmsArticleVersion.getHasAttachment();
	}

	/**
	* Returns <code>true</code> if this vcms article version is has attachment.
	*
	* @return <code>true</code> if this vcms article version is has attachment; <code>false</code> otherwise
	*/
	public boolean isHasAttachment() {
		return _vcmsArticleVersion.isHasAttachment();
	}

	/**
	* Sets whether this vcms article version is has attachment.
	*
	* @param hasAttachment the has attachment of this vcms article version
	*/
	public void setHasAttachment(boolean hasAttachment) {
		_vcmsArticleVersion.setHasAttachment(hasAttachment);
	}

	/**
	* Returns the has poll of this vcms article version.
	*
	* @return the has poll of this vcms article version
	*/
	public boolean getHasPoll() {
		return _vcmsArticleVersion.getHasPoll();
	}

	/**
	* Returns <code>true</code> if this vcms article version is has poll.
	*
	* @return <code>true</code> if this vcms article version is has poll; <code>false</code> otherwise
	*/
	public boolean isHasPoll() {
		return _vcmsArticleVersion.isHasPoll();
	}

	/**
	* Sets whether this vcms article version is has poll.
	*
	* @param hasPoll the has poll of this vcms article version
	*/
	public void setHasPoll(boolean hasPoll) {
		_vcmsArticleVersion.setHasPoll(hasPoll);
	}

	/**
	* Returns the poll ID of this vcms article version.
	*
	* @return the poll ID of this vcms article version
	*/
	public java.lang.String getPollId() {
		return _vcmsArticleVersion.getPollId();
	}

	/**
	* Sets the poll ID of this vcms article version.
	*
	* @param pollId the poll ID of this vcms article version
	*/
	public void setPollId(java.lang.String pollId) {
		_vcmsArticleVersion.setPollId(pollId);
	}

	/**
	* Returns the effective date of this vcms article version.
	*
	* @return the effective date of this vcms article version
	*/
	public java.util.Date getEffectiveDate() {
		return _vcmsArticleVersion.getEffectiveDate();
	}

	/**
	* Sets the effective date of this vcms article version.
	*
	* @param effectiveDate the effective date of this vcms article version
	*/
	public void setEffectiveDate(java.util.Date effectiveDate) {
		_vcmsArticleVersion.setEffectiveDate(effectiveDate);
	}

	/**
	* Returns the expire date of this vcms article version.
	*
	* @return the expire date of this vcms article version
	*/
	public java.util.Date getExpireDate() {
		return _vcmsArticleVersion.getExpireDate();
	}

	/**
	* Sets the expire date of this vcms article version.
	*
	* @param expireDate the expire date of this vcms article version
	*/
	public void setExpireDate(java.util.Date expireDate) {
		_vcmsArticleVersion.setExpireDate(expireDate);
	}

	/**
	* Returns the sticky of this vcms article version.
	*
	* @return the sticky of this vcms article version
	*/
	public boolean getSticky() {
		return _vcmsArticleVersion.getSticky();
	}

	/**
	* Returns <code>true</code> if this vcms article version is sticky.
	*
	* @return <code>true</code> if this vcms article version is sticky; <code>false</code> otherwise
	*/
	public boolean isSticky() {
		return _vcmsArticleVersion.isSticky();
	}

	/**
	* Sets whether this vcms article version is sticky.
	*
	* @param sticky the sticky of this vcms article version
	*/
	public void setSticky(boolean sticky) {
		_vcmsArticleVersion.setSticky(sticky);
	}

	/**
	* Returns the sticky never expired of this vcms article version.
	*
	* @return the sticky never expired of this vcms article version
	*/
	public boolean getStickyNeverExpired() {
		return _vcmsArticleVersion.getStickyNeverExpired();
	}

	/**
	* Returns <code>true</code> if this vcms article version is sticky never expired.
	*
	* @return <code>true</code> if this vcms article version is sticky never expired; <code>false</code> otherwise
	*/
	public boolean isStickyNeverExpired() {
		return _vcmsArticleVersion.isStickyNeverExpired();
	}

	/**
	* Sets whether this vcms article version is sticky never expired.
	*
	* @param stickyNeverExpired the sticky never expired of this vcms article version
	*/
	public void setStickyNeverExpired(boolean stickyNeverExpired) {
		_vcmsArticleVersion.setStickyNeverExpired(stickyNeverExpired);
	}

	/**
	* Returns the sticky expire date of this vcms article version.
	*
	* @return the sticky expire date of this vcms article version
	*/
	public java.util.Date getStickyExpireDate() {
		return _vcmsArticleVersion.getStickyExpireDate();
	}

	/**
	* Sets the sticky expire date of this vcms article version.
	*
	* @param stickyExpireDate the sticky expire date of this vcms article version
	*/
	public void setStickyExpireDate(java.util.Date stickyExpireDate) {
		_vcmsArticleVersion.setStickyExpireDate(stickyExpireDate);
	}

	public boolean isNew() {
		return _vcmsArticleVersion.isNew();
	}

	public void setNew(boolean n) {
		_vcmsArticleVersion.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsArticleVersion.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsArticleVersion.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsArticleVersion.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsArticleVersion.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsArticleVersion.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsArticleVersion.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsArticleVersion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsArticleVersionWrapper((VcmsArticleVersion)_vcmsArticleVersion.clone());
	}

	public int compareTo(
		com.vportal.portlet.vcms.model.VcmsArticleVersion vcmsArticleVersion) {
		return _vcmsArticleVersion.compareTo(vcmsArticleVersion);
	}

	@Override
	public int hashCode() {
		return _vcmsArticleVersion.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsArticleVersion> toCacheModel() {
		return _vcmsArticleVersion.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsArticleVersion toEscapedModel() {
		return new VcmsArticleVersionWrapper(_vcmsArticleVersion.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsArticleVersion.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsArticleVersion.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleVersion.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsArticleVersion getWrappedVcmsArticleVersion() {
		return _vcmsArticleVersion;
	}

	public VcmsArticleVersion getWrappedModel() {
		return _vcmsArticleVersion;
	}

	public void resetOriginalValues() {
		_vcmsArticleVersion.resetOriginalValues();
	}

	private VcmsArticleVersion _vcmsArticleVersion;
}