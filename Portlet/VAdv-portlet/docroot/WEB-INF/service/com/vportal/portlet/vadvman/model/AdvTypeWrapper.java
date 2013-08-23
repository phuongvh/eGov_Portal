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

package com.vportal.portlet.vadvman.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AdvType}.
 * </p>
 *
 * @author    DucNN
 * @see       AdvType
 * @generated
 */
public class AdvTypeWrapper implements AdvType, ModelWrapper<AdvType> {
	public AdvTypeWrapper(AdvType advType) {
		_advType = advType;
	}

	public Class<?> getModelClass() {
		return AdvType.class;
	}

	public String getModelClassName() {
		return AdvType.class.getName();
	}

	/**
	* Returns the primary key of this adv type.
	*
	* @return the primary key of this adv type
	*/
	public long getPrimaryKey() {
		return _advType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this adv type.
	*
	* @param primaryKey the primary key of this adv type
	*/
	public void setPrimaryKey(long primaryKey) {
		_advType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the type ID of this adv type.
	*
	* @return the type ID of this adv type
	*/
	public long getTypeId() {
		return _advType.getTypeId();
	}

	/**
	* Sets the type ID of this adv type.
	*
	* @param typeId the type ID of this adv type
	*/
	public void setTypeId(long typeId) {
		_advType.setTypeId(typeId);
	}

	/**
	* Returns the create date of this adv type.
	*
	* @return the create date of this adv type
	*/
	public java.util.Date getCreateDate() {
		return _advType.getCreateDate();
	}

	/**
	* Sets the create date of this adv type.
	*
	* @param createDate the create date of this adv type
	*/
	public void setCreateDate(java.util.Date createDate) {
		_advType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this adv type.
	*
	* @return the modified date of this adv type
	*/
	public java.util.Date getModifiedDate() {
		return _advType.getModifiedDate();
	}

	/**
	* Sets the modified date of this adv type.
	*
	* @param modifiedDate the modified date of this adv type
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_advType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the group ID of this adv type.
	*
	* @return the group ID of this adv type
	*/
	public long getGroupId() {
		return _advType.getGroupId();
	}

	/**
	* Sets the group ID of this adv type.
	*
	* @param groupId the group ID of this adv type
	*/
	public void setGroupId(long groupId) {
		_advType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this adv type.
	*
	* @return the company ID of this adv type
	*/
	public long getCompanyId() {
		return _advType.getCompanyId();
	}

	/**
	* Sets the company ID of this adv type.
	*
	* @param companyId the company ID of this adv type
	*/
	public void setCompanyId(long companyId) {
		_advType.setCompanyId(companyId);
	}

	/**
	* Returns the name of this adv type.
	*
	* @return the name of this adv type
	*/
	public java.lang.String getName() {
		return _advType.getName();
	}

	/**
	* Sets the name of this adv type.
	*
	* @param name the name of this adv type
	*/
	public void setName(java.lang.String name) {
		_advType.setName(name);
	}

	/**
	* Returns the description of this adv type.
	*
	* @return the description of this adv type
	*/
	public java.lang.String getDescription() {
		return _advType.getDescription();
	}

	/**
	* Sets the description of this adv type.
	*
	* @param description the description of this adv type
	*/
	public void setDescription(java.lang.String description) {
		_advType.setDescription(description);
	}

	public boolean isNew() {
		return _advType.isNew();
	}

	public void setNew(boolean n) {
		_advType.setNew(n);
	}

	public boolean isCachedModel() {
		return _advType.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_advType.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _advType.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _advType.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_advType.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _advType.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_advType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdvTypeWrapper((AdvType)_advType.clone());
	}

	public int compareTo(com.vportal.portlet.vadvman.model.AdvType advType) {
		return _advType.compareTo(advType);
	}

	@Override
	public int hashCode() {
		return _advType.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vadvman.model.AdvType> toCacheModel() {
		return _advType.toCacheModel();
	}

	public com.vportal.portlet.vadvman.model.AdvType toEscapedModel() {
		return new AdvTypeWrapper(_advType.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _advType.toString();
	}

	public java.lang.String toXmlString() {
		return _advType.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AdvType getWrappedAdvType() {
		return _advType;
	}

	public AdvType getWrappedModel() {
		return _advType;
	}

	public void resetOriginalValues() {
		_advType.resetOriginalValues();
	}

	private AdvType _advType;
}