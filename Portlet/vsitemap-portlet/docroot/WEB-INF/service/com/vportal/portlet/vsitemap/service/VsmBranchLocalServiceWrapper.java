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

package com.vportal.portlet.vsitemap.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VsmBranchLocalService}.
 * </p>
 *
 * @author    LongLH
 * @see       VsmBranchLocalService
 * @generated
 */
public class VsmBranchLocalServiceWrapper implements VsmBranchLocalService,
	ServiceWrapper<VsmBranchLocalService> {
	public VsmBranchLocalServiceWrapper(
		VsmBranchLocalService vsmBranchLocalService) {
		_vsmBranchLocalService = vsmBranchLocalService;
	}

	/**
	* Adds the vsm branch to the database. Also notifies the appropriate model listeners.
	*
	* @param vsmBranch the vsm branch
	* @return the vsm branch that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vsitemap.model.VsmBranch addVsmBranch(
		com.vportal.portlet.vsitemap.model.VsmBranch vsmBranch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vsmBranchLocalService.addVsmBranch(vsmBranch);
	}

	/**
	* Creates a new vsm branch with the primary key. Does not add the vsm branch to the database.
	*
	* @param branchId the primary key for the new vsm branch
	* @return the new vsm branch
	*/
	public com.vportal.portlet.vsitemap.model.VsmBranch createVsmBranch(
		long branchId) {
		return _vsmBranchLocalService.createVsmBranch(branchId);
	}

	/**
	* Deletes the vsm branch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param branchId the primary key of the vsm branch
	* @throws PortalException if a vsm branch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVsmBranch(long branchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vsmBranchLocalService.deleteVsmBranch(branchId);
	}

	/**
	* Deletes the vsm branch from the database. Also notifies the appropriate model listeners.
	*
	* @param vsmBranch the vsm branch
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVsmBranch(
		com.vportal.portlet.vsitemap.model.VsmBranch vsmBranch)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vsmBranchLocalService.deleteVsmBranch(vsmBranch);
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
		return _vsmBranchLocalService.dynamicQuery(dynamicQuery);
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
		return _vsmBranchLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _vsmBranchLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vsmBranchLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vsitemap.model.VsmBranch fetchVsmBranch(
		long branchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vsmBranchLocalService.fetchVsmBranch(branchId);
	}

	/**
	* Returns the vsm branch with the primary key.
	*
	* @param branchId the primary key of the vsm branch
	* @return the vsm branch
	* @throws PortalException if a vsm branch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vsitemap.model.VsmBranch getVsmBranch(
		long branchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vsmBranchLocalService.getVsmBranch(branchId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vsmBranchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vsm branchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @return the range of vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> getVsmBranchs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vsmBranchLocalService.getVsmBranchs(start, end);
	}

	/**
	* Returns the number of vsm branchs.
	*
	* @return the number of vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public int getVsmBranchsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vsmBranchLocalService.getVsmBranchsCount();
	}

	/**
	* Updates the vsm branch in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vsmBranch the vsm branch
	* @return the vsm branch that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vsitemap.model.VsmBranch updateVsmBranch(
		com.vportal.portlet.vsitemap.model.VsmBranch vsmBranch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vsmBranchLocalService.updateVsmBranch(vsmBranch);
	}

	/**
	* Updates the vsm branch in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vsmBranch the vsm branch
	* @param merge whether to merge the vsm branch with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vsm branch that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vsitemap.model.VsmBranch updateVsmBranch(
		com.vportal.portlet.vsitemap.model.VsmBranch vsmBranch, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vsmBranchLocalService.updateVsmBranch(vsmBranch, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vsmBranchLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vsmBranchLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VsmBranchLocalService getWrappedVsmBranchLocalService() {
		return _vsmBranchLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVsmBranchLocalService(
		VsmBranchLocalService vsmBranchLocalService) {
		_vsmBranchLocalService = vsmBranchLocalService;
	}

	public VsmBranchLocalService getWrappedService() {
		return _vsmBranchLocalService;
	}

	public void setWrappedService(VsmBranchLocalService vsmBranchLocalService) {
		_vsmBranchLocalService = vsmBranchLocalService;
	}

	private VsmBranchLocalService _vsmBranchLocalService;
}