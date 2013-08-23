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

import com.vportal.portlet.vfaq.model.FAQCategory;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing FAQCategory in entity cache.
 *
 * @author DucNN
 * @see FAQCategory
 * @generated
 */
public class FAQCategoryCacheModel implements CacheModel<FAQCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", language=");
		sb.append(language);
		sb.append(", parent=");
		sb.append(parent);
		sb.append(", catorder=");
		sb.append(catorder);
		sb.append(", catlevel=");
		sb.append(catlevel);
		sb.append(", image=");
		sb.append(image);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	public FAQCategory toEntityModel() {
		FAQCategoryImpl faqCategoryImpl = new FAQCategoryImpl();

		faqCategoryImpl.setId(id);

		if (name == null) {
			faqCategoryImpl.setName(StringPool.BLANK);
		}
		else {
			faqCategoryImpl.setName(name);
		}

		if (description == null) {
			faqCategoryImpl.setDescription(StringPool.BLANK);
		}
		else {
			faqCategoryImpl.setDescription(description);
		}

		if (language == null) {
			faqCategoryImpl.setLanguage(StringPool.BLANK);
		}
		else {
			faqCategoryImpl.setLanguage(language);
		}

		faqCategoryImpl.setParent(parent);
		faqCategoryImpl.setCatorder(catorder);
		faqCategoryImpl.setCatlevel(catlevel);

		if (image == null) {
			faqCategoryImpl.setImage(StringPool.BLANK);
		}
		else {
			faqCategoryImpl.setImage(image);
		}

		if (createdByUser == null) {
			faqCategoryImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			faqCategoryImpl.setCreatedByUser(createdByUser);
		}

		if (createdDate == Long.MIN_VALUE) {
			faqCategoryImpl.setCreatedDate(null);
		}
		else {
			faqCategoryImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedByUser == null) {
			faqCategoryImpl.setModifiedByUser(StringPool.BLANK);
		}
		else {
			faqCategoryImpl.setModifiedByUser(modifiedByUser);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			faqCategoryImpl.setModifiedDate(null);
		}
		else {
			faqCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		faqCategoryImpl.setGroupId(groupId);
		faqCategoryImpl.setUserId(userId);

		faqCategoryImpl.resetOriginalValues();

		return faqCategoryImpl;
	}

	public long id;
	public String name;
	public String description;
	public String language;
	public long parent;
	public long catorder;
	public long catlevel;
	public String image;
	public String createdByUser;
	public long createdDate;
	public String modifiedByUser;
	public long modifiedDate;
	public long groupId;
	public long userId;
}