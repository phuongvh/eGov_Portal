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

package com.vportal.portlet.vdoc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vdoc.model.vdocOrg;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing vdocOrg in entity cache.
 *
 * @author MrEn
 * @see vdocOrg
 * @generated
 */
public class vdocOrgCacheModel implements CacheModel<vdocOrg>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{orgId=");
		sb.append(orgId);
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
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", address=");
		sb.append(address);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", language=");
		sb.append(language);
		sb.append(", statusOrg=");
		sb.append(statusOrg);
		sb.append(", position=");
		sb.append(position);
		sb.append(", listparent=");
		sb.append(listparent);
		sb.append("}");

		return sb.toString();
	}

	public vdocOrg toEntityModel() {
		vdocOrgImpl vdocOrgImpl = new vdocOrgImpl();

		if (orgId == null) {
			vdocOrgImpl.setOrgId(StringPool.BLANK);
		}
		else {
			vdocOrgImpl.setOrgId(orgId);
		}

		vdocOrgImpl.setGroupId(groupId);
		vdocOrgImpl.setCompanyId(companyId);
		vdocOrgImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			vdocOrgImpl.setCreatedDate(null);
		}
		else {
			vdocOrgImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vdocOrgImpl.setModifiedDate(null);
		}
		else {
			vdocOrgImpl.setModifiedDate(new Date(modifiedDate));
		}

		vdocOrgImpl.setCreatedByUser(createdByUser);
		vdocOrgImpl.setModifiedByUser(modifiedByUser);

		if (parentId == null) {
			vdocOrgImpl.setParentId(StringPool.BLANK);
		}
		else {
			vdocOrgImpl.setParentId(parentId);
		}

		if (name == null) {
			vdocOrgImpl.setName(StringPool.BLANK);
		}
		else {
			vdocOrgImpl.setName(name);
		}

		if (description == null) {
			vdocOrgImpl.setDescription(StringPool.BLANK);
		}
		else {
			vdocOrgImpl.setDescription(description);
		}

		if (address == null) {
			vdocOrgImpl.setAddress(StringPool.BLANK);
		}
		else {
			vdocOrgImpl.setAddress(address);
		}

		if (phone == null) {
			vdocOrgImpl.setPhone(StringPool.BLANK);
		}
		else {
			vdocOrgImpl.setPhone(phone);
		}

		if (fax == null) {
			vdocOrgImpl.setFax(StringPool.BLANK);
		}
		else {
			vdocOrgImpl.setFax(fax);
		}

		if (language == null) {
			vdocOrgImpl.setLanguage(StringPool.BLANK);
		}
		else {
			vdocOrgImpl.setLanguage(language);
		}

		vdocOrgImpl.setStatusOrg(statusOrg);
		vdocOrgImpl.setPosition(position);

		if (listparent == null) {
			vdocOrgImpl.setListparent(StringPool.BLANK);
		}
		else {
			vdocOrgImpl.setListparent(listparent);
		}

		vdocOrgImpl.resetOriginalValues();

		return vdocOrgImpl;
	}

	public String orgId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long createdByUser;
	public long modifiedByUser;
	public String parentId;
	public String name;
	public String description;
	public String address;
	public String phone;
	public String fax;
	public String language;
	public boolean statusOrg;
	public int position;
	public String listparent;
}