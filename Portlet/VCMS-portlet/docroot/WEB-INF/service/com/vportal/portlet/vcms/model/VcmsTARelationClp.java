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

import com.vportal.portlet.vcms.service.VcmsTARelationLocalServiceUtil;
import com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author hai
 */
public class VcmsTARelationClp extends BaseModelImpl<VcmsTARelation>
	implements VcmsTARelation {
	public VcmsTARelationClp() {
	}

	public Class<?> getModelClass() {
		return VcmsTARelation.class;
	}

	public String getModelClassName() {
		return VcmsTARelation.class.getName();
	}

	public VcmsTARelationPK getPrimaryKey() {
		return new VcmsTARelationPK(_threadId, _articleId);
	}

	public void setPrimaryKey(VcmsTARelationPK primaryKey) {
		setThreadId(primaryKey.threadId);
		setArticleId(primaryKey.articleId);
	}

	public Serializable getPrimaryKeyObj() {
		return new VcmsTARelationPK(_threadId, _articleId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VcmsTARelationPK)primaryKeyObj);
	}

	public String getThreadId() {
		return _threadId;
	}

	public void setThreadId(String threadId) {
		_threadId = threadId;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VcmsTARelationLocalServiceUtil.addVcmsTARelation(this);
		}
		else {
			VcmsTARelationLocalServiceUtil.updateVcmsTARelation(this);
		}
	}

	@Override
	public VcmsTARelation toEscapedModel() {
		return (VcmsTARelation)Proxy.newProxyInstance(VcmsTARelation.class.getClassLoader(),
			new Class[] { VcmsTARelation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VcmsTARelationClp clone = new VcmsTARelationClp();

		clone.setThreadId(getThreadId());
		clone.setArticleId(getArticleId());

		return clone;
	}

	public int compareTo(VcmsTARelation vcmsTARelation) {
		int value = 0;

		value = getArticleId().compareTo(vcmsTARelation.getArticleId());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getThreadId().compareTo(vcmsTARelation.getThreadId());

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

		VcmsTARelationClp vcmsTARelation = null;

		try {
			vcmsTARelation = (VcmsTARelationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		VcmsTARelationPK primaryKey = vcmsTARelation.getPrimaryKey();

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

		sb.append("{threadId=");
		sb.append(getThreadId());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcms.model.VcmsTARelation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>threadId</column-name><column-value><![CDATA[");
		sb.append(getThreadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _threadId;
	private String _articleId;
}