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

package com.vportal.portlet.vsitemap.service.impl;

import com.vportal.portlet.vsitemap.service.base.VsmBranchServiceBaseImpl;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vsitemap.DeleteBranchException;
import com.vportal.portlet.vsitemap.model.VsmBranch;
import com.vportal.portlet.vsitemap.service.base.VsmBranchServiceBaseImpl;
import com.vportal.portlet.vsitemap.service.permission.VsmBranchPermission;
import com.vportal.portlet.vsitemap.service.persistence.VsmBranchUtil;
import com.vportal.portlet.vsitemap.util.ActionKeysExt;
/**
 * The implementation of the vsm branch remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vsitemap.service.VsmBranchService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LongLH
 * @see com.vportal.portlet.vsitemap.service.base.VsmBranchServiceBaseImpl
 * @see com.vportal.portlet.vsitemap.service.VsmBranchServiceUtil
 */
public class VsmBranchServiceImpl extends VsmBranchServiceBaseImpl {
	public VsmBranch addBranch(long groupId, long companyId, long plid,
			long parentId, String name, String description, boolean anchored,
			String href, String language, boolean hasIcon, String icon,
			long userId) throws PortalException, SystemException,
			RemoteException {

		return addBranch(groupId, companyId, plid, parentId, name, description,
				anchored, href, language, hasIcon, icon, userId,null,null);
	}

