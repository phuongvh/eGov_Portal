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

package com.vportal.portlet.edirectory.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the e d department local service. This utility wraps {@link com.vportal.portlet.edirectory.service.impl.EDDepartmentLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HOAN
 * @see EDDepartmentLocalService
 * @see com.vportal.portlet.edirectory.service.base.EDDepartmentLocalServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.impl.EDDepartmentLocalServiceImpl
 * @generated
 */
public class EDDepartmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.edirectory.service.impl.EDDepartmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e d department to the database. Also notifies the appropriate model listeners.
	*
	* @param edDepartment the e d department
	* @return the e d department that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment addEDDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEDDepartment(edDepartment);
	}

	/**
	* Creates a new e d department with the primary key. Does not add the e d department to the database.
	*
	* @param id the primary key for the new e d department
	* @return the new e d department
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment createEDDepartment(
		long id) {
		return getService().createEDDepartment(id);
	}

	/**
	* Deletes the e d department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d department
	* @throws PortalException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEDDepartment(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEDDepartment(id);
	}

	/**
	* Deletes the e d department from the database. Also notifies the appropriate model listeners.
	*
	* @param edDepartment the e d department
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEDDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEDDepartment(edDepartment);
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

	public static com.vportal.portlet.edirectory.model.EDDepartment fetchEDDepartment(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEDDepartment(id);
	}

	/**
	* Returns the e d department with the primary key.
	*
	* @param id the primary key of the e d department
	* @return the e d department
	* @throws PortalException if a e d department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment getEDDepartment(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEDDepartment(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e d departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d departments
	* @param end the upper bound of the range of e d departments (not inclusive)
	* @return the range of e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> getEDDepartments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEDDepartments(start, end);
	}

	/**
	* Returns the number of e d departments.
	*
	* @return the number of e d departments
	* @throws SystemException if a system exception occurred
	*/
	public static int getEDDepartmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEDDepartmentsCount();
	}

	/**
	* Updates the e d department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param edDepartment the e d department
	* @return the e d department that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment updateEDDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEDDepartment(edDepartment);
	}

	/**
	* Updates the e d department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param edDepartment the e d department
	* @param merge whether to merge the e d department with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the e d department that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDDepartment updateEDDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEDDepartment(edDepartment, merge);
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

	public static com.vportal.portlet.edirectory.model.EDDepartment getDepartmentByD_G(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getService().getDepartmentByD_G(departmentId, groupId);
	}

	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> getAllDepartment()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllDepartment();
	}

	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> getByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByGroupId(groupId);
	}

	public static java.util.List<com.vportal.portlet.edirectory.model.EDDepartment> getByParent(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByParent(parentId);
	}

	public static com.vportal.portlet.edirectory.model.EDDepartment getByParent1(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByParent1(parentId);
	}

	public static com.vportal.portlet.edirectory.model.EDDepartment addDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment dep, long userId,
		java.lang.String languageId, java.lang.String domainId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().addDepartment(dep, userId, languageId, domainId);
	}

	public static com.vportal.portlet.edirectory.model.EDDepartment updateDepartment(
		long departmentId, java.lang.String name, java.lang.String description,
		long parent, int level, java.lang.String address,
		java.lang.String email, java.lang.String phone, java.lang.String fax,
		java.lang.String languageId, long userId, long groupId,
		java.lang.String website)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDDepartmentException {
		return getService()
				   .updateDepartment(departmentId, name, description, parent,
			level, address, email, phone, fax, languageId, userId, groupId,
			website);
	}

	/**
	* @param departmentId
	* @throws SystemException
	* @throws PortalException
	*/
	public static void deleteDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDepartment(departmentId);
	}

	/**
	* @param department
	* @throws PortalException
	* @throws SystemException
	*/
	public static void deleteDepartment(
		com.vportal.portlet.edirectory.model.EDDepartment department)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDepartment(department);
	}

	public static void clearService() {
		_service = null;
	}

	public static EDDepartmentLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EDDepartmentLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					EDDepartmentLocalService.class.getName(), portletClassLoader);

			_service = new EDDepartmentLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(EDDepartmentLocalServiceUtil.class,
				"_service");
			MethodCache.remove(EDDepartmentLocalService.class);
		}

		return _service;
	}

	public void setService(EDDepartmentLocalService service) {
		MethodCache.remove(EDDepartmentLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(EDDepartmentLocalServiceUtil.class,
			"_service");
		MethodCache.remove(EDDepartmentLocalService.class);
	}

	private static EDDepartmentLocalService _service;
}