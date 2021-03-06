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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK;

import java.io.Serializable;

/**
 * The base model interface for the VcmsTARelation service. Represents a row in the &quot;VcmsTARelation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.vportal.portlet.vcms.model.impl.VcmsTARelationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.vportal.portlet.vcms.model.impl.VcmsTARelationImpl}.
 * </p>
 *
 * @author hai
 * @see VcmsTARelation
 * @see com.vportal.portlet.vcms.model.impl.VcmsTARelationImpl
 * @see com.vportal.portlet.vcms.model.impl.VcmsTARelationModelImpl
 * @generated
 */
public interface VcmsTARelationModel extends BaseModel<VcmsTARelation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vcms t a relation model instance should use the {@link VcmsTARelation} interface instead.
	 */

	/**
	 * Returns the primary key of this vcms t a relation.
	 *
	 * @return the primary key of this vcms t a relation
	 */
	public VcmsTARelationPK getPrimaryKey();

	/**
	 * Sets the primary key of this vcms t a relation.
	 *
	 * @param primaryKey the primary key of this vcms t a relation
	 */
	public void setPrimaryKey(VcmsTARelationPK primaryKey);

	/**
	 * Returns the thread ID of this vcms t a relation.
	 *
	 * @return the thread ID of this vcms t a relation
	 */
	@AutoEscape
	public String getThreadId();

	/**
	 * Sets the thread ID of this vcms t a relation.
	 *
	 * @param threadId the thread ID of this vcms t a relation
	 */
	public void setThreadId(String threadId);

	/**
	 * Returns the article ID of this vcms t a relation.
	 *
	 * @return the article ID of this vcms t a relation
	 */
	@AutoEscape
	public String getArticleId();

	/**
	 * Sets the article ID of this vcms t a relation.
	 *
	 * @param articleId the article ID of this vcms t a relation
	 */
	public void setArticleId(String articleId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(VcmsTARelation vcmsTARelation);

	public int hashCode();

	public CacheModel<VcmsTARelation> toCacheModel();

	public VcmsTARelation toEscapedModel();

	public String toString();

	public String toXmlString();
}