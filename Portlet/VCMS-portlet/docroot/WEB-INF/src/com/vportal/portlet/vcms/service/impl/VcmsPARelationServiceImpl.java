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
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.vportal.portlet.vcms.model.VcmsPARelation;
import com.vportal.portlet.vcms.service.base.VcmsPARelationServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK;
import com.vportal.portlet.vcms.service.persistence.VcmsPARelationUtil;

/**
 * The implementation of the vcms p a relation remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsPARelationService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsPARelationServiceUtil} to access
 * the vcms p a relation remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsPARelationServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsPARelationServiceUtil
 */
public class VcmsPARelationServiceImpl extends VcmsPARelationServiceBaseImpl {
	public VcmsPARelation addRelation(String portionId, String articleId)
			throws PortalException, SystemException, RemoteException {

		VcmsPARelation relation = null;

		VcmsPARelationPK primaryKey = new VcmsPARelationPK(portionId, articleId);

		relation = VcmsPARelationUtil.create(primaryKey);

		return vcmsPARelationPersistence.update(relation, false);
	}

	public void deleteRelation(String portionId, String articleId)
			throws PortalException, SystemException, RemoteException {

		VcmsPARelationPK primaryKey = new VcmsPARelationPK(portionId, articleId);

		VcmsPARelationUtil.remove(primaryKey);
	}

	public void deleteRelationsByPortion(String portionId)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(portionId)) {
			return;
		}

		vcmsPARelationPersistence.removeByPortion(portionId);
	}

	public void deleteRelationsByArticle(String articleId)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(articleId)) {
			return;
		}

		vcmsPARelationPersistence.removeByArticle(articleId);
	}

	public List<VcmsPARelation> getRelationsByPortion(String portionId)
			throws PortalException, SystemException, RemoteException {

		return vcmsPARelationPersistence.findByPortion(portionId);
	}

	public List<VcmsPARelation> getRelationsByArticle(String articleId)
			throws PortalException, SystemException, RemoteException {

		return vcmsPARelationPersistence.findByArticle(articleId);
	}
}