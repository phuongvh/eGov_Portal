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
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.vportal.portlet.vcms.model.VcmsTARelation;
import com.vportal.portlet.vcms.service.base.VcmsTARelationServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK;
import com.vportal.portlet.vcms.service.persistence.VcmsTARelationUtil;

/**
 * The implementation of the vcms t a relation remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsTARelationService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsTARelationServiceUtil} to access
 * the vcms t a relation remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsTARelationServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsTARelationServiceUtil
 */
public class VcmsTARelationServiceImpl extends VcmsTARelationServiceBaseImpl {
	public VcmsTARelation addRelation(String threadId, String articleId)
			throws PortalException, SystemException, RemoteException {

		VcmsTARelation relation = null;

		VcmsTARelationPK primaryKey = new VcmsTARelationPK(threadId, articleId);

		relation = VcmsTARelationUtil.create(primaryKey);

		return VcmsTARelationUtil.update(relation, false);
	}

	public void deleteRelation(String threadId, String articleId)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(threadId) || Validator.isNull(articleId)) {
			return;
		}

		VcmsTARelationPK primaryKey = new VcmsTARelationPK(threadId, articleId);

		VcmsTARelationUtil.remove(primaryKey);
	}

	public void deleteRelationsByArticle(String articleId)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(articleId)) {
			return;
		}

		VcmsTARelationUtil.removeByArticle(articleId);
	}

	public void deleteRelationsByThread(String threadId)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(threadId)) {
			return;
		}

		VcmsTARelationUtil.removeByThread(threadId);
	}

	public List<VcmsTARelation> getRelationsByArticle(String articleId)
			throws PortalException, SystemException, RemoteException {

		List relations = new ArrayList();

		if (Validator.isNull(articleId)) {
			return relations;
		}

		relations = VcmsTARelationUtil.findByArticle(articleId);

		return relations;
	}

	public List<VcmsTARelation> getRelationsByThread(String threadId)
			throws PortalException, SystemException, RemoteException {

		List relations = new ArrayList();

		if (Validator.isNull(threadId)) {
			return relations;
		}

		relations = VcmsTARelationUtil.findByThread(threadId);

		return relations;
	}

	public int countArticlesOfThread(String threadId) throws PortalException,
			SystemException, RemoteException {
		return vcmsTARelationPersistence.countByThread(threadId);
	}

	public int countRelationByThread(String threadId) throws PortalException,
			SystemException, RemoteException {
		return vcmsTARelationPersistence.countByThread(threadId);
	}
}