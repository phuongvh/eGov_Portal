/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.vportal.portlet.vlinksman.NoSuchLinkGroupException;
import com.vportal.portlet.vlinksman.model.LinkGroup;
import com.vportal.portlet.vlinksman.model.impl.LinkGroupImpl;
import com.vportal.portlet.vlinksman.model.impl.LinkGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the link group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LongLH
 * @see LinkGroupPersistence
 * @see LinkGroupUtil
 * @generated
 */
public class LinkGroupPersistenceImpl extends BasePersistenceImpl<LinkGroup>
	implements LinkGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LinkGroupUtil} to access the link group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LinkGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
			LinkGroupModelImpl.FINDER_CACHE_ENABLED, LinkGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
			LinkGroupModelImpl.FINDER_CACHE_ENABLED, LinkGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygroupId",
			new String[] { Long.class.getName() },
			LinkGroupModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
			LinkGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
			LinkGroupModelImpl.FINDER_CACHE_ENABLED, LinkGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
			LinkGroupModelImpl.FINDER_CACHE_ENABLED, LinkGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
			LinkGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the link group in the entity cache if it is enabled.
	 *
	 * @param linkGroup the link group
	 */
	public void cacheResult(LinkGroup linkGroup) {
		EntityCacheUtil.putResult(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
			LinkGroupImpl.class, linkGroup.getPrimaryKey(), linkGroup);

		linkGroup.resetOriginalValues();
	}

	/**
	 * Caches the link groups in the entity cache if it is enabled.
	 *
	 * @param linkGroups the link groups
	 */
	public void cacheResult(List<LinkGroup> linkGroups) {
		for (LinkGroup linkGroup : linkGroups) {
			if (EntityCacheUtil.getResult(
						LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
						LinkGroupImpl.class, linkGroup.getPrimaryKey()) == null) {
				cacheResult(linkGroup);
			}
			else {
				linkGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all link groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LinkGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LinkGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the link group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LinkGroup linkGroup) {
		EntityCacheUtil.removeResult(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
			LinkGroupImpl.class, linkGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LinkGroup> linkGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LinkGroup linkGroup : linkGroups) {
			EntityCacheUtil.removeResult(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
				LinkGroupImpl.class, linkGroup.getPrimaryKey());
		}
	}

	/**
	 * Creates a new link group with the primary key. Does not add the link group to the database.
	 *
	 * @param linkgroupId the primary key for the new link group
	 * @return the new link group
	 */
	public LinkGroup create(long linkgroupId) {
		LinkGroup linkGroup = new LinkGroupImpl();

		linkGroup.setNew(true);
		linkGroup.setPrimaryKey(linkgroupId);

		return linkGroup;
	}

	/**
	 * Removes the link group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linkgroupId the primary key of the link group
	 * @return the link group that was removed
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinkGroupException if a link group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LinkGroup remove(long linkgroupId)
		throws NoSuchLinkGroupException, SystemException {
		return remove(Long.valueOf(linkgroupId));
	}

	/**
	 * Removes the link group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the link group
	 * @return the link group that was removed
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinkGroupException if a link group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkGroup remove(Serializable primaryKey)
		throws NoSuchLinkGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LinkGroup linkGroup = (LinkGroup)session.get(LinkGroupImpl.class,
					primaryKey);

			if (linkGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLinkGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(linkGroup);
		}
		catch (NoSuchLinkGroupException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LinkGroup removeImpl(LinkGroup linkGroup)
		throws SystemException {
		linkGroup = toUnwrappedModel(linkGroup);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, linkGroup);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(linkGroup);

		return linkGroup;
	}

	@Override
	public LinkGroup updateImpl(
		com.vportal.portlet.vlinksman.model.LinkGroup linkGroup, boolean merge)
		throws SystemException {
		linkGroup = toUnwrappedModel(linkGroup);

		boolean isNew = linkGroup.isNew();

		LinkGroupModelImpl linkGroupModelImpl = (LinkGroupModelImpl)linkGroup;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, linkGroup, merge);

			linkGroup.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LinkGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((linkGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(linkGroupModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(linkGroupModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
			LinkGroupImpl.class, linkGroup.getPrimaryKey(), linkGroup);

		return linkGroup;
	}

	protected LinkGroup toUnwrappedModel(LinkGroup linkGroup) {
		if (linkGroup instanceof LinkGroupImpl) {
			return linkGroup;
		}

		LinkGroupImpl linkGroupImpl = new LinkGroupImpl();

		linkGroupImpl.setNew(linkGroup.isNew());
		linkGroupImpl.setPrimaryKey(linkGroup.getPrimaryKey());

		linkGroupImpl.setLinkgroupId(linkGroup.getLinkgroupId());
		linkGroupImpl.setGroupId(linkGroup.getGroupId());
		linkGroupImpl.setCompanyId(linkGroup.getCompanyId());
		linkGroupImpl.setCreatedDate(linkGroup.getCreatedDate());
		linkGroupImpl.setModifiedDate(linkGroup.getModifiedDate());
		linkGroupImpl.setName(linkGroup.getName());
		linkGroupImpl.setDescription(linkGroup.getDescription());

		return linkGroupImpl;
	}

	/**
	 * Returns the link group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the link group
	 * @return the link group
	 * @throws com.liferay.portal.NoSuchModelException if a link group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the link group with the primary key or throws a {@link com.vportal.portlet.vlinksman.NoSuchLinkGroupException} if it could not be found.
	 *
	 * @param linkgroupId the primary key of the link group
	 * @return the link group
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinkGroupException if a link group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LinkGroup findByPrimaryKey(long linkgroupId)
		throws NoSuchLinkGroupException, SystemException {
		LinkGroup linkGroup = fetchByPrimaryKey(linkgroupId);

		if (linkGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + linkgroupId);
			}

			throw new NoSuchLinkGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				linkgroupId);
		}

		return linkGroup;
	}

	/**
	 * Returns the link group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the link group
	 * @return the link group, or <code>null</code> if a link group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LinkGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the link group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linkgroupId the primary key of the link group
	 * @return the link group, or <code>null</code> if a link group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LinkGroup fetchByPrimaryKey(long linkgroupId)
		throws SystemException {
		LinkGroup linkGroup = (LinkGroup)EntityCacheUtil.getResult(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
				LinkGroupImpl.class, linkgroupId);

		if (linkGroup == _nullLinkGroup) {
			return null;
		}

		if (linkGroup == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				linkGroup = (LinkGroup)session.get(LinkGroupImpl.class,
						Long.valueOf(linkgroupId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (linkGroup != null) {
					cacheResult(linkGroup);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LinkGroupModelImpl.ENTITY_CACHE_ENABLED,
						LinkGroupImpl.class, linkgroupId, _nullLinkGroup);
				}

				closeSession(session);
			}
		}

		return linkGroup;
	}

	/**
	 * Returns all the link groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching link groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<LinkGroup> findBygroupId(long groupId)
		throws SystemException {
		return findBygroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link groups
	 * @param end the upper bound of the range of link groups (not inclusive)
	 * @return the range of matching link groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<LinkGroup> findBygroupId(long groupId, int start, int end)
		throws SystemException {
		return findBygroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the link groups where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of link groups
	 * @param end the upper bound of the range of link groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching link groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<LinkGroup> findBygroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<LinkGroup> list = (List<LinkGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LINKGROUP_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(LinkGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LinkGroup>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first link group in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link group
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinkGroupException if a matching link group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LinkGroup findBygroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinkGroupException, SystemException {
		List<LinkGroup> list = findBygroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkGroupException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last link group in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link group
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinkGroupException if a matching link group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LinkGroup findBygroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLinkGroupException, SystemException {
		int count = countBygroupId(groupId);

		List<LinkGroup> list = findBygroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkGroupException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the link groups before and after the current link group in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkgroupId the primary key of the current link group
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link group
	 * @throws com.vportal.portlet.vlinksman.NoSuchLinkGroupException if a link group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LinkGroup[] findBygroupId_PrevAndNext(long linkgroupId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLinkGroupException, SystemException {
		LinkGroup linkGroup = findByPrimaryKey(linkgroupId);

		Session session = null;

		try {
			session = openSession();

			LinkGroup[] array = new LinkGroupImpl[3];

			array[0] = getBygroupId_PrevAndNext(session, linkGroup, groupId,
					orderByComparator, true);

			array[1] = linkGroup;

			array[2] = getBygroupId_PrevAndNext(session, linkGroup, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LinkGroup getBygroupId_PrevAndNext(Session session,
		LinkGroup linkGroup, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINKGROUP_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(LinkGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(linkGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LinkGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the link groups.
	 *
	 * @return the link groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<LinkGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the link groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of link groups
	 * @param end the upper bound of the range of link groups (not inclusive)
	 * @return the range of link groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<LinkGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the link groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of link groups
	 * @param end the upper bound of the range of link groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of link groups
	 * @throws SystemException if a system exception occurred
	 */
	public List<LinkGroup> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<LinkGroup> list = (List<LinkGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LINKGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LINKGROUP.concat(LinkGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LinkGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LinkGroup>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the link groups where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBygroupId(long groupId) throws SystemException {
		for (LinkGroup linkGroup : findBygroupId(groupId)) {
			remove(linkGroup);
		}
	}

	/**
	 * Removes all the link groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LinkGroup linkGroup : findAll()) {
			remove(linkGroup);
		}
	}

	/**
	 * Returns the number of link groups where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching link groups
	 * @throws SystemException if a system exception occurred
	 */
	public int countBygroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINKGROUP_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of link groups.
	 *
	 * @return the number of link groups
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LINKGROUP);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the link group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vlinksman.model.LinkGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LinkGroup>> listenersList = new ArrayList<ModelListener<LinkGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LinkGroup>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LinkGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LinkGroupPersistence.class)
	protected LinkGroupPersistence linkGroupPersistence;
	@BeanReference(type = LinksPersistence.class)
	protected LinksPersistence linksPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LINKGROUP = "SELECT linkGroup FROM LinkGroup linkGroup";
	private static final String _SQL_SELECT_LINKGROUP_WHERE = "SELECT linkGroup FROM LinkGroup linkGroup WHERE ";
	private static final String _SQL_COUNT_LINKGROUP = "SELECT COUNT(linkGroup) FROM LinkGroup linkGroup";
	private static final String _SQL_COUNT_LINKGROUP_WHERE = "SELECT COUNT(linkGroup) FROM LinkGroup linkGroup WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "linkGroup.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "linkGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LinkGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LinkGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LinkGroupPersistenceImpl.class);
	private static LinkGroup _nullLinkGroup = new LinkGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LinkGroup> toCacheModel() {
				return _nullLinkGroupCacheModel;
			}
		};

	private static CacheModel<LinkGroup> _nullLinkGroupCacheModel = new CacheModel<LinkGroup>() {
			public LinkGroup toEntityModel() {
				return _nullLinkGroup;
			}
		};
}