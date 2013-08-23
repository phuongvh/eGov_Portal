/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

package com.vportal.portlet.edirectory.service.impl;

import java.rmi.RemoteException;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.vportal.portlet.edirectory.NoSuchEDDepartmentException;
import com.vportal.portlet.edirectory.model.EDDepartment;
import com.vportal.portlet.edirectory.service.base.EDDepartmentLocalServiceBaseImpl;

/**
 * The implementation of the e d department local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.edirectory.service.EDDepartmentLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.edirectory.service.base.EDDepartmentLocalServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil
 */
public class EDDepartmentLocalServiceImpl extends
		EDDepartmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil} to
	 * access the e d department local service.
	 */
	public EDDepartment getDepartmentByD_G(long departmentId, long groupId)
			throws NoSuchEDDepartmentException, SystemException {
		return edDepartmentPersistence.findByD_G(departmentId, groupId);
	}

	public List<EDDepartment> getAllDepartment() throws SystemException {
		return edDepartmentPersistence.findAll();
	}

	public List<EDDepartment> getByGroupId(long groupId) throws SystemException {
		return edDepartmentPersistence.findByGroupId(groupId);
	}

	public List<EDDepartment> getByParent(long parentId) throws SystemException {
		return edDepartmentPersistence.findByParent(parentId);
	}

	public EDDepartment getByParent1(long parentId) throws SystemException {
		return (EDDepartment) edDepartmentPersistence.findByParent(parentId);
	}

	public EDDepartment addDepartment(EDDepartment dep, long userId,
			String languageId, String domainId) throws SystemException,
			RemoteException {

		long departmentId = CounterLocalServiceUtil
				.increment(EDDepartment.class.getName());
		EDDepartment department = edDepartmentPersistence.create(departmentId);
		department.setName(dep.getName());
		department.setDescription(dep.getDescription());
		department.setParent(dep.getParent());
		department.setLevelEd(dep.getLevelEd());
		department.setAddress(dep.getAddress());
		department.setEmail(dep.getEmail());
		department.setPhone(dep.getPhone());
		department.setFax(dep.getFax());
		department.setWebsite(dep.getWebsite());

		department.setLanguageId(dep.getLanguageId());
		department.setUserId(dep.getUserId());
		department.setGroupId(dep.getGroupId());
		department.setDomainId(dep.getDomainId());
		department.setCreatedDate(dep.getCreatedDate());
		department.setLanguageId(languageId);
		department.setDomainId(domainId);
		try {
			resourceLocalService.addResources(dep.getCompanyId(),
					dep.getGroupId(), userId, EDDepartment.class.getName(),
					department.getPrimaryKey(), false, true, true);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return edDepartmentPersistence.update(department, false);
	}

	public EDDepartment updateDepartment(long departmentId, String name,
			String description, long parent, int level, String address,
			String email, String phone, String fax, String languageId,
			long userId, long groupId, String website) throws SystemException,
			NoSuchEDDepartmentException {

		EDDepartment department = edDepartmentPersistence
				.findByPrimaryKey(departmentId);
		department.setName(name);
		department.setDescription(description);
		department.setParent(parent);
		department.setLevelEd(level);
		department.setAddress(address);
		department.setEmail(email);
		department.setPhone(phone);
		department.setFax(fax);

		department.setLanguageId(languageId);
		department.setUserId(userId);
		department.setGroupId(groupId);
		department.setWebsite(website);

		// edDepartmentPersistence.update(department,false);
		return department;
	}

	/**
	 * 
	 * @param departmentId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void deleteDepartment(long departmentId) throws SystemException,
			PortalException {
		EDDepartment department = edDepartmentPersistence
				.findByPrimaryKey(departmentId);
		deleteDepartment(department);
	}

	/**
	 * 
	 * @param department
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteDepartment(EDDepartment department)
			throws PortalException, SystemException {
		resourceLocalService.deleteResource(department.getCompanyId(),
				EDDepartment.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, department.getPrimaryKey());
		edDepartmentPersistence.remove(department);
	}
}