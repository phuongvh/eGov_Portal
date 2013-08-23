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

package com.vportal.portlet.edirectory.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.edirectory.model.EDFunction;

import java.util.List;

/**
 * The persistence utility for the e d function service. This utility wraps {@link EDFunctionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see EDFunctionPersistence
 * @see EDFunctionPersistenceImpl
 * @generated
 */
public class EDFunctionUtil {
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
	public static void clearCache(EDFunction edFunction) {
		getPersistence().clearCache(edFunction);
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
	public static List<EDFunction> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EDFunction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EDFunction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static EDFunction update(EDFunction edFunction, boolean merge)
		throws SystemException {
		return getPersistence().update(edFunction, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static EDFunction update(EDFunction edFunction, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(edFunction, merge, serviceContext);
	}

	/**
	* Caches the e d function in the entity cache if it is enabled.
	*
	* @param edFunction the e d function
	*/
	public static void cacheResult(
		com.vportal.portlet.edirectory.model.EDFunction edFunction) {
		getPersistence().cacheResult(edFunction);
	}

	/**
	* Caches the e d functions in the entity cache if it is enabled.
	*
	* @param edFunctions the e d functions
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.edirectory.model.EDFunction> edFunctions) {
		getPersistence().cacheResult(edFunctions);
	}

	/**
	* Creates a new e d function with the primary key. Does not add the e d function to the database.
	*
	* @param id the primary key for the new e d function
	* @return the new e d function
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the e d function with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d function
	* @return the e d function that was removed
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a e d function with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException {
		return getPersistence().remove(id);
	}

	public static com.vportal.portlet.edirectory.model.EDFunction updateImpl(
		com.vportal.portlet.edirectory.model.EDFunction edFunction,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(edFunction, merge);
	}

	/**
	* Returns the e d function with the primary key or throws a {@link com.vportal.portlet.edirectory.NoSuchEDFunctionException} if it could not be found.
	*
	* @param id the primary key of the e d function
	* @return the e d function
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a e d function with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the e d function with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the e d function
	* @return the e d function, or <code>null</code> if a e d function with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the e d functions where isShowTree = &#63;.
	*
	* @param isShowTree the is show tree
	* @return the matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByIsShowed(
		boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsShowed(isShowTree);
	}

	/**
	* Returns a range of all the e d functions where isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isShowTree the is show tree
	* @param start the lower bound of the range of e d functions
	* @param end the upper bound of the range of e d functions (not inclusive)
	* @return the range of matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByIsShowed(
		boolean isShowTree, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsShowed(isShowTree, start, end);
	}

	/**
	* Returns an ordered range of all the e d functions where isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isShowTree the is show tree
	* @param start the lower bound of the range of e d functions
	* @param end the upper bound of the range of e d functions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByIsShowed(
		boolean isShowTree, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsShowed(isShowTree, start, end, orderByComparator);
	}

	/**
	* Returns the first e d function in the ordered set where isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isShowTree the is show tree
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d function
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a matching e d function could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction findByIsShowed_First(
		boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException {
		return getPersistence()
				   .findByIsShowed_First(isShowTree, orderByComparator);
	}

	/**
	* Returns the last e d function in the ordered set where isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param isShowTree the is show tree
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d function
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a matching e d function could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction findByIsShowed_Last(
		boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException {
		return getPersistence()
				   .findByIsShowed_Last(isShowTree, orderByComparator);
	}

	/**
	* Returns the e d functions before and after the current e d function in the ordered set where isShowTree = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d function
	* @param isShowTree the is show tree
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d function
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a e d function with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction[] findByIsShowed_PrevAndNext(
		long id, boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException {
		return getPersistence()
				   .findByIsShowed_PrevAndNext(id, isShowTree, orderByComparator);
	}

	/**
	* Returns all the e d functions where groupId = &#63; and languageId = &#63;.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @return the matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByG_L(
		long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(groupId, languageId);
	}

	/**
	* Returns a range of all the e d functions where groupId = &#63; and languageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param start the lower bound of the range of e d functions
	* @param end the upper bound of the range of e d functions (not inclusive)
	* @return the range of matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByG_L(
		long groupId, java.lang.String languageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(groupId, languageId, start, end);
	}

	/**
	* Returns an ordered range of all the e d functions where groupId = &#63; and languageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param start the lower bound of the range of e d functions
	* @param end the upper bound of the range of e d functions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByG_L(
		long groupId, java.lang.String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L(groupId, languageId, start, end, orderByComparator);
	}

	/**
	* Returns the first e d function in the ordered set where groupId = &#63; and languageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e d function
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a matching e d function could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction findByG_L_First(
		long groupId, java.lang.String languageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException {
		return getPersistence()
				   .findByG_L_First(groupId, languageId, orderByComparator);
	}

	/**
	* Returns the last e d function in the ordered set where groupId = &#63; and languageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e d function
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a matching e d function could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction findByG_L_Last(
		long groupId, java.lang.String languageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException {
		return getPersistence()
				   .findByG_L_Last(groupId, languageId, orderByComparator);
	}

	/**
	* Returns the e d functions before and after the current e d function in the ordered set where groupId = &#63; and languageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current e d function
	* @param groupId the group ID
	* @param languageId the language ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e d function
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a e d function with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction[] findByG_L_PrevAndNext(
		long id, long groupId, java.lang.String languageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException {
		return getPersistence()
				   .findByG_L_PrevAndNext(id, groupId, languageId,
			orderByComparator);
	}

	/**
	* Returns the e d function where id = &#63; and groupId = &#63; or throws a {@link com.vportal.portlet.edirectory.NoSuchEDFunctionException} if it could not be found.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the matching e d function
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a matching e d function could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction findByF_G(
		long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException {
		return getPersistence().findByF_G(id, groupId);
	}

	/**
	* Returns the e d function where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the matching e d function, or <code>null</code> if a matching e d function could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction fetchByF_G(
		long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByF_G(id, groupId);
	}

	/**
	* Returns the e d function where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e d function, or <code>null</code> if a matching e d function could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.edirectory.model.EDFunction fetchByF_G(
		long id, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByF_G(id, groupId, retrieveFromCache);
	}

	/**
	* Returns all the e d functions.
	*
	* @return the e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e d functions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d functions
	* @param end the upper bound of the range of e d functions (not inclusive)
	* @return the range of e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e d functions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e d functions
	* @param end the upper bound of the range of e d functions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e d functions where isShowTree = &#63; from the database.
	*
	* @param isShowTree the is show tree
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsShowed(boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsShowed(isShowTree);
	}

	/**
	* Removes all the e d functions where groupId = &#63; and languageId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L(long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L(groupId, languageId);
	}

	/**
	* Removes the e d function where id = &#63; and groupId = &#63; from the database.
	*
	* @param id the ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByF_G(long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException {
		getPersistence().removeByF_G(id, groupId);
	}

	/**
	* Removes all the e d functions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e d functions where isShowTree = &#63;.
	*
	* @param isShowTree the is show tree
	* @return the number of matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsShowed(boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsShowed(isShowTree);
	}

	/**
	* Returns the number of e d functions where groupId = &#63; and languageId = &#63;.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @return the number of matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L(long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L(groupId, languageId);
	}

	/**
	* Returns the number of e d functions where id = &#63; and groupId = &#63;.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the number of matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByF_G(long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByF_G(id, groupId);
	}

	/**
	* Returns the number of e d functions.
	*
	* @return the number of e d functions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EDFunctionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EDFunctionPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.edirectory.service.ClpSerializer.getServletContextName(),
					EDFunctionPersistence.class.getName());

			ReferenceRegistry.registerReference(EDFunctionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(EDFunctionPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(EDFunctionUtil.class, "_persistence");
	}

	private static EDFunctionPersistence _persistence;
}