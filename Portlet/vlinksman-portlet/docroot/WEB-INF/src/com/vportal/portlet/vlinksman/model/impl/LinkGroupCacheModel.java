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

package com.vportal.portlet.vlinksman.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vlinksman.model.LinkGroup;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LinkGroup in entity cache.
 *
 * @author LongLH
 * @see LinkGroup
 * @generated
 */
public class LinkGroupCacheModel implements CacheModel<LinkGroup>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{linkgroupId=");
		sb.append(linkgroupId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public LinkGroup toEntityModel() {
		LinkGroupImpl linkGroupImpl = new LinkGroupImpl();

		linkGroupImpl.setLinkgroupId(linkgroupId);
		linkGroupImpl.setGroupId(groupId);
		linkGroupImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			linkGroupImpl.setCreatedDate(null);
		}
		else {
			linkGroupImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			linkGroupImpl.setModifiedDate(null);
		}
		else {
			linkGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			linkGroupImpl.setName(StringPool.BLANK);
		}
		else {
			linkGroupImpl.setName(name);
		}

		if (description == null) {
			linkGroupImpl.setDescription(StringPool.BLANK);
		}
		else {
			linkGroupImpl.setDescription(description);
		}

		linkGroupImpl.resetOriginalValues();

		return linkGroupImpl;
	}

	public long linkgroupId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public long modifiedDate;
	public String name;
	public String description;
}