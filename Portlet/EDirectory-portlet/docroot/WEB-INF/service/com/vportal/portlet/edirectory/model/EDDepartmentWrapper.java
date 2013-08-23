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

package com.vportal.portlet.edirectory.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EDDepartment}.
 * </p>
 *
 * @author    HOAN
 * @see       EDDepartment
 * @generated
 */
public class EDDepartmentWrapper implements EDDepartment,
	ModelWrapper<EDDepartment> {
	public EDDepartmentWrapper(EDDepartment edDepartment) {
		_edDepartment = edDepartment;
	}

	public Class<?> getModelClass() {
		return EDDepartment.class;
	}

	public String getModelClassName() {
		return EDDepartment.class.getName();
	}

	/**
	* Returns the primary key of this e d department.
	*
	* @return the primary key of this e d department
	*/
	public long getPrimaryKey() {
		return _edDepartment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e d department.
	*
	* @param primaryKey the primary key of this e d department
	*/
	public void setPrimaryKey(long primaryKey) {
		_edDepartment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this e d department.
	*
	* @return the ID of this e d department
	*/
	public long getId() {
		return _edDepartment.getId();
	}

	/**
	* Sets the ID of this e d department.
	*
	* @param id the ID of this e d department
	*/
	public void setId(long id) {
		_edDepartment.setId(id);
	}

	/**
	* Returns the created date of this e d department.
	*
	* @return the created date of this e d department
	*/
	public java.util.Date getCreatedDate() {
		return _edDepartment.getCreatedDate();
	}

	/**
	* Sets the created date of this e d department.
	*
	* @param createdDate the created date of this e d department
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_edDepartment.setCreatedDate(createdDate);
	}

	/**
	* Returns the name of this e d department.
	*
	* @return the name of this e d department
	*/
	public java.lang.String getName() {
		return _edDepartment.getName();
	}

	/**
	* Sets the name of this e d department.
	*
	* @param name the name of this e d department
	*/
	public void setName(java.lang.String name) {
		_edDepartment.setName(name);
	}

	/**
	* Returns the parent of this e d department.
	*
	* @return the parent of this e d department
	*/
	public long getParent() {
		return _edDepartment.getParent();
	}

	/**
	* Sets the parent of this e d department.
	*
	* @param parent the parent of this e d department
	*/
	public void setParent(long parent) {
		_edDepartment.setParent(parent);
	}

	/**
	* Returns the phone of this e d department.
	*
	* @return the phone of this e d department
	*/
	public java.lang.String getPhone() {
		return _edDepartment.getPhone();
	}

	/**
	* Sets the phone of this e d department.
	*
	* @param phone the phone of this e d department
	*/
	public void setPhone(java.lang.String phone) {
		_edDepartment.setPhone(phone);
	}

	/**
	* Returns the fax of this e d department.
	*
	* @return the fax of this e d department
	*/
	public java.lang.String getFax() {
		return _edDepartment.getFax();
	}

	/**
	* Sets the fax of this e d department.
	*
	* @param fax the fax of this e d department
	*/
	public void setFax(java.lang.String fax) {
		_edDepartment.setFax(fax);
	}

	/**
	* Returns the level ed of this e d department.
	*
	* @return the level ed of this e d department
	*/
	public long getLevelEd() {
		return _edDepartment.getLevelEd();
	}

	/**
	* Sets the level ed of this e d department.
	*
	* @param levelEd the level ed of this e d department
	*/
	public void setLevelEd(long levelEd) {
		_edDepartment.setLevelEd(levelEd);
	}

	/**
	* Returns the email of this e d department.
	*
	* @return the email of this e d department
	*/
	public java.lang.String getEmail() {
		return _edDepartment.getEmail();
	}

	/**
	* Sets the email of this e d department.
	*
	* @param email the email of this e d department
	*/
	public void setEmail(java.lang.String email) {
		_edDepartment.setEmail(email);
	}

	/**
	* Returns the address of this e d department.
	*
	* @return the address of this e d department
	*/
	public java.lang.String getAddress() {
		return _edDepartment.getAddress();
	}

	/**
	* Sets the address of this e d department.
	*
	* @param address the address of this e d department
	*/
	public void setAddress(java.lang.String address) {
		_edDepartment.setAddress(address);
	}

	/**
	* Returns the description of this e d department.
	*
	* @return the description of this e d department
	*/
	public java.lang.String getDescription() {
		return _edDepartment.getDescription();
	}

	/**
	* Sets the description of this e d department.
	*
	* @param description the description of this e d department
	*/
	public void setDescription(java.lang.String description) {
		_edDepartment.setDescription(description);
	}

	/**
	* Returns the website of this e d department.
	*
	* @return the website of this e d department
	*/
	public java.lang.String getWebsite() {
		return _edDepartment.getWebsite();
	}

	/**
	* Sets the website of this e d department.
	*
	* @param website the website of this e d department
	*/
	public void setWebsite(java.lang.String website) {
		_edDepartment.setWebsite(website);
	}

	/**
	* Returns the imgurl of this e d department.
	*
	* @return the imgurl of this e d department
	*/
	public java.lang.String getImgurl() {
		return _edDepartment.getImgurl();
	}

	/**
	* Sets the imgurl of this e d department.
	*
	* @param imgurl the imgurl of this e d department
	*/
	public void setImgurl(java.lang.String imgurl) {
		_edDepartment.setImgurl(imgurl);
	}

	/**
	* Returns the company ID of this e d department.
	*
	* @return the company ID of this e d department
	*/
	public long getCompanyId() {
		return _edDepartment.getCompanyId();
	}

	/**
	* Sets the company ID of this e d department.
	*
	* @param companyId the company ID of this e d department
	*/
	public void setCompanyId(long companyId) {
		_edDepartment.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this e d department.
	*
	* @return the group ID of this e d department
	*/
	public long getGroupId() {
		return _edDepartment.getGroupId();
	}

	/**
	* Sets the group ID of this e d department.
	*
	* @param groupId the group ID of this e d department
	*/
	public void setGroupId(long groupId) {
		_edDepartment.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this e d department.
	*
	* @return the user ID of this e d department
	*/
	public long getUserId() {
		return _edDepartment.getUserId();
	}

	/**
	* Sets the user ID of this e d department.
	*
	* @param userId the user ID of this e d department
	*/
	public void setUserId(long userId) {
		_edDepartment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e d department.
	*
	* @return the user uuid of this e d department
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edDepartment.getUserUuid();
	}

	/**
	* Sets the user uuid of this e d department.
	*
	* @param userUuid the user uuid of this e d department
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_edDepartment.setUserUuid(userUuid);
	}

	/**
	* Returns the language ID of this e d department.
	*
	* @return the language ID of this e d department
	*/
	public java.lang.String getLanguageId() {
		return _edDepartment.getLanguageId();
	}

	/**
	* Sets the language ID of this e d department.
	*
	* @param languageId the language ID of this e d department
	*/
	public void setLanguageId(java.lang.String languageId) {
		_edDepartment.setLanguageId(languageId);
	}

	/**
	* Returns the domain ID of this e d department.
	*
	* @return the domain ID of this e d department
	*/
	public java.lang.String getDomainId() {
		return _edDepartment.getDomainId();
	}

	/**
	* Sets the domain ID of this e d department.
	*
	* @param domainId the domain ID of this e d department
	*/
	public void setDomainId(java.lang.String domainId) {
		_edDepartment.setDomainId(domainId);
	}

	public boolean isNew() {
		return _edDepartment.isNew();
	}

	public void setNew(boolean n) {
		_edDepartment.setNew(n);
	}

	public boolean isCachedModel() {
		return _edDepartment.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_edDepartment.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _edDepartment.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _edDepartment.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_edDepartment.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _edDepartment.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_edDepartment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EDDepartmentWrapper((EDDepartment)_edDepartment.clone());
	}

	public int compareTo(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment) {
		return _edDepartment.compareTo(edDepartment);
	}

	@Override
	public int hashCode() {
		return _edDepartment.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.edirectory.model.EDDepartment> toCacheModel() {
		return _edDepartment.toCacheModel();
	}

	public com.vportal.portlet.edirectory.model.EDDepartment toEscapedModel() {
		return new EDDepartmentWrapper(_edDepartment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _edDepartment.toString();
	}

	public java.lang.String toXmlString() {
		return _edDepartment.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_edDepartment.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public EDDepartment getWrappedEDDepartment() {
		return _edDepartment;
	}

	public EDDepartment getWrappedModel() {
		return _edDepartment;
	}

	public void resetOriginalValues() {
		_edDepartment.resetOriginalValues();
	}

	private EDDepartment _edDepartment;
}