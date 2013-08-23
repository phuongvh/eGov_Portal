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
 * This class is a wrapper for {@link VcmsLogger}.
 * </p>
 *
 * @author    hai
 * @see       VcmsLogger
 * @generated
 */
public class VcmsLoggerWrapper implements VcmsLogger, ModelWrapper<VcmsLogger> {
	public VcmsLoggerWrapper(VcmsLogger vcmsLogger) {
		_vcmsLogger = vcmsLogger;
	}

	public Class<?> getModelClass() {
		return VcmsLogger.class;
	}

	public String getModelClassName() {
		return VcmsLogger.class.getName();
	}

	/**
	* Returns the primary key of this vcms logger.
	*
	* @return the primary key of this vcms logger
	*/
	public java.lang.String getPrimaryKey() {
		return _vcmsLogger.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms logger.
	*
	* @param primaryKey the primary key of this vcms logger
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vcmsLogger.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the logger ID of this vcms logger.
	*
	* @return the logger ID of this vcms logger
	*/
	public java.lang.String getLoggerId() {
		return _vcmsLogger.getLoggerId();
	}

	/**
	* Sets the logger ID of this vcms logger.
	*
	* @param loggerId the logger ID of this vcms logger
	*/
	public void setLoggerId(java.lang.String loggerId) {
		_vcmsLogger.setLoggerId(loggerId);
	}

	/**
	* Returns the group ID of this vcms logger.
	*
	* @return the group ID of this vcms logger
	*/
	public long getGroupId() {
		return _vcmsLogger.getGroupId();
	}

	/**
	* Sets the group ID of this vcms logger.
	*
	* @param groupId the group ID of this vcms logger
	*/
	public void setGroupId(long groupId) {
		_vcmsLogger.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vcms logger.
	*
	* @return the company ID of this vcms logger
	*/
	public long getCompanyId() {
		return _vcmsLogger.getCompanyId();
	}

	/**
	* Sets the company ID of this vcms logger.
	*
	* @param companyId the company ID of this vcms logger
	*/
	public void setCompanyId(long companyId) {
		_vcmsLogger.setCompanyId(companyId);
	}

	/**
	* Returns the created date of this vcms logger.
	*
	* @return the created date of this vcms logger
	*/
	public java.util.Date getCreatedDate() {
		return _vcmsLogger.getCreatedDate();
	}

	/**
	* Sets the created date of this vcms logger.
	*
	* @param createdDate the created date of this vcms logger
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vcmsLogger.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by user of this vcms logger.
	*
	* @return the created by user of this vcms logger
	*/
	public java.lang.String getCreatedByUser() {
		return _vcmsLogger.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vcms logger.
	*
	* @param createdByUser the created by user of this vcms logger
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_vcmsLogger.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the content of this vcms logger.
	*
	* @return the content of this vcms logger
	*/
	public java.lang.String getContent() {
		return _vcmsLogger.getContent();
	}

	/**
	* Sets the content of this vcms logger.
	*
	* @param content the content of this vcms logger
	*/
	public void setContent(java.lang.String content) {
		_vcmsLogger.setContent(content);
	}

	public boolean isNew() {
		return _vcmsLogger.isNew();
	}

	public void setNew(boolean n) {
		_vcmsLogger.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsLogger.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsLogger.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsLogger.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsLogger.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsLogger.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsLogger.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsLogger.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsLoggerWrapper((VcmsLogger)_vcmsLogger.clone());
	}

	public int compareTo(com.vportal.portlet.vcms.model.VcmsLogger vcmsLogger) {
		return _vcmsLogger.compareTo(vcmsLogger);
	}

	@Override
	public int hashCode() {
		return _vcmsLogger.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsLogger> toCacheModel() {
		return _vcmsLogger.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsLogger toEscapedModel() {
		return new VcmsLoggerWrapper(_vcmsLogger.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsLogger.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsLogger.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsLogger.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsLogger getWrappedVcmsLogger() {
		return _vcmsLogger;
	}

	public VcmsLogger getWrappedModel() {
		return _vcmsLogger;
	}

	public void resetOriginalValues() {
		_vcmsLogger.resetOriginalValues();
	}

	private VcmsLogger _vcmsLogger;
}