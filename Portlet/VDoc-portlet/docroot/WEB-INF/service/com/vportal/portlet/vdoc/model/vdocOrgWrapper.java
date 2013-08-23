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
 * This class is a wrapper for {@link vdocOrg}.
 * </p>
 *
 * @author    MrEn
 * @see       vdocOrg
 * @generated
 */
public class vdocOrgWrapper implements vdocOrg, ModelWrapper<vdocOrg> {
	public vdocOrgWrapper(vdocOrg vdocOrg) {
		_vdocOrg = vdocOrg;
	}

	public Class<?> getModelClass() {
		return vdocOrg.class;
	}

	public String getModelClassName() {
		return vdocOrg.class.getName();
	}

	/**
	* Returns the primary key of this vdoc org.
	*
	* @return the primary key of this vdoc org
	*/
	public java.lang.String getPrimaryKey() {
		return _vdocOrg.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vdoc org.
	*
	* @param primaryKey the primary key of this vdoc org
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vdocOrg.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the org ID of this vdoc org.
	*
	* @return the org ID of this vdoc org
	*/
	public java.lang.String getOrgId() {
		return _vdocOrg.getOrgId();
	}

	/**
	* Sets the org ID of this vdoc org.
	*
	* @param orgId the org ID of this vdoc org
	*/
	public void setOrgId(java.lang.String orgId) {
		_vdocOrg.setOrgId(orgId);
	}

	/**
	* Returns the group ID of this vdoc org.
	*
	* @return the group ID of this vdoc org
	*/
	public long getGroupId() {
		return _vdocOrg.getGroupId();
	}

	/**
	* Sets the group ID of this vdoc org.
	*
	* @param groupId the group ID of this vdoc org
	*/
	public void setGroupId(long groupId) {
		_vdocOrg.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vdoc org.
	*
	* @return the company ID of this vdoc org
	*/
	public long getCompanyId() {
		return _vdocOrg.getCompanyId();
	}

	/**
	* Sets the company ID of this vdoc org.
	*
	* @param companyId the company ID of this vdoc org
	*/
	public void setCompanyId(long companyId) {
		_vdocOrg.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vdoc org.
	*
	* @return the user ID of this vdoc org
	*/
	public long getUserId() {
		return _vdocOrg.getUserId();
	}

	/**
	* Sets the user ID of this vdoc org.
	*
	* @param userId the user ID of this vdoc org
	*/
	public void setUserId(long userId) {
		_vdocOrg.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vdoc org.
	*
	* @return the user uuid of this vdoc org
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocOrg.getUserUuid();
	}

	/**
	* Sets the user uuid of this vdoc org.
	*
	* @param userUuid the user uuid of this vdoc org
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_vdocOrg.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this vdoc org.
	*
	* @return the created date of this vdoc org
	*/
	public java.util.Date getCreatedDate() {
		return _vdocOrg.getCreatedDate();
	}

	/**
	* Sets the created date of this vdoc org.
	*
	* @param createdDate the created date of this vdoc org
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vdocOrg.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this vdoc org.
	*
	* @return the modified date of this vdoc org
	*/
	public java.util.Date getModifiedDate() {
		return _vdocOrg.getModifiedDate();
	}

	/**
	* Sets the modified date of this vdoc org.
	*
	* @param modifiedDate the modified date of this vdoc org
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vdocOrg.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the created by user of this vdoc org.
	*
	* @return the created by user of this vdoc org
	*/
	public long getCreatedByUser() {
		return _vdocOrg.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vdoc org.
	*
	* @param createdByUser the created by user of this vdoc org
	*/
	public void setCreatedByUser(long createdByUser) {
		_vdocOrg.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the modified by user of this vdoc org.
	*
	* @return the modified by user of this vdoc org
	*/
	public long getModifiedByUser() {
		return _vdocOrg.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this vdoc org.
	*
	* @param modifiedByUser the modified by user of this vdoc org
	*/
	public void setModifiedByUser(long modifiedByUser) {
		_vdocOrg.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the parent ID of this vdoc org.
	*
	* @return the parent ID of this vdoc org
	*/
	public java.lang.String getParentId() {
		return _vdocOrg.getParentId();
	}

	/**
	* Sets the parent ID of this vdoc org.
	*
	* @param parentId the parent ID of this vdoc org
	*/
	public void setParentId(java.lang.String parentId) {
		_vdocOrg.setParentId(parentId);
	}

	/**
	* Returns the name of this vdoc org.
	*
	* @return the name of this vdoc org
	*/
	public java.lang.String getName() {
		return _vdocOrg.getName();
	}

	/**
	* Sets the name of this vdoc org.
	*
	* @param name the name of this vdoc org
	*/
	public void setName(java.lang.String name) {
		_vdocOrg.setName(name);
	}

	/**
	* Returns the description of this vdoc org.
	*
	* @return the description of this vdoc org
	*/
	public java.lang.String getDescription() {
		return _vdocOrg.getDescription();
	}

	/**
	* Sets the description of this vdoc org.
	*
	* @param description the description of this vdoc org
	*/
	public void setDescription(java.lang.String description) {
		_vdocOrg.setDescription(description);
	}

	/**
	* Returns the address of this vdoc org.
	*
	* @return the address of this vdoc org
	*/
	public java.lang.String getAddress() {
		return _vdocOrg.getAddress();
	}

	/**
	* Sets the address of this vdoc org.
	*
	* @param address the address of this vdoc org
	*/
	public void setAddress(java.lang.String address) {
		_vdocOrg.setAddress(address);
	}

	/**
	* Returns the phone of this vdoc org.
	*
	* @return the phone of this vdoc org
	*/
	public java.lang.String getPhone() {
		return _vdocOrg.getPhone();
	}

	/**
	* Sets the phone of this vdoc org.
	*
	* @param phone the phone of this vdoc org
	*/
	public void setPhone(java.lang.String phone) {
		_vdocOrg.setPhone(phone);
	}

	/**
	* Returns the fax of this vdoc org.
	*
	* @return the fax of this vdoc org
	*/
	public java.lang.String getFax() {
		return _vdocOrg.getFax();
	}

	/**
	* Sets the fax of this vdoc org.
	*
	* @param fax the fax of this vdoc org
	*/
	public void setFax(java.lang.String fax) {
		_vdocOrg.setFax(fax);
	}

	/**
	* Returns the language of this vdoc org.
	*
	* @return the language of this vdoc org
	*/
	public java.lang.String getLanguage() {
		return _vdocOrg.getLanguage();
	}

	/**
	* Sets the language of this vdoc org.
	*
	* @param language the language of this vdoc org
	*/
	public void setLanguage(java.lang.String language) {
		_vdocOrg.setLanguage(language);
	}

	/**
	* Returns the status org of this vdoc org.
	*
	* @return the status org of this vdoc org
	*/
	public boolean getStatusOrg() {
		return _vdocOrg.getStatusOrg();
	}

	/**
	* Returns <code>true</code> if this vdoc org is status org.
	*
	* @return <code>true</code> if this vdoc org is status org; <code>false</code> otherwise
	*/
	public boolean isStatusOrg() {
		return _vdocOrg.isStatusOrg();
	}

	/**
	* Sets whether this vdoc org is status org.
	*
	* @param statusOrg the status org of this vdoc org
	*/
	public void setStatusOrg(boolean statusOrg) {
		_vdocOrg.setStatusOrg(statusOrg);
	}

	/**
	* Returns the position of this vdoc org.
	*
	* @return the position of this vdoc org
	*/
	public int getPosition() {
		return _vdocOrg.getPosition();
	}

	/**
	* Sets the position of this vdoc org.
	*
	* @param position the position of this vdoc org
	*/
	public void setPosition(int position) {
		_vdocOrg.setPosition(position);
	}

	/**
	* Returns the listparent of this vdoc org.
	*
	* @return the listparent of this vdoc org
	*/
	public java.lang.String getListparent() {
		return _vdocOrg.getListparent();
	}

	/**
	* Sets the listparent of this vdoc org.
	*
	* @param listparent the listparent of this vdoc org
	*/
	public void setListparent(java.lang.String listparent) {
		_vdocOrg.setListparent(listparent);
	}

	public boolean isNew() {
		return _vdocOrg.isNew();
	}

	public void setNew(boolean n) {
		_vdocOrg.setNew(n);
	}

	public boolean isCachedModel() {
		return _vdocOrg.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vdocOrg.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vdocOrg.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vdocOrg.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vdocOrg.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vdocOrg.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vdocOrg.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new vdocOrgWrapper((vdocOrg)_vdocOrg.clone());
	}

	public int compareTo(com.vportal.portlet.vdoc.model.vdocOrg vdocOrg) {
		return _vdocOrg.compareTo(vdocOrg);
	}

	@Override
	public int hashCode() {
		return _vdocOrg.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vdoc.model.vdocOrg> toCacheModel() {
		return _vdocOrg.toCacheModel();
	}

	public com.vportal.portlet.vdoc.model.vdocOrg toEscapedModel() {
		return new vdocOrgWrapper(_vdocOrg.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vdocOrg.toString();
	}

	public java.lang.String toXmlString() {
		return _vdocOrg.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public vdocOrg getWrappedvdocOrg() {
		return _vdocOrg;
	}

	public vdocOrg getWrappedModel() {
		return _vdocOrg;
	}

	public void resetOriginalValues() {
		_vdocOrg.resetOriginalValues();
	}

	private vdocOrg _vdocOrg;
}