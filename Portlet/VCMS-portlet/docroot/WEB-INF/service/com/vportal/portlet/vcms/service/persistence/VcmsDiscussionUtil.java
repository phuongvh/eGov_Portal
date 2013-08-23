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

package com.vportal.portlet.vcms.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.vcms.model.VcmsDiscussion;

import java.util.List;

/**
 * The persistence utility for the vcms discussion service. This utility wraps {@link VcmsDiscussionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsDiscussionPersistence
 * @see VcmsDiscussionPersistenceImpl
 * @generated
 */
public class VcmsDiscussionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(VcmsDiscussion vcmsDiscussion) {
		getPersistence().clearCache(vcmsDiscussion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VcmsDiscussion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VcmsDiscussion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VcmsDiscussion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VcmsDiscussion update(VcmsDiscussion vcmsDiscussion,
		boolean merge) throws SystemException {
		return getPersistence().update(vcmsDiscussion, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VcmsDiscussion update(VcmsDiscussion vcmsDiscussion,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vcmsDiscussion, merge, serviceContext);
	}

	/**
	* Caches the vcms discussion in the entity cache if it is enabled.
	*
	* @param vcmsDiscussion the vcms discussion
	*/
	public static void cacheResult(
		com.vportal.portlet.vcms.model.VcmsDiscussion vcmsDiscussion) {
		getPersistence().cacheResult(vcmsDiscussion);
	}

	/**
	* Caches the vcms discussions in the entity cache if it is enabled.
	*
	* @param vcmsDiscussions the vcms discussions
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> vcmsDiscussions) {
		getPersistence().cacheResult(vcmsDiscussions);
	}

	/**
	* Creates a new vcms discussion with the primary key. Does not add the vcms discussion to the database.
	*
	* @param discussionId the primary key for the new vcms discussion
	* @return the new vcms discussion
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion create(
		java.lang.String discussionId) {
		return getPersistence().create(discussionId);
	}

	/**
	* Removes the vcms discussion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param discussionId the primary key of the vcms discussion
	* @return the vcms discussion that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a vcms discussion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion remove(
		java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence().remove(discussionId);
	}

	public static com.vportal.portlet.vcms.model.VcmsDiscussion updateImpl(
		com.vportal.portlet.vcms.model.VcmsDiscussion vcmsDiscussion,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vcmsDiscussion, merge);
	}

	/**
	* Returns the vcms discussion with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsDiscussionException} if it could not be found.
	*
	* @param discussionId the primary key of the vcms discussion
	* @return the vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a vcms discussion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion findByPrimaryKey(
		java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence().findByPrimaryKey(discussionId);
	}

	/**
	* Returns the vcms discussion with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param discussionId the primary key of the vcms discussion
	* @return the vcms discussion, or <code>null</code> if a vcms discussion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion fetchByPrimaryKey(
		java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(discussionId);
	}

	/**
	* Returns all the vcms discussions where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_L(groupId, language);
	}

	/**
	* Returns a range of all the vcms discussions where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @return the range of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_L(groupId, language, start, end);
	}

	/**
	* Returns an ordered range of all the vcms discussions where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L(
		long groupId, java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_L(groupId, language, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms discussion in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a matching vcms discussion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion findByP_L_First(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByP_L_First(groupId, language, orderByComparator);
	}

	/**
	* Returns the last vcms discussion in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a matching vcms discussion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion findByP_L_Last(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByP_L_Last(groupId, language, orderByComparator);
	}

	/**
	* Returns the vcms discussions before and after the current vcms discussion in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param discussionId the primary key of the current vcms discussion
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a vcms discussion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion[] findByP_L_PrevAndNext(
		java.lang.String discussionId, long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByP_L_PrevAndNext(discussionId, groupId, language,
			orderByComparator);
	}

	/**
	* Returns all the vcms discussions where groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @return the matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L_A(
		long groupId, java.lang.String language, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_L_A(groupId, language, approved);
	}

	/**
	* Returns a range of all the vcms discussions where groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @return the range of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L_A(
		long groupId, java.lang.String language, boolean approved, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_L_A(groupId, language, approved, start, end);
	}

	/**
	* Returns an ordered range of all the vcms discussions where groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L_A(
		long groupId, java.lang.String language, boolean approved, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_L_A(groupId, language, approved, start, end,
			orderByComparator);
	}

	/**
	* Returns the first vcms discussion in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a matching vcms discussion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion findByP_L_A_First(
		long groupId, java.lang.String language, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByP_L_A_First(groupId, language, approved,
			orderByComparator);
	}

	/**
	* Returns the last vcms discussion in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a matching vcms discussion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion findByP_L_A_Last(
		long groupId, java.lang.String language, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByP_L_A_Last(groupId, language, approved,
			orderByComparator);
	}

	/**
	* Returns the vcms discussions before and after the current vcms discussion in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param discussionId the primary key of the current vcms discussion
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a vcms discussion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion[] findByP_L_A_PrevAndNext(
		java.lang.String discussionId, long groupId, java.lang.String language,
		boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByP_L_A_PrevAndNext(discussionId, groupId, language,
			approved, orderByComparator);
	}

	/**
	* Returns all the vcms discussions where articleId = &#63; and groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* @param articleId the article ID
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @return the matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_P_L_A(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByA_P_L_A(articleId, groupId, language, approved);
	}

	/**
	* Returns a range of all the vcms discussions where articleId = &#63; and groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @return the range of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_P_L_A(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByA_P_L_A(articleId, groupId, language, approved,
			start, end);
	}

	/**
	* Returns an ordered range of all the vcms discussions where articleId = &#63; and groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_P_L_A(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByA_P_L_A(articleId, groupId, language, approved,
			start, end, orderByComparator);
	}

	/**
	* Returns the first vcms discussion in the ordered set where articleId = &#63; and groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a matching vcms discussion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion findByA_P_L_A_First(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByA_P_L_A_First(articleId, groupId, language, approved,
			orderByComparator);
	}

	/**
	* Returns the last vcms discussion in the ordered set where articleId = &#63; and groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a matching vcms discussion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion findByA_P_L_A_Last(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByA_P_L_A_Last(articleId, groupId, language, approved,
			orderByComparator);
	}

	/**
	* Returns the vcms discussions before and after the current vcms discussion in the ordered set where articleId = &#63; and groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param discussionId the primary key of the current vcms discussion
	* @param articleId the article ID
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a vcms discussion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion[] findByA_P_L_A_PrevAndNext(
		java.lang.String discussionId, java.lang.String articleId,
		long groupId, java.lang.String language, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByA_P_L_A_PrevAndNext(discussionId, articleId, groupId,
			language, approved, orderByComparator);
	}

	/**
	* Returns all the vcms discussions where articleId = &#63; and approved = &#63;.
	*
	* @param articleId the article ID
	* @param approved the approved
	* @return the matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_A(
		java.lang.String articleId, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA_A(articleId, approved);
	}

	/**
	* Returns a range of all the vcms discussions where articleId = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param approved the approved
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @return the range of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_A(
		java.lang.String articleId, boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA_A(articleId, approved, start, end);
	}

	/**
	* Returns an ordered range of all the vcms discussions where articleId = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param approved the approved
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_A(
		java.lang.String articleId, boolean approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByA_A(articleId, approved, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms discussion in the ordered set where articleId = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a matching vcms discussion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion findByA_A_First(
		java.lang.String articleId, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByA_A_First(articleId, approved, orderByComparator);
	}

	/**
	* Returns the last vcms discussion in the ordered set where articleId = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a matching vcms discussion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion findByA_A_Last(
		java.lang.String articleId, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByA_A_Last(articleId, approved, orderByComparator);
	}

	/**
	* Returns the vcms discussions before and after the current vcms discussion in the ordered set where articleId = &#63; and approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param discussionId the primary key of the current vcms discussion
	* @param articleId the article ID
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a vcms discussion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion[] findByA_A_PrevAndNext(
		java.lang.String discussionId, java.lang.String articleId,
		boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByA_A_PrevAndNext(discussionId, articleId, approved,
			orderByComparator);
	}

	/**
	* Returns all the vcms discussions where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticle(articleId);
	}

	/**
	* Returns a range of all the vcms discussions where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @return the range of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByArticle(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticle(articleId, start, end);
	}

	/**
	* Returns an ordered range of all the vcms discussions where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByArticle(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArticle(articleId, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms discussion in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a matching vcms discussion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion findByArticle_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence().findByArticle_First(articleId, orderByComparator);
	}

	/**
	* Returns the last vcms discussion in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a matching vcms discussion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion findByArticle_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence().findByArticle_Last(articleId, orderByComparator);
	}

	/**
	* Returns the vcms discussions before and after the current vcms discussion in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param discussionId the primary key of the current vcms discussion
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a vcms discussion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsDiscussion[] findByArticle_PrevAndNext(
		java.lang.String discussionId, java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException {
		return getPersistence()
				   .findByArticle_PrevAndNext(discussionId, articleId,
			orderByComparator);
	}

	/**
	* Returns all the vcms discussions.
	*
	* @return the vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vcms discussions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @return the range of vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vcms discussions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms discussions
	* @param end the upper bound of the range of vcms discussions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vcms discussions where groupId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByP_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByP_L(groupId, language);
	}

	/**
	* Removes all the vcms discussions where groupId = &#63; and language = &#63; and approved = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByP_L_A(long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByP_L_A(groupId, language, approved);
	}

	/**
	* Removes all the vcms discussions where articleId = &#63; and groupId = &#63; and language = &#63; and approved = &#63; from the database.
	*
	* @param articleId the article ID
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByA_P_L_A(java.lang.String articleId,
		long groupId, java.lang.String language, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByA_P_L_A(articleId, groupId, language, approved);
	}

	/**
	* Removes all the vcms discussions where articleId = &#63; and approved = &#63; from the database.
	*
	* @param articleId the article ID
	* @param approved the approved
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByA_A(java.lang.String articleId, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByA_A(articleId, approved);
	}

	/**
	* Removes all the vcms discussions where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArticle(articleId);
	}

	/**
	* Removes all the vcms discussions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vcms discussions where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the number of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByP_L(groupId, language);
	}

	/**
	* Returns the number of vcms discussions where groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @return the number of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_L_A(long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByP_L_A(groupId, language, approved);
	}

	/**
	* Returns the number of vcms discussions where articleId = &#63; and groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* @param articleId the article ID
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @return the number of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByA_P_L_A(java.lang.String articleId, long groupId,
		java.lang.String language, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByA_P_L_A(articleId, groupId, language, approved);
	}

	/**
	* Returns the number of vcms discussions where articleId = &#63; and approved = &#63;.
	*
	* @param articleId the article ID
	* @param approved the approved
	* @return the number of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByA_A(java.lang.String articleId, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByA_A(articleId, approved);
	}

	/**
	* Returns the number of vcms discussions where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArticle(articleId);
	}

	/**
	* Returns the number of vcms discussions.
	*
	* @return the number of vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VcmsDiscussionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VcmsDiscussionPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsDiscussionPersistence.class.getName());

			ReferenceRegistry.registerReference(VcmsDiscussionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VcmsDiscussionPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VcmsDiscussionUtil.class,
			"_persistence");
	}

	private static VcmsDiscussionPersistence _persistence;
}