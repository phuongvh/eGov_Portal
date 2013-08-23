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

import com.vportal.portlet.vcms.model.VcmsArticleType;

import java.io.Serializable;

/**
 * The cache model class for representing VcmsArticleType in entity cache.
 *
 * @author hai
 * @see VcmsArticleType
 * @generated
 */
public class VcmsArticleTypeCacheModel implements CacheModel<VcmsArticleType>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{typeId=");
		sb.append(typeId);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", position=");
		sb.append(position);
		sb.append("}");

		return sb.toString();
	}

	public VcmsArticleType toEntityModel() {
		VcmsArticleTypeImpl vcmsArticleTypeImpl = new VcmsArticleTypeImpl();

		vcmsArticleTypeImpl.setTypeId(typeId);

		if (articleId == null) {
			vcmsArticleTypeImpl.setArticleId(StringPool.BLANK);
		}
		else {
			vcmsArticleTypeImpl.setArticleId(articleId);
		}

		vcmsArticleTypeImpl.setPosition(position);

		vcmsArticleTypeImpl.resetOriginalValues();

		return vcmsArticleTypeImpl;
	}

	public long typeId;
	public String articleId;
	public long position;
}