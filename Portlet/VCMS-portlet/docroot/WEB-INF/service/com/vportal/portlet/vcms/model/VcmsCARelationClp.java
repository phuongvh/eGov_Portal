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

import com.vportal.portlet.vcms.service.VcmsCARelationLocalServiceUtil;
import com.vportal.portlet.vcms.service.persistence.VcmsCARelationPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author hai
 */
public class VcmsCARelationClp extends BaseModelImpl<VcmsCARelation>
	implements VcmsCARelation {
	public VcmsCARelationClp() {
	}

	public Class<?> getModelClass() {
		return VcmsCARelation.class;
	}

	public String getModelClassName() {
		return VcmsCARelation.class.getName();
	}

	public VcmsCARelationPK getPrimaryKey() {
		return new VcmsCARelationPK(_categoryId, _articleId);
	}

	public void setPrimaryKey(VcmsCARelationPK primaryKey) {
		setCategoryId(primaryKey.categoryId);
		setArticleId(primaryKey.articleId);
	}

	public Serializable getPrimaryKeyObj() {
		return new VcmsCARelationPK(_categoryId, _articleId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VcmsCARelationPK)primaryKeyObj);
	}

	public String getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(String categoryId) {
		_categoryId = categoryId;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
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

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VcmsCARelationLocalServiceUtil.addVcmsCARelation(this);
		}
		else {
			VcmsCARelationLocalServiceUtil.updateVcmsCARelation(this);
		}
	}

	@Override
	public VcmsCARelation toEscapedModel() {
		return (VcmsCARelation)Proxy.newProxyInstance(VcmsCARelation.class.getClassLoader(),
			new Class[] { VcmsCARelation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VcmsCARelationClp clone = new VcmsCARelationClp();

		clone.setCategoryId(getCategoryId());
		clone.setArticleId(getArticleId());
		clone.setCreatedDate(getCreatedDate());
		clone.setCreatedByUser(getCreatedByUser());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(VcmsCARelation vcmsCARelation) {
		int value = 0;

		value = getArticleId().compareTo(vcmsCARelation.getArticleId());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getCategoryId().compareTo(vcmsCARelation.getCategoryId());

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

		VcmsCARelationClp vcmsCARelation = null;

		try {
			vcmsCARelation = (VcmsCARelationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		VcmsCARelationPK primaryKey = vcmsCARelation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{categoryId=");
		sb.append(getCategoryId());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", createdByUser=");
		sb.append(getCreatedByUser());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcms.model.VcmsCARelation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _categoryId;
	private String _articleId;
	private Date _createdDate;
	private String _createdByUser;
	private long _status;
}