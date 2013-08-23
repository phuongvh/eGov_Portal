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

import com.vportal.portlet.vfaq.service.FAQAnswerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author DucNN
 */
public class FAQAnswerClp extends BaseModelImpl<FAQAnswer> implements FAQAnswer {
	public FAQAnswerClp() {
	}

	public Class<?> getModelClass() {
		return FAQAnswer.class;
	}

	public String getModelClassName() {
		return FAQAnswer.class.getName();
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			FAQAnswerLocalServiceUtil.addFAQAnswer(this);
		}
		else {
			FAQAnswerLocalServiceUtil.updateFAQAnswer(this);
		}
	}

	@Override
	public FAQAnswer toEscapedModel() {
		return (FAQAnswer)Proxy.newProxyInstance(FAQAnswer.class.getClassLoader(),
			new Class[] { FAQAnswer.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FAQAnswerClp clone = new FAQAnswerClp();

		clone.setUuid(getUuid());
		clone.setId(getId());
		clone.setQuestionid(getQuestionid());
		clone.setContent(getContent());
		clone.setAnswerOrder(getAnswerOrder());
		clone.setAnsweredByUser(getAnsweredByUser());
		clone.setAnsweredDate(getAnsweredDate());
		clone.setModifiedByUser(getModifiedByUser());
		clone.setLanguage(getLanguage());
		clone.setModifiedDate(getModifiedDate());
		clone.setApproved(getApproved());
		clone.setApprovedByUser(getApprovedByUser());
		clone.setApprovedDate(getApprovedDate());
		clone.setUserId(getUserId());
		clone.setAttachName(getAttachName());
		clone.setFolderId(getFolderId());

		return clone;
	}

	public int compareTo(FAQAnswer faqAnswer) {
		int value = 0;

		value = DateUtil.compareTo(getAnsweredDate(),
				faqAnswer.getAnsweredDate());

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

		FAQAnswerClp faqAnswer = null;

		try {
			faqAnswer = (FAQAnswerClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = faqAnswer.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", questionid=");
		sb.append(getQuestionid());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", answerOrder=");
		sb.append(getAnswerOrder());
		sb.append(", answeredByUser=");
		sb.append(getAnsweredByUser());
		sb.append(", answeredDate=");
		sb.append(getAnsweredDate());
		sb.append(", modifiedByUser=");
		sb.append(getModifiedByUser());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", approved=");
		sb.append(getApproved());
		sb.append(", approvedByUser=");
		sb.append(getApprovedByUser());
		sb.append(", approvedDate=");
		sb.append(getApprovedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", attachName=");
		sb.append(getAttachName());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vfaq.model.FAQAnswer");
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
			"<column><column-name>questionid</column-name><column-value><![CDATA[");
		sb.append(getQuestionid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerOrder</column-name><column-value><![CDATA[");
		sb.append(getAnswerOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answeredByUser</column-name><column-value><![CDATA[");
		sb.append(getAnsweredByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answeredDate</column-name><column-value><![CDATA[");
		sb.append(getAnsweredDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedByUser</column-name><column-value><![CDATA[");
		sb.append(getModifiedByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachName</column-name><column-value><![CDATA[");
		sb.append(getAttachName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
	private String _attachName;
	private long _folderId;
}