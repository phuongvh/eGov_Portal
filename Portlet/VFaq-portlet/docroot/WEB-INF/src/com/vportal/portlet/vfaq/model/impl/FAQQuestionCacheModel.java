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

import com.vportal.portlet.vfaq.model.FAQQuestion;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing FAQQuestion in entity cache.
 *
 * @author DucNN
 * @see FAQQuestion
 * @generated
 */
public class FAQQuestionCacheModel implements CacheModel<FAQQuestion>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", language=");
		sb.append(language);
		sb.append(", questionOrder=");
		sb.append(questionOrder);
		sb.append(", sentDate=");
		sb.append(sentDate);
		sb.append(", sentByUser=");
		sb.append(sentByUser);
		sb.append(", senderEmail=");
		sb.append(senderEmail);
		sb.append(", questionType=");
		sb.append(questionType);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", hitCount=");
		sb.append(hitCount);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	public FAQQuestion toEntityModel() {
		FAQQuestionImpl faqQuestionImpl = new FAQQuestionImpl();

		if (uuid == null) {
			faqQuestionImpl.setUuid(StringPool.BLANK);
		}
		else {
			faqQuestionImpl.setUuid(uuid);
		}

		faqQuestionImpl.setId(id);

		if (title == null) {
			faqQuestionImpl.setTitle(StringPool.BLANK);
		}
		else {
			faqQuestionImpl.setTitle(title);
		}

		if (content == null) {
			faqQuestionImpl.setContent(StringPool.BLANK);
		}
		else {
			faqQuestionImpl.setContent(content);
		}

		if (language == null) {
			faqQuestionImpl.setLanguage(StringPool.BLANK);
		}
		else {
			faqQuestionImpl.setLanguage(language);
		}

		faqQuestionImpl.setQuestionOrder(questionOrder);

		if (sentDate == Long.MIN_VALUE) {
			faqQuestionImpl.setSentDate(null);
		}
		else {
			faqQuestionImpl.setSentDate(new Date(sentDate));
		}

		if (sentByUser == null) {
			faqQuestionImpl.setSentByUser(StringPool.BLANK);
		}
		else {
			faqQuestionImpl.setSentByUser(sentByUser);
		}

		if (senderEmail == null) {
			faqQuestionImpl.setSenderEmail(StringPool.BLANK);
		}
		else {
			faqQuestionImpl.setSenderEmail(senderEmail);
		}

		if (questionType == null) {
			faqQuestionImpl.setQuestionType(StringPool.BLANK);
		}
		else {
			faqQuestionImpl.setQuestionType(questionType);
		}

		if (modifiedByUser == null) {
			faqQuestionImpl.setModifiedByUser(StringPool.BLANK);
		}
		else {
			faqQuestionImpl.setModifiedByUser(modifiedByUser);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			faqQuestionImpl.setModifiedDate(null);
		}
		else {
			faqQuestionImpl.setModifiedDate(new Date(modifiedDate));
		}

		faqQuestionImpl.setHitCount(hitCount);
		faqQuestionImpl.setApproved(approved);
		faqQuestionImpl.setGroupId(groupId);
		faqQuestionImpl.setUserId(userId);

		faqQuestionImpl.resetOriginalValues();

		return faqQuestionImpl;
	}

	public String uuid;
	public long id;
	public String title;
	public String content;
	public String language;
	public long questionOrder;
	public long sentDate;
	public String sentByUser;
	public String senderEmail;
	public String questionType;
	public String modifiedByUser;
	public long modifiedDate;
	public long hitCount;
	public boolean approved;
	public long groupId;
	public long userId;
}