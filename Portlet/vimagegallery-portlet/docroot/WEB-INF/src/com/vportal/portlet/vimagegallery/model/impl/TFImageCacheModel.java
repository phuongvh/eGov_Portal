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

import com.vportal.portlet.vimagegallery.model.TFImage;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TFImage in entity cache.
 *
 * @author DucNN
 * @see TFImage
 * @generated
 */
public class TFImageCacheModel implements CacheModel<TFImage>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

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
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", image=");
		sb.append(image);
		sb.append(", isShow=");
		sb.append(isShow);
		sb.append("}");

		return sb.toString();
	}

	public TFImage toEntityModel() {
		TFImageImpl tfImageImpl = new TFImageImpl();

		tfImageImpl.setId(id);
		tfImageImpl.setGroupId(groupId);
		tfImageImpl.setCompanyId(companyId);
		tfImageImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			tfImageImpl.setCreateDate(null);
		}
		else {
			tfImageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tfImageImpl.setModifiedDate(null);
		}
		else {
			tfImageImpl.setModifiedDate(new Date(modifiedDate));
		}

		tfImageImpl.setCategoryId(categoryId);

		if (name == null) {
			tfImageImpl.setName(StringPool.BLANK);
		}
		else {
			tfImageImpl.setName(name);
		}

		if (description == null) {
			tfImageImpl.setDescription(StringPool.BLANK);
		}
		else {
			tfImageImpl.setDescription(description);
		}

		if (image == null) {
			tfImageImpl.setImage(StringPool.BLANK);
		}
		else {
			tfImageImpl.setImage(image);
		}

		tfImageImpl.setIsShow(isShow);

		tfImageImpl.resetOriginalValues();

		return tfImageImpl;
	}

	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long categoryId;
	public String name;
	public String description;
	public String image;
	public boolean isShow;
}