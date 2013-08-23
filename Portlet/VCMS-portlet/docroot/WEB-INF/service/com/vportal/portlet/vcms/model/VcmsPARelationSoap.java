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

import com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsPARelationServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsPARelationServiceSoap
 * @generated
 */
public class VcmsPARelationSoap implements Serializable {
	public static VcmsPARelationSoap toSoapModel(VcmsPARelation model) {
		VcmsPARelationSoap soapModel = new VcmsPARelationSoap();

		soapModel.setPortionId(model.getPortionId());
		soapModel.setArticleId(model.getArticleId());

		return soapModel;
	}

	public static VcmsPARelationSoap[] toSoapModels(VcmsPARelation[] models) {
		VcmsPARelationSoap[] soapModels = new VcmsPARelationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsPARelationSoap[][] toSoapModels(VcmsPARelation[][] models) {
		VcmsPARelationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsPARelationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsPARelationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsPARelationSoap[] toSoapModels(List<VcmsPARelation> models) {
		List<VcmsPARelationSoap> soapModels = new ArrayList<VcmsPARelationSoap>(models.size());

		for (VcmsPARelation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsPARelationSoap[soapModels.size()]);
	}

	public VcmsPARelationSoap() {
	}

	public VcmsPARelationPK getPrimaryKey() {
		return new VcmsPARelationPK(_portionId, _articleId);
	}

	public void setPrimaryKey(VcmsPARelationPK pk) {
		setPortionId(pk.portionId);
		setArticleId(pk.articleId);
	}

	public String getPortionId() {
		return _portionId;
	}

	public void setPortionId(String portionId) {
		_portionId = portionId;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	private String _portionId;
	private String _articleId;
}