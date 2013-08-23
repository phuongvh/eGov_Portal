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

package com.vportal.portlet.vdoc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link vdocField}.
 * </p>
 *
 * @author    MrEn
 * @see       vdocField
 * @generated
 */
public class vdocFieldWrapper implements vdocField, ModelWrapper<vdocField> {
	public vdocFieldWrapper(vdocField vdocField) {
		_vdocField = vdocField;
	}

	public Class<?> getModelClass() {
		return vdocField.class;
	}

	public String getModelClassName() {
		return vdocField.class.getName();
	}

	/**
	* Returns the primary key of this vdoc field.
	*
	* @return the primary key of this vdoc field
	*/
	public java.lang.String getPrimaryKey() {
		return _vdocField.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vdoc field.
	*
	* @param primaryKey the primary key of this vdoc field
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vdocField.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the field ID of this vdoc field.
	*
	* @return the field ID of this vdoc field
	*/
	public java.lang.String getFieldId() {
		return _vdocField.getFieldId();
	}

	/**
	* Sets the field ID of this vdoc field.
	*
	* @param fieldId the field ID of this vdoc field
	*/
	public void setFieldId(java.lang.String fieldId) {
		_vdocField.setFieldId(fieldId);
	}

	/**
	* Returns the group ID of this vdoc field.
	*
	* @return the group ID of this vdoc field
	*/
	public long getGroupId() {
		return _vdocField.getGroupId();
	}

	/**
	* Sets the group ID of this vdoc field.
	*
	* @param groupId the group ID of this vdoc field
	*/
	public void setGroupId(long groupId) {
		_vdocField.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vdoc field.
	*
	* @return the company ID of this vdoc field
	*/
	public long getCompanyId() {
		return _vdocField.getCompanyId();
	}

	/**
	* Sets the company ID of this vdoc field.
	*
	* @param companyId the company ID of this vdoc field
	*/
	public void setCompanyId(long companyId) {
		_vdocField.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vdoc field.
	*
	* @return the user ID of this vdoc field
	*/
	public long getUserId() {
		return _vdocField.getUserId();
	}

	/**
	* Sets the user ID of this vdoc field.
	*
	* @param userId the user ID of this vdoc field
	*/
	public void setUserId(long userId) {
		_vdocField.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vdoc field.
	*
	* @return the user uuid of this vdoc field
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocField.getUserUuid();
	}

	/**
	* Sets the user uuid of this vdoc field.
	*
	* @param userUuid the user uuid of this vdoc field
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_vdocField.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this vdoc field.
	*
	* @return the created date of this vdoc field
	*/
	public java.util.Date getCreatedDate() {
		return _vdocField.getCreatedDate();
	}

	/**
	* Sets the created date of this vdoc field.
	*
	* @param createdDate the created date of this vdoc field
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vdocField.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this vdoc field.
	*
	* @return the modified date of this vdoc field
	*/
	public java.util.Date getModifiedDate() {
		return _vdocField.getModifiedDate();
	}

	/**
	* Sets the modified date of this vdoc field.
	*
	* @param modifiedDate the modified date of this vdoc field
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vdocField.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the created by user of this vdoc field.
	*
	* @return the created by user of this vdoc field
	*/
	public long getCreatedByUser() {
		return _vdocField.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vdoc field.
	*
	* @param createdByUser the created by user of this vdoc field
	*/
	public void setCreatedByUser(long createdByUser) {
		_vdocField.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the modified by user of this vdoc field.
	*
	* @return the modified by user of this vdoc field
	*/
	public long getModifiedByUser() {
		return _vdocField.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this vdoc field.
	*
	* @param modifiedByUser the modified by user of this vdoc field
	*/
	public void setModifiedByUser(long modifiedByUser) {
		_vdocField.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the parent ID of this vdoc field.
	*
	* @return the parent ID of this vdoc field
	*/
	public java.lang.String getParentId() {
		return _vdocField.getParentId();
	}

	/**
	* Sets the parent ID of this vdoc field.
	*
	* @param parentId the parent ID of this vdoc field
	*/
	public void setParentId(java.lang.String parentId) {
		_vdocField.setParentId(parentId);
	}

	/**
	* Returns the name of this vdoc field.
	*
	* @return the name of this vdoc field
	*/
	public java.lang.String getName() {
		return _vdocField.getName();
	}

	/**
	* Sets the name of this vdoc field.
	*
	* @param name the name of this vdoc field
	*/
	public void setName(java.lang.String name) {
		_vdocField.setName(name);
	}

	/**
	* Returns the description of this vdoc field.
	*
	* @return the description of this vdoc field
	*/
	public java.lang.String getDescription() {
		return _vdocField.getDescription();
	}

	/**
	* Sets the description of this vdoc field.
	*
	* @param description the description of this vdoc field
	*/
	public void setDescription(java.lang.String description) {
		_vdocField.setDescription(description);
	}

	/**
	* Returns the language of this vdoc field.
	*
	* @return the language of this vdoc field
	*/
	public java.lang.String getLanguage() {
		return _vdocField.getLanguage();
	}

	/**
	* Sets the language of this vdoc field.
	*
	* @param language the language of this vdoc field
	*/
	public void setLanguage(java.lang.String language) {
		_vdocField.setLanguage(language);
	}

	/**
	* Returns the status field of this vdoc field.
	*
	* @return the status field of this vdoc field
	*/
	public boolean getStatusField() {
		return _vdocField.getStatusField();
	}

	/**
	* Returns <code>true</code> if this vdoc field is status field.
	*
	* @return <code>true</code> if this vdoc field is status field; <code>false</code> otherwise
	*/
	public boolean isStatusField() {
		return _vdocField.isStatusField();
	}

	/**
	* Sets whether this vdoc field is status field.
	*
	* @param statusField the status field of this vdoc field
	*/
	public void setStatusField(boolean statusField) {
		_vdocField.setStatusField(statusField);
	}

	/**
	* Returns the position of this vdoc field.
	*
	* @return the position of this vdoc field
	*/
	public int getPosition() {
		return _vdocField.getPosition();
	}

	/**
	* Sets the position of this vdoc field.
	*
	* @param position the position of this vdoc field
	*/
	public void setPosition(int position) {
		_vdocField.setPosition(position);
	}

	/**
	* Returns the listparent of this vdoc field.
	*
	* @return the listparent of this vdoc field
	*/
	public java.lang.String getListparent() {
		return _vdocField.getListparent();
	}

	/**
	* Sets the listparent of this vdoc field.
	*
	* @param listparent the listparent of this vdoc field
	*/
	public void setListparent(java.lang.String listparent) {
		_vdocField.setListparent(listparent);
	}

	public boolean isNew() {
		return _vdocField.isNew();
	}

	public void setNew(boolean n) {
		_vdocField.setNew(n);
	}

	public boolean isCachedModel() {
		return _vdocField.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vdocField.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vdocField.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vdocField.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vdocField.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vdocField.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vdocField.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new vdocFieldWrapper((vdocField)_vdocField.clone());
	}

	public int compareTo(com.vportal.portlet.vdoc.model.vdocField vdocField) {
		return _vdocField.compareTo(vdocField);
	}

	@Override
	public int hashCode() {
		return _vdocField.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vdoc.model.vdocField> toCacheModel() {
		return _vdocField.toCacheModel();
	}

	public com.vportal.portlet.vdoc.model.vdocField toEscapedModel() {
		return new vdocFieldWrapper(_vdocField.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vdocField.toString();
	}

	public java.lang.String toXmlString() {
		return _vdocField.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public vdocField getWrappedvdocField() {
		return _vdocField;
	}

	public vdocField getWrappedModel() {
		return _vdocField;
	}

	public void resetOriginalValues() {
		_vdocField.resetOriginalValues();
	}

	private vdocField _vdocField;
}