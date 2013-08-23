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
 * The utility for the vcms article version local service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsArticleVersionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hai
 * @see VcmsArticleVersionLocalService
 * @see com.vportal.portlet.vcms.service.base.VcmsArticleVersionLocalServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsArticleVersionLocalServiceImpl
 * @generated
 */
public class VcmsArticleVersionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsArticleVersionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the vcms article version to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleVersion the vcms article version
	* @return the vcms article version that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleVersion addVcmsArticleVersion(
		com.vportal.portlet.vcms.model.VcmsArticleVersion vcmsArticleVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVcmsArticleVersion(vcmsArticleVersion);
	}

	/**
	* Creates a new vcms article version with the primary key. Does not add the vcms article version to the database.
	*
	* @param articleVersionId the primary key for the new vcms article version
	* @return the new vcms article version
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleVersion createVcmsArticleVersion(
		long articleVersionId) {
		return getService().createVcmsArticleVersion(articleVersionId);
	}

	/**
	* Deletes the vcms article version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articleVersionId the primary key of the vcms article version
	* @throws PortalException if a vcms article version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVcmsArticleVersion(long articleVersionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVcmsArticleVersion(articleVersionId);
	}

	/**
	* Deletes the vcms article version from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleVersion the vcms article version
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVcmsArticleVersion(
		com.vportal.portlet.vcms.model.VcmsArticleVersion vcmsArticleVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVcmsArticleVersion(vcmsArticleVersion);
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

	public static com.vportal.portlet.vcms.model.VcmsArticleVersion fetchVcmsArticleVersion(
		long articleVersionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVcmsArticleVersion(articleVersionId);
	}

	/**
	* Returns the vcms article version with the primary key.
	*
	* @param articleVersionId the primary key of the vcms article version
	* @return the vcms article version
	* @throws PortalException if a vcms article version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleVersion getVcmsArticleVersion(
		long articleVersionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVcmsArticleVersion(articleVersionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsArticleVersion> getVcmsArticleVersions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVcmsArticleVersions(start, end);
	}

	/**
	* Returns the number of vcms article versions.
	*
	* @return the number of vcms article versions
	* @throws SystemException if a system exception occurred
	*/
	public static int getVcmsArticleVersionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVcmsArticleVersionsCount();
	}

	/**
	* Updates the vcms article version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleVersion the vcms article version
	* @return the vcms article version that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleVersion updateVcmsArticleVersion(
		com.vportal.portlet.vcms.model.VcmsArticleVersion vcmsArticleVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVcmsArticleVersion(vcmsArticleVersion);
	}

	/**
	* Updates the vcms article version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleVersion the vcms article version
	* @param merge whether to merge the vcms article version with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms article version that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsArticleVersion updateVcmsArticleVersion(
		com.vportal.portlet.vcms.model.VcmsArticleVersion vcmsArticleVersion,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVcmsArticleVersion(vcmsArticleVersion, merge);
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

	public static VcmsArticleVersionLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsArticleVersionLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsArticleVersionLocalService.class.getName(),
					portletClassLoader);

			_service = new VcmsArticleVersionLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsArticleVersionLocalServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsArticleVersionLocalService.class);
		}

		return _service;
	}

	public void setService(VcmsArticleVersionLocalService service) {
		MethodCache.remove(VcmsArticleVersionLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsArticleVersionLocalServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsArticleVersionLocalService.class);
	}

	private static VcmsArticleVersionLocalService _service;
}