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

import com.vportal.portlet.vfaq.model.FAQComment;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing FAQComment in entity cache.
 *
 * @author DucNN
 * @see FAQComment
 * @generated
 */
public class FAQCommentCacheModel implements CacheModel<FAQComment>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", answerid=");
		sb.append(answerid);
		sb.append(", content=");
		sb.append(content);
		sb.append(", commName=");
		sb.append(commName);
		sb.append(", commEmail=");
		sb.append(commEmail);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", approveByUser=");
		sb.append(approveByUser);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", commDate=");
		sb.append(commDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	public FAQComment toEntityModel() {
		FAQCommentImpl faqCommentImpl = new FAQCommentImpl();

		if (uuid == null) {
			faqCommentImpl.setUuid(StringPool.BLANK);
		}
		else {
			faqCommentImpl.setUuid(uuid);
		}

		faqCommentImpl.setId(id);
		faqCommentImpl.setAnswerid(answerid);

		if (content == null) {
			faqCommentImpl.setContent(StringPool.BLANK);
		}
		else {
			faqCommentImpl.setContent(content);
		}

		if (commName == null) {
			faqCommentImpl.setCommName(StringPool.BLANK);
		}
		else {
			faqCommentImpl.setCommName(commName);
		}

		if (commEmail == null) {
			faqCommentImpl.setCommEmail(StringPool.BLANK);
		}
		else {
			faqCommentImpl.setCommEmail(commEmail);
		}

		faqCommentImpl.setApproved(approved);

		if (approveByUser == null) {
			faqCommentImpl.setApproveByUser(StringPool.BLANK);
		}
		else {
			faqCommentImpl.setApproveByUser(approveByUser);
		}

		if (approvedDate == Long.MIN_VALUE) {
			faqCommentImpl.setApprovedDate(null);
		}
		else {
			faqCommentImpl.setApprovedDate(new Date(approvedDate));
		}

		if (commDate == Long.MIN_VALUE) {
			faqCommentImpl.setCommDate(null);
		}
		else {
			faqCommentImpl.setCommDate(new Date(commDate));
		}

		faqCommentImpl.setUserId(userId);

		faqCommentImpl.resetOriginalValues();

		return faqCommentImpl;
	}

	public String uuid;
	public long id;
	public long answerid;
	public String content;
	public String commName;
	public String commEmail;
	public boolean approved;
	public String approveByUser;
	public long approvedDate;
	public long commDate;
	public long userId;
}