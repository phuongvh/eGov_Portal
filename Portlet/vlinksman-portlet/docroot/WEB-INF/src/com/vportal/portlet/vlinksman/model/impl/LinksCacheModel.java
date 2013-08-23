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

package com.vportal.portlet.vlinksman.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vlinksman.model.Links;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Links in entity cache.
 *
 * @author LongLH
 * @see Links
 * @generated
 */
public class LinksCacheModel implements CacheModel<Links>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{linkId=");
		sb.append(linkId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", linkgroupId=");
		sb.append(linkgroupId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", url=");
		sb.append(url);
		sb.append(", position=");
		sb.append(position);
		sb.append(", hasImage=");
		sb.append(hasImage);
		sb.append(", isTargetBlank=");
		sb.append(isTargetBlank);
		sb.append(", imageName=");
		sb.append(imageName);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append("}");

		return sb.toString();
	}

	public Links toEntityModel() {
		LinksImpl linksImpl = new LinksImpl();

		linksImpl.setLinkId(linkId);
		linksImpl.setGroupId(groupId);
		linksImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			linksImpl.setCreatedDate(null);
		}
		else {
			linksImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			linksImpl.setModifiedDate(null);
		}
		else {
			linksImpl.setModifiedDate(new Date(modifiedDate));
		}

		linksImpl.setLinkgroupId(linkgroupId);

		if (name == null) {
			linksImpl.setName(StringPool.BLANK);
		}
		else {
			linksImpl.setName(name);
		}

		if (description == null) {
			linksImpl.setDescription(StringPool.BLANK);
		}
		else {
			linksImpl.setDescription(description);
		}

		if (url == null) {
			linksImpl.setUrl(StringPool.BLANK);
		}
		else {
			linksImpl.setUrl(url);
		}

		linksImpl.setPosition(position);
		linksImpl.setHasImage(hasImage);
		linksImpl.setIsTargetBlank(isTargetBlank);

		if (imageName == null) {
			linksImpl.setImageName(StringPool.BLANK);
		}
		else {
			linksImpl.setImageName(imageName);
		}

		linksImpl.setFolderId(folderId);

		linksImpl.resetOriginalValues();

		return linksImpl;
	}

	public long linkId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public long modifiedDate;
	public long linkgroupId;
	public String name;
	public String description;
	public String url;
	public long position;
	public boolean hasImage;
	public boolean isTargetBlank;
	public String imageName;
	public long folderId;
}