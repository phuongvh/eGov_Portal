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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the f a q question local service. This utility wraps {@link com.vportal.portlet.vfaq.service.impl.FAQQuestionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucNN
 * @see FAQQuestionLocalService
 * @see com.vportal.portlet.vfaq.service.base.FAQQuestionLocalServiceBaseImpl
 * @see com.vportal.portlet.vfaq.service.impl.FAQQuestionLocalServiceImpl
 * @generated
 */
public class FAQQuestionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vfaq.service.impl.FAQQuestionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the f a q question to the database. Also notifies the appropriate model listeners.
	*
	* @param faqQuestion the f a q question
	* @return the f a q question that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQQuestion addFAQQuestion(
		com.vportal.portlet.vfaq.model.FAQQuestion faqQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFAQQuestion(faqQuestion);
	}

	/**
	* Creates a new f a q question with the primary key. Does not add the f a q question to the database.
	*
	* @param id the primary key for the new f a q question
	* @return the new f a q question
	*/
	public static com.vportal.portlet.vfaq.model.FAQQuestion createFAQQuestion(
		long id) {
		return getService().createFAQQuestion(id);
	}

	/**
	* Deletes the f a q question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the f a q question
	* @throws PortalException if a f a q question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteFAQQuestion(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFAQQuestion(id);
	}

	/**
	* Deletes the f a q question from the database. Also notifies the appropriate model listeners.
	*
	* @param faqQuestion the f a q question
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteFAQQuestion(
		com.vportal.portlet.vfaq.model.FAQQuestion faqQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFAQQuestion(faqQuestion);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion fetchFAQQuestion(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFAQQuestion(id);
	}

	/**
	* Returns the f a q question with the primary key.
	*
	* @param id the primary key of the f a q question
	* @return the f a q question
	* @throws PortalException if a f a q question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQQuestion getFAQQuestion(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQQuestion(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.vportal.portlet.vfaq.model.FAQQuestion getFAQQuestionByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQQuestionByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.vportal.portlet.vfaq.model.FAQQuestion> getFAQQuestions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQQuestions(start, end);
	}

	/**
	* Returns the number of f a q questions.
	*
	* @return the number of f a q questions
	* @throws SystemException if a system exception occurred
	*/
	public static int getFAQQuestionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQQuestionsCount();
	}

	/**
	* Updates the f a q question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqQuestion the f a q question
	* @return the f a q question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQQuestion updateFAQQuestion(
		com.vportal.portlet.vfaq.model.FAQQuestion faqQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFAQQuestion(faqQuestion);
	}

	/**
	* Updates the f a q question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqQuestion the f a q question
	* @param merge whether to merge the f a q question with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the f a q question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQQuestion updateFAQQuestion(
		com.vportal.portlet.vfaq.model.FAQQuestion faqQuestion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFAQQuestion(faqQuestion, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion addQuestion(
		java.lang.String title, java.lang.String content,
		java.lang.String language, long questionOrder, java.util.Date sentDate,
		java.lang.String sentByUser, java.lang.String senderEmail,
		java.lang.String questionType, long hitCount, boolean isApproved,
		long groupId, long userId, long plid, boolean addCommunityPermissions,
		boolean addGuestPermissions) throws java.lang.Exception {
		return getService()
				   .addQuestion(title, content, language, questionOrder,
			sentDate, sentByUser, senderEmail, questionType, hitCount,
			isApproved, groupId, userId, plid, addCommunityPermissions,
			addGuestPermissions);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion addQuestion(
		java.lang.String title, java.lang.String content,
		java.lang.String language, long questionOrder, java.util.Date sentDate,
		java.lang.String sentByUser, java.lang.String senderEmail,
		java.lang.String questionType, long hitCount, boolean isApproved,
		long groupId, long userId, long plid,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return getService()
				   .addQuestion(title, content, language, questionOrder,
			sentDate, sentByUser, senderEmail, questionType, hitCount,
			isApproved, groupId, userId, plid, communityPermissions,
			guestPermissions);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion addQuestion(
		java.lang.String title, java.lang.String content,
		java.lang.String language, long questionOrder, java.util.Date sentDate,
		java.lang.String sentByUser, java.lang.String senderEmail,
		java.lang.String questionType, long hitCount, boolean isApproved,
		long groupId, long userId, long plid,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return getService()
				   .addQuestion(title, content, language, questionOrder,
			sentDate, sentByUser, senderEmail, questionType, hitCount,
			isApproved, groupId, userId, plid, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion updateQuestion(
		long questionId, java.lang.String title, java.lang.String content,
		java.lang.String language, long questionOrder,
		java.util.Date modifiedDate, java.lang.String modifiedByUser,
		java.lang.String questionType, long hitCount, boolean isApproved,
		long groupId, long userId, java.lang.String senderEmail,
		java.lang.String sentByUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateQuestion(questionId, title, content, language,
			questionOrder, modifiedDate, modifiedByUser, questionType,
			hitCount, isApproved, groupId, userId, senderEmail, sentByUser);
	}

	public static void deleteQuestion(long groupId, long userId, long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteQuestion(groupId, userId, questionId);
	}

	public static void deleteQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteQuestion(questionId);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion increaseHitCount(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().increaseHitCount(questionId);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion unapproveQuestion(
		long groupId, long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().unapproveQuestion(groupId, questionId);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion unapproveQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().unapproveQuestion(questionId);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion approveQuestion(
		long groupId, long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().approveQuestion(groupId, questionId);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion approveQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().approveQuestion(questionId);
	}

	public static java.util.List getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll();
	}

	public static java.util.List getAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll(groupId);
	}

	public static java.util.List getAll(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll(groupId, start, end);
	}

	public static int countAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll(groupId);
	}

	public static java.util.List getApprovedQuestions(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getApprovedQuestions(groupId);
	}

	public static java.util.List getApprovedQuestions(long groupId, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getApprovedQuestions(groupId, start, end);
	}

	public static int countApprovedQuestions(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countApprovedQuestions(groupId);
	}

	public static java.util.List getUnapprovedQuestions(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUnapprovedQuestions(groupId);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion getQuestion(
		long groupId, long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuestion(groupId, questionId);
	}

	public static com.vportal.portlet.vfaq.model.FAQQuestion getQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuestion(questionId);
	}

	public static java.util.List getByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByGroupId(groupId);
	}

	public static java.util.List getTopQuestion(long groupId,
		java.lang.String language, int quantity, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTopQuestion(groupId, language, quantity, approved);
	}

	public static java.util.List getOtherQuestion(long groupId,
		java.lang.String language, boolean approved, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getOtherQuestion(groupId, language, approved, begin, end);
	}

	public static java.util.List getQuestionsInCategory(long groupId,
		java.lang.String language, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuestionsInCategory(groupId, language, categoryId);
	}

	public static void addQuestionResources(long questionId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addQuestionResources(questionId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addQuestionResources(
		com.vportal.portlet.vfaq.model.FAQQuestion question,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addQuestionResources(question, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addQuestionResources(long questionId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addQuestionResources(questionId, communityPermissions,
			guestPermissions);
	}

	public static void addQuestionResources(
		com.vportal.portlet.vfaq.model.FAQQuestion question,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addQuestionResources(question, communityPermissions,
			guestPermissions);
	}

	public static com.liferay.portal.kernel.search.Hits search(long companyId,
		long groupId, long userId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, userId, keywords, start, end);
	}

	public static java.util.List getOrtherQuestionByParam(long groupId,
		java.lang.String language, long Id, long categoryId, boolean approved,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getOrtherQuestionByParam(groupId, language, Id, categoryId,
			approved, start, end);
	}

	public static int countQuestionByParam(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		java.lang.String sentByUser, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .countQuestionByParam(groupId, language, categoryId, title,
			sentByUser, approved);
	}

	public static java.util.List getQuestion(long groupId,
		java.lang.String language, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getQuestion(groupId, language, categoryId, start, end);
	}

	public static int countQuestion(long groupId, java.lang.String language,
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countQuestion(groupId, language, categoryId);
	}

	public static java.util.List getQuestionByParam(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		java.lang.String sentByUser, boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getQuestionByParam(groupId, language, categoryId, title,
			sentByUser, approved, start, end);
	}

	public static java.util.List getQuestionByParam(long groupId,
		java.lang.String language, long categoryId, java.lang.String title,
		java.lang.String sentByUser, boolean approved,
		java.lang.String clickValue, java.lang.String arrange, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getQuestionByParam(groupId, language, categoryId, title,
			sentByUser, approved, clickValue, arrange, start, end);
	}

	public static java.util.List getQuestionByG_L_S(long groupId,
		java.lang.String language, boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService()
				   .getQuestionByG_L_S(groupId, language, approved, start, end);
	}

	public static int countQuestionByG_L_S(long groupId,
		java.lang.String language, boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().countQuestionByG_L_S(groupId, language, approved);
	}

	public static void clearService() {
		_service = null;
	}

	public static FAQQuestionLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FAQQuestionLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					FAQQuestionLocalService.class.getName(), portletClassLoader);

			_service = new FAQQuestionLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(FAQQuestionLocalServiceUtil.class,
				"_service");
			MethodCache.remove(FAQQuestionLocalService.class);
		}

		return _service;
	}

	public void setService(FAQQuestionLocalService service) {
		MethodCache.remove(FAQQuestionLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(FAQQuestionLocalServiceUtil.class,
			"_service");
		MethodCache.remove(FAQQuestionLocalService.class);
	}

	private static FAQQuestionLocalService _service;
}