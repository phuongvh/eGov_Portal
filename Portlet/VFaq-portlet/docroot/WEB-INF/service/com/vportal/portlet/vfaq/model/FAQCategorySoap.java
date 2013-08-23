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

package com.vportal.portlet.vfaq.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    DucNN
 * @generated
 */
public class FAQCategorySoap implements Serializable {
	public static FAQCategorySoap toSoapModel(FAQCategory model) {
		FAQCategorySoap soapModel = new FAQCategorySoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setParent(model.getParent());
		soapModel.setCatorder(model.getCatorder());
		soapModel.setCatlevel(model.getCatlevel());
		soapModel.setImage(model.getImage());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static FAQCategorySoap[] toSoapModels(FAQCategory[] models) {
		FAQCategorySoap[] soapModels = new FAQCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FAQCategorySoap[][] toSoapModels(FAQCategory[][] models) {
		FAQCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FAQCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new FAQCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FAQCategorySoap[] toSoapModels(List<FAQCategory> models) {
		List<FAQCategorySoap> soapModels = new ArrayList<FAQCategorySoap>(models.size());

		for (FAQCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FAQCategorySoap[soapModels.size()]);
	}

	public FAQCategorySoap() {
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

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public long getParent() {
		return _parent;
	}

	public void setParent(long parent) {
		_parent = parent;
	}

	public long getCatorder() {
		return _catorder;
	}

	public void setCatorder(long catorder) {
		_catorder = catorder;
	}

	public long getCatlevel() {
		return _catlevel;
	}

	public void setCatlevel(long catlevel) {
		_catlevel = catlevel;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public String getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public String getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(String modifiedByUser) {
		_modifiedByUser = modifiedByUser;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _id;
	private String _name;
	private String _description;
	private String _language;
	private long _parent;
	private long _catorder;
	private long _catlevel;
	private String _image;
	private String _createdByUser;
	private Date _createdDate;
	private String _modifiedByUser;
	private Date _modifiedDate;
	private long _groupId;
	private long _userId;
}