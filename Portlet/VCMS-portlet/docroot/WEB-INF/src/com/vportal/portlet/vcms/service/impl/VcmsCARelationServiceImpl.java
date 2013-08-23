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

package com.vportal.portlet.vcms.service.impl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.vportal.portlet.vcms.model.VcmsCARelation;
import com.vportal.portlet.vcms.service.base.VcmsCARelationServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsCARelationPK;

/**
 * The implementation of the vcms c a relation remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsCARelationService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsCARelationServiceUtil} to access
 * the vcms c a relation remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsCARelationServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsCARelationServiceUtil
 */
public class VcmsCARelationServiceImpl extends VcmsCARelationServiceBaseImpl {
	public VcmsCARelation addRelation(String categoryId, String articleId,
			long statusId) throws PortalException, SystemException,
			RemoteException {

		VcmsCARelation relation = null;

		VcmsCARelationPK primaryKey = new VcmsCARelationPK(categoryId,
				articleId);

		relation = vcmsCARelationPersistence.create(primaryKey);
		relation.setCreatedByUser(String.valueOf(new Date()));
		relation.setCreatedByUser(String.valueOf(getUserId()));
		relation.setStatus(statusId);

		return vcmsCARelationPersistence.update(relation, false);
	}

	public void deleteRelation(String categoryId, String articleId)
			throws PortalException, SystemException, RemoteException {

		VcmsCARelationPK primaryKey = new VcmsCARelationPK(categoryId,
				articleId);

		vcmsCARelationPersistence.remove(primaryKey);
	}

	public void deleteRelationsByCategory(String categoryId)
			throws PortalException, SystemException, RemoteException {

		vcmsCARelationPersistence.removeByCategory(categoryId);
	}

	public void deleteRelationsByArticle(String articleId)
			throws PortalException, SystemException, RemoteException {

		vcmsCARelationPersistence.removeByArticle(articleId);
	}

	public List<VcmsCARelation> getRelationsByCategory(String categoryId)
			throws PortalException, SystemException, RemoteException {

		return vcmsCARelationPersistence.findByCategory(categoryId);
	}

	public List<VcmsCARelation> getRelationsByArticle(String articleId)
			throws PortalException, SystemException, RemoteException {

		return vcmsCARelationPersistence.findByArticle(articleId);
	}

	public int countArticlesOfCategory(String categoryId)
			throws PortalException, SystemException, RemoteException {
		return vcmsCARelationPersistence.countByCategory(categoryId);
	}

	public VcmsCARelation findRelationsByArticle(String articleId)
			throws PortalException, SystemException, RemoteException {
		VcmsCARelation vcmsCARelation = null;
		List<VcmsCARelation> list = vcmsCARelationPersistence.findByArticle(
				articleId, 0, 1);
		if (list.size() > 0) {
			vcmsCARelation = (VcmsCARelation) list.get(0);
		}
		return vcmsCARelation;
	}
}