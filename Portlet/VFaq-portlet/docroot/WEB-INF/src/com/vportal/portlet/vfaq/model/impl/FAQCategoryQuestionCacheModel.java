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

package com.vportal.portlet.vfaq.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.vportal.portlet.vfaq.model.FAQCategoryQuestion;

import java.io.Serializable;

/**
 * The cache model class for representing FAQCategoryQuestion in entity cache.
 *
 * @author DucNN
 * @see FAQCategoryQuestion
 * @generated
 */
public class FAQCategoryQuestionCacheModel implements CacheModel<FAQCategoryQuestion>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append("}");

		return sb.toString();
	}

	public FAQCategoryQuestion toEntityModel() {
		FAQCategoryQuestionImpl faqCategoryQuestionImpl = new FAQCategoryQuestionImpl();

		if (uuid == null) {
			faqCategoryQuestionImpl.setUuid(StringPool.BLANK);
		}
		else {
			faqCategoryQuestionImpl.setUuid(uuid);
		}

		faqCategoryQuestionImpl.setId(id);
		faqCategoryQuestionImpl.setQuestionId(questionId);
		faqCategoryQuestionImpl.setCategoryId(categoryId);

		faqCategoryQuestionImpl.resetOriginalValues();

		return faqCategoryQuestionImpl;
	}

	public String uuid;
	public long id;
	public long questionId;
	public long categoryId;
}