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
 * This class is a wrapper for {@link VcmsTARelation}.
 * </p>
 *
 * @author    hai
 * @see       VcmsTARelation
 * @generated
 */
public class VcmsTARelationWrapper implements VcmsTARelation,
	ModelWrapper<VcmsTARelation> {
	public VcmsTARelationWrapper(VcmsTARelation vcmsTARelation) {
		_vcmsTARelation = vcmsTARelation;
	}

	public Class<?> getModelClass() {
		return VcmsTARelation.class;
	}

	public String getModelClassName() {
		return VcmsTARelation.class.getName();
	}

	/**
	* Returns the primary key of this vcms t a relation.
	*
	* @return the primary key of this vcms t a relation
	*/
	public com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK getPrimaryKey() {
		return _vcmsTARelation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms t a relation.
	*
	* @param primaryKey the primary key of this vcms t a relation
	*/
	public void setPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK primaryKey) {
		_vcmsTARelation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the thread ID of this vcms t a relation.
	*
	* @return the thread ID of this vcms t a relation
	*/
	public java.lang.String getThreadId() {
		return _vcmsTARelation.getThreadId();
	}

	/**
	* Sets the thread ID of this vcms t a relation.
	*
	* @param threadId the thread ID of this vcms t a relation
	*/
	public void setThreadId(java.lang.String threadId) {
		_vcmsTARelation.setThreadId(threadId);
	}

	/**
	* Returns the article ID of this vcms t a relation.
	*
	* @return the article ID of this vcms t a relation
	*/
	public java.lang.String getArticleId() {
		return _vcmsTARelation.getArticleId();
	}

	/**
	* Sets the article ID of this vcms t a relation.
	*
	* @param articleId the article ID of this vcms t a relation
	*/
	public void setArticleId(java.lang.String articleId) {
		_vcmsTARelation.setArticleId(articleId);
	}

	public boolean isNew() {
		return _vcmsTARelation.isNew();
	}

	public void setNew(boolean n) {
		_vcmsTARelation.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsTARelation.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsTARelation.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsTARelation.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsTARelation.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsTARelation.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsTARelation.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsTARelation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsTARelationWrapper((VcmsTARelation)_vcmsTARelation.clone());
	}

	public int compareTo(
		com.vportal.portlet.vcms.model.VcmsTARelation vcmsTARelation) {
		return _vcmsTARelation.compareTo(vcmsTARelation);
	}

	@Override
	public int hashCode() {
		return _vcmsTARelation.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsTARelation> toCacheModel() {
		return _vcmsTARelation.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsTARelation toEscapedModel() {
		return new VcmsTARelationWrapper(_vcmsTARelation.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsTARelation.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsTARelation.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsTARelation.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsTARelation getWrappedVcmsTARelation() {
		return _vcmsTARelation;
	}

	public VcmsTARelation getWrappedModel() {
		return _vcmsTARelation;
	}

	public void resetOriginalValues() {
		_vcmsTARelation.resetOriginalValues();
	}

	private VcmsTARelation _vcmsTARelation;
}