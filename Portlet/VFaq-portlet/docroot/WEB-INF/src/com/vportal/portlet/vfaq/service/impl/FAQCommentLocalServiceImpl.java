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

package com.vportal.portlet.vfaq.service.impl;

import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vfaq.service.base.FAQCommentLocalServiceBaseImpl;
import com.vportal.portlet.vfaq.service.permission.FAQAnswerPermission;
import com.vportal.portlet.vfaq.service.permission.FAQCommentPermission;
import com.vportal.portlet.vfaq.service.permission.FAQQuestionPermission;
import com.vportal.portlet.vfaq.util.ActionKeysExt;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portlet.vfaq.FAQCommentApproverException;
import com.vportal.portlet.vfaq.FAQCommentContentException;
import com.vportal.portlet.vfaq.FAQCommentEmailException;
import com.vportal.portlet.vfaq.FAQCommentSenderException;
import com.vportal.portlet.vfaq.model.FAQComment;
/**
 * The implementation of the f a q comment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vfaq.service.FAQCommentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucNN
 * @see com.vportal.portlet.vfaq.service.base.FAQCommentLocalServiceBaseImpl
 * @see com.vportal.portlet.vfaq.service.FAQCommentLocalServiceUtil
 */
public class FAQCommentLocalServiceImpl extends FAQCommentLocalServiceBaseImpl {
	/**
	 * Them 1 comment moi vao database
	 * @throws Exception 
	 */
	public FAQComment addComment(long answerId, String content,
			String commName, String commEmail, boolean approved,
			String approveByUser, Date approvedDate, Date commDate,
			long userId, long plid, boolean addCommunityPermissions,
			boolean addGuestPermissions) throws Exception {
		return addComment(answerId, content, commName, commEmail, approved,
				approveByUser, approvedDate, commDate, userId, plid, new Boolean(
						addCommunityPermissions), new Boolean(
						addGuestPermissions), null, null);
	}

	public FAQComment addComment(long answerId, String content,
			String commName, String commEmail, boolean approved,
			String approveByUser, Date approvedDate, Date commDate,
			long userId, long plid, String[] communityPermissions,
			String[] guestPermissions) throws Exception {
		return addComment(answerId, content, commName, commEmail, approved,
				approveByUser, approvedDate, commDate, userId, plid, null, null,
				communityPermissions, guestPermissions);

	}

	public FAQComment addComment(long answerId, String content,
			String commName, String commEmail, boolean approved,
			String approveByUser, Date approvedDate, Date commDate,
			long userId,long plid, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws Exception {
		
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(userLocalService.getUser(userId), false);
		PortletPermissionUtil.check(permissionChecker, plid,PortletKeysExt.VFAQ, ActionKeysExt.ADD_COMMENT);
		// Comment
		long id = counterLocalService.increment();
		FAQComment comment = faqCommentPersistence.create(id);
		comment.setAnswerid(answerId);
		comment.setContent(content);
		comment.setCommName(commName);
		comment.setCommEmail(commEmail);
		comment.setApproved(approved);
		comment.setApproveByUser(approveByUser);
		comment.setApprovedDate(approvedDate);
		comment.setCommDate(commDate);
		comment.setUserId(userId);

		faqCommentPersistence.update(comment, false);

		// Resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addCommentResources(comment,
					addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addCommentResources(comment, communityPermissions, guestPermissions);
		}
		return comment;

	}

	/**
	 * Sua 1 comment da co
	 */
	public FAQComment updateComment(long commentId, String content,
			boolean approved, String approveByUser, Date approvedDate,
			long userId) throws SystemException, PortalException {
		
		/*FAQCommentPermission.check(getPermissionChecker(), groupId, commentId,
		ActionKeys.UPDATE);*/
		FAQComment comment = faqCommentPersistence.findByPrimaryKey(commentId);
		comment.setContent(content);
		comment.setApproved(approved);
		comment.setApproveByUser(approveByUser);
		comment.setApprovedDate(approvedDate);
		comment.setUserId(userId);
		faqCommentPersistence.update(comment, false);

		return comment;

	}

