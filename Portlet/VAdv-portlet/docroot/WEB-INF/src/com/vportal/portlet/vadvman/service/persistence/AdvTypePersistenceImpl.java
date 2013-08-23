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

package com.vportal.portlet.vadvman.service.persistence;

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

import com.vportal.portlet.vadvman.NoSuchAdvTypeException;
import com.vportal.portlet.vadvman.model.AdvType;
import com.vportal.portlet.vadvman.model.impl.AdvTypeImpl;
import com.vportal.portlet.vadvman.model.impl.AdvTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the adv type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucNN
 * @see AdvTypePersistence
 * @see AdvTypeUtil
 * @generated
 */
public class AdvTypePersistenceImpl extends BasePersistenceImpl<AdvType>
	implements AdvTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdvTypeUtil} to access the adv type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdvTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G = new FinderPath(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
			AdvTypeModelImpl.FINDER_CACHE_ENABLED, AdvTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G = new FinderPath(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
			AdvTypeModelImpl.FINDER_CACHE_ENABLED, AdvTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG",
			new String[] { Long.class.getName() },
			AdvTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G = new FinderPath(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
			AdvTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
			AdvTypeModelImpl.FINDER_CACHE_ENABLED, AdvTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
			AdvTypeModelImpl.FINDER_CACHE_ENABLED, AdvTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
			AdvTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the adv type in the entity cache if it is enabled.
	 *
	 * @param advType the adv type
	 */
	public void cacheResult(AdvType advType) {
		EntityCacheUtil.putResult(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
			AdvTypeImpl.class, advType.getPrimaryKey(), advType);

		advType.resetOriginalValues();
	}

	/**
	 * Caches the adv types in the entity cache if it is enabled.
	 *
	 * @param advTypes the adv types
	 */
	public void cacheResult(List<AdvType> advTypes) {
		for (AdvType advType : advTypes) {
			if (EntityCacheUtil.getResult(
						AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
						AdvTypeImpl.class, advType.getPrimaryKey()) == null) {
				cacheResult(advType);
			}
			else {
				advType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all adv types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdvTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdvTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the adv type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdvType advType) {
		EntityCacheUtil.removeResult(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
			AdvTypeImpl.class, advType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdvType> advTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdvType advType : advTypes) {
			EntityCacheUtil.removeResult(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
				AdvTypeImpl.class, advType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new adv type with the primary key. Does not add the adv type to the database.
	 *
	 * @param typeId the primary key for the new adv type
	 * @return the new adv type
	 */
	public AdvType create(long typeId) {
		AdvType advType = new AdvTypeImpl();

		advType.setNew(true);
		advType.setPrimaryKey(typeId);

		return advType;
	}

	/**
	 * Removes the adv type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeId the primary key of the adv type
	 * @return the adv type that was removed
	 * @throws com.vportal.portlet.vadvman.NoSuchAdvTypeException if a adv type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdvType remove(long typeId)
		throws NoSuchAdvTypeException, SystemException {
		return remove(Long.valueOf(typeId));
	}

	/**
	 * Removes the adv type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the adv type
	 * @return the adv type that was removed
	 * @throws com.vportal.portlet.vadvman.NoSuchAdvTypeException if a adv type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvType remove(Serializable primaryKey)
		throws NoSuchAdvTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdvType advType = (AdvType)session.get(AdvTypeImpl.class, primaryKey);

			if (advType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdvTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(advType);
		}
		catch (NoSuchAdvTypeException nsee) {
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
	protected AdvType removeImpl(AdvType advType) throws SystemException {
		advType = toUnwrappedModel(advType);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, advType);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(advType);

		return advType;
	}

	@Override
	public AdvType updateImpl(
		com.vportal.portlet.vadvman.model.AdvType advType, boolean merge)
		throws SystemException {
		advType = toUnwrappedModel(advType);

		boolean isNew = advType.isNew();

		AdvTypeModelImpl advTypeModelImpl = (AdvTypeModelImpl)advType;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, advType, merge);

			advType.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdvTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((advTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(advTypeModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G,
					args);

				args = new Object[] { Long.valueOf(advTypeModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G,
					args);
			}
		}

		EntityCacheUtil.putResult(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
			AdvTypeImpl.class, advType.getPrimaryKey(), advType);

		return advType;
	}

	protected AdvType toUnwrappedModel(AdvType advType) {
		if (advType instanceof AdvTypeImpl) {
			return advType;
		}

		AdvTypeImpl advTypeImpl = new AdvTypeImpl();

		advTypeImpl.setNew(advType.isNew());
		advTypeImpl.setPrimaryKey(advType.getPrimaryKey());

		advTypeImpl.setTypeId(advType.getTypeId());
		advTypeImpl.setCreateDate(advType.getCreateDate());
		advTypeImpl.setModifiedDate(advType.getModifiedDate());
		advTypeImpl.setGroupId(advType.getGroupId());
		advTypeImpl.setCompanyId(advType.getCompanyId());
		advTypeImpl.setName(advType.getName());
		advTypeImpl.setDescription(advType.getDescription());

		return advTypeImpl;
	}

	/**
	 * Returns the adv type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the adv type
	 * @return the adv type
	 * @throws com.liferay.portal.NoSuchModelException if a adv type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the adv type with the primary key or throws a {@link com.vportal.portlet.vadvman.NoSuchAdvTypeException} if it could not be found.
	 *
	 * @param typeId the primary key of the adv type
	 * @return the adv type
	 * @throws com.vportal.portlet.vadvman.NoSuchAdvTypeException if a adv type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdvType findByPrimaryKey(long typeId)
		throws NoSuchAdvTypeException, SystemException {
		AdvType advType = fetchByPrimaryKey(typeId);

		if (advType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + typeId);
			}

			throw new NoSuchAdvTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				typeId);
		}

		return advType;
	}

	/**
	 * Returns the adv type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the adv type
	 * @return the adv type, or <code>null</code> if a adv type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the adv type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeId the primary key of the adv type
	 * @return the adv type, or <code>null</code> if a adv type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdvType fetchByPrimaryKey(long typeId) throws SystemException {
		AdvType advType = (AdvType)EntityCacheUtil.getResult(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
				AdvTypeImpl.class, typeId);

		if (advType == _nullAdvType) {
			return null;
		}

		if (advType == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				advType = (AdvType)session.get(AdvTypeImpl.class,
						Long.valueOf(typeId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (advType != null) {
					cacheResult(advType);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AdvTypeModelImpl.ENTITY_CACHE_ENABLED,
						AdvTypeImpl.class, typeId, _nullAdvType);
				}

				closeSession(session);
			}
		}

		return advType;
	}

	/**
	 * Returns all the adv types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching adv types
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdvType> findByG(long groupId) throws SystemException {
		return findByG(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the adv types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of adv types
	 * @param end the upper bound of the range of adv types (not inclusive)
	 * @return the range of matching adv types
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdvType> findByG(long groupId, int start, int end)
		throws SystemException {
		return findByG(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the adv types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of adv types
	 * @param end the upper bound of the range of adv types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching adv types
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdvType> findByG(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<AdvType> list = (List<AdvType>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_ADVTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AdvTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<AdvType>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first adv type in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching adv type
	 * @throws com.vportal.portlet.vadvman.NoSuchAdvTypeException if a matching adv type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdvType findByG_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTypeException, SystemException {
		List<AdvType> list = findByG(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAdvTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last adv type in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching adv type
	 * @throws com.vportal.portlet.vadvman.NoSuchAdvTypeException if a matching adv type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdvType findByG_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTypeException, SystemException {
		int count = countByG(groupId);

		List<AdvType> list = findByG(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchAdvTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the adv types before and after the current adv type in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param typeId the primary key of the current adv type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next adv type
	 * @throws com.vportal.portlet.vadvman.NoSuchAdvTypeException if a adv type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AdvType[] findByG_PrevAndNext(long typeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvTypeException, SystemException {
		AdvType advType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			AdvType[] array = new AdvTypeImpl[3];

			array[0] = getByG_PrevAndNext(session, advType, groupId,
					orderByComparator, true);

			array[1] = advType;

			array[2] = getByG_PrevAndNext(session, advType, groupId,
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

	protected AdvType getByG_PrevAndNext(Session session, AdvType advType,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVTYPE_WHERE);

		query.append(_FINDER_COLUMN_G_GROUPID_2);

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
			query.append(AdvTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the adv types.
	 *
	 * @return the adv types
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdvType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the adv types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of adv types
	 * @param end the upper bound of the range of adv types (not inclusive)
	 * @return the range of adv types
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdvType> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the adv types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of adv types
	 * @param end the upper bound of the range of adv types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of adv types
	 * @throws SystemException if a system exception occurred
	 */
	public List<AdvType> findAll(int start, int end,
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

		List<AdvType> list = (List<AdvType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADVTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADVTYPE.concat(AdvTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AdvType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AdvType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the adv types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG(long groupId) throws SystemException {
		for (AdvType advType : findByG(groupId)) {
			remove(advType);
		}
	}

	/**
	 * Removes all the adv types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AdvType advType : findAll()) {
			remove(advType);
		}
	}

	/**
	 * Returns the number of adv types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching adv types
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADVTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_GROUPID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of adv types.
	 *
	 * @return the number of adv types
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ADVTYPE);

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
	 * Initializes the adv type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vadvman.model.AdvType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdvType>> listenersList = new ArrayList<ModelListener<AdvType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdvType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdvTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AdvItemPersistence.class)
	protected AdvItemPersistence advItemPersistence;
	@BeanReference(type = AdvTypePersistence.class)
	protected AdvTypePersistence advTypePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ADVTYPE = "SELECT advType FROM AdvType advType";
	private static final String _SQL_SELECT_ADVTYPE_WHERE = "SELECT advType FROM AdvType advType WHERE ";
	private static final String _SQL_COUNT_ADVTYPE = "SELECT COUNT(advType) FROM AdvType advType";
	private static final String _SQL_COUNT_ADVTYPE_WHERE = "SELECT COUNT(advType) FROM AdvType advType WHERE ";
	private static final String _FINDER_COLUMN_G_GROUPID_2 = "advType.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "advType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdvType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdvType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdvTypePersistenceImpl.class);
	private static AdvType _nullAdvType = new AdvTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdvType> toCacheModel() {
				return _nullAdvTypeCacheModel;
			}
		};

	private static CacheModel<AdvType> _nullAdvTypeCacheModel = new CacheModel<AdvType>() {
			public AdvType toEntityModel() {
				return _nullAdvType;
			}
		};
}