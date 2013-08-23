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

import com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsArticleTypeServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsArticleTypeServiceSoap
 * @generated
 */
public class VcmsArticleTypeSoap implements Serializable {
	public static VcmsArticleTypeSoap toSoapModel(VcmsArticleType model) {
		VcmsArticleTypeSoap soapModel = new VcmsArticleTypeSoap();

		soapModel.setTypeId(model.getTypeId());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setPosition(model.getPosition());

		return soapModel;
	}

	public static VcmsArticleTypeSoap[] toSoapModels(VcmsArticleType[] models) {
		VcmsArticleTypeSoap[] soapModels = new VcmsArticleTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsArticleTypeSoap[][] toSoapModels(
		VcmsArticleType[][] models) {
		VcmsArticleTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsArticleTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsArticleTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsArticleTypeSoap[] toSoapModels(
		List<VcmsArticleType> models) {
		List<VcmsArticleTypeSoap> soapModels = new ArrayList<VcmsArticleTypeSoap>(models.size());

		for (VcmsArticleType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsArticleTypeSoap[soapModels.size()]);
	}

	public VcmsArticleTypeSoap() {
	}

	public VcmsArticleTypePK getPrimaryKey() {
		return new VcmsArticleTypePK(_typeId, _articleId);
	}

	public void setPrimaryKey(VcmsArticleTypePK pk) {
		setTypeId(pk.typeId);
		setArticleId(pk.articleId);
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	public long getPosition() {
		return _position;
	}

	public void setPosition(long position) {
		_position = position;
	}

	private long _typeId;
	private String _articleId;
	private long _position;
}