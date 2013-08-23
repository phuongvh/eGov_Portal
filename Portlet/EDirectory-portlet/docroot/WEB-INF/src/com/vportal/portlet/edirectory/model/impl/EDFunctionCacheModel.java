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

package com.vportal.portlet.edirectory.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.edirectory.model.EDFunction;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing EDFunction in entity cache.
 *
 * @author HOAN
 * @see EDFunction
 * @generated
 */
public class EDFunctionCacheModel implements CacheModel<EDFunction>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", levelEd=");
		sb.append(levelEd);
		sb.append(", isShowTree=");
		sb.append(isShowTree);
		sb.append(", description=");
		sb.append(description);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append("}");

		return sb.toString();
	}

	public EDFunction toEntityModel() {
		EDFunctionImpl edFunctionImpl = new EDFunctionImpl();

		edFunctionImpl.setId(id);

		if (createdDate == Long.MIN_VALUE) {
			edFunctionImpl.setCreatedDate(null);
		}
		else {
			edFunctionImpl.setCreatedDate(new Date(createdDate));
		}

		if (name == null) {
			edFunctionImpl.setName(StringPool.BLANK);
		}
		else {
			edFunctionImpl.setName(name);
		}

		edFunctionImpl.setLevelEd(levelEd);
		edFunctionImpl.setIsShowTree(isShowTree);

		if (description == null) {
			edFunctionImpl.setDescription(StringPool.BLANK);
		}
		else {
			edFunctionImpl.setDescription(description);
		}

		edFunctionImpl.setGroupId(groupId);
		edFunctionImpl.setUserId(userId);
		edFunctionImpl.setCompanyId(companyId);

		if (languageId == null) {
			edFunctionImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			edFunctionImpl.setLanguageId(languageId);
		}

		edFunctionImpl.resetOriginalValues();

		return edFunctionImpl;
	}

	public long id;
	public long createdDate;
	public String name;
	public int levelEd;
	public boolean isShowTree;
	public String description;
	public long groupId;
	public long userId;
	public long companyId;
	public String languageId;
}