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

package com.vportal.portlet.vadvman.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vadvman.model.AdvType;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AdvType in entity cache.
 *
 * @author DucNN
 * @see AdvType
 * @generated
 */
public class AdvTypeCacheModel implements CacheModel<AdvType>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{typeId=");
		sb.append(typeId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public AdvType toEntityModel() {
		AdvTypeImpl advTypeImpl = new AdvTypeImpl();

		advTypeImpl.setTypeId(typeId);

		if (createDate == Long.MIN_VALUE) {
			advTypeImpl.setCreateDate(null);
		}
		else {
			advTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			advTypeImpl.setModifiedDate(null);
		}
		else {
			advTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		advTypeImpl.setGroupId(groupId);
		advTypeImpl.setCompanyId(companyId);

		if (name == null) {
			advTypeImpl.setName(StringPool.BLANK);
		}
		else {
			advTypeImpl.setName(name);
		}

		if (description == null) {
			advTypeImpl.setDescription(StringPool.BLANK);
		}
		else {
			advTypeImpl.setDescription(description);
		}

		advTypeImpl.resetOriginalValues();

		return advTypeImpl;
	}

	public long typeId;
	public long createDate;
	public long modifiedDate;
	public long groupId;
	public long companyId;
	public String name;
	public String description;
}