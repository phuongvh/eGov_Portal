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
 * This class is a wrapper for {@link VcmsThread}.
 * </p>
 *
 * @author    hai
 * @see       VcmsThread
 * @generated
 */
public class VcmsThreadWrapper implements VcmsThread, ModelWrapper<VcmsThread> {
	public VcmsThreadWrapper(VcmsThread vcmsThread) {
		_vcmsThread = vcmsThread;
	}

	public Class<?> getModelClass() {
		return VcmsThread.class;
	}

	public String getModelClassName() {
		return VcmsThread.class.getName();
	}

	/**
	* Returns the primary key of this vcms thread.
	*
	* @return the primary key of this vcms thread
	*/
	public java.lang.String getPrimaryKey() {
		return _vcmsThread.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms thread.
	*
	* @param primaryKey the primary key of this vcms thread
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vcmsThread.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the thread ID of this vcms thread.
	*
	* @return the thread ID of this vcms thread
	*/
	public java.lang.String getThreadId() {
		return _vcmsThread.getThreadId();
	}

	/**
	* Sets the thread ID of this vcms thread.
	*
	* @param threadId the thread ID of this vcms thread
	*/
	public void setThreadId(java.lang.String threadId) {
		_vcmsThread.setThreadId(threadId);
	}

	/**
	* Returns the group ID of this vcms thread.
	*
	* @return the group ID of this vcms thread
	*/
	public long getGroupId() {
		return _vcmsThread.getGroupId();
	}

	/**
	* Sets the group ID of this vcms thread.
	*
	* @param groupId the group ID of this vcms thread
	*/
	public void setGroupId(long groupId) {
		_vcmsThread.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vcms thread.
	*
	* @return the company ID of this vcms thread
	*/
	public long getCompanyId() {
		return _vcmsThread.getCompanyId();
	}

	/**
	* Sets the company ID of this vcms thread.
	*
	* @param companyId the company ID of this vcms thread
	*/
	public void setCompanyId(long companyId) {
		_vcmsThread.setCompanyId(companyId);
	}

	/**
	* Returns the created date of this vcms thread.
	*
	* @return the created date of this vcms thread
	*/
	public java.util.Date getCreatedDate() {
		return _vcmsThread.getCreatedDate();
	}

	/**
	* Sets the created date of this vcms thread.
	*
	* @param createdDate the created date of this vcms thread
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vcmsThread.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by user of this vcms thread.
	*
	* @return the created by user of this vcms thread
	*/
	public java.lang.String getCreatedByUser() {
		return _vcmsThread.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vcms thread.
	*
	* @param createdByUser the created by user of this vcms thread
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_vcmsThread.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the modified date of this vcms thread.
	*
	* @return the modified date of this vcms thread
	*/
	public java.util.Date getModifiedDate() {
		return _vcmsThread.getModifiedDate();
	}

	/**
	* Sets the modified date of this vcms thread.
	*
	* @param modifiedDate the modified date of this vcms thread
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vcmsThread.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the modified by user of this vcms thread.
	*
	* @return the modified by user of this vcms thread
	*/
	public java.lang.String getModifiedByUser() {
		return _vcmsThread.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this vcms thread.
	*
	* @param modifiedByUser the modified by user of this vcms thread
	*/
	public void setModifiedByUser(java.lang.String modifiedByUser) {
		_vcmsThread.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the title of this vcms thread.
	*
	* @return the title of this vcms thread
	*/
	public java.lang.String getTitle() {
		return _vcmsThread.getTitle();
	}

	/**
	* Sets the title of this vcms thread.
	*
	* @param title the title of this vcms thread
	*/
	public void setTitle(java.lang.String title) {
		_vcmsThread.setTitle(title);
	}

	/**
	* Returns the description of this vcms thread.
	*
	* @return the description of this vcms thread
	*/
	public java.lang.String getDescription() {
		return _vcmsThread.getDescription();
	}

	/**
	* Sets the description of this vcms thread.
	*
	* @param description the description of this vcms thread
	*/
	public void setDescription(java.lang.String description) {
		_vcmsThread.setDescription(description);
	}

	/**
	* Returns the has image of this vcms thread.
	*
	* @return the has image of this vcms thread
	*/
	public boolean getHasImage() {
		return _vcmsThread.getHasImage();
	}

	/**
	* Returns <code>true</code> if this vcms thread is has image.
	*
	* @return <code>true</code> if this vcms thread is has image; <code>false</code> otherwise
	*/
	public boolean isHasImage() {
		return _vcmsThread.isHasImage();
	}

	/**
	* Sets whether this vcms thread is has image.
	*
	* @param hasImage the has image of this vcms thread
	*/
	public void setHasImage(boolean hasImage) {
		_vcmsThread.setHasImage(hasImage);
	}

	/**
	* Returns the image of this vcms thread.
	*
	* @return the image of this vcms thread
	*/
	public java.lang.String getImage() {
		return _vcmsThread.getImage();
	}

	/**
	* Sets the image of this vcms thread.
	*
	* @param image the image of this vcms thread
	*/
	public void setImage(java.lang.String image) {
		_vcmsThread.setImage(image);
	}

	/**
	* Returns the language of this vcms thread.
	*
	* @return the language of this vcms thread
	*/
	public java.lang.String getLanguage() {
		return _vcmsThread.getLanguage();
	}

	/**
	* Sets the language of this vcms thread.
	*
	* @param language the language of this vcms thread
	*/
	public void setLanguage(java.lang.String language) {
		_vcmsThread.setLanguage(language);
	}

	public boolean isNew() {
		return _vcmsThread.isNew();
	}

	public void setNew(boolean n) {
		_vcmsThread.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsThread.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsThread.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsThread.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsThread.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsThread.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsThread.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsThread.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsThreadWrapper((VcmsThread)_vcmsThread.clone());
	}

	public int compareTo(com.vportal.portlet.vcms.model.VcmsThread vcmsThread) {
		return _vcmsThread.compareTo(vcmsThread);
	}

	@Override
	public int hashCode() {
		return _vcmsThread.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsThread> toCacheModel() {
		return _vcmsThread.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsThread toEscapedModel() {
		return new VcmsThreadWrapper(_vcmsThread.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsThread.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsThread.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsThread.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsThread getWrappedVcmsThread() {
		return _vcmsThread;
	}

	public VcmsThread getWrappedModel() {
		return _vcmsThread;
	}

	public void resetOriginalValues() {
		_vcmsThread.resetOriginalValues();
	}

	private VcmsThread _vcmsThread;
}