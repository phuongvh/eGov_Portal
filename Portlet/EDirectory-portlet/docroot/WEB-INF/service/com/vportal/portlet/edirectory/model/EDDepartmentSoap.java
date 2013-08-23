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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.edirectory.service.http.EDDepartmentServiceSoap}.
 *
 * @author    HOAN
 * @see       com.vportal.portlet.edirectory.service.http.EDDepartmentServiceSoap
 * @generated
 */
public class EDDepartmentSoap implements Serializable {
	public static EDDepartmentSoap toSoapModel(EDDepartment model) {
		EDDepartmentSoap soapModel = new EDDepartmentSoap();

		soapModel.setId(model.getId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setName(model.getName());
		soapModel.setParent(model.getParent());
		soapModel.setPhone(model.getPhone());
		soapModel.setFax(model.getFax());
		soapModel.setLevelEd(model.getLevelEd());
		soapModel.setEmail(model.getEmail());
		soapModel.setAddress(model.getAddress());
		soapModel.setDescription(model.getDescription());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setImgurl(model.getImgurl());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setDomainId(model.getDomainId());

		return soapModel;
	}

	public static EDDepartmentSoap[] toSoapModels(EDDepartment[] models) {
		EDDepartmentSoap[] soapModels = new EDDepartmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EDDepartmentSoap[][] toSoapModels(EDDepartment[][] models) {
		EDDepartmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EDDepartmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EDDepartmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EDDepartmentSoap[] toSoapModels(List<EDDepartment> models) {
		List<EDDepartmentSoap> soapModels = new ArrayList<EDDepartmentSoap>(models.size());

		for (EDDepartment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EDDepartmentSoap[soapModels.size()]);
	}

	public EDDepartmentSoap() {
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

	public long getParent() {
		return _parent;
	}

	public void setParent(long parent) {
		_parent = parent;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public long getLevelEd() {
		return _levelEd;
	}

	public void setLevelEd(long levelEd) {
		_levelEd = levelEd;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getImgurl() {
		return _imgurl;
	}

	public void setImgurl(String imgurl) {
		_imgurl = imgurl;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public String getDomainId() {
		return _domainId;
	}

	public void setDomainId(String domainId) {
		_domainId = domainId;
	}

	private long _id;
	private Date _createdDate;
	private String _name;
	private long _parent;
	private String _phone;
	private String _fax;
	private long _levelEd;
	private String _email;
	private String _address;
	private String _description;
	private String _website;
	private String _imgurl;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _languageId;
	private String _domainId;
}