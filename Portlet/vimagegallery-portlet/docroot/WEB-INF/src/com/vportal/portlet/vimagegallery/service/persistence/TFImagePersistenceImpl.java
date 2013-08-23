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

package com.vportal.portlet.vimagegallery.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.vportal.portlet.vimagegallery.NoSuchTFImageException;
import com.vportal.portlet.vimagegallery.model.TFImage;
import com.vportal.portlet.vimagegallery.model.impl.TFImageImpl;
import com.vportal.portlet.vimagegallery.model.impl.TFImageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the t f image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucNN
 * @see TFImagePersistence
 * @see TFImageUtil
 * @generated
 */
public class TFImagePersistenceImpl extends BasePersistenceImpl<TFImage>
	implements TFImagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TFImageUtil} to access the t f image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TFImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			TFImageModelImpl.GROUPID_COLUMN_BITMASK |
			TFImageModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_I = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_I",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_I = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_I",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			TFImageModelImpl.GROUPID_COLUMN_BITMASK |
			TFImageModelImpl.CATEGORYID_COLUMN_BITMASK |
			TFImageModelImpl.ISSHOW_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_I = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_I",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			TFImageModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_I = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_I",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_I = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_I",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			TFImageModelImpl.GROUPID_COLUMN_BITMASK |
			TFImageModelImpl.ISSHOW_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_I = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_I",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			TFImageModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, TFImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the t f image in the entity cache if it is enabled.
	 *
	 * @param tfImage the t f image
	 */
	public void cacheResult(TFImage tfImage) {
		EntityCacheUtil.putResult(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageImpl.class, tfImage.getPrimaryKey(), tfImage);

		tfImage.resetOriginalValues();
	}

	/**
	 * Caches the t f images in the entity cache if it is enabled.
	 *
	 * @param tfImages the t f images
	 */
	public void cacheResult(List<TFImage> tfImages) {
		for (TFImage tfImage : tfImages) {
			if (EntityCacheUtil.getResult(
						TFImageModelImpl.ENTITY_CACHE_ENABLED,
						TFImageImpl.class, tfImage.getPrimaryKey()) == null) {
				cacheResult(tfImage);
			}
			else {
				tfImage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all t f images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TFImageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TFImageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the t f image.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TFImage tfImage) {
		EntityCacheUtil.removeResult(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageImpl.class, tfImage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TFImage> tfImages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TFImage tfImage : tfImages) {
			EntityCacheUtil.removeResult(TFImageModelImpl.ENTITY_CACHE_ENABLED,
				TFImageImpl.class, tfImage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new t f image with the primary key. Does not add the t f image to the database.
	 *
	 * @param id the primary key for the new t f image
	 * @return the new t f image
	 */
	public TFImage create(long id) {
		TFImage tfImage = new TFImageImpl();

		tfImage.setNew(true);
		tfImage.setPrimaryKey(id);

		return tfImage;
	}

	/**
	 * Removes the t f image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the t f image
	 * @return the t f image that was removed
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage remove(long id)
		throws NoSuchTFImageException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the t f image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the t f image
	 * @return the t f image that was removed
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TFImage remove(Serializable primaryKey)
		throws NoSuchTFImageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TFImage tfImage = (TFImage)session.get(TFImageImpl.class, primaryKey);

			if (tfImage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTFImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tfImage);
		}
		catch (NoSuchTFImageException nsee) {
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
	protected TFImage removeImpl(TFImage tfImage) throws SystemException {
		tfImage = toUnwrappedModel(tfImage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tfImage);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tfImage);

		return tfImage;
	}

	@Override
	public TFImage updateImpl(
		com.vportal.portlet.vimagegallery.model.TFImage tfImage, boolean merge)
		throws SystemException {
		tfImage = toUnwrappedModel(tfImage);

		boolean isNew = tfImage.isNew();

		TFImageModelImpl tfImageModelImpl = (TFImageModelImpl)tfImage;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tfImage, merge);

			tfImage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TFImageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tfImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tfImageModelImpl.getOriginalGroupId()),
						Long.valueOf(tfImageModelImpl.getOriginalCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
					args);

				args = new Object[] {
						Long.valueOf(tfImageModelImpl.getGroupId()),
						Long.valueOf(tfImageModelImpl.getCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C,
					args);
			}

			if ((tfImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_I.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tfImageModelImpl.getOriginalGroupId()),
						Long.valueOf(tfImageModelImpl.getOriginalCategoryId()),
						Boolean.valueOf(tfImageModelImpl.getOriginalIsShow())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_I, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_I,
					args);

				args = new Object[] {
						Long.valueOf(tfImageModelImpl.getGroupId()),
						Long.valueOf(tfImageModelImpl.getCategoryId()),
						Boolean.valueOf(tfImageModelImpl.getIsShow())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_I, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_I,
					args);
			}

			if ((tfImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tfImageModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { Long.valueOf(tfImageModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((tfImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_I.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tfImageModelImpl.getOriginalGroupId()),
						Boolean.valueOf(tfImageModelImpl.getOriginalIsShow())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_I, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_I,
					args);

				args = new Object[] {
						Long.valueOf(tfImageModelImpl.getGroupId()),
						Boolean.valueOf(tfImageModelImpl.getIsShow())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_I, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_I,
					args);
			}

			if ((tfImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tfImageModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(tfImageModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(TFImageModelImpl.ENTITY_CACHE_ENABLED,
			TFImageImpl.class, tfImage.getPrimaryKey(), tfImage);

		return tfImage;
	}

	protected TFImage toUnwrappedModel(TFImage tfImage) {
		if (tfImage instanceof TFImageImpl) {
			return tfImage;
		}

		TFImageImpl tfImageImpl = new TFImageImpl();

		tfImageImpl.setNew(tfImage.isNew());
		tfImageImpl.setPrimaryKey(tfImage.getPrimaryKey());

		tfImageImpl.setId(tfImage.getId());
		tfImageImpl.setGroupId(tfImage.getGroupId());
		tfImageImpl.setCompanyId(tfImage.getCompanyId());
		tfImageImpl.setUserId(tfImage.getUserId());
		tfImageImpl.setCreateDate(tfImage.getCreateDate());
		tfImageImpl.setModifiedDate(tfImage.getModifiedDate());
		tfImageImpl.setCategoryId(tfImage.getCategoryId());
		tfImageImpl.setName(tfImage.getName());
		tfImageImpl.setDescription(tfImage.getDescription());
		tfImageImpl.setImage(tfImage.getImage());
		tfImageImpl.setIsShow(tfImage.isIsShow());

		return tfImageImpl;
	}

	/**
	 * Returns the t f image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the t f image
	 * @return the t f image
	 * @throws com.liferay.portal.NoSuchModelException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TFImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t f image with the primary key or throws a {@link com.vportal.portlet.vimagegallery.NoSuchTFImageException} if it could not be found.
	 *
	 * @param id the primary key of the t f image
	 * @return the t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage findByPrimaryKey(long id)
		throws NoSuchTFImageException, SystemException {
		TFImage tfImage = fetchByPrimaryKey(id);

		if (tfImage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTFImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return tfImage;
	}

	/**
	 * Returns the t f image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the t f image
	 * @return the t f image, or <code>null</code> if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TFImage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the t f image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the t f image
	 * @return the t f image, or <code>null</code> if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage fetchByPrimaryKey(long id) throws SystemException {
		TFImage tfImage = (TFImage)EntityCacheUtil.getResult(TFImageModelImpl.ENTITY_CACHE_ENABLED,
				TFImageImpl.class, id);

		if (tfImage == _nullTFImage) {
			return null;
		}

		if (tfImage == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tfImage = (TFImage)session.get(TFImageImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tfImage != null) {
					cacheResult(tfImage);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TFImageModelImpl.ENTITY_CACHE_ENABLED,
						TFImageImpl.class, id, _nullTFImage);
				}

				closeSession(session);
			}
		}

		return tfImage;
	}

	/**
	 * Returns all the t f images where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByG_C(long groupId, long categoryId)
		throws SystemException {
		return findByG_C(groupId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t f images where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @return the range of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByG_C(long groupId, long categoryId, int start,
		int end) throws SystemException {
		return findByG_C(groupId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t f images where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByG_C(long groupId, long categoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C;
			finderArgs = new Object[] { groupId, categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C;
			finderArgs = new Object[] {
					groupId, categoryId,
					
					start, end, orderByComparator
				};
		}

		List<TFImage> list = (List<TFImage>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TFIMAGE_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				list = (List<TFImage>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first t f image in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage findByG_C_First(long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		List<TFImage> list = findByG_C(groupId, categoryId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTFImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t f image in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage findByG_C_Last(long groupId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		int count = countByG_C(groupId, categoryId);

		List<TFImage> list = findByG_C(groupId, categoryId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTFImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t f images before and after the current t f image in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t f image
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage[] findByG_C_PrevAndNext(long id, long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		TFImage tfImage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TFImage[] array = new TFImageImpl[3];

			array[0] = getByG_C_PrevAndNext(session, tfImage, groupId,
					categoryId, orderByComparator, true);

			array[1] = tfImage;

			array[2] = getByG_C_PrevAndNext(session, tfImage, groupId,
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

	protected TFImage getByG_C_PrevAndNext(Session session, TFImage tfImage,
		long groupId, long categoryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TFIMAGE_WHERE);

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

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
			query.append(TFImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tfImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TFImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t f images that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByG_C(long groupId, long categoryId)
		throws SystemException {
		return filterFindByG_C(groupId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t f images that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @return the range of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByG_C(long groupId, long categoryId,
		int start, int end) throws SystemException {
		return filterFindByG_C(groupId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t f images that the user has permissions to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByG_C(long groupId, long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C(groupId, categoryId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TFImageModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TFImageImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TFImageImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			return (List<TFImage>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t f images before and after the current t f image in the ordered set of t f images that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param id the primary key of the current t f image
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage[] filterFindByG_C_PrevAndNext(long id, long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_PrevAndNext(id, groupId, categoryId,
				orderByComparator);
		}

		TFImage tfImage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TFImage[] array = new TFImageImpl[3];

			array[0] = filterGetByG_C_PrevAndNext(session, tfImage, groupId,
					categoryId, orderByComparator, true);

			array[1] = tfImage;

			array[2] = filterGetByG_C_PrevAndNext(session, tfImage, groupId,
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

	protected TFImage filterGetByG_C_PrevAndNext(Session session,
		TFImage tfImage, long groupId, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TFImageModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TFImageImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TFImageImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tfImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TFImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @return the matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByG_C_I(long groupId, long categoryId,
		boolean isShow) throws SystemException {
		return findByG_C_I(groupId, categoryId, isShow, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @return the range of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByG_C_I(long groupId, long categoryId,
		boolean isShow, int start, int end) throws SystemException {
		return findByG_C_I(groupId, categoryId, isShow, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByG_C_I(long groupId, long categoryId,
		boolean isShow, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_I;
			finderArgs = new Object[] { groupId, categoryId, isShow };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_I;
			finderArgs = new Object[] {
					groupId, categoryId, isShow,
					
					start, end, orderByComparator
				};
		}

		List<TFImage> list = (List<TFImage>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TFIMAGE_WHERE);

			query.append(_FINDER_COLUMN_G_C_I_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_I_CATEGORYID_2);

			query.append(_FINDER_COLUMN_G_C_I_ISSHOW_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				qPos.add(isShow);

				list = (List<TFImage>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first t f image in the ordered set where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage findByG_C_I_First(long groupId, long categoryId,
		boolean isShow, OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		List<TFImage> list = findByG_C_I(groupId, categoryId, isShow, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", categoryId=");
			msg.append(categoryId);

			msg.append(", isShow=");
			msg.append(isShow);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTFImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t f image in the ordered set where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage findByG_C_I_Last(long groupId, long categoryId,
		boolean isShow, OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		int count = countByG_C_I(groupId, categoryId, isShow);

		List<TFImage> list = findByG_C_I(groupId, categoryId, isShow,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", categoryId=");
			msg.append(categoryId);

			msg.append(", isShow=");
			msg.append(isShow);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTFImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t f images before and after the current t f image in the ordered set where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t f image
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage[] findByG_C_I_PrevAndNext(long id, long groupId,
		long categoryId, boolean isShow, OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		TFImage tfImage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TFImage[] array = new TFImageImpl[3];

			array[0] = getByG_C_I_PrevAndNext(session, tfImage, groupId,
					categoryId, isShow, orderByComparator, true);

			array[1] = tfImage;

			array[2] = getByG_C_I_PrevAndNext(session, tfImage, groupId,
					categoryId, isShow, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TFImage getByG_C_I_PrevAndNext(Session session, TFImage tfImage,
		long groupId, long categoryId, boolean isShow,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TFIMAGE_WHERE);

		query.append(_FINDER_COLUMN_G_C_I_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_I_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_C_I_ISSHOW_2);

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
			query.append(TFImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		qPos.add(isShow);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tfImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TFImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t f images that the user has permission to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @return the matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByG_C_I(long groupId, long categoryId,
		boolean isShow) throws SystemException {
		return filterFindByG_C_I(groupId, categoryId, isShow,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t f images that the user has permission to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @return the range of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByG_C_I(long groupId, long categoryId,
		boolean isShow, int start, int end) throws SystemException {
		return filterFindByG_C_I(groupId, categoryId, isShow, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t f images that the user has permissions to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByG_C_I(long groupId, long categoryId,
		boolean isShow, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_I(groupId, categoryId, isShow, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_I_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_I_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_C_I_ISSHOW_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TFImageModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TFImageImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TFImageImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			qPos.add(isShow);

			return (List<TFImage>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t f images before and after the current t f image in the ordered set of t f images that the user has permission to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * @param id the primary key of the current t f image
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage[] filterFindByG_C_I_PrevAndNext(long id, long groupId,
		long categoryId, boolean isShow, OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_I_PrevAndNext(id, groupId, categoryId, isShow,
				orderByComparator);
		}

		TFImage tfImage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TFImage[] array = new TFImageImpl[3];

			array[0] = filterGetByG_C_I_PrevAndNext(session, tfImage, groupId,
					categoryId, isShow, orderByComparator, true);

			array[1] = tfImage;

			array[2] = filterGetByG_C_I_PrevAndNext(session, tfImage, groupId,
					categoryId, isShow, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TFImage filterGetByG_C_I_PrevAndNext(Session session,
		TFImage tfImage, long groupId, long categoryId, boolean isShow,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_I_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_I_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_C_I_ISSHOW_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TFImageModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TFImageImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TFImageImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		qPos.add(isShow);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tfImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TFImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t f images where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t f images where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @return the range of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t f images where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByGroupId(long groupId, int start, int end,
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

		List<TFImage> list = (List<TFImage>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TFIMAGE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<TFImage>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first t f image in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		List<TFImage> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTFImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t f image in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		int count = countByGroupId(groupId);

		List<TFImage> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTFImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t f images before and after the current t f image in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t f image
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage[] findByGroupId_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		TFImage tfImage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TFImage[] array = new TFImageImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, tfImage, groupId,
					orderByComparator, true);

			array[1] = tfImage;

			array[2] = getByGroupId_PrevAndNext(session, tfImage, groupId,
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

	protected TFImage getByGroupId_PrevAndNext(Session session,
		TFImage tfImage, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TFIMAGE_WHERE);

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
			query.append(TFImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tfImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TFImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t f images that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t f images that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @return the range of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t f images that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TFImageModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TFImageImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TFImageImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<TFImage>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t f images before and after the current t f image in the ordered set of t f images that the user has permission to view where groupId = &#63;.
	 *
	 * @param id the primary key of the current t f image
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage[] filterFindByGroupId_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(id, groupId, orderByComparator);
		}

		TFImage tfImage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TFImage[] array = new TFImageImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, tfImage,
					groupId, orderByComparator, true);

			array[1] = tfImage;

			array[2] = filterGetByGroupId_PrevAndNext(session, tfImage,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TFImage filterGetByGroupId_PrevAndNext(Session session,
		TFImage tfImage, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TFImageModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TFImageImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TFImageImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tfImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TFImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t f images where groupId = &#63; and isShow = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @return the matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByG_I(long groupId, boolean isShow)
		throws SystemException {
		return findByG_I(groupId, isShow, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the t f images where groupId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @return the range of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByG_I(long groupId, boolean isShow, int start,
		int end) throws SystemException {
		return findByG_I(groupId, isShow, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t f images where groupId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByG_I(long groupId, boolean isShow, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_I;
			finderArgs = new Object[] { groupId, isShow };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_I;
			finderArgs = new Object[] {
					groupId, isShow,
					
					start, end, orderByComparator
				};
		}

		List<TFImage> list = (List<TFImage>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TFIMAGE_WHERE);

			query.append(_FINDER_COLUMN_G_I_GROUPID_2);

			query.append(_FINDER_COLUMN_G_I_ISSHOW_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isShow);

				list = (List<TFImage>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first t f image in the ordered set where groupId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage findByG_I_First(long groupId, boolean isShow,
		OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		List<TFImage> list = findByG_I(groupId, isShow, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", isShow=");
			msg.append(isShow);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTFImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t f image in the ordered set where groupId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage findByG_I_Last(long groupId, boolean isShow,
		OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		int count = countByG_I(groupId, isShow);

		List<TFImage> list = findByG_I(groupId, isShow, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", isShow=");
			msg.append(isShow);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTFImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t f images before and after the current t f image in the ordered set where groupId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t f image
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage[] findByG_I_PrevAndNext(long id, long groupId,
		boolean isShow, OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		TFImage tfImage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TFImage[] array = new TFImageImpl[3];

			array[0] = getByG_I_PrevAndNext(session, tfImage, groupId, isShow,
					orderByComparator, true);

			array[1] = tfImage;

			array[2] = getByG_I_PrevAndNext(session, tfImage, groupId, isShow,
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

	protected TFImage getByG_I_PrevAndNext(Session session, TFImage tfImage,
		long groupId, boolean isShow, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TFIMAGE_WHERE);

		query.append(_FINDER_COLUMN_G_I_GROUPID_2);

		query.append(_FINDER_COLUMN_G_I_ISSHOW_2);

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
			query.append(TFImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(isShow);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tfImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TFImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t f images that the user has permission to view where groupId = &#63; and isShow = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @return the matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByG_I(long groupId, boolean isShow)
		throws SystemException {
		return filterFindByG_I(groupId, isShow, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t f images that the user has permission to view where groupId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @return the range of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByG_I(long groupId, boolean isShow,
		int start, int end) throws SystemException {
		return filterFindByG_I(groupId, isShow, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t f images that the user has permissions to view where groupId = &#63; and isShow = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> filterFindByG_I(long groupId, boolean isShow,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_I(groupId, isShow, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_I_GROUPID_2);

		query.append(_FINDER_COLUMN_G_I_ISSHOW_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TFImageModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TFImageImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TFImageImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(isShow);

			return (List<TFImage>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the t f images before and after the current t f image in the ordered set of t f images that the user has permission to view where groupId = &#63; and isShow = &#63;.
	 *
	 * @param id the primary key of the current t f image
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage[] filterFindByG_I_PrevAndNext(long id, long groupId,
		boolean isShow, OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_I_PrevAndNext(id, groupId, isShow, orderByComparator);
		}

		TFImage tfImage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TFImage[] array = new TFImageImpl[3];

			array[0] = filterGetByG_I_PrevAndNext(session, tfImage, groupId,
					isShow, orderByComparator, true);

			array[1] = tfImage;

			array[2] = filterGetByG_I_PrevAndNext(session, tfImage, groupId,
					isShow, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TFImage filterGetByG_I_PrevAndNext(Session session,
		TFImage tfImage, long groupId, boolean isShow,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_I_GROUPID_2);

		query.append(_FINDER_COLUMN_G_I_ISSHOW_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TFImageModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TFImageImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TFImageImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(isShow);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tfImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TFImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t f images where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the t f images where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @return the range of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t f images where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<TFImage> list = (List<TFImage>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TFIMAGE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TFImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<TFImage>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first t f image in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		List<TFImage> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTFImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last t f image in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a matching t f image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		int count = countByCompanyId(companyId);

		List<TFImage> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTFImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the t f images before and after the current t f image in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current t f image
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t f image
	 * @throws com.vportal.portlet.vimagegallery.NoSuchTFImageException if a t f image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TFImage[] findByCompanyId_PrevAndNext(long id, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTFImageException, SystemException {
		TFImage tfImage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TFImage[] array = new TFImageImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, tfImage, companyId,
					orderByComparator, true);

			array[1] = tfImage;

			array[2] = getByCompanyId_PrevAndNext(session, tfImage, companyId,
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

	protected TFImage getByCompanyId_PrevAndNext(Session session,
		TFImage tfImage, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TFIMAGE_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(TFImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tfImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TFImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the t f images.
	 *
	 * @return the t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t f images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @return the range of t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the t f images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of t f images
	 * @param end the upper bound of the range of t f images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of t f images
	 * @throws SystemException if a system exception occurred
	 */
	public List<TFImage> findAll(int start, int end,
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

		List<TFImage> list = (List<TFImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TFIMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TFIMAGE.concat(TFImageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TFImage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TFImage>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the t f images where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_C(long groupId, long categoryId)
		throws SystemException {
		for (TFImage tfImage : findByG_C(groupId, categoryId)) {
			remove(tfImage);
		}
	}

	/**
	 * Removes all the t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_C_I(long groupId, long categoryId, boolean isShow)
		throws SystemException {
		for (TFImage tfImage : findByG_C_I(groupId, categoryId, isShow)) {
			remove(tfImage);
		}
	}

	/**
	 * Removes all the t f images where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (TFImage tfImage : findByGroupId(groupId)) {
			remove(tfImage);
		}
	}

	/**
	 * Removes all the t f images where groupId = &#63; and isShow = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_I(long groupId, boolean isShow)
		throws SystemException {
		for (TFImage tfImage : findByG_I(groupId, isShow)) {
			remove(tfImage);
		}
	}

	/**
	 * Removes all the t f images where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (TFImage tfImage : findByCompanyId(companyId)) {
			remove(tfImage);
		}
	}

	/**
	 * Removes all the t f images from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TFImage tfImage : findAll()) {
			remove(tfImage);
		}
	}

	/**
	 * Returns the number of t f images where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_C(long groupId, long categoryId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_C,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TFIMAGE_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

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
	 * Returns the number of t f images that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_C(long groupId, long categoryId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C(groupId, categoryId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TFIMAGE_WHERE);

		query.append(_FINDER_COLUMN_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_CATEGORYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of t f images where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @return the number of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_C_I(long groupId, long categoryId, boolean isShow)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, categoryId, isShow };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_C_I,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TFIMAGE_WHERE);

			query.append(_FINDER_COLUMN_G_C_I_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_I_CATEGORYID_2);

			query.append(_FINDER_COLUMN_G_C_I_ISSHOW_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				qPos.add(isShow);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C_I,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t f images that the user has permission to view where groupId = &#63; and categoryId = &#63; and isShow = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param isShow the is show
	 * @return the number of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_C_I(long groupId, long categoryId, boolean isShow)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C_I(groupId, categoryId, isShow);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_TFIMAGE_WHERE);

		query.append(_FINDER_COLUMN_G_C_I_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_I_CATEGORYID_2);

		query.append(_FINDER_COLUMN_G_C_I_ISSHOW_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(categoryId);

			qPos.add(isShow);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of t f images where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TFIMAGE_WHERE);

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
	 * Returns the number of t f images that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TFIMAGE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of t f images where groupId = &#63; and isShow = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @return the number of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_I(long groupId, boolean isShow)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, isShow };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_I,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TFIMAGE_WHERE);

			query.append(_FINDER_COLUMN_G_I_GROUPID_2);

			query.append(_FINDER_COLUMN_G_I_ISSHOW_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isShow);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_I, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t f images that the user has permission to view where groupId = &#63; and isShow = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isShow the is show
	 * @return the number of matching t f images that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_I(long groupId, boolean isShow)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_I(groupId, isShow);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TFIMAGE_WHERE);

		query.append(_FINDER_COLUMN_G_I_GROUPID_2);

		query.append(_FINDER_COLUMN_G_I_ISSHOW_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TFImage.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(isShow);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of t f images where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching t f images
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TFIMAGE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of t f images.
	 *
	 * @return the number of t f images
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TFIMAGE);

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
	 * Initializes the t f image persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vimagegallery.model.TFImage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TFImage>> listenersList = new ArrayList<ModelListener<TFImage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TFImage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TFImageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = TFCategoryPersistence.class)
	protected TFCategoryPersistence tfCategoryPersistence;
	@BeanReference(type = TFImagePersistence.class)
	protected TFImagePersistence tfImagePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TFIMAGE = "SELECT tfImage FROM TFImage tfImage";
	private static final String _SQL_SELECT_TFIMAGE_WHERE = "SELECT tfImage FROM TFImage tfImage WHERE ";
	private static final String _SQL_COUNT_TFIMAGE = "SELECT COUNT(tfImage) FROM TFImage tfImage";
	private static final String _SQL_COUNT_TFIMAGE_WHERE = "SELECT COUNT(tfImage) FROM TFImage tfImage WHERE ";
	private static final String _FINDER_COLUMN_G_C_GROUPID_2 = "tfImage.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_CATEGORYID_2 = "tfImage.categoryId = ?";
	private static final String _FINDER_COLUMN_G_C_I_GROUPID_2 = "tfImage.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_I_CATEGORYID_2 = "tfImage.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_I_ISSHOW_2 = "tfImage.isShow = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "tfImage.groupId = ?";
	private static final String _FINDER_COLUMN_G_I_GROUPID_2 = "tfImage.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_I_ISSHOW_2 = "tfImage.isShow = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "tfImage.companyId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "tfImage.id_";
	private static final String _FILTER_SQL_SELECT_TFIMAGE_WHERE = "SELECT DISTINCT {tfImage.*} FROM TFImage tfImage WHERE ";
	private static final String _FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {TFImage.*} FROM (SELECT DISTINCT tfImage.id_ FROM TFImage tfImage WHERE ";
	private static final String _FILTER_SQL_SELECT_TFIMAGE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN TFImage ON TEMP_TABLE.id_ = TFImage.id_";
	private static final String _FILTER_SQL_COUNT_TFIMAGE_WHERE = "SELECT COUNT(DISTINCT tfImage.id_) AS COUNT_VALUE FROM TFImage tfImage WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "tfImage";
	private static final String _FILTER_ENTITY_TABLE = "TFImage";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tfImage.";
	private static final String _ORDER_BY_ENTITY_TABLE = "TFImage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TFImage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TFImage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TFImagePersistenceImpl.class);
	private static TFImage _nullTFImage = new TFImageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TFImage> toCacheModel() {
				return _nullTFImageCacheModel;
			}
		};

	private static CacheModel<TFImage> _nullTFImageCacheModel = new CacheModel<TFImage>() {
			public TFImage toEntityModel() {
				return _nullTFImage;
			}
		};
}