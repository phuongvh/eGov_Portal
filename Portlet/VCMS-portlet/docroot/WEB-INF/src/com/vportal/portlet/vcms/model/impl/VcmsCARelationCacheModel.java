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

import com.vportal.portlet.vcms.model.VcmsCARelation;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsCARelation in entity cache.
 *
 * @author hai
 * @see VcmsCARelation
 * @generated
 */
public class VcmsCARelationCacheModel implements CacheModel<VcmsCARelation>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public VcmsCARelation toEntityModel() {
		VcmsCARelationImpl vcmsCARelationImpl = new VcmsCARelationImpl();

		if (categoryId == null) {
			vcmsCARelationImpl.setCategoryId(StringPool.BLANK);
		}
		else {
			vcmsCARelationImpl.setCategoryId(categoryId);
		}

		if (articleId == null) {
			vcmsCARelationImpl.setArticleId(StringPool.BLANK);
		}
		else {
			vcmsCARelationImpl.setArticleId(articleId);
		}

		if (createdDate == Long.MIN_VALUE) {
			vcmsCARelationImpl.setCreatedDate(null);
		}
		else {
			vcmsCARelationImpl.setCreatedDate(new Date(createdDate));
		}

		if (createdByUser == null) {
			vcmsCARelationImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			vcmsCARelationImpl.setCreatedByUser(createdByUser);
		}

		vcmsCARelationImpl.setStatus(status);

		vcmsCARelationImpl.resetOriginalValues();

		return vcmsCARelationImpl;
	}

	public String categoryId;
	public String articleId;
	public long createdDate;
	public String createdByUser;
	public long status;
}