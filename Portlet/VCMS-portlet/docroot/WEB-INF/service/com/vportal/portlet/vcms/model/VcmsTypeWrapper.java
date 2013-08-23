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
 * This class is a wrapper for {@link VcmsType}.
 * </p>
 *
 * @author    hai
 * @see       VcmsType
 * @generated
 */
public class VcmsTypeWrapper implements VcmsType, ModelWrapper<VcmsType> {
	public VcmsTypeWrapper(VcmsType vcmsType) {
		_vcmsType = vcmsType;
	}

	public Class<?> getModelClass() {
		return VcmsType.class;
	}

	public String getModelClassName() {
		return VcmsType.class.getName();
	}

	/**
	* Returns the primary key of this vcms type.
	*
	* @return the primary key of this vcms type
	*/
	public java.lang.String getPrimaryKey() {
		return _vcmsType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms type.
	*
	* @param primaryKey the primary key of this vcms type
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vcmsType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the type ID of this vcms type.
	*
	* @return the type ID of this vcms type
	*/
	public java.lang.String getTypeId() {
		return _vcmsType.getTypeId();
	}

	/**
	* Sets the type ID of this vcms type.
	*
	* @param typeId the type ID of this vcms type
	*/
	public void setTypeId(java.lang.String typeId) {
		_vcmsType.setTypeId(typeId);
	}

	/**
	* Returns the group ID of this vcms type.
	*
	* @return the group ID of this vcms type
	*/
	public long getGroupId() {
		return _vcmsType.getGroupId();
	}

	/**
	* Sets the group ID of this vcms type.
	*
	* @param groupId the group ID of this vcms type
	*/
	public void setGroupId(long groupId) {
		_vcmsType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vcms type.
	*
	* @return the company ID of this vcms type
	*/
	public long getCompanyId() {
		return _vcmsType.getCompanyId();
	}

	/**
	* Sets the company ID of this vcms type.
	*
	* @param companyId the company ID of this vcms type
	*/
	public void setCompanyId(long companyId) {
		_vcmsType.setCompanyId(companyId);
	}

	/**
	* Returns the created date of this vcms type.
	*
	* @return the created date of this vcms type
	*/
	public java.util.Date getCreatedDate() {
		return _vcmsType.getCreatedDate();
	}

	/**
	* Sets the created date of this vcms type.
	*
	* @param createdDate the created date of this vcms type
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vcmsType.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by user of this vcms type.
	*
	* @return the created by user of this vcms type
	*/
	public java.lang.String getCreatedByUser() {
		return _vcmsType.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vcms type.
	*
	* @param createdByUser the created by user of this vcms type
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_vcmsType.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the modified date of this vcms type.
	*
	* @return the modified date of this vcms type
	*/
	public java.util.Date getModifiedDate() {
		return _vcmsType.getModifiedDate();
	}

	/**
	* Sets the modified date of this vcms type.
	*
	* @param modifiedDate the modified date of this vcms type
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vcmsType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the modified by user of this vcms type.
	*
	* @return the modified by user of this vcms type
	*/
	public java.lang.String getModifiedByUser() {
		return _vcmsType.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this vcms type.
	*
	* @param modifiedByUser the modified by user of this vcms type
	*/
	public void setModifiedByUser(java.lang.String modifiedByUser) {
		_vcmsType.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the code of this vcms type.
	*
	* @return the code of this vcms type
	*/
	public java.lang.String getCode() {
		return _vcmsType.getCode();
	}

	/**
	* Sets the code of this vcms type.
	*
	* @param code the code of this vcms type
	*/
	public void setCode(java.lang.String code) {
		_vcmsType.setCode(code);
	}

	/**
	* Returns the name of this vcms type.
	*
	* @return the name of this vcms type
	*/
	public java.lang.String getName() {
		return _vcmsType.getName();
	}

	/**
	* Sets the name of this vcms type.
	*
	* @param name the name of this vcms type
	*/
	public void setName(java.lang.String name) {
		_vcmsType.setName(name);
	}

	/**
	* Returns the description of this vcms type.
	*
	* @return the description of this vcms type
	*/
	public java.lang.String getDescription() {
		return _vcmsType.getDescription();
	}

	/**
	* Sets the description of this vcms type.
	*
	* @param description the description of this vcms type
	*/
	public void setDescription(java.lang.String description) {
		_vcmsType.setDescription(description);
	}

	/**
	* Returns the language of this vcms type.
	*
	* @return the language of this vcms type
	*/
	public java.lang.String getLanguage() {
		return _vcmsType.getLanguage();
	}

	/**
	* Sets the language of this vcms type.
	*
	* @param language the language of this vcms type
	*/
	public void setLanguage(java.lang.String language) {
		_vcmsType.setLanguage(language);
	}

	public boolean isNew() {
		return _vcmsType.isNew();
	}

	public void setNew(boolean n) {
		_vcmsType.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsType.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsType.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsType.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsType.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsType.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsType.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsTypeWrapper((VcmsType)_vcmsType.clone());
	}

	public int compareTo(com.vportal.portlet.vcms.model.VcmsType vcmsType) {
		return _vcmsType.compareTo(vcmsType);
	}

	@Override
	public int hashCode() {
		return _vcmsType.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsType> toCacheModel() {
		return _vcmsType.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsType toEscapedModel() {
		return new VcmsTypeWrapper(_vcmsType.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsType.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsType.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsType.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsType getWrappedVcmsType() {
		return _vcmsType;
	}

	public VcmsType getWrappedModel() {
		return _vcmsType;
	}

	public void resetOriginalValues() {
		_vcmsType.resetOriginalValues();
	}

	private VcmsType _vcmsType;
}