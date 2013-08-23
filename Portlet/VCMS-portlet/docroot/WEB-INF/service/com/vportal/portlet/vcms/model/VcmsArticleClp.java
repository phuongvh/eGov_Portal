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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.vportal.portlet.vcms.service.VcmsArticleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author hai
 */
public class VcmsArticleClp extends BaseModelImpl<VcmsArticle>
	implements VcmsArticle {
	public VcmsArticleClp() {
	}

	public Class<?> getModelClass() {
		return VcmsArticle.class;
	}

	public String getModelClassName() {
		return VcmsArticle.class.getName();
	}

	public String getPrimaryKey() {
		return _articleId;
	}

	public void setPrimaryKey(String primaryKey) {
		setArticleId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _articleId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			VcmsArticleLocalServiceUtil.addVcmsArticle(this);
		}
		else {
			VcmsArticleLocalServiceUtil.updateVcmsArticle(this);
		}
	}

	@Override
	public VcmsArticle toEscapedModel() {
		return (VcmsArticle)Proxy.newProxyInstance(VcmsArticle.class.getClassLoader(),
			new Class[] { VcmsArticle.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VcmsArticleClp clone = new VcmsArticleClp();

		clone.setArticleId(getArticleId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreatedByUser(getCreatedByUser());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedByUser(getModifiedByUser());
		clone.setModifiedDate(getModifiedDate());
		clone.setApprovedByUser(getApprovedByUser());
		clone.setApprovedDate(getApprovedDate());
		clone.setPublishedByUser(getPublishedByUser());
		clone.setPublishedDate(getPublishedDate());
		clone.setStatus(getStatus());
		clone.setTitle(getTitle());
		clone.setLead(getLead());
		clone.setContent(getContent());
		clone.setHasImage(getHasImage());
		clone.setImageTitle(getImageTitle());
		clone.setImage(getImage());
		clone.setAuthor(getAuthor());
		clone.setSource(getSource());
		clone.setLanguage(getLanguage());
		clone.setUserHit(getUserHit());
		clone.setDiscussible(getDiscussible());
		clone.setHasAttachment(getHasAttachment());
		clone.setHasPoll(getHasPoll());
		clone.setPollId(getPollId());
		clone.setEffectiveDate(getEffectiveDate());
		clone.setExpireDate(getExpireDate());
		clone.setSticky(getSticky());
		clone.setStickyNeverExpired(getStickyNeverExpired());
		clone.setStickyExpireDate(getStickyExpireDate());

		return clone;
	}

	public int compareTo(VcmsArticle vcmsArticle) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				vcmsArticle.getModifiedDate());

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

		VcmsArticleClp vcmsArticle = null;

		try {
			vcmsArticle = (VcmsArticleClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = vcmsArticle.getPrimaryKey();

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
		StringBundler sb = new StringBundler(63);

		sb.append("{articleId=");
		sb.append(getArticleId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
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
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", lead=");
		sb.append(getLead());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", hasImage=");
		sb.append(getHasImage());
		sb.append(", imageTitle=");
		sb.append(getImageTitle());
		sb.append(", image=");
		sb.append(getImage());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", source=");
		sb.append(getSource());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", userHit=");
		sb.append(getUserHit());
		sb.append(", discussible=");
		sb.append(getDiscussible());
		sb.append(", hasAttachment=");
		sb.append(getHasAttachment());
		sb.append(", hasPoll=");
		sb.append(getHasPoll());
		sb.append(", pollId=");
		sb.append(getPollId());
		sb.append(", effectiveDate=");
		sb.append(getEffectiveDate());
		sb.append(", expireDate=");
		sb.append(getExpireDate());
		sb.append(", sticky=");
		sb.append(getSticky());
		sb.append(", stickyNeverExpired=");
		sb.append(getStickyNeverExpired());
		sb.append(", stickyExpireDate=");
		sb.append(getStickyExpireDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(97);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcms.model.VcmsArticle");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lead</column-name><column-value><![CDATA[");
		sb.append(getLead());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasImage</column-name><column-value><![CDATA[");
		sb.append(getHasImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageTitle</column-name><column-value><![CDATA[");
		sb.append(getImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>image</column-name><column-value><![CDATA[");
		sb.append(getImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>source</column-name><column-value><![CDATA[");
		sb.append(getSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userHit</column-name><column-value><![CDATA[");
		sb.append(getUserHit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discussible</column-name><column-value><![CDATA[");
		sb.append(getDiscussible());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasAttachment</column-name><column-value><![CDATA[");
		sb.append(getHasAttachment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasPoll</column-name><column-value><![CDATA[");
		sb.append(getHasPoll());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pollId</column-name><column-value><![CDATA[");
		sb.append(getPollId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectiveDate</column-name><column-value><![CDATA[");
		sb.append(getEffectiveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expireDate</column-name><column-value><![CDATA[");
		sb.append(getExpireDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sticky</column-name><column-value><![CDATA[");
		sb.append(getSticky());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stickyNeverExpired</column-name><column-value><![CDATA[");
		sb.append(getStickyNeverExpired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stickyExpireDate</column-name><column-value><![CDATA[");
		sb.append(getStickyExpireDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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