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

package com.vportal.portlet.vdoc.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the vdoc org remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author MrEn
 * @see vdocOrgServiceUtil
 * @see com.vportal.portlet.vdoc.service.base.vdocOrgServiceBaseImpl
 * @see com.vportal.portlet.vdoc.service.impl.vdocOrgServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface vdocOrgService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link vdocOrgServiceUtil} to access the vdoc org remote service. Add custom service methods to {@link com.vportal.portlet.vdoc.service.impl.vdocOrgServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.vportal.portlet.vdoc.model.vdocOrg addOrg(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		java.lang.String address, java.lang.String phone, boolean statusOrg,
		int position, java.lang.String fax, java.lang.String listparent,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	public com.vportal.portlet.vdoc.model.vdocOrg addOrg(long groupId,
		long userId, java.lang.String language, java.lang.String parentId,
		java.lang.String name, java.lang.String description,
		java.lang.String address, java.lang.String phone, boolean statusOrg,
		int position, java.lang.String fax, java.lang.String listparent,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException;

	public com.vportal.portlet.vdoc.model.vdocOrg updateOrg(
		com.vportal.portlet.vdoc.model.vdocOrg org, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	public com.vportal.portlet.vdoc.model.vdocOrg updateOrg(
		java.lang.String orgId, long groupId, java.lang.String language,
		java.lang.String parentId, java.lang.String name,
		java.lang.String description, java.lang.String address,
		java.lang.String phone, boolean statusOrg, int position,
		java.lang.String fax, java.lang.String listparent, long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	public void deleteOrg(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.DeleteOrgException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.vdoc.model.vdocOrg getOrg(java.lang.String orgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocOrgException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByParentId(
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L(
		long groupId, java.lang.String language, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vdoc.model.vdocOrg> getOrgByG_L_P(
		long groupId, java.lang.String language, java.lang.String parentId,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countOrgByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countOrgByG_L_P(long groupId, java.lang.String language,
		java.lang.String parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(long entryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocOrg entry,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(long entryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(
		com.vportal.portlet.vdoc.model.vdocOrg entry,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}