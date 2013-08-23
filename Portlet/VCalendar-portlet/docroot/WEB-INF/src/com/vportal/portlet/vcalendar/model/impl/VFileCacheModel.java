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

import com.vportal.portlet.vcalendar.model.VFile;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VFile in entity cache.
 *
 * @author LongLH
 * @see VFile
 * @generated
 */
public class VFileCacheModel implements CacheModel<VFile>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{fileId=");
		sb.append(fileId);
		sb.append(", fullname=");
		sb.append(fullname);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", address=");
		sb.append(address);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", position=");
		sb.append(position);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public VFile toEntityModel() {
		VFileImpl vFileImpl = new VFileImpl();

		vFileImpl.setFileId(fileId);

		if (fullname == null) {
			vFileImpl.setFullname(StringPool.BLANK);
		}
		else {
			vFileImpl.setFullname(fullname);
		}

		if (phone == null) {
			vFileImpl.setPhone(StringPool.BLANK);
		}
		else {
			vFileImpl.setPhone(phone);
		}

		if (address == null) {
			vFileImpl.setAddress(StringPool.BLANK);
		}
		else {
			vFileImpl.setAddress(address);
		}

		if (birthday == Long.MIN_VALUE) {
			vFileImpl.setBirthday(null);
		}
		else {
			vFileImpl.setBirthday(new Date(birthday));
		}

		if (position == null) {
			vFileImpl.setPosition(StringPool.BLANK);
		}
		else {
			vFileImpl.setPosition(position);
		}

		vFileImpl.setStatus(status);

		vFileImpl.resetOriginalValues();

		return vFileImpl;
	}

	public long fileId;
	public String fullname;
	public String phone;
	public String address;
	public long birthday;
	public String position;
	public long status;
}