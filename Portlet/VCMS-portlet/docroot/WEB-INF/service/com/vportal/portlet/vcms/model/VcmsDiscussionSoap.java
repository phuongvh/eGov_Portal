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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsDiscussionServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsDiscussionServiceSoap
 * @generated
 */
public class VcmsDiscussionSoap implements Serializable {
	public static VcmsDiscussionSoap toSoapModel(VcmsDiscussion model) {
		VcmsDiscussionSoap soapModel = new VcmsDiscussionSoap();

		soapModel.setDiscussionId(model.getDiscussionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setVisitorName(model.getVisitorName());
		soapModel.setVisitorEmail(model.getVisitorEmail());
		soapModel.setVisitorPhone(model.getVisitorPhone());
		soapModel.setPostedDate(model.getPostedDate());
		soapModel.setApproved(model.getApproved());
		soapModel.setApprovedByUser(model.getApprovedByUser());
		soapModel.setApprovedDate(model.getApprovedDate());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setHasAttachment(model.getHasAttachment());

		return soapModel;
	}

	public static VcmsDiscussionSoap[] toSoapModels(VcmsDiscussion[] models) {
		VcmsDiscussionSoap[] soapModels = new VcmsDiscussionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsDiscussionSoap[][] toSoapModels(VcmsDiscussion[][] models) {
		VcmsDiscussionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsDiscussionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsDiscussionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsDiscussionSoap[] toSoapModels(List<VcmsDiscussion> models) {
		List<VcmsDiscussionSoap> soapModels = new ArrayList<VcmsDiscussionSoap>(models.size());

		for (VcmsDiscussion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsDiscussionSoap[soapModels.size()]);
	}

	public VcmsDiscussionSoap() {
	}

	public String getPrimaryKey() {
		return _discussionId;
	}

	public void setPrimaryKey(String pk) {
		setDiscussionId(pk);
	}

	public String getDiscussionId() {
		return _discussionId;
	}

	public void setDiscussionId(String discussionId) {
		_discussionId = discussionId;
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

	public String getVisitorName() {
		return _visitorName;
	}

	public void setVisitorName(String visitorName) {
		_visitorName = visitorName;
	}

	public String getVisitorEmail() {
		return _visitorEmail;
	}

	public void setVisitorEmail(String visitorEmail) {
		_visitorEmail = visitorEmail;
	}

	public String getVisitorPhone() {
		return _visitorPhone;
	}

	public void setVisitorPhone(String visitorPhone) {
		_visitorPhone = visitorPhone;
	}

	public Date getPostedDate() {
		return _postedDate;
	}

	public void setPostedDate(Date postedDate) {
		_postedDate = postedDate;
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

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
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

	public boolean getHasAttachment() {
		return _hasAttachment;
	}

	public boolean isHasAttachment() {
		return _hasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		_hasAttachment = hasAttachment;
	}

	private String _discussionId;
	private long _groupId;
	private long _companyId;
	private String _visitorName;
	private String _visitorEmail;
	private String _visitorPhone;
	private Date _postedDate;
	private boolean _approved;
	private String _approvedByUser;
	private Date _approvedDate;
	private String _articleId;
	private String _title;
	private String _content;
	private String _language;
	private boolean _hasAttachment;
}