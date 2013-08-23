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
 * This class is a wrapper for {@link FAQAnswer}.
 * </p>
 *
 * @author    DucNN
 * @see       FAQAnswer
 * @generated
 */
public class FAQAnswerWrapper implements FAQAnswer, ModelWrapper<FAQAnswer> {
	public FAQAnswerWrapper(FAQAnswer faqAnswer) {
		_faqAnswer = faqAnswer;
	}

	public Class<?> getModelClass() {
		return FAQAnswer.class;
	}

	public String getModelClassName() {
		return FAQAnswer.class.getName();
	}

	/**
	* Returns the primary key of this f a q answer.
	*
	* @return the primary key of this f a q answer
	*/
	public long getPrimaryKey() {
		return _faqAnswer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this f a q answer.
	*
	* @param primaryKey the primary key of this f a q answer
	*/
	public void setPrimaryKey(long primaryKey) {
		_faqAnswer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this f a q answer.
	*
	* @return the uuid of this f a q answer
	*/
	public java.lang.String getUuid() {
		return _faqAnswer.getUuid();
	}

	/**
	* Sets the uuid of this f a q answer.
	*
	* @param uuid the uuid of this f a q answer
	*/
	public void setUuid(java.lang.String uuid) {
		_faqAnswer.setUuid(uuid);
	}

	/**
	* Returns the ID of this f a q answer.
	*
	* @return the ID of this f a q answer
	*/
	public long getId() {
		return _faqAnswer.getId();
	}

	/**
	* Sets the ID of this f a q answer.
	*
	* @param id the ID of this f a q answer
	*/
	public void setId(long id) {
		_faqAnswer.setId(id);
	}

	/**
	* Returns the questionid of this f a q answer.
	*
	* @return the questionid of this f a q answer
	*/
	public long getQuestionid() {
		return _faqAnswer.getQuestionid();
	}

	/**
	* Sets the questionid of this f a q answer.
	*
	* @param questionid the questionid of this f a q answer
	*/
	public void setQuestionid(long questionid) {
		_faqAnswer.setQuestionid(questionid);
	}

	/**
	* Returns the content of this f a q answer.
	*
	* @return the content of this f a q answer
	*/
	public java.lang.String getContent() {
		return _faqAnswer.getContent();
	}

	/**
	* Sets the content of this f a q answer.
	*
	* @param content the content of this f a q answer
	*/
	public void setContent(java.lang.String content) {
		_faqAnswer.setContent(content);
	}

	/**
	* Returns the answer order of this f a q answer.
	*
	* @return the answer order of this f a q answer
	*/
	public long getAnswerOrder() {
		return _faqAnswer.getAnswerOrder();
	}

	/**
	* Sets the answer order of this f a q answer.
	*
	* @param answerOrder the answer order of this f a q answer
	*/
	public void setAnswerOrder(long answerOrder) {
		_faqAnswer.setAnswerOrder(answerOrder);
	}

	/**
	* Returns the answered by user of this f a q answer.
	*
	* @return the answered by user of this f a q answer
	*/
	public java.lang.String getAnsweredByUser() {
		return _faqAnswer.getAnsweredByUser();
	}

	/**
	* Sets the answered by user of this f a q answer.
	*
	* @param answeredByUser the answered by user of this f a q answer
	*/
	public void setAnsweredByUser(java.lang.String answeredByUser) {
		_faqAnswer.setAnsweredByUser(answeredByUser);
	}

	/**
	* Returns the answered date of this f a q answer.
	*
	* @return the answered date of this f a q answer
	*/
	public java.util.Date getAnsweredDate() {
		return _faqAnswer.getAnsweredDate();
	}

	/**
	* Sets the answered date of this f a q answer.
	*
	* @param answeredDate the answered date of this f a q answer
	*/
	public void setAnsweredDate(java.util.Date answeredDate) {
		_faqAnswer.setAnsweredDate(answeredDate);
	}

	/**
	* Returns the modified by user of this f a q answer.
	*
	* @return the modified by user of this f a q answer
	*/
	public java.lang.String getModifiedByUser() {
		return _faqAnswer.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this f a q answer.
	*
	* @param modifiedByUser the modified by user of this f a q answer
	*/
	public void setModifiedByUser(java.lang.String modifiedByUser) {
		_faqAnswer.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the language of this f a q answer.
	*
	* @return the language of this f a q answer
	*/
	public java.lang.String getLanguage() {
		return _faqAnswer.getLanguage();
	}

	/**
	* Sets the language of this f a q answer.
	*
	* @param language the language of this f a q answer
	*/
	public void setLanguage(java.lang.String language) {
		_faqAnswer.setLanguage(language);
	}

	/**
	* Returns the modified date of this f a q answer.
	*
	* @return the modified date of this f a q answer
	*/
	public java.util.Date getModifiedDate() {
		return _faqAnswer.getModifiedDate();
	}

	/**
	* Sets the modified date of this f a q answer.
	*
	* @param modifiedDate the modified date of this f a q answer
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_faqAnswer.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the approved of this f a q answer.
	*
	* @return the approved of this f a q answer
	*/
	public boolean getApproved() {
		return _faqAnswer.getApproved();
	}

	/**
	* Returns <code>true</code> if this f a q answer is approved.
	*
	* @return <code>true</code> if this f a q answer is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _faqAnswer.isApproved();
	}

	/**
	* Sets whether this f a q answer is approved.
	*
	* @param approved the approved of this f a q answer
	*/
	public void setApproved(boolean approved) {
		_faqAnswer.setApproved(approved);
	}

	/**
	* Returns the approved by user of this f a q answer.
	*
	* @return the approved by user of this f a q answer
	*/
	public java.lang.String getApprovedByUser() {
		return _faqAnswer.getApprovedByUser();
	}

	/**
	* Sets the approved by user of this f a q answer.
	*
	* @param approvedByUser the approved by user of this f a q answer
	*/
	public void setApprovedByUser(java.lang.String approvedByUser) {
		_faqAnswer.setApprovedByUser(approvedByUser);
	}

	/**
	* Returns the approved date of this f a q answer.
	*
	* @return the approved date of this f a q answer
	*/
	public java.util.Date getApprovedDate() {
		return _faqAnswer.getApprovedDate();
	}

	/**
	* Sets the approved date of this f a q answer.
	*
	* @param approvedDate the approved date of this f a q answer
	*/
	public void setApprovedDate(java.util.Date approvedDate) {
		_faqAnswer.setApprovedDate(approvedDate);
	}

	/**
	* Returns the user ID of this f a q answer.
	*
	* @return the user ID of this f a q answer
	*/
	public long getUserId() {
		return _faqAnswer.getUserId();
	}

	/**
	* Sets the user ID of this f a q answer.
	*
	* @param userId the user ID of this f a q answer
	*/
	public void setUserId(long userId) {
		_faqAnswer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this f a q answer.
	*
	* @return the user uuid of this f a q answer
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqAnswer.getUserUuid();
	}

	/**
	* Sets the user uuid of this f a q answer.
	*
	* @param userUuid the user uuid of this f a q answer
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_faqAnswer.setUserUuid(userUuid);
	}

	/**
	* Returns the attach name of this f a q answer.
	*
	* @return the attach name of this f a q answer
	*/
	public java.lang.String getAttachName() {
		return _faqAnswer.getAttachName();
	}

	/**
	* Sets the attach name of this f a q answer.
	*
	* @param attachName the attach name of this f a q answer
	*/
	public void setAttachName(java.lang.String attachName) {
		_faqAnswer.setAttachName(attachName);
	}

	/**
	* Returns the folder ID of this f a q answer.
	*
	* @return the folder ID of this f a q answer
	*/
	public long getFolderId() {
		return _faqAnswer.getFolderId();
	}

	/**
	* Sets the folder ID of this f a q answer.
	*
	* @param folderId the folder ID of this f a q answer
	*/
	public void setFolderId(long folderId) {
		_faqAnswer.setFolderId(folderId);
	}

	public boolean isNew() {
		return _faqAnswer.isNew();
	}

	public void setNew(boolean n) {
		_faqAnswer.setNew(n);
	}

	public boolean isCachedModel() {
		return _faqAnswer.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_faqAnswer.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _faqAnswer.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _faqAnswer.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_faqAnswer.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _faqAnswer.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_faqAnswer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FAQAnswerWrapper((FAQAnswer)_faqAnswer.clone());
	}

	public int compareTo(com.vportal.portlet.vfaq.model.FAQAnswer faqAnswer) {
		return _faqAnswer.compareTo(faqAnswer);
	}

	@Override
	public int hashCode() {
		return _faqAnswer.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vfaq.model.FAQAnswer> toCacheModel() {
		return _faqAnswer.toCacheModel();
	}

	public com.vportal.portlet.vfaq.model.FAQAnswer toEscapedModel() {
		return new FAQAnswerWrapper(_faqAnswer.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _faqAnswer.toString();
	}

	public java.lang.String toXmlString() {
		return _faqAnswer.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_faqAnswer.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FAQAnswer getWrappedFAQAnswer() {
		return _faqAnswer;
	}

	public FAQAnswer getWrappedModel() {
		return _faqAnswer;
	}

	public void resetOriginalValues() {
		_faqAnswer.resetOriginalValues();
	}

	private FAQAnswer _faqAnswer;
}