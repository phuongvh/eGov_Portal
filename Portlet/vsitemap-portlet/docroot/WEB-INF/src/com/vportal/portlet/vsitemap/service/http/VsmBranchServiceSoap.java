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

package com.vportal.portlet.vsitemap.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vsitemap.service.VsmBranchServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vsitemap.service.VsmBranchServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vsitemap.model.VsmBranchSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vsitemap.model.VsmBranch}, that is translated to a
 * {@link com.vportal.portlet.vsitemap.model.VsmBranchSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    LongLH
 * @see       VsmBranchServiceHttp
 * @see       com.vportal.portlet.vsitemap.model.VsmBranchSoap
 * @see       com.vportal.portlet.vsitemap.service.VsmBranchServiceUtil
 * @generated
 */
public class VsmBranchServiceSoap {
	public static com.vportal.portlet.vsitemap.model.VsmBranchSoap addBranch(
		long groupId, long companyId, long plid, long parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasIcon,
		java.lang.String icon, long userId) throws RemoteException {
		try {
			com.vportal.portlet.vsitemap.model.VsmBranch returnValue = VsmBranchServiceUtil.addBranch(groupId,
					companyId, plid, parentId, name, description, anchored,
					href, language, hasIcon, icon, userId);

			return com.vportal.portlet.vsitemap.model.VsmBranchSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vsitemap.model.VsmBranchSoap addBranch(
		long groupId, long companyId, long plid, long parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasIcon,
		java.lang.String icon, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vsitemap.model.VsmBranch returnValue = VsmBranchServiceUtil.addBranch(groupId,
					companyId, plid, parentId, name, description, anchored,
					href, language, hasIcon, icon, userId,
					addCommunityPermissions, addGuestPermissions);

			return com.vportal.portlet.vsitemap.model.VsmBranchSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vsitemap.model.VsmBranchSoap updateBranch(
		long groupId, long companyId, long branchId, long parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasIcon,
		java.lang.String icon, long position, long userId)
		throws RemoteException {
		try {
			com.vportal.portlet.vsitemap.model.VsmBranch returnValue = VsmBranchServiceUtil.updateBranch(groupId,
					companyId, branchId, parentId, name, description, anchored,
					href, language, hasIcon, icon, position, userId);

			return com.vportal.portlet.vsitemap.model.VsmBranchSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vsitemap.model.VsmBranchSoap updateBranch(
		com.vportal.portlet.vsitemap.model.VsmBranch branch)
		throws RemoteException {
		try {
			com.vportal.portlet.vsitemap.model.VsmBranch returnValue = VsmBranchServiceUtil.updateBranch(branch);

			return com.vportal.portlet.vsitemap.model.VsmBranchSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteBranch(long branchId) throws RemoteException {
		try {
			VsmBranchServiceUtil.deleteBranch(branchId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getAll() throws RemoteException {
		try {
			java.util.List returnValue = VsmBranchServiceUtil.getAll();

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getByG_L(long groupId,
		java.lang.String language) throws RemoteException {
		try {
			java.util.List returnValue = VsmBranchServiceUtil.getByG_L(groupId,
					language);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getByG_L(long groupId,
		java.lang.String language, int start, int end)
		throws RemoteException {
		try {
			java.util.List returnValue = VsmBranchServiceUtil.getByG_L(groupId,
					language, start, end);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByG_L(long groupId, java.lang.String language)
		throws RemoteException {
		try {
			int returnValue = VsmBranchServiceUtil.countByG_L(groupId, language);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getByG_L_P(long groupId,
		java.lang.String language, long parentId) throws RemoteException {
		try {
			java.util.List returnValue = VsmBranchServiceUtil.getByG_L_P(groupId,
					language, parentId);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getByG_L_P(long groupId,
		java.lang.String language, long parentId, int start, int end)
		throws RemoteException {
		try {
			java.util.List returnValue = VsmBranchServiceUtil.getByG_L_P(groupId,
					language, parentId, start, end);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByG_L_P(long groupId, java.lang.String language,
		long parentId) throws RemoteException {
		try {
			int returnValue = VsmBranchServiceUtil.countByG_L_P(groupId,
					language, parentId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vsitemap.model.VsmBranchSoap getBranch(
		long branchId) throws RemoteException {
		try {
			com.vportal.portlet.vsitemap.model.VsmBranch returnValue = VsmBranchServiceUtil.getBranch(branchId);

			return com.vportal.portlet.vsitemap.model.VsmBranchSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getAllByLanguage(java.lang.String language)
		throws RemoteException {
		try {
			java.util.List returnValue = VsmBranchServiceUtil.getAllByLanguage(language);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getAllByHasicon(boolean hasIcon)
		throws RemoteException {
		try {
			java.util.List returnValue = VsmBranchServiceUtil.getAllByHasicon(hasIcon);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static Object[] getAllByParent(long parentId)
		throws RemoteException {
		try {
			java.util.List returnValue = VsmBranchServiceUtil.getAllByParent(parentId);

			return returnValue.toArray(new java.util.List[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addVsmBranchResources(long branchId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			VsmBranchServiceUtil.addVsmBranchResources(branchId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addVsmBranchResources(
		com.vportal.portlet.vsitemap.model.VsmBranch branch,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			VsmBranchServiceUtil.addVsmBranchResources(branch,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addVsmBranchResources(long branchId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			VsmBranchServiceUtil.addVsmBranchResources(branchId,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addVsmBranchResources(
		com.vportal.portlet.vsitemap.model.VsmBranch branch,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			VsmBranchServiceUtil.addVsmBranchResources(branch,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VsmBranchServiceSoap.class);
}