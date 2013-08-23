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

package com.vportal.portlet.vcms.service.persistence;

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

import com.vportal.portlet.vcms.NoSuchVcmsTARelationException;
import com.vportal.portlet.vcms.model.VcmsTARelation;
import com.vportal.portlet.vcms.model.impl.VcmsTARelationImpl;
import com.vportal.portlet.vcms.model.impl.VcmsTARelationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms t a relation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsTARelationPersistence
 * @see VcmsTARelationUtil
 * @generated
 */
public class VcmsTARelationPersistenceImpl extends BasePersistenceImpl<VcmsTARelation>
	implements VcmsTARelationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsTARelationUtil} to access the vcms t a relation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsTARelationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THREAD = new FinderPath(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsTARelationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByThread",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREAD =
		new FinderPath(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsTARelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByThread",
			new String[] { String.class.getName() },
			VcmsTARelationModelImpl.THREADID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THREAD = new FinderPath(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByThread",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLE = new FinderPath(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsTARelationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByArticle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE =
		new FinderPath(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsTARelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticle",
			new String[] { String.class.getName() },
			VcmsTARelationModelImpl.ARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLE = new FinderPath(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsTARelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsTARelationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms t a relation in the entity cache if it is enabled.
	 *
	 * @param vcmsTARelation the vcms t a relation
	 */
	public void cacheResult(VcmsTARelation vcmsTARelation) {
		EntityCacheUtil.putResult(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationImpl.class, vcmsTARelation.getPrimaryKey(),
			vcmsTARelation);

		vcmsTARelation.resetOriginalValues();
	}

	/**
	 * Caches the vcms t a relations in the entity cache if it is enabled.
	 *
	 * @param vcmsTARelations the vcms t a relations
	 */
	public void cacheResult(List<VcmsTARelation> vcmsTARelations) {
		for (VcmsTARelation vcmsTARelation : vcmsTARelations) {
			if (EntityCacheUtil.getResult(
						VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
						VcmsTARelationImpl.class, vcmsTARelation.getPrimaryKey()) == null) {
				cacheResult(vcmsTARelation);
			}
			else {
				vcmsTARelation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms t a relations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsTARelationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsTARelationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms t a relation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsTARelation vcmsTARelation) {
		EntityCacheUtil.removeResult(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationImpl.class, vcmsTARelation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VcmsTARelation> vcmsTARelations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsTARelation vcmsTARelation : vcmsTARelations) {
			EntityCacheUtil.removeResult(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
				VcmsTARelationImpl.class, vcmsTARelation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vcms t a relation with the primary key. Does not add the vcms t a relation to the database.
	 *
	 * @param vcmsTARelationPK the primary key for the new vcms t a relation
	 * @return the new vcms t a relation
	 */
	public VcmsTARelation create(VcmsTARelationPK vcmsTARelationPK) {
		VcmsTARelation vcmsTARelation = new VcmsTARelationImpl();

		vcmsTARelation.setNew(true);
		vcmsTARelation.setPrimaryKey(vcmsTARelationPK);

		return vcmsTARelation;
	}

	/**
	 * Removes the vcms t a relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vcmsTARelationPK the primary key of the vcms t a relation
	 * @return the vcms t a relation that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a vcms t a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsTARelation remove(VcmsTARelationPK vcmsTARelationPK)
		throws NoSuchVcmsTARelationException, SystemException {
		return remove((Serializable)vcmsTARelationPK);
	}

	/**
	 * Removes the vcms t a relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms t a relation
	 * @return the vcms t a relation that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a vcms t a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsTARelation remove(Serializable primaryKey)
		throws NoSuchVcmsTARelationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsTARelation vcmsTARelation = (VcmsTARelation)session.get(VcmsTARelationImpl.class,
					primaryKey);

			if (vcmsTARelation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsTARelationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsTARelation);
		}
		catch (NoSuchVcmsTARelationException nsee) {
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
	protected VcmsTARelation removeImpl(VcmsTARelation vcmsTARelation)
		throws SystemException {
		vcmsTARelation = toUnwrappedModel(vcmsTARelation);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsTARelation);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsTARelation);

		return vcmsTARelation;
	}

	@Override
	public VcmsTARelation updateImpl(
		com.vportal.portlet.vcms.model.VcmsTARelation vcmsTARelation,
		boolean merge) throws SystemException {
		vcmsTARelation = toUnwrappedModel(vcmsTARelation);

		boolean isNew = vcmsTARelation.isNew();

		VcmsTARelationModelImpl vcmsTARelationModelImpl = (VcmsTARelationModelImpl)vcmsTARelation;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsTARelation, merge);

			vcmsTARelation.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsTARelationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsTARelationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREAD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsTARelationModelImpl.getOriginalThreadId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THREAD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREAD,
					args);

				args = new Object[] { vcmsTARelationModelImpl.getThreadId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THREAD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREAD,
					args);
			}

			if ((vcmsTARelationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsTARelationModelImpl.getOriginalArticleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);

				args = new Object[] { vcmsTARelationModelImpl.getArticleId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTARelationImpl.class, vcmsTARelation.getPrimaryKey(),
			vcmsTARelation);

		return vcmsTARelation;
	}

	protected VcmsTARelation toUnwrappedModel(VcmsTARelation vcmsTARelation) {
		if (vcmsTARelation instanceof VcmsTARelationImpl) {
			return vcmsTARelation;
		}

		VcmsTARelationImpl vcmsTARelationImpl = new VcmsTARelationImpl();

		vcmsTARelationImpl.setNew(vcmsTARelation.isNew());
		vcmsTARelationImpl.setPrimaryKey(vcmsTARelation.getPrimaryKey());

		vcmsTARelationImpl.setThreadId(vcmsTARelation.getThreadId());
		vcmsTARelationImpl.setArticleId(vcmsTARelation.getArticleId());

		return vcmsTARelationImpl;
	}

	/**
	 * Returns the vcms t a relation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms t a relation
	 * @return the vcms t a relation
	 * @throws com.liferay.portal.NoSuchModelException if a vcms t a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsTARelation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((VcmsTARelationPK)primaryKey);
	}

	/**
	 * Returns the vcms t a relation with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsTARelationException} if it could not be found.
	 *
	 * @param vcmsTARelationPK the primary key of the vcms t a relation
	 * @return the vcms t a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a vcms t a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsTARelation findByPrimaryKey(VcmsTARelationPK vcmsTARelationPK)
		throws NoSuchVcmsTARelationException, SystemException {
		VcmsTARelation vcmsTARelation = fetchByPrimaryKey(vcmsTARelationPK);

		if (vcmsTARelation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + vcmsTARelationPK);
			}

			throw new NoSuchVcmsTARelationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				vcmsTARelationPK);
		}

		return vcmsTARelation;
	}

	/**
	 * Returns the vcms t a relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms t a relation
	 * @return the vcms t a relation, or <code>null</code> if a vcms t a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsTARelation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((VcmsTARelationPK)primaryKey);
	}

	/**
	 * Returns the vcms t a relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vcmsTARelationPK the primary key of the vcms t a relation
	 * @return the vcms t a relation, or <code>null</code> if a vcms t a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsTARelation fetchByPrimaryKey(VcmsTARelationPK vcmsTARelationPK)
		throws SystemException {
		VcmsTARelation vcmsTARelation = (VcmsTARelation)EntityCacheUtil.getResult(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
				VcmsTARelationImpl.class, vcmsTARelationPK);

		if (vcmsTARelation == _nullVcmsTARelation) {
			return null;
		}

		if (vcmsTARelation == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsTARelation = (VcmsTARelation)session.get(VcmsTARelationImpl.class,
						vcmsTARelationPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsTARelation != null) {
					cacheResult(vcmsTARelation);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsTARelationModelImpl.ENTITY_CACHE_ENABLED,
						VcmsTARelationImpl.class, vcmsTARelationPK,
						_nullVcmsTARelation);
				}

				closeSession(session);
			}
		}

		return vcmsTARelation;
	}

	/**
	 * Returns all the vcms t a relations where threadId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @return the matching vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsTARelation> findByThread(String threadId)
		throws SystemException {
		return findByThread(threadId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms t a relations where threadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param start the lower bound of the range of vcms t a relations
	 * @param end the upper bound of the range of vcms t a relations (not inclusive)
	 * @return the range of matching vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsTARelation> findByThread(String threadId, int start, int end)
		throws SystemException {
		return findByThread(threadId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms t a relations where threadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param start the lower bound of the range of vcms t a relations
	 * @param end the upper bound of the range of vcms t a relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsTARelation> findByThread(String threadId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THREAD;
			finderArgs = new Object[] { threadId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THREAD;
			finderArgs = new Object[] { threadId, start, end, orderByComparator };
		}

		List<VcmsTARelation> list = (List<VcmsTARelation>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSTARELATION_WHERE);

			if (threadId == null) {
				query.append(_FINDER_COLUMN_THREAD_THREADID_1);
			}
			else {
				if (threadId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_THREAD_THREADID_3);
				}
				else {
					query.append(_FINDER_COLUMN_THREAD_THREADID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsTARelationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (threadId != null) {
					qPos.add(threadId);
				}

				list = (List<VcmsTARelation>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first vcms t a relation in the ordered set where threadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms t a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a matching vcms t a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsTARelation findByThread_First(String threadId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsTARelationException, SystemException {
		List<VcmsTARelation> list = findByThread(threadId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("threadId=");
			msg.append(threadId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsTARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms t a relation in the ordered set where threadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the thread ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms t a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a matching vcms t a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsTARelation findByThread_Last(String threadId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsTARelationException, SystemException {
		int count = countByThread(threadId);

		List<VcmsTARelation> list = findByThread(threadId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("threadId=");
			msg.append(threadId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsTARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms t a relations before and after the current vcms t a relation in the ordered set where threadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vcmsTARelationPK the primary key of the current vcms t a relation
	 * @param threadId the thread ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms t a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a vcms t a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsTARelation[] findByThread_PrevAndNext(
		VcmsTARelationPK vcmsTARelationPK, String threadId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsTARelationException, SystemException {
		VcmsTARelation vcmsTARelation = findByPrimaryKey(vcmsTARelationPK);

		Session session = null;

		try {
			session = openSession();

			VcmsTARelation[] array = new VcmsTARelationImpl[3];

			array[0] = getByThread_PrevAndNext(session, vcmsTARelation,
					threadId, orderByComparator, true);

			array[1] = vcmsTARelation;

			array[2] = getByThread_PrevAndNext(session, vcmsTARelation,
					threadId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsTARelation getByThread_PrevAndNext(Session session,
		VcmsTARelation vcmsTARelation, String threadId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSTARELATION_WHERE);

		if (threadId == null) {
			query.append(_FINDER_COLUMN_THREAD_THREADID_1);
		}
		else {
			if (threadId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_THREAD_THREADID_3);
			}
			else {
				query.append(_FINDER_COLUMN_THREAD_THREADID_2);
			}
		}

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
			query.append(VcmsTARelationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (threadId != null) {
			qPos.add(threadId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsTARelation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsTARelation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms t a relations where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsTARelation> findByArticle(String articleId)
		throws SystemException {
		return findByArticle(articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms t a relations where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms t a relations
	 * @param end the upper bound of the range of vcms t a relations (not inclusive)
	 * @return the range of matching vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsTARelation> findByArticle(String articleId, int start,
		int end) throws SystemException {
		return findByArticle(articleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms t a relations where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms t a relations
	 * @param end the upper bound of the range of vcms t a relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsTARelation> findByArticle(String articleId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE;
			finderArgs = new Object[] { articleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLE;
			finderArgs = new Object[] { articleId, start, end, orderByComparator };
		}

		List<VcmsTARelation> list = (List<VcmsTARelation>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSTARELATION_WHERE);

			if (articleId == null) {
				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_1);
			}
			else {
				if (articleId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsTARelationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (articleId != null) {
					qPos.add(articleId);
				}

				list = (List<VcmsTARelation>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first vcms t a relation in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms t a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a matching vcms t a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsTARelation findByArticle_First(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsTARelationException, SystemException {
		List<VcmsTARelation> list = findByArticle(articleId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsTARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms t a relation in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms t a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a matching vcms t a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsTARelation findByArticle_Last(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsTARelationException, SystemException {
		int count = countByArticle(articleId);

		List<VcmsTARelation> list = findByArticle(articleId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsTARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms t a relations before and after the current vcms t a relation in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vcmsTARelationPK the primary key of the current vcms t a relation
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms t a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTARelationException if a vcms t a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsTARelation[] findByArticle_PrevAndNext(
		VcmsTARelationPK vcmsTARelationPK, String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsTARelationException, SystemException {
		VcmsTARelation vcmsTARelation = findByPrimaryKey(vcmsTARelationPK);

		Session session = null;

		try {
			session = openSession();

			VcmsTARelation[] array = new VcmsTARelationImpl[3];

			array[0] = getByArticle_PrevAndNext(session, vcmsTARelation,
					articleId, orderByComparator, true);

			array[1] = vcmsTARelation;

			array[2] = getByArticle_PrevAndNext(session, vcmsTARelation,
					articleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsTARelation getByArticle_PrevAndNext(Session session,
		VcmsTARelation vcmsTARelation, String articleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSTARELATION_WHERE);

		if (articleId == null) {
			query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_1);
		}
		else {
			if (articleId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_3);
			}
			else {
				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);
			}
		}

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
			query.append(VcmsTARelationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (articleId != null) {
			qPos.add(articleId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsTARelation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsTARelation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms t a relations.
	 *
	 * @return the vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsTARelation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms t a relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms t a relations
	 * @param end the upper bound of the range of vcms t a relations (not inclusive)
	 * @return the range of vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsTARelation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms t a relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms t a relations
	 * @param end the upper bound of the range of vcms t a relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsTARelation> findAll(int start, int end,
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

		List<VcmsTARelation> list = (List<VcmsTARelation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSTARELATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSTARELATION.concat(VcmsTARelationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsTARelation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsTARelation>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the vcms t a relations where threadId = &#63; from the database.
	 *
	 * @param threadId the thread ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByThread(String threadId) throws SystemException {
		for (VcmsTARelation vcmsTARelation : findByThread(threadId)) {
			remove(vcmsTARelation);
		}
	}

	/**
	 * Removes all the vcms t a relations where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByArticle(String articleId) throws SystemException {
		for (VcmsTARelation vcmsTARelation : findByArticle(articleId)) {
			remove(vcmsTARelation);
		}
	}

	/**
	 * Removes all the vcms t a relations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsTARelation vcmsTARelation : findAll()) {
			remove(vcmsTARelation);
		}
	}

	/**
	 * Returns the number of vcms t a relations where threadId = &#63;.
	 *
	 * @param threadId the thread ID
	 * @return the number of matching vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByThread(String threadId) throws SystemException {
		Object[] finderArgs = new Object[] { threadId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THREAD,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSTARELATION_WHERE);

			if (threadId == null) {
				query.append(_FINDER_COLUMN_THREAD_THREADID_1);
			}
			else {
				if (threadId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_THREAD_THREADID_3);
				}
				else {
					query.append(_FINDER_COLUMN_THREAD_THREADID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (threadId != null) {
					qPos.add(threadId);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THREAD,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms t a relations where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByArticle(String articleId) throws SystemException {
		Object[] finderArgs = new Object[] { articleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSTARELATION_WHERE);

			if (articleId == null) {
				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_1);
			}
			else {
				if (articleId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (articleId != null) {
					qPos.add(articleId);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms t a relations.
	 *
	 * @return the number of vcms t a relations
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSTARELATION);

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
	 * Initializes the vcms t a relation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsTARelation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsTARelation>> listenersList = new ArrayList<ModelListener<VcmsTARelation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsTARelation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsTARelationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = VcmsArticlePersistence.class)
	protected VcmsArticlePersistence vcmsArticlePersistence;
	@BeanReference(type = VcmsArticleStatusPersistence.class)
	protected VcmsArticleStatusPersistence vcmsArticleStatusPersistence;
	@BeanReference(type = VcmsArticleTypePersistence.class)
	protected VcmsArticleTypePersistence vcmsArticleTypePersistence;
	@BeanReference(type = VcmsArticleVersionPersistence.class)
	protected VcmsArticleVersionPersistence vcmsArticleVersionPersistence;
	@BeanReference(type = VcmsAttachedMessagePersistence.class)
	protected VcmsAttachedMessagePersistence vcmsAttachedMessagePersistence;
	@BeanReference(type = VcmsCARelationPersistence.class)
	protected VcmsCARelationPersistence vcmsCARelationPersistence;
	@BeanReference(type = VcmsCategoryPersistence.class)
	protected VcmsCategoryPersistence vcmsCategoryPersistence;
	@BeanReference(type = VcmsDiscussionPersistence.class)
	protected VcmsDiscussionPersistence vcmsDiscussionPersistence;
	@BeanReference(type = VcmsLoggerPersistence.class)
	protected VcmsLoggerPersistence vcmsLoggerPersistence;
	@BeanReference(type = VcmsPARelationPersistence.class)
	protected VcmsPARelationPersistence vcmsPARelationPersistence;
	@BeanReference(type = VcmsPortionPersistence.class)
	protected VcmsPortionPersistence vcmsPortionPersistence;
	@BeanReference(type = VcmsStatusPersistence.class)
	protected VcmsStatusPersistence vcmsStatusPersistence;
	@BeanReference(type = VcmsTARelationPersistence.class)
	protected VcmsTARelationPersistence vcmsTARelationPersistence;
	@BeanReference(type = VcmsThreadPersistence.class)
	protected VcmsThreadPersistence vcmsThreadPersistence;
	@BeanReference(type = VcmsTypePersistence.class)
	protected VcmsTypePersistence vcmsTypePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_VCMSTARELATION = "SELECT vcmsTARelation FROM VcmsTARelation vcmsTARelation";
	private static final String _SQL_SELECT_VCMSTARELATION_WHERE = "SELECT vcmsTARelation FROM VcmsTARelation vcmsTARelation WHERE ";
	private static final String _SQL_COUNT_VCMSTARELATION = "SELECT COUNT(vcmsTARelation) FROM VcmsTARelation vcmsTARelation";
	private static final String _SQL_COUNT_VCMSTARELATION_WHERE = "SELECT COUNT(vcmsTARelation) FROM VcmsTARelation vcmsTARelation WHERE ";
	private static final String _FINDER_COLUMN_THREAD_THREADID_1 = "vcmsTARelation.id.threadId IS NULL";
	private static final String _FINDER_COLUMN_THREAD_THREADID_2 = "vcmsTARelation.id.threadId = ?";
	private static final String _FINDER_COLUMN_THREAD_THREADID_3 = "(vcmsTARelation.id.threadId IS NULL OR vcmsTARelation.id.threadId = ?)";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_1 = "vcmsTARelation.id.articleId IS NULL";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_2 = "vcmsTARelation.id.articleId = ?";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_3 = "(vcmsTARelation.id.articleId IS NULL OR vcmsTARelation.id.articleId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsTARelation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsTARelation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsTARelation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsTARelationPersistenceImpl.class);
	private static VcmsTARelation _nullVcmsTARelation = new VcmsTARelationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsTARelation> toCacheModel() {
				return _nullVcmsTARelationCacheModel;
			}
		};

	private static CacheModel<VcmsTARelation> _nullVcmsTARelationCacheModel = new CacheModel<VcmsTARelation>() {
			public VcmsTARelation toEntityModel() {
				return _nullVcmsTARelation;
			}
		};
}