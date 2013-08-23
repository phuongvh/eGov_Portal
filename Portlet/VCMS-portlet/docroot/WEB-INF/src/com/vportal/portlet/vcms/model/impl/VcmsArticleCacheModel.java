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

import com.vportal.portlet.vcms.model.VcmsArticle;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsArticle in entity cache.
 *
 * @author hai
 * @see VcmsArticle
 * @generated
 */
public class VcmsArticleCacheModel implements CacheModel<VcmsArticle>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{articleId=");
		sb.append(articleId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", approvedByUser=");
		sb.append(approvedByUser);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", publishedByUser=");
		sb.append(publishedByUser);
		sb.append(", publishedDate=");
		sb.append(publishedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", title=");
		sb.append(title);
		sb.append(", lead=");
		sb.append(lead);
		sb.append(", content=");
		sb.append(content);
		sb.append(", hasImage=");
		sb.append(hasImage);
		sb.append(", imageTitle=");
		sb.append(imageTitle);
		sb.append(", image=");
		sb.append(image);
		sb.append(", author=");
		sb.append(author);
		sb.append(", source=");
		sb.append(source);
		sb.append(", language=");
		sb.append(language);
		sb.append(", userHit=");
		sb.append(userHit);
		sb.append(", discussible=");
		sb.append(discussible);
		sb.append(", hasAttachment=");
		sb.append(hasAttachment);
		sb.append(", hasPoll=");
		sb.append(hasPoll);
		sb.append(", pollId=");
		sb.append(pollId);
		sb.append(", effectiveDate=");
		sb.append(effectiveDate);
		sb.append(", expireDate=");
		sb.append(expireDate);
		sb.append(", sticky=");
		sb.append(sticky);
		sb.append(", stickyNeverExpired=");
		sb.append(stickyNeverExpired);
		sb.append(", stickyExpireDate=");
		sb.append(stickyExpireDate);
		sb.append("}");

		return sb.toString();
	}

	public VcmsArticle toEntityModel() {
		VcmsArticleImpl vcmsArticleImpl = new VcmsArticleImpl();

		if (articleId == null) {
			vcmsArticleImpl.setArticleId(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setArticleId(articleId);
		}

		vcmsArticleImpl.setGroupId(groupId);
		vcmsArticleImpl.setCompanyId(companyId);

		if (createdByUser == null) {
			vcmsArticleImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setCreatedByUser(createdByUser);
		}

		if (createdDate == Long.MIN_VALUE) {
			vcmsArticleImpl.setCreatedDate(null);
		}
		else {
			vcmsArticleImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedByUser == null) {
			vcmsArticleImpl.setModifiedByUser(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setModifiedByUser(modifiedByUser);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vcmsArticleImpl.setModifiedDate(null);
		}
		else {
			vcmsArticleImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (approvedByUser == null) {
			vcmsArticleImpl.setApprovedByUser(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setApprovedByUser(approvedByUser);
		}

		if (approvedDate == Long.MIN_VALUE) {
			vcmsArticleImpl.setApprovedDate(null);
		}
		else {
			vcmsArticleImpl.setApprovedDate(new Date(approvedDate));
		}

		if (publishedByUser == null) {
			vcmsArticleImpl.setPublishedByUser(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setPublishedByUser(publishedByUser);
		}

		if (publishedDate == Long.MIN_VALUE) {
			vcmsArticleImpl.setPublishedDate(null);
		}
		else {
			vcmsArticleImpl.setPublishedDate(new Date(publishedDate));
		}

		vcmsArticleImpl.setStatus(status);

		if (title == null) {
			vcmsArticleImpl.setTitle(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setTitle(title);
		}

		if (lead == null) {
			vcmsArticleImpl.setLead(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setLead(lead);
		}

		if (content == null) {
			vcmsArticleImpl.setContent(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setContent(content);
		}

		vcmsArticleImpl.setHasImage(hasImage);

		if (imageTitle == null) {
			vcmsArticleImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setImageTitle(imageTitle);
		}

		if (image == null) {
			vcmsArticleImpl.setImage(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setImage(image);
		}

		if (author == null) {
			vcmsArticleImpl.setAuthor(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setAuthor(author);
		}

		if (source == null) {
			vcmsArticleImpl.setSource(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setSource(source);
		}

		if (language == null) {
			vcmsArticleImpl.setLanguage(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setLanguage(language);
		}

		vcmsArticleImpl.setUserHit(userHit);
		vcmsArticleImpl.setDiscussible(discussible);
		vcmsArticleImpl.setHasAttachment(hasAttachment);
		vcmsArticleImpl.setHasPoll(hasPoll);

		if (pollId == null) {
			vcmsArticleImpl.setPollId(StringPool.BLANK);
		}
		else {
			vcmsArticleImpl.setPollId(pollId);
		}

		if (effectiveDate == Long.MIN_VALUE) {
			vcmsArticleImpl.setEffectiveDate(null);
		}
		else {
			vcmsArticleImpl.setEffectiveDate(new Date(effectiveDate));
		}

		if (expireDate == Long.MIN_VALUE) {
			vcmsArticleImpl.setExpireDate(null);
		}
		else {
			vcmsArticleImpl.setExpireDate(new Date(expireDate));
		}

		vcmsArticleImpl.setSticky(sticky);
		vcmsArticleImpl.setStickyNeverExpired(stickyNeverExpired);

		if (stickyExpireDate == Long.MIN_VALUE) {
			vcmsArticleImpl.setStickyExpireDate(null);
		}
		else {
			vcmsArticleImpl.setStickyExpireDate(new Date(stickyExpireDate));
		}

		vcmsArticleImpl.resetOriginalValues();

		return vcmsArticleImpl;
	}

	public String articleId;
	public long groupId;
	public long companyId;
	public String createdByUser;
	public long createdDate;
	public String modifiedByUser;
	public long modifiedDate;
	public String approvedByUser;
	public long approvedDate;
	public String publishedByUser;
	public long publishedDate;
	public long status;
	public String title;
	public String lead;
	public String content;
	public boolean hasImage;
	public String imageTitle;
	public String image;
	public String author;
	public String source;
	public String language;
	public long userHit;
	public boolean discussible;
	public boolean hasAttachment;
	public boolean hasPoll;
	public String pollId;
	public long effectiveDate;
	public long expireDate;
	public boolean sticky;
	public boolean stickyNeverExpired;
	public long stickyExpireDate;
}