	public FAQComment updateComment(long groupId, long commentId,
			String content, boolean approved, String approveByUser,
			Date approvedDate, long userId) throws SystemException,
			PortalException {
		
		PermissionChecker permissionChecker = null;
		try {
			permissionChecker = PermissionCheckerFactoryUtil.create(userLocalService.getUser(userId), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FAQCommentPermission.check(permissionChecker, groupId, commentId,
				ActionKeys.UPDATE);

		return updateComment(commentId, content,
				approved, approveByUser, approvedDate, userId);
	}

	public FAQComment getComment(long commentid) throws SystemException,
			PortalException {
		return faqCommentPersistence.findByPrimaryKey(commentid);
	}

	public List getAll() throws SystemException, PortalException {
		return faqCommentPersistence.findAll();
	}

	public List getAll(long groupId) throws SystemException, PortalException {

		return faqCommentFinder.findByGroupId(groupId);
	}

	public List getAll(long groupId, int start, int end)
			throws SystemException, PortalException {

		return faqCommentFinder.findByGroupId(groupId, start, end);
	}

	public int countAll(long groupId) throws SystemException, PortalException {

		return faqCommentFinder.countByGroupId(groupId);
	}

	public void deleteComment(long commentId) throws PortalException,
			SystemException {
		// Get Comment
		FAQComment comment = faqCommentPersistence.findByPrimaryKey(commentId);

		// Delete Resources
		resourceLocalService.deleteResource(PortalUtil.getDefaultCompanyId(),
				FAQComment.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				comment.getId());

		// Delete Comment
		faqCommentPersistence.remove(commentId);
	}

	public FAQComment unapproved(long commentid) throws SystemException,
			PortalException {
		FAQComment comment = faqCommentPersistence.findByPrimaryKey(commentid);
		if (comment.isApproved()) {
			comment.setApproved(false);
			faqCommentPersistence.update(comment, false);
		}
		return comment;
	}

	public List getByApproved(boolean approved) throws SystemException,
			PortalException {
		return faqCommentPersistence.findByApproved(approved);
	}

	public List getByAnswer(long answerid) throws SystemException,
			PortalException {
		return faqCommentPersistence.findByAnswerid(answerid);
	}

	private void _validate(String content, String commName, String commEmail,
			String approveByUser) throws PortalException, SystemException {
		if (Validator.isNull(content) || content.trim().length() > 1000) {
			throw new FAQCommentContentException();
		}
		if (Validator.isNull(commName) || commName.trim().length() > 50) {
			throw new FAQCommentSenderException();
		}
		// Set the email pattern string
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

		// Match the given string with the pattern
		Matcher m = p.matcher(commEmail);

		// check whether match is found
		boolean matchFound = m.matches();
		if (Validator.isNull(commEmail) || commEmail.trim().length() > 50
				|| matchFound == false) {
			throw new FAQCommentEmailException();
		}
		if (approveByUser.length() > 50) {
			throw new FAQCommentApproverException();
		}
	}

	public void addCommentResources(long commentId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		FAQComment comment = faqCommentPersistence.findByPrimaryKey(commentId);

		addCommentResources(comment, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addCommentResources(FAQComment comment,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addResources(PortalUtil.getDefaultCompanyId(), 0,
				comment.getUserId(), FAQComment.class.getName(),
				comment.getId(), false, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addCommentResources(long commentId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		FAQComment comment = faqCommentPersistence.findByPrimaryKey(commentId);

		addCommentResources(comment, communityPermissions, guestPermissions);

	}

	public void addCommentResources(FAQComment comment,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(
				PortalUtil.getDefaultCompanyId(), 0, comment.getUserId(),
				FAQComment.class.getName(), comment.getId(),
				communityPermissions, guestPermissions);
	}
	
	//ducnn add getcomment by para
	public List getByPara(long groupId, String title, int start, int end)
			throws SystemException, PortalException {

		return faqCommentFinder.findByPara(groupId, title, start, end);
	}

	public int countByPara(long groupId, String title) throws SystemException, PortalException {

		return faqCommentFinder.countByPara(groupId,title);
	}
	
	public void removeComment(long groupId, long commentid)
			throws SystemException, PortalException {

		/*FAQCommentPermission.check(getPermissionChecker(), groupId, commentid,
				ActionKeys.DELETE);*/

		deleteComment(commentid);
	}
}