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

package com.vportal.portlet.vcalendar.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LongLH
 */
public class VFileClp extends BaseModelImpl<VFile> implements VFile {
	public VFileClp() {
	}

	public Class<?> getModelClass() {
		return VFile.class;
	}

	public String getModelClassName() {
		return VFile.class.getName();
	}

	public long getPrimaryKey() {
		return _fileId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFileId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_fileId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFullname() {
		return _fullname;
	}

	public void setFullname(String fullname) {
		_fullname = fullname;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	@Override
	public VFile toEscapedModel() {
		return (VFile)Proxy.newProxyInstance(VFile.class.getClassLoader(),
			new Class[] { VFile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VFileClp clone = new VFileClp();

		clone.setFileId(getFileId());
		clone.setFullname(getFullname());
		clone.setPhone(getPhone());
		clone.setAddress(getAddress());
		clone.setBirthday(getBirthday());
		clone.setPosition(getPosition());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(VFile vFile) {
		int value = 0;

		value = getFullname().compareTo(vFile.getFullname());

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

		VFileClp vFile = null;

		try {
			vFile = (VFileClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = vFile.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{fileId=");
		sb.append(getFileId());
		sb.append(", fullname=");
		sb.append(getFullname());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", birthday=");
		sb.append(getBirthday());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcalendar.model.VFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>fileId</column-name><column-value><![CDATA[");
		sb.append(getFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullname</column-name><column-value><![CDATA[");
		sb.append(getFullname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthday</column-name><column-value><![CDATA[");
		sb.append(getBirthday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _fileId;
	private String _fullname;
	private String _phone;
	private String _address;
	private Date _birthday;
	private String _position;
	private long _status;
}