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

package com.vportal.portlet.vimagegallery.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vimagegallery.model.TFCategory;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TFCategory in entity cache.
 *
 * @author DucNN
 * @see TFCategory
 * @generated
 */
public class TFCategoryCacheModel implements CacheModel<TFCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", image=");
		sb.append(image);
		sb.append("}");

		return sb.toString();
	}

	public TFCategory toEntityModel() {
		TFCategoryImpl tfCategoryImpl = new TFCategoryImpl();

		tfCategoryImpl.setId(id);
		tfCategoryImpl.setGroupId(groupId);
		tfCategoryImpl.setCompanyId(companyId);
		tfCategoryImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			tfCategoryImpl.setCreateDate(null);
		}
		else {
			tfCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tfCategoryImpl.setModifiedDate(null);
		}
		else {
			tfCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			tfCategoryImpl.setName(StringPool.BLANK);
		}
		else {
			tfCategoryImpl.setName(name);
		}

		if (description == null) {
			tfCategoryImpl.setDescription(StringPool.BLANK);
		}
		else {
			tfCategoryImpl.setDescription(description);
		}

		if (image == null) {
			tfCategoryImpl.setImage(StringPool.BLANK);
		}
		else {
			tfCategoryImpl.setImage(image);
		}

		tfCategoryImpl.resetOriginalValues();

		return tfCategoryImpl;
	}

	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String image;
}