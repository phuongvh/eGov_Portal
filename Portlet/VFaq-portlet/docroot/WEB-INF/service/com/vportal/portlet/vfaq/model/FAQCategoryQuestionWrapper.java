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
 * This class is a wrapper for {@link FAQCategoryQuestion}.
 * </p>
 *
 * @author    DucNN
 * @see       FAQCategoryQuestion
 * @generated
 */
public class FAQCategoryQuestionWrapper implements FAQCategoryQuestion,
	ModelWrapper<FAQCategoryQuestion> {
	public FAQCategoryQuestionWrapper(FAQCategoryQuestion faqCategoryQuestion) {
		_faqCategoryQuestion = faqCategoryQuestion;
	}

	public Class<?> getModelClass() {
		return FAQCategoryQuestion.class;
	}

	public String getModelClassName() {
		return FAQCategoryQuestion.class.getName();
	}

	/**
	* Returns the primary key of this f a q category question.
	*
	* @return the primary key of this f a q category question
	*/
	public long getPrimaryKey() {
		return _faqCategoryQuestion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this f a q category question.
	*
	* @param primaryKey the primary key of this f a q category question
	*/
	public void setPrimaryKey(long primaryKey) {
		_faqCategoryQuestion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this f a q category question.
	*
	* @return the uuid of this f a q category question
	*/
	public java.lang.String getUuid() {
		return _faqCategoryQuestion.getUuid();
	}

	/**
	* Sets the uuid of this f a q category question.
	*
	* @param uuid the uuid of this f a q category question
	*/
	public void setUuid(java.lang.String uuid) {
		_faqCategoryQuestion.setUuid(uuid);
	}

	/**
	* Returns the ID of this f a q category question.
	*
	* @return the ID of this f a q category question
	*/
	public long getId() {
		return _faqCategoryQuestion.getId();
	}

	/**
	* Sets the ID of this f a q category question.
	*
	* @param id the ID of this f a q category question
	*/
	public void setId(long id) {
		_faqCategoryQuestion.setId(id);
	}

	/**
	* Returns the question ID of this f a q category question.
	*
	* @return the question ID of this f a q category question
	*/
	public long getQuestionId() {
		return _faqCategoryQuestion.getQuestionId();
	}

	/**
	* Sets the question ID of this f a q category question.
	*
	* @param questionId the question ID of this f a q category question
	*/
	public void setQuestionId(long questionId) {
		_faqCategoryQuestion.setQuestionId(questionId);
	}

	/**
	* Returns the category ID of this f a q category question.
	*
	* @return the category ID of this f a q category question
	*/
	public long getCategoryId() {
		return _faqCategoryQuestion.getCategoryId();
	}

	/**
	* Sets the category ID of this f a q category question.
	*
	* @param categoryId the category ID of this f a q category question
	*/
	public void setCategoryId(long categoryId) {
		_faqCategoryQuestion.setCategoryId(categoryId);
	}

	public boolean isNew() {
		return _faqCategoryQuestion.isNew();
	}

	public void setNew(boolean n) {
		_faqCategoryQuestion.setNew(n);
	}

	public boolean isCachedModel() {
		return _faqCategoryQuestion.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_faqCategoryQuestion.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _faqCategoryQuestion.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _faqCategoryQuestion.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_faqCategoryQuestion.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _faqCategoryQuestion.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_faqCategoryQuestion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FAQCategoryQuestionWrapper((FAQCategoryQuestion)_faqCategoryQuestion.clone());
	}

	public int compareTo(
		com.vportal.portlet.vfaq.model.FAQCategoryQuestion faqCategoryQuestion) {
		return _faqCategoryQuestion.compareTo(faqCategoryQuestion);
	}

	@Override
	public int hashCode() {
		return _faqCategoryQuestion.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vfaq.model.FAQCategoryQuestion> toCacheModel() {
		return _faqCategoryQuestion.toCacheModel();
	}

	public com.vportal.portlet.vfaq.model.FAQCategoryQuestion toEscapedModel() {
		return new FAQCategoryQuestionWrapper(_faqCategoryQuestion.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _faqCategoryQuestion.toString();
	}

	public java.lang.String toXmlString() {
		return _faqCategoryQuestion.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_faqCategoryQuestion.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FAQCategoryQuestion getWrappedFAQCategoryQuestion() {
		return _faqCategoryQuestion;
	}

	public FAQCategoryQuestion getWrappedModel() {
		return _faqCategoryQuestion;
	}

	public void resetOriginalValues() {
		_faqCategoryQuestion.resetOriginalValues();
	}

	private FAQCategoryQuestion _faqCategoryQuestion;
}