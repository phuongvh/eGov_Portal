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
 * This class is a wrapper for {@link FAQQuestion}.
 * </p>
 *
 * @author    DucNN
 * @see       FAQQuestion
 * @generated
 */
public class FAQQuestionWrapper implements FAQQuestion,
	ModelWrapper<FAQQuestion> {
	public FAQQuestionWrapper(FAQQuestion faqQuestion) {
		_faqQuestion = faqQuestion;
	}

	public Class<?> getModelClass() {
		return FAQQuestion.class;
	}

	public String getModelClassName() {
		return FAQQuestion.class.getName();
	}

	/**
	* Returns the primary key of this f a q question.
	*
	* @return the primary key of this f a q question
	*/
	public long getPrimaryKey() {
		return _faqQuestion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this f a q question.
	*
	* @param primaryKey the primary key of this f a q question
	*/
	public void setPrimaryKey(long primaryKey) {
		_faqQuestion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this f a q question.
	*
	* @return the uuid of this f a q question
	*/
	public java.lang.String getUuid() {
		return _faqQuestion.getUuid();
	}

	/**
	* Sets the uuid of this f a q question.
	*
	* @param uuid the uuid of this f a q question
	*/
	public void setUuid(java.lang.String uuid) {
		_faqQuestion.setUuid(uuid);
	}

	/**
	* Returns the ID of this f a q question.
	*
	* @return the ID of this f a q question
	*/
	public long getId() {
		return _faqQuestion.getId();
	}

	/**
	* Sets the ID of this f a q question.
	*
	* @param id the ID of this f a q question
	*/
	public void setId(long id) {
		_faqQuestion.setId(id);
	}

	/**
	* Returns the title of this f a q question.
	*
	* @return the title of this f a q question
	*/
	public java.lang.String getTitle() {
		return _faqQuestion.getTitle();
	}

	/**
	* Sets the title of this f a q question.
	*
	* @param title the title of this f a q question
	*/
	public void setTitle(java.lang.String title) {
		_faqQuestion.setTitle(title);
	}

	/**
	* Returns the content of this f a q question.
	*
	* @return the content of this f a q question
	*/
	public java.lang.String getContent() {
		return _faqQuestion.getContent();
	}

	/**
	* Sets the content of this f a q question.
	*
	* @param content the content of this f a q question
	*/
	public void setContent(java.lang.String content) {
		_faqQuestion.setContent(content);
	}

	/**
	* Returns the language of this f a q question.
	*
	* @return the language of this f a q question
	*/
	public java.lang.String getLanguage() {
		return _faqQuestion.getLanguage();
	}

	/**
	* Sets the language of this f a q question.
	*
	* @param language the language of this f a q question
	*/
	public void setLanguage(java.lang.String language) {
		_faqQuestion.setLanguage(language);
	}

	/**
	* Returns the question order of this f a q question.
	*
	* @return the question order of this f a q question
	*/
	public long getQuestionOrder() {
		return _faqQuestion.getQuestionOrder();
	}

	/**
	* Sets the question order of this f a q question.
	*
	* @param questionOrder the question order of this f a q question
	*/
	public void setQuestionOrder(long questionOrder) {
		_faqQuestion.setQuestionOrder(questionOrder);
	}

	/**
	* Returns the sent date of this f a q question.
	*
	* @return the sent date of this f a q question
	*/
	public java.util.Date getSentDate() {
		return _faqQuestion.getSentDate();
	}

	/**
	* Sets the sent date of this f a q question.
	*
	* @param sentDate the sent date of this f a q question
	*/
	public void setSentDate(java.util.Date sentDate) {
		_faqQuestion.setSentDate(sentDate);
	}

	/**
	* Returns the sent by user of this f a q question.
	*
	* @return the sent by user of this f a q question
	*/
	public java.lang.String getSentByUser() {
		return _faqQuestion.getSentByUser();
	}

	/**
	* Sets the sent by user of this f a q question.
	*
	* @param sentByUser the sent by user of this f a q question
	*/
	public void setSentByUser(java.lang.String sentByUser) {
		_faqQuestion.setSentByUser(sentByUser);
	}

	/**
	* Returns the sender email of this f a q question.
	*
	* @return the sender email of this f a q question
	*/
	public java.lang.String getSenderEmail() {
		return _faqQuestion.getSenderEmail();
	}

	/**
	* Sets the sender email of this f a q question.
	*
	* @param senderEmail the sender email of this f a q question
	*/
	public void setSenderEmail(java.lang.String senderEmail) {
		_faqQuestion.setSenderEmail(senderEmail);
	}

	/**
	* Returns the question type of this f a q question.
	*
	* @return the question type of this f a q question
	*/
	public java.lang.String getQuestionType() {
		return _faqQuestion.getQuestionType();
	}

	/**
	* Sets the question type of this f a q question.
	*
	* @param questionType the question type of this f a q question
	*/
	public void setQuestionType(java.lang.String questionType) {
		_faqQuestion.setQuestionType(questionType);
	}

	/**
	* Returns the modified by user of this f a q question.
	*
	* @return the modified by user of this f a q question
	*/
	public java.lang.String getModifiedByUser() {
		return _faqQuestion.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this f a q question.
	*
	* @param modifiedByUser the modified by user of this f a q question
	*/
	public void setModifiedByUser(java.lang.String modifiedByUser) {
		_faqQuestion.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the modified date of this f a q question.
	*
	* @return the modified date of this f a q question
	*/
	public java.util.Date getModifiedDate() {
		return _faqQuestion.getModifiedDate();
	}

	/**
	* Sets the modified date of this f a q question.
	*
	* @param modifiedDate the modified date of this f a q question
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_faqQuestion.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the hit count of this f a q question.
	*
	* @return the hit count of this f a q question
	*/
	public long getHitCount() {
		return _faqQuestion.getHitCount();
	}

	/**
	* Sets the hit count of this f a q question.
	*
	* @param hitCount the hit count of this f a q question
	*/
	public void setHitCount(long hitCount) {
		_faqQuestion.setHitCount(hitCount);
	}

	/**
	* Returns the approved of this f a q question.
	*
	* @return the approved of this f a q question
	*/
	public boolean getApproved() {
		return _faqQuestion.getApproved();
	}

	/**
	* Returns <code>true</code> if this f a q question is approved.
	*
	* @return <code>true</code> if this f a q question is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _faqQuestion.isApproved();
	}

	/**
	* Sets whether this f a q question is approved.
	*
	* @param approved the approved of this f a q question
	*/
	public void setApproved(boolean approved) {
		_faqQuestion.setApproved(approved);
	}

	/**
	* Returns the group ID of this f a q question.
	*
	* @return the group ID of this f a q question
	*/
	public long getGroupId() {
		return _faqQuestion.getGroupId();
	}

	/**
	* Sets the group ID of this f a q question.
	*
	* @param groupId the group ID of this f a q question
	*/
	public void setGroupId(long groupId) {
		_faqQuestion.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this f a q question.
	*
	* @return the user ID of this f a q question
	*/
	public long getUserId() {
		return _faqQuestion.getUserId();
	}

	/**
	* Sets the user ID of this f a q question.
	*
	* @param userId the user ID of this f a q question
	*/
	public void setUserId(long userId) {
		_faqQuestion.setUserId(userId);
	}

	/**
	* Returns the user uuid of this f a q question.
	*
	* @return the user uuid of this f a q question
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestion.getUserUuid();
	}

	/**
	* Sets the user uuid of this f a q question.
	*
	* @param userUuid the user uuid of this f a q question
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_faqQuestion.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _faqQuestion.isNew();
	}

	public void setNew(boolean n) {
		_faqQuestion.setNew(n);
	}

	public boolean isCachedModel() {
		return _faqQuestion.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_faqQuestion.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _faqQuestion.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _faqQuestion.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_faqQuestion.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _faqQuestion.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_faqQuestion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FAQQuestionWrapper((FAQQuestion)_faqQuestion.clone());
	}

	public int compareTo(com.vportal.portlet.vfaq.model.FAQQuestion faqQuestion) {
		return _faqQuestion.compareTo(faqQuestion);
	}

	@Override
	public int hashCode() {
		return _faqQuestion.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vfaq.model.FAQQuestion> toCacheModel() {
		return _faqQuestion.toCacheModel();
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion toEscapedModel() {
		return new FAQQuestionWrapper(_faqQuestion.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _faqQuestion.toString();
	}

	public java.lang.String toXmlString() {
		return _faqQuestion.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_faqQuestion.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FAQQuestion getWrappedFAQQuestion() {
		return _faqQuestion;
	}

	public FAQQuestion getWrappedModel() {
		return _faqQuestion;
	}

	public void resetOriginalValues() {
		_faqQuestion.resetOriginalValues();
	}

	private FAQQuestion _faqQuestion;
}