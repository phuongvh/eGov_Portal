/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.vportal.portlet.vcontact.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vcontact.model.VContact;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VContact in entity cache.
 *
 * @author LongLH
 * @see VContact
 * @generated
 */
public class VContactCacheModel implements CacheModel<VContact>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", guestName=");
		sb.append(guestName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", title=");
		sb.append(title);
		sb.append(", address=");
		sb.append(address);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", content=");
		sb.append(content);
		sb.append(", hasAttach=");
		sb.append(hasAttach);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public VContact toEntityModel() {
		VContactImpl vContactImpl = new VContactImpl();

		vContactImpl.setId(id);
		vContactImpl.setGroupId(groupId);
		vContactImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			vContactImpl.setCreatedDate(null);
		}
		else {
			vContactImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vContactImpl.setModifiedDate(null);
		}
		else {
			vContactImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (guestName == null) {
			vContactImpl.setGuestName(StringPool.BLANK);
		}
		else {
			vContactImpl.setGuestName(guestName);
		}

		if (email == null) {
			vContactImpl.setEmail(StringPool.BLANK);
		}
		else {
			vContactImpl.setEmail(email);
		}

		if (title == null) {
			vContactImpl.setTitle(StringPool.BLANK);
		}
		else {
			vContactImpl.setTitle(title);
		}

		if (address == null) {
			vContactImpl.setAddress(StringPool.BLANK);
		}
		else {
			vContactImpl.setAddress(address);
		}

		if (phone == null) {
			vContactImpl.setPhone(StringPool.BLANK);
		}
		else {
			vContactImpl.setPhone(phone);
		}

		if (fax == null) {
			vContactImpl.setFax(StringPool.BLANK);
		}
		else {
			vContactImpl.setFax(fax);
		}

		if (content == null) {
			vContactImpl.setContent(StringPool.BLANK);
		}
		else {
			vContactImpl.setContent(content);
		}

		vContactImpl.setHasAttach(hasAttach);
		vContactImpl.setStatus(status);

		vContactImpl.resetOriginalValues();

		return vContactImpl;
	}

	public long id;
	public long groupId;
	public long companyId;
	public long createdDate;
	public long modifiedDate;
	public String guestName;
	public String email;
	public String title;
	public String address;
	public String phone;
	public String fax;
	public String content;
	public boolean hasAttach;
	public int status;
}