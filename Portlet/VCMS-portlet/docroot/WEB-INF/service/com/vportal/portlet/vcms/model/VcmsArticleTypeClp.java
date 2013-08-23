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

import com.vportal.portlet.vcms.service.VcmsArticleTypeLocalServiceUtil;
import com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author hai
 */
public class VcmsArticleTypeClp extends BaseModelImpl<VcmsArticleType>
	implements VcmsArticleType {
	public VcmsArticleTypeClp() {
	}

	public Class<?> getModelClass() {
		return VcmsArticleType.class;
	}

	public String getModelClassName() {
		return VcmsArticleType.class.getName();
	}

	public VcmsArticleTypePK getPrimaryKey() {
		return new VcmsArticleTypePK(_typeId, _articleId);
	}

	public void setPrimaryKey(VcmsArticleTypePK primaryKey) {
		setTypeId(primaryKey.typeId);
		setArticleId(primaryKey.articleId);
	}

	public Serializable getPrimaryKeyObj() {
		return new VcmsArticleTypePK(_typeId, _articleId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VcmsArticleTypePK)primaryKeyObj);
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	public long getPosition() {
		return _position;
	}

	public void setPosition(long position) {
		_position = position;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VcmsArticleTypeLocalServiceUtil.addVcmsArticleType(this);
		}
		else {
			VcmsArticleTypeLocalServiceUtil.updateVcmsArticleType(this);
		}
	}

	@Override
	public VcmsArticleType toEscapedModel() {
		return (VcmsArticleType)Proxy.newProxyInstance(VcmsArticleType.class.getClassLoader(),
			new Class[] { VcmsArticleType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VcmsArticleTypeClp clone = new VcmsArticleTypeClp();

		clone.setTypeId(getTypeId());
		clone.setArticleId(getArticleId());
		clone.setPosition(getPosition());

		return clone;
	}

	public int compareTo(VcmsArticleType vcmsArticleType) {
		int value = 0;

		if (getPosition() < vcmsArticleType.getPosition()) {
			value = -1;
		}
		else if (getPosition() > vcmsArticleType.getPosition()) {
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

		VcmsArticleTypeClp vcmsArticleType = null;

		try {
			vcmsArticleType = (VcmsArticleTypeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		VcmsArticleTypePK primaryKey = vcmsArticleType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{typeId=");
		sb.append(getTypeId());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcms.model.VcmsArticleType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _typeId;
	private String _articleId;
	private long _position;
}