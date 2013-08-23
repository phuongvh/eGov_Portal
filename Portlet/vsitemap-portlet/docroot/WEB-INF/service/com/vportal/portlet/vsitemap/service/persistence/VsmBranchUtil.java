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

package com.vportal.portlet.vsitemap.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.vportal.portlet.vsitemap.model.VsmBranch;

import java.util.List;

/**
 * The persistence utility for the vsm branch service. This utility wraps {@link VsmBranchPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LongLH
 * @see VsmBranchPersistence
 * @see VsmBranchPersistenceImpl
 * @generated
 */
public class VsmBranchUtil {
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
	public static void clearCache(VsmBranch vsmBranch) {
		getPersistence().clearCache(vsmBranch);
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
	public static List<VsmBranch> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VsmBranch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VsmBranch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VsmBranch update(VsmBranch vsmBranch, boolean merge)
		throws SystemException {
		return getPersistence().update(vsmBranch, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VsmBranch update(VsmBranch vsmBranch, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vsmBranch, merge, serviceContext);
	}

	/**
	* Caches the vsm branch in the entity cache if it is enabled.
	*
	* @param vsmBranch the vsm branch
	*/
	public static void cacheResult(
		com.vportal.portlet.vsitemap.model.VsmBranch vsmBranch) {
		getPersistence().cacheResult(vsmBranch);
	}

	/**
	* Caches the vsm branchs in the entity cache if it is enabled.
	*
	* @param vsmBranchs the vsm branchs
	*/
	public static void cacheResult(
		java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> vsmBranchs) {
		getPersistence().cacheResult(vsmBranchs);
	}

	/**
	* Creates a new vsm branch with the primary key. Does not add the vsm branch to the database.
	*
	* @param branchId the primary key for the new vsm branch
	* @return the new vsm branch
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch create(
		long branchId) {
		return getPersistence().create(branchId);
	}

	/**
	* Removes the vsm branch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param branchId the primary key of the vsm branch
	* @return the vsm branch that was removed
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch remove(
		long branchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence().remove(branchId);
	}

	public static com.vportal.portlet.vsitemap.model.VsmBranch updateImpl(
		com.vportal.portlet.vsitemap.model.VsmBranch vsmBranch, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vsmBranch, merge);
	}

	/**
	* Returns the vsm branch with the primary key or throws a {@link com.vportal.portlet.vsitemap.NoSuchVsmBranchException} if it could not be found.
	*
	* @param branchId the primary key of the vsm branch
	* @return the vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch findByPrimaryKey(
		long branchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence().findByPrimaryKey(branchId);
	}

	/**
	* Returns the vsm branch with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param branchId the primary key of the vsm branch
	* @return the vsm branch, or <code>null</code> if a vsm branch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch fetchByPrimaryKey(
		long branchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(branchId);
	}

	/**
	* Returns all the vsm branchs where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByParent(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParent(parentId);
	}

	/**
	* Returns a range of all the vsm branchs where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @return the range of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByParent(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParent(parentId, start, end);
	}

	/**
	* Returns an ordered range of all the vsm branchs where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByParent(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParent(parentId, start, end, orderByComparator);
	}

	/**
	* Returns the first vsm branch in the ordered set where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch findByParent_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence().findByParent_First(parentId, orderByComparator);
	}

	/**
	* Returns the last vsm branch in the ordered set where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch findByParent_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence().findByParent_Last(parentId, orderByComparator);
	}

	/**
	* Returns the vsm branchs before and after the current vsm branch in the ordered set where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param branchId the primary key of the current vsm branch
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch[] findByParent_PrevAndNext(
		long branchId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence()
				   .findByParent_PrevAndNext(branchId, parentId,
			orderByComparator);
	}

	/**
	* Returns all the vsm branchs where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByG_L(
		long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(groupId, language);
	}

	/**
	* Returns a range of all the vsm branchs where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @return the range of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByG_L(
		long groupId, java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L(groupId, language, start, end);
	}

	/**
	* Returns an ordered range of all the vsm branchs where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByG_L(
		long groupId, java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L(groupId, language, start, end, orderByComparator);
	}

	/**
	* Returns the first vsm branch in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch findByG_L_First(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence()
				   .findByG_L_First(groupId, language, orderByComparator);
	}

	/**
	* Returns the last vsm branch in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch findByG_L_Last(
		long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence()
				   .findByG_L_Last(groupId, language, orderByComparator);
	}

	/**
	* Returns the vsm branchs before and after the current vsm branch in the ordered set where groupId = &#63; and language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param branchId the primary key of the current vsm branch
	* @param groupId the group ID
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch[] findByG_L_PrevAndNext(
		long branchId, long groupId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence()
				   .findByG_L_PrevAndNext(branchId, groupId, language,
			orderByComparator);
	}

	/**
	* Returns all the vsm branchs where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @return the matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByG_L_P(
		long groupId, java.lang.String language, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_L_P(groupId, language, parentId);
	}

	/**
	* Returns a range of all the vsm branchs where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @return the range of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByG_L_P(
		long groupId, java.lang.String language, long parentId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_P(groupId, language, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the vsm branchs where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByG_L_P(
		long groupId, java.lang.String language, long parentId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_L_P(groupId, language, parentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first vsm branch in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch findByG_L_P_First(
		long groupId, java.lang.String language, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence()
				   .findByG_L_P_First(groupId, language, parentId,
			orderByComparator);
	}

	/**
	* Returns the last vsm branch in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch findByG_L_P_Last(
		long groupId, java.lang.String language, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence()
				   .findByG_L_P_Last(groupId, language, parentId,
			orderByComparator);
	}

	/**
	* Returns the vsm branchs before and after the current vsm branch in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param branchId the primary key of the current vsm branch
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch[] findByG_L_P_PrevAndNext(
		long branchId, long groupId, java.lang.String language, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence()
				   .findByG_L_P_PrevAndNext(branchId, groupId, language,
			parentId, orderByComparator);
	}

	/**
	* Returns all the vsm branchs where hasIcon = &#63;.
	*
	* @param hasIcon the has icon
	* @return the matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByIcon(
		boolean hasIcon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIcon(hasIcon);
	}

	/**
	* Returns a range of all the vsm branchs where hasIcon = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hasIcon the has icon
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @return the range of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByIcon(
		boolean hasIcon, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIcon(hasIcon, start, end);
	}

	/**
	* Returns an ordered range of all the vsm branchs where hasIcon = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hasIcon the has icon
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByIcon(
		boolean hasIcon, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIcon(hasIcon, start, end, orderByComparator);
	}

	/**
	* Returns the first vsm branch in the ordered set where hasIcon = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hasIcon the has icon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch findByIcon_First(
		boolean hasIcon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence().findByIcon_First(hasIcon, orderByComparator);
	}

	/**
	* Returns the last vsm branch in the ordered set where hasIcon = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hasIcon the has icon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch findByIcon_Last(
		boolean hasIcon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence().findByIcon_Last(hasIcon, orderByComparator);
	}

	/**
	* Returns the vsm branchs before and after the current vsm branch in the ordered set where hasIcon = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param branchId the primary key of the current vsm branch
	* @param hasIcon the has icon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch[] findByIcon_PrevAndNext(
		long branchId, boolean hasIcon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence()
				   .findByIcon_PrevAndNext(branchId, hasIcon, orderByComparator);
	}

	/**
	* Returns all the vsm branchs where language = &#63;.
	*
	* @param language the language
	* @return the matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByLanguage(
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLanguage(language);
	}

	/**
	* Returns a range of all the vsm branchs where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @return the range of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByLanguage(
		java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLanguage(language, start, end);
	}

	/**
	* Returns an ordered range of all the vsm branchs where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findByLanguage(
		java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLanguage(language, start, end, orderByComparator);
	}

	/**
	* Returns the first vsm branch in the ordered set where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch findByLanguage_First(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence().findByLanguage_First(language, orderByComparator);
	}

	/**
	* Returns the last vsm branch in the ordered set where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch findByLanguage_Last(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence().findByLanguage_Last(language, orderByComparator);
	}

	/**
	* Returns the vsm branchs before and after the current vsm branch in the ordered set where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param branchId the primary key of the current vsm branch
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vsm branch
	* @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.vportal.portlet.vsitemap.model.VsmBranch[] findByLanguage_PrevAndNext(
		long branchId, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vsitemap.NoSuchVsmBranchException {
		return getPersistence()
				   .findByLanguage_PrevAndNext(branchId, language,
			orderByComparator);
	}

	/**
	* Returns all the vsm branchs.
	*
	* @return the vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vsm branchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @return the range of vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vsm branchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vsm branchs
	* @param end the upper bound of the range of vsm branchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.vportal.portlet.vsitemap.model.VsmBranch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vsm branchs where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParent(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParent(parentId);
	}

	/**
	* Removes all the vsm branchs where groupId = &#63; and language = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L(groupId, language);
	}

	/**
	* Removes all the vsm branchs where groupId = &#63; and language = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_L_P(long groupId, java.lang.String language,
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_L_P(groupId, language, parentId);
	}

	/**
	* Removes all the vsm branchs where hasIcon = &#63; from the database.
	*
	* @param hasIcon the has icon
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIcon(boolean hasIcon)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIcon(hasIcon);
	}

	/**
	* Removes all the vsm branchs where language = &#63; from the database.
	*
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLanguage(java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLanguage(language);
	}

	/**
	* Removes all the vsm branchs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vsm branchs where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParent(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParent(parentId);
	}

	/**
	* Returns the number of vsm branchs where groupId = &#63; and language = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @return the number of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L(groupId, language);
	}

	/**
	* Returns the number of vsm branchs where groupId = &#63; and language = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param language the language
	* @param parentId the parent ID
	* @return the number of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_L_P(long groupId, java.lang.String language,
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_L_P(groupId, language, parentId);
	}

	/**
	* Returns the number of vsm branchs where hasIcon = &#63;.
	*
	* @param hasIcon the has icon
	* @return the number of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIcon(boolean hasIcon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIcon(hasIcon);
	}

	/**
	* Returns the number of vsm branchs where language = &#63;.
	*
	* @param language the language
	* @return the number of matching vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLanguage(java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLanguage(language);
	}

	/**
	* Returns the number of vsm branchs.
	*
	* @return the number of vsm branchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VsmBranchPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VsmBranchPersistence)PortletBeanLocatorUtil.locate(com.vportal.portlet.vsitemap.service.ClpSerializer.getServletContextName(),
					VsmBranchPersistence.class.getName());

			ReferenceRegistry.registerReference(VsmBranchUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VsmBranchPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VsmBranchUtil.class, "_persistence");
	}

	private static VsmBranchPersistence _persistence;
}