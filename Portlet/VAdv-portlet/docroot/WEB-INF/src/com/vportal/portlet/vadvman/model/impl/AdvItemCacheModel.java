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

import com.vportal.portlet.vadvman.model.AdvItem;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AdvItem in entity cache.
 *
 * @author DucNN
 * @see AdvItem
 * @generated
 */
public class AdvItemCacheModel implements CacheModel<AdvItem>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{itemId=");
		sb.append(itemId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", expriedDate=");
		sb.append(expriedDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", url=");
		sb.append(url);
		sb.append(", isTargetBlank=");
		sb.append(isTargetBlank);
		sb.append(", txtMouseOver=");
		sb.append(txtMouseOver);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append("}");

		return sb.toString();
	}

	public AdvItem toEntityModel() {
		AdvItemImpl advItemImpl = new AdvItemImpl();

		advItemImpl.setItemId(itemId);

		if (createDate == Long.MIN_VALUE) {
			advItemImpl.setCreateDate(null);
		}
		else {
			advItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			advItemImpl.setModifiedDate(null);
		}
		else {
			advItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (expriedDate == Long.MIN_VALUE) {
			advItemImpl.setExpriedDate(null);
		}
		else {
			advItemImpl.setExpriedDate(new Date(expriedDate));
		}

		advItemImpl.setGroupId(groupId);
		advItemImpl.setCompanyId(companyId);

		if (name == null) {
			advItemImpl.setName(StringPool.BLANK);
		}
		else {
			advItemImpl.setName(name);
		}

		if (description == null) {
			advItemImpl.setDescription(StringPool.BLANK);
		}
		else {
			advItemImpl.setDescription(description);
		}

		if (url == null) {
			advItemImpl.setUrl(StringPool.BLANK);
		}
		else {
			advItemImpl.setUrl(url);
		}

		advItemImpl.setIsTargetBlank(isTargetBlank);

		if (txtMouseOver == null) {
			advItemImpl.setTxtMouseOver(StringPool.BLANK);
		}
		else {
			advItemImpl.setTxtMouseOver(txtMouseOver);
		}

		advItemImpl.setFolderId(folderId);
		advItemImpl.setStatus(status);
		advItemImpl.setTypeId(typeId);

		advItemImpl.resetOriginalValues();

		return advItemImpl;
	}

	public long itemId;
	public long createDate;
	public long modifiedDate;
	public long expriedDate;
	public long groupId;
	public long companyId;
	public String name;
	public String description;
	public String url;
	public boolean isTargetBlank;
	public String txtMouseOver;
	public long folderId;
	public boolean status;
	public long typeId;
}