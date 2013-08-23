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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vlinksman.service.http.LinkGroupServiceSoap}.
 *
 * @author    LongLH
 * @see       com.vportal.portlet.vlinksman.service.http.LinkGroupServiceSoap
 * @generated
 */
public class LinkGroupSoap implements Serializable {
	public static LinkGroupSoap toSoapModel(LinkGroup model) {
		LinkGroupSoap soapModel = new LinkGroupSoap();

		soapModel.setLinkgroupId(model.getLinkgroupId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static LinkGroupSoap[] toSoapModels(LinkGroup[] models) {
		LinkGroupSoap[] soapModels = new LinkGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LinkGroupSoap[][] toSoapModels(LinkGroup[][] models) {
		LinkGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LinkGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LinkGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LinkGroupSoap[] toSoapModels(List<LinkGroup> models) {
		List<LinkGroupSoap> soapModels = new ArrayList<LinkGroupSoap>(models.size());

		for (LinkGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LinkGroupSoap[soapModels.size()]);
	}

	public LinkGroupSoap() {
	}

	public long getPrimaryKey() {
		return _linkgroupId;
	}

	public void setPrimaryKey(long pk) {
		setLinkgroupId(pk);
	}

	public long getLinkgroupId() {
		return _linkgroupId;
	}

	public void setLinkgroupId(long linkgroupId) {
		_linkgroupId = linkgroupId;
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

	private long _linkgroupId;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
}