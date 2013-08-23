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

import com.vportal.portlet.vcms.model.VcmsPARelation;

/**
 * The persistence interface for the vcms p a relation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsPARelationPersistenceImpl
 * @see VcmsPARelationUtil
 * @generated
 */
public interface VcmsPARelationPersistence extends BasePersistence<VcmsPARelation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VcmsPARelationUtil} to access the vcms p a relation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vcms p a relation in the entity cache if it is enabled.
	*
	* @param vcmsPARelation the vcms p a relation
	*/
	public void cacheResult(
		com.vportal.portlet.vcms.model.VcmsPARelation vcmsPARelation);

	/**
	* Caches the vcms p a relations in the entity cache if it is enabled.
	*
	* @param vcmsPARelations the vcms p a relations
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> vcmsPARelations);

	/**
	* Creates a new vcms p a relation with the primary key. Does not add the vcms p a relation to the database.
	*
	* @param vcmsPARelationPK the primary key for the new vcms p a relation
	* @return the new vcms p a relation
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation create(
		com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK vcmsPARelationPK);

	/**
	* Removes the vcms p a relation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsPARelationPK the primary key of the vcms p a relation
	* @return the vcms p a relation that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a vcms p a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation remove(
		com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK vcmsPARelationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPARelationException;

	public com.vportal.portlet.vcms.model.VcmsPARelation updateImpl(
		com.vportal.portlet.vcms.model.VcmsPARelation vcmsPARelation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms p a relation with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsPARelationException} if it could not be found.
	*
	* @param vcmsPARelationPK the primary key of the vcms p a relation
	* @return the vcms p a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a vcms p a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation findByPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK vcmsPARelationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPARelationException;

	/**
	* Returns the vcms p a relation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vcmsPARelationPK the primary key of the vcms p a relation
	* @return the vcms p a relation, or <code>null</code> if a vcms p a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation fetchByPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK vcmsPARelationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vcms p a relations where portionId = &#63;.
	*
	* @param portionId the portion ID
	* @return the matching vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> findByPortion(
		java.lang.String portionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms p a relations where portionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portionId the portion ID
	* @param start the lower bound of the range of vcms p a relations
	* @param end the upper bound of the range of vcms p a relations (not inclusive)
	* @return the range of matching vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> findByPortion(
		java.lang.String portionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms p a relations where portionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portionId the portion ID
	* @param start the lower bound of the range of vcms p a relations
	* @param end the upper bound of the range of vcms p a relations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> findByPortion(
		java.lang.String portionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms p a relation in the ordered set where portionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portionId the portion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms p a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a matching vcms p a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation findByPortion_First(
		java.lang.String portionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPARelationException;

	/**
	* Returns the last vcms p a relation in the ordered set where portionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portionId the portion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms p a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a matching vcms p a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation findByPortion_Last(
		java.lang.String portionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPARelationException;

	/**
	* Returns the vcms p a relations before and after the current vcms p a relation in the ordered set where portionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vcmsPARelationPK the primary key of the current vcms p a relation
	* @param portionId the portion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms p a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a vcms p a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation[] findByPortion_PrevAndNext(
		com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK vcmsPARelationPK,
		java.lang.String portionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPARelationException;

	/**
	* Returns all the vcms p a relations where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> findByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms p a relations where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms p a relations
	* @param end the upper bound of the range of vcms p a relations (not inclusive)
	* @return the range of matching vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> findByArticle(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms p a relations where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms p a relations
	* @param end the upper bound of the range of vcms p a relations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> findByArticle(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms p a relation in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms p a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a matching vcms p a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation findByArticle_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPARelationException;

	/**
	* Returns the last vcms p a relation in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms p a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a matching vcms p a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation findByArticle_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPARelationException;

	/**
	* Returns the vcms p a relations before and after the current vcms p a relation in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vcmsPARelationPK the primary key of the current vcms p a relation
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms p a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a vcms p a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPARelation[] findByArticle_PrevAndNext(
		com.vportal.portlet.vcms.service.persistence.VcmsPARelationPK vcmsPARelationPK,
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPARelationException;

	/**
	* Returns all the vcms p a relations.
	*
	* @return the vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms p a relations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms p a relations
	* @param end the upper bound of the range of vcms p a relations (not inclusive)
	* @return the range of vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms p a relations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms p a relations
	* @param end the upper bound of the range of vcms p a relations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms p a relations where portionId = &#63; from the database.
	*
	* @param portionId the portion ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPortion(java.lang.String portionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms p a relations where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms p a relations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms p a relations where portionId = &#63;.
	*
	* @param portionId the portion ID
	* @return the number of matching vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public int countByPortion(java.lang.String portionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms p a relations where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public int countByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms p a relations.
	*
	* @return the number of vcms p a relations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}