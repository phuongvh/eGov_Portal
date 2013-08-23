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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.vportal.portlet.vcms.service.VcmsCategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author hai
 */
public class VcmsCategoryClp extends BaseModelImpl<VcmsCategory>
	implements VcmsCategory {
	public VcmsCategoryClp() {
	}

	public Class<?> getModelClass() {
		return VcmsCategory.class;
	}

	public String getModelClassName() {
		return VcmsCategory.class.getName();
	}

	public String getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(String primaryKey) {
		setCategoryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _categoryId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	public String getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(String categoryId) {
		_categoryId = categoryId;
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

	public String getPortionId() {
		return _portionId;
	}

	public void setPortionId(String portionId) {
		_portionId = portionId;
	}

	public String getParentId() {
		return _parentId;
	}

	public void setParentId(String parentId) {
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

	public boolean getHasImage() {
		return _hasImage;
	}

	public boolean isHasImage() {
		return _hasImage;
	}

	public void setHasImage(boolean hasImage) {
		_hasImage = hasImage;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public long getPosition() {
		return _position;
	}

	public void setPosition(long position) {
		_position = position;
	}

	public long getUserHit() {
		return _userHit;
	}

	public void setUserHit(long userHit) {
		_userHit = userHit;
	}

	public boolean getRssable() {
		return _rssable;
	}

	public boolean isRssable() {
		return _rssable;
	}

	public void setRssable(boolean rssable) {
		_rssable = rssable;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VcmsCategoryLocalServiceUtil.addVcmsCategory(this);
		}
		else {
			VcmsCategoryLocalServiceUtil.updateVcmsCategory(this);
		}
	}

	@Override
	public VcmsCategory toEscapedModel() {
		return (VcmsCategory)Proxy.newProxyInstance(VcmsCategory.class.getClassLoader(),
			new Class[] { VcmsCategory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VcmsCategoryClp clone = new VcmsCategoryClp();

		clone.setCategoryId(getCategoryId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreatedDate(getCreatedDate());
		clone.setCreatedByUser(getCreatedByUser());
		clone.setModifiedDate(getModifiedDate());
		clone.setModifiedByUser(getModifiedByUser());
		clone.setPortionId(getPortionId());
		clone.setParentId(getParentId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setAnchored(getAnchored());
		clone.setHref(getHref());
		clone.setLanguage(getLanguage());
		clone.setHasImage(getHasImage());
		clone.setImage(getImage());
		clone.setPosition(getPosition());
		clone.setUserHit(getUserHit());
		clone.setRssable(getRssable());

		return clone;
	}

	public int compareTo(VcmsCategory vcmsCategory) {
		int value = 0;

		if (getPosition() < vcmsCategory.getPosition()) {
			value = -1;
		}
		else if (getPosition() > vcmsCategory.getPosition()) {
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

		VcmsCategoryClp vcmsCategory = null;

		try {
			vcmsCategory = (VcmsCategoryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = vcmsCategory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{categoryId=");
		sb.append(getCategoryId());
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
		sb.append(", portionId=");
		sb.append(getPortionId());
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
		sb.append(", hasImage=");
		sb.append(getHasImage());
		sb.append(", image=");
		sb.append(getImage());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", userHit=");
		sb.append(getUserHit());
		sb.append(", rssable=");
		sb.append(getRssable());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcms.model.VcmsCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
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
			"<column><column-name>portionId</column-name><column-value><![CDATA[");
		sb.append(getPortionId());
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
			"<column><column-name>hasImage</column-name><column-value><![CDATA[");
		sb.append(getHasImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>image</column-name><column-value><![CDATA[");
		sb.append(getImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userHit</column-name><column-value><![CDATA[");
		sb.append(getUserHit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rssable</column-name><column-value><![CDATA[");
		sb.append(getRssable());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _categoryId;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private String _createdByUser;
	private Date _modifiedDate;
	private String _modifiedByUser;
	private String _portionId;
	private String _parentId;
	private String _name;
	private String _description;
	private boolean _anchored;
	private String _href;
	private String _language;
	private boolean _hasImage;
	private String _image;
	private long _position;
	private long _userHit;
	private boolean _rssable;
}