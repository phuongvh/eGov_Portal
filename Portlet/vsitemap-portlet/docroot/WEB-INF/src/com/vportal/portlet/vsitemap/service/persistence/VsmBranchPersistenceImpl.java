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

package com.vportal.portlet.vsitemap.service.persistence;

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

import com.vportal.portlet.vsitemap.NoSuchVsmBranchException;
import com.vportal.portlet.vsitemap.model.VsmBranch;
import com.vportal.portlet.vsitemap.model.impl.VsmBranchImpl;
import com.vportal.portlet.vsitemap.model.impl.VsmBranchModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vsm branch service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LongLH
 * @see VsmBranchPersistence
 * @see VsmBranchUtil
 * @generated
 */
public class VsmBranchPersistenceImpl extends BasePersistenceImpl<VsmBranch>
	implements VsmBranchPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VsmBranchUtil} to access the vsm branch persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VsmBranchImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParent",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT =
		new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParent",
			new String[] { Long.class.getName() },
			VsmBranchModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENT = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParent",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] { Long.class.getName(), String.class.getName() },
			VsmBranchModelImpl.GROUPID_COLUMN_BITMASK |
			VsmBranchModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_P = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			VsmBranchModelImpl.GROUPID_COLUMN_BITMASK |
			VsmBranchModelImpl.LANGUAGE_COLUMN_BITMASK |
			VsmBranchModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L_P = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ICON = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIcon",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICON = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIcon",
			new String[] { Boolean.class.getName() },
			VsmBranchModelImpl.HASICON_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ICON = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIcon",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGE = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLanguage",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE =
		new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLanguage",
			new String[] { String.class.getName() },
			VsmBranchModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANGUAGE = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLanguage",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, VsmBranchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vsm branch in the entity cache if it is enabled.
	 *
	 * @param vsmBranch the vsm branch
	 */
	public void cacheResult(VsmBranch vsmBranch) {
		EntityCacheUtil.putResult(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchImpl.class, vsmBranch.getPrimaryKey(), vsmBranch);

		vsmBranch.resetOriginalValues();
	}

	/**
	 * Caches the vsm branchs in the entity cache if it is enabled.
	 *
	 * @param vsmBranchs the vsm branchs
	 */
	public void cacheResult(List<VsmBranch> vsmBranchs) {
		for (VsmBranch vsmBranch : vsmBranchs) {
			if (EntityCacheUtil.getResult(
						VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
						VsmBranchImpl.class, vsmBranch.getPrimaryKey()) == null) {
				cacheResult(vsmBranch);
			}
			else {
				vsmBranch.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vsm branchs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VsmBranchImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VsmBranchImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vsm branch.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VsmBranch vsmBranch) {
		EntityCacheUtil.removeResult(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchImpl.class, vsmBranch.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VsmBranch> vsmBranchs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VsmBranch vsmBranch : vsmBranchs) {
			EntityCacheUtil.removeResult(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
				VsmBranchImpl.class, vsmBranch.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vsm branch with the primary key. Does not add the vsm branch to the database.
	 *
	 * @param branchId the primary key for the new vsm branch
	 * @return the new vsm branch
	 */
	public VsmBranch create(long branchId) {
		VsmBranch vsmBranch = new VsmBranchImpl();

		vsmBranch.setNew(true);
		vsmBranch.setPrimaryKey(branchId);

		return vsmBranch;
	}

	/**
	 * Removes the vsm branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param branchId the primary key of the vsm branch
	 * @return the vsm branch that was removed
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch remove(long branchId)
		throws NoSuchVsmBranchException, SystemException {
		return remove(Long.valueOf(branchId));
	}

	/**
	 * Removes the vsm branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vsm branch
	 * @return the vsm branch that was removed
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VsmBranch remove(Serializable primaryKey)
		throws NoSuchVsmBranchException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VsmBranch vsmBranch = (VsmBranch)session.get(VsmBranchImpl.class,
					primaryKey);

			if (vsmBranch == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVsmBranchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vsmBranch);
		}
		catch (NoSuchVsmBranchException nsee) {
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
	protected VsmBranch removeImpl(VsmBranch vsmBranch)
		throws SystemException {
		vsmBranch = toUnwrappedModel(vsmBranch);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vsmBranch);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vsmBranch);

		return vsmBranch;
	}

	@Override
	public VsmBranch updateImpl(
		com.vportal.portlet.vsitemap.model.VsmBranch vsmBranch, boolean merge)
		throws SystemException {
		vsmBranch = toUnwrappedModel(vsmBranch);

		boolean isNew = vsmBranch.isNew();

		VsmBranchModelImpl vsmBranchModelImpl = (VsmBranchModelImpl)vsmBranch;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vsmBranch, merge);

			vsmBranch.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VsmBranchModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vsmBranchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vsmBranchModelImpl.getOriginalParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);

				args = new Object[] {
						Long.valueOf(vsmBranchModelImpl.getParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);
			}

			if ((vsmBranchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vsmBranchModelImpl.getOriginalGroupId()),
						
						vsmBranchModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);

				args = new Object[] {
						Long.valueOf(vsmBranchModelImpl.getGroupId()),
						
						vsmBranchModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);
			}

			if ((vsmBranchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vsmBranchModelImpl.getOriginalGroupId()),
						
						vsmBranchModelImpl.getOriginalLanguage(),
						Long.valueOf(vsmBranchModelImpl.getOriginalParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P,
					args);

				args = new Object[] {
						Long.valueOf(vsmBranchModelImpl.getGroupId()),
						
						vsmBranchModelImpl.getLanguage(),
						Long.valueOf(vsmBranchModelImpl.getParentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P,
					args);
			}

			if ((vsmBranchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICON.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(vsmBranchModelImpl.getOriginalHasIcon())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ICON, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICON,
					args);

				args = new Object[] {
						Boolean.valueOf(vsmBranchModelImpl.getHasIcon())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ICON, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICON,
					args);
			}

			if ((vsmBranchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vsmBranchModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE,
					args);

				args = new Object[] { vsmBranchModelImpl.getLanguage() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE,
					args);
			}
		}

		EntityCacheUtil.putResult(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
			VsmBranchImpl.class, vsmBranch.getPrimaryKey(), vsmBranch);

		return vsmBranch;
	}

	protected VsmBranch toUnwrappedModel(VsmBranch vsmBranch) {
		if (vsmBranch instanceof VsmBranchImpl) {
			return vsmBranch;
		}

		VsmBranchImpl vsmBranchImpl = new VsmBranchImpl();

		vsmBranchImpl.setNew(vsmBranch.isNew());
		vsmBranchImpl.setPrimaryKey(vsmBranch.getPrimaryKey());

		vsmBranchImpl.setBranchId(vsmBranch.getBranchId());
		vsmBranchImpl.setGroupId(vsmBranch.getGroupId());
		vsmBranchImpl.setCompanyId(vsmBranch.getCompanyId());
		vsmBranchImpl.setCreatedDate(vsmBranch.getCreatedDate());
		vsmBranchImpl.setCreatedByUser(vsmBranch.getCreatedByUser());
		vsmBranchImpl.setModifiedDate(vsmBranch.getModifiedDate());
		vsmBranchImpl.setModifiedByUser(vsmBranch.getModifiedByUser());
		vsmBranchImpl.setParentId(vsmBranch.getParentId());
		vsmBranchImpl.setName(vsmBranch.getName());
		vsmBranchImpl.setDescription(vsmBranch.getDescription());
		vsmBranchImpl.setAnchored(vsmBranch.isAnchored());
		vsmBranchImpl.setHref(vsmBranch.getHref());
		vsmBranchImpl.setLanguage(vsmBranch.getLanguage());
		vsmBranchImpl.setHasIcon(vsmBranch.isHasIcon());
		vsmBranchImpl.setIcon(vsmBranch.getIcon());
		vsmBranchImpl.setPosition(vsmBranch.getPosition());

		return vsmBranchImpl;
	}

	/**
	 * Returns the vsm branch with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vsm branch
	 * @return the vsm branch
	 * @throws com.liferay.portal.NoSuchModelException if a vsm branch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VsmBranch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the vsm branch with the primary key or throws a {@link com.vportal.portlet.vsitemap.NoSuchVsmBranchException} if it could not be found.
	 *
	 * @param branchId the primary key of the vsm branch
	 * @return the vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch findByPrimaryKey(long branchId)
		throws NoSuchVsmBranchException, SystemException {
		VsmBranch vsmBranch = fetchByPrimaryKey(branchId);

		if (vsmBranch == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + branchId);
			}

			throw new NoSuchVsmBranchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				branchId);
		}

		return vsmBranch;
	}

	/**
	 * Returns the vsm branch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vsm branch
	 * @return the vsm branch, or <code>null</code> if a vsm branch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VsmBranch fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the vsm branch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param branchId the primary key of the vsm branch
	 * @return the vsm branch, or <code>null</code> if a vsm branch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch fetchByPrimaryKey(long branchId) throws SystemException {
		VsmBranch vsmBranch = (VsmBranch)EntityCacheUtil.getResult(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
				VsmBranchImpl.class, branchId);

		if (vsmBranch == _nullVsmBranch) {
			return null;
		}

		if (vsmBranch == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vsmBranch = (VsmBranch)session.get(VsmBranchImpl.class,
						Long.valueOf(branchId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vsmBranch != null) {
					cacheResult(vsmBranch);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VsmBranchModelImpl.ENTITY_CACHE_ENABLED,
						VsmBranchImpl.class, branchId, _nullVsmBranch);
				}

				closeSession(session);
			}
		}

		return vsmBranch;
	}

	/**
	 * Returns all the vsm branchs where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByParent(long parentId)
		throws SystemException {
		return findByParent(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vsm branchs where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @return the range of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByParent(long parentId, int start, int end)
		throws SystemException {
		return findByParent(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vsm branchs where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByParent(long parentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] { parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] { parentId, start, end, orderByComparator };
		}

		List<VsmBranch> list = (List<VsmBranch>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VSMBRANCH_WHERE);

			query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VsmBranchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				list = (List<VsmBranch>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first vsm branch in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch findByParent_First(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		List<VsmBranch> list = findByParent(parentId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVsmBranchException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vsm branch in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch findByParent_Last(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		int count = countByParent(parentId);

		List<VsmBranch> list = findByParent(parentId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVsmBranchException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vsm branchs before and after the current vsm branch in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param branchId the primary key of the current vsm branch
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch[] findByParent_PrevAndNext(long branchId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		VsmBranch vsmBranch = findByPrimaryKey(branchId);

		Session session = null;

		try {
			session = openSession();

			VsmBranch[] array = new VsmBranchImpl[3];

			array[0] = getByParent_PrevAndNext(session, vsmBranch, parentId,
					orderByComparator, true);

			array[1] = vsmBranch;

			array[2] = getByParent_PrevAndNext(session, vsmBranch, parentId,
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

	protected VsmBranch getByParent_PrevAndNext(Session session,
		VsmBranch vsmBranch, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VSMBRANCH_WHERE);

		query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

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
			query.append(VsmBranchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vsmBranch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VsmBranch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vsm branchs where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByG_L(long groupId, String language)
		throws SystemException {
		return findByG_L(groupId, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vsm branchs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @return the range of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByG_L(long groupId, String language, int start,
		int end) throws SystemException {
		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vsm branchs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByG_L(long groupId, String language, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<VsmBranch> list = (List<VsmBranch>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VSMBRANCH_WHERE);

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
				query.append(VsmBranchModelImpl.ORDER_BY_JPQL);
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

				list = (List<VsmBranch>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first vsm branch in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch findByG_L_First(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		List<VsmBranch> list = findByG_L(groupId, language, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVsmBranchException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vsm branch in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch findByG_L_Last(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		int count = countByG_L(groupId, language);

		List<VsmBranch> list = findByG_L(groupId, language, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVsmBranchException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vsm branchs before and after the current vsm branch in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param branchId the primary key of the current vsm branch
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch[] findByG_L_PrevAndNext(long branchId, long groupId,
		String language, OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		VsmBranch vsmBranch = findByPrimaryKey(branchId);

		Session session = null;

		try {
			session = openSession();

			VsmBranch[] array = new VsmBranchImpl[3];

			array[0] = getByG_L_PrevAndNext(session, vsmBranch, groupId,
					language, orderByComparator, true);

			array[1] = vsmBranch;

			array[2] = getByG_L_PrevAndNext(session, vsmBranch, groupId,
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

	protected VsmBranch getByG_L_PrevAndNext(Session session,
		VsmBranch vsmBranch, long groupId, String language,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VSMBRANCH_WHERE);

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
			query.append(VsmBranchModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vsmBranch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VsmBranch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vsm branchs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByG_L_P(long groupId, String language,
		long parentId) throws SystemException {
		return findByG_L_P(groupId, language, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vsm branchs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @return the range of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByG_L_P(long groupId, String language,
		long parentId, int start, int end) throws SystemException {
		return findByG_L_P(groupId, language, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vsm branchs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByG_L_P(long groupId, String language,
		long parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P;
			finderArgs = new Object[] { groupId, language, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_P;
			finderArgs = new Object[] {
					groupId, language, parentId,
					
					start, end, orderByComparator
				};
		}

		List<VsmBranch> list = (List<VsmBranch>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VSMBRANCH_WHERE);

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

			query.append(_FINDER_COLUMN_G_L_P_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VsmBranchModelImpl.ORDER_BY_JPQL);
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

				qPos.add(parentId);

				list = (List<VsmBranch>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first vsm branch in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch findByG_L_P_First(long groupId, String language,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		List<VsmBranch> list = findByG_L_P(groupId, language, parentId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVsmBranchException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vsm branch in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch findByG_L_P_Last(long groupId, String language,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		int count = countByG_L_P(groupId, language, parentId);

		List<VsmBranch> list = findByG_L_P(groupId, language, parentId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVsmBranchException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vsm branchs before and after the current vsm branch in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param branchId the primary key of the current vsm branch
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch[] findByG_L_P_PrevAndNext(long branchId, long groupId,
		String language, long parentId, OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		VsmBranch vsmBranch = findByPrimaryKey(branchId);

		Session session = null;

		try {
			session = openSession();

			VsmBranch[] array = new VsmBranchImpl[3];

			array[0] = getByG_L_P_PrevAndNext(session, vsmBranch, groupId,
					language, parentId, orderByComparator, true);

			array[1] = vsmBranch;

			array[2] = getByG_L_P_PrevAndNext(session, vsmBranch, groupId,
					language, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VsmBranch getByG_L_P_PrevAndNext(Session session,
		VsmBranch vsmBranch, long groupId, String language, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VSMBRANCH_WHERE);

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

		query.append(_FINDER_COLUMN_G_L_P_PARENTID_2);

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
			query.append(VsmBranchModelImpl.ORDER_BY_JPQL);
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

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vsmBranch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VsmBranch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vsm branchs where hasIcon = &#63;.
	 *
	 * @param hasIcon the has icon
	 * @return the matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByIcon(boolean hasIcon)
		throws SystemException {
		return findByIcon(hasIcon, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vsm branchs where hasIcon = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hasIcon the has icon
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @return the range of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByIcon(boolean hasIcon, int start, int end)
		throws SystemException {
		return findByIcon(hasIcon, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vsm branchs where hasIcon = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hasIcon the has icon
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByIcon(boolean hasIcon, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICON;
			finderArgs = new Object[] { hasIcon };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ICON;
			finderArgs = new Object[] { hasIcon, start, end, orderByComparator };
		}

		List<VsmBranch> list = (List<VsmBranch>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VSMBRANCH_WHERE);

			query.append(_FINDER_COLUMN_ICON_HASICON_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VsmBranchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hasIcon);

				list = (List<VsmBranch>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first vsm branch in the ordered set where hasIcon = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hasIcon the has icon
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch findByIcon_First(boolean hasIcon,
		OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		List<VsmBranch> list = findByIcon(hasIcon, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hasIcon=");
			msg.append(hasIcon);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVsmBranchException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vsm branch in the ordered set where hasIcon = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param hasIcon the has icon
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch findByIcon_Last(boolean hasIcon,
		OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		int count = countByIcon(hasIcon);

		List<VsmBranch> list = findByIcon(hasIcon, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hasIcon=");
			msg.append(hasIcon);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVsmBranchException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vsm branchs before and after the current vsm branch in the ordered set where hasIcon = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param branchId the primary key of the current vsm branch
	 * @param hasIcon the has icon
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch[] findByIcon_PrevAndNext(long branchId, boolean hasIcon,
		OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		VsmBranch vsmBranch = findByPrimaryKey(branchId);

		Session session = null;

		try {
			session = openSession();

			VsmBranch[] array = new VsmBranchImpl[3];

			array[0] = getByIcon_PrevAndNext(session, vsmBranch, hasIcon,
					orderByComparator, true);

			array[1] = vsmBranch;

			array[2] = getByIcon_PrevAndNext(session, vsmBranch, hasIcon,
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

	protected VsmBranch getByIcon_PrevAndNext(Session session,
		VsmBranch vsmBranch, boolean hasIcon,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VSMBRANCH_WHERE);

		query.append(_FINDER_COLUMN_ICON_HASICON_2);

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
			query.append(VsmBranchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(hasIcon);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vsmBranch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VsmBranch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vsm branchs where language = &#63;.
	 *
	 * @param language the language
	 * @return the matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByLanguage(String language)
		throws SystemException {
		return findByLanguage(language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vsm branchs where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param language the language
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @return the range of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByLanguage(String language, int start, int end)
		throws SystemException {
		return findByLanguage(language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vsm branchs where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param language the language
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findByLanguage(String language, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE;
			finderArgs = new Object[] { language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGE;
			finderArgs = new Object[] { language, start, end, orderByComparator };
		}

		List<VsmBranch> list = (List<VsmBranch>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VSMBRANCH_WHERE);

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
				query.append(VsmBranchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (language != null) {
					qPos.add(language);
				}

				list = (List<VsmBranch>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first vsm branch in the ordered set where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch findByLanguage_First(String language,
		OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		List<VsmBranch> list = findByLanguage(language, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVsmBranchException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vsm branch in the ordered set where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a matching vsm branch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch findByLanguage_Last(String language,
		OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		int count = countByLanguage(language);

		List<VsmBranch> list = findByLanguage(language, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVsmBranchException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vsm branchs before and after the current vsm branch in the ordered set where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param branchId the primary key of the current vsm branch
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vsm branch
	 * @throws com.vportal.portlet.vsitemap.NoSuchVsmBranchException if a vsm branch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VsmBranch[] findByLanguage_PrevAndNext(long branchId,
		String language, OrderByComparator orderByComparator)
		throws NoSuchVsmBranchException, SystemException {
		VsmBranch vsmBranch = findByPrimaryKey(branchId);

		Session session = null;

		try {
			session = openSession();

			VsmBranch[] array = new VsmBranchImpl[3];

			array[0] = getByLanguage_PrevAndNext(session, vsmBranch, language,
					orderByComparator, true);

			array[1] = vsmBranch;

			array[2] = getByLanguage_PrevAndNext(session, vsmBranch, language,
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

	protected VsmBranch getByLanguage_PrevAndNext(Session session,
		VsmBranch vsmBranch, String language,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VSMBRANCH_WHERE);

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
			query.append(VsmBranchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (language != null) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vsmBranch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VsmBranch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vsm branchs.
	 *
	 * @return the vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vsm branchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @return the range of vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vsm branchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vsm branchs
	 * @param end the upper bound of the range of vsm branchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public List<VsmBranch> findAll(int start, int end,
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

		List<VsmBranch> list = (List<VsmBranch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VSMBRANCH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VSMBRANCH.concat(VsmBranchModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VsmBranch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VsmBranch>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vsm branchs where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParent(long parentId) throws SystemException {
		for (VsmBranch vsmBranch : findByParent(parentId)) {
			remove(vsmBranch);
		}
	}

	/**
	 * Removes all the vsm branchs where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_L(long groupId, String language)
		throws SystemException {
		for (VsmBranch vsmBranch : findByG_L(groupId, language)) {
			remove(vsmBranch);
		}
	}

	/**
	 * Removes all the vsm branchs where groupId = &#63; and language = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_L_P(long groupId, String language, long parentId)
		throws SystemException {
		for (VsmBranch vsmBranch : findByG_L_P(groupId, language, parentId)) {
			remove(vsmBranch);
		}
	}

	/**
	 * Removes all the vsm branchs where hasIcon = &#63; from the database.
	 *
	 * @param hasIcon the has icon
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIcon(boolean hasIcon) throws SystemException {
		for (VsmBranch vsmBranch : findByIcon(hasIcon)) {
			remove(vsmBranch);
		}
	}

	/**
	 * Removes all the vsm branchs where language = &#63; from the database.
	 *
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLanguage(String language) throws SystemException {
		for (VsmBranch vsmBranch : findByLanguage(language)) {
			remove(vsmBranch);
		}
	}

	/**
	 * Removes all the vsm branchs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VsmBranch vsmBranch : findAll()) {
			remove(vsmBranch);
		}
	}

	/**
	 * Returns the number of vsm branchs where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParent(long parentId) throws SystemException {
		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VSMBRANCH_WHERE);

			query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vsm branchs where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_L(long groupId, String language)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VSMBRANCH_WHERE);

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
	 * Returns the number of vsm branchs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the number of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_L_P(long groupId, String language, long parentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language, parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VSMBRANCH_WHERE);

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

			query.append(_FINDER_COLUMN_G_L_P_PARENTID_2);

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

				qPos.add(parentId);

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
	 * Returns the number of vsm branchs where hasIcon = &#63;.
	 *
	 * @param hasIcon the has icon
	 * @return the number of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIcon(boolean hasIcon) throws SystemException {
		Object[] finderArgs = new Object[] { hasIcon };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ICON,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VSMBRANCH_WHERE);

			query.append(_FINDER_COLUMN_ICON_HASICON_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hasIcon);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ICON,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vsm branchs where language = &#63;.
	 *
	 * @param language the language
	 * @return the number of matching vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLanguage(String language) throws SystemException {
		Object[] finderArgs = new Object[] { language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LANGUAGE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VSMBRANCH_WHERE);

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
	 * Returns the number of vsm branchs.
	 *
	 * @return the number of vsm branchs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VSMBRANCH);

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
	 * Initializes the vsm branch persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vsitemap.model.VsmBranch")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VsmBranch>> listenersList = new ArrayList<ModelListener<VsmBranch>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VsmBranch>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VsmBranchImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = VsmBranchPersistence.class)
	protected VsmBranchPersistence vsmBranchPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_VSMBRANCH = "SELECT vsmBranch FROM VsmBranch vsmBranch";
	private static final String _SQL_SELECT_VSMBRANCH_WHERE = "SELECT vsmBranch FROM VsmBranch vsmBranch WHERE ";
	private static final String _SQL_COUNT_VSMBRANCH = "SELECT COUNT(vsmBranch) FROM VsmBranch vsmBranch";
	private static final String _SQL_COUNT_VSMBRANCH_WHERE = "SELECT COUNT(vsmBranch) FROM VsmBranch vsmBranch WHERE ";
	private static final String _FINDER_COLUMN_PARENT_PARENTID_2 = "vsmBranch.parentId = ?";
	private static final String _FINDER_COLUMN_G_L_GROUPID_2 = "vsmBranch.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_1 = "vsmBranch.language IS NULL";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 = "vsmBranch.language = ?";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 = "(vsmBranch.language IS NULL OR vsmBranch.language = ?)";
	private static final String _FINDER_COLUMN_G_L_P_GROUPID_2 = "vsmBranch.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_1 = "vsmBranch.language IS NULL AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_2 = "vsmBranch.language = ? AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_3 = "(vsmBranch.language IS NULL OR vsmBranch.language = ?) AND ";
	private static final String _FINDER_COLUMN_G_L_P_PARENTID_2 = "vsmBranch.parentId = ?";
	private static final String _FINDER_COLUMN_ICON_HASICON_2 = "vsmBranch.hasIcon = ?";
	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_1 = "vsmBranch.language IS NULL";
	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_2 = "vsmBranch.language = ?";
	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_3 = "(vsmBranch.language IS NULL OR vsmBranch.language = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vsmBranch.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VsmBranch exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VsmBranch exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VsmBranchPersistenceImpl.class);
	private static VsmBranch _nullVsmBranch = new VsmBranchImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VsmBranch> toCacheModel() {
				return _nullVsmBranchCacheModel;
			}
		};

	private static CacheModel<VsmBranch> _nullVsmBranchCacheModel = new CacheModel<VsmBranch>() {
			public VsmBranch toEntityModel() {
				return _nullVsmBranch;
			}
		};
}