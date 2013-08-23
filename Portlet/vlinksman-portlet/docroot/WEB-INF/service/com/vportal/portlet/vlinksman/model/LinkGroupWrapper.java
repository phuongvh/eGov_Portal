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

package com.vportal.portlet.vlinksman.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LinkGroup}.
 * </p>
 *
 * @author    LongLH
 * @see       LinkGroup
 * @generated
 */
public class LinkGroupWrapper implements LinkGroup, ModelWrapper<LinkGroup> {
	public LinkGroupWrapper(LinkGroup linkGroup) {
		_linkGroup = linkGroup;
	}

	public Class<?> getModelClass() {
		return LinkGroup.class;
	}

	public String getModelClassName() {
		return LinkGroup.class.getName();
	}

	/**
	* Returns the primary key of this link group.
	*
	* @return the primary key of this link group
	*/
	public long getPrimaryKey() {
		return _linkGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this link group.
	*
	* @param primaryKey the primary key of this link group
	*/
	public void setPrimaryKey(long primaryKey) {
		_linkGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the linkgroup ID of this link group.
	*
	* @return the linkgroup ID of this link group
	*/
	public long getLinkgroupId() {
		return _linkGroup.getLinkgroupId();
	}

	/**
	* Sets the linkgroup ID of this link group.
	*
	* @param linkgroupId the linkgroup ID of this link group
	*/
	public void setLinkgroupId(long linkgroupId) {
		_linkGroup.setLinkgroupId(linkgroupId);
	}

	/**
	* Returns the group ID of this link group.
	*
	* @return the group ID of this link group
	*/
	public long getGroupId() {
		return _linkGroup.getGroupId();
	}

	/**
	* Sets the group ID of this link group.
	*
	* @param groupId the group ID of this link group
	*/
	public void setGroupId(long groupId) {
		_linkGroup.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this link group.
	*
	* @return the company ID of this link group
	*/
	public long getCompanyId() {
		return _linkGroup.getCompanyId();
	}

	/**
	* Sets the company ID of this link group.
	*
	* @param companyId the company ID of this link group
	*/
	public void setCompanyId(long companyId) {
		_linkGroup.setCompanyId(companyId);
	}

	/**
	* Returns the created date of this link group.
	*
	* @return the created date of this link group
	*/
	public java.util.Date getCreatedDate() {
		return _linkGroup.getCreatedDate();
	}

	/**
	* Sets the created date of this link group.
	*
	* @param createdDate the created date of this link group
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_linkGroup.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this link group.
	*
	* @return the modified date of this link group
	*/
	public java.util.Date getModifiedDate() {
		return _linkGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this link group.
	*
	* @param modifiedDate the modified date of this link group
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_linkGroup.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this link group.
	*
	* @return the name of this link group
	*/
	public java.lang.String getName() {
		return _linkGroup.getName();
	}

	/**
	* Sets the name of this link group.
	*
	* @param name the name of this link group
	*/
	public void setName(java.lang.String name) {
		_linkGroup.setName(name);
	}

	/**
	* Returns the description of this link group.
	*
	* @return the description of this link group
	*/
	public java.lang.String getDescription() {
		return _linkGroup.getDescription();
	}

	/**
	* Sets the description of this link group.
	*
	* @param description the description of this link group
	*/
	public void setDescription(java.lang.String description) {
		_linkGroup.setDescription(description);
	}

	public boolean isNew() {
		return _linkGroup.isNew();
	}

	public void setNew(boolean n) {
		_linkGroup.setNew(n);
	}

	public boolean isCachedModel() {
		return _linkGroup.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_linkGroup.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _linkGroup.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _linkGroup.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_linkGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _linkGroup.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_linkGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LinkGroupWrapper((LinkGroup)_linkGroup.clone());
	}

	public int compareTo(
		com.vportal.portlet.vlinksman.model.LinkGroup linkGroup) {
		return _linkGroup.compareTo(linkGroup);
	}

	@Override
	public int hashCode() {
		return _linkGroup.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vlinksman.model.LinkGroup> toCacheModel() {
		return _linkGroup.toCacheModel();
	}

	public com.vportal.portlet.vlinksman.model.LinkGroup toEscapedModel() {
		return new LinkGroupWrapper(_linkGroup.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _linkGroup.toString();
	}

	public java.lang.String toXmlString() {
		return _linkGroup.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LinkGroup getWrappedLinkGroup() {
		return _linkGroup;
	}

	public LinkGroup getWrappedModel() {
		return _linkGroup;
	}

	public void resetOriginalValues() {
		_linkGroup.resetOriginalValues();
	}

	private LinkGroup _linkGroup;
}