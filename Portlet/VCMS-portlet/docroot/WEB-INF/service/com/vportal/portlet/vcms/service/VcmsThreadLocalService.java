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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the vcms thread local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hai
 * @see VcmsThreadLocalServiceUtil
 * @see com.vportal.portlet.vcms.service.base.VcmsThreadLocalServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsThreadLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VcmsThreadLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VcmsThreadLocalServiceUtil} to access the vcms thread local service. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsThreadLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the vcms thread to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsThread the vcms thread
	* @return the vcms thread that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsThread addVcmsThread(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new vcms thread with the primary key. Does not add the vcms thread to the database.
	*
	* @param threadId the primary key for the new vcms thread
	* @return the new vcms thread
	*/
	public com.vportal.portlet.vcms.model.VcmsThread createVcmsThread(
		java.lang.String threadId);

	/**
	* Deletes the vcms thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param threadId the primary key of the vcms thread
	* @throws PortalException if a vcms thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsThread(java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the vcms thread from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsThread the vcms thread
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsThread(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.vcms.model.VcmsThread fetchVcmsThread(
		java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms thread with the primary key.
	*
	* @param threadId the primary key of the vcms thread
	* @return the vcms thread
	* @throws PortalException if a vcms thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.vcms.model.VcmsThread getVcmsThread(
		java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vcms.model.VcmsThread> getVcmsThreads(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms threads.
	*
	* @return the number of vcms threads
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVcmsThreadsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the vcms thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsThread the vcms thread
	* @return the vcms thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsThread updateVcmsThread(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);
}