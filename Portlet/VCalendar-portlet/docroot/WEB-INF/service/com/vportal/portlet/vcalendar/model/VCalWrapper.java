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

package com.vportal.portlet.vcalendar.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VCal}.
 * </p>
 *
 * @author    LongLH
 * @see       VCal
 * @generated
 */
public class VCalWrapper implements VCal, ModelWrapper<VCal> {
	public VCalWrapper(VCal vCal) {
		_vCal = vCal;
	}

	public Class<?> getModelClass() {
		return VCal.class;
	}

	public String getModelClassName() {
		return VCal.class.getName();
	}

	/**
	* Returns the primary key of this v cal.
	*
	* @return the primary key of this v cal
	*/
	public long getPrimaryKey() {
		return _vCal.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v cal.
	*
	* @param primaryKey the primary key of this v cal
	*/
	public void setPrimaryKey(long primaryKey) {
		_vCal.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cal ID of this v cal.
	*
	* @return the cal ID of this v cal
	*/
	public long getCalId() {
		return _vCal.getCalId();
	}

	/**
	* Sets the cal ID of this v cal.
	*
	* @param calId the cal ID of this v cal
	*/
	public void setCalId(long calId) {
		_vCal.setCalId(calId);
	}

	/**
	* Returns the group ID of this v cal.
	*
	* @return the group ID of this v cal
	*/
	public long getGroupId() {
		return _vCal.getGroupId();
	}

	/**
	* Sets the group ID of this v cal.
	*
	* @param groupId the group ID of this v cal
	*/
	public void setGroupId(long groupId) {
		_vCal.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this v cal.
	*
	* @return the company ID of this v cal
	*/
	public long getCompanyId() {
		return _vCal.getCompanyId();
	}

	/**
	* Sets the company ID of this v cal.
	*
	* @param companyId the company ID of this v cal
	*/
	public void setCompanyId(long companyId) {
		_vCal.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this v cal.
	*
	* @return the user ID of this v cal
	*/
	public long getUserId() {
		return _vCal.getUserId();
	}

	/**
	* Sets the user ID of this v cal.
	*
	* @param userId the user ID of this v cal
	*/
	public void setUserId(long userId) {
		_vCal.setUserId(userId);
	}

	/**
	* Returns the user uuid of this v cal.
	*
	* @return the user uuid of this v cal
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vCal.getUserUuid();
	}

	/**
	* Sets the user uuid of this v cal.
	*
	* @param userUuid the user uuid of this v cal
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_vCal.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this v cal.
	*
	* @return the user name of this v cal
	*/
	public java.lang.String getUserName() {
		return _vCal.getUserName();
	}

	/**
	* Sets the user name of this v cal.
	*
	* @param userName the user name of this v cal
	*/
	public void setUserName(java.lang.String userName) {
		_vCal.setUserName(userName);
	}

	/**
	* Returns the create date of this v cal.
	*
	* @return the create date of this v cal
	*/
	public java.util.Date getCreateDate() {
		return _vCal.getCreateDate();
	}

	/**
	* Sets the create date of this v cal.
	*
	* @param createDate the create date of this v cal
	*/
	public void setCreateDate(java.util.Date createDate) {
		_vCal.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this v cal.
	*
	* @return the modified date of this v cal
	*/
	public java.util.Date getModifiedDate() {
		return _vCal.getModifiedDate();
	}

	/**
	* Sets the modified date of this v cal.
	*
	* @param modifiedDate the modified date of this v cal
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vCal.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the language ID of this v cal.
	*
	* @return the language ID of this v cal
	*/
	public java.lang.String getLanguageId() {
		return _vCal.getLanguageId();
	}

	/**
	* Sets the language ID of this v cal.
	*
	* @param languageId the language ID of this v cal
	*/
	public void setLanguageId(java.lang.String languageId) {
		_vCal.setLanguageId(languageId);
	}

	/**
	* Returns the file ID of this v cal.
	*
	* @return the file ID of this v cal
	*/
	public long getFileId() {
		return _vCal.getFileId();
	}

	/**
	* Sets the file ID of this v cal.
	*
	* @param fileId the file ID of this v cal
	*/
	public void setFileId(long fileId) {
		_vCal.setFileId(fileId);
	}

	/**
	* Returns the title of this v cal.
	*
	* @return the title of this v cal
	*/
	public java.lang.String getTitle() {
		return _vCal.getTitle();
	}

	/**
	* Sets the title of this v cal.
	*
	* @param title the title of this v cal
	*/
	public void setTitle(java.lang.String title) {
		_vCal.setTitle(title);
	}

	/**
	* Returns the description of this v cal.
	*
	* @return the description of this v cal
	*/
	public java.lang.String getDescription() {
		return _vCal.getDescription();
	}

	/**
	* Sets the description of this v cal.
	*
	* @param description the description of this v cal
	*/
	public void setDescription(java.lang.String description) {
		_vCal.setDescription(description);
	}

	/**
	* Returns the guest of this v cal.
	*
	* @return the guest of this v cal
	*/
	public java.lang.String getGuest() {
		return _vCal.getGuest();
	}

	/**
	* Sets the guest of this v cal.
	*
	* @param guest the guest of this v cal
	*/
	public void setGuest(java.lang.String guest) {
		_vCal.setGuest(guest);
	}

	/**
	* Returns the location of this v cal.
	*
	* @return the location of this v cal
	*/
	public java.lang.String getLocation() {
		return _vCal.getLocation();
	}

	/**
	* Sets the location of this v cal.
	*
	* @param location the location of this v cal
	*/
	public void setLocation(java.lang.String location) {
		_vCal.setLocation(location);
	}

	/**
	* Returns the time of this v cal.
	*
	* @return the time of this v cal
	*/
	public java.lang.String getTime() {
		return _vCal.getTime();
	}

	/**
	* Sets the time of this v cal.
	*
	* @param time the time of this v cal
	*/
	public void setTime(java.lang.String time) {
		_vCal.setTime(time);
	}

	/**
	* Returns the start date of this v cal.
	*
	* @return the start date of this v cal
	*/
	public java.util.Date getStartDate() {
		return _vCal.getStartDate();
	}

	/**
	* Sets the start date of this v cal.
	*
	* @param startDate the start date of this v cal
	*/
	public void setStartDate(java.util.Date startDate) {
		_vCal.setStartDate(startDate);
	}

	/**
	* Returns the end date of this v cal.
	*
	* @return the end date of this v cal
	*/
	public java.util.Date getEndDate() {
		return _vCal.getEndDate();
	}

	/**
	* Sets the end date of this v cal.
	*
	* @param endDate the end date of this v cal
	*/
	public void setEndDate(java.util.Date endDate) {
		_vCal.setEndDate(endDate);
	}

	/**
	* Returns the status of this v cal.
	*
	* @return the status of this v cal
	*/
	public long getStatus() {
		return _vCal.getStatus();
	}

	/**
	* Sets the status of this v cal.
	*
	* @param status the status of this v cal
	*/
	public void setStatus(long status) {
		_vCal.setStatus(status);
	}

	public boolean isNew() {
		return _vCal.isNew();
	}

	public void setNew(boolean n) {
		_vCal.setNew(n);
	}

	public boolean isCachedModel() {
		return _vCal.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vCal.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vCal.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vCal.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vCal.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vCal.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vCal.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VCalWrapper((VCal)_vCal.clone());
	}

	public int compareTo(com.vportal.portlet.vcalendar.model.VCal vCal) {
		return _vCal.compareTo(vCal);
	}

	@Override
	public int hashCode() {
		return _vCal.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcalendar.model.VCal> toCacheModel() {
		return _vCal.toCacheModel();
	}

	public com.vportal.portlet.vcalendar.model.VCal toEscapedModel() {
		return new VCalWrapper(_vCal.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vCal.toString();
	}

	public java.lang.String toXmlString() {
		return _vCal.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vCal.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VCal getWrappedVCal() {
		return _vCal;
	}

	public VCal getWrappedModel() {
		return _vCal;
	}

	public void resetOriginalValues() {
		_vCal.resetOriginalValues();
	}

	private VCal _vCal;
}