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

import com.vportal.portlet.vcms.model.VcmsCARelation;

/**
 * The persistence interface for the vcms c a relation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsCARelationPersistenceImpl
 * @see VcmsCARelationUtil
 * @generated
 */
public interface VcmsCARelationPersistence extends BasePersistence<VcmsCARelation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VcmsCARelationUtil} to access the vcms c a relation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vcms c a relation in the entity cache if it is enabled.
	*
	* @param vcmsCARelation the vcms c a relation
	*/
	public void cacheResult(
		com.vportal.portlet.vcms.model.VcmsCARelation vcmsCARelation);

	/**
	* Caches the vcms c a relations in the entity cache if it is enabled.
	*
	* @param vcmsCARelations the vcms c a relations
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> vcmsCARelations);

	/**
	* Creates a new vcms c a relation with the primary key. Does not add the vcms c a relation to the database.
	*
	* @param vcmsCARelationPK the primary key for the new vcms c a relation
	* @return the new vcms c a relation
	*/
	public com.vportal.portlet.vcms.model.VcmsCARelation create(
		com.vportal.portlet.vcms.service.persistence.VcmsCARelationPK vcmsCARelationPK);

	/**
	* Removes the vcms c a relation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsCARelationPK the primary key of the vcms c a relation
	* @return the vcms c a relation that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a vcms c a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCARelation remove(
		com.vportal.portlet.vcms.service.persistence.VcmsCARelationPK vcmsCARelationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCARelationException;

	public com.vportal.portlet.vcms.model.VcmsCARelation updateImpl(
		com.vportal.portlet.vcms.model.VcmsCARelation vcmsCARelation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms c a relation with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsCARelationException} if it could not be found.
	*
	* @param vcmsCARelationPK the primary key of the vcms c a relation
	* @return the vcms c a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a vcms c a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCARelation findByPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsCARelationPK vcmsCARelationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCARelationException;

	/**
	* Returns the vcms c a relation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vcmsCARelationPK the primary key of the vcms c a relation
	* @return the vcms c a relation, or <code>null</code> if a vcms c a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCARelation fetchByPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsCARelationPK vcmsCARelationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vcms c a relations where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> findByCategory(
		java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms c a relations where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of vcms c a relations
	* @param end the upper bound of the range of vcms c a relations (not inclusive)
	* @return the range of matching vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> findByCategory(
		java.lang.String categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms c a relations where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of vcms c a relations
	* @param end the upper bound of the range of vcms c a relations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> findByCategory(
		java.lang.String categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms c a relation in the ordered set where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms c a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a matching vcms c a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCARelation findByCategory_First(
		java.lang.String categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCARelationException;

	/**
	* Returns the last vcms c a relation in the ordered set where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms c a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a matching vcms c a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCARelation findByCategory_Last(
		java.lang.String categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCARelationException;

	/**
	* Returns the vcms c a relations before and after the current vcms c a relation in the ordered set where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vcmsCARelationPK the primary key of the current vcms c a relation
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms c a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a vcms c a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCARelation[] findByCategory_PrevAndNext(
		com.vportal.portlet.vcms.service.persistence.VcmsCARelationPK vcmsCARelationPK,
		java.lang.String categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCARelationException;

	/**
	* Returns all the vcms c a relations where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> findByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms c a relations where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms c a relations
	* @param end the upper bound of the range of vcms c a relations (not inclusive)
	* @return the range of matching vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> findByArticle(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms c a relations where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms c a relations
	* @param end the upper bound of the range of vcms c a relations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> findByArticle(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms c a relation in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms c a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a matching vcms c a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCARelation findByArticle_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCARelationException;

	/**
	* Returns the last vcms c a relation in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms c a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a matching vcms c a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCARelation findByArticle_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCARelationException;

	/**
	* Returns the vcms c a relations before and after the current vcms c a relation in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vcmsCARelationPK the primary key of the current vcms c a relation
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms c a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a vcms c a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsCARelation[] findByArticle_PrevAndNext(
		com.vportal.portlet.vcms.service.persistence.VcmsCARelationPK vcmsCARelationPK,
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsCARelationException;

	/**
	* Returns all the vcms c a relations.
	*
	* @return the vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms c a relations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms c a relations
	* @param end the upper bound of the range of vcms c a relations (not inclusive)
	* @return the range of vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms c a relations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms c a relations
	* @param end the upper bound of the range of vcms c a relations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms c a relations where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms c a relations where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms c a relations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms c a relations where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(java.lang.String categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms c a relations where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public int countByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms c a relations.
	*
	* @return the number of vcms c a relations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}