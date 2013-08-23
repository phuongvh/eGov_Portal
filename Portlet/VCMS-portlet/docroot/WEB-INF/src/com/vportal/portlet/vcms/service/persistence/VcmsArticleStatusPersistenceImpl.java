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

import com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException;
import com.vportal.portlet.vcms.model.VcmsArticleStatus;
import com.vportal.portlet.vcms.model.impl.VcmsArticleStatusImpl;
import com.vportal.portlet.vcms.model.impl.VcmsArticleStatusModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms article status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsArticleStatusPersistence
 * @see VcmsArticleStatusUtil
 * @generated
 */
public class VcmsArticleStatusPersistenceImpl extends BasePersistenceImpl<VcmsArticleStatus>
	implements VcmsArticleStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsArticleStatusUtil} to access the vcms article status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsArticleStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLE = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE =
		new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticle",
			new String[] { String.class.getName() },
			VcmsArticleStatusModelImpl.ARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLE = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] { Boolean.class.getName() },
			VcmsArticleStatusModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { String.class.getName() },
			VcmsArticleStatusModelImpl.CREATEDBYUSER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_A = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_A",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_A = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_A",
			new String[] { String.class.getName(), Boolean.class.getName() },
			VcmsArticleStatusModelImpl.CREATEDBYUSER_COLUMN_BITMASK |
			VcmsArticleStatusModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_A = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_A",
			new String[] { String.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms article status in the entity cache if it is enabled.
	 *
	 * @param vcmsArticleStatus the vcms article status
	 */
	public void cacheResult(VcmsArticleStatus vcmsArticleStatus) {
		EntityCacheUtil.putResult(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusImpl.class, vcmsArticleStatus.getPrimaryKey(),
			vcmsArticleStatus);

		vcmsArticleStatus.resetOriginalValues();
	}

	/**
	 * Caches the vcms article statuses in the entity cache if it is enabled.
	 *
	 * @param vcmsArticleStatuses the vcms article statuses
	 */
	public void cacheResult(List<VcmsArticleStatus> vcmsArticleStatuses) {
		for (VcmsArticleStatus vcmsArticleStatus : vcmsArticleStatuses) {
			if (EntityCacheUtil.getResult(
						VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
						VcmsArticleStatusImpl.class,
						vcmsArticleStatus.getPrimaryKey()) == null) {
				cacheResult(vcmsArticleStatus);
			}
			else {
				vcmsArticleStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms article statuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsArticleStatusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsArticleStatusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms article status.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsArticleStatus vcmsArticleStatus) {
		EntityCacheUtil.removeResult(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusImpl.class, vcmsArticleStatus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VcmsArticleStatus> vcmsArticleStatuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsArticleStatus vcmsArticleStatus : vcmsArticleStatuses) {
			EntityCacheUtil.removeResult(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
				VcmsArticleStatusImpl.class, vcmsArticleStatus.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vcms article status with the primary key. Does not add the vcms article status to the database.
	 *
	 * @param id the primary key for the new vcms article status
	 * @return the new vcms article status
	 */
	public VcmsArticleStatus create(long id) {
		VcmsArticleStatus vcmsArticleStatus = new VcmsArticleStatusImpl();

		vcmsArticleStatus.setNew(true);
		vcmsArticleStatus.setPrimaryKey(id);

		return vcmsArticleStatus;
	}

	/**
	 * Removes the vcms article status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vcms article status
	 * @return the vcms article status that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus remove(long id)
		throws NoSuchVcmsArticleStatusException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the vcms article status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms article status
	 * @return the vcms article status that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsArticleStatus remove(Serializable primaryKey)
		throws NoSuchVcmsArticleStatusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsArticleStatus vcmsArticleStatus = (VcmsArticleStatus)session.get(VcmsArticleStatusImpl.class,
					primaryKey);

			if (vcmsArticleStatus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsArticleStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsArticleStatus);
		}
		catch (NoSuchVcmsArticleStatusException nsee) {
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
	protected VcmsArticleStatus removeImpl(VcmsArticleStatus vcmsArticleStatus)
		throws SystemException {
		vcmsArticleStatus = toUnwrappedModel(vcmsArticleStatus);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsArticleStatus);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsArticleStatus);

		return vcmsArticleStatus;
	}

	@Override
	public VcmsArticleStatus updateImpl(
		com.vportal.portlet.vcms.model.VcmsArticleStatus vcmsArticleStatus,
		boolean merge) throws SystemException {
		vcmsArticleStatus = toUnwrappedModel(vcmsArticleStatus);

		boolean isNew = vcmsArticleStatus.isNew();

		VcmsArticleStatusModelImpl vcmsArticleStatusModelImpl = (VcmsArticleStatusModelImpl)vcmsArticleStatus;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsArticleStatus, merge);

			vcmsArticleStatus.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsArticleStatusModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsArticleStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsArticleStatusModelImpl.getOriginalArticleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);

				args = new Object[] { vcmsArticleStatusModelImpl.getArticleId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);
			}

			if ((vcmsArticleStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(vcmsArticleStatusModelImpl.getOriginalActive())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] {
						Boolean.valueOf(vcmsArticleStatusModelImpl.getActive())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}

			if ((vcmsArticleStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsArticleStatusModelImpl.getOriginalCreatedByUser()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] {
						vcmsArticleStatusModelImpl.getCreatedByUser()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((vcmsArticleStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsArticleStatusModelImpl.getOriginalCreatedByUser(),
						Boolean.valueOf(vcmsArticleStatusModelImpl.getOriginalActive())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_A,
					args);

				args = new Object[] {
						vcmsArticleStatusModelImpl.getCreatedByUser(),
						Boolean.valueOf(vcmsArticleStatusModelImpl.getActive())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_A,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleStatusImpl.class, vcmsArticleStatus.getPrimaryKey(),
			vcmsArticleStatus);

		return vcmsArticleStatus;
	}

	protected VcmsArticleStatus toUnwrappedModel(
		VcmsArticleStatus vcmsArticleStatus) {
		if (vcmsArticleStatus instanceof VcmsArticleStatusImpl) {
			return vcmsArticleStatus;
		}

		VcmsArticleStatusImpl vcmsArticleStatusImpl = new VcmsArticleStatusImpl();

		vcmsArticleStatusImpl.setNew(vcmsArticleStatus.isNew());
		vcmsArticleStatusImpl.setPrimaryKey(vcmsArticleStatus.getPrimaryKey());

		vcmsArticleStatusImpl.setId(vcmsArticleStatus.getId());
		vcmsArticleStatusImpl.setStatusId(vcmsArticleStatus.getStatusId());
		vcmsArticleStatusImpl.setArticleId(vcmsArticleStatus.getArticleId());
		vcmsArticleStatusImpl.setCategoryId(vcmsArticleStatus.getCategoryId());
		vcmsArticleStatusImpl.setCreatedDate(vcmsArticleStatus.getCreatedDate());
		vcmsArticleStatusImpl.setCreatedByUser(vcmsArticleStatus.getCreatedByUser());
		vcmsArticleStatusImpl.setActive(vcmsArticleStatus.isActive());
		vcmsArticleStatusImpl.setArticleVersionId(vcmsArticleStatus.getArticleVersionId());

		return vcmsArticleStatusImpl;
	}

	/**
	 * Returns the vcms article status with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms article status
	 * @return the vcms article status
	 * @throws com.liferay.portal.NoSuchModelException if a vcms article status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsArticleStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the vcms article status with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException} if it could not be found.
	 *
	 * @param id the primary key of the vcms article status
	 * @return the vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus findByPrimaryKey(long id)
		throws NoSuchVcmsArticleStatusException, SystemException {
		VcmsArticleStatus vcmsArticleStatus = fetchByPrimaryKey(id);

		if (vcmsArticleStatus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchVcmsArticleStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return vcmsArticleStatus;
	}

	/**
	 * Returns the vcms article status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms article status
	 * @return the vcms article status, or <code>null</code> if a vcms article status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsArticleStatus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the vcms article status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vcms article status
	 * @return the vcms article status, or <code>null</code> if a vcms article status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus fetchByPrimaryKey(long id)
		throws SystemException {
		VcmsArticleStatus vcmsArticleStatus = (VcmsArticleStatus)EntityCacheUtil.getResult(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
				VcmsArticleStatusImpl.class, id);

		if (vcmsArticleStatus == _nullVcmsArticleStatus) {
			return null;
		}

		if (vcmsArticleStatus == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsArticleStatus = (VcmsArticleStatus)session.get(VcmsArticleStatusImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsArticleStatus != null) {
					cacheResult(vcmsArticleStatus);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsArticleStatusModelImpl.ENTITY_CACHE_ENABLED,
						VcmsArticleStatusImpl.class, id, _nullVcmsArticleStatus);
				}

				closeSession(session);
			}
		}

		return vcmsArticleStatus;
	}

	/**
	 * Returns all the vcms article statuses where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByArticle(String articleId)
		throws SystemException {
		return findByArticle(articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms article statuses where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms article statuses
	 * @param end the upper bound of the range of vcms article statuses (not inclusive)
	 * @return the range of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByArticle(String articleId, int start,
		int end) throws SystemException {
		return findByArticle(articleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms article statuses where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms article statuses
	 * @param end the upper bound of the range of vcms article statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByArticle(String articleId, int start,
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

		List<VcmsArticleStatus> list = (List<VcmsArticleStatus>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSARTICLESTATUS_WHERE);

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
				query.append(VcmsArticleStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<VcmsArticleStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article status in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus findByArticle_First(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		List<VcmsArticleStatus> list = findByArticle(articleId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article status in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus findByArticle_Last(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		int count = countByArticle(articleId);

		List<VcmsArticleStatus> list = findByArticle(articleId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms article statuses before and after the current vcms article status in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current vcms article status
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus[] findByArticle_PrevAndNext(long id,
		String articleId, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		VcmsArticleStatus vcmsArticleStatus = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VcmsArticleStatus[] array = new VcmsArticleStatusImpl[3];

			array[0] = getByArticle_PrevAndNext(session, vcmsArticleStatus,
					articleId, orderByComparator, true);

			array[1] = vcmsArticleStatus;

			array[2] = getByArticle_PrevAndNext(session, vcmsArticleStatus,
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

	protected VcmsArticleStatus getByArticle_PrevAndNext(Session session,
		VcmsArticleStatus vcmsArticleStatus, String articleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLESTATUS_WHERE);

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
			query.append(VcmsArticleStatusModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticleStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticleStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms article statuses where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByActive(boolean active)
		throws SystemException {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms article statuses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of vcms article statuses
	 * @param end the upper bound of the range of vcms article statuses (not inclusive)
	 * @return the range of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByActive(boolean active, int start,
		int end) throws SystemException {
		return findByActive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms article statuses where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of vcms article statuses
	 * @param end the upper bound of the range of vcms article statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByActive(boolean active, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active, start, end, orderByComparator };
		}

		List<VcmsArticleStatus> list = (List<VcmsArticleStatus>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSARTICLESTATUS_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				list = (List<VcmsArticleStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article status in the ordered set where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus findByActive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		List<VcmsArticleStatus> list = findByActive(active, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article status in the ordered set where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus findByActive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		int count = countByActive(active);

		List<VcmsArticleStatus> list = findByActive(active, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms article statuses before and after the current vcms article status in the ordered set where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current vcms article status
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus[] findByActive_PrevAndNext(long id,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		VcmsArticleStatus vcmsArticleStatus = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VcmsArticleStatus[] array = new VcmsArticleStatusImpl[3];

			array[0] = getByActive_PrevAndNext(session, vcmsArticleStatus,
					active, orderByComparator, true);

			array[1] = vcmsArticleStatus;

			array[2] = getByActive_PrevAndNext(session, vcmsArticleStatus,
					active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsArticleStatus getByActive_PrevAndNext(Session session,
		VcmsArticleStatus vcmsArticleStatus, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLESTATUS_WHERE);

		query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

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
			query.append(VcmsArticleStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticleStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticleStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms article statuses where createdByUser = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @return the matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByUser(String createdByUser)
		throws SystemException {
		return findByUser(createdByUser, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms article statuses where createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param start the lower bound of the range of vcms article statuses
	 * @param end the upper bound of the range of vcms article statuses (not inclusive)
	 * @return the range of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByUser(String createdByUser, int start,
		int end) throws SystemException {
		return findByUser(createdByUser, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms article statuses where createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param start the lower bound of the range of vcms article statuses
	 * @param end the upper bound of the range of vcms article statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByUser(String createdByUser, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { createdByUser };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] {
					createdByUser,
					
					start, end, orderByComparator
				};
		}

		List<VcmsArticleStatus> list = (List<VcmsArticleStatus>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSARTICLESTATUS_WHERE);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_USER_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USER_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_USER_CREATEDBYUSER_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdByUser != null) {
					qPos.add(createdByUser);
				}

				list = (List<VcmsArticleStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article status in the ordered set where createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus findByUser_First(String createdByUser,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		List<VcmsArticleStatus> list = findByUser(createdByUser, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("createdByUser=");
			msg.append(createdByUser);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article status in the ordered set where createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus findByUser_Last(String createdByUser,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		int count = countByUser(createdByUser);

		List<VcmsArticleStatus> list = findByUser(createdByUser, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("createdByUser=");
			msg.append(createdByUser);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms article statuses before and after the current vcms article status in the ordered set where createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current vcms article status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus[] findByUser_PrevAndNext(long id,
		String createdByUser, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		VcmsArticleStatus vcmsArticleStatus = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VcmsArticleStatus[] array = new VcmsArticleStatusImpl[3];

			array[0] = getByUser_PrevAndNext(session, vcmsArticleStatus,
					createdByUser, orderByComparator, true);

			array[1] = vcmsArticleStatus;

			array[2] = getByUser_PrevAndNext(session, vcmsArticleStatus,
					createdByUser, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsArticleStatus getByUser_PrevAndNext(Session session,
		VcmsArticleStatus vcmsArticleStatus, String createdByUser,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLESTATUS_WHERE);

		if (createdByUser == null) {
			query.append(_FINDER_COLUMN_USER_CREATEDBYUSER_1);
		}
		else {
			if (createdByUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USER_CREATEDBYUSER_3);
			}
			else {
				query.append(_FINDER_COLUMN_USER_CREATEDBYUSER_2);
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
			query.append(VcmsArticleStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (createdByUser != null) {
			qPos.add(createdByUser);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticleStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticleStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms article statuses where createdByUser = &#63; and active = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param active the active
	 * @return the matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByU_A(String createdByUser,
		boolean active) throws SystemException {
		return findByU_A(createdByUser, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms article statuses where createdByUser = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param active the active
	 * @param start the lower bound of the range of vcms article statuses
	 * @param end the upper bound of the range of vcms article statuses (not inclusive)
	 * @return the range of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByU_A(String createdByUser,
		boolean active, int start, int end) throws SystemException {
		return findByU_A(createdByUser, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms article statuses where createdByUser = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param active the active
	 * @param start the lower bound of the range of vcms article statuses
	 * @param end the upper bound of the range of vcms article statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findByU_A(String createdByUser,
		boolean active, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_A;
			finderArgs = new Object[] { createdByUser, active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_A;
			finderArgs = new Object[] {
					createdByUser, active,
					
					start, end, orderByComparator
				};
		}

		List<VcmsArticleStatus> list = (List<VcmsArticleStatus>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSARTICLESTATUS_WHERE);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_U_A_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_A_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_A_CREATEDBYUSER_2);
				}
			}

			query.append(_FINDER_COLUMN_U_A_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdByUser != null) {
					qPos.add(createdByUser);
				}

				qPos.add(active);

				list = (List<VcmsArticleStatus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article status in the ordered set where createdByUser = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus findByU_A_First(String createdByUser,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		List<VcmsArticleStatus> list = findByU_A(createdByUser, active, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("createdByUser=");
			msg.append(createdByUser);

			msg.append(", active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article status in the ordered set where createdByUser = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a matching vcms article status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus findByU_A_Last(String createdByUser,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		int count = countByU_A(createdByUser, active);

		List<VcmsArticleStatus> list = findByU_A(createdByUser, active,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("createdByUser=");
			msg.append(createdByUser);

			msg.append(", active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms article statuses before and after the current vcms article status in the ordered set where createdByUser = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current vcms article status
	 * @param createdByUser the created by user
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleStatusException if a vcms article status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleStatus[] findByU_A_PrevAndNext(long id,
		String createdByUser, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleStatusException, SystemException {
		VcmsArticleStatus vcmsArticleStatus = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VcmsArticleStatus[] array = new VcmsArticleStatusImpl[3];

			array[0] = getByU_A_PrevAndNext(session, vcmsArticleStatus,
					createdByUser, active, orderByComparator, true);

			array[1] = vcmsArticleStatus;

			array[2] = getByU_A_PrevAndNext(session, vcmsArticleStatus,
					createdByUser, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsArticleStatus getByU_A_PrevAndNext(Session session,
		VcmsArticleStatus vcmsArticleStatus, String createdByUser,
		boolean active, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLESTATUS_WHERE);

		if (createdByUser == null) {
			query.append(_FINDER_COLUMN_U_A_CREATEDBYUSER_1);
		}
		else {
			if (createdByUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_U_A_CREATEDBYUSER_3);
			}
			else {
				query.append(_FINDER_COLUMN_U_A_CREATEDBYUSER_2);
			}
		}

		query.append(_FINDER_COLUMN_U_A_ACTIVE_2);

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
			query.append(VcmsArticleStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (createdByUser != null) {
			qPos.add(createdByUser);
		}

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticleStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticleStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms article statuses.
	 *
	 * @return the vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms article statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms article statuses
	 * @param end the upper bound of the range of vcms article statuses (not inclusive)
	 * @return the range of vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms article statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms article statuses
	 * @param end the upper bound of the range of vcms article statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleStatus> findAll(int start, int end,
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

		List<VcmsArticleStatus> list = (List<VcmsArticleStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSARTICLESTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSARTICLESTATUS.concat(VcmsArticleStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsArticleStatus>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsArticleStatus>)QueryUtil.list(q,
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
	 * Removes all the vcms article statuses where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByArticle(String articleId) throws SystemException {
		for (VcmsArticleStatus vcmsArticleStatus : findByArticle(articleId)) {
			remove(vcmsArticleStatus);
		}
	}

	/**
	 * Removes all the vcms article statuses where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByActive(boolean active) throws SystemException {
		for (VcmsArticleStatus vcmsArticleStatus : findByActive(active)) {
			remove(vcmsArticleStatus);
		}
	}

	/**
	 * Removes all the vcms article statuses where createdByUser = &#63; from the database.
	 *
	 * @param createdByUser the created by user
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUser(String createdByUser) throws SystemException {
		for (VcmsArticleStatus vcmsArticleStatus : findByUser(createdByUser)) {
			remove(vcmsArticleStatus);
		}
	}

	/**
	 * Removes all the vcms article statuses where createdByUser = &#63; and active = &#63; from the database.
	 *
	 * @param createdByUser the created by user
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByU_A(String createdByUser, boolean active)
		throws SystemException {
		for (VcmsArticleStatus vcmsArticleStatus : findByU_A(createdByUser,
				active)) {
			remove(vcmsArticleStatus);
		}
	}

	/**
	 * Removes all the vcms article statuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsArticleStatus vcmsArticleStatus : findAll()) {
			remove(vcmsArticleStatus);
		}
	}

	/**
	 * Returns the number of vcms article statuses where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByArticle(String articleId) throws SystemException {
		Object[] finderArgs = new Object[] { articleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSARTICLESTATUS_WHERE);

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
	 * Returns the number of vcms article statuses where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByActive(boolean active) throws SystemException {
		Object[] finderArgs = new Object[] { active };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSARTICLESTATUS_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms article statuses where createdByUser = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @return the number of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUser(String createdByUser) throws SystemException {
		Object[] finderArgs = new Object[] { createdByUser };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSARTICLESTATUS_WHERE);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_USER_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USER_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_USER_CREATEDBYUSER_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdByUser != null) {
					qPos.add(createdByUser);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms article statuses where createdByUser = &#63; and active = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param active the active
	 * @return the number of matching vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_A(String createdByUser, boolean active)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdByUser, active };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSARTICLESTATUS_WHERE);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_U_A_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_A_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_A_CREATEDBYUSER_2);
				}
			}

			query.append(_FINDER_COLUMN_U_A_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdByUser != null) {
					qPos.add(createdByUser);
				}

				qPos.add(active);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_A, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms article statuses.
	 *
	 * @return the number of vcms article statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSARTICLESTATUS);

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
	 * Initializes the vcms article status persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsArticleStatus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsArticleStatus>> listenersList = new ArrayList<ModelListener<VcmsArticleStatus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsArticleStatus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsArticleStatusImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSARTICLESTATUS = "SELECT vcmsArticleStatus FROM VcmsArticleStatus vcmsArticleStatus";
	private static final String _SQL_SELECT_VCMSARTICLESTATUS_WHERE = "SELECT vcmsArticleStatus FROM VcmsArticleStatus vcmsArticleStatus WHERE ";
	private static final String _SQL_COUNT_VCMSARTICLESTATUS = "SELECT COUNT(vcmsArticleStatus) FROM VcmsArticleStatus vcmsArticleStatus";
	private static final String _SQL_COUNT_VCMSARTICLESTATUS_WHERE = "SELECT COUNT(vcmsArticleStatus) FROM VcmsArticleStatus vcmsArticleStatus WHERE ";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_1 = "vcmsArticleStatus.articleId IS NULL";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_2 = "vcmsArticleStatus.articleId = ?";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_3 = "(vcmsArticleStatus.articleId IS NULL OR vcmsArticleStatus.articleId = ?)";
	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "vcmsArticleStatus.active = ?";
	private static final String _FINDER_COLUMN_USER_CREATEDBYUSER_1 = "vcmsArticleStatus.createdByUser IS NULL";
	private static final String _FINDER_COLUMN_USER_CREATEDBYUSER_2 = "vcmsArticleStatus.createdByUser = ?";
	private static final String _FINDER_COLUMN_USER_CREATEDBYUSER_3 = "(vcmsArticleStatus.createdByUser IS NULL OR vcmsArticleStatus.createdByUser = ?)";
	private static final String _FINDER_COLUMN_U_A_CREATEDBYUSER_1 = "vcmsArticleStatus.createdByUser IS NULL AND ";
	private static final String _FINDER_COLUMN_U_A_CREATEDBYUSER_2 = "vcmsArticleStatus.createdByUser = ? AND ";
	private static final String _FINDER_COLUMN_U_A_CREATEDBYUSER_3 = "(vcmsArticleStatus.createdByUser IS NULL OR vcmsArticleStatus.createdByUser = ?) AND ";
	private static final String _FINDER_COLUMN_U_A_ACTIVE_2 = "vcmsArticleStatus.active = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsArticleStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsArticleStatus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsArticleStatus exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsArticleStatusPersistenceImpl.class);
	private static VcmsArticleStatus _nullVcmsArticleStatus = new VcmsArticleStatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsArticleStatus> toCacheModel() {
				return _nullVcmsArticleStatusCacheModel;
			}
		};

	private static CacheModel<VcmsArticleStatus> _nullVcmsArticleStatusCacheModel =
		new CacheModel<VcmsArticleStatus>() {
			public VcmsArticleStatus toEntityModel() {
				return _nullVcmsArticleStatus;
			}
		};
}