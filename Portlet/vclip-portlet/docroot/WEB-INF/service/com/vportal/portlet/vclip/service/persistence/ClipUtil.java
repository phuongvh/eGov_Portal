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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.vclip.model.Clip;

import java.util.List;

/**
 * The persistence utility for the clip service. This utility wraps {@link ClipPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see ClipPersistence
 * @see ClipPersistenceImpl
 * @generated
 */
public class ClipUtil {
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
	public static void clearCache(Clip clip) {
		getPersistence().clearCache(clip);
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
	public static List<Clip> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Clip> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Clip> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Clip update(Clip clip, boolean merge)
		throws SystemException {
		return getPersistence().update(clip, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Clip update(Clip clip, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(clip, merge, serviceContext);
	}

	/**
	* Caches the clip in the entity cache if it is enabled.
	*
	* @param clip the clip
	*/
	public static void cacheResult(com.vportal.portlet.vclip.model.Clip clip) {
		getPersistence().cacheResult(clip);
	}

	/**
	* Caches the clips in the entity cache if it is enabled.
	*
	* @param clips the clips
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vclip.model.Clip> clips) {
		getPersistence().cacheResult(clips);
	}

	/**
	* Creates a new clip with the primary key. Does not add the clip to the database.
	*
	* @param id the primary key for the new clip
	* @return the new clip
	*/
	public static com.vportal.portlet.vclip.model.Clip create(
		java.lang.String id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the clip with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the clip
	* @return the clip that was removed
	* @throws com.vportal.portlet.vclip.NoSuchClipException if a clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vclip.model.Clip remove(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException {
		return getPersistence().remove(id);
	}

	public static com.vportal.portlet.vclip.model.Clip updateImpl(
		com.vportal.portlet.vclip.model.Clip clip, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(clip, merge);
	}

	/**
	* Returns the clip with the primary key or throws a {@link com.vportal.portlet.vclip.NoSuchClipException} if it could not be found.
	*
	* @param id the primary key of the clip
	* @return the clip
	* @throws com.vportal.portlet.vclip.NoSuchClipException if a clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vclip.model.Clip findByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the clip with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the clip
	* @return the clip, or <code>null</code> if a clip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vclip.model.Clip fetchByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the clips where language = &#63; and active = &#63;.
	*
	* @param language the language
	* @param active the active
	* @return the matching clips
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findByLanguage(
		java.lang.String language, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLanguage(language, active);
	}

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
	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findByLanguage(
		java.lang.String language, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLanguage(language, active, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findByLanguage(
		java.lang.String language, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLanguage(language, active, start, end,
			orderByComparator);
	}

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
	public static com.vportal.portlet.vclip.model.Clip findByLanguage_First(
		java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException {
		return getPersistence()
				   .findByLanguage_First(language, active, orderByComparator);
	}

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
	public static com.vportal.portlet.vclip.model.Clip findByLanguage_Last(
		java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException {
		return getPersistence()
				   .findByLanguage_Last(language, active, orderByComparator);
	}

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
	public static com.vportal.portlet.vclip.model.Clip[] findByLanguage_PrevAndNext(
		java.lang.String id, java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException {
		return getPersistence()
				   .findByLanguage_PrevAndNext(id, language, active,
			orderByComparator);
	}

	/**
	* Returns all the clips where clipTypeId = &#63;.
	*
	* @param clipTypeId the clip type ID
	* @return the matching clips
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClipTypeId(clipTypeId);
	}

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
	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClipTypeId(clipTypeId, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findByClipTypeId(
		java.lang.String clipTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClipTypeId(clipTypeId, start, end, orderByComparator);
	}

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
	public static com.vportal.portlet.vclip.model.Clip findByClipTypeId_First(
		java.lang.String clipTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException {
		return getPersistence()
				   .findByClipTypeId_First(clipTypeId, orderByComparator);
	}

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
	public static com.vportal.portlet.vclip.model.Clip findByClipTypeId_Last(
		java.lang.String clipTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException {
		return getPersistence()
				   .findByClipTypeId_Last(clipTypeId, orderByComparator);
	}

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
	public static com.vportal.portlet.vclip.model.Clip[] findByClipTypeId_PrevAndNext(
		java.lang.String id, java.lang.String clipTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipException {
		return getPersistence()
				   .findByClipTypeId_PrevAndNext(id, clipTypeId,
			orderByComparator);
	}

	/**
	* Returns all the clips.
	*
	* @return the clips
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vclip.model.Clip> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the clips where language = &#63; and active = &#63; from the database.
	*
	* @param language the language
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLanguage(java.lang.String language,
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLanguage(language, active);
	}

	/**
	* Removes all the clips where clipTypeId = &#63; from the database.
	*
	* @param clipTypeId the clip type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByClipTypeId(java.lang.String clipTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByClipTypeId(clipTypeId);
	}

	/**
	* Removes all the clips from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of clips where language = &#63; and active = &#63;.
	*
	* @param language the language
	* @param active the active
	* @return the number of matching clips
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLanguage(java.lang.String language, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLanguage(language, active);
	}

	/**
	* Returns the number of clips where clipTypeId = &#63;.
	*
	* @param clipTypeId the clip type ID
	* @return the number of matching clips
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClipTypeId(java.lang.String clipTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByClipTypeId(clipTypeId);
	}

	/**
	* Returns the number of clips.
	*
	* @return the number of clips
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ClipPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ClipPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vclip.service.ClpSerializer.getServletContextName(),
					ClipPersistence.class.getName());

			ReferenceRegistry.registerReference(ClipUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ClipPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ClipUtil.class, "_persistence");
	}

	private static ClipPersistence _persistence;
}