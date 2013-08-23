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

import com.vportal.portlet.vcms.model.VcmsPARelation;

import java.io.Serializable;

/**
 * The cache model class for representing VcmsPARelation in entity cache.
 *
 * @author hai
 * @see VcmsPARelation
 * @generated
 */
public class VcmsPARelationCacheModel implements CacheModel<VcmsPARelation>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{portionId=");
		sb.append(portionId);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append("}");

		return sb.toString();
	}

	public VcmsPARelation toEntityModel() {
		VcmsPARelationImpl vcmsPARelationImpl = new VcmsPARelationImpl();

		if (portionId == null) {
			vcmsPARelationImpl.setPortionId(StringPool.BLANK);
		}
		else {
			vcmsPARelationImpl.setPortionId(portionId);
		}

		if (articleId == null) {
			vcmsPARelationImpl.setArticleId(StringPool.BLANK);
		}
		else {
			vcmsPARelationImpl.setArticleId(articleId);
		}

		vcmsPARelationImpl.resetOriginalValues();

		return vcmsPARelationImpl;
	}

	public String portionId;
	public String articleId;
}