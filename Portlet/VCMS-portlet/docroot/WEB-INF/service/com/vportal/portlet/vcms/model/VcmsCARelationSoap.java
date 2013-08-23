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

package com.vportal.portlet.vcms.model;

import com.vportal.portlet.vcms.service.persistence.VcmsCARelationPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsCARelationServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsCARelationServiceSoap
 * @generated
 */
public class VcmsCARelationSoap implements Serializable {
	public static VcmsCARelationSoap toSoapModel(VcmsCARelation model) {
		VcmsCARelationSoap soapModel = new VcmsCARelationSoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static VcmsCARelationSoap[] toSoapModels(VcmsCARelation[] models) {
		VcmsCARelationSoap[] soapModels = new VcmsCARelationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsCARelationSoap[][] toSoapModels(VcmsCARelation[][] models) {
		VcmsCARelationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsCARelationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsCARelationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsCARelationSoap[] toSoapModels(List<VcmsCARelation> models) {
		List<VcmsCARelationSoap> soapModels = new ArrayList<VcmsCARelationSoap>(models.size());

		for (VcmsCARelation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsCARelationSoap[soapModels.size()]);
	}

	public VcmsCARelationSoap() {
	}

	public VcmsCARelationPK getPrimaryKey() {
		return new VcmsCARelationPK(_categoryId, _articleId);
	}

	public void setPrimaryKey(VcmsCARelationPK pk) {
		setCategoryId(pk.categoryId);
		setArticleId(pk.articleId);
	}

	public String getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(String categoryId) {
		_categoryId = categoryId;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public String getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		_createdByUser = createdByUser;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	private String _categoryId;
	private String _articleId;
	private Date _createdDate;
	private String _createdByUser;
	private long _status;
}