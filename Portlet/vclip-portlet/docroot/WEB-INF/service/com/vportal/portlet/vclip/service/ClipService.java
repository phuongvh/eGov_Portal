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
 * The interface for the clip remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author HOAN
 * @see ClipServiceUtil
 * @see com.vportal.portlet.vclip.service.base.ClipServiceBaseImpl
 * @see com.vportal.portlet.vclip.service.impl.ClipServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ClipService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClipServiceUtil} to access the clip remote service. Add custom service methods to {@link com.vportal.portlet.vclip.service.impl.ClipServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.vportal.portlet.vclip.model.Clip addClip(long groupId,
		long companyId, long plid, com.vportal.portlet.vclip.model.Clip clip,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception;

	public com.vportal.portlet.vclip.model.Clip updateClip(long groupId,
		long companyId, java.lang.String clipId,
		com.vportal.portlet.vclip.model.Clip clip) throws java.lang.Exception;

	public void deleteClip(com.vportal.portlet.vclip.model.Clip clip)
		throws java.lang.Exception;

	public void deleteClip(java.lang.String clipId) throws java.lang.Exception;

	public com.vportal.portlet.vclip.model.Clip increaseHitCount(
		java.lang.String clipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.vportal.portlet.vclip.model.Clip increaseHitCountView(
		java.lang.String clipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.vportal.portlet.vclip.model.Clip findById(
		java.lang.String clipId) throws java.lang.Exception;

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId) throws java.lang.Exception;

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId, int start, int end)
		throws java.lang.Exception;

	public int countByClipTypeId(java.lang.String clipTypeId)
		throws java.lang.Exception;

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findClip(
		com.vportal.portlet.vclip.model.Clip clip) throws java.lang.Exception;

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findClip(
		com.vportal.portlet.vclip.model.Clip clip, int start, int end)
		throws java.lang.Exception;

	public int countClip(com.vportal.portlet.vclip.model.Clip clip)
		throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vclip.model.Clip> searchClip(
		java.lang.String textSearch, java.lang.String clipTypeId)
		throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vclip.model.Clip> getAll()
		throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.vportal.portlet.vclip.model.Clip> getAll(
		int begin, int end) throws java.lang.Exception;

	public int countAll() throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasParent(java.lang.String clipTypeId)
		throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.vclip.model.Clip getFirst()
		throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.vportal.portlet.vclip.model.Clip getByClipTypeId(
		java.lang.String clipTypeId) throws java.lang.Exception;

	public void addClipResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addClipResources(com.vportal.portlet.vclip.model.Clip article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addClipResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addClipResources(com.vportal.portlet.vclip.model.Clip article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}