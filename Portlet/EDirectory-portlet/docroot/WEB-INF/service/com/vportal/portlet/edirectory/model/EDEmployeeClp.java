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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.vportal.portlet.edirectory.service.EDEmployeeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author HOAN
 */
public class EDEmployeeClp extends BaseModelImpl<EDEmployee>
	implements EDEmployee {
	public EDEmployeeClp() {
	}

	public Class<?> getModelClass() {
		return EDEmployee.class;
	}

	public String getModelClassName() {
		return EDEmployee.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			EDEmployeeLocalServiceUtil.addEDEmployee(this);
		}
		else {
			EDEmployeeLocalServiceUtil.updateEDEmployee(this);
		}
	}

	@Override
	public EDEmployee toEscapedModel() {
		return (EDEmployee)Proxy.newProxyInstance(EDEmployee.class.getClassLoader(),
			new Class[] { EDEmployee.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EDEmployeeClp clone = new EDEmployeeClp();

		clone.setUuid(getUuid());
		clone.setId(getId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setName(getName());
		clone.setBirthday(getBirthday());
		clone.setHomeSide(getHomeSide());
		clone.setFamily(getFamily());
		clone.setRace(getRace());
		clone.setHome(getHome());
		clone.setHomePhone(getHomePhone());
		clone.setWorkPhone(getWorkPhone());
		clone.setMobilePhone(getMobilePhone());
		clone.setEmail(getEmail());
		clone.setDepartmentId(getDepartmentId());
		clone.setMajorLevel(getMajorLevel());
		clone.setPhilosophism(getPhilosophism());
		clone.setForeignLanguage(getForeignLanguage());
		clone.setJoinDate(getJoinDate());
		clone.setImage(getImage());
		clone.setIsShowTree(getIsShowTree());
		clone.setOtherInfo(getOtherInfo());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setLanguageId(getLanguageId());
		clone.setDisplayOrder(getDisplayOrder());
		clone.setSex(getSex());
		clone.setStatus(getStatus());
		clone.setShow(getShow());

		return clone;
	}

	public int compareTo(EDEmployee edEmployee) {
		int value = 0;

		if (getDisplayOrder() < edEmployee.getDisplayOrder()) {
			value = -1;
		}
		else if (getDisplayOrder() > edEmployee.getDisplayOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EDEmployeeClp edEmployee = null;

		try {
			edEmployee = (EDEmployeeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = edEmployee.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", birthday=");
		sb.append(getBirthday());
		sb.append(", homeSide=");
		sb.append(getHomeSide());
		sb.append(", family=");
		sb.append(getFamily());
		sb.append(", race=");
		sb.append(getRace());
		sb.append(", home=");
		sb.append(getHome());
		sb.append(", homePhone=");
		sb.append(getHomePhone());
		sb.append(", workPhone=");
		sb.append(getWorkPhone());
		sb.append(", mobilePhone=");
		sb.append(getMobilePhone());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", majorLevel=");
		sb.append(getMajorLevel());
		sb.append(", philosophism=");
		sb.append(getPhilosophism());
		sb.append(", foreignLanguage=");
		sb.append(getForeignLanguage());
		sb.append(", joinDate=");
		sb.append(getJoinDate());
		sb.append(", image=");
		sb.append(getImage());
		sb.append(", isShowTree=");
		sb.append(getIsShowTree());
		sb.append(", otherInfo=");
		sb.append(getOtherInfo());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", displayOrder=");
		sb.append(getDisplayOrder());
		sb.append(", sex=");
		sb.append(getSex());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", show=");
		sb.append(getShow());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(97);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.edirectory.model.EDEmployee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthday</column-name><column-value><![CDATA[");
		sb.append(getBirthday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>homeSide</column-name><column-value><![CDATA[");
		sb.append(getHomeSide());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>family</column-name><column-value><![CDATA[");
		sb.append(getFamily());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>race</column-name><column-value><![CDATA[");
		sb.append(getRace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>home</column-name><column-value><![CDATA[");
		sb.append(getHome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>homePhone</column-name><column-value><![CDATA[");
		sb.append(getHomePhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workPhone</column-name><column-value><![CDATA[");
		sb.append(getWorkPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobilePhone</column-name><column-value><![CDATA[");
		sb.append(getMobilePhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>majorLevel</column-name><column-value><![CDATA[");
		sb.append(getMajorLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>philosophism</column-name><column-value><![CDATA[");
		sb.append(getPhilosophism());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>foreignLanguage</column-name><column-value><![CDATA[");
		sb.append(getForeignLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>joinDate</column-name><column-value><![CDATA[");
		sb.append(getJoinDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>image</column-name><column-value><![CDATA[");
		sb.append(getImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isShowTree</column-name><column-value><![CDATA[");
		sb.append(getIsShowTree());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otherInfo</column-name><column-value><![CDATA[");
		sb.append(getOtherInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrder</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sex</column-name><column-value><![CDATA[");
		sb.append(getSex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>show</column-name><column-value><![CDATA[");
		sb.append(getShow());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
	private String _languageId;
	private long _displayOrder;
	private String _sex;
	private long _status;
	private String _show;
}