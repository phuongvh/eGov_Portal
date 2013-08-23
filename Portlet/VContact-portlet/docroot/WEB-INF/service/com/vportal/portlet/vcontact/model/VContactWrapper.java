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

package com.vportal.portlet.vcontact.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VContact}.
 * </p>
 *
 * @author    LongLH
 * @see       VContact
 * @generated
 */
public class VContactWrapper implements VContact, ModelWrapper<VContact> {
	public VContactWrapper(VContact vContact) {
		_vContact = vContact;
	}

	public Class<?> getModelClass() {
		return VContact.class;
	}

	public String getModelClassName() {
		return VContact.class.getName();
	}

	/**
	* Returns the primary key of this v contact.
	*
	* @return the primary key of this v contact
	*/
	public long getPrimaryKey() {
		return _vContact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v contact.
	*
	* @param primaryKey the primary key of this v contact
	*/
	public void setPrimaryKey(long primaryKey) {
		_vContact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this v contact.
	*
	* @return the ID of this v contact
	*/
	public long getId() {
		return _vContact.getId();
	}

	/**
	* Sets the ID of this v contact.
	*
	* @param id the ID of this v contact
	*/
	public void setId(long id) {
		_vContact.setId(id);
	}

	/**
	* Returns the group ID of this v contact.
	*
	* @return the group ID of this v contact
	*/
	public long getGroupId() {
		return _vContact.getGroupId();
	}

	/**
	* Sets the group ID of this v contact.
	*
	* @param groupId the group ID of this v contact
	*/
	public void setGroupId(long groupId) {
		_vContact.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this v contact.
	*
	* @return the company ID of this v contact
	*/
	public long getCompanyId() {
		return _vContact.getCompanyId();
	}

	/**
	* Sets the company ID of this v contact.
	*
	* @param companyId the company ID of this v contact
	*/
	public void setCompanyId(long companyId) {
		_vContact.setCompanyId(companyId);
	}

	/**
	* Returns the created date of this v contact.
	*
	* @return the created date of this v contact
	*/
	public java.util.Date getCreatedDate() {
		return _vContact.getCreatedDate();
	}

	/**
	* Sets the created date of this v contact.
	*
	* @param createdDate the created date of this v contact
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vContact.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this v contact.
	*
	* @return the modified date of this v contact
	*/
	public java.util.Date getModifiedDate() {
		return _vContact.getModifiedDate();
	}

	/**
	* Sets the modified date of this v contact.
	*
	* @param modifiedDate the modified date of this v contact
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vContact.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the guest name of this v contact.
	*
	* @return the guest name of this v contact
	*/
	public java.lang.String getGuestName() {
		return _vContact.getGuestName();
	}

	/**
	* Sets the guest name of this v contact.
	*
	* @param guestName the guest name of this v contact
	*/
	public void setGuestName(java.lang.String guestName) {
		_vContact.setGuestName(guestName);
	}

	/**
	* Returns the email of this v contact.
	*
	* @return the email of this v contact
	*/
	public java.lang.String getEmail() {
		return _vContact.getEmail();
	}

	/**
	* Sets the email of this v contact.
	*
	* @param email the email of this v contact
	*/
	public void setEmail(java.lang.String email) {
		_vContact.setEmail(email);
	}

	/**
	* Returns the title of this v contact.
	*
	* @return the title of this v contact
	*/
	public java.lang.String getTitle() {
		return _vContact.getTitle();
	}

	/**
	* Sets the title of this v contact.
	*
	* @param title the title of this v contact
	*/
	public void setTitle(java.lang.String title) {
		_vContact.setTitle(title);
	}

	/**
	* Returns the address of this v contact.
	*
	* @return the address of this v contact
	*/
	public java.lang.String getAddress() {
		return _vContact.getAddress();
	}

	/**
	* Sets the address of this v contact.
	*
	* @param address the address of this v contact
	*/
	public void setAddress(java.lang.String address) {
		_vContact.setAddress(address);
	}

	/**
	* Returns the phone of this v contact.
	*
	* @return the phone of this v contact
	*/
	public java.lang.String getPhone() {
		return _vContact.getPhone();
	}

	/**
	* Sets the phone of this v contact.
	*
	* @param phone the phone of this v contact
	*/
	public void setPhone(java.lang.String phone) {
		_vContact.setPhone(phone);
	}

	/**
	* Returns the fax of this v contact.
	*
	* @return the fax of this v contact
	*/
	public java.lang.String getFax() {
		return _vContact.getFax();
	}

	/**
	* Sets the fax of this v contact.
	*
	* @param fax the fax of this v contact
	*/
	public void setFax(java.lang.String fax) {
		_vContact.setFax(fax);
	}

	/**
	* Returns the content of this v contact.
	*
	* @return the content of this v contact
	*/
	public java.lang.String getContent() {
		return _vContact.getContent();
	}

	/**
	* Sets the content of this v contact.
	*
	* @param content the content of this v contact
	*/
	public void setContent(java.lang.String content) {
		_vContact.setContent(content);
	}

	/**
	* Returns the has attach of this v contact.
	*
	* @return the has attach of this v contact
	*/
	public boolean getHasAttach() {
		return _vContact.getHasAttach();
	}

	/**
	* Returns <code>true</code> if this v contact is has attach.
	*
	* @return <code>true</code> if this v contact is has attach; <code>false</code> otherwise
	*/
	public boolean isHasAttach() {
		return _vContact.isHasAttach();
	}

	/**
	* Sets whether this v contact is has attach.
	*
	* @param hasAttach the has attach of this v contact
	*/
	public void setHasAttach(boolean hasAttach) {
		_vContact.setHasAttach(hasAttach);
	}

	/**
	* Returns the status of this v contact.
	*
	* @return the status of this v contact
	*/
	public int getStatus() {
		return _vContact.getStatus();
	}

	/**
	* Sets the status of this v contact.
	*
	* @param status the status of this v contact
	*/
	public void setStatus(int status) {
		_vContact.setStatus(status);
	}

	public boolean isNew() {
		return _vContact.isNew();
	}

	public void setNew(boolean n) {
		_vContact.setNew(n);
	}

	public boolean isCachedModel() {
		return _vContact.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vContact.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vContact.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vContact.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vContact.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vContact.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vContact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VContactWrapper((VContact)_vContact.clone());
	}

	public int compareTo(com.vportal.portlet.vcontact.model.VContact vContact) {
		return _vContact.compareTo(vContact);
	}

	@Override
	public int hashCode() {
		return _vContact.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcontact.model.VContact> toCacheModel() {
		return _vContact.toCacheModel();
	}

	public com.vportal.portlet.vcontact.model.VContact toEscapedModel() {
		return new VContactWrapper(_vContact.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vContact.toString();
	}

	public java.lang.String toXmlString() {
		return _vContact.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VContact getWrappedVContact() {
		return _vContact;
	}

	public VContact getWrappedModel() {
		return _vContact;
	}

	public void resetOriginalValues() {
		_vContact.resetOriginalValues();
	}

	private VContact _vContact;
}