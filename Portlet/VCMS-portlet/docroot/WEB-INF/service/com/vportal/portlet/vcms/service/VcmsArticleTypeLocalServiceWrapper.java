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
 * This class is a wrapper for {@link VcmsArticleTypeLocalService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticleTypeLocalService
 * @generated
 */
public class VcmsArticleTypeLocalServiceWrapper
	implements VcmsArticleTypeLocalService,
		ServiceWrapper<VcmsArticleTypeLocalService> {
	public VcmsArticleTypeLocalServiceWrapper(
		VcmsArticleTypeLocalService vcmsArticleTypeLocalService) {
		_vcmsArticleTypeLocalService = vcmsArticleTypeLocalService;
	}

	/**
	* Adds the vcms article type to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleType the vcms article type
	* @return the vcms article type that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType addVcmsArticleType(
		com.vportal.portlet.vcms.model.VcmsArticleType vcmsArticleType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleTypeLocalService.addVcmsArticleType(vcmsArticleType);
	}

	/**
	* Creates a new vcms article type with the primary key. Does not add the vcms article type to the database.
	*
	* @param vcmsArticleTypePK the primary key for the new vcms article type
	* @return the new vcms article type
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType createVcmsArticleType(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK) {
		return _vcmsArticleTypeLocalService.createVcmsArticleType(vcmsArticleTypePK);
	}

	/**
	* Deletes the vcms article type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleTypePK the primary key of the vcms article type
	* @throws PortalException if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsArticleType(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleTypeLocalService.deleteVcmsArticleType(vcmsArticleTypePK);
	}

	/**
	* Deletes the vcms article type from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleType the vcms article type
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsArticleType(
		com.vportal.portlet.vcms.model.VcmsArticleType vcmsArticleType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleTypeLocalService.deleteVcmsArticleType(vcmsArticleType);
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
		return _vcmsArticleTypeLocalService.dynamicQuery(dynamicQuery);
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
		return _vcmsArticleTypeLocalService.dynamicQuery(dynamicQuery, start,
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
		return _vcmsArticleTypeLocalService.dynamicQuery(dynamicQuery, start,
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
		return _vcmsArticleTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vcms.model.VcmsArticleType fetchVcmsArticleType(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleTypeLocalService.fetchVcmsArticleType(vcmsArticleTypePK);
	}

	/**
	* Returns the vcms article type with the primary key.
	*
	* @param vcmsArticleTypePK the primary key of the vcms article type
	* @return the vcms article type
	* @throws PortalException if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType getVcmsArticleType(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleTypeLocalService.getVcmsArticleType(vcmsArticleTypePK);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vcms article types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @return the range of vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> getVcmsArticleTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleTypeLocalService.getVcmsArticleTypes(start, end);
	}

	/**
	* Returns the number of vcms article types.
	*
	* @return the number of vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public int getVcmsArticleTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleTypeLocalService.getVcmsArticleTypesCount();
	}

	/**
	* Updates the vcms article type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleType the vcms article type
	* @return the vcms article type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType updateVcmsArticleType(
		com.vportal.portlet.vcms.model.VcmsArticleType vcmsArticleType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleTypeLocalService.updateVcmsArticleType(vcmsArticleType);
	}

	/**
	* Updates the vcms article type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleType the vcms article type
	* @param merge whether to merge the vcms article type with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms article type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType updateVcmsArticleType(
		com.vportal.portlet.vcms.model.VcmsArticleType vcmsArticleType,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleTypeLocalService.updateVcmsArticleType(vcmsArticleType,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vcmsArticleTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vcmsArticleTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.vportal.portlet.vcms.model.VcmsArticleType addArticleType(
		java.lang.String articleId, long typeId, int position)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleTypeLocalService.addArticleType(articleId, typeId,
			position);
	}

	public void deleteRelationByArticleId(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsArticleTypeLocalService.deleteRelationByArticleId(articleId);
	}

	public void deleteRelationByTypeId(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_vcmsArticleTypeLocalService.deleteRelationByTypeId(typeId);
	}

	public java.util.List getByArticleId(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleTypeLocalService.getByArticleId(articleId);
	}

	public java.util.List getByArticleId(java.lang.String articleId, int begin,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleTypeLocalService.getByArticleId(articleId, begin, end);
	}

	public int countByArticleId(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleTypeLocalService.countByArticleId(articleId);
	}

	public java.util.List getByTypeId(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleTypeLocalService.getByTypeId(typeId);
	}

	public java.util.List getByTypeId(long typeId, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleTypeLocalService.getByTypeId(typeId, begin, end);
	}

	public int countByTypeId(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleTypeLocalService.countByTypeId(typeId);
	}

	public com.vportal.portlet.vcms.model.VcmsArticleType getArticleType(
		long typeId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleTypeLocalService.getArticleType(typeId, articleId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsArticleTypeLocalService getWrappedVcmsArticleTypeLocalService() {
		return _vcmsArticleTypeLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsArticleTypeLocalService(
		VcmsArticleTypeLocalService vcmsArticleTypeLocalService) {
		_vcmsArticleTypeLocalService = vcmsArticleTypeLocalService;
	}

	public VcmsArticleTypeLocalService getWrappedService() {
		return _vcmsArticleTypeLocalService;
	}

	public void setWrappedService(
		VcmsArticleTypeLocalService vcmsArticleTypeLocalService) {
		_vcmsArticleTypeLocalService = vcmsArticleTypeLocalService;
	}

	private VcmsArticleTypeLocalService _vcmsArticleTypeLocalService;
}