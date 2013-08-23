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
public class FAQAnswerSoap implements Serializable {
	public static FAQAnswerSoap toSoapModel(FAQAnswer model) {
		FAQAnswerSoap soapModel = new FAQAnswerSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setQuestionid(model.getQuestionid());
		soapModel.setContent(model.getContent());
		soapModel.setAnswerOrder(model.getAnswerOrder());
		soapModel.setAnsweredByUser(model.getAnsweredByUser());
		soapModel.setAnsweredDate(model.getAnsweredDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApproved(model.getApproved());
		soapModel.setApprovedByUser(model.getApprovedByUser());
		soapModel.setApprovedDate(model.getApprovedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setAttachName(model.getAttachName());
		soapModel.setFolderId(model.getFolderId());

		return soapModel;
	}

	public static FAQAnswerSoap[] toSoapModels(FAQAnswer[] models) {
		FAQAnswerSoap[] soapModels = new FAQAnswerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FAQAnswerSoap[][] toSoapModels(FAQAnswer[][] models) {
		FAQAnswerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FAQAnswerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FAQAnswerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FAQAnswerSoap[] toSoapModels(List<FAQAnswer> models) {
		List<FAQAnswerSoap> soapModels = new ArrayList<FAQAnswerSoap>(models.size());

		for (FAQAnswer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FAQAnswerSoap[soapModels.size()]);
	}

	public FAQAnswerSoap() {
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

	public long getQuestionid() {
		return _questionid;
	}

	public void setQuestionid(long questionid) {
		_questionid = questionid;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getAnswerOrder() {
		return _answerOrder;
	}

	public void setAnswerOrder(long answerOrder) {
		_answerOrder = answerOrder;
	}

	public String getAnsweredByUser() {
		return _answeredByUser;
	}

	public void setAnsweredByUser(String answeredByUser) {
		_answeredByUser = answeredByUser;
	}

	public Date getAnsweredDate() {
		return _answeredDate;
	}

	public void setAnsweredDate(Date answeredDate) {
		_answeredDate = answeredDate;
	}

	public String getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(String modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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

	public String getApprovedByUser() {
		return _approvedByUser;
	}

	public void setApprovedByUser(String approvedByUser) {
		_approvedByUser = approvedByUser;
	}

	public Date getApprovedDate() {
		return _approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		_approvedDate = approvedDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getAttachName() {
		return _attachName;
	}

	public void setAttachName(String attachName) {
		_attachName = attachName;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	private String _uuid;
	private long _id;
	private long _questionid;
	private String _content;
	private long _answerOrder;
	private String _answeredByUser;
	private Date _answeredDate;
	private String _modifiedByUser;
	private String _language;
	private Date _modifiedDate;
	private boolean _approved;
	private String _approvedByUser;
	private Date _approvedDate;
	private long _userId;
	private String _attachName;
	private long _folderId;
}