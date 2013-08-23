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
 * This class is a wrapper for {@link VcmsCategoryLocalService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsCategoryLocalService
 * @generated
 */
public class VcmsCategoryLocalServiceWrapper implements VcmsCategoryLocalService,
	ServiceWrapper<VcmsCategoryLocalService> {
	public VcmsCategoryLocalServiceWrapper(
		VcmsCategoryLocalService vcmsCategoryLocalService) {
		_vcmsCategoryLocalService = vcmsCategoryLocalService;
	}

	/**
	* Adds the vcms category to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsCategory the vcms category
	* @return the vcms category that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCategory addVcmsCategory(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsCategoryLocalService.addVcmsCategory(vcmsCategory);
	}

	/**
	* Creates a new vcms category with the primary key. Does not add the vcms category to the database.
	*
	* @param categoryId the primary key for the new vcms category
	* @return the new vcms category
	*/
	public com.vportal.portlet.vcms.model.VcmsCategory createVcmsCategory(
		java.lang.String categoryId) {
		return _vcmsCategoryLocalService.createVcmsCategory(categoryId);
	}

	/**
	* Deletes the vcms category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the vcms category
	* @throws PortalException if a vcms category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsCategory(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsCategoryLocalService.deleteVcmsCategory(categoryId);
	}

	/**
	* Deletes the vcms category from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsCategory the vcms category
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsCategory(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsCategoryLocalService.deleteVcmsCategory(vcmsCategory);
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
		return _vcmsCategoryLocalService.dynamicQuery(dynamicQuery);
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
		return _vcmsCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _vcmsCategoryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vcmsCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vcms.model.VcmsCategory fetchVcmsCategory(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsCategoryLocalService.fetchVcmsCategory(categoryId);
	}

	/**
	* Returns the vcms category with the primary key.
	*
	* @param categoryId the primary key of the vcms category
	* @return the vcms category
	* @throws PortalException if a vcms category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCategory getVcmsCategory(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsCategoryLocalService.getVcmsCategory(categoryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vcms categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms categories
	* @param end the upper bound of the range of vcms categories (not inclusive)
	* @return the range of vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getVcmsCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsCategoryLocalService.getVcmsCategories(start, end);
	}

	/**
	* Returns the number of vcms categories.
	*
	* @return the number of vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public int getVcmsCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsCategoryLocalService.getVcmsCategoriesCount();
	}

	/**
	* Updates the vcms category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsCategory the vcms category
	* @return the vcms category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCategory updateVcmsCategory(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsCategoryLocalService.updateVcmsCategory(vcmsCategory);
	}

	/**
	* Updates the vcms category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsCategory the vcms category
	* @param merge whether to merge the vcms category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCategory updateVcmsCategory(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsCategoryLocalService.updateVcmsCategory(vcmsCategory, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vcmsCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vcmsCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsCategoryLocalService getWrappedVcmsCategoryLocalService() {
		return _vcmsCategoryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsCategoryLocalService(
		VcmsCategoryLocalService vcmsCategoryLocalService) {
		_vcmsCategoryLocalService = vcmsCategoryLocalService;
	}

	public VcmsCategoryLocalService getWrappedService() {
		return _vcmsCategoryLocalService;
	}

	public void setWrappedService(
		VcmsCategoryLocalService vcmsCategoryLocalService) {
		_vcmsCategoryLocalService = vcmsCategoryLocalService;
	}

	private VcmsCategoryLocalService _vcmsCategoryLocalService;
}