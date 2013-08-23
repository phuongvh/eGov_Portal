/**
 * Copyright Liferay, Inc. All rights reserved.
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

package com.vportal.portlet.edirectory.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.edirectory.model.EDDepartment;

import java.io.Serializable;

import java.util.Date;
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

/**
 * The cache model class for representing EDDepartment in entity cache.
 * 
 * @author HOAN
 * @see EDDepartment
 * @generated
 */
public class EDDepartmentCacheModel implements CacheModel<EDDepartment>,
		Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{id=");
		sb.append(id);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", parent=");
		sb.append(parent);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", levelEd=");
		sb.append(levelEd);
		sb.append(", email=");
		sb.append(email);
		sb.append(", address=");
		sb.append(address);
		sb.append(", description=");
		sb.append(description);
		sb.append(", website=");
		sb.append(website);
		sb.append(", imgurl=");
		sb.append(imgurl);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", domainId=");
		sb.append(domainId);
		sb.append("}");

		return sb.toString();
	}

	public EDDepartment toEntityModel() {
		EDDepartmentImpl edDepartmentImpl = new EDDepartmentImpl();

		edDepartmentImpl.setId(id);

		if (createdDate == Long.MIN_VALUE) {
			edDepartmentImpl.setCreatedDate(null);
		} else {
			edDepartmentImpl.setCreatedDate(new Date(createdDate));
		}

		if (name == null) {
			edDepartmentImpl.setName(StringPool.BLANK);
		} else {
			edDepartmentImpl.setName(name);
		}

		edDepartmentImpl.setParent(parent);

		if (phone == null) {
			edDepartmentImpl.setPhone(StringPool.BLANK);
		} else {
			edDepartmentImpl.setPhone(phone);
		}

		if (fax == null) {
			edDepartmentImpl.setFax(StringPool.BLANK);
		} else {
			edDepartmentImpl.setFax(fax);
		}

		edDepartmentImpl.setLevelEd(levelEd);

		if (email == null) {
			edDepartmentImpl.setEmail(StringPool.BLANK);
		} else {
			edDepartmentImpl.setEmail(email);
		}

		if (address == null) {
			edDepartmentImpl.setAddress(StringPool.BLANK);
		} else {
			edDepartmentImpl.setAddress(address);
		}

		if (description == null) {
			edDepartmentImpl.setDescription(StringPool.BLANK);
		} else {
			edDepartmentImpl.setDescription(description);
		}

		if (website == null) {
			edDepartmentImpl.setWebsite(StringPool.BLANK);
		} else {
			edDepartmentImpl.setWebsite(website);
		}

		if (imgurl == null) {
			edDepartmentImpl.setImgurl(StringPool.BLANK);
		} else {
			edDepartmentImpl.setImgurl(imgurl);
		}

		edDepartmentImpl.setCompanyId(companyId);
		edDepartmentImpl.setGroupId(groupId);
		edDepartmentImpl.setUserId(userId);

		if (languageId == null) {
			edDepartmentImpl.setLanguageId(StringPool.BLANK);
		} else {
			edDepartmentImpl.setLanguageId(languageId);
		}

		if (domainId == null) {
			edDepartmentImpl.setDomainId(StringPool.BLANK);
		} else {
			edDepartmentImpl.setDomainId(domainId);
		}

		edDepartmentImpl.resetOriginalValues();

		return edDepartmentImpl;
	}

	public long id;
	public long createdDate;
	public String name;
	public long parent;
	public String phone;
	public String fax;
	public long levelEd;
	public String email;
	public String address;
	public String description;
	public String website;
	public String imgurl;
	public long companyId;
	public long groupId;
	public long userId;
	public String languageId;
	public String domainId;
}