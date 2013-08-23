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

package com.vportal.portlet.vfaq.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.vportal.portlet.vfaq.service.FAQCategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author DucNN
 */
public class FAQCategoryClp extends BaseModelImpl<FAQCategory>
	implements FAQCategory {
	public FAQCategoryClp() {
	}

	public Class<?> getModelClass() {
		return FAQCategory.class;
	}

	public String getModelClassName() {
		return FAQCategory.class.getName();
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

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public long getParent() {
		return _parent;
	}

	public void setParent(long parent) {
		_parent = parent;
	}

	public long getCatorder() {
		return _catorder;
	}

	public void setCatorder(long catorder) {
		_catorder = catorder;
	}

	public long getCatlevel() {
		return _catlevel;
	}

	public void setCatlevel(long catlevel) {
		_catlevel = catlevel;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public String getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public String getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(String modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			FAQCategoryLocalServiceUtil.addFAQCategory(this);
		}
		else {
			FAQCategoryLocalServiceUtil.updateFAQCategory(this);
		}
	}

	@Override
	public FAQCategory toEscapedModel() {
		return (FAQCategory)Proxy.newProxyInstance(FAQCategory.class.getClassLoader(),
			new Class[] { FAQCategory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FAQCategoryClp clone = new FAQCategoryClp();

		clone.setId(getId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setLanguage(getLanguage());
		clone.setParent(getParent());
		clone.setCatorder(getCatorder());
		clone.setCatlevel(getCatlevel());
		clone.setImage(getImage());
		clone.setCreatedByUser(getCreatedByUser());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedByUser(getModifiedByUser());
		clone.setModifiedDate(getModifiedDate());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(FAQCategory faqCategory) {
		int value = 0;

		value = DateUtil.compareTo(getCreatedDate(),
				faqCategory.getCreatedDate());

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

		FAQCategoryClp faqCategory = null;

		try {
			faqCategory = (FAQCategoryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = faqCategory.getPrimaryKey();

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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", parent=");
		sb.append(getParent());
		sb.append(", catorder=");
		sb.append(getCatorder());
		sb.append(", catlevel=");
		sb.append(getCatlevel());
		sb.append(", image=");
		sb.append(getImage());
		sb.append(", createdByUser=");
		sb.append(getCreatedByUser());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedByUser=");
		sb.append(getModifiedByUser());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vfaq.model.FAQCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
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
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parent</column-name><column-value><![CDATA[");
		sb.append(getParent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catorder</column-name><column-value><![CDATA[");
		sb.append(getCatorder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catlevel</column-name><column-value><![CDATA[");
		sb.append(getCatlevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>image</column-name><column-value><![CDATA[");
		sb.append(getImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUser</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedByUser</column-name><column-value><![CDATA[");
		sb.append(getModifiedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _name;
	private String _description;
	private String _language;
	private long _parent;
	private long _catorder;
	private long _catlevel;
	private String _image;
	private String _createdByUser;
	private Date _createdDate;
	private String _modifiedByUser;
	private Date _modifiedDate;
	private long _groupId;
	private long _userId;
	private String _userUuid;
}