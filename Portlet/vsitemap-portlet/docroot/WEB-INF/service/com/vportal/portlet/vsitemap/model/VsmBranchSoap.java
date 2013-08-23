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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vsitemap.service.http.VsmBranchServiceSoap}.
 *
 * @author    LongLH
 * @see       com.vportal.portlet.vsitemap.service.http.VsmBranchServiceSoap
 * @generated
 */
public class VsmBranchSoap implements Serializable {
	public static VsmBranchSoap toSoapModel(VsmBranch model) {
		VsmBranchSoap soapModel = new VsmBranchSoap();

		soapModel.setBranchId(model.getBranchId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setParentId(model.getParentId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setAnchored(model.getAnchored());
		soapModel.setHref(model.getHref());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setHasIcon(model.getHasIcon());
		soapModel.setIcon(model.getIcon());
		soapModel.setPosition(model.getPosition());

		return soapModel;
	}

	public static VsmBranchSoap[] toSoapModels(VsmBranch[] models) {
		VsmBranchSoap[] soapModels = new VsmBranchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VsmBranchSoap[][] toSoapModels(VsmBranch[][] models) {
		VsmBranchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VsmBranchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VsmBranchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VsmBranchSoap[] toSoapModels(List<VsmBranch> models) {
		List<VsmBranchSoap> soapModels = new ArrayList<VsmBranchSoap>(models.size());

		for (VsmBranch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VsmBranchSoap[soapModels.size()]);
	}

	public VsmBranchSoap() {
	}

	public long getPrimaryKey() {
		return _branchId;
	}

	public void setPrimaryKey(long pk) {
		setBranchId(pk);
	}

	public long getBranchId() {
		return _branchId;
	}

	public void setBranchId(long branchId) {
		_branchId = branchId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getAnchored() {
		return _anchored;
	}

	public boolean isAnchored() {
		return _anchored;
	}

	public void setAnchored(boolean anchored) {
		_anchored = anchored;
	}

	public String getHref() {
		return _href;
	}

	public void setHref(String href) {
		_href = href;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public boolean getHasIcon() {
		return _hasIcon;
	}

	public boolean isHasIcon() {
		return _hasIcon;
	}

	public void setHasIcon(boolean hasIcon) {
		_hasIcon = hasIcon;
	}

	public String getIcon() {
		return _icon;
	}

	public void setIcon(String icon) {
		_icon = icon;
	}

	public long getPosition() {
		return _position;
	}

	public void setPosition(long position) {
		_position = position;
	}

	private long _branchId;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private long _createdByUser;
	private Date _modifiedDate;
	private long _modifiedByUser;
	private long _parentId;
	private String _name;
	private String _description;
	private boolean _anchored;
	private String _href;
	private String _language;
	private boolean _hasIcon;
	private String _icon;
	private long _position;
}