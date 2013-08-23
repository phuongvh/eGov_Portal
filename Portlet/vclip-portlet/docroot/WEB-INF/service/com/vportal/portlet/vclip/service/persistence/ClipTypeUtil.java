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

import com.vportal.portlet.vclip.model.ClipType;

import java.util.List;

/**
 * The persistence utility for the clip type service. This utility wraps {@link ClipTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see ClipTypePersistence
 * @see ClipTypePersistenceImpl
 * @generated
 */
public class ClipTypeUtil {
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
	public static void clearCache(ClipType clipType) {
		getPersistence().clearCache(clipType);
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
	public static List<ClipType> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClipType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClipType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ClipType update(ClipType clipType, boolean merge)
		throws SystemException {
		return getPersistence().update(clipType, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ClipType update(ClipType clipType, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(clipType, merge, serviceContext);
	}

	/**
	* Caches the clip type in the entity cache if it is enabled.
	*
	* @param clipType the clip type
	*/
	public static void cacheResult(
		com.vportal.portlet.vclip.model.ClipType clipType) {
		getPersistence().cacheResult(clipType);
	}

	/**
	* Caches the clip types in the entity cache if it is enabled.
	*
	* @param clipTypes the clip types
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vclip.model.ClipType> clipTypes) {
		getPersistence().cacheResult(clipTypes);
	}

	/**
	* Creates a new clip type with the primary key. Does not add the clip type to the database.
	*
	* @param id the primary key for the new clip type
	* @return the new clip type
	*/
	public static com.vportal.portlet.vclip.model.ClipType create(
		java.lang.String id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the clip type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the clip type
	* @return the clip type that was removed
	* @throws com.vportal.portlet.vclip.NoSuchClipTypeException if a clip type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vclip.model.ClipType remove(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipTypeException {
		return getPersistence().remove(id);
	}

	public static com.vportal.portlet.vclip.model.ClipType updateImpl(
		com.vportal.portlet.vclip.model.ClipType clipType, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(clipType, merge);
	}

	/**
	* Returns the clip type with the primary key or throws a {@link com.vportal.portlet.vclip.NoSuchClipTypeException} if it could not be found.
	*
	* @param id the primary key of the clip type
	* @return the clip type
	* @throws com.vportal.portlet.vclip.NoSuchClipTypeException if a clip type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vclip.model.ClipType findByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipTypeException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the clip type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the clip type
	* @return the clip type, or <code>null</code> if a clip type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vclip.model.ClipType fetchByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the clip types where language = &#63; and active = &#63;.
	*
	* @param language the language
	* @param active the active
	* @return the matching clip types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vclip.model.ClipType> findByLanguage(
		java.lang.String language, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLanguage(language, active);
	}

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
	public static java.util.List<com.vportal.portlet.vclip.model.ClipType> findByLanguage(
		java.lang.String language, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLanguage(language, active, start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vclip.model.ClipType> findByLanguage(
		java.lang.String language, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLanguage(language, active, start, end,
			orderByComparator);
	}

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
	public static com.vportal.portlet.vclip.model.ClipType findByLanguage_First(
		java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipTypeException {
		return getPersistence()
				   .findByLanguage_First(language, active, orderByComparator);
	}

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
	public static com.vportal.portlet.vclip.model.ClipType findByLanguage_Last(
		java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipTypeException {
		return getPersistence()
				   .findByLanguage_Last(language, active, orderByComparator);
	}

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
	public static com.vportal.portlet.vclip.model.ClipType[] findByLanguage_PrevAndNext(
		java.lang.String id, java.lang.String language, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vclip.NoSuchClipTypeException {
		return getPersistence()
				   .findByLanguage_PrevAndNext(id, language, active,
			orderByComparator);
	}

	/**
	* Returns all the clip types.
	*
	* @return the clip types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.vportal.portlet.vclip.model.ClipType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the clip types where language = &#63; and active = &#63; from the database.
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
	* Removes all the clip types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of clip types where language = &#63; and active = &#63;.
	*
	* @param language the language
	* @param active the active
	* @return the number of matching clip types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLanguage(java.lang.String language, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLanguage(language, active);
	}

	/**
	* Returns the number of clip types.
	*
	* @return the number of clip types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ClipTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ClipTypePersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vclip.service.ClpSerializer.getServletContextName(),
					ClipTypePersistence.class.getName());

			ReferenceRegistry.registerReference(ClipTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ClipTypePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ClipTypeUtil.class, "_persistence");
	}

	private static ClipTypePersistence _persistence;
}