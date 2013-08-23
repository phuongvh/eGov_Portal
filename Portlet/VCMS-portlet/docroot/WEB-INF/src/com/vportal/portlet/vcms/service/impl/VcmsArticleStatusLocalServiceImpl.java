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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.vportal.portlet.vcms.model.VcmsArticleStatus;
import com.vportal.portlet.vcms.service.base.VcmsArticleStatusLocalServiceBaseImpl;

/**
 * The implementation of the vcms article status local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsArticleStatusLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsArticleStatusLocalServiceUtil} to
 * access the vcms article status local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsArticleStatusLocalServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsArticleStatusLocalServiceUtil
 */
public class VcmsArticleStatusLocalServiceImpl extends
		VcmsArticleStatusLocalServiceBaseImpl {
	public VcmsArticleStatus addArticleStatus(long statusId, String articleId,
			String categoryId, Date createDate, String createdByUser,
			boolean active, long articleVersionId) throws PortalException,
			SystemException, RemoteException {

		long primaryKey = CounterLocalServiceUtil
				.increment(VcmsArticleStatus.class.getName());

		VcmsArticleStatus relation = null;

		// VcmsArticleStatusPK primaryKey = new VcmsArticleStatusPK(statusId,
		// articleId, categoryId, createDate);

		relation = vcmsArticleStatusPersistence.create(primaryKey);

		relation.setStatusId(statusId);
		relation.setArticleId(articleId);
		relation.setCategoryId(categoryId);
		relation.setCreatedDate(createDate);
		relation.setCreatedByUser(createdByUser);
		relation.setActive(active);
		relation.setArticleVersionId(articleVersionId);

		return vcmsArticleStatusPersistence.update(relation, false);

	}

	public void deleteRelationByArticleId(String articleId)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(articleId)) {
			return;
		}

		vcmsArticleStatusPersistence.removeByArticle(articleId);
	}

	public List getRelationByArticleId(String articleId)
			throws PortalException, SystemException, RemoteException {

		return vcmsArticleStatusPersistence.findByArticle(articleId);
	}

	public List getRelationByArticleId(String articleId, int begin, int end)
			throws PortalException, SystemException, RemoteException {

		return vcmsArticleStatusPersistence
				.findByArticle(articleId, begin, end);
	}

	public int countRelationByArticleId(String articleId)
			throws PortalException, SystemException, RemoteException {

		return vcmsArticleStatusPersistence.countByArticle(articleId);
	}

	public List getRelationByActive(boolean active) throws PortalException,
			SystemException, RemoteException {

		return vcmsArticleStatusPersistence.findByActive(active);
	}

	public List getRelationByActive(boolean active, int begin, int end)
			throws PortalException, SystemException, RemoteException {

		return vcmsArticleStatusPersistence.findByActive(active, begin, end);
	}

	public int countRelationByActive(boolean active) throws PortalException,
			SystemException, RemoteException {

		return vcmsArticleStatusPersistence.countByActive(active);
	}

	public List getRelationByUser(String createdByUser) throws PortalException,
			SystemException, RemoteException {

		return vcmsArticleStatusPersistence.findByUser(createdByUser);
	}

	public List getRelationByUser(String createdByUser, int begin, int end)
			throws PortalException, SystemException, RemoteException {

		return vcmsArticleStatusPersistence.findByUser(createdByUser, begin,
				end);
	}

	public int countRelationByUser(String createdByUser)
			throws PortalException, SystemException, RemoteException {

		return vcmsArticleStatusPersistence.countByUser(createdByUser);
	}

	public List getRelationByU_C(String createdByUser, boolean active)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticleStatusPersistence.findByU_A(createdByUser, active);
	}

	public List getRelationByU_C(String createdByUser, boolean active,
			int begin, int end) throws PortalException, SystemException,
			RemoteException {
		return vcmsArticleStatusPersistence.findByU_A(createdByUser, active,
				begin, end);
	}

	public int countRelationByU_C(String createdByUser, boolean active)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticleStatusPersistence.countByU_A(createdByUser, active);
	}

	// public int countByC_L_S(String categoryId, long groupId, String language,
	// int status);
}