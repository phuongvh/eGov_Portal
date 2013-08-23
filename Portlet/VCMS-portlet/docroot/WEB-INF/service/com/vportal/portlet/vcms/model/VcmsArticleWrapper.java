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
 * This class is a wrapper for {@link VcmsArticle}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticle
 * @generated
 */
public class VcmsArticleWrapper implements VcmsArticle,
	ModelWrapper<VcmsArticle> {
	public VcmsArticleWrapper(VcmsArticle vcmsArticle) {
		_vcmsArticle = vcmsArticle;
	}

	public Class<?> getModelClass() {
		return VcmsArticle.class;
	}

	public String getModelClassName() {
		return VcmsArticle.class.getName();
	}

	/**
	* Returns the primary key of this vcms article.
	*
	* @return the primary key of this vcms article
	*/
	public java.lang.String getPrimaryKey() {
		return _vcmsArticle.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms article.
	*
	* @param primaryKey the primary key of this vcms article
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vcmsArticle.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the article ID of this vcms article.
	*
	* @return the article ID of this vcms article
	*/
	public java.lang.String getArticleId() {
		return _vcmsArticle.getArticleId();
	}

	/**
	* Sets the article ID of this vcms article.
	*
	* @param articleId the article ID of this vcms article
	*/
	public void setArticleId(java.lang.String articleId) {
		_vcmsArticle.setArticleId(articleId);
	}

	/**
	* Returns the group ID of this vcms article.
	*
	* @return the group ID of this vcms article
	*/
	public long getGroupId() {
		return _vcmsArticle.getGroupId();
	}

	/**
	* Sets the group ID of this vcms article.
	*
	* @param groupId the group ID of this vcms article
	*/
	public void setGroupId(long groupId) {
		_vcmsArticle.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vcms article.
	*
	* @return the company ID of this vcms article
	*/
	public long getCompanyId() {
		return _vcmsArticle.getCompanyId();
	}

	/**
	* Sets the company ID of this vcms article.
	*
	* @param companyId the company ID of this vcms article
	*/
	public void setCompanyId(long companyId) {
		_vcmsArticle.setCompanyId(companyId);
	}

	/**
	* Returns the created by user of this vcms article.
	*
	* @return the created by user of this vcms article
	*/
	public java.lang.String getCreatedByUser() {
		return _vcmsArticle.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vcms article.
	*
	* @param createdByUser the created by user of this vcms article
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_vcmsArticle.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the created date of this vcms article.
	*
	* @return the created date of this vcms article
	*/
	public java.util.Date getCreatedDate() {
		return _vcmsArticle.getCreatedDate();
	}

	/**
	* Sets the created date of this vcms article.
	*
	* @param createdDate the created date of this vcms article
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vcmsArticle.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified by user of this vcms article.
	*
	* @return the modified by user of this vcms article
	*/
	public java.lang.String getModifiedByUser() {
		return _vcmsArticle.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this vcms article.
	*
	* @param modifiedByUser the modified by user of this vcms article
	*/
	public void setModifiedByUser(java.lang.String modifiedByUser) {
		_vcmsArticle.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the modified date of this vcms article.
	*
	* @return the modified date of this vcms article
	*/
	public java.util.Date getModifiedDate() {
		return _vcmsArticle.getModifiedDate();
	}

	/**
	* Sets the modified date of this vcms article.
	*
	* @param modifiedDate the modified date of this vcms article
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vcmsArticle.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the approved by user of this vcms article.
	*
	* @return the approved by user of this vcms article
	*/
	public java.lang.String getApprovedByUser() {
		return _vcmsArticle.getApprovedByUser();
	}

	/**
	* Sets the approved by user of this vcms article.
	*
	* @param approvedByUser the approved by user of this vcms article
	*/
	public void setApprovedByUser(java.lang.String approvedByUser) {
		_vcmsArticle.setApprovedByUser(approvedByUser);
	}

	/**
	* Returns the approved date of this vcms article.
	*
	* @return the approved date of this vcms article
	*/
	public java.util.Date getApprovedDate() {
		return _vcmsArticle.getApprovedDate();
	}

	/**
	* Sets the approved date of this vcms article.
	*
	* @param approvedDate the approved date of this vcms article
	*/
	public void setApprovedDate(java.util.Date approvedDate) {
		_vcmsArticle.setApprovedDate(approvedDate);
	}

	/**
	* Returns the published by user of this vcms article.
	*
	* @return the published by user of this vcms article
	*/
	public java.lang.String getPublishedByUser() {
		return _vcmsArticle.getPublishedByUser();
	}

	/**
	* Sets the published by user of this vcms article.
	*
	* @param publishedByUser the published by user of this vcms article
	*/
	public void setPublishedByUser(java.lang.String publishedByUser) {
		_vcmsArticle.setPublishedByUser(publishedByUser);
	}

	/**
	* Returns the published date of this vcms article.
	*
	* @return the published date of this vcms article
	*/
	public java.util.Date getPublishedDate() {
		return _vcmsArticle.getPublishedDate();
	}

	/**
	* Sets the published date of this vcms article.
	*
	* @param publishedDate the published date of this vcms article
	*/
	public void setPublishedDate(java.util.Date publishedDate) {
		_vcmsArticle.setPublishedDate(publishedDate);
	}

	/**
	* Returns the status of this vcms article.
	*
	* @return the status of this vcms article
	*/
	public long getStatus() {
		return _vcmsArticle.getStatus();
	}

	/**
	* Sets the status of this vcms article.
	*
	* @param status the status of this vcms article
	*/
	public void setStatus(long status) {
		_vcmsArticle.setStatus(status);
	}

	/**
	* Returns the title of this vcms article.
	*
	* @return the title of this vcms article
	*/
	public java.lang.String getTitle() {
		return _vcmsArticle.getTitle();
	}

	/**
	* Sets the title of this vcms article.
	*
	* @param title the title of this vcms article
	*/
	public void setTitle(java.lang.String title) {
		_vcmsArticle.setTitle(title);
	}

	/**
	* Returns the lead of this vcms article.
	*
	* @return the lead of this vcms article
	*/
	public java.lang.String getLead() {
		return _vcmsArticle.getLead();
	}

	/**
	* Sets the lead of this vcms article.
	*
	* @param lead the lead of this vcms article
	*/
	public void setLead(java.lang.String lead) {
		_vcmsArticle.setLead(lead);
	}

	/**
	* Returns the content of this vcms article.
	*
	* @return the content of this vcms article
	*/
	public java.lang.String getContent() {
		return _vcmsArticle.getContent();
	}

	/**
	* Sets the content of this vcms article.
	*
	* @param content the content of this vcms article
	*/
	public void setContent(java.lang.String content) {
		_vcmsArticle.setContent(content);
	}

	/**
	* Returns the has image of this vcms article.
	*
	* @return the has image of this vcms article
	*/
	public boolean getHasImage() {
		return _vcmsArticle.getHasImage();
	}

	/**
	* Returns <code>true</code> if this vcms article is has image.
	*
	* @return <code>true</code> if this vcms article is has image; <code>false</code> otherwise
	*/
	public boolean isHasImage() {
		return _vcmsArticle.isHasImage();
	}

	/**
	* Sets whether this vcms article is has image.
	*
	* @param hasImage the has image of this vcms article
	*/
	public void setHasImage(boolean hasImage) {
		_vcmsArticle.setHasImage(hasImage);
	}

	/**
	* Returns the image title of this vcms article.
	*
	* @return the image title of this vcms article
	*/
	public java.lang.String getImageTitle() {
		return _vcmsArticle.getImageTitle();
	}

	/**
	* Sets the image title of this vcms article.
	*
	* @param imageTitle the image title of this vcms article
	*/
	public void setImageTitle(java.lang.String imageTitle) {
		_vcmsArticle.setImageTitle(imageTitle);
	}

	/**
	* Returns the image of this vcms article.
	*
	* @return the image of this vcms article
	*/
	public java.lang.String getImage() {
		return _vcmsArticle.getImage();
	}

	/**
	* Sets the image of this vcms article.
	*
	* @param image the image of this vcms article
	*/
	public void setImage(java.lang.String image) {
		_vcmsArticle.setImage(image);
	}

	/**
	* Returns the author of this vcms article.
	*
	* @return the author of this vcms article
	*/
	public java.lang.String getAuthor() {
		return _vcmsArticle.getAuthor();
	}

	/**
	* Sets the author of this vcms article.
	*
	* @param author the author of this vcms article
	*/
	public void setAuthor(java.lang.String author) {
		_vcmsArticle.setAuthor(author);
	}

	/**
	* Returns the source of this vcms article.
	*
	* @return the source of this vcms article
	*/
	public java.lang.String getSource() {
		return _vcmsArticle.getSource();
	}

	/**
	* Sets the source of this vcms article.
	*
	* @param source the source of this vcms article
	*/
	public void setSource(java.lang.String source) {
		_vcmsArticle.setSource(source);
	}

	/**
	* Returns the language of this vcms article.
	*
	* @return the language of this vcms article
	*/
	public java.lang.String getLanguage() {
		return _vcmsArticle.getLanguage();
	}

	/**
	* Sets the language of this vcms article.
	*
	* @param language the language of this vcms article
	*/
	public void setLanguage(java.lang.String language) {
		_vcmsArticle.setLanguage(language);
	}

	/**
	* Returns the user hit of this vcms article.
	*
	* @return the user hit of this vcms article
	*/
	public long getUserHit() {
		return _vcmsArticle.getUserHit();
	}

	/**
	* Sets the user hit of this vcms article.
	*
	* @param userHit the user hit of this vcms article
	*/
	public void setUserHit(long userHit) {
		_vcmsArticle.setUserHit(userHit);
	}

	/**
	* Returns the discussible of this vcms article.
	*
	* @return the discussible of this vcms article
	*/
	public boolean getDiscussible() {
		return _vcmsArticle.getDiscussible();
	}

	/**
	* Returns <code>true</code> if this vcms article is discussible.
	*
	* @return <code>true</code> if this vcms article is discussible; <code>false</code> otherwise
	*/
	public boolean isDiscussible() {
		return _vcmsArticle.isDiscussible();
	}

	/**
	* Sets whether this vcms article is discussible.
	*
	* @param discussible the discussible of this vcms article
	*/
	public void setDiscussible(boolean discussible) {
		_vcmsArticle.setDiscussible(discussible);
	}

	/**
	* Returns the has attachment of this vcms article.
	*
	* @return the has attachment of this vcms article
	*/
	public boolean getHasAttachment() {
		return _vcmsArticle.getHasAttachment();
	}

	/**
	* Returns <code>true</code> if this vcms article is has attachment.
	*
	* @return <code>true</code> if this vcms article is has attachment; <code>false</code> otherwise
	*/
	public boolean isHasAttachment() {
		return _vcmsArticle.isHasAttachment();
	}

	/**
	* Sets whether this vcms article is has attachment.
	*
	* @param hasAttachment the has attachment of this vcms article
	*/
	public void setHasAttachment(boolean hasAttachment) {
		_vcmsArticle.setHasAttachment(hasAttachment);
	}

	/**
	* Returns the has poll of this vcms article.
	*
	* @return the has poll of this vcms article
	*/
	public boolean getHasPoll() {
		return _vcmsArticle.getHasPoll();
	}

	/**
	* Returns <code>true</code> if this vcms article is has poll.
	*
	* @return <code>true</code> if this vcms article is has poll; <code>false</code> otherwise
	*/
	public boolean isHasPoll() {
		return _vcmsArticle.isHasPoll();
	}

	/**
	* Sets whether this vcms article is has poll.
	*
	* @param hasPoll the has poll of this vcms article
	*/
	public void setHasPoll(boolean hasPoll) {
		_vcmsArticle.setHasPoll(hasPoll);
	}

	/**
	* Returns the poll ID of this vcms article.
	*
	* @return the poll ID of this vcms article
	*/
	public java.lang.String getPollId() {
		return _vcmsArticle.getPollId();
	}

	/**
	* Sets the poll ID of this vcms article.
	*
	* @param pollId the poll ID of this vcms article
	*/
	public void setPollId(java.lang.String pollId) {
		_vcmsArticle.setPollId(pollId);
	}

	/**
	* Returns the effective date of this vcms article.
	*
	* @return the effective date of this vcms article
	*/
	public java.util.Date getEffectiveDate() {
		return _vcmsArticle.getEffectiveDate();
	}

	/**
	* Sets the effective date of this vcms article.
	*
	* @param effectiveDate the effective date of this vcms article
	*/
	public void setEffectiveDate(java.util.Date effectiveDate) {
		_vcmsArticle.setEffectiveDate(effectiveDate);
	}

	/**
	* Returns the expire date of this vcms article.
	*
	* @return the expire date of this vcms article
	*/
	public java.util.Date getExpireDate() {
		return _vcmsArticle.getExpireDate();
	}

	/**
	* Sets the expire date of this vcms article.
	*
	* @param expireDate the expire date of this vcms article
	*/
	public void setExpireDate(java.util.Date expireDate) {
		_vcmsArticle.setExpireDate(expireDate);
	}

	/**
	* Returns the sticky of this vcms article.
	*
	* @return the sticky of this vcms article
	*/
	public boolean getSticky() {
		return _vcmsArticle.getSticky();
	}

	/**
	* Returns <code>true</code> if this vcms article is sticky.
	*
	* @return <code>true</code> if this vcms article is sticky; <code>false</code> otherwise
	*/
	public boolean isSticky() {
		return _vcmsArticle.isSticky();
	}

	/**
	* Sets whether this vcms article is sticky.
	*
	* @param sticky the sticky of this vcms article
	*/
	public void setSticky(boolean sticky) {
		_vcmsArticle.setSticky(sticky);
	}

	/**
	* Returns the sticky never expired of this vcms article.
	*
	* @return the sticky never expired of this vcms article
	*/
	public boolean getStickyNeverExpired() {
		return _vcmsArticle.getStickyNeverExpired();
	}

	/**
	* Returns <code>true</code> if this vcms article is sticky never expired.
	*
	* @return <code>true</code> if this vcms article is sticky never expired; <code>false</code> otherwise
	*/
	public boolean isStickyNeverExpired() {
		return _vcmsArticle.isStickyNeverExpired();
	}

	/**
	* Sets whether this vcms article is sticky never expired.
	*
	* @param stickyNeverExpired the sticky never expired of this vcms article
	*/
	public void setStickyNeverExpired(boolean stickyNeverExpired) {
		_vcmsArticle.setStickyNeverExpired(stickyNeverExpired);
	}

	/**
	* Returns the sticky expire date of this vcms article.
	*
	* @return the sticky expire date of this vcms article
	*/
	public java.util.Date getStickyExpireDate() {
		return _vcmsArticle.getStickyExpireDate();
	}

	/**
	* Sets the sticky expire date of this vcms article.
	*
	* @param stickyExpireDate the sticky expire date of this vcms article
	*/
	public void setStickyExpireDate(java.util.Date stickyExpireDate) {
		_vcmsArticle.setStickyExpireDate(stickyExpireDate);
	}

	public boolean isNew() {
		return _vcmsArticle.isNew();
	}

	public void setNew(boolean n) {
		_vcmsArticle.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsArticle.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsArticle.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsArticle.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsArticle.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsArticle.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsArticle.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsArticle.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsArticleWrapper((VcmsArticle)_vcmsArticle.clone());
	}

	public int compareTo(com.vportal.portlet.vcms.model.VcmsArticle vcmsArticle) {
		return _vcmsArticle.compareTo(vcmsArticle);
	}

	@Override
	public int hashCode() {
		return _vcmsArticle.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsArticle> toCacheModel() {
		return _vcmsArticle.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsArticle toEscapedModel() {
		return new VcmsArticleWrapper(_vcmsArticle.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsArticle.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsArticle.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticle.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsArticle getWrappedVcmsArticle() {
		return _vcmsArticle;
	}

	public VcmsArticle getWrappedModel() {
		return _vcmsArticle;
	}

	public void resetOriginalValues() {
		_vcmsArticle.resetOriginalValues();
	}

	private VcmsArticle _vcmsArticle;
}