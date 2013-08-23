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

package com.vportal.portlet.vclip.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ClipType}.
 * </p>
 *
 * @author    HOAN
 * @see       ClipType
 * @generated
 */
public class ClipTypeWrapper implements ClipType, ModelWrapper<ClipType> {
	public ClipTypeWrapper(ClipType clipType) {
		_clipType = clipType;
	}

	public Class<?> getModelClass() {
		return ClipType.class;
	}

	public String getModelClassName() {
		return ClipType.class.getName();
	}

	/**
	* Returns the primary key of this clip type.
	*
	* @return the primary key of this clip type
	*/
	public java.lang.String getPrimaryKey() {
		return _clipType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this clip type.
	*
	* @param primaryKey the primary key of this clip type
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_clipType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this clip type.
	*
	* @return the ID of this clip type
	*/
	public java.lang.String getId() {
		return _clipType.getId();
	}

	/**
	* Sets the ID of this clip type.
	*
	* @param id the ID of this clip type
	*/
	public void setId(java.lang.String id) {
		_clipType.setId(id);
	}

	/**
	* Returns the group ID of this clip type.
	*
	* @return the group ID of this clip type
	*/
	public long getGroupId() {
		return _clipType.getGroupId();
	}

	/**
	* Sets the group ID of this clip type.
	*
	* @param groupId the group ID of this clip type
	*/
	public void setGroupId(long groupId) {
		_clipType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this clip type.
	*
	* @return the company ID of this clip type
	*/
	public long getCompanyId() {
		return _clipType.getCompanyId();
	}

	/**
	* Sets the company ID of this clip type.
	*
	* @param companyId the company ID of this clip type
	*/
	public void setCompanyId(long companyId) {
		_clipType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this clip type.
	*
	* @return the user ID of this clip type
	*/
	public long getUserId() {
		return _clipType.getUserId();
	}

	/**
	* Sets the user ID of this clip type.
	*
	* @param userId the user ID of this clip type
	*/
	public void setUserId(long userId) {
		_clipType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this clip type.
	*
	* @return the user uuid of this clip type
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clipType.getUserUuid();
	}

	/**
	* Sets the user uuid of this clip type.
	*
	* @param userUuid the user uuid of this clip type
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_clipType.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this clip type.
	*
	* @return the created date of this clip type
	*/
	public java.util.Date getCreatedDate() {
		return _clipType.getCreatedDate();
	}

	/**
	* Sets the created date of this clip type.
	*
	* @param createdDate the created date of this clip type
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_clipType.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this clip type.
	*
	* @return the modified date of this clip type
	*/
	public java.util.Date getModifiedDate() {
		return _clipType.getModifiedDate();
	}

	/**
	* Sets the modified date of this clip type.
	*
	* @param modifiedDate the modified date of this clip type
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_clipType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this clip type.
	*
	* @return the title of this clip type
	*/
	public java.lang.String getTitle() {
		return _clipType.getTitle();
	}

	/**
	* Sets the title of this clip type.
	*
	* @param title the title of this clip type
	*/
	public void setTitle(java.lang.String title) {
		_clipType.setTitle(title);
	}

	/**
	* Returns the name of this clip type.
	*
	* @return the name of this clip type
	*/
	public java.lang.String getName() {
		return _clipType.getName();
	}

	/**
	* Sets the name of this clip type.
	*
	* @param name the name of this clip type
	*/
	public void setName(java.lang.String name) {
		_clipType.setName(name);
	}

	/**
	* Returns the description of this clip type.
	*
	* @return the description of this clip type
	*/
	public java.lang.String getDescription() {
		return _clipType.getDescription();
	}

	/**
	* Sets the description of this clip type.
	*
	* @param description the description of this clip type
	*/
	public void setDescription(java.lang.String description) {
		_clipType.setDescription(description);
	}

	/**
	* Returns the active of this clip type.
	*
	* @return the active of this clip type
	*/
	public boolean getActive() {
		return _clipType.getActive();
	}

	/**
	* Returns <code>true</code> if this clip type is active.
	*
	* @return <code>true</code> if this clip type is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _clipType.isActive();
	}

	/**
	* Sets whether this clip type is active.
	*
	* @param active the active of this clip type
	*/
	public void setActive(boolean active) {
		_clipType.setActive(active);
	}

	/**
	* Returns the language of this clip type.
	*
	* @return the language of this clip type
	*/
	public java.lang.String getLanguage() {
		return _clipType.getLanguage();
	}

	/**
	* Sets the language of this clip type.
	*
	* @param language the language of this clip type
	*/
	public void setLanguage(java.lang.String language) {
		_clipType.setLanguage(language);
	}

	public boolean isNew() {
		return _clipType.isNew();
	}

	public void setNew(boolean n) {
		_clipType.setNew(n);
	}

	public boolean isCachedModel() {
		return _clipType.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_clipType.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _clipType.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _clipType.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_clipType.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _clipType.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_clipType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ClipTypeWrapper((ClipType)_clipType.clone());
	}

	public int compareTo(com.vportal.portlet.vclip.model.ClipType clipType) {
		return _clipType.compareTo(clipType);
	}

	@Override
	public int hashCode() {
		return _clipType.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vclip.model.ClipType> toCacheModel() {
		return _clipType.toCacheModel();
	}

	public com.vportal.portlet.vclip.model.ClipType toEscapedModel() {
		return new ClipTypeWrapper(_clipType.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _clipType.toString();
	}

	public java.lang.String toXmlString() {
		return _clipType.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_clipType.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ClipType getWrappedClipType() {
		return _clipType;
	}

	public ClipType getWrappedModel() {
		return _clipType;
	}

	public void resetOriginalValues() {
		_clipType.resetOriginalValues();
	}

	private ClipType _clipType;
}