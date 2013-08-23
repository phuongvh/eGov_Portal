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

package com.vportal.portlet.vcontact.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcontact.service.http.VContactServiceSoap}.
 *
 * @author    LongLH
 * @see       com.vportal.portlet.vcontact.service.http.VContactServiceSoap
 * @generated
 */
public class VContactSoap implements Serializable {
	public static VContactSoap toSoapModel(VContact model) {
		VContactSoap soapModel = new VContactSoap();

		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGuestName(model.getGuestName());
		soapModel.setEmail(model.getEmail());
		soapModel.setTitle(model.getTitle());
		soapModel.setAddress(model.getAddress());
		soapModel.setPhone(model.getPhone());
		soapModel.setFax(model.getFax());
		soapModel.setContent(model.getContent());
		soapModel.setHasAttach(model.getHasAttach());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static VContactSoap[] toSoapModels(VContact[] models) {
		VContactSoap[] soapModels = new VContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VContactSoap[][] toSoapModels(VContact[][] models) {
		VContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VContactSoap[] toSoapModels(List<VContact> models) {
		List<VContactSoap> soapModels = new ArrayList<VContactSoap>(models.size());

		for (VContact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VContactSoap[soapModels.size()]);
	}

	public VContactSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getGuestName() {
		return _guestName;
	}

	public void setGuestName(String guestName) {
		_guestName = guestName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
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

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public boolean getHasAttach() {
		return _hasAttach;
	}

	public boolean isHasAttach() {
		return _hasAttach;
	}

	public void setHasAttach(boolean hasAttach) {
		_hasAttach = hasAttach;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _id;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _guestName;
	private String _email;
	private String _title;
	private String _address;
	private String _phone;
	private String _fax;
	private String _content;
	private boolean _hasAttach;
	private int _status;
}