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
 * This class is a wrapper for {@link VcmsPARelation}.
 * </p>
 *
 * @author    hai
 * @see       VcmsPARelation
 * @generated
 */
public class VcmsPARelationWrapper implements VcmsPARelation,
	ModelWrapper<VcmsPARelation> {
	public VcmsPARelationWrapper(VcmsPARelation vcmsPARelation) {
		_vcmsPARelation = vcmsPARelation;
	}

	public Class<?> getModelClass() {
		return VcmsPARelation.class;
	}

	public String getModelClassName() {
		return VcmsPARelation.class.getName();
	}

	/**
	* Returns the primary key of this vcms p a relation.
	*
	* @return the primary key of this vcms p a relation
	*/
	public com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK getPrimaryKey() {
		return _vcmsPARelation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms p a relation.
	*
	* @param primaryKey the primary key of this vcms p a relation
	*/
	public void setPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK primaryKey) {
		_vcmsPARelation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the portion ID of this vcms p a relation.
	*
	* @return the portion ID of this vcms p a relation
	*/
	public java.lang.String getPortionId() {
		return _vcmsPARelation.getPortionId();
	}

	/**
	* Sets the portion ID of this vcms p a relation.
	*
	* @param portionId the portion ID of this vcms p a relation
	*/
	public void setPortionId(java.lang.String portionId) {
		_vcmsPARelation.setPortionId(portionId);
	}

	/**
	* Returns the article ID of this vcms p a relation.
	*
	* @return the article ID of this vcms p a relation
	*/
	public java.lang.String getArticleId() {
		return _vcmsPARelation.getArticleId();
	}

	/**
	* Sets the article ID of this vcms p a relation.
	*
	* @param articleId the article ID of this vcms p a relation
	*/
	public void setArticleId(java.lang.String articleId) {
		_vcmsPARelation.setArticleId(articleId);
	}

	public boolean isNew() {
		return _vcmsPARelation.isNew();
	}

	public void setNew(boolean n) {
		_vcmsPARelation.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsPARelation.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsPARelation.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsPARelation.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsPARelation.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsPARelation.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsPARelation.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsPARelation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsPARelationWrapper((VcmsPARelation)_vcmsPARelation.clone());
	}

	public int compareTo(
		com.vportal.portlet.vcms.model.VcmsPARelation vcmsPARelation) {
		return _vcmsPARelation.compareTo(vcmsPARelation);
	}

	@Override
	public int hashCode() {
		return _vcmsPARelation.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsPARelation> toCacheModel() {
		return _vcmsPARelation.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsPARelation toEscapedModel() {
		return new VcmsPARelationWrapper(_vcmsPARelation.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsPARelation.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsPARelation.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsPARelation.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsPARelation getWrappedVcmsPARelation() {
		return _vcmsPARelation;
	}

	public VcmsPARelation getWrappedModel() {
		return _vcmsPARelation;
	}

	public void resetOriginalValues() {
		_vcmsPARelation.resetOriginalValues();
	}

	private VcmsPARelation _vcmsPARelation;
}