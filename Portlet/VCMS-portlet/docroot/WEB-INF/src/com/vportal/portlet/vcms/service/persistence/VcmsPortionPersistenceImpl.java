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

import com.vportal.portlet.vcms.NoSuchVcmsPortionException;
import com.vportal.portlet.vcms.model.VcmsPortion;
import com.vportal.portlet.vcms.model.impl.VcmsPortionImpl;
import com.vportal.portlet.vcms.model.impl.VcmsPortionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms portion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsPortionPersistence
 * @see VcmsPortionUtil
 * @generated
 */
public class VcmsPortionPersistenceImpl extends BasePersistenceImpl<VcmsPortion>
	implements VcmsPortionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsPortionUtil} to access the vcms portion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsPortionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_CATEGORIZABLE = new FinderPath(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionModelImpl.FINDER_CACHE_ENABLED, VcmsPortionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCategorizable",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			VcmsPortionModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsPortionModelImpl.CATEGORIZABLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORIZABLE = new FinderPath(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategorizable",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_S_C = new FinderPath(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionModelImpl.FINDER_CACHE_ENABLED, VcmsPortionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByS_C",
			new String[] { Long.class.getName(), String.class.getName() },
			VcmsPortionModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsPortionModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_C = new FinderPath(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_C",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_L = new FinderPath(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionModelImpl.FINDER_CACHE_ENABLED, VcmsPortionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_L = new FinderPath(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionModelImpl.FINDER_CACHE_ENABLED, VcmsPortionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_L",
			new String[] { Long.class.getName(), String.class.getName() },
			VcmsPortionModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsPortionModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_L = new FinderPath(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_L",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionModelImpl.FINDER_CACHE_ENABLED, VcmsPortionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionModelImpl.FINDER_CACHE_ENABLED, VcmsPortionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms portion in the entity cache if it is enabled.
	 *
	 * @param vcmsPortion the vcms portion
	 */
	public void cacheResult(VcmsPortion vcmsPortion) {
		EntityCacheUtil.putResult(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionImpl.class, vcmsPortion.getPrimaryKey(), vcmsPortion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORIZABLE,
			new Object[] {
				Long.valueOf(vcmsPortion.getGroupId()),
				Boolean.valueOf(vcmsPortion.getCategorizable())
			}, vcmsPortion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_C,
			new Object[] {
				Long.valueOf(vcmsPortion.getGroupId()),
				
			vcmsPortion.getCode()
			}, vcmsPortion);

		vcmsPortion.resetOriginalValues();
	}

	/**
	 * Caches the vcms portions in the entity cache if it is enabled.
	 *
	 * @param vcmsPortions the vcms portions
	 */
	public void cacheResult(List<VcmsPortion> vcmsPortions) {
		for (VcmsPortion vcmsPortion : vcmsPortions) {
			if (EntityCacheUtil.getResult(
						VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
						VcmsPortionImpl.class, vcmsPortion.getPrimaryKey()) == null) {
				cacheResult(vcmsPortion);
			}
			else {
				vcmsPortion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms portions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsPortionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsPortionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms portion.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsPortion vcmsPortion) {
		EntityCacheUtil.removeResult(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionImpl.class, vcmsPortion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(vcmsPortion);
	}

	@Override
	public void clearCache(List<VcmsPortion> vcmsPortions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsPortion vcmsPortion : vcmsPortions) {
			EntityCacheUtil.removeResult(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
				VcmsPortionImpl.class, vcmsPortion.getPrimaryKey());

			clearUniqueFindersCache(vcmsPortion);
		}
	}

	protected void clearUniqueFindersCache(VcmsPortion vcmsPortion) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORIZABLE,
			new Object[] {
				Long.valueOf(vcmsPortion.getGroupId()),
				Boolean.valueOf(vcmsPortion.getCategorizable())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_C,
			new Object[] {
				Long.valueOf(vcmsPortion.getGroupId()),
				
			vcmsPortion.getCode()
			});
	}

	/**
	 * Creates a new vcms portion with the primary key. Does not add the vcms portion to the database.
	 *
	 * @param portionId the primary key for the new vcms portion
	 * @return the new vcms portion
	 */
	public VcmsPortion create(String portionId) {
		VcmsPortion vcmsPortion = new VcmsPortionImpl();

		vcmsPortion.setNew(true);
		vcmsPortion.setPrimaryKey(portionId);

		return vcmsPortion;
	}

	/**
	 * Removes the vcms portion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portionId the primary key of the vcms portion
	 * @return the vcms portion that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a vcms portion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion remove(String portionId)
		throws NoSuchVcmsPortionException, SystemException {
		return remove((Serializable)portionId);
	}

	/**
	 * Removes the vcms portion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms portion
	 * @return the vcms portion that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a vcms portion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsPortion remove(Serializable primaryKey)
		throws NoSuchVcmsPortionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsPortion vcmsPortion = (VcmsPortion)session.get(VcmsPortionImpl.class,
					primaryKey);

			if (vcmsPortion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsPortionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsPortion);
		}
		catch (NoSuchVcmsPortionException nsee) {
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
	protected VcmsPortion removeImpl(VcmsPortion vcmsPortion)
		throws SystemException {
		vcmsPortion = toUnwrappedModel(vcmsPortion);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsPortion);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsPortion);

		return vcmsPortion;
	}

	@Override
	public VcmsPortion updateImpl(
		com.vportal.portlet.vcms.model.VcmsPortion vcmsPortion, boolean merge)
		throws SystemException {
		vcmsPortion = toUnwrappedModel(vcmsPortion);

		boolean isNew = vcmsPortion.isNew();

		VcmsPortionModelImpl vcmsPortionModelImpl = (VcmsPortionModelImpl)vcmsPortion;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsPortion, merge);

			vcmsPortion.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsPortionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsPortionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsPortionModelImpl.getOriginalGroupId()),
						
						vcmsPortionModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_L,
					args);

				args = new Object[] {
						Long.valueOf(vcmsPortionModelImpl.getGroupId()),
						
						vcmsPortionModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_L,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsPortionImpl.class, vcmsPortion.getPrimaryKey(), vcmsPortion);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORIZABLE,
				new Object[] {
					Long.valueOf(vcmsPortion.getGroupId()),
					Boolean.valueOf(vcmsPortion.getCategorizable())
				}, vcmsPortion);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_C,
				new Object[] {
					Long.valueOf(vcmsPortion.getGroupId()),
					
				vcmsPortion.getCode()
				}, vcmsPortion);
		}
		else {
			if ((vcmsPortionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CATEGORIZABLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsPortionModelImpl.getOriginalGroupId()),
						Boolean.valueOf(vcmsPortionModelImpl.getOriginalCategorizable())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORIZABLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORIZABLE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORIZABLE,
					new Object[] {
						Long.valueOf(vcmsPortion.getGroupId()),
						Boolean.valueOf(vcmsPortion.getCategorizable())
					}, vcmsPortion);
			}

			if ((vcmsPortionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_S_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsPortionModelImpl.getOriginalGroupId()),
						
						vcmsPortionModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_C, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_C,
					new Object[] {
						Long.valueOf(vcmsPortion.getGroupId()),
						
					vcmsPortion.getCode()
					}, vcmsPortion);
			}
		}

		return vcmsPortion;
	}

	protected VcmsPortion toUnwrappedModel(VcmsPortion vcmsPortion) {
		if (vcmsPortion instanceof VcmsPortionImpl) {
			return vcmsPortion;
		}

		VcmsPortionImpl vcmsPortionImpl = new VcmsPortionImpl();

		vcmsPortionImpl.setNew(vcmsPortion.isNew());
		vcmsPortionImpl.setPrimaryKey(vcmsPortion.getPrimaryKey());

		vcmsPortionImpl.setPortionId(vcmsPortion.getPortionId());
		vcmsPortionImpl.setGroupId(vcmsPortion.getGroupId());
		vcmsPortionImpl.setCompanyId(vcmsPortion.getCompanyId());
		vcmsPortionImpl.setCreatedDate(vcmsPortion.getCreatedDate());
		vcmsPortionImpl.setCreatedByUser(vcmsPortion.getCreatedByUser());
		vcmsPortionImpl.setModifiedDate(vcmsPortion.getModifiedDate());
		vcmsPortionImpl.setModifiedByUser(vcmsPortion.getModifiedByUser());
		vcmsPortionImpl.setCode(vcmsPortion.getCode());
		vcmsPortionImpl.setName(vcmsPortion.getName());
		vcmsPortionImpl.setDescription(vcmsPortion.getDescription());
		vcmsPortionImpl.setCategorizable(vcmsPortion.isCategorizable());
		vcmsPortionImpl.setLanguage(vcmsPortion.getLanguage());

		return vcmsPortionImpl;
	}

	/**
	 * Returns the vcms portion with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms portion
	 * @return the vcms portion
	 * @throws com.liferay.portal.NoSuchModelException if a vcms portion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsPortion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms portion with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsPortionException} if it could not be found.
	 *
	 * @param portionId the primary key of the vcms portion
	 * @return the vcms portion
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a vcms portion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion findByPrimaryKey(String portionId)
		throws NoSuchVcmsPortionException, SystemException {
		VcmsPortion vcmsPortion = fetchByPrimaryKey(portionId);

		if (vcmsPortion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + portionId);
			}

			throw new NoSuchVcmsPortionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				portionId);
		}

		return vcmsPortion;
	}

	/**
	 * Returns the vcms portion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms portion
	 * @return the vcms portion, or <code>null</code> if a vcms portion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsPortion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms portion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param portionId the primary key of the vcms portion
	 * @return the vcms portion, or <code>null</code> if a vcms portion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion fetchByPrimaryKey(String portionId)
		throws SystemException {
		VcmsPortion vcmsPortion = (VcmsPortion)EntityCacheUtil.getResult(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
				VcmsPortionImpl.class, portionId);

		if (vcmsPortion == _nullVcmsPortion) {
			return null;
		}

		if (vcmsPortion == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsPortion = (VcmsPortion)session.get(VcmsPortionImpl.class,
						portionId);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsPortion != null) {
					cacheResult(vcmsPortion);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsPortionModelImpl.ENTITY_CACHE_ENABLED,
						VcmsPortionImpl.class, portionId, _nullVcmsPortion);
				}

				closeSession(session);
			}
		}

		return vcmsPortion;
	}

	/**
	 * Returns the vcms portion where groupId = &#63; and categorizable = &#63; or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsPortionException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param categorizable the categorizable
	 * @return the matching vcms portion
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a matching vcms portion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion findByCategorizable(long groupId, boolean categorizable)
		throws NoSuchVcmsPortionException, SystemException {
		VcmsPortion vcmsPortion = fetchByCategorizable(groupId, categorizable);

		if (vcmsPortion == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", categorizable=");
			msg.append(categorizable);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVcmsPortionException(msg.toString());
		}

		return vcmsPortion;
	}

	/**
	 * Returns the vcms portion where groupId = &#63; and categorizable = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param categorizable the categorizable
	 * @return the matching vcms portion, or <code>null</code> if a matching vcms portion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion fetchByCategorizable(long groupId, boolean categorizable)
		throws SystemException {
		return fetchByCategorizable(groupId, categorizable, true);
	}

	/**
	 * Returns the vcms portion where groupId = &#63; and categorizable = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param categorizable the categorizable
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching vcms portion, or <code>null</code> if a matching vcms portion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion fetchByCategorizable(long groupId,
		boolean categorizable, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, categorizable };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CATEGORIZABLE,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VCMSPORTION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORIZABLE_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORIZABLE_CATEGORIZABLE_2);

			query.append(VcmsPortionModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categorizable);

				List<VcmsPortion> list = q.list();

				result = list;

				VcmsPortion vcmsPortion = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORIZABLE,
						finderArgs, list);
				}
				else {
					vcmsPortion = list.get(0);

					cacheResult(vcmsPortion);

					if ((vcmsPortion.getGroupId() != groupId) ||
							(vcmsPortion.getCategorizable() != categorizable)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORIZABLE,
							finderArgs, vcmsPortion);
					}
				}

				return vcmsPortion;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORIZABLE,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (VcmsPortion)result;
			}
		}
	}

	/**
	 * Returns the vcms portion where groupId = &#63; and code = &#63; or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsPortionException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param code the code
	 * @return the matching vcms portion
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a matching vcms portion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion findByS_C(long groupId, String code)
		throws NoSuchVcmsPortionException, SystemException {
		VcmsPortion vcmsPortion = fetchByS_C(groupId, code);

		if (vcmsPortion == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVcmsPortionException(msg.toString());
		}

		return vcmsPortion;
	}

	/**
	 * Returns the vcms portion where groupId = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param code the code
	 * @return the matching vcms portion, or <code>null</code> if a matching vcms portion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion fetchByS_C(long groupId, String code)
		throws SystemException {
		return fetchByS_C(groupId, code, true);
	}

	/**
	 * Returns the vcms portion where groupId = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching vcms portion, or <code>null</code> if a matching vcms portion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion fetchByS_C(long groupId, String code,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_S_C,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VCMSPORTION_WHERE);

			query.append(_FINDER_COLUMN_S_C_GROUPID_2);

			if (code == null) {
				query.append(_FINDER_COLUMN_S_C_CODE_1);
			}
			else {
				if (code.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_S_C_CODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_S_C_CODE_2);
				}
			}

			query.append(VcmsPortionModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (code != null) {
					qPos.add(code);
				}

				List<VcmsPortion> list = q.list();

				result = list;

				VcmsPortion vcmsPortion = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_C,
						finderArgs, list);
				}
				else {
					vcmsPortion = list.get(0);

					cacheResult(vcmsPortion);

					if ((vcmsPortion.getGroupId() != groupId) ||
							(vcmsPortion.getCode() == null) ||
							!vcmsPortion.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_C,
							finderArgs, vcmsPortion);
					}
				}

				return vcmsPortion;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_C,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (VcmsPortion)result;
			}
		}
	}

	/**
	 * Returns all the vcms portions where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching vcms portions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPortion> findByS_L(long groupId, String language)
		throws SystemException {
		return findByS_L(groupId, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms portions where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms portions
	 * @param end the upper bound of the range of vcms portions (not inclusive)
	 * @return the range of matching vcms portions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPortion> findByS_L(long groupId, String language,
		int start, int end) throws SystemException {
		return findByS_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms portions where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms portions
	 * @param end the upper bound of the range of vcms portions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms portions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPortion> findByS_L(long groupId, String language,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_L;
			finderArgs = new Object[] { groupId, language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_S_L;
			finderArgs = new Object[] {
					groupId, language,
					
					start, end, orderByComparator
				};
		}

		List<VcmsPortion> list = (List<VcmsPortion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VCMSPORTION_WHERE);

			query.append(_FINDER_COLUMN_S_L_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsPortionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (language != null) {
					qPos.add(language);
				}

				list = (List<VcmsPortion>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms portion in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms portion
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a matching vcms portion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion findByS_L_First(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsPortionException, SystemException {
		List<VcmsPortion> list = findByS_L(groupId, language, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsPortionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms portion in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms portion
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a matching vcms portion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion findByS_L_Last(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsPortionException, SystemException {
		int count = countByS_L(groupId, language);

		List<VcmsPortion> list = findByS_L(groupId, language, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsPortionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms portions before and after the current vcms portion in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param portionId the primary key of the current vcms portion
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms portion
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsPortionException if a vcms portion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsPortion[] findByS_L_PrevAndNext(String portionId, long groupId,
		String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsPortionException, SystemException {
		VcmsPortion vcmsPortion = findByPrimaryKey(portionId);

		Session session = null;

		try {
			session = openSession();

			VcmsPortion[] array = new VcmsPortionImpl[3];

			array[0] = getByS_L_PrevAndNext(session, vcmsPortion, groupId,
					language, orderByComparator, true);

			array[1] = vcmsPortion;

			array[2] = getByS_L_PrevAndNext(session, vcmsPortion, groupId,
					language, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsPortion getByS_L_PrevAndNext(Session session,
		VcmsPortion vcmsPortion, long groupId, String language,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSPORTION_WHERE);

		query.append(_FINDER_COLUMN_S_L_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_S_L_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
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
			query.append(VcmsPortionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (language != null) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsPortion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsPortion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms portions.
	 *
	 * @return the vcms portions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPortion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms portions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms portions
	 * @param end the upper bound of the range of vcms portions (not inclusive)
	 * @return the range of vcms portions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPortion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms portions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms portions
	 * @param end the upper bound of the range of vcms portions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms portions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsPortion> findAll(int start, int end,
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

		List<VcmsPortion> list = (List<VcmsPortion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSPORTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSPORTION.concat(VcmsPortionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsPortion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsPortion>)QueryUtil.list(q, getDialect(),
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
	 * Removes the vcms portion where groupId = &#63; and categorizable = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categorizable the categorizable
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategorizable(long groupId, boolean categorizable)
		throws NoSuchVcmsPortionException, SystemException {
		VcmsPortion vcmsPortion = findByCategorizable(groupId, categorizable);

		remove(vcmsPortion);
	}

	/**
	 * Removes the vcms portion where groupId = &#63; and code = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByS_C(long groupId, String code)
		throws NoSuchVcmsPortionException, SystemException {
		VcmsPortion vcmsPortion = findByS_C(groupId, code);

		remove(vcmsPortion);
	}

	/**
	 * Removes all the vcms portions where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByS_L(long groupId, String language)
		throws SystemException {
		for (VcmsPortion vcmsPortion : findByS_L(groupId, language)) {
			remove(vcmsPortion);
		}
	}

	/**
	 * Removes all the vcms portions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsPortion vcmsPortion : findAll()) {
			remove(vcmsPortion);
		}
	}

	/**
	 * Returns the number of vcms portions where groupId = &#63; and categorizable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categorizable the categorizable
	 * @return the number of matching vcms portions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategorizable(long groupId, boolean categorizable)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, categorizable };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORIZABLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSPORTION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORIZABLE_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORIZABLE_CATEGORIZABLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categorizable);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORIZABLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms portions where groupId = &#63; and code = &#63;.
	 *
	 * @param groupId the group ID
	 * @param code the code
	 * @return the number of matching vcms portions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByS_C(long groupId, String code) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, code };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_S_C,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSPORTION_WHERE);

			query.append(_FINDER_COLUMN_S_C_GROUPID_2);

			if (code == null) {
				query.append(_FINDER_COLUMN_S_C_CODE_1);
			}
			else {
				if (code.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_S_C_CODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_S_C_CODE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (code != null) {
					qPos.add(code);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S_C, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms portions where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching vcms portions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByS_L(long groupId, String language)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_S_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSPORTION_WHERE);

			query.append(_FINDER_COLUMN_S_L_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (language != null) {
					qPos.add(language);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S_L, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms portions.
	 *
	 * @return the number of vcms portions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSPORTION);

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
	 * Initializes the vcms portion persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsPortion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsPortion>> listenersList = new ArrayList<ModelListener<VcmsPortion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsPortion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsPortionImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSPORTION = "SELECT vcmsPortion FROM VcmsPortion vcmsPortion";
	private static final String _SQL_SELECT_VCMSPORTION_WHERE = "SELECT vcmsPortion FROM VcmsPortion vcmsPortion WHERE ";
	private static final String _SQL_COUNT_VCMSPORTION = "SELECT COUNT(vcmsPortion) FROM VcmsPortion vcmsPortion";
	private static final String _SQL_COUNT_VCMSPORTION_WHERE = "SELECT COUNT(vcmsPortion) FROM VcmsPortion vcmsPortion WHERE ";
	private static final String _FINDER_COLUMN_CATEGORIZABLE_GROUPID_2 = "vcmsPortion.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORIZABLE_CATEGORIZABLE_2 = "vcmsPortion.categorizable = ?";
	private static final String _FINDER_COLUMN_S_C_GROUPID_2 = "vcmsPortion.groupId = ? AND ";
	private static final String _FINDER_COLUMN_S_C_CODE_1 = "vcmsPortion.code IS NULL";
	private static final String _FINDER_COLUMN_S_C_CODE_2 = "vcmsPortion.code = ?";
	private static final String _FINDER_COLUMN_S_C_CODE_3 = "(vcmsPortion.code IS NULL OR vcmsPortion.code = ?)";
	private static final String _FINDER_COLUMN_S_L_GROUPID_2 = "vcmsPortion.groupId = ? AND ";
	private static final String _FINDER_COLUMN_S_L_LANGUAGE_1 = "vcmsPortion.language IS NULL";
	private static final String _FINDER_COLUMN_S_L_LANGUAGE_2 = "vcmsPortion.language = ?";
	private static final String _FINDER_COLUMN_S_L_LANGUAGE_3 = "(vcmsPortion.language IS NULL OR vcmsPortion.language = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsPortion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsPortion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsPortion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsPortionPersistenceImpl.class);
	private static VcmsPortion _nullVcmsPortion = new VcmsPortionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsPortion> toCacheModel() {
				return _nullVcmsPortionCacheModel;
			}
		};

	private static CacheModel<VcmsPortion> _nullVcmsPortionCacheModel = new CacheModel<VcmsPortion>() {
			public VcmsPortion toEntityModel() {
				return _nullVcmsPortion;
			}
		};
}