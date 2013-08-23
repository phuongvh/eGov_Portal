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

package com.vportal.portlet.vclip.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vclip.model.ClipType;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ClipType in entity cache.
 *
 * @author HOAN
 * @see ClipType
 * @generated
 */
public class ClipTypeCacheModel implements CacheModel<ClipType>, Serializable {
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
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", active=");
		sb.append(active);
		sb.append(", language=");
		sb.append(language);
		sb.append("}");

		return sb.toString();
	}

	public ClipType toEntityModel() {
		ClipTypeImpl clipTypeImpl = new ClipTypeImpl();

		if (id == null) {
			clipTypeImpl.setId(StringPool.BLANK);
		}
		else {
			clipTypeImpl.setId(id);
		}

		clipTypeImpl.setGroupId(groupId);
		clipTypeImpl.setCompanyId(companyId);
		clipTypeImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			clipTypeImpl.setCreatedDate(null);
		}
		else {
			clipTypeImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			clipTypeImpl.setModifiedDate(null);
		}
		else {
			clipTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			clipTypeImpl.setTitle(StringPool.BLANK);
		}
		else {
			clipTypeImpl.setTitle(title);
		}

		if (name == null) {
			clipTypeImpl.setName(StringPool.BLANK);
		}
		else {
			clipTypeImpl.setName(name);
		}

		if (description == null) {
			clipTypeImpl.setDescription(StringPool.BLANK);
		}
		else {
			clipTypeImpl.setDescription(description);
		}

		clipTypeImpl.setActive(active);

		if (language == null) {
			clipTypeImpl.setLanguage(StringPool.BLANK);
		}
		else {
			clipTypeImpl.setLanguage(language);
		}

		clipTypeImpl.resetOriginalValues();

		return clipTypeImpl;
	}

	public String id;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public String title;
	public String name;
	public String description;
	public boolean active;
	public String language;
}