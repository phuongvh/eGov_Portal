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

package com.vportal.portlet.vcms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VcmsPARelationLocalService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsPARelationLocalService
 * @generated
 */
public class VcmsPARelationLocalServiceWrapper
	implements VcmsPARelationLocalService,
		ServiceWrapper<VcmsPARelationLocalService> {
	public VcmsPARelationLocalServiceWrapper(
		VcmsPARelationLocalService vcmsPARelationLocalService) {
		_vcmsPARelationLocalService = vcmsPARelationLocalService;
	}

	/**
	* Adds the vcms p a relation to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsPARelation the vcms p a relation
	* @return the vcms p a relation that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation addVcmsPARelation(
		com.vportal.portlet.vcms.model.VcmsPARelation vcmsPARelation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.addVcmsPARelation(vcmsPARelation);
	}

	/**
	* Creates a new vcms p a relation with the primary key. Does not add the vcms p a relation to the database.
	*
	* @param vcmsPARelationPK the primary key for the new vcms p a relation
	* @return the new vcms p a relation
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation createVcmsPARelation(
		com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK vcmsPARelationPK) {
		return _vcmsPARelationLocalService.createVcmsPARelation(vcmsPARelationPK);
	}

	/**
	* Deletes the vcms p a relation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsPARelationPK the primary key of the vcms p a relation
	* @throws PortalException if a vcms p a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsPARelation(
		com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK vcmsPARelationPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsPARelationLocalService.deleteVcmsPARelation(vcmsPARelationPK);
	}

	/**
	* Deletes the vcms p a relation from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsPARelation the vcms p a relation
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsPARelation(
		com.vportal.portlet.vcms.model.VcmsPARelation vcmsPARelation)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsPARelationLocalService.deleteVcmsPARelation(vcmsPARelation);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vcms.model.VcmsPARelation fetchVcmsPARelation(
		com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK vcmsPARelationPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.fetchVcmsPARelation(vcmsPARelationPK);
	}

	/**
	* Returns the vcms p a relation with the primary key.
	*
	* @param vcmsPARelationPK the primary key of the vcms p a relation
	* @return the vcms p a relation
	* @throws PortalException if a vcms p a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation getVcmsPARelation(
		com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK vcmsPARelationPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.getVcmsPARelation(vcmsPARelationPK);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vcms p a relations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms p a relations
	* @param end the upper bound of the range of vcms p a relations (not inclusive)
	* @return the range of vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> getVcmsPARelations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.getVcmsPARelations(start, end);
	}

	/**
	* Returns the number of vcms p a relations.
	*
	* @return the number of vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public int getVcmsPARelationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.getVcmsPARelationsCount();
	}

	/**
	* Updates the vcms p a relation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsPARelation the vcms p a relation
	* @return the vcms p a relation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation updateVcmsPARelation(
		com.vportal.portlet.vcms.model.VcmsPARelation vcmsPARelation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.updateVcmsPARelation(vcmsPARelation);
	}

	/**
	* Updates the vcms p a relation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsPARelation the vcms p a relation
	* @param merge whether to merge the vcms p a relation with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms p a relation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation updateVcmsPARelation(
		com.vportal.portlet.vcms.model.VcmsPARelation vcmsPARelation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsPARelationLocalService.updateVcmsPARelation(vcmsPARelation,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vcmsPARelationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vcmsPARelationLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsPARelationLocalService getWrappedVcmsPARelationLocalService() {
		return _vcmsPARelationLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsPARelationLocalService(
		VcmsPARelationLocalService vcmsPARelationLocalService) {
		_vcmsPARelationLocalService = vcmsPARelationLocalService;
	}

	public VcmsPARelationLocalService getWrappedService() {
		return _vcmsPARelationLocalService;
	}

	public void setWrappedService(
		VcmsPARelationLocalService vcmsPARelationLocalService) {
		_vcmsPARelationLocalService = vcmsPARelationLocalService;
	}

	private VcmsPARelationLocalService _vcmsPARelationLocalService;
}