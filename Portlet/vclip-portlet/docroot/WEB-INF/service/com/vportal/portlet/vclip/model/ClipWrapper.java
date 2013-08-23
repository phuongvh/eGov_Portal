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
 * This class is a wrapper for {@link Clip}.
 * </p>
 *
 * @author    HOAN
 * @see       Clip
 * @generated
 */
public class ClipWrapper implements Clip, ModelWrapper<Clip> {
	public ClipWrapper(Clip clip) {
		_clip = clip;
	}

	public Class<?> getModelClass() {
		return Clip.class;
	}

	public String getModelClassName() {
		return Clip.class.getName();
	}

	/**
	* Returns the primary key of this clip.
	*
	* @return the primary key of this clip
	*/
	public java.lang.String getPrimaryKey() {
		return _clip.getPrimaryKey();
	}

	/**
	* Sets the primary key of this clip.
	*
	* @param primaryKey the primary key of this clip
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_clip.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this clip.
	*
	* @return the ID of this clip
	*/
	public java.lang.String getId() {
		return _clip.getId();
	}

	/**
	* Sets the ID of this clip.
	*
	* @param id the ID of this clip
	*/
	public void setId(java.lang.String id) {
		_clip.setId(id);
	}

	/**
	* Returns the clip type ID of this clip.
	*
	* @return the clip type ID of this clip
	*/
	public java.lang.String getClipTypeId() {
		return _clip.getClipTypeId();
	}

	/**
	* Sets the clip type ID of this clip.
	*
	* @param clipTypeId the clip type ID of this clip
	*/
	public void setClipTypeId(java.lang.String clipTypeId) {
		_clip.setClipTypeId(clipTypeId);
	}

	/**
	* Returns the group ID of this clip.
	*
	* @return the group ID of this clip
	*/
	public long getGroupId() {
		return _clip.getGroupId();
	}

	/**
	* Sets the group ID of this clip.
	*
	* @param groupId the group ID of this clip
	*/
	public void setGroupId(long groupId) {
		_clip.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this clip.
	*
	* @return the company ID of this clip
	*/
	public long getCompanyId() {
		return _clip.getCompanyId();
	}

	/**
	* Sets the company ID of this clip.
	*
	* @param companyId the company ID of this clip
	*/
	public void setCompanyId(long companyId) {
		_clip.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this clip.
	*
	* @return the user ID of this clip
	*/
	public long getUserId() {
		return _clip.getUserId();
	}

	/**
	* Sets the user ID of this clip.
	*
	* @param userId the user ID of this clip
	*/
	public void setUserId(long userId) {
		_clip.setUserId(userId);
	}

	/**
	* Returns the user uuid of this clip.
	*
	* @return the user uuid of this clip
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _clip.getUserUuid();
	}

	/**
	* Sets the user uuid of this clip.
	*
	* @param userUuid the user uuid of this clip
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_clip.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this clip.
	*
	* @return the created date of this clip
	*/
	public java.util.Date getCreatedDate() {
		return _clip.getCreatedDate();
	}

	/**
	* Sets the created date of this clip.
	*
	* @param createdDate the created date of this clip
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_clip.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this clip.
	*
	* @return the modified date of this clip
	*/
	public java.util.Date getModifiedDate() {
		return _clip.getModifiedDate();
	}

	/**
	* Sets the modified date of this clip.
	*
	* @param modifiedDate the modified date of this clip
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_clip.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the url of this clip.
	*
	* @return the url of this clip
	*/
	public java.lang.String getUrl() {
		return _clip.getUrl();
	}

	/**
	* Sets the url of this clip.
	*
	* @param url the url of this clip
	*/
	public void setUrl(java.lang.String url) {
		_clip.setUrl(url);
	}

	/**
	* Returns the name of this clip.
	*
	* @return the name of this clip
	*/
	public java.lang.String getName() {
		return _clip.getName();
	}

	/**
	* Sets the name of this clip.
	*
	* @param name the name of this clip
	*/
	public void setName(java.lang.String name) {
		_clip.setName(name);
	}

	/**
	* Returns the title of this clip.
	*
	* @return the title of this clip
	*/
	public java.lang.String getTitle() {
		return _clip.getTitle();
	}

	/**
	* Sets the title of this clip.
	*
	* @param title the title of this clip
	*/
	public void setTitle(java.lang.String title) {
		_clip.setTitle(title);
	}

	/**
	* Returns the image of this clip.
	*
	* @return the image of this clip
	*/
	public java.lang.String getImage() {
		return _clip.getImage();
	}

	/**
	* Sets the image of this clip.
	*
	* @param image the image of this clip
	*/
	public void setImage(java.lang.String image) {
		_clip.setImage(image);
	}

	/**
	* Returns the description of this clip.
	*
	* @return the description of this clip
	*/
	public java.lang.String getDescription() {
		return _clip.getDescription();
	}

	/**
	* Sets the description of this clip.
	*
	* @param description the description of this clip
	*/
	public void setDescription(java.lang.String description) {
		_clip.setDescription(description);
	}

	/**
	* Returns the active of this clip.
	*
	* @return the active of this clip
	*/
	public boolean getActive() {
		return _clip.getActive();
	}

	/**
	* Returns <code>true</code> if this clip is active.
	*
	* @return <code>true</code> if this clip is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _clip.isActive();
	}

	/**
	* Sets whether this clip is active.
	*
	* @param active the active of this clip
	*/
	public void setActive(boolean active) {
		_clip.setActive(active);
	}

	/**
	* Returns the language of this clip.
	*
	* @return the language of this clip
	*/
	public java.lang.String getLanguage() {
		return _clip.getLanguage();
	}

	/**
	* Sets the language of this clip.
	*
	* @param language the language of this clip
	*/
	public void setLanguage(java.lang.String language) {
		_clip.setLanguage(language);
	}

	/**
	* Returns the hitcount of this clip.
	*
	* @return the hitcount of this clip
	*/
	public long getHitcount() {
		return _clip.getHitcount();
	}

	/**
	* Sets the hitcount of this clip.
	*
	* @param hitcount the hitcount of this clip
	*/
	public void setHitcount(long hitcount) {
		_clip.setHitcount(hitcount);
	}

	/**
	* Returns the hitcountview of this clip.
	*
	* @return the hitcountview of this clip
	*/
	public long getHitcountview() {
		return _clip.getHitcountview();
	}

	/**
	* Sets the hitcountview of this clip.
	*
	* @param hitcountview the hitcountview of this clip
	*/
	public void setHitcountview(long hitcountview) {
		_clip.setHitcountview(hitcountview);
	}

	public boolean isNew() {
		return _clip.isNew();
	}

	public void setNew(boolean n) {
		_clip.setNew(n);
	}

	public boolean isCachedModel() {
		return _clip.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_clip.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _clip.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _clip.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_clip.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _clip.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_clip.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ClipWrapper((Clip)_clip.clone());
	}

	public int compareTo(com.vportal.portlet.vclip.model.Clip clip) {
		return _clip.compareTo(clip);
	}

	@Override
	public int hashCode() {
		return _clip.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vclip.model.Clip> toCacheModel() {
		return _clip.toCacheModel();
	}

	public com.vportal.portlet.vclip.model.Clip toEscapedModel() {
		return new ClipWrapper(_clip.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _clip.toString();
	}

	public java.lang.String toXmlString() {
		return _clip.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_clip.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Clip getWrappedClip() {
		return _clip;
	}

	public Clip getWrappedModel() {
		return _clip;
	}

	public void resetOriginalValues() {
		_clip.resetOriginalValues();
	}

	private Clip _clip;
}