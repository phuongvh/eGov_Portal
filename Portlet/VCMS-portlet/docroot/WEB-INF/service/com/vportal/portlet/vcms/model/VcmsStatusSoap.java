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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsStatusServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsStatusServiceSoap
 * @generated
 */
public class VcmsStatusSoap implements Serializable {
	public static VcmsStatusSoap toSoapModel(VcmsStatus model) {
		VcmsStatusSoap soapModel = new VcmsStatusSoap();

		soapModel.setStatusId(model.getStatusId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCssClass(model.getCssClass());
		soapModel.setTextColor(model.getTextColor());
		soapModel.setPosition(model.getPosition());
		soapModel.setIsPrimary(model.getIsPrimary());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static VcmsStatusSoap[] toSoapModels(VcmsStatus[] models) {
		VcmsStatusSoap[] soapModels = new VcmsStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsStatusSoap[][] toSoapModels(VcmsStatus[][] models) {
		VcmsStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsStatusSoap[] toSoapModels(List<VcmsStatus> models) {
		List<VcmsStatusSoap> soapModels = new ArrayList<VcmsStatusSoap>(models.size());

		for (VcmsStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsStatusSoap[soapModels.size()]);
	}

	public VcmsStatusSoap() {
	}

	public long getPrimaryKey() {
		return _statusId;
	}

	public void setPrimaryKey(long pk) {
		setStatusId(pk);
	}

	public long getStatusId() {
		return _statusId;
	}

	public void setStatusId(long statusId) {
		_statusId = statusId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getCssClass() {
		return _cssClass;
	}

	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	public String getTextColor() {
		return _textColor;
	}

	public void setTextColor(String textColor) {
		_textColor = textColor;
	}

	public long getPosition() {
		return _position;
	}

	public void setPosition(long position) {
		_position = position;
	}

	public boolean getIsPrimary() {
		return _isPrimary;
	}

	public boolean isIsPrimary() {
		return _isPrimary;
	}

	public void setIsPrimary(boolean isPrimary) {
		_isPrimary = isPrimary;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _statusId;
	private long _companyId;
	private long _groupId;
	private Date _createdDate;
	private String _createdByUser;
	private Date _modifiedDate;
	private String _modifiedByUser;
	private String _name;
	private String _description;
	private String _cssClass;
	private String _textColor;
	private long _position;
	private boolean _isPrimary;
	private boolean _active;
}