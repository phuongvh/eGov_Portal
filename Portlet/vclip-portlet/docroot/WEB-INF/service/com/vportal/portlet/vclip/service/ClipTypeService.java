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

package com.vportal.portlet.vclip.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the clip type remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author HOAN
 * @see ClipTypeServiceUtil
 * @see com.vportal.portlet.vclip.service.base.ClipTypeServiceBaseImpl
 * @see com.vportal.portlet.vclip.service.impl.ClipTypeServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ClipTypeService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClipTypeServiceUtil} to access the clip type remote service. Add custom service methods to {@link com.vportal.portlet.vclip.service.impl.ClipTypeServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.vportal.portlet.vclip.model.ClipType addClipType(long groupId,
		long companyId, long plid,
		com.vportal.portlet.vclip.model.ClipType clipType,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception;

	public com.vportal.portlet.vclip.model.ClipType updateClipType(
		long groupId, long companyId, java.lang.String clipTypeId,
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception;

	public void deleteClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception;

	public void deleteClipType(java.lang.String clipTypeId)
		throws java.lang.Exception;

	public com.vportal.portlet.vclip.model.ClipType findById(
		java.lang.String clipTypeId) throws java.lang.Exception;

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll()
		throws java.lang.Exception;

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll(
		int begin, int end) throws java.lang.Exception;

	public int countAll() throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vclip.model.ClipType> getLanguage(
		java.lang.String language, boolean active) throws java.lang.Exception;

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception;

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType, int start, int end)
		throws java.lang.Exception;

	public int countClipType(com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.vclip.model.ClipType getFirst()
		throws java.lang.Exception;

	public void addClipTypeResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addClipTypeResources(
		com.vportal.portlet.vclip.model.ClipType article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addClipTypeResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addClipTypeResources(
		com.vportal.portlet.vclip.model.ClipType article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}