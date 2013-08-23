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

import com.vportal.portlet.vdoc.model.vdocField;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing vdocField in entity cache.
 *
 * @author MrEn
 * @see vdocField
 * @generated
 */
public class vdocFieldCacheModel implements CacheModel<vdocField>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{fieldId=");
		sb.append(fieldId);
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
		sb.append(", language=");
		sb.append(language);
		sb.append(", statusField=");
		sb.append(statusField);
		sb.append(", position=");
		sb.append(position);
		sb.append(", listparent=");
		sb.append(listparent);
		sb.append("}");

		return sb.toString();
	}

	public vdocField toEntityModel() {
		vdocFieldImpl vdocFieldImpl = new vdocFieldImpl();

		if (fieldId == null) {
			vdocFieldImpl.setFieldId(StringPool.BLANK);
		}
		else {
			vdocFieldImpl.setFieldId(fieldId);
		}

		vdocFieldImpl.setGroupId(groupId);
		vdocFieldImpl.setCompanyId(companyId);
		vdocFieldImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			vdocFieldImpl.setCreatedDate(null);
		}
		else {
			vdocFieldImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vdocFieldImpl.setModifiedDate(null);
		}
		else {
			vdocFieldImpl.setModifiedDate(new Date(modifiedDate));
		}

		vdocFieldImpl.setCreatedByUser(createdByUser);
		vdocFieldImpl.setModifiedByUser(modifiedByUser);

		if (parentId == null) {
			vdocFieldImpl.setParentId(StringPool.BLANK);
		}
		else {
			vdocFieldImpl.setParentId(parentId);
		}

		if (name == null) {
			vdocFieldImpl.setName(StringPool.BLANK);
		}
		else {
			vdocFieldImpl.setName(name);
		}

		if (description == null) {
			vdocFieldImpl.setDescription(StringPool.BLANK);
		}
		else {
			vdocFieldImpl.setDescription(description);
		}

		if (language == null) {
			vdocFieldImpl.setLanguage(StringPool.BLANK);
		}
		else {
			vdocFieldImpl.setLanguage(language);
		}

		vdocFieldImpl.setStatusField(statusField);
		vdocFieldImpl.setPosition(position);

		if (listparent == null) {
			vdocFieldImpl.setListparent(StringPool.BLANK);
		}
		else {
			vdocFieldImpl.setListparent(listparent);
		}

		vdocFieldImpl.resetOriginalValues();

		return vdocFieldImpl;
	}

	public String fieldId;
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
	public String language;
	public boolean statusField;
	public int position;
	public String listparent;
}