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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    DucNN
 * @generated
 */
public class FAQQuestionSoap implements Serializable {
	public static FAQQuestionSoap toSoapModel(FAQQuestion model) {
		FAQQuestionSoap soapModel = new FAQQuestionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setQuestionOrder(model.getQuestionOrder());
		soapModel.setSentDate(model.getSentDate());
		soapModel.setSentByUser(model.getSentByUser());
		soapModel.setSenderEmail(model.getSenderEmail());
		soapModel.setQuestionType(model.getQuestionType());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setHitCount(model.getHitCount());
		soapModel.setApproved(model.getApproved());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static FAQQuestionSoap[] toSoapModels(FAQQuestion[] models) {
		FAQQuestionSoap[] soapModels = new FAQQuestionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FAQQuestionSoap[][] toSoapModels(FAQQuestion[][] models) {
		FAQQuestionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FAQQuestionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FAQQuestionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FAQQuestionSoap[] toSoapModels(List<FAQQuestion> models) {
		List<FAQQuestionSoap> soapModels = new ArrayList<FAQQuestionSoap>(models.size());

		for (FAQQuestion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FAQQuestionSoap[soapModels.size()]);
	}

	public FAQQuestionSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public long getQuestionOrder() {
		return _questionOrder;
	}

	public void setQuestionOrder(long questionOrder) {
		_questionOrder = questionOrder;
	}

	public Date getSentDate() {
		return _sentDate;
	}

	public void setSentDate(Date sentDate) {
		_sentDate = sentDate;
	}

	public String getSentByUser() {
		return _sentByUser;
	}

	public void setSentByUser(String sentByUser) {
		_sentByUser = sentByUser;
	}

	public String getSenderEmail() {
		return _senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		_senderEmail = senderEmail;
	}

	public String getQuestionType() {
		return _questionType;
	}

	public void setQuestionType(String questionType) {
		_questionType = questionType;
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

	public long getHitCount() {
		return _hitCount;
	}

	public void setHitCount(long hitCount) {
		_hitCount = hitCount;
	}

	public boolean getApproved() {
		return _approved;
	}

	public boolean isApproved() {
		return _approved;
	}

	public void setApproved(boolean approved) {
		_approved = approved;
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

	private String _uuid;
	private long _id;
	private String _title;
	private String _content;
	private String _language;
	private long _questionOrder;
	private Date _sentDate;
	private String _sentByUser;
	private String _senderEmail;
	private String _questionType;
	private String _modifiedByUser;
	private Date _modifiedDate;
	private long _hitCount;
	private boolean _approved;
	private long _groupId;
	private long _userId;
}