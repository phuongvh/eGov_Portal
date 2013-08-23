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

import com.vportal.portlet.vcms.NoSuchVcmsPARelationException;
import com.vportal.portlet.vcms.model.VcmsPARelation;
import com.vportal.portlet.vcms.model.impl.VcmsPARelationImpl;
import com.vportal.portlet.vcms.model.impl.VcmsPARelationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms p a relation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsPARelationPersistence
 * @see VcmsPARelationUtil
 * @generated
 */
public class VcmsPARelationPersistenceImpl extends BasePersistenceImpl<VcmsPARelation>
	implements VcmsPARelationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsPARelationUtil} to access the vcms p a relation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsPARelationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTION = new FinderPath(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsPARelationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPortion",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTION =
		new FinderPath(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsPARelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPortion",
			new String[] { String.class.getName() },
			VcmsPARelationModelImpl.PORTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORTION = new FinderPath(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPortion",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLE = new FinderPath(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsPARelationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByArticle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE =
		new FinderPath(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsPARelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticle",
			new String[] { String.class.getName() },
			VcmsPARelationModelImpl.ARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLE = new FinderPath(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsPARelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationModelImpl.FINDER_CACHE_ENABLED,
			VcmsPARelationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms p a relation in the entity cache if it is enabled.
	 *
	 * @param vcmsPARelation the vcms p a relation
	 */
	public void cacheResult(VcmsPARelation vcmsPARelation) {
		EntityCacheUtil.putResult(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationImpl.class, vcmsPARelation.getPrimaryKey(),
			vcmsPARelation);

		vcmsPARelation.resetOriginalValues();
	}

	/**
	 * Caches the vcms p a relations in the entity cache if it is enabled.
	 *
	 * @param vcmsPARelations the vcms p a relations
	 */
	public void cacheResult(List<VcmsPARelation> vcmsPARelations) {
		for (VcmsPARelation vcmsPARelation : vcmsPARelations) {
			if (EntityCacheUtil.getResult(
						VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
						VcmsPARelationImpl.class, vcmsPARelation.getPrimaryKey()) == null) {
				cacheResult(vcmsPARelation);
			}
			else {
				vcmsPARelation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms p a relations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsPARelationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsPARelationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms p a relation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsPARelation vcmsPARelation) {
		EntityCacheUtil.removeResult(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationImpl.class, vcmsPARelation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VcmsPARelation> vcmsPARelations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsPARelation vcmsPARelation : vcmsPARelations) {
			EntityCacheUtil.removeResult(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
				VcmsPARelationImpl.class, vcmsPARelation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vcms p a relation with the primary key. Does not add the vcms p a relation to the database.
	 *
	 * @param vcmsPARelationPK the primary key for the new vcms p a relation
	 * @return the new vcms p a relation
	 */
	public VcmsPARelation create(VcmsPARelationPK vcmsPARelationPK) {
		VcmsPARelation vcmsPARelation = new VcmsPARelationImpl();

		vcmsPARelation.setNew(true);
		vcmsPARelation.setPrimaryKey(vcmsPARelationPK);

		return vcmsPARelation;
	}

	/**
	 * Removes the vcms p a relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vcmsPARelationPK the primary key of the vcms p a relation
	 * @return the vcms p a relation that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a vcms p a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPARelation remove(VcmsPARelationPK vcmsPARelationPK)
		throws NoSuchVcmsPARelationException, SystemException {
		return remove((Serializable)vcmsPARelationPK);
	}

	/**
	 * Removes the vcms p a relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms p a relation
	 * @return the vcms p a relation that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a vcms p a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsPARelation remove(Serializable primaryKey)
		throws NoSuchVcmsPARelationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsPARelation vcmsPARelation = (VcmsPARelation)session.get(VcmsPARelationImpl.class,
					primaryKey);

			if (vcmsPARelation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsPARelationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsPARelation);
		}
		catch (NoSuchVcmsPARelationException nsee) {
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
	protected VcmsPARelation removeImpl(VcmsPARelation vcmsPARelation)
		throws SystemException {
		vcmsPARelation = toUnwrappedModel(vcmsPARelation);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsPARelation);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsPARelation);

		return vcmsPARelation;
	}

	@Override
	public VcmsPARelation updateImpl(
		com.vportal.portlet.vcms.model.VcmsPARelation vcmsPARelation,
		boolean merge) throws SystemException {
		vcmsPARelation = toUnwrappedModel(vcmsPARelation);

		boolean isNew = vcmsPARelation.isNew();

		VcmsPARelationModelImpl vcmsPARelationModelImpl = (VcmsPARelationModelImpl)vcmsPARelation;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsPARelation, merge);

			vcmsPARelation.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsPARelationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsPARelationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsPARelationModelImpl.getOriginalPortionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTION, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTION,
					args);

				args = new Object[] { vcmsPARelationModelImpl.getPortionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTION, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTION,
					args);
			}

			if ((vcmsPARelationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsPARelationModelImpl.getOriginalArticleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);

				args = new Object[] { vcmsPARelationModelImpl.getArticleId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPARelationImpl.class, vcmsPARelation.getPrimaryKey(),
			vcmsPARelation);

		return vcmsPARelation;
	}

	protected VcmsPARelation toUnwrappedModel(VcmsPARelation vcmsPARelation) {
		if (vcmsPARelation instanceof VcmsPARelationImpl) {
			return vcmsPARelation;
		}

		VcmsPARelationImpl vcmsPARelationImpl = new VcmsPARelationImpl();

		vcmsPARelationImpl.setNew(vcmsPARelation.isNew());
		vcmsPARelationImpl.setPrimaryKey(vcmsPARelation.getPrimaryKey());

		vcmsPARelationImpl.setPortionId(vcmsPARelation.getPortionId());
		vcmsPARelationImpl.setArticleId(vcmsPARelation.getArticleId());

		return vcmsPARelationImpl;
	}

	/**
	 * Returns the vcms p a relation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms p a relation
	 * @return the vcms p a relation
	 * @throws com.liferay.portal.NoSuchModelException if a vcms p a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsPARelation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((VcmsPARelationPK)primaryKey);
	}

	/**
	 * Returns the vcms p a relation with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsPARelationException} if it could not be found.
	 *
	 * @param vcmsPARelationPK the primary key of the vcms p a relation
	 * @return the vcms p a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a vcms p a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPARelation findByPrimaryKey(VcmsPARelationPK vcmsPARelationPK)
		throws NoSuchVcmsPARelationException, SystemException {
		VcmsPARelation vcmsPARelation = fetchByPrimaryKey(vcmsPARelationPK);

		if (vcmsPARelation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + vcmsPARelationPK);
			}

			throw new NoSuchVcmsPARelationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				vcmsPARelationPK);
		}

		return vcmsPARelation;
	}

	/**
	 * Returns the vcms p a relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms p a relation
	 * @return the vcms p a relation, or <code>null</code> if a vcms p a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsPARelation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((VcmsPARelationPK)primaryKey);
	}

	/**
	 * Returns the vcms p a relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vcmsPARelationPK the primary key of the vcms p a relation
	 * @return the vcms p a relation, or <code>null</code> if a vcms p a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPARelation fetchByPrimaryKey(VcmsPARelationPK vcmsPARelationPK)
		throws SystemException {
		VcmsPARelation vcmsPARelation = (VcmsPARelation)EntityCacheUtil.getResult(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
				VcmsPARelationImpl.class, vcmsPARelationPK);

		if (vcmsPARelation == _nullVcmsPARelation) {
			return null;
		}

		if (vcmsPARelation == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsPARelation = (VcmsPARelation)session.get(VcmsPARelationImpl.class,
						vcmsPARelationPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsPARelation != null) {
					cacheResult(vcmsPARelation);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsPARelationModelImpl.ENTITY_CACHE_ENABLED,
						VcmsPARelationImpl.class, vcmsPARelationPK,
						_nullVcmsPARelation);
				}

				closeSession(session);
			}
		}

		return vcmsPARelation;
	}

	/**
	 * Returns all the vcms p a relations where portionId = &#63;.
	 *
	 * @param portionId the portion ID
	 * @return the matching vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPARelation> findByPortion(String portionId)
		throws SystemException {
		return findByPortion(portionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms p a relations where portionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param portionId the portion ID
	 * @param start the lower bound of the range of vcms p a relations
	 * @param end the upper bound of the range of vcms p a relations (not inclusive)
	 * @return the range of matching vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPARelation> findByPortion(String portionId, int start,
		int end) throws SystemException {
		return findByPortion(portionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms p a relations where portionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param portionId the portion ID
	 * @param start the lower bound of the range of vcms p a relations
	 * @param end the upper bound of the range of vcms p a relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPARelation> findByPortion(String portionId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTION;
			finderArgs = new Object[] { portionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTION;
			finderArgs = new Object[] { portionId, start, end, orderByComparator };
		}

		List<VcmsPARelation> list = (List<VcmsPARelation>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSPARELATION_WHERE);

			if (portionId == null) {
				query.append(_FINDER_COLUMN_PORTION_PORTIONID_1);
			}
			else {
				if (portionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORTION_PORTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORTION_PORTIONID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsPARelationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (portionId != null) {
					qPos.add(portionId);
				}

				list = (List<VcmsPARelation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms p a relation in the ordered set where portionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param portionId the portion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms p a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a matching vcms p a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPARelation findByPortion_First(String portionId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsPARelationException, SystemException {
		List<VcmsPARelation> list = findByPortion(portionId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("portionId=");
			msg.append(portionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsPARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms p a relation in the ordered set where portionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param portionId the portion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms p a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a matching vcms p a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPARelation findByPortion_Last(String portionId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsPARelationException, SystemException {
		int count = countByPortion(portionId);

		List<VcmsPARelation> list = findByPortion(portionId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("portionId=");
			msg.append(portionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsPARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms p a relations before and after the current vcms p a relation in the ordered set where portionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vcmsPARelationPK the primary key of the current vcms p a relation
	 * @param portionId the portion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms p a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a vcms p a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPARelation[] findByPortion_PrevAndNext(
		VcmsPARelationPK vcmsPARelationPK, String portionId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsPARelationException, SystemException {
		VcmsPARelation vcmsPARelation = findByPrimaryKey(vcmsPARelationPK);

		Session session = null;

		try {
			session = openSession();

			VcmsPARelation[] array = new VcmsPARelationImpl[3];

			array[0] = getByPortion_PrevAndNext(session, vcmsPARelation,
					portionId, orderByComparator, true);

			array[1] = vcmsPARelation;

			array[2] = getByPortion_PrevAndNext(session, vcmsPARelation,
					portionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsPARelation getByPortion_PrevAndNext(Session session,
		VcmsPARelation vcmsPARelation, String portionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSPARELATION_WHERE);

		if (portionId == null) {
			query.append(_FINDER_COLUMN_PORTION_PORTIONID_1);
		}
		else {
			if (portionId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORTION_PORTIONID_3);
			}
			else {
				query.append(_FINDER_COLUMN_PORTION_PORTIONID_2);
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
			query.append(VcmsPARelationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (portionId != null) {
			qPos.add(portionId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsPARelation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsPARelation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms p a relations where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPARelation> findByArticle(String articleId)
		throws SystemException {
		return findByArticle(articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms p a relations where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms p a relations
	 * @param end the upper bound of the range of vcms p a relations (not inclusive)
	 * @return the range of matching vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPARelation> findByArticle(String articleId, int start,
		int end) throws SystemException {
		return findByArticle(articleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms p a relations where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms p a relations
	 * @param end the upper bound of the range of vcms p a relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPARelation> findByArticle(String articleId, int start,
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

		List<VcmsPARelation> list = (List<VcmsPARelation>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSPARELATION_WHERE);

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
				query.append(VcmsPARelationModelImpl.ORDER_BY_JPQL);
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

				list = (List<VcmsPARelation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms p a relation in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms p a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a matching vcms p a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPARelation findByArticle_First(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsPARelationException, SystemException {
		List<VcmsPARelation> list = findByArticle(articleId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsPARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms p a relation in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms p a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a matching vcms p a relation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPARelation findByArticle_Last(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsPARelationException, SystemException {
		int count = countByArticle(articleId);

		List<VcmsPARelation> list = findByArticle(articleId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsPARelationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms p a relations before and after the current vcms p a relation in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vcmsPARelationPK the primary key of the current vcms p a relation
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms p a relation
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPARelationException if a vcms p a relation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPARelation[] findByArticle_PrevAndNext(
		VcmsPARelationPK vcmsPARelationPK, String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsPARelationException, SystemException {
		VcmsPARelation vcmsPARelation = findByPrimaryKey(vcmsPARelationPK);

		Session session = null;

		try {
			session = openSession();

			VcmsPARelation[] array = new VcmsPARelationImpl[3];

			array[0] = getByArticle_PrevAndNext(session, vcmsPARelation,
					articleId, orderByComparator, true);

			array[1] = vcmsPARelation;

			array[2] = getByArticle_PrevAndNext(session, vcmsPARelation,
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

	protected VcmsPARelation getByArticle_PrevAndNext(Session session,
		VcmsPARelation vcmsPARelation, String articleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSPARELATION_WHERE);

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
			query.append(VcmsPARelationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsPARelation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsPARelation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms p a relations.
	 *
	 * @return the vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPARelation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms p a relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms p a relations
	 * @param end the upper bound of the range of vcms p a relations (not inclusive)
	 * @return the range of vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPARelation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms p a relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms p a relations
	 * @param end the upper bound of the range of vcms p a relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPARelation> findAll(int start, int end,
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

		List<VcmsPARelation> list = (List<VcmsPARelation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSPARELATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSPARELATION.concat(VcmsPARelationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsPARelation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsPARelation>)QueryUtil.list(q,
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
	 * Removes all the vcms p a relations where portionId = &#63; from the database.
	 *
	 * @param portionId the portion ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPortion(String portionId) throws SystemException {
		for (VcmsPARelation vcmsPARelation : findByPortion(portionId)) {
			remove(vcmsPARelation);
		}
	}

	/**
	 * Removes all the vcms p a relations where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByArticle(String articleId) throws SystemException {
		for (VcmsPARelation vcmsPARelation : findByArticle(articleId)) {
			remove(vcmsPARelation);
		}
	}

	/**
	 * Removes all the vcms p a relations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsPARelation vcmsPARelation : findAll()) {
			remove(vcmsPARelation);
		}
	}

	/**
	 * Returns the number of vcms p a relations where portionId = &#63;.
	 *
	 * @param portionId the portion ID
	 * @return the number of matching vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPortion(String portionId) throws SystemException {
		Object[] finderArgs = new Object[] { portionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PORTION,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSPARELATION_WHERE);

			if (portionId == null) {
				query.append(_FINDER_COLUMN_PORTION_PORTIONID_1);
			}
			else {
				if (portionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORTION_PORTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORTION_PORTIONID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (portionId != null) {
					qPos.add(portionId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORTION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms p a relations where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public int countByArticle(String articleId) throws SystemException {
		Object[] finderArgs = new Object[] { articleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSPARELATION_WHERE);

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
	 * Returns the number of vcms p a relations.
	 *
	 * @return the number of vcms p a relations
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSPARELATION);

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
	 * Initializes the vcms p a relation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsPARelation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsPARelation>> listenersList = new ArrayList<ModelListener<VcmsPARelation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsPARelation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsPARelationImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSPARELATION = "SELECT vcmsPARelation FROM VcmsPARelation vcmsPARelation";
	private static final String _SQL_SELECT_VCMSPARELATION_WHERE = "SELECT vcmsPARelation FROM VcmsPARelation vcmsPARelation WHERE ";
	private static final String _SQL_COUNT_VCMSPARELATION = "SELECT COUNT(vcmsPARelation) FROM VcmsPARelation vcmsPARelation";
	private static final String _SQL_COUNT_VCMSPARELATION_WHERE = "SELECT COUNT(vcmsPARelation) FROM VcmsPARelation vcmsPARelation WHERE ";
	private static final String _FINDER_COLUMN_PORTION_PORTIONID_1 = "vcmsPARelation.id.portionId IS NULL";
	private static final String _FINDER_COLUMN_PORTION_PORTIONID_2 = "vcmsPARelation.id.portionId = ?";
	private static final String _FINDER_COLUMN_PORTION_PORTIONID_3 = "(vcmsPARelation.id.portionId IS NULL OR vcmsPARelation.id.portionId = ?)";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_1 = "vcmsPARelation.id.articleId IS NULL";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_2 = "vcmsPARelation.id.articleId = ?";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_3 = "(vcmsPARelation.id.articleId IS NULL OR vcmsPARelation.id.articleId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsPARelation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsPARelation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsPARelation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsPARelationPersistenceImpl.class);
	private static VcmsPARelation _nullVcmsPARelation = new VcmsPARelationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsPARelation> toCacheModel() {
				return _nullVcmsPARelationCacheModel;
			}
		};

	private static CacheModel<VcmsPARelation> _nullVcmsPARelationCacheModel = new CacheModel<VcmsPARelation>() {
			public VcmsPARelation toEntityModel() {
				return _nullVcmsPARelation;
			}
		};
}