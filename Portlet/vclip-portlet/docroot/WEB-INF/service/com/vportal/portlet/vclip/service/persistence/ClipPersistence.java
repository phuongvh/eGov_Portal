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

import com.vportal.portlet.vclip.model.Clip;

/**
 * The persistence interface for the clip service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see ClipPersistenceImpl
 * @see ClipUtil
 * @generated
 */
public interface ClipPersistence extends BasePersistence<Clip> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClipUtil} to access the clip persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the clip in the entity cache if it is enabled.
	*
	* @param clip the clip
	*/
	public void cacheResult(com.vportal.portlet.vclip.model.Clip clip);

	/**
	* Caches the clips in the entity cache if it is enabled.
	*
	* @param clips the clips
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vclip.model.Clip> clips);

	/**
	* Creates a new clip with the primary key. Does not add the clip to the database.
	*
	* @param id the primary key for the new clip
	* @return the new clip
	*/
	public com.vportal.portlet.vclip.model.Clip create(java.lang.String id);

	/**
	* Removes the clip with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the clip
	* @return the clip that was removed
	* @throws com.vportal.portlet.vclip.NoSuchClipException if a clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.Clip remove(java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException;

	public com.vportal.portlet.vclip.model.Clip updateImpl(
		com.vportal.portlet.vclip.model.Clip clip, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clip with the primary key or throws a {@link com.vportal.portlet.vclip.NoSuchClipException} if it could not be found.
	*
	* @param id the primary key of the clip
	* @return the clip
	* @throws com.vportal.portlet.vclip.NoSuchClipException if a clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.Clip findByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException;

	/**
	* Returns the clip with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the clip
	* @return the clip, or <code>null</code> if a clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.Clip fetchByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clips where language = &#63; and active = &#63;.
	*
	* @param language the language
	* @param active the active
	* @return the matching clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByLanguage(
		java.lang.String language, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clips where language = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param active the active
	* @param start the lower bound of the range of clips
	* @param end the upper bound of the range of clips (not inclusive)
	* @return the range of matching clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByLanguage(
		java.lang.String language, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clips where language = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param active the active
	* @param start the lower bound of the range of clips
	* @param end the upper bound of the range of clips (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByLanguage(
		java.lang.String language, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first clip in the ordered set where language = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching clip
	* @throws com.vportal.portlet.vclip.NoSuchClipException if a matching clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.Clip findByLanguage_First(
		java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException;

	/**
	* Returns the last clip in the ordered set where language = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching clip
	* @throws com.vportal.portlet.vclip.NoSuchClipException if a matching clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.Clip findByLanguage_Last(
		java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException;

	/**
	* Returns the clips before and after the current clip in the ordered set where language = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current clip
	* @param language the language
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next clip
	* @throws com.vportal.portlet.vclip.NoSuchClipException if a clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.Clip[] findByLanguage_PrevAndNext(
		java.lang.String id, java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException;

	/**
	* Returns all the clips where clipTypeId = &#63;.
	*
	* @param clipTypeId the clip type ID
	* @return the matching clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clips where clipTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param clipTypeId the clip type ID
	* @param start the lower bound of the range of clips
	* @param end the upper bound of the range of clips (not inclusive)
	* @return the range of matching clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clips where clipTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param clipTypeId the clip type ID
	* @param start the lower bound of the range of clips
	* @param end the upper bound of the range of clips (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first clip in the ordered set where clipTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param clipTypeId the clip type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching clip
	* @throws com.vportal.portlet.vclip.NoSuchClipException if a matching clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.Clip findByClipTypeId_First(
		java.lang.String clipTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException;

	/**
	* Returns the last clip in the ordered set where clipTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param clipTypeId the clip type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching clip
	* @throws com.vportal.portlet.vclip.NoSuchClipException if a matching clip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.Clip findByClipTypeId_Last(
		java.lang.String clipTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException;

	/**
	* Returns the clips before and after the current clip in the ordered set where clipTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current clip
	* @param clipTypeId the clip type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next clip
	* @throws com.vportal.portlet.vclip.NoSuchClipException if a clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vclip.model.Clip[] findByClipTypeId_PrevAndNext(
		java.lang.String id, java.lang.String clipTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException;

	/**
	* Returns all the clips.
	*
	* @return the clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.Clip> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the clips.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of clips
	* @param end the upper bound of the range of clips (not inclusive)
	* @return the range of clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.Clip> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the clips.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of clips
	* @param end the upper bound of the range of clips (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of clips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vclip.model.Clip> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clips where language = &#63; and active = &#63; from the database.
	*
	* @param language the language
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLanguage(java.lang.String language, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clips where clipTypeId = &#63; from the database.
	*
	* @param clipTypeId the clip type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByClipTypeId(java.lang.String clipTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clips from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clips where language = &#63; and active = &#63;.
	*
	* @param language the language
	* @param active the active
	* @return the number of matching clips
	* @throws SystemException if a system exception occurred
	*/
	public int countByLanguage(java.lang.String language, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clips where clipTypeId = &#63;.
	*
	* @param clipTypeId the clip type ID
	* @return the number of matching clips
	* @throws SystemException if a system exception occurred
	*/
	public int countByClipTypeId(java.lang.String clipTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clips.
	*
	* @return the number of clips
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}