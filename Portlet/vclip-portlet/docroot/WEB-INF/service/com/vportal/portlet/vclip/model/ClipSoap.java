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

package com.vportal.portlet.vclip.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vclip.service.http.ClipServiceSoap}.
 *
 * @author    HOAN
 * @see       com.vportal.portlet.vclip.service.http.ClipServiceSoap
 * @generated
 */
public class ClipSoap implements Serializable {
	public static ClipSoap toSoapModel(Clip model) {
		ClipSoap soapModel = new ClipSoap();

		soapModel.setId(model.getId());
		soapModel.setClipTypeId(model.getClipTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUrl(model.getUrl());
		soapModel.setName(model.getName());
		soapModel.setTitle(model.getTitle());
		soapModel.setImage(model.getImage());
		soapModel.setDescription(model.getDescription());
		soapModel.setActive(model.getActive());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setHitcount(model.getHitcount());
		soapModel.setHitcountview(model.getHitcountview());

		return soapModel;
	}

	public static ClipSoap[] toSoapModels(Clip[] models) {
		ClipSoap[] soapModels = new ClipSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClipSoap[][] toSoapModels(Clip[][] models) {
		ClipSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClipSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClipSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClipSoap[] toSoapModels(List<Clip> models) {
		List<ClipSoap> soapModels = new ArrayList<ClipSoap>(models.size());

		for (Clip model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClipSoap[soapModels.size()]);
	}

	public ClipSoap() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getClipTypeId() {
		return _clipTypeId;
	}

	public void setClipTypeId(String clipTypeId) {
		_clipTypeId = clipTypeId;
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

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public long getHitcount() {
		return _hitcount;
	}

	public void setHitcount(long hitcount) {
		_hitcount = hitcount;
	}

	public long getHitcountview() {
		return _hitcountview;
	}

	public void setHitcountview(long hitcountview) {
		_hitcountview = hitcountview;
	}

	private String _id;
	private String _clipTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _url;
	private String _name;
	private String _title;
	private String _image;
	private String _description;
	private boolean _active;
	private String _language;
	private long _hitcount;
	private long _hitcountview;
}