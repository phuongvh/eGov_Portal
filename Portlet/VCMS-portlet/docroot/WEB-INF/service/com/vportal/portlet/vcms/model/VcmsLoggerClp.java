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

import com.vportal.portlet.vcms.service.VcmsLoggerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author hai
 */
public class VcmsLoggerClp extends BaseModelImpl<VcmsLogger>
	implements VcmsLogger {
	public VcmsLoggerClp() {
	}

	public Class<?> getModelClass() {
		return VcmsLogger.class;
	}

	public String getModelClassName() {
		return VcmsLogger.class.getName();
	}

	public String getPrimaryKey() {
		return _loggerId;
	}

	public void setPrimaryKey(String primaryKey) {
		setLoggerId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _loggerId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	public String getLoggerId() {
		return _loggerId;
	}

	public void setLoggerId(String loggerId) {
		_loggerId = loggerId;
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

	public String getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		_createdByUser = createdByUser;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VcmsLoggerLocalServiceUtil.addVcmsLogger(this);
		}
		else {
			VcmsLoggerLocalServiceUtil.updateVcmsLogger(this);
		}
	}

	@Override
	public VcmsLogger toEscapedModel() {
		return (VcmsLogger)Proxy.newProxyInstance(VcmsLogger.class.getClassLoader(),
			new Class[] { VcmsLogger.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VcmsLoggerClp clone = new VcmsLoggerClp();

		clone.setLoggerId(getLoggerId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreatedDate(getCreatedDate());
		clone.setCreatedByUser(getCreatedByUser());
		clone.setContent(getContent());

		return clone;
	}

	public int compareTo(VcmsLogger vcmsLogger) {
		int value = 0;

		value = DateUtil.compareTo(getCreatedDate(), vcmsLogger.getCreatedDate());

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

		VcmsLoggerClp vcmsLogger = null;

		try {
			vcmsLogger = (VcmsLoggerClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = vcmsLogger.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{loggerId=");
		sb.append(getLoggerId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", createdByUser=");
		sb.append(getCreatedByUser());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcms.model.VcmsLogger");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>loggerId</column-name><column-value><![CDATA[");
		sb.append(getLoggerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _loggerId;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private String _createdByUser;
	private String _content;
}