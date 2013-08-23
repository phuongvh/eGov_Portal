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
 * This class is a wrapper for {@link VcmsStatus}.
 * </p>
 *
 * @author    hai
 * @see       VcmsStatus
 * @generated
 */
public class VcmsStatusWrapper implements VcmsStatus, ModelWrapper<VcmsStatus> {
	public VcmsStatusWrapper(VcmsStatus vcmsStatus) {
		_vcmsStatus = vcmsStatus;
	}

	public Class<?> getModelClass() {
		return VcmsStatus.class;
	}

	public String getModelClassName() {
		return VcmsStatus.class.getName();
	}

	/**
	* Returns the primary key of this vcms status.
	*
	* @return the primary key of this vcms status
	*/
	public long getPrimaryKey() {
		return _vcmsStatus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms status.
	*
	* @param primaryKey the primary key of this vcms status
	*/
	public void setPrimaryKey(long primaryKey) {
		_vcmsStatus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the status ID of this vcms status.
	*
	* @return the status ID of this vcms status
	*/
	public long getStatusId() {
		return _vcmsStatus.getStatusId();
	}

	/**
	* Sets the status ID of this vcms status.
	*
	* @param statusId the status ID of this vcms status
	*/
	public void setStatusId(long statusId) {
		_vcmsStatus.setStatusId(statusId);
	}

	/**
	* Returns the company ID of this vcms status.
	*
	* @return the company ID of this vcms status
	*/
	public long getCompanyId() {
		return _vcmsStatus.getCompanyId();
	}

	/**
	* Sets the company ID of this vcms status.
	*
	* @param companyId the company ID of this vcms status
	*/
	public void setCompanyId(long companyId) {
		_vcmsStatus.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this vcms status.
	*
	* @return the group ID of this vcms status
	*/
	public long getGroupId() {
		return _vcmsStatus.getGroupId();
	}

	/**
	* Sets the group ID of this vcms status.
	*
	* @param groupId the group ID of this vcms status
	*/
	public void setGroupId(long groupId) {
		_vcmsStatus.setGroupId(groupId);
	}

	/**
	* Returns the created date of this vcms status.
	*
	* @return the created date of this vcms status
	*/
	public java.util.Date getCreatedDate() {
		return _vcmsStatus.getCreatedDate();
	}

	/**
	* Sets the created date of this vcms status.
	*
	* @param createdDate the created date of this vcms status
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vcmsStatus.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by user of this vcms status.
	*
	* @return the created by user of this vcms status
	*/
	public java.lang.String getCreatedByUser() {
		return _vcmsStatus.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vcms status.
	*
	* @param createdByUser the created by user of this vcms status
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_vcmsStatus.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the modified date of this vcms status.
	*
	* @return the modified date of this vcms status
	*/
	public java.util.Date getModifiedDate() {
		return _vcmsStatus.getModifiedDate();
	}

	/**
	* Sets the modified date of this vcms status.
	*
	* @param modifiedDate the modified date of this vcms status
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vcmsStatus.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the modified by user of this vcms status.
	*
	* @return the modified by user of this vcms status
	*/
	public java.lang.String getModifiedByUser() {
		return _vcmsStatus.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this vcms status.
	*
	* @param modifiedByUser the modified by user of this vcms status
	*/
	public void setModifiedByUser(java.lang.String modifiedByUser) {
		_vcmsStatus.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the name of this vcms status.
	*
	* @return the name of this vcms status
	*/
	public java.lang.String getName() {
		return _vcmsStatus.getName();
	}

	/**
	* Sets the name of this vcms status.
	*
	* @param name the name of this vcms status
	*/
	public void setName(java.lang.String name) {
		_vcmsStatus.setName(name);
	}

	/**
	* Returns the description of this vcms status.
	*
	* @return the description of this vcms status
	*/
	public java.lang.String getDescription() {
		return _vcmsStatus.getDescription();
	}

	/**
	* Sets the description of this vcms status.
	*
	* @param description the description of this vcms status
	*/
	public void setDescription(java.lang.String description) {
		_vcmsStatus.setDescription(description);
	}

	/**
	* Returns the css class of this vcms status.
	*
	* @return the css class of this vcms status
	*/
	public java.lang.String getCssClass() {
		return _vcmsStatus.getCssClass();
	}

	/**
	* Sets the css class of this vcms status.
	*
	* @param cssClass the css class of this vcms status
	*/
	public void setCssClass(java.lang.String cssClass) {
		_vcmsStatus.setCssClass(cssClass);
	}

	/**
	* Returns the text color of this vcms status.
	*
	* @return the text color of this vcms status
	*/
	public java.lang.String getTextColor() {
		return _vcmsStatus.getTextColor();
	}

	/**
	* Sets the text color of this vcms status.
	*
	* @param textColor the text color of this vcms status
	*/
	public void setTextColor(java.lang.String textColor) {
		_vcmsStatus.setTextColor(textColor);
	}

	/**
	* Returns the position of this vcms status.
	*
	* @return the position of this vcms status
	*/
	public long getPosition() {
		return _vcmsStatus.getPosition();
	}

	/**
	* Sets the position of this vcms status.
	*
	* @param position the position of this vcms status
	*/
	public void setPosition(long position) {
		_vcmsStatus.setPosition(position);
	}

	/**
	* Returns the is primary of this vcms status.
	*
	* @return the is primary of this vcms status
	*/
	public boolean getIsPrimary() {
		return _vcmsStatus.getIsPrimary();
	}

	/**
	* Returns <code>true</code> if this vcms status is is primary.
	*
	* @return <code>true</code> if this vcms status is is primary; <code>false</code> otherwise
	*/
	public boolean isIsPrimary() {
		return _vcmsStatus.isIsPrimary();
	}

	/**
	* Sets whether this vcms status is is primary.
	*
	* @param isPrimary the is primary of this vcms status
	*/
	public void setIsPrimary(boolean isPrimary) {
		_vcmsStatus.setIsPrimary(isPrimary);
	}

	/**
	* Returns the active of this vcms status.
	*
	* @return the active of this vcms status
	*/
	public boolean getActive() {
		return _vcmsStatus.getActive();
	}

	/**
	* Returns <code>true</code> if this vcms status is active.
	*
	* @return <code>true</code> if this vcms status is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _vcmsStatus.isActive();
	}

	/**
	* Sets whether this vcms status is active.
	*
	* @param active the active of this vcms status
	*/
	public void setActive(boolean active) {
		_vcmsStatus.setActive(active);
	}

	public boolean isNew() {
		return _vcmsStatus.isNew();
	}

	public void setNew(boolean n) {
		_vcmsStatus.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsStatus.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsStatus.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsStatus.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsStatus.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsStatus.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsStatus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsStatusWrapper((VcmsStatus)_vcmsStatus.clone());
	}

	public int compareTo(com.vportal.portlet.vcms.model.VcmsStatus vcmsStatus) {
		return _vcmsStatus.compareTo(vcmsStatus);
	}

	@Override
	public int hashCode() {
		return _vcmsStatus.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsStatus> toCacheModel() {
		return _vcmsStatus.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsStatus toEscapedModel() {
		return new VcmsStatusWrapper(_vcmsStatus.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsStatus.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsStatus.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsStatus.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsStatus getWrappedVcmsStatus() {
		return _vcmsStatus;
	}

	public VcmsStatus getWrappedModel() {
		return _vcmsStatus;
	}

	public void resetOriginalValues() {
		_vcmsStatus.resetOriginalValues();
	}

	private VcmsStatus _vcmsStatus;
}