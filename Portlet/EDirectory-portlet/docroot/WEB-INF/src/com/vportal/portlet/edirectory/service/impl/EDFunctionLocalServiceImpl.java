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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.vportal.portlet.edirectory.DeleteFunctionException;
import com.vportal.portlet.edirectory.NoSuchEDFunctionException;
import com.vportal.portlet.edirectory.model.EDFunction;
import com.vportal.portlet.edirectory.model.EDFunctionEmployee;
import com.vportal.portlet.edirectory.service.base.EDFunctionLocalServiceBaseImpl;

/**
 * The implementation of the e d function local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.edirectory.service.EDFunctionLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.edirectory.service.base.EDFunctionLocalServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil
 */
public class EDFunctionLocalServiceImpl extends EDFunctionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil} to
	 * access the e d function local service.
	 */
	public EDFunction getFunctionByF_G(long functionId, long groupId)
			throws NoSuchEDFunctionException, SystemException {
		return edFunctionPersistence.findByF_G(functionId, groupId);
	}

	public List<EDFunction> getAllFunction() throws SystemException {
		return edFunctionPersistence.findAll();
	}

	public List<EDFunction> getFunctionByGroupAndLanguage(long groupId,
			String language) throws SystemException {
		return edFunctionPersistence.findByG_L(groupId, language);
	}

	public EDFunction addFunction(EDFunction function, long userId,
			String language) throws SystemException, PortalException {
		EDFunction edFunction = edFunctionPersistence
				.create(counterLocalService.increment(EDFunction.class
						.getName()));

		edFunction.setName(function.getName());
		edFunction.setCreatedDate(function.getCreatedDate());
		edFunction.setLevelEd(function.getLevelEd());
		edFunction.setIsShowTree(function.getIsShowTree());
		edFunction.setDescription(function.getDescription());
		edFunction.setGroupId(function.getGroupId());
		edFunction.setCompanyId(function.getCompanyId());
		edFunction.setUserId(userId);
		edFunction.setLanguageId(language);
		// resourceLocalService.addResources(function.getCompanyId(),
		// function.getGroupId(), userId,
		// EDFunction.class.getName(), edFunction.getPrimaryKey(), false, true,
		// true);
		return edFunctionPersistence.update(edFunction, false);
	}

	/**
	 * 
	 * @param functionId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void deleteFunction(long functionId) throws SystemException,
			PortalException {
		EDFunction function = edFunctionPersistence
				.findByPrimaryKey(functionId);
		deleteFunction(function);
	}

	/**
	 * 
	 * @param function
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteFunction(EDFunction function) throws PortalException,
			SystemException {
		resourceLocalService.deleteResource(function.getCompanyId(),
				EDFunction.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				function.getPrimaryKey());
		// edFunctionPersistence.remove(function);
		try {
			List<EDFunctionEmployee> edFunctionEmployeeList = edFunctionEmployeeLocalService
					.getByFunctionId(function.getId());
			if (edFunctionEmployeeList.size() > 0) {
				throw new DeleteFunctionException();
			}
			edFunctionLocalService.deleteEDFunction(function.getId());
		} catch (Exception e) {
			throw new DeleteFunctionException();
		}
	}
}