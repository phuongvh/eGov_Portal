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

package com.vportal.portlet.vsitemap.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vsitemap.model.VsmBranch;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VsmBranch in entity cache.
 *
 * @author LongLH
 * @see VsmBranch
 * @generated
 */
public class VsmBranchCacheModel implements CacheModel<VsmBranch>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{branchId=");
		sb.append(branchId);
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
		sb.append(", hasIcon=");
		sb.append(hasIcon);
		sb.append(", icon=");
		sb.append(icon);
		sb.append(", position=");
		sb.append(position);
		sb.append("}");

		return sb.toString();
	}

	public VsmBranch toEntityModel() {
		VsmBranchImpl vsmBranchImpl = new VsmBranchImpl();

		vsmBranchImpl.setBranchId(branchId);
		vsmBranchImpl.setGroupId(groupId);
		vsmBranchImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			vsmBranchImpl.setCreatedDate(null);
		}
		else {
			vsmBranchImpl.setCreatedDate(new Date(createdDate));
		}

		vsmBranchImpl.setCreatedByUser(createdByUser);

		if (modifiedDate == Long.MIN_VALUE) {
			vsmBranchImpl.setModifiedDate(null);
		}
		else {
			vsmBranchImpl.setModifiedDate(new Date(modifiedDate));
		}

		vsmBranchImpl.setModifiedByUser(modifiedByUser);
		vsmBranchImpl.setParentId(parentId);

		if (name == null) {
			vsmBranchImpl.setName(StringPool.BLANK);
		}
		else {
			vsmBranchImpl.setName(name);
		}

		if (description == null) {
			vsmBranchImpl.setDescription(StringPool.BLANK);
		}
		else {
			vsmBranchImpl.setDescription(description);
		}

		vsmBranchImpl.setAnchored(anchored);

		if (href == null) {
			vsmBranchImpl.setHref(StringPool.BLANK);
		}
		else {
			vsmBranchImpl.setHref(href);
		}

		if (language == null) {
			vsmBranchImpl.setLanguage(StringPool.BLANK);
		}
		else {
			vsmBranchImpl.setLanguage(language);
		}

		vsmBranchImpl.setHasIcon(hasIcon);

		if (icon == null) {
			vsmBranchImpl.setIcon(StringPool.BLANK);
		}
		else {
			vsmBranchImpl.setIcon(icon);
		}

		vsmBranchImpl.setPosition(position);

		vsmBranchImpl.resetOriginalValues();

		return vsmBranchImpl;
	}

	public long branchId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public long createdByUser;
	public long modifiedDate;
	public long modifiedByUser;
	public long parentId;
	public String name;
	public String description;
	public boolean anchored;
	public String href;
	public String language;
	public boolean hasIcon;
	public String icon;
	public long position;
}