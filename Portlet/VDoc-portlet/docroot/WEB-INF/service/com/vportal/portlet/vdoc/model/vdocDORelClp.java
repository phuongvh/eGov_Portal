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

package com.vportal.portlet.vdoc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.vportal.portlet.vdoc.service.persistence.vdocDORelPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author MrEn
 */
public class vdocDORelClp extends BaseModelImpl<vdocDORel> implements vdocDORel {
	public vdocDORelClp() {
	}

	public Class<?> getModelClass() {
		return vdocDORel.class;
	}

	public String getModelClassName() {
		return vdocDORel.class.getName();
	}

	public vdocDORelPK getPrimaryKey() {
		return new vdocDORelPK(_docId, _orgId);
	}

	public void setPrimaryKey(vdocDORelPK primaryKey) {
		setDocId(primaryKey.docId);
		setOrgId(primaryKey.orgId);
	}

	public Serializable getPrimaryKeyObj() {
		return new vdocDORelPK(_docId, _orgId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((vdocDORelPK)primaryKeyObj);
	}

	public String getDocId() {
		return _docId;
	}

	public void setDocId(String docId) {
		_docId = docId;
	}

	public String getOrgId() {
		return _orgId;
	}

	public void setOrgId(String orgId) {
		_orgId = orgId;
	}

	@Override
	public vdocDORel toEscapedModel() {
		return (vdocDORel)Proxy.newProxyInstance(vdocDORel.class.getClassLoader(),
			new Class[] { vdocDORel.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		vdocDORelClp clone = new vdocDORelClp();

		clone.setDocId(getDocId());
		clone.setOrgId(getOrgId());

		return clone;
	}

	public int compareTo(vdocDORel vdocDORel) {
		int value = 0;

		value = getDocId().compareTo(vdocDORel.getDocId());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getOrgId().compareTo(vdocDORel.getOrgId());

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

		vdocDORelClp vdocDORel = null;

		try {
			vdocDORel = (vdocDORelClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		vdocDORelPK primaryKey = vdocDORel.getPrimaryKey();

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

		sb.append("{docId=");
		sb.append(getDocId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vdoc.model.vdocDORel");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>docId</column-name><column-value><![CDATA[");
		sb.append(getDocId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _docId;
	private String _orgId;
}