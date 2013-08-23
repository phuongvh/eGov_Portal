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

import com.vportal.portlet.vdoc.model.vdocDORel;

import java.io.Serializable;

/**
 * The cache model class for representing vdocDORel in entity cache.
 *
 * @author MrEn
 * @see vdocDORel
 * @generated
 */
public class vdocDORelCacheModel implements CacheModel<vdocDORel>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{docId=");
		sb.append(docId);
		sb.append(", orgId=");
		sb.append(orgId);
		sb.append("}");

		return sb.toString();
	}

	public vdocDORel toEntityModel() {
		vdocDORelImpl vdocDORelImpl = new vdocDORelImpl();

		if (docId == null) {
			vdocDORelImpl.setDocId(StringPool.BLANK);
		}
		else {
			vdocDORelImpl.setDocId(docId);
		}

		if (orgId == null) {
			vdocDORelImpl.setOrgId(StringPool.BLANK);
		}
		else {
			vdocDORelImpl.setOrgId(orgId);
		}

		vdocDORelImpl.resetOriginalValues();

		return vdocDORelImpl;
	}

	public String docId;
	public String orgId;
}