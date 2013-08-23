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
 * This class is a wrapper for {@link VcmsStatusLocalService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsStatusLocalService
 * @generated
 */
public class VcmsStatusLocalServiceWrapper implements VcmsStatusLocalService,
	ServiceWrapper<VcmsStatusLocalService> {
	public VcmsStatusLocalServiceWrapper(
		VcmsStatusLocalService vcmsStatusLocalService) {
		_vcmsStatusLocalService = vcmsStatusLocalService;
	}

	/**
	* Adds the vcms status to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsStatus the vcms status
	* @return the vcms status that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsStatus addVcmsStatus(
		com.vportal.portlet.vcms.model.VcmsStatus vcmsStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsStatusLocalService.addVcmsStatus(vcmsStatus);
	}

	/**
	* Creates a new vcms status with the primary key. Does not add the vcms status to the database.
	*
	* @param statusId the primary key for the new vcms status
	* @return the new vcms status
	*/
	public com.vportal.portlet.vcms.model.VcmsStatus createVcmsStatus(
		long statusId) {
		return _vcmsStatusLocalService.createVcmsStatus(statusId);
	}

	/**
	* Deletes the vcms status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statusId the primary key of the vcms status
	* @throws PortalException if a vcms status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsStatus(long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsStatusLocalService.deleteVcmsStatus(statusId);
	}

	/**
	* Deletes the vcms status from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsStatus the vcms status
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsStatus(
		com.vportal.portlet.vcms.model.VcmsStatus vcmsStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsStatusLocalService.deleteVcmsStatus(vcmsStatus);
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
		return _vcmsStatusLocalService.dynamicQuery(dynamicQuery);
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
		return _vcmsStatusLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _vcmsStatusLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vcmsStatusLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vcms.model.VcmsStatus fetchVcmsStatus(
		long statusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsStatusLocalService.fetchVcmsStatus(statusId);
	}

	/**
	* Returns the vcms status with the primary key.
	*
	* @param statusId the primary key of the vcms status
	* @return the vcms status
	* @throws PortalException if a vcms status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsStatus getVcmsStatus(
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsStatusLocalService.getVcmsStatus(statusId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vcms statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms statuses
	* @param end the upper bound of the range of vcms statuses (not inclusive)
	* @return the range of vcms statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsStatus> getVcmsStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsStatusLocalService.getVcmsStatuses(start, end);
	}

	/**
	* Returns the number of vcms statuses.
	*
	* @return the number of vcms statuses
	* @throws SystemException if a system exception occurred
	*/
	public int getVcmsStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsStatusLocalService.getVcmsStatusesCount();
	}

	/**
	* Updates the vcms status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsStatus the vcms status
	* @return the vcms status that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsStatus updateVcmsStatus(
		com.vportal.portlet.vcms.model.VcmsStatus vcmsStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsStatusLocalService.updateVcmsStatus(vcmsStatus);
	}

	/**
	* Updates the vcms status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsStatus the vcms status
	* @param merge whether to merge the vcms status with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms status that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsStatus updateVcmsStatus(
		com.vportal.portlet.vcms.model.VcmsStatus vcmsStatus, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsStatusLocalService.updateVcmsStatus(vcmsStatus, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vcmsStatusLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vcmsStatusLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.vportal.portlet.vcms.model.VcmsStatus addStatus(long companyId,
		long groupId, long userId, java.lang.String name,
		java.lang.String description, java.lang.String cssClass,
		java.lang.String textColor, long position, boolean isPrimary,
		boolean active, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsStatusLocalService.addStatus(companyId, groupId, userId,
			name, description, cssClass, textColor, position, isPrimary,
			active, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vcms.model.VcmsStatus updateStatus(
		long statusId, long companyId, long groupId, long userId,
		java.lang.String name, java.lang.String description,
		java.lang.String cssClass, java.lang.String textColor, long position,
		boolean isPrimary, boolean active,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsStatusLocalService.updateStatus(statusId, companyId,
			groupId, userId, name, description, cssClass, textColor, position,
			isPrimary, active, addCommunityPermissions, addGuestPermissions,
			communityPermissions, guestPermissions);
	}

	public java.util.List getStatusByPosition(long position)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsStatusLocalService.getStatusByPosition(position);
	}

	public java.util.List getByG_P(long groupId, long position)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsStatusLocalService.getByG_P(groupId, position);
	}

	public java.util.List getByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsStatusLocalService.getByGroupId(groupId);
	}

	public java.util.List getByGroupId(long groupId, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsStatusLocalService.getByGroupId(groupId, begin, end);
	}

	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsStatusLocalService.countByGroupId(groupId);
	}

	public com.vportal.portlet.vcms.model.VcmsStatus getByC_G_A(
		long companyId, long groupId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsStatusLocalService.getByC_G_A(companyId, groupId, active);
	}

	public com.vportal.portlet.vcms.model.VcmsStatus getByA(boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsStatusLocalService.getByA(active);
	}

	public void deleteStatus(long statusId, long companyId, long groupId,
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsStatusLocalService.deleteStatus(statusId, companyId, groupId,
			userId);
	}

	public void addResources(int statusId, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsStatusLocalService.addResources(statusId, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addResources(com.vportal.portlet.vcms.model.VcmsStatus status,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsStatusLocalService.addResources(status, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addResources(int statusId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsStatusLocalService.addResources(statusId, communityPermissions,
			guestPermissions);
	}

	public void addResources(com.vportal.portlet.vcms.model.VcmsStatus status,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsStatusLocalService.addResources(status, communityPermissions,
			guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsStatusLocalService getWrappedVcmsStatusLocalService() {
		return _vcmsStatusLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsStatusLocalService(
		VcmsStatusLocalService vcmsStatusLocalService) {
		_vcmsStatusLocalService = vcmsStatusLocalService;
	}

	public VcmsStatusLocalService getWrappedService() {
		return _vcmsStatusLocalService;
	}

	public void setWrappedService(VcmsStatusLocalService vcmsStatusLocalService) {
		_vcmsStatusLocalService = vcmsStatusLocalService;
	}

	private VcmsStatusLocalService _vcmsStatusLocalService;
}