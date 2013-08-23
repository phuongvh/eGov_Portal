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

import com.vportal.portlet.vcms.NoSuchVcmsCategoryException;
import com.vportal.portlet.vcms.model.VcmsCategory;
import com.vportal.portlet.vcms.model.impl.VcmsCategoryImpl;
import com.vportal.portlet.vcms.model.impl.VcmsCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsCategoryPersistence
 * @see VcmsCategoryUtil
 * @generated
 */
public class VcmsCategoryPersistenceImpl extends BasePersistenceImpl<VcmsCategory>
	implements VcmsCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsCategoryUtil} to access the vcms category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTION_LANGUAGE =
		new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, VcmsCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPortion_Language",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTION_LANGUAGE =
		new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, VcmsCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPortion_Language",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			VcmsCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsCategoryModelImpl.PORTIONID_COLUMN_BITMASK |
			VcmsCategoryModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORTION_LANGUAGE = new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPortion_Language",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT_LANGUAGE =
		new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, VcmsCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParent_Language",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT_LANGUAGE =
		new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, VcmsCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParent_Language",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			VcmsCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsCategoryModelImpl.PARENTID_COLUMN_BITMASK |
			VcmsCategoryModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENT_LANGUAGE = new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParent_Language",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGE = new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, VcmsCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLanguage",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE =
		new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, VcmsCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLanguage",
			new String[] { Long.class.getName(), String.class.getName() },
			VcmsCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsCategoryModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANGUAGE = new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLanguage",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_P_P_L = new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, VcmsCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_P_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_P_L = new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, VcmsCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_P_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			VcmsCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsCategoryModelImpl.PORTIONID_COLUMN_BITMASK |
			VcmsCategoryModelImpl.PARENTID_COLUMN_BITMASK |
			VcmsCategoryModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_P_P_L = new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_P_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, VcmsCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, VcmsCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms category in the entity cache if it is enabled.
	 *
	 * @param vcmsCategory the vcms category
	 */
	public void cacheResult(VcmsCategory vcmsCategory) {
		EntityCacheUtil.putResult(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryImpl.class, vcmsCategory.getPrimaryKey(), vcmsCategory);

		vcmsCategory.resetOriginalValues();
	}

	/**
	 * Caches the vcms categories in the entity cache if it is enabled.
	 *
	 * @param vcmsCategories the vcms categories
	 */
	public void cacheResult(List<VcmsCategory> vcmsCategories) {
		for (VcmsCategory vcmsCategory : vcmsCategories) {
			if (EntityCacheUtil.getResult(
						VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VcmsCategoryImpl.class, vcmsCategory.getPrimaryKey()) == null) {
				cacheResult(vcmsCategory);
			}
			else {
				vcmsCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsCategory vcmsCategory) {
		EntityCacheUtil.removeResult(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryImpl.class, vcmsCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VcmsCategory> vcmsCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsCategory vcmsCategory : vcmsCategories) {
			EntityCacheUtil.removeResult(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VcmsCategoryImpl.class, vcmsCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vcms category with the primary key. Does not add the vcms category to the database.
	 *
	 * @param categoryId the primary key for the new vcms category
	 * @return the new vcms category
	 */
	public VcmsCategory create(String categoryId) {
		VcmsCategory vcmsCategory = new VcmsCategoryImpl();

		vcmsCategory.setNew(true);
		vcmsCategory.setPrimaryKey(categoryId);

		return vcmsCategory;
	}

	/**
	 * Removes the vcms category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the vcms category
	 * @return the vcms category that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory remove(String categoryId)
		throws NoSuchVcmsCategoryException, SystemException {
		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the vcms category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms category
	 * @return the vcms category that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsCategory remove(Serializable primaryKey)
		throws NoSuchVcmsCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsCategory vcmsCategory = (VcmsCategory)session.get(VcmsCategoryImpl.class,
					primaryKey);

			if (vcmsCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsCategory);
		}
		catch (NoSuchVcmsCategoryException nsee) {
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
	protected VcmsCategory removeImpl(VcmsCategory vcmsCategory)
		throws SystemException {
		vcmsCategory = toUnwrappedModel(vcmsCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsCategory);

		return vcmsCategory;
	}

	@Override
	public VcmsCategory updateImpl(
		com.vportal.portlet.vcms.model.VcmsCategory vcmsCategory, boolean merge)
		throws SystemException {
		vcmsCategory = toUnwrappedModel(vcmsCategory);

		boolean isNew = vcmsCategory.isNew();

		VcmsCategoryModelImpl vcmsCategoryModelImpl = (VcmsCategoryModelImpl)vcmsCategory;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsCategory, merge);

			vcmsCategory.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTION_LANGUAGE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsCategoryModelImpl.getOriginalGroupId()),
						
						vcmsCategoryModelImpl.getOriginalPortionId(),
						
						vcmsCategoryModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTION_LANGUAGE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTION_LANGUAGE,
					args);

				args = new Object[] {
						Long.valueOf(vcmsCategoryModelImpl.getGroupId()),
						
						vcmsCategoryModelImpl.getPortionId(),
						
						vcmsCategoryModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTION_LANGUAGE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTION_LANGUAGE,
					args);
			}

			if ((vcmsCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT_LANGUAGE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsCategoryModelImpl.getOriginalGroupId()),
						
						vcmsCategoryModelImpl.getOriginalParentId(),
						
						vcmsCategoryModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT_LANGUAGE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT_LANGUAGE,
					args);

				args = new Object[] {
						Long.valueOf(vcmsCategoryModelImpl.getGroupId()),
						
						vcmsCategoryModelImpl.getParentId(),
						
						vcmsCategoryModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT_LANGUAGE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT_LANGUAGE,
					args);
			}

			if ((vcmsCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsCategoryModelImpl.getOriginalGroupId()),
						
						vcmsCategoryModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE,
					args);

				args = new Object[] {
						Long.valueOf(vcmsCategoryModelImpl.getGroupId()),
						
						vcmsCategoryModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE,
					args);
			}

			if ((vcmsCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_P_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsCategoryModelImpl.getOriginalGroupId()),
						
						vcmsCategoryModelImpl.getOriginalPortionId(),
						
						vcmsCategoryModelImpl.getOriginalParentId(),
						
						vcmsCategoryModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_P_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_P_L,
					args);

				args = new Object[] {
						Long.valueOf(vcmsCategoryModelImpl.getGroupId()),
						
						vcmsCategoryModelImpl.getPortionId(),
						
						vcmsCategoryModelImpl.getParentId(),
						
						vcmsCategoryModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_P_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_P_L,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VcmsCategoryImpl.class, vcmsCategory.getPrimaryKey(), vcmsCategory);

		return vcmsCategory;
	}

	protected VcmsCategory toUnwrappedModel(VcmsCategory vcmsCategory) {
		if (vcmsCategory instanceof VcmsCategoryImpl) {
			return vcmsCategory;
		}

		VcmsCategoryImpl vcmsCategoryImpl = new VcmsCategoryImpl();

		vcmsCategoryImpl.setNew(vcmsCategory.isNew());
		vcmsCategoryImpl.setPrimaryKey(vcmsCategory.getPrimaryKey());

		vcmsCategoryImpl.setCategoryId(vcmsCategory.getCategoryId());
		vcmsCategoryImpl.setGroupId(vcmsCategory.getGroupId());
		vcmsCategoryImpl.setCompanyId(vcmsCategory.getCompanyId());
		vcmsCategoryImpl.setCreatedDate(vcmsCategory.getCreatedDate());
		vcmsCategoryImpl.setCreatedByUser(vcmsCategory.getCreatedByUser());
		vcmsCategoryImpl.setModifiedDate(vcmsCategory.getModifiedDate());
		vcmsCategoryImpl.setModifiedByUser(vcmsCategory.getModifiedByUser());
		vcmsCategoryImpl.setPortionId(vcmsCategory.getPortionId());
		vcmsCategoryImpl.setParentId(vcmsCategory.getParentId());
		vcmsCategoryImpl.setName(vcmsCategory.getName());
		vcmsCategoryImpl.setDescription(vcmsCategory.getDescription());
		vcmsCategoryImpl.setAnchored(vcmsCategory.isAnchored());
		vcmsCategoryImpl.setHref(vcmsCategory.getHref());
		vcmsCategoryImpl.setLanguage(vcmsCategory.getLanguage());
		vcmsCategoryImpl.setHasImage(vcmsCategory.isHasImage());
		vcmsCategoryImpl.setImage(vcmsCategory.getImage());
		vcmsCategoryImpl.setPosition(vcmsCategory.getPosition());
		vcmsCategoryImpl.setUserHit(vcmsCategory.getUserHit());
		vcmsCategoryImpl.setRssable(vcmsCategory.isRssable());

		return vcmsCategoryImpl;
	}

	/**
	 * Returns the vcms category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms category
	 * @return the vcms category
	 * @throws com.liferay.portal.NoSuchModelException if a vcms category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms category with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the vcms category
	 * @return the vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory findByPrimaryKey(String categoryId)
		throws NoSuchVcmsCategoryException, SystemException {
		VcmsCategory vcmsCategory = fetchByPrimaryKey(categoryId);

		if (vcmsCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchVcmsCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return vcmsCategory;
	}

	/**
	 * Returns the vcms category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms category
	 * @return the vcms category, or <code>null</code> if a vcms category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the vcms category
	 * @return the vcms category, or <code>null</code> if a vcms category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory fetchByPrimaryKey(String categoryId)
		throws SystemException {
		VcmsCategory vcmsCategory = (VcmsCategory)EntityCacheUtil.getResult(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VcmsCategoryImpl.class, categoryId);

		if (vcmsCategory == _nullVcmsCategory) {
			return null;
		}

		if (vcmsCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsCategory = (VcmsCategory)session.get(VcmsCategoryImpl.class,
						categoryId);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsCategory != null) {
					cacheResult(vcmsCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VcmsCategoryImpl.class, categoryId, _nullVcmsCategory);
				}

				closeSession(session);
			}
		}

		return vcmsCategory;
	}

	/**
	 * Returns all the vcms categories where groupId = &#63; and portionId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param language the language
	 * @return the matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByPortion_Language(long groupId,
		String portionId, String language) throws SystemException {
		return findByPortion_Language(groupId, portionId, language,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms categories where groupId = &#63; and portionId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms categories
	 * @param end the upper bound of the range of vcms categories (not inclusive)
	 * @return the range of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByPortion_Language(long groupId,
		String portionId, String language, int start, int end)
		throws SystemException {
		return findByPortion_Language(groupId, portionId, language, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the vcms categories where groupId = &#63; and portionId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms categories
	 * @param end the upper bound of the range of vcms categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByPortion_Language(long groupId,
		String portionId, String language, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTION_LANGUAGE;
			finderArgs = new Object[] { groupId, portionId, language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTION_LANGUAGE;
			finderArgs = new Object[] {
					groupId, portionId, language,
					
					start, end, orderByComparator
				};
		}

		List<VcmsCategory> list = (List<VcmsCategory>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PORTION_LANGUAGE_GROUPID_2);

			if (portionId == null) {
				query.append(_FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_1);
			}
			else {
				if (portionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_2);
				}
			}

			if (language == null) {
				query.append(_FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (portionId != null) {
					qPos.add(portionId);
				}

				if (language != null) {
					qPos.add(language);
				}

				list = (List<VcmsCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms category in the ordered set where groupId = &#63; and portionId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory findByPortion_Language_First(long groupId,
		String portionId, String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		List<VcmsCategory> list = findByPortion_Language(groupId, portionId,
				language, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", portionId=");
			msg.append(portionId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms category in the ordered set where groupId = &#63; and portionId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory findByPortion_Language_Last(long groupId,
		String portionId, String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		int count = countByPortion_Language(groupId, portionId, language);

		List<VcmsCategory> list = findByPortion_Language(groupId, portionId,
				language, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", portionId=");
			msg.append(portionId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms categories before and after the current vcms category in the ordered set where groupId = &#63; and portionId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the primary key of the current vcms category
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory[] findByPortion_Language_PrevAndNext(
		String categoryId, long groupId, String portionId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		VcmsCategory vcmsCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VcmsCategory[] array = new VcmsCategoryImpl[3];

			array[0] = getByPortion_Language_PrevAndNext(session, vcmsCategory,
					groupId, portionId, language, orderByComparator, true);

			array[1] = vcmsCategory;

			array[2] = getByPortion_Language_PrevAndNext(session, vcmsCategory,
					groupId, portionId, language, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsCategory getByPortion_Language_PrevAndNext(Session session,
		VcmsCategory vcmsCategory, long groupId, String portionId,
		String language, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PORTION_LANGUAGE_GROUPID_2);

		if (portionId == null) {
			query.append(_FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_1);
		}
		else {
			if (portionId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_3);
			}
			else {
				query.append(_FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_2);
			}
		}

		if (language == null) {
			query.append(_FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_2);
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
			query.append(VcmsCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (portionId != null) {
			qPos.add(portionId);
		}

		if (language != null) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms categories where groupId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @return the matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByParent_Language(long groupId,
		String parentId, String language) throws SystemException {
		return findByParent_Language(groupId, parentId, language,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms categories where groupId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms categories
	 * @param end the upper bound of the range of vcms categories (not inclusive)
	 * @return the range of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByParent_Language(long groupId,
		String parentId, String language, int start, int end)
		throws SystemException {
		return findByParent_Language(groupId, parentId, language, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the vcms categories where groupId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms categories
	 * @param end the upper bound of the range of vcms categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByParent_Language(long groupId,
		String parentId, String language, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT_LANGUAGE;
			finderArgs = new Object[] { groupId, parentId, language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT_LANGUAGE;
			finderArgs = new Object[] {
					groupId, parentId, language,
					
					start, end, orderByComparator
				};
		}

		List<VcmsCategory> list = (List<VcmsCategory>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENT_LANGUAGE_GROUPID_2);

			if (parentId == null) {
				query.append(_FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_1);
			}
			else {
				if (parentId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_2);
				}
			}

			if (language == null) {
				query.append(_FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (parentId != null) {
					qPos.add(parentId);
				}

				if (language != null) {
					qPos.add(language);
				}

				list = (List<VcmsCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms category in the ordered set where groupId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory findByParent_Language_First(long groupId,
		String parentId, String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		List<VcmsCategory> list = findByParent_Language(groupId, parentId,
				language, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", parentId=");
			msg.append(parentId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms category in the ordered set where groupId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory findByParent_Language_Last(long groupId,
		String parentId, String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		int count = countByParent_Language(groupId, parentId, language);

		List<VcmsCategory> list = findByParent_Language(groupId, parentId,
				language, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", parentId=");
			msg.append(parentId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms categories before and after the current vcms category in the ordered set where groupId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the primary key of the current vcms category
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory[] findByParent_Language_PrevAndNext(String categoryId,
		long groupId, String parentId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		VcmsCategory vcmsCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VcmsCategory[] array = new VcmsCategoryImpl[3];

			array[0] = getByParent_Language_PrevAndNext(session, vcmsCategory,
					groupId, parentId, language, orderByComparator, true);

			array[1] = vcmsCategory;

			array[2] = getByParent_Language_PrevAndNext(session, vcmsCategory,
					groupId, parentId, language, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsCategory getByParent_Language_PrevAndNext(Session session,
		VcmsCategory vcmsCategory, long groupId, String parentId,
		String language, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENT_LANGUAGE_GROUPID_2);

		if (parentId == null) {
			query.append(_FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_1);
		}
		else {
			if (parentId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_3);
			}
			else {
				query.append(_FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_2);
			}
		}

		if (language == null) {
			query.append(_FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_2);
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
			query.append(VcmsCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (parentId != null) {
			qPos.add(parentId);
		}

		if (language != null) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms categories where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByLanguage(long groupId, String language)
		throws SystemException {
		return findByLanguage(groupId, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms categories where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms categories
	 * @param end the upper bound of the range of vcms categories (not inclusive)
	 * @return the range of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByLanguage(long groupId, String language,
		int start, int end) throws SystemException {
		return findByLanguage(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms categories where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms categories
	 * @param end the upper bound of the range of vcms categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByLanguage(long groupId, String language,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE;
			finderArgs = new Object[] { groupId, language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGE;
			finderArgs = new Object[] {
					groupId, language,
					
					start, end, orderByComparator
				};
		}

		List<VcmsCategory> list = (List<VcmsCategory>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_LANGUAGE_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<VcmsCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms category in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory findByLanguage_First(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		List<VcmsCategory> list = findByLanguage(groupId, language, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms category in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory findByLanguage_Last(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		int count = countByLanguage(groupId, language);

		List<VcmsCategory> list = findByLanguage(groupId, language, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms categories before and after the current vcms category in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the primary key of the current vcms category
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory[] findByLanguage_PrevAndNext(String categoryId,
		long groupId, String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		VcmsCategory vcmsCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VcmsCategory[] array = new VcmsCategoryImpl[3];

			array[0] = getByLanguage_PrevAndNext(session, vcmsCategory,
					groupId, language, orderByComparator, true);

			array[1] = vcmsCategory;

			array[2] = getByLanguage_PrevAndNext(session, vcmsCategory,
					groupId, language, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsCategory getByLanguage_PrevAndNext(Session session,
		VcmsCategory vcmsCategory, long groupId, String language,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_LANGUAGE_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_2);
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
			query.append(VcmsCategoryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms categories where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @return the matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByP_P_L(long groupId, String portionId,
		String parentId, String language) throws SystemException {
		return findByP_P_L(groupId, portionId, parentId, language,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms categories where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms categories
	 * @param end the upper bound of the range of vcms categories (not inclusive)
	 * @return the range of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByP_P_L(long groupId, String portionId,
		String parentId, String language, int start, int end)
		throws SystemException {
		return findByP_P_L(groupId, portionId, parentId, language, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the vcms categories where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms categories
	 * @param end the upper bound of the range of vcms categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findByP_P_L(long groupId, String portionId,
		String parentId, String language, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_P_L;
			finderArgs = new Object[] { groupId, portionId, parentId, language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_P_P_L;
			finderArgs = new Object[] {
					groupId, portionId, parentId, language,
					
					start, end, orderByComparator
				};
		}

		List<VcmsCategory> list = (List<VcmsCategory>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_P_P_L_GROUPID_2);

			if (portionId == null) {
				query.append(_FINDER_COLUMN_P_P_L_PORTIONID_1);
			}
			else {
				if (portionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_P_P_L_PORTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_P_P_L_PORTIONID_2);
				}
			}

			if (parentId == null) {
				query.append(_FINDER_COLUMN_P_P_L_PARENTID_1);
			}
			else {
				if (parentId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_P_P_L_PARENTID_3);
				}
				else {
					query.append(_FINDER_COLUMN_P_P_L_PARENTID_2);
				}
			}

			if (language == null) {
				query.append(_FINDER_COLUMN_P_P_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_P_P_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_P_P_L_LANGUAGE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (portionId != null) {
					qPos.add(portionId);
				}

				if (parentId != null) {
					qPos.add(parentId);
				}

				if (language != null) {
					qPos.add(language);
				}

				list = (List<VcmsCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vcms category in the ordered set where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory findByP_P_L_First(long groupId, String portionId,
		String parentId, String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		List<VcmsCategory> list = findByP_P_L(groupId, portionId, parentId,
				language, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", portionId=");
			msg.append(portionId);

			msg.append(", parentId=");
			msg.append(parentId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms category in the ordered set where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a matching vcms category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory findByP_P_L_Last(long groupId, String portionId,
		String parentId, String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		int count = countByP_P_L(groupId, portionId, parentId, language);

		List<VcmsCategory> list = findByP_P_L(groupId, portionId, parentId,
				language, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", portionId=");
			msg.append(portionId);

			msg.append(", parentId=");
			msg.append(parentId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms categories before and after the current vcms category in the ordered set where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the primary key of the current vcms category
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms category
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsCategoryException if a vcms category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsCategory[] findByP_P_L_PrevAndNext(String categoryId,
		long groupId, String portionId, String parentId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsCategoryException, SystemException {
		VcmsCategory vcmsCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			VcmsCategory[] array = new VcmsCategoryImpl[3];

			array[0] = getByP_P_L_PrevAndNext(session, vcmsCategory, groupId,
					portionId, parentId, language, orderByComparator, true);

			array[1] = vcmsCategory;

			array[2] = getByP_P_L_PrevAndNext(session, vcmsCategory, groupId,
					portionId, parentId, language, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsCategory getByP_P_L_PrevAndNext(Session session,
		VcmsCategory vcmsCategory, long groupId, String portionId,
		String parentId, String language, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_P_P_L_GROUPID_2);

		if (portionId == null) {
			query.append(_FINDER_COLUMN_P_P_L_PORTIONID_1);
		}
		else {
			if (portionId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_P_P_L_PORTIONID_3);
			}
			else {
				query.append(_FINDER_COLUMN_P_P_L_PORTIONID_2);
			}
		}

		if (parentId == null) {
			query.append(_FINDER_COLUMN_P_P_L_PARENTID_1);
		}
		else {
			if (parentId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_P_P_L_PARENTID_3);
			}
			else {
				query.append(_FINDER_COLUMN_P_P_L_PARENTID_2);
			}
		}

		if (language == null) {
			query.append(_FINDER_COLUMN_P_P_L_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_P_P_L_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_P_P_L_LANGUAGE_2);
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
			query.append(VcmsCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (portionId != null) {
			qPos.add(portionId);
		}

		if (parentId != null) {
			qPos.add(parentId);
		}

		if (language != null) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms categories.
	 *
	 * @return the vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms categories
	 * @param end the upper bound of the range of vcms categories (not inclusive)
	 * @return the range of vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms categories
	 * @param end the upper bound of the range of vcms categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsCategory> findAll(int start, int end,
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

		List<VcmsCategory> list = (List<VcmsCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSCATEGORY.concat(VcmsCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vcms categories where groupId = &#63; and portionId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPortion_Language(long groupId, String portionId,
		String language) throws SystemException {
		for (VcmsCategory vcmsCategory : findByPortion_Language(groupId,
				portionId, language)) {
			remove(vcmsCategory);
		}
	}

	/**
	 * Removes all the vcms categories where groupId = &#63; and parentId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParent_Language(long groupId, String parentId,
		String language) throws SystemException {
		for (VcmsCategory vcmsCategory : findByParent_Language(groupId,
				parentId, language)) {
			remove(vcmsCategory);
		}
	}

	/**
	 * Removes all the vcms categories where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLanguage(long groupId, String language)
		throws SystemException {
		for (VcmsCategory vcmsCategory : findByLanguage(groupId, language)) {
			remove(vcmsCategory);
		}
	}

	/**
	 * Removes all the vcms categories where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByP_P_L(long groupId, String portionId, String parentId,
		String language) throws SystemException {
		for (VcmsCategory vcmsCategory : findByP_P_L(groupId, portionId,
				parentId, language)) {
			remove(vcmsCategory);
		}
	}

	/**
	 * Removes all the vcms categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsCategory vcmsCategory : findAll()) {
			remove(vcmsCategory);
		}
	}

	/**
	 * Returns the number of vcms categories where groupId = &#63; and portionId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param language the language
	 * @return the number of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPortion_Language(long groupId, String portionId,
		String language) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, portionId, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PORTION_LANGUAGE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VCMSCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PORTION_LANGUAGE_GROUPID_2);

			if (portionId == null) {
				query.append(_FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_1);
			}
			else {
				if (portionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_2);
				}
			}

			if (language == null) {
				query.append(_FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (portionId != null) {
					qPos.add(portionId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORTION_LANGUAGE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms categories where groupId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @return the number of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParent_Language(long groupId, String parentId,
		String language) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, parentId, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENT_LANGUAGE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VCMSCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENT_LANGUAGE_GROUPID_2);

			if (parentId == null) {
				query.append(_FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_1);
			}
			else {
				if (parentId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_2);
				}
			}

			if (language == null) {
				query.append(_FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (parentId != null) {
					qPos.add(parentId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENT_LANGUAGE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms categories where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLanguage(long groupId, String language)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LANGUAGE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_LANGUAGE_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LANGUAGE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms categories where groupId = &#63; and portionId = &#63; and parentId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portionId the portion ID
	 * @param parentId the parent ID
	 * @param language the language
	 * @return the number of matching vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByP_P_L(long groupId, String portionId, String parentId,
		String language) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, portionId, parentId, language
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_P_P_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_VCMSCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_P_P_L_GROUPID_2);

			if (portionId == null) {
				query.append(_FINDER_COLUMN_P_P_L_PORTIONID_1);
			}
			else {
				if (portionId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_P_P_L_PORTIONID_3);
				}
				else {
					query.append(_FINDER_COLUMN_P_P_L_PORTIONID_2);
				}
			}

			if (parentId == null) {
				query.append(_FINDER_COLUMN_P_P_L_PARENTID_1);
			}
			else {
				if (parentId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_P_P_L_PARENTID_3);
				}
				else {
					query.append(_FINDER_COLUMN_P_P_L_PARENTID_2);
				}
			}

			if (language == null) {
				query.append(_FINDER_COLUMN_P_P_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_P_P_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_P_P_L_LANGUAGE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (portionId != null) {
					qPos.add(portionId);
				}

				if (parentId != null) {
					qPos.add(parentId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_P_P_L,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms categories.
	 *
	 * @return the number of vcms categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSCATEGORY);

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
	 * Initializes the vcms category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsCategory>> listenersList = new ArrayList<ModelListener<VcmsCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsCategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSCATEGORY = "SELECT vcmsCategory FROM VcmsCategory vcmsCategory";
	private static final String _SQL_SELECT_VCMSCATEGORY_WHERE = "SELECT vcmsCategory FROM VcmsCategory vcmsCategory WHERE ";
	private static final String _SQL_COUNT_VCMSCATEGORY = "SELECT COUNT(vcmsCategory) FROM VcmsCategory vcmsCategory";
	private static final String _SQL_COUNT_VCMSCATEGORY_WHERE = "SELECT COUNT(vcmsCategory) FROM VcmsCategory vcmsCategory WHERE ";
	private static final String _FINDER_COLUMN_PORTION_LANGUAGE_GROUPID_2 = "vcmsCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_1 = "vcmsCategory.portionId IS NULL AND ";
	private static final String _FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_2 = "vcmsCategory.portionId = ? AND ";
	private static final String _FINDER_COLUMN_PORTION_LANGUAGE_PORTIONID_3 = "(vcmsCategory.portionId IS NULL OR vcmsCategory.portionId = ?) AND ";
	private static final String _FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_1 = "vcmsCategory.language IS NULL";
	private static final String _FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_2 = "vcmsCategory.language = ?";
	private static final String _FINDER_COLUMN_PORTION_LANGUAGE_LANGUAGE_3 = "(vcmsCategory.language IS NULL OR vcmsCategory.language = ?)";
	private static final String _FINDER_COLUMN_PARENT_LANGUAGE_GROUPID_2 = "vcmsCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_1 = "vcmsCategory.parentId IS NULL AND ";
	private static final String _FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_2 = "vcmsCategory.parentId = ? AND ";
	private static final String _FINDER_COLUMN_PARENT_LANGUAGE_PARENTID_3 = "(vcmsCategory.parentId IS NULL OR vcmsCategory.parentId = ?) AND ";
	private static final String _FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_1 = "vcmsCategory.language IS NULL";
	private static final String _FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_2 = "vcmsCategory.language = ?";
	private static final String _FINDER_COLUMN_PARENT_LANGUAGE_LANGUAGE_3 = "(vcmsCategory.language IS NULL OR vcmsCategory.language = ?)";
	private static final String _FINDER_COLUMN_LANGUAGE_GROUPID_2 = "vcmsCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_1 = "vcmsCategory.language IS NULL";
	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_2 = "vcmsCategory.language = ?";
	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_3 = "(vcmsCategory.language IS NULL OR vcmsCategory.language = ?)";
	private static final String _FINDER_COLUMN_P_P_L_GROUPID_2 = "vcmsCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_P_P_L_PORTIONID_1 = "vcmsCategory.portionId IS NULL AND ";
	private static final String _FINDER_COLUMN_P_P_L_PORTIONID_2 = "vcmsCategory.portionId = ? AND ";
	private static final String _FINDER_COLUMN_P_P_L_PORTIONID_3 = "(vcmsCategory.portionId IS NULL OR vcmsCategory.portionId = ?) AND ";
	private static final String _FINDER_COLUMN_P_P_L_PARENTID_1 = "vcmsCategory.parentId IS NULL AND ";
	private static final String _FINDER_COLUMN_P_P_L_PARENTID_2 = "vcmsCategory.parentId = ? AND ";
	private static final String _FINDER_COLUMN_P_P_L_PARENTID_3 = "(vcmsCategory.parentId IS NULL OR vcmsCategory.parentId = ?) AND ";
	private static final String _FINDER_COLUMN_P_P_L_LANGUAGE_1 = "vcmsCategory.language IS NULL";
	private static final String _FINDER_COLUMN_P_P_L_LANGUAGE_2 = "vcmsCategory.language = ?";
	private static final String _FINDER_COLUMN_P_P_L_LANGUAGE_3 = "(vcmsCategory.language IS NULL OR vcmsCategory.language = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsCategoryPersistenceImpl.class);
	private static VcmsCategory _nullVcmsCategory = new VcmsCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsCategory> toCacheModel() {
				return _nullVcmsCategoryCacheModel;
			}
		};

	private static CacheModel<VcmsCategory> _nullVcmsCategoryCacheModel = new CacheModel<VcmsCategory>() {
			public VcmsCategory toEntityModel() {
				return _nullVcmsCategory;
			}
		};
}