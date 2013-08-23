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
 * This class is a wrapper for {@link VcmsArticleStatusLocalService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticleStatusLocalService
 * @generated
 */
public class VcmsArticleStatusLocalServiceWrapper
	implements VcmsArticleStatusLocalService,
		ServiceWrapper<VcmsArticleStatusLocalService> {
	public VcmsArticleStatusLocalServiceWrapper(
		VcmsArticleStatusLocalService vcmsArticleStatusLocalService) {
		_vcmsArticleStatusLocalService = vcmsArticleStatusLocalService;
	}

	/**
	* Adds the vcms article status to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleStatus the vcms article status
	* @return the vcms article status that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleStatus addVcmsArticleStatus(
		com.vportal.portlet.vcms.model.VcmsArticleStatus vcmsArticleStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleStatusLocalService.addVcmsArticleStatus(vcmsArticleStatus);
	}

	/**
	* Creates a new vcms article status with the primary key. Does not add the vcms article status to the database.
	*
	* @param id the primary key for the new vcms article status
	* @return the new vcms article status
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleStatus createVcmsArticleStatus(
		long id) {
		return _vcmsArticleStatusLocalService.createVcmsArticleStatus(id);
	}

	/**
	* Deletes the vcms article status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the vcms article status
	* @throws PortalException if a vcms article status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsArticleStatus(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleStatusLocalService.deleteVcmsArticleStatus(id);
	}

	/**
	* Deletes the vcms article status from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleStatus the vcms article status
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsArticleStatus(
		com.vportal.portlet.vcms.model.VcmsArticleStatus vcmsArticleStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleStatusLocalService.deleteVcmsArticleStatus(vcmsArticleStatus);
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
		return _vcmsArticleStatusLocalService.dynamicQuery(dynamicQuery);
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
		return _vcmsArticleStatusLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _vcmsArticleStatusLocalService.dynamicQuery(dynamicQuery, start,
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
		return _vcmsArticleStatusLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vcms.model.VcmsArticleStatus fetchVcmsArticleStatus(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleStatusLocalService.fetchVcmsArticleStatus(id);
	}

	/**
	* Returns the vcms article status with the primary key.
	*
	* @param id the primary key of the vcms article status
	* @return the vcms article status
	* @throws PortalException if a vcms article status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleStatus getVcmsArticleStatus(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleStatusLocalService.getVcmsArticleStatus(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vcms article statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms article statuses
	* @param end the upper bound of the range of vcms article statuses (not inclusive)
	* @return the range of vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleStatus> getVcmsArticleStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleStatusLocalService.getVcmsArticleStatuses(start, end);
	}

	/**
	* Returns the number of vcms article statuses.
	*
	* @return the number of vcms article statuses
	* @throws SystemException if a system exception occurred
	*/
	public int getVcmsArticleStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleStatusLocalService.getVcmsArticleStatusesCount();
	}

	/**
	* Updates the vcms article status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleStatus the vcms article status
	* @return the vcms article status that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleStatus updateVcmsArticleStatus(
		com.vportal.portlet.vcms.model.VcmsArticleStatus vcmsArticleStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleStatusLocalService.updateVcmsArticleStatus(vcmsArticleStatus);
	}

	/**
	* Updates the vcms article status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleStatus the vcms article status
	* @param merge whether to merge the vcms article status with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms article status that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleStatus updateVcmsArticleStatus(
		com.vportal.portlet.vcms.model.VcmsArticleStatus vcmsArticleStatus,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleStatusLocalService.updateVcmsArticleStatus(vcmsArticleStatus,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vcmsArticleStatusLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vcmsArticleStatusLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.vportal.portlet.vcms.model.VcmsArticleStatus addArticleStatus(
		long statusId, java.lang.String articleId, java.lang.String categoryId,
		java.util.Date createDate, java.lang.String createdByUser,
		boolean active, long articleVersionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.addArticleStatus(statusId,
			articleId, categoryId, createDate, createdByUser, active,
			articleVersionId);
	}

	public void deleteRelationByArticleId(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsArticleStatusLocalService.deleteRelationByArticleId(articleId);
	}

	public java.util.List getRelationByArticleId(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.getRelationByArticleId(articleId);
	}

	public java.util.List getRelationByArticleId(java.lang.String articleId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.getRelationByArticleId(articleId,
			begin, end);
	}

	public int countRelationByArticleId(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.countRelationByArticleId(articleId);
	}

	public java.util.List getRelationByActive(boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.getRelationByActive(active);
	}

	public java.util.List getRelationByActive(boolean active, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.getRelationByActive(active,
			begin, end);
	}

	public int countRelationByActive(boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.countRelationByActive(active);
	}

	public java.util.List getRelationByUser(java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.getRelationByUser(createdByUser);
	}

	public java.util.List getRelationByUser(java.lang.String createdByUser,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.getRelationByUser(createdByUser,
			begin, end);
	}

	public int countRelationByUser(java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.countRelationByUser(createdByUser);
	}

	public java.util.List getRelationByU_C(java.lang.String createdByUser,
		boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.getRelationByU_C(createdByUser,
			active);
	}

	public java.util.List getRelationByU_C(java.lang.String createdByUser,
		boolean active, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.getRelationByU_C(createdByUser,
			active, begin, end);
	}

	public int countRelationByU_C(java.lang.String createdByUser, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleStatusLocalService.countRelationByU_C(createdByUser,
			active);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsArticleStatusLocalService getWrappedVcmsArticleStatusLocalService() {
		return _vcmsArticleStatusLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsArticleStatusLocalService(
		VcmsArticleStatusLocalService vcmsArticleStatusLocalService) {
		_vcmsArticleStatusLocalService = vcmsArticleStatusLocalService;
	}

	public VcmsArticleStatusLocalService getWrappedService() {
		return _vcmsArticleStatusLocalService;
	}

	public void setWrappedService(
		VcmsArticleStatusLocalService vcmsArticleStatusLocalService) {
		_vcmsArticleStatusLocalService = vcmsArticleStatusLocalService;
	}

	private VcmsArticleStatusLocalService _vcmsArticleStatusLocalService;
}