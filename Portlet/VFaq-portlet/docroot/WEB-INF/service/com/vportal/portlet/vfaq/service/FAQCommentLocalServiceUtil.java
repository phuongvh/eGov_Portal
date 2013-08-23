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
 * The utility for the f a q comment local service. This utility wraps {@link com.vportal.portlet.vfaq.service.impl.FAQCommentLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucNN
 * @see FAQCommentLocalService
 * @see com.vportal.portlet.vfaq.service.base.FAQCommentLocalServiceBaseImpl
 * @see com.vportal.portlet.vfaq.service.impl.FAQCommentLocalServiceImpl
 * @generated
 */
public class FAQCommentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.vportal.portlet.vfaq.service.impl.FAQCommentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the f a q comment to the database. Also notifies the appropriate model listeners.
	*
	* @param faqComment the f a q comment
	* @return the f a q comment that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQComment addFAQComment(
		com.vportal.portlet.vfaq.model.FAQComment faqComment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFAQComment(faqComment);
	}

	/**
	* Creates a new f a q comment with the primary key. Does not add the f a q comment to the database.
	*
	* @param id the primary key for the new f a q comment
	* @return the new f a q comment
	*/
	public static com.vportal.portlet.vfaq.model.FAQComment createFAQComment(
		long id) {
		return getService().createFAQComment(id);
	}

	/**
	* Deletes the f a q comment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the f a q comment
	* @throws PortalException if a f a q comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteFAQComment(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFAQComment(id);
	}

	/**
	* Deletes the f a q comment from the database. Also notifies the appropriate model listeners.
	*
	* @param faqComment the f a q comment
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteFAQComment(
		com.vportal.portlet.vfaq.model.FAQComment faqComment)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFAQComment(faqComment);
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

	public static com.vportal.portlet.vfaq.model.FAQComment fetchFAQComment(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFAQComment(id);
	}

	/**
	* Returns the f a q comment with the primary key.
	*
	* @param id the primary key of the f a q comment
	* @return the f a q comment
	* @throws PortalException if a f a q comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQComment getFAQComment(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQComment(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the f a q comments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of f a q comments
	* @param end the upper bound of the range of f a q comments (not inclusive)
	* @return the range of f a q comments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vfaq.model.FAQComment> getFAQComments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQComments(start, end);
	}

	/**
	* Returns the number of f a q comments.
	*
	* @return the number of f a q comments
	* @throws SystemException if a system exception occurred
	*/
	public static int getFAQCommentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFAQCommentsCount();
	}

	/**
	* Updates the f a q comment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqComment the f a q comment
	* @return the f a q comment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQComment updateFAQComment(
		com.vportal.portlet.vfaq.model.FAQComment faqComment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFAQComment(faqComment);
	}

	/**
	* Updates the f a q comment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqComment the f a q comment
	* @param merge whether to merge the f a q comment with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the f a q comment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vfaq.model.FAQComment updateFAQComment(
		com.vportal.portlet.vfaq.model.FAQComment faqComment, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFAQComment(faqComment, merge);
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
	* Them 1 comment moi vao database
	*
	* @throws Exception
	*/
	public static com.vportal.portlet.vfaq.model.FAQComment addComment(
		long answerId, java.lang.String content, java.lang.String commName,
		java.lang.String commEmail, boolean approved,
		java.lang.String approveByUser, java.util.Date approvedDate,
		java.util.Date commDate, long userId, long plid,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws java.lang.Exception {
		return getService()
				   .addComment(answerId, content, commName, commEmail,
			approved, approveByUser, approvedDate, commDate, userId, plid,
			addCommunityPermissions, addGuestPermissions);
	}

	public static com.vportal.portlet.vfaq.model.FAQComment addComment(
		long answerId, java.lang.String content, java.lang.String commName,
		java.lang.String commEmail, boolean approved,
		java.lang.String approveByUser, java.util.Date approvedDate,
		java.util.Date commDate, long userId, long plid,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return getService()
				   .addComment(answerId, content, commName, commEmail,
			approved, approveByUser, approvedDate, commDate, userId, plid,
			communityPermissions, guestPermissions);
	}

	public static com.vportal.portlet.vfaq.model.FAQComment addComment(
		long answerId, java.lang.String content, java.lang.String commName,
		java.lang.String commEmail, boolean approved,
		java.lang.String approveByUser, java.util.Date approvedDate,
		java.util.Date commDate, long userId, long plid,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return getService()
				   .addComment(answerId, content, commName, commEmail,
			approved, approveByUser, approvedDate, commDate, userId, plid,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	/**
	* Sua 1 comment da co
	*/
	public static com.vportal.portlet.vfaq.model.FAQComment updateComment(
		long commentId, java.lang.String content, boolean approved,
		java.lang.String approveByUser, java.util.Date approvedDate, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateComment(commentId, content, approved, approveByUser,
			approvedDate, userId);
	}

	public static com.vportal.portlet.vfaq.model.FAQComment updateComment(
		long groupId, long commentId, java.lang.String content,
		boolean approved, java.lang.String approveByUser,
		java.util.Date approvedDate, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateComment(groupId, commentId, content, approved,
			approveByUser, approvedDate, userId);
	}

	public static com.vportal.portlet.vfaq.model.FAQComment getComment(
		long commentid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getComment(commentid);
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

	public static void deleteComment(long commentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteComment(commentId);
	}

	public static com.vportal.portlet.vfaq.model.FAQComment unapproved(
		long commentid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().unapproved(commentid);
	}

	public static java.util.List getByApproved(boolean approved)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByApproved(approved);
	}

	public static java.util.List getByAnswer(long answerid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByAnswer(answerid);
	}

	public static void addCommentResources(long commentId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addCommentResources(commentId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addCommentResources(
		com.vportal.portlet.vfaq.model.FAQComment comment,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addCommentResources(comment, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addCommentResources(long commentId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addCommentResources(commentId, communityPermissions,
			guestPermissions);
	}

	public static void addCommentResources(
		com.vportal.portlet.vfaq.model.FAQComment comment,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addCommentResources(comment, communityPermissions, guestPermissions);
	}

	public static java.util.List getByPara(long groupId,
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByPara(groupId, title, start, end);
	}

	public static int countByPara(long groupId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countByPara(groupId, title);
	}

	public static void removeComment(long groupId, long commentid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeComment(groupId, commentid);
	}

	public static void clearService() {
		_service = null;
	}

	public static FAQCommentLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FAQCommentLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					FAQCommentLocalService.class.getName(), portletClassLoader);

			_service = new FAQCommentLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(FAQCommentLocalServiceUtil.class,
				"_service");
			MethodCache.remove(FAQCommentLocalService.class);
		}

		return _service;
	}

	public void setService(FAQCommentLocalService service) {
		MethodCache.remove(FAQCommentLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(FAQCommentLocalServiceUtil.class,
			"_service");
		MethodCache.remove(FAQCommentLocalService.class);
	}

	private static FAQCommentLocalService _service;
}