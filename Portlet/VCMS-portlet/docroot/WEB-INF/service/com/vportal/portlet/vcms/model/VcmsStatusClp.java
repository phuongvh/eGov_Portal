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

package com.vportal.portlet.vcms.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author hai
 */
public class VcmsStatusClp extends BaseModelImpl<VcmsStatus>
	implements VcmsStatus {
	public VcmsStatusClp() {
	}

	public Class<?> getModelClass() {
		return VcmsStatus.class;
	}

	public String getModelClassName() {
		return VcmsStatus.class.getName();
	}

	public long getPrimaryKey() {
		return _statusId;
	}

	public void setPrimaryKey(long primaryKey) {
		setStatusId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_statusId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getStatusId() {
		return _statusId;
	}

	public void setStatusId(long statusId) {
		_statusId = statusId;
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

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public String getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(String modifiedByUser) {
		_modifiedByUser = modifiedByUser;
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

	public String getCssClass() {
		return _cssClass;
	}

	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	public String getTextColor() {
		return _textColor;
	}

	public void setTextColor(String textColor) {
		_textColor = textColor;
	}

	public long getPosition() {
		return _position;
	}

	public void setPosition(long position) {
		_position = position;
	}

	public boolean getIsPrimary() {
		return _isPrimary;
	}

	public boolean isIsPrimary() {
		return _isPrimary;
	}

	public void setIsPrimary(boolean isPrimary) {
		_isPrimary = isPrimary;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VcmsStatusLocalServiceUtil.addVcmsStatus(this);
		}
		else {
			VcmsStatusLocalServiceUtil.updateVcmsStatus(this);
		}
	}

	@Override
	public VcmsStatus toEscapedModel() {
		return (VcmsStatus)Proxy.newProxyInstance(VcmsStatus.class.getClassLoader(),
			new Class[] { VcmsStatus.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VcmsStatusClp clone = new VcmsStatusClp();

		clone.setStatusId(getStatusId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreatedDate(getCreatedDate());
		clone.setCreatedByUser(getCreatedByUser());
		clone.setModifiedDate(getModifiedDate());
		clone.setModifiedByUser(getModifiedByUser());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setCssClass(getCssClass());
		clone.setTextColor(getTextColor());
		clone.setPosition(getPosition());
		clone.setIsPrimary(getIsPrimary());
		clone.setActive(getActive());

		return clone;
	}

	public int compareTo(VcmsStatus vcmsStatus) {
		int value = 0;

		if (getPosition() < vcmsStatus.getPosition()) {
			value = -1;
		}
		else if (getPosition() > vcmsStatus.getPosition()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreatedDate(), vcmsStatus.getCreatedDate());

		value = value * -1;

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

		VcmsStatusClp vcmsStatus = null;

		try {
			vcmsStatus = (VcmsStatusClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = vcmsStatus.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{statusId=");
		sb.append(getStatusId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", createdByUser=");
		sb.append(getCreatedByUser());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", modifiedByUser=");
		sb.append(getModifiedByUser());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", cssClass=");
		sb.append(getCssClass());
		sb.append(", textColor=");
		sb.append(getTextColor());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", isPrimary=");
		sb.append(getIsPrimary());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcms.model.VcmsStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>statusId</column-name><column-value><![CDATA[");
		sb.append(getStatusId());
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
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUser</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedByUser</column-name><column-value><![CDATA[");
		sb.append(getModifiedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cssClass</column-name><column-value><![CDATA[");
		sb.append(getCssClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>textColor</column-name><column-value><![CDATA[");
		sb.append(getTextColor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPrimary</column-name><column-value><![CDATA[");
		sb.append(getIsPrimary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _statusId;
	private long _companyId;
	private long _groupId;
	private Date _createdDate;
	private String _createdByUser;
	private Date _modifiedDate;
	private String _modifiedByUser;
	private String _name;
	private String _description;
	private String _cssClass;
	private String _textColor;
	private long _position;
	private boolean _isPrimary;
	private boolean _active;
}