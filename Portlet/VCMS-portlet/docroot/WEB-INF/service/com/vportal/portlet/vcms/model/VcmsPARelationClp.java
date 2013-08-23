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

import com.vportal.portlet.vcms.service.VcmsPARelationLocalServiceUtil;
import com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author hai
 */
public class VcmsPARelationClp extends BaseModelImpl<VcmsPARelation>
	implements VcmsPARelation {
	public VcmsPARelationClp() {
	}

	public Class<?> getModelClass() {
		return VcmsPARelation.class;
	}

	public String getModelClassName() {
		return VcmsPARelation.class.getName();
	}

	public VcmsPARelationPK getPrimaryKey() {
		return new VcmsPARelationPK(_portionId, _articleId);
	}

	public void setPrimaryKey(VcmsPARelationPK primaryKey) {
		setPortionId(primaryKey.portionId);
		setArticleId(primaryKey.articleId);
	}

	public Serializable getPrimaryKeyObj() {
		return new VcmsPARelationPK(_portionId, _articleId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VcmsPARelationPK)primaryKeyObj);
	}

	public String getPortionId() {
		return _portionId;
	}

	public void setPortionId(String portionId) {
		_portionId = portionId;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VcmsPARelationLocalServiceUtil.addVcmsPARelation(this);
		}
		else {
			VcmsPARelationLocalServiceUtil.updateVcmsPARelation(this);
		}
	}

	@Override
	public VcmsPARelation toEscapedModel() {
		return (VcmsPARelation)Proxy.newProxyInstance(VcmsPARelation.class.getClassLoader(),
			new Class[] { VcmsPARelation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VcmsPARelationClp clone = new VcmsPARelationClp();

		clone.setPortionId(getPortionId());
		clone.setArticleId(getArticleId());

		return clone;
	}

	public int compareTo(VcmsPARelation vcmsPARelation) {
		int value = 0;

		value = getArticleId().compareTo(vcmsPARelation.getArticleId());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getPortionId().compareTo(vcmsPARelation.getPortionId());

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

		VcmsPARelationClp vcmsPARelation = null;

		try {
			vcmsPARelation = (VcmsPARelationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		VcmsPARelationPK primaryKey = vcmsPARelation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{portionId=");
		sb.append(getPortionId());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcms.model.VcmsPARelation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>portionId</column-name><column-value><![CDATA[");
		sb.append(getPortionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _portionId;
	private String _articleId;
}