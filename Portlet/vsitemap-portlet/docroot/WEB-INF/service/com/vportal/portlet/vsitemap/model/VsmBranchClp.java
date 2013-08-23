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

package com.vportal.portlet.vsitemap.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.vportal.portlet.vsitemap.service.VsmBranchLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LongLH
 */
public class VsmBranchClp extends BaseModelImpl<VsmBranch> implements VsmBranch {
	public VsmBranchClp() {
	}

	public Class<?> getModelClass() {
		return VsmBranch.class;
	}

	public String getModelClassName() {
		return VsmBranch.class.getName();
	}

	public long getPrimaryKey() {
		return _branchId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBranchId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_branchId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getBranchId() {
		return _branchId;
	}

	public void setBranchId(long branchId) {
		_branchId = branchId;
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

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
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

	public boolean getAnchored() {
		return _anchored;
	}

	public boolean isAnchored() {
		return _anchored;
	}

	public void setAnchored(boolean anchored) {
		_anchored = anchored;
	}

	public String getHref() {
		return _href;
	}

	public void setHref(String href) {
		_href = href;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public boolean getHasIcon() {
		return _hasIcon;
	}

	public boolean isHasIcon() {
		return _hasIcon;
	}

	public void setHasIcon(boolean hasIcon) {
		_hasIcon = hasIcon;
	}

	public String getIcon() {
		return _icon;
	}

	public void setIcon(String icon) {
		_icon = icon;
	}

	public long getPosition() {
		return _position;
	}

	public void setPosition(long position) {
		_position = position;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VsmBranchLocalServiceUtil.addVsmBranch(this);
		}
		else {
			VsmBranchLocalServiceUtil.updateVsmBranch(this);
		}
	}

	@Override
	public VsmBranch toEscapedModel() {
		return (VsmBranch)Proxy.newProxyInstance(VsmBranch.class.getClassLoader(),
			new Class[] { VsmBranch.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VsmBranchClp clone = new VsmBranchClp();

		clone.setBranchId(getBranchId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreatedDate(getCreatedDate());
		clone.setCreatedByUser(getCreatedByUser());
		clone.setModifiedDate(getModifiedDate());
		clone.setModifiedByUser(getModifiedByUser());
		clone.setParentId(getParentId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setAnchored(getAnchored());
		clone.setHref(getHref());
		clone.setLanguage(getLanguage());
		clone.setHasIcon(getHasIcon());
		clone.setIcon(getIcon());
		clone.setPosition(getPosition());

		return clone;
	}

	public int compareTo(VsmBranch vsmBranch) {
		int value = 0;

		if (getPosition() < vsmBranch.getPosition()) {
			value = -1;
		}
		else if (getPosition() > vsmBranch.getPosition()) {
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

		VsmBranchClp vsmBranch = null;

		try {
			vsmBranch = (VsmBranchClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = vsmBranch.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{branchId=");
		sb.append(getBranchId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", createdByUser=");
		sb.append(getCreatedByUser());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", modifiedByUser=");
		sb.append(getModifiedByUser());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", anchored=");
		sb.append(getAnchored());
		sb.append(", href=");
		sb.append(getHref());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", hasIcon=");
		sb.append(getHasIcon());
		sb.append(", icon=");
		sb.append(getIcon());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vsitemap.model.VsmBranch");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>branchId</column-name><column-value><![CDATA[");
		sb.append(getBranchId());
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
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedByUser</column-name><column-value><![CDATA[");
		sb.append(getModifiedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
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
			"<column><column-name>anchored</column-name><column-value><![CDATA[");
		sb.append(getAnchored());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>href</column-name><column-value><![CDATA[");
		sb.append(getHref());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasIcon</column-name><column-value><![CDATA[");
		sb.append(getHasIcon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>icon</column-name><column-value><![CDATA[");
		sb.append(getIcon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _branchId;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private long _createdByUser;
	private Date _modifiedDate;
	private long _modifiedByUser;
	private long _parentId;
	private String _name;
	private String _description;
	private boolean _anchored;
	private String _href;
	private String _language;
	private boolean _hasIcon;
	private String _icon;
	private long _position;
}