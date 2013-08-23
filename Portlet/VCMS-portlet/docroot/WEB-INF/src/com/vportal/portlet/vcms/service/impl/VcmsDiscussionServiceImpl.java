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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.Validator;
import com.vportal.portlet.vcms.InvalidDiscussionContentException;
import com.vportal.portlet.vcms.InvalidDiscussionTitleException;
import com.vportal.portlet.vcms.InvalidDiscussionVisitorEmailException;
import com.vportal.portlet.vcms.InvalidDiscussionVisitorNameException;
import com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;
import com.vportal.portlet.vcms.model.VcmsDiscussion;
import com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil;
import com.vportal.portlet.vcms.service.base.VcmsDiscussionServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsDiscussionUtil;

/**
 * The implementation of the vcms discussion remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsDiscussionService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsDiscussionServiceUtil} to access
 * the vcms discussion remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsDiscussionServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsDiscussionServiceUtil
 */
public class VcmsDiscussionServiceImpl extends VcmsDiscussionServiceBaseImpl {
	public VcmsDiscussion addDiscussion(String visitorName,
			String visitorEmail, String visitorPhone, long groupId,
			long companyId, String articleId, String title, String content,
			boolean hasAttachment, String language,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException, RemoteException {

		_validate(visitorName, visitorEmail, title, content);

		String discussionId = Long.toString(CounterLocalServiceUtil
				.increment(VcmsDiscussion.class.getName()));

		VcmsDiscussion discussion = VcmsDiscussionUtil.create(discussionId);

		discussion.setVisitorName(visitorName);
		discussion.setVisitorEmail(visitorEmail);
		discussion.setVisitorPhone(visitorPhone);

		discussion.setGroupId(groupId);
		discussion.setCompanyId(companyId);

		discussion.setArticleId(articleId);
		discussion.setTitle(title);
		discussion.setContent(content);
		discussion.setLanguage(language);

		discussion.setApproved(false);
		discussion.setApprovedByUser(null);
		discussion.setApprovedDate(null);

		discussion.setPostedDate(new Date());

		discussion.setHasAttachment(hasAttachment);

		vcmsDiscussionPersistence.update(discussion, false);

		return discussion;
	}

	public VcmsDiscussion updateDiscussion(String discussionId,
			String visitorName, String visitorEmail, String visitorPhone,
			long groupId, long companyId, String articleId, String title,
			String content, boolean hasAttachment, boolean approved,
			String language) throws PortalException, SystemException,
			RemoteException {

		_validate(visitorName, visitorEmail, title, content);

		VcmsDiscussion discussion = VcmsDiscussionUtil
				.findByPrimaryKey(discussionId);

		Date now = new Date();

		discussion.setVisitorName(visitorName);
		discussion.setVisitorEmail(visitorEmail);
		discussion.setVisitorPhone(visitorPhone);

		discussion.setGroupId(groupId);
		discussion.setCompanyId(companyId);

		discussion.setArticleId(articleId);

		discussion.setTitle(title);
		discussion.setContent(content);

		if (discussion.getApproved() ^ approved) {
			discussion.setApproved(approved);
			discussion.setApprovedByUser(String.valueOf(getUserId()));
			discussion.setApprovedDate(now);

			if (approved) {
				VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
						+ " - APPROVE: vcms discussion [" + title + "] by "
						+ getUserId());
			} else {
				VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
						+ " - CANCEL APPROVE: vcms discussion [" + title
						+ "] by " + getUserId());
			}
		} else {
			VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
					+ " - UPDATE: vcms discussion [" + title + "] by "
					+ getUserId());
		}

		discussion.setPostedDate(now);
		discussion.setHasAttachment(hasAttachment);
		discussion.setLanguage(language);

		vcmsDiscussionPersistence.update(discussion, false);

		return discussion;
	}

	public VcmsDiscussion updateDiscussion(VcmsDiscussion discussion)
			throws PortalException, SystemException, RemoteException {
		return updateDiscussion(discussion.getDiscussionId(),
				discussion.getVisitorName(), discussion.getVisitorEmail(),
				discussion.getVisitorPhone(), discussion.getGroupId(),
				discussion.getCompanyId(), discussion.getArticleId(),
				discussion.getTitle(), discussion.getContent(),
				discussion.getHasAttachment(), discussion.getApproved(),
				discussion.getLanguage());
	}

	public void deleteDiscussion(String discussionId) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(discussionId)) {
			throw new NoSuchVcmsDiscussionException();
		}

		VcmsDiscussion discussion = VcmsDiscussionUtil
				.findByPrimaryKey(discussionId);

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(new Date())
				+ " - DELETE: vcms discussion [" + discussion.getTitle()
				+ "] by " + getUserId());

		vcmsDiscussionPersistence.remove(discussionId);
	}

	public void deleteDiscussions(String[] discussionIds)
			throws PortalException, SystemException, RemoteException {

		if ((discussionIds == null) || (discussionIds.length <= 0)) {
			return;
		}

		for (int i = 0; i < discussionIds.length; i++) {
			deleteDiscussion(discussionIds[i]);
		}

	}

	public void deleteDiscussions(String articleId) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(articleId)) {
			return;
		}

		vcmsDiscussionPersistence.removeByArticle(articleId);
	}

	public void deleteDiscussions(String articleId, boolean approved)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(articleId)) {
			return;
		}

		vcmsDiscussionPersistence.removeByA_A(articleId, approved);
	}

	public VcmsDiscussion getDiscussion(String discussionId)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(discussionId)) {
			throw new NoSuchVcmsDiscussionException();
		}

		return vcmsDiscussionPersistence.findByPrimaryKey(discussionId);
	}

	public List<VcmsDiscussion> getDiscussions(String articleId)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(articleId)) {
			return new ArrayList();
		}

		return vcmsDiscussionPersistence.findByArticle(articleId);
	}

	public List<VcmsDiscussion> getDiscussions(String articleId,
			boolean approved) throws PortalException, SystemException,
			RemoteException {

		if (Validator.isNull(articleId)) {
			return new ArrayList();
		}

		return vcmsDiscussionPersistence.findByA_A(articleId, approved);
	}

	public List<VcmsDiscussion> getDiscussionsByP_L(long groupId,
			String language) throws PortalException, SystemException,
			RemoteException {
		/*
		 * if (Validator.isNull(groupId) || Validator.isNull(language)) { return
		 * null; }
		 */

		return vcmsDiscussionPersistence.findByP_L(groupId, language);
	}

	public List<VcmsDiscussion> getDiscussionsByP_L_A(long groupId,
			String language, boolean approved) throws PortalException,
			SystemException, RemoteException {

		/*
		 * if (Validator.isNull(groupId) || Validator.isNull(language)) { return
		 * null; }
		 */

		return vcmsDiscussionPersistence.findByP_L_A(groupId, language,
				approved);
	}

	/*
	 * add by Donghh the method implement get discussions by article
	 */
	public List<VcmsDiscussion> getDiscussionsByA_P_L_A(String articleId,
			long groupId, String language, boolean approved)
			throws PortalException, SystemException, RemoteException {

		/*
		 * if (Validator.isNull(articleId) || Validator.isNull(groupId) ||
		 * Validator.isNull(language)) { return null; }
		 */

		return vcmsDiscussionPersistence.findByA_P_L_A(articleId, groupId,
				language, approved);
	}

	public List<VcmsDiscussion> searchDiscussionByA_P_L_K(String articleId,
			long groupId, String language, String keyword, boolean approved,
			boolean isTitle, boolean isContent, String select)
			throws PortalException, SystemException, RemoteException {

		return (List) vcmsDiscussionFinder.searchDiscussionByA_P_L_K(articleId,
				groupId, language, keyword, approved, isTitle, isContent,
				select);
	}

	public int countByApproval(long groupId, String language, boolean approved)
			throws PortalException, SystemException, RemoteException {
		/*
		 * if (Validator.isNull(groupId) || Validator.isNull(language)) { return
		 * 0; }
		 */

		return vcmsDiscussionPersistence.countByP_L_A(groupId, language,
				approved);
	}

	private void _validate(String visitorName, String visitorEmail,
			String title, String content) throws PortalException,
			SystemException {

		if (Validator.isNull(visitorName)) {
			throw new InvalidDiscussionVisitorNameException();
		}

		if (!Validator.isEmailAddress(visitorEmail)) {
			throw new InvalidDiscussionVisitorEmailException();
		}

		if (Validator.isNull(title)) {
			throw new InvalidDiscussionTitleException();
		}

		if (Validator.isNull(content)) {
			throw new InvalidDiscussionContentException();
		}
	}
}