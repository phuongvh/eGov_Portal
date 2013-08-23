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

package com.vportal.portlet.vcms.service.impl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.vportal.portlet.vcms.model.VcmsStatus;
import com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil;
import com.vportal.portlet.vcms.service.base.VcmsStatusLocalServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsStatusUtil;

/**
 * The implementation of the vcms status local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsStatusLocalService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil} to access
 * the vcms status local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsStatusLocalServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsStatusLocalServiceUtil
 */
public class VcmsStatusLocalServiceImpl extends VcmsStatusLocalServiceBaseImpl {
	public VcmsStatus addStatus(long companyId, long groupId, long userId,
			String name, String description, String cssClass, String textColor,
			long position, boolean isPrimary, boolean active,
			Boolean addCommunityPermissions, Boolean addGuestPermissions,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException, RemoteException {

		long statusId = CounterLocalServiceUtil.increment(VcmsStatus.class
				.getName());

		Date now = new Date();

		VcmsStatus status = VcmsStatusUtil.create(statusId);
		status.setName(name);
		status.setDescription(description);
		status.setIsPrimary(isPrimary);
		status.setCssClass(cssClass);
		status.setTextColor(textColor);

		status.setCompanyId(companyId);
		status.setGroupId(groupId);
		status.setPosition(position);
		status.setActive(active);
		status.setCreatedByUser(String.valueOf(userId));
		status.setCreatedDate(now);

		vcmsStatusPersistence.update(status, false);

		vcmsStatusFinder.updatePostion(statusId, companyId, groupId, position,
				true);
		if (isPrimary)
			vcmsStatusFinder.updatePrimary(statusId, companyId, groupId);
		if (active)
			vcmsStatusFinder.updateActive(statusId, companyId, groupId);

		// Add to common resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addResources(status, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addResources(status, communityPermissions, guestPermissions);
		}

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - CREATE: vcms status [" + name + "] by " + userId);

		return status;
	}

	public VcmsStatus updateStatus(long statusId, long companyId, long groupId,
			long userId, String name, String description, String cssClass,
			String textColor, long position, boolean isPrimary, boolean active,
			Boolean addCommunityPermissions, Boolean addGuestPermissions,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException, RemoteException {

		Date now = new Date();

		VcmsStatus status = vcmsStatusPersistence.findByPrimaryKey(statusId);
		// decrease position of all status where position >= status. old
		// position
		vcmsStatusFinder.updatePostion(statusId, companyId, groupId,
				status.getPosition(), false);
		// long temp = status.getPosition();
		status.setName(name);
		status.setDescription(description);
		status.setIsPrimary(isPrimary);
		status.setCssClass(cssClass);
		status.setTextColor(textColor);

		status.setCompanyId(companyId);
		status.setGroupId(groupId);
		status.setPosition(position);
		status.setActive(active);
		status.setModifiedByUser(String.valueOf(userId));
		status.setModifiedDate(now);

		vcmsStatusPersistence.update(status, true);

		// increase position of all status where position >= status.position
		vcmsStatusFinder.updatePostion(statusId, companyId, groupId, position,
				true);
		if (isPrimary)
			vcmsStatusFinder.updatePrimary(statusId, companyId, groupId);
		if (active)
			vcmsStatusFinder.updateActive(statusId, companyId, groupId);

		// Add to common resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addResources(status, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addResources(status, communityPermissions, guestPermissions);
		}

		// Logging...
		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - UPDATE: vcms status [" + name + "] by " + userId);

		return status;
	}

	public List getStatusByPosition(long position) throws PortalException,
			SystemException, RemoteException {
		return vcmsStatusFinder.selectStatusId(position);
	}

	public List getByG_P(long groupId, long position) throws PortalException,
			SystemException, RemoteException {
		return vcmsStatusPersistence.findByG_P(groupId, position);
	}

	public List getByGroupId(long groupId) throws PortalException,
			SystemException, RemoteException {
		return vcmsStatusPersistence.findByGroupId(groupId);
	}

	public List getByGroupId(long groupId, int begin, int end)
			throws PortalException, SystemException, RemoteException {
		return vcmsStatusPersistence.findByGroupId(groupId, begin, end);
	}

	public int countByGroupId(long groupId) throws PortalException,
			SystemException, RemoteException {
		return vcmsStatusPersistence.countByGroupId(groupId);
	}

	public VcmsStatus getByC_G_A(long companyId, long groupId, boolean active)
			throws PortalException, SystemException, RemoteException {

		return vcmsStatusPersistence.findByC_G_A(companyId, groupId, active);
	}

	public VcmsStatus getByA(boolean active) throws PortalException,
			SystemException, RemoteException {

		return vcmsStatusPersistence.findByA(active);
	}

	public void deleteStatus(long statusId, long companyId, long groupId,
			long userId) throws PortalException, SystemException,
			RemoteException {
		VcmsStatus status = vcmsStatusPersistence.findByPrimaryKey(statusId);

		vcmsStatusLocalService.deleteVcmsStatus(statusId);

		// reorder position of all status
		vcmsStatusFinder.updatePostion(statusId, companyId, groupId,
				status.getPosition(), false);

		Date now = new Date();
		// Logging...
		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - DELETE: vcms status [" + status.getName() + "] by "
				+ userId);

	}

	// Common Resources Utilities ...

	public void addResources(int statusId, boolean addCommunityPermissions,
			boolean addGuestPermissions) throws PortalException,
			SystemException {

		VcmsStatus status = VcmsStatusUtil.findByPrimaryKey(statusId);

		addResources(status, addCommunityPermissions, addGuestPermissions);
	}

	public void addResources(VcmsStatus status,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(status.getCompanyId(), 0,
				Long.parseLong(status.getCreatedByUser()),
				VcmsStatus.class.getName(), status.getPrimaryKey(), false,
				addCommunityPermissions, addGuestPermissions);
	}

	public void addResources(int statusId, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		VcmsStatus status = VcmsStatusUtil.findByPrimaryKey(statusId);

		addResources(status, communityPermissions, guestPermissions);
	}

	public void addResources(VcmsStatus status, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(status.getCompanyId(), 0,
				Long.parseLong(status.getCreatedByUser()),
				VcmsStatus.class.getName(), status.getPrimaryKey(),
				communityPermissions, guestPermissions);
	}
}