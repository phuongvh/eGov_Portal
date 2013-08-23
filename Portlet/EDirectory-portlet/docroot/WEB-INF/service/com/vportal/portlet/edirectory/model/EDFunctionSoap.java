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

package com.vportal.portlet.edirectory.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.edirectory.service.http.EDFunctionServiceSoap}.
 *
 * @author    HOAN
 * @see       com.vportal.portlet.edirectory.service.http.EDFunctionServiceSoap
 * @generated
 */
public class EDFunctionSoap implements Serializable {
	public static EDFunctionSoap toSoapModel(EDFunction model) {
		EDFunctionSoap soapModel = new EDFunctionSoap();

		soapModel.setId(model.getId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setName(model.getName());
		soapModel.setLevelEd(model.getLevelEd());
		soapModel.setIsShowTree(model.getIsShowTree());
		soapModel.setDescription(model.getDescription());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setLanguageId(model.getLanguageId());

		return soapModel;
	}

	public static EDFunctionSoap[] toSoapModels(EDFunction[] models) {
		EDFunctionSoap[] soapModels = new EDFunctionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EDFunctionSoap[][] toSoapModels(EDFunction[][] models) {
		EDFunctionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EDFunctionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EDFunctionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EDFunctionSoap[] toSoapModels(List<EDFunction> models) {
		List<EDFunctionSoap> soapModels = new ArrayList<EDFunctionSoap>(models.size());

		for (EDFunction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EDFunctionSoap[soapModels.size()]);
	}

	public EDFunctionSoap() {
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

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getLevelEd() {
		return _levelEd;
	}

	public void setLevelEd(int levelEd) {
		_levelEd = levelEd;
	}

	public boolean getIsShowTree() {
		return _isShowTree;
	}

	public boolean isIsShowTree() {
		return _isShowTree;
	}

	public void setIsShowTree(boolean isShowTree) {
		_isShowTree = isShowTree;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	private long _id;
	private Date _createdDate;
	private String _name;
	private int _levelEd;
	private boolean _isShowTree;
	private String _description;
	private long _groupId;
	private long _userId;
	private long _companyId;
	private String _languageId;
}