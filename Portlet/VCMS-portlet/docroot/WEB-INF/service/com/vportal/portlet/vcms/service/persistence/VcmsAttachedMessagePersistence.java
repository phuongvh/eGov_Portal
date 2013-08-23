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

import com.vportal.portlet.vcms.model.VcmsAttachedMessage;

/**
 * The persistence interface for the vcms attached message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsAttachedMessagePersistenceImpl
 * @see VcmsAttachedMessageUtil
 * @generated
 */
public interface VcmsAttachedMessagePersistence extends BasePersistence<VcmsAttachedMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VcmsAttachedMessageUtil} to access the vcms attached message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vcms attached message in the entity cache if it is enabled.
	*
	* @param vcmsAttachedMessage the vcms attached message
	*/
	public void cacheResult(
		com.vportal.portlet.vcms.model.VcmsAttachedMessage vcmsAttachedMessage);

	/**
	* Caches the vcms attached messages in the entity cache if it is enabled.
	*
	* @param vcmsAttachedMessages the vcms attached messages
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> vcmsAttachedMessages);

	/**
	* Creates a new vcms attached message with the primary key. Does not add the vcms attached message to the database.
	*
	* @param messageId the primary key for the new vcms attached message
	* @return the new vcms attached message
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage create(
		java.lang.String messageId);

	/**
	* Removes the vcms attached message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the vcms attached message
	* @return the vcms attached message that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage remove(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	public com.vportal.portlet.vcms.model.VcmsAttachedMessage updateImpl(
		com.vportal.portlet.vcms.model.VcmsAttachedMessage vcmsAttachedMessage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms attached message with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException} if it could not be found.
	*
	* @param messageId the primary key of the vcms attached message
	* @return the vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage findByPrimaryKey(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns the vcms attached message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the vcms attached message
	* @return the vcms attached message, or <code>null</code> if a vcms attached message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage fetchByPrimaryKey(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vcms attached messages where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms attached messages where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms attached messages
	* @param end the upper bound of the range of vcms attached messages (not inclusive)
	* @return the range of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByArticle(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms attached messages where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms attached messages
	* @param end the upper bound of the range of vcms attached messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByArticle(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms attached message in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage findByArticle_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns the last vcms attached message in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage findByArticle_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns the vcms attached messages before and after the current vcms attached message in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param messageId the primary key of the current vcms attached message
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage[] findByArticle_PrevAndNext(
		java.lang.String messageId, java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns all the vcms attached messages where readMessage = &#63;.
	*
	* @param readMessage the read message
	* @return the matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByUnRead(
		boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms attached messages where readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param readMessage the read message
	* @param start the lower bound of the range of vcms attached messages
	* @param end the upper bound of the range of vcms attached messages (not inclusive)
	* @return the range of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByUnRead(
		boolean readMessage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms attached messages where readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param readMessage the read message
	* @param start the lower bound of the range of vcms attached messages
	* @param end the upper bound of the range of vcms attached messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByUnRead(
		boolean readMessage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms attached message in the ordered set where readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param readMessage the read message
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage findByUnRead_First(
		boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns the last vcms attached message in the ordered set where readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param readMessage the read message
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage findByUnRead_Last(
		boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns the vcms attached messages before and after the current vcms attached message in the ordered set where readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param messageId the primary key of the current vcms attached message
	* @param readMessage the read message
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage[] findByUnRead_PrevAndNext(
		java.lang.String messageId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns all the vcms attached messages where articleId = &#63; and readMessage = &#63;.
	*
	* @param articleId the article ID
	* @param readMessage the read message
	* @return the matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByA_R(
		java.lang.String articleId, boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms attached messages where articleId = &#63; and readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param readMessage the read message
	* @param start the lower bound of the range of vcms attached messages
	* @param end the upper bound of the range of vcms attached messages (not inclusive)
	* @return the range of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByA_R(
		java.lang.String articleId, boolean readMessage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms attached messages where articleId = &#63; and readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param readMessage the read message
	* @param start the lower bound of the range of vcms attached messages
	* @param end the upper bound of the range of vcms attached messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByA_R(
		java.lang.String articleId, boolean readMessage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param readMessage the read message
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage findByA_R_First(
		java.lang.String articleId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns the last vcms attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param readMessage the read message
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage findByA_R_Last(
		java.lang.String articleId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns the vcms attached messages before and after the current vcms attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param messageId the primary key of the current vcms attached message
	* @param articleId the article ID
	* @param readMessage the read message
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage[] findByA_R_PrevAndNext(
		java.lang.String messageId, java.lang.String articleId,
		boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns all the vcms attached messages where groupId = &#63; and readMessage = &#63;.
	*
	* @param groupId the group ID
	* @param readMessage the read message
	* @return the matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByG_R(
		long groupId, boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms attached messages where groupId = &#63; and readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param readMessage the read message
	* @param start the lower bound of the range of vcms attached messages
	* @param end the upper bound of the range of vcms attached messages (not inclusive)
	* @return the range of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms attached messages where groupId = &#63; and readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param readMessage the read message
	* @param start the lower bound of the range of vcms attached messages
	* @param end the upper bound of the range of vcms attached messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param readMessage the read message
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage findByG_R_First(
		long groupId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns the last vcms attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param readMessage the read message
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage findByG_R_Last(
		long groupId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns the vcms attached messages before and after the current vcms attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param messageId the primary key of the current vcms attached message
	* @param groupId the group ID
	* @param readMessage the read message
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsAttachedMessage[] findByG_R_PrevAndNext(
		java.lang.String messageId, long groupId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;

	/**
	* Returns all the vcms attached messages.
	*
	* @return the vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms attached messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms attached messages
	* @param end the upper bound of the range of vcms attached messages (not inclusive)
	* @return the range of vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms attached messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms attached messages
	* @param end the upper bound of the range of vcms attached messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms attached messages where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms attached messages where readMessage = &#63; from the database.
	*
	* @param readMessage the read message
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUnRead(boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms attached messages where articleId = &#63; and readMessage = &#63; from the database.
	*
	* @param articleId the article ID
	* @param readMessage the read message
	* @throws SystemException if a system exception occurred
	*/
	public void removeByA_R(java.lang.String articleId, boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms attached messages where groupId = &#63; and readMessage = &#63; from the database.
	*
	* @param groupId the group ID
	* @param readMessage the read message
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_R(long groupId, boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms attached messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms attached messages where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms attached messages where readMessage = &#63;.
	*
	* @param readMessage the read message
	* @return the number of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByUnRead(boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms attached messages where articleId = &#63; and readMessage = &#63;.
	*
	* @param articleId the article ID
	* @param readMessage the read message
	* @return the number of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByA_R(java.lang.String articleId, boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms attached messages where groupId = &#63; and readMessage = &#63;.
	*
	* @param groupId the group ID
	* @param readMessage the read message
	* @return the number of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_R(long groupId, boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms attached messages.
	*
	* @return the number of vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}