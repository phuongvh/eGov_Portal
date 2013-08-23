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

package com.vportal.portlet.vsitemap.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VsmBranch}.
 * </p>
 *
 * @author    LongLH
 * @see       VsmBranch
 * @generated
 */
public class VsmBranchWrapper implements VsmBranch, ModelWrapper<VsmBranch> {
	public VsmBranchWrapper(VsmBranch vsmBranch) {
		_vsmBranch = vsmBranch;
	}

	public Class<?> getModelClass() {
		return VsmBranch.class;
	}

	public String getModelClassName() {
		return VsmBranch.class.getName();
	}

	/**
	* Returns the primary key of this vsm branch.
	*
	* @return the primary key of this vsm branch
	*/
	public long getPrimaryKey() {
		return _vsmBranch.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vsm branch.
	*
	* @param primaryKey the primary key of this vsm branch
	*/
	public void setPrimaryKey(long primaryKey) {
		_vsmBranch.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the branch ID of this vsm branch.
	*
	* @return the branch ID of this vsm branch
	*/
	public long getBranchId() {
		return _vsmBranch.getBranchId();
	}

	/**
	* Sets the branch ID of this vsm branch.
	*
	* @param branchId the branch ID of this vsm branch
	*/
	public void setBranchId(long branchId) {
		_vsmBranch.setBranchId(branchId);
	}

	/**
	* Returns the group ID of this vsm branch.
	*
	* @return the group ID of this vsm branch
	*/
	public long getGroupId() {
		return _vsmBranch.getGroupId();
	}

	/**
	* Sets the group ID of this vsm branch.
	*
	* @param groupId the group ID of this vsm branch
	*/
	public void setGroupId(long groupId) {
		_vsmBranch.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vsm branch.
	*
	* @return the company ID of this vsm branch
	*/
	public long getCompanyId() {
		return _vsmBranch.getCompanyId();
	}

	/**
	* Sets the company ID of this vsm branch.
	*
	* @param companyId the company ID of this vsm branch
	*/
	public void setCompanyId(long companyId) {
		_vsmBranch.setCompanyId(companyId);
	}

	/**
	* Returns the created date of this vsm branch.
	*
	* @return the created date of this vsm branch
	*/
	public java.util.Date getCreatedDate() {
		return _vsmBranch.getCreatedDate();
	}

	/**
	* Sets the created date of this vsm branch.
	*
	* @param createdDate the created date of this vsm branch
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vsmBranch.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by user of this vsm branch.
	*
	* @return the created by user of this vsm branch
	*/
	public long getCreatedByUser() {
		return _vsmBranch.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vsm branch.
	*
	* @param createdByUser the created by user of this vsm branch
	*/
	public void setCreatedByUser(long createdByUser) {
		_vsmBranch.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the modified date of this vsm branch.
	*
	* @return the modified date of this vsm branch
	*/
	public java.util.Date getModifiedDate() {
		return _vsmBranch.getModifiedDate();
	}

	/**
	* Sets the modified date of this vsm branch.
	*
	* @param modifiedDate the modified date of this vsm branch
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vsmBranch.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the modified by user of this vsm branch.
	*
	* @return the modified by user of this vsm branch
	*/
	public long getModifiedByUser() {
		return _vsmBranch.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this vsm branch.
	*
	* @param modifiedByUser the modified by user of this vsm branch
	*/
	public void setModifiedByUser(long modifiedByUser) {
		_vsmBranch.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the parent ID of this vsm branch.
	*
	* @return the parent ID of this vsm branch
	*/
	public long getParentId() {
		return _vsmBranch.getParentId();
	}

	/**
	* Sets the parent ID of this vsm branch.
	*
	* @param parentId the parent ID of this vsm branch
	*/
	public void setParentId(long parentId) {
		_vsmBranch.setParentId(parentId);
	}

	/**
	* Returns the name of this vsm branch.
	*
	* @return the name of this vsm branch
	*/
	public java.lang.String getName() {
		return _vsmBranch.getName();
	}

	/**
	* Sets the name of this vsm branch.
	*
	* @param name the name of this vsm branch
	*/
	public void setName(java.lang.String name) {
		_vsmBranch.setName(name);
	}

	/**
	* Returns the description of this vsm branch.
	*
	* @return the description of this vsm branch
	*/
	public java.lang.String getDescription() {
		return _vsmBranch.getDescription();
	}

	/**
	* Sets the description of this vsm branch.
	*
	* @param description the description of this vsm branch
	*/
	public void setDescription(java.lang.String description) {
		_vsmBranch.setDescription(description);
	}

	/**
	* Returns the anchored of this vsm branch.
	*
	* @return the anchored of this vsm branch
	*/
	public boolean getAnchored() {
		return _vsmBranch.getAnchored();
	}

	/**
	* Returns <code>true</code> if this vsm branch is anchored.
	*
	* @return <code>true</code> if this vsm branch is anchored; <code>false</code> otherwise
	*/
	public boolean isAnchored() {
		return _vsmBranch.isAnchored();
	}

	/**
	* Sets whether this vsm branch is anchored.
	*
	* @param anchored the anchored of this vsm branch
	*/
	public void setAnchored(boolean anchored) {
		_vsmBranch.setAnchored(anchored);
	}

	/**
	* Returns the href of this vsm branch.
	*
	* @return the href of this vsm branch
	*/
	public java.lang.String getHref() {
		return _vsmBranch.getHref();
	}

	/**
	* Sets the href of this vsm branch.
	*
	* @param href the href of this vsm branch
	*/
	public void setHref(java.lang.String href) {
		_vsmBranch.setHref(href);
	}

	/**
	* Returns the language of this vsm branch.
	*
	* @return the language of this vsm branch
	*/
	public java.lang.String getLanguage() {
		return _vsmBranch.getLanguage();
	}

	/**
	* Sets the language of this vsm branch.
	*
	* @param language the language of this vsm branch
	*/
	public void setLanguage(java.lang.String language) {
		_vsmBranch.setLanguage(language);
	}

	/**
	* Returns the has icon of this vsm branch.
	*
	* @return the has icon of this vsm branch
	*/
	public boolean getHasIcon() {
		return _vsmBranch.getHasIcon();
	}

	/**
	* Returns <code>true</code> if this vsm branch is has icon.
	*
	* @return <code>true</code> if this vsm branch is has icon; <code>false</code> otherwise
	*/
	public boolean isHasIcon() {
		return _vsmBranch.isHasIcon();
	}

	/**
	* Sets whether this vsm branch is has icon.
	*
	* @param hasIcon the has icon of this vsm branch
	*/
	public void setHasIcon(boolean hasIcon) {
		_vsmBranch.setHasIcon(hasIcon);
	}

	/**
	* Returns the icon of this vsm branch.
	*
	* @return the icon of this vsm branch
	*/
	public java.lang.String getIcon() {
		return _vsmBranch.getIcon();
	}

	/**
	* Sets the icon of this vsm branch.
	*
	* @param icon the icon of this vsm branch
	*/
	public void setIcon(java.lang.String icon) {
		_vsmBranch.setIcon(icon);
	}

	/**
	* Returns the position of this vsm branch.
	*
	* @return the position of this vsm branch
	*/
	public long getPosition() {
		return _vsmBranch.getPosition();
	}

	/**
	* Sets the position of this vsm branch.
	*
	* @param position the position of this vsm branch
	*/
	public void setPosition(long position) {
		_vsmBranch.setPosition(position);
	}

	public boolean isNew() {
		return _vsmBranch.isNew();
	}

	public void setNew(boolean n) {
		_vsmBranch.setNew(n);
	}

	public boolean isCachedModel() {
		return _vsmBranch.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vsmBranch.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vsmBranch.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vsmBranch.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vsmBranch.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vsmBranch.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vsmBranch.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VsmBranchWrapper((VsmBranch)_vsmBranch.clone());
	}

	public int compareTo(com.vportal.portlet.vsitemap.model.VsmBranch vsmBranch) {
		return _vsmBranch.compareTo(vsmBranch);
	}

	@Override
	public int hashCode() {
		return _vsmBranch.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vsitemap.model.VsmBranch> toCacheModel() {
		return _vsmBranch.toCacheModel();
	}

	public com.vportal.portlet.vsitemap.model.VsmBranch toEscapedModel() {
		return new VsmBranchWrapper(_vsmBranch.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vsmBranch.toString();
	}

	public java.lang.String toXmlString() {
		return _vsmBranch.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vsmBranch.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VsmBranch getWrappedVsmBranch() {
		return _vsmBranch;
	}

	public VsmBranch getWrappedModel() {
		return _vsmBranch;
	}

	public void resetOriginalValues() {
		_vsmBranch.resetOriginalValues();
	}

	private VsmBranch _vsmBranch;
}