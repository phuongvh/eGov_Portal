/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.vportal.portlet.vcms.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author hai
 */
public class VcmsCategoryServiceClp implements VcmsCategoryService {
	public VcmsCategoryServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addCategoryMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addCategory", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				java.lang.String.class, boolean.class,
				java.lang.String[].class, java.lang.String[].class);

		_addCategoryMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"addCategory", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				java.lang.String.class, boolean.class, java.lang.Boolean.class,
				java.lang.Boolean.class, java.lang.String[].class,
				java.lang.String[].class);

		_changePortionMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"changePortion", java.lang.String.class, long.class,
				java.lang.String.class, java.lang.String.class);

		_addCategoryResourcesMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"addCategoryResources", java.lang.String.class, boolean.class,
				boolean.class);

		_addCategoryResourcesMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"addCategoryResources",
				com.vportal.portlet.vcms.model.VcmsCategory.class,
				boolean.class, boolean.class);

		_addCategoryResourcesMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"addCategoryResources", java.lang.String.class,
				java.lang.String[].class, java.lang.String[].class);

		_addCategoryResourcesMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"addCategoryResources",
				com.vportal.portlet.vcms.model.VcmsCategory.class,
				java.lang.String[].class, java.lang.String[].class);

		_updateCategoryMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateCategory", long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, java.lang.String.class,
				java.lang.String.class, boolean.class, java.lang.String.class,
				long.class, long.class, boolean.class);

		_updateCategoryMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateCategory",
				com.vportal.portlet.vcms.model.VcmsCategory.class);

		_deleteCategoryMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteCategory", java.lang.String.class);

		_getCategoryMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategory", java.lang.String.class);

		_getCategoriesByRSSMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoriesByRSS", java.lang.String.class, int.class,
				java.lang.String.class, double.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, int.class,
				com.liferay.portal.theme.ThemeDisplay.class);

		_getCategoriesByPortionMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoriesByPortion", long.class, java.lang.String.class,
				java.lang.String.class);

		_getCategoriesByParentMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoriesByParent", long.class, java.lang.String.class,
				java.lang.String.class);

		_getCategoriesByParentMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoriesByParent", long.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_countCategoriesByParentMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"countCategoriesByParent", long.class, java.lang.String.class,
				java.lang.String.class);

		_getCategoriesByP_PMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoriesByP_P", long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class);

		_getCategoriesByP_PMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoriesByP_P", long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, int.class,
				int.class);

		_countCategoriesByP_PMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"countCategoriesByP_P", long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class);

		_countByP_LMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByP_L", long.class, java.lang.String.class);
	}

	public com.vportal.portlet.vcms.model.VcmsCategory addCategory(
		long groupId, long companyId, long plid, java.lang.String portionId,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean anchored, java.lang.String href,
		java.lang.String language, boolean hasImage, java.lang.String image,
		boolean rssable, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addCategoryMethodKey0,
				groupId, companyId, plid,
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description), anchored,
				ClpSerializer.translateInput(href),
				ClpSerializer.translateInput(language), hasImage,
				ClpSerializer.translateInput(image), rssable,
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vcms.model.VcmsCategory)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vcms.model.VcmsCategory addCategory(
		long groupId, long companyId, long plid, java.lang.String portionId,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, boolean anchored, java.lang.String href,
		java.lang.String language, boolean hasImage, java.lang.String image,
		boolean rssable, java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addCategoryMethodKey1,
				groupId, companyId, plid,
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description), anchored,
				ClpSerializer.translateInput(href),
				ClpSerializer.translateInput(language), hasImage,
				ClpSerializer.translateInput(image), rssable,
				ClpSerializer.translateInput(addCommunityPermissions),
				ClpSerializer.translateInput(addGuestPermissions),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vcms.model.VcmsCategory)ClpSerializer.translateOutput(returnObj);
	}

	public void changePortion(java.lang.String parentId, long groupId,
		java.lang.String portionId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_changePortionMethodKey2,
				ClpSerializer.translateInput(parentId), groupId,
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(language));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addCategoryResources(java.lang.String categoryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addCategoryResourcesMethodKey3,
				ClpSerializer.translateInput(categoryId),
				addCommunityPermissions, addGuestPermissions);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addCategoryResources(
		com.vportal.portlet.vcms.model.VcmsCategory category,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addCategoryResourcesMethodKey4,
				ClpSerializer.translateInput(category),
				addCommunityPermissions, addGuestPermissions);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addCategoryResources(java.lang.String categoryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addCategoryResourcesMethodKey5,
				ClpSerializer.translateInput(categoryId),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addCategoryResources(
		com.vportal.portlet.vcms.model.VcmsCategory category,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addCategoryResourcesMethodKey6,
				ClpSerializer.translateInput(category),
				ClpSerializer.translateInput(communityPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.vportal.portlet.vcms.model.VcmsCategory updateCategory(
		long groupId, long companyId, java.lang.String categoryId,
		java.lang.String portionId, java.lang.String parentId,
		java.lang.String name, java.lang.String description, boolean anchored,
		java.lang.String href, java.lang.String language, boolean hasImage,
		java.lang.String image, long position, long userHit, boolean rssable)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateCategoryMethodKey7,
				groupId, companyId, ClpSerializer.translateInput(categoryId),
				ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description), anchored,
				ClpSerializer.translateInput(href),
				ClpSerializer.translateInput(language), hasImage,
				ClpSerializer.translateInput(image), position, userHit, rssable);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vcms.model.VcmsCategory)ClpSerializer.translateOutput(returnObj);
	}

	public com.vportal.portlet.vcms.model.VcmsCategory updateCategory(
		com.vportal.portlet.vcms.model.VcmsCategory category)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateCategoryMethodKey8,
				ClpSerializer.translateInput(category));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vcms.model.VcmsCategory)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteCategory(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		MethodHandler methodHandler = new MethodHandler(_deleteCategoryMethodKey9,
				ClpSerializer.translateInput(categoryId));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.vportal.portlet.vcms.model.VcmsCategory getCategory(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoryMethodKey10,
				ClpSerializer.translateInput(categoryId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.vportal.portlet.vcms.model.VcmsCategory)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getCategoriesByRSS(java.lang.String categoryId,
		int max, java.lang.String type, double version,
		java.lang.String displayStyle, java.lang.String feedURL,
		java.lang.String entryURL, int quantity,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoriesByRSSMethodKey11,
				ClpSerializer.translateInput(categoryId), max,
				ClpSerializer.translateInput(type), version,
				ClpSerializer.translateInput(displayStyle),
				ClpSerializer.translateInput(feedURL),
				ClpSerializer.translateInput(entryURL), quantity,
				ClpSerializer.translateInput(themeDisplay));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getCategoriesByPortion(
		long groupId, java.lang.String portionId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoriesByPortionMethodKey12,
				groupId, ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(language));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsCategory>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getCategoriesByParent(
		long groupId, java.lang.String parentId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoriesByParentMethodKey13,
				groupId, ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(language));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsCategory>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getCategoriesByParent(
		long groupId, java.lang.String parentId, java.lang.String language,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoriesByParentMethodKey14,
				groupId, ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(language), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsCategory>)ClpSerializer.translateOutput(returnObj);
	}

	public int countCategoriesByParent(long groupId, java.lang.String parentId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countCategoriesByParentMethodKey15,
				groupId, ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(language));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getCategoriesByP_P(
		long groupId, java.lang.String portionId, java.lang.String parentId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoriesByP_PMethodKey16,
				groupId, ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(language));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsCategory>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsCategory> getCategoriesByP_P(
		long groupId, java.lang.String portionId, java.lang.String parentId,
		java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoriesByP_PMethodKey17,
				groupId, ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(language), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.vportal.portlet.vcms.model.VcmsCategory>)ClpSerializer.translateOutput(returnObj);
	}

	public int countCategoriesByP_P(long groupId, java.lang.String portionId,
		java.lang.String parentId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countCategoriesByP_PMethodKey18,
				groupId, ClpSerializer.translateInput(portionId),
				ClpSerializer.translateInput(parentId),
				ClpSerializer.translateInput(language));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public int countByP_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByP_LMethodKey19,
				groupId, ClpSerializer.translateInput(language));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addCategoryMethodKey0;
	private MethodKey _addCategoryMethodKey1;
	private MethodKey _changePortionMethodKey2;
	private MethodKey _addCategoryResourcesMethodKey3;
	private MethodKey _addCategoryResourcesMethodKey4;
	private MethodKey _addCategoryResourcesMethodKey5;
	private MethodKey _addCategoryResourcesMethodKey6;
	private MethodKey _updateCategoryMethodKey7;
	private MethodKey _updateCategoryMethodKey8;
	private MethodKey _deleteCategoryMethodKey9;
	private MethodKey _getCategoryMethodKey10;
	private MethodKey _getCategoriesByRSSMethodKey11;
	private MethodKey _getCategoriesByPortionMethodKey12;
	private MethodKey _getCategoriesByParentMethodKey13;
	private MethodKey _getCategoriesByParentMethodKey14;
	private MethodKey _countCategoriesByParentMethodKey15;
	private MethodKey _getCategoriesByP_PMethodKey16;
	private MethodKey _getCategoriesByP_PMethodKey17;
	private MethodKey _countCategoriesByP_PMethodKey18;
	private MethodKey _countByP_LMethodKey19;
}