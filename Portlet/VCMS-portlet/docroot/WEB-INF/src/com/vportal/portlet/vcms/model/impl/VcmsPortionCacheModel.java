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

import com.vportal.portlet.vcms.model.VcmsPortion;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsPortion in entity cache.
 *
 * @author hai
 * @see VcmsPortion
 * @generated
 */
public class VcmsPortionCacheModel implements CacheModel<VcmsPortion>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{portionId=");
		sb.append(portionId);
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
		sb.append(", categorizable=");
		sb.append(categorizable);
		sb.append(", language=");
		sb.append(language);
		sb.append("}");

		return sb.toString();
	}

	public VcmsPortion toEntityModel() {
		VcmsPortionImpl vcmsPortionImpl = new VcmsPortionImpl();

		if (portionId == null) {
			vcmsPortionImpl.setPortionId(StringPool.BLANK);
		}
		else {
			vcmsPortionImpl.setPortionId(portionId);
		}

		vcmsPortionImpl.setGroupId(groupId);
		vcmsPortionImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			vcmsPortionImpl.setCreatedDate(null);
		}
		else {
			vcmsPortionImpl.setCreatedDate(new Date(createdDate));
		}

		if (createdByUser == null) {
			vcmsPortionImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			vcmsPortionImpl.setCreatedByUser(createdByUser);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vcmsPortionImpl.setModifiedDate(null);
		}
		else {
			vcmsPortionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (modifiedByUser == null) {
			vcmsPortionImpl.setModifiedByUser(StringPool.BLANK);
		}
		else {
			vcmsPortionImpl.setModifiedByUser(modifiedByUser);
		}

		if (code == null) {
			vcmsPortionImpl.setCode(StringPool.BLANK);
		}
		else {
			vcmsPortionImpl.setCode(code);
		}

		if (name == null) {
			vcmsPortionImpl.setName(StringPool.BLANK);
		}
		else {
			vcmsPortionImpl.setName(name);
		}

		if (description == null) {
			vcmsPortionImpl.setDescription(StringPool.BLANK);
		}
		else {
			vcmsPortionImpl.setDescription(description);
		}

		vcmsPortionImpl.setCategorizable(categorizable);

		if (language == null) {
			vcmsPortionImpl.setLanguage(StringPool.BLANK);
		}
		else {
			vcmsPortionImpl.setLanguage(language);
		}

		vcmsPortionImpl.resetOriginalValues();

		return vcmsPortionImpl;
	}

	public String portionId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public String createdByUser;
	public long modifiedDate;
	public String modifiedByUser;
	public String code;
	public String name;
	public String description;
	public boolean categorizable;
	public String language;
}