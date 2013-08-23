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

package com.vportal.portlet.vdoc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.vdoc.model.vdocDocument;

import java.util.List;

/**
 * The persistence utility for the vdoc document service. This utility wraps {@link vdocDocumentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocDocumentPersistence
 * @see vdocDocumentPersistenceImpl
 * @generated
 */
public class vdocDocumentUtil {
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
	public static void clearCache(vdocDocument vdocDocument) {
		getPersistence().clearCache(vdocDocument);
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
	public static List<vdocDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<vdocDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<vdocDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static vdocDocument update(vdocDocument vdocDocument, boolean merge)
		throws SystemException {
		return getPersistence().update(vdocDocument, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static vdocDocument update(vdocDocument vdocDocument, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vdocDocument, merge, serviceContext);
	}

	/**
	* Caches the vdoc document in the entity cache if it is enabled.
	*
	* @param vdocDocument the vdoc document
	*/
	public static void cacheResult(
		com.vportal.portlet.vdoc.model.vdocDocument vdocDocument) {
		getPersistence().cacheResult(vdocDocument);
	}

	/**
	* Caches the vdoc documents in the entity cache if it is enabled.
	*
	* @param vdocDocuments the vdoc documents
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> vdocDocuments) {
		getPersistence().cacheResult(vdocDocuments);
	}

	/**
	* Creates a new vdoc document with the primary key. Does not add the vdoc document to the database.
	*
	* @param docId the primary key for the new vdoc document
	* @return the new vdoc document
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument create(
		java.lang.String docId) {
		return getPersistence().create(docId);
	}

	/**
	* Removes the vdoc document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param docId the primary key of the vdoc document
	* @return the vdoc document that was removed
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument remove(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence().remove(docId);
	}

	public static com.vportal.portlet.vdoc.model.vdocDocument updateImpl(
		com.vportal.portlet.vdoc.model.vdocDocument vdocDocument, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vdocDocument, merge);
	}

	/**
	* Returns the vdoc document with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocDocumentException} if it could not be found.
	*
	* @param docId the primary key of the vdoc document
	* @return the vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByPrimaryKey(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence().findByPrimaryKey(docId);
	}

	/**
	* Returns the vdoc document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param docId the primary key of the vdoc document
	* @return the vdoc document, or <code>null</code> if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument fetchByPrimaryKey(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(docId);
	}

	/**
	* Returns the vdoc document where fieldId = &#63; and docId = &#63; or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocDocumentException} if it could not be found.
	*
	* @param fieldId the field ID
	* @param docId the doc ID
	* @return the matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByField_Doc(
		java.lang.String fieldId, java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence().findByField_Doc(fieldId, docId);
	}

	/**
	* Returns the vdoc document where fieldId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fieldId the field ID
	* @param docId the doc ID
	* @return the matching vdoc document, or <code>null</code> if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument fetchByField_Doc(
		java.lang.String fieldId, java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByField_Doc(fieldId, docId);
	}

	/**
	* Returns the vdoc document where fieldId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fieldId the field ID
	* @param docId the doc ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vdoc document, or <code>null</code> if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument fetchByField_Doc(
		java.lang.String fieldId, java.lang.String docId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByField_Doc(fieldId, docId, retrieveFromCache);
	}

	/**
	* Returns all the vdoc documents where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(groupId, language);
	}

	/**
	* Returns a range of all the vdoc documents where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @return the range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(groupId, language, start, end);
	}

	/**
	* Returns an ordered range of all the vdoc documents where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L(
		long groupId, java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L(groupId, language, start, end, orderByComparator);
	}

	/**
	* Returns the first vdoc document in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_First(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_First(groupId, language, orderByComparator);
	}

	/**
	* Returns the last vdoc document in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_Last(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_Last(groupId, language, orderByComparator);
	}

	/**
	* Returns the vdoc documents before and after the current vdoc document in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the primary key of the current vdoc document
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_PrevAndNext(docId, groupId, language,
			orderByComparator);
	}

	/**
	* Returns all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S(
		long groupId, java.lang.String language, int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L_S(groupId, language, statusDoc);
	}

	/**
	* Returns a range of all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @return the range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S(
		long groupId, java.lang.String language, int statusDoc, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_S(groupId, language, statusDoc, start, end);
	}

	/**
	* Returns an ordered range of all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S(
		long groupId, java.lang.String language, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_S(groupId, language, statusDoc, start, end,
			orderByComparator);
	}

	/**
	* Returns the first vdoc document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_First(
		long groupId, java.lang.String language, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_S_First(groupId, language, statusDoc,
			orderByComparator);
	}

	/**
	* Returns the last vdoc document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_Last(
		long groupId, java.lang.String language, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_S_Last(groupId, language, statusDoc,
			orderByComparator);
	}

	/**
	* Returns the vdoc documents before and after the current vdoc document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the primary key of the current vdoc document
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_S_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_S_PrevAndNext(docId, groupId, language,
			statusDoc, orderByComparator);
	}

	/**
	* Returns all the vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F(
		long groupId, java.lang.String language, java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L_F(groupId, language, fieldId);
	}

	/**
	* Returns a range of all the vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @return the range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_F(groupId, language, fieldId, start, end);
	}

	/**
	* Returns an ordered range of all the vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_F(groupId, language, fieldId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first vdoc document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_F_First(
		long groupId, java.lang.String language, java.lang.String fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_F_First(groupId, language, fieldId,
			orderByComparator);
	}

	/**
	* Returns the last vdoc document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_F_Last(
		long groupId, java.lang.String language, java.lang.String fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_F_Last(groupId, language, fieldId,
			orderByComparator);
	}

	/**
	* Returns the vdoc documents before and after the current vdoc document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the primary key of the current vdoc document
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_F_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		java.lang.String fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_F_PrevAndNext(docId, groupId, language, fieldId,
			orderByComparator);
	}

	/**
	* Returns all the vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param statusDoc the status doc
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F_S(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_F_S(groupId, language, fieldId, statusDoc);
	}

	/**
	* Returns a range of all the vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param statusDoc the status doc
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @return the range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F_S(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int statusDoc, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_F_S(groupId, language, fieldId, statusDoc, start,
			end);
	}

	/**
	* Returns an ordered range of all the vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param statusDoc the status doc
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F_S(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_F_S(groupId, language, fieldId, statusDoc, start,
			end, orderByComparator);
	}

	/**
	* Returns the first vdoc document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param statusDoc the status doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_F_S_First(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_F_S_First(groupId, language, fieldId, statusDoc,
			orderByComparator);
	}

	/**
	* Returns the last vdoc document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param statusDoc the status doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_F_S_Last(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_F_S_Last(groupId, language, fieldId, statusDoc,
			orderByComparator);
	}

	/**
	* Returns the vdoc documents before and after the current vdoc document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the primary key of the current vdoc document
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param statusDoc the status doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_F_S_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		java.lang.String fieldId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_F_S_PrevAndNext(docId, groupId, language,
			fieldId, statusDoc, orderByComparator);
	}

	/**
	* Returns all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; and typeDoc = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param typeDoc the type doc
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_T(
		long groupId, java.lang.String language, int statusDoc, int typeDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_S_T(groupId, language, statusDoc, typeDoc);
	}

	/**
	* Returns a range of all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; and typeDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param typeDoc the type doc
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @return the range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_T(
		long groupId, java.lang.String language, int statusDoc, int typeDoc,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_S_T(groupId, language, statusDoc, typeDoc, start,
			end);
	}

	/**
	* Returns an ordered range of all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; and typeDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param typeDoc the type doc
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_T(
		long groupId, java.lang.String language, int statusDoc, int typeDoc,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_S_T(groupId, language, statusDoc, typeDoc, start,
			end, orderByComparator);
	}

	/**
	* Returns the first vdoc document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63; and typeDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param typeDoc the type doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_T_First(
		long groupId, java.lang.String language, int statusDoc, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_S_T_First(groupId, language, statusDoc, typeDoc,
			orderByComparator);
	}

	/**
	* Returns the last vdoc document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63; and typeDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param typeDoc the type doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_T_Last(
		long groupId, java.lang.String language, int statusDoc, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_S_T_Last(groupId, language, statusDoc, typeDoc,
			orderByComparator);
	}

	/**
	* Returns the vdoc documents before and after the current vdoc document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63; and typeDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the primary key of the current vdoc document
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param typeDoc the type doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_S_T_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		int statusDoc, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_S_T_PrevAndNext(docId, groupId, language,
			statusDoc, typeDoc, orderByComparator);
	}

	/**
	* Returns all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; and fieldId = &#63; and typeDoc = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param fieldId the field ID
	* @param typeDoc the type doc
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_F_T(
		long groupId, java.lang.String language, int statusDoc,
		java.lang.String fieldId, int typeDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_S_F_T(groupId, language, statusDoc, fieldId,
			typeDoc);
	}

	/**
	* Returns a range of all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; and fieldId = &#63; and typeDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param fieldId the field ID
	* @param typeDoc the type doc
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @return the range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_F_T(
		long groupId, java.lang.String language, int statusDoc,
		java.lang.String fieldId, int typeDoc, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_S_F_T(groupId, language, statusDoc, fieldId,
			typeDoc, start, end);
	}

	/**
	* Returns an ordered range of all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; and fieldId = &#63; and typeDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param fieldId the field ID
	* @param typeDoc the type doc
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_F_T(
		long groupId, java.lang.String language, int statusDoc,
		java.lang.String fieldId, int typeDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_S_F_T(groupId, language, statusDoc, fieldId,
			typeDoc, start, end, orderByComparator);
	}

	/**
	* Returns the first vdoc document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63; and fieldId = &#63; and typeDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param fieldId the field ID
	* @param typeDoc the type doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_F_T_First(
		long groupId, java.lang.String language, int statusDoc,
		java.lang.String fieldId, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_S_F_T_First(groupId, language, statusDoc,
			fieldId, typeDoc, orderByComparator);
	}

	/**
	* Returns the last vdoc document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63; and fieldId = &#63; and typeDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param fieldId the field ID
	* @param typeDoc the type doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_F_T_Last(
		long groupId, java.lang.String language, int statusDoc,
		java.lang.String fieldId, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_S_F_T_Last(groupId, language, statusDoc, fieldId,
			typeDoc, orderByComparator);
	}

	/**
	* Returns the vdoc documents before and after the current vdoc document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63; and fieldId = &#63; and typeDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the primary key of the current vdoc document
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param fieldId the field ID
	* @param typeDoc the type doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_S_F_T_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		int statusDoc, java.lang.String fieldId, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByG_L_S_F_T_PrevAndNext(docId, groupId, language,
			statusDoc, fieldId, typeDoc, orderByComparator);
	}

	/**
	* Returns all the vdoc documents where statusDoc = &#63;.
	*
	* @param statusDoc the status doc
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByStatus(
		int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(statusDoc);
	}

	/**
	* Returns a range of all the vdoc documents where statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param statusDoc the status doc
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @return the range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByStatus(
		int statusDoc, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(statusDoc, start, end);
	}

	/**
	* Returns an ordered range of all the vdoc documents where statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param statusDoc the status doc
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByStatus(
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(statusDoc, start, end, orderByComparator);
	}

	/**
	* Returns the first vdoc document in the ordered set where statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param statusDoc the status doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByStatus_First(
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence().findByStatus_First(statusDoc, orderByComparator);
	}

	/**
	* Returns the last vdoc document in the ordered set where statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param statusDoc the status doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByStatus_Last(
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence().findByStatus_Last(statusDoc, orderByComparator);
	}

	/**
	* Returns the vdoc documents before and after the current vdoc document in the ordered set where statusDoc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the primary key of the current vdoc document
	* @param statusDoc the status doc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument[] findByStatus_PrevAndNext(
		java.lang.String docId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByStatus_PrevAndNext(docId, statusDoc, orderByComparator);
	}

	/**
	* Returns all the vdoc documents where position = &#63;.
	*
	* @param position the position
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByPosition(
		int position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPosition(position);
	}

	/**
	* Returns a range of all the vdoc documents where position = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param position the position
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @return the range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByPosition(
		int position, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPosition(position, start, end);
	}

	/**
	* Returns an ordered range of all the vdoc documents where position = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param position the position
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByPosition(
		int position, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPosition(position, start, end, orderByComparator);
	}

	/**
	* Returns the first vdoc document in the ordered set where position = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param position the position
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByPosition_First(
		int position,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence().findByPosition_First(position, orderByComparator);
	}

	/**
	* Returns the last vdoc document in the ordered set where position = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param position the position
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument findByPosition_Last(
		int position,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence().findByPosition_Last(position, orderByComparator);
	}

	/**
	* Returns the vdoc documents before and after the current vdoc document in the ordered set where position = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docId the primary key of the current vdoc document
	* @param position the position
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vdoc.model.vdocDocument[] findByPosition_PrevAndNext(
		java.lang.String docId, int position,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		return getPersistence()
				   .findByPosition_PrevAndNext(docId, position,
			orderByComparator);
	}

	/**
	* Returns all the vdoc documents.
	*
	* @return the vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vdoc documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @return the range of vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vdoc documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vdoc documents
	* @param end the upper bound of the range of vdoc documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the vdoc document where fieldId = &#63; and docId = &#63; from the database.
	*
	* @param fieldId the field ID
	* @param docId the doc ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByField_Doc(java.lang.String fieldId,
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException {
		getPersistence().removeByField_Doc(fieldId, docId);
	}

	/**
	* Removes all the vdoc documents where groupId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L(groupId, language);
	}

	/**
	* Removes all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L_S(long groupId, java.lang.String language,
		int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L_S(groupId, language, statusDoc);
	}

	/**
	* Removes all the vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L_F(long groupId, java.lang.String language,
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L_F(groupId, language, fieldId);
	}

	/**
	* Removes all the vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param statusDoc the status doc
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L_F_S(long groupId, java.lang.String language,
		java.lang.String fieldId, int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L_F_S(groupId, language, fieldId, statusDoc);
	}

	/**
	* Removes all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; and typeDoc = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param typeDoc the type doc
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L_S_T(long groupId, java.lang.String language,
		int statusDoc, int typeDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L_S_T(groupId, language, statusDoc, typeDoc);
	}

	/**
	* Removes all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; and fieldId = &#63; and typeDoc = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param fieldId the field ID
	* @param typeDoc the type doc
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L_S_F_T(long groupId,
		java.lang.String language, int statusDoc, java.lang.String fieldId,
		int typeDoc) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByG_L_S_F_T(groupId, language, statusDoc, fieldId, typeDoc);
	}

	/**
	* Removes all the vdoc documents where statusDoc = &#63; from the database.
	*
	* @param statusDoc the status doc
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(statusDoc);
	}

	/**
	* Removes all the vdoc documents where position = &#63; from the database.
	*
	* @param position the position
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPosition(int position)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPosition(position);
	}

	/**
	* Removes all the vdoc documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vdoc documents where fieldId = &#63; and docId = &#63;.
	*
	* @param fieldId the field ID
	* @param docId the doc ID
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByField_Doc(java.lang.String fieldId,
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByField_Doc(fieldId, docId);
	}

	/**
	* Returns the number of vdoc documents where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L(groupId, language);
	}

	/**
	* Returns the number of vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L_S(long groupId, java.lang.String language,
		int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L_S(groupId, language, statusDoc);
	}

	/**
	* Returns the number of vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L_F(long groupId, java.lang.String language,
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L_F(groupId, language, fieldId);
	}

	/**
	* Returns the number of vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param statusDoc the status doc
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L_F_S(long groupId, java.lang.String language,
		java.lang.String fieldId, int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_L_F_S(groupId, language, fieldId, statusDoc);
	}

	/**
	* Returns the number of vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; and typeDoc = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param typeDoc the type doc
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L_S_T(long groupId, java.lang.String language,
		int statusDoc, int typeDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_L_S_T(groupId, language, statusDoc, typeDoc);
	}

	/**
	* Returns the number of vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; and fieldId = &#63; and typeDoc = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param fieldId the field ID
	* @param typeDoc the type doc
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L_S_F_T(long groupId, java.lang.String language,
		int statusDoc, java.lang.String fieldId, int typeDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_L_S_F_T(groupId, language, statusDoc, fieldId,
			typeDoc);
	}

	/**
	* Returns the number of vdoc documents where statusDoc = &#63;.
	*
	* @param statusDoc the status doc
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(statusDoc);
	}

	/**
	* Returns the number of vdoc documents where position = &#63;.
	*
	* @param position the position
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPosition(int position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPosition(position);
	}

	/**
	* Returns the number of vdoc documents.
	*
	* @return the number of vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static vdocDocumentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (vdocDocumentPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vdoc.service.ClpSerializer.getServletContextName(),
					vdocDocumentPersistence.class.getName());

			ReferenceRegistry.registerReference(vdocDocumentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(vdocDocumentPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(vdocDocumentUtil.class,
			"_persistence");
	}

	private static vdocDocumentPersistence _persistence;
}