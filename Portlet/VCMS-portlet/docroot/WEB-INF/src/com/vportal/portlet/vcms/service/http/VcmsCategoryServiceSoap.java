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

package com.vportal.portlet.vcms.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcms.model.VcmsCategorySoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcms.model.VcmsCategory}, that is translated to a
 * {@link com.vportal.portlet.vcms.model.VcmsCategorySoap}. Methods that SOAP cannot
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
 * @author    hai
 * @see       VcmsCategoryServiceHttp
 * @see       com.vportal.portlet.vcms.model.VcmsCategorySoap
 * @see       com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil
 * @generated
 */
public class VcmsCategoryServiceSoap {
	public static com.vportal.portlet.vcms.model.VcmsCategorySoap addCategory(
		long groupId, long companyId, long plid, java.lang.String portionId,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean anchored, java.lang.String href,
		java.lang.String language, boolean hasImage, java.lang.String image,
		boolean rssable, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsCategory returnValue = VcmsCategoryServiceUtil.addCategory(groupId,
					companyId, plid, portionId, parentId, name, description,
					anchored, href, language, hasImage, image, rssable,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vcms.model.VcmsCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCategorySoap addCategory(
		long groupId, long companyId, long plid, java.lang.String portionId,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean anchored, java.lang.String href,
		java.lang.String language, boolean hasImage, java.lang.String image,
		boolean rssable, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsCategory returnValue = VcmsCategoryServiceUtil.addCategory(groupId,
					companyId, plid, portionId, parentId, name, description,
					anchored, href, language, hasImage, image, rssable,
					addCommunityPermissions, addGuestPermissions,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vcms.model.VcmsCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void changePortion(java.lang.String parentId, long groupId,
		java.lang.String portionId, java.lang.String language)
		throws RemoteException {
		try {
			VcmsCategoryServiceUtil.changePortion(parentId, groupId, portionId,
				language);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addCategoryResources(java.lang.String categoryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			VcmsCategoryServiceUtil.addCategoryResources(categoryId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addCategoryResources(
		com.vportal.portlet.vcms.model.VcmsCategory category,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			VcmsCategoryServiceUtil.addCategoryResources(category,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addCategoryResources(java.lang.String categoryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			VcmsCategoryServiceUtil.addCategoryResources(categoryId,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addCategoryResources(
		com.vportal.portlet.vcms.model.VcmsCategory category,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			VcmsCategoryServiceUtil.addCategoryResources(category,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCategorySoap updateCategory(
		long groupId, long companyId, java.lang.String categoryId,
		java.lang.String portionId, java.lang.String parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasImage,
		java.lang.String image, long position, long userHit, boolean rssable)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsCategory returnValue = VcmsCategoryServiceUtil.updateCategory(groupId,
					companyId, categoryId, portionId, parentId, name,
					description, anchored, href, language, hasImage, image,
					position, userHit, rssable);

			return com.vportal.portlet.vcms.model.VcmsCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCategorySoap updateCategory(
		com.vportal.portlet.vcms.model.VcmsCategory category)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsCategory returnValue = VcmsCategoryServiceUtil.updateCategory(category);

			return com.vportal.portlet.vcms.model.VcmsCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCategory(java.lang.String categoryId)
		throws RemoteException {
		try {
			VcmsCategoryServiceUtil.deleteCategory(categoryId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCategorySoap getCategory(
		java.lang.String categoryId) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsCategory returnValue = VcmsCategoryServiceUtil.getCategory(categoryId);

			return com.vportal.portlet.vcms.model.VcmsCategorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCategory[] getCategoriesByPortion(
		long groupId, java.lang.String portionId, java.lang.String language)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> returnValue =
				VcmsCategoryServiceUtil.getCategoriesByPortion(groupId,
					portionId, language);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsCategory[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCategory[] getCategoriesByParent(
		long groupId, java.lang.String parentId, java.lang.String language)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> returnValue =
				VcmsCategoryServiceUtil.getCategoriesByParent(groupId,
					parentId, language);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsCategory[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCategory[] getCategoriesByParent(
		long groupId, java.lang.String parentId, java.lang.String language,
		int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> returnValue =
				VcmsCategoryServiceUtil.getCategoriesByParent(groupId,
					parentId, language, start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsCategory[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countCategoriesByParent(long groupId,
		java.lang.String parentId, java.lang.String language)
		throws RemoteException {
		try {
			int returnValue = VcmsCategoryServiceUtil.countCategoriesByParent(groupId,
					parentId, language);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCategory[] getCategoriesByP_P(
		long groupId, java.lang.String portionId, java.lang.String parentId,
		java.lang.String language) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> returnValue =
				VcmsCategoryServiceUtil.getCategoriesByP_P(groupId, portionId,
					parentId, language);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsCategory[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCategory[] getCategoriesByP_P(
		long groupId, java.lang.String portionId, java.lang.String parentId,
		java.lang.String language, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> returnValue =
				VcmsCategoryServiceUtil.getCategoriesByP_P(groupId, portionId,
					parentId, language, start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsCategory[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countCategoriesByP_P(long groupId,
		java.lang.String portionId, java.lang.String parentId,
		java.lang.String language) throws RemoteException {
		try {
			int returnValue = VcmsCategoryServiceUtil.countCategoriesByP_P(groupId,
					portionId, parentId, language);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByP_L(long groupId, java.lang.String language)
		throws RemoteException {
		try {
			int returnValue = VcmsCategoryServiceUtil.countByP_L(groupId,
					language);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VcmsCategoryServiceSoap.class);
}