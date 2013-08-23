/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.vimagegallery.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vimagegallery.service.http.TFImageServiceSoap}.
 *
 * @author    DucNN
 * @see       com.vportal.portlet.vimagegallery.service.http.TFImageServiceSoap
 * @generated
 */
public class TFImageSoap implements Serializable {
	public static TFImageSoap toSoapModel(TFImage model) {
		TFImageSoap soapModel = new TFImageSoap();

		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setImage(model.getImage());
		soapModel.setIsShow(model.getIsShow());

		return soapModel;
	}

	public static TFImageSoap[] toSoapModels(TFImage[] models) {
		TFImageSoap[] soapModels = new TFImageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TFImageSoap[][] toSoapModels(TFImage[][] models) {
		TFImageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TFImageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TFImageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TFImageSoap[] toSoapModels(List<TFImage> models) {
		List<TFImageSoap> soapModels = new ArrayList<TFImageSoap>(models.size());

		for (TFImage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TFImageSoap[soapModels.size()]);
	}

	public TFImageSoap() {
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
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

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public boolean getIsShow() {
		return _isShow;
	}

	public boolean isIsShow() {
		return _isShow;
	}

	public void setIsShow(boolean isShow) {
		_isShow = isShow;
	}

	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _categoryId;
	private String _name;
	private String _description;
	private String _image;
	private boolean _isShow;
}