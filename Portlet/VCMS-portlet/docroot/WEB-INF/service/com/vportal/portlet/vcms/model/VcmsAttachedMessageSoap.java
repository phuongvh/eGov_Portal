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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsAttachedMessageServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsAttachedMessageServiceSoap
 * @generated
 */
public class VcmsAttachedMessageSoap implements Serializable {
	public static VcmsAttachedMessageSoap toSoapModel(VcmsAttachedMessage model) {
		VcmsAttachedMessageSoap soapModel = new VcmsAttachedMessageSoap();

		soapModel.setMessageId(model.getMessageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setContent(model.getContent());
		soapModel.setReadMessage(model.getReadMessage());

		return soapModel;
	}

	public static VcmsAttachedMessageSoap[] toSoapModels(
		VcmsAttachedMessage[] models) {
		VcmsAttachedMessageSoap[] soapModels = new VcmsAttachedMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsAttachedMessageSoap[][] toSoapModels(
		VcmsAttachedMessage[][] models) {
		VcmsAttachedMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsAttachedMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsAttachedMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsAttachedMessageSoap[] toSoapModels(
		List<VcmsAttachedMessage> models) {
		List<VcmsAttachedMessageSoap> soapModels = new ArrayList<VcmsAttachedMessageSoap>(models.size());

		for (VcmsAttachedMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsAttachedMessageSoap[soapModels.size()]);
	}

	public VcmsAttachedMessageSoap() {
	}

	public String getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(String pk) {
		setMessageId(pk);
	}

	public String getMessageId() {
		return _messageId;
	}

	public void setMessageId(String messageId) {
		_messageId = messageId;
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

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public boolean getReadMessage() {
		return _readMessage;
	}

	public boolean isReadMessage() {
		return _readMessage;
	}

	public void setReadMessage(boolean readMessage) {
		_readMessage = readMessage;
	}

	private String _messageId;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private String _createdByUser;
	private String _articleId;
	private String _content;
	private boolean _readMessage;
}