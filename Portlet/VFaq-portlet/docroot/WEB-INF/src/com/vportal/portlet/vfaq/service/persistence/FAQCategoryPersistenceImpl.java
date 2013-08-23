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

package com.vportal.portlet.vfaq.service.persistence;

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

import com.vportal.portlet.vfaq.NoSuchFAQCategoryException;
import com.vportal.portlet.vfaq.model.FAQCategory;
import com.vportal.portlet.vfaq.model.impl.FAQCategoryImpl;
import com.vportal.portlet.vfaq.model.impl.FAQCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the f a q category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucNN
 * @see FAQCategoryPersistence
 * @see FAQCategoryUtil
 * @generated
 */
public class FAQCategoryPersistenceImpl extends BasePersistenceImpl<FAQCategory>
	implements FAQCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FAQCategoryUtil} to access the f a q category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FAQCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			FAQCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_G_C = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			FAQCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			FAQCategoryModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			FAQCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			FAQCategoryModelImpl.PARENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_P",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
		new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] { Long.class.getName() },
			FAQCategoryModelImpl.PARENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] { Long.class.getName(), String.class.getName() },
			FAQCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			FAQCategoryModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_P = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			FAQCategoryModelImpl.GROUPID_COLUMN_BITMASK |
			FAQCategoryModelImpl.LANGUAGE_COLUMN_BITMASK |
			FAQCategoryModelImpl.PARENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L_P = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, FAQCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the f a q category in the entity cache if it is enabled.
	 *
	 * @param faqCategory the f a q category
	 */
	public void cacheResult(FAQCategory faqCategory) {
		EntityCacheUtil.putResult(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryImpl.class, faqCategory.getPrimaryKey(), faqCategory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C,
			new Object[] {
				Long.valueOf(faqCategory.getGroupId()),
				Long.valueOf(faqCategory.getId())
			}, faqCategory);

		faqCategory.resetOriginalValues();
	}

	/**
	 * Caches the f a q categories in the entity cache if it is enabled.
	 *
	 * @param faqCategories the f a q categories
	 */
	public void cacheResult(List<FAQCategory> faqCategories) {
		for (FAQCategory faqCategory : faqCategories) {
			if (EntityCacheUtil.getResult(
						FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
						FAQCategoryImpl.class, faqCategory.getPrimaryKey()) == null) {
				cacheResult(faqCategory);
			}
			else {
				faqCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all f a q categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FAQCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FAQCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the f a q category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FAQCategory faqCategory) {
		EntityCacheUtil.removeResult(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryImpl.class, faqCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(faqCategory);
	}

	@Override
	public void clearCache(List<FAQCategory> faqCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FAQCategory faqCategory : faqCategories) {
			EntityCacheUtil.removeResult(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
				FAQCategoryImpl.class, faqCategory.getPrimaryKey());

			clearUniqueFindersCache(faqCategory);
		}
	}

	protected void clearUniqueFindersCache(FAQCategory faqCategory) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C,
			new Object[] {
				Long.valueOf(faqCategory.getGroupId()),
				Long.valueOf(faqCategory.getId())
			});
	}

	/**
	 * Creates a new f a q category with the primary key. Does not add the f a q category to the database.
	 *
	 * @param id the primary key for the new f a q category
	 * @return the new f a q category
	 */
	public FAQCategory create(long id) {
		FAQCategory faqCategory = new FAQCategoryImpl();

		faqCategory.setNew(true);
		faqCategory.setPrimaryKey(id);

		return faqCategory;
	}

	/**
	 * Removes the f a q category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the f a q category
	 * @return the f a q category that was removed
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory remove(long id)
		throws NoSuchFAQCategoryException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the f a q category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the f a q category
	 * @return the f a q category that was removed
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQCategory remove(Serializable primaryKey)
		throws NoSuchFAQCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FAQCategory faqCategory = (FAQCategory)session.get(FAQCategoryImpl.class,
					primaryKey);

			if (faqCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFAQCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(faqCategory);
		}
		catch (NoSuchFAQCategoryException nsee) {
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
	protected FAQCategory removeImpl(FAQCategory faqCategory)
		throws SystemException {
		faqCategory = toUnwrappedModel(faqCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, faqCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(faqCategory);

		return faqCategory;
	}

	@Override
	public FAQCategory updateImpl(
		com.vportal.portlet.vfaq.model.FAQCategory faqCategory, boolean merge)
		throws SystemException {
		faqCategory = toUnwrappedModel(faqCategory);

		boolean isNew = faqCategory.isNew();

		FAQCategoryModelImpl faqCategoryModelImpl = (FAQCategoryModelImpl)faqCategory;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, faqCategory, merge);

			faqCategory.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FAQCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((faqCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqCategoryModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(faqCategoryModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((faqCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqCategoryModelImpl.getOriginalGroupId()),
						Long.valueOf(faqCategoryModelImpl.getOriginalParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P,
					args);

				args = new Object[] {
						Long.valueOf(faqCategoryModelImpl.getGroupId()),
						Long.valueOf(faqCategoryModelImpl.getParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P,
					args);
			}

			if ((faqCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqCategoryModelImpl.getOriginalParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);

				args = new Object[] {
						Long.valueOf(faqCategoryModelImpl.getParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);
			}

			if ((faqCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqCategoryModelImpl.getOriginalGroupId()),
						
						faqCategoryModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);

				args = new Object[] {
						Long.valueOf(faqCategoryModelImpl.getGroupId()),
						
						faqCategoryModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);
			}

			if ((faqCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqCategoryModelImpl.getOriginalGroupId()),
						
						faqCategoryModelImpl.getOriginalLanguage(),
						Long.valueOf(faqCategoryModelImpl.getOriginalParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P,
					args);

				args = new Object[] {
						Long.valueOf(faqCategoryModelImpl.getGroupId()),
						
						faqCategoryModelImpl.getLanguage(),
						Long.valueOf(faqCategoryModelImpl.getParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P,
					args);
			}
		}

		EntityCacheUtil.putResult(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryImpl.class, faqCategory.getPrimaryKey(), faqCategory);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C,
				new Object[] {
					Long.valueOf(faqCategory.getGroupId()),
					Long.valueOf(faqCategory.getId())
				}, faqCategory);
		}
		else {
			if ((faqCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqCategoryModelImpl.getOriginalGroupId()),
						Long.valueOf(faqCategoryModelImpl.getOriginalId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C,
					new Object[] {
						Long.valueOf(faqCategory.getGroupId()),
						Long.valueOf(faqCategory.getId())
					}, faqCategory);
			}
		}

		return faqCategory;
	}

	protected FAQCategory toUnwrappedModel(FAQCategory faqCategory) {
		if (faqCategory instanceof FAQCategoryImpl) {
			return faqCategory;
		}

		FAQCategoryImpl faqCategoryImpl = new FAQCategoryImpl();

		faqCategoryImpl.setNew(faqCategory.isNew());
		faqCategoryImpl.setPrimaryKey(faqCategory.getPrimaryKey());

		faqCategoryImpl.setId(faqCategory.getId());
		faqCategoryImpl.setName(faqCategory.getName());
		faqCategoryImpl.setDescription(faqCategory.getDescription());
		faqCategoryImpl.setLanguage(faqCategory.getLanguage());
		faqCategoryImpl.setParent(faqCategory.getParent());
		faqCategoryImpl.setCatorder(faqCategory.getCatorder());
		faqCategoryImpl.setCatlevel(faqCategory.getCatlevel());
		faqCategoryImpl.setImage(faqCategory.getImage());
		faqCategoryImpl.setCreatedByUser(faqCategory.getCreatedByUser());
		faqCategoryImpl.setCreatedDate(faqCategory.getCreatedDate());
		faqCategoryImpl.setModifiedByUser(faqCategory.getModifiedByUser());
		faqCategoryImpl.setModifiedDate(faqCategory.getModifiedDate());
		faqCategoryImpl.setGroupId(faqCategory.getGroupId());
		faqCategoryImpl.setUserId(faqCategory.getUserId());

		return faqCategoryImpl;
	}

	/**
	 * Returns the f a q category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q category
	 * @return the f a q category
	 * @throws com.liferay.portal.NoSuchModelException if a f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the f a q category with the primary key or throws a {@link com.vportal.portlet.vfaq.NoSuchFAQCategoryException} if it could not be found.
	 *
	 * @param id the primary key of the f a q category
	 * @return the f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByPrimaryKey(long id)
		throws NoSuchFAQCategoryException, SystemException {
		FAQCategory faqCategory = fetchByPrimaryKey(id);

		if (faqCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchFAQCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return faqCategory;
	}

	/**
	 * Returns the f a q category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q category
	 * @return the f a q category, or <code>null</code> if a f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the f a q category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the f a q category
	 * @return the f a q category, or <code>null</code> if a f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory fetchByPrimaryKey(long id) throws SystemException {
		FAQCategory faqCategory = (FAQCategory)EntityCacheUtil.getResult(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
				FAQCategoryImpl.class, id);

		if (faqCategory == _nullFAQCategory) {
			return null;
		}

		if (faqCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				faqCategory = (FAQCategory)session.get(FAQCategoryImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (faqCategory != null) {
					cacheResult(faqCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FAQCategoryModelImpl.ENTITY_CACHE_ENABLED,
						FAQCategoryImpl.class, id, _nullFAQCategory);
				}

				closeSession(session);
			}
		}

		return faqCategory;
	}

	/**
	 * Returns all the f a q categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @return the range of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByGroupId(long groupId, int start, int end,
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

		List<FAQCategory> list = (List<FAQCategory>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<FAQCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first f a q category in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		List<FAQCategory> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q category in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		int count = countByGroupId(groupId);

		List<FAQCategory> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q categories before and after the current f a q category in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory[] findByGroupId_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		FAQCategory faqCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQCategory[] array = new FAQCategoryImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, faqCategory, groupId,
					orderByComparator, true);

			array[1] = faqCategory;

			array[2] = getByGroupId_PrevAndNext(session, faqCategory, groupId,
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

	protected FAQCategory getByGroupId_PrevAndNext(Session session,
		FAQCategory faqCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQCATEGORY_WHERE);

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
			query.append(FAQCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the f a q category where groupId = &#63; and id = &#63; or throws a {@link com.vportal.portlet.vfaq.NoSuchFAQCategoryException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param id the ID
	 * @return the matching f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByG_C(long groupId, long id)
		throws NoSuchFAQCategoryException, SystemException {
		FAQCategory faqCategory = fetchByG_C(groupId, id);

		if (faqCategory == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", id=");
			msg.append(id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFAQCategoryException(msg.toString());
		}

		return faqCategory;
	}

	/**
	 * Returns the f a q category where groupId = &#63; and id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param id the ID
	 * @return the matching f a q category, or <code>null</code> if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory fetchByG_C(long groupId, long id)
		throws SystemException {
		return fetchByG_C(groupId, id, true);
	}

	/**
	 * Returns the f a q category where groupId = &#63; and id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param id the ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching f a q category, or <code>null</code> if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory fetchByG_C(long groupId, long id,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, id };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_C,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_ID_2);

			query.append(FAQCategoryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(id);

				List<FAQCategory> list = q.list();

				result = list;

				FAQCategory faqCategory = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C,
						finderArgs, list);
				}
				else {
					faqCategory = list.get(0);

					cacheResult(faqCategory);

					if ((faqCategory.getGroupId() != groupId) ||
							(faqCategory.getId() != id)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C,
							finderArgs, faqCategory);
					}
				}

				return faqCategory;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C,
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
				return (FAQCategory)result;
			}
		}
	}

	/**
	 * Returns all the f a q categories where groupId = &#63; and parent = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parent the parent
	 * @return the matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByG_P(long groupId, long parent)
		throws SystemException {
		return findByG_P(groupId, parent, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the f a q categories where groupId = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parent the parent
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @return the range of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByG_P(long groupId, long parent, int start,
		int end) throws SystemException {
		return findByG_P(groupId, parent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q categories where groupId = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parent the parent
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByG_P(long groupId, long parent, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P;
			finderArgs = new Object[] { groupId, parent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P;
			finderArgs = new Object[] {
					groupId, parent,
					
					start, end, orderByComparator
				};
		}

		List<FAQCategory> list = (List<FAQCategory>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_PARENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parent);

				list = (List<FAQCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first f a q category in the ordered set where groupId = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByG_P_First(long groupId, long parent,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		List<FAQCategory> list = findByG_P(groupId, parent, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", parent=");
			msg.append(parent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q category in the ordered set where groupId = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByG_P_Last(long groupId, long parent,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		int count = countByG_P(groupId, parent);

		List<FAQCategory> list = findByG_P(groupId, parent, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", parent=");
			msg.append(parent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q categories before and after the current f a q category in the ordered set where groupId = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q category
	 * @param groupId the group ID
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory[] findByG_P_PrevAndNext(long id, long groupId,
		long parent, OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		FAQCategory faqCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQCategory[] array = new FAQCategoryImpl[3];

			array[0] = getByG_P_PrevAndNext(session, faqCategory, groupId,
					parent, orderByComparator, true);

			array[1] = faqCategory;

			array[2] = getByG_P_PrevAndNext(session, faqCategory, groupId,
					parent, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FAQCategory getByG_P_PrevAndNext(Session session,
		FAQCategory faqCategory, long groupId, long parent,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_PARENT_2);

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
			query.append(FAQCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q categories where parent = &#63;.
	 *
	 * @param parent the parent
	 * @return the matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByParentId(long parent)
		throws SystemException {
		return findByParentId(parent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q categories where parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @return the range of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByParentId(long parent, int start, int end)
		throws SystemException {
		return findByParentId(parent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q categories where parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByParentId(long parent, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parent, start, end, orderByComparator };
		}

		List<FAQCategory> list = (List<FAQCategory>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parent);

				list = (List<FAQCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first f a q category in the ordered set where parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByParentId_First(long parent,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		List<FAQCategory> list = findByParentId(parent, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parent=");
			msg.append(parent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q category in the ordered set where parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByParentId_Last(long parent,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		int count = countByParentId(parent);

		List<FAQCategory> list = findByParentId(parent, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parent=");
			msg.append(parent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q categories before and after the current f a q category in the ordered set where parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q category
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory[] findByParentId_PrevAndNext(long id, long parent,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		FAQCategory faqCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQCategory[] array = new FAQCategoryImpl[3];

			array[0] = getByParentId_PrevAndNext(session, faqCategory, parent,
					orderByComparator, true);

			array[1] = faqCategory;

			array[2] = getByParentId_PrevAndNext(session, faqCategory, parent,
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

	protected FAQCategory getByParentId_PrevAndNext(Session session,
		FAQCategory faqCategory, long parent,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PARENTID_PARENT_2);

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
			query.append(FAQCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q categories where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByG_L(long groupId, String language)
		throws SystemException {
		return findByG_L(groupId, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q categories where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @return the range of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByG_L(long groupId, String language,
		int start, int end) throws SystemException {
		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q categories where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByG_L(long groupId, String language,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L;
			finderArgs = new Object[] { groupId, language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L;
			finderArgs = new Object[] {
					groupId, language,
					
					start, end, orderByComparator
				};
		}

		List<FAQCategory> list = (List<FAQCategory>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<FAQCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first f a q category in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByG_L_First(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		List<FAQCategory> list = findByG_L(groupId, language, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q category in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByG_L_Last(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		int count = countByG_L(groupId, language);

		List<FAQCategory> list = findByG_L(groupId, language, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q categories before and after the current f a q category in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q category
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory[] findByG_L_PrevAndNext(long id, long groupId,
		String language, OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		FAQCategory faqCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQCategory[] array = new FAQCategoryImpl[3];

			array[0] = getByG_L_PrevAndNext(session, faqCategory, groupId,
					language, orderByComparator, true);

			array[1] = faqCategory;

			array[2] = getByG_L_PrevAndNext(session, faqCategory, groupId,
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

	protected FAQCategory getByG_L_PrevAndNext(Session session,
		FAQCategory faqCategory, long groupId, String language,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_G_L_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_G_L_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
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
			query.append(FAQCategoryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(faqCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q categories where groupId = &#63; and language = &#63; and parent = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parent the parent
	 * @return the matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByG_L_P(long groupId, String language,
		long parent) throws SystemException {
		return findByG_L_P(groupId, language, parent, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q categories where groupId = &#63; and language = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parent the parent
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @return the range of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByG_L_P(long groupId, String language,
		long parent, int start, int end) throws SystemException {
		return findByG_L_P(groupId, language, parent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q categories where groupId = &#63; and language = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parent the parent
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findByG_L_P(long groupId, String language,
		long parent, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P;
			finderArgs = new Object[] { groupId, language, parent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_P;
			finderArgs = new Object[] {
					groupId, language, parent,
					
					start, end, orderByComparator
				};
		}

		List<FAQCategory> list = (List<FAQCategory>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_L_P_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_G_L_P_PARENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQCategoryModelImpl.ORDER_BY_JPQL);
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

				qPos.add(parent);

				list = (List<FAQCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first f a q category in the ordered set where groupId = &#63; and language = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByG_L_P_First(long groupId, String language,
		long parent, OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		List<FAQCategory> list = findByG_L_P(groupId, language, parent, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", parent=");
			msg.append(parent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q category in the ordered set where groupId = &#63; and language = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a matching f a q category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory findByG_L_P_Last(long groupId, String language,
		long parent, OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		int count = countByG_L_P(groupId, language, parent);

		List<FAQCategory> list = findByG_L_P(groupId, language, parent,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", parent=");
			msg.append(parent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q categories before and after the current f a q category in the ordered set where groupId = &#63; and language = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q category
	 * @param groupId the group ID
	 * @param language the language
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q category
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryException if a f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategory[] findByG_L_P_PrevAndNext(long id, long groupId,
		String language, long parent, OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryException, SystemException {
		FAQCategory faqCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQCategory[] array = new FAQCategoryImpl[3];

			array[0] = getByG_L_P_PrevAndNext(session, faqCategory, groupId,
					language, parent, orderByComparator, true);

			array[1] = faqCategory;

			array[2] = getByG_L_P_PrevAndNext(session, faqCategory, groupId,
					language, parent, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FAQCategory getByG_L_P_PrevAndNext(Session session,
		FAQCategory faqCategory, long groupId, String language, long parent,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_G_L_P_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_2);
			}
		}

		query.append(_FINDER_COLUMN_G_L_P_PARENT_2);

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
			query.append(FAQCategoryModelImpl.ORDER_BY_JPQL);
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

		qPos.add(parent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q categories.
	 *
	 * @return the f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @return the range of f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q categories
	 * @param end the upper bound of the range of f a q categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategory> findAll(int start, int end,
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

		List<FAQCategory> list = (List<FAQCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FAQCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FAQCATEGORY.concat(FAQCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FAQCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FAQCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the f a q categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (FAQCategory faqCategory : findByGroupId(groupId)) {
			remove(faqCategory);
		}
	}

	/**
	 * Removes the f a q category where groupId = &#63; and id = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param id the ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_C(long groupId, long id)
		throws NoSuchFAQCategoryException, SystemException {
		FAQCategory faqCategory = findByG_C(groupId, id);

		remove(faqCategory);
	}

	/**
	 * Removes all the f a q categories where groupId = &#63; and parent = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parent the parent
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_P(long groupId, long parent)
		throws SystemException {
		for (FAQCategory faqCategory : findByG_P(groupId, parent)) {
			remove(faqCategory);
		}
	}

	/**
	 * Removes all the f a q categories where parent = &#63; from the database.
	 *
	 * @param parent the parent
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentId(long parent) throws SystemException {
		for (FAQCategory faqCategory : findByParentId(parent)) {
			remove(faqCategory);
		}
	}

	/**
	 * Removes all the f a q categories where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_L(long groupId, String language)
		throws SystemException {
		for (FAQCategory faqCategory : findByG_L(groupId, language)) {
			remove(faqCategory);
		}
	}

	/**
	 * Removes all the f a q categories where groupId = &#63; and language = &#63; and parent = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parent the parent
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_L_P(long groupId, String language, long parent)
		throws SystemException {
		for (FAQCategory faqCategory : findByG_L_P(groupId, language, parent)) {
			remove(faqCategory);
		}
	}

	/**
	 * Removes all the f a q categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FAQCategory faqCategory : findAll()) {
			remove(faqCategory);
		}
	}

	/**
	 * Returns the number of f a q categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQCATEGORY_WHERE);

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
	 * Returns the number of f a q categories where groupId = &#63; and id = &#63;.
	 *
	 * @param groupId the group ID
	 * @param id the ID
	 * @return the number of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_C(long groupId, long id) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, id };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_C,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(id);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q categories where groupId = &#63; and parent = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parent the parent
	 * @return the number of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_P(long groupId, long parent) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, parent };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_PARENT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parent);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_P, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q categories where parent = &#63;.
	 *
	 * @param parent the parent
	 * @return the number of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentId(long parent) throws SystemException {
		Object[] finderArgs = new Object[] { parent };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parent);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q categories where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_L(long groupId, String language)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_L, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q categories where groupId = &#63; and language = &#63; and parent = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parent the parent
	 * @return the number of matching f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_L_P(long groupId, String language, long parent)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language, parent };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FAQCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_G_L_P_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_G_L_P_PARENT_2);

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

				qPos.add(parent);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_L_P,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q categories.
	 *
	 * @return the number of f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FAQCATEGORY);

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
	 * Initializes the f a q category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vfaq.model.FAQCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FAQCategory>> listenersList = new ArrayList<ModelListener<FAQCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FAQCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FAQCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = FAQAnswerPersistence.class)
	protected FAQAnswerPersistence faqAnswerPersistence;
	@BeanReference(type = FAQCategoryPersistence.class)
	protected FAQCategoryPersistence faqCategoryPersistence;
	@BeanReference(type = FAQCategoryQuestionPersistence.class)
	protected FAQCategoryQuestionPersistence faqCategoryQuestionPersistence;
	@BeanReference(type = FAQCommentPersistence.class)
	protected FAQCommentPersistence faqCommentPersistence;
	@BeanReference(type = FAQQuestionPersistence.class)
	protected FAQQuestionPersistence faqQuestionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_FAQCATEGORY = "SELECT faqCategory FROM FAQCategory faqCategory";
	private static final String _SQL_SELECT_FAQCATEGORY_WHERE = "SELECT faqCategory FROM FAQCategory faqCategory WHERE ";
	private static final String _SQL_COUNT_FAQCATEGORY = "SELECT COUNT(faqCategory) FROM FAQCategory faqCategory";
	private static final String _SQL_COUNT_FAQCATEGORY_WHERE = "SELECT COUNT(faqCategory) FROM FAQCategory faqCategory WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "faqCategory.groupId = ?";
	private static final String _FINDER_COLUMN_G_C_GROUPID_2 = "faqCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_ID_2 = "faqCategory.id = ?";
	private static final String _FINDER_COLUMN_G_P_GROUPID_2 = "faqCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_PARENT_2 = "faqCategory.parent = ?";
	private static final String _FINDER_COLUMN_PARENTID_PARENT_2 = "faqCategory.parent = ?";
	private static final String _FINDER_COLUMN_G_L_GROUPID_2 = "faqCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_1 = "faqCategory.language IS NULL";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 = "faqCategory.language = ?";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 = "(faqCategory.language IS NULL OR faqCategory.language = ?)";
	private static final String _FINDER_COLUMN_G_L_P_GROUPID_2 = "faqCategory.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_1 = "faqCategory.language IS NULL AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_2 = "faqCategory.language = ? AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_3 = "(faqCategory.language IS NULL OR faqCategory.language = ?) AND ";
	private static final String _FINDER_COLUMN_G_L_P_PARENT_2 = "faqCategory.parent = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "faqCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FAQCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FAQCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FAQCategoryPersistenceImpl.class);
	private static FAQCategory _nullFAQCategory = new FAQCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FAQCategory> toCacheModel() {
				return _nullFAQCategoryCacheModel;
			}
		};

	private static CacheModel<FAQCategory> _nullFAQCategoryCacheModel = new CacheModel<FAQCategory>() {
			public FAQCategory toEntityModel() {
				return _nullFAQCategory;
			}
		};
}