	public VsmBranch addBranch(long groupId, long companyId, long plid,
			long parentId, String name, String description, boolean anchored,
			String href, String language, boolean hasIcon, String icon,
			long userId, Boolean addCommunityPermissions,
			Boolean addGuestPermissions) throws PortalException, SystemException,
			RemoteException {

		// Check permissions
//		PortletPermissionUtil.check(getPermissionChecker(), plid,
//				PortletKeysExt.VSITEMAP, ActionKeysExt.ADD_BRANCH);

		long id = CounterLocalServiceUtil.increment(VsmBranch.class.getName());
		VsmBranch branch = VsmBranchUtil.create(id);

		branch.setGroupId(groupId);
		branch.setCompanyId(companyId);

		branch.setBranchId(id);
		branch.setCreatedByUser(userId);
		branch.setCreatedDate(new Date());
		branch.setModifiedByUser(userId);
		branch.setModifiedDate(new Date());

		branch.setParentId(parentId);
		branch.setName(name);
		branch.setDescription(description);
		branch.setAnchored(anchored);
		branch.setHref(href);
		branch.setLanguage(language);
		branch.setHasIcon(hasIcon);
		branch.setIcon(icon);
		branch.setPosition(1);

		vsmBranchPersistence.update(branch, false);

		// // Add to common resources
		try {
			if ((addCommunityPermissions != null)
					&& (addGuestPermissions != null)) {
				addVsmBranchResources(branch, addCommunityPermissions
						.booleanValue(), addGuestPermissions.booleanValue());
			} else {
				addVsmBranchResources(branch,true,true);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return branch;
	}

	public VsmBranch updateBranch(long groupId, long companyId, long branchId,
			long parentId, String name, String description, boolean anchored,
			String href, String language, boolean hasIcon, String icon,
			long position, long userId) throws PortalException, SystemException,
			RemoteException {

//		VsmBranchPermission.check(getPermissionChecker(), branchId,
//				ActionKeysExt.UPDATE);

		VsmBranch branch = VsmBranchUtil.findByPrimaryKey(branchId);

		branch.setGroupId(groupId);
		branch.setCompanyId(companyId);
		branch.setParentId(parentId);
		branch.setName(name);
		branch.setDescription(description);
		branch.setAnchored(anchored);
		branch.setHref(href);
		branch.setLanguage(language);
		branch.setHasIcon(hasIcon);
		branch.setIcon(icon);
		branch.setPosition(position);
		branch.setModifiedByUser(userId);
		branch.setModifiedDate(new Date());

		return vsmBranchPersistence.update(branch,false);
	}

	public VsmBranch updateBranch(VsmBranch branch) throws PortalException,
			SystemException, RemoteException {

		VsmBranch vsmBranch = vsmBranchPersistence.findByPrimaryKey(branch
				.getBranchId());

		Date now = new Date();

		vsmBranch.setName(branch.getName());
		vsmBranch.setDescription(branch.getDescription());
		vsmBranch.setAnchored(branch.getAnchored());
		vsmBranch.setHref(branch.getHref());
		vsmBranch.setLanguage(branch.getLanguage());
		vsmBranch.setHasIcon(branch.getHasIcon());
		vsmBranch.setIcon(branch.getIcon());
		vsmBranch.setPosition(branch.getPosition());
		vsmBranch.setParentId(branch.getParentId());
		vsmBranch.setModifiedByUser(branch.getCreatedByUser());
		vsmBranch.setModifiedDate(now);

		vsmBranchPersistence.update(vsmBranch,false);

		return vsmBranch;
	}

	public void deleteBranch(long branchId) throws PortalException,
			SystemException, RemoteException {

//		VsmBranchPermission.check(getPermissionChecker(), branchId,
//				ActionKeysExt.DELETE);

		List children = vsmBranchPersistence.findByParent(branchId);
		if ((children == null) || children.isEmpty()) {
			vsmBranchPersistence.remove(branchId);
		} else {
			throw new DeleteBranchException();
		}
	}

	public List getAll() throws PortalException, SystemException,
			RemoteException {
		return vsmBranchPersistence.findAll();
	}

	public List getByG_L(long groupId, String language) throws PortalException,
			SystemException, RemoteException {
		return vsmBranchPersistence.findByG_L(groupId, language);
	}

	public List getByG_L(long groupId, String language, int start, int end)
			throws PortalException, SystemException, RemoteException {
		return vsmBranchPersistence.findByG_L(groupId, language, start, end);
	}

	public int countByG_L(long groupId, String language)
			throws PortalException, SystemException, RemoteException {
		return vsmBranchPersistence.countByG_L(groupId, language);
	}

	public List getByG_L_P(long groupId, String language, long parentId)
			throws PortalException, SystemException, RemoteException {
		return vsmBranchPersistence.findByG_L_P(groupId, language, parentId);
	}

	public List getByG_L_P(long groupId, String language, long parentId,
			int start, int end) throws PortalException, SystemException,
			RemoteException {
		return vsmBranchPersistence.findByG_L_P(groupId, language, parentId,
				start, end);
	}

	public int countByG_L_P(long groupId, String language, long parentId)
			throws PortalException, SystemException, RemoteException {
		return vsmBranchPersistence.countByG_L_P(groupId, language, parentId);
	}

	public VsmBranch getBranch(long branchId) throws PortalException,
			SystemException, RemoteException {
		return vsmBranchPersistence.findByPrimaryKey(branchId);
	}

	public List getAllByLanguage(String language) throws PortalException,
			SystemException, RemoteException {
		return vsmBranchPersistence.findByLanguage(language);
	}

	public List getAllByHasicon(boolean hasIcon) throws PortalException,
			SystemException, RemoteException {
		return vsmBranchPersistence.findByIcon(hasIcon);
	}

	public List getAllByParent(long parentId) throws PortalException,
			SystemException, RemoteException {
		return vsmBranchPersistence.findByParent(parentId);
	}

	// add Resource
	public void addVsmBranchResources(long branchId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		VsmBranch branch = vsmBranchPersistence.findByPrimaryKey(branchId);
		addVsmBranchResources(branch, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addVsmBranchResources(VsmBranch branch,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(10132,
				0, getUserId(), VsmBranch.class.getName(), branch
						.getPrimaryKey(), false, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addVsmBranchResources(long branchId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		VsmBranch branch = vsmBranchPersistence.findByPrimaryKey(branchId);
		addVsmBranchResources(branch, communityPermissions, guestPermissions);
	}

	public void addVsmBranchResources(VsmBranch branch,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(
				10132, 0, getUserId(), VsmBranch.class
						.getName(), branch.getPrimaryKey(),
				communityPermissions, guestPermissions);
	}
}