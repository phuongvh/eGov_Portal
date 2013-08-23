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
 * This class is a wrapper for {@link FAQComment}.
 * </p>
 *
 * @author    DucNN
 * @see       FAQComment
 * @generated
 */
public class FAQCommentWrapper implements FAQComment, ModelWrapper<FAQComment> {
	public FAQCommentWrapper(FAQComment faqComment) {
		_faqComment = faqComment;
	}

	public Class<?> getModelClass() {
		return FAQComment.class;
	}

	public String getModelClassName() {
		return FAQComment.class.getName();
	}

	/**
	* Returns the primary key of this f a q comment.
	*
	* @return the primary key of this f a q comment
	*/
	public long getPrimaryKey() {
		return _faqComment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this f a q comment.
	*
	* @param primaryKey the primary key of this f a q comment
	*/
	public void setPrimaryKey(long primaryKey) {
		_faqComment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this f a q comment.
	*
	* @return the uuid of this f a q comment
	*/
	public java.lang.String getUuid() {
		return _faqComment.getUuid();
	}

	/**
	* Sets the uuid of this f a q comment.
	*
	* @param uuid the uuid of this f a q comment
	*/
	public void setUuid(java.lang.String uuid) {
		_faqComment.setUuid(uuid);
	}

	/**
	* Returns the ID of this f a q comment.
	*
	* @return the ID of this f a q comment
	*/
	public long getId() {
		return _faqComment.getId();
	}

	/**
	* Sets the ID of this f a q comment.
	*
	* @param id the ID of this f a q comment
	*/
	public void setId(long id) {
		_faqComment.setId(id);
	}

	/**
	* Returns the answerid of this f a q comment.
	*
	* @return the answerid of this f a q comment
	*/
	public long getAnswerid() {
		return _faqComment.getAnswerid();
	}

	/**
	* Sets the answerid of this f a q comment.
	*
	* @param answerid the answerid of this f a q comment
	*/
	public void setAnswerid(long answerid) {
		_faqComment.setAnswerid(answerid);
	}

	/**
	* Returns the content of this f a q comment.
	*
	* @return the content of this f a q comment
	*/
	public java.lang.String getContent() {
		return _faqComment.getContent();
	}

	/**
	* Sets the content of this f a q comment.
	*
	* @param content the content of this f a q comment
	*/
	public void setContent(java.lang.String content) {
		_faqComment.setContent(content);
	}

	/**
	* Returns the comm name of this f a q comment.
	*
	* @return the comm name of this f a q comment
	*/
	public java.lang.String getCommName() {
		return _faqComment.getCommName();
	}

	/**
	* Sets the comm name of this f a q comment.
	*
	* @param commName the comm name of this f a q comment
	*/
	public void setCommName(java.lang.String commName) {
		_faqComment.setCommName(commName);
	}

	/**
	* Returns the comm email of this f a q comment.
	*
	* @return the comm email of this f a q comment
	*/
	public java.lang.String getCommEmail() {
		return _faqComment.getCommEmail();
	}

	/**
	* Sets the comm email of this f a q comment.
	*
	* @param commEmail the comm email of this f a q comment
	*/
	public void setCommEmail(java.lang.String commEmail) {
		_faqComment.setCommEmail(commEmail);
	}

	/**
	* Returns the approved of this f a q comment.
	*
	* @return the approved of this f a q comment
	*/
	public boolean getApproved() {
		return _faqComment.getApproved();
	}

	/**
	* Returns <code>true</code> if this f a q comment is approved.
	*
	* @return <code>true</code> if this f a q comment is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _faqComment.isApproved();
	}

	/**
	* Sets whether this f a q comment is approved.
	*
	* @param approved the approved of this f a q comment
	*/
	public void setApproved(boolean approved) {
		_faqComment.setApproved(approved);
	}

	/**
	* Returns the approve by user of this f a q comment.
	*
	* @return the approve by user of this f a q comment
	*/
	public java.lang.String getApproveByUser() {
		return _faqComment.getApproveByUser();
	}

	/**
	* Sets the approve by user of this f a q comment.
	*
	* @param approveByUser the approve by user of this f a q comment
	*/
	public void setApproveByUser(java.lang.String approveByUser) {
		_faqComment.setApproveByUser(approveByUser);
	}

	/**
	* Returns the approved date of this f a q comment.
	*
	* @return the approved date of this f a q comment
	*/
	public java.util.Date getApprovedDate() {
		return _faqComment.getApprovedDate();
	}

	/**
	* Sets the approved date of this f a q comment.
	*
	* @param approvedDate the approved date of this f a q comment
	*/
	public void setApprovedDate(java.util.Date approvedDate) {
		_faqComment.setApprovedDate(approvedDate);
	}

	/**
	* Returns the comm date of this f a q comment.
	*
	* @return the comm date of this f a q comment
	*/
	public java.util.Date getCommDate() {
		return _faqComment.getCommDate();
	}

	/**
	* Sets the comm date of this f a q comment.
	*
	* @param commDate the comm date of this f a q comment
	*/
	public void setCommDate(java.util.Date commDate) {
		_faqComment.setCommDate(commDate);
	}

	/**
	* Returns the user ID of this f a q comment.
	*
	* @return the user ID of this f a q comment
	*/
	public long getUserId() {
		return _faqComment.getUserId();
	}

	/**
	* Sets the user ID of this f a q comment.
	*
	* @param userId the user ID of this f a q comment
	*/
	public void setUserId(long userId) {
		_faqComment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this f a q comment.
	*
	* @return the user uuid of this f a q comment
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqComment.getUserUuid();
	}

	/**
	* Sets the user uuid of this f a q comment.
	*
	* @param userUuid the user uuid of this f a q comment
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_faqComment.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _faqComment.isNew();
	}

	public void setNew(boolean n) {
		_faqComment.setNew(n);
	}

	public boolean isCachedModel() {
		return _faqComment.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_faqComment.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _faqComment.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _faqComment.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_faqComment.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _faqComment.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_faqComment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FAQCommentWrapper((FAQComment)_faqComment.clone());
	}

	public int compareTo(com.vportal.portlet.vfaq.model.FAQComment faqComment) {
		return _faqComment.compareTo(faqComment);
	}

	@Override
	public int hashCode() {
		return _faqComment.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vfaq.model.FAQComment> toCacheModel() {
		return _faqComment.toCacheModel();
	}

	public com.vportal.portlet.vfaq.model.FAQComment toEscapedModel() {
		return new FAQCommentWrapper(_faqComment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _faqComment.toString();
	}

	public java.lang.String toXmlString() {
		return _faqComment.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_faqComment.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FAQComment getWrappedFAQComment() {
		return _faqComment;
	}

	public FAQComment getWrappedModel() {
		return _faqComment;
	}

	public void resetOriginalValues() {
		_faqComment.resetOriginalValues();
	}

	private FAQComment _faqComment;
}