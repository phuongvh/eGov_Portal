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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vadvman.service.http.AdvTypeServiceSoap}.
 *
 * @author    DucNN
 * @see       com.vportal.portlet.vadvman.service.http.AdvTypeServiceSoap
 * @generated
 */
public class AdvTypeSoap implements Serializable {
	public static AdvTypeSoap toSoapModel(AdvType model) {
		AdvTypeSoap soapModel = new AdvTypeSoap();

		soapModel.setTypeId(model.getTypeId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static AdvTypeSoap[] toSoapModels(AdvType[] models) {
		AdvTypeSoap[] soapModels = new AdvTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdvTypeSoap[][] toSoapModels(AdvType[][] models) {
		AdvTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdvTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdvTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdvTypeSoap[] toSoapModels(List<AdvType> models) {
		List<AdvTypeSoap> soapModels = new ArrayList<AdvTypeSoap>(models.size());

		for (AdvType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdvTypeSoap[soapModels.size()]);
	}

	public AdvTypeSoap() {
	}

	public long getPrimaryKey() {
		return _typeId;
	}

	public void setPrimaryKey(long pk) {
		setTypeId(pk);
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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

	private long _typeId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _groupId;
	private long _companyId;
	private String _name;
	private String _description;
}