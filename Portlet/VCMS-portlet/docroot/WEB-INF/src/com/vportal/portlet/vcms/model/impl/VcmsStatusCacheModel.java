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

import com.vportal.portlet.vcms.model.VcmsStatus;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsStatus in entity cache.
 *
 * @author hai
 * @see VcmsStatus
 * @generated
 */
public class VcmsStatusCacheModel implements CacheModel<VcmsStatus>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{statusId=");
		sb.append(statusId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", cssClass=");
		sb.append(cssClass);
		sb.append(", textColor=");
		sb.append(textColor);
		sb.append(", position=");
		sb.append(position);
		sb.append(", isPrimary=");
		sb.append(isPrimary);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	public VcmsStatus toEntityModel() {
		VcmsStatusImpl vcmsStatusImpl = new VcmsStatusImpl();

		vcmsStatusImpl.setStatusId(statusId);
		vcmsStatusImpl.setCompanyId(companyId);
		vcmsStatusImpl.setGroupId(groupId);

		if (createdDate == Long.MIN_VALUE) {
			vcmsStatusImpl.setCreatedDate(null);
		}
		else {
			vcmsStatusImpl.setCreatedDate(new Date(createdDate));
		}

		if (createdByUser == null) {
			vcmsStatusImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			vcmsStatusImpl.setCreatedByUser(createdByUser);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vcmsStatusImpl.setModifiedDate(null);
		}
		else {
			vcmsStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (modifiedByUser == null) {
			vcmsStatusImpl.setModifiedByUser(StringPool.BLANK);
		}
		else {
			vcmsStatusImpl.setModifiedByUser(modifiedByUser);
		}

		if (name == null) {
			vcmsStatusImpl.setName(StringPool.BLANK);
		}
		else {
			vcmsStatusImpl.setName(name);
		}

		if (description == null) {
			vcmsStatusImpl.setDescription(StringPool.BLANK);
		}
		else {
			vcmsStatusImpl.setDescription(description);
		}

		if (cssClass == null) {
			vcmsStatusImpl.setCssClass(StringPool.BLANK);
		}
		else {
			vcmsStatusImpl.setCssClass(cssClass);
		}

		if (textColor == null) {
			vcmsStatusImpl.setTextColor(StringPool.BLANK);
		}
		else {
			vcmsStatusImpl.setTextColor(textColor);
		}

		vcmsStatusImpl.setPosition(position);
		vcmsStatusImpl.setIsPrimary(isPrimary);
		vcmsStatusImpl.setActive(active);

		vcmsStatusImpl.resetOriginalValues();

		return vcmsStatusImpl;
	}

	public long statusId;
	public long companyId;
	public long groupId;
	public long createdDate;
	public String createdByUser;
	public long modifiedDate;
	public String modifiedByUser;
	public String name;
	public String description;
	public String cssClass;
	public String textColor;
	public long position;
	public boolean isPrimary;
	public boolean active;
}