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

import com.vportal.portlet.vcms.service.VcmsArticleStatusLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author hai
 */
public class VcmsArticleStatusClp extends BaseModelImpl<VcmsArticleStatus>
	implements VcmsArticleStatus {
	public VcmsArticleStatusClp() {
	}

	public Class<?> getModelClass() {
		return VcmsArticleStatus.class;
	}

	public String getModelClassName() {
		return VcmsArticleStatus.class.getName();
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

	public long getStatusId() {
		return _statusId;
	}

	public void setStatusId(long statusId) {
		_statusId = statusId;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	public String getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(String categoryId) {
		_categoryId = categoryId;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public long getArticleVersionId() {
		return _articleVersionId;
	}

	public void setArticleVersionId(long articleVersionId) {
		_articleVersionId = articleVersionId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VcmsArticleStatusLocalServiceUtil.addVcmsArticleStatus(this);
		}
		else {
			VcmsArticleStatusLocalServiceUtil.updateVcmsArticleStatus(this);
		}
	}

	@Override
	public VcmsArticleStatus toEscapedModel() {
		return (VcmsArticleStatus)Proxy.newProxyInstance(VcmsArticleStatus.class.getClassLoader(),
			new Class[] { VcmsArticleStatus.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VcmsArticleStatusClp clone = new VcmsArticleStatusClp();

		clone.setId(getId());
		clone.setStatusId(getStatusId());
		clone.setArticleId(getArticleId());
		clone.setCategoryId(getCategoryId());
		clone.setCreatedDate(getCreatedDate());
		clone.setCreatedByUser(getCreatedByUser());
		clone.setActive(getActive());
		clone.setArticleVersionId(getArticleVersionId());

		return clone;
	}

	public int compareTo(VcmsArticleStatus vcmsArticleStatus) {
		int value = 0;

		value = DateUtil.compareTo(getCreatedDate(),
				vcmsArticleStatus.getCreatedDate());

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

		VcmsArticleStatusClp vcmsArticleStatus = null;

		try {
			vcmsArticleStatus = (VcmsArticleStatusClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = vcmsArticleStatus.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", statusId=");
		sb.append(getStatusId());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", createdByUser=");
		sb.append(getCreatedByUser());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", articleVersionId=");
		sb.append(getArticleVersionId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcms.model.VcmsArticleStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusId</column-name><column-value><![CDATA[");
		sb.append(getStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
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
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleVersionId</column-name><column-value><![CDATA[");
		sb.append(getArticleVersionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _statusId;
	private String _articleId;
	private String _categoryId;
	private Date _createdDate;
	private String _createdByUser;
	private boolean _active;
	private long _articleVersionId;
}