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

import com.vportal.portlet.vcms.model.VcmsAttachedMessage;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsAttachedMessage in entity cache.
 *
 * @author hai
 * @see VcmsAttachedMessage
 * @generated
 */
public class VcmsAttachedMessageCacheModel implements CacheModel<VcmsAttachedMessage>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{messageId=");
		sb.append(messageId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", content=");
		sb.append(content);
		sb.append(", readMessage=");
		sb.append(readMessage);
		sb.append("}");

		return sb.toString();
	}

	public VcmsAttachedMessage toEntityModel() {
		VcmsAttachedMessageImpl vcmsAttachedMessageImpl = new VcmsAttachedMessageImpl();

		if (messageId == null) {
			vcmsAttachedMessageImpl.setMessageId(StringPool.BLANK);
		}
		else {
			vcmsAttachedMessageImpl.setMessageId(messageId);
		}

		vcmsAttachedMessageImpl.setGroupId(groupId);
		vcmsAttachedMessageImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			vcmsAttachedMessageImpl.setCreatedDate(null);
		}
		else {
			vcmsAttachedMessageImpl.setCreatedDate(new Date(createdDate));
		}

		if (createdByUser == null) {
			vcmsAttachedMessageImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			vcmsAttachedMessageImpl.setCreatedByUser(createdByUser);
		}

		if (articleId == null) {
			vcmsAttachedMessageImpl.setArticleId(StringPool.BLANK);
		}
		else {
			vcmsAttachedMessageImpl.setArticleId(articleId);
		}

		if (content == null) {
			vcmsAttachedMessageImpl.setContent(StringPool.BLANK);
		}
		else {
			vcmsAttachedMessageImpl.setContent(content);
		}

		vcmsAttachedMessageImpl.setReadMessage(readMessage);

		vcmsAttachedMessageImpl.resetOriginalValues();

		return vcmsAttachedMessageImpl;
	}

	public String messageId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public String createdByUser;
	public String articleId;
	public String content;
	public boolean readMessage;
}