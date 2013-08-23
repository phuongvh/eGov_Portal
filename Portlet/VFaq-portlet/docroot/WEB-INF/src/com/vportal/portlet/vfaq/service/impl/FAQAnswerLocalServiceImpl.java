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

import com.vportal.portal.util.PortalUtilExt;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vfaq.service.base.FAQAnswerLocalServiceBaseImpl;
import com.vportal.portlet.vfaq.service.permission.FAQAnswerPermission;
import com.vportal.portlet.vfaq.service.permission.FAQQuestionPermission;
import com.vportal.portlet.vfaq.util.ActionKeysExt;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portlet.vfaq.model.FAQAnswer;
/**
 * The implementation of the f a q answer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vfaq.service.FAQAnswerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucNN
 * @see com.vportal.portlet.vfaq.service.base.FAQAnswerLocalServiceBaseImpl
 * @see com.vportal.portlet.vfaq.service.FAQAnswerLocalServiceUtil
 */
public class FAQAnswerLocalServiceImpl extends FAQAnswerLocalServiceBaseImpl {
	/**
	 * Them 1 answer moi vao database
	 * @throws Exception 
	 */	
	public FAQAnswer addAnswer(long groupId, long questionId, String content,
			long answerOrder, String answeredByUser, Date answeredDate,
			String language, boolean isApproved, String approvedByUser,
			Date approvedDate, long userId, long plid, String attachName, long folderId,
			String[] communityPermissions, String[] guestPermissions)
			throws Exception {
	
		return addAnswer(groupId, questionId, content,
				answerOrder, answeredByUser, answeredDate, language,
				isApproved, approvedByUser, approvedDate, userId,plid, attachName,
				folderId,null,null, communityPermissions, guestPermissions);
	}

	public FAQAnswer addAnswer(long groupId, long questionId, String content,
			long answerOrder, String answeredByUser, Date answeredDate,
			String language, boolean isApproved, String approvedByUser,
			Date approvedDate, long userId,long plid, String attachName, long folderId,
			Boolean addCommunityPermissions, Boolean addGuestPermissions,
			String[] communityPermissions, String[] guestPermissions)
			throws Exception {

		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(userLocalService.getUser(userId), false);
		PortletPermissionUtil.check(permissionChecker, plid,PortletKeysExt.VFAQ, ActionKeysExt.ADD_ANSWER);
		// Answer
		long id = counterLocalService.increment();
		FAQAnswer answer = faqAnswerPersistence.create(id);
		answer.setQuestionid(questionId);
		answer.setContent(content);
		answer.setAnswerOrder(answerOrder);
		answer.setAnsweredByUser(answeredByUser);
		answer.setAnsweredDate(answeredDate);
		answer.setLanguage(language);
		answer.setApproved(isApproved);
		answer.setApprovedByUser(approvedByUser);
		answer.setApprovedDate(approvedDate);
		answer.setUserId(userId);
		answer.setAttachName(attachName);
		answer.setFolderId(folderId);
		faqAnswerPersistence.update(answer, false);

		// Resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addAnswerResources(answer, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addAnswerResources(answer, communityPermissions, guestPermissions);
		}

