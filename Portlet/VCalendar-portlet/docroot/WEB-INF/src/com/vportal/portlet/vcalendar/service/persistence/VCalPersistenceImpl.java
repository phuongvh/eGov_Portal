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

package com.vportal.portlet.vcalendar.service.persistence;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.PortletPreferencesPersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.vportal.portlet.vcalendar.NoSuchVCalException;
import com.vportal.portlet.vcalendar.model.VCal;
import com.vportal.portlet.vcalendar.model.impl.VCalImpl;
import com.vportal.portlet.vcalendar.model.impl.VCalModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the v cal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LongLH
 * @see VCalPersistence
 * @see VCalUtil
 * @generated
 */
public class VCalPersistenceImpl extends BasePersistenceImpl<VCal>
	implements VCalPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VCalUtil} to access the v cal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VCalImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_S_G = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByD_S_G",
			new String[] {
				Date.class.getName(), Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S_G = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByD_S_G",
			new String[] {
				Date.class.getName(), Long.class.getName(), Long.class.getName()
			},
			VCalModelImpl.STARTDATE_COLUMN_BITMASK |
			VCalModelImpl.STATUS_COLUMN_BITMASK |
			VCalModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_S_G = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_S_G",
			new String[] {
				Date.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_D_S = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_D_S",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_D_S = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_D_S",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName()
			},
			VCalModelImpl.USERID_COLUMN_BITMASK |
			VCalModelImpl.STARTDATE_COLUMN_BITMASK |
			VCalModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_D_S = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_D_S",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_S = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByD_S",
			new String[] {
				Date.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByD_S",
			new String[] { Date.class.getName(), Long.class.getName() },
			VCalModelImpl.STARTDATE_COLUMN_BITMASK |
			VCalModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_S = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_S",
			new String[] { Date.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_F_D_G_U = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByF_D_G_U",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_D_G_U =
		new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByF_D_G_U",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			VCalModelImpl.USERID_COLUMN_BITMASK |
			VCalModelImpl.STARTDATE_COLUMN_BITMASK |
			VCalModelImpl.GROUPID_COLUMN_BITMASK |
			VCalModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_F_D_G_U = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByF_D_G_U",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_F_D_G_T = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByF_D_G_T",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_D_G_T =
		new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByF_D_G_T",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			VCalModelImpl.FILEID_COLUMN_BITMASK |
			VCalModelImpl.STARTDATE_COLUMN_BITMASK |
			VCalModelImpl.GROUPID_COLUMN_BITMASK |
			VCalModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_F_D_G_T = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByF_D_G_T",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName()
			},
			VCalModelImpl.USERID_COLUMN_BITMASK |
			VCalModelImpl.STARTDATE_COLUMN_BITMASK |
			VCalModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERGROUP =
		new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUP =
		new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserGroup",
			new String[] { Long.class.getName() },
			VCalModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERGROUP = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserGroup",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEID = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFileId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEID =
		new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFileId",
			new String[] { Long.class.getName() },
			VCalModelImpl.FILEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILEID = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, VCalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the v cal in the entity cache if it is enabled.
	 *
	 * @param vCal the v cal
	 */
	public void cacheResult(VCal vCal) {
		EntityCacheUtil.putResult(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalImpl.class, vCal.getPrimaryKey(), vCal);

		vCal.resetOriginalValues();
	}

	/**
	 * Caches the v cals in the entity cache if it is enabled.
	 *
	 * @param vCals the v cals
	 */
	public void cacheResult(List<VCal> vCals) {
		for (VCal vCal : vCals) {
			if (EntityCacheUtil.getResult(VCalModelImpl.ENTITY_CACHE_ENABLED,
						VCalImpl.class, vCal.getPrimaryKey()) == null) {
				cacheResult(vCal);
			}
			else {
				vCal.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v cals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VCalImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VCalImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v cal.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VCal vCal) {
		EntityCacheUtil.removeResult(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalImpl.class, vCal.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VCal> vCals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VCal vCal : vCals) {
			EntityCacheUtil.removeResult(VCalModelImpl.ENTITY_CACHE_ENABLED,
				VCalImpl.class, vCal.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v cal with the primary key. Does not add the v cal to the database.
	 *
	 * @param calId the primary key for the new v cal
	 * @return the new v cal
	 */
	public VCal create(long calId) {
		VCal vCal = new VCalImpl();

		vCal.setNew(true);
		vCal.setPrimaryKey(calId);

		return vCal;
	}

	/**
	 * Removes the v cal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param calId the primary key of the v cal
	 * @return the v cal that was removed
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal remove(long calId) throws NoSuchVCalException, SystemException {
		return remove(Long.valueOf(calId));
	}

	/**
	 * Removes the v cal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v cal
	 * @return the v cal that was removed
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VCal remove(Serializable primaryKey)
		throws NoSuchVCalException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VCal vCal = (VCal)session.get(VCalImpl.class, primaryKey);

			if (vCal == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVCalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vCal);
		}
		catch (NoSuchVCalException nsee) {
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
	protected VCal removeImpl(VCal vCal) throws SystemException {
		vCal = toUnwrappedModel(vCal);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vCal);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vCal);

		return vCal;
	}

	@Override
	public VCal updateImpl(com.vportal.portlet.vcalendar.model.VCal vCal,
		boolean merge) throws SystemException {
		vCal = toUnwrappedModel(vCal);

		boolean isNew = vCal.isNew();

		VCalModelImpl vCalModelImpl = (VCalModelImpl)vCal;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vCal, merge);

			vCal.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VCalModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vCalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vCalModelImpl.getOriginalStartDate(),
						Long.valueOf(vCalModelImpl.getOriginalStatus()),
						Long.valueOf(vCalModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_S_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S_G,
					args);

				args = new Object[] {
						vCalModelImpl.getStartDate(),
						Long.valueOf(vCalModelImpl.getStatus()),
						Long.valueOf(vCalModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_S_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S_G,
					args);
			}

			if ((vCalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_D_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vCalModelImpl.getOriginalUserId()),
						
						vCalModelImpl.getOriginalStartDate(),
						Long.valueOf(vCalModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_D_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_D_S,
					args);

				args = new Object[] {
						Long.valueOf(vCalModelImpl.getUserId()),
						
						vCalModelImpl.getStartDate(),
						Long.valueOf(vCalModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_D_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_D_S,
					args);
			}

			if ((vCalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vCalModelImpl.getOriginalStartDate(),
						Long.valueOf(vCalModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S,
					args);

				args = new Object[] {
						vCalModelImpl.getStartDate(),
						Long.valueOf(vCalModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S,
					args);
			}

			if ((vCalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_D_G_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vCalModelImpl.getOriginalUserId()),
						
						vCalModelImpl.getOriginalStartDate(),
						Long.valueOf(vCalModelImpl.getOriginalGroupId()),
						Long.valueOf(vCalModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_F_D_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_D_G_U,
					args);

				args = new Object[] {
						Long.valueOf(vCalModelImpl.getUserId()),
						
						vCalModelImpl.getStartDate(),
						Long.valueOf(vCalModelImpl.getGroupId()),
						Long.valueOf(vCalModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_F_D_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_D_G_U,
					args);
			}

			if ((vCalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_D_G_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vCalModelImpl.getOriginalFileId()),
						
						vCalModelImpl.getOriginalStartDate(),
						Long.valueOf(vCalModelImpl.getOriginalGroupId()),
						Long.valueOf(vCalModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_F_D_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_D_G_T,
					args);

				args = new Object[] {
						Long.valueOf(vCalModelImpl.getFileId()),
						
						vCalModelImpl.getStartDate(),
						Long.valueOf(vCalModelImpl.getGroupId()),
						Long.valueOf(vCalModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_F_D_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_D_G_T,
					args);
			}

			if ((vCalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vCalModelImpl.getOriginalUserId()),
						
						vCalModelImpl.getOriginalStartDate(),
						Long.valueOf(vCalModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] {
						Long.valueOf(vCalModelImpl.getUserId()),
						
						vCalModelImpl.getStartDate(),
						Long.valueOf(vCalModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((vCalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vCalModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUP,
					args);

				args = new Object[] { Long.valueOf(vCalModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUP,
					args);
			}

			if ((vCalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vCalModelImpl.getOriginalFileId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEID,
					args);

				args = new Object[] { Long.valueOf(vCalModelImpl.getFileId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEID,
					args);
			}
		}

		EntityCacheUtil.putResult(VCalModelImpl.ENTITY_CACHE_ENABLED,
			VCalImpl.class, vCal.getPrimaryKey(), vCal);

		return vCal;
	}

	protected VCal toUnwrappedModel(VCal vCal) {
		if (vCal instanceof VCalImpl) {
			return vCal;
		}

		VCalImpl vCalImpl = new VCalImpl();

		vCalImpl.setNew(vCal.isNew());
		vCalImpl.setPrimaryKey(vCal.getPrimaryKey());

		vCalImpl.setCalId(vCal.getCalId());
		vCalImpl.setGroupId(vCal.getGroupId());
		vCalImpl.setCompanyId(vCal.getCompanyId());
		vCalImpl.setUserId(vCal.getUserId());
		vCalImpl.setUserName(vCal.getUserName());
		vCalImpl.setCreateDate(vCal.getCreateDate());
		vCalImpl.setModifiedDate(vCal.getModifiedDate());
		vCalImpl.setLanguageId(vCal.getLanguageId());
		vCalImpl.setFileId(vCal.getFileId());
		vCalImpl.setTitle(vCal.getTitle());
		vCalImpl.setDescription(vCal.getDescription());
		vCalImpl.setGuest(vCal.getGuest());
		vCalImpl.setLocation(vCal.getLocation());
		vCalImpl.setTime(vCal.getTime());
		vCalImpl.setStartDate(vCal.getStartDate());
		vCalImpl.setEndDate(vCal.getEndDate());
		vCalImpl.setStatus(vCal.getStatus());

		return vCalImpl;
	}

	/**
	 * Returns the v cal with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v cal
	 * @return the v cal
	 * @throws com.liferay.portal.NoSuchModelException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VCal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the v cal with the primary key or throws a {@link com.vportal.portlet.vcalendar.NoSuchVCalException} if it could not be found.
	 *
	 * @param calId the primary key of the v cal
	 * @return the v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByPrimaryKey(long calId)
		throws NoSuchVCalException, SystemException {
		VCal vCal = fetchByPrimaryKey(calId);

		if (vCal == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + calId);
			}

			throw new NoSuchVCalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				calId);
		}

		return vCal;
	}

	/**
	 * Returns the v cal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v cal
	 * @return the v cal, or <code>null</code> if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VCal fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the v cal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param calId the primary key of the v cal
	 * @return the v cal, or <code>null</code> if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal fetchByPrimaryKey(long calId) throws SystemException {
		VCal vCal = (VCal)EntityCacheUtil.getResult(VCalModelImpl.ENTITY_CACHE_ENABLED,
				VCalImpl.class, calId);

		if (vCal == _nullVCal) {
			return null;
		}

		if (vCal == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vCal = (VCal)session.get(VCalImpl.class, Long.valueOf(calId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vCal != null) {
					cacheResult(vCal);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VCalModelImpl.ENTITY_CACHE_ENABLED,
						VCalImpl.class, calId, _nullVCal);
				}

				closeSession(session);
			}
		}

		return vCal;
	}

	/**
	 * Returns all the v cals where startDate = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByD_S_G(Date startDate, long status, long groupId)
		throws SystemException {
		return findByD_S_G(startDate, status, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v cals where startDate = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @return the range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByD_S_G(Date startDate, long status, long groupId,
		int start, int end) throws SystemException {
		return findByD_S_G(startDate, status, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v cals where startDate = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByD_S_G(Date startDate, long status, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S_G;
			finderArgs = new Object[] { startDate, status, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_S_G;
			finderArgs = new Object[] {
					startDate, status, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VCal> list = (List<VCal>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCAL_WHERE);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_D_S_G_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_D_S_G_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_D_S_G_STATUS_2);

			query.append(_FINDER_COLUMN_D_S_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VCalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(status);

				qPos.add(groupId);

				list = (List<VCal>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first v cal in the ordered set where startDate = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByD_S_G_First(Date startDate, long status, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		List<VCal> list = findByD_S_G(startDate, status, groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("startDate=");
			msg.append(startDate);

			msg.append(", status=");
			msg.append(status);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last v cal in the ordered set where startDate = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByD_S_G_Last(Date startDate, long status, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		int count = countByD_S_G(startDate, status, groupId);

		List<VCal> list = findByD_S_G(startDate, status, groupId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("startDate=");
			msg.append(startDate);

			msg.append(", status=");
			msg.append(status);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the v cals before and after the current v cal in the ordered set where startDate = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param calId the primary key of the current v cal
	 * @param startDate the start date
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal[] findByD_S_G_PrevAndNext(long calId, Date startDate,
		long status, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		VCal vCal = findByPrimaryKey(calId);

		Session session = null;

		try {
			session = openSession();

			VCal[] array = new VCalImpl[3];

			array[0] = getByD_S_G_PrevAndNext(session, vCal, startDate, status,
					groupId, orderByComparator, true);

			array[1] = vCal;

			array[2] = getByD_S_G_PrevAndNext(session, vCal, startDate, status,
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

	protected VCal getByD_S_G_PrevAndNext(Session session, VCal vCal,
		Date startDate, long status, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCAL_WHERE);

		if (startDate == null) {
			query.append(_FINDER_COLUMN_D_S_G_STARTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_D_S_G_STARTDATE_2);
		}

		query.append(_FINDER_COLUMN_D_S_G_STATUS_2);

		query.append(_FINDER_COLUMN_D_S_G_GROUPID_2);

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
			query.append(VCalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (startDate != null) {
			qPos.add(CalendarUtil.getTimestamp(startDate));
		}

		qPos.add(status);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vCal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VCal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v cals where userId = &#63; and startDate = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param status the status
	 * @return the matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByU_D_S(long userId, Date startDate, long status)
		throws SystemException {
		return findByU_D_S(userId, startDate, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v cals where userId = &#63; and startDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param status the status
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @return the range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByU_D_S(long userId, Date startDate, long status,
		int start, int end) throws SystemException {
		return findByU_D_S(userId, startDate, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v cals where userId = &#63; and startDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param status the status
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByU_D_S(long userId, Date startDate, long status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_D_S;
			finderArgs = new Object[] { userId, startDate, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_D_S;
			finderArgs = new Object[] {
					userId, startDate, status,
					
					start, end, orderByComparator
				};
		}

		List<VCal> list = (List<VCal>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_U_D_S_USERID_2);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_U_D_S_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_U_D_S_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_U_D_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VCalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(status);

				list = (List<VCal>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first v cal in the ordered set where userId = &#63; and startDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByU_D_S_First(long userId, Date startDate, long status,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		List<VCal> list = findByU_D_S(userId, startDate, status, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", startDate=");
			msg.append(startDate);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last v cal in the ordered set where userId = &#63; and startDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByU_D_S_Last(long userId, Date startDate, long status,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		int count = countByU_D_S(userId, startDate, status);

		List<VCal> list = findByU_D_S(userId, startDate, status, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", startDate=");
			msg.append(startDate);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the v cals before and after the current v cal in the ordered set where userId = &#63; and startDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param calId the primary key of the current v cal
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal[] findByU_D_S_PrevAndNext(long calId, long userId,
		Date startDate, long status, OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		VCal vCal = findByPrimaryKey(calId);

		Session session = null;

		try {
			session = openSession();

			VCal[] array = new VCalImpl[3];

			array[0] = getByU_D_S_PrevAndNext(session, vCal, userId, startDate,
					status, orderByComparator, true);

			array[1] = vCal;

			array[2] = getByU_D_S_PrevAndNext(session, vCal, userId, startDate,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VCal getByU_D_S_PrevAndNext(Session session, VCal vCal,
		long userId, Date startDate, long status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCAL_WHERE);

		query.append(_FINDER_COLUMN_U_D_S_USERID_2);

		if (startDate == null) {
			query.append(_FINDER_COLUMN_U_D_S_STARTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_U_D_S_STARTDATE_2);
		}

		query.append(_FINDER_COLUMN_U_D_S_STATUS_2);

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
			query.append(VCalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (startDate != null) {
			qPos.add(CalendarUtil.getTimestamp(startDate));
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vCal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VCal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v cals where startDate = &#63; and status = &#63;.
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @return the matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByD_S(Date startDate, long status)
		throws SystemException {
		return findByD_S(startDate, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v cals where startDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @return the range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByD_S(Date startDate, long status, int start, int end)
		throws SystemException {
		return findByD_S(startDate, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v cals where startDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByD_S(Date startDate, long status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_S;
			finderArgs = new Object[] { startDate, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_S;
			finderArgs = new Object[] {
					startDate, status,
					
					start, end, orderByComparator
				};
		}

		List<VCal> list = (List<VCal>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCAL_WHERE);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_D_S_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_D_S_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_D_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VCalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(status);

				list = (List<VCal>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first v cal in the ordered set where startDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByD_S_First(Date startDate, long status,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		List<VCal> list = findByD_S(startDate, status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("startDate=");
			msg.append(startDate);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last v cal in the ordered set where startDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByD_S_Last(Date startDate, long status,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		int count = countByD_S(startDate, status);

		List<VCal> list = findByD_S(startDate, status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("startDate=");
			msg.append(startDate);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the v cals before and after the current v cal in the ordered set where startDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param calId the primary key of the current v cal
	 * @param startDate the start date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal[] findByD_S_PrevAndNext(long calId, Date startDate,
		long status, OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		VCal vCal = findByPrimaryKey(calId);

		Session session = null;

		try {
			session = openSession();

			VCal[] array = new VCalImpl[3];

			array[0] = getByD_S_PrevAndNext(session, vCal, startDate, status,
					orderByComparator, true);

			array[1] = vCal;

			array[2] = getByD_S_PrevAndNext(session, vCal, startDate, status,
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

	protected VCal getByD_S_PrevAndNext(Session session, VCal vCal,
		Date startDate, long status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCAL_WHERE);

		if (startDate == null) {
			query.append(_FINDER_COLUMN_D_S_STARTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_D_S_STARTDATE_2);
		}

		query.append(_FINDER_COLUMN_D_S_STATUS_2);

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
			query.append(VCalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (startDate != null) {
			qPos.add(CalendarUtil.getTimestamp(startDate));
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vCal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VCal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByF_D_G_U(long userId, Date startDate, long groupId,
		long status) throws SystemException {
		return findByF_D_G_U(userId, startDate, groupId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @return the range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByF_D_G_U(long userId, Date startDate, long groupId,
		long status, int start, int end) throws SystemException {
		return findByF_D_G_U(userId, startDate, groupId, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByF_D_G_U(long userId, Date startDate, long groupId,
		long status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_D_G_U;
			finderArgs = new Object[] { userId, startDate, groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_F_D_G_U;
			finderArgs = new Object[] {
					userId, startDate, groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<VCal> list = (List<VCal>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_F_D_G_U_USERID_2);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_F_D_G_U_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_F_D_G_U_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_F_D_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_F_D_G_U_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VCalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(groupId);

				qPos.add(status);

				list = (List<VCal>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByF_D_G_U_First(long userId, Date startDate, long groupId,
		long status, OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		List<VCal> list = findByF_D_G_U(userId, startDate, groupId, status, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", startDate=");
			msg.append(startDate);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByF_D_G_U_Last(long userId, Date startDate, long groupId,
		long status, OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		int count = countByF_D_G_U(userId, startDate, groupId, status);

		List<VCal> list = findByF_D_G_U(userId, startDate, groupId, status,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", startDate=");
			msg.append(startDate);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the v cals before and after the current v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param calId the primary key of the current v cal
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal[] findByF_D_G_U_PrevAndNext(long calId, long userId,
		Date startDate, long groupId, long status,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		VCal vCal = findByPrimaryKey(calId);

		Session session = null;

		try {
			session = openSession();

			VCal[] array = new VCalImpl[3];

			array[0] = getByF_D_G_U_PrevAndNext(session, vCal, userId,
					startDate, groupId, status, orderByComparator, true);

			array[1] = vCal;

			array[2] = getByF_D_G_U_PrevAndNext(session, vCal, userId,
					startDate, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VCal getByF_D_G_U_PrevAndNext(Session session, VCal vCal,
		long userId, Date startDate, long groupId, long status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCAL_WHERE);

		query.append(_FINDER_COLUMN_F_D_G_U_USERID_2);

		if (startDate == null) {
			query.append(_FINDER_COLUMN_F_D_G_U_STARTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_F_D_G_U_STARTDATE_2);
		}

		query.append(_FINDER_COLUMN_F_D_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_F_D_G_U_STATUS_2);

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
			query.append(VCalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (startDate != null) {
			qPos.add(CalendarUtil.getTimestamp(startDate));
		}

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vCal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VCal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v cals where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param fileId the file ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByF_D_G_T(long fileId, Date startDate, long groupId,
		long status) throws SystemException {
		return findByF_D_G_T(fileId, startDate, groupId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v cals where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileId the file ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @return the range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByF_D_G_T(long fileId, Date startDate, long groupId,
		long status, int start, int end) throws SystemException {
		return findByF_D_G_T(fileId, startDate, groupId, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the v cals where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileId the file ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByF_D_G_T(long fileId, Date startDate, long groupId,
		long status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_F_D_G_T;
			finderArgs = new Object[] { fileId, startDate, groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_F_D_G_T;
			finderArgs = new Object[] {
					fileId, startDate, groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<VCal> list = (List<VCal>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_F_D_G_T_FILEID_2);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_F_D_G_T_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_F_D_G_T_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_F_D_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_F_D_G_T_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VCalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileId);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(groupId);

				qPos.add(status);

				list = (List<VCal>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first v cal in the ordered set where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileId the file ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByF_D_G_T_First(long fileId, Date startDate, long groupId,
		long status, OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		List<VCal> list = findByF_D_G_T(fileId, startDate, groupId, status, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fileId=");
			msg.append(fileId);

			msg.append(", startDate=");
			msg.append(startDate);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last v cal in the ordered set where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileId the file ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByF_D_G_T_Last(long fileId, Date startDate, long groupId,
		long status, OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		int count = countByF_D_G_T(fileId, startDate, groupId, status);

		List<VCal> list = findByF_D_G_T(fileId, startDate, groupId, status,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fileId=");
			msg.append(fileId);

			msg.append(", startDate=");
			msg.append(startDate);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the v cals before and after the current v cal in the ordered set where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param calId the primary key of the current v cal
	 * @param fileId the file ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal[] findByF_D_G_T_PrevAndNext(long calId, long fileId,
		Date startDate, long groupId, long status,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		VCal vCal = findByPrimaryKey(calId);

		Session session = null;

		try {
			session = openSession();

			VCal[] array = new VCalImpl[3];

			array[0] = getByF_D_G_T_PrevAndNext(session, vCal, fileId,
					startDate, groupId, status, orderByComparator, true);

			array[1] = vCal;

			array[2] = getByF_D_G_T_PrevAndNext(session, vCal, fileId,
					startDate, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VCal getByF_D_G_T_PrevAndNext(Session session, VCal vCal,
		long fileId, Date startDate, long groupId, long status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCAL_WHERE);

		query.append(_FINDER_COLUMN_F_D_G_T_FILEID_2);

		if (startDate == null) {
			query.append(_FINDER_COLUMN_F_D_G_T_STARTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_F_D_G_T_STARTDATE_2);
		}

		query.append(_FINDER_COLUMN_F_D_G_T_GROUPID_2);

		query.append(_FINDER_COLUMN_F_D_G_T_STATUS_2);

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
			query.append(VCalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fileId);

		if (startDate != null) {
			qPos.add(CalendarUtil.getTimestamp(startDate));
		}

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vCal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VCal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @return the matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByUser(long userId, Date startDate, long groupId)
		throws SystemException {
		return findByUser(userId, startDate, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @return the range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByUser(long userId, Date startDate, long groupId,
		int start, int end) throws SystemException {
		return findByUser(userId, startDate, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByUser(long userId, Date startDate, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, startDate, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] {
					userId, startDate, groupId,
					
					start, end, orderByComparator
				};
		}

		List<VCal> list = (List<VCal>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_USER_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_USER_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_USER_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VCalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(groupId);

				list = (List<VCal>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByUser_First(long userId, Date startDate, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		List<VCal> list = findByUser(userId, startDate, groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", startDate=");
			msg.append(startDate);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByUser_Last(long userId, Date startDate, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		int count = countByUser(userId, startDate, groupId);

		List<VCal> list = findByUser(userId, startDate, groupId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", startDate=");
			msg.append(startDate);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the v cals before and after the current v cal in the ordered set where userId = &#63; and startDate = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param calId the primary key of the current v cal
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal[] findByUser_PrevAndNext(long calId, long userId,
		Date startDate, long groupId, OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		VCal vCal = findByPrimaryKey(calId);

		Session session = null;

		try {
			session = openSession();

			VCal[] array = new VCalImpl[3];

			array[0] = getByUser_PrevAndNext(session, vCal, userId, startDate,
					groupId, orderByComparator, true);

			array[1] = vCal;

			array[2] = getByUser_PrevAndNext(session, vCal, userId, startDate,
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

	protected VCal getByUser_PrevAndNext(Session session, VCal vCal,
		long userId, Date startDate, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCAL_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

		if (startDate == null) {
			query.append(_FINDER_COLUMN_USER_STARTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_USER_STARTDATE_2);
		}

		query.append(_FINDER_COLUMN_USER_GROUPID_2);

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
			query.append(VCalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (startDate != null) {
			qPos.add(CalendarUtil.getTimestamp(startDate));
		}

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vCal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VCal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v cals where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByUserGroup(long groupId) throws SystemException {
		return findByUserGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the v cals where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @return the range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByUserGroup(long groupId, int start, int end)
		throws SystemException {
		return findByUserGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v cals where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByUserGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERGROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<VCal> list = (List<VCal>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_USERGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VCalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<VCal>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first v cal in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByUserGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		List<VCal> list = findByUserGroup(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last v cal in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByUserGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		int count = countByUserGroup(groupId);

		List<VCal> list = findByUserGroup(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the v cals before and after the current v cal in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param calId the primary key of the current v cal
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal[] findByUserGroup_PrevAndNext(long calId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		VCal vCal = findByPrimaryKey(calId);

		Session session = null;

		try {
			session = openSession();

			VCal[] array = new VCalImpl[3];

			array[0] = getByUserGroup_PrevAndNext(session, vCal, groupId,
					orderByComparator, true);

			array[1] = vCal;

			array[2] = getByUserGroup_PrevAndNext(session, vCal, groupId,
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

	protected VCal getByUserGroup_PrevAndNext(Session session, VCal vCal,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCAL_WHERE);

		query.append(_FINDER_COLUMN_USERGROUP_GROUPID_2);

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
			query.append(VCalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vCal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VCal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v cals where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @return the matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByFileId(long fileId) throws SystemException {
		return findByFileId(fileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v cals where fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileId the file ID
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @return the range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByFileId(long fileId, int start, int end)
		throws SystemException {
		return findByFileId(fileId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v cals where fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileId the file ID
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findByFileId(long fileId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEID;
			finderArgs = new Object[] { fileId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEID;
			finderArgs = new Object[] { fileId, start, end, orderByComparator };
		}

		List<VCal> list = (List<VCal>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_FILEID_FILEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VCalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileId);

				list = (List<VCal>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first v cal in the ordered set where fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByFileId_First(long fileId,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		List<VCal> list = findByFileId(fileId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fileId=");
			msg.append(fileId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last v cal in the ordered set where fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a matching v cal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal findByFileId_Last(long fileId,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		int count = countByFileId(fileId);

		List<VCal> list = findByFileId(fileId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fileId=");
			msg.append(fileId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVCalException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the v cals before and after the current v cal in the ordered set where fileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param calId the primary key of the current v cal
	 * @param fileId the file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v cal
	 * @throws com.vportal.portlet.vcalendar.NoSuchVCalException if a v cal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VCal[] findByFileId_PrevAndNext(long calId, long fileId,
		OrderByComparator orderByComparator)
		throws NoSuchVCalException, SystemException {
		VCal vCal = findByPrimaryKey(calId);

		Session session = null;

		try {
			session = openSession();

			VCal[] array = new VCalImpl[3];

			array[0] = getByFileId_PrevAndNext(session, vCal, fileId,
					orderByComparator, true);

			array[1] = vCal;

			array[2] = getByFileId_PrevAndNext(session, vCal, fileId,
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

	protected VCal getByFileId_PrevAndNext(Session session, VCal vCal,
		long fileId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCAL_WHERE);

		query.append(_FINDER_COLUMN_FILEID_FILEID_2);

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
			query.append(VCalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fileId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vCal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VCal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v cals.
	 *
	 * @return the v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v cals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @return the range of v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v cals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v cals
	 * @param end the upper bound of the range of v cals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v cals
	 * @throws SystemException if a system exception occurred
	 */
	public List<VCal> findAll(int start, int end,
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

		List<VCal> list = (List<VCal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCAL.concat(VCalModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VCal>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VCal>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the v cals where startDate = &#63; and status = &#63; and groupId = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByD_S_G(Date startDate, long status, long groupId)
		throws SystemException {
		for (VCal vCal : findByD_S_G(startDate, status, groupId)) {
			remove(vCal);
		}
	}

	/**
	 * Removes all the v cals where userId = &#63; and startDate = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByU_D_S(long userId, Date startDate, long status)
		throws SystemException {
		for (VCal vCal : findByU_D_S(userId, startDate, status)) {
			remove(vCal);
		}
	}

	/**
	 * Removes all the v cals where startDate = &#63; and status = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByD_S(Date startDate, long status)
		throws SystemException {
		for (VCal vCal : findByD_S(startDate, status)) {
			remove(vCal);
		}
	}

	/**
	 * Removes all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByF_D_G_U(long userId, Date startDate, long groupId,
		long status) throws SystemException {
		for (VCal vCal : findByF_D_G_U(userId, startDate, groupId, status)) {
			remove(vCal);
		}
	}

	/**
	 * Removes all the v cals where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByF_D_G_T(long fileId, Date startDate, long groupId,
		long status) throws SystemException {
		for (VCal vCal : findByF_D_G_T(fileId, startDate, groupId, status)) {
			remove(vCal);
		}
	}

	/**
	 * Removes all the v cals where userId = &#63; and startDate = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUser(long userId, Date startDate, long groupId)
		throws SystemException {
		for (VCal vCal : findByUser(userId, startDate, groupId)) {
			remove(vCal);
		}
	}

	/**
	 * Removes all the v cals where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserGroup(long groupId) throws SystemException {
		for (VCal vCal : findByUserGroup(groupId)) {
			remove(vCal);
		}
	}

	/**
	 * Removes all the v cals where fileId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByFileId(long fileId) throws SystemException {
		for (VCal vCal : findByFileId(fileId)) {
			remove(vCal);
		}
	}

	/**
	 * Removes all the v cals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VCal vCal : findAll()) {
			remove(vCal);
		}
	}

	/**
	 * Returns the number of v cals where startDate = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public int countByD_S_G(Date startDate, long status, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { startDate, status, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_D_S_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VCAL_WHERE);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_D_S_G_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_D_S_G_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_D_S_G_STATUS_2);

			query.append(_FINDER_COLUMN_D_S_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(status);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_D_S_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v cals where userId = &#63; and startDate = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param status the status
	 * @return the number of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_D_S(long userId, Date startDate, long status)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, startDate, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_D_S,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_U_D_S_USERID_2);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_U_D_S_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_U_D_S_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_U_D_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_D_S,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v cals where startDate = &#63; and status = &#63;.
	 *
	 * @param startDate the start date
	 * @param status the status
	 * @return the number of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public int countByD_S(Date startDate, long status)
		throws SystemException {
		Object[] finderArgs = new Object[] { startDate, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_D_S,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCAL_WHERE);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_D_S_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_D_S_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_D_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_D_S, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v cals where userId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public int countByF_D_G_U(long userId, Date startDate, long groupId,
		long status) throws SystemException {
		Object[] finderArgs = new Object[] { userId, startDate, groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_F_D_G_U,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_F_D_G_U_USERID_2);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_F_D_G_U_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_F_D_G_U_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_F_D_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_F_D_G_U_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(groupId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_F_D_G_U,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v cals where fileId = &#63; and startDate = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param fileId the file ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public int countByF_D_G_T(long fileId, Date startDate, long groupId,
		long status) throws SystemException {
		Object[] finderArgs = new Object[] { fileId, startDate, groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_F_D_G_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_F_D_G_T_FILEID_2);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_F_D_G_T_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_F_D_G_T_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_F_D_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_F_D_G_T_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileId);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				qPos.add(groupId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_F_D_G_T,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v cals where userId = &#63; and startDate = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param groupId the group ID
	 * @return the number of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUser(long userId, Date startDate, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, startDate, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (startDate == null) {
				query.append(_FINDER_COLUMN_USER_STARTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_USER_STARTDATE_2);
			}

			query.append(_FINDER_COLUMN_USER_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (startDate != null) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v cals where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserGroup(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_USERGROUP_GROUPID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v cals where fileId = &#63;.
	 *
	 * @param fileId the file ID
	 * @return the number of matching v cals
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFileId(long fileId) throws SystemException {
		Object[] finderArgs = new Object[] { fileId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCAL_WHERE);

			query.append(_FINDER_COLUMN_FILEID_FILEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v cals.
	 *
	 * @return the number of v cals
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCAL);

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
	 * Initializes the v cal persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcalendar.model.VCal")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VCal>> listenersList = new ArrayList<ModelListener<VCal>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VCal>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VCalImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = VCalPersistence.class)
	protected VCalPersistence vCalPersistence;
	@BeanReference(type = VFilePersistence.class)
	protected VFilePersistence vFilePersistence;
	@BeanReference(type = CompanyPersistence.class)
	protected CompanyPersistence companyPersistence;
	@BeanReference(type = PortletPreferencesPersistence.class)
	protected PortletPreferencesPersistence portletPreferencesPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_VCAL = "SELECT vCal FROM VCal vCal";
	private static final String _SQL_SELECT_VCAL_WHERE = "SELECT vCal FROM VCal vCal WHERE ";
	private static final String _SQL_COUNT_VCAL = "SELECT COUNT(vCal) FROM VCal vCal";
	private static final String _SQL_COUNT_VCAL_WHERE = "SELECT COUNT(vCal) FROM VCal vCal WHERE ";
	private static final String _FINDER_COLUMN_D_S_G_STARTDATE_1 = "vCal.startDate IS NULL AND ";
	private static final String _FINDER_COLUMN_D_S_G_STARTDATE_2 = "vCal.startDate = ? AND ";
	private static final String _FINDER_COLUMN_D_S_G_STATUS_2 = "vCal.status = ? AND ";
	private static final String _FINDER_COLUMN_D_S_G_GROUPID_2 = "vCal.groupId = ?";
	private static final String _FINDER_COLUMN_U_D_S_USERID_2 = "vCal.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_D_S_STARTDATE_1 = "vCal.startDate IS NULL AND ";
	private static final String _FINDER_COLUMN_U_D_S_STARTDATE_2 = "vCal.startDate = ? AND ";
	private static final String _FINDER_COLUMN_U_D_S_STATUS_2 = "vCal.status = ?";
	private static final String _FINDER_COLUMN_D_S_STARTDATE_1 = "vCal.startDate IS NULL AND ";
	private static final String _FINDER_COLUMN_D_S_STARTDATE_2 = "vCal.startDate = ? AND ";
	private static final String _FINDER_COLUMN_D_S_STATUS_2 = "vCal.status = ?";
	private static final String _FINDER_COLUMN_F_D_G_U_USERID_2 = "vCal.userId = ? AND ";
	private static final String _FINDER_COLUMN_F_D_G_U_STARTDATE_1 = "vCal.startDate IS NULL AND ";
	private static final String _FINDER_COLUMN_F_D_G_U_STARTDATE_2 = "vCal.startDate = ? AND ";
	private static final String _FINDER_COLUMN_F_D_G_U_GROUPID_2 = "vCal.groupId = ? AND ";
	private static final String _FINDER_COLUMN_F_D_G_U_STATUS_2 = "vCal.status = ?";
	private static final String _FINDER_COLUMN_F_D_G_T_FILEID_2 = "vCal.fileId = ? AND ";
	private static final String _FINDER_COLUMN_F_D_G_T_STARTDATE_1 = "vCal.startDate IS NULL AND ";
	private static final String _FINDER_COLUMN_F_D_G_T_STARTDATE_2 = "vCal.startDate = ? AND ";
	private static final String _FINDER_COLUMN_F_D_G_T_GROUPID_2 = "vCal.groupId = ? AND ";
	private static final String _FINDER_COLUMN_F_D_G_T_STATUS_2 = "vCal.status = ?";
	private static final String _FINDER_COLUMN_USER_USERID_2 = "vCal.userId = ? AND ";
	private static final String _FINDER_COLUMN_USER_STARTDATE_1 = "vCal.startDate IS NULL AND ";
	private static final String _FINDER_COLUMN_USER_STARTDATE_2 = "vCal.startDate = ? AND ";
	private static final String _FINDER_COLUMN_USER_GROUPID_2 = "vCal.groupId = ?";
	private static final String _FINDER_COLUMN_USERGROUP_GROUPID_2 = "vCal.groupId = ?";
	private static final String _FINDER_COLUMN_FILEID_FILEID_2 = "vCal.fileId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vCal.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VCal exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VCal exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VCalPersistenceImpl.class);
	private static VCal _nullVCal = new VCalImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VCal> toCacheModel() {
				return _nullVCalCacheModel;
			}
		};

	private static CacheModel<VCal> _nullVCalCacheModel = new CacheModel<VCal>() {
			public VCal toEntityModel() {
				return _nullVCal;
			}
		};
}