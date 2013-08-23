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

package com.vportal.portlet.vcms.service.impl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.vportal.portlet.vcms.model.VcmsArticleVersion;
import com.vportal.portlet.vcms.service.base.VcmsArticleVersionServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsArticleVersionUtil;

/**
 * The implementation of the vcms article version remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsArticleVersionService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsArticleVersionServiceUtil} to
 * access the vcms article version remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsArticleVersionServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsArticleVersionServiceUtil
 */
public class VcmsArticleVersionServiceImpl extends
		VcmsArticleVersionServiceBaseImpl {
	public VcmsArticleVersion addVersion(long groupId, String language,
			long companyId, String articleId, String typeIds, long status,
			String versionName, String title, String lead, String content,
			long userHit, boolean hasImage, String imageTitle, String image,
			String author, String source, boolean discussible, boolean hasPoll,
			String pollId, Date effectiveDate, Date expireDate, boolean sticky,
			boolean stickyNeverExpired, Date stickyExpireDate, boolean hasAttach)
			throws PortalException, SystemException, RemoteException {

		long versionId = CounterLocalServiceUtil
				.increment(VcmsArticleVersion.class.getName());

		VcmsArticleVersion articleVersion = VcmsArticleVersionUtil
				.create(versionId);

		Date now = new Date();

		articleVersion.setGroupId(groupId);
		articleVersion.setLanguage(language);
		articleVersion.setCompanyId(companyId);
		articleVersion.setArticleId(articleId);
		articleVersion.setTitle(title);
		articleVersion.setLead(lead);
		articleVersion.setContent(content);
		articleVersion.setUserHit(userHit);
		articleVersion.setHasImage(hasImage);
		articleVersion.setImageTitle(imageTitle);
		articleVersion.setImage(image);
		articleVersion.setAuthor(author);
		articleVersion.setSource(source);
		articleVersion.setDiscussible(discussible);
		articleVersion.setHasPoll(hasPoll);
		articleVersion.setPollId(pollId);
		articleVersion.setEffectiveDate(effectiveDate);
		articleVersion.setExpireDate(expireDate);
		articleVersion.setSticky(sticky);
		articleVersion.setStickyNeverExpired(stickyNeverExpired);
		articleVersion.setStickyExpireDate(stickyExpireDate);
		articleVersion.setHasAttachment(hasAttach);

		articleVersion.setCreatedDate(now);
		articleVersion.setCreatedByUser(String.valueOf(getUserId()));

		return vcmsArticleVersionPersistence.update(articleVersion, false);

	}

	public int countVersionByArticleId(String articleId)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticleVersionPersistence.countByArticle(articleId);
	}

	public List<VcmsArticleVersion> listVersionByArticleId(String articleId)
			throws PortalException, SystemException, RemoteException {
		return vcmsArticleVersionPersistence.findByArticle(articleId);

	}

}