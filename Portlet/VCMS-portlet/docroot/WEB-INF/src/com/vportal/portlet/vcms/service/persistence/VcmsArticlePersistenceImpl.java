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

import com.vportal.portlet.vcms.NoSuchVcmsArticleException;
import com.vportal.portlet.vcms.model.VcmsArticle;
import com.vportal.portlet.vcms.model.impl.VcmsArticleImpl;
import com.vportal.portlet.vcms.model.impl.VcmsArticleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsArticlePersistence
 * @see VcmsArticleUtil
 * @generated
 */
public class VcmsArticlePersistenceImpl extends BasePersistenceImpl<VcmsArticle>
	implements VcmsArticlePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsArticleUtil} to access the vcms article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsArticleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_L_S = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByL_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_S = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByL_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			VcmsArticleModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsArticleModelImpl.LANGUAGE_COLUMN_BITMASK |
			VcmsArticleModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_L_S = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByL_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_S_U = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_S_U",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_S_U =
		new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_S_U",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			VcmsArticleModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsArticleModelImpl.LANGUAGE_COLUMN_BITMASK |
			VcmsArticleModelImpl.STATUS_COLUMN_BITMASK |
			VcmsArticleModelImpl.CREATEDBYUSER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L_S_U = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_S_U",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_L_S_S = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByL_S_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_S_S = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByL_S_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			},
			VcmsArticleModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsArticleModelImpl.LANGUAGE_COLUMN_BITMASK |
			VcmsArticleModelImpl.STATUS_COLUMN_BITMASK |
			VcmsArticleModelImpl.STICKY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_L_S_S = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByL_S_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_L = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_L = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			VcmsArticleModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsArticleModelImpl.CREATEDBYUSER_COLUMN_BITMASK |
			VcmsArticleModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_L = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_L_S = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_L_S = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			VcmsArticleModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsArticleModelImpl.CREATEDBYUSER_COLUMN_BITMASK |
			VcmsArticleModelImpl.LANGUAGE_COLUMN_BITMASK |
			VcmsArticleModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_L_S = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_P_L_S_D = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_L_S_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_L_S_D =
		new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_L_S_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			},
			VcmsArticleModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsArticleModelImpl.LANGUAGE_COLUMN_BITMASK |
			VcmsArticleModelImpl.STATUS_COLUMN_BITMASK |
			VcmsArticleModelImpl.DISCUSSIBLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_P_L_S_D = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_L_S_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Long.class.getName() },
			VcmsArticleModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			VcmsArticleModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, VcmsArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms article in the entity cache if it is enabled.
	 *
	 * @param vcmsArticle the vcms article
	 */
	public void cacheResult(VcmsArticle vcmsArticle) {
		EntityCacheUtil.putResult(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleImpl.class, vcmsArticle.getPrimaryKey(), vcmsArticle);

		vcmsArticle.resetOriginalValues();
	}

	/**
	 * Caches the vcms articles in the entity cache if it is enabled.
	 *
	 * @param vcmsArticles the vcms articles
	 */
	public void cacheResult(List<VcmsArticle> vcmsArticles) {
		for (VcmsArticle vcmsArticle : vcmsArticles) {
			if (EntityCacheUtil.getResult(
						VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
						VcmsArticleImpl.class, vcmsArticle.getPrimaryKey()) == null) {
				cacheResult(vcmsArticle);
			}
			else {
				vcmsArticle.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms articles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsArticleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsArticleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms article.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsArticle vcmsArticle) {
		EntityCacheUtil.removeResult(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleImpl.class, vcmsArticle.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VcmsArticle> vcmsArticles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsArticle vcmsArticle : vcmsArticles) {
			EntityCacheUtil.removeResult(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
				VcmsArticleImpl.class, vcmsArticle.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vcms article with the primary key. Does not add the vcms article to the database.
	 *
	 * @param articleId the primary key for the new vcms article
	 * @return the new vcms article
	 */
	public VcmsArticle create(String articleId) {
		VcmsArticle vcmsArticle = new VcmsArticleImpl();

		vcmsArticle.setNew(true);
		vcmsArticle.setPrimaryKey(articleId);

		return vcmsArticle;
	}

	/**
	 * Removes the vcms article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the vcms article
	 * @return the vcms article that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle remove(String articleId)
		throws NoSuchVcmsArticleException, SystemException {
		return remove((Serializable)articleId);
	}

	/**
	 * Removes the vcms article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms article
	 * @return the vcms article that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsArticle remove(Serializable primaryKey)
		throws NoSuchVcmsArticleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsArticle vcmsArticle = (VcmsArticle)session.get(VcmsArticleImpl.class,
					primaryKey);

			if (vcmsArticle == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsArticle);
		}
		catch (NoSuchVcmsArticleException nsee) {
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
	protected VcmsArticle removeImpl(VcmsArticle vcmsArticle)
		throws SystemException {
		vcmsArticle = toUnwrappedModel(vcmsArticle);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsArticle);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsArticle);

		return vcmsArticle;
	}

	@Override
	public VcmsArticle updateImpl(
		com.vportal.portlet.vcms.model.VcmsArticle vcmsArticle, boolean merge)
		throws SystemException {
		vcmsArticle = toUnwrappedModel(vcmsArticle);

		boolean isNew = vcmsArticle.isNew();

		VcmsArticleModelImpl vcmsArticleModelImpl = (VcmsArticleModelImpl)vcmsArticle;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsArticle, merge);

			vcmsArticle.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsArticleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getOriginalGroupId()),
						
						vcmsArticleModelImpl.getOriginalLanguage(),
						Long.valueOf(vcmsArticleModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_L_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_S,
					args);

				args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getGroupId()),
						
						vcmsArticleModelImpl.getLanguage(),
						Long.valueOf(vcmsArticleModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_L_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_S,
					args);
			}

			if ((vcmsArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_S_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getOriginalGroupId()),
						
						vcmsArticleModelImpl.getOriginalLanguage(),
						Long.valueOf(vcmsArticleModelImpl.getOriginalStatus()),
						
						vcmsArticleModelImpl.getOriginalCreatedByUser()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_S_U,
					args);

				args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getGroupId()),
						
						vcmsArticleModelImpl.getLanguage(),
						Long.valueOf(vcmsArticleModelImpl.getStatus()),
						
						vcmsArticleModelImpl.getCreatedByUser()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_S_U,
					args);
			}

			if ((vcmsArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_S_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getOriginalGroupId()),
						
						vcmsArticleModelImpl.getOriginalLanguage(),
						Long.valueOf(vcmsArticleModelImpl.getOriginalStatus()),
						Boolean.valueOf(vcmsArticleModelImpl.getOriginalSticky())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_L_S_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_S_S,
					args);

				args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getGroupId()),
						
						vcmsArticleModelImpl.getLanguage(),
						Long.valueOf(vcmsArticleModelImpl.getStatus()),
						Boolean.valueOf(vcmsArticleModelImpl.getSticky())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_L_S_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_S_S,
					args);
			}

			if ((vcmsArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getOriginalGroupId()),
						
						vcmsArticleModelImpl.getOriginalCreatedByUser(),
						
						vcmsArticleModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_L,
					args);

				args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getGroupId()),
						
						vcmsArticleModelImpl.getCreatedByUser(),
						
						vcmsArticleModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_L,
					args);
			}

			if ((vcmsArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_L_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getOriginalGroupId()),
						
						vcmsArticleModelImpl.getOriginalCreatedByUser(),
						
						vcmsArticleModelImpl.getOriginalLanguage(),
						Long.valueOf(vcmsArticleModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_L_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_L_S,
					args);

				args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getGroupId()),
						
						vcmsArticleModelImpl.getCreatedByUser(),
						
						vcmsArticleModelImpl.getLanguage(),
						Long.valueOf(vcmsArticleModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_L_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_L_S,
					args);
			}

			if ((vcmsArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_L_S_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getOriginalGroupId()),
						
						vcmsArticleModelImpl.getOriginalLanguage(),
						Long.valueOf(vcmsArticleModelImpl.getOriginalStatus()),
						Boolean.valueOf(vcmsArticleModelImpl.getOriginalDiscussible())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_L_S_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_L_S_D,
					args);

				args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getGroupId()),
						
						vcmsArticleModelImpl.getLanguage(),
						Long.valueOf(vcmsArticleModelImpl.getStatus()),
						Boolean.valueOf(vcmsArticleModelImpl.getDiscussible())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_L_S_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_L_S_D,
					args);
			}

			if ((vcmsArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((vcmsArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] {
						Long.valueOf(vcmsArticleModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleImpl.class, vcmsArticle.getPrimaryKey(), vcmsArticle);

		return vcmsArticle;
	}

	protected VcmsArticle toUnwrappedModel(VcmsArticle vcmsArticle) {
		if (vcmsArticle instanceof VcmsArticleImpl) {
			return vcmsArticle;
		}

		VcmsArticleImpl vcmsArticleImpl = new VcmsArticleImpl();

		vcmsArticleImpl.setNew(vcmsArticle.isNew());
		vcmsArticleImpl.setPrimaryKey(vcmsArticle.getPrimaryKey());

		vcmsArticleImpl.setArticleId(vcmsArticle.getArticleId());
		vcmsArticleImpl.setGroupId(vcmsArticle.getGroupId());
		vcmsArticleImpl.setCompanyId(vcmsArticle.getCompanyId());
		vcmsArticleImpl.setCreatedByUser(vcmsArticle.getCreatedByUser());
		vcmsArticleImpl.setCreatedDate(vcmsArticle.getCreatedDate());
		vcmsArticleImpl.setModifiedByUser(vcmsArticle.getModifiedByUser());
		vcmsArticleImpl.setModifiedDate(vcmsArticle.getModifiedDate());
		vcmsArticleImpl.setApprovedByUser(vcmsArticle.getApprovedByUser());
		vcmsArticleImpl.setApprovedDate(vcmsArticle.getApprovedDate());
		vcmsArticleImpl.setPublishedByUser(vcmsArticle.getPublishedByUser());
		vcmsArticleImpl.setPublishedDate(vcmsArticle.getPublishedDate());
		vcmsArticleImpl.setStatus(vcmsArticle.getStatus());
		vcmsArticleImpl.setTitle(vcmsArticle.getTitle());
		vcmsArticleImpl.setLead(vcmsArticle.getLead());
		vcmsArticleImpl.setContent(vcmsArticle.getContent());
		vcmsArticleImpl.setHasImage(vcmsArticle.isHasImage());
		vcmsArticleImpl.setImageTitle(vcmsArticle.getImageTitle());
		vcmsArticleImpl.setImage(vcmsArticle.getImage());
		vcmsArticleImpl.setAuthor(vcmsArticle.getAuthor());
		vcmsArticleImpl.setSource(vcmsArticle.getSource());
		vcmsArticleImpl.setLanguage(vcmsArticle.getLanguage());
		vcmsArticleImpl.setUserHit(vcmsArticle.getUserHit());
		vcmsArticleImpl.setDiscussible(vcmsArticle.isDiscussible());
		vcmsArticleImpl.setHasAttachment(vcmsArticle.isHasAttachment());
		vcmsArticleImpl.setHasPoll(vcmsArticle.isHasPoll());
		vcmsArticleImpl.setPollId(vcmsArticle.getPollId());
		vcmsArticleImpl.setEffectiveDate(vcmsArticle.getEffectiveDate());
		vcmsArticleImpl.setExpireDate(vcmsArticle.getExpireDate());
		vcmsArticleImpl.setSticky(vcmsArticle.isSticky());
		vcmsArticleImpl.setStickyNeverExpired(vcmsArticle.isStickyNeverExpired());
		vcmsArticleImpl.setStickyExpireDate(vcmsArticle.getStickyExpireDate());

		return vcmsArticleImpl;
	}

	/**
	 * Returns the vcms article with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms article
	 * @return the vcms article
	 * @throws com.liferay.portal.NoSuchModelException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsArticle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms article with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsArticleException} if it could not be found.
	 *
	 * @param articleId the primary key of the vcms article
	 * @return the vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByPrimaryKey(String articleId)
		throws NoSuchVcmsArticleException, SystemException {
		VcmsArticle vcmsArticle = fetchByPrimaryKey(articleId);

		if (vcmsArticle == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + articleId);
			}

			throw new NoSuchVcmsArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				articleId);
		}

		return vcmsArticle;
	}

	/**
	 * Returns the vcms article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms article
	 * @return the vcms article, or <code>null</code> if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsArticle fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleId the primary key of the vcms article
	 * @return the vcms article, or <code>null</code> if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle fetchByPrimaryKey(String articleId)
		throws SystemException {
		VcmsArticle vcmsArticle = (VcmsArticle)EntityCacheUtil.getResult(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
				VcmsArticleImpl.class, articleId);

		if (vcmsArticle == _nullVcmsArticle) {
			return null;
		}

		if (vcmsArticle == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsArticle = (VcmsArticle)session.get(VcmsArticleImpl.class,
						articleId);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsArticle != null) {
					cacheResult(vcmsArticle);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsArticleModelImpl.ENTITY_CACHE_ENABLED,
						VcmsArticleImpl.class, articleId, _nullVcmsArticle);
				}

				closeSession(session);
			}
		}

		return vcmsArticle;
	}

	/**
	 * Returns all the vcms articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @return the matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByL_S(long groupId, String language,
		long status) throws SystemException {
		return findByL_S(groupId, language, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @return the range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByL_S(long groupId, String language,
		long status, int start, int end) throws SystemException {
		return findByL_S(groupId, language, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByL_S(long groupId, String language,
		long status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_S;
			finderArgs = new Object[] { groupId, language, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_L_S;
			finderArgs = new Object[] {
					groupId, language, status,
					
					start, end, orderByComparator
				};
		}

		List<VcmsArticle> list = (List<VcmsArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_L_S_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_L_S_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_L_S_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_L_S_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_L_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
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

				qPos.add(status);

				list = (List<VcmsArticle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByL_S_First(long groupId, String language,
		long status, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		List<VcmsArticle> list = findByL_S(groupId, language, status, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByL_S_Last(long groupId, String language,
		long status, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		int count = countByL_S(groupId, language, status);

		List<VcmsArticle> list = findByL_S(groupId, language, status,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the primary key of the current vcms article
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle[] findByL_S_PrevAndNext(String articleId, long groupId,
		String language, long status, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		VcmsArticle vcmsArticle = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			VcmsArticle[] array = new VcmsArticleImpl[3];

			array[0] = getByL_S_PrevAndNext(session, vcmsArticle, groupId,
					language, status, orderByComparator, true);

			array[1] = vcmsArticle;

			array[2] = getByL_S_PrevAndNext(session, vcmsArticle, groupId,
					language, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsArticle getByL_S_PrevAndNext(Session session,
		VcmsArticle vcmsArticle, long groupId, String language, long status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

		query.append(_FINDER_COLUMN_L_S_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_L_S_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_L_S_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_L_S_LANGUAGE_2);
			}
		}

		query.append(_FINDER_COLUMN_L_S_STATUS_2);

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
			query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
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

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @return the matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByG_L_S_U(long groupId, String language,
		long status, String createdByUser) throws SystemException {
		return findByG_L_S_U(groupId, language, status, createdByUser,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @return the range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByG_L_S_U(long groupId, String language,
		long status, String createdByUser, int start, int end)
		throws SystemException {
		return findByG_L_S_U(groupId, language, status, createdByUser, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByG_L_S_U(long groupId, String language,
		long status, String createdByUser, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_S_U;
			finderArgs = new Object[] { groupId, language, status, createdByUser };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_S_U;
			finderArgs = new Object[] {
					groupId, language, status, createdByUser,
					
					start, end, orderByComparator
				};
		}

		List<VcmsArticle> list = (List<VcmsArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_G_L_S_U_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_S_U_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_S_U_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_S_U_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_G_L_S_U_STATUS_2);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
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

				qPos.add(status);

				if (createdByUser != null) {
					qPos.add(createdByUser);
				}

				list = (List<VcmsArticle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByG_L_S_U_First(long groupId, String language,
		long status, String createdByUser, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		List<VcmsArticle> list = findByG_L_S_U(groupId, language, status,
				createdByUser, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", status=");
			msg.append(status);

			msg.append(", createdByUser=");
			msg.append(createdByUser);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByG_L_S_U_Last(long groupId, String language,
		long status, String createdByUser, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		int count = countByG_L_S_U(groupId, language, status, createdByUser);

		List<VcmsArticle> list = findByG_L_S_U(groupId, language, status,
				createdByUser, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", status=");
			msg.append(status);

			msg.append(", createdByUser=");
			msg.append(createdByUser);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the primary key of the current vcms article
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle[] findByG_L_S_U_PrevAndNext(String articleId,
		long groupId, String language, long status, String createdByUser,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		VcmsArticle vcmsArticle = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			VcmsArticle[] array = new VcmsArticleImpl[3];

			array[0] = getByG_L_S_U_PrevAndNext(session, vcmsArticle, groupId,
					language, status, createdByUser, orderByComparator, true);

			array[1] = vcmsArticle;

			array[2] = getByG_L_S_U_PrevAndNext(session, vcmsArticle, groupId,
					language, status, createdByUser, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsArticle getByG_L_S_U_PrevAndNext(Session session,
		VcmsArticle vcmsArticle, long groupId, String language, long status,
		String createdByUser, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

		query.append(_FINDER_COLUMN_G_L_S_U_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_G_L_S_U_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_S_U_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_L_S_U_LANGUAGE_2);
			}
		}

		query.append(_FINDER_COLUMN_G_L_S_U_STATUS_2);

		if (createdByUser == null) {
			query.append(_FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_1);
		}
		else {
			if (createdByUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_2);
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
			query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
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

		qPos.add(status);

		if (createdByUser != null) {
			qPos.add(createdByUser);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param sticky the sticky
	 * @return the matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByL_S_S(long groupId, String language,
		long status, boolean sticky) throws SystemException {
		return findByL_S_S(groupId, language, status, sticky,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param sticky the sticky
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @return the range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByL_S_S(long groupId, String language,
		long status, boolean sticky, int start, int end)
		throws SystemException {
		return findByL_S_S(groupId, language, status, sticky, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param sticky the sticky
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByL_S_S(long groupId, String language,
		long status, boolean sticky, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_S_S;
			finderArgs = new Object[] { groupId, language, status, sticky };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_L_S_S;
			finderArgs = new Object[] {
					groupId, language, status, sticky,
					
					start, end, orderByComparator
				};
		}

		List<VcmsArticle> list = (List<VcmsArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_L_S_S_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_L_S_S_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_L_S_S_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_L_S_S_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_L_S_S_STATUS_2);

			query.append(_FINDER_COLUMN_L_S_S_STICKY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
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

				qPos.add(status);

				qPos.add(sticky);

				list = (List<VcmsArticle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param sticky the sticky
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByL_S_S_First(long groupId, String language,
		long status, boolean sticky, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		List<VcmsArticle> list = findByL_S_S(groupId, language, status, sticky,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", status=");
			msg.append(status);

			msg.append(", sticky=");
			msg.append(sticky);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param sticky the sticky
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByL_S_S_Last(long groupId, String language,
		long status, boolean sticky, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		int count = countByL_S_S(groupId, language, status, sticky);

		List<VcmsArticle> list = findByL_S_S(groupId, language, status, sticky,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", status=");
			msg.append(status);

			msg.append(", sticky=");
			msg.append(sticky);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the primary key of the current vcms article
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param sticky the sticky
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle[] findByL_S_S_PrevAndNext(String articleId,
		long groupId, String language, long status, boolean sticky,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		VcmsArticle vcmsArticle = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			VcmsArticle[] array = new VcmsArticleImpl[3];

			array[0] = getByL_S_S_PrevAndNext(session, vcmsArticle, groupId,
					language, status, sticky, orderByComparator, true);

			array[1] = vcmsArticle;

			array[2] = getByL_S_S_PrevAndNext(session, vcmsArticle, groupId,
					language, status, sticky, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsArticle getByL_S_S_PrevAndNext(Session session,
		VcmsArticle vcmsArticle, long groupId, String language, long status,
		boolean sticky, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

		query.append(_FINDER_COLUMN_L_S_S_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_L_S_S_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_L_S_S_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_L_S_S_LANGUAGE_2);
			}
		}

		query.append(_FINDER_COLUMN_L_S_S_STATUS_2);

		query.append(_FINDER_COLUMN_L_S_S_STICKY_2);

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
			query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
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

		qPos.add(status);

		qPos.add(sticky);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @return the matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByU_L(long groupId, String createdByUser,
		String language) throws SystemException {
		return findByU_L(groupId, createdByUser, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @return the range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByU_L(long groupId, String createdByUser,
		String language, int start, int end) throws SystemException {
		return findByU_L(groupId, createdByUser, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByU_L(long groupId, String createdByUser,
		String language, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_L;
			finderArgs = new Object[] { groupId, createdByUser, language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_L;
			finderArgs = new Object[] {
					groupId, createdByUser, language,
					
					start, end, orderByComparator
				};
		}

		List<VcmsArticle> list = (List<VcmsArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_U_L_GROUPID_2);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_U_L_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_L_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_L_CREATEDBYUSER_2);
				}
			}

			if (language == null) {
				query.append(_FINDER_COLUMN_U_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_L_LANGUAGE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (createdByUser != null) {
					qPos.add(createdByUser);
				}

				if (language != null) {
					qPos.add(language);
				}

				list = (List<VcmsArticle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByU_L_First(long groupId, String createdByUser,
		String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		List<VcmsArticle> list = findByU_L(groupId, createdByUser, language, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", createdByUser=");
			msg.append(createdByUser);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByU_L_Last(long groupId, String createdByUser,
		String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		int count = countByU_L(groupId, createdByUser, language);

		List<VcmsArticle> list = findByU_L(groupId, createdByUser, language,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", createdByUser=");
			msg.append(createdByUser);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the primary key of the current vcms article
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle[] findByU_L_PrevAndNext(String articleId, long groupId,
		String createdByUser, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		VcmsArticle vcmsArticle = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			VcmsArticle[] array = new VcmsArticleImpl[3];

			array[0] = getByU_L_PrevAndNext(session, vcmsArticle, groupId,
					createdByUser, language, orderByComparator, true);

			array[1] = vcmsArticle;

			array[2] = getByU_L_PrevAndNext(session, vcmsArticle, groupId,
					createdByUser, language, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsArticle getByU_L_PrevAndNext(Session session,
		VcmsArticle vcmsArticle, long groupId, String createdByUser,
		String language, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

		query.append(_FINDER_COLUMN_U_L_GROUPID_2);

		if (createdByUser == null) {
			query.append(_FINDER_COLUMN_U_L_CREATEDBYUSER_1);
		}
		else {
			if (createdByUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_U_L_CREATEDBYUSER_3);
			}
			else {
				query.append(_FINDER_COLUMN_U_L_CREATEDBYUSER_2);
			}
		}

		if (language == null) {
			query.append(_FINDER_COLUMN_U_L_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_U_L_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_U_L_LANGUAGE_2);
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
			query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (createdByUser != null) {
			qPos.add(createdByUser);
		}

		if (language != null) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param status the status
	 * @return the matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByU_L_S(long groupId, String createdByUser,
		String language, long status) throws SystemException {
		return findByU_L_S(groupId, createdByUser, language, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param status the status
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @return the range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByU_L_S(long groupId, String createdByUser,
		String language, long status, int start, int end)
		throws SystemException {
		return findByU_L_S(groupId, createdByUser, language, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param status the status
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByU_L_S(long groupId, String createdByUser,
		String language, long status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_L_S;
			finderArgs = new Object[] { groupId, createdByUser, language, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_L_S;
			finderArgs = new Object[] {
					groupId, createdByUser, language, status,
					
					start, end, orderByComparator
				};
		}

		List<VcmsArticle> list = (List<VcmsArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_U_L_S_GROUPID_2);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_U_L_S_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_L_S_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_L_S_CREATEDBYUSER_2);
				}
			}

			if (language == null) {
				query.append(_FINDER_COLUMN_U_L_S_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_L_S_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_L_S_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_U_L_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (createdByUser != null) {
					qPos.add(createdByUser);
				}

				if (language != null) {
					qPos.add(language);
				}

				qPos.add(status);

				list = (List<VcmsArticle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByU_L_S_First(long groupId, String createdByUser,
		String language, long status, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		List<VcmsArticle> list = findByU_L_S(groupId, createdByUser, language,
				status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", createdByUser=");
			msg.append(createdByUser);

			msg.append(", language=");
			msg.append(language);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByU_L_S_Last(long groupId, String createdByUser,
		String language, long status, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		int count = countByU_L_S(groupId, createdByUser, language, status);

		List<VcmsArticle> list = findByU_L_S(groupId, createdByUser, language,
				status, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", createdByUser=");
			msg.append(createdByUser);

			msg.append(", language=");
			msg.append(language);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the primary key of the current vcms article
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle[] findByU_L_S_PrevAndNext(String articleId,
		long groupId, String createdByUser, String language, long status,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		VcmsArticle vcmsArticle = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			VcmsArticle[] array = new VcmsArticleImpl[3];

			array[0] = getByU_L_S_PrevAndNext(session, vcmsArticle, groupId,
					createdByUser, language, status, orderByComparator, true);

			array[1] = vcmsArticle;

			array[2] = getByU_L_S_PrevAndNext(session, vcmsArticle, groupId,
					createdByUser, language, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsArticle getByU_L_S_PrevAndNext(Session session,
		VcmsArticle vcmsArticle, long groupId, String createdByUser,
		String language, long status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

		query.append(_FINDER_COLUMN_U_L_S_GROUPID_2);

		if (createdByUser == null) {
			query.append(_FINDER_COLUMN_U_L_S_CREATEDBYUSER_1);
		}
		else {
			if (createdByUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_U_L_S_CREATEDBYUSER_3);
			}
			else {
				query.append(_FINDER_COLUMN_U_L_S_CREATEDBYUSER_2);
			}
		}

		if (language == null) {
			query.append(_FINDER_COLUMN_U_L_S_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_U_L_S_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_U_L_S_LANGUAGE_2);
			}
		}

		query.append(_FINDER_COLUMN_U_L_S_STATUS_2);

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
			query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (createdByUser != null) {
			qPos.add(createdByUser);
		}

		if (language != null) {
			qPos.add(language);
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param discussible the discussible
	 * @return the matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByP_L_S_D(long groupId, String language,
		long status, boolean discussible) throws SystemException {
		return findByP_L_S_D(groupId, language, status, discussible,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param discussible the discussible
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @return the range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByP_L_S_D(long groupId, String language,
		long status, boolean discussible, int start, int end)
		throws SystemException {
		return findByP_L_S_D(groupId, language, status, discussible, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param discussible the discussible
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByP_L_S_D(long groupId, String language,
		long status, boolean discussible, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_L_S_D;
			finderArgs = new Object[] { groupId, language, status, discussible };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_P_L_S_D;
			finderArgs = new Object[] {
					groupId, language, status, discussible,
					
					start, end, orderByComparator
				};
		}

		List<VcmsArticle> list = (List<VcmsArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_P_L_S_D_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_P_L_S_D_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_P_L_S_D_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_P_L_S_D_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_P_L_S_D_STATUS_2);

			query.append(_FINDER_COLUMN_P_L_S_D_DISCUSSIBLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
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

				qPos.add(status);

				qPos.add(discussible);

				list = (List<VcmsArticle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param discussible the discussible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByP_L_S_D_First(long groupId, String language,
		long status, boolean discussible, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		List<VcmsArticle> list = findByP_L_S_D(groupId, language, status,
				discussible, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", status=");
			msg.append(status);

			msg.append(", discussible=");
			msg.append(discussible);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param discussible the discussible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByP_L_S_D_Last(long groupId, String language,
		long status, boolean discussible, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		int count = countByP_L_S_D(groupId, language, status, discussible);

		List<VcmsArticle> list = findByP_L_S_D(groupId, language, status,
				discussible, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", status=");
			msg.append(status);

			msg.append(", discussible=");
			msg.append(discussible);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms articles before and after the current vcms article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the primary key of the current vcms article
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param discussible the discussible
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle[] findByP_L_S_D_PrevAndNext(String articleId,
		long groupId, String language, long status, boolean discussible,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		VcmsArticle vcmsArticle = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			VcmsArticle[] array = new VcmsArticleImpl[3];

			array[0] = getByP_L_S_D_PrevAndNext(session, vcmsArticle, groupId,
					language, status, discussible, orderByComparator, true);

			array[1] = vcmsArticle;

			array[2] = getByP_L_S_D_PrevAndNext(session, vcmsArticle, groupId,
					language, status, discussible, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsArticle getByP_L_S_D_PrevAndNext(Session session,
		VcmsArticle vcmsArticle, long groupId, String language, long status,
		boolean discussible, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

		query.append(_FINDER_COLUMN_P_L_S_D_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_P_L_S_D_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_P_L_S_D_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_P_L_S_D_LANGUAGE_2);
			}
		}

		query.append(_FINDER_COLUMN_P_L_S_D_STATUS_2);

		query.append(_FINDER_COLUMN_P_L_S_D_DISCUSSIBLE_2);

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
			query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
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

		qPos.add(status);

		qPos.add(discussible);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms articles where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByStatus(long status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms articles where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @return the range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByStatus(long status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms articles where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByStatus(long status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<VcmsArticle> list = (List<VcmsArticle>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<VcmsArticle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByStatus_First(long status,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		List<VcmsArticle> list = findByStatus(status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByStatus_Last(long status,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		int count = countByStatus(status);

		List<VcmsArticle> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms articles before and after the current vcms article in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the primary key of the current vcms article
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle[] findByStatus_PrevAndNext(String articleId,
		long status, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		VcmsArticle vcmsArticle = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			VcmsArticle[] array = new VcmsArticleImpl[3];

			array[0] = getByStatus_PrevAndNext(session, vcmsArticle, status,
					orderByComparator, true);

			array[1] = vcmsArticle;

			array[2] = getByStatus_PrevAndNext(session, vcmsArticle, status,
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

	protected VcmsArticle getByStatus_PrevAndNext(Session session,
		VcmsArticle vcmsArticle, long status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms articles where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms articles where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @return the range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms articles where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findByCompany(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<VcmsArticle> list = (List<VcmsArticle>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<VcmsArticle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms article in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		List<VcmsArticle> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a matching vcms article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		int count = countByCompany(companyId);

		List<VcmsArticle> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms articles before and after the current vcms article in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the primary key of the current vcms article
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleException if a vcms article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticle[] findByCompany_PrevAndNext(String articleId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleException, SystemException {
		VcmsArticle vcmsArticle = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			VcmsArticle[] array = new VcmsArticleImpl[3];

			array[0] = getByCompany_PrevAndNext(session, vcmsArticle,
					companyId, orderByComparator, true);

			array[1] = vcmsArticle;

			array[2] = getByCompany_PrevAndNext(session, vcmsArticle,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsArticle getByCompany_PrevAndNext(Session session,
		VcmsArticle vcmsArticle, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLE_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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
			query.append(VcmsArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms articles.
	 *
	 * @return the vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @return the range of vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms articles
	 * @param end the upper bound of the range of vcms articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticle> findAll(int start, int end,
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

		List<VcmsArticle> list = (List<VcmsArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSARTICLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSARTICLE.concat(VcmsArticleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsArticle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsArticle>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByL_S(long groupId, String language, long status)
		throws SystemException {
		for (VcmsArticle vcmsArticle : findByL_S(groupId, language, status)) {
			remove(vcmsArticle);
		}
	}

	/**
	 * Removes all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_L_S_U(long groupId, String language, long status,
		String createdByUser) throws SystemException {
		for (VcmsArticle vcmsArticle : findByG_L_S_U(groupId, language, status,
				createdByUser)) {
			remove(vcmsArticle);
		}
	}

	/**
	 * Removes all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param sticky the sticky
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByL_S_S(long groupId, String language, long status,
		boolean sticky) throws SystemException {
		for (VcmsArticle vcmsArticle : findByL_S_S(groupId, language, status,
				sticky)) {
			remove(vcmsArticle);
		}
	}

	/**
	 * Removes all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByU_L(long groupId, String createdByUser, String language)
		throws SystemException {
		for (VcmsArticle vcmsArticle : findByU_L(groupId, createdByUser,
				language)) {
			remove(vcmsArticle);
		}
	}

	/**
	 * Removes all the vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByU_L_S(long groupId, String createdByUser,
		String language, long status) throws SystemException {
		for (VcmsArticle vcmsArticle : findByU_L_S(groupId, createdByUser,
				language, status)) {
			remove(vcmsArticle);
		}
	}

	/**
	 * Removes all the vcms articles where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param discussible the discussible
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByP_L_S_D(long groupId, String language, long status,
		boolean discussible) throws SystemException {
		for (VcmsArticle vcmsArticle : findByP_L_S_D(groupId, language, status,
				discussible)) {
			remove(vcmsArticle);
		}
	}

	/**
	 * Removes all the vcms articles where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatus(long status) throws SystemException {
		for (VcmsArticle vcmsArticle : findByStatus(status)) {
			remove(vcmsArticle);
		}
	}

	/**
	 * Removes all the vcms articles where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompany(long companyId) throws SystemException {
		for (VcmsArticle vcmsArticle : findByCompany(companyId)) {
			remove(vcmsArticle);
		}
	}

	/**
	 * Removes all the vcms articles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsArticle vcmsArticle : findAll()) {
			remove(vcmsArticle);
		}
	}

	/**
	 * Returns the number of vcms articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @return the number of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByL_S(long groupId, String language, long status)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_L_S,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_L_S_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_L_S_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_L_S_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_L_S_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_L_S_STATUS_2);

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

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_L_S, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @return the number of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_L_S_U(long groupId, String language, long status,
		String createdByUser) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, language, status, createdByUser
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L_S_U,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_G_L_S_U_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_S_U_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_S_U_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_S_U_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_G_L_S_U_STATUS_2);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_2);
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

				qPos.add(status);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_L_S_U,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms articles where groupId = &#63; and language = &#63; and status = &#63; and sticky = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param sticky the sticky
	 * @return the number of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByL_S_S(long groupId, String language, long status,
		boolean sticky) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language, status, sticky };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_L_S_S,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_L_S_S_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_L_S_S_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_L_S_S_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_L_S_S_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_L_S_S_STATUS_2);

			query.append(_FINDER_COLUMN_L_S_S_STICKY_2);

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

				qPos.add(status);

				qPos.add(sticky);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_L_S_S,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @return the number of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_L(long groupId, String createdByUser, String language)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, createdByUser, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_U_L_GROUPID_2);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_U_L_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_L_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_L_CREATEDBYUSER_2);
				}
			}

			if (language == null) {
				query.append(_FINDER_COLUMN_U_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_L_LANGUAGE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (createdByUser != null) {
					qPos.add(createdByUser);
				}

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_L, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms articles where groupId = &#63; and createdByUser = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param status the status
	 * @return the number of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_L_S(long groupId, String createdByUser,
		String language, long status) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, createdByUser, language, status
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_L_S,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_U_L_S_GROUPID_2);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_U_L_S_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_L_S_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_L_S_CREATEDBYUSER_2);
				}
			}

			if (language == null) {
				query.append(_FINDER_COLUMN_U_L_S_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_L_S_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_L_S_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_U_L_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (createdByUser != null) {
					qPos.add(createdByUser);
				}

				if (language != null) {
					qPos.add(language);
				}

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_L_S,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms articles where groupId = &#63; and language = &#63; and status = &#63; and discussible = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param discussible the discussible
	 * @return the number of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByP_L_S_D(long groupId, String language, long status,
		boolean discussible) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, language, status, discussible
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_P_L_S_D,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_P_L_S_D_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_P_L_S_D_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_P_L_S_D_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_P_L_S_D_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_P_L_S_D_STATUS_2);

			query.append(_FINDER_COLUMN_P_L_S_D_DISCUSSIBLE_2);

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

				qPos.add(status);

				qPos.add(discussible);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_P_L_S_D,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms articles where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatus(long status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms articles where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompany(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSARTICLE_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms articles.
	 *
	 * @return the number of vcms articles
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSARTICLE);

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
	 * Initializes the vcms article persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsArticle")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsArticle>> listenersList = new ArrayList<ModelListener<VcmsArticle>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsArticle>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsArticleImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSARTICLE = "SELECT vcmsArticle FROM VcmsArticle vcmsArticle";
	private static final String _SQL_SELECT_VCMSARTICLE_WHERE = "SELECT vcmsArticle FROM VcmsArticle vcmsArticle WHERE ";
	private static final String _SQL_COUNT_VCMSARTICLE = "SELECT COUNT(vcmsArticle) FROM VcmsArticle vcmsArticle";
	private static final String _SQL_COUNT_VCMSARTICLE_WHERE = "SELECT COUNT(vcmsArticle) FROM VcmsArticle vcmsArticle WHERE ";
	private static final String _FINDER_COLUMN_L_S_GROUPID_2 = "vcmsArticle.groupId = ? AND ";
	private static final String _FINDER_COLUMN_L_S_LANGUAGE_1 = "vcmsArticle.language IS NULL AND ";
	private static final String _FINDER_COLUMN_L_S_LANGUAGE_2 = "vcmsArticle.language = ? AND ";
	private static final String _FINDER_COLUMN_L_S_LANGUAGE_3 = "(vcmsArticle.language IS NULL OR vcmsArticle.language = ?) AND ";
	private static final String _FINDER_COLUMN_L_S_STATUS_2 = "vcmsArticle.status = ?";
	private static final String _FINDER_COLUMN_G_L_S_U_GROUPID_2 = "vcmsArticle.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_S_U_LANGUAGE_1 = "vcmsArticle.language IS NULL AND ";
	private static final String _FINDER_COLUMN_G_L_S_U_LANGUAGE_2 = "vcmsArticle.language = ? AND ";
	private static final String _FINDER_COLUMN_G_L_S_U_LANGUAGE_3 = "(vcmsArticle.language IS NULL OR vcmsArticle.language = ?) AND ";
	private static final String _FINDER_COLUMN_G_L_S_U_STATUS_2 = "vcmsArticle.status = ? AND ";
	private static final String _FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_1 = "vcmsArticle.createdByUser IS NULL";
	private static final String _FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_2 = "vcmsArticle.createdByUser = ?";
	private static final String _FINDER_COLUMN_G_L_S_U_CREATEDBYUSER_3 = "(vcmsArticle.createdByUser IS NULL OR vcmsArticle.createdByUser = ?)";
	private static final String _FINDER_COLUMN_L_S_S_GROUPID_2 = "vcmsArticle.groupId = ? AND ";
	private static final String _FINDER_COLUMN_L_S_S_LANGUAGE_1 = "vcmsArticle.language IS NULL AND ";
	private static final String _FINDER_COLUMN_L_S_S_LANGUAGE_2 = "vcmsArticle.language = ? AND ";
	private static final String _FINDER_COLUMN_L_S_S_LANGUAGE_3 = "(vcmsArticle.language IS NULL OR vcmsArticle.language = ?) AND ";
	private static final String _FINDER_COLUMN_L_S_S_STATUS_2 = "vcmsArticle.status = ? AND ";
	private static final String _FINDER_COLUMN_L_S_S_STICKY_2 = "vcmsArticle.sticky = ?";
	private static final String _FINDER_COLUMN_U_L_GROUPID_2 = "vcmsArticle.groupId = ? AND ";
	private static final String _FINDER_COLUMN_U_L_CREATEDBYUSER_1 = "vcmsArticle.createdByUser IS NULL AND ";
	private static final String _FINDER_COLUMN_U_L_CREATEDBYUSER_2 = "vcmsArticle.createdByUser = ? AND ";
	private static final String _FINDER_COLUMN_U_L_CREATEDBYUSER_3 = "(vcmsArticle.createdByUser IS NULL OR vcmsArticle.createdByUser = ?) AND ";
	private static final String _FINDER_COLUMN_U_L_LANGUAGE_1 = "vcmsArticle.language IS NULL";
	private static final String _FINDER_COLUMN_U_L_LANGUAGE_2 = "vcmsArticle.language = ?";
	private static final String _FINDER_COLUMN_U_L_LANGUAGE_3 = "(vcmsArticle.language IS NULL OR vcmsArticle.language = ?)";
	private static final String _FINDER_COLUMN_U_L_S_GROUPID_2 = "vcmsArticle.groupId = ? AND ";
	private static final String _FINDER_COLUMN_U_L_S_CREATEDBYUSER_1 = "vcmsArticle.createdByUser IS NULL AND ";
	private static final String _FINDER_COLUMN_U_L_S_CREATEDBYUSER_2 = "vcmsArticle.createdByUser = ? AND ";
	private static final String _FINDER_COLUMN_U_L_S_CREATEDBYUSER_3 = "(vcmsArticle.createdByUser IS NULL OR vcmsArticle.createdByUser = ?) AND ";
	private static final String _FINDER_COLUMN_U_L_S_LANGUAGE_1 = "vcmsArticle.language IS NULL AND ";
	private static final String _FINDER_COLUMN_U_L_S_LANGUAGE_2 = "vcmsArticle.language = ? AND ";
	private static final String _FINDER_COLUMN_U_L_S_LANGUAGE_3 = "(vcmsArticle.language IS NULL OR vcmsArticle.language = ?) AND ";
	private static final String _FINDER_COLUMN_U_L_S_STATUS_2 = "vcmsArticle.status = ?";
	private static final String _FINDER_COLUMN_P_L_S_D_GROUPID_2 = "vcmsArticle.groupId = ? AND ";
	private static final String _FINDER_COLUMN_P_L_S_D_LANGUAGE_1 = "vcmsArticle.language IS NULL AND ";
	private static final String _FINDER_COLUMN_P_L_S_D_LANGUAGE_2 = "vcmsArticle.language = ? AND ";
	private static final String _FINDER_COLUMN_P_L_S_D_LANGUAGE_3 = "(vcmsArticle.language IS NULL OR vcmsArticle.language = ?) AND ";
	private static final String _FINDER_COLUMN_P_L_S_D_STATUS_2 = "vcmsArticle.status = ? AND ";
	private static final String _FINDER_COLUMN_P_L_S_D_DISCUSSIBLE_2 = "vcmsArticle.discussible = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "vcmsArticle.status = ?";
	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "vcmsArticle.companyId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsArticle.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsArticle exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsArticle exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsArticlePersistenceImpl.class);
	private static VcmsArticle _nullVcmsArticle = new VcmsArticleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsArticle> toCacheModel() {
				return _nullVcmsArticleCacheModel;
			}
		};

	private static CacheModel<VcmsArticle> _nullVcmsArticleCacheModel = new CacheModel<VcmsArticle>() {
			public VcmsArticle toEntityModel() {
				return _nullVcmsArticle;
			}
		};
}