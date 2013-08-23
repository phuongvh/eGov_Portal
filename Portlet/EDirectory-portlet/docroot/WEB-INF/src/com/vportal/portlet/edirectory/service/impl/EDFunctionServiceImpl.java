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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portlet.edirectory.DeleteFunctionException;
import com.vportal.portlet.edirectory.model.EDFunction;
import com.vportal.portlet.edirectory.model.EDFunctionEmployee;
import com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil;
import com.vportal.portlet.edirectory.service.base.EDFunctionServiceBaseImpl;
import com.vportal.portlet.edirectory.service.permission.EDFunctionPermission;
import com.vportal.portlet.edirectory.util.ActionKeysExt;
import com.vportal.portlet.edirectory.util.WebKeysExt;

/**
 * The implementation of the e d function remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.edirectory.service.EDFunctionService} interface.
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.edirectory.service.base.EDFunctionServiceBaseImpl
 * @see com.vportal.portlet.edirectory.service.EDFunctionServiceUtil
 */
public class EDFunctionServiceImpl extends EDFunctionServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.vportal.portlet.edirectory.service.EDFunctionServiceUtil} to access
	 * the e d function remote service.
	 */
	public EDFunction addFunction(EDFunction function, String languageId,
			long userId, long plid, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		PortletPermissionUtil.check(getPermissionChecker(), plid,
				WebKeysExt.EDIR, ActionKeysExt.ADD_FUNCTION);
		EDFunction result = edFunctionLocalService.addFunction(function,
				userId, languageId);

		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {
			addFunctionResources(result,
					addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addFunctionResources(result, communityPermissions, guestPermissions);
		}
		return result;
	}

	public EDFunction updateFunction(EDFunction function, long functionId,
			long groupId) throws SystemException, PrincipalException,
			PortalException, RemoteException {
		EDFunctionPermission.check(getPermissionChecker(), groupId, functionId,
				ActionKeys.UPDATE);
		return edFunctionLocalService.updateEDFunction(function);
	}

	public void removeFunction(long functionId, long groupId)
			throws PrincipalException, PortalException, SystemException,
			RemoteException {
		EDFunctionPermission.check(getPermissionChecker(), groupId, functionId,
				ActionKeys.DELETE);

		EDFunction function = edFunctionPersistence
				.findByPrimaryKey(functionId);
		ResourceLocalServiceUtil.deleteResource(
				PortalUtil.getDefaultCompanyId(), EDFunction.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, function.getId());
		try {
			List<EDFunctionEmployee> edFunctionEmployeeList = edFunctionEmployeeLocalService
					.getByFunctionId(functionId);
			if (edFunctionEmployeeList.size() > 0) {
				throw new DeleteFunctionException();
			}
			edFunctionLocalService.deleteEDFunction(functionId);
		} catch (Exception e) {
			throw new DeleteFunctionException();
		}

	}

	// add resource
	public void addFunctionResources(long functionId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		EDFunction function = edFunctionPersistence
				.findByPrimaryKey(functionId);

		addFunctionResources(function, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addFunctionResources(EDFunction function,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(PortalUtil.getDefaultCompanyId(),
				0, getUserId(), EDFunction.class.getName(),
				String.valueOf(function.getId()), false,
				addCommunityPermissions, addGuestPermissions);
	}

	public void addFunctionResources(long functionId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		EDFunction function = EDFunctionLocalServiceUtil
				.getEDFunction(functionId);

		addFunctionResources(function, communityPermissions, guestPermissions);
	}

	public void addFunctionResources(EDFunction function,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(
				PortalUtil.getDefaultCompanyId(), 0, getUserId(),
				EDFunction.class.getName(), String.valueOf(function.getId()),
				communityPermissions, guestPermissions);
	}
}