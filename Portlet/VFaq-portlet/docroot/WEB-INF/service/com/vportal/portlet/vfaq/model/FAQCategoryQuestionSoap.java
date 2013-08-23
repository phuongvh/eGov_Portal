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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    DucNN
 * @generated
 */
public class FAQCategoryQuestionSoap implements Serializable {
	public static FAQCategoryQuestionSoap toSoapModel(FAQCategoryQuestion model) {
		FAQCategoryQuestionSoap soapModel = new FAQCategoryQuestionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setCategoryId(model.getCategoryId());

		return soapModel;
	}

	public static FAQCategoryQuestionSoap[] toSoapModels(
		FAQCategoryQuestion[] models) {
		FAQCategoryQuestionSoap[] soapModels = new FAQCategoryQuestionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FAQCategoryQuestionSoap[][] toSoapModels(
		FAQCategoryQuestion[][] models) {
		FAQCategoryQuestionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FAQCategoryQuestionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FAQCategoryQuestionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FAQCategoryQuestionSoap[] toSoapModels(
		List<FAQCategoryQuestion> models) {
		List<FAQCategoryQuestionSoap> soapModels = new ArrayList<FAQCategoryQuestionSoap>(models.size());

		for (FAQCategoryQuestion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FAQCategoryQuestionSoap[soapModels.size()]);
	}

	public FAQCategoryQuestionSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	private String _uuid;
	private long _id;
	private long _questionId;
	private long _categoryId;
}