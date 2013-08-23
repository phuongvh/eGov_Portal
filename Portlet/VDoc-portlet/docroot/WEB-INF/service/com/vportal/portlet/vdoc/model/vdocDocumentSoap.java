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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vdoc.service.http.vdocDocumentServiceSoap}.
 *
 * @author    MrEn
 * @see       com.vportal.portlet.vdoc.service.http.vdocDocumentServiceSoap
 * @generated
 */
public class vdocDocumentSoap implements Serializable {
	public static vdocDocumentSoap toSoapModel(vdocDocument model) {
		vdocDocumentSoap soapModel = new vdocDocumentSoap();

		soapModel.setDocId(model.getDocId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApprovedByUser(model.getApprovedByUser());
		soapModel.setApprovedDate(model.getApprovedDate());
		soapModel.setPublishedByUser(model.getPublishedByUser());
		soapModel.setPublishedDate(model.getPublishedDate());
		soapModel.setPromulDate(model.getPromulDate());
		soapModel.setEffectivedDate(model.getEffectivedDate());
		soapModel.setExpiredDate(model.getExpiredDate());
		soapModel.setReplaceDoc(model.getReplaceDoc());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setProcess(model.getProcess());
		soapModel.setBase(model.getBase());
		soapModel.setTime(model.getTime());
		soapModel.setCost(model.getCost());
		soapModel.setRequire(model.getRequire());
		soapModel.setResult(model.getResult());
		soapModel.setObjects(model.getObjects());
		soapModel.setStyle(model.getStyle());
		soapModel.setPosition(model.getPosition());
		soapModel.setNote(model.getNote());
		soapModel.setUserHit(model.getUserHit());
		soapModel.setStatusDoc(model.getStatusDoc());
		soapModel.setTypeDoc(model.getTypeDoc());
		soapModel.setHasAttachment(model.getHasAttachment());
		soapModel.setFieldId(model.getFieldId());
		soapModel.setOrgRels(model.getOrgRels());
		soapModel.setFieldRels(model.getFieldRels());

		return soapModel;
	}

	public static vdocDocumentSoap[] toSoapModels(vdocDocument[] models) {
		vdocDocumentSoap[] soapModels = new vdocDocumentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static vdocDocumentSoap[][] toSoapModels(vdocDocument[][] models) {
		vdocDocumentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new vdocDocumentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new vdocDocumentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static vdocDocumentSoap[] toSoapModels(List<vdocDocument> models) {
		List<vdocDocumentSoap> soapModels = new ArrayList<vdocDocumentSoap>(models.size());

		for (vdocDocument model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new vdocDocumentSoap[soapModels.size()]);
	}

	public vdocDocumentSoap() {
	}

	public String getPrimaryKey() {
		return _docId;
	}

	public void setPrimaryKey(String pk) {
		setDocId(pk);
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

	private String _docId;
	private long _groupId;
	private String _language;
	private long _companyId;
	private long _userId;
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