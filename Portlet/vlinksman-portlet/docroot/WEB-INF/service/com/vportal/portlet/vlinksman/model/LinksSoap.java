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

package com.vportal.portlet.vlinksman.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vlinksman.service.http.LinksServiceSoap}.
 *
 * @author    LongLH
 * @see       com.vportal.portlet.vlinksman.service.http.LinksServiceSoap
 * @generated
 */
public class LinksSoap implements Serializable {
	public static LinksSoap toSoapModel(Links model) {
		LinksSoap soapModel = new LinksSoap();

		soapModel.setLinkId(model.getLinkId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLinkgroupId(model.getLinkgroupId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setUrl(model.getUrl());
		soapModel.setPosition(model.getPosition());
		soapModel.setHasImage(model.getHasImage());
		soapModel.setIsTargetBlank(model.getIsTargetBlank());
		soapModel.setImageName(model.getImageName());
		soapModel.setFolderId(model.getFolderId());

		return soapModel;
	}

	public static LinksSoap[] toSoapModels(Links[] models) {
		LinksSoap[] soapModels = new LinksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LinksSoap[][] toSoapModels(Links[][] models) {
		LinksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LinksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LinksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LinksSoap[] toSoapModels(List<Links> models) {
		List<LinksSoap> soapModels = new ArrayList<LinksSoap>(models.size());

		for (Links model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LinksSoap[soapModels.size()]);
	}

	public LinksSoap() {
	}

	public long getPrimaryKey() {
		return _linkId;
	}

	public void setPrimaryKey(long pk) {
		setLinkId(pk);
	}

	public long getLinkId() {
		return _linkId;
	}

	public void setLinkId(long linkId) {
		_linkId = linkId;
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

	public long getLinkgroupId() {
		return _linkgroupId;
	}

	public void setLinkgroupId(long linkgroupId) {
		_linkgroupId = linkgroupId;
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

	public long getPosition() {
		return _position;
	}

	public void setPosition(long position) {
		_position = position;
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

	public boolean getIsTargetBlank() {
		return _isTargetBlank;
	}

	public boolean isIsTargetBlank() {
		return _isTargetBlank;
	}

	public void setIsTargetBlank(boolean isTargetBlank) {
		_isTargetBlank = isTargetBlank;
	}

	public String getImageName() {
		return _imageName;
	}

	public void setImageName(String imageName) {
		_imageName = imageName;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	private long _linkId;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _linkgroupId;
	private String _name;
	private String _description;
	private String _url;
	private long _position;
	private boolean _hasImage;
	private boolean _isTargetBlank;
	private String _imageName;
	private long _folderId;
}