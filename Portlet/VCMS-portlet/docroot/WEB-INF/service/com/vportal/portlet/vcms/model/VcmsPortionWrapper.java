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
 * This class is a wrapper for {@link VcmsPortion}.
 * </p>
 *
 * @author    hai
 * @see       VcmsPortion
 * @generated
 */
public class VcmsPortionWrapper implements VcmsPortion,
	ModelWrapper<VcmsPortion> {
	public VcmsPortionWrapper(VcmsPortion vcmsPortion) {
		_vcmsPortion = vcmsPortion;
	}

	public Class<?> getModelClass() {
		return VcmsPortion.class;
	}

	public String getModelClassName() {
		return VcmsPortion.class.getName();
	}

	/**
	* Returns the primary key of this vcms portion.
	*
	* @return the primary key of this vcms portion
	*/
	public java.lang.String getPrimaryKey() {
		return _vcmsPortion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vcms portion.
	*
	* @param primaryKey the primary key of this vcms portion
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vcmsPortion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the portion ID of this vcms portion.
	*
	* @return the portion ID of this vcms portion
	*/
	public java.lang.String getPortionId() {
		return _vcmsPortion.getPortionId();
	}

	/**
	* Sets the portion ID of this vcms portion.
	*
	* @param portionId the portion ID of this vcms portion
	*/
	public void setPortionId(java.lang.String portionId) {
		_vcmsPortion.setPortionId(portionId);
	}

	/**
	* Returns the group ID of this vcms portion.
	*
	* @return the group ID of this vcms portion
	*/
	public long getGroupId() {
		return _vcmsPortion.getGroupId();
	}

	/**
	* Sets the group ID of this vcms portion.
	*
	* @param groupId the group ID of this vcms portion
	*/
	public void setGroupId(long groupId) {
		_vcmsPortion.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vcms portion.
	*
	* @return the company ID of this vcms portion
	*/
	public long getCompanyId() {
		return _vcmsPortion.getCompanyId();
	}

	/**
	* Sets the company ID of this vcms portion.
	*
	* @param companyId the company ID of this vcms portion
	*/
	public void setCompanyId(long companyId) {
		_vcmsPortion.setCompanyId(companyId);
	}

	/**
	* Returns the created date of this vcms portion.
	*
	* @return the created date of this vcms portion
	*/
	public java.util.Date getCreatedDate() {
		return _vcmsPortion.getCreatedDate();
	}

	/**
	* Sets the created date of this vcms portion.
	*
	* @param createdDate the created date of this vcms portion
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vcmsPortion.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by user of this vcms portion.
	*
	* @return the created by user of this vcms portion
	*/
	public java.lang.String getCreatedByUser() {
		return _vcmsPortion.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vcms portion.
	*
	* @param createdByUser the created by user of this vcms portion
	*/
	public void setCreatedByUser(java.lang.String createdByUser) {
		_vcmsPortion.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the modified date of this vcms portion.
	*
	* @return the modified date of this vcms portion
	*/
	public java.util.Date getModifiedDate() {
		return _vcmsPortion.getModifiedDate();
	}

	/**
	* Sets the modified date of this vcms portion.
	*
	* @param modifiedDate the modified date of this vcms portion
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vcmsPortion.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the modified by user of this vcms portion.
	*
	* @return the modified by user of this vcms portion
	*/
	public java.lang.String getModifiedByUser() {
		return _vcmsPortion.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this vcms portion.
	*
	* @param modifiedByUser the modified by user of this vcms portion
	*/
	public void setModifiedByUser(java.lang.String modifiedByUser) {
		_vcmsPortion.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the code of this vcms portion.
	*
	* @return the code of this vcms portion
	*/
	public java.lang.String getCode() {
		return _vcmsPortion.getCode();
	}

	/**
	* Sets the code of this vcms portion.
	*
	* @param code the code of this vcms portion
	*/
	public void setCode(java.lang.String code) {
		_vcmsPortion.setCode(code);
	}

	/**
	* Returns the name of this vcms portion.
	*
	* @return the name of this vcms portion
	*/
	public java.lang.String getName() {
		return _vcmsPortion.getName();
	}

	/**
	* Sets the name of this vcms portion.
	*
	* @param name the name of this vcms portion
	*/
	public void setName(java.lang.String name) {
		_vcmsPortion.setName(name);
	}

	/**
	* Returns the description of this vcms portion.
	*
	* @return the description of this vcms portion
	*/
	public java.lang.String getDescription() {
		return _vcmsPortion.getDescription();
	}

	/**
	* Sets the description of this vcms portion.
	*
	* @param description the description of this vcms portion
	*/
	public void setDescription(java.lang.String description) {
		_vcmsPortion.setDescription(description);
	}

	/**
	* Returns the categorizable of this vcms portion.
	*
	* @return the categorizable of this vcms portion
	*/
	public boolean getCategorizable() {
		return _vcmsPortion.getCategorizable();
	}

	/**
	* Returns <code>true</code> if this vcms portion is categorizable.
	*
	* @return <code>true</code> if this vcms portion is categorizable; <code>false</code> otherwise
	*/
	public boolean isCategorizable() {
		return _vcmsPortion.isCategorizable();
	}

	/**
	* Sets whether this vcms portion is categorizable.
	*
	* @param categorizable the categorizable of this vcms portion
	*/
	public void setCategorizable(boolean categorizable) {
		_vcmsPortion.setCategorizable(categorizable);
	}

	/**
	* Returns the language of this vcms portion.
	*
	* @return the language of this vcms portion
	*/
	public java.lang.String getLanguage() {
		return _vcmsPortion.getLanguage();
	}

	/**
	* Sets the language of this vcms portion.
	*
	* @param language the language of this vcms portion
	*/
	public void setLanguage(java.lang.String language) {
		_vcmsPortion.setLanguage(language);
	}

	public boolean isNew() {
		return _vcmsPortion.isNew();
	}

	public void setNew(boolean n) {
		_vcmsPortion.setNew(n);
	}

	public boolean isCachedModel() {
		return _vcmsPortion.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vcmsPortion.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vcmsPortion.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vcmsPortion.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vcmsPortion.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vcmsPortion.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vcmsPortion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VcmsPortionWrapper((VcmsPortion)_vcmsPortion.clone());
	}

	public int compareTo(com.vportal.portlet.vcms.model.VcmsPortion vcmsPortion) {
		return _vcmsPortion.compareTo(vcmsPortion);
	}

	@Override
	public int hashCode() {
		return _vcmsPortion.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcms.model.VcmsPortion> toCacheModel() {
		return _vcmsPortion.toCacheModel();
	}

	public com.vportal.portlet.vcms.model.VcmsPortion toEscapedModel() {
		return new VcmsPortionWrapper(_vcmsPortion.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vcmsPortion.toString();
	}

	public java.lang.String toXmlString() {
		return _vcmsPortion.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsPortion.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VcmsPortion getWrappedVcmsPortion() {
		return _vcmsPortion;
	}

	public VcmsPortion getWrappedModel() {
		return _vcmsPortion;
	}

	public void resetOriginalValues() {
		_vcmsPortion.resetOriginalValues();
	}

	private VcmsPortion _vcmsPortion;
}