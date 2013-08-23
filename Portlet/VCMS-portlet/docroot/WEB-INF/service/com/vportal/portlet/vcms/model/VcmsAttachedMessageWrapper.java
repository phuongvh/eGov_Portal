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
 * This class is a wrapper for {@link VcmsAttachedMessage}.
 * </p>
 *
 * @author    hai
 * @see       VcmsAttachedMessage
 * @generated
 */
public class VcmsAttachedMessageWrapper implements VcmsAttachedMessage,
	ModelWrapper<VcmsAttachedMessage> {
	public VcmsAttachedMessageWrapper(VcmsAttachedMessage vcmsAttachedMessage) {
		_vcmsAttachedMessage = vcmsAttachedMessage;
	}

	public Class<?> getModelClass() {
		return VcmsAttachedMessage.class;
	}

	public String getModelClassName() {
		return VcmsAttachedMessage.class.getName();
	}

	/**
	* Returns the primary key of this vcms attached message.
	*
	* @return the primary key of this vcms attached message
	*/
	public java.lang.String getPrimaryKey() {
		return _vcmsAttachedMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms attached message.
	*
	* @param primaryKey the primary key of this vcms attached message
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vcmsAttachedMessage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the message ID of this vcms attached message.
	*
	* @return the message ID of this vcms attached message
	*/
	public java.lang.String getMessageId() {
		return _vcmsAttachedMessage.getMessageId();
	}

	/**
	* Sets the message ID of this vcms attached message.
	*
	* @param messageId the message ID of this vcms attached message
	*/
	public void setMessageId(java.lang.String messageId) {
		_vcmsAttachedMessage.setMessageId(messageId);
	}

	/**
	* Returns the group ID of this vcms attached message.
	*
	* @return the group ID of this vcms attached message
	*/
	public long getGroupId() {
		return _vcmsAttachedMessage.getGroupId();
	}

	/**
	* Sets the group ID of this vcms attached message.
	*
	* @param groupId the group ID of this vcms attached message
	*/
	public void setGroupId(long groupId) {
		_vcmsAttachedMessage.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vcms attached message.
	*
	* @return the company ID of this vcms attached message
	*/
	public long getCompanyId() {
		return _vcmsAttachedMessage.getCompanyId();
	}

	/**
	* Sets the company ID of this vcms attached message.
	*
	* @param companyId the company ID of this vcms attached message
	*/
	public void setCompanyId(long companyId) {
		_vcmsAttachedMessage.setCompanyId(companyId);
	}

	/**
	* Returns the created date of this vcms attached message.
	*
	* @return the created date of this vcms attached message
	*/
	public java.util.Date getCreatedDate() {
		return _vcmsAttachedMessage.getCreatedDate();
	}

	/**
	* Sets the created date of this vcms attached message.
	*
	* @param createdDate the created date of this vcms attached message
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vcmsAttachedMessage.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by user of this vcms attached message.
	*
	* @return the created by user of this vcms attached message
	*/
	public java.lang.String getCreatedByUser() {
		return _vcmsAttachedMessage.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vcms attached message.
	*
	* @param createdByUser the created by user of this vcms attached message
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_vcmsAttachedMessage.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the article ID of this vcms attached message.
	*
	* @return the article ID of this vcms attached message
	*/
	public java.lang.String getArticleId() {
		return _vcmsAttachedMessage.getArticleId();
	}

	/**
	* Sets the article ID of this vcms attached message.
	*
	* @param articleId the article ID of this vcms attached message
	*/
	public void setArticleId(java.lang.String articleId) {
		_vcmsAttachedMessage.setArticleId(articleId);
	}

	/**
	* Returns the content of this vcms attached message.
	*
	* @return the content of this vcms attached message
	*/
	public java.lang.String getContent() {
		return _vcmsAttachedMessage.getContent();
	}

	/**
	* Sets the content of this vcms attached message.
	*
	* @param content the content of this vcms attached message
	*/
	public void setContent(java.lang.String content) {
		_vcmsAttachedMessage.setContent(content);
	}

	/**
	* Returns the read message of this vcms attached message.
	*
	* @return the read message of this vcms attached message
	*/
	public boolean getReadMessage() {
		return _vcmsAttachedMessage.getReadMessage();
	}

	/**
	* Returns <code>true</code> if this vcms attached message is read message.
	*
	* @return <code>true</code> if this vcms attached message is read message; <code>false</code> otherwise
	*/
	public boolean isReadMessage() {
		return _vcmsAttachedMessage.isReadMessage();
	}

	/**
	* Sets whether this vcms attached message is read message.
	*
	* @param readMessage the read message of this vcms attached message
	*/
	public void setReadMessage(boolean readMessage) {
		_vcmsAttachedMessage.setReadMessage(readMessage);
	}

	public boolean isNew() {
		return _vcmsAttachedMessage.isNew();
	}

	public void setNew(boolean n) {
		_vcmsAttachedMessage.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsAttachedMessage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsAttachedMessage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsAttachedMessage.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsAttachedMessage.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsAttachedMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsAttachedMessage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsAttachedMessage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsAttachedMessageWrapper((VcmsAttachedMessage)_vcmsAttachedMessage.clone());
	}

	public int compareTo(
		com.vportal.portlet.vcms.model.VcmsAttachedMessage vcmsAttachedMessage) {
		return _vcmsAttachedMessage.compareTo(vcmsAttachedMessage);
	}

	@Override
	public int hashCode() {
		return _vcmsAttachedMessage.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsAttachedMessage> toCacheModel() {
		return _vcmsAttachedMessage.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsAttachedMessage toEscapedModel() {
		return new VcmsAttachedMessageWrapper(_vcmsAttachedMessage.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsAttachedMessage.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsAttachedMessage.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsAttachedMessage.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsAttachedMessage getWrappedVcmsAttachedMessage() {
		return _vcmsAttachedMessage;
	}

	public VcmsAttachedMessage getWrappedModel() {
		return _vcmsAttachedMessage;
	}

	public void resetOriginalValues() {
		_vcmsAttachedMessage.resetOriginalValues();
	}

	private VcmsAttachedMessage _vcmsAttachedMessage;
}