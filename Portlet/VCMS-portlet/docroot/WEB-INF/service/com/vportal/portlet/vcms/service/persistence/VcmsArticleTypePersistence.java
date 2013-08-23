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

import com.vportal.portlet.vcms.model.VcmsArticleType;

/**
 * The persistence interface for the vcms article type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsArticleTypePersistenceImpl
 * @see VcmsArticleTypeUtil
 * @generated
 */
public interface VcmsArticleTypePersistence extends BasePersistence<VcmsArticleType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VcmsArticleTypeUtil} to access the vcms article type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vcms article type in the entity cache if it is enabled.
	*
	* @param vcmsArticleType the vcms article type
	*/
	public void cacheResult(
		com.vportal.portlet.vcms.model.VcmsArticleType vcmsArticleType);

	/**
	* Caches the vcms article types in the entity cache if it is enabled.
	*
	* @param vcmsArticleTypes the vcms article types
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> vcmsArticleTypes);

	/**
	* Creates a new vcms article type with the primary key. Does not add the vcms article type to the database.
	*
	* @param vcmsArticleTypePK the primary key for the new vcms article type
	* @return the new vcms article type
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType create(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK);

	/**
	* Removes the vcms article type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticleTypePK the primary key of the vcms article type
	* @return the vcms article type that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType remove(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException;

	public com.vportal.portlet.vcms.model.VcmsArticleType updateImpl(
		com.vportal.portlet.vcms.model.VcmsArticleType vcmsArticleType,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms article type with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException} if it could not be found.
	*
	* @param vcmsArticleTypePK the primary key of the vcms article type
	* @return the vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType findByPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException;

	/**
	* Returns the vcms article type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vcmsArticleTypePK the primary key of the vcms article type
	* @return the vcms article type, or <code>null</code> if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType fetchByPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vcms article types where typeId = &#63;.
	*
	* @param typeId the type ID
	* @return the matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByType(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms article types where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @return the range of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByType(
		long typeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms article types where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByType(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms article type in the ordered set where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType findByType_First(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException;

	/**
	* Returns the last vcms article type in the ordered set where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType findByType_Last(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException;

	/**
	* Returns the vcms article types before and after the current vcms article type in the ordered set where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vcmsArticleTypePK the primary key of the current vcms article type
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType[] findByType_PrevAndNext(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK,
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException;

	/**
	* Returns all the vcms article types where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms article types where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @return the range of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByArticle(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms article types where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findByArticle(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms article type in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType findByArticle_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException;

	/**
	* Returns the last vcms article type in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType findByArticle_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException;

	/**
	* Returns the vcms article types before and after the current vcms article type in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vcmsArticleTypePK the primary key of the current vcms article type
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a vcms article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType[] findByArticle_PrevAndNext(
		com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePK vcmsArticleTypePK,
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException;

	/**
	* Returns the vcms article type where typeId = &#63; and articleId = &#63; or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException} if it could not be found.
	*
	* @param typeId the type ID
	* @param articleId the article ID
	* @return the matching vcms article type
	* @throws com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType findByArticleByType(
		long typeId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException;

	/**
	* Returns the vcms article type where typeId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param typeId the type ID
	* @param articleId the article ID
	* @return the matching vcms article type, or <code>null</code> if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType fetchByArticleByType(
		long typeId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms article type where typeId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param typeId the type ID
	* @param articleId the article ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vcms article type, or <code>null</code> if a matching vcms article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticleType fetchByArticleByType(
		long typeId, java.lang.String articleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vcms article types.
	*
	* @return the vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms article types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @return the range of vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms article types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms article types
	* @param end the upper bound of the range of vcms article types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticleType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms article types where typeId = &#63; from the database.
	*
	* @param typeId the type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms article types where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the vcms article type where typeId = &#63; and articleId = &#63; from the database.
	*
	* @param typeId the type ID
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByArticleByType(long typeId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsArticleTypeException;

	/**
	* Removes all the vcms article types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms article types where typeId = &#63;.
	*
	* @param typeId the type ID
	* @return the number of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms article types where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public int countByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms article types where typeId = &#63; and articleId = &#63;.
	*
	* @param typeId the type ID
	* @param articleId the article ID
	* @return the number of matching vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public int countByArticleByType(long typeId, java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms article types.
	*
	* @return the number of vcms article types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}