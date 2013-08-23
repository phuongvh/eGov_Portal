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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.vportal.portlet.vfaq.service.FAQCommentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author DucNN
 */
public class FAQCommentClp extends BaseModelImpl<FAQComment>
	implements FAQComment {
	public FAQCommentClp() {
	}

	public Class<?> getModelClass() {
		return FAQComment.class;
	}

	public String getModelClassName() {
		return FAQComment.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			FAQCommentLocalServiceUtil.addFAQComment(this);
		}
		else {
			FAQCommentLocalServiceUtil.updateFAQComment(this);
		}
	}

	@Override
	public FAQComment toEscapedModel() {
		return (FAQComment)Proxy.newProxyInstance(FAQComment.class.getClassLoader(),
			new Class[] { FAQComment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FAQCommentClp clone = new FAQCommentClp();

		clone.setUuid(getUuid());
		clone.setId(getId());
		clone.setAnswerid(getAnswerid());
		clone.setContent(getContent());
		clone.setCommName(getCommName());
		clone.setCommEmail(getCommEmail());
		clone.setApproved(getApproved());
		clone.setApproveByUser(getApproveByUser());
		clone.setApprovedDate(getApprovedDate());
		clone.setCommDate(getCommDate());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(FAQComment faqComment) {
		int value = 0;

		value = DateUtil.compareTo(getCommDate(), faqComment.getCommDate());

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

		FAQCommentClp faqComment = null;

		try {
			faqComment = (FAQCommentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = faqComment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", answerid=");
		sb.append(getAnswerid());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", commName=");
		sb.append(getCommName());
		sb.append(", commEmail=");
		sb.append(getCommEmail());
		sb.append(", approved=");
		sb.append(getApproved());
		sb.append(", approveByUser=");
		sb.append(getApproveByUser());
		sb.append(", approvedDate=");
		sb.append(getApprovedDate());
		sb.append(", commDate=");
		sb.append(getCommDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vfaq.model.FAQComment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerid</column-name><column-value><![CDATA[");
		sb.append(getAnswerid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commName</column-name><column-value><![CDATA[");
		sb.append(getCommName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commEmail</column-name><column-value><![CDATA[");
		sb.append(getCommEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approved</column-name><column-value><![CDATA[");
		sb.append(getApproved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approveByUser</column-name><column-value><![CDATA[");
		sb.append(getApproveByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedDate</column-name><column-value><![CDATA[");
		sb.append(getApprovedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commDate</column-name><column-value><![CDATA[");
		sb.append(getCommDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
}