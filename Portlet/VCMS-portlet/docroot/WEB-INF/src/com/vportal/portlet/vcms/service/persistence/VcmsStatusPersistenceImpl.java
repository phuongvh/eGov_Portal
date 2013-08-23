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

import com.vportal.portlet.vcms.NoSuchVcmsStatusException;
import com.vportal.portlet.vcms.model.VcmsStatus;
import com.vportal.portlet.vcms.model.impl.VcmsStatusImpl;
import com.vportal.portlet.vcms.model.impl.VcmsStatusModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsStatusPersistence
 * @see VcmsStatusUtil
 * @generated
 */
public class VcmsStatusPersistenceImpl extends BasePersistenceImpl<VcmsStatus>
	implements VcmsStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsStatusUtil} to access the vcms status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			VcmsStatusModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			VcmsStatusModelImpl.COMPANYID_COLUMN_BITMASK |
			VcmsStatusModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			VcmsStatusModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsStatusModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_P",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			VcmsStatusModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_A = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			VcmsStatusModelImpl.COMPANYID_COLUMN_BITMASK |
			VcmsStatusModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsStatusModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_A = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_A = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByA",
			new String[] { Boolean.class.getName() },
			VcmsStatusModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_A = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_A",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_A = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_A",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			VcmsStatusModelImpl.COMPANYID_COLUMN_BITMASK |
			VcmsStatusModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_A = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_A",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_P = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			VcmsStatusModelImpl.COMPANYID_COLUMN_BITMASK |
			VcmsStatusModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsStatusModelImpl.ISPRIMARY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_P = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_P = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_P",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_P",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			VcmsStatusModelImpl.COMPANYID_COLUMN_BITMASK |
			VcmsStatusModelImpl.ISPRIMARY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_P = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_P",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, VcmsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms status in the entity cache if it is enabled.
	 *
	 * @param vcmsStatus the vcms status
	 */
	public void cacheResult(VcmsStatus vcmsStatus) {
		EntityCacheUtil.putResult(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusImpl.class, vcmsStatus.getPrimaryKey(), vcmsStatus);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_A,
			new Object[] {
				Long.valueOf(vcmsStatus.getCompanyId()),
				Long.valueOf(vcmsStatus.getGroupId()),
				Boolean.valueOf(vcmsStatus.getActive())
			}, vcmsStatus);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A,
			new Object[] { Boolean.valueOf(vcmsStatus.getActive()) }, vcmsStatus);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_P,
			new Object[] {
				Long.valueOf(vcmsStatus.getCompanyId()),
				Long.valueOf(vcmsStatus.getGroupId()),
				Boolean.valueOf(vcmsStatus.getIsPrimary())
			}, vcmsStatus);

		vcmsStatus.resetOriginalValues();
	}

	/**
	 * Caches the vcms statuses in the entity cache if it is enabled.
	 *
	 * @param vcmsStatuses the vcms statuses
	 */
	public void cacheResult(List<VcmsStatus> vcmsStatuses) {
		for (VcmsStatus vcmsStatus : vcmsStatuses) {
			if (EntityCacheUtil.getResult(
						VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
						VcmsStatusImpl.class, vcmsStatus.getPrimaryKey()) == null) {
				cacheResult(vcmsStatus);
			}
			else {
				vcmsStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms statuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsStatusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsStatusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms status.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsStatus vcmsStatus) {
		EntityCacheUtil.removeResult(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusImpl.class, vcmsStatus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(vcmsStatus);
	}

	@Override
	public void clearCache(List<VcmsStatus> vcmsStatuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsStatus vcmsStatus : vcmsStatuses) {
			EntityCacheUtil.removeResult(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
				VcmsStatusImpl.class, vcmsStatus.getPrimaryKey());

			clearUniqueFindersCache(vcmsStatus);
		}
	}

	protected void clearUniqueFindersCache(VcmsStatus vcmsStatus) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_A,
			new Object[] {
				Long.valueOf(vcmsStatus.getCompanyId()),
				Long.valueOf(vcmsStatus.getGroupId()),
				Boolean.valueOf(vcmsStatus.getActive())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A,
			new Object[] { Boolean.valueOf(vcmsStatus.getActive()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_P,
			new Object[] {
				Long.valueOf(vcmsStatus.getCompanyId()),
				Long.valueOf(vcmsStatus.getGroupId()),
				Boolean.valueOf(vcmsStatus.getIsPrimary())
			});
	}

	/**
	 * Creates a new vcms status with the primary key. Does not add the vcms status to the database.
	 *
	 * @param statusId the primary key for the new vcms status
	 * @return the new vcms status
	 */
	public VcmsStatus create(long statusId) {
		VcmsStatus vcmsStatus = new VcmsStatusImpl();

		vcmsStatus.setNew(true);
		vcmsStatus.setPrimaryKey(statusId);

		return vcmsStatus;
	}

	/**
	 * Removes the vcms status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statusId the primary key of the vcms status
	 * @return the vcms status that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus remove(long statusId)
		throws NoSuchVcmsStatusException, SystemException {
		return remove(Long.valueOf(statusId));
	}

	/**
	 * Removes the vcms status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms status
	 * @return the vcms status that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsStatus remove(Serializable primaryKey)
		throws NoSuchVcmsStatusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsStatus vcmsStatus = (VcmsStatus)session.get(VcmsStatusImpl.class,
					primaryKey);

			if (vcmsStatus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsStatus);
		}
		catch (NoSuchVcmsStatusException nsee) {
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
	protected VcmsStatus removeImpl(VcmsStatus vcmsStatus)
		throws SystemException {
		vcmsStatus = toUnwrappedModel(vcmsStatus);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsStatus);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsStatus);

		return vcmsStatus;
	}

	@Override
	public VcmsStatus updateImpl(
		com.vportal.portlet.vcms.model.VcmsStatus vcmsStatus, boolean merge)
		throws SystemException {
		vcmsStatus = toUnwrappedModel(vcmsStatus);

		boolean isNew = vcmsStatus.isNew();

		VcmsStatusModelImpl vcmsStatusModelImpl = (VcmsStatusModelImpl)vcmsStatus;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsStatus, merge);

			vcmsStatus.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsStatusModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((vcmsStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getOriginalCompanyId()),
						Long.valueOf(vcmsStatusModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getCompanyId()),
						Long.valueOf(vcmsStatusModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}

			if ((vcmsStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getOriginalGroupId()),
						Long.valueOf(vcmsStatusModelImpl.getOriginalPosition())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P,
					args);

				args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getGroupId()),
						Long.valueOf(vcmsStatusModelImpl.getPosition())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P,
					args);
			}

			if ((vcmsStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((vcmsStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(vcmsStatusModelImpl.getOriginalActive())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_A,
					args);

				args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getCompanyId()),
						Boolean.valueOf(vcmsStatusModelImpl.getActive())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_A,
					args);
			}

			if ((vcmsStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(vcmsStatusModelImpl.getOriginalIsPrimary())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P,
					args);

				args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getCompanyId()),
						Boolean.valueOf(vcmsStatusModelImpl.getIsPrimary())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
			VcmsStatusImpl.class, vcmsStatus.getPrimaryKey(), vcmsStatus);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_A,
				new Object[] {
					Long.valueOf(vcmsStatus.getCompanyId()),
					Long.valueOf(vcmsStatus.getGroupId()),
					Boolean.valueOf(vcmsStatus.getActive())
				}, vcmsStatus);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A,
				new Object[] { Boolean.valueOf(vcmsStatus.getActive()) },
				vcmsStatus);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_P,
				new Object[] {
					Long.valueOf(vcmsStatus.getCompanyId()),
					Long.valueOf(vcmsStatus.getGroupId()),
					Boolean.valueOf(vcmsStatus.getIsPrimary())
				}, vcmsStatus);
		}
		else {
			if ((vcmsStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_G_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getOriginalCompanyId()),
						Long.valueOf(vcmsStatusModelImpl.getOriginalGroupId()),
						Boolean.valueOf(vcmsStatusModelImpl.getOriginalActive())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_A, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_A,
					new Object[] {
						Long.valueOf(vcmsStatus.getCompanyId()),
						Long.valueOf(vcmsStatus.getGroupId()),
						Boolean.valueOf(vcmsStatus.getActive())
					}, vcmsStatus);
			}

			if ((vcmsStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(vcmsStatusModelImpl.getOriginalActive())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A,
					new Object[] { Boolean.valueOf(vcmsStatus.getActive()) },
					vcmsStatus);
			}

			if ((vcmsStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_G_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsStatusModelImpl.getOriginalCompanyId()),
						Long.valueOf(vcmsStatusModelImpl.getOriginalGroupId()),
						Boolean.valueOf(vcmsStatusModelImpl.getOriginalIsPrimary())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_P, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_P,
					new Object[] {
						Long.valueOf(vcmsStatus.getCompanyId()),
						Long.valueOf(vcmsStatus.getGroupId()),
						Boolean.valueOf(vcmsStatus.getIsPrimary())
					}, vcmsStatus);
			}
		}

		return vcmsStatus;
	}

	protected VcmsStatus toUnwrappedModel(VcmsStatus vcmsStatus) {
		if (vcmsStatus instanceof VcmsStatusImpl) {
			return vcmsStatus;
		}

		VcmsStatusImpl vcmsStatusImpl = new VcmsStatusImpl();

		vcmsStatusImpl.setNew(vcmsStatus.isNew());
		vcmsStatusImpl.setPrimaryKey(vcmsStatus.getPrimaryKey());

		vcmsStatusImpl.setStatusId(vcmsStatus.getStatusId());
		vcmsStatusImpl.setCompanyId(vcmsStatus.getCompanyId());
		vcmsStatusImpl.setGroupId(vcmsStatus.getGroupId());
		vcmsStatusImpl.setCreatedDate(vcmsStatus.getCreatedDate());
		vcmsStatusImpl.setCreatedByUser(vcmsStatus.getCreatedByUser());
		vcmsStatusImpl.setModifiedDate(vcmsStatus.getModifiedDate());
		vcmsStatusImpl.setModifiedByUser(vcmsStatus.getModifiedByUser());
		vcmsStatusImpl.setName(vcmsStatus.getName());
		vcmsStatusImpl.setDescription(vcmsStatus.getDescription());
		vcmsStatusImpl.setCssClass(vcmsStatus.getCssClass());
		vcmsStatusImpl.setTextColor(vcmsStatus.getTextColor());
		vcmsStatusImpl.setPosition(vcmsStatus.getPosition());
		vcmsStatusImpl.setIsPrimary(vcmsStatus.isIsPrimary());
		vcmsStatusImpl.setActive(vcmsStatus.isActive());

		return vcmsStatusImpl;
	}

	/**
	 * Returns the vcms status with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms status
	 * @return the vcms status
	 * @throws com.liferay.portal.NoSuchModelException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the vcms status with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsStatusException} if it could not be found.
	 *
	 * @param statusId the primary key of the vcms status
	 * @return the vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByPrimaryKey(long statusId)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = fetchByPrimaryKey(statusId);

		if (vcmsStatus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + statusId);
			}

			throw new NoSuchVcmsStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				statusId);
		}

		return vcmsStatus;
	}

	/**
	 * Returns the vcms status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms status
	 * @return the vcms status, or <code>null</code> if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsStatus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the vcms status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statusId the primary key of the vcms status
	 * @return the vcms status, or <code>null</code> if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus fetchByPrimaryKey(long statusId)
		throws SystemException {
		VcmsStatus vcmsStatus = (VcmsStatus)EntityCacheUtil.getResult(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
				VcmsStatusImpl.class, statusId);

		if (vcmsStatus == _nullVcmsStatus) {
			return null;
		}

		if (vcmsStatus == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsStatus = (VcmsStatus)session.get(VcmsStatusImpl.class,
						Long.valueOf(statusId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsStatus != null) {
					cacheResult(vcmsStatus);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsStatusModelImpl.ENTITY_CACHE_ENABLED,
						VcmsStatusImpl.class, statusId, _nullVcmsStatus);
				}

				closeSession(session);
			}
		}

		return vcmsStatus;
	}

	/**
	 * Returns all the vcms statuses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms statuses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @return the range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms statuses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByCompanyId(long companyId, int start, int end,
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

		List<VcmsStatus> list = (List<VcmsStatus>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<VcmsStatus>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vcms status in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		List<VcmsStatus> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms status in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		int count = countByCompanyId(companyId);

		List<VcmsStatus> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms statuses before and after the current vcms status in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param statusId the primary key of the current vcms status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus[] findByCompanyId_PrevAndNext(long statusId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			VcmsStatus[] array = new VcmsStatusImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, vcmsStatus,
					companyId, orderByComparator, true);

			array[1] = vcmsStatus;

			array[2] = getByCompanyId_PrevAndNext(session, vcmsStatus,
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

	protected VcmsStatus getByCompanyId_PrevAndNext(Session session,
		VcmsStatus vcmsStatus, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

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
			query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms statuses where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByC_G(long companyId, long groupId)
		throws SystemException {
		return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms statuses where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @return the range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByC_G(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms statuses where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByC_G(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VcmsStatus> list = (List<VcmsStatus>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				list = (List<VcmsStatus>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vcms status in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByC_G_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		List<VcmsStatus> list = findByC_G(companyId, groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms status in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByC_G_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		int count = countByC_G(companyId, groupId);

		List<VcmsStatus> list = findByC_G(companyId, groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms statuses before and after the current vcms status in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param statusId the primary key of the current vcms status
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus[] findByC_G_PrevAndNext(long statusId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			VcmsStatus[] array = new VcmsStatusImpl[3];

			array[0] = getByC_G_PrevAndNext(session, vcmsStatus, companyId,
					groupId, orderByComparator, true);

			array[1] = vcmsStatus;

			array[2] = getByC_G_PrevAndNext(session, vcmsStatus, companyId,
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

	protected VcmsStatus getByC_G_PrevAndNext(Session session,
		VcmsStatus vcmsStatus, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

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
			query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms statuses that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> filterFindByC_G(long companyId, long groupId)
		throws SystemException {
		return filterFindByC_G(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms statuses that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @return the range of matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> filterFindByC_G(long companyId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByC_G(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms statuses that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> filterFindByC_G(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G(companyId, groupId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VcmsStatus.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VcmsStatusImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VcmsStatusImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<VcmsStatus>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the vcms statuses before and after the current vcms status in the ordered set of vcms statuses that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param statusId the primary key of the current vcms status
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus[] filterFindByC_G_PrevAndNext(long statusId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByC_G_PrevAndNext(statusId, companyId, groupId,
				orderByComparator);
		}

		VcmsStatus vcmsStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			VcmsStatus[] array = new VcmsStatusImpl[3];

			array[0] = filterGetByC_G_PrevAndNext(session, vcmsStatus,
					companyId, groupId, orderByComparator, true);

			array[1] = vcmsStatus;

			array[2] = filterGetByC_G_PrevAndNext(session, vcmsStatus,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsStatus filterGetByC_G_PrevAndNext(Session session,
		VcmsStatus vcmsStatus, long companyId, long groupId,
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
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VcmsStatus.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VcmsStatusImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VcmsStatusImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms statuses where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @return the matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByG_P(long groupId, long position)
		throws SystemException {
		return findByG_P(groupId, position, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms statuses where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @return the range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByG_P(long groupId, long position, int start,
		int end) throws SystemException {
		return findByG_P(groupId, position, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms statuses where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByG_P(long groupId, long position, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P;
			finderArgs = new Object[] { groupId, position };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P;
			finderArgs = new Object[] {
					groupId, position,
					
					start, end, orderByComparator
				};
		}

		List<VcmsStatus> list = (List<VcmsStatus>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_POSITION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(position);

				list = (List<VcmsStatus>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vcms status in the ordered set where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByG_P_First(long groupId, long position,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		List<VcmsStatus> list = findByG_P(groupId, position, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", position=");
			msg.append(position);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms status in the ordered set where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByG_P_Last(long groupId, long position,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		int count = countByG_P(groupId, position);

		List<VcmsStatus> list = findByG_P(groupId, position, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", position=");
			msg.append(position);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms statuses before and after the current vcms status in the ordered set where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param statusId the primary key of the current vcms status
	 * @param groupId the group ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus[] findByG_P_PrevAndNext(long statusId, long groupId,
		long position, OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			VcmsStatus[] array = new VcmsStatusImpl[3];

			array[0] = getByG_P_PrevAndNext(session, vcmsStatus, groupId,
					position, orderByComparator, true);

			array[1] = vcmsStatus;

			array[2] = getByG_P_PrevAndNext(session, vcmsStatus, groupId,
					position, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsStatus getByG_P_PrevAndNext(Session session,
		VcmsStatus vcmsStatus, long groupId, long position,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_POSITION_2);

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
			query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(position);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms statuses that the user has permission to view where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @return the matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> filterFindByG_P(long groupId, long position)
		throws SystemException {
		return filterFindByG_P(groupId, position, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms statuses that the user has permission to view where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @return the range of matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> filterFindByG_P(long groupId, long position,
		int start, int end) throws SystemException {
		return filterFindByG_P(groupId, position, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms statuses that the user has permissions to view where groupId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> filterFindByG_P(long groupId, long position,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_P(groupId, position, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_POSITION_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VcmsStatus.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VcmsStatusImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VcmsStatusImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(position);

			return (List<VcmsStatus>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the vcms statuses before and after the current vcms status in the ordered set of vcms statuses that the user has permission to view where groupId = &#63; and position = &#63;.
	 *
	 * @param statusId the primary key of the current vcms status
	 * @param groupId the group ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus[] filterFindByG_P_PrevAndNext(long statusId,
		long groupId, long position, OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_P_PrevAndNext(statusId, groupId, position,
				orderByComparator);
		}

		VcmsStatus vcmsStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			VcmsStatus[] array = new VcmsStatusImpl[3];

			array[0] = filterGetByG_P_PrevAndNext(session, vcmsStatus, groupId,
					position, orderByComparator, true);

			array[1] = vcmsStatus;

			array[2] = filterGetByG_P_PrevAndNext(session, vcmsStatus, groupId,
					position, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsStatus filterGetByG_P_PrevAndNext(Session session,
		VcmsStatus vcmsStatus, long groupId, long position,
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
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_POSITION_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VcmsStatus.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VcmsStatusImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VcmsStatusImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(position);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms statuses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms statuses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @return the range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms statuses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByGroupId(long groupId, int start, int end,
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

		List<VcmsStatus> list = (List<VcmsStatus>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<VcmsStatus>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vcms status in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		List<VcmsStatus> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms status in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		int count = countByGroupId(groupId);

		List<VcmsStatus> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms statuses before and after the current vcms status in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param statusId the primary key of the current vcms status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus[] findByGroupId_PrevAndNext(long statusId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			VcmsStatus[] array = new VcmsStatusImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, vcmsStatus, groupId,
					orderByComparator, true);

			array[1] = vcmsStatus;

			array[2] = getByGroupId_PrevAndNext(session, vcmsStatus, groupId,
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

	protected VcmsStatus getByGroupId_PrevAndNext(Session session,
		VcmsStatus vcmsStatus, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

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
			query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms statuses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms statuses that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @return the range of matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms statuses that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VcmsStatus.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, VcmsStatusImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, VcmsStatusImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<VcmsStatus>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the vcms statuses before and after the current vcms status in the ordered set of vcms statuses that the user has permission to view where groupId = &#63;.
	 *
	 * @param statusId the primary key of the current vcms status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus[] filterFindByGroupId_PrevAndNext(long statusId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(statusId, groupId,
				orderByComparator);
		}

		VcmsStatus vcmsStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			VcmsStatus[] array = new VcmsStatusImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, vcmsStatus,
					groupId, orderByComparator, true);

			array[1] = vcmsStatus;

			array[2] = filterGetByGroupId_PrevAndNext(session, vcmsStatus,
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

	protected VcmsStatus filterGetByGroupId_PrevAndNext(Session session,
		VcmsStatus vcmsStatus, long groupId,
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
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VcmsStatus.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, VcmsStatusImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, VcmsStatusImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the vcms status where companyId = &#63; and groupId = &#63; and active = &#63; or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsStatusException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param active the active
	 * @return the matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByC_G_A(long companyId, long groupId, boolean active)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = fetchByC_G_A(companyId, groupId, active);

		if (vcmsStatus == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVcmsStatusException(msg.toString());
		}

		return vcmsStatus;
	}

	/**
	 * Returns the vcms status where companyId = &#63; and groupId = &#63; and active = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param active the active
	 * @return the matching vcms status, or <code>null</code> if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus fetchByC_G_A(long companyId, long groupId, boolean active)
		throws SystemException {
		return fetchByC_G_A(companyId, groupId, active, true);
	}

	/**
	 * Returns the vcms status where companyId = &#63; and groupId = &#63; and active = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param active the active
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching vcms status, or <code>null</code> if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus fetchByC_G_A(long companyId, long groupId,
		boolean active, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, active };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_A,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_C_G_A_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_A_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_A_ACTIVE_2);

			query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(active);

				List<VcmsStatus> list = q.list();

				result = list;

				VcmsStatus vcmsStatus = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_A,
						finderArgs, list);
				}
				else {
					vcmsStatus = list.get(0);

					cacheResult(vcmsStatus);

					if ((vcmsStatus.getCompanyId() != companyId) ||
							(vcmsStatus.getGroupId() != groupId) ||
							(vcmsStatus.getActive() != active)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_A,
							finderArgs, vcmsStatus);
					}
				}

				return vcmsStatus;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_A,
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
				return (VcmsStatus)result;
			}
		}
	}

	/**
	 * Returns the vcms status where active = &#63; or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsStatusException} if it could not be found.
	 *
	 * @param active the active
	 * @return the matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByA(boolean active)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = fetchByA(active);

		if (vcmsStatus == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVcmsStatusException(msg.toString());
		}

		return vcmsStatus;
	}

	/**
	 * Returns the vcms status where active = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param active the active
	 * @return the matching vcms status, or <code>null</code> if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus fetchByA(boolean active) throws SystemException {
		return fetchByA(active, true);
	}

	/**
	 * Returns the vcms status where active = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param active the active
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching vcms status, or <code>null</code> if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus fetchByA(boolean active, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { active };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_A,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_A_ACTIVE_2);

			query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				List<VcmsStatus> list = q.list();

				result = list;

				VcmsStatus vcmsStatus = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A,
						finderArgs, list);
				}
				else {
					vcmsStatus = list.get(0);

					cacheResult(vcmsStatus);

					if ((vcmsStatus.getActive() != active)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A,
							finderArgs, vcmsStatus);
					}
				}

				return vcmsStatus;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A,
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
				return (VcmsStatus)result;
			}
		}
	}

	/**
	 * Returns all the vcms statuses where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByC_A(long companyId, boolean active)
		throws SystemException {
		return findByC_A(companyId, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms statuses where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @return the range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByC_A(long companyId, boolean active,
		int start, int end) throws SystemException {
		return findByC_A(companyId, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms statuses where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByC_A(long companyId, boolean active,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_A;
			finderArgs = new Object[] { companyId, active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_A;
			finderArgs = new Object[] {
					companyId, active,
					
					start, end, orderByComparator
				};
		}

		List<VcmsStatus> list = (List<VcmsStatus>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_C_A_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_A_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(active);

				list = (List<VcmsStatus>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vcms status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByC_A_First(long companyId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		List<VcmsStatus> list = findByC_A(companyId, active, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByC_A_Last(long companyId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		int count = countByC_A(companyId, active);

		List<VcmsStatus> list = findByC_A(companyId, active, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", active=");
			msg.append(active);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms statuses before and after the current vcms status in the ordered set where companyId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param statusId the primary key of the current vcms status
	 * @param companyId the company ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus[] findByC_A_PrevAndNext(long statusId, long companyId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			VcmsStatus[] array = new VcmsStatusImpl[3];

			array[0] = getByC_A_PrevAndNext(session, vcmsStatus, companyId,
					active, orderByComparator, true);

			array[1] = vcmsStatus;

			array[2] = getByC_A_PrevAndNext(session, vcmsStatus, companyId,
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

	protected VcmsStatus getByC_A_PrevAndNext(Session session,
		VcmsStatus vcmsStatus, long companyId, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

		query.append(_FINDER_COLUMN_C_A_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_A_ACTIVE_2);

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
			query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the vcms status where companyId = &#63; and groupId = &#63; and isPrimary = &#63; or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsStatusException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param isPrimary the is primary
	 * @return the matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByC_G_P(long companyId, long groupId,
		boolean isPrimary) throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = fetchByC_G_P(companyId, groupId, isPrimary);

		if (vcmsStatus == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", isPrimary=");
			msg.append(isPrimary);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVcmsStatusException(msg.toString());
		}

		return vcmsStatus;
	}

	/**
	 * Returns the vcms status where companyId = &#63; and groupId = &#63; and isPrimary = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param isPrimary the is primary
	 * @return the matching vcms status, or <code>null</code> if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus fetchByC_G_P(long companyId, long groupId,
		boolean isPrimary) throws SystemException {
		return fetchByC_G_P(companyId, groupId, isPrimary, true);
	}

	/**
	 * Returns the vcms status where companyId = &#63; and groupId = &#63; and isPrimary = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param isPrimary the is primary
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching vcms status, or <code>null</code> if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus fetchByC_G_P(long companyId, long groupId,
		boolean isPrimary, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, isPrimary };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_P,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_C_G_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_P_ISPRIMARY_2);

			query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(isPrimary);

				List<VcmsStatus> list = q.list();

				result = list;

				VcmsStatus vcmsStatus = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_P,
						finderArgs, list);
				}
				else {
					vcmsStatus = list.get(0);

					cacheResult(vcmsStatus);

					if ((vcmsStatus.getCompanyId() != companyId) ||
							(vcmsStatus.getGroupId() != groupId) ||
							(vcmsStatus.getIsPrimary() != isPrimary)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_P,
							finderArgs, vcmsStatus);
					}
				}

				return vcmsStatus;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_P,
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
				return (VcmsStatus)result;
			}
		}
	}

	/**
	 * Returns all the vcms statuses where companyId = &#63; and isPrimary = &#63;.
	 *
	 * @param companyId the company ID
	 * @param isPrimary the is primary
	 * @return the matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByC_P(long companyId, boolean isPrimary)
		throws SystemException {
		return findByC_P(companyId, isPrimary, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms statuses where companyId = &#63; and isPrimary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param isPrimary the is primary
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @return the range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByC_P(long companyId, boolean isPrimary,
		int start, int end) throws SystemException {
		return findByC_P(companyId, isPrimary, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms statuses where companyId = &#63; and isPrimary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param isPrimary the is primary
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findByC_P(long companyId, boolean isPrimary,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_P;
			finderArgs = new Object[] { companyId, isPrimary };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_P;
			finderArgs = new Object[] {
					companyId, isPrimary,
					
					start, end, orderByComparator
				};
		}

		List<VcmsStatus> list = (List<VcmsStatus>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_C_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_P_ISPRIMARY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(isPrimary);

				list = (List<VcmsStatus>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vcms status in the ordered set where companyId = &#63; and isPrimary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByC_P_First(long companyId, boolean isPrimary,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		List<VcmsStatus> list = findByC_P(companyId, isPrimary, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", isPrimary=");
			msg.append(isPrimary);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms status in the ordered set where companyId = &#63; and isPrimary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a matching vcms status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus findByC_P_Last(long companyId, boolean isPrimary,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		int count = countByC_P(companyId, isPrimary);

		List<VcmsStatus> list = findByC_P(companyId, isPrimary, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", isPrimary=");
			msg.append(isPrimary);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsStatusException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms statuses before and after the current vcms status in the ordered set where companyId = &#63; and isPrimary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param statusId the primary key of the current vcms status
	 * @param companyId the company ID
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms status
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsStatusException if a vcms status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsStatus[] findByC_P_PrevAndNext(long statusId, long companyId,
		boolean isPrimary, OrderByComparator orderByComparator)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			VcmsStatus[] array = new VcmsStatusImpl[3];

			array[0] = getByC_P_PrevAndNext(session, vcmsStatus, companyId,
					isPrimary, orderByComparator, true);

			array[1] = vcmsStatus;

			array[2] = getByC_P_PrevAndNext(session, vcmsStatus, companyId,
					isPrimary, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsStatus getByC_P_PrevAndNext(Session session,
		VcmsStatus vcmsStatus, long companyId, boolean isPrimary,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSSTATUS_WHERE);

		query.append(_FINDER_COLUMN_C_P_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_P_ISPRIMARY_2);

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
			query.append(VcmsStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(isPrimary);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms statuses.
	 *
	 * @return the vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @return the range of vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms statuses
	 * @param end the upper bound of the range of vcms statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsStatus> findAll(int start, int end,
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

		List<VcmsStatus> list = (List<VcmsStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSSTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSSTATUS.concat(VcmsStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsStatus>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vcms statuses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (VcmsStatus vcmsStatus : findByCompanyId(companyId)) {
			remove(vcmsStatus);
		}
	}

	/**
	 * Removes all the vcms statuses where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_G(long companyId, long groupId)
		throws SystemException {
		for (VcmsStatus vcmsStatus : findByC_G(companyId, groupId)) {
			remove(vcmsStatus);
		}
	}

	/**
	 * Removes all the vcms statuses where groupId = &#63; and position = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_P(long groupId, long position)
		throws SystemException {
		for (VcmsStatus vcmsStatus : findByG_P(groupId, position)) {
			remove(vcmsStatus);
		}
	}

	/**
	 * Removes all the vcms statuses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (VcmsStatus vcmsStatus : findByGroupId(groupId)) {
			remove(vcmsStatus);
		}
	}

	/**
	 * Removes the vcms status where companyId = &#63; and groupId = &#63; and active = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_G_A(long companyId, long groupId, boolean active)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = findByC_G_A(companyId, groupId, active);

		remove(vcmsStatus);
	}

	/**
	 * Removes the vcms status where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByA(boolean active)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = findByA(active);

		remove(vcmsStatus);
	}

	/**
	 * Removes all the vcms statuses where companyId = &#63; and active = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_A(long companyId, boolean active)
		throws SystemException {
		for (VcmsStatus vcmsStatus : findByC_A(companyId, active)) {
			remove(vcmsStatus);
		}
	}

	/**
	 * Removes the vcms status where companyId = &#63; and groupId = &#63; and isPrimary = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param isPrimary the is primary
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_G_P(long companyId, long groupId, boolean isPrimary)
		throws NoSuchVcmsStatusException, SystemException {
		VcmsStatus vcmsStatus = findByC_G_P(companyId, groupId, isPrimary);

		remove(vcmsStatus);
	}

	/**
	 * Removes all the vcms statuses where companyId = &#63; and isPrimary = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param isPrimary the is primary
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_P(long companyId, boolean isPrimary)
		throws SystemException {
		for (VcmsStatus vcmsStatus : findByC_P(companyId, isPrimary)) {
			remove(vcmsStatus);
		}
	}

	/**
	 * Removes all the vcms statuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsStatus vcmsStatus : findAll()) {
			remove(vcmsStatus);
		}
	}

	/**
	 * Returns the number of vcms statuses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSSTATUS_WHERE);

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
	 * Returns the number of vcms statuses where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_G(long companyId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms statuses that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByC_G(long companyId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByC_G(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VCMSSTATUS_WHERE);

		query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VcmsStatus.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

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
	 * Returns the number of vcms statuses where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @return the number of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_P(long groupId, long position)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, position };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_POSITION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(position);

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
	 * Returns the number of vcms statuses that the user has permission to view where groupId = &#63; and position = &#63;.
	 *
	 * @param groupId the group ID
	 * @param position the position
	 * @return the number of matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_P(long groupId, long position)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_P(groupId, position);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_VCMSSTATUS_WHERE);

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_POSITION_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VcmsStatus.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(position);

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
	 * Returns the number of vcms statuses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSSTATUS_WHERE);

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
	 * Returns the number of vcms statuses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching vcms statuses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_VCMSSTATUS_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				VcmsStatus.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

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
	 * Returns the number of vcms statuses where companyId = &#63; and groupId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param active the active
	 * @return the number of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_G_A(long companyId, long groupId, boolean active)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, active };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_C_G_A_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_A_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_A_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_A,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms statuses where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByA(boolean active) throws SystemException {
		Object[] finderArgs = new Object[] { active };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_A_ACTIVE_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms statuses where companyId = &#63; and active = &#63;.
	 *
	 * @param companyId the company ID
	 * @param active the active
	 * @return the number of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_A(long companyId, boolean active)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, active };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_C_A_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_A_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_A, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms statuses where companyId = &#63; and groupId = &#63; and isPrimary = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param isPrimary the is primary
	 * @return the number of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_G_P(long companyId, long groupId, boolean isPrimary)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, isPrimary };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_C_G_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_P_ISPRIMARY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(isPrimary);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_P,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms statuses where companyId = &#63; and isPrimary = &#63;.
	 *
	 * @param companyId the company ID
	 * @param isPrimary the is primary
	 * @return the number of matching vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_P(long companyId, boolean isPrimary)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, isPrimary };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_C_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_P_ISPRIMARY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(isPrimary);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_P, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms statuses.
	 *
	 * @return the number of vcms statuses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSSTATUS);

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
	 * Initializes the vcms status persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsStatus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsStatus>> listenersList = new ArrayList<ModelListener<VcmsStatus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsStatus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsStatusImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSSTATUS = "SELECT vcmsStatus FROM VcmsStatus vcmsStatus";
	private static final String _SQL_SELECT_VCMSSTATUS_WHERE = "SELECT vcmsStatus FROM VcmsStatus vcmsStatus WHERE ";
	private static final String _SQL_COUNT_VCMSSTATUS = "SELECT COUNT(vcmsStatus) FROM VcmsStatus vcmsStatus";
	private static final String _SQL_COUNT_VCMSSTATUS_WHERE = "SELECT COUNT(vcmsStatus) FROM VcmsStatus vcmsStatus WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "vcmsStatus.companyId = ?";
	private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "vcmsStatus.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "vcmsStatus.groupId = ?";
	private static final String _FINDER_COLUMN_G_P_GROUPID_2 = "vcmsStatus.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_POSITION_2 = "vcmsStatus.position = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "vcmsStatus.groupId = ?";
	private static final String _FINDER_COLUMN_C_G_A_COMPANYID_2 = "vcmsStatus.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_A_GROUPID_2 = "vcmsStatus.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_A_ACTIVE_2 = "vcmsStatus.active = ?";
	private static final String _FINDER_COLUMN_A_ACTIVE_2 = "vcmsStatus.active = ?";
	private static final String _FINDER_COLUMN_C_A_COMPANYID_2 = "vcmsStatus.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_A_ACTIVE_2 = "vcmsStatus.active = ?";
	private static final String _FINDER_COLUMN_C_G_P_COMPANYID_2 = "vcmsStatus.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_P_GROUPID_2 = "vcmsStatus.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_P_ISPRIMARY_2 = "vcmsStatus.isPrimary = ?";
	private static final String _FINDER_COLUMN_C_P_COMPANYID_2 = "vcmsStatus.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_P_ISPRIMARY_2 = "vcmsStatus.isPrimary = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "vcmsStatus.statusId";
	private static final String _FILTER_SQL_SELECT_VCMSSTATUS_WHERE = "SELECT DISTINCT {vcmsStatus.*} FROM VcmsStatus vcmsStatus WHERE ";
	private static final String _FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {VcmsStatus.*} FROM (SELECT DISTINCT vcmsStatus.statusId FROM VcmsStatus vcmsStatus WHERE ";
	private static final String _FILTER_SQL_SELECT_VCMSSTATUS_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN VcmsStatus ON TEMP_TABLE.statusId = VcmsStatus.statusId";
	private static final String _FILTER_SQL_COUNT_VCMSSTATUS_WHERE = "SELECT COUNT(DISTINCT vcmsStatus.statusId) AS COUNT_VALUE FROM VcmsStatus vcmsStatus WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "vcmsStatus";
	private static final String _FILTER_ENTITY_TABLE = "VcmsStatus";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsStatus.";
	private static final String _ORDER_BY_ENTITY_TABLE = "VcmsStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsStatus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsStatus exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsStatusPersistenceImpl.class);
	private static VcmsStatus _nullVcmsStatus = new VcmsStatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsStatus> toCacheModel() {
				return _nullVcmsStatusCacheModel;
			}
		};

	private static CacheModel<VcmsStatus> _nullVcmsStatusCacheModel = new CacheModel<VcmsStatus>() {
			public VcmsStatus toEntityModel() {
				return _nullVcmsStatus;
			}
		};
}