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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vdoc.service.http.vdocFieldServiceSoap}.
 *
 * @author    MrEn
 * @see       com.vportal.portlet.vdoc.service.http.vdocFieldServiceSoap
 * @generated
 */
public class vdocFieldSoap implements Serializable {
	public static vdocFieldSoap toSoapModel(vdocField model) {
		vdocFieldSoap soapModel = new vdocFieldSoap();

		soapModel.setFieldId(model.getFieldId());
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
		soapModel.setLanguage(model.getLanguage());
		soapModel.setStatusField(model.getStatusField());
		soapModel.setPosition(model.getPosition());
		soapModel.setListparent(model.getListparent());

		return soapModel;
	}

	public static vdocFieldSoap[] toSoapModels(vdocField[] models) {
		vdocFieldSoap[] soapModels = new vdocFieldSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static vdocFieldSoap[][] toSoapModels(vdocField[][] models) {
		vdocFieldSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new vdocFieldSoap[models.length][models[0].length];
		}
		else {
			soapModels = new vdocFieldSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static vdocFieldSoap[] toSoapModels(List<vdocField> models) {
		List<vdocFieldSoap> soapModels = new ArrayList<vdocFieldSoap>(models.size());

		for (vdocField model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new vdocFieldSoap[soapModels.size()]);
	}

	public vdocFieldSoap() {
	}

	public String getPrimaryKey() {
		return _fieldId;
	}

	public void setPrimaryKey(String pk) {
		setFieldId(pk);
	}

	public String getFieldId() {
		return _fieldId;
	}

	public void setFieldId(String fieldId) {
		_fieldId = fieldId;
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

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public boolean getStatusField() {
		return _statusField;
	}

	public boolean isStatusField() {
		return _statusField;
	}

	public void setStatusField(boolean statusField) {
		_statusField = statusField;
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

	private String _fieldId;
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
	private String _language;
	private boolean _statusField;
	private int _position;
	private String _listparent;
}