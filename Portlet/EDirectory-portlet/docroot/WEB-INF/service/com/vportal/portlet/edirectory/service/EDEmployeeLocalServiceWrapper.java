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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EDEmployeeLocalService}.
 * </p>
 *
 * @author    HOAN
 * @see       EDEmployeeLocalService
 * @generated
 */
public class EDEmployeeLocalServiceWrapper implements EDEmployeeLocalService,
	ServiceWrapper<EDEmployeeLocalService> {
	public EDEmployeeLocalServiceWrapper(
		EDEmployeeLocalService edEmployeeLocalService) {
		_edEmployeeLocalService = edEmployeeLocalService;
	}

	/**
	* Adds the e d employee to the database. Also notifies the appropriate model listeners.
	*
	* @param edEmployee the e d employee
	* @return the e d employee that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDEmployee addEDEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee edEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.addEDEmployee(edEmployee);
	}

	/**
	* Creates a new e d employee with the primary key. Does not add the e d employee to the database.
	*
	* @param id the primary key for the new e d employee
	* @return the new e d employee
	*/
	public com.vportal.portlet.edirectory.model.EDEmployee createEDEmployee(
		long id) {
		return _edEmployeeLocalService.createEDEmployee(id);
	}

	/**
	* Deletes the e d employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d employee
	* @throws PortalException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEDEmployee(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_edEmployeeLocalService.deleteEDEmployee(id);
	}

	/**
	* Deletes the e d employee from the database. Also notifies the appropriate model listeners.
	*
	* @param edEmployee the e d employee
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEDEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee edEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		_edEmployeeLocalService.deleteEDEmployee(edEmployee);
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
		return _edEmployeeLocalService.dynamicQuery(dynamicQuery);
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
		return _edEmployeeLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _edEmployeeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _edEmployeeLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee fetchEDEmployee(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.fetchEDEmployee(id);
	}

	/**
	* Returns the e d employee with the primary key.
	*
	* @param id the primary key of the e d employee
	* @return the e d employee
	* @throws PortalException if a e d employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDEmployee getEDEmployee(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getEDEmployee(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e d employee with the UUID in the group.
	*
	* @param uuid the UUID of e d employee
	* @param groupId the group id of the e d employee
	* @return the e d employee
	* @throws PortalException if a e d employee with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDEmployee getEDEmployeeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getEDEmployeeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e d employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d employees
	* @param end the upper bound of the range of e d employees (not inclusive)
	* @return the range of e d employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getEDEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getEDEmployees(start, end);
	}

	/**
	* Returns the number of e d employees.
	*
	* @return the number of e d employees
	* @throws SystemException if a system exception occurred
	*/
	public int getEDEmployeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getEDEmployeesCount();
	}

	/**
	* Updates the e d employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param edEmployee the e d employee
	* @return the e d employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDEmployee updateEDEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee edEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.updateEDEmployee(edEmployee);
	}

	/**
	* Updates the e d employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param edEmployee the e d employee
	* @param merge whether to merge the e d employee with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the e d employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDEmployee updateEDEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee edEmployee,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.updateEDEmployee(edEmployee, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _edEmployeeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_edEmployeeLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee getById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return _edEmployeeLocalService.getById(id);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee getEmployeeByE_G(
		long employeeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return _edEmployeeLocalService.getEmployeeByE_G(employeeId, groupId);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getAllEmployee()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getAllEmployee();
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getAllEmployee(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getAllEmployee(begin, end);
	}

	/**
	* Danh sach can bo theo don vi, chuc vu va ten
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getEmployeeByAll(
		long departmentId, long functionId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getEmployeeByAll(departmentId,
			functionId, name);
	}

	/**
	* Danh sÃƒÂ¡ch cÃƒÂ¡n bÃ¡Â»â„¢ theo Ã„â€˜Ã†Â¡n vÃ¡Â»â€¹
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByDepartmentId(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getByDepartmentId(departmentId);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByDepartmentId(
		long departmentId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getByDepartmentId(departmentId, begin,
			end);
	}

	/**
	* TÃƒÂ¬m cÃƒÂ¡n bÃ¡Â»â„¢ theo id vÃƒÂ  Ã„â€˜Ã†Â¡n vÃ¡Â»â€¹
	*/
	public com.vportal.portlet.edirectory.model.EDEmployee getByDepartmentAndId(
		long departmentId, long id) {
		return _edEmployeeLocalService.getByDepartmentAndId(departmentId, id);
	}

	/**
	* Danh sÃƒÂ¡ch cÃƒÂ¡n bÃ¡Â»â„¢ theo chÃ¡Â»Â©c vÃ¡Â»Â¥
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByFunctionId(
		long functionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		return _edEmployeeLocalService.getByFunctionId(functionId);
	}

	/**
	* Danh sÃƒÂ¡ch cÃƒÂ¡n bÃ¡Â»â„¢ theo Ã„â€˜Ã†Â¡n vÃ¡Â»â€¹ vÃƒÂ  chÃ¡Â»Â©c vÃ¡Â»Â¥
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByDepartmentAndFunction(
		long departmentId, long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getByDepartmentAndFunction(departmentId,
			functionId);
	}

	/**
	* Danh sÃƒÂ¡ch cÃƒÂ¡n bÃ¡Â»â„¢ theo hÃ¡Â»ï¿½ tÃƒÂªn
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getByName(name);
	}

	/**
	* Danh sÃƒÂ¡ch cÃƒÂ¡n bÃ¡Â»â„¢ theo hÃ¡Â»ï¿½ tÃƒÂªn vÃƒÂ  Ã„â€˜Ã†Â¡n vÃ¡Â»â€¹
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByDepartmentAndName(
		long departmentId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getByDepartmentAndName(departmentId, name);
	}

	/**
	* Danh sÃƒÂ¡ch cÃƒÂ¡n bÃ¡Â»â„¢ theo HÃ¡Â»ï¿½ tÃƒÂªn vÃƒÂ  ChÃ¡Â»Â©c vÃ¡Â»Â¥
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByFunctionAndName(
		long functionId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getByFunctionAndName(functionId, name);
	}

	/**
	* Tim kiem can bo cua nguoi dan Danh sÃƒÂ¡ch cÃƒÂ¡n bÃ¡Â»â„¢ theo HÃ¡Â»ï¿½ tÃƒÂªn, Ã„ï¿½Ã†Â¡n vÃ¡Â»â€¹ vÃƒÂ 
	* ChÃ¡Â»Â©c vÃ¡Â»Â¥
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getByDepartmentFunctionName(
		long departmentId, long functionId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getByDepartmentFunctionName(departmentId,
			functionId, name);
	}

	public int countEmployeeByParam(long groupId, java.lang.String language,
		boolean isShow, long departmentId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.countEmployeeByParam(groupId, language,
			isShow, departmentId, name);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> getEmployeeByParam(
		long groupId, java.lang.String language, boolean isShow,
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.getEmployeeByParam(groupId, language,
			isShow, departmentId, start, end);
	}

	/**
	* ThÃƒÂªm cÃƒÂ¡n bÃ¡Â»â„¢
	*/
	public com.vportal.portlet.edirectory.model.EDEmployee addEmployee(
		java.lang.String title, java.lang.String name, java.util.Date birthday,
		java.lang.String sex, java.lang.String homeSide, java.lang.String race,
		java.lang.String home, java.lang.String homePhone,
		java.lang.String workPhone, java.lang.String mobilePhone,
		java.lang.String email, long[] functionIds, long departmentId,
		java.lang.String imageUrl, java.lang.String majorLevel,
		java.lang.String philosophism, java.lang.String family,
		java.lang.String foreignLanguage, java.util.Date joinDate,
		java.lang.String otherInfo, boolean isShowTree, long displayOrder,
		java.lang.String show, long groupId, long companyId, long userId,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _edEmployeeLocalService.addEmployee(title, name, birthday, sex,
			homeSide, race, home, homePhone, workPhone, mobilePhone, email,
			functionIds, departmentId, imageUrl, majorLevel, philosophism,
			family, foreignLanguage, joinDate, otherInfo, isShowTree,
			displayOrder, show, groupId, companyId, userId, languageId);
	}

	public com.vportal.portlet.edirectory.model.EDEmployee updateEmployee(
		long employeeId, java.lang.String title, java.lang.String name,
		java.util.Date birthday, java.lang.String sex,
		java.lang.String homeSide, java.lang.String race,
		java.lang.String home, java.lang.String homePhone,
		java.lang.String workPhone, java.lang.String mobilePhone,
		java.lang.String email, long[] functionIds, long departmentId,
		java.lang.String image, java.lang.String majorLevel,
		java.lang.String philosophism, java.lang.String family,
		java.lang.String foreignLanguage, java.util.Date joinDate,
		java.lang.String otherInfo, boolean isShowTree, long displayOrder,
		java.lang.String show, long groupId, long companyId, long userId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException,
			java.rmi.RemoteException {
		return _edEmployeeLocalService.updateEmployee(employeeId, title, name,
			birthday, sex, homeSide, race, home, homePhone, workPhone,
			mobilePhone, email, functionIds, departmentId, image, majorLevel,
			philosophism, family, foreignLanguage, joinDate, otherInfo,
			isShowTree, displayOrder, show, groupId, companyId, userId, language);
	}

	/**
	* XÃƒÂ³a cÃƒÂ¡n bÃ¡Â»â„¢ theo Id
	*/
	public void delelteEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_edEmployeeLocalService.delelteEmployee(employeeId);
	}

	/**
	* XÃƒÂ³a mÃ¡Â»â„¢t cÃƒÂ¡n bÃ¡Â»â„¢
	*/
	public void deleteEmployee(
		com.vportal.portlet.edirectory.model.EDEmployee employee)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_edEmployeeLocalService.deleteEmployee(employee);
	}

	/**
	* ThÃƒÂªm cÃƒÂ¡c chÃ¡Â»Â©c vÃ¡Â»Â¥ cÃ¡Â»Â§a mÃ¡Â»â„¢t cÃƒÂ¡n bÃ¡Â»â„¢
	*/
	public void addFunctionToEmployee(long employeeId, long[] functionIds)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		_edEmployeeLocalService.addFunctionToEmployee(employeeId, functionIds);
	}

	public void addImage(long employeeId, java.lang.String imageKey)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDEmployeeException {
		_edEmployeeLocalService.addImage(employeeId, imageKey);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> searchEmployeeByParams(
		long groupId, java.lang.String language, long departmentId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.searchEmployeeByParams(groupId,
			language, departmentId, name);
	}

	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> searchEmployeeByParams(
		long groupId, java.lang.String language, java.lang.String name,
		long departmentId, long functionId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.searchEmployeeByParams(groupId,
			language, name, departmentId, functionId, begin, end);
	}

	public java.util.List searchEmployeeByParams(long groupId,
		java.lang.String language, java.lang.String name, long departmentId,
		long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.searchEmployeeByParams(groupId,
			language, name, departmentId, functionId);
	}

	public int countEmployeeByParam(long groupId, java.lang.String language,
		java.lang.String name, long departmentId, long functionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.countEmployeeByParam(groupId, language,
			name, departmentId, functionId);
	}

	/**
	* Search Employee by departmentId, name, phone, email
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDEmployee> searchEmployeeByDepartmentNamePhoneEmail(
		long groupId, java.lang.String language, long departmentId,
		java.lang.String name, java.lang.String phone, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployeeLocalService.searchEmployeeByDepartmentNamePhoneEmail(groupId,
			language, departmentId, name, phone, email);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EDEmployeeLocalService getWrappedEDEmployeeLocalService() {
		return _edEmployeeLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEDEmployeeLocalService(
		EDEmployeeLocalService edEmployeeLocalService) {
		_edEmployeeLocalService = edEmployeeLocalService;
	}

	public EDEmployeeLocalService getWrappedService() {
		return _edEmployeeLocalService;
	}

	public void setWrappedService(EDEmployeeLocalService edEmployeeLocalService) {
		_edEmployeeLocalService = edEmployeeLocalService;
	}

	private EDEmployeeLocalService _edEmployeeLocalService;
}