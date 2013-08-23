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

package com.vportal.portlet.vcalendar.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VFile}.
 * </p>
 *
 * @author    LongLH
 * @see       VFile
 * @generated
 */
public class VFileWrapper implements VFile, ModelWrapper<VFile> {
	public VFileWrapper(VFile vFile) {
		_vFile = vFile;
	}

	public Class<?> getModelClass() {
		return VFile.class;
	}

	public String getModelClassName() {
		return VFile.class.getName();
	}

	/**
	* Returns the primary key of this v file.
	*
	* @return the primary key of this v file
	*/
	public long getPrimaryKey() {
		return _vFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v file.
	*
	* @param primaryKey the primary key of this v file
	*/
	public void setPrimaryKey(long primaryKey) {
		_vFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the file ID of this v file.
	*
	* @return the file ID of this v file
	*/
	public long getFileId() {
		return _vFile.getFileId();
	}

	/**
	* Sets the file ID of this v file.
	*
	* @param fileId the file ID of this v file
	*/
	public void setFileId(long fileId) {
		_vFile.setFileId(fileId);
	}

	/**
	* Returns the fullname of this v file.
	*
	* @return the fullname of this v file
	*/
	public java.lang.String getFullname() {
		return _vFile.getFullname();
	}

	/**
	* Sets the fullname of this v file.
	*
	* @param fullname the fullname of this v file
	*/
	public void setFullname(java.lang.String fullname) {
		_vFile.setFullname(fullname);
	}

	/**
	* Returns the phone of this v file.
	*
	* @return the phone of this v file
	*/
	public java.lang.String getPhone() {
		return _vFile.getPhone();
	}

	/**
	* Sets the phone of this v file.
	*
	* @param phone the phone of this v file
	*/
	public void setPhone(java.lang.String phone) {
		_vFile.setPhone(phone);
	}

	/**
	* Returns the address of this v file.
	*
	* @return the address of this v file
	*/
	public java.lang.String getAddress() {
		return _vFile.getAddress();
	}

	/**
	* Sets the address of this v file.
	*
	* @param address the address of this v file
	*/
	public void setAddress(java.lang.String address) {
		_vFile.setAddress(address);
	}

	/**
	* Returns the birthday of this v file.
	*
	* @return the birthday of this v file
	*/
	public java.util.Date getBirthday() {
		return _vFile.getBirthday();
	}

	/**
	* Sets the birthday of this v file.
	*
	* @param birthday the birthday of this v file
	*/
	public void setBirthday(java.util.Date birthday) {
		_vFile.setBirthday(birthday);
	}

	/**
	* Returns the position of this v file.
	*
	* @return the position of this v file
	*/
	public java.lang.String getPosition() {
		return _vFile.getPosition();
	}

	/**
	* Sets the position of this v file.
	*
	* @param position the position of this v file
	*/
	public void setPosition(java.lang.String position) {
		_vFile.setPosition(position);
	}

	/**
	* Returns the status of this v file.
	*
	* @return the status of this v file
	*/
	public long getStatus() {
		return _vFile.getStatus();
	}

	/**
	* Sets the status of this v file.
	*
	* @param status the status of this v file
	*/
	public void setStatus(long status) {
		_vFile.setStatus(status);
	}

	public boolean isNew() {
		return _vFile.isNew();
	}

	public void setNew(boolean n) {
		_vFile.setNew(n);
	}

	public boolean isCachedModel() {
		return _vFile.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vFile.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vFile.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vFile.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vFile.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vFile.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VFileWrapper((VFile)_vFile.clone());
	}

	public int compareTo(com.vportal.portlet.vcalendar.model.VFile vFile) {
		return _vFile.compareTo(vFile);
	}

	@Override
	public int hashCode() {
		return _vFile.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vcalendar.model.VFile> toCacheModel() {
		return _vFile.toCacheModel();
	}

	public com.vportal.portlet.vcalendar.model.VFile toEscapedModel() {
		return new VFileWrapper(_vFile.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vFile.toString();
	}

	public java.lang.String toXmlString() {
		return _vFile.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VFile getWrappedVFile() {
		return _vFile;
	}

	public VFile getWrappedModel() {
		return _vFile;
	}

	public void resetOriginalValues() {
		_vFile.resetOriginalValues();
	}

	private VFile _vFile;
}