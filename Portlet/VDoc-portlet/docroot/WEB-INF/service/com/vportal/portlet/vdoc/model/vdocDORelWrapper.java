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
 * This class is a wrapper for {@link vdocDORel}.
 * </p>
 *
 * @author    MrEn
 * @see       vdocDORel
 * @generated
 */
public class vdocDORelWrapper implements vdocDORel, ModelWrapper<vdocDORel> {
	public vdocDORelWrapper(vdocDORel vdocDORel) {
		_vdocDORel = vdocDORel;
	}

	public Class<?> getModelClass() {
		return vdocDORel.class;
	}

	public String getModelClassName() {
		return vdocDORel.class.getName();
	}

	/**
	* Returns the primary key of this vdoc d o rel.
	*
	* @return the primary key of this vdoc d o rel
	*/
	public com.vportal.portlet.vdoc.service.persistence.vdocDORelPK getPrimaryKey() {
		return _vdocDORel.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vdoc d o rel.
	*
	* @param primaryKey the primary key of this vdoc d o rel
	*/
	public void setPrimaryKey(
		com.vportal.portlet.vdoc.service.persistence.vdocDORelPK primaryKey) {
		_vdocDORel.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the doc ID of this vdoc d o rel.
	*
	* @return the doc ID of this vdoc d o rel
	*/
	public java.lang.String getDocId() {
		return _vdocDORel.getDocId();
	}

	/**
	* Sets the doc ID of this vdoc d o rel.
	*
	* @param docId the doc ID of this vdoc d o rel
	*/
	public void setDocId(java.lang.String docId) {
		_vdocDORel.setDocId(docId);
	}

	/**
	* Returns the org ID of this vdoc d o rel.
	*
	* @return the org ID of this vdoc d o rel
	*/
	public java.lang.String getOrgId() {
		return _vdocDORel.getOrgId();
	}

	/**
	* Sets the org ID of this vdoc d o rel.
	*
	* @param orgId the org ID of this vdoc d o rel
	*/
	public void setOrgId(java.lang.String orgId) {
		_vdocDORel.setOrgId(orgId);
	}

	public boolean isNew() {
		return _vdocDORel.isNew();
	}

	public void setNew(boolean n) {
		_vdocDORel.setNew(n);
	}

	public boolean isCachedModel() {
		return _vdocDORel.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vdocDORel.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vdocDORel.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vdocDORel.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vdocDORel.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vdocDORel.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vdocDORel.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new vdocDORelWrapper((vdocDORel)_vdocDORel.clone());
	}

	public int compareTo(com.vportal.portlet.vdoc.model.vdocDORel vdocDORel) {
		return _vdocDORel.compareTo(vdocDORel);
	}

	@Override
	public int hashCode() {
		return _vdocDORel.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vdoc.model.vdocDORel> toCacheModel() {
		return _vdocDORel.toCacheModel();
	}

	public com.vportal.portlet.vdoc.model.vdocDORel toEscapedModel() {
		return new vdocDORelWrapper(_vdocDORel.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vdocDORel.toString();
	}

	public java.lang.String toXmlString() {
		return _vdocDORel.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public vdocDORel getWrappedvdocDORel() {
		return _vdocDORel;
	}

	public vdocDORel getWrappedModel() {
		return _vdocDORel;
	}

	public void resetOriginalValues() {
		_vdocDORel.resetOriginalValues();
	}

	private vdocDORel _vdocDORel;
}