		return answer;
	}

	/**
	 * Sua 1 answer da co
	 */
	public FAQAnswer updateAnswer(long groupId, long answerId, String content,
			long answerOrder, String answeredByUser, Date answeredDate,
			String language, boolean isApproved, String approvedByUser,
			Date approvedDate, long userId, String attachName, long folderId)
			throws PortalException, SystemException {
 
		try {
			PermissionChecker permissionChecker = 
					PermissionCheckerFactoryUtil.create(userLocalService.getUser(userId), false) ;
		
			FAQAnswerPermission.check(permissionChecker, groupId,
			answerId, ActionKeys.UPDATE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FAQAnswer answer = faqAnswerPersistence.findByPrimaryKey(answerId);
		answer.setContent(content);
		answer.setAnswerOrder(answerOrder);
		answer.setAnsweredByUser(answeredByUser);
		answer.setAnsweredDate(answeredDate);
		answer.setLanguage(language);
		answer.setApproved(isApproved);
		answer.setApprovedByUser(approvedByUser);
		answer.setApprovedDate(approvedDate);
		answer.setUserId(userId);
		answer.setAttachName(attachName);
		answer.setFolderId(folderId);
		faqAnswerPersistence.update(answer, false);

		return answer;
	}
	public FAQAnswer updateAnswer(FAQAnswer faqAnswer, long groupId)
			throws PortalException, SystemException {

		return updateAnswer(groupId,faqAnswer.getId(), faqAnswer.getContent(), faqAnswer.getAnswerOrder(), 
				faqAnswer.getAnsweredByUser(),
				faqAnswer.getAnsweredDate(),faqAnswer.getLanguage(),faqAnswer.getApproved(),
				faqAnswer.getApprovedByUser(),faqAnswer.getApprovedDate(),faqAnswer.getUserId(),
				faqAnswer.getAttachName(),faqAnswer.getFolderId());

	}

	/**
	 * Xoa 1 answer
	 */
	public void deleteAnswer(long answerid) throws PortalException,
			SystemException {
		// Get Answer
		FAQAnswer answer = faqAnswerPersistence.findByPrimaryKey(answerid);

		// Delete Resources
		resourceLocalService.deleteResource(PortalUtil.getDefaultCompanyId(),
				FAQAnswer.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				answer.getId());

		// Delete Answer
		faqAnswerPersistence.remove(answerid);
	}
	
	public void deleteAnswer(long groupId, long userId, long answerid)
			throws PortalException, SystemException {

		try {
			PermissionChecker permissionChecker = 
					PermissionCheckerFactoryUtil.create(userLocalService.getUser(userId), false) ;
		
			FAQAnswerPermission.check(permissionChecker, groupId,
			answerid, ActionKeys.DELETE);
			deleteAnswer(answerid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public FAQAnswer approveAnswer(long answerId, String approvedByUser)
			throws PortalException, SystemException {
		FAQAnswer answer = faqAnswerPersistence.findByPrimaryKey(answerId);
		if (!answer.isApproved()) {
			answer.setApproved(true);
			answer.setApprovedByUser(approvedByUser);
			faqAnswerPersistence.update(answer, false);
		}
		return answer;
	}

	/**
	 * Huy viec hien thi 1 answer
	 */
	public FAQAnswer unapproveAnswer(long answerId, String approvedByUser)
			throws PortalException, SystemException {
		FAQAnswer answer = faqAnswerPersistence.findByPrimaryKey(answerId);
		if (answer.isApproved()) {
			answer.setApproved(false);
			answer.setApprovedByUser(approvedByUser);
			faqAnswerPersistence.update(answer, false);
		}
		return answer;
	}

	/**
	 * Tim answer voi questionid
	 */
	public List getByQuestion(long questionId) throws PortalException,
			SystemException {
		return faqAnswerPersistence.findByQuestionId(questionId);
	}

	public int countQuestion(long questionid) throws SystemException {
		return faqAnswerPersistence.countByQuestionId(questionid);
	}

	/**
	 * Tim nhung answer thong qua trang thai duyet (approve) cua answer
	 */
	public List getByApprove(boolean approved) throws PortalException,
			SystemException {
		return faqAnswerPersistence.findByApproved(approved);
	}

	public List getByLanguage(String language) throws PortalException,
			SystemException {
		return faqAnswerPersistence.findByLanguage(language);
	}

	public FAQAnswer getAnswer(long answerId) throws PortalException,
			SystemException {
		return faqAnswerPersistence.findByPrimaryKey(answerId);
	}

	public List getAll() throws PortalException, SystemException {
		return faqAnswerPersistence.findAll();
	}

	public List getByGroupId(long groupId) throws PortalException,
			SystemException {
		return faqAnswerFinder.findByGroupId(groupId);
	}

	public List getByGroupId(long groupId, int start, int end)
			throws PortalException, SystemException {
		return faqAnswerFinder.findByGroupId(groupId, start, end);
	}

	public int countByGroupId(long groupId) throws PortalException,
			SystemException {
		return faqAnswerFinder.countByGroupId(groupId);
	}

	public List getByGroupId(long groupId, String language)
			throws PortalException, SystemException {
		return faqAnswerFinder.findByG_L(groupId, language);
	}

	public List getByG_L_S(long groupId, String language, boolean approved,
			int start, int end) throws PortalException, SystemException {
		return faqAnswerFinder.getByG_L_S(groupId, language, approved, start,
				end);
	}

	public int countByG_L_S(long groupId, String language, boolean approved)
			throws PortalException, SystemException {
		return faqAnswerFinder.countByG_L_S(groupId, language, approved);
	}

	public int countByG_L_S_Q(long groupId, String language, boolean approved,
			long questionId) throws PortalException, SystemException {
		return faqAnswerFinder.countByG_L_S_Q(groupId, language, approved,
				questionId);
	}

	public List getByParam(long groupId, String language, boolean approved,
			String title, String sentByUser, long categoryId, int start, int end)
			throws PortalException, SystemException {
		return faqAnswerFinder.getByParam(groupId, language, approved, title, sentByUser,
				categoryId, start, end);
	}

	public int countByParam(long groupId, String language, boolean approved,
			String title, String sentByUser, long categoryId) throws PortalException,
			SystemException {
		return faqAnswerFinder.countByParam(groupId, language, approved, title, sentByUser,
				categoryId);
	}

	public void addAnswerResources(long answerId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		FAQAnswer answer = faqAnswerPersistence.findByPrimaryKey(answerId);

		addAnswerResources(answer, addCommunityPermissions, addGuestPermissions);
	}

	public void addAnswerResources(FAQAnswer answer,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		/*
		 * resourceLocalService.addResources(MainServlet.DEFAULT_COMPANY_ID, 0,
		 * answer.getUserId(), FAQAnswer.class.getName(), answer.getId(), false,
		 * addCommunityPermissions, addGuestPermissions);
		 */
		resourceLocalService.addResources(PortalUtil.getDefaultCompanyId(), 0,
				answer.getUserId(), FAQAnswer.class.getName(), answer.getId(),
				false, addCommunityPermissions, addGuestPermissions);
	}

	public void addAnswerResources(long answerId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		FAQAnswer answer = faqAnswerPersistence.findByPrimaryKey(answerId);

		addAnswerResources(answer, communityPermissions, guestPermissions);

	}

	public void addAnswerResources(FAQAnswer answer,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		/*
		 * resourceLocalService.addModelResources(MainServlet.DEFAULT_COMPANY_ID,
		 * 0, answer.getUserId(), FAQAnswer.class.getName(), answer .getId(),
		 * communityPermissions, guestPermissions);
		 */
		resourceLocalService.addModelResources(
				PortalUtil.getDefaultCompanyId(), 0, answer.getUserId(),
				FAQAnswer.class.getName(), answer.getId(),
				communityPermissions, guestPermissions);
	}
	
	public List getAnswer(long groupId, String language, long categoryId, int start, int end)
			throws PortalException, SystemException {
		return faqAnswerFinder.getAnswer(groupId, language, categoryId, start, end);
	}

	public int countAnswer(long groupId, String language, long categoryId) throws PortalException,
			SystemException {
		return faqAnswerFinder.countAnswer(groupId, language, categoryId);
	}
}