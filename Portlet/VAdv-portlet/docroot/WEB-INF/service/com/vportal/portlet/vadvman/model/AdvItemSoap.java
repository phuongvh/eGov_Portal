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

package com.vportal.portlet.vadvman.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vadvman.service.http.AdvItemServiceSoap}.
 *
 * @author    DucNN
 * @see       com.vportal.portlet.vadvman.service.http.AdvItemServiceSoap
 * @generated
 */
public class AdvItemSoap implements Serializable {
	public static AdvItemSoap toSoapModel(AdvItem model) {
		AdvItemSoap soapModel = new AdvItemSoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExpriedDate(model.getExpriedDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setUrl(model.getUrl());
		soapModel.setIsTargetBlank(model.getIsTargetBlank());
		soapModel.setTxtMouseOver(model.getTxtMouseOver());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setStatus(model.getStatus());
		soapModel.setTypeId(model.getTypeId());

		return soapModel;
	}

	public static AdvItemSoap[] toSoapModels(AdvItem[] models) {
		AdvItemSoap[] soapModels = new AdvItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdvItemSoap[][] toSoapModels(AdvItem[][] models) {
		AdvItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdvItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdvItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdvItemSoap[] toSoapModels(List<AdvItem> models) {
		List<AdvItemSoap> soapModels = new ArrayList<AdvItemSoap>(models.size());

		for (AdvItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdvItemSoap[soapModels.size()]);
	}

	public AdvItemSoap() {
	}

	public long getPrimaryKey() {
		return _itemId;
	}

	public void setPrimaryKey(long pk) {
		setItemId(pk);
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
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

	public Date getExpriedDate() {
		return _expriedDate;
	}

	public void setExpriedDate(Date expriedDate) {
		_expriedDate = expriedDate;
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

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public boolean getIsTargetBlank() {
		return _isTargetBlank;
	}

	public boolean isIsTargetBlank() {
		return _isTargetBlank;
	}

	public void setIsTargetBlank(boolean isTargetBlank) {
		_isTargetBlank = isTargetBlank;
	}

	public String getTxtMouseOver() {
		return _txtMouseOver;
	}

	public void setTxtMouseOver(String txtMouseOver) {
		_txtMouseOver = txtMouseOver;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	private long _itemId;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _expriedDate;
	private long _groupId;
	private long _companyId;
	private String _name;
	private String _description;
	private String _url;
	private boolean _isTargetBlank;
	private String _txtMouseOver;
	private long _folderId;
	private boolean _status;
	private long _typeId;
}