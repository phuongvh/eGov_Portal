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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcalendar.service.http.VCalServiceSoap}.
 *
 * @author    LongLH
 * @see       com.vportal.portlet.vcalendar.service.http.VCalServiceSoap
 * @generated
 */
public class VCalSoap implements Serializable {
	public static VCalSoap toSoapModel(VCal model) {
		VCalSoap soapModel = new VCalSoap();

		soapModel.setCalId(model.getCalId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setFileId(model.getFileId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setGuest(model.getGuest());
		soapModel.setLocation(model.getLocation());
		soapModel.setTime(model.getTime());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static VCalSoap[] toSoapModels(VCal[] models) {
		VCalSoap[] soapModels = new VCalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VCalSoap[][] toSoapModels(VCal[][] models) {
		VCalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VCalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VCalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VCalSoap[] toSoapModels(List<VCal> models) {
		List<VCalSoap> soapModels = new ArrayList<VCalSoap>(models.size());

		for (VCal model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VCalSoap[soapModels.size()]);
	}

	public VCalSoap() {
	}

	public long getPrimaryKey() {
		return _calId;
	}

	public void setPrimaryKey(long pk) {
		setCalId(pk);
	}

	public long getCalId() {
		return _calId;
	}

	public void setCalId(long calId) {
		_calId = calId;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getGuest() {
		return _guest;
	}

	public void setGuest(String guest) {
		_guest = guest;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getTime() {
		return _time;
	}

	public void setTime(String time) {
		_time = time;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	private long _calId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _languageId;
	private long _fileId;
	private String _title;
	private String _description;
	private String _guest;
	private String _location;
	private String _time;
	private Date _startDate;
	private Date _endDate;
	private long _status;
}