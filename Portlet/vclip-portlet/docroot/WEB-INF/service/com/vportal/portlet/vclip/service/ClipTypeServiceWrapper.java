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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ClipTypeService}.
 * </p>
 *
 * @author    HOAN
 * @see       ClipTypeService
 * @generated
 */
public class ClipTypeServiceWrapper implements ClipTypeService,
	ServiceWrapper<ClipTypeService> {
	public ClipTypeServiceWrapper(ClipTypeService clipTypeService) {
		_clipTypeService = clipTypeService;
	}

	public com.vportal.portlet.vclip.model.ClipType addClipType(long groupId,
		long companyId, long plid,
		com.vportal.portlet.vclip.model.ClipType clipType,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return _clipTypeService.addClipType(groupId, companyId, plid, clipType,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public com.vportal.portlet.vclip.model.ClipType updateClipType(
		long groupId, long companyId, java.lang.String clipTypeId,
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		return _clipTypeService.updateClipType(groupId, companyId, clipTypeId,
			clipType);
	}

	public void deleteClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		_clipTypeService.deleteClipType(clipType);
	}

	public void deleteClipType(java.lang.String clipTypeId)
		throws java.lang.Exception {
		_clipTypeService.deleteClipType(clipTypeId);
	}

	public com.vportal.portlet.vclip.model.ClipType findById(
		java.lang.String clipTypeId) throws java.lang.Exception {
		return _clipTypeService.findById(clipTypeId);
	}

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll()
		throws java.lang.Exception {
		return _clipTypeService.findAll();
	}

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll(
		int begin, int end) throws java.lang.Exception {
		return _clipTypeService.findAll(begin, end);
	}

	public int countAll() throws java.lang.Exception {
		return _clipTypeService.countAll();
	}

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> getLanguage(
		java.lang.String language, boolean active) throws java.lang.Exception {
		return _clipTypeService.getLanguage(language, active);
	}

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		return _clipTypeService.findClipType(clipType);
	}

	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType, int start, int end)
		throws java.lang.Exception {
		return _clipTypeService.findClipType(clipType, start, end);
	}

	public int countClipType(com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception {
		return _clipTypeService.countClipType(clipType);
	}

	public com.vportal.portlet.vclip.model.ClipType getFirst()
		throws java.lang.Exception {
		return _clipTypeService.getFirst();
	}

	public void addClipTypeResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_clipTypeService.addClipTypeResources(articleId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addClipTypeResources(
		com.vportal.portlet.vclip.model.ClipType article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_clipTypeService.addClipTypeResources(article, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addClipTypeResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_clipTypeService.addClipTypeResources(articleId, communityPermissions,
			guestPermissions);
	}

	public void addClipTypeResources(
		com.vportal.portlet.vclip.model.ClipType article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_clipTypeService.addClipTypeResources(article, communityPermissions,
			guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ClipTypeService getWrappedClipTypeService() {
		return _clipTypeService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedClipTypeService(ClipTypeService clipTypeService) {
		_clipTypeService = clipTypeService;
	}

	public ClipTypeService getWrappedService() {
		return _clipTypeService;
	}

	public void setWrappedService(ClipTypeService clipTypeService) {
		_clipTypeService = clipTypeService;
	}

	private ClipTypeService _clipTypeService;
}