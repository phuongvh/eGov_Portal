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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the vcms thread local service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsThreadLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hai
 * @see VcmsThreadLocalService
 * @see com.vportal.portlet.vcms.service.base.VcmsThreadLocalServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsThreadLocalServiceImpl
 * @generated
 */
public class VcmsThreadLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsThreadLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the vcms thread to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsThread the vcms thread
	* @return the vcms thread that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsThread addVcmsThread(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVcmsThread(vcmsThread);
	}

	/**
	* Creates a new vcms thread with the primary key. Does not add the vcms thread to the database.
	*
	* @param threadId the primary key for the new vcms thread
	* @return the new vcms thread
	*/
	public static com.vportal.portlet.vcms.model.VcmsThread createVcmsThread(
		java.lang.String threadId) {
		return getService().createVcmsThread(threadId);
	}

	/**
	* Deletes the vcms thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param threadId the primary key of the vcms thread
	* @throws PortalException if a vcms thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVcmsThread(java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVcmsThread(threadId);
	}

	/**
	* Deletes the vcms thread from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsThread the vcms thread
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVcmsThread(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVcmsThread(vcmsThread);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.vportal.portlet.vcms.model.VcmsThread fetchVcmsThread(
		java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVcmsThread(threadId);
	}

	/**
	* Returns the vcms thread with the primary key.
	*
	* @param threadId the primary key of the vcms thread
	* @return the vcms thread
	* @throws PortalException if a vcms thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsThread getVcmsThread(
		java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVcmsThread(threadId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsThread> getVcmsThreads(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVcmsThreads(start, end);
	}

	/**
	* Returns the number of vcms threads.
	*
	* @return the number of vcms threads
	* @throws SystemException if a system exception occurred
	*/
	public static int getVcmsThreadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVcmsThreadsCount();
	}

	/**
	* Updates the vcms thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsThread the vcms thread
	* @return the vcms thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsThread updateVcmsThread(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVcmsThread(vcmsThread);
	}

	/**
	* Updates the vcms thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsThread the vcms thread
	* @param merge whether to merge the vcms thread with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsThread updateVcmsThread(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVcmsThread(vcmsThread, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void clearService() {
		_service = null;
	}

	public static VcmsThreadLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsThreadLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsThreadLocalService.class.getName(), portletClassLoader);

			_service = new VcmsThreadLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsThreadLocalServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsThreadLocalService.class);
		}

		return _service;
	}

	public void setService(VcmsThreadLocalService service) {
		MethodCache.remove(VcmsThreadLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsThreadLocalServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsThreadLocalService.class);
	}

	private static VcmsThreadLocalService _service;
}