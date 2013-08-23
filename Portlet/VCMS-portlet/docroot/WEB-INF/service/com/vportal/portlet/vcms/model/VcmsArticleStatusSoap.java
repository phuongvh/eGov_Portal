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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsArticleStatusServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsArticleStatusServiceSoap
 * @generated
 */
public class VcmsArticleStatusSoap implements Serializable {
	public static VcmsArticleStatusSoap toSoapModel(VcmsArticleStatus model) {
		VcmsArticleStatusSoap soapModel = new VcmsArticleStatusSoap();

		soapModel.setId(model.getId());
		soapModel.setStatusId(model.getStatusId());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setActive(model.getActive());
		soapModel.setArticleVersionId(model.getArticleVersionId());

		return soapModel;
	}

	public static VcmsArticleStatusSoap[] toSoapModels(
		VcmsArticleStatus[] models) {
		VcmsArticleStatusSoap[] soapModels = new VcmsArticleStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsArticleStatusSoap[][] toSoapModels(
		VcmsArticleStatus[][] models) {
		VcmsArticleStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsArticleStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsArticleStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsArticleStatusSoap[] toSoapModels(
		List<VcmsArticleStatus> models) {
		List<VcmsArticleStatusSoap> soapModels = new ArrayList<VcmsArticleStatusSoap>(models.size());

		for (VcmsArticleStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsArticleStatusSoap[soapModels.size()]);
	}

	public VcmsArticleStatusSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getStatusId() {
		return _statusId;
	}

	public void setStatusId(long statusId) {
		_statusId = statusId;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	public String getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(String categoryId) {
		_categoryId = categoryId;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public long getArticleVersionId() {
		return _articleVersionId;
	}

	public void setArticleVersionId(long articleVersionId) {
		_articleVersionId = articleVersionId;
	}

	private long _id;
	private long _statusId;
	private String _articleId;
	private String _categoryId;
	private Date _createdDate;
	private String _createdByUser;
	private boolean _active;
	private long _articleVersionId;
}