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

import com.vportal.portlet.vcms.model.VcmsType;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsType in entity cache.
 *
 * @author hai
 * @see VcmsType
 * @generated
 */
public class VcmsTypeCacheModel implements CacheModel<VcmsType>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{typeId=");
		sb.append(typeId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", language=");
		sb.append(language);
		sb.append("}");

		return sb.toString();
	}

	public VcmsType toEntityModel() {
		VcmsTypeImpl vcmsTypeImpl = new VcmsTypeImpl();

		if (typeId == null) {
			vcmsTypeImpl.setTypeId(StringPool.BLANK);
		}
		else {
			vcmsTypeImpl.setTypeId(typeId);
		}

		vcmsTypeImpl.setGroupId(groupId);
		vcmsTypeImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			vcmsTypeImpl.setCreatedDate(null);
		}
		else {
			vcmsTypeImpl.setCreatedDate(new Date(createdDate));
		}

		if (createdByUser == null) {
			vcmsTypeImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			vcmsTypeImpl.setCreatedByUser(createdByUser);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vcmsTypeImpl.setModifiedDate(null);
		}
		else {
			vcmsTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (modifiedByUser == null) {
			vcmsTypeImpl.setModifiedByUser(StringPool.BLANK);
		}
		else {
			vcmsTypeImpl.setModifiedByUser(modifiedByUser);
		}

		if (code == null) {
			vcmsTypeImpl.setCode(StringPool.BLANK);
		}
		else {
			vcmsTypeImpl.setCode(code);
		}

		if (name == null) {
			vcmsTypeImpl.setName(StringPool.BLANK);
		}
		else {
			vcmsTypeImpl.setName(name);
		}

		if (description == null) {
			vcmsTypeImpl.setDescription(StringPool.BLANK);
		}
		else {
			vcmsTypeImpl.setDescription(description);
		}

		if (language == null) {
			vcmsTypeImpl.setLanguage(StringPool.BLANK);
		}
		else {
			vcmsTypeImpl.setLanguage(language);
		}

		vcmsTypeImpl.resetOriginalValues();

		return vcmsTypeImpl;
	}

	public String typeId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public String createdByUser;
	public long modifiedDate;
	public String modifiedByUser;
	public String code;
	public String name;
	public String description;
	public String language;
}