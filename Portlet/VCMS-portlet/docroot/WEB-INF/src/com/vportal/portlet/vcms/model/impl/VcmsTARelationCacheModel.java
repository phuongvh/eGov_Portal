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

import com.vportal.portlet.vcms.model.VcmsTARelation;

import java.io.Serializable;

/**
 * The cache model class for representing VcmsTARelation in entity cache.
 *
 * @author hai
 * @see VcmsTARelation
 * @generated
 */
public class VcmsTARelationCacheModel implements CacheModel<VcmsTARelation>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{threadId=");
		sb.append(threadId);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append("}");

		return sb.toString();
	}

	public VcmsTARelation toEntityModel() {
		VcmsTARelationImpl vcmsTARelationImpl = new VcmsTARelationImpl();

		if (threadId == null) {
			vcmsTARelationImpl.setThreadId(StringPool.BLANK);
		}
		else {
			vcmsTARelationImpl.setThreadId(threadId);
		}

		if (articleId == null) {
			vcmsTARelationImpl.setArticleId(StringPool.BLANK);
		}
		else {
			vcmsTARelationImpl.setArticleId(articleId);
		}

		vcmsTARelationImpl.resetOriginalValues();

		return vcmsTARelationImpl;
	}

	public String threadId;
	public String articleId;
}