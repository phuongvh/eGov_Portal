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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VcmsArticleVersionService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticleVersionService
 * @generated
 */
public class VcmsArticleVersionServiceWrapper
	implements VcmsArticleVersionService,
		ServiceWrapper<VcmsArticleVersionService> {
	public VcmsArticleVersionServiceWrapper(
		VcmsArticleVersionService vcmsArticleVersionService) {
		_vcmsArticleVersionService = vcmsArticleVersionService;
	}

	public com.vportal.portlet.vcms.model.VcmsArticleVersion addVersion(
		long groupId, java.lang.String language, long companyId,
		java.lang.String articleId, java.lang.String typeIds, long status,
		java.lang.String versionName, java.lang.String title,
		java.lang.String lead, java.lang.String content, long userHit,
		boolean hasImage, java.lang.String imageTitle, java.lang.String image,
		java.lang.String author, java.lang.String source, boolean discussible,
		boolean hasPoll, java.lang.String pollId, java.util.Date effectiveDate,
		java.util.Date expireDate, boolean sticky, boolean stickyNeverExpired,
		java.util.Date stickyExpireDate, boolean hasAttach)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleVersionService.addVersion(groupId, language,
			companyId, articleId, typeIds, status, versionName, title, lead,
			content, userHit, hasImage, imageTitle, image, author, source,
			discussible, hasPoll, pollId, effectiveDate, expireDate, sticky,
			stickyNeverExpired, stickyExpireDate, hasAttach);
	}

	public int countVersionByArticleId(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleVersionService.countVersionByArticleId(articleId);
	}

	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleVersion> listVersionByArticleId(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _vcmsArticleVersionService.listVersionByArticleId(articleId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsArticleVersionService getWrappedVcmsArticleVersionService() {
		return _vcmsArticleVersionService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsArticleVersionService(
		VcmsArticleVersionService vcmsArticleVersionService) {
		_vcmsArticleVersionService = vcmsArticleVersionService;
	}

	public VcmsArticleVersionService getWrappedService() {
		return _vcmsArticleVersionService;
	}

	public void setWrappedService(
		VcmsArticleVersionService vcmsArticleVersionService) {
		_vcmsArticleVersionService = vcmsArticleVersionService;
	}

	private VcmsArticleVersionService _vcmsArticleVersionService;
}