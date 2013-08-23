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

package com.vportal.portlet.vlinksman.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.vportal.portlet.vlinksman.model.Links;

/**
 * The persistence interface for the links service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LongLH
 * @see LinksPersistenceImpl
 * @see LinksUtil
 * @generated
 */
public interface LinksPersistence extends BasePersistence<Links> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LinksUtil} to access the links persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the links in the entity cache if it is enabled.
	*
	* @param links the links
	*/
	public void cacheResult(com.vportal.portlet.vlinksman.model.Links links);

	/**
	* Caches the linkses in the entity cache if it is enabled.
	*
	* @param linkses the linkses
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vlinksman.model.Links> linkses);

	/**
	* Creates a new links with the primary key. Does not add the links to the database.
	*
	* @param linkId the primary key for the new links
	* @return the new links
	*/
	public com.vportal.portlet.vlinksman.model.Links create(long linkId);

	/**
	* Removes the links with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkId the primary key of the links
	* @return the links that was removed
	* @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a links with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links remove(long linkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinksException;

	public com.vportal.portlet.vlinksman.model.Links updateImpl(
		com.vportal.portlet.vlinksman.model.Links links, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the links with the primary key or throws a {@link com.vportal.portlet.vlinksman.NoSuchLinksException} if it could not be found.
	*
	* @param linkId the primary key of the links
	* @return the links
	* @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a links with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links findByPrimaryKey(
		long linkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinksException;

	/**
	* Returns the links with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param linkId the primary key of the links
	* @return the links, or <code>null</code> if a links with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links fetchByPrimaryKey(
		long linkId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the linkses where linkgroupId = &#63;.
	*
	* @param linkgroupId the linkgroup ID
	* @return the matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findBylinkgroupId(
		long linkgroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the linkses where linkgroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param linkgroupId the linkgroup ID
	* @param start the lower bound of the range of linkses
	* @param end the upper bound of the range of linkses (not inclusive)
	* @return the range of matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findBylinkgroupId(
		long linkgroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the linkses where linkgroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param linkgroupId the linkgroup ID
	* @param start the lower bound of the range of linkses
	* @param end the upper bound of the range of linkses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findBylinkgroupId(
		long linkgroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first links in the ordered set where linkgroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param linkgroupId the linkgroup ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching links
	* @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links findBylinkgroupId_First(
		long linkgroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinksException;

	/**
	* Returns the last links in the ordered set where linkgroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param linkgroupId the linkgroup ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching links
	* @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links findBylinkgroupId_Last(
		long linkgroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinksException;

	/**
	* Returns the linkses before and after the current links in the ordered set where linkgroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param linkId the primary key of the current links
	* @param linkgroupId the linkgroup ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next links
	* @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a links with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links[] findBylinkgroupId_PrevAndNext(
		long linkId, long linkgroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinksException;

	/**
	* Returns all the linkses where groupId = &#63; and linkgroupId = &#63;.
	*
	* @param groupId the group ID
	* @param linkgroupId the linkgroup ID
	* @return the matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findByG_LG(
		long groupId, long linkgroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the linkses where groupId = &#63; and linkgroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param linkgroupId the linkgroup ID
	* @param start the lower bound of the range of linkses
	* @param end the upper bound of the range of linkses (not inclusive)
	* @return the range of matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findByG_LG(
		long groupId, long linkgroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the linkses where groupId = &#63; and linkgroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param linkgroupId the linkgroup ID
	* @param start the lower bound of the range of linkses
	* @param end the upper bound of the range of linkses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findByG_LG(
		long groupId, long linkgroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first links in the ordered set where groupId = &#63; and linkgroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param linkgroupId the linkgroup ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching links
	* @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links findByG_LG_First(
		long groupId, long linkgroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinksException;

	/**
	* Returns the last links in the ordered set where groupId = &#63; and linkgroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param linkgroupId the linkgroup ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching links
	* @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links findByG_LG_Last(
		long groupId, long linkgroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinksException;

	/**
	* Returns the linkses before and after the current links in the ordered set where groupId = &#63; and linkgroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param linkId the primary key of the current links
	* @param groupId the group ID
	* @param linkgroupId the linkgroup ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next links
	* @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a links with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links[] findByG_LG_PrevAndNext(
		long linkId, long groupId, long linkgroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinksException;

	/**
	* Returns all the linkses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the linkses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of linkses
	* @param end the upper bound of the range of linkses (not inclusive)
	* @return the range of matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the linkses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of linkses
	* @param end the upper bound of the range of linkses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first links in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching links
	* @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinksException;

	/**
	* Returns the last links in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching links
	* @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a matching links could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinksException;

	/**
	* Returns the linkses before and after the current links in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param linkId the primary key of the current links
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next links
	* @throws com.vportal.portlet.vlinksman.NoSuchLinksException if a links with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vlinksman.model.Links[] findByGroupId_PrevAndNext(
		long linkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vlinksman.NoSuchLinksException;

	/**
	* Returns all the linkses.
	*
	* @return the linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the linkses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of linkses
	* @param end the upper bound of the range of linkses (not inclusive)
	* @return the range of linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the linkses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of linkses
	* @param end the upper bound of the range of linkses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of linkses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vlinksman.model.Links> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the linkses where linkgroupId = &#63; from the database.
	*
	* @param linkgroupId the linkgroup ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBylinkgroupId(long linkgroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the linkses where groupId = &#63; and linkgroupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param linkgroupId the linkgroup ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_LG(long groupId, long linkgroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the linkses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the linkses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of linkses where linkgroupId = &#63;.
	*
	* @param linkgroupId the linkgroup ID
	* @return the number of matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public int countBylinkgroupId(long linkgroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of linkses where groupId = &#63; and linkgroupId = &#63;.
	*
	* @param groupId the group ID
	* @param linkgroupId the linkgroup ID
	* @return the number of matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_LG(long groupId, long linkgroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of linkses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching linkses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of linkses.
	*
	* @return the number of linkses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}