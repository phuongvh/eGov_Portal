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

import com.liferay.portal.service.persistence.BasePersistence;

import com.vportal.portlet.edirectory.model.EDFunction;

/**
 * The persistence interface for the e d function service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see EDFunctionPersistenceImpl
 * @see EDFunctionUtil
 * @generated
 */
public interface EDFunctionPersistence extends BasePersistence<EDFunction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EDFunctionUtil} to access the e d function persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the e d function in the entity cache if it is enabled.
	*
	* @param edFunction the e d function
	*/
	public void cacheResult(
		com.vportal.portlet.edirectory.model.EDFunction edFunction);

	/**
	* Caches the e d functions in the entity cache if it is enabled.
	*
	* @param edFunctions the e d functions
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.edirectory.model.EDFunction> edFunctions);

	/**
	* Creates a new e d function with the primary key. Does not add the e d function to the database.
	*
	* @param id the primary key for the new e d function
	* @return the new e d function
	*/
	public com.vportal.portlet.edirectory.model.EDFunction create(long id);

	/**
	* Removes the e d function with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e d function
	* @return the e d function that was removed
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a e d function with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunction remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException;

	public com.vportal.portlet.edirectory.model.EDFunction updateImpl(
		com.vportal.portlet.edirectory.model.EDFunction edFunction,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e d function with the primary key or throws a {@link com.vportal.portlet.edirectory.NoSuchEDFunctionException} if it could not be found.
	*
	* @param id the primary key of the e d function
	* @return the e d function
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a e d function with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunction findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException;

	/**
	* Returns the e d function with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the e d function
	* @return the e d function, or <code>null</code> if a e d function with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunction fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e d functions where isShowTree = &#63;.
	*
	* @param isShowTree the is show tree
	* @return the matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByIsShowed(
		boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByIsShowed(
		boolean isShowTree, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByIsShowed(
		boolean isShowTree, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.edirectory.model.EDFunction findByIsShowed_First(
		boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException;

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
	public com.vportal.portlet.edirectory.model.EDFunction findByIsShowed_Last(
		boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException;

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
	public com.vportal.portlet.edirectory.model.EDFunction[] findByIsShowed_PrevAndNext(
		long id, boolean isShowTree,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException;

	/**
	* Returns all the e d functions where groupId = &#63; and languageId = &#63;.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @return the matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByG_L(
		long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByG_L(
		long groupId, java.lang.String languageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findByG_L(
		long groupId, java.lang.String languageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.vportal.portlet.edirectory.model.EDFunction findByG_L_First(
		long groupId, java.lang.String languageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException;

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
	public com.vportal.portlet.edirectory.model.EDFunction findByG_L_Last(
		long groupId, java.lang.String languageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException;

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
	public com.vportal.portlet.edirectory.model.EDFunction[] findByG_L_PrevAndNext(
		long id, long groupId, java.lang.String languageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException;

	/**
	* Returns the e d function where id = &#63; and groupId = &#63; or throws a {@link com.vportal.portlet.edirectory.NoSuchEDFunctionException} if it could not be found.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the matching e d function
	* @throws com.vportal.portlet.edirectory.NoSuchEDFunctionException if a matching e d function could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunction findByF_G(long id,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException;

	/**
	* Returns the e d function where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the matching e d function, or <code>null</code> if a matching e d function could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunction fetchByF_G(long id,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e d function where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e d function, or <code>null</code> if a matching e d function could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.edirectory.model.EDFunction fetchByF_G(long id,
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e d functions.
	*
	* @return the e d functions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.vportal.portlet.edirectory.model.EDFunction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d functions where isShowTree = &#63; from the database.
	*
	* @param isShowTree the is show tree
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIsShowed(boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e d functions where groupId = &#63; and languageId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_L(long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e d function where id = &#63; and groupId = &#63; from the database.
	*
	* @param id the ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByF_G(long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.edirectory.NoSuchEDFunctionException;

	/**
	* Removes all the e d functions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d functions where isShowTree = &#63;.
	*
	* @param isShowTree the is show tree
	* @return the number of matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public int countByIsShowed(boolean isShowTree)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d functions where groupId = &#63; and languageId = &#63;.
	*
	* @param groupId the group ID
	* @param languageId the language ID
	* @return the number of matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_L(long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d functions where id = &#63; and groupId = &#63;.
	*
	* @param id the ID
	* @param groupId the group ID
	* @return the number of matching e d functions
	* @throws SystemException if a system exception occurred
	*/
	public int countByF_G(long id, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e d functions.
	*
	* @return the number of e d functions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}