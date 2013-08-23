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

package com.vportal.portlet.vlinksman.service.impl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portlet.vlinksman.model.LinkGroup;
import com.vportal.portlet.vlinksman.service.base.LinkGroupServiceBaseImpl;
import com.vportal.portlet.vlinksman.service.permission.LinkGroupPermission;
import com.vportal.portlet.vlinksman.service.persistence.LinkGroupUtil;
import com.vportal.portlet.vlinksman.service.persistence.LinksUtil;
import com.vportal.portlet.vlinksman.util.ActionKeysExt;
import com.vportal.portlet.vlinksman.util.PortletKeysExt;

/**
 * The implementation of the link group remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vlinksman.service.LinkGroupService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vlinksman.service.LinkGroupServiceUtil} to access
 * the link group remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author hai
 * @see com.vportal.portlet.vlinksman.service.base.LinkGroupServiceBaseImpl
 * @see com.vportal.portlet.vlinksman.service.LinkGroupServiceUtil
 */
public class LinkGroupServiceImpl extends LinkGroupServiceBaseImpl {
	public LinkGroup addLinkGroup(long groupId, long companyId, long plid,
			String name, String description, long userId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException, RemoteException {

		// Check permissions
		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeysExt.VLINKSMAN, ActionKeysExt.ADD_LINK_GROUP);

		return addLinkGroup(groupId, companyId, plid, name, description,
				userId, null, null, communityPermissions, guestPermissions);
	}

	public LinkGroup addLinkGroup(long groupId, long companyId, long plid,
			String name, String description, long userId,
			Boolean addCommunityPermissions, Boolean addGuestPermissions,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException, RemoteException {

		long linkgroupId = CounterLocalServiceUtil.increment(LinkGroup.class
				.getName());

		LinkGroup linkGroup = LinkGroupUtil.create(linkgroupId);

		linkGroup.setCompanyId(companyId);
		linkGroup.setGroupId(groupId);

		linkGroup.setName(name);
		linkGroup.setDescription(description);
		linkGroup.setCreatedDate(new Date());

		LinkGroupUtil.update(linkGroup, false);

		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {
			addLinkGroupResources(linkGroup,
					addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());

		} else {

			addLinkGroupResources(linkGroup, communityPermissions,
					guestPermissions);
		}

		return linkGroup;
	}

	public LinkGroup updateLinkGroup(long linkgroupId, long groupId,
			long companyId, String name, String description)
			throws PortalException, SystemException, RemoteException {

		LinkGroupPermission.check(getPermissionChecker(), linkgroupId,
				ActionKeysExt.UPDATE);

		LinkGroup linkGroup = LinkGroupUtil.findByPrimaryKey(linkgroupId);

		linkGroup.setCompanyId(companyId);
		linkGroup.setGroupId(groupId);

		linkGroup.setName(name);
		linkGroup.setDescription(description);
		linkGroup.setModifiedDate(new Date());

		LinkGroupUtil.update(linkGroup, false);
		return linkGroup;
	}

	public void deleteLinkGroup(long linkgroupId) throws PortalException,
			SystemException, RemoteException {

		LinkGroupPermission.check(getPermissionChecker(), linkgroupId,
				ActionKeysExt.DELETE);
		LinkGroup linkGroup = LinkGroupUtil.findByPrimaryKey(linkgroupId);

		ResourceLocalServiceUtil.deleteResource(linkGroup.getCompanyId(),
				LinkGroup.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				linkGroup.getLinkgroupId());

		LinksUtil.removeBylinkgroupId(linkgroupId);

		LinkGroupUtil.remove(linkgroupId);//remove(linkGroup);
	}

	public List getAll() throws PortalException, SystemException,
			RemoteException {
		return LinkGroupUtil.findAll();
	}

	public List getByGroupId(long groupId) throws PortalException,
			SystemException, RemoteException {
		return LinkGroupUtil.findBygroupId(groupId);
	}

	public List getByGroupId(long groupId, int start, int end)
			throws PortalException, SystemException, RemoteException {
		return LinkGroupUtil.findBygroupId(groupId, start, end);
	}

	public LinkGroup getLinkGroup(long linkgroupId) throws PortalException,
			SystemException, RemoteException {
		return LinkGroupUtil.fetchByPrimaryKey(linkgroupId);
	}

	// add Resource
	public void addLinkGroupResources(long linkgroupId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		LinkGroup linkGroup = LinkGroupUtil.findByPrimaryKey(linkgroupId);
		addLinkGroupResources(linkGroup, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addLinkGroupResources(LinkGroup linkGroup,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(PortalUtil.getDefaultCompanyId(),
				0, getUserId(), LinkGroup.class.getName(),
				linkGroup.getPrimaryKey(), false, addCommunityPermissions,
				addGuestPermissions);

	}

	public void addLinkGroupResources(long linkgroupId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		LinkGroup linkGroup = LinkGroupUtil.findByPrimaryKey(linkgroupId);
		addLinkGroupResources(linkGroup, communityPermissions, guestPermissions);
	}

	public void addLinkGroupResources(LinkGroup linkGroup,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {
		
		System.out.println(PortalUtil.getDefaultCompanyId());
		ResourceLocalServiceUtil.addModelResources(
				PortalUtil.getDefaultCompanyId(), linkGroup.getGroupId(), getUserId(),
				LinkGroup.class.getName(), linkGroup.getPrimaryKey(),
				communityPermissions, guestPermissions);
	}
}