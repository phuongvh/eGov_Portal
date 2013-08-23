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

package com.vportal.portlet.vclip.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.vportal.portlet.vclip.model.ClipType;

/**
 * The persistence interface for the clip type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see ClipTypePersistenceImpl
 * @see ClipTypeUtil
 * @generated
 */
public interface ClipTypePersistence extends BasePersistence<ClipType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClipTypeUtil} to access the clip type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the clip type in the entity cache if it is enabled.
	*
	* @param clipType the clip type
	*/
	public void cacheResult(com.vportal.portlet.vclip.model.ClipType clipType);

	/**
	* Caches the clip types in the entity cache if it is enabled.
	*
	* @param clipTypes the clip types
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vclip.model.ClipType> clipTypes);

	/**
	* Creates a new clip type with the primary key. Does not add the clip type to the database.
	*
	* @param id the primary key for the new clip type
	* @return the new clip type
	*/
	public com.vportal.portlet.vclip.model.ClipType create(java.lang.String id);

	/**
	* Removes the clip type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the clip type
	* @return the clip type that was removed
	* @throws com.vportal.portlet.vclip.NoSuchClipTypeException if a clip type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.ClipType remove(java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipTypeException;

	public com.vportal.portlet.vclip.model.ClipType updateImpl(
		com.vportal.portlet.vclip.model.ClipType clipType, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clip type with the primary key or throws a {@link com.vportal.portlet.vclip.NoSuchClipTypeException} if it could not be found.
	*
	* @param id the primary key of the clip type
	* @return the clip type
	* @throws com.vportal.portlet.vclip.NoSuchClipTypeException if a clip type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.ClipType findByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipTypeException;

	/**
	* Returns the clip type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the clip type
	* @return the clip type, or <code>null</code> if a clip type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.ClipType fetchByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clip types where language = &#63; and active = &#63;.
	*
	* @param language the language
	* @param active the active
	* @return the matching clip types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findByLanguage(
		java.lang.String language, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clip types where language = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param active the active
	* @param start the lower bound of the range of clip types
	* @param end the upper bound of the range of clip types (not inclusive)
	* @return the range of matching clip types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findByLanguage(
		java.lang.String language, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clip types where language = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param active the active
	* @param start the lower bound of the range of clip types
	* @param end the upper bound of the range of clip types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clip types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findByLanguage(
		java.lang.String language, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first clip type in the ordered set where language = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching clip type
	* @throws com.vportal.portlet.vclip.NoSuchClipTypeException if a matching clip type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.ClipType findByLanguage_First(
		java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipTypeException;

	/**
	* Returns the last clip type in the ordered set where language = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching clip type
	* @throws com.vportal.portlet.vclip.NoSuchClipTypeException if a matching clip type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.ClipType findByLanguage_Last(
		java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipTypeException;

	/**
	* Returns the clip types before and after the current clip type in the ordered set where language = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current clip type
	* @param language the language
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next clip type
	* @throws com.vportal.portlet.vclip.NoSuchClipTypeException if a clip type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.ClipType[] findByLanguage_PrevAndNext(
		java.lang.String id, java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipTypeException;

	/**
	* Returns all the clip types.
	*
	* @return the clip types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clip types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of clip types
	* @param end the upper bound of the range of clip types (not inclusive)
	* @return the range of clip types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clip types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of clip types
	* @param end the upper bound of the range of clip types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of clip types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clip types where language = &#63; and active = &#63; from the database.
	*
	* @param language the language
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLanguage(java.lang.String language, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clip types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clip types where language = &#63; and active = &#63;.
	*
	* @param language the language
	* @param active the active
	* @return the number of matching clip types
	* @throws SystemException if a system exception occurred
	*/
	public int countByLanguage(java.lang.String language, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clip types.
	*
	* @return the number of clip types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}