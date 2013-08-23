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

package com.vportal.portlet.vlinksman.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LongLH
 */
public class LinksClp extends BaseModelImpl<Links> implements Links {
	public LinksClp() {
	}

	public Class<?> getModelClass() {
		return Links.class;
	}

	public String getModelClassName() {
		return Links.class.getName();
	}

	public long getPrimaryKey() {
		return _linkId;
	}

	public void setPrimaryKey(long primaryKey) {
		setLinkId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_linkId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getLinkId() {
		return _linkId;
	}

	public void setLinkId(long linkId) {
		_linkId = linkId;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getLinkgroupId() {
		return _linkgroupId;
	}

	public void setLinkgroupId(long linkgroupId) {
		_linkgroupId = linkgroupId;
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

	public long getPosition() {
		return _position;
	}

	public void setPosition(long position) {
		_position = position;
	}

	public boolean getHasImage() {
		return _hasImage;
	}

	public boolean isHasImage() {
		return _hasImage;
	}

	public void setHasImage(boolean hasImage) {
		_hasImage = hasImage;
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

	public String getImageName() {
		return _imageName;
	}

	public void setImageName(String imageName) {
		_imageName = imageName;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	@Override
	public Links toEscapedModel() {
		return (Links)Proxy.newProxyInstance(Links.class.getClassLoader(),
			new Class[] { Links.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LinksClp clone = new LinksClp();

		clone.setLinkId(getLinkId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLinkgroupId(getLinkgroupId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setUrl(getUrl());
		clone.setPosition(getPosition());
		clone.setHasImage(getHasImage());
		clone.setIsTargetBlank(getIsTargetBlank());
		clone.setImageName(getImageName());
		clone.setFolderId(getFolderId());

		return clone;
	}

	public int compareTo(Links links) {
		int value = 0;

		if (getPosition() < links.getPosition()) {
			value = -1;
		}
		else if (getPosition() > links.getPosition()) {
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

		LinksClp links = null;

		try {
			links = (LinksClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = links.getPrimaryKey();

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

		sb.append("{linkId=");
		sb.append(getLinkId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", linkgroupId=");
		sb.append(getLinkgroupId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", hasImage=");
		sb.append(getHasImage());
		sb.append(", isTargetBlank=");
		sb.append(getIsTargetBlank());
		sb.append(", imageName=");
		sb.append(getImageName());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vlinksman.model.Links");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>linkId</column-name><column-value><![CDATA[");
		sb.append(getLinkId());
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
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkgroupId</column-name><column-value><![CDATA[");
		sb.append(getLinkgroupId());
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
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasImage</column-name><column-value><![CDATA[");
		sb.append(getHasImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isTargetBlank</column-name><column-value><![CDATA[");
		sb.append(getIsTargetBlank());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageName</column-name><column-value><![CDATA[");
		sb.append(getImageName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _linkId;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _linkgroupId;
	private String _name;
	private String _description;
	private String _url;
	private long _position;
	private boolean _hasImage;
	private boolean _isTargetBlank;
	private String _imageName;
	private long _folderId;
}