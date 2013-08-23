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
 * This class is a wrapper for {@link vdocLogger}.
 * </p>
 *
 * @author    MrEn
 * @see       vdocLogger
 * @generated
 */
public class vdocLoggerWrapper implements vdocLogger, ModelWrapper<vdocLogger> {
	public vdocLoggerWrapper(vdocLogger vdocLogger) {
		_vdocLogger = vdocLogger;
	}

	public Class<?> getModelClass() {
		return vdocLogger.class;
	}

	public String getModelClassName() {
		return vdocLogger.class.getName();
	}

	/**
	* Returns the primary key of this vdoc logger.
	*
	* @return the primary key of this vdoc logger
	*/
	public java.lang.String getPrimaryKey() {
		return _vdocLogger.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vdoc logger.
	*
	* @param primaryKey the primary key of this vdoc logger
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vdocLogger.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the logger ID of this vdoc logger.
	*
	* @return the logger ID of this vdoc logger
	*/
	public java.lang.String getLoggerId() {
		return _vdocLogger.getLoggerId();
	}

	/**
	* Sets the logger ID of this vdoc logger.
	*
	* @param loggerId the logger ID of this vdoc logger
	*/
	public void setLoggerId(java.lang.String loggerId) {
		_vdocLogger.setLoggerId(loggerId);
	}

	/**
	* Returns the group ID of this vdoc logger.
	*
	* @return the group ID of this vdoc logger
	*/
	public long getGroupId() {
		return _vdocLogger.getGroupId();
	}

	/**
	* Sets the group ID of this vdoc logger.
	*
	* @param groupId the group ID of this vdoc logger
	*/
	public void setGroupId(long groupId) {
		_vdocLogger.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vdoc logger.
	*
	* @return the company ID of this vdoc logger
	*/
	public long getCompanyId() {
		return _vdocLogger.getCompanyId();
	}

	/**
	* Sets the company ID of this vdoc logger.
	*
	* @param companyId the company ID of this vdoc logger
	*/
	public void setCompanyId(long companyId) {
		_vdocLogger.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vdoc logger.
	*
	* @return the user ID of this vdoc logger
	*/
	public long getUserId() {
		return _vdocLogger.getUserId();
	}

	/**
	* Sets the user ID of this vdoc logger.
	*
	* @param userId the user ID of this vdoc logger
	*/
	public void setUserId(long userId) {
		_vdocLogger.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vdoc logger.
	*
	* @return the user uuid of this vdoc logger
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocLogger.getUserUuid();
	}

	/**
	* Sets the user uuid of this vdoc logger.
	*
	* @param userUuid the user uuid of this vdoc logger
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_vdocLogger.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this vdoc logger.
	*
	* @return the created date of this vdoc logger
	*/
	public java.util.Date getCreatedDate() {
		return _vdocLogger.getCreatedDate();
	}

	/**
	* Sets the created date of this vdoc logger.
	*
	* @param createdDate the created date of this vdoc logger
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vdocLogger.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by user of this vdoc logger.
	*
	* @return the created by user of this vdoc logger
	*/
	public long getCreatedByUser() {
		return _vdocLogger.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vdoc logger.
	*
	* @param createdByUser the created by user of this vdoc logger
	*/
	public void setCreatedByUser(long createdByUser) {
		_vdocLogger.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the content of this vdoc logger.
	*
	* @return the content of this vdoc logger
	*/
	public java.lang.String getContent() {
		return _vdocLogger.getContent();
	}

	/**
	* Sets the content of this vdoc logger.
	*
	* @param content the content of this vdoc logger
	*/
	public void setContent(java.lang.String content) {
		_vdocLogger.setContent(content);
	}

	public boolean isNew() {
		return _vdocLogger.isNew();
	}

	public void setNew(boolean n) {
		_vdocLogger.setNew(n);
	}

	public boolean isCachedModel() {
		return _vdocLogger.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vdocLogger.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vdocLogger.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vdocLogger.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vdocLogger.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vdocLogger.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vdocLogger.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new vdocLoggerWrapper((vdocLogger)_vdocLogger.clone());
	}

	public int compareTo(com.vportal.portlet.vdoc.model.vdocLogger vdocLogger) {
		return _vdocLogger.compareTo(vdocLogger);
	}

	@Override
	public int hashCode() {
		return _vdocLogger.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vdoc.model.vdocLogger> toCacheModel() {
		return _vdocLogger.toCacheModel();
	}

	public com.vportal.portlet.vdoc.model.vdocLogger toEscapedModel() {
		return new vdocLoggerWrapper(_vdocLogger.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vdocLogger.toString();
	}

	public java.lang.String toXmlString() {
		return _vdocLogger.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public vdocLogger getWrappedvdocLogger() {
		return _vdocLogger;
	}

	public vdocLogger getWrappedModel() {
		return _vdocLogger;
	}

	public void resetOriginalValues() {
		_vdocLogger.resetOriginalValues();
	}

	private vdocLogger _vdocLogger;
}