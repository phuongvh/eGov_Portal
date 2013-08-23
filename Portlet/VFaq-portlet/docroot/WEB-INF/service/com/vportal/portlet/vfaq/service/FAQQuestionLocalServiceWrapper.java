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

package com.vportal.portlet.vfaq.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link FAQQuestionLocalService}.
 * </p>
 *
 * @author    DucNN
 * @see       FAQQuestionLocalService
 * @generated
 */
public class FAQQuestionLocalServiceWrapper implements FAQQuestionLocalService,
	ServiceWrapper<FAQQuestionLocalService> {
	public FAQQuestionLocalServiceWrapper(
		FAQQuestionLocalService faqQuestionLocalService) {
		_faqQuestionLocalService = faqQuestionLocalService;
	}

	/**
	* Adds the f a q question to the database. Also notifies the appropriate model listeners.
	*
	* @param faqQuestion the f a q question
	* @return the f a q question that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQQuestion addFAQQuestion(
		com.vportal.portlet.vfaq.model.FAQQuestion faqQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.addFAQQuestion(faqQuestion);
	}

	/**
	* Creates a new f a q question with the primary key. Does not add the f a q question to the database.
	*
	* @param id the primary key for the new f a q question
	* @return the new f a q question
	*/
	public com.vportal.portlet.vfaq.model.FAQQuestion createFAQQuestion(long id) {
		return _faqQuestionLocalService.createFAQQuestion(id);
	}

	/**
	* Deletes the f a q question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the f a q question
	* @throws PortalException if a f a q question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteFAQQuestion(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqQuestionLocalService.deleteFAQQuestion(id);
	}

	/**
	* Deletes the f a q question from the database. Also notifies the appropriate model listeners.
	*
	* @param faqQuestion the f a q question
	* @throws SystemException if a system exception occurred
	*/
	public void deleteFAQQuestion(
		com.vportal.portlet.vfaq.model.FAQQuestion faqQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		_faqQuestionLocalService.deleteFAQQuestion(faqQuestion);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion fetchFAQQuestion(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.fetchFAQQuestion(id);
	}

	/**
	* Returns the f a q question with the primary key.
	*
	* @param id the primary key of the f a q question
	* @return the f a q question
	* @throws PortalException if a f a q question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQQuestion getFAQQuestion(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getFAQQuestion(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the f a q question with the UUID in the group.
	*
	* @param uuid the UUID of f a q question
	* @param groupId the group id of the f a q question
	* @return the f a q question
	* @throws PortalException if a f a q question with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQQuestion getFAQQuestionByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getFAQQuestionByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the f a q questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of f a q questions
	* @param end the upper bound of the range of f a q questions (not inclusive)
	* @return the range of f a q questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQQuestion> getFAQQuestions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getFAQQuestions(start, end);
	}

	/**
	* Returns the number of f a q questions.
	*
	* @return the number of f a q questions
	* @throws SystemException if a system exception occurred
	*/
	public int getFAQQuestionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getFAQQuestionsCount();
	}

	/**
	* Updates the f a q question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqQuestion the f a q question
	* @return the f a q question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQQuestion updateFAQQuestion(
		com.vportal.portlet.vfaq.model.FAQQuestion faqQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.updateFAQQuestion(faqQuestion);
	}

	/**
	* Updates the f a q question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqQuestion the f a q question
	* @param merge whether to merge the f a q question with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the f a q question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQQuestion updateFAQQuestion(
		com.vportal.portlet.vfaq.model.FAQQuestion faqQuestion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.updateFAQQuestion(faqQuestion, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _faqQuestionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_faqQuestionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion addQuestion(
		java.lang.String title, java.lang.String content,
		java.lang.String language, long questionOrder, java.util.Date sentDate,
		java.lang.String sentByUser, java.lang.String senderEmail,
		java.lang.String questionType, long hitCount, boolean isApproved,
		long groupId, long userId, long plid, boolean addCommunityPermissions,
		boolean addGuestPermissions) throws java.lang.Exception {
		return _faqQuestionLocalService.addQuestion(title, content, language,
			questionOrder, sentDate, sentByUser, senderEmail, questionType,
			hitCount, isApproved, groupId, userId, plid,
			addCommunityPermissions, addGuestPermissions);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion addQuestion(
		java.lang.String title, java.lang.String content,
		java.lang.String language, long questionOrder, java.util.Date sentDate,
		java.lang.String sentByUser, java.lang.String senderEmail,
		java.lang.String questionType, long hitCount, boolean isApproved,
		long groupId, long userId, long plid,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return _faqQuestionLocalService.addQuestion(title, content, language,
			questionOrder, sentDate, sentByUser, senderEmail, questionType,
			hitCount, isApproved, groupId, userId, plid, communityPermissions,
			guestPermissions);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion addQuestion(
		java.lang.String title, java.lang.String content,
		java.lang.String language, long questionOrder, java.util.Date sentDate,
		java.lang.String sentByUser, java.lang.String senderEmail,
		java.lang.String questionType, long hitCount, boolean isApproved,
		long groupId, long userId, long plid,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return _faqQuestionLocalService.addQuestion(title, content, language,
			questionOrder, sentDate, sentByUser, senderEmail, questionType,
			hitCount, isApproved, groupId, userId, plid,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion updateQuestion(
		long questionId, java.lang.String title, java.lang.String content,
		java.lang.String language, long questionOrder,
		java.util.Date modifiedDate, java.lang.String modifiedByUser,
		java.lang.String questionType, long hitCount, boolean isApproved,
		long groupId, long userId, java.lang.String senderEmail,
		java.lang.String sentByUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.updateQuestion(questionId, title,
			content, language, questionOrder, modifiedDate, modifiedByUser,
			questionType, hitCount, isApproved, groupId, userId, senderEmail,
			sentByUser);
	}

	public void deleteQuestion(long groupId, long userId, long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqQuestionLocalService.deleteQuestion(groupId, userId, questionId);
	}

	public void deleteQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqQuestionLocalService.deleteQuestion(questionId);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion increaseHitCount(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.increaseHitCount(questionId);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion unapproveQuestion(
		long groupId, long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.unapproveQuestion(groupId, questionId);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion unapproveQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.unapproveQuestion(questionId);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion approveQuestion(
		long groupId, long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.approveQuestion(groupId, questionId);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion approveQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.approveQuestion(questionId);
	}

	public java.util.List getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getAll();
	}

	public java.util.List getAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getAll(groupId);
	}

	public java.util.List getAll(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getAll(groupId, start, end);
	}

	public int countAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.countAll(groupId);
	}

	public java.util.List getApprovedQuestions(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getApprovedQuestions(groupId);
	}

	public java.util.List getApprovedQuestions(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getApprovedQuestions(groupId, start, end);
	}

	public int countApprovedQuestions(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.countApprovedQuestions(groupId);
	}

	public java.util.List getUnapprovedQuestions(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getUnapprovedQuestions(groupId);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion getQuestion(
		long groupId, long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getQuestion(groupId, questionId);
	}

	public com.vportal.portlet.vfaq.model.FAQQuestion getQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getQuestion(questionId);
	}

	public java.util.List getByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getByGroupId(groupId);
	}

	public java.util.List getTopQuestion(long groupId,
		java.lang.String language, int quantity, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getTopQuestion(groupId, language,
			quantity, approved);
	}

	public java.util.List getOtherQuestion(long groupId,
		java.lang.String language, boolean approved, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getOtherQuestion(groupId, language,
			approved, begin, end);
	}

	public java.util.List getQuestionsInCategory(long groupId,
		java.lang.String language, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.getQuestionsInCategory(groupId,
			language, categoryId);
	}

	public void addQuestionResources(long questionId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqQuestionLocalService.addQuestionResources(questionId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addQuestionResources(
		com.vportal.portlet.vfaq.model.FAQQuestion question,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqQuestionLocalService.addQuestionResources(question,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addQuestionResources(long questionId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqQuestionLocalService.addQuestionResources(questionId,
			communityPermissions, guestPermissions);
	}

	public void addQuestionResources(
		com.vportal.portlet.vfaq.model.FAQQuestion question,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqQuestionLocalService.addQuestionResources(question,
			communityPermissions, guestPermissions);
	}

	public com.liferay.portal.kernel.search.Hits search(long companyId,
		long groupId, long userId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqQuestionLocalService.search(companyId, groupId, userId,
			keywords, start, end);
	}

	public java.util.List getOrtherQuestionByParam(long groupId,
		java.lang.String language, long Id, long categoryId, boolean approved,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _faqQuestionLocalService.getOrtherQuestionByParam(groupId,
			language, Id, categoryId, approved, start, end);
	}

	public int countQuestionByParam(long groupId, java.lang.String language,
		long categoryId, java.lang.String title, java.lang.String sentByUser,
		boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _faqQuestionLocalService.countQuestionByParam(groupId, language,
			categoryId, title, sentByUser, approved);
	}

	public java.util.List getQuestion(long groupId, java.lang.String language,
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _faqQuestionLocalService.getQuestion(groupId, language,
			categoryId, start, end);
	}

	public int countQuestion(long groupId, java.lang.String language,
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _faqQuestionLocalService.countQuestion(groupId, language,
			categoryId);
	}

	public java.util.List getQuestionByParam(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		java.lang.String sentByUser, boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _faqQuestionLocalService.getQuestionByParam(groupId, language,
			categoryId, title, sentByUser, approved, start, end);
	}

	public java.util.List getQuestionByParam(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		java.lang.String sentByUser, boolean approved,
		java.lang.String clickValue, java.lang.String arrange, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _faqQuestionLocalService.getQuestionByParam(groupId, language,
			categoryId, title, sentByUser, approved, clickValue, arrange,
			start, end);
	}

	public java.util.List getQuestionByG_L_S(long groupId,
		java.lang.String language, boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _faqQuestionLocalService.getQuestionByG_L_S(groupId, language,
			approved, start, end);
	}

	public int countQuestionByG_L_S(long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _faqQuestionLocalService.countQuestionByG_L_S(groupId, language,
			approved);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public FAQQuestionLocalService getWrappedFAQQuestionLocalService() {
		return _faqQuestionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedFAQQuestionLocalService(
		FAQQuestionLocalService faqQuestionLocalService) {
		_faqQuestionLocalService = faqQuestionLocalService;
	}

	public FAQQuestionLocalService getWrappedService() {
		return _faqQuestionLocalService;
	}

	public void setWrappedService(
		FAQQuestionLocalService faqQuestionLocalService) {
		_faqQuestionLocalService = faqQuestionLocalService;
	}

	private FAQQuestionLocalService _faqQuestionLocalService;
}