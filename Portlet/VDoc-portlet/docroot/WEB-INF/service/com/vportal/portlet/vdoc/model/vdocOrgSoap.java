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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vdoc.service.http.vdocOrgServiceSoap}.
 *
 * @author    MrEn
 * @see       com.vportal.portlet.vdoc.service.http.vdocOrgServiceSoap
 * @generated
 */
public class vdocOrgSoap implements Serializable {
	public static vdocOrgSoap toSoapModel(vdocOrg model) {
		vdocOrgSoap soapModel = new vdocOrgSoap();

		soapModel.setOrgId(model.getOrgId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setParentId(model.getParentId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setAddress(model.getAddress());
		soapModel.setPhone(model.getPhone());
		soapModel.setFax(model.getFax());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setStatusOrg(model.getStatusOrg());
		soapModel.setPosition(model.getPosition());
		soapModel.setListparent(model.getListparent());

		return soapModel;
	}

	public static vdocOrgSoap[] toSoapModels(vdocOrg[] models) {
		vdocOrgSoap[] soapModels = new vdocOrgSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static vdocOrgSoap[][] toSoapModels(vdocOrg[][] models) {
		vdocOrgSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new vdocOrgSoap[models.length][models[0].length];
		}
		else {
			soapModels = new vdocOrgSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static vdocOrgSoap[] toSoapModels(List<vdocOrg> models) {
		List<vdocOrgSoap> soapModels = new ArrayList<vdocOrgSoap>(models.size());

		for (vdocOrg model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new vdocOrgSoap[soapModels.size()]);
	}

	public vdocOrgSoap() {
	}

	public String getPrimaryKey() {
		return _orgId;
	}

	public void setPrimaryKey(String pk) {
		setOrgId(pk);
	}

	public String getOrgId() {
		return _orgId;
	}

	public void setOrgId(String orgId) {
		_orgId = orgId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public String getParentId() {
		return _parentId;
	}

	public void setParentId(String parentId) {
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

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public boolean getStatusOrg() {
		return _statusOrg;
	}

	public boolean isStatusOrg() {
		return _statusOrg;
	}

	public void setStatusOrg(boolean statusOrg) {
		_statusOrg = statusOrg;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_position = position;
	}

	public String getListparent() {
		return _listparent;
	}

	public void setListparent(String listparent) {
		_listparent = listparent;
	}

	private String _orgId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _createdByUser;
	private long _modifiedByUser;
	private String _parentId;
	private String _name;
	private String _description;
	private String _address;
	private String _phone;
	private String _fax;
	private String _language;
	private boolean _statusOrg;
	private int _position;
	private String _listparent;
}