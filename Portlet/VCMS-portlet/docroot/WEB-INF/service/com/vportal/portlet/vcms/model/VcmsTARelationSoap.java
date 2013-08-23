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

import com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vcms.service.http.VcmsTARelationServiceSoap}.
 *
 * @author    hai
 * @see       com.vportal.portlet.vcms.service.http.VcmsTARelationServiceSoap
 * @generated
 */
public class VcmsTARelationSoap implements Serializable {
	public static VcmsTARelationSoap toSoapModel(VcmsTARelation model) {
		VcmsTARelationSoap soapModel = new VcmsTARelationSoap();

		soapModel.setThreadId(model.getThreadId());
		soapModel.setArticleId(model.getArticleId());

		return soapModel;
	}

	public static VcmsTARelationSoap[] toSoapModels(VcmsTARelation[] models) {
		VcmsTARelationSoap[] soapModels = new VcmsTARelationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VcmsTARelationSoap[][] toSoapModels(VcmsTARelation[][] models) {
		VcmsTARelationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VcmsTARelationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VcmsTARelationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VcmsTARelationSoap[] toSoapModels(List<VcmsTARelation> models) {
		List<VcmsTARelationSoap> soapModels = new ArrayList<VcmsTARelationSoap>(models.size());

		for (VcmsTARelation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VcmsTARelationSoap[soapModels.size()]);
	}

	public VcmsTARelationSoap() {
	}

	public VcmsTARelationPK getPrimaryKey() {
		return new VcmsTARelationPK(_threadId, _articleId);
	}

	public void setPrimaryKey(VcmsTARelationPK pk) {
		setThreadId(pk.threadId);
		setArticleId(pk.articleId);
	}

	public String getThreadId() {
		return _threadId;
	}

	public void setThreadId(String threadId) {
		_threadId = threadId;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	private String _threadId;
	private String _articleId;
}