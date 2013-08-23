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

package com.vportal.portlet.vfaq.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.vportal.portlet.vfaq.service.FAQCategoryQuestionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author DucNN
 */
public class FAQCategoryQuestionClp extends BaseModelImpl<FAQCategoryQuestion>
	implements FAQCategoryQuestion {
	public FAQCategoryQuestionClp() {
	}

	public Class<?> getModelClass() {
		return FAQCategoryQuestion.class;
	}

	public String getModelClassName() {
		return FAQCategoryQuestion.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			FAQCategoryQuestionLocalServiceUtil.addFAQCategoryQuestion(this);
		}
		else {
			FAQCategoryQuestionLocalServiceUtil.updateFAQCategoryQuestion(this);
		}
	}

	@Override
	public FAQCategoryQuestion toEscapedModel() {
		return (FAQCategoryQuestion)Proxy.newProxyInstance(FAQCategoryQuestion.class.getClassLoader(),
			new Class[] { FAQCategoryQuestion.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FAQCategoryQuestionClp clone = new FAQCategoryQuestionClp();

		clone.setUuid(getUuid());
		clone.setId(getId());
		clone.setQuestionId(getQuestionId());
		clone.setCategoryId(getCategoryId());

		return clone;
	}

	public int compareTo(FAQCategoryQuestion faqCategoryQuestion) {
		long primaryKey = faqCategoryQuestion.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		FAQCategoryQuestionClp faqCategoryQuestion = null;

		try {
			faqCategoryQuestion = (FAQCategoryQuestionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = faqCategoryQuestion.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", questionId=");
		sb.append(getQuestionId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.vportal.portlet.vfaq.model.FAQCategoryQuestion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionId</column-name><column-value><![CDATA[");
		sb.append(getQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _id;
	private long _questionId;
	private long _categoryId;
}