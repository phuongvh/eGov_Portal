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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsPortionServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsPortionServiceSoap
 * @generated
 */
public class VcmsPortionSoap implements Serializable {
	public static VcmsPortionSoap toSoapModel(VcmsPortion model) {
		VcmsPortionSoap soapModel = new VcmsPortionSoap();

		soapModel.setPortionId(model.getPortionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCategorizable(model.getCategorizable());
		soapModel.setLanguage(model.getLanguage());

		return soapModel;
	}

	public static VcmsPortionSoap[] toSoapModels(VcmsPortion[] models) {
		VcmsPortionSoap[] soapModels = new VcmsPortionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsPortionSoap[][] toSoapModels(VcmsPortion[][] models) {
		VcmsPortionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsPortionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsPortionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsPortionSoap[] toSoapModels(List<VcmsPortion> models) {
		List<VcmsPortionSoap> soapModels = new ArrayList<VcmsPortionSoap>(models.size());

		for (VcmsPortion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsPortionSoap[soapModels.size()]);
	}

	public VcmsPortionSoap() {
	}

	public String getPrimaryKey() {
		return _portionId;
	}

	public void setPrimaryKey(String pk) {
		setPortionId(pk);
	}

	public String getPortionId() {
		return _portionId;
	}

	public void setPortionId(String portionId) {
		_portionId = portionId;
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

	public boolean getCategorizable() {
		return _categorizable;
	}

	public boolean isCategorizable() {
		return _categorizable;
	}

	public void setCategorizable(boolean categorizable) {
		_categorizable = categorizable;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	private String _portionId;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private String _createdByUser;
	private Date _modifiedDate;
	private String _modifiedByUser;
	private String _code;
	private String _name;
	private String _description;
	private boolean _categorizable;
	private String _language;
}