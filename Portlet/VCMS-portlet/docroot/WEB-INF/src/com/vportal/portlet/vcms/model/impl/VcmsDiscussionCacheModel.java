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

package com.vportal.portlet.vcms.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vcms.model.VcmsDiscussion;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsDiscussion in entity cache.
 *
 * @author hai
 * @see VcmsDiscussion
 * @generated
 */
public class VcmsDiscussionCacheModel implements CacheModel<VcmsDiscussion>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{discussionId=");
		sb.append(discussionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", visitorName=");
		sb.append(visitorName);
		sb.append(", visitorEmail=");
		sb.append(visitorEmail);
		sb.append(", visitorPhone=");
		sb.append(visitorPhone);
		sb.append(", postedDate=");
		sb.append(postedDate);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", approvedByUser=");
		sb.append(approvedByUser);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", language=");
		sb.append(language);
		sb.append(", hasAttachment=");
		sb.append(hasAttachment);
		sb.append("}");

		return sb.toString();
	}

	public VcmsDiscussion toEntityModel() {
		VcmsDiscussionImpl vcmsDiscussionImpl = new VcmsDiscussionImpl();

		if (discussionId == null) {
			vcmsDiscussionImpl.setDiscussionId(StringPool.BLANK);
		}
		else {
			vcmsDiscussionImpl.setDiscussionId(discussionId);
		}

		vcmsDiscussionImpl.setGroupId(groupId);
		vcmsDiscussionImpl.setCompanyId(companyId);

		if (visitorName == null) {
			vcmsDiscussionImpl.setVisitorName(StringPool.BLANK);
		}
		else {
			vcmsDiscussionImpl.setVisitorName(visitorName);
		}

		if (visitorEmail == null) {
			vcmsDiscussionImpl.setVisitorEmail(StringPool.BLANK);
		}
		else {
			vcmsDiscussionImpl.setVisitorEmail(visitorEmail);
		}

		if (visitorPhone == null) {
			vcmsDiscussionImpl.setVisitorPhone(StringPool.BLANK);
		}
		else {
			vcmsDiscussionImpl.setVisitorPhone(visitorPhone);
		}

		if (postedDate == Long.MIN_VALUE) {
			vcmsDiscussionImpl.setPostedDate(null);
		}
		else {
			vcmsDiscussionImpl.setPostedDate(new Date(postedDate));
		}

		vcmsDiscussionImpl.setApproved(approved);

		if (approvedByUser == null) {
			vcmsDiscussionImpl.setApprovedByUser(StringPool.BLANK);
		}
		else {
			vcmsDiscussionImpl.setApprovedByUser(approvedByUser);
		}

		if (approvedDate == Long.MIN_VALUE) {
			vcmsDiscussionImpl.setApprovedDate(null);
		}
		else {
			vcmsDiscussionImpl.setApprovedDate(new Date(approvedDate));
		}

		if (articleId == null) {
			vcmsDiscussionImpl.setArticleId(StringPool.BLANK);
		}
		else {
			vcmsDiscussionImpl.setArticleId(articleId);
		}

		if (title == null) {
			vcmsDiscussionImpl.setTitle(StringPool.BLANK);
		}
		else {
			vcmsDiscussionImpl.setTitle(title);
		}

		if (content == null) {
			vcmsDiscussionImpl.setContent(StringPool.BLANK);
		}
		else {
			vcmsDiscussionImpl.setContent(content);
		}

		if (language == null) {
			vcmsDiscussionImpl.setLanguage(StringPool.BLANK);
		}
		else {
			vcmsDiscussionImpl.setLanguage(language);
		}

		vcmsDiscussionImpl.setHasAttachment(hasAttachment);

		vcmsDiscussionImpl.resetOriginalValues();

		return vcmsDiscussionImpl;
	}

	public String discussionId;
	public long groupId;
	public long companyId;
	public String visitorName;
	public String visitorEmail;
	public String visitorPhone;
	public long postedDate;
	public boolean approved;
	public String approvedByUser;
	public long approvedDate;
	public String articleId;
	public String title;
	public String content;
	public String language;
	public boolean hasAttachment;
}