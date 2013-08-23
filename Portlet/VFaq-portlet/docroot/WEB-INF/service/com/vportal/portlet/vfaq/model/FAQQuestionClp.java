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

import com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author DucNN
 */
public class FAQQuestionClp extends BaseModelImpl<FAQQuestion>
	implements FAQQuestion {
	public FAQQuestionClp() {
	}

	public Class<?> getModelClass() {
		return FAQQuestion.class;
	}

	public String getModelClassName() {
		return FAQQuestion.class.getName();
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			FAQQuestionLocalServiceUtil.addFAQQuestion(this);
		}
		else {
			FAQQuestionLocalServiceUtil.updateFAQQuestion(this);
		}
	}

	@Override
	public FAQQuestion toEscapedModel() {
		return (FAQQuestion)Proxy.newProxyInstance(FAQQuestion.class.getClassLoader(),
			new Class[] { FAQQuestion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FAQQuestionClp clone = new FAQQuestionClp();

		clone.setUuid(getUuid());
		clone.setId(getId());
		clone.setTitle(getTitle());
		clone.setContent(getContent());
		clone.setLanguage(getLanguage());
		clone.setQuestionOrder(getQuestionOrder());
		clone.setSentDate(getSentDate());
		clone.setSentByUser(getSentByUser());
		clone.setSenderEmail(getSenderEmail());
		clone.setQuestionType(getQuestionType());
		clone.setModifiedByUser(getModifiedByUser());
		clone.setModifiedDate(getModifiedDate());
		clone.setHitCount(getHitCount());
		clone.setApproved(getApproved());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(FAQQuestion faqQuestion) {
		int value = 0;

		value = DateUtil.compareTo(getSentDate(), faqQuestion.getSentDate());

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

		FAQQuestionClp faqQuestion = null;

		try {
			faqQuestion = (FAQQuestionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = faqQuestion.getPrimaryKey();

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
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", questionOrder=");
		sb.append(getQuestionOrder());
		sb.append(", sentDate=");
		sb.append(getSentDate());
		sb.append(", sentByUser=");
		sb.append(getSentByUser());
		sb.append(", senderEmail=");
		sb.append(getSenderEmail());
		sb.append(", questionType=");
		sb.append(getQuestionType());
		sb.append(", modifiedByUser=");
		sb.append(getModifiedByUser());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", hitCount=");
		sb.append(getHitCount());
		sb.append(", approved=");
		sb.append(getApproved());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vfaq.model.FAQQuestion");
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
			"<column><column-name>questionOrder</column-name><column-value><![CDATA[");
		sb.append(getQuestionOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentDate</column-name><column-value><![CDATA[");
		sb.append(getSentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentByUser</column-name><column-value><![CDATA[");
		sb.append(getSentByUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderEmail</column-name><column-value><![CDATA[");
		sb.append(getSenderEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionType</column-name><column-value><![CDATA[");
		sb.append(getQuestionType());
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
			"<column><column-name>hitCount</column-name><column-value><![CDATA[");
		sb.append(getHitCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approved</column-name><column-value><![CDATA[");
		sb.append(getApproved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
	private String _userUuid;
}