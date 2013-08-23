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

import com.vportal.portlet.vcms.model.VcmsPortion;

/**
 * The persistence interface for the vcms portion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsPortionPersistenceImpl
 * @see VcmsPortionUtil
 * @generated
 */
public interface VcmsPortionPersistence extends BasePersistence<VcmsPortion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VcmsPortionUtil} to access the vcms portion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vcms portion in the entity cache if it is enabled.
	*
	* @param vcmsPortion the vcms portion
	*/
	public void cacheResult(
		com.vportal.portlet.vcms.model.VcmsPortion vcmsPortion);

	/**
	* Caches the vcms portions in the entity cache if it is enabled.
	*
	* @param vcmsPortions the vcms portions
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vcms.model.VcmsPortion> vcmsPortions);

	/**
	* Creates a new vcms portion with the primary key. Does not add the vcms portion to the database.
	*
	* @param portionId the primary key for the new vcms portion
	* @return the new vcms portion
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion create(
		java.lang.String portionId);

	/**
	* Removes the vcms portion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portionId the primary key of the vcms portion
	* @return the vcms portion that was removed
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a vcms portion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion remove(
		java.lang.String portionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPortionException;

	public com.vportal.portlet.vcms.model.VcmsPortion updateImpl(
		com.vportal.portlet.vcms.model.VcmsPortion vcmsPortion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms portion with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsPortionException} if it could not be found.
	*
	* @param portionId the primary key of the vcms portion
	* @return the vcms portion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a vcms portion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion findByPrimaryKey(
		java.lang.String portionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPortionException;

	/**
	* Returns the vcms portion with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portionId the primary key of the vcms portion
	* @return the vcms portion, or <code>null</code> if a vcms portion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion fetchByPrimaryKey(
		java.lang.String portionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms portion where groupId = &#63; and categorizable = &#63; or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsPortionException} if it could not be found.
	*
	* @param groupId the group ID
	* @param categorizable the categorizable
	* @return the matching vcms portion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a matching vcms portion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion findByCategorizable(
		long groupId, boolean categorizable)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPortionException;

	/**
	* Returns the vcms portion where groupId = &#63; and categorizable = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param categorizable the categorizable
	* @return the matching vcms portion, or <code>null</code> if a matching vcms portion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion fetchByCategorizable(
		long groupId, boolean categorizable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms portion where groupId = &#63; and categorizable = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param categorizable the categorizable
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vcms portion, or <code>null</code> if a matching vcms portion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion fetchByCategorizable(
		long groupId, boolean categorizable, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms portion where groupId = &#63; and code = &#63; or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsPortionException} if it could not be found.
	*
	* @param groupId the group ID
	* @param code the code
	* @return the matching vcms portion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a matching vcms portion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion findByS_C(long groupId,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPortionException;

	/**
	* Returns the vcms portion where groupId = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param code the code
	* @return the matching vcms portion, or <code>null</code> if a matching vcms portion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion fetchByS_C(long groupId,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vcms portion where groupId = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vcms portion, or <code>null</code> if a matching vcms portion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion fetchByS_C(long groupId,
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vcms portions where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the matching vcms portions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPortion> findByS_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms portions where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vcms portions
	* @param end the upper bound of the range of vcms portions (not inclusive)
	* @return the range of matching vcms portions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPortion> findByS_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms portions where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vcms portions
	* @param end the upper bound of the range of vcms portions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vcms portions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPortion> findByS_L(
		long groupId, java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vcms portion in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vcms portion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a matching vcms portion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion findByS_L_First(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPortionException;

	/**
	* Returns the last vcms portion in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vcms portion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a matching vcms portion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion findByS_L_Last(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPortionException;

	/**
	* Returns the vcms portions before and after the current vcms portion in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portionId the primary key of the current vcms portion
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vcms portion
	* @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a vcms portion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsPortion[] findByS_L_PrevAndNext(
		java.lang.String portionId, long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPortionException;

	/**
	* Returns all the vcms portions.
	*
	* @return the vcms portions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPortion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vcms portions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms portions
	* @param end the upper bound of the range of vcms portions (not inclusive)
	* @return the range of vcms portions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPortion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vcms portions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms portions
	* @param end the upper bound of the range of vcms portions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vcms portions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsPortion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the vcms portion where groupId = &#63; and categorizable = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categorizable the categorizable
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategorizable(long groupId, boolean categorizable)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPortionException;

	/**
	* Removes the vcms portion where groupId = &#63; and code = &#63; from the database.
	*
	* @param groupId the group ID
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_C(long groupId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcms.NoSuchVcmsPortionException;

	/**
	* Removes all the vcms portions where groupId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vcms portions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms portions where groupId = &#63; and categorizable = &#63;.
	*
	* @param groupId the group ID
	* @param categorizable the categorizable
	* @return the number of matching vcms portions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategorizable(long groupId, boolean categorizable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms portions where groupId = &#63; and code = &#63;.
	*
	* @param groupId the group ID
	* @param code the code
	* @return the number of matching vcms portions
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_C(long groupId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms portions where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the number of matching vcms portions
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vcms portions.
	*
	* @return the number of vcms portions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}