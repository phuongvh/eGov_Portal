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

import com.vportal.portlet.vcms.model.VcmsArticleVersion;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsArticleVersion in entity cache.
 *
 * @author hai
 * @see VcmsArticleVersion
 * @generated
 */
public class VcmsArticleVersionCacheModel implements CacheModel<VcmsArticleVersion>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{articleVersionId=");
		sb.append(articleVersionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", typeIds=");
		sb.append(typeIds);
		sb.append(", status=");
		sb.append(status);
		sb.append(", versionName=");
		sb.append(versionName);
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
		sb.append(", language=");
		sb.append(language);
		sb.append(", userHit=");
		sb.append(userHit);
		sb.append(", author=");
		sb.append(author);
		sb.append(", source=");
		sb.append(source);
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

	public VcmsArticleVersion toEntityModel() {
		VcmsArticleVersionImpl vcmsArticleVersionImpl = new VcmsArticleVersionImpl();

		vcmsArticleVersionImpl.setArticleVersionId(articleVersionId);
		vcmsArticleVersionImpl.setGroupId(groupId);
		vcmsArticleVersionImpl.setCompanyId(companyId);

		if (articleId == null) {
			vcmsArticleVersionImpl.setArticleId(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setArticleId(articleId);
		}

		if (createdByUser == null) {
			vcmsArticleVersionImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setCreatedByUser(createdByUser);
		}

		if (createdDate == Long.MIN_VALUE) {
			vcmsArticleVersionImpl.setCreatedDate(null);
		}
		else {
			vcmsArticleVersionImpl.setCreatedDate(new Date(createdDate));
		}

		if (typeIds == null) {
			vcmsArticleVersionImpl.setTypeIds(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setTypeIds(typeIds);
		}

		vcmsArticleVersionImpl.setStatus(status);

		if (versionName == null) {
			vcmsArticleVersionImpl.setVersionName(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setVersionName(versionName);
		}

		if (title == null) {
			vcmsArticleVersionImpl.setTitle(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setTitle(title);
		}

		if (lead == null) {
			vcmsArticleVersionImpl.setLead(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setLead(lead);
		}

		if (content == null) {
			vcmsArticleVersionImpl.setContent(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setContent(content);
		}

		vcmsArticleVersionImpl.setHasImage(hasImage);

		if (imageTitle == null) {
			vcmsArticleVersionImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setImageTitle(imageTitle);
		}

		if (image == null) {
			vcmsArticleVersionImpl.setImage(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setImage(image);
		}

		if (language == null) {
			vcmsArticleVersionImpl.setLanguage(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setLanguage(language);
		}

		vcmsArticleVersionImpl.setUserHit(userHit);

		if (author == null) {
			vcmsArticleVersionImpl.setAuthor(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setAuthor(author);
		}

		if (source == null) {
			vcmsArticleVersionImpl.setSource(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setSource(source);
		}

		vcmsArticleVersionImpl.setDiscussible(discussible);
		vcmsArticleVersionImpl.setHasAttachment(hasAttachment);
		vcmsArticleVersionImpl.setHasPoll(hasPoll);

		if (pollId == null) {
			vcmsArticleVersionImpl.setPollId(StringPool.BLANK);
		}
		else {
			vcmsArticleVersionImpl.setPollId(pollId);
		}

		if (effectiveDate == Long.MIN_VALUE) {
			vcmsArticleVersionImpl.setEffectiveDate(null);
		}
		else {
			vcmsArticleVersionImpl.setEffectiveDate(new Date(effectiveDate));
		}

		if (expireDate == Long.MIN_VALUE) {
			vcmsArticleVersionImpl.setExpireDate(null);
		}
		else {
			vcmsArticleVersionImpl.setExpireDate(new Date(expireDate));
		}

		vcmsArticleVersionImpl.setSticky(sticky);
		vcmsArticleVersionImpl.setStickyNeverExpired(stickyNeverExpired);

		if (stickyExpireDate == Long.MIN_VALUE) {
			vcmsArticleVersionImpl.setStickyExpireDate(null);
		}
		else {
			vcmsArticleVersionImpl.setStickyExpireDate(new Date(
					stickyExpireDate));
		}

		vcmsArticleVersionImpl.resetOriginalValues();

		return vcmsArticleVersionImpl;
	}

	public long articleVersionId;
	public long groupId;
	public long companyId;
	public String articleId;
	public String createdByUser;
	public long createdDate;
	public String typeIds;
	public long status;
	public String versionName;
	public String title;
	public String lead;
	public String content;
	public boolean hasImage;
	public String imageTitle;
	public String image;
	public String language;
	public long userHit;
	public String author;
	public String source;
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