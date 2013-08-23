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
 * This class is a wrapper for {@link AdvItem}.
 * </p>
 *
 * @author    DucNN
 * @see       AdvItem
 * @generated
 */
public class AdvItemWrapper implements AdvItem, ModelWrapper<AdvItem> {
	public AdvItemWrapper(AdvItem advItem) {
		_advItem = advItem;
	}

	public Class<?> getModelClass() {
		return AdvItem.class;
	}

	public String getModelClassName() {
		return AdvItem.class.getName();
	}

	/**
	* Returns the primary key of this adv item.
	*
	* @return the primary key of this adv item
	*/
	public long getPrimaryKey() {
		return _advItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this adv item.
	*
	* @param primaryKey the primary key of this adv item
	*/
	public void setPrimaryKey(long primaryKey) {
		_advItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this adv item.
	*
	* @return the item ID of this adv item
	*/
	public long getItemId() {
		return _advItem.getItemId();
	}

	/**
	* Sets the item ID of this adv item.
	*
	* @param itemId the item ID of this adv item
	*/
	public void setItemId(long itemId) {
		_advItem.setItemId(itemId);
	}

	/**
	* Returns the create date of this adv item.
	*
	* @return the create date of this adv item
	*/
	public java.util.Date getCreateDate() {
		return _advItem.getCreateDate();
	}

	/**
	* Sets the create date of this adv item.
	*
	* @param createDate the create date of this adv item
	*/
	public void setCreateDate(java.util.Date createDate) {
		_advItem.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this adv item.
	*
	* @return the modified date of this adv item
	*/
	public java.util.Date getModifiedDate() {
		return _advItem.getModifiedDate();
	}

	/**
	* Sets the modified date of this adv item.
	*
	* @param modifiedDate the modified date of this adv item
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_advItem.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the expried date of this adv item.
	*
	* @return the expried date of this adv item
	*/
	public java.util.Date getExpriedDate() {
		return _advItem.getExpriedDate();
	}

	/**
	* Sets the expried date of this adv item.
	*
	* @param expriedDate the expried date of this adv item
	*/
	public void setExpriedDate(java.util.Date expriedDate) {
		_advItem.setExpriedDate(expriedDate);
	}

	/**
	* Returns the group ID of this adv item.
	*
	* @return the group ID of this adv item
	*/
	public long getGroupId() {
		return _advItem.getGroupId();
	}

	/**
	* Sets the group ID of this adv item.
	*
	* @param groupId the group ID of this adv item
	*/
	public void setGroupId(long groupId) {
		_advItem.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this adv item.
	*
	* @return the company ID of this adv item
	*/
	public long getCompanyId() {
		return _advItem.getCompanyId();
	}

	/**
	* Sets the company ID of this adv item.
	*
	* @param companyId the company ID of this adv item
	*/
	public void setCompanyId(long companyId) {
		_advItem.setCompanyId(companyId);
	}

	/**
	* Returns the name of this adv item.
	*
	* @return the name of this adv item
	*/
	public java.lang.String getName() {
		return _advItem.getName();
	}

	/**
	* Sets the name of this adv item.
	*
	* @param name the name of this adv item
	*/
	public void setName(java.lang.String name) {
		_advItem.setName(name);
	}

	/**
	* Returns the description of this adv item.
	*
	* @return the description of this adv item
	*/
	public java.lang.String getDescription() {
		return _advItem.getDescription();
	}

	/**
	* Sets the description of this adv item.
	*
	* @param description the description of this adv item
	*/
	public void setDescription(java.lang.String description) {
		_advItem.setDescription(description);
	}

	/**
	* Returns the url of this adv item.
	*
	* @return the url of this adv item
	*/
	public java.lang.String getUrl() {
		return _advItem.getUrl();
	}

	/**
	* Sets the url of this adv item.
	*
	* @param url the url of this adv item
	*/
	public void setUrl(java.lang.String url) {
		_advItem.setUrl(url);
	}

	/**
	* Returns the is target blank of this adv item.
	*
	* @return the is target blank of this adv item
	*/
	public boolean getIsTargetBlank() {
		return _advItem.getIsTargetBlank();
	}

	/**
	* Returns <code>true</code> if this adv item is is target blank.
	*
	* @return <code>true</code> if this adv item is is target blank; <code>false</code> otherwise
	*/
	public boolean isIsTargetBlank() {
		return _advItem.isIsTargetBlank();
	}

	/**
	* Sets whether this adv item is is target blank.
	*
	* @param isTargetBlank the is target blank of this adv item
	*/
	public void setIsTargetBlank(boolean isTargetBlank) {
		_advItem.setIsTargetBlank(isTargetBlank);
	}

	/**
	* Returns the txt mouse over of this adv item.
	*
	* @return the txt mouse over of this adv item
	*/
	public java.lang.String getTxtMouseOver() {
		return _advItem.getTxtMouseOver();
	}

	/**
	* Sets the txt mouse over of this adv item.
	*
	* @param txtMouseOver the txt mouse over of this adv item
	*/
	public void setTxtMouseOver(java.lang.String txtMouseOver) {
		_advItem.setTxtMouseOver(txtMouseOver);
	}

	/**
	* Returns the folder ID of this adv item.
	*
	* @return the folder ID of this adv item
	*/
	public long getFolderId() {
		return _advItem.getFolderId();
	}

	/**
	* Sets the folder ID of this adv item.
	*
	* @param folderId the folder ID of this adv item
	*/
	public void setFolderId(long folderId) {
		_advItem.setFolderId(folderId);
	}

	/**
	* Returns the status of this adv item.
	*
	* @return the status of this adv item
	*/
	public boolean getStatus() {
		return _advItem.getStatus();
	}

	/**
	* Returns <code>true</code> if this adv item is status.
	*
	* @return <code>true</code> if this adv item is status; <code>false</code> otherwise
	*/
	public boolean isStatus() {
		return _advItem.isStatus();
	}

	/**
	* Sets whether this adv item is status.
	*
	* @param status the status of this adv item
	*/
	public void setStatus(boolean status) {
		_advItem.setStatus(status);
	}

	/**
	* Returns the type ID of this adv item.
	*
	* @return the type ID of this adv item
	*/
	public long getTypeId() {
		return _advItem.getTypeId();
	}

	/**
	* Sets the type ID of this adv item.
	*
	* @param typeId the type ID of this adv item
	*/
	public void setTypeId(long typeId) {
		_advItem.setTypeId(typeId);
	}

	public boolean isNew() {
		return _advItem.isNew();
	}

	public void setNew(boolean n) {
		_advItem.setNew(n);
	}

	public boolean isCachedModel() {
		return _advItem.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_advItem.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _advItem.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _advItem.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_advItem.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _advItem.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_advItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdvItemWrapper((AdvItem)_advItem.clone());
	}

	public int compareTo(com.vportal.portlet.vadvman.model.AdvItem advItem) {
		return _advItem.compareTo(advItem);
	}

	@Override
	public int hashCode() {
		return _advItem.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vadvman.model.AdvItem> toCacheModel() {
		return _advItem.toCacheModel();
	}

	public com.vportal.portlet.vadvman.model.AdvItem toEscapedModel() {
		return new AdvItemWrapper(_advItem.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _advItem.toString();
	}

	public java.lang.String toXmlString() {
		return _advItem.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AdvItem getWrappedAdvItem() {
		return _advItem;
	}

	public AdvItem getWrappedModel() {
		return _advItem;
	}

	public void resetOriginalValues() {
		_advItem.resetOriginalValues();
	}

	private AdvItem _advItem;
}