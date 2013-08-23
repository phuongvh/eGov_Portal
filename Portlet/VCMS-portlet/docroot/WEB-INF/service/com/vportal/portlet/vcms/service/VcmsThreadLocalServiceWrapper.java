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
 * This class is a wrapper for {@link VcmsThreadLocalService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsThreadLocalService
 * @generated
 */
public class VcmsThreadLocalServiceWrapper implements VcmsThreadLocalService,
	ServiceWrapper<VcmsThreadLocalService> {
	public VcmsThreadLocalServiceWrapper(
		VcmsThreadLocalService vcmsThreadLocalService) {
		_vcmsThreadLocalService = vcmsThreadLocalService;
	}

	/**
	* Adds the vcms thread to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsThread the vcms thread
	* @return the vcms thread that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsThread addVcmsThread(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsThreadLocalService.addVcmsThread(vcmsThread);
	}

	/**
	* Creates a new vcms thread with the primary key. Does not add the vcms thread to the database.
	*
	* @param threadId the primary key for the new vcms thread
	* @return the new vcms thread
	*/
	public com.vportal.portlet.vcms.model.VcmsThread createVcmsThread(
		java.lang.String threadId) {
		return _vcmsThreadLocalService.createVcmsThread(threadId);
	}

	/**
	* Deletes the vcms thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param threadId the primary key of the vcms thread
	* @throws PortalException if a vcms thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsThread(java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsThreadLocalService.deleteVcmsThread(threadId);
	}

	/**
	* Deletes the vcms thread from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsThread the vcms thread
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsThread(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsThreadLocalService.deleteVcmsThread(vcmsThread);
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
		return _vcmsThreadLocalService.dynamicQuery(dynamicQuery);
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
		return _vcmsThreadLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _vcmsThreadLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _vcmsThreadLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vcms.model.VcmsThread fetchVcmsThread(
		java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsThreadLocalService.fetchVcmsThread(threadId);
	}

	/**
	* Returns the vcms thread with the primary key.
	*
	* @param threadId the primary key of the vcms thread
	* @return the vcms thread
	* @throws PortalException if a vcms thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsThread getVcmsThread(
		java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsThreadLocalService.getVcmsThread(threadId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsThreadLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vcms threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms threads
	* @param end the upper bound of the range of vcms threads (not inclusive)
	* @return the range of vcms threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsThread> getVcmsThreads(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsThreadLocalService.getVcmsThreads(start, end);
	}

	/**
	* Returns the number of vcms threads.
	*
	* @return the number of vcms threads
	* @throws SystemException if a system exception occurred
	*/
	public int getVcmsThreadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsThreadLocalService.getVcmsThreadsCount();
	}

	/**
	* Updates the vcms thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsThread the vcms thread
	* @return the vcms thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsThread updateVcmsThread(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsThreadLocalService.updateVcmsThread(vcmsThread);
	}

	/**
	* Updates the vcms thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsThread the vcms thread
	* @param merge whether to merge the vcms thread with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsThread updateVcmsThread(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsThreadLocalService.updateVcmsThread(vcmsThread, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vcmsThreadLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vcmsThreadLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsThreadLocalService getWrappedVcmsThreadLocalService() {
		return _vcmsThreadLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsThreadLocalService(
		VcmsThreadLocalService vcmsThreadLocalService) {
		_vcmsThreadLocalService = vcmsThreadLocalService;
	}

	public VcmsThreadLocalService getWrappedService() {
		return _vcmsThreadLocalService;
	}

	public void setWrappedService(VcmsThreadLocalService vcmsThreadLocalService) {
		_vcmsThreadLocalService = vcmsThreadLocalService;
	}

	private VcmsThreadLocalService _vcmsThreadLocalService;
}