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
 * This class is a wrapper for {@link VcmsDiscussion}.
 * </p>
 *
 * @author    hai
 * @see       VcmsDiscussion
 * @generated
 */
public class VcmsDiscussionWrapper implements VcmsDiscussion,
	ModelWrapper<VcmsDiscussion> {
	public VcmsDiscussionWrapper(VcmsDiscussion vcmsDiscussion) {
		_vcmsDiscussion = vcmsDiscussion;
	}

	public Class<?> getModelClass() {
		return VcmsDiscussion.class;
	}

	public String getModelClassName() {
		return VcmsDiscussion.class.getName();
	}

	/**
	* Returns the primary key of this vcms discussion.
	*
	* @return the primary key of this vcms discussion
	*/
	public java.lang.String getPrimaryKey() {
		return _vcmsDiscussion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms discussion.
	*
	* @param primaryKey the primary key of this vcms discussion
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vcmsDiscussion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the discussion ID of this vcms discussion.
	*
	* @return the discussion ID of this vcms discussion
	*/
	public java.lang.String getDiscussionId() {
		return _vcmsDiscussion.getDiscussionId();
	}

	/**
	* Sets the discussion ID of this vcms discussion.
	*
	* @param discussionId the discussion ID of this vcms discussion
	*/
	public void setDiscussionId(java.lang.String discussionId) {
		_vcmsDiscussion.setDiscussionId(discussionId);
	}

	/**
	* Returns the group ID of this vcms discussion.
	*
	* @return the group ID of this vcms discussion
	*/
	public long getGroupId() {
		return _vcmsDiscussion.getGroupId();
	}

	/**
	* Sets the group ID of this vcms discussion.
	*
	* @param groupId the group ID of this vcms discussion
	*/
	public void setGroupId(long groupId) {
		_vcmsDiscussion.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vcms discussion.
	*
	* @return the company ID of this vcms discussion
	*/
	public long getCompanyId() {
		return _vcmsDiscussion.getCompanyId();
	}

	/**
	* Sets the company ID of this vcms discussion.
	*
	* @param companyId the company ID of this vcms discussion
	*/
	public void setCompanyId(long companyId) {
		_vcmsDiscussion.setCompanyId(companyId);
	}

	/**
	* Returns the visitor name of this vcms discussion.
	*
	* @return the visitor name of this vcms discussion
	*/
	public java.lang.String getVisitorName() {
		return _vcmsDiscussion.getVisitorName();
	}

	/**
	* Sets the visitor name of this vcms discussion.
	*
	* @param visitorName the visitor name of this vcms discussion
	*/
	public void setVisitorName(java.lang.String visitorName) {
		_vcmsDiscussion.setVisitorName(visitorName);
	}

	/**
	* Returns the visitor email of this vcms discussion.
	*
	* @return the visitor email of this vcms discussion
	*/
	public java.lang.String getVisitorEmail() {
		return _vcmsDiscussion.getVisitorEmail();
	}

	/**
	* Sets the visitor email of this vcms discussion.
	*
	* @param visitorEmail the visitor email of this vcms discussion
	*/
	public void setVisitorEmail(java.lang.String visitorEmail) {
		_vcmsDiscussion.setVisitorEmail(visitorEmail);
	}

	/**
	* Returns the visitor phone of this vcms discussion.
	*
	* @return the visitor phone of this vcms discussion
	*/
	public java.lang.String getVisitorPhone() {
		return _vcmsDiscussion.getVisitorPhone();
	}

	/**
	* Sets the visitor phone of this vcms discussion.
	*
	* @param visitorPhone the visitor phone of this vcms discussion
	*/
	public void setVisitorPhone(java.lang.String visitorPhone) {
		_vcmsDiscussion.setVisitorPhone(visitorPhone);
	}

	/**
	* Returns the posted date of this vcms discussion.
	*
	* @return the posted date of this vcms discussion
	*/
	public java.util.Date getPostedDate() {
		return _vcmsDiscussion.getPostedDate();
	}

	/**
	* Sets the posted date of this vcms discussion.
	*
	* @param postedDate the posted date of this vcms discussion
	*/
	public void setPostedDate(java.util.Date postedDate) {
		_vcmsDiscussion.setPostedDate(postedDate);
	}

	/**
	* Returns the approved of this vcms discussion.
	*
	* @return the approved of this vcms discussion
	*/
	public boolean getApproved() {
		return _vcmsDiscussion.getApproved();
	}

	/**
	* Returns <code>true</code> if this vcms discussion is approved.
	*
	* @return <code>true</code> if this vcms discussion is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _vcmsDiscussion.isApproved();
	}

	/**
	* Sets whether this vcms discussion is approved.
	*
	* @param approved the approved of this vcms discussion
	*/
	public void setApproved(boolean approved) {
		_vcmsDiscussion.setApproved(approved);
	}

	/**
	* Returns the approved by user of this vcms discussion.
	*
	* @return the approved by user of this vcms discussion
	*/
	public java.lang.String getApprovedByUser() {
		return _vcmsDiscussion.getApprovedByUser();
	}

	/**
	* Sets the approved by user of this vcms discussion.
	*
	* @param approvedByUser the approved by user of this vcms discussion
	*/
	public void setApprovedByUser(java.lang.String approvedByUser) {
		_vcmsDiscussion.setApprovedByUser(approvedByUser);
	}

	/**
	* Returns the approved date of this vcms discussion.
	*
	* @return the approved date of this vcms discussion
	*/
	public java.util.Date getApprovedDate() {
		return _vcmsDiscussion.getApprovedDate();
	}

	/**
	* Sets the approved date of this vcms discussion.
	*
	* @param approvedDate the approved date of this vcms discussion
	*/
	public void setApprovedDate(java.util.Date approvedDate) {
		_vcmsDiscussion.setApprovedDate(approvedDate);
	}

	/**
	* Returns the article ID of this vcms discussion.
	*
	* @return the article ID of this vcms discussion
	*/
	public java.lang.String getArticleId() {
		return _vcmsDiscussion.getArticleId();
	}

	/**
	* Sets the article ID of this vcms discussion.
	*
	* @param articleId the article ID of this vcms discussion
	*/
	public void setArticleId(java.lang.String articleId) {
		_vcmsDiscussion.setArticleId(articleId);
	}

	/**
	* Returns the title of this vcms discussion.
	*
	* @return the title of this vcms discussion
	*/
	public java.lang.String getTitle() {
		return _vcmsDiscussion.getTitle();
	}

	/**
	* Sets the title of this vcms discussion.
	*
	* @param title the title of this vcms discussion
	*/
	public void setTitle(java.lang.String title) {
		_vcmsDiscussion.setTitle(title);
	}

	/**
	* Returns the content of this vcms discussion.
	*
	* @return the content of this vcms discussion
	*/
	public java.lang.String getContent() {
		return _vcmsDiscussion.getContent();
	}

	/**
	* Sets the content of this vcms discussion.
	*
	* @param content the content of this vcms discussion
	*/
	public void setContent(java.lang.String content) {
		_vcmsDiscussion.setContent(content);
	}

	/**
	* Returns the language of this vcms discussion.
	*
	* @return the language of this vcms discussion
	*/
	public java.lang.String getLanguage() {
		return _vcmsDiscussion.getLanguage();
	}

	/**
	* Sets the language of this vcms discussion.
	*
	* @param language the language of this vcms discussion
	*/
	public void setLanguage(java.lang.String language) {
		_vcmsDiscussion.setLanguage(language);
	}

	/**
	* Returns the has attachment of this vcms discussion.
	*
	* @return the has attachment of this vcms discussion
	*/
	public boolean getHasAttachment() {
		return _vcmsDiscussion.getHasAttachment();
	}

	/**
	* Returns <code>true</code> if this vcms discussion is has attachment.
	*
	* @return <code>true</code> if this vcms discussion is has attachment; <code>false</code> otherwise
	*/
	public boolean isHasAttachment() {
		return _vcmsDiscussion.isHasAttachment();
	}

	/**
	* Sets whether this vcms discussion is has attachment.
	*
	* @param hasAttachment the has attachment of this vcms discussion
	*/
	public void setHasAttachment(boolean hasAttachment) {
		_vcmsDiscussion.setHasAttachment(hasAttachment);
	}

	public boolean isNew() {
		return _vcmsDiscussion.isNew();
	}

	public void setNew(boolean n) {
		_vcmsDiscussion.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsDiscussion.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsDiscussion.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsDiscussion.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsDiscussion.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsDiscussion.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsDiscussion.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsDiscussion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsDiscussionWrapper((VcmsDiscussion)_vcmsDiscussion.clone());
	}

	public int compareTo(
		com.vportal.portlet.vcms.model.VcmsDiscussion vcmsDiscussion) {
		return _vcmsDiscussion.compareTo(vcmsDiscussion);
	}

	@Override
	public int hashCode() {
		return _vcmsDiscussion.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsDiscussion> toCacheModel() {
		return _vcmsDiscussion.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsDiscussion toEscapedModel() {
		return new VcmsDiscussionWrapper(_vcmsDiscussion.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsDiscussion.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsDiscussion.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsDiscussion.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsDiscussion getWrappedVcmsDiscussion() {
		return _vcmsDiscussion;
	}

	public VcmsDiscussion getWrappedModel() {
		return _vcmsDiscussion;
	}

	public void resetOriginalValues() {
		_vcmsDiscussion.resetOriginalValues();
	}

	private VcmsDiscussion _vcmsDiscussion;
}