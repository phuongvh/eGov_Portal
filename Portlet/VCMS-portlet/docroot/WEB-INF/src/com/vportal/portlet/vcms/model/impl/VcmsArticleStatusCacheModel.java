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

import com.vportal.portlet.vcms.model.VcmsArticleStatus;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsArticleStatus in entity cache.
 *
 * @author hai
 * @see VcmsArticleStatus
 * @generated
 */
public class VcmsArticleStatusCacheModel implements CacheModel<VcmsArticleStatus>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", statusId=");
		sb.append(statusId);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", active=");
		sb.append(active);
		sb.append(", articleVersionId=");
		sb.append(articleVersionId);
		sb.append("}");

		return sb.toString();
	}

	public VcmsArticleStatus toEntityModel() {
		VcmsArticleStatusImpl vcmsArticleStatusImpl = new VcmsArticleStatusImpl();

		vcmsArticleStatusImpl.setId(id);
		vcmsArticleStatusImpl.setStatusId(statusId);

		if (articleId == null) {
			vcmsArticleStatusImpl.setArticleId(StringPool.BLANK);
		}
		else {
			vcmsArticleStatusImpl.setArticleId(articleId);
		}

		if (categoryId == null) {
			vcmsArticleStatusImpl.setCategoryId(StringPool.BLANK);
		}
		else {
			vcmsArticleStatusImpl.setCategoryId(categoryId);
		}

		if (createdDate == Long.MIN_VALUE) {
			vcmsArticleStatusImpl.setCreatedDate(null);
		}
		else {
			vcmsArticleStatusImpl.setCreatedDate(new Date(createdDate));
		}

		if (createdByUser == null) {
			vcmsArticleStatusImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			vcmsArticleStatusImpl.setCreatedByUser(createdByUser);
		}

		vcmsArticleStatusImpl.setActive(active);
		vcmsArticleStatusImpl.setArticleVersionId(articleVersionId);

		vcmsArticleStatusImpl.resetOriginalValues();

		return vcmsArticleStatusImpl;
	}

	public long id;
	public long statusId;
	public String articleId;
	public String categoryId;
	public long createdDate;
	public String createdByUser;
	public boolean active;
	public long articleVersionId;
}