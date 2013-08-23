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
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsArticleServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsArticleServiceSoap
 * @generated
 */
public class VcmsArticleSoap implements Serializable {
	public static VcmsArticleSoap toSoapModel(VcmsArticle model) {
		VcmsArticleSoap soapModel = new VcmsArticleSoap();

		soapModel.setArticleId(model.getArticleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApprovedByUser(model.getApprovedByUser());
		soapModel.setApprovedDate(model.getApprovedDate());
		soapModel.setPublishedByUser(model.getPublishedByUser());
		soapModel.setPublishedDate(model.getPublishedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setTitle(model.getTitle());
		soapModel.setLead(model.getLead());
		soapModel.setContent(model.getContent());
		soapModel.setHasImage(model.getHasImage());
		soapModel.setImageTitle(model.getImageTitle());
		soapModel.setImage(model.getImage());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setSource(model.getSource());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setUserHit(model.getUserHit());
		soapModel.setDiscussible(model.getDiscussible());
		soapModel.setHasAttachment(model.getHasAttachment());
		soapModel.setHasPoll(model.getHasPoll());
		soapModel.setPollId(model.getPollId());
		soapModel.setEffectiveDate(model.getEffectiveDate());
		soapModel.setExpireDate(model.getExpireDate());
		soapModel.setSticky(model.getSticky());
		soapModel.setStickyNeverExpired(model.getStickyNeverExpired());
		soapModel.setStickyExpireDate(model.getStickyExpireDate());

		return soapModel;
	}

	public static VcmsArticleSoap[] toSoapModels(VcmsArticle[] models) {
		VcmsArticleSoap[] soapModels = new VcmsArticleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsArticleSoap[][] toSoapModels(VcmsArticle[][] models) {
		VcmsArticleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsArticleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsArticleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsArticleSoap[] toSoapModels(List<VcmsArticle> models) {
		List<VcmsArticleSoap> soapModels = new ArrayList<VcmsArticleSoap>(models.size());

		for (VcmsArticle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsArticleSoap[soapModels.size()]);
	}

	public VcmsArticleSoap() {
	}

	public String getPrimaryKey() {
		return _articleId;
	}

	public void setPrimaryKey(String pk) {
		setArticleId(pk);
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
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

	public String getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
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

	public String getPublishedByUser() {
		return _publishedByUser;
	}

	public void setPublishedByUser(String publishedByUser) {
		_publishedByUser = publishedByUser;
	}

	public Date getPublishedDate() {
		return _publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		_publishedDate = publishedDate;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getLead() {
		return _lead;
	}

	public void setLead(String lead) {
		_lead = lead;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public boolean getHasImage() {
		return _hasImage;
	}

	public boolean isHasImage() {
		return _hasImage;
	}

	public void setHasImage(boolean hasImage) {
		_hasImage = hasImage;
	}

	public String getImageTitle() {
		return _imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public String getSource() {
		return _source;
	}

	public void setSource(String source) {
		_source = source;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public long getUserHit() {
		return _userHit;
	}

	public void setUserHit(long userHit) {
		_userHit = userHit;
	}

	public boolean getDiscussible() {
		return _discussible;
	}

	public boolean isDiscussible() {
		return _discussible;
	}

	public void setDiscussible(boolean discussible) {
		_discussible = discussible;
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

	public boolean getHasPoll() {
		return _hasPoll;
	}

	public boolean isHasPoll() {
		return _hasPoll;
	}

	public void setHasPoll(boolean hasPoll) {
		_hasPoll = hasPoll;
	}

	public String getPollId() {
		return _pollId;
	}

	public void setPollId(String pollId) {
		_pollId = pollId;
	}

	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	public Date getExpireDate() {
		return _expireDate;
	}

	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;
	}

	public boolean getSticky() {
		return _sticky;
	}

	public boolean isSticky() {
		return _sticky;
	}

	public void setSticky(boolean sticky) {
		_sticky = sticky;
	}

	public boolean getStickyNeverExpired() {
		return _stickyNeverExpired;
	}

	public boolean isStickyNeverExpired() {
		return _stickyNeverExpired;
	}

	public void setStickyNeverExpired(boolean stickyNeverExpired) {
		_stickyNeverExpired = stickyNeverExpired;
	}

	public Date getStickyExpireDate() {
		return _stickyExpireDate;
	}

	public void setStickyExpireDate(Date stickyExpireDate) {
		_stickyExpireDate = stickyExpireDate;
	}

	private String _articleId;
	private long _groupId;
	private long _companyId;
	private String _createdByUser;
	private Date _createdDate;
	private String _modifiedByUser;
	private Date _modifiedDate;
	private String _approvedByUser;
	private Date _approvedDate;
	private String _publishedByUser;
	private Date _publishedDate;
	private long _status;
	private String _title;
	private String _lead;
	private String _content;
	private boolean _hasImage;
	private String _imageTitle;
	private String _image;
	private String _author;
	private String _source;
	private String _language;
	private long _userHit;
	private boolean _discussible;
	private boolean _hasAttachment;
	private boolean _hasPoll;
	private String _pollId;
	private Date _effectiveDate;
	private Date _expireDate;
	private boolean _sticky;
	private boolean _stickyNeverExpired;
	private Date _stickyExpireDate;
}