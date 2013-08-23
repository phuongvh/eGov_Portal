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
 * This class is a wrapper for {@link VcmsTypeLocalService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsTypeLocalService
 * @generated
 */
public class VcmsTypeLocalServiceWrapper implements VcmsTypeLocalService,
	ServiceWrapper<VcmsTypeLocalService> {
	public VcmsTypeLocalServiceWrapper(
		VcmsTypeLocalService vcmsTypeLocalService) {
		_vcmsTypeLocalService = vcmsTypeLocalService;
	}

	/**
	* Adds the vcms type to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsType the vcms type
	* @return the vcms type that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsType addVcmsType(
		com.vportal.portlet.vcms.model.VcmsType vcmsType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsTypeLocalService.addVcmsType(vcmsType);
	}

	/**
	* Creates a new vcms type with the primary key. Does not add the vcms type to the database.
	*
	* @param typeId the primary key for the new vcms type
	* @return the new vcms type
	*/
	public com.vportal.portlet.vcms.model.VcmsType createVcmsType(
		java.lang.String typeId) {
		return _vcmsTypeLocalService.createVcmsType(typeId);
	}

	/**
	* Deletes the vcms type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the vcms type
	* @throws PortalException if a vcms type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsType(java.lang.String typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsTypeLocalService.deleteVcmsType(typeId);
	}

	/**
	* Deletes the vcms type from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsType the vcms type
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsType(com.vportal.portlet.vcms.model.VcmsType vcmsType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsTypeLocalService.deleteVcmsType(vcmsType);
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
		return _vcmsTypeLocalService.dynamicQuery(dynamicQuery);
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
		return _vcmsTypeLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _vcmsTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vcmsTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vcms.model.VcmsType fetchVcmsType(
		java.lang.String typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsTypeLocalService.fetchVcmsType(typeId);
	}

	/**
	* Returns the vcms type with the primary key.
	*
	* @param typeId the primary key of the vcms type
	* @return the vcms type
	* @throws PortalException if a vcms type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsType getVcmsType(
		java.lang.String typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsTypeLocalService.getVcmsType(typeId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vcms types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms types
	* @param end the upper bound of the range of vcms types (not inclusive)
	* @return the range of vcms types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsType> getVcmsTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsTypeLocalService.getVcmsTypes(start, end);
	}

	/**
	* Returns the number of vcms types.
	*
	* @return the number of vcms types
	* @throws SystemException if a system exception occurred
	*/
	public int getVcmsTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsTypeLocalService.getVcmsTypesCount();
	}

	/**
	* Updates the vcms type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsType the vcms type
	* @return the vcms type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsType updateVcmsType(
		com.vportal.portlet.vcms.model.VcmsType vcmsType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsTypeLocalService.updateVcmsType(vcmsType);
	}

	/**
	* Updates the vcms type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsType the vcms type
	* @param merge whether to merge the vcms type with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsType updateVcmsType(
		com.vportal.portlet.vcms.model.VcmsType vcmsType, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsTypeLocalService.updateVcmsType(vcmsType, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vcmsTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vcmsTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsTypeLocalService getWrappedVcmsTypeLocalService() {
		return _vcmsTypeLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsTypeLocalService(
		VcmsTypeLocalService vcmsTypeLocalService) {
		_vcmsTypeLocalService = vcmsTypeLocalService;
	}

	public VcmsTypeLocalService getWrappedService() {
		return _vcmsTypeLocalService;
	}

	public void setWrappedService(VcmsTypeLocalService vcmsTypeLocalService) {
		_vcmsTypeLocalService = vcmsTypeLocalService;
	}

	private VcmsTypeLocalService _vcmsTypeLocalService;
}