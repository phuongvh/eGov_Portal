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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsThreadServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsThreadServiceSoap
 * @generated
 */
public class VcmsThreadSoap implements Serializable {
	public static VcmsThreadSoap toSoapModel(VcmsThread model) {
		VcmsThreadSoap soapModel = new VcmsThreadSoap();

		soapModel.setThreadId(model.getThreadId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setHasImage(model.getHasImage());
		soapModel.setImage(model.getImage());
		soapModel.setLanguage(model.getLanguage());

		return soapModel;
	}

	public static VcmsThreadSoap[] toSoapModels(VcmsThread[] models) {
		VcmsThreadSoap[] soapModels = new VcmsThreadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsThreadSoap[][] toSoapModels(VcmsThread[][] models) {
		VcmsThreadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsThreadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsThreadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsThreadSoap[] toSoapModels(List<VcmsThread> models) {
		List<VcmsThreadSoap> soapModels = new ArrayList<VcmsThreadSoap>(models.size());

		for (VcmsThread model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsThreadSoap[soapModels.size()]);
	}

	public VcmsThreadSoap() {
	}

	public String getPrimaryKey() {
		return _threadId;
	}

	public void setPrimaryKey(String pk) {
		setThreadId(pk);
	}

	public String getThreadId() {
		return _threadId;
	}

	public void setThreadId(String threadId) {
		_threadId = threadId;
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

	public boolean getHasImage() {
		return _hasImage;
	}

	public boolean isHasImage() {
		return _hasImage;
	}

	public void setHasImage(boolean hasImage) {
		_hasImage = hasImage;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	private String _threadId;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private String _createdByUser;
	private Date _modifiedDate;
	private String _modifiedByUser;
	private String _title;
	private String _description;
	private boolean _hasImage;
	private String _image;
	private String _language;
}