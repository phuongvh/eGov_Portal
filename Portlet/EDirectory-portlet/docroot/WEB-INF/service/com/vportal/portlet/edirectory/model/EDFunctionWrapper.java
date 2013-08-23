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
 * This class is a wrapper for {@link EDFunction}.
 * </p>
 *
 * @author    HOAN
 * @see       EDFunction
 * @generated
 */
public class EDFunctionWrapper implements EDFunction, ModelWrapper<EDFunction> {
	public EDFunctionWrapper(EDFunction edFunction) {
		_edFunction = edFunction;
	}

	public Class<?> getModelClass() {
		return EDFunction.class;
	}

	public String getModelClassName() {
		return EDFunction.class.getName();
	}

	/**
	* Returns the primary key of this e d function.
	*
	* @return the primary key of this e d function
	*/
	public long getPrimaryKey() {
		return _edFunction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e d function.
	*
	* @param primaryKey the primary key of this e d function
	*/
	public void setPrimaryKey(long primaryKey) {
		_edFunction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this e d function.
	*
	* @return the ID of this e d function
	*/
	public long getId() {
		return _edFunction.getId();
	}

	/**
	* Sets the ID of this e d function.
	*
	* @param id the ID of this e d function
	*/
	public void setId(long id) {
		_edFunction.setId(id);
	}

	/**
	* Returns the created date of this e d function.
	*
	* @return the created date of this e d function
	*/
	public java.util.Date getCreatedDate() {
		return _edFunction.getCreatedDate();
	}

	/**
	* Sets the created date of this e d function.
	*
	* @param createdDate the created date of this e d function
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_edFunction.setCreatedDate(createdDate);
	}

	/**
	* Returns the name of this e d function.
	*
	* @return the name of this e d function
	*/
	public java.lang.String getName() {
		return _edFunction.getName();
	}

	/**
	* Sets the name of this e d function.
	*
	* @param name the name of this e d function
	*/
	public void setName(java.lang.String name) {
		_edFunction.setName(name);
	}

	/**
	* Returns the level ed of this e d function.
	*
	* @return the level ed of this e d function
	*/
	public int getLevelEd() {
		return _edFunction.getLevelEd();
	}

	/**
	* Sets the level ed of this e d function.
	*
	* @param levelEd the level ed of this e d function
	*/
	public void setLevelEd(int levelEd) {
		_edFunction.setLevelEd(levelEd);
	}

	/**
	* Returns the is show tree of this e d function.
	*
	* @return the is show tree of this e d function
	*/
	public boolean getIsShowTree() {
		return _edFunction.getIsShowTree();
	}

	/**
	* Returns <code>true</code> if this e d function is is show tree.
	*
	* @return <code>true</code> if this e d function is is show tree; <code>false</code> otherwise
	*/
	public boolean isIsShowTree() {
		return _edFunction.isIsShowTree();
	}

	/**
	* Sets whether this e d function is is show tree.
	*
	* @param isShowTree the is show tree of this e d function
	*/
	public void setIsShowTree(boolean isShowTree) {
		_edFunction.setIsShowTree(isShowTree);
	}

	/**
	* Returns the description of this e d function.
	*
	* @return the description of this e d function
	*/
	public java.lang.String getDescription() {
		return _edFunction.getDescription();
	}

	/**
	* Sets the description of this e d function.
	*
	* @param description the description of this e d function
	*/
	public void setDescription(java.lang.String description) {
		_edFunction.setDescription(description);
	}

	/**
	* Returns the group ID of this e d function.
	*
	* @return the group ID of this e d function
	*/
	public long getGroupId() {
		return _edFunction.getGroupId();
	}

	/**
	* Sets the group ID of this e d function.
	*
	* @param groupId the group ID of this e d function
	*/
	public void setGroupId(long groupId) {
		_edFunction.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this e d function.
	*
	* @return the user ID of this e d function
	*/
	public long getUserId() {
		return _edFunction.getUserId();
	}

	/**
	* Sets the user ID of this e d function.
	*
	* @param userId the user ID of this e d function
	*/
	public void setUserId(long userId) {
		_edFunction.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e d function.
	*
	* @return the user uuid of this e d function
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edFunction.getUserUuid();
	}

	/**
	* Sets the user uuid of this e d function.
	*
	* @param userUuid the user uuid of this e d function
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_edFunction.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this e d function.
	*
	* @return the company ID of this e d function
	*/
	public long getCompanyId() {
		return _edFunction.getCompanyId();
	}

	/**
	* Sets the company ID of this e d function.
	*
	* @param companyId the company ID of this e d function
	*/
	public void setCompanyId(long companyId) {
		_edFunction.setCompanyId(companyId);
	}

	/**
	* Returns the language ID of this e d function.
	*
	* @return the language ID of this e d function
	*/
	public java.lang.String getLanguageId() {
		return _edFunction.getLanguageId();
	}

	/**
	* Sets the language ID of this e d function.
	*
	* @param languageId the language ID of this e d function
	*/
	public void setLanguageId(java.lang.String languageId) {
		_edFunction.setLanguageId(languageId);
	}

	public boolean isNew() {
		return _edFunction.isNew();
	}

	public void setNew(boolean n) {
		_edFunction.setNew(n);
	}

	public boolean isCachedModel() {
		return _edFunction.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_edFunction.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _edFunction.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _edFunction.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_edFunction.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _edFunction.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_edFunction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EDFunctionWrapper((EDFunction)_edFunction.clone());
	}

	public int compareTo(
		com.vportal.portlet.edirectory.model.EDFunction edFunction) {
		return _edFunction.compareTo(edFunction);
	}

	@Override
	public int hashCode() {
		return _edFunction.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.edirectory.model.EDFunction> toCacheModel() {
		return _edFunction.toCacheModel();
	}

	public com.vportal.portlet.edirectory.model.EDFunction toEscapedModel() {
		return new EDFunctionWrapper(_edFunction.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _edFunction.toString();
	}

	public java.lang.String toXmlString() {
		return _edFunction.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_edFunction.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public EDFunction getWrappedEDFunction() {
		return _edFunction;
	}

	public EDFunction getWrappedModel() {
		return _edFunction;
	}

	public void resetOriginalValues() {
		_edFunction.resetOriginalValues();
	}

	private EDFunction _edFunction;
}