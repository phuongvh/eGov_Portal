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

package com.vportal.portlet.vadvman.service.impl;

import com.vportal.portlet.vadvman.service.base.AdvTypeServiceBaseImpl;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portlet.vadvman.DeleteTypeException;
import com.vportal.portlet.vadvman.model.AdvType;
import com.vportal.portlet.vadvman.service.AdvItemServiceUtil;
import com.vportal.portlet.vadvman.service.permission.AdvTypePermission;
import com.vportal.portlet.vadvman.util.ActionKeysExt;
import com.vportal.portlet.vadvman.util.PortletKeysExt;

/**
 * The implementation of the adv type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vadvman.service.AdvTypeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author DucNN
 * @see com.vportal.portlet.vadvman.service.base.AdvTypeServiceBaseImpl
 * @see com.vportal.portlet.vadvman.service.AdvTypeServiceUtil
 */
public class AdvTypeServiceImpl extends AdvTypeServiceBaseImpl {
	public AdvType addType(long groupId, long companyId, long plid,
			String name, String description, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {
		return addType(groupId, companyId, plid, name, description, null, null,
				communityPermissions, guestPermissions);
	}

	public AdvType addType(long groupId, long companyId, long plid,
			String name, String description, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeysExt.VADVMAN, ActionKeysExt.ADD_TYPE);

		long typeId = CounterLocalServiceUtil
				.increment(AdvType.class.getName());

		AdvType type = advTypePersistence.create(typeId);

		type.setCompanyId(companyId);
		type.setGroupId(groupId);
		type.setCreateDate(new Date());
		type.setModifiedDate(new Date());
		type.setName(name);
		type.setDescription(description);

		advTypePersistence.update(type, false);

		// Add to common resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addAdvTypeResources(type, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());

		} else {

			addAdvTypeResources(type, communityPermissions, guestPermissions);
		}

		return type;
	}

	public AdvType updateType(long typeId, long groupId, long companyId,
			long plid, String name, String description) throws PortalException,
			SystemException, RemoteException {

		AdvTypePermission.check(getPermissionChecker(), typeId,
				ActionKeysExt.UPDATE);

		AdvType type = advTypePersistence.findByPrimaryKey(typeId);

		type.setCompanyId(companyId);
		type.setGroupId(groupId);
		type.setModifiedDate(new Date());
		type.setName(name);
		type.setDescription(description);

		advTypePersistence.update(type, false);
		return type;
	}

	// Delete Type
	public void deleteType(long typeId) throws PortalException,
			SystemException, RemoteException {

		try {
			AdvType type = advTypePersistence.findByPrimaryKey(typeId);

			List listItem = (List) AdvItemServiceUtil.getAllbyType(type
					.getTypeId());

			if (Validator.isNotNull(listItem) && listItem.size() > 0) {
				throw new DeleteTypeException();
			}

			// Delete resource
			ResourceLocalServiceUtil.deleteResource(type.getCompanyId(),
					AdvType.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, type.getTypeId());

			advTypePersistence.remove(type);
		} catch (Exception e) {			
			throw new DeleteTypeException();
		}

	}

	public void deleteType(AdvType type) throws PortalException,
			SystemException, RemoteException {
		List listItem = AdvItemServiceUtil.getAllbyType(type.getTypeId());
		if (listItem != null) {
			AdvItemServiceUtil.deleteItembyType(type.getTypeId());
		}

		advTypePersistence.remove(type.getTypeId());
	}

	public AdvType getType(long typeId) throws PortalException,
			SystemException, RemoteException {
		return advTypePersistence.findByPrimaryKey(typeId);
	}

	public int getItemCount(long typeId) throws PortalException,
			SystemException, RemoteException {
		return advTypePersistence.countAll();
	}

	public List<AdvType> getTypeByG(long groupId) throws PortalException,
			SystemException, RemoteException {
		return advTypePersistence.findByG(groupId);
	}

	public List<AdvType> getTypeByG(long groupId, int start, int end)
			throws PortalException, SystemException, RemoteException {
		return advTypePersistence.findByG(groupId, start, end);
	}

	public int countTypeByG(long groupId) throws PortalException,
			SystemException, RemoteException {
		return advTypePersistence.countByG(groupId);
	}

	// Adding Resource
	public void addAdvTypeResources(long typeId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		AdvType type = advTypePersistence.findByPrimaryKey(typeId);
		addAdvTypeResources(type, addCommunityPermissions, addGuestPermissions);
	}

	public void addAdvTypeResources(AdvType type,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(PortalUtil.getDefaultCompanyId(),
				0, getUserId(), AdvType.class.getName(), type.getPrimaryKey(),
				false, addCommunityPermissions, addGuestPermissions);

	}

	public void addAdvTypeResources(long typeId, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		AdvType type = advTypePersistence.findByPrimaryKey(typeId);
		addAdvTypeResources(type, communityPermissions, guestPermissions);
	}

	public void addAdvTypeResources(AdvType type,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(
				PortalUtil.getDefaultCompanyId(), 0, getUserId(), AdvType.class
						.getName(), type.getPrimaryKey(), communityPermissions,
				guestPermissions);
	}
}