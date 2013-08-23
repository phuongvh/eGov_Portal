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

package com.vportal.portlet.vcms.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsTypeServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsTypeServiceSoap
 * @generated
 */
public class VcmsTypeSoap implements Serializable {
	public static VcmsTypeSoap toSoapModel(VcmsType model) {
		VcmsTypeSoap soapModel = new VcmsTypeSoap();

		soapModel.setTypeId(model.getTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setLanguage(model.getLanguage());

		return soapModel;
	}

	public static VcmsTypeSoap[] toSoapModels(VcmsType[] models) {
		VcmsTypeSoap[] soapModels = new VcmsTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsTypeSoap[][] toSoapModels(VcmsType[][] models) {
		VcmsTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsTypeSoap[] toSoapModels(List<VcmsType> models) {
		List<VcmsTypeSoap> soapModels = new ArrayList<VcmsTypeSoap>(models.size());

		for (VcmsType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsTypeSoap[soapModels.size()]);
	}

	public VcmsTypeSoap() {
	}

	public String getPrimaryKey() {
		return _typeId;
	}

	public void setPrimaryKey(String pk) {
		setTypeId(pk);
	}

	public String getTypeId() {
		return _typeId;
	}

	public void setTypeId(String typeId) {
		_typeId = typeId;
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

	public String getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(String modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
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

	private String _typeId;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private String _createdByUser;
	private Date _modifiedDate;
	private String _modifiedByUser;
	private String _code;
	private String _name;
	private String _description;
	private String _language;
}