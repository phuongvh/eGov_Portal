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

import com.vportal.portlet.vdoc.model.vdocLogger;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing vdocLogger in entity cache.
 *
 * @author MrEn
 * @see vdocLogger
 * @generated
 */
public class vdocLoggerCacheModel implements CacheModel<vdocLogger>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{loggerId=");
		sb.append(loggerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	public vdocLogger toEntityModel() {
		vdocLoggerImpl vdocLoggerImpl = new vdocLoggerImpl();

		if (loggerId == null) {
			vdocLoggerImpl.setLoggerId(StringPool.BLANK);
		}
		else {
			vdocLoggerImpl.setLoggerId(loggerId);
		}

		vdocLoggerImpl.setGroupId(groupId);
		vdocLoggerImpl.setCompanyId(companyId);
		vdocLoggerImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			vdocLoggerImpl.setCreatedDate(null);
		}
		else {
			vdocLoggerImpl.setCreatedDate(new Date(createdDate));
		}

		vdocLoggerImpl.setCreatedByUser(createdByUser);

		if (content == null) {
			vdocLoggerImpl.setContent(StringPool.BLANK);
		}
		else {
			vdocLoggerImpl.setContent(content);
		}

		vdocLoggerImpl.resetOriginalValues();

		return vdocLoggerImpl;
	}

	public String loggerId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long createdByUser;
	public String content;
}