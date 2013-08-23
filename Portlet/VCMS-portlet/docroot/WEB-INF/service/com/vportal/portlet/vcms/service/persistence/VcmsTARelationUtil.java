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

import com.vportal.portlet.vcms.model.VcmsTARelation;

import java.util.List;

/**
 * The persistence utility for the vcms t a relation service. This utility wraps {@link VcmsTARelationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsTARelationPersistence
 * @see VcmsTARelationPersistenceImpl
 * @generated
 */
public class VcmsTARelationUtil {
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
	public static void clearCache(VcmsTARelation vcmsTARelation) {
		getPersistence().clearCache(vcmsTARelation);
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
	public static List<VcmsTARelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VcmsTARelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VcmsTARelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VcmsTARelation update(VcmsTARelation vcmsTARelation,
		boolean merge) throws SystemException {
		return getPersistence().update(vcmsTARelation, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VcmsTARelation update(VcmsTARelation vcmsTARelation,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vcmsTARelation, merge, serviceContext);
	}

	/**
	* Caches the vcms t a relation in the entity cache if it is enabled.
	*
	* @param vcmsTARelation the vcms t a relation
	*/
	public static void cacheResult(
		com.vportal.portlet.vcms.model.VcmsTARelation vcmsTARelation) {
		getPersistence().cacheResult(vcmsTARelation);
	}

	/**
	* Caches the vcms t a relations in the entity cache if it is enabled.
	*
	* @param vcmsTARelations the vcms t a relations
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> vcmsTARelations) {
		getPersistence().cacheResult(vcmsTARelations);
	}

	/**
	* Creates a new vcms t a relation with the primary key. Does not add the vcms t a relation to the database.
	*
	* @param vcmsTARelationPK the primary key for the new vcms t a relation
	* @return the new vcms t a relation
	*/
	public static com.vportal.portlet.vcms.model.VcmsTARelation create(
		com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK vcmsTARelationPK) {
		return getPersistence().create(vcmsTARelationPK);
	}

	/**
	* Removes the vcms t a relation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsTARelationPK the primary key of the vcms t a relation
	* @return the vcms t a relation that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a vcms t a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsTARelation remove(
		com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK vcmsTARelationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsTARelationException {
		return getPersistence().remove(vcmsTARelationPK);
	}

	public static com.vportal.portlet.vcms.model.VcmsTARelation updateImpl(
		com.vportal.portlet.vcms.model.VcmsTARelation vcmsTARelation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vcmsTARelation, merge);
	}

	/**
	* Returns the vcms t a relation with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsTARelationException} if it could not be found.
	*
	* @param vcmsTARelationPK the primary key of the vcms t a relation
	* @return the vcms t a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a vcms t a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsTARelation findByPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK vcmsTARelationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsTARelationException {
		return getPersistence().findByPrimaryKey(vcmsTARelationPK);
	}

	/**
	* Returns the vcms t a relation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vcmsTARelationPK the primary key of the vcms t a relation
	* @return the vcms t a relation, or <code>null</code> if a vcms t a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsTARelation fetchByPrimaryKey(
		com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK vcmsTARelationPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vcmsTARelationPK);
	}

	/**
	* Returns all the vcms t a relations where threadId = &#63;.
	*
	* @param threadId the thread ID
	* @return the matching vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> findByThread(
		java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByThread(threadId);
	}

	/**
	* Returns a range of all the vcms t a relations where threadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param start the lower bound of the range of vcms t a relations
	* @param end the upper bound of the range of vcms t a relations (not inclusive)
	* @return the range of matching vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> findByThread(
		java.lang.String threadId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByThread(threadId, start, end);
	}

	/**
	* Returns an ordered range of all the vcms t a relations where threadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param start the lower bound of the range of vcms t a relations
	* @param end the upper bound of the range of vcms t a relations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> findByThread(
		java.lang.String threadId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThread(threadId, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms t a relation in the ordered set where threadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms t a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a matching vcms t a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsTARelation findByThread_First(
		java.lang.String threadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsTARelationException {
		return getPersistence().findByThread_First(threadId, orderByComparator);
	}

	/**
	* Returns the last vcms t a relation in the ordered set where threadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms t a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a matching vcms t a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsTARelation findByThread_Last(
		java.lang.String threadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsTARelationException {
		return getPersistence().findByThread_Last(threadId, orderByComparator);
	}

	/**
	* Returns the vcms t a relations before and after the current vcms t a relation in the ordered set where threadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vcmsTARelationPK the primary key of the current vcms t a relation
	* @param threadId the thread ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms t a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a vcms t a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsTARelation[] findByThread_PrevAndNext(
		com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK vcmsTARelationPK,
		java.lang.String threadId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsTARelationException {
		return getPersistence()
				   .findByThread_PrevAndNext(vcmsTARelationPK, threadId,
			orderByComparator);
	}

	/**
	* Returns all the vcms t a relations where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> findByArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticle(articleId);
	}

	/**
	* Returns a range of all the vcms t a relations where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms t a relations
	* @param end the upper bound of the range of vcms t a relations (not inclusive)
	* @return the range of matching vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> findByArticle(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticle(articleId, start, end);
	}

	/**
	* Returns an ordered range of all the vcms t a relations where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param start the lower bound of the range of vcms t a relations
	* @param end the upper bound of the range of vcms t a relations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> findByArticle(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArticle(articleId, start, end, orderByComparator);
	}

	/**
	* Returns the first vcms t a relation in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms t a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a matching vcms t a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsTARelation findByArticle_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsTARelationException {
		return getPersistence().findByArticle_First(articleId, orderByComparator);
	}

	/**
	* Returns the last vcms t a relation in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms t a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a matching vcms t a relation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsTARelation findByArticle_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsTARelationException {
		return getPersistence().findByArticle_Last(articleId, orderByComparator);
	}

	/**
	* Returns the vcms t a relations before and after the current vcms t a relation in the ordered set where articleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vcmsTARelationPK the primary key of the current vcms t a relation
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms t a relation
	* @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a vcms t a relation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vcms.model.VcmsTARelation[] findByArticle_PrevAndNext(
		com.vportal.portlet.vcms.service.persistence.VcmsTARelationPK vcmsTARelationPK,
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsTARelationException {
		return getPersistence()
				   .findByArticle_PrevAndNext(vcmsTARelationPK, articleId,
			orderByComparator);
	}

	/**
	* Returns all the vcms t a relations.
	*
	* @return the vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vcms t a relations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms t a relations
	* @param end the upper bound of the range of vcms t a relations (not inclusive)
	* @return the range of vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vcms t a relations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms t a relations
	* @param end the upper bound of the range of vcms t a relations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vcms t a relations where threadId = &#63; from the database.
	*
	* @param threadId the thread ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThread(java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByThread(threadId);
	}

	/**
	* Removes all the vcms t a relations where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArticle(articleId);
	}

	/**
	* Removes all the vcms t a relations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vcms t a relations where threadId = &#63;.
	*
	* @param threadId the thread ID
	* @return the number of matching vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThread(java.lang.String threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByThread(threadId);
	}

	/**
	* Returns the number of vcms t a relations where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArticle(articleId);
	}

	/**
	* Returns the number of vcms t a relations.
	*
	* @return the number of vcms t a relations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VcmsTARelationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VcmsTARelationPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vcms.service.ClpSerializer.getServletContextName(),
					VcmsTARelationPersistence.class.getName());

			ReferenceRegistry.registerReference(VcmsTARelationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VcmsTARelationPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VcmsTARelationUtil.class,
			"_persistence");
	}

	private static VcmsTARelationPersistence _persistence;
}