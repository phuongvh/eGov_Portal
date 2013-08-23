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

import com.liferay.portal.service.persistence.BasePersistence;

import com.vportal.portlet.vdoc.model.vdocDocument;

/**
 * The persistence interface for the vdoc document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocDocumentPersistenceImpl
 * @see vdocDocumentUtil
 * @generated
 */
public interface vdocDocumentPersistence extends BasePersistence<vdocDocument> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link vdocDocumentUtil} to access the vdoc document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vdoc document in the entity cache if it is enabled.
	*
	* @param vdocDocument the vdoc document
	*/
	public void cacheResult(
		com.vportal.portlet.vdoc.model.vdocDocument vdocDocument);

	/**
	* Caches the vdoc documents in the entity cache if it is enabled.
	*
	* @param vdocDocuments the vdoc documents
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> vdocDocuments);

	/**
	* Creates a new vdoc document with the primary key. Does not add the vdoc document to the database.
	*
	* @param docId the primary key for the new vdoc document
	* @return the new vdoc document
	*/
	public com.vportal.portlet.vdoc.model.vdocDocument create(
		java.lang.String docId);

	/**
	* Removes the vdoc document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param docId the primary key of the vdoc document
	* @return the vdoc document that was removed
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDocument remove(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

	public com.vportal.portlet.vdoc.model.vdocDocument updateImpl(
		com.vportal.portlet.vdoc.model.vdocDocument vdocDocument, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vdoc document with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocDocumentException} if it could not be found.
	*
	* @param docId the primary key of the vdoc document
	* @return the vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDocument findByPrimaryKey(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

	/**
	* Returns the vdoc document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param docId the primary key of the vdoc document
	* @return the vdoc document, or <code>null</code> if a vdoc document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDocument fetchByPrimaryKey(
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vdoc document where fieldId = &#63; and docId = &#63; or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocDocumentException} if it could not be found.
	*
	* @param fieldId the field ID
	* @param docId the doc ID
	* @return the matching vdoc document
	* @throws com.vportal.portlet.vdoc.NoSuchvdocDocumentException if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDocument findByField_Doc(
		java.lang.String fieldId, java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

	/**
	* Returns the vdoc document where fieldId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fieldId the field ID
	* @param docId the doc ID
	* @return the matching vdoc document, or <code>null</code> if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDocument fetchByField_Doc(
		java.lang.String fieldId, java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vdoc document where fieldId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fieldId the field ID
	* @param docId the doc ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vdoc document, or <code>null</code> if a matching vdoc document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vdoc.model.vdocDocument fetchByField_Doc(
		java.lang.String fieldId, java.lang.String docId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vdoc documents where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L(
		long groupId, java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_First(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_Last(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

	/**
	* Returns all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S(
		long groupId, java.lang.String language, int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S(
		long groupId, java.lang.String language, int statusDoc, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S(
		long groupId, java.lang.String language, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_First(
		long groupId, java.lang.String language, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_Last(
		long groupId, java.lang.String language, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_S_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

	/**
	* Returns all the vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F(
		long groupId, java.lang.String language, java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_F_First(
		long groupId, java.lang.String language, java.lang.String fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_F_Last(
		long groupId, java.lang.String language, java.lang.String fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_F_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		java.lang.String fieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F_S(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F_S(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int statusDoc, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_F_S(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_F_S_First(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_F_S_Last(
		long groupId, java.lang.String language, java.lang.String fieldId,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_F_S_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		java.lang.String fieldId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_T(
		long groupId, java.lang.String language, int statusDoc, int typeDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_T(
		long groupId, java.lang.String language, int statusDoc, int typeDoc,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_T(
		long groupId, java.lang.String language, int statusDoc, int typeDoc,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_T_First(
		long groupId, java.lang.String language, int statusDoc, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_T_Last(
		long groupId, java.lang.String language, int statusDoc, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_S_T_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		int statusDoc, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_F_T(
		long groupId, java.lang.String language, int statusDoc,
		java.lang.String fieldId, int typeDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_F_T(
		long groupId, java.lang.String language, int statusDoc,
		java.lang.String fieldId, int typeDoc, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByG_L_S_F_T(
		long groupId, java.lang.String language, int statusDoc,
		java.lang.String fieldId, int typeDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_F_T_First(
		long groupId, java.lang.String language, int statusDoc,
		java.lang.String fieldId, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByG_L_S_F_T_Last(
		long groupId, java.lang.String language, int statusDoc,
		java.lang.String fieldId, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument[] findByG_L_S_F_T_PrevAndNext(
		java.lang.String docId, long groupId, java.lang.String language,
		int statusDoc, java.lang.String fieldId, int typeDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

	/**
	* Returns all the vdoc documents where statusDoc = &#63;.
	*
	* @param statusDoc the status doc
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByStatus(
		int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByStatus(
		int statusDoc, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByStatus(
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByStatus_First(
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByStatus_Last(
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument[] findByStatus_PrevAndNext(
		java.lang.String docId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

	/**
	* Returns all the vdoc documents where position = &#63;.
	*
	* @param position the position
	* @return the matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByPosition(
		int position)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByPosition(
		int position, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findByPosition(
		int position, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByPosition_First(
		int position,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument findByPosition_Last(
		int position,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

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
	public com.vportal.portlet.vdoc.model.vdocDocument[] findByPosition_PrevAndNext(
		java.lang.String docId, int position,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

	/**
	* Returns all the vdoc documents.
	*
	* @return the vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.vdoc.model.vdocDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the vdoc document where fieldId = &#63; and docId = &#63; from the database.
	*
	* @param fieldId the field ID
	* @param docId the doc ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByField_Doc(java.lang.String fieldId,
		java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vdoc.NoSuchvdocDocumentException;

	/**
	* Removes all the vdoc documents where groupId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_L_S(long groupId, java.lang.String language,
		int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_L_F(long groupId, java.lang.String language,
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @param statusDoc the status doc
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_L_F_S(long groupId, java.lang.String language,
		java.lang.String fieldId, int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63; and typeDoc = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @param typeDoc the type doc
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_L_S_T(long groupId, java.lang.String language,
		int statusDoc, int typeDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public void removeByG_L_S_F_T(long groupId, java.lang.String language,
		int statusDoc, java.lang.String fieldId, int typeDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc documents where statusDoc = &#63; from the database.
	*
	* @param statusDoc the status doc
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc documents where position = &#63; from the database.
	*
	* @param position the position
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPosition(int position)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vdoc documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc documents where fieldId = &#63; and docId = &#63;.
	*
	* @param fieldId the field ID
	* @param docId the doc ID
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByField_Doc(java.lang.String fieldId, java.lang.String docId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc documents where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param statusDoc the status doc
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_L_S(long groupId, java.lang.String language,
		int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param fieldId the field ID
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_L_F(long groupId, java.lang.String language,
		java.lang.String fieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByG_L_F_S(long groupId, java.lang.String language,
		java.lang.String fieldId, int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByG_L_S_T(long groupId, java.lang.String language,
		int statusDoc, int typeDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByG_L_S_F_T(long groupId, java.lang.String language,
		int statusDoc, java.lang.String fieldId, int typeDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc documents where statusDoc = &#63;.
	*
	* @param statusDoc the status doc
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int statusDoc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc documents where position = &#63;.
	*
	* @param position the position
	* @return the number of matching vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByPosition(int position)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vdoc documents.
	*
	* @return the number of vdoc documents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}