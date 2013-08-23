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

import com.vportal.portlet.vcms.model.VcmsCategory;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsCategory in entity cache.
 *
 * @author hai
 * @see VcmsCategory
 * @generated
 */
public class VcmsCategoryCacheModel implements CacheModel<VcmsCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", portionId=");
		sb.append(portionId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", anchored=");
		sb.append(anchored);
		sb.append(", href=");
		sb.append(href);
		sb.append(", language=");
		sb.append(language);
		sb.append(", hasImage=");
		sb.append(hasImage);
		sb.append(", image=");
		sb.append(image);
		sb.append(", position=");
		sb.append(position);
		sb.append(", userHit=");
		sb.append(userHit);
		sb.append(", rssable=");
		sb.append(rssable);
		sb.append("}");

		return sb.toString();
	}

	public VcmsCategory toEntityModel() {
		VcmsCategoryImpl vcmsCategoryImpl = new VcmsCategoryImpl();

		if (categoryId == null) {
			vcmsCategoryImpl.setCategoryId(StringPool.BLANK);
		}
		else {
			vcmsCategoryImpl.setCategoryId(categoryId);
		}

		vcmsCategoryImpl.setGroupId(groupId);
		vcmsCategoryImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			vcmsCategoryImpl.setCreatedDate(null);
		}
		else {
			vcmsCategoryImpl.setCreatedDate(new Date(createdDate));
		}

		if (createdByUser == null) {
			vcmsCategoryImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			vcmsCategoryImpl.setCreatedByUser(createdByUser);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vcmsCategoryImpl.setModifiedDate(null);
		}
		else {
			vcmsCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (modifiedByUser == null) {
			vcmsCategoryImpl.setModifiedByUser(StringPool.BLANK);
		}
		else {
			vcmsCategoryImpl.setModifiedByUser(modifiedByUser);
		}

		if (portionId == null) {
			vcmsCategoryImpl.setPortionId(StringPool.BLANK);
		}
		else {
			vcmsCategoryImpl.setPortionId(portionId);
		}

		if (parentId == null) {
			vcmsCategoryImpl.setParentId(StringPool.BLANK);
		}
		else {
			vcmsCategoryImpl.setParentId(parentId);
		}

		if (name == null) {
			vcmsCategoryImpl.setName(StringPool.BLANK);
		}
		else {
			vcmsCategoryImpl.setName(name);
		}

		if (description == null) {
			vcmsCategoryImpl.setDescription(StringPool.BLANK);
		}
		else {
			vcmsCategoryImpl.setDescription(description);
		}

		vcmsCategoryImpl.setAnchored(anchored);

		if (href == null) {
			vcmsCategoryImpl.setHref(StringPool.BLANK);
		}
		else {
			vcmsCategoryImpl.setHref(href);
		}

		if (language == null) {
			vcmsCategoryImpl.setLanguage(StringPool.BLANK);
		}
		else {
			vcmsCategoryImpl.setLanguage(language);
		}

		vcmsCategoryImpl.setHasImage(hasImage);

		if (image == null) {
			vcmsCategoryImpl.setImage(StringPool.BLANK);
		}
		else {
			vcmsCategoryImpl.setImage(image);
		}

		vcmsCategoryImpl.setPosition(position);
		vcmsCategoryImpl.setUserHit(userHit);
		vcmsCategoryImpl.setRssable(rssable);

		vcmsCategoryImpl.resetOriginalValues();

		return vcmsCategoryImpl;
	}

	public String categoryId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public String createdByUser;
	public long modifiedDate;
	public String modifiedByUser;
	public String portionId;
	public String parentId;
	public String name;
	public String description;
	public boolean anchored;
	public String href;
	public String language;
	public boolean hasImage;
	public String image;
	public long position;
	public long userHit;
	public boolean rssable;
}