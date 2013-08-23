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

import com.vportal.portlet.vcms.NoSuchVcmsCARelationException;
import com.vportal.portlet.vcms.model.VcmsCARelation;
import com.vportal.portlet.vcms.model.impl.VcmsCARelationImpl;
import com.vportal.portlet.vcms.model.impl.VcmsCARelationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms c a relation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsCARelationPersistence
 * @see VcmsCARelationUtil
 * @generated
 */
public class VcmsCARelationPersistenceImpl extends BasePersistenceImpl<VcmsCARelation>
	implements VcmsCARelationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsCARelationUtil} to access the vcms c a relation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsCARelationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsCARelationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsCARelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { String.class.getName() },
			VcmsCARelationModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLE = new FinderPath(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsCARelationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByArticle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE =
		new FinderPath(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsCARelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticle",
			new String[] { String.class.getName() },
			VcmsCARelationModelImpl.ARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLE = new FinderPath(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsCARelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsCARelationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms c a relation in the entity cache if it is enabled.
	 *
	 * @param vcmsCARelation the vcms c a relation
	 */
	public void cacheResult(VcmsCARelation vcmsCARelation) {
		EntityCacheUtil.putResult(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationImpl.class, vcmsCARelation.getPrimaryKey(),
			vcmsCARelation);

		vcmsCARelation.resetOriginalValues();
	}

	/**
	 * Caches the vcms c a relations in the entity cache if it is enabled.
	 *
	 * @param vcmsCARelations the vcms c a relations
	 */
	public void cacheResult(List<VcmsCARelation> vcmsCARelations) {
		for (VcmsCARelation vcmsCARelation : vcmsCARelations) {
			if (EntityCacheUtil.getResult(
						VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
						VcmsCARelationImpl.class, vcmsCARelation.getPrimaryKey()) == null) {
				cacheResult(vcmsCARelation);
			}
			else {
				vcmsCARelation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms c a relations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsCARelationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsCARelationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms c a relation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsCARelation vcmsCARelation) {
		EntityCacheUtil.removeResult(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationImpl.class, vcmsCARelation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VcmsCARelation> vcmsCARelations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsCARelation vcmsCARelation : vcmsCARelations) {
			EntityCacheUtil.removeResult(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
				VcmsCARelationImpl.class, vcmsCARelation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vcms c a relation with the primary key. Does not add the vcms c a relation to the database.
	 *
	 * @param vcmsCARelationPK the primary key for the new vcms c a relation
	 * @return the new vcms c a relation
	 */
	public VcmsCARelation create(VcmsCARelationPK vcmsCARelationPK) {
		VcmsCARelation vcmsCARelation = new VcmsCARelationImpl();

		vcmsCARelation.setNew(true);
		vcmsCARelation.setPrimaryKey(vcmsCARelationPK);

		return vcmsCARelation;
	}

	/**
	 * Removes the vcms c a relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vcmsCARelationPK the primary key of the vcms c a relation
	 * @return the vcms c a relation that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a vcms c a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCARelation remove(VcmsCARelationPK vcmsCARelationPK)
		throws NoSuchVcmsCARelationException, SystemException {
		return remove((Serializable)vcmsCARelationPK);
	}

	/**
	 * Removes the vcms c a relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms c a relation
	 * @return the vcms c a relation that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a vcms c a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsCARelation remove(Serializable primaryKey)
		throws NoSuchVcmsCARelationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsCARelation vcmsCARelation = (VcmsCARelation)session.get(VcmsCARelationImpl.class,
					primaryKey);

			if (vcmsCARelation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsCARelationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsCARelation);
		}
		catch (NoSuchVcmsCARelationException nsee) {
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
	protected VcmsCARelation removeImpl(VcmsCARelation vcmsCARelation)
		throws SystemException {
		vcmsCARelation = toUnwrappedModel(vcmsCARelation);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsCARelation);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsCARelation);

		return vcmsCARelation;
	}

	@Override
	public VcmsCARelation updateImpl(
		com.vportal.portlet.vcms.model.VcmsCARelation vcmsCARelation,
		boolean merge) throws SystemException {
		vcmsCARelation = toUnwrappedModel(vcmsCARelation);

		boolean isNew = vcmsCARelation.isNew();

		VcmsCARelationModelImpl vcmsCARelationModelImpl = (VcmsCARelationModelImpl)vcmsCARelation;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsCARelation, merge);

			vcmsCARelation.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsCARelationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsCARelationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsCARelationModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] { vcmsCARelationModelImpl.getCategoryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}

			if ((vcmsCARelationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsCARelationModelImpl.getOriginalArticleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);

				args = new Object[] { vcmsCARelationModelImpl.getArticleId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCARelationImpl.class, vcmsCARelation.getPrimaryKey(),
			vcmsCARelation);

		return vcmsCARelation;
	}

	protected VcmsCARelation toUnwrappedModel(VcmsCARelation vcmsCARelation) {
		if (vcmsCARelation instanceof VcmsCARelationImpl) {
			return vcmsCARelation;
		}

		VcmsCARelationImpl vcmsCARelationImpl = new VcmsCARelationImpl();

		vcmsCARelationImpl.setNew(vcmsCARelation.isNew());
		vcmsCARelationImpl.setPrimaryKey(vcmsCARelation.getPrimaryKey());

		vcmsCARelationImpl.setCategoryId(vcmsCARelation.getCategoryId());
		vcmsCARelationImpl.setArticleId(vcmsCARelation.getArticleId());
		vcmsCARelationImpl.setCreatedDate(vcmsCARelation.getCreatedDate());
		vcmsCARelationImpl.setCreatedByUser(vcmsCARelation.getCreatedByUser());
		vcmsCARelationImpl.setStatus(vcmsCARelation.getStatus());

		return vcmsCARelationImpl;
	}

	/**
	 * Returns the vcms c a relation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms c a relation
	 * @return the vcms c a relation
	 * @throws com.liferay.portal.NoSuchModelException if a vcms c a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsCARelation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((VcmsCARelationPK)primaryKey);
	}

	/**
	 * Returns the vcms c a relation with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsCARelationException} if it could not be found.
	 *
	 * @param vcmsCARelationPK the primary key of the vcms c a relation
	 * @return the vcms c a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a vcms c a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCARelation findByPrimaryKey(VcmsCARelationPK vcmsCARelationPK)
		throws NoSuchVcmsCARelationException, SystemException {
		VcmsCARelation vcmsCARelation = fetchByPrimaryKey(vcmsCARelationPK);

		if (vcmsCARelation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + vcmsCARelationPK);
			}

			throw new NoSuchVcmsCARelationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				vcmsCARelationPK);
		}

		return vcmsCARelation;
	}

	/**
	 * Returns the vcms c a relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms c a relation
	 * @return the vcms c a relation, or <code>null</code> if a vcms c a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsCARelation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((VcmsCARelationPK)primaryKey);
	}

	/**
	 * Returns the vcms c a relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vcmsCARelationPK the primary key of the vcms c a relation
	 * @return the vcms c a relation, or <code>null</code> if a vcms c a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCARelation fetchByPrimaryKey(VcmsCARelationPK vcmsCARelationPK)
		throws SystemException {
		VcmsCARelation vcmsCARelation = (VcmsCARelation)EntityCacheUtil.getResult(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
				VcmsCARelationImpl.class, vcmsCARelationPK);

		if (vcmsCARelation == _nullVcmsCARelation) {
			return null;
		}

		if (vcmsCARelation == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsCARelation = (VcmsCARelation)session.get(VcmsCARelationImpl.class,
						vcmsCARelationPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsCARelation != null) {
					cacheResult(vcmsCARelation);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsCARelationModelImpl.ENTITY_CACHE_ENABLED,
						VcmsCARelationImpl.class, vcmsCARelationPK,
						_nullVcmsCARelation);
				}

				closeSession(session);
			}
		}

		return vcmsCARelation;
	}

	/**
	 * Returns all the vcms c a relations where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCARelation> findByCategory(String categoryId)
		throws SystemException {
		return findByCategory(categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms c a relations where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of vcms c a relations
	 * @param end the upper bound of the range of vcms c a relations (not inclusive)
	 * @return the range of matching vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCARelation> findByCategory(String categoryId, int start,
		int end) throws SystemException {
		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms c a relations where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of vcms c a relations
	 * @param end the upper bound of the range of vcms c a relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCARelation> findByCategory(String categoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<VcmsCARelation> list = (List<VcmsCARelation>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSCARELATION_WHERE);

			if (categoryId == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_1);
			}
			else {
				if (categoryId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_3);
				}
				else {
					query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsCARelationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (categoryId != null) {
					qPos.add(categoryId);
				}

				list = (List<VcmsCARelation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms c a relation in the ordered set where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms c a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a matching vcms c a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCARelation findByCategory_First(String categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsCARelationException, SystemException {
		List<VcmsCARelation> list = findByCategory(categoryId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms c a relation in the ordered set where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms c a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a matching vcms c a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCARelation findByCategory_Last(String categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsCARelationException, SystemException {
		int count = countByCategory(categoryId);

		List<VcmsCARelation> list = findByCategory(categoryId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms c a relations before and after the current vcms c a relation in the ordered set where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vcmsCARelationPK the primary key of the current vcms c a relation
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms c a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a vcms c a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCARelation[] findByCategory_PrevAndNext(
		VcmsCARelationPK vcmsCARelationPK, String categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsCARelationException, SystemException {
		VcmsCARelation vcmsCARelation = findByPrimaryKey(vcmsCARelationPK);

		Session session = null;

		try {
			session = openSession();

			VcmsCARelation[] array = new VcmsCARelationImpl[3];

			array[0] = getByCategory_PrevAndNext(session, vcmsCARelation,
					categoryId, orderByComparator, true);

			array[1] = vcmsCARelation;

			array[2] = getByCategory_PrevAndNext(session, vcmsCARelation,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsCARelation getByCategory_PrevAndNext(Session session,
		VcmsCARelation vcmsCARelation, String categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSCARELATION_WHERE);

		if (categoryId == null) {
			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_1);
		}
		else {
			if (categoryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_3);
			}
			else {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);
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
			query.append(VcmsCARelationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (categoryId != null) {
			qPos.add(categoryId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsCARelation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsCARelation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms c a relations where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCARelation> findByArticle(String articleId)
		throws SystemException {
		return findByArticle(articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms c a relations where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms c a relations
	 * @param end the upper bound of the range of vcms c a relations (not inclusive)
	 * @return the range of matching vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCARelation> findByArticle(String articleId, int start,
		int end) throws SystemException {
		return findByArticle(articleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms c a relations where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms c a relations
	 * @param end the upper bound of the range of vcms c a relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCARelation> findByArticle(String articleId, int start,
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

		List<VcmsCARelation> list = (List<VcmsCARelation>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSCARELATION_WHERE);

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
				query.append(VcmsCARelationModelImpl.ORDER_BY_JPQL);
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

				list = (List<VcmsCARelation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms c a relation in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms c a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a matching vcms c a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCARelation findByArticle_First(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsCARelationException, SystemException {
		List<VcmsCARelation> list = findByArticle(articleId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms c a relation in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms c a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a matching vcms c a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCARelation findByArticle_Last(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsCARelationException, SystemException {
		int count = countByArticle(articleId);

		List<VcmsCARelation> list = findByArticle(articleId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms c a relations before and after the current vcms c a relation in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vcmsCARelationPK the primary key of the current vcms c a relation
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms c a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCARelationException if a vcms c a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCARelation[] findByArticle_PrevAndNext(
		VcmsCARelationPK vcmsCARelationPK, String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsCARelationException, SystemException {
		VcmsCARelation vcmsCARelation = findByPrimaryKey(vcmsCARelationPK);

		Session session = null;

		try {
			session = openSession();

			VcmsCARelation[] array = new VcmsCARelationImpl[3];

			array[0] = getByArticle_PrevAndNext(session, vcmsCARelation,
					articleId, orderByComparator, true);

			array[1] = vcmsCARelation;

			array[2] = getByArticle_PrevAndNext(session, vcmsCARelation,
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

	protected VcmsCARelation getByArticle_PrevAndNext(Session session,
		VcmsCARelation vcmsCARelation, String articleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSCARELATION_WHERE);

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
			query.append(VcmsCARelationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsCARelation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsCARelation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms c a relations.
	 *
	 * @return the vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCARelation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms c a relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms c a relations
	 * @param end the upper bound of the range of vcms c a relations (not inclusive)
	 * @return the range of vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCARelation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms c a relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms c a relations
	 * @param end the upper bound of the range of vcms c a relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCARelation> findAll(int start, int end,
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

		List<VcmsCARelation> list = (List<VcmsCARelation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSCARELATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSCARELATION.concat(VcmsCARelationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsCARelation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsCARelation>)QueryUtil.list(q,
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
	 * Removes all the vcms c a relations where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategory(String categoryId) throws SystemException {
		for (VcmsCARelation vcmsCARelation : findByCategory(categoryId)) {
			remove(vcmsCARelation);
		}
	}

	/**
	 * Removes all the vcms c a relations where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByArticle(String articleId) throws SystemException {
		for (VcmsCARelation vcmsCARelation : findByArticle(articleId)) {
			remove(vcmsCARelation);
		}
	}

	/**
	 * Removes all the vcms c a relations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsCARelation vcmsCARelation : findAll()) {
			remove(vcmsCARelation);
		}
	}

	/**
	 * Returns the number of vcms c a relations where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategory(String categoryId) throws SystemException {
		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSCARELATION_WHERE);

			if (categoryId == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_1);
			}
			else {
				if (categoryId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_3);
				}
				else {
					query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (categoryId != null) {
					qPos.add(categoryId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms c a relations where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByArticle(String articleId) throws SystemException {
		Object[] finderArgs = new Object[] { articleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSCARELATION_WHERE);

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
	 * Returns the number of vcms c a relations.
	 *
	 * @return the number of vcms c a relations
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSCARELATION);

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
	 * Initializes the vcms c a relation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsCARelation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsCARelation>> listenersList = new ArrayList<ModelListener<VcmsCARelation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsCARelation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsCARelationImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSCARELATION = "SELECT vcmsCARelation FROM VcmsCARelation vcmsCARelation";
	private static final String _SQL_SELECT_VCMSCARELATION_WHERE = "SELECT vcmsCARelation FROM VcmsCARelation vcmsCARelation WHERE ";
	private static final String _SQL_COUNT_VCMSCARELATION = "SELECT COUNT(vcmsCARelation) FROM VcmsCARelation vcmsCARelation";
	private static final String _SQL_COUNT_VCMSCARELATION_WHERE = "SELECT COUNT(vcmsCARelation) FROM VcmsCARelation vcmsCARelation WHERE ";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_1 = "vcmsCARelation.id.categoryId IS NULL";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "vcmsCARelation.id.categoryId = ?";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_3 = "(vcmsCARelation.id.categoryId IS NULL OR vcmsCARelation.id.categoryId = ?)";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_1 = "vcmsCARelation.id.articleId IS NULL";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_2 = "vcmsCARelation.id.articleId = ?";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_3 = "(vcmsCARelation.id.articleId IS NULL OR vcmsCARelation.id.articleId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsCARelation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsCARelation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsCARelation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsCARelationPersistenceImpl.class);
	private static VcmsCARelation _nullVcmsCARelation = new VcmsCARelationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsCARelation> toCacheModel() {
				return _nullVcmsCARelationCacheModel;
			}
		};

	private static CacheModel<VcmsCARelation> _nullVcmsCARelationCacheModel = new CacheModel<VcmsCARelation>() {
			public VcmsCARelation toEntityModel() {
				return _nullVcmsCARelation;
			}
		};
}