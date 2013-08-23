/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.vfaq.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vfaq.model.FAQAnswer;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing FAQAnswer in entity cache.
 *
 * @author DucNN
 * @see FAQAnswer
 * @generated
 */
public class FAQAnswerCacheModel implements CacheModel<FAQAnswer>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", questionid=");
		sb.append(questionid);
		sb.append(", content=");
		sb.append(content);
		sb.append(", answerOrder=");
		sb.append(answerOrder);
		sb.append(", answeredByUser=");
		sb.append(answeredByUser);
		sb.append(", answeredDate=");
		sb.append(answeredDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", language=");
		sb.append(language);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", approvedByUser=");
		sb.append(approvedByUser);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", attachName=");
		sb.append(attachName);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append("}");

		return sb.toString();
	}

	public FAQAnswer toEntityModel() {
		FAQAnswerImpl faqAnswerImpl = new FAQAnswerImpl();

		if (uuid == null) {
			faqAnswerImpl.setUuid(StringPool.BLANK);
		}
		else {
			faqAnswerImpl.setUuid(uuid);
		}

		faqAnswerImpl.setId(id);
		faqAnswerImpl.setQuestionid(questionid);

		if (content == null) {
			faqAnswerImpl.setContent(StringPool.BLANK);
		}
		else {
			faqAnswerImpl.setContent(content);
		}

		faqAnswerImpl.setAnswerOrder(answerOrder);

		if (answeredByUser == null) {
			faqAnswerImpl.setAnsweredByUser(StringPool.BLANK);
		}
		else {
			faqAnswerImpl.setAnsweredByUser(answeredByUser);
		}

		if (answeredDate == Long.MIN_VALUE) {
			faqAnswerImpl.setAnsweredDate(null);
		}
		else {
			faqAnswerImpl.setAnsweredDate(new Date(answeredDate));
		}

		if (modifiedByUser == null) {
			faqAnswerImpl.setModifiedByUser(StringPool.BLANK);
		}
		else {
			faqAnswerImpl.setModifiedByUser(modifiedByUser);
		}

		if (language == null) {
			faqAnswerImpl.setLanguage(StringPool.BLANK);
		}
		else {
			faqAnswerImpl.setLanguage(language);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			faqAnswerImpl.setModifiedDate(null);
		}
		else {
			faqAnswerImpl.setModifiedDate(new Date(modifiedDate));
		}

		faqAnswerImpl.setApproved(approved);

		if (approvedByUser == null) {
			faqAnswerImpl.setApprovedByUser(StringPool.BLANK);
		}
		else {
			faqAnswerImpl.setApprovedByUser(approvedByUser);
		}

		if (approvedDate == Long.MIN_VALUE) {
			faqAnswerImpl.setApprovedDate(null);
		}
		else {
			faqAnswerImpl.setApprovedDate(new Date(approvedDate));
		}

		faqAnswerImpl.setUserId(userId);

		if (attachName == null) {
			faqAnswerImpl.setAttachName(StringPool.BLANK);
		}
		else {
			faqAnswerImpl.setAttachName(attachName);
		}

		faqAnswerImpl.setFolderId(folderId);

		faqAnswerImpl.resetOriginalValues();

		return faqAnswerImpl;
	}

	public String uuid;
	public long id;
	public long questionid;
	public String content;
	public long answerOrder;
	public String answeredByUser;
	public long answeredDate;
	public String modifiedByUser;
	public String language;
	public long modifiedDate;
	public boolean approved;
	public String approvedByUser;
	public long approvedDate;
	public long userId;
	public String attachName;
	public long folderId;
}