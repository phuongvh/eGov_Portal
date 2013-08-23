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

package com.vportal.portlet.vdoc.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author MrEn
 */
public class vdocDORelPK implements Comparable<vdocDORelPK>, Serializable {
	public String docId;
	public String orgId;

	public vdocDORelPK() {
	}

	public vdocDORelPK(String docId, String orgId) {
		this.docId = docId;
		this.orgId = orgId;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public int compareTo(vdocDORelPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = docId.compareTo(pk.docId);

		if (value != 0) {
			return value;
		}

		value = orgId.compareTo(pk.orgId);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		vdocDORelPK pk = null;

		try {
			pk = (vdocDORelPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((docId.equals(pk.docId)) && (orgId.equals(pk.orgId))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(docId) + String.valueOf(orgId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("docId");
		sb.append(StringPool.EQUAL);
		sb.append(docId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("orgId");
		sb.append(StringPool.EQUAL);
		sb.append(orgId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}