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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vdoc.service.http.vdocLoggerServiceSoap}.
 *
 * @author    MrEn
 * @see       com.vportal.portlet.vdoc.service.http.vdocLoggerServiceSoap
 * @generated
 */
public class vdocLoggerSoap implements Serializable {
	public static vdocLoggerSoap toSoapModel(vdocLogger model) {
		vdocLoggerSoap soapModel = new vdocLoggerSoap();

		soapModel.setLoggerId(model.getLoggerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static vdocLoggerSoap[] toSoapModels(vdocLogger[] models) {
		vdocLoggerSoap[] soapModels = new vdocLoggerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static vdocLoggerSoap[][] toSoapModels(vdocLogger[][] models) {
		vdocLoggerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new vdocLoggerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new vdocLoggerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static vdocLoggerSoap[] toSoapModels(List<vdocLogger> models) {
		List<vdocLoggerSoap> soapModels = new ArrayList<vdocLoggerSoap>(models.size());

		for (vdocLogger model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new vdocLoggerSoap[soapModels.size()]);
	}

	public vdocLoggerSoap() {
	}

	public String getPrimaryKey() {
		return _loggerId;
	}

	public void setPrimaryKey(String pk) {
		setLoggerId(pk);
	}

	public String getLoggerId() {
		return _loggerId;
	}

	public void setLoggerId(String loggerId) {
		_loggerId = loggerId;
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

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private String _loggerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private long _createdByUser;
	private String _content;
}