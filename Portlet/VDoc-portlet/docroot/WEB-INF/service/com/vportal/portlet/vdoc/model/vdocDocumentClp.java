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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author MrEn
 */
public class vdocDocumentClp extends BaseModelImpl<vdocDocument>
	implements vdocDocument {
	public vdocDocumentClp() {
	}

	public Class<?> getModelClass() {
		return vdocDocument.class;
	}

	public String getModelClassName() {
		return vdocDocument.class.getName();
	}

	public String getPrimaryKey() {
		return _docId;
	}

	public void setPrimaryKey(String primaryKey) {
		setDocId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _docId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	public String getDocId() {
		return _docId;
	}

	public void setDocId(String docId) {
		_docId = docId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getApprovedByUser() {
		return _approvedByUser;
	}

	public void setApprovedByUser(long approvedByUser) {
		_approvedByUser = approvedByUser;
	}

	public Date getApprovedDate() {
		return _approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		_approvedDate = approvedDate;
	}

	public long getPublishedByUser() {
		return _publishedByUser;
	}

	public void setPublishedByUser(long publishedByUser) {
		_publishedByUser = publishedByUser;
	}

	public Date getPublishedDate() {
		return _publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		_publishedDate = publishedDate;
	}

	public Date getPromulDate() {
		return _promulDate;
	}

	public void setPromulDate(Date promulDate) {
		_promulDate = promulDate;
	}

	public Date getEffectivedDate() {
		return _effectivedDate;
	}

	public void setEffectivedDate(Date effectivedDate) {
		_effectivedDate = effectivedDate;
	}

	public Date getExpiredDate() {
		return _expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
	}

	public String getReplaceDoc() {
		return _replaceDoc;
	}

	public void setReplaceDoc(String replaceDoc) {
		_replaceDoc = replaceDoc;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getProcess() {
		return _process;
	}

	public void setProcess(String process) {
		_process = process;
	}

	public String getBase() {
		return _base;
	}

	public void setBase(String base) {
		_base = base;
	}

	public String getTime() {
		return _time;
	}

	public void setTime(String time) {
		_time = time;
	}

	public String getCost() {
		return _cost;
	}

	public void setCost(String cost) {
		_cost = cost;
	}

	public String getRequire() {
		return _require;
	}

	public void setRequire(String require) {
		_require = require;
	}

	public String getResult() {
		return _result;
	}

	public void setResult(String result) {
		_result = result;
	}

	public String getObjects() {
		return _objects;
	}

	public void setObjects(String objects) {
		_objects = objects;
	}

	public String getStyle() {
		return _style;
	}

	public void setStyle(String style) {
		_style = style;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_position = position;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public int getUserHit() {
		return _userHit;
	}

	public void setUserHit(int userHit) {
		_userHit = userHit;
	}

	public int getStatusDoc() {
		return _statusDoc;
	}

	public void setStatusDoc(int statusDoc) {
		_statusDoc = statusDoc;
	}

	public int getTypeDoc() {
		return _typeDoc;
	}

	public void setTypeDoc(int typeDoc) {
		_typeDoc = typeDoc;
	}

	public boolean getHasAttachment() {
		return _hasAttachment;
	}

	public boolean isHasAttachment() {
		return _hasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		_hasAttachment = hasAttachment;
	}

	public String getFieldId() {
		return _fieldId;
	}

	public void setFieldId(String fieldId) {
		_fieldId = fieldId;
	}

	public String getOrgRels() {
		return _orgRels;
	}

	public void setOrgRels(String orgRels) {
		_orgRels = orgRels;
	}

	public String getFieldRels() {
		return _fieldRels;
	}

	public void setFieldRels(String fieldRels) {
		_fieldRels = fieldRels;
	}

	@Override
	public vdocDocument toEscapedModel() {
		return (vdocDocument)Proxy.newProxyInstance(vdocDocument.class.getClassLoader(),
			new Class[] { vdocDocument.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		vdocDocumentClp clone = new vdocDocumentClp();

		clone.setDocId(getDocId());
		clone.setGroupId(getGroupId());
		clone.setLanguage(getLanguage());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedByUser(getCreatedByUser());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedByUser(getModifiedByUser());
		clone.setModifiedDate(getModifiedDate());
		clone.setApprovedByUser(getApprovedByUser());
		clone.setApprovedDate(getApprovedDate());
		clone.setPublishedByUser(getPublishedByUser());
		clone.setPublishedDate(getPublishedDate());
		clone.setPromulDate(getPromulDate());
		clone.setEffectivedDate(getEffectivedDate());
		clone.setExpiredDate(getExpiredDate());
		clone.setReplaceDoc(getReplaceDoc());
		clone.setTitle(getTitle());
		clone.setContent(getContent());
		clone.setProcess(getProcess());
		clone.setBase(getBase());
		clone.setTime(getTime());
		clone.setCost(getCost());
		clone.setRequire(getRequire());
		clone.setResult(getResult());
		clone.setObjects(getObjects());
		clone.setStyle(getStyle());
		clone.setPosition(getPosition());
		clone.setNote(getNote());
		clone.setUserHit(getUserHit());
		clone.setStatusDoc(getStatusDoc());
		clone.setTypeDoc(getTypeDoc());
		clone.setHasAttachment(getHasAttachment());
		clone.setFieldId(getFieldId());
		clone.setOrgRels(getOrgRels());
		clone.setFieldRels(getFieldRels());

		return clone;
	}

	public int compareTo(vdocDocument vdocDocument) {
		int value = 0;

		if (getPosition() < vdocDocument.getPosition()) {
			value = -1;
		}
		else if (getPosition() > vdocDocument.getPosition()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		vdocDocumentClp vdocDocument = null;

		try {
			vdocDocument = (vdocDocumentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = vdocDocument.getPrimaryKey();

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
		StringBundler sb = new StringBundler(73);

		sb.append("{docId=");
		sb.append(getDocId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdByUser=");
		sb.append(getCreatedByUser());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedByUser=");
		sb.append(getModifiedByUser());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", approvedByUser=");
		sb.append(getApprovedByUser());
		sb.append(", approvedDate=");
		sb.append(getApprovedDate());
		sb.append(", publishedByUser=");
		sb.append(getPublishedByUser());
		sb.append(", publishedDate=");
		sb.append(getPublishedDate());
		sb.append(", promulDate=");
		sb.append(getPromulDate());
		sb.append(", effectivedDate=");
		sb.append(getEffectivedDate());
		sb.append(", expiredDate=");
		sb.append(getExpiredDate());
		sb.append(", replaceDoc=");
		sb.append(getReplaceDoc());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", process=");
		sb.append(getProcess());
		sb.append(", base=");
		sb.append(getBase());
		sb.append(", time=");
		sb.append(getTime());
		sb.append(", cost=");
		sb.append(getCost());
		sb.append(", require=");
		sb.append(getRequire());
		sb.append(", result=");
		sb.append(getResult());
		sb.append(", objects=");
		sb.append(getObjects());
		sb.append(", style=");
		sb.append(getStyle());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", userHit=");
		sb.append(getUserHit());
		sb.append(", statusDoc=");
		sb.append(getStatusDoc());
		sb.append(", typeDoc=");
		sb.append(getTypeDoc());
		sb.append(", hasAttachment=");
		sb.append(getHasAttachment());
		sb.append(", fieldId=");
		sb.append(getFieldId());
		sb.append(", orgRels=");
		sb.append(getOrgRels());
		sb.append(", fieldRels=");
		sb.append(getFieldRels());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(112);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vdoc.model.vdocDocument");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>docId</column-name><column-value><![CDATA[");
		sb.append(getDocId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>approvedByUser</column-name><column-value><![CDATA[");
		sb.append(getApprovedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedDate</column-name><column-value><![CDATA[");
		sb.append(getApprovedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishedByUser</column-name><column-value><![CDATA[");
		sb.append(getPublishedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishedDate</column-name><column-value><![CDATA[");
		sb.append(getPublishedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promulDate</column-name><column-value><![CDATA[");
		sb.append(getPromulDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectivedDate</column-name><column-value><![CDATA[");
		sb.append(getEffectivedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredDate</column-name><column-value><![CDATA[");
		sb.append(getExpiredDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>replaceDoc</column-name><column-value><![CDATA[");
		sb.append(getReplaceDoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>process</column-name><column-value><![CDATA[");
		sb.append(getProcess());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>base</column-name><column-value><![CDATA[");
		sb.append(getBase());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>time</column-name><column-value><![CDATA[");
		sb.append(getTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cost</column-name><column-value><![CDATA[");
		sb.append(getCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>require</column-name><column-value><![CDATA[");
		sb.append(getRequire());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>result</column-name><column-value><![CDATA[");
		sb.append(getResult());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objects</column-name><column-value><![CDATA[");
		sb.append(getObjects());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>style</column-name><column-value><![CDATA[");
		sb.append(getStyle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userHit</column-name><column-value><![CDATA[");
		sb.append(getUserHit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDoc</column-name><column-value><![CDATA[");
		sb.append(getStatusDoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeDoc</column-name><column-value><![CDATA[");
		sb.append(getTypeDoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasAttachment</column-name><column-value><![CDATA[");
		sb.append(getHasAttachment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fieldId</column-name><column-value><![CDATA[");
		sb.append(getFieldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgRels</column-name><column-value><![CDATA[");
		sb.append(getOrgRels());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fieldRels</column-name><column-value><![CDATA[");
		sb.append(getFieldRels());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _docId;
	private long _groupId;
	private String _language;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _createdByUser;
	private Date _createdDate;
	private long _modifiedByUser;
	private Date _modifiedDate;
	private long _approvedByUser;
	private Date _approvedDate;
	private long _publishedByUser;
	private Date _publishedDate;
	private Date _promulDate;
	private Date _effectivedDate;
	private Date _expiredDate;
	private String _replaceDoc;
	private String _title;
	private String _content;
	private String _process;
	private String _base;
	private String _time;
	private String _cost;
	private String _require;
	private String _result;
	private String _objects;
	private String _style;
	private int _position;
	private String _note;
	private int _userHit;
	private int _statusDoc;
	private int _typeDoc;
	private boolean _hasAttachment;
	private String _fieldId;
	private String _orgRels;
	private String _fieldRels;
}