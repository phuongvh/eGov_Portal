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

package com.vportal.portlet.vimagegallery.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vimagegallery.service.TFCategoryServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vimagegallery.service.TFCategoryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vimagegallery.model.TFCategorySoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vimagegallery.model.TFCategory}, that is translated to a
 * {@link com.vportal.portlet.vimagegallery.model.TFCategorySoap}. Methods that SOAP cannot
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
 * @author    DucNN
 * @see       TFCategoryServiceHttp
 * @see       com.vportal.portlet.vimagegallery.model.TFCategorySoap
 * @see       com.vportal.portlet.vimagegallery.service.TFCategoryServiceUtil
 * @generated
 */
public class TFCategoryServiceSoap {
	public static com.vportal.portlet.vimagegallery.model.TFCategorySoap addCategory(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String image,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFCategory returnValue = TFCategoryServiceUtil.addCategory(groupId,
					companyId, plid, name, description, image,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vimagegallery.model.TFCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategorySoap addCategory(
		long groupId, long companyId, long plid, java.lang.String name,
		java.lang.String description, java.lang.String image,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFCategory returnValue = TFCategoryServiceUtil.addCategory(groupId,
					companyId, plid, name, description, image,
					addCommunityPermissions, addGuestPermissions,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vimagegallery.model.TFCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategorySoap addCategory(
		com.vportal.portlet.vimagegallery.model.TFCategory category)
		throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFCategory returnValue = TFCategoryServiceUtil.addCategory(category);

			return com.vportal.portlet.vimagegallery.model.TFCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategorySoap updateCategory(
		long groupId, long companyId, long id, java.lang.String name,
		java.lang.String description, java.lang.String image)
		throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFCategory returnValue = TFCategoryServiceUtil.updateCategory(groupId,
					companyId, id, name, description, image);

			return com.vportal.portlet.vimagegallery.model.TFCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategorySoap updateCategory(
		com.vportal.portlet.vimagegallery.model.TFCategory category)
		throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFCategory returnValue = TFCategoryServiceUtil.updateCategory(category);

			return com.vportal.portlet.vimagegallery.model.TFCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCategory(long id) throws RemoteException {
		try {
			TFCategoryServiceUtil.deleteCategory(id);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategorySoap getCategory(
		long id) throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFCategory returnValue = TFCategoryServiceUtil.getCategory(id);

			return com.vportal.portlet.vimagegallery.model.TFCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategory[] getByGroupId(
		long groupId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vimagegallery.model.TFCategory> returnValue =
				TFCategoryServiceUtil.getByGroupId(groupId);

			return returnValue.toArray(new com.vportal.portlet.vimagegallery.model.TFCategory[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByGroupId(long groupId) throws RemoteException {
		try {
			int returnValue = TFCategoryServiceUtil.countByGroupId(groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vimagegallery.model.TFCategorySoap findCategory(
		long id) throws RemoteException {
		try {
			com.vportal.portlet.vimagegallery.model.TFCategory returnValue = TFCategoryServiceUtil.findCategory(id);

			return com.vportal.portlet.vimagegallery.model.TFCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addTFCategoryResources(long id,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			TFCategoryServiceUtil.addTFCategoryResources(id,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addTFCategoryResources(
		com.vportal.portlet.vimagegallery.model.TFCategory tfCategory,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			TFCategoryServiceUtil.addTFCategoryResources(tfCategory,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addTFCategoryResources(long id,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			TFCategoryServiceUtil.addTFCategoryResources(id,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addTFCategoryResources(
		com.vportal.portlet.vimagegallery.model.TFCategory tfCategory,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			TFCategoryServiceUtil.addTFCategoryResources(tfCategory,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TFCategoryServiceSoap.class);
}