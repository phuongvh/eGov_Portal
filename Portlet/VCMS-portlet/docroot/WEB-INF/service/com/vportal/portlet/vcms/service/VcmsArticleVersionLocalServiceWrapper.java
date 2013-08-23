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
 * This class is a wrapper for {@link VcmsArticleVersionLocalService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticleVersionLocalService
 * @generated
 */
public class VcmsArticleVersionLocalServiceWrapper
	implements VcmsArticleVersionLocalService,
		ServiceWrapper<VcmsArticleVersionLocalService> {
	public VcmsArticleVersionLocalServiceWrapper(
		VcmsArticleVersionLocalService vcmsArticleVersionLocalService) {
		_vcmsArticleVersionLocalService = vcmsArticleVersionLocalService;
	}

	/**
	* Adds the vcms article version to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleVersion the vcms article version
	* @return the vcms article version that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleVersion addVcmsArticleVersion(
		com.vportal.portlet.vcms.model.VcmsArticleVersion vcmsArticleVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleVersionLocalService.addVcmsArticleVersion(vcmsArticleVersion);
	}

	/**
	* Creates a new vcms article version with the primary key. Does not add the vcms article version to the database.
	*
	* @param articleVersionId the primary key for the new vcms article version
	* @return the new vcms article version
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleVersion createVcmsArticleVersion(
		long articleVersionId) {
		return _vcmsArticleVersionLocalService.createVcmsArticleVersion(articleVersionId);
	}

	/**
	* Deletes the vcms article version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articleVersionId the primary key of the vcms article version
	* @throws PortalException if a vcms article version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsArticleVersion(long articleVersionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleVersionLocalService.deleteVcmsArticleVersion(articleVersionId);
	}

	/**
	* Deletes the vcms article version from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleVersion the vcms article version
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsArticleVersion(
		com.vportal.portlet.vcms.model.VcmsArticleVersion vcmsArticleVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleVersionLocalService.deleteVcmsArticleVersion(vcmsArticleVersion);
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
		return _vcmsArticleVersionLocalService.dynamicQuery(dynamicQuery);
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
		return _vcmsArticleVersionLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _vcmsArticleVersionLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _vcmsArticleVersionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vcms.model.VcmsArticleVersion fetchVcmsArticleVersion(
		long articleVersionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleVersionLocalService.fetchVcmsArticleVersion(articleVersionId);
	}

	/**
	* Returns the vcms article version with the primary key.
	*
	* @param articleVersionId the primary key of the vcms article version
	* @return the vcms article version
	* @throws PortalException if a vcms article version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleVersion getVcmsArticleVersion(
		long articleVersionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleVersionLocalService.getVcmsArticleVersion(articleVersionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleVersionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vcms article versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms article versions
	* @param end the upper bound of the range of vcms article versions (not inclusive)
	* @return the range of vcms article versions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleVersion> getVcmsArticleVersions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleVersionLocalService.getVcmsArticleVersions(start, end);
	}

	/**
	* Returns the number of vcms article versions.
	*
	* @return the number of vcms article versions
	* @throws SystemException if a system exception occurred
	*/
	public int getVcmsArticleVersionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleVersionLocalService.getVcmsArticleVersionsCount();
	}

	/**
	* Updates the vcms article version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleVersion the vcms article version
	* @return the vcms article version that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleVersion updateVcmsArticleVersion(
		com.vportal.portlet.vcms.model.VcmsArticleVersion vcmsArticleVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleVersionLocalService.updateVcmsArticleVersion(vcmsArticleVersion);
	}

	/**
	* Updates the vcms article version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleVersion the vcms article version
	* @param merge whether to merge the vcms article version with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms article version that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleVersion updateVcmsArticleVersion(
		com.vportal.portlet.vcms.model.VcmsArticleVersion vcmsArticleVersion,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleVersionLocalService.updateVcmsArticleVersion(vcmsArticleVersion,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vcmsArticleVersionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vcmsArticleVersionLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsArticleVersionLocalService getWrappedVcmsArticleVersionLocalService() {
		return _vcmsArticleVersionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsArticleVersionLocalService(
		VcmsArticleVersionLocalService vcmsArticleVersionLocalService) {
		_vcmsArticleVersionLocalService = vcmsArticleVersionLocalService;
	}

	public VcmsArticleVersionLocalService getWrappedService() {
		return _vcmsArticleVersionLocalService;
	}

	public void setWrappedService(
		VcmsArticleVersionLocalService vcmsArticleVersionLocalService) {
		_vcmsArticleVersionLocalService = vcmsArticleVersionLocalService;
	}

	private VcmsArticleVersionLocalService _vcmsArticleVersionLocalService;
}