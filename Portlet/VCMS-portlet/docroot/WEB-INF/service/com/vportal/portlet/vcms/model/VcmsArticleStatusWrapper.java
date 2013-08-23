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
 * This class is a wrapper for {@link VcmsArticleStatus}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticleStatus
 * @generated
 */
public class VcmsArticleStatusWrapper implements VcmsArticleStatus,
	ModelWrapper<VcmsArticleStatus> {
	public VcmsArticleStatusWrapper(VcmsArticleStatus vcmsArticleStatus) {
		_vcmsArticleStatus = vcmsArticleStatus;
	}

	public Class<?> getModelClass() {
		return VcmsArticleStatus.class;
	}

	public String getModelClassName() {
		return VcmsArticleStatus.class.getName();
	}

	/**
	* Returns the primary key of this vcms article status.
	*
	* @return the primary key of this vcms article status
	*/
	public long getPrimaryKey() {
		return _vcmsArticleStatus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms article status.
	*
	* @param primaryKey the primary key of this vcms article status
	*/
	public void setPrimaryKey(long primaryKey) {
		_vcmsArticleStatus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this vcms article status.
	*
	* @return the ID of this vcms article status
	*/
	public long getId() {
		return _vcmsArticleStatus.getId();
	}

	/**
	* Sets the ID of this vcms article status.
	*
	* @param id the ID of this vcms article status
	*/
	public void setId(long id) {
		_vcmsArticleStatus.setId(id);
	}

	/**
	* Returns the status ID of this vcms article status.
	*
	* @return the status ID of this vcms article status
	*/
	public long getStatusId() {
		return _vcmsArticleStatus.getStatusId();
	}

	/**
	* Sets the status ID of this vcms article status.
	*
	* @param statusId the status ID of this vcms article status
	*/
	public void setStatusId(long statusId) {
		_vcmsArticleStatus.setStatusId(statusId);
	}

	/**
	* Returns the article ID of this vcms article status.
	*
	* @return the article ID of this vcms article status
	*/
	public java.lang.String getArticleId() {
		return _vcmsArticleStatus.getArticleId();
	}

	/**
	* Sets the article ID of this vcms article status.
	*
	* @param articleId the article ID of this vcms article status
	*/
	public void setArticleId(java.lang.String articleId) {
		_vcmsArticleStatus.setArticleId(articleId);
	}

	/**
	* Returns the category ID of this vcms article status.
	*
	* @return the category ID of this vcms article status
	*/
	public java.lang.String getCategoryId() {
		return _vcmsArticleStatus.getCategoryId();
	}

	/**
	* Sets the category ID of this vcms article status.
	*
	* @param categoryId the category ID of this vcms article status
	*/
	public void setCategoryId(java.lang.String categoryId) {
		_vcmsArticleStatus.setCategoryId(categoryId);
	}

	/**
	* Returns the created date of this vcms article status.
	*
	* @return the created date of this vcms article status
	*/
	public java.util.Date getCreatedDate() {
		return _vcmsArticleStatus.getCreatedDate();
	}

	/**
	* Sets the created date of this vcms article status.
	*
	* @param createdDate the created date of this vcms article status
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vcmsArticleStatus.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by user of this vcms article status.
	*
	* @return the created by user of this vcms article status
	*/
	public java.lang.String getCreatedByUser() {
		return _vcmsArticleStatus.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vcms article status.
	*
	* @param createdByUser the created by user of this vcms article status
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_vcmsArticleStatus.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the active of this vcms article status.
	*
	* @return the active of this vcms article status
	*/
	public boolean getActive() {
		return _vcmsArticleStatus.getActive();
	}

	/**
	* Returns <code>true</code> if this vcms article status is active.
	*
	* @return <code>true</code> if this vcms article status is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _vcmsArticleStatus.isActive();
	}

	/**
	* Sets whether this vcms article status is active.
	*
	* @param active the active of this vcms article status
	*/
	public void setActive(boolean active) {
		_vcmsArticleStatus.setActive(active);
	}

	/**
	* Returns the article version ID of this vcms article status.
	*
	* @return the article version ID of this vcms article status
	*/
	public long getArticleVersionId() {
		return _vcmsArticleStatus.getArticleVersionId();
	}

	/**
	* Sets the article version ID of this vcms article status.
	*
	* @param articleVersionId the article version ID of this vcms article status
	*/
	public void setArticleVersionId(long articleVersionId) {
		_vcmsArticleStatus.setArticleVersionId(articleVersionId);
	}

	public boolean isNew() {
		return _vcmsArticleStatus.isNew();
	}

	public void setNew(boolean n) {
		_vcmsArticleStatus.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsArticleStatus.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsArticleStatus.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsArticleStatus.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsArticleStatus.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsArticleStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsArticleStatus.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsArticleStatus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsArticleStatusWrapper((VcmsArticleStatus)_vcmsArticleStatus.clone());
	}

	public int compareTo(
		com.vportal.portlet.vcms.model.VcmsArticleStatus vcmsArticleStatus) {
		return _vcmsArticleStatus.compareTo(vcmsArticleStatus);
	}

	@Override
	public int hashCode() {
		return _vcmsArticleStatus.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsArticleStatus> toCacheModel() {
		return _vcmsArticleStatus.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsArticleStatus toEscapedModel() {
		return new VcmsArticleStatusWrapper(_vcmsArticleStatus.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsArticleStatus.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsArticleStatus.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleStatus.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsArticleStatus getWrappedVcmsArticleStatus() {
		return _vcmsArticleStatus;
	}

	public VcmsArticleStatus getWrappedModel() {
		return _vcmsArticleStatus;
	}

	public void resetOriginalValues() {
		_vcmsArticleStatus.resetOriginalValues();
	}

	private VcmsArticleStatus _vcmsArticleStatus;
}