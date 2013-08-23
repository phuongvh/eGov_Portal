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

import com.vportal.portlet.vcms.model.VcmsThread;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VcmsThread in entity cache.
 *
 * @author hai
 * @see VcmsThread
 * @generated
 */
public class VcmsThreadCacheModel implements CacheModel<VcmsThread>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{threadId=");
		sb.append(threadId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", hasImage=");
		sb.append(hasImage);
		sb.append(", image=");
		sb.append(image);
		sb.append(", language=");
		sb.append(language);
		sb.append("}");

		return sb.toString();
	}

	public VcmsThread toEntityModel() {
		VcmsThreadImpl vcmsThreadImpl = new VcmsThreadImpl();

		if (threadId == null) {
			vcmsThreadImpl.setThreadId(StringPool.BLANK);
		}
		else {
			vcmsThreadImpl.setThreadId(threadId);
		}

		vcmsThreadImpl.setGroupId(groupId);
		vcmsThreadImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			vcmsThreadImpl.setCreatedDate(null);
		}
		else {
			vcmsThreadImpl.setCreatedDate(new Date(createdDate));
		}

		if (createdByUser == null) {
			vcmsThreadImpl.setCreatedByUser(StringPool.BLANK);
		}
		else {
			vcmsThreadImpl.setCreatedByUser(createdByUser);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vcmsThreadImpl.setModifiedDate(null);
		}
		else {
			vcmsThreadImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (modifiedByUser == null) {
			vcmsThreadImpl.setModifiedByUser(StringPool.BLANK);
		}
		else {
			vcmsThreadImpl.setModifiedByUser(modifiedByUser);
		}

		if (title == null) {
			vcmsThreadImpl.setTitle(StringPool.BLANK);
		}
		else {
			vcmsThreadImpl.setTitle(title);
		}

		if (description == null) {
			vcmsThreadImpl.setDescription(StringPool.BLANK);
		}
		else {
			vcmsThreadImpl.setDescription(description);
		}

		vcmsThreadImpl.setHasImage(hasImage);

		if (image == null) {
			vcmsThreadImpl.setImage(StringPool.BLANK);
		}
		else {
			vcmsThreadImpl.setImage(image);
		}

		if (language == null) {
			vcmsThreadImpl.setLanguage(StringPool.BLANK);
		}
		else {
			vcmsThreadImpl.setLanguage(language);
		}

		vcmsThreadImpl.resetOriginalValues();

		return vcmsThreadImpl;
	}

	public String threadId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public String createdByUser;
	public long modifiedDate;
	public String modifiedByUser;
	public String title;
	public String description;
	public boolean hasImage;
	public String image;
	public String language;
}