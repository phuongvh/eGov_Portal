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
 * This class is a wrapper for {@link VcmsArticleType}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticleType
 * @generated
 */
public class VcmsArticleTypeWrapper implements VcmsArticleType,
	ModelWrapper<VcmsArticleType> {
	public VcmsArticleTypeWrapper(VcmsArticleType vcmsArticleType) {
		_vcmsArticleType = vcmsArticleType;
	}

	public Class<?> getModelClass() {
		return VcmsArticleType.class;
	}

	public String getModelClassName() {
		return VcmsArticleType.class.getName();
	}

	/**
	* Returns the primary key of this vcms article type.
	*
	* @return the primary key of this vcms article type
	*/
	public com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK getPrimaryKey() {
		return _vcmsArticleType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms article type.
	*
	* @param primaryKey the primary key of this vcms article type
	*/
	public void setPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK primaryKey) {
		_vcmsArticleType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the type ID of this vcms article type.
	*
	* @return the type ID of this vcms article type
	*/
	public long getTypeId() {
		return _vcmsArticleType.getTypeId();
	}

	/**
	* Sets the type ID of this vcms article type.
	*
	* @param typeId the type ID of this vcms article type
	*/
	public void setTypeId(long typeId) {
		_vcmsArticleType.setTypeId(typeId);
	}

	/**
	* Returns the article ID of this vcms article type.
	*
	* @return the article ID of this vcms article type
	*/
	public java.lang.String getArticleId() {
		return _vcmsArticleType.getArticleId();
	}

	/**
	* Sets the article ID of this vcms article type.
	*
	* @param articleId the article ID of this vcms article type
	*/
	public void setArticleId(java.lang.String articleId) {
		_vcmsArticleType.setArticleId(articleId);
	}

	/**
	* Returns the position of this vcms article type.
	*
	* @return the position of this vcms article type
	*/
	public long getPosition() {
		return _vcmsArticleType.getPosition();
	}

	/**
	* Sets the position of this vcms article type.
	*
	* @param position the position of this vcms article type
	*/
	public void setPosition(long position) {
		_vcmsArticleType.setPosition(position);
	}

	public boolean isNew() {
		return _vcmsArticleType.isNew();
	}

	public void setNew(boolean n) {
		_vcmsArticleType.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsArticleType.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsArticleType.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsArticleType.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsArticleType.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsArticleType.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsArticleType.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsArticleType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsArticleTypeWrapper((VcmsArticleType)_vcmsArticleType.clone());
	}

	public int compareTo(
		com.vportal.portlet.vcms.model.VcmsArticleType vcmsArticleType) {
		return _vcmsArticleType.compareTo(vcmsArticleType);
	}

	@Override
	public int hashCode() {
		return _vcmsArticleType.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsArticleType> toCacheModel() {
		return _vcmsArticleType.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsArticleType toEscapedModel() {
		return new VcmsArticleTypeWrapper(_vcmsArticleType.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsArticleType.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsArticleType.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleType.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsArticleType getWrappedVcmsArticleType() {
		return _vcmsArticleType;
	}

	public VcmsArticleType getWrappedModel() {
		return _vcmsArticleType;
	}

	public void resetOriginalValues() {
		_vcmsArticleType.resetOriginalValues();
	}

	private VcmsArticleType _vcmsArticleType;
}