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
 * The utility for the vcms category local service. This utility wraps {@link com.vportal.portlet.vcms.service.impl.VcmsCategoryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hai
 * @see VcmsCategoryLocalService
 * @see com.vportal.portlet.vcms.service.base.VcmsCategoryLocalServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.impl.VcmsCategoryLocalServiceImpl
 * @generated
 */
public class VcmsCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vcms.service.impl.VcmsCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the vcms category to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsCategory the vcms category
	* @return the vcms category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory addVcmsCategory(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVcmsCategory(vcmsCategory);
	}

	/**
	* Creates a new vcms category with the primary key. Does not add the vcms category to the database.
	*
	* @param categoryId the primary key for the new vcms category
	* @return the new vcms category
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory createVcmsCategory(
		java.lang.String categoryId) {
		return getService().createVcmsCategory(categoryId);
	}

	/**
	* Deletes the vcms category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the vcms category
	* @throws PortalException if a vcms category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVcmsCategory(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVcmsCategory(categoryId);
	}

	/**
	* Deletes the vcms category from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsCategory the vcms category
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVcmsCategory(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVcmsCategory(vcmsCategory);
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

	public static com.vportal.portlet.vcms.model.VcmsCategory fetchVcmsCategory(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVcmsCategory(categoryId);
	}

	/**
	* Returns the vcms category with the primary key.
	*
	* @param categoryId the primary key of the vcms category
	* @return the vcms category
	* @throws PortalException if a vcms category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory getVcmsCategory(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVcmsCategory(categoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getVcmsCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVcmsCategories(start, end);
	}

	/**
	* Returns the number of vcms categories.
	*
	* @return the number of vcms categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getVcmsCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVcmsCategoriesCount();
	}

	/**
	* Updates the vcms category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsCategory the vcms category
	* @return the vcms category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory updateVcmsCategory(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVcmsCategory(vcmsCategory);
	}

	/**
	* Updates the vcms category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsCategory the vcms category
	* @param merge whether to merge the vcms category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsCategory updateVcmsCategory(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVcmsCategory(vcmsCategory, merge);
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

	public static VcmsCategoryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VcmsCategoryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VcmsCategoryLocalService.class.getName(), portletClassLoader);

			_service = new VcmsCategoryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VcmsCategoryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(VcmsCategoryLocalService.class);
		}

		return _service;
	}

	public void setService(VcmsCategoryLocalService service) {
		MethodCache.remove(VcmsCategoryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(VcmsCategoryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(VcmsCategoryLocalService.class);
	}

	private static VcmsCategoryLocalService _service;
}