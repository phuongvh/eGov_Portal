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
 * This class is a wrapper for {@link ClipService}.
 * </p>
 *
 * @author    HOAN
 * @see       ClipService
 * @generated
 */
public class ClipServiceWrapper implements ClipService,
	ServiceWrapper<ClipService> {
	public ClipServiceWrapper(ClipService clipService) {
		_clipService = clipService;
	}

	public com.vportal.portlet.vclip.model.Clip addClip(long groupId,
		long companyId, long plid, com.vportal.portlet.vclip.model.Clip clip,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return _clipService.addClip(groupId, companyId, plid, clip,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public com.vportal.portlet.vclip.model.Clip updateClip(long groupId,
		long companyId, java.lang.String clipId,
		com.vportal.portlet.vclip.model.Clip clip) throws java.lang.Exception {
		return _clipService.updateClip(groupId, companyId, clipId, clip);
	}

	public void deleteClip(com.vportal.portlet.vclip.model.Clip clip)
		throws java.lang.Exception {
		_clipService.deleteClip(clip);
	}

	public void deleteClip(java.lang.String clipId) throws java.lang.Exception {
		_clipService.deleteClip(clipId);
	}

	public com.vportal.portlet.vclip.model.Clip increaseHitCount(
		java.lang.String clipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _clipService.increaseHitCount(clipId);
	}

	public com.vportal.portlet.vclip.model.Clip increaseHitCountView(
		java.lang.String clipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _clipService.increaseHitCountView(clipId);
	}

	public com.vportal.portlet.vclip.model.Clip findById(
		java.lang.String clipId) throws java.lang.Exception {
		return _clipService.findById(clipId);
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId) throws java.lang.Exception {
		return _clipService.findByClipTypeId(clipTypeId);
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId, int start, int end)
		throws java.lang.Exception {
		return _clipService.findByClipTypeId(clipTypeId, start, end);
	}

	public int countByClipTypeId(java.lang.String clipTypeId)
		throws java.lang.Exception {
		return _clipService.countByClipTypeId(clipTypeId);
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findClip(
		com.vportal.portlet.vclip.model.Clip clip) throws java.lang.Exception {
		return _clipService.findClip(clip);
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> findClip(
		com.vportal.portlet.vclip.model.Clip clip, int start, int end)
		throws java.lang.Exception {
		return _clipService.findClip(clip, start, end);
	}

	public int countClip(com.vportal.portlet.vclip.model.Clip clip)
		throws java.lang.Exception {
		return _clipService.countClip(clip);
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> searchClip(
		java.lang.String textSearch, java.lang.String clipTypeId)
		throws java.lang.Exception {
		return _clipService.searchClip(textSearch, clipTypeId);
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> getAll()
		throws java.lang.Exception {
		return _clipService.getAll();
	}

	public java.util.List<com.vportal.portlet.vclip.model.Clip> getAll(
		int begin, int end) throws java.lang.Exception {
		return _clipService.getAll(begin, end);
	}

	public int countAll() throws java.lang.Exception {
		return _clipService.countAll();
	}

	public boolean hasParent(java.lang.String clipTypeId)
		throws java.lang.Exception {
		return _clipService.hasParent(clipTypeId);
	}

	public com.vportal.portlet.vclip.model.Clip getFirst()
		throws java.lang.Exception {
		return _clipService.getFirst();
	}

	public com.vportal.portlet.vclip.model.Clip getByClipTypeId(
		java.lang.String clipTypeId) throws java.lang.Exception {
		return _clipService.getByClipTypeId(clipTypeId);
	}

	public void addClipResources(java.lang.String articleId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_clipService.addClipResources(articleId, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addClipResources(com.vportal.portlet.vclip.model.Clip article,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_clipService.addClipResources(article, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addClipResources(java.lang.String articleId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_clipService.addClipResources(articleId, communityPermissions,
			guestPermissions);
	}

	public void addClipResources(com.vportal.portlet.vclip.model.Clip article,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_clipService.addClipResources(article, communityPermissions,
			guestPermissions);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ClipService getWrappedClipService() {
		return _clipService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedClipService(ClipService clipService) {
		_clipService = clipService;
	}

	public ClipService getWrappedService() {
		return _clipService;
	}

	public void setWrappedService(ClipService clipService) {
		_clipService = clipService;
	}

	private ClipService _clipService;
}