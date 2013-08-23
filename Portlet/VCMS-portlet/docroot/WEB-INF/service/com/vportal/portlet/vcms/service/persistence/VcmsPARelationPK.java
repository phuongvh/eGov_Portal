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

package com.vportal.portlet.vcms.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author hai
 */
public class VcmsPARelationPK implements Comparable<VcmsPARelationPK>,
	Serializable {
	public String portionId;
	public String articleId;

	public VcmsPARelationPK() {
	}

	public VcmsPARelationPK(String portionId, String articleId) {
		this.portionId = portionId;
		this.articleId = articleId;
	}

	public String getPortionId() {
		return portionId;
	}

	public void setPortionId(String portionId) {
		this.portionId = portionId;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public int compareTo(VcmsPARelationPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = portionId.compareTo(pk.portionId);

		if (value != 0) {
			return value;
		}

		value = articleId.compareTo(pk.articleId);

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

		VcmsPARelationPK pk = null;

		try {
			pk = (VcmsPARelationPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((portionId.equals(pk.portionId)) &&
				(articleId.equals(pk.articleId))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(portionId) + String.valueOf(articleId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("portionId");
		sb.append(StringPool.EQUAL);
		sb.append(portionId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("articleId");
		sb.append(StringPool.EQUAL);
		sb.append(articleId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}