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

import com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author HOAN
 */
public class EDFunctionClp extends BaseModelImpl<EDFunction>
	implements EDFunction {
	public EDFunctionClp() {
	}

	public Class<?> getModelClass() {
		return EDFunction.class;
	}

	public String getModelClassName() {
		return EDFunction.class.getName();
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

	public int getLevelEd() {
		return _levelEd;
	}

	public void setLevelEd(int levelEd) {
		_levelEd = levelEd;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EDFunctionLocalServiceUtil.addEDFunction(this);
		}
		else {
			EDFunctionLocalServiceUtil.updateEDFunction(this);
		}
	}

	@Override
	public EDFunction toEscapedModel() {
		return (EDFunction)Proxy.newProxyInstance(EDFunction.class.getClassLoader(),
			new Class[] { EDFunction.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EDFunctionClp clone = new EDFunctionClp();

		clone.setId(getId());
		clone.setCreatedDate(getCreatedDate());
		clone.setName(getName());
		clone.setLevelEd(getLevelEd());
		clone.setIsShowTree(getIsShowTree());
		clone.setDescription(getDescription());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setLanguageId(getLanguageId());

		return clone;
	}

	public int compareTo(EDFunction edFunction) {
		int value = 0;

		if (getLevelEd() < edFunction.getLevelEd()) {
			value = -1;
		}
		else if (getLevelEd() > edFunction.getLevelEd()) {
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

		EDFunctionClp edFunction = null;

		try {
			edFunction = (EDFunctionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = edFunction.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", levelEd=");
		sb.append(getLevelEd());
		sb.append(", isShowTree=");
		sb.append(getIsShowTree());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.edirectory.model.EDFunction");
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
			"<column><column-name>levelEd</column-name><column-value><![CDATA[");
		sb.append(getLevelEd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isShowTree</column-name><column-value><![CDATA[");
		sb.append(getIsShowTree());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
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
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private Date _createdDate;
	private String _name;
	private int _levelEd;
	private boolean _isShowTree;
	private String _description;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private String _languageId;
}