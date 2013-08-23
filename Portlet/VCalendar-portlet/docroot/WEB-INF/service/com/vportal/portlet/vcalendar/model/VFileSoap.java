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

package com.vportal.portlet.vcalendar.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcalendar.service.http.VFileServiceSoap}.
 *
 * @author    LongLH
 * @see       com.vportal.portlet.vcalendar.service.http.VFileServiceSoap
 * @generated
 */
public class VFileSoap implements Serializable {
	public static VFileSoap toSoapModel(VFile model) {
		VFileSoap soapModel = new VFileSoap();

		soapModel.setFileId(model.getFileId());
		soapModel.setFullname(model.getFullname());
		soapModel.setPhone(model.getPhone());
		soapModel.setAddress(model.getAddress());
		soapModel.setBirthday(model.getBirthday());
		soapModel.setPosition(model.getPosition());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static VFileSoap[] toSoapModels(VFile[] models) {
		VFileSoap[] soapModels = new VFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VFileSoap[][] toSoapModels(VFile[][] models) {
		VFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VFileSoap[] toSoapModels(List<VFile> models) {
		List<VFileSoap> soapModels = new ArrayList<VFileSoap>(models.size());

		for (VFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VFileSoap[soapModels.size()]);
	}

	public VFileSoap() {
	}

	public long getPrimaryKey() {
		return _fileId;
	}

	public void setPrimaryKey(long pk) {
		setFileId(pk);
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFullname() {
		return _fullname;
	}

	public void setFullname(String fullname) {
		_fullname = fullname;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	private long _fileId;
	private String _fullname;
	private String _phone;
	private String _address;
	private Date _birthday;
	private String _position;
	private long _status;
}