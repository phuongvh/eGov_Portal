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

import com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author HOAN
 */
public class EDDepartmentClp extends BaseModelImpl<EDDepartment>
	implements EDDepartment {
	public EDDepartmentClp() {
	}

	public Class<?> getModelClass() {
		return EDDepartment.class;
	}

	public String getModelClassName() {
		return EDDepartment.class.getName();
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

	public String getDomainId() {
		return _domainId;
	}

	public void setDomainId(String domainId) {
		_domainId = domainId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EDDepartmentLocalServiceUtil.addEDDepartment(this);
		}
		else {
			EDDepartmentLocalServiceUtil.updateEDDepartment(this);
		}
	}

	@Override
	public EDDepartment toEscapedModel() {
		return (EDDepartment)Proxy.newProxyInstance(EDDepartment.class.getClassLoader(),
			new Class[] { EDDepartment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EDDepartmentClp clone = new EDDepartmentClp();

		clone.setId(getId());
		clone.setCreatedDate(getCreatedDate());
		clone.setName(getName());
		clone.setParent(getParent());
		clone.setPhone(getPhone());
		clone.setFax(getFax());
		clone.setLevelEd(getLevelEd());
		clone.setEmail(getEmail());
		clone.setAddress(getAddress());
		clone.setDescription(getDescription());
		clone.setWebsite(getWebsite());
		clone.setImgurl(getImgurl());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setLanguageId(getLanguageId());
		clone.setDomainId(getDomainId());

		return clone;
	}

	public int compareTo(EDDepartment edDepartment) {
		int value = 0;

		if (getLevelEd() < edDepartment.getLevelEd()) {
			value = -1;
		}
		else if (getLevelEd() > edDepartment.getLevelEd()) {
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

		EDDepartmentClp edDepartment = null;

		try {
			edDepartment = (EDDepartmentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = edDepartment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", parent=");
		sb.append(getParent());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", fax=");
		sb.append(getFax());
		sb.append(", levelEd=");
		sb.append(getLevelEd());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", imgurl=");
		sb.append(getImgurl());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", domainId=");
		sb.append(getDomainId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.edirectory.model.EDDepartment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parent</column-name><column-value><![CDATA[");
		sb.append(getParent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fax</column-name><column-value><![CDATA[");
		sb.append(getFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelEd</column-name><column-value><![CDATA[");
		sb.append(getLevelEd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imgurl</column-name><column-value><![CDATA[");
		sb.append(getImgurl());
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
			"<column><column-name>domainId</column-name><column-value><![CDATA[");
		sb.append(getDomainId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
	private String _languageId;
	private String _domainId;
}