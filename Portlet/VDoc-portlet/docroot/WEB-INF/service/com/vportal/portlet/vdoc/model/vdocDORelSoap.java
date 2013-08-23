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

package com.vportal.portlet.vdoc.model;

import com.vportal.portlet.vdoc.service.persistence.vdocDORelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.vportal.portlet.vdoc.service.http.vdocDORelServiceSoap}.
 *
 * @author    MrEn
 * @see       com.vportal.portlet.vdoc.service.http.vdocDORelServiceSoap
 * @generated
 */
public class vdocDORelSoap implements Serializable {
	public static vdocDORelSoap toSoapModel(vdocDORel model) {
		vdocDORelSoap soapModel = new vdocDORelSoap();

		soapModel.setDocId(model.getDocId());
		soapModel.setOrgId(model.getOrgId());

		return soapModel;
	}

	public static vdocDORelSoap[] toSoapModels(vdocDORel[] models) {
		vdocDORelSoap[] soapModels = new vdocDORelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static vdocDORelSoap[][] toSoapModels(vdocDORel[][] models) {
		vdocDORelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new vdocDORelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new vdocDORelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static vdocDORelSoap[] toSoapModels(List<vdocDORel> models) {
		List<vdocDORelSoap> soapModels = new ArrayList<vdocDORelSoap>(models.size());

		for (vdocDORel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new vdocDORelSoap[soapModels.size()]);
	}

	public vdocDORelSoap() {
	}

	public vdocDORelPK getPrimaryKey() {
		return new vdocDORelPK(_docId, _orgId);
	}

	public void setPrimaryKey(vdocDORelPK pk) {
		setDocId(pk.docId);
		setOrgId(pk.orgId);
	}

	public String getDocId() {
		return _docId;
	}

	public void setDocId(String docId) {
		_docId = docId;
	}

	public String getOrgId() {
		return _orgId;
	}

	public void setOrgId(String orgId) {
		_orgId = orgId;
	}

	private String _docId;
	private String _orgId;
}