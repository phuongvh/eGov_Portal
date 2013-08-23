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
 * This class is a wrapper for {@link VcmsCARelation}.
 * </p>
 *
 * @author    hai
 * @see       VcmsCARelation
 * @generated
 */
public class VcmsCARelationWrapper implements VcmsCARelation,
	ModelWrapper<VcmsCARelation> {
	public VcmsCARelationWrapper(VcmsCARelation vcmsCARelation) {
		_vcmsCARelation = vcmsCARelation;
	}

	public Class<?> getModelClass() {
		return VcmsCARelation.class;
	}

	public String getModelClassName() {
		return VcmsCARelation.class.getName();
	}

	/**
	* Returns the primary key of this vcms c a relation.
	*
	* @return the primary key of this vcms c a relation
	*/
	public com.vportal.portlet.vcms.service.persistence.VcmsCARelationPK getPrimaryKey() {
		return _vcmsCARelation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms c a relation.
	*
	* @param primaryKey the primary key of this vcms c a relation
	*/
	public void setPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsCARelationPK primaryKey) {
		_vcmsCARelation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this vcms c a relation.
	*
	* @return the category ID of this vcms c a relation
	*/
	public java.lang.String getCategoryId() {
		return _vcmsCARelation.getCategoryId();
	}

	/**
	* Sets the category ID of this vcms c a relation.
	*
	* @param categoryId the category ID of this vcms c a relation
	*/
	public void setCategoryId(java.lang.String categoryId) {
		_vcmsCARelation.setCategoryId(categoryId);
	}

	/**
	* Returns the article ID of this vcms c a relation.
	*
	* @return the article ID of this vcms c a relation
	*/
	public java.lang.String getArticleId() {
		return _vcmsCARelation.getArticleId();
	}

	/**
	* Sets the article ID of this vcms c a relation.
	*
	* @param articleId the article ID of this vcms c a relation
	*/
	public void setArticleId(java.lang.String articleId) {
		_vcmsCARelation.setArticleId(articleId);
	}

	/**
	* Returns the created date of this vcms c a relation.
	*
	* @return the created date of this vcms c a relation
	*/
	public java.util.Date getCreatedDate() {
		return _vcmsCARelation.getCreatedDate();
	}

	/**
	* Sets the created date of this vcms c a relation.
	*
	* @param createdDate the created date of this vcms c a relation
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vcmsCARelation.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by user of this vcms c a relation.
	*
	* @return the created by user of this vcms c a relation
	*/
	public java.lang.String getCreatedByUser() {
		return _vcmsCARelation.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vcms c a relation.
	*
	* @param createdByUser the created by user of this vcms c a relation
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_vcmsCARelation.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the status of this vcms c a relation.
	*
	* @return the status of this vcms c a relation
	*/
	public long getStatus() {
		return _vcmsCARelation.getStatus();
	}

	/**
	* Sets the status of this vcms c a relation.
	*
	* @param status the status of this vcms c a relation
	*/
	public void setStatus(long status) {
		_vcmsCARelation.setStatus(status);
	}

	public boolean isNew() {
		return _vcmsCARelation.isNew();
	}

	public void setNew(boolean n) {
		_vcmsCARelation.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsCARelation.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsCARelation.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsCARelation.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsCARelation.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsCARelation.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsCARelation.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsCARelation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsCARelationWrapper((VcmsCARelation)_vcmsCARelation.clone());
	}

	public int compareTo(
		com.vportal.portlet.vcms.model.VcmsCARelation vcmsCARelation) {
		return _vcmsCARelation.compareTo(vcmsCARelation);
	}

	@Override
	public int hashCode() {
		return _vcmsCARelation.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsCARelation> toCacheModel() {
		return _vcmsCARelation.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsCARelation toEscapedModel() {
		return new VcmsCARelationWrapper(_vcmsCARelation.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsCARelation.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsCARelation.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsCARelation.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsCARelation getWrappedVcmsCARelation() {
		return _vcmsCARelation;
	}

	public VcmsCARelation getWrappedModel() {
		return _vcmsCARelation;
	}

	public void resetOriginalValues() {
		_vcmsCARelation.resetOriginalValues();
	}

	private VcmsCARelation _vcmsCARelation;
}