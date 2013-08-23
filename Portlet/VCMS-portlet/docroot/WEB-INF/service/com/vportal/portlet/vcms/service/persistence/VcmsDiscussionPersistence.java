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

import com.liferay.portal.service.persistence.BasePersistence;

import com.vportal.portlet.vcms.model.VcmsDiscussion;

/**
 * The persistence interface for the vcms discussion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsDiscussionPersistenceImpl
 * @see VcmsDiscussionUtil
 * @generated
 */
public interface VcmsDiscussionPersistence extends BasePersistence<VcmsDiscussion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VcmsDiscussionUtil} to access the vcms discussion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vcms discussion in the entity cache if it is enabled.
	*
	* @param vcmsDiscussion the vcms discussion
	*/
	public void cacheResult(
		com.vportal.portlet.vcms.model.VcmsDiscussion vcmsDiscussion);

	/**
	* Caches the vcms discussions in the entity cache if it is enabled.
	*
	* @param vcmsDiscussions the vcms discussions
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> vcmsDiscussions);

	/**
	* Creates a new vcms discussion with the primary key. Does not add the vcms discussion to the database.
	*
	* @param discussionId the primary key for the new vcms discussion
	* @return the new vcms discussion
	*/
	public com.vportal.portlet.vcms.model.VcmsDiscussion create(
		java.lang.String discussionId);

	/**
	* Removes the vcms discussion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param discussionId the primary key of the vcms discussion
	* @return the vcms discussion that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a vcms discussion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsDiscussion remove(
		java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

	public com.vportal.portlet.vcms.model.VcmsDiscussion updateImpl(
		com.vportal.portlet.vcms.model.VcmsDiscussion vcmsDiscussion,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms discussion with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsDiscussionException} if it could not be found.
	*
	* @param discussionId the primary key of the vcms discussion
	* @return the vcms discussion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsDiscussionException if a vcms discussion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsDiscussion findByPrimaryKey(
		java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

	/**
	* Returns the vcms discussion with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param discussionId the primary key of the vcms discussion
	* @return the vcms discussion, or <code>null</code> if a vcms discussion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsDiscussion fetchByPrimaryKey(
		java.lang.String discussionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vcms discussions where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L(
		long groupId, java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion findByP_L_First(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion findByP_L_Last(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion[] findByP_L_PrevAndNext(
		java.lang.String discussionId, long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

	/**
	* Returns all the vcms discussions where groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @return the matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L_A(
		long groupId, java.lang.String language, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L_A(
		long groupId, java.lang.String language, boolean approved, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByP_L_A(
		long groupId, java.lang.String language, boolean approved, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion findByP_L_A_First(
		long groupId, java.lang.String language, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion findByP_L_A_Last(
		long groupId, java.lang.String language, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion[] findByP_L_A_PrevAndNext(
		java.lang.String discussionId, long groupId, java.lang.String language,
		boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_P_L_A(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_P_L_A(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_P_L_A(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion findByA_P_L_A_First(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion findByA_P_L_A_Last(
		java.lang.String articleId, long groupId, java.lang.String language,
		boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion[] findByA_P_L_A_PrevAndNext(
		java.lang.String discussionId, java.lang.String articleId,
		long groupId, java.lang.String language, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

	/**
	* Returns all the vcms discussions where articleId = &#63; and approved = &#63;.
	*
	* @param articleId the article ID
	* @param approved the approved
	* @return the matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_A(
		java.lang.String articleId, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_A(
		java.lang.String articleId, boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByA_A(
		java.lang.String articleId, boolean approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion findByA_A_First(
		java.lang.String articleId, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion findByA_A_Last(
		java.lang.String articleId, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion[] findByA_A_PrevAndNext(
		java.lang.String discussionId, java.lang.String articleId,
		boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

	/**
	* Returns all the vcms discussions where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByArticle(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findByArticle(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion findByArticle_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion findByArticle_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

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
	public com.vportal.portlet.vcms.model.VcmsDiscussion[] findByArticle_PrevAndNext(
		java.lang.String discussionId, java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsDiscussionException;

	/**
	* Returns all the vcms discussions.
	*
	* @return the vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vcms.model.VcmsDiscussion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms discussions where groupId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByP_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms discussions where groupId = &#63; and language = &#63; and approved = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @throws SystemException if a system exception occurred
	*/
	public void removeByP_L_A(long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms discussions where articleId = &#63; and groupId = &#63; and language = &#63; and approved = &#63; from the database.
	*
	* @param articleId the article ID
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @throws SystemException if a system exception occurred
	*/
	public void removeByA_P_L_A(java.lang.String articleId, long groupId,
		java.lang.String language, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms discussions where articleId = &#63; and approved = &#63; from the database.
	*
	* @param articleId the article ID
	* @param approved the approved
	* @throws SystemException if a system exception occurred
	*/
	public void removeByA_A(java.lang.String articleId, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms discussions where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms discussions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms discussions where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the number of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public int countByP_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms discussions where groupId = &#63; and language = &#63; and approved = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param approved the approved
	* @return the number of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public int countByP_L_A(long groupId, java.lang.String language,
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByA_P_L_A(java.lang.String articleId, long groupId,
		java.lang.String language, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms discussions where articleId = &#63; and approved = &#63;.
	*
	* @param articleId the article ID
	* @param approved the approved
	* @return the number of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public int countByA_A(java.lang.String articleId, boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms discussions where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public int countByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms discussions.
	*
	* @return the number of vcms discussions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}