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

import com.vportal.portlet.vcms.service.VcmsDiscussionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author hai
 */
public class VcmsDiscussionClp extends BaseModelImpl<VcmsDiscussion>
	implements VcmsDiscussion {
	public VcmsDiscussionClp() {
	}

	public Class<?> getModelClass() {
		return VcmsDiscussion.class;
	}

	public String getModelClassName() {
		return VcmsDiscussion.class.getName();
	}

	public String getPrimaryKey() {
		return _discussionId;
	}

	public void setPrimaryKey(String primaryKey) {
		setDiscussionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _discussionId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			VcmsDiscussionLocalServiceUtil.addVcmsDiscussion(this);
		}
		else {
			VcmsDiscussionLocalServiceUtil.updateVcmsDiscussion(this);
		}
	}

	@Override
	public VcmsDiscussion toEscapedModel() {
		return (VcmsDiscussion)Proxy.newProxyInstance(VcmsDiscussion.class.getClassLoader(),
			new Class[] { VcmsDiscussion.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VcmsDiscussionClp clone = new VcmsDiscussionClp();

		clone.setDiscussionId(getDiscussionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setVisitorName(getVisitorName());
		clone.setVisitorEmail(getVisitorEmail());
		clone.setVisitorPhone(getVisitorPhone());
		clone.setPostedDate(getPostedDate());
		clone.setApproved(getApproved());
		clone.setApprovedByUser(getApprovedByUser());
		clone.setApprovedDate(getApprovedDate());
		clone.setArticleId(getArticleId());
		clone.setTitle(getTitle());
		clone.setContent(getContent());
		clone.setLanguage(getLanguage());
		clone.setHasAttachment(getHasAttachment());

		return clone;
	}

	public int compareTo(VcmsDiscussion vcmsDiscussion) {
		int value = 0;

		value = DateUtil.compareTo(getPostedDate(),
				vcmsDiscussion.getPostedDate());

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

		VcmsDiscussionClp vcmsDiscussion = null;

		try {
			vcmsDiscussion = (VcmsDiscussionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = vcmsDiscussion.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{discussionId=");
		sb.append(getDiscussionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", visitorName=");
		sb.append(getVisitorName());
		sb.append(", visitorEmail=");
		sb.append(getVisitorEmail());
		sb.append(", visitorPhone=");
		sb.append(getVisitorPhone());
		sb.append(", postedDate=");
		sb.append(getPostedDate());
		sb.append(", approved=");
		sb.append(getApproved());
		sb.append(", approvedByUser=");
		sb.append(getApprovedByUser());
		sb.append(", approvedDate=");
		sb.append(getApprovedDate());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", hasAttachment=");
		sb.append(getHasAttachment());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vcms.model.VcmsDiscussion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>discussionId</column-name><column-value><![CDATA[");
		sb.append(getDiscussionId());
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
			"<column><column-name>visitorName</column-name><column-value><![CDATA[");
		sb.append(getVisitorName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visitorEmail</column-name><column-value><![CDATA[");
		sb.append(getVisitorEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visitorPhone</column-name><column-value><![CDATA[");
		sb.append(getVisitorPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postedDate</column-name><column-value><![CDATA[");
		sb.append(getPostedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approved</column-name><column-value><![CDATA[");
		sb.append(getApproved());
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
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
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
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasAttachment</column-name><column-value><![CDATA[");
		sb.append(getHasAttachment());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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