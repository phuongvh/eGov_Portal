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

package com.vportal.portlet.vadvman.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author DucNN
 */
public class AdvItemClp extends BaseModelImpl<AdvItem> implements AdvItem {
	public AdvItemClp() {
	}

	public Class<?> getModelClass() {
		return AdvItem.class;
	}

	public String getModelClassName() {
		return AdvItem.class.getName();
	}

	public long getPrimaryKey() {
		return _itemId;
	}

	public void setPrimaryKey(long primaryKey) {
		setItemId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_itemId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getExpriedDate() {
		return _expriedDate;
	}

	public void setExpriedDate(Date expriedDate) {
		_expriedDate = expriedDate;
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

	public boolean getIsTargetBlank() {
		return _isTargetBlank;
	}

	public boolean isIsTargetBlank() {
		return _isTargetBlank;
	}

	public void setIsTargetBlank(boolean isTargetBlank) {
		_isTargetBlank = isTargetBlank;
	}

	public String getTxtMouseOver() {
		return _txtMouseOver;
	}

	public void setTxtMouseOver(String txtMouseOver) {
		_txtMouseOver = txtMouseOver;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	@Override
	public AdvItem toEscapedModel() {
		return (AdvItem)Proxy.newProxyInstance(AdvItem.class.getClassLoader(),
			new Class[] { AdvItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdvItemClp clone = new AdvItemClp();

		clone.setItemId(getItemId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setExpriedDate(getExpriedDate());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setUrl(getUrl());
		clone.setIsTargetBlank(getIsTargetBlank());
		clone.setTxtMouseOver(getTxtMouseOver());
		clone.setFolderId(getFolderId());
		clone.setStatus(getStatus());
		clone.setTypeId(getTypeId());

		return clone;
	}

	public int compareTo(AdvItem advItem) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), advItem.getCreateDate());

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

		AdvItemClp advItem = null;

		try {
			advItem = (AdvItemClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = advItem.getPrimaryKey();

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

		sb.append("{itemId=");
		sb.append(getItemId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", expriedDate=");
		sb.append(getExpriedDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", isTargetBlank=");
		sb.append(getIsTargetBlank());
		sb.append(", txtMouseOver=");
		sb.append(getTxtMouseOver());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", typeId=");
		sb.append(getTypeId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vadvman.model.AdvItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expriedDate</column-name><column-value><![CDATA[");
		sb.append(getExpriedDate());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isTargetBlank</column-name><column-value><![CDATA[");
		sb.append(getIsTargetBlank());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>txtMouseOver</column-name><column-value><![CDATA[");
		sb.append(getTxtMouseOver());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemId;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _expriedDate;
	private long _groupId;
	private long _companyId;
	private String _name;
	private String _description;
	private String _url;
	private boolean _isTargetBlank;
	private String _txtMouseOver;
	private long _folderId;
	private boolean _status;
	private long _typeId;
}