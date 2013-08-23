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

import com.vportal.portlet.vcms.model.VcmsAttachedMessage;

import java.util.List;

/**
 * The persistence utility for the vcms attached message service. This utility wraps {@link VcmsAttachedMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsAttachedMessagePersistence
 * @see VcmsAttachedMessagePersistenceImpl
 * @generated
 */
public class VcmsAttachedMessageUtil {
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
	public static void clearCache(VcmsAttachedMessage vcmsAttachedMessage) {
		getPersistence().clearCache(vcmsAttachedMessage);
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
	public static List<VcmsAttachedMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VcmsAttachedMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VcmsAttachedMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VcmsAttachedMessage update(
		VcmsAttachedMessage vcmsAttachedMessage, boolean merge)
		throws SystemException {
		return getPersistence().update(vcmsAttachedMessage, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VcmsAttachedMessage update(
		VcmsAttachedMessage vcmsAttachedMessage, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(vcmsAttachedMessage, merge, serviceContext);
	}

	/**
	* Caches the vcms attached message in the entity cache if it is enabled.
	*
	* @param vcmsAttachedMessage the vcms attached message
	*/
	public static void cacheResult(
		com.vportal.portlet.vcms.model.VcmsAttachedMessage vcmsAttachedMessage) {
		getPersistence().cacheResult(vcmsAttachedMessage);
	}

	/**
	* Caches the vcms attached messages in the entity cache if it is enabled.
	*
	* @param vcmsAttachedMessages the vcms attached messages
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> vcmsAttachedMessages) {
		getPersistence().cacheResult(vcmsAttachedMessages);
	}

	/**
	* Creates a new vcms attached message with the primary key. Does not add the vcms attached message to the database.
	*
	* @param messageId the primary key for the new vcms attached message
	* @return the new vcms attached message
	*/
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage create(
		java.lang.String messageId) {
		return getPersistence().create(messageId);
	}

	/**
	* Removes the vcms attached message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the vcms attached message
	* @return the vcms attached message that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage remove(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence().remove(messageId);
	}

	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage updateImpl(
		com.vportal.portlet.vcms.model.VcmsAttachedMessage vcmsAttachedMessage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vcmsAttachedMessage, merge);
	}

	/**
	* Returns the vcms attached message with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException} if it could not be found.
	*
	* @param messageId the primary key of the vcms attached message
	* @return the vcms attached message
	* @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage findByPrimaryKey(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence().findByPrimaryKey(messageId);
	}

	/**
	* Returns the vcms attached message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the vcms attached message
	* @return the vcms attached message, or <code>null</code> if a vcms attached message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage fetchByPrimaryKey(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(messageId);
	}

	/**
	* Returns all the vcms attached messages where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticle(articleId);
	}

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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByArticle(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticle(articleId, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByArticle(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArticle(articleId, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage findByArticle_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence().findByArticle_First(articleId, orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage findByArticle_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence().findByArticle_Last(articleId, orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage[] findByArticle_PrevAndNext(
		java.lang.String messageId, java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence()
				   .findByArticle_PrevAndNext(messageId, articleId,
			orderByComparator);
	}

	/**
	* Returns all the vcms attached messages where readMessage = &#63;.
	*
	* @param readMessage the read message
	* @return the matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByUnRead(
		boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnRead(readMessage);
	}

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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByUnRead(
		boolean readMessage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnRead(readMessage, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByUnRead(
		boolean readMessage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUnRead(readMessage, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage findByUnRead_First(
		boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence()
				   .findByUnRead_First(readMessage, orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage findByUnRead_Last(
		boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence().findByUnRead_Last(readMessage, orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage[] findByUnRead_PrevAndNext(
		java.lang.String messageId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence()
				   .findByUnRead_PrevAndNext(messageId, readMessage,
			orderByComparator);
	}

	/**
	* Returns all the vcms attached messages where articleId = &#63; and readMessage = &#63;.
	*
	* @param articleId the article ID
	* @param readMessage the read message
	* @return the matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByA_R(
		java.lang.String articleId, boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA_R(articleId, readMessage);
	}

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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByA_R(
		java.lang.String articleId, boolean readMessage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA_R(articleId, readMessage, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByA_R(
		java.lang.String articleId, boolean readMessage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByA_R(articleId, readMessage, start, end,
			orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage findByA_R_First(
		java.lang.String articleId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence()
				   .findByA_R_First(articleId, readMessage, orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage findByA_R_Last(
		java.lang.String articleId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence()
				   .findByA_R_Last(articleId, readMessage, orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage[] findByA_R_PrevAndNext(
		java.lang.String messageId, java.lang.String articleId,
		boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence()
				   .findByA_R_PrevAndNext(messageId, articleId, readMessage,
			orderByComparator);
	}

	/**
	* Returns all the vcms attached messages where groupId = &#63; and readMessage = &#63;.
	*
	* @param groupId the group ID
	* @param readMessage the read message
	* @return the matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByG_R(
		long groupId, boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_R(groupId, readMessage);
	}

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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_R(groupId, readMessage, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_R(groupId, readMessage, start, end,
			orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage findByG_R_First(
		long groupId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence()
				   .findByG_R_First(groupId, readMessage, orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage findByG_R_Last(
		long groupId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence()
				   .findByG_R_Last(groupId, readMessage, orderByComparator);
	}

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
	public static com.vportal.portlet.vcms.model.VcmsAttachedMessage[] findByG_R_PrevAndNext(
		java.lang.String messageId, long groupId, boolean readMessage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException {
		return getPersistence()
				   .findByG_R_PrevAndNext(messageId, groupId, readMessage,
			orderByComparator);
	}

	/**
	* Returns all the vcms attached messages.
	*
	* @return the vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsAttachedMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vcms attached messages where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArticle(articleId);
	}

	/**
	* Removes all the vcms attached messages where readMessage = &#63; from the database.
	*
	* @param readMessage the read message
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnRead(boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnRead(readMessage);
	}

	/**
	* Removes all the vcms attached messages where articleId = &#63; and readMessage = &#63; from the database.
	*
	* @param articleId the article ID
	* @param readMessage the read message
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByA_R(java.lang.String articleId,
		boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByA_R(articleId, readMessage);
	}

	/**
	* Removes all the vcms attached messages where groupId = &#63; and readMessage = &#63; from the database.
	*
	* @param groupId the group ID
	* @param readMessage the read message
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_R(long groupId, boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_R(groupId, readMessage);
	}

	/**
	* Removes all the vcms attached messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vcms attached messages where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArticle(articleId);
	}

	/**
	* Returns the number of vcms attached messages where readMessage = &#63;.
	*
	* @param readMessage the read message
	* @return the number of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnRead(boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnRead(readMessage);
	}

	/**
	* Returns the number of vcms attached messages where articleId = &#63; and readMessage = &#63;.
	*
	* @param articleId the article ID
	* @param readMessage the read message
	* @return the number of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByA_R(java.lang.String articleId, boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByA_R(articleId, readMessage);
	}

	/**
	* Returns the number of vcms attached messages where groupId = &#63; and readMessage = &#63;.
	*
	* @param groupId the group ID
	* @param readMessage the read message
	* @return the number of matching vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_R(long groupId, boolean readMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_R(groupId, readMessage);
	}

	/**
	* Returns the number of vcms attached messages.
	*
	* @return the number of vcms attached messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VcmsAttachedMessagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VcmsAttachedMessagePersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsAttachedMessagePersistence.class.getName());

			ReferenceRegistry.registerReference(VcmsAttachedMessageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VcmsAttachedMessagePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VcmsAttachedMessageUtil.class,
			"_persistence");
	}

	private static VcmsAttachedMessagePersistence _persistence;
}