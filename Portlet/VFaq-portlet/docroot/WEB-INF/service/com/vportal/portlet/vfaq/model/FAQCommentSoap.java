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
public class FAQCommentSoap implements Serializable {
	public static FAQCommentSoap toSoapModel(FAQComment model) {
		FAQCommentSoap soapModel = new FAQCommentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setAnswerid(model.getAnswerid());
		soapModel.setContent(model.getContent());
		soapModel.setCommName(model.getCommName());
		soapModel.setCommEmail(model.getCommEmail());
		soapModel.setApproved(model.getApproved());
		soapModel.setApproveByUser(model.getApproveByUser());
		soapModel.setApprovedDate(model.getApprovedDate());
		soapModel.setCommDate(model.getCommDate());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static FAQCommentSoap[] toSoapModels(FAQComment[] models) {
		FAQCommentSoap[] soapModels = new FAQCommentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FAQCommentSoap[][] toSoapModels(FAQComment[][] models) {
		FAQCommentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FAQCommentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FAQCommentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FAQCommentSoap[] toSoapModels(List<FAQComment> models) {
		List<FAQCommentSoap> soapModels = new ArrayList<FAQCommentSoap>(models.size());

		for (FAQComment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FAQCommentSoap[soapModels.size()]);
	}

	public FAQCommentSoap() {
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

	public long getAnswerid() {
		return _answerid;
	}

	public void setAnswerid(long answerid) {
		_answerid = answerid;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getCommName() {
		return _commName;
	}

	public void setCommName(String commName) {
		_commName = commName;
	}

	public String getCommEmail() {
		return _commEmail;
	}

	public void setCommEmail(String commEmail) {
		_commEmail = commEmail;
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

	public String getApproveByUser() {
		return _approveByUser;
	}

	public void setApproveByUser(String approveByUser) {
		_approveByUser = approveByUser;
	}

	public Date getApprovedDate() {
		return _approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		_approvedDate = approvedDate;
	}

	public Date getCommDate() {
		return _commDate;
	}

	public void setCommDate(Date commDate) {
		_commDate = commDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private String _uuid;
	private long _id;
	private long _answerid;
	private String _content;
	private String _commName;
	private String _commEmail;
	private boolean _approved;
	private String _approveByUser;
	private Date _approvedDate;
	private Date _commDate;
	private long _userId;
}