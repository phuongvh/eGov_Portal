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
 * The utility for the f a q answer local service. This utility wraps {@link com.vportal.portlet.vfaq.service.impl.FAQAnswerLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucNN
 * @see FAQAnswerLocalService
 * @see com.vportal.portlet.vfaq.service.base.FAQAnswerLocalServiceBaseImpl
 * @see com.vportal.portlet.vfaq.service.impl.FAQAnswerLocalServiceImpl
 * @generated
 */
public class FAQAnswerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vfaq.service.impl.FAQAnswerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the f a q answer to the database. Also notifies the appropriate model listeners.
	*
	* @param faqAnswer the f a q answer
	* @return the f a q answer that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQAnswer addFAQAnswer(
		com.vportal.portlet.vfaq.model.FAQAnswer faqAnswer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFAQAnswer(faqAnswer);
	}

	/**
	* Creates a new f a q answer with the primary key. Does not add the f a q answer to the database.
	*
	* @param id the primary key for the new f a q answer
	* @return the new f a q answer
	*/
	public static com.vportal.portlet.vfaq.model.FAQAnswer createFAQAnswer(
		long id) {
		return getService().createFAQAnswer(id);
	}

	/**
	* Deletes the f a q answer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the f a q answer
	* @throws PortalException if a f a q answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteFAQAnswer(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFAQAnswer(id);
	}

	/**
	* Deletes the f a q answer from the database. Also notifies the appropriate model listeners.
	*
	* @param faqAnswer the f a q answer
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteFAQAnswer(
		com.vportal.portlet.vfaq.model.FAQAnswer faqAnswer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFAQAnswer(faqAnswer);
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

	public static com.vportal.portlet.vfaq.model.FAQAnswer fetchFAQAnswer(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFAQAnswer(id);
	}

	/**
	* Returns the f a q answer with the primary key.
	*
	* @param id the primary key of the f a q answer
	* @return the f a q answer
	* @throws PortalException if a f a q answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQAnswer getFAQAnswer(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQAnswer(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the f a q answers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of f a q answers
	* @param end the upper bound of the range of f a q answers (not inclusive)
	* @return the range of f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> getFAQAnswers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQAnswers(start, end);
	}

	/**
	* Returns the number of f a q answers.
	*
	* @return the number of f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public static int getFAQAnswersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQAnswersCount();
	}

	/**
	* Updates the f a q answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqAnswer the f a q answer
	* @return the f a q answer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQAnswer updateFAQAnswer(
		com.vportal.portlet.vfaq.model.FAQAnswer faqAnswer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFAQAnswer(faqAnswer);
	}

	/**
	* Updates the f a q answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqAnswer the f a q answer
	* @param merge whether to merge the f a q answer with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the f a q answer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQAnswer updateFAQAnswer(
		com.vportal.portlet.vfaq.model.FAQAnswer faqAnswer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFAQAnswer(faqAnswer, merge);
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

	/**
	* Them 1 answer moi vao database
	*
	* @throws Exception
	*/
	public static com.vportal.portlet.vfaq.model.FAQAnswer addAnswer(
		long groupId, long questionId, java.lang.String content,
		long answerOrder, java.lang.String answeredByUser,
		java.util.Date answeredDate, java.lang.String language,
		boolean isApproved, java.lang.String approvedByUser,
		java.util.Date approvedDate, long userId, long plid,
		java.lang.String attachName, long folderId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return getService()
				   .addAnswer(groupId, questionId, content, answerOrder,
			answeredByUser, answeredDate, language, isApproved, approvedByUser,
			approvedDate, userId, plid, attachName, folderId,
			communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vfaq.model.FAQAnswer addAnswer(
		long groupId, long questionId, java.lang.String content,
		long answerOrder, java.lang.String answeredByUser,
		java.util.Date answeredDate, java.lang.String language,
		boolean isApproved, java.lang.String approvedByUser,
		java.util.Date approvedDate, long userId, long plid,
		java.lang.String attachName, long folderId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return getService()
				   .addAnswer(groupId, questionId, content, answerOrder,
			answeredByUser, answeredDate, language, isApproved, approvedByUser,
			approvedDate, userId, plid, attachName, folderId,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	/**
	* Sua 1 answer da co
	*/
	public static com.vportal.portlet.vfaq.model.FAQAnswer updateAnswer(
		long groupId, long answerId, java.lang.String content,
		long answerOrder, java.lang.String answeredByUser,
		java.util.Date answeredDate, java.lang.String language,
		boolean isApproved, java.lang.String approvedByUser,
		java.util.Date approvedDate, long userId, java.lang.String attachName,
		long folderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateAnswer(groupId, answerId, content, answerOrder,
			answeredByUser, answeredDate, language, isApproved, approvedByUser,
			approvedDate, userId, attachName, folderId);
	}

	public static com.vportal.portlet.vfaq.model.FAQAnswer updateAnswer(
		com.vportal.portlet.vfaq.model.FAQAnswer faqAnswer, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAnswer(faqAnswer, groupId);
	}

	/**
	* Xoa 1 answer
	*/
	public static void deleteAnswer(long answerid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteAnswer(answerid);
	}

	public static void deleteAnswer(long groupId, long userId, long answerid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteAnswer(groupId, userId, answerid);
	}

	public static com.vportal.portlet.vfaq.model.FAQAnswer approveAnswer(
		long answerId, java.lang.String approvedByUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().approveAnswer(answerId, approvedByUser);
	}

	/**
	* Huy viec hien thi 1 answer
	*/
	public static com.vportal.portlet.vfaq.model.FAQAnswer unapproveAnswer(
		long answerId, java.lang.String approvedByUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().unapproveAnswer(answerId, approvedByUser);
	}

	/**
	* Tim answer voi questionid
	*/
	public static java.util.List getByQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByQuestion(questionId);
	}

	public static int countQuestion(long questionid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countQuestion(questionid);
	}

	/**
	* Tim nhung answer thong qua trang thai duyet (approve) cua answer
	*/
	public static java.util.List getByApprove(boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByApprove(approved);
	}

	public static java.util.List getByLanguage(java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByLanguage(language);
	}

	public static com.vportal.portlet.vfaq.model.FAQAnswer getAnswer(
		long answerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnswer(answerId);
	}

	public static java.util.List getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll();
	}

	public static java.util.List getByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByGroupId(groupId);
	}

	public static java.util.List getByGroupId(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByGroupId(groupId, start, end);
	}

	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroupId(groupId);
	}

	public static java.util.List getByGroupId(long groupId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByGroupId(groupId, language);
	}

	public static java.util.List getByG_L_S(long groupId,
		java.lang.String language, boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByG_L_S(groupId, language, approved, start, end);
	}

	public static int countByG_L_S(long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countByG_L_S(groupId, language, approved);
	}

	public static int countByG_L_S_Q(long groupId, java.lang.String language,
		boolean approved, long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByG_L_S_Q(groupId, language, approved, questionId);
	}

	public static java.util.List getByParam(long groupId,
		java.lang.String language, boolean approved, java.lang.String title,
		java.lang.String sentByUser, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByParam(groupId, language, approved, title, sentByUser,
			categoryId, start, end);
	}

	public static int countByParam(long groupId, java.lang.String language,
		boolean approved, java.lang.String title, java.lang.String sentByUser,
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByParam(groupId, language, approved, title,
			sentByUser, categoryId);
	}

	public static void addAnswerResources(long answerId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAnswerResources(answerId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addAnswerResources(
		com.vportal.portlet.vfaq.model.FAQAnswer answer,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAnswerResources(answer, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addAnswerResources(long answerId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAnswerResources(answerId, communityPermissions, guestPermissions);
	}

	public static void addAnswerResources(
		com.vportal.portlet.vfaq.model.FAQAnswer answer,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addAnswerResources(answer, communityPermissions, guestPermissions);
	}

	public static java.util.List getAnswer(long groupId,
		java.lang.String language, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnswer(groupId, language, categoryId, start, end);
	}

	public static int countAnswer(long groupId, java.lang.String language,
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countAnswer(groupId, language, categoryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static FAQAnswerLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FAQAnswerLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					FAQAnswerLocalService.class.getName(), portletClassLoader);

			_service = new FAQAnswerLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(FAQAnswerLocalServiceUtil.class,
				"_service");
			MethodCache.remove(FAQAnswerLocalService.class);
		}

		return _service;
	}

	public void setService(FAQAnswerLocalService service) {
		MethodCache.remove(FAQAnswerLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(FAQAnswerLocalServiceUtil.class,
			"_service");
		MethodCache.remove(FAQAnswerLocalService.class);
	}

	private static FAQAnswerLocalService _service;
}