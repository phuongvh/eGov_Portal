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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.edirectory.service.http.EDEmployeeServiceSoap}.
 *
 * @author    HOAN
 * @see       com.vportal.portlet.edirectory.service.http.EDEmployeeServiceSoap
 * @generated
 */
public class EDEmployeeSoap implements Serializable {
	public static EDEmployeeSoap toSoapModel(EDEmployee model) {
		EDEmployeeSoap soapModel = new EDEmployeeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setName(model.getName());
		soapModel.setBirthday(model.getBirthday());
		soapModel.setHomeSide(model.getHomeSide());
		soapModel.setFamily(model.getFamily());
		soapModel.setRace(model.getRace());
		soapModel.setHome(model.getHome());
		soapModel.setHomePhone(model.getHomePhone());
		soapModel.setWorkPhone(model.getWorkPhone());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setMajorLevel(model.getMajorLevel());
		soapModel.setPhilosophism(model.getPhilosophism());
		soapModel.setForeignLanguage(model.getForeignLanguage());
		soapModel.setJoinDate(model.getJoinDate());
		soapModel.setImage(model.getImage());
		soapModel.setIsShowTree(model.getIsShowTree());
		soapModel.setOtherInfo(model.getOtherInfo());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setDisplayOrder(model.getDisplayOrder());
		soapModel.setSex(model.getSex());
		soapModel.setStatus(model.getStatus());
		soapModel.setShow(model.getShow());

		return soapModel;
	}

	public static EDEmployeeSoap[] toSoapModels(EDEmployee[] models) {
		EDEmployeeSoap[] soapModels = new EDEmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EDEmployeeSoap[][] toSoapModels(EDEmployee[][] models) {
		EDEmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EDEmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EDEmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EDEmployeeSoap[] toSoapModels(List<EDEmployee> models) {
		List<EDEmployeeSoap> soapModels = new ArrayList<EDEmployeeSoap>(models.size());

		for (EDEmployee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EDEmployeeSoap[soapModels.size()]);
	}

	public EDEmployeeSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	public String getHomeSide() {
		return _homeSide;
	}

	public void setHomeSide(String homeSide) {
		_homeSide = homeSide;
	}

	public String getFamily() {
		return _family;
	}

	public void setFamily(String family) {
		_family = family;
	}

	public String getRace() {
		return _race;
	}

	public void setRace(String race) {
		_race = race;
	}

	public String getHome() {
		return _home;
	}

	public void setHome(String home) {
		_home = home;
	}

	public String getHomePhone() {
		return _homePhone;
	}

	public void setHomePhone(String homePhone) {
		_homePhone = homePhone;
	}

	public String getWorkPhone() {
		return _workPhone;
	}

	public void setWorkPhone(String workPhone) {
		_workPhone = workPhone;
	}

	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public String getMajorLevel() {
		return _majorLevel;
	}

	public void setMajorLevel(String majorLevel) {
		_majorLevel = majorLevel;
	}

	public String getPhilosophism() {
		return _philosophism;
	}

	public void setPhilosophism(String philosophism) {
		_philosophism = philosophism;
	}

	public String getForeignLanguage() {
		return _foreignLanguage;
	}

	public void setForeignLanguage(String foreignLanguage) {
		_foreignLanguage = foreignLanguage;
	}

	public Date getJoinDate() {
		return _joinDate;
	}

	public void setJoinDate(Date joinDate) {
		_joinDate = joinDate;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
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

	public String getOtherInfo() {
		return _otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		_otherInfo = otherInfo;
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

	public long getDisplayOrder() {
		return _displayOrder;
	}

	public void setDisplayOrder(long displayOrder) {
		_displayOrder = displayOrder;
	}

	public String getSex() {
		return _sex;
	}

	public void setSex(String sex) {
		_sex = sex;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public String getShow() {
		return _show;
	}

	public void setShow(String show) {
		_show = show;
	}

	private String _uuid;
	private long _id;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _title;
	private String _name;
	private Date _birthday;
	private String _homeSide;
	private String _family;
	private String _race;
	private String _home;
	private String _homePhone;
	private String _workPhone;
	private String _mobilePhone;
	private String _email;
	private long _departmentId;
	private String _majorLevel;
	private String _philosophism;
	private String _foreignLanguage;
	private Date _joinDate;
	private String _image;
	private boolean _isShowTree;
	private String _otherInfo;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _languageId;
	private long _displayOrder;
	private String _sex;
	private long _status;
	private String _show;
}