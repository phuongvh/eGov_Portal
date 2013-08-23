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

import com.vportal.portlet.vcms.model.VcmsLogger;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsLogger in entity cache.
 *
 * @author hai
 * @see VcmsLogger
 * @generated
 */
public class VcmsLoggerCacheModel implements CacheModel<VcmsLogger>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{loggerId=");
		sb.append(loggerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	public VcmsLogger toEntityModel() {
		VcmsLoggerImpl vcmsLoggerImpl = new VcmsLoggerImpl();

		if (loggerId == null) {
			vcmsLoggerImpl.setLoggerId(StringPool.BLANK);
		}
		else {
			vcmsLoggerImpl.setLoggerId(loggerId);
		}

		vcmsLoggerImpl.setGroupId(groupId);
		vcmsLoggerImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			vcmsLoggerImpl.setCreatedDate(null);
		}
		else {
			vcmsLoggerImpl.setCreatedDate(new Date(createdDate));
		}

		if (createdByUser == null) {
			vcmsLoggerImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			vcmsLoggerImpl.setCreatedByUser(createdByUser);
		}

		if (content == null) {
			vcmsLoggerImpl.setContent(StringPool.BLANK);
		}
		else {
			vcmsLoggerImpl.setContent(content);
		}

		vcmsLoggerImpl.resetOriginalValues();

		return vcmsLoggerImpl;
	}

	public String loggerId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public String createdByUser;
	public String content;
}