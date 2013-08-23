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
import com.vportal.portlet.vcms.model.VcmsArticleType;
import com.vportal.portlet.vcms.service.base.VcmsArticleTypeLocalServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK;

/**
 * The implementation of the vcms article type local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsArticleTypeLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsArticleTypeLocalServiceUtil} to
 * access the vcms article type local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsArticleTypeLocalServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsArticleTypeLocalServiceUtil
 */
public class VcmsArticleTypeLocalServiceImpl extends
		VcmsArticleTypeLocalServiceBaseImpl {
	public VcmsArticleType addArticleType(String articleId, long typeId,
			int position) throws PortalException, SystemException,
			RemoteException {

		VcmsArticleType relation = null;

		VcmsArticleTypePK primaryKey = new VcmsArticleTypePK(typeId, articleId);

		relation = vcmsArticleTypePersistence.create(primaryKey);
		relation.setPosition(position);

		return vcmsArticleTypePersistence.update(relation, false);

	}

	public void deleteRelationByArticleId(String articleId)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(articleId)) {
			return;
		}

		vcmsArticleTypePersistence.removeByArticle(articleId);
	}

	public void deleteRelationByTypeId(long typeId) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(typeId)) {
			return;
		}

		vcmsArticleTypePersistence.removeByType(typeId);
	}

	public List getByArticleId(String articleId) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticleTypePersistence.findByArticle(articleId);
	}

	public List getByArticleId(String articleId, int begin, int end)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticleTypePersistence.findByArticle(articleId, begin, end);
	}

	public int countByArticleId(String articleId) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticleTypePersistence.countByArticle(articleId);
	}

	public List getByTypeId(long typeId) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticleTypePersistence.findByType(typeId);
	}

	public List getByTypeId(long typeId, int begin, int end)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticleTypePersistence.findByType(typeId, begin, end);
	}

	public int countByTypeId(long typeId) throws PortalException,
			SystemException, RemoteException {
		return vcmsArticleTypePersistence.countByType(typeId);
	}

	public VcmsArticleType getArticleType(long typeId, String articleId)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticleTypePersistence
				.findByArticleByType(typeId, articleId);
	}

}