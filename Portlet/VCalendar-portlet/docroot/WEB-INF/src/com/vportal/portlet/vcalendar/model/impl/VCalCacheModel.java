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

package com.vportal.portlet.vcalendar.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vcalendar.model.VCal;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VCal in entity cache.
 *
 * @author LongLH
 * @see VCal
 * @generated
 */
public class VCalCacheModel implements CacheModel<VCal>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{calId=");
		sb.append(calId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", guest=");
		sb.append(guest);
		sb.append(", location=");
		sb.append(location);
		sb.append(", time=");
		sb.append(time);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public VCal toEntityModel() {
		VCalImpl vCalImpl = new VCalImpl();

		vCalImpl.setCalId(calId);
		vCalImpl.setGroupId(groupId);
		vCalImpl.setCompanyId(companyId);
		vCalImpl.setUserId(userId);

		if (userName == null) {
			vCalImpl.setUserName(StringPool.BLANK);
		}
		else {
			vCalImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			vCalImpl.setCreateDate(null);
		}
		else {
			vCalImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vCalImpl.setModifiedDate(null);
		}
		else {
			vCalImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (languageId == null) {
			vCalImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			vCalImpl.setLanguageId(languageId);
		}

		vCalImpl.setFileId(fileId);

		if (title == null) {
			vCalImpl.setTitle(StringPool.BLANK);
		}
		else {
			vCalImpl.setTitle(title);
		}

		if (description == null) {
			vCalImpl.setDescription(StringPool.BLANK);
		}
		else {
			vCalImpl.setDescription(description);
		}

		if (guest == null) {
			vCalImpl.setGuest(StringPool.BLANK);
		}
		else {
			vCalImpl.setGuest(guest);
		}

		if (location == null) {
			vCalImpl.setLocation(StringPool.BLANK);
		}
		else {
			vCalImpl.setLocation(location);
		}

		if (time == null) {
			vCalImpl.setTime(StringPool.BLANK);
		}
		else {
			vCalImpl.setTime(time);
		}

		if (startDate == Long.MIN_VALUE) {
			vCalImpl.setStartDate(null);
		}
		else {
			vCalImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			vCalImpl.setEndDate(null);
		}
		else {
			vCalImpl.setEndDate(new Date(endDate));
		}

		vCalImpl.setStatus(status);

		vCalImpl.resetOriginalValues();

		return vCalImpl;
	}

	public long calId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String languageId;
	public long fileId;
	public String title;
	public String description;
	public String guest;
	public String location;
	public String time;
	public long startDate;
	public long endDate;
	public long status